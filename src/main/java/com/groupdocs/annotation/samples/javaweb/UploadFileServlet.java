package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.domain.response.StatusResult;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.groupdocs.annotation.common.Utils.toJson;

/**
 * The type Upload file servlet.
 * @author Aleksey Permyakov (16.07.14).
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadFileServlet extends AnnotationServlet {
    /**
     * GET request
     * @param request  object
     * @param response object
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * POST request
     * @param request  object
     * @param response object
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);

        String uploadFileName;
        uploadFileName = request.getParameter("fileName");
        File tempFile = File.createTempFile("annotation-upload", "_" + uploadFileName);
        FileOutputStream outputStream = null;
        InputStream uploadInputStream = null;
        try {
            outputStream = new FileOutputStream(tempFile);
            uploadInputStream = new FileInputStream(tempFile);
            IOUtils.copy(request.getInputStream(), outputStream);
            writeOutput(MediaType.APPLICATION_JSON, response, annotationHandler.uploadFileHandler(uploadFileName, uploadInputStream));
        } catch (AnnotationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, MESSAGE_HANDLER_THROWS, e.getMessage());
            writeOutput(MediaType.APPLICATION_JSON, response, toJson(new StatusResult(false, e.getMessage())));
        }
    }
}
