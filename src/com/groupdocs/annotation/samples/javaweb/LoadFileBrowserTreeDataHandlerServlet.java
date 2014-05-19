package com.groupdocs.annotation.samples.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author imy
 */
public class LoadFileBrowserTreeDataHandlerServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getOutputStream().write(annotationHandler.loadFileBrowserTreeDataHandler(request, response).toString().getBytes());
    }
}
