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
        request.setAttribute("annotation_head", annotationHandler.getHeader());
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
            TokenId tki = new TokenId(tokenId);
            if(tki.isExpired()){
                groupDocsFilePath = null;
            }else{
                groupDocsFilePath = tki;
            }
        } else {
            groupDocsFilePath = null;
        }

        final String userGuid = annotationHandler.addCollaborator(userName, groupDocsFilePath.getPath(), AccessRights.All, getIntFromColor(Color.RED));

        HashMap<String, String> params = new HashMap<String, String>() {{
            // You can skip parameters which have default value
            put("filePath",                             groupDocsFilePath.getPath()); // Default value: empty string
            put("width",                                Integer.toString(width));            // Default value: 800
            put("height",                               Integer.toString(height));           // Default value: 600
            put("quality",                              "75");              // Default value: 90
            put("enableRightClickMenu",                 "true");            // Default value: true
            put("showHeader",                           "true");       // Default value: true
            put("showZoom",                             "true");         // Default value: true
            put("showPaging",                           "true");       // Default value: true
            put("showPrint",                            "false");        // Default value: false
            put("showFileExplorer",                     "true");            // Default value: true
            put("showThumbnails",                       "true");   // Default value: true
            put("showToolbar",                          "true");            // Default value: true
            put("openThumbnails",                       "false");   // Default value: false
            put("zoomToFitWidth",                       "false");           // Default value: false
            put("zoomToFitHeight",                      "false");           // Default value: false
            put("initialZoom",                          "100");             // Default value: 100
            put("preloadPagesCount",                    "0");               // Default value: 0
            put("enableSidePanel",                      "true");            // Default value: true
            put("scrollOnFocus",                        "true");            // Default value: true
            put("strikeOutColor",                       "");                // Default value: empty string
            put("enabledTools",                         "511");             // Default value: 511
            put("connectorPosition",                    "0");               // Default value: 0
            put("saveReplyOnFocusLoss",                 "false");           // Default value: false
            put("clickableAnnotations",                 "false");           // Default value: false
            put("disconnectUncommented",                "false");           // Default value: false
            put("strikeoutMode",                        "0");               // Default value: 0
            put("sideboarContainerSelector",            "div.comments_sidebar_wrapper"); // Default value: div.comments_sidebar_wrapper
            put("usePageNumberInUrlHash",               "false");           // Default value: false
            put("textSelectionSynchronousCalculation",  "true");            // Default value: true
            put("variableHeightPageSupport",            "true");            // Default value: true
            put("useJavaScriptDocumentDescription",     "true");            // Default value: true
            put("isRightPanelEnabled",                  "true");            // Default value: true
            put("createMarkup",                         "true");            // Default value: true
            put("use_pdf",                              "true");            // Default value: true
            put("_mode",                                "annotatedDocument");           // Default value: annotatedDocument
            put("selectionContainerSelector",           "[name='selection-content']");  // Default value: [name='selection-content']
            put("graphicsContainerSelector",            ".annotationsContainer");       // Default value: .annotationsContainer
            put("widgetId",                             "annotation-widget");           // Default value: annotation-widget
            put("userName",                             userName == null ? "Anonimous" : userName);
            put("userGuid",                             userGuid);
//            put("showFolderBrowser", Boolean.toString(applicationConfig.getShowFolderBrowser())); // Not used
//            put("showDownload", Boolean.toString(applicationConfig.getShowDownload())); // Not used
//            put("showSearch", Boolean.toString(applicationConfig.getShowSearch())); // Not used
        }};        request.setAttribute("annotation_scripts", annotationHandler.getScripts(params));
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
