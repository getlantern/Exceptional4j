package org.lantern.exceptional4j;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;

/**
 * Tests sending an error to GetExceptional. Be sure to fill in your API key!
 */
public class ExceptionalAppenderTest {
    
    private static final String API_KEY = "";

    @Test public void testGetExceptionalAppender() {
        if (StringUtils.isBlank(API_KEY)) {
            System.err.println("Cannot run test with a blank API key");
            return;
        }
        final ExceptionalAppender appender = 
            new ExceptionalAppender(API_KEY, false);
        final String fqnOfCategoryClass = getClass().getName();
        final Category logger = Logger.getLogger(getClass());
        final Priority level = Level.ERROR;
        final Object message = "different error";
        final Throwable throwable = new IOException();
        final LoggingEvent le = 
            new LoggingEvent(fqnOfCategoryClass, logger, level, message, throwable);
        appender.append(le);
    }
}
