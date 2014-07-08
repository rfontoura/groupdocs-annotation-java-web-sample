package com.groupdocs.annotation.samples.javaweb.media;

/**
 *
 * @author Alex Bobkov
 */
public enum MediaType {
    APPLICATION_JSON("application/json"), TEXT_HTML("text/html"), IMAGE_PNG("image/png"), TEXT_PLAIN("text/plain");
    
    private final String name;

    private MediaType(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
