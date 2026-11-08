/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.filter;

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

@Plugin(name="ThresholdFilter", category="Core", elementType="filter", printObject=true)
public class ThresholdFilter
extends AbstractFilter {
    private final Level level;

    private ThresholdFilter(Level level, Filter.Result result, Filter.Result result2) {
        super(result, result2);
        this.level = level;
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object ... objectArray) {
        return this.filter(level);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Object object, Throwable throwable) {
        return this.filter(level);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
        return this.filter(level);
    }

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        return this.filter(logEvent.getLevel());
    }

    private Filter.Result filter(Level level) {
        return level.isAtLeastAsSpecificAs(this.level) ? this.onMatch : this.onMismatch;
    }

    @Override
    public String toString() {
        return this.level.toString();
    }

    @PluginFactory
    public static ThresholdFilter createFilter(@PluginAttribute(value="level") String string, @PluginAttribute(value="onMatch") String string2, @PluginAttribute(value="onMismatch") String string3) {
        Level level = Level.toLevel(string, Level.ERROR);
        Filter.Result result = Filter.Result.toResult(string2, Filter.Result.NEUTRAL);
        Filter.Result result2 = Filter.Result.toResult(string3, Filter.Result.DENY);
        return new ThresholdFilter(level, result, result2);
    }
}

