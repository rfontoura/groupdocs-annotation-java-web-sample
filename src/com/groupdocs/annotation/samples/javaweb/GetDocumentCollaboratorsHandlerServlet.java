package com.groupdocs.annotation.samples.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aleksey Permyakov on 27.05.14.
 */
public class GetDocumentCollaboratorsHandlerServlet extends AnnotationServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getOutputStream().write(annotationHandler.getDocumentCollaboratorsHandler(request, response).toString().getBytes());
    }
}
