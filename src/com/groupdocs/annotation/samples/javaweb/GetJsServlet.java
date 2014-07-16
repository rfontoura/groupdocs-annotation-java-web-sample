package com.groupdocs.annotation.samples.javaweb;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author imy
 */
public class GetJsServlet extends AnnotationServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/javascript");
        addCORSHeaders(request, response);
        writeOutput((InputStream) annotationHandler.getJsHandler(request.getParameter("script"), response), response);
    }
}
