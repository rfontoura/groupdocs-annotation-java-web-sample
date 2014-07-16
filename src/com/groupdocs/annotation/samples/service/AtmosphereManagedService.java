package com.groupdocs.annotation.samples.service;

import com.groupdocs.annotation.samples.javaweb.AnnotationServlet;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Post;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;

/**
 * @author Aleksey Permyakov (16.07.14).
 */
@ManagedService(path = "/annotation")
public class AtmosphereManagedService {

    /**
     * On ready handler
     *
     * @param resource resource data received from socket
     */
    @Ready
    public void onReady(final AtmosphereResource resource) {
        AnnotationServlet.getAnnotationHandler().onAtmosphereReady(resource);
    }

    /**
     * On message handler [POST]
     *
     * @param resource resource data received from socket
     */
    @Post
    @Message
    public void onMessage(AtmosphereResource resource) {
        AnnotationServlet.getAnnotationHandler().onAtmosphereMessage(resource);
    }
}
