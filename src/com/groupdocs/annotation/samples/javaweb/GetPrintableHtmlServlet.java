package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.samples.javaweb.media.MediaType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author imy
 */
public class GetPrintableHtmlServlet extends AnnotationServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        writeOutput(MediaType.TEXT_PLAIN, response, annotationHandler.getPrintableHtmlHandler(request, response));
    }
}
