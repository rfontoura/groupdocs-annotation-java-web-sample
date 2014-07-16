package com.groupdocs.annotation.samples.javaweb;

import static com.groupdocs.annotation.samples.javaweb.AnnotationServlet.annotationHandler;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author imy
 */
public class DeleteAnnotationReplyServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);
        writeOutput(MediaType.APPLICATION_JSON, response, annotationHandler.deleteAnnotationReplyHandler(request, response));
    }
}
