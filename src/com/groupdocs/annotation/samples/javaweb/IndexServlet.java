package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.domain.AccessRights;
import com.groupdocs.viewer.domain.*;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author imy
 */
public class IndexServlet extends AnnotationServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("annotation_head", annotationHandler.getHeader(request));
        final String userName = request.getParameter("userName");

        String fileId = request.getParameter("fileId");
        String filePath = request.getParameter("filePath");
        String fileUrl = request.getParameter("fileUrl");
        String tokenId = request.getParameter("tokenId");

        // Default value
        if (filePath == null) {
            filePath = "/files/GroupDocs_Demo.doc";
        }

        final GroupDocsPath groupDocsFilePath;

        if(fileId !=null && !fileId.isEmpty()){
            groupDocsFilePath = new FileId(fileId);
        }else if(filePath != null && !filePath.isEmpty()){
            groupDocsFilePath = new FilePath(filePath, annotationHandler.getConfiguration());
        }else if(fileUrl != null && !fileUrl.isEmpty()){
            groupDocsFilePath = new FileUrl(fileUrl);
        }else if(tokenId != null && !tokenId.isEmpty()){
            TokenId tki = new TokenId(tokenId, serviceConfiguration.getEncryptionKey());
            if(tki.isExpired()){
                groupDocsFilePath = null;
            }else{
                groupDocsFilePath = tki;
            }
        } else {
            groupDocsFilePath = null;
        }

        final String userGuid = annotationHandler.addCollaborator(userName, groupDocsFilePath.getPath(), AccessRights.All.value(), getIntFromColor(Color.RED));

        HashMap<String, Object> params = new HashMap<String, Object>() {{
            // You can skip parameters which have default value
            put("filePath",                             groupDocsFilePath.getPath()); // Default value: empty string
            put("width",                                applicationConfig.getWidth());            // Default value: 800
            put("height",                               applicationConfig.getHeight());           // Default value: 600
            put("quality",                              applicationConfig.getQuality());              // Default value: 90
            put("enableRightClickMenu",                 applicationConfig.isEnableRightClickMenu());            // Default value: true
            put("showHeader",                           applicationConfig.isShowHeader());       // Default value: true
            put("showZoom",                             applicationConfig.isShowZoom());         // Default value: true
            put("showPaging",                           applicationConfig.isShowPaging());       // Default value: true
            put("showPrint",                            applicationConfig.isShowPrint());        // Default value: false
            put("showFileExplorer",                     applicationConfig.isShowFileExplorer());            // Default value: true
            put("showThumbnails",                       applicationConfig.isShowThumbnails());   // Default value: true
            put("showToolbar",                          applicationConfig.isShowToolbar());            // Default value: true
            put("openThumbnails",                       applicationConfig.isOpenThumbnails());   // Default value: false
            put("zoomToFitWidth",                       applicationConfig.isZoomToFitWidth());           // Default value: false
            put("zoomToFitHeight",                      applicationConfig.isZoomToFitHeight());           // Default value: false
            put("initialZoom",                          applicationConfig.getInitialZoom());             // Default value: 100
            put("preloadPagesCount",                    applicationConfig.getPreloadPagesCount());               // Default value: 0
            put("enableSidePanel",                      applicationConfig.isEnableSidePanel());            // Default value: true
            put("scrollOnFocus",                        applicationConfig.isScrollOnFocus());            // Default value: true
            put("strikeOutColor",                       applicationConfig.getStrikeOutColor());                // Default value: empty string
            put("enabledTools",                         applicationConfig.getEnabledTools());            // Default value: 2047
            put("connectorPosition",                    applicationConfig.getConnectorPosition());               // Default value: 0
            put("saveReplyOnFocusLoss",                 applicationConfig.isSaveReplyOnFocusLoss());           // Default value: false
            put("clickableAnnotations",                 applicationConfig.isClickableAnnotations());           // Default value: true
            put("disconnectUncommented",                applicationConfig.isDisconnectUncommented());           // Default value: false
            put("strikeoutMode",                        applicationConfig.getStrikeoutMode());               // Default value: 0
            put("sideboarContainerSelector",            applicationConfig.getSidebarContainerSelector()); // Default value: div.comments_sidebar_wrapper
            put("usePageNumberInUrlHash",               applicationConfig.isUsePageNumberInUrlHash());           // Default value: false
            put("textSelectionSynchronousCalculation",  applicationConfig.isTextSelectionSynchronousCalculation());            // Default value: true
            put("variableHeightPageSupport",            applicationConfig.isVariableHeightPageSupport());            // Default value: true
            put("useJavaScriptDocumentDescription",     applicationConfig.isUseJavaScriptDocumentDescription());            // Default value: true
            put("isRightPanelEnabled",                  applicationConfig.isRightPanelEnabled());            // Default value: true
            put("createMarkup",                         applicationConfig.isCreateMarkup());            // Default value: true
            put("use_pdf",                              applicationConfig.isUse_pdf());            // Default value: true
            put("_mode",                                applicationConfig.getMode());           // Default value: annotatedDocument
            put("selectionContainerSelector",           applicationConfig.getSelectionContainerSelector());  // Default value: [name='selection-content']
            put("graphicsContainerSelector",            applicationConfig.getGraphicsContainerSelector());       // Default value: .annotationsContainer
            put("widgetId",                             applicationConfig.getWidgetId());           // Default value: annotation-widget
            put("userName",                             userName == null ? "Anonimous" : userName);
            put("userGuid",                             userGuid);
//            put("showFolderBrowser", Boolean.toString(applicationConfig.getShowFolderBrowser())); // Not used
//            put("showDownload", Boolean.toString(applicationConfig.getShowDownload())); // Not used
//            put("showSearch", Boolean.toString(applicationConfig.getShowSearch())); // Not used
        }};        request.setAttribute("annotation_scripts", annotationHandler.getScripts(request, params));
        request.setAttribute("userName", userName);
        request.setAttribute("userGuid", userGuid);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("annotation/index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getIntFromColor(Color color){
        return getIntFromColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    public int getIntFromColor(float red, float green, float blue){
        int R = Math.round(255 * red);
        int G = Math.round(255 * green);
        int B = Math.round(255 * blue);

        R = (R << 16) & 0x00FF0000;
        G = (G << 8) & 0x0000FF00;
        B = B & 0x000000FF;

        return 0xFF000000 | R | G | B;
    }}
