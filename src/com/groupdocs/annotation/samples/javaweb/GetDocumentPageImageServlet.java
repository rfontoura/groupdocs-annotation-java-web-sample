package com.groupdocs.annotation.samples.javaweb;


import com.groupdocs.annotation.common.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


/**
 * The type Get document page image servlet.
 * @author imy
 */
public class GetDocumentPageImageServlet extends AnnotationServlet {
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
        int width = Integer.parseInt(request.getParameter("width"));
        int quality = Integer.valueOf(request.getParameter("quality"));
        boolean usePdf = Boolean.valueOf(request.getParameter("usePdf"));
        int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
        boolean isPrint = Boolean.valueOf(request.getParameter("isPrint"));

        String watermarkPosition = request.getParameter("watermarkPosition");
        Integer watermarkFontSize = Integer.valueOf(request.getParameter("watermarkFontSize"));
        Boolean useHtmlBasedEngine = Boolean.valueOf(request.getParameter("useHtmlBasedEngine"));
        Boolean rotate = Boolean.valueOf(request.getParameter("rotate"));

        String path = request.getParameter("path");
        Object o = null;
        try {
            o = annotationHandler.getDocumentPageImageHandler(path, width, quality, usePdf, pageIndex, isPrint, watermarkPosition, watermarkFontSize, useHtmlBasedEngine, rotate, response);
        } catch (Exception e) {
            Utils.err(AnnotationServlet.class, e);
        }
        if (o instanceof InputStream) {
            writeOutput((InputStream) o, response);
        }
    }
}
