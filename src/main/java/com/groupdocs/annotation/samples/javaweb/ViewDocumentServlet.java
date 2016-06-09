package com.groupdocs.annotation.samples.javaweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupdocs.annotation.samples.javaweb.media.MediaType;

/**
 * @author imy
 */
public class ViewDocumentServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        configureApplicationPath(request);
        writeOutput(MediaType.APPLICATION_JSON, response, annotationHandler.viewDocumentHandler(request, response));
    }
}
