package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.config.ServiceConfiguration;
import com.groupdocs.annotation.handler.AnnotationHandler;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author imy
 */
public abstract class AnnotationServlet extends HttpServlet {

    protected AnnotationHandler annotationHandler = null;

    @Override
    public void init() throws ServletException {
        try {
            final String appPath = "http://127.0.0.1:8080/document-annotation";
            final String basePath = "G:\\imyFolder\\workshop\\GroupDocs\\Files";
            final String licensePath = null;
            final ServiceConfiguration annotationConfig
                    = new ServiceConfiguration(appPath, basePath, licensePath, Boolean.FALSE);
            annotationHandler = new AnnotationHandler(annotationConfig);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex);
        }
    }

    @Override
    public abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    @Override
    public abstract void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
