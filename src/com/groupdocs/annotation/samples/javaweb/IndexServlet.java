package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.domain.AccessRights;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.viewer.domain.path.EncodedPath;
import com.groupdocs.viewer.domain.path.GroupDocsPath;
import com.groupdocs.viewer.domain.path.TokenId;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author imy
 */
public class IndexServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        request.setAttribute("annotation_head", annotationHandler.getHeader(applicationConfig.getApplicationPath(), request));
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
            userGuid = annotationHandler.addCollaborator(userName, initialPath, AccessRights.All.value(), Utils.colorToInt(Color.RED));
        } catch (AnnotationException e) {
            Logger.getLogger(this.getClass()).error(e);
        }
        request.setAttribute("annotation_scripts", annotationHandler.getAnnotationScript(initialPath, userName, userGuid));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("annotation/index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
