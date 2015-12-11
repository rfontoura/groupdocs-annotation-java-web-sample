package com.groupdocs.annotation.samples.javaweb.config;

import com.groupdocs.annotation.config.ServiceConfiguration;

import java.util.Properties;

/**
 * The type Application config.
 * @author Aleksey Permyakov on 05.06.14.
 */
public class ApplicationConfig extends ServiceConfiguration {
    private final Properties properties;

    /**
     * Instantiates a new Application config.
     * @param properties the properties
     */
    public ApplicationConfig(Properties properties) {
        this.properties = properties;
    }

    /**
     * {@inheritDoc}
     * @return the license path
     */
    @Override
    public String getLicensePath() {
        return properties.getProperty("licensePath", null);
    }

    /**
     * {@inheritDoc}
     * @return the application path
     */
    @Override
    public String getApplicationPath() {
        return properties.getProperty("applicationPath", null);
    }

    /**
     * {@inheritDoc}
     * @return the base path
     */
    @Override
    public String getBasePath() {
        return properties.getProperty("basePath", null);
    }

    /**
     * {@inheritDoc}
     * @return the cache path
     */
    @Override
    public String getCachePath() {
        return properties.getProperty("cachePath", null);
    }

    /**
     * {@inheritDoc}
     * @return the upload path
     */
    @Override
    public String getUploadPath() {
        return properties.getProperty("uploadPath", null);
    }

