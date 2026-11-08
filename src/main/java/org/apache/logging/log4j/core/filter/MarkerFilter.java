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

@Plugin(name="MarkerFilter", category="Core", elementType="filter", printObject=true)
public class MarkerFilter
extends AbstractFilter {
    private final String name;

    private MarkerFilter(String string, Filter.Result result, Filter.Result result2) {
        super(result, result2);
        this.name = string;
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object ... objectArray) {
        return this.filter(marker);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Object object, Throwable throwable) {
        return this.filter(marker);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
        return this.filter(marker);
    }

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        return this.filter(logEvent.getMarker());
    }

    private Filter.Result filter(Marker marker) {
        return marker != null && marker.isInstanceOf(this.name) ? this.onMatch : this.onMismatch;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @PluginFactory
    public static MarkerFilter createFilter(@PluginAttribute(value="marker") String string, @PluginAttribute(value="onMatch") String string2, @PluginAttribute(value="onMismatch") String string3) {
        if (string == null) {
            LOGGER.error("A marker must be provided for MarkerFilter");
            return null;
        }
        Filter.Result result = Filter.Result.toResult(string2);
        Filter.Result result2 = Filter.Result.toResult(string3);
        return new MarkerFilter(string, result, result2);
    }
}

