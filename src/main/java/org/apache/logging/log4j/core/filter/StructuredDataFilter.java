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
import org.apache.logging.log4j.core.filter.MapFilter;
import org.apache.logging.log4j.core.helpers.KeyValuePair;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.StructuredDataMessage;

@Plugin(name="StructuredDataFilter", category="Core", elementType="filter", printObject=true)
public class StructuredDataFilter
extends MapFilter {
    private StructuredDataFilter(Map<String, List<String>> map, boolean bl, Filter.Result result, Filter.Result result2) {
        super(map, bl, result, result2);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
        if (message instanceof StructuredDataMessage) {
            return this.filter((StructuredDataMessage)message);
        }
        return Filter.Result.NEUTRAL;
    }

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        Message message = logEvent.getMessage();
        if (message instanceof StructuredDataMessage) {
            return this.filter((StructuredDataMessage)message);
        }
        return super.filter(logEvent);
    }

    protected Filter.Result filter(StructuredDataMessage structuredDataMessage) {
        boolean bl = false;
        for (Map.Entry<String, List<String>> entry : this.getMap().entrySet()) {
            String string = this.getValue(structuredDataMessage, entry.getKey());
            bl = string != null ? entry.getValue().contains(string) : false;
            if ((this.isAnd() || !bl) && (!this.isAnd() || bl)) continue;
            break;
        }
        return bl ? this.onMatch : this.onMismatch;
    }

    private String getValue(StructuredDataMessage structuredDataMessage, String string) {
        if (string.equalsIgnoreCase("id")) {
            return structuredDataMessage.getId().toString();
        }
        if (string.equalsIgnoreCase("id.name")) {
            return structuredDataMessage.getId().getName();
        }
        if (string.equalsIgnoreCase("type")) {
            return structuredDataMessage.getType();
        }
        if (string.equalsIgnoreCase("message")) {
            return structuredDataMessage.getFormattedMessage();
        }
        return structuredDataMessage.getData().get(string);
    }

    @PluginFactory
    public static StructuredDataFilter createFilter(@PluginElement(value="Pairs") KeyValuePair[] keyValuePairArray, @PluginAttribute(value="operator") String string, @PluginAttribute(value="onMatch") String string2, @PluginAttribute(value="onMismatch") String string3) {
        if (keyValuePairArray == null || keyValuePairArray.length == 0) {
            LOGGER.error("keys and values must be specified for the StructuredDataFilter");
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
            LOGGER.error("StructuredDataFilter is not configured with any valid key value pairs");
            return null;
        }
        boolean bl = string == null || !string.equalsIgnoreCase("or");
        Filter.Result result = Filter.Result.toResult(string2);
        Filter.Result result2 = Filter.Result.toResult(string3);
        return new StructuredDataFilter(hashMap, bl, result, result2);
    }
}

