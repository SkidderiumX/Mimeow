/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.async;

import com.lmax.disruptor.EventFactory;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.async.AsyncLogger;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.lookup.StrSubstitutor;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;

public class RingBufferLogEvent
implements LogEvent {
    private static final long serialVersionUID = 8462119088943934758L;
    public static final Factory FACTORY = new Factory();
    private AsyncLogger asyncLogger;
    private String loggerName;
    private Marker marker;
    private String fqcn;
    private Level level;
    private Message message;
    private Throwable thrown;
    private Map<String, String> contextMap;
    private ThreadContext.ContextStack contextStack;
    private String threadName;
    private StackTraceElement location;
    private long currentTimeMillis;
    private boolean endOfBatch;
    private boolean includeLocation;

    public void setValues(AsyncLogger asyncLogger, String string, Marker marker, String string2, Level level, Message message, Throwable throwable, Map<String, String> map, ThreadContext.ContextStack contextStack, String string3, StackTraceElement stackTraceElement, long l) {
        this.asyncLogger = asyncLogger;
        this.loggerName = string;
        this.marker = marker;
        this.fqcn = string2;
        this.level = level;
        this.message = message;
        this.thrown = throwable;
        this.contextMap = map;
        this.contextStack = contextStack;
        this.threadName = string3;
        this.location = stackTraceElement;
        this.currentTimeMillis = l;
    }

    public void execute(boolean bl) {
        this.endOfBatch = bl;
        this.asyncLogger.actualAsyncLog(this);
    }

    @Override
    public boolean isEndOfBatch() {
        return this.endOfBatch;
    }

    @Override
    public void setEndOfBatch(boolean bl) {
        this.endOfBatch = bl;
    }

    @Override
    public boolean isIncludeLocation() {
        return this.includeLocation;
    }

    @Override
    public void setIncludeLocation(boolean bl) {
        this.includeLocation = bl;
    }

    @Override
    public String getLoggerName() {
        return this.loggerName;
    }

    @Override
    public Marker getMarker() {
        return this.marker;
    }

    @Override
    public String getFQCN() {
        return this.fqcn;
    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    @Override
    public Message getMessage() {
        if (this.message == null) {
            this.message = new SimpleMessage("");
        }
        return this.message;
    }

    @Override
    public Throwable getThrown() {
        return this.thrown;
    }

    @Override
    public Map<String, String> getContextMap() {
        return this.contextMap;
    }

    @Override
    public ThreadContext.ContextStack getContextStack() {
        return this.contextStack;
    }

    @Override
    public String getThreadName() {
        return this.threadName;
    }

    @Override
    public StackTraceElement getSource() {
        return this.location;
    }

    @Override
    public long getMillis() {
        return this.currentTimeMillis;
    }

    public void mergePropertiesIntoContextMap(Map<Property, Boolean> map, StrSubstitutor strSubstitutor) {
        if (map == null) {
            return;
        }
        HashMap<String, String> hashMap = this.contextMap == null ? new HashMap<String, String>() : new HashMap<String, String>(this.contextMap);
        for (Map.Entry<Property, Boolean> entry : map.entrySet()) {
            Property property = entry.getKey();
            if (hashMap.containsKey(property.getName())) continue;
            String string = entry.getValue() != false ? strSubstitutor.replace(property.getValue()) : property.getValue();
            hashMap.put(property.getName(), string);
        }
        this.contextMap = hashMap;
    }

    public void clear() {
        this.setValues(null, null, null, null, null, null, null, null, null, null, null, 0L);
    }

    private static class Factory
    implements EventFactory<RingBufferLogEvent> {
        private Factory() {
        }

        public RingBufferLogEvent newInstance() {
            return new RingBufferLogEvent();
        }
    }
}

