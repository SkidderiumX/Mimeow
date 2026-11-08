/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import org.apache.logging.log4j.core.filter.MapFilter;
import org.apache.logging.log4j.core.helpers.KeyValuePair;
import org.apache.logging.log4j.message.Message;

@Plugin(name="ThreadContextMapFilter", category="Core", elementType="filter", printObject=true)
public class ThreadContextMapFilter
extends MapFilter {
    private final String key;
    private final String value;
    private final boolean useMap;

    public ThreadContextMapFilter(Map<String, List<String>> map, boolean bl, Filter.Result result, Filter.Result result2) {
        super(map, bl, result, result2);
        if (map.size() == 1) {
            Iterator<Map.Entry<String, List<String>>> iterator2 = map.entrySet().iterator();
            Map.Entry<String, List<String>> entry = iterator2.next();
            if (entry.getValue().size() == 1) {
                this.key = entry.getKey();
                this.value = entry.getValue().get(0);
                this.useMap = false;
            } else {
                this.key = null;
                this.value = null;
                this.useMap = true;
            }
        } else {
            this.key = null;
            this.value = null;
            this.useMap = true;
        }
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object ... objectArray) {
        return this.filter();
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Object object, Throwable throwable) {
        return this.filter();
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
        return this.filter();
    }

    private Filter.Result filter() {
        boolean bl = false;
        if (this.useMap) {
            for (Map.Entry<String, List<String>> entry : this.getMap().entrySet()) {
                String string = ThreadContext.get(entry.getKey());
                bl = string != null ? entry.getValue().contains(string) : false;
                if ((this.isAnd() || !bl) && (!this.isAnd() || bl)) continue;
                break;
            }
        } else {
            bl = this.value.equals(ThreadContext.get(this.key));
        }
        return bl ? this.onMatch : this.onMismatch;
    }

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        return super.filter(logEvent.getContextMap()) ? this.onMatch : this.onMismatch;
    }

    @PluginFactory
    public static ThreadContextMapFilter createFilter(@PluginElement(value="Pairs") KeyValuePair[] keyValuePairArray, @PluginAttribute(value="operator") String string, @PluginAttribute(value="onMatch") String string2, @PluginAttribute(value="onMismatch") String string3) {
        if (keyValuePairArray == null || keyValuePairArray.length == 0) {
            LOGGER.error("key and value pairs must be specified for the ThreadContextMapFilter");
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
            LOGGER.error("ThreadContextMapFilter is not configured with any valid key value pairs");
            return null;
        }
        boolean bl = string == null || !string.equalsIgnoreCase("or");
        Filter.Result result = Filter.Result.toResult(string2);
        Filter.Result result2 = Filter.Result.toResult(string3);
        return new ThreadContextMapFilter(hashMap, bl, result, result2);
    }
}

