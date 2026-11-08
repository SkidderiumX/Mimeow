/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.regex.Pattern;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="replace", category="Core", printObject=true)
public class RegexReplacement {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final Pattern pattern;
    private final String substitution;

    private RegexReplacement(Pattern pattern, String string) {
        this.pattern = pattern;
        this.substitution = string;
    }

    public String format(String string) {
        return this.pattern.matcher(string).replaceAll(this.substitution);
    }

    public String toString() {
        return "replace(regex=" + this.pattern.pattern() + ", replacement=" + this.substitution + ")";
    }

    @PluginFactory
    public static RegexReplacement createRegexReplacement(@PluginAttribute(value="regex") String string, @PluginAttribute(value="replacement") String string2) {
        if (string == null) {
            LOGGER.error("A regular expression is required for replacement");
            return null;
        }
        if (string2 == null) {
            LOGGER.error("A replacement string is required to perform replacement");
        }
        Pattern pattern = Pattern.compile(string);
        return new RegexReplacement(pattern, string2);
    }
}

