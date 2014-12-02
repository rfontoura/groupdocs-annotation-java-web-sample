package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.localization.ILocalization;
import com.groupdocs.annotation.localization.LocalizationRU;
import com.groupdocs.annotation.samples.localization.LocalizationGE;
import com.groupdocs.viewer.domain.path.EncodedPath;
import com.groupdocs.viewer.domain.path.GroupDocsPath;
import com.groupdocs.viewer.domain.path.TokenId;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author imy
 */
public class IndexServlet extends AnnotationServlet {

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

        if (file == null && tokenId == null) {
            file = new File(applicationConfig.getBasePath() + "/GroupDocs_Demo.doc").getAbsolutePath();
        }
        GroupDocsPath path = null;
        if (file != null && !file.isEmpty()) {
            path = new EncodedPath(file, annotationHandler.getConfiguration());
        } else if (tokenId != null && !tokenId.isEmpty()) {
            TokenId tki = new TokenId(tokenId, applicationConfig.getEncryptionKey());
            if (!tki.isExpired()) {
                path = tki;
            }
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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
