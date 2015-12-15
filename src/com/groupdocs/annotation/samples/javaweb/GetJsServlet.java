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
 * The type Get js servlet.
 * @author imy
 */
public class GetJsServlet extends AnnotationServlet {
    private static Logger logger = LoggerFactory.getLogger(GetJsServlet.class);
    /**
     * Do get.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/javascript");
        addCORSHeaders(request, response);
        try {
            writeOutput((InputStream) annotationHandler.getJsHandler(request.getParameter("script"), request, response), response);
        } catch (AnnotationException e) {
            logger.error("get js handler", e);
        }
    }
}
