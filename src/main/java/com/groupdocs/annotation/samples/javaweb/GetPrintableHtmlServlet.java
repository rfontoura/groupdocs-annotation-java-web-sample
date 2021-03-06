package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Get printable html servlet.
 * @author imy
 */
public class GetPrintableHtmlServlet extends AnnotationServlet {
    private static Logger logger = LoggerFactory.getLogger(GetPrintableHtmlServlet.class);

    /**
     * Do get.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
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
            writeOutput(MediaType.TEXT_PLAIN, response, annotationHandler.getPrintableHtmlHandler(request, response));
        } catch (AnnotationException e) {
            logger.error("get printable html handler", e);
        }
    }
}
