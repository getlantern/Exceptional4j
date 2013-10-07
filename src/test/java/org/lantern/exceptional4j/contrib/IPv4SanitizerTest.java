package org.lantern.exceptional4j.contrib;

import org.junit.Test;
import static org.junit.Assert.*;

public class IPv4SanitizerTest {
    private IPv4Sanitizer sanitizer = new IPv4Sanitizer();

    @Test
    public void testIpsAtBeginning() {
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("1.1.1.1 b"));
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("11.1.1.1 b"));
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("111.1.1.1 b"));
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("111.11.1.1 b"));
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("111.111.1.1 b"));
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("111.111.11.1 b"));
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("111.111.111.1 b"));
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("111.111.111.11 b"));
        assertEquals("???.???.???.??? b",
                sanitizer.sanitize("111.111.111.111 b"));
    }

    @Test
    public void testIpAtEnd() {
        assertEquals("a ???.???.???.???",
                sanitizer.sanitize("a 1.1.1.1"));
    }
    
    @Test
    public void testIpInMiddle() {
        assertEquals("a ???.???.???.??? b",
                sanitizer.sanitize("a 1.1.1.1 b"));
    }
    
    @Test
    public void testMultipleIps() {
        assertEquals("a ???.???.???.??? b ???.???.???.??? c",
                sanitizer.sanitize("a 1.1.1.1 b 2.2.2.2 c"));
    }
}
