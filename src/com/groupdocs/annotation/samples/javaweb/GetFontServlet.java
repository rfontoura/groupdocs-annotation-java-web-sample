package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.exception.AnnotationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * The type Get font servlet.
 * @author imy
 */
public class GetFontServlet extends AnnotationServlet {

    /**
     * Do get.
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "application/x-font-woff");
        addCORSHeaders(request, response);
        String[] split = request.getRequestURI().split("/");
        if (split.length > 0) {
            try {
                writeOutput((InputStream) annotationHandler.getFontHandler(split[split.length - 1], request, response), response);
            } catch (AnnotationException e) {
                Utils.err(AnnotationServlet.class, e);
            }
        }
    }
}
