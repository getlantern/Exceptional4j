package org.lantern.exceptional4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sanitizer that sanitizes content by replacing occurrences of a regex with a
 * static string.
 */
public class RegexSanitizer implements Sanitizer {
    private final Pattern pattern;
    private final String replacement;

    /**
     * 
     * @param regex
     *            the regex
     * @param replacement
     *            the string with which to replace occurrences of the regex
     */
    public RegexSanitizer(String regex, String replacement) {
        super();
        this.pattern = Pattern.compile(regex);
        this.replacement = replacement;
    }

    @Override
    public String sanitize(String original) {
        Matcher matcher = pattern.matcher(original);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
