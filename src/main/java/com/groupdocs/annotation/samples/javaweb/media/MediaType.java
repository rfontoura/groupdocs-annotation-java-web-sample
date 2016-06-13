package com.groupdocs.annotation.samples.javaweb.media;

/**
 * The enum Media type.
 * @author Alex Bobkov
 */
public enum MediaType {
    /**
     * Application json media type.
     */
    APPLICATION_JSON("application/json"), /**
     * Text html media type.
     */
    TEXT_HTML("text/html"), /**
     * Image png media type.
     */
    IMAGE_PNG("image/png"), /**
     * Text plain media type.
     */
    TEXT_PLAIN("text/plain");

    private final String name;

    private MediaType(String name) {
        this.name = name;
    }

    /**
     * To string string.
     * @return the string
     */
    @Override
    public String toString() {
        return name;
    }
}
