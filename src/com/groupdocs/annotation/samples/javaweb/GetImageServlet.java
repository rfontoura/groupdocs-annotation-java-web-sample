package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.exception.AnnotationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * The type Get image servlet.
 * @author imy
 */
public class GetImageServlet extends AnnotationServlet {
    /**
     * Do get.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "image/png");
        addCORSHeaders(request, response);
        String contextPath = request.getPathInfo();
        String[] path = contextPath.split("/");
        try {
            writeOutput((InputStream) annotationHandler.getImageHandler(path[path.length - 1], request, response), response);
        } catch (AnnotationException e) {
            e.printStackTrace();
        }
    }
}
