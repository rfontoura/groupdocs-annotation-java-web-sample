package com.groupdocs.annotation.samples.data.dao;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.dao.interfaces.ISystemInfoDao;
import com.groupdocs.annotation.data.environment.IEnvironmentCreator;
import com.groupdocs.annotation.data.tables.interfaces.ISystemInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Custom xml system info dao.
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlSystemInfoDaoImpl extends CustomAbstractDaoImpl<ISystemInfo> implements ISystemInfoDao {

    /**
     * The constant SYSTEM_INFO_FILE_NAME.
     */
    public static final String SYSTEM_INFO_FILE_NAME = "SystemInfo.xml";

    /**
     * Instantiates a new Custom xml system info dao.
     * @param environmentCreator the environment creator
     */
    public CustomXmlSystemInfoDaoImpl(IEnvironmentCreator environmentCreator) {
        super(environmentCreator);
    }

    /**
     * Save data.
     * @param data the data
     */
    @Override
    protected void saveData(List<ISystemInfo> data) {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + SYSTEM_INFO_FILE_NAME);
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
    protected List<ISystemInfo> loadData() {
        String tempPath = Utils.getTempPath();
        File file = new File(tempPath + File.separator + SYSTEM_INFO_FILE_NAME);
        if (!file.exists() || !file.isFile()) {
            return new ArrayList<ISystemInfo>();
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
        return new ArrayList<ISystemInfo>();
    }
}
