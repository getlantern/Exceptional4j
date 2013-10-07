package org.lantern.exceptional4j;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.lantern.exceptional4j.contrib.IPv4Sanitizer;

public class SanitizingTest {
    @Test
    public void testSanitizing() {
        final ExceptionalAppender appender =
                new ExceptionalAppender("fake_key", false);
        appender.addSanitizer(new IPv4Sanitizer());
        appender.addSanitizer(new RegexSanitizer("bob", "bubba"));
        final String fqnOfCategoryClass = getClass().getName();
        final Category logger = Logger.getLogger(getClass());
        final Priority level = Level.ERROR;
        final Object message = "Message containing an ip of 192.168.0.1 and an ip of 10.65.1.1 with bob";
        final Object expectedSanitizedMessage = "Message containing an ip of ???.???.???.??? and an ip of ???.???.???.??? with bubba";
        final Throwable throwable = new IOException();
        final LoggingEvent le =
                new LoggingEvent(fqnOfCategoryClass, logger, level, message,
                        throwable);
        JSONObject exceptionData = appender.exceptionData(le);
        String sanitizedMessage = (String) exceptionData.get("message");
        assertEquals(expectedSanitizedMessage, sanitizedMessage);
    }
}
