package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Rotate page servlet.
 * @author Aleksey Permyakov (18.11.2014)
 */
public class RotatePageServlet extends AnnotationServlet {
    private static Logger logger = LoggerFactory.getLogger(RotatePageServlet.class);

    /**
     * Do get.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
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
        addCORSHeaders(request, response);
        try {
            writeOutput(MediaType.APPLICATION_JSON, response, annotationHandler.rotatePageHandler(request, response));
        } catch (AnnotationException e) {
            logger.error("rotate page handler", e);
        }
    }
}
