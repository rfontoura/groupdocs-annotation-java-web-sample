package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;
import com.groupdocs.annotation.utils.Utils;
import com.groupdocs.viewer.config.ServiceConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author imy
 */
public abstract class AnnotationServlet extends HttpServlet {
    private final String DEFAULT_ENCODING = "UTF-8";
    protected static AnnotationHandler annotationHandler = null;
    protected final String appPath = "http://127.0.0.1:8080/document-annotation";
    protected final String basePath = "E:\\Projects\\GroupDocs\\app\\xFiles";
    protected static ApplicationConfig applicationConfig;
    protected static ServiceConfiguration serviceConfiguration;

    @Override
    public void init() throws ServletException {
        try {
            if (annotationHandler == null) {
                applicationConfig = new ApplicationConfig(appPath, basePath);
                serviceConfiguration = new ServiceConfiguration(applicationConfig);
                annotationHandler = new AnnotationHandler(serviceConfiguration);
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex);
        }
    }

    protected void writeOutput(MediaType contentType, HttpServletResponse response, Object object) throws IOException {
        String json = (String) object;
        response.getOutputStream().write(json.getBytes(DEFAULT_ENCODING));
        if (contentType != null && !contentType.toString().isEmpty()) {
            response.setContentType(contentType.toString());
        }
    }

    protected void writeOutput(InputStream inputStream, HttpServletResponse response) throws IOException {
        if (inputStream == null) {
            Logger.getLogger(this.getClass()).error("inputStream is null");
        }
        IOUtils.copy(inputStream, response.getOutputStream());
        Utils.closeStreams(inputStream, response.getOutputStream());
    }

    protected void addCORSHeaders(HttpServletRequest request, HttpServletResponse response) {
        String origin = request.getHeader("origin");
        if (origin == null || "".equals(origin)) {
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "X-Requested-With,Origin,Content-Type, Accept");
    }

    public static AnnotationHandler getAnnotationHandler() {
        return annotationHandler;
    }
}
