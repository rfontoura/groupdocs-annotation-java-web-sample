package com.groupdocs.annotation.samples.javaweb;


import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.exception.AnnotationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * The type Get file servlet.
 * @author imy
 */
public class GetFileServlet extends AnnotationServlet {
    private static Logger logger = LoggerFactory.getLogger(GetFileServlet.class);

    /**
     * Do get.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        String path = request.getQueryString().split("=")[1];
        try {
            writeOutput((InputStream) annotationHandler.getFileHandler(path, false, response), response);
        } catch (AnnotationException e) {
            logger.error("get file handler", e);
        }
    }
}