    /**
     * {@inheritDoc}
     * @return the localization
     */
    @Override
    public String getLocalization() {
        return properties.getProperty("localization", null);
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isDisableAtmosphere() {
        return Boolean.parseBoolean(properties.getProperty("disableAtmosphere", "false"));
    }

    /**
     * Is case sensitive boolean.
     * @return the boolean
     */
    @Override
    public Boolean isCaseSensitive() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isUseCache() {
        return Boolean.parseBoolean(properties.getProperty("useCache", "false"));
    }

    /**
     * Gets encoding.
     * @return the encoding
     */
    @Override
    public String getEncoding() {
        return properties.getProperty("encoding", null);
    }

    /**
     * Gets fonts path.
     * @return the fonts path
     */
    @Override
    public String getFontsPath() {
        return properties.getProperty("fontsPath", null);
    }

    /**
     * Gets image web request timeout.
     * @return the image web request timeout
     */
    @Override
    public Integer getImageWebRequestTimeout() {
        return null;
    }

    /**
     * Gets image resolution.
     * @return the image resolution
     */
    @Override
    public Integer getImageResolution() {
        return null;
    }

    /**
     * Is show hidden slides boolean.
     * @return the boolean
     */
    @Override
    public Boolean isShowHiddenSlides() {
        return null;
    }


    /**
     * Gets storage type.
     * @return the storage type
     */
    public String getStorageType() {
        return properties.getProperty("storageType", null);
    }

    /**
     * Gets db server.
     * @return the db server
     */
    public String getDbServer() {
        return properties.getProperty("dbServer", null);
    }


    /**
     * Gets db port.
     * @return the db port
     */
    public Integer getDbPort() {
        return Integer.parseInt(properties.getProperty("dbPort", "0"));
    }


    /**
     * Gets db name.
     * @return the db name
     */
    public String getDbName() {
        return properties.getProperty("dbName", null);
    }


    /**
     * Gets db username.
     * @return the db username
     */
    public String getDbUsername() {
        return properties.getProperty("dbUsername", null);
    }


    /**
     * Gets db password.
     * @return the db password
     */
    public String getDbPassword() {
        return properties.getProperty("dbPassword", null);
    }


    /**
     * Gets storage path.
     * @return the storage path
     */
    public String getStoragePath() {
        String storagePath = properties.getProperty("storagePath", null);
        return storagePath == null || "null".equals(storagePath) ? null : storagePath;
    }

    /**
     * Gets store logic.
     * @return the store logic
     */
    public String getStoreLogic() {
        return properties.getProperty("storeLogic", null);
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isUseBrowserCache() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the expiration date
     */
    @Override
    public Integer getExpirationDate() {
        return 5;
    }

    /**
     * {@inheritDoc}
     * @return the encryption key
     */
    @Override
    public String getEncryptionKey() {
        return "GroupDocsEncrypt";
    }

    /**
     * {@inheritDoc}
     * @return the locales path
     */
    @Override
    public String getLocalesPath() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return the quality
     */
    @Override
    public Integer getQuality() {
        return 100;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isShowThumbnails() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isOpenThumbnails() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the initial zoom
     */
    @Override
    public Integer getInitialZoom() {
        return 100;
    }

    /**
     * {@inheritDoc}
     * @return the jquery file download cookie name
     */
    @Override
    public String getJqueryFileDownloadCookieName() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isZoomToFitWidth() {
        return true;
    }

    /**
     * Gets custom document css.
     * @return the custom document css
     */
    @Override
    public String getCustomDocumentCss() {
        return null;
    }

    /**
     * Is use virtual scrolling boolean.
     * @return the boolean
     */
    @Override
    public boolean isUseVirtualScrolling() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isZoomToFitHeight() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the width
     */
    @Override
    public Integer getWidth() {
        return 1000;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isConvertWordDocumentsCompletely() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the file display name
     */
    @Override
    public String getFileDisplayName() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return the height
     */
    @Override
    public Integer getHeight() {
        return 800;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isIgnoreDocumentAbsence() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isShowPrint() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isShowZoom() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isSupportPageRotation() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isShowPaging() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the preload pages count
     */
    @Override
    public Integer getPreloadPagesCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isPreloadPagesOnBrowserSide() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isPrintWithWatermark() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isShowHeader() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isUseEmScaling() {
        return false;
    }

    /**
     * Is pdf print margins enabled boolean.
     * @return the boolean
     */
    @Override
    public Boolean isPdfPrintMarginsEnabled() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the watermark font size
     */
    @Override
    public Integer getWatermarkFontSize() {
        return 24;
    }

    /**
     * {@inheritDoc}
     * @return the watermark position
     */
    @Override
    public String getWatermarkPosition() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isShowFileExplorer() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isEnableRightClickMenu() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isShowToolbar() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isEnableSidePanel() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isScrollOnFocus() {
        return true;
    }


    /**
     * {@inheritDoc}
     * @return the strike out color
     */
    @Override
    public String getStrikeOutColor() {
        return "#00000c";
    }

    /**
     * {@inheritDoc}
     * @return the highlight color
     */
    @Override
    public String getHighlightColor() {
        return "#000017";
    }

    /**
     * {@inheritDoc}
     * @return the underline color
     */
    @Override
    public String getUnderlineColor() {
        return "#FF0000";
    }

    /**
     * {@inheritDoc}
     * @return the text field background color
     */
    @Override
    public String getTextFieldBackgroundColor() {
        return "#000041";
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isTabNavigationEnabled() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the area tool options pen width
     */
    @Override
    public Integer getAreaToolOptionsPenWidth() {
        return 1;
    }

    /**
     * {@inheritDoc}
     * @return the area tool options pen color
     */
    @Override
    public String getAreaToolOptionsPenColor() {
        return "#00FF00";
    }

    /**
     * {@inheritDoc}
     * @return the area tool options pen dash style
     */
    @Override
    public Integer getAreaToolOptionsPenDashStyle() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * @return the area tool options brush color
     */
    @Override
    public String getAreaToolOptionsBrushColor() {
        return "#00FF00";
    }

    /**
     * {@inheritDoc}
     * @return the polyline tool options pen width
     */
    @Override
    public Integer getPolylineToolOptionsPenWidth() {
        return 1;
    }

    /**
     * {@inheritDoc}
     * @return the polyline tool options pen color
     */
    @Override
    public String getPolylineToolOptionsPenColor() {
        return "#FF0000";
    }

    /**
     * {@inheritDoc}
     * @return the polyline tool options pen dash style
     */
    @Override
    public Integer getPolylineToolOptionsPenDashStyle() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * @return the polyline tool options brush color
     */
    @Override
    public String getPolylineToolOptionsBrushColor() {
        return "#0000FF";
    }

    /**
     * {@inheritDoc}
     * @return the arrow tool options pen width
     */
    @Override
    public Integer getArrowToolOptionsPenWidth() {
        return 1;
    }

    /**
     * {@inheritDoc}
     * @return the arrow tool options pen color
     */
    @Override
    public String getArrowToolOptionsPenColor() {
        return "#FF0000";
    }

    /**
     * {@inheritDoc}
     * @return the arrow tool options pen dash style
     */
    @Override
    public Integer getArrowToolOptionsPenDashStyle() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * @return the arrow tool options brush color
     */
    @Override
    public String getArrowToolOptionsBrushColor() {
        return "#FF00FF";
    }

    /**
     * {@inheritDoc}
     * @return the distance tool options pen color
     */
    @Override
    public String getDistanceToolOptionsPenColor() {
        return "#0000FF";
    }

    /**
     * {@inheritDoc}
     * @return the pen width
     */
    @Override
    public Integer getPenWidth() {
        return super.getPenWidth();
    }

    /**
     * {@inheritDoc}
     * @return the pen color
     */
    @Override
    public String getPenColor() {
        return "#FFFF00";
    }

    /**
     * {@inheritDoc}
     * @return the pen style
     */
    @Override
    public Integer getPenStyle() {
        return super.getPenStyle();
    }

    /**
     * {@inheritDoc}
     * @return the enabled tools
     */
    @Override
    public Integer getEnabledTools() {
        return 8191;
    }

    /**
     * {@inheritDoc}
     * @return the connector position
     */
    @Override
    public Integer getConnectorPosition() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isSaveReplyOnFocusLoss() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isClickableAnnotations() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isDisconnectUncommented() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the strikeout mode
     */
    @Override
    public Integer getStrikeoutMode() {
        return 1;
    }

    /**
     * {@inheritDoc}
     * @return the sidebar container selector
     */
    @Override
    public String getSidebarContainerSelector() {
        return "div.comments_sidebar_wrapper";
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isUsePageNumberInUrlHash() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isTextSelectionSynchronousCalculation() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isVariableHeightPageSupport() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isRightPanelEnabled() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isCreateMarkup() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isUse_pdf() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the mode
     */
    @Override
    public String getMode() {
        return "annotatedDocument";
    }

    /**
     * {@inheritDoc}
     * @return the selection container selector
     */
    @Override
    public String getSelectionContainerSelector() {
        return "[name='selection-content']";
    }

    /**
     * {@inheritDoc}
     * @return the graphics container selector
     */
    @Override
    public String getGraphicsContainerSelector() {
        return ".annotationsContainer";
    }

    /**
     * {@inheritDoc}
     * @return the widget id
     */
    @Override
    public String getWidgetId() {
        return "annotation-widget";
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isUndoEnabled() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isAnyToolSelection() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isPrintAnnotations() {
        return true;
    }

    /**
     * Is typewriter import enabled boolean.
     * @return the boolean
     */
    @Override
    public Boolean isTypewriterImportEnabled() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the max cache size
     */
    @Override
    public Long getMaxCacheSize() {
        return 10L;
    }

    /**
     * {@inheritDoc}
     * @return the boolean
     */
    @Override
    public Boolean isSearchForSeparateWords() {
        return true;
    }
}
