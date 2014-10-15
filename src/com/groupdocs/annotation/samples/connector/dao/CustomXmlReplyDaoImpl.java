package com.groupdocs.annotation.samples.connector.dao;

import com.groupdocs.annotation.db.dao.interfaces.IReplyDao;
import com.groupdocs.annotation.db.tables.interfaces.IReply;
import com.groupdocs.annotation.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlReplyDaoImpl extends CustomAbstractDaoImpl<IReply> implements IReplyDao {

    public static final String REPLY_FILE_NAME = "Reply.xml";

    @Override
    protected void saveData(List<IReply> data) {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + REPLY_FILE_NAME);
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
    protected List<IReply> loadData() {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + REPLY_FILE_NAME);
        if (!file.exists() || !file.isFile()) {
            return new ArrayList<IReply>();
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
        return new ArrayList<IReply>();
    }
}
