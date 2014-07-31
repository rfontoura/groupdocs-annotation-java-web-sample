package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.domain.AccessRights;
import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.utils.Utils;
import com.groupdocs.viewer.domain.path.EncodedPath;
import com.groupdocs.viewer.domain.path.GroupDocsPath;
import com.groupdocs.viewer.domain.path.TokenId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author imy
 */
public class IndexServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        request.setAttribute("annotation_head", annotationHandler.getHeader());
        final String userName = Utils.or(request.getParameter("userName"), AnnotationHandler.ANONIMOUS_USERNAME);

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

        final String userGuid = annotationHandler.addCollaborator(userName, initialPath, AccessRights.All.value(), getIntFromColor(Color.RED));
        request.setAttribute("annotation_scripts", annotationHandler.getAnnotationScript(null, initialPath, userName, userGuid));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("annotation/index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getIntFromColor(Color color) {
        return getIntFromColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    public int getIntFromColor(float red, float green, float blue) {
        int R = Math.round(255 * red);
        int G = Math.round(255 * green);
        int B = Math.round(255 * blue);

        R = (R << 16) & 0x00FF0000;
        G = (G << 8) & 0x0000FF00;
        B = B & 0x000000FF;

        return 0xFF000000 | R | G | B;
    }
}
