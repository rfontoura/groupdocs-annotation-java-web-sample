package com.groupdocs.annotation.samples.connector.dao;

import com.groupdocs.annotation.db.dao.interfaces.IDocumentDao;
import com.groupdocs.annotation.db.tables.interfaces.IDocument;
import com.groupdocs.annotation.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlDocumentDaoImpl extends CustomAbstractDaoImpl<IDocument> implements IDocumentDao {

    public static final String DOCUMENT_FILE_NAME = "Document.xml";

    @Override
    protected void saveData(List<IDocument> data) {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + DOCUMENT_FILE_NAME);
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
    protected List<IDocument> loadData() {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + DOCUMENT_FILE_NAME);
        if (!file.exists() || !file.isFile()) {
            return new ArrayList<IDocument>();
        }
        DataInputStream dataInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);
            byte[] bytes = new byte[dataInputStream.available()];
            dataInputStream.readFully(bytes);
            return Utils.fromXml(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeStreams(dataInputStream, fileInputStream);
        }
        return new ArrayList<IDocument>();
    }
}
