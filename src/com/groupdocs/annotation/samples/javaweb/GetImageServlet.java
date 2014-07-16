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
public class GetImageServlet extends AnnotationServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "image/png");
        addCORSHeaders(request, response);
        String contextPath = request.getPathInfo();
        String[] path = contextPath.split("/");
        writeOutput((InputStream) annotationHandler.getImageHandler(path[path.length - 1], response), response);
    }
}
