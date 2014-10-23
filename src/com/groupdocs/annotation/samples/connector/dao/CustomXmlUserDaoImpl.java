package com.groupdocs.annotation.samples.connector.dao;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.dao.interfaces.IUserDao;
import com.groupdocs.annotation.data.tables.interfaces.IUser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlUserDaoImpl extends CustomAbstractDaoImpl<IUser> implements IUserDao {

    public static final String USER_FILE_NAME = "User.xml";

    @Override
    protected void saveData(List<IUser> data) {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + USER_FILE_NAME);
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
    protected List<IUser> loadData() {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + USER_FILE_NAME);
        if (!file.exists() || !file.isFile()) {
            return new ArrayList<IUser>();
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
        return new ArrayList<IUser>();
    }
}
