package com.groupdocs.annotation.samples.service;

import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.annotation.samples.javaweb.AnnotationServlet;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Post;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aleksey Permyakov (16.07.14).
 */
@ManagedService(path = "/annotation")
public class AtmosphereManagedService {
    private static final String MESSAGE_HANDLER_THROWS = "Handler throws exception: {0}";

    /**
     * On ready handler
     *
     * @param resource resource data received from socket
     */
    @Ready
    public void onReady(final AtmosphereResource resource) {
        try {
            AnnotationServlet.getAnnotationHandler().onAtmosphereReady(resource);
        } catch (AnnotationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, MESSAGE_HANDLER_THROWS, e.getMessage());
        }
    }

    /**
     * On message handler [POST]
     *
     * @param resource resource data received from socket
     */
    @Post
    @Message
    public void onMessage(AtmosphereResource resource) {
        try {
            AnnotationServlet.getAnnotationHandler().onAtmosphereMessage(resource);
        } catch (AnnotationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, MESSAGE_HANDLER_THROWS, e.getMessage());
        }
    }
}
