package com.groupdocs.annotation.samples.connector.dao;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.dao.interfaces.IAnnDocDao;
import com.groupdocs.annotation.data.tables.interfaces.IAnnDoc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlAnnDocDaoImpl extends CustomAbstractDaoImpl<IAnnDoc> implements IAnnDocDao {

    public static final String ANN_DOC_FILE_NAME = "AnnDoc.xml";

    @Override
    protected void saveData(List<IAnnDoc> data) {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + ANN_DOC_FILE_NAME);
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
    protected List<IAnnDoc> loadData() {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + ANN_DOC_FILE_NAME);
        if (!file.exists() || !file.isFile()) {
            return new ArrayList<IAnnDoc>();
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
        return new ArrayList<IAnnDoc>();
    }
}
