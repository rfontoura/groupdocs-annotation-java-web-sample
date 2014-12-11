package com.groupdocs.annotation.samples.data.dao;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.DaoFactory;
import com.groupdocs.annotation.data.dao.interfaces.IAnnotationDao;
import com.groupdocs.annotation.data.dao.interfaces.IDocumentDao;
import com.groupdocs.annotation.data.dao.interfaces.ISessionDao;
import com.groupdocs.annotation.data.environment.IEnvironmentCreator;
import com.groupdocs.annotation.data.tables.interfaces.IAnnotation;
import com.groupdocs.annotation.data.tables.interfaces.IDocument;
import com.groupdocs.annotation.data.tables.interfaces.ISession;

import java.io.*;
import java.util.*;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlAnnotationDaoImpl extends CustomAbstractDaoImpl<IAnnotation> implements IAnnotationDao {
    public static final String ANNOTATION_FILE_NAME = "annotation.xml";

    public CustomXmlAnnotationDaoImpl(IEnvironmentCreator environmentCreator) {
        super(environmentCreator);
    }

    @Override
    protected void saveData(List<IAnnotation> data) {
        try (DaoFactory daoFactory = DaoFactory.create()) {
            ISessionDao sessionDao = daoFactory.getSessionDao();
            IDocumentDao documentDao = daoFactory.getDocumentDao();
            String tempPath = Utils.getTempPath();

            Map<String, List<IAnnotation>> fileGuid2list = new HashMap<String, List<IAnnotation>>();
            for (IAnnotation annotation : data) {
                ISession session = sessionDao.selectBy(Arrays.asList(ISession.ID), annotation.getAnnotationSessionId());
                IDocument document = documentDao.selectBy(Arrays.asList(IDocument.ID), session.getDocumentId());
                String documentGuid = document.getDocumentName();
                if (!fileGuid2list.containsKey(documentGuid)) {
                    fileGuid2list.put(documentGuid, new ArrayList<IAnnotation>());
                }
                fileGuid2list.get(documentGuid).add(annotation);
            }

            for (Map.Entry<String, List<IAnnotation>> entry : fileGuid2list.entrySet()) {
                String fileGuid = entry.getKey();
                List<IAnnotation> annotations = entry.getValue();
                File file = new File(tempPath + File.separator + fileGuid + File.separator + ANNOTATION_FILE_NAME);
                if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        saveObjectAsXml(annotations, fileOutputStream);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        Utils.closeStreams(fileOutputStream);
                    }
                }
            }
        } catch (Exception e) {
            Utils.log(this.getClass(), e);
        }
    }

    @Override
    protected List<IAnnotation> loadData() {
        String tempPath = Utils.getTempPath();
        File tempDirectory = new File(tempPath);
        if (!tempDirectory.exists() || tempDirectory.isFile()) {
            return new ArrayList<IAnnotation>();
        }

        List<IAnnotation> annotations = new ArrayList<IAnnotation>();
        File[] directories = tempDirectory.listFiles();
        for (File directory : directories) {
            if (directory.isFile()) {
                continue;
            }
            File[] files = directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.equals(ANNOTATION_FILE_NAME);
                }
            });
            for (File file : files) {
                DataInputStream dataInputStream = null;
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    dataInputStream = new DataInputStream(fileInputStream);
                    byte[] bytes = new byte[dataInputStream.available()];
                    dataInputStream.readFully(bytes);
                    List<IAnnotation> fileAnnotations = Utils.fromXml(new String(bytes));
                    annotations.addAll(fileAnnotations);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Utils.closeStreams(dataInputStream, fileInputStream);
                }
            }
        }
        return annotations;
    }
}
