package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.handler.AnnotationHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author imy
 */
public class GetJsServlet extends AnnotationServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/javascript");
        addCORSHeaders(request, response);
        long dateSince = request.getDateHeader("If-Modified-Since");
        if (annotationHandler.isResourceModified(dateSince)) {
            response.setDateHeader("Last-Modified", AnnotationHandler.LAST_RESOURCE_MODIFIED);
            writeOutput((InputStream) annotationHandler.getJsHandler(request.getParameter("script"), response), response);
        } else {
            response.setStatus(304);
        }
    }
}
