package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.exception.AnnotationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * The type Get css servlet.
 * @author imy
 */
public class GetCssServlet extends AnnotationServlet {
    private static Logger logger = LoggerFactory.getLogger(GetCssServlet.class);
    /**
     * Do get.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/css");
        addCORSHeaders(request, response);
        try {
            writeOutput((InputStream) annotationHandler.getCssHandler(request.getParameter("script"), request, response), response);
        } catch (AnnotationException e) {
            logger.error("get css handler", e);
        }
    }

    /**
     * Do post.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Not required
    }
}
