package com.groupdocs.annotation.samples.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author imy
 */
public class GetFontServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "application/x-font-woff");
        String[] split = request.getRequestURI().split("/");
        if (split.length > 0){
            writeOutput((InputStream) annotationHandler.getFontHandler(split[split.length - 1], response), response);
        }
    }
}
