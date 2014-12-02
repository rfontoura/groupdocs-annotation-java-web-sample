package com.groupdocs.annotation.samples.javaweb;

import com.groupdocs.annotation.domain.response.StatusResult;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.media.MediaType;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.groupdocs.annotation.common.Utils.toJson;

/**
 * @author Aleksey Permyakov (16.07.14).
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadFileServlet extends AnnotationServlet {
    /**
     * GET request
     *
     * @param request  object
     * @param response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * POST request
     *
     * @param request  object
     * @param response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addCORSHeaders(request, response);

        String uploadFileName;
        InputStream uploadInputStream;
        Collection<Part> parts = request.getParts();
        if (parts.size() > 0) {
            Part part = parts.iterator().next();
            uploadFileName = extractFileName(part);
            File tempFile = File.createTempFile("annotation-upload", "_" + uploadFileName);
            part.write(tempFile.getAbsolutePath());
            uploadInputStream = new FileInputStream(tempFile);

            try {
                writeOutput(MediaType.APPLICATION_JSON, response, annotationHandler.uploadFileHandler(uploadFileName, uploadInputStream));
            } catch (AnnotationException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, MESSAGE_HANDLER_THROWS, e.getMessage());
                writeOutput(MediaType.APPLICATION_JSON, response, toJson(new StatusResult(false, e.getMessage())));
            }
        }
    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
    }
}
