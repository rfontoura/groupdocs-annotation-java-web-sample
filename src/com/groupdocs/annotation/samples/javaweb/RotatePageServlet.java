package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Aleksey Permyakov (18.11.2014)
 */
public class RotatePageServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        try {
            writeOutput(MediaType.APPLICATION_JSON, response, annotationHandler.rotatePageHandler(request, response));
        } catch (AnnotationException e) {
            Utils.err(AnnotationServlet.class, e);
        }
    }
}
