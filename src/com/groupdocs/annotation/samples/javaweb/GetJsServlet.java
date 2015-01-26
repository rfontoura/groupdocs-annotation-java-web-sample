package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.exception.AnnotationException;

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
        try {
            writeOutput((InputStream) annotationHandler.getJsHandler(request.getParameter("script"), response), response);
        } catch (AnnotationException e) {
            Utils.log(AnnotationServlet.class, e);
        }
    }
}
