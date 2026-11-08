/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

@Plugin(name="RegexFilter", category="Core", elementType="filter", printObject=true)
public class RegexFilter
extends AbstractFilter {
    private final Pattern pattern;
    private final boolean useRawMessage;

    private RegexFilter(boolean bl, Pattern pattern, Filter.Result result, Filter.Result result2) {
        super(result, result2);
        this.pattern = pattern;
        this.useRawMessage = bl;
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object ... objectArray) {
        return this.filter(string);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Object object, Throwable throwable) {
        if (object == null) {
            return this.onMismatch;
        }
        return this.filter(object.toString());
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
        if (message == null) {
            return this.onMismatch;
        }
        String string = this.useRawMessage ? message.getFormat() : message.getFormattedMessage();
        return this.filter(string);
    }

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        String string = this.useRawMessage ? logEvent.getMessage().getFormat() : logEvent.getMessage().getFormattedMessage();
        return this.filter(string);
    }

    private Filter.Result filter(String string) {
        if (string == null) {
            return this.onMismatch;
        }
        Matcher matcher = this.pattern.matcher(string);
        return matcher.matches() ? this.onMatch : this.onMismatch;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("useRaw=").append(this.useRawMessage);
        stringBuilder.append(", pattern=").append(this.pattern.toString());
        return stringBuilder.toString();
    }

    @PluginFactory
    public static RegexFilter createFilter(@PluginAttribute(value="regex") String string, @PluginAttribute(value="useRawMsg") String string2, @PluginAttribute(value="onMatch") String string3, @PluginAttribute(value="onMismatch") String string4) {
        Pattern pattern;
        if (string == null) {
            LOGGER.error("A regular expression must be provided for RegexFilter");
            return null;
        }
        boolean bl = Boolean.parseBoolean(string2);
        try {
            pattern = Pattern.compile(string);
        }
        catch (Exception exception) {
            LOGGER.error("RegexFilter caught exception compiling pattern: " + string + " cause: " + exception.getMessage());
            return null;
        }
        Filter.Result result = Filter.Result.toResult(string3);
        Filter.Result result2 = Filter.Result.toResult(string4);
        return new RegexFilter(bl, pattern, result, result2);
    }
}

