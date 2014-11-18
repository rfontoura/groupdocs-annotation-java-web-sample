package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.domain.request.ImportAnnotationsData;
import com.groupdocs.annotation.enums.AccessRights;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;

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
        ImportAnnotationsData importAnnotationsData;
        try {
            importAnnotationsData = Utils.getObjectData(Utils.getBody(request), ImportAnnotationsData.class);
            String fileGuid = importAnnotationsData.getFileGuid();
            String userGuid = importAnnotationsData.getUserId();
            annotationHandler.addCollaboratorByGuid(
                    userGuid,
                    fileGuid,
                    AccessRights.All,
//                AccessRights.from(
//                        AccessRights.CAN_VIEW,
//                        AccessRights.CAN_ANNOTATE,
//                        AccessRights.CAN_EXPORT,
//                        AccessRights.CAN_DOWNLOAD,
//                        AccessRights.CAN_DELETE
//                ),
                    Utils.colorToInt(Color.black));
            writeOutput(MediaType.APPLICATION_JSON, response, Utils.toJson(annotationHandler.importAnnotations(importAnnotationsData)));
        } catch (AnnotationException e) {
            e.printStackTrace(); // Logger
        }
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
