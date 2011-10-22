package org.lantern.exceptional4j;

import org.apache.log4j.spi.LoggingEvent;
import org.json.simple.JSONObject;

/**
 * Interface for making callbacks prior to sending data to GetExceptional.
 */
public interface ExceptionalAppenderCallback {

    /**
     * Allows the creator of a GetExceptional log4j appender to add arbitrary
     * data or edit existing data prior to the exception being reported.
     * 
     * @param json The data for submission.
     * @param le The data about the logging event, allowing you to not submit
     * the log if desired.
     * @return <code>true</code> if the bug should be submitted, otherwise
     * <code>false</code>.
     */
    boolean addData(JSONObject json, LoggingEvent le);
}
