package org.lantern.exceptional4j.contrib;

import org.lantern.exceptional4j.RegexSanitizer;
import org.lantern.exceptional4j.Sanitizer;

/**
 * A {@link Sanitizer} that replaces everything that looks like an IPv4 address
 * with ???.???.???.???.
 */
public class IPv4Sanitizer extends RegexSanitizer {
    private static final String IP_REGEX = "(?:[0-9]{1,3}\\.){3}[0-9]{1,3}";
    private static final String IP_REPLACEMENT = "???.???.???.???";

    public IPv4Sanitizer() {
        super(IP_REGEX, IP_REPLACEMENT);
    }

}
