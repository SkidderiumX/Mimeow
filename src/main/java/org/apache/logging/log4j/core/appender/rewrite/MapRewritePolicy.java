/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rewrite;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.KeyValuePair;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.message.MapMessage;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="MapRewritePolicy", category="Core", elementType="rewritePolicy", printObject=true)
public class MapRewritePolicy
implements RewritePolicy {
    protected static final Logger LOGGER = StatusLogger.getLogger();
    private final Map<String, String> map;
    private final Mode mode;

    private MapRewritePolicy(Map<String, String> map, Mode mode) {
        this.map = map;
        this.mode = mode;
    }

    @Override
    public LogEvent rewrite(LogEvent logEvent) {
        Message message = logEvent.getMessage();
        if (message == null || !(message instanceof MapMessage)) {
            return logEvent;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>(((MapMessage)message).getData());
        switch (this.mode) {
            case Add: {
                hashMap.putAll(this.map);
                break;
            }
            default: {
                for (Map.Entry<String, String> entry : this.map.entrySet()) {
                    if (!hashMap.containsKey(entry.getKey())) continue;
                    hashMap.put((String)entry.getKey(), (String)entry.getValue());
                }
            }
        }
        MapMessage mapMessage = ((MapMessage)message).newInstance(hashMap);
        if (logEvent instanceof Log4jLogEvent) {
            Map.Entry<String, String> entry;
            entry = (Log4jLogEvent)logEvent;
            return Log4jLogEvent.createEvent(((Log4jLogEvent)((Object)entry)).getLoggerName(), ((Log4jLogEvent)((Object)entry)).getMarker(), ((Log4jLogEvent)((Object)entry)).getFQCN(), ((Log4jLogEvent)((Object)entry)).getLevel(), mapMessage, ((Log4jLogEvent)((Object)entry)).getThrownProxy(), ((Log4jLogEvent)((Object)entry)).getContextMap(), ((Log4jLogEvent)((Object)entry)).getContextStack(), ((Log4jLogEvent)((Object)entry)).getThreadName(), ((Log4jLogEvent)((Object)entry)).getSource(), ((Log4jLogEvent)((Object)entry)).getMillis());
        }
        return new Log4jLogEvent(logEvent.getLoggerName(), logEvent.getMarker(), logEvent.getFQCN(), logEvent.getLevel(), (Message)mapMessage, logEvent.getThrown(), logEvent.getContextMap(), logEvent.getContextStack(), logEvent.getThreadName(), logEvent.getSource(), logEvent.getMillis());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mode=").append((Object)this.mode);
        stringBuilder.append(" {");
        boolean bl = true;
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            if (!bl) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            bl = false;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @PluginFactory
    public static MapRewritePolicy createPolicy(@PluginAttribute(value="mode") String string, @PluginElement(value="KeyValuePair") KeyValuePair[] keyValuePairArray) {
        Mode mode;
        if (string == null) {
            mode = Mode.Add;
        } else {
            mode = Mode.valueOf(string);
            if (mode == null) {
                LOGGER.error("Undefined mode " + string);
                return null;
            }
        }
        if (keyValuePairArray == null || keyValuePairArray.length == 0) {
            LOGGER.error("keys and values must be specified for the MapRewritePolicy");
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (KeyValuePair keyValuePair : keyValuePairArray) {
            String string2 = keyValuePair.getKey();
            if (string2 == null) {
                LOGGER.error("A null key is not valid in MapRewritePolicy");
                continue;
            }
            String string3 = keyValuePair.getValue();
            if (string3 == null) {
                LOGGER.error("A null value for key " + string2 + " is not allowed in MapRewritePolicy");
                continue;
            }
            hashMap.put(keyValuePair.getKey(), keyValuePair.getValue());
        }
        if (hashMap.size() == 0) {
            LOGGER.error("MapRewritePolicy is not configured with any valid key value pairs");
            return null;
        }
        return new MapRewritePolicy(hashMap, mode);
    }

    public static enum Mode {
        Add,
        Update;

    }
}

