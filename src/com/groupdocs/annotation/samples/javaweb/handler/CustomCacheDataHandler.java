package com.groupdocs.annotation.samples.javaweb.handler;

import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.GroupDocsFileDescription;
import com.groupdocs.viewer.handlers.cache.CacheDataHandler;

import java.io.*;

/**
 * The type Custom cache data handler.
 * @author Alex Bobkov
 */
public class CustomCacheDataHandler implements CacheDataHandler {
    private final String cacheDir;

    /**
     * Instantiates a new Custom cache data handler.
     *
     * @param config the config
     */
    public CustomCacheDataHandler(ServiceConfiguration config) {
        cacheDir = config.getConfig().getCachePath();
    }

    private String getDocumentCachePath(GroupDocsFileDescription fileDescription) {
        return cacheDir + fileDescription.getGuid() + "/";
    }

    private String getPdfPath(GroupDocsFileDescription fileDescription) {
        return getDocumentCachePath(fileDescription) + fileDescription.getBaseName() + ".pdf";
    }

    private String getImagePath(GroupDocsFileDescription fileDescription, int page, int width) {
        return getDocumentCachePath(fileDescription) + width + "/" + fileDescription.getBaseName() + page + ".png";
    }

    public boolean imageExists(GroupDocsFileDescription fileDescription, int page, int width) {
        String imagePath = getImagePath(fileDescription, page, width);
        File imageFile = new File(imagePath);
        if (imageFile.exists() && (imageFile.length() > 0) && (imageFile.lastModified() > fileDescription.getLastModified())) {
            return true;
        } else {
            imageFile.getParentFile().mkdirs();
            return false;
        }
    }

    public InputStream getImageStream(GroupDocsFileDescription fileDescription, int page, int width) throws FileNotFoundException {
        String imagePath = getImagePath(fileDescription, page, width);
        File file = new File(imagePath);
        return new FileInputStream(file);
    }

    public OutputStream getImageSaveStream(GroupDocsFileDescription fileDescription, int page, int width) throws FileNotFoundException {
        String imagePath = getImagePath(fileDescription, page, width);
        File file = new File(imagePath);
        return new FileOutputStream(file);
    }

    public boolean pdfExists(GroupDocsFileDescription fileDescription) {
        String pdfPath = getPdfPath(fileDescription);
        File pdfFile = new File(pdfPath);
        if (pdfFile.exists() && (pdfFile.length() > 0) && (pdfFile.lastModified() > fileDescription.getLastModified())) {
            return true;
        } else {
            pdfFile.getParentFile().mkdirs();
            return false;
        }
    }

    public InputStream getPdfStream(GroupDocsFileDescription fileDescription) throws FileNotFoundException {
        String pdfPath = getPdfPath(fileDescription);
        File pdfFile = new File(pdfPath);
        return new FileInputStream(pdfFile);
    }

    public OutputStream getPdfSaveStream(GroupDocsFileDescription fileDescription) throws FileNotFoundException {
        String pdfPath = getPdfPath(fileDescription);
        File pdfFile = new File(pdfPath);
        return new FileOutputStream(pdfFile);
    }
}
