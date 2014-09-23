package com.groupdocs.annotation.samples.javaweb;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author imy
 */
public class GetPrintDocumentPageImageServlet extends AnnotationServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        boolean usePdf = Boolean.valueOf(request.getParameter("usePdf"));
        int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
        String path = request.getParameter("path");
        Object o = annotationHandler.getPrintDocumentPageImageHandler(path, usePdf, pageIndex, response);
        if (o instanceof InputStream) {
            writeOutput((InputStream) o, response);
        }
    }
}