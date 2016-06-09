package com.groupdocs.annotation.samples.data.dao;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.dao.interfaces.ICollaboratorDao;
import com.groupdocs.annotation.data.environment.IEnvironmentCreator;
import com.groupdocs.annotation.data.tables.interfaces.ICollaborator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlCollaboratorDaoImpl extends CustomAbstractDaoImpl<ICollaborator> implements ICollaboratorDao {

    public static final String COLLABORATOR_FILE_NAME = "Collaborator.xml";

    public CustomXmlCollaboratorDaoImpl(IEnvironmentCreator environmentCreator) {
        super(environmentCreator);
    }

    @Override
    protected void saveData(List<ICollaborator> data) {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + COLLABORATOR_FILE_NAME);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            saveObjectAsXml(data, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            Utils.closeStreams(fileOutputStream);
        }
    }

    @Override
    protected List<ICollaborator> loadData() {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + COLLABORATOR_FILE_NAME);
        if (!file.exists() || !file.isFile()) {
            return new ArrayList<ICollaborator>();
        }
        DataInputStream dataInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);
            byte[] bytes = new byte[dataInputStream.available()];
            dataInputStream.readFully(bytes);
            return fromXml(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeStreams(dataInputStream, fileInputStream);
        }
        return new ArrayList<ICollaborator>();
    }
}
