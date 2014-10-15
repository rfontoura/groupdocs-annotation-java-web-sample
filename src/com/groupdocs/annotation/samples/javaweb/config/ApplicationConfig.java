package com.groupdocs.annotation.samples.javaweb.config;

import com.groupdocs.annotation.config.ServiceConfigurationBase;

import java.util.Properties;

/**
 * @author Aleksey Permyakov on 05.06.14.
 */
public class ApplicationConfig extends ServiceConfigurationBase {
    private final Properties properties;

    public ApplicationConfig(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String getLicensePath() {
        return properties.getProperty("licensePath", null);
    }

    @Override
    public String getApplicationPath() {
        return properties.getProperty("applicationPath", null);
    }

    @Override
    public String getBasePath() {
        return properties.getProperty("basePath", null);
    }

    @Override
    public String getUploadPath() {
        return properties.getProperty("uploadPath", null);
    }

    @Override
    public Boolean isUseCache() {
        return Boolean.parseBoolean(properties.getProperty("useCache", "false"));
    }


    public String getStorageType() {
        return properties.getProperty("storageType", null);
    }

    public String getDbServer() {
        return properties.getProperty("dbServer", null);
    }


    public Integer getDbPort() {
        return Integer.parseInt(properties.getProperty("dbPort", "0"));
    }


    public String getDbName() {
        return properties.getProperty("dbName", null);
    }


    public String getDbUsername() {
        return properties.getProperty("dbUsername", null);
    }


    public String getDbPassword() {
        return properties.getProperty("dbPassword", null);
    }


    public String getStoragePath() {
        String storagePath = properties.getProperty("storagePath", null);
        return storagePath == null || "null".equals(storagePath) ? null : storagePath;
    }

    public String getStoreLogic() {
        return properties.getProperty("storeLogic", null);
    }

    @Override
    public Boolean isUseAuthorization() {
        return false;
    }

    @Override
    public Boolean isUseBrowserCache() {
        return false;
    }

    @Override
    public Integer getExpirationDate() {
        return 5;
    }

    @Override
    public String getEncryptionKey() {
        return "GroupDocsEncrypt";
    }

    @Override
    public String getLocalesPath() {
        return null;
    }

    @Override
    public Integer getQuality() {
        return 100;
    }

    @Override
    public Boolean isShowThumbnails() {
        return true;
    }

    @Override
    public Boolean isOpenThumbnails() {
        return false;
    }

    @Override
    public Integer getInitialZoom() {
        return 100;
    }

    @Override
    public String getJqueryFileDownloadCookieName() {
        return null;
    }

    @Override
    public Boolean isZoomToFitWidth() {
        return true;
    }

    @Override
    public Boolean isZoomToFitHeight() {
        return false;
    }

    @Override
    public Integer getWidth() {
        return 1000;
    }

    @Override
    public Boolean isConvertWordDocumentsCompletely() {
        return false;
    }

    @Override
    public String getFileDisplayName() {
        return null;
    }

    @Override
    public Integer getHeight() {
        return 800;
    }

    @Override
    public Boolean isIgnoreDocumentAbsence() {
        return false;
    }

    @Override
    public Boolean isShowPrint() {
        return true;
    }

    @Override
    public Boolean isShowZoom() {
        return true;
    }

    @Override
    public Boolean isSupportPageRotation() {
        return false;
    }

    @Override
    public Boolean isShowPaging() {
        return true;
    }

    @Override
    public Integer getPreloadPagesCount() {
        return 0;
    }

    @Override
    public Boolean isPreloadPagesOnBrowserSide() {
        return false;
    }

    @Override
    public Boolean isPrintWithWatermark() {
        return false;
    }

    @Override
    public Boolean isShowHeader() {
        return true;
    }

    @Override
    public Boolean isUseEmScaling() {
        return false;
    }

    @Override
    public Integer getWatermarkFontSize() {
        return 24;
    }

    @Override
    public String getWatermarkPosition() {
        return null;
    }

    @Override
    public Boolean isShowFileExplorer() {
        return true;
    }

    @Override
    public Boolean isEnableRightClickMenu() {
        return true;
    }

    @Override
    public Boolean isShowToolbar() {
        return true;
    }

    @Override
    public Boolean isEnableSidePanel() {
        return true;
    }

    @Override
    public Boolean isScrollOnFocus() {
        return true;
    }

    @Override
    public Integer getEnabledTools() {
        return 8191;
    }

    @Override
    public Integer getConnectorPosition() {
        return 0;
    }

    @Override
    public Boolean isSaveReplyOnFocusLoss() {
        return false;
    }

    @Override
    public Boolean isClickableAnnotations() {
        return true;
    }

    @Override
    public Boolean isDisconnectUncommented() {
        return false;
    }

    @Override
    public Integer getStrikeoutMode() {
        return 1;
    }

    @Override
    public String getSidebarContainerSelector() {
        return "div.comments_sidebar_wrapper";
    }

    @Override
    public Boolean isUsePageNumberInUrlHash() {
        return false;
    }

    @Override
    public Boolean isTextSelectionSynchronousCalculation() {
        return true;
    }

    @Override
    public Boolean isVariableHeightPageSupport() {
        return true;
    }

    @Override
    public Boolean isRightPanelEnabled() {
        return true;
    }

    @Override
    public Boolean isCreateMarkup() {
        return true;
    }

    @Override
    public Boolean isUse_pdf() {
        return true;
    }

    @Override
    public String getMode() {
        return "annotatedDocument";
    }

    @Override
    public String getSelectionContainerSelector() {
        return "[name='selection-content']";
    }

    @Override
    public String getGraphicsContainerSelector() {
        return ".annotationsContainer";
    }

    @Override
    public String getWidgetId() {
        return "annotation-widget";
    }

    @Override
    public Boolean isUndoEnabled() {
        return true;
    }

    @Override
    public Boolean isAnyToolSelection() {
        return true;
    }

    @Override
    public Long getMaxCacheSize() {
        return 10L;
    }
}
