package org.lantern.exceptional4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilities for GetExceptional4j.
 */
public class ExceptionalUtils {
    
    public static final String NO_OP_KEY = "no_op_key";

    /**
     * Encodes date value into ISO8601 that can be compared 
     * lexicographically.
     * 
     * @return string representation of the date value for the current date.
     */
    public static String iso8601() {
        return iso8601(new Date());
    }

    public static String iso8601(final Date date) {
        final SimpleDateFormat dateFormatter = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        // Java doesn't handle ISO8601 nicely: need to add ':' manually
        final String result = dateFormatter.format(date);
        return result.substring(0, result.length() - 2) + ":"
                + result.substring(result.length() - 2);
    }
}
