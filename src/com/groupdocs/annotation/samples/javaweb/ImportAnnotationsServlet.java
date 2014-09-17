package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.domain.AccessRights;
import com.groupdocs.annotation.domain.request.ImportAnnotationsRequest;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;
import com.groupdocs.annotation.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * @author Aleksey Permyakov (16.07.14).
 */
public class ImportAnnotationsServlet extends AnnotationServlet {
    /**
     * POST request
     *
     * @param request  object
     * @param response object
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        ImportAnnotationsRequest importAnnotationsRequest = null;
        try {
            importAnnotationsRequest = Utils.getObjectData(Utils.getBody(request), ImportAnnotationsRequest.class);
            String fileGuid = importAnnotationsRequest.getFileGuid();
            String userGuid = importAnnotationsRequest.getUserId();
            annotationHandler.addCollaboratorByGuid(
                    userGuid,
                    fileGuid,
                    AccessRights.All,
                    Utils.colorToInt(Color.black)
            );
        } catch (AnnotationException e) {
            e.printStackTrace(); // Logger
        }
        writeOutput(MediaType.APPLICATION_JSON, response, annotationHandler.importAnnotationsHandler(importAnnotationsRequest));
    }

    /**
     * GET request
     *
     * @param request  object
     * @param response object
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
