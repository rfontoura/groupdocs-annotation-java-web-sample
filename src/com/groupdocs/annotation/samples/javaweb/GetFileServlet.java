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
public class GetFileServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        String path = request.getQueryString().split("=")[1];
        try {
            writeOutput((InputStream) annotationHandler.getFileHandler(path, false, response), response);
        } catch (AnnotationException e) {
            Utils.log(AnnotationServlet.class, e);
        }
    }
}
