/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.impl;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.impl.ThrowableProxy;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.TimestampMessage;

public class Log4jLogEvent
implements LogEvent {
    private static final long serialVersionUID = -1351367343806656055L;
    private static final String NOT_AVAIL = "?";
    private final String fqcnOfLogger;
    private final Marker marker;
    private final Level level;
    private final String name;
    private final Message message;
    private final long timestamp;
    private final ThrowableProxy throwable;
    private final Map<String, String> mdc;
    private final ThreadContext.ContextStack ndc;
    private String threadName = null;
    private StackTraceElement location;
    private boolean includeLocation;
    private boolean endOfBatch = false;

    public Log4jLogEvent(long l) {
        this("", null, "", null, null, (ThrowableProxy)null, null, null, null, null, l);
    }

    public Log4jLogEvent(String string, Marker marker, String string2, Level level, Message message, Throwable throwable) {
        this(string, marker, string2, level, message, null, throwable);
    }

    public Log4jLogEvent(String string, Marker marker, String string2, Level level, Message message, List<Property> list, Throwable throwable) {
        this(string, marker, string2, level, message, throwable, Log4jLogEvent.createMap(list), ThreadContext.getDepth() == 0 ? null : ThreadContext.cloneStack(), null, null, System.currentTimeMillis());
    }

    public Log4jLogEvent(String string, Marker marker, String string2, Level level, Message message, Throwable throwable, Map<String, String> map, ThreadContext.ContextStack contextStack, String string3, StackTraceElement stackTraceElement, long l) {
        this(string, marker, string2, level, message, throwable == null ? null : new ThrowableProxy(throwable), map, contextStack, string3, stackTraceElement, l);
    }

    public static Log4jLogEvent createEvent(String string, Marker marker, String string2, Level level, Message message, ThrowableProxy throwableProxy, Map<String, String> map, ThreadContext.ContextStack contextStack, String string3, StackTraceElement stackTraceElement, long l) {
        return new Log4jLogEvent(string, marker, string2, level, message, throwableProxy, map, contextStack, string3, stackTraceElement, l);
    }

    private Log4jLogEvent(String string, Marker marker, String string2, Level level, Message message, ThrowableProxy throwableProxy, Map<String, String> map, ThreadContext.ContextStack contextStack, String string3, StackTraceElement stackTraceElement, long l) {
        this.name = string;
        this.marker = marker;
        this.fqcnOfLogger = string2;
        this.level = level;
        this.message = message;
        this.throwable = throwableProxy;
        this.mdc = map;
        this.ndc = contextStack;
        this.timestamp = message instanceof TimestampMessage ? ((TimestampMessage)((Object)message)).getTimestamp() : l;
        this.threadName = string3;
        this.location = stackTraceElement;
        if (message != null && message instanceof LoggerNameAwareMessage) {
            ((LoggerNameAwareMessage)((Object)message)).setLoggerName(this.name);
        }
    }

    private static Map<String, String> createMap(List<Property> list) {
        Map<String, String> map = ThreadContext.getImmutableContext();
        if (map == null && (list == null || list.size() == 0)) {
            return null;
        }
        if (list == null || list.size() == 0) {
            return map;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>(map);
        for (Property property : list) {
            if (hashMap.containsKey(property.getName())) continue;
            hashMap.put(property.getName(), property.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    @Override
    public String getLoggerName() {
        return this.name;
    }

    @Override
    public Message getMessage() {
        return this.message;
    }

    @Override
    public String getThreadName() {
        if (this.threadName == null) {
            this.threadName = Thread.currentThread().getName();
        }
        return this.threadName;
    }

    @Override
    public long getMillis() {
        return this.timestamp;
    }

    @Override
    public Throwable getThrown() {
        return this.throwable == null ? null : this.throwable.getThrowable();
    }

    public ThrowableProxy getThrownProxy() {
        return this.throwable;
    }

    @Override
    public Marker getMarker() {
        return this.marker;
    }

    @Override
    public String getFQCN() {
        return this.fqcnOfLogger;
    }

    @Override
    public Map<String, String> getContextMap() {
        return this.mdc == null ? ThreadContext.EMPTY_MAP : this.mdc;
    }

    @Override
    public ThreadContext.ContextStack getContextStack() {
        return this.ndc == null ? ThreadContext.EMPTY_STACK : this.ndc;
    }

    @Override
    public StackTraceElement getSource() {
        if (this.location != null) {
            return this.location;
        }
        if (this.fqcnOfLogger == null || !this.includeLocation) {
            return null;
        }
        this.location = Log4jLogEvent.calcLocation(this.fqcnOfLogger);
        return this.location;
    }

    public static StackTraceElement calcLocation(String string) {
        if (string == null) {
            return null;
        }
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        boolean bl = false;
        for (StackTraceElement stackTraceElement : stackTraceElementArray) {
            String string2 = stackTraceElement.getClassName();
            if (bl) {
                if (string.equals(string2)) continue;
                return stackTraceElement;
            }
            if (string.equals(string2)) {
                bl = true;
                continue;
            }
            if (NOT_AVAIL.equals(string2)) break;
        }
        return null;
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
    public boolean isEndOfBatch() {
        return this.endOfBatch;
    }

    @Override
    public void setEndOfBatch(boolean bl) {
        this.endOfBatch = bl;
    }

    protected Object writeReplace() {
        return new LogEventProxy(this, this.includeLocation);
    }

    public static Serializable serialize(Log4jLogEvent log4jLogEvent, boolean bl) {
        return new LogEventProxy(log4jLogEvent, bl);
    }

    public static Log4jLogEvent deserialize(Serializable serializable) {
        if (serializable == null) {
            throw new NullPointerException("Event cannot be null");
        }
        if (serializable instanceof LogEventProxy) {
            LogEventProxy logEventProxy = (LogEventProxy)serializable;
            Log4jLogEvent log4jLogEvent = new Log4jLogEvent(logEventProxy.name, logEventProxy.marker, logEventProxy.fqcnOfLogger, logEventProxy.level, logEventProxy.message, logEventProxy.throwable, (Map<String, String>)logEventProxy.mdc, logEventProxy.ndc, logEventProxy.threadName, logEventProxy.location, logEventProxy.timestamp);
            log4jLogEvent.setEndOfBatch(logEventProxy.isEndOfBatch);
            log4jLogEvent.setIncludeLocation(logEventProxy.isLocationRequired);
            return log4jLogEvent;
        }
        throw new IllegalArgumentException("Event is not a serialized LogEvent: " + serializable.toString());
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.name.isEmpty() ? "root" : this.name;
        stringBuilder.append("Logger=").append(string);
        stringBuilder.append(" Level=").append(this.level.name());
        stringBuilder.append(" Message=").append(this.message.getFormattedMessage());
        return stringBuilder.toString();
    }

    private static class LogEventProxy
    implements Serializable {
        private static final long serialVersionUID = -7139032940312647146L;
        private final String fqcnOfLogger;
        private final Marker marker;
        private final Level level;
        private final String name;
        private final Message message;
        private final long timestamp;
        private final ThrowableProxy throwable;
        private final Map<String, String> mdc;
        private final ThreadContext.ContextStack ndc;
        private final String threadName;
        private final StackTraceElement location;
        private final boolean isLocationRequired;
        private final boolean isEndOfBatch;

        public LogEventProxy(Log4jLogEvent log4jLogEvent, boolean bl) {
            this.fqcnOfLogger = log4jLogEvent.fqcnOfLogger;
            this.marker = log4jLogEvent.marker;
            this.level = log4jLogEvent.level;
            this.name = log4jLogEvent.name;
            this.message = log4jLogEvent.message;
            this.timestamp = log4jLogEvent.timestamp;
            this.throwable = log4jLogEvent.throwable;
            this.mdc = log4jLogEvent.mdc;
            this.ndc = log4jLogEvent.ndc;
            this.location = bl ? log4jLogEvent.getSource() : null;
            this.threadName = log4jLogEvent.getThreadName();
            this.isLocationRequired = bl;
            this.isEndOfBatch = log4jLogEvent.endOfBatch;
        }

        protected Object readResolve() {
            Log4jLogEvent log4jLogEvent = new Log4jLogEvent(this.name, this.marker, this.fqcnOfLogger, this.level, this.message, this.throwable, this.mdc, this.ndc, this.threadName, this.location, this.timestamp);
            log4jLogEvent.setEndOfBatch(this.isEndOfBatch);
            log4jLogEvent.setIncludeLocation(this.isLocationRequired);
            return log4jLogEvent;
        }
    }
}

