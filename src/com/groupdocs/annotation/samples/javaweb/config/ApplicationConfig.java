package com.groupdocs.annotation.samples.javaweb.config;

import com.groupdocs.annotation.config.ServiceConfiguration;

import java.util.Properties;

/**
 * The type Application config.
 *
 * @author Aleksey Permyakov on 05.06.14.
 */
public class ApplicationConfig extends ServiceConfiguration {
    private final Properties properties;

    /**
     * Instantiates a new Application config.
     *
     * @param properties the properties
     */
    public ApplicationConfig(Properties properties) {
        this.properties = properties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLicensePath() {
        return properties.getProperty("licensePath", null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getApplicationPath() {
        return properties.getProperty("applicationPath", null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBasePath() {
        return properties.getProperty("basePath", null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCachePath() {
        return properties.getProperty("cachePath", null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUploadPath() {
        return properties.getProperty("uploadPath", null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLocalization() {
        return properties.getProperty("localization", null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isDisableAtmosphere() {
        return Boolean.parseBoolean(properties.getProperty("disableAtmosphere", "false"));
    }

    @Override
    public Boolean isCaseSensitive() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isUseCache() {
        return Boolean.parseBoolean(properties.getProperty("useCache", "false"));
    }


    /**
     * Gets storage type.
     *
     * @return the storage type
     */
    public String getStorageType() {
        return properties.getProperty("storageType", null);
    }

    /**
     * Gets db server.
     *
     * @return the db server
     */
    public String getDbServer() {
        return properties.getProperty("dbServer", null);
    }


    /**
     * Gets db port.
     *
     * @return the db port
     */
    public Integer getDbPort() {
        return Integer.parseInt(properties.getProperty("dbPort", "0"));
    }


    /**
     * Gets db name.
     *
     * @return the db name
     */
    public String getDbName() {
        return properties.getProperty("dbName", null);
    }


    /**
     * Gets db username.
     *
     * @return the db username
     */
    public String getDbUsername() {
        return properties.getProperty("dbUsername", null);
    }


    /**
     * Gets db password.
     *
     * @return the db password
     */
    public String getDbPassword() {
        return properties.getProperty("dbPassword", null);
    }


    /**
     * Gets storage path.
     *
     * @return the storage path
     */
    public String getStoragePath() {
        String storagePath = properties.getProperty("storagePath", null);
        return storagePath == null || "null".equals(storagePath) ? null : storagePath;
    }

    /**
     * Gets store logic.
     *
     * @return the store logic
     */
    public String getStoreLogic() {
        return properties.getProperty("storeLogic", null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isUseBrowserCache() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getExpirationDate() {
        return 5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEncryptionKey() {
        return "GroupDocsEncrypt";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLocalesPath() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getQuality() {
        return 100;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isShowThumbnails() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isOpenThumbnails() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getInitialZoom() {
        return 100;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getJqueryFileDownloadCookieName() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isZoomToFitWidth() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isZoomToFitHeight() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getWidth() {
        return 1000;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isConvertWordDocumentsCompletely() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFileDisplayName() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getHeight() {
        return 800;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isIgnoreDocumentAbsence() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isShowPrint() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isShowZoom() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isSupportPageRotation() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isShowPaging() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPreloadPagesCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isPreloadPagesOnBrowserSide() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isPrintWithWatermark() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isShowHeader() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isUseEmScaling() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getWatermarkFontSize() {
        return 24;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWatermarkPosition() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isShowFileExplorer() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isEnableRightClickMenu() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isShowToolbar() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isEnableSidePanel() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isScrollOnFocus() {
        return true;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getStrikeOutColor() {
        return "#00000c";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHighlightColor() {
        return "#000017";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUnderlineColor() {
        return "#FF0000";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTextFieldBackgroundColor() {
        return "#000041";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isTabNavigationEnabled() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getAreaToolOptionsPenWidth() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAreaToolOptionsPenColor() {
        return "#00FF00";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getAreaToolOptionsPenDashStyle() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAreaToolOptionsBrushColor() {
        return "#00FF00";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPolylineToolOptionsPenWidth() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPolylineToolOptionsPenColor() {
        return "#FF0000";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPolylineToolOptionsPenDashStyle() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPolylineToolOptionsBrushColor() {
        return "#0000FF";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getArrowToolOptionsPenWidth() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getArrowToolOptionsPenColor() {
        return "#FF0000";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getArrowToolOptionsPenDashStyle() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getArrowToolOptionsBrushColor() {
        return "#FF00FF";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPenWidth() {
        return super.getPenWidth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPenColor() {
        return "#FFFF00";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPenStyle() {
        return super.getPenStyle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getEnabledTools() {
        return 8191;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getConnectorPosition() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isSaveReplyOnFocusLoss() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isClickableAnnotations() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isDisconnectUncommented() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getStrikeoutMode() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSidebarContainerSelector() {
        return "div.comments_sidebar_wrapper";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isUsePageNumberInUrlHash() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isTextSelectionSynchronousCalculation() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isVariableHeightPageSupport() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isRightPanelEnabled() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isCreateMarkup() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isUse_pdf() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMode() {
        return "annotatedDocument";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSelectionContainerSelector() {
        return "[name='selection-content']";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getGraphicsContainerSelector() {
        return ".annotationsContainer";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWidgetId() {
        return "annotation-widget";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isUndoEnabled() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isAnyToolSelection() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isPrintAnnotations() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getMaxCacheSize() {
        return 10L;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isSearchForSeparateWords() {
        return true;
    }
}
