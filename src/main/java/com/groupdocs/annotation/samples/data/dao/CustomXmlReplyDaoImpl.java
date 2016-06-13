package com.groupdocs.annotation.samples.data.dao;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.dao.interfaces.IReplyDao;
import com.groupdocs.annotation.data.environment.IEnvironmentCreator;
import com.groupdocs.annotation.data.tables.interfaces.IReply;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Custom xml reply dao.
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlReplyDaoImpl extends CustomAbstractDaoImpl<IReply> implements IReplyDao {

    /**
     * The constant REPLY_FILE_NAME.
     */
    public static final String REPLY_FILE_NAME = "Reply.xml";

    /**
     * Instantiates a new Custom xml reply dao.
     * @param environmentCreator the environment creator
     */
    public CustomXmlReplyDaoImpl(IEnvironmentCreator environmentCreator) {
        super(environmentCreator);
    }

    /**
     * Save data.
     * @param data the data
     */
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

    /**
     * Load data list.
     * @return the list
     */
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
            return fromXml(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeStreams(dataInputStream, fileInputStream);
        }
        return new ArrayList<IReply>();
    }
}
