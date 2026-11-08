/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.filter;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.core.helpers.KeyValuePair;
import org.apache.logging.log4j.message.Message;

@Plugin(name="DynamicThresholdFilter", category="Core", elementType="filter", printObject=true)
public class DynamicThresholdFilter
extends AbstractFilter {
    private Map<String, Level> levelMap = new HashMap<String, Level>();
    private Level defaultThreshold = Level.ERROR;
    private final String key;

    private DynamicThresholdFilter(String string, Map<String, Level> map, Level level, Filter.Result result, Filter.Result result2) {
        super(result, result2);
        if (string == null) {
            throw new NullPointerException("key cannot be null");
        }
        this.key = string;
        this.levelMap = map;
        this.defaultThreshold = level;
    }

    public String getKey() {
        return this.key;
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
        String string = ThreadContext.get(this.key);
        if (string != null) {
            Level level2 = this.levelMap.get(string);
            if (level2 == null) {
                level2 = this.defaultThreshold;
            }
            return level.isAtLeastAsSpecificAs(level2) ? this.onMatch : this.onMismatch;
        }
        return Filter.Result.NEUTRAL;
    }

    public Map<String, Level> getLevelMap() {
        return this.levelMap;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key=").append(this.key);
        stringBuilder.append(", default=").append((Object)this.defaultThreshold);
        if (this.levelMap.size() > 0) {
            stringBuilder.append("{");
            boolean bl = true;
            for (Map.Entry<String, Level> entry : this.levelMap.entrySet()) {
                if (!bl) {
                    stringBuilder.append(", ");
                    bl = false;
                }
                stringBuilder.append(entry.getKey()).append("=").append((Object)entry.getValue());
            }
            stringBuilder.append("}");
        }
        return stringBuilder.toString();
    }

    @PluginFactory
    public static DynamicThresholdFilter createFilter(@PluginAttribute(value="key") String string, @PluginElement(value="Pairs") KeyValuePair[] keyValuePairArray, @PluginAttribute(value="defaultThreshold") String string2, @PluginAttribute(value="onMatch") String string3, @PluginAttribute(value="onMismatch") String string4) {
        Filter.Result result = Filter.Result.toResult(string3);
        Filter.Result result2 = Filter.Result.toResult(string4);
        HashMap<String, Level> hashMap = new HashMap<String, Level>();
        for (KeyValuePair keyValuePair : keyValuePairArray) {
            hashMap.put(keyValuePair.getKey(), Level.toLevel(keyValuePair.getValue()));
        }
        Level level = Level.toLevel(string2, Level.ERROR);
        return new DynamicThresholdFilter(string, hashMap, level, result, result2);
    }
}

