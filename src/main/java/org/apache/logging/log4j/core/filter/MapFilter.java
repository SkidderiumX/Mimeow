/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.core.helpers.KeyValuePair;
import org.apache.logging.log4j.message.MapMessage;
import org.apache.logging.log4j.message.Message;

@Plugin(name="MapFilter", category="Core", elementType="filter", printObject=true)
public class MapFilter
extends AbstractFilter {
    private final Map<String, List<String>> map;
    private final boolean isAnd;

    protected MapFilter(Map<String, List<String>> map, boolean bl, Filter.Result result, Filter.Result result2) {
        super(result, result2);
        if (map == null) {
            throw new NullPointerException("key cannot be null");
        }
        this.isAnd = bl;
        this.map = map;
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
        if (message instanceof MapMessage) {
            return this.filter(((MapMessage)message).getData()) ? this.onMatch : this.onMismatch;
        }
        return Filter.Result.NEUTRAL;
    }

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        Message message = logEvent.getMessage();
        if (message instanceof MapMessage) {
            return this.filter(((MapMessage)message).getData()) ? this.onMatch : this.onMismatch;
        }
        return Filter.Result.NEUTRAL;
    }

    protected boolean filter(Map<String, String> map) {
        boolean bl = false;
        for (Map.Entry<String, List<String>> entry : this.map.entrySet()) {
            String string = map.get(entry.getKey());
            bl = string != null ? entry.getValue().contains(string) : false;
            if ((this.isAnd || !bl) && (!this.isAnd || bl)) continue;
            break;
        }
        return bl;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isAnd=").append(this.isAnd);
        if (this.map.size() > 0) {
            stringBuilder.append(", {");
            boolean bl = true;
            for (Map.Entry<String, List<String>> entry : this.map.entrySet()) {
                if (!bl) {
                    stringBuilder.append(", ");
                }
                bl = false;
                List<String> list = entry.getValue();
                String string = list.size() > 1 ? list.get(0) : list.toString();
                stringBuilder.append(entry.getKey()).append("=").append(string);
            }
            stringBuilder.append("}");
        }
        return stringBuilder.toString();
    }

    protected boolean isAnd() {
        return this.isAnd;
    }

    protected Map<String, List<String>> getMap() {
        return this.map;
    }

    @PluginFactory
    public static MapFilter createFilter(@PluginElement(value="Pairs") KeyValuePair[] keyValuePairArray, @PluginAttribute(value="operator") String string, @PluginAttribute(value="onMatch") String string2, @PluginAttribute(value="onMismatch") String string3) {
        if (keyValuePairArray == null || keyValuePairArray.length == 0) {
            LOGGER.error("keys and values must be specified for the MapFilter");
            return null;
        }
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (KeyValuePair keyValuePair : keyValuePairArray) {
            String string4 = keyValuePair.getKey();
            if (string4 == null) {
                LOGGER.error("A null key is not valid in MapFilter");
                continue;
            }
            String string5 = keyValuePair.getValue();
            if (string5 == null) {
                LOGGER.error("A null value for key " + string4 + " is not allowed in MapFilter");
                continue;
            }
            ArrayList<String> arrayList = (ArrayList<String>)hashMap.get(keyValuePair.getKey());
            if (arrayList != null) {
                arrayList.add(string5);
                continue;
            }
            arrayList = new ArrayList<String>();
            arrayList.add(string5);
            hashMap.put(keyValuePair.getKey(), arrayList);
        }
        if (hashMap.size() == 0) {
            LOGGER.error("MapFilter is not configured with any valid key value pairs");
            return null;
        }
        boolean bl = string == null || !string.equalsIgnoreCase("or");
        Filter.Result result = Filter.Result.toResult(string2);
        Filter.Result result2 = Filter.Result.toResult(string3);
        return new MapFilter(hashMap, bl, result, result2);
    }
}

