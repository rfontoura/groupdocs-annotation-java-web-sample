package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.config.ServiceConfigurationBase;

/**
 * @author Aleksey Permyakov on 05.06.14.
 */
public class ApplicationConfig extends ServiceConfigurationBase {
    private final String appPath;
    private final String basePath;
    private final String licensePath;

    public ApplicationConfig(String appPath, String basePath, String licensePath) {
        this.appPath = appPath;
        this.basePath = basePath;
        this.licensePath = licensePath;
    }

    @Override
    public String getLicensePath() {
        return licensePath;
    }

    @Override
    public String getApplicationPath() {
        return appPath;
    }

    @Override
    public String getBasePath() {
        return basePath;
    }

    @Override
    public boolean isUseAuthorization() {
        return false;
    }

    @Override
    public boolean isUseCache() {
        return false;
    }

    @Override
    public boolean isUseBrowserCache() {
        return false;
    }

    @Override
    public int getExpirationDate() {
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
    public String getUploadPath() {
        return "/";
    }

    @Override
    public int getQuality() {
        return 100;
    }

    @Override
    public boolean isShowThumbnails() {
        return true;
    }

    @Override
    public boolean isOpenThumbnails() {
        return false;
    }

    @Override
    public int getInitialZoom() {
        return 100;
    }

    @Override
    public boolean isZoomToFitWidth() {
        return true;
    }

    @Override
    public boolean isZoomToFitHeight() {
        return false;
    }

    @Override
    public int getWidth() {
        return 1000;
    }

    @Override
    public int getHeight() {
        return 800;
    }

    @Override
    public boolean isShowPrint() {
        return true;
    }

    @Override
    public boolean isShowZoom() {
        return true;
    }

    @Override
    public boolean isShowPaging() {
        return true;
    }

    @Override
    public int getPreloadPagesCount() {
        return 0;
    }

    @Override
    public boolean isShowHeader() {
        return true;
    }

    @Override
    public boolean isUseEmScaling() {
        return false;
    }

    @Override
    public boolean isShowFileExplorer() {
        return true;
    }

    @Override
    public boolean isEnableRightClickMenu() {
        return true;
    }

    @Override
    public boolean isShowToolbar() {
        return true;
    }

    @Override
    public boolean isEnableSidePanel() {
        return true;
    }

    @Override
    public boolean isScrollOnFocus() {
        return true;
    }

    @Override
    public String getStrikeOutColor() {
        return "";
    }

    @Override
    public int getEnabledTools() {
        return 8191;
    }

    @Override
    public int getConnectorPosition() {
        return 0;
    }

    @Override
    public boolean isSaveReplyOnFocusLoss() {
        return false;
    }

    @Override
    public boolean isClickableAnnotations() {
        return true;
    }

    @Override
    public boolean isDisconnectUncommented() {
        return false;
    }

    @Override
    public int getStrikeoutMode() {
        return 1;
    }

    @Override
    public String getSidebarContainerSelector() {
        return "div.comments_sidebar_wrapper";
    }

    @Override
    public boolean isUsePageNumberInUrlHash() {
        return false;
    }

    @Override
    public boolean isTextSelectionSynchronousCalculation() {
        return true;
    }

    @Override
    public boolean isVariableHeightPageSupport() {
        return true;
    }

    @Override
    public boolean isUseJavaScriptDocumentDescription() {
        return true;
    }

    @Override
    public boolean isRightPanelEnabled() {
        return true;
    }

    @Override
    public boolean isCreateMarkup() {
        return true;
    }

    @Override
    public boolean isUse_pdf() {
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
    public boolean isUndoEnabled() {
        return true;
    }
}
