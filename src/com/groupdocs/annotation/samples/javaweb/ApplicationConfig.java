package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.viewer.config.ServiceConfigurationBase;

/**
 * @author Aleksey Permyakov on 05.06.14.
 */
public class ApplicationConfig implements ServiceConfigurationBase {
    private final String appPath;
    private final String basePath;

    public ApplicationConfig(String appPath, String basePath) {
        this.appPath = appPath;
        this.basePath = basePath;
    }

    @Override
    public String getLicensePath() {
        return "C:\\license\\GroupDocs.Annotation.lic";
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
    public String getBackgroundColor() {
        return null;
    }

    @Override
    public boolean isShowFolderBrowser() {
        return true;
    }

    @Override
    public boolean isShowPrint() {
        return true;
    }

    @Override
    public boolean isShowDownload() {
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
    public boolean isShowViewerStyleControl() {
        return true;
    }

    @Override
    public boolean isShowSearch() {
        return true;
    }

    @Override
    public int getPreloadPagesCount() {
        return 0;
    }

    @Override
    public int getViewerStyle() {
        return 1;
    }

    @Override
    public boolean isSupportTextSelection() {
        return true;
    }

    @Override
    public boolean isUsePdfPrinting() {
        return false;
    }

    @Override
    public String getToolbarButtonsBoxShadowStyle() {
        return null;
    }

    @Override
    public String getToolbarButtonsBoxShadowHoverStyle() {
        return null;
    }

    @Override
    public String getThumbnailsContainerBackgroundColor() {
        return null;
    }

    @Override
    public String getThumbnailsContainerBorderRightColor() {
        return null;
    }

    @Override
    public String getToolbarBorderBottomColor() {
        return null;
    }

    @Override
    public String getToolbarInputFieldBorderColor() {
        return null;
    }

    @Override
    public String getToolbarButtonBorderColor() {
        return null;
    }

    @Override
    public String getToolbarButtonBorderHoverColor() {
        return null;
    }

    @Override
    public int getThumbnailsContainerWidth() {
        return 0;
    }

    @Override
    public boolean isShowDownloadErrorsInPopup() {
        return false;
    }

    @Override
    public boolean isShowImageWidth() {
        return false;
    }

    @Override
    public boolean isShowHeader() {
        return true;
    }

    @Override
    public int getMinimumImageWidth() {
        return 0;
    }

    @Override
    public boolean isEnableStandardErrorHandling() {
        return true;
    }

    @Override
    public boolean isUseHtmlBasedEngine() {
        return false;
    }

    @Override
    public boolean isUseImageBasedPrinting() {
        return true;
    }

    @Override
    public boolean isDownloadPdfFile() {
        return false;
    }

    @Override
    public boolean isSearchForSeparateWords() {
        return false;
    }

    @Override
    public boolean isPreventTouchEventsBubbling() {
        return false;
    }

    @Override
    public boolean isUseInnerThumbnails() {
        return true;
    }

    @Override
    public String getWatermarkText() {
        return null;
    }

    @Override
    public String getWatermarkColor() {
        return null;
    }

    @Override
    public boolean isSupportPageReordering() {
        return false;
    }

    @Override
    public boolean isOnlyShrinkLargePages() {
        return true;
    }

    @Override
    public String getSearchHighlightColor() {
        return null;
    }

    @Override
    public String getCurrentSearchHighlightColor() {
        return null;
    }

    @Override
    public boolean isTreatPhrasesInDoubleQuotesAsExactPhrases() {
        return false;
    }

    @Override
    public boolean isUsePngImagesForHtmlBasedEngine() {
        return false;
    }

    @Override
    public boolean isShowOnePageInRow() {
        return false;
    }

    @Override
    public boolean isLoadAllPagesOnSearch() {
        return false;
    }

    @Override
    public boolean isUseEmScaling() {
        return false;
    }


    public boolean isShowFileExplorer() {
        return true;
    }

    public boolean isEnableRightClickMenu() {
        return true;
    }

    public boolean isShowToolbar() {
        return true;
    }

    public boolean isEnableSidePanel() {
        return true;
    }

    public boolean isScrollOnFocus() {
        return true;
    }

    public String getStrikeOutColor() {
        return "";
    }

    public int getEnabledTools() {
        return 2047;
    }

    public int getConnectorPosition() {
        return 0;
    }

    public boolean isSaveReplyOnFocusLoss() {
        return false;
    }

    public boolean isClickableAnnotations() {
        return true;
    }

    public boolean isDisconnectUncommented() {
        return false;
    }

    public int getStrikeoutMode() {
        return 1;
    }

    public String getSidebarContainerSelector() {
        return "div.comments_sidebar_wrapper";
    }

    public boolean isUsePageNumberInUrlHash() {
        return false;
    }

    public boolean isTextSelectionSynchronousCalculation() {
        return true;
    }

    public boolean isVariableHeightPageSupport() {
        return true;
    }

    public boolean isUseJavaScriptDocumentDescription() {
        return true;
    }

    public boolean isRightPanelEnabled() {
        return true;
    }

    public boolean isCreateMarkup() {
        return true;
    }

    public boolean isUse_pdf() {
        return true;
    }

    public String getMode() {
        return "annotatedDocument";
    }

    public String getSelectionContainerSelector() {
        return "[name='selection-content']";
    }

    public String getGraphicsContainerSelector() {
        return ".annotationsContainer";
    }

    public String getWidgetId() {
        return "annotation-widget";
    }
}
