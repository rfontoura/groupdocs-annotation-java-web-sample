package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.api.ApiFactory;
import com.groupdocs.annotation.api.interfaces.IExporter;
import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.DaoFactory;
import com.groupdocs.annotation.domain.GroupDocsFileDescription;
import com.groupdocs.annotation.domain.path.EncodedPath;
import com.groupdocs.annotation.domain.path.GroupDocsPath;
import com.groupdocs.annotation.domain.path.TokenId;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.handler.input.InputDataHandler;
import com.groupdocs.annotation.localization.ILocalization;
import com.groupdocs.annotation.localization.LocalizationRU;
import com.groupdocs.annotation.samples.localization.LocalizationGE;
import org.apache.log4j.Logger;

import javax.naming.NoPermissionException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The type Index servlet.
 * @author imy
 */
public class IndexServlet extends AnnotationServlet {

    /**
     * Do get.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        // Configure localization
        ILocalization localization = null;
        if ("RU".equalsIgnoreCase(applicationConfig.getLocalization())) {
            localization = new LocalizationRU();
        } else if ("GE".equalsIgnoreCase(applicationConfig.getLocalization())) {
            localization = new LocalizationGE();
        }
        String header = "";
        try {
            header = annotationHandler.getHeader(applicationConfig.getApplicationPath(), request);
        } catch (AnnotationException e) {
            Logger.getLogger(this.getClass()).error(e);
        }
        request.setAttribute("annotation_head", header);
        final String userName = Utils.or(request.getParameter("userName"), AnnotationHandler.ANONYMOUS_USERNAME);

        String file = request.getParameter("file");
        String tokenId = request.getParameter("tokenId");

        GroupDocsPath path = null;
        try {
        if (file != null && !file.isEmpty()) {
                path = new EncodedPath(file, annotationHandler.getConfiguration());
        } else if (tokenId != null && !tokenId.isEmpty()) {
            TokenId tki = new TokenId(tokenId, applicationConfig.getEncryptionKey());
            if (!tki.isExpired()) {
                path = tki;
            }
        }
        } catch (NoPermissionException e) {
            e.printStackTrace();
        }
        final String initialPath = (path == null ? "" : path.getPath());

        String userGuid = null;
        try {
            userGuid = annotationHandler.getUserGuid(userName);
            request.setAttribute("annotation_scripts", annotationHandler.getAnnotationScript(initialPath, userName, userGuid));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("annotation/index.jsp");
            requestDispatcher.forward(request, response);
        } catch (AnnotationException e) {
            Logger.getLogger(this.getClass()).error(e);
        }
    }

    /**
     * Do post.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Export document.
     * @param documentGuid the document guid
     * @throws Exception the exception
     */
    public void exportDocument(String documentGuid) throws Exception {
        final IExporter exporter = ApiFactory.createExporter(annotationHandler);
        DaoFactory daoFactory = DaoFactory.create();
        final InputDataHandler inputDataHandler = annotationHandler.getInputDataHandler();
        final GroupDocsFileDescription groupDocsFileDescription = inputDataHandler.getFileDescription(documentGuid);
        try {
            final boolean exportAnnotations = true;
            // Export annotations as not editable (rasterized)
            // At the moment it supports next annotations:
            // Area, Point, Polyline, Resources Redaction, Strikeout, Text, Text Redaction, Underline
            // Opacity in annotations does not support
            final boolean rasterizeAnnotations = true;
            exporter.exportToPdf(daoFactory, groupDocsFileDescription, new FileOutputStream("D:\\test.pdf"), exportAnnotations, rasterizeAnnotations);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
