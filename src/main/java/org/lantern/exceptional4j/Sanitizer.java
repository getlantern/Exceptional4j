package org.lantern.exceptional4j;

/**
 * Sanitizes strings before they are sent to Exceptional.
 */
public interface Sanitizer {
    /**
     * Sanitize the given original string.
     * 
     * @param original
     * @return the string to be sent to Exceptional
     */
    String sanitize(String original);
}
