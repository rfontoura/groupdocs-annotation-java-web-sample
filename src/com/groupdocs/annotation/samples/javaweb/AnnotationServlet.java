package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.handler.AnnotationHandler;
import com.groupdocs.annotation.samples.javaweb.config.ApplicationConfig;
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
import java.util.Properties;

/**
 * @author imy
 */
public abstract class AnnotationServlet extends HttpServlet {
    protected static AnnotationHandler annotationHandler = null;
    protected static ApplicationConfig applicationConfig;
    protected static ServiceConfiguration serviceConfiguration;
    private final String DEFAULT_ENCODING = "UTF-8";

    public static AnnotationHandler getAnnotationHandler() {
        return annotationHandler;
    }

    @Override
    public void init() throws ServletException {
        InputStream resourceStreamAux = getServletContext().getResourceAsStream("WEB-INF/application.properties");
        try {
            if (annotationHandler == null) {
                Properties properties = new Properties();
                properties.load(resourceStreamAux);
                applicationConfig = new ApplicationConfig(
                        properties.getProperty("applicationPath"),
                        properties.getProperty("basePath"),
                        properties.getProperty("licensePath"),
                        properties.getProperty("dbDriver"),
                        properties.getProperty("dbConnection"));
                serviceConfiguration = new ServiceConfiguration(applicationConfig);
//                annotationHandler = new AnnotationHandler(serviceConfiguration, null, new CustomDatabaseConnector(applicationConfig));
                annotationHandler = new AnnotationHandler(serviceConfiguration);
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass()).error(ex);
        } finally {
            Utils.closeStreams(resourceStreamAux);
        }
    }

    protected void writeOutput(MediaType contentType, HttpServletResponse response, Object object) throws IOException {
        String json = (String) object;
        if (contentType != null && !contentType.toString().isEmpty()) {
            response.setContentType(contentType.toString());
        }
        response.getOutputStream().write(json.getBytes(DEFAULT_ENCODING));
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
}
