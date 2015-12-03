package com.groupdocs.annotation.samples.javaweb.handler;

import com.groupdocs.annotation.config.ext.ServiceConfiguration;
import com.groupdocs.annotation.domain.GroupDocsFileDescription;
import com.groupdocs.annotation.domain.path.EncodedPath;
import com.groupdocs.annotation.handler.input.InputDataHandler;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import javax.naming.NoPermissionException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Input data handler - custom implementation
 * @author Aleksey Permyakov, Alex Bobkov
 */
public class CustomInputDataHandler extends InputDataHandler {
    private final HashMap<String, File> fileMap = new HashMap<String, File>();
    private final ServiceConfiguration serviceConfiguration;
    private String basePath = null;

    public CustomInputDataHandler(ServiceConfiguration serviceConfiguration) {
        this.basePath = serviceConfiguration.getRootDir();
        this.serviceConfiguration = serviceConfiguration;
    }

    @Override
    public List<GroupDocsFileDescription> getFileDescriptionList(String directory) throws NoPermissionException {
        File path = new File(basePath + directory);
        if (!path.exists()) {
            path = fileMap.get(directory);
        }
        File[] files = path.listFiles();
        if (files == null) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "File#listFiles return null for path '" + path + "'");
//            throw new FileNotFoundException("File#listFiles return null for path '" + path + "'");
            return null;
        }
        List<GroupDocsFileDescription> fileList = new ArrayList<GroupDocsFileDescription>();
        for (File file : files) {
            //Generate file ID with custom encoder
            String guid = new EncodedPath(file.getName(), serviceConfiguration).getPath();
            //Create file description object
            GroupDocsFileDescription fileDescription = new GroupDocsFileDescription();
            fileDescription.setGuid(guid);
            fileDescription.setName(file.getName());
            if (file.exists() && file.isFile()) {
                //If file
                fileDescription.setLastModified(file.lastModified());
                fileDescription.setSize(file.length());
            } else {
                //If directory
                fileDescription.setLastModified(0);
                fileDescription.setSize(0);
            }
            fileList.add(fileDescription);
            fileMap.put(guid, file);
        }
        return fileList;
    }

    @Override
    public GroupDocsFileDescription getFileDescription(String guid) throws Exception {
        //Create file description object
        GroupDocsFileDescription fileDescription = new GroupDocsFileDescription();
        fileDescription.setGuid(guid);
        //Check if guid is initial directory
        if (guid.isEmpty()) {
            fileDescription.setName("");
        } else {
            //Get file
            File file = fileMap.get(guid);
            if (file == null) {
                throw new FileNotFoundException("File with guid '" + guid + "' is not found in CustomInputDataHandler#fileMap");
            }
            fileDescription.setName(file.getName());
            if (file.exists() && file.isFile()) {
                //If file
                fileDescription.setLastModified(file.lastModified());
                fileDescription.setSize(file.length());
            } else {
                //If directory
                fileDescription.setLastModified(0);
                fileDescription.setSize(0);
            }
        }
        return fileDescription;
    }

    @Override
    public InputStream getFile(String guid) {
        try {
            return new FileInputStream(fileMap.get(guid));
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @Override
    public String saveFile(InputStream inputStream, String fileName, Integer timeToLive, String encryptedKey) throws FileNotFoundException, IOException {
        //Generate file ID
        String guid = Base64.encodeBase64String(fileName.getBytes());
        //Save file
        File saveFile = new File(basePath + "/" + fileName);
        FileOutputStream outputStream = new FileOutputStream(saveFile);
        IOUtils.copy(inputStream, outputStream);
        return guid;
    }

}