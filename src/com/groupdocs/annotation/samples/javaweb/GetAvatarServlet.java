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
public class GetAvatarServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        writeOutput(MediaType.IMAGE_PNG, response, annotationHandler.getAvatarHandler(request, response, "Anonimous"));
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
