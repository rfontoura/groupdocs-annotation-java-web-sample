package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        try {
            writeOutput(MediaType.APPLICATION_JSON, response, annotationHandler.importAnnotationsHandler(request, response));
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
