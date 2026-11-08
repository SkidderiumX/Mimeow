/*
 * Decompiled with CFR 0.152.
 */
package org.slf4j.spi;

import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.DefaultLoggingEvent;
import org.slf4j.event.KeyValuePair;
import org.slf4j.event.Level;
import org.slf4j.event.LoggingEvent;
import org.slf4j.spi.CallerBoundaryAware;
import org.slf4j.spi.LocationAwareLogger;
import org.slf4j.spi.LoggingEventAware;
import org.slf4j.spi.LoggingEventBuilder;

public class DefaultLoggingEventBuilder
implements LoggingEventBuilder,
CallerBoundaryAware {
    static String DLEB_FQCN = DefaultLoggingEventBuilder.class.getName();
    protected DefaultLoggingEvent loggingEvent;
    protected Logger logger;

    public DefaultLoggingEventBuilder(Logger logger, Level level) {
        this.logger = logger;
        this.loggingEvent = new DefaultLoggingEvent(level, logger);
    }

    @Override
    public LoggingEventBuilder addMarker(Marker marker) {
        this.loggingEvent.addMarker(marker);
        return this;
    }

    @Override
    public LoggingEventBuilder setCause(Throwable throwable) {
        this.loggingEvent.setThrowable(throwable);
        return this;
    }

    @Override
    public LoggingEventBuilder addArgument(Object object) {
        this.loggingEvent.addArgument(object);
        return this;
    }

    @Override
    public LoggingEventBuilder addArgument(Supplier<?> supplier) {
        this.loggingEvent.addArgument(supplier.get());
        return this;
    }

    @Override
    public LoggingEventBuilder addKeyValue(String string, Object object) {
        this.loggingEvent.addKeyValue(string, object);
        return this;
    }

    @Override
    public LoggingEventBuilder addKeyValue(String string, Supplier<Object> supplier) {
        this.loggingEvent.addKeyValue(string, supplier.get());
        return this;
    }

    @Override
    public void setCallerBoundary(String string) {
        this.loggingEvent.setCallerBoundary(string);
    }

    @Override
    public void log() {
        this.log(this.loggingEvent);
    }

    @Override
    public LoggingEventBuilder setMessage(String string) {
        this.loggingEvent.setMessage(string);
        return this;
    }

    @Override
    public LoggingEventBuilder setMessage(Supplier<String> supplier) {
        this.loggingEvent.setMessage(supplier.get());
        return this;
    }

    @Override
    public void log(String string) {
        this.loggingEvent.setMessage(string);
        this.log(this.loggingEvent);
    }

    @Override
    public void log(String string, Object object) {
        this.loggingEvent.setMessage(string);
        this.loggingEvent.addArgument(object);
        this.log(this.loggingEvent);
    }

    @Override
    public void log(String string, Object object, Object object2) {
        this.loggingEvent.setMessage(string);
        this.loggingEvent.addArgument(object);
        this.loggingEvent.addArgument(object2);
        this.log(this.loggingEvent);
    }

    @Override
    public void log(String string, Object ... objectArray) {
        this.loggingEvent.setMessage(string);
        this.loggingEvent.addArguments(objectArray);
        this.log(this.loggingEvent);
    }

    @Override
    public void log(Supplier<String> supplier) {
        if (supplier == null) {
            this.log((String)null);
        } else {
            this.log(supplier.get());
        }
    }

    protected void log(LoggingEvent loggingEvent) {
        if (loggingEvent.getCallerBoundary() == null) {
            this.setCallerBoundary(DLEB_FQCN);
        }
        if (this.logger instanceof LoggingEventAware) {
            ((LoggingEventAware)((Object)this.logger)).log(loggingEvent);
        } else if (this.logger instanceof LocationAwareLogger) {
            this.logViaLocationAwareLoggerAPI((LocationAwareLogger)this.logger, loggingEvent);
        } else {
            this.logViaPublicSLF4JLoggerAPI(loggingEvent);
        }
    }

    private void logViaLocationAwareLoggerAPI(LocationAwareLogger locationAwareLogger, LoggingEvent loggingEvent) {
        String string = loggingEvent.getMessage();
        List<Marker> list = loggingEvent.getMarkers();
        String string2 = this.mergeMarkersAndKeyValuePairsAndMessage(loggingEvent);
        locationAwareLogger.log(null, loggingEvent.getCallerBoundary(), loggingEvent.getLevel().toInt(), string2, loggingEvent.getArgumentArray(), loggingEvent.getThrowable());
    }

    private void logViaPublicSLF4JLoggerAPI(LoggingEvent loggingEvent) {
        Object[] objectArray = loggingEvent.getArgumentArray();
        int n = objectArray == null ? 0 : objectArray.length;
        Throwable throwable = loggingEvent.getThrowable();
        int n2 = throwable == null ? 0 : 1;
        Object[] objectArray2 = new Object[n + n2];
        if (objectArray != null) {
            System.arraycopy(objectArray, 0, objectArray2, 0, n);
        }
        if (throwable != null) {
            objectArray2[n] = throwable;
        }
        String string = this.mergeMarkersAndKeyValuePairsAndMessage(loggingEvent);
        switch (loggingEvent.getLevel()) {
            case TRACE: {
                this.logger.trace(string, objectArray2);
                break;
            }
            case DEBUG: {
                this.logger.debug(string, objectArray2);
                break;
            }
            case INFO: {
                this.logger.info(string, objectArray2);
                break;
            }
            case WARN: {
                this.logger.warn(string, objectArray2);
                break;
            }
            case ERROR: {
                this.logger.error(string, objectArray2);
            }
        }
    }

    private String mergeMarkersAndKeyValuePairsAndMessage(LoggingEvent loggingEvent) {
        StringBuilder stringBuilder = this.mergeMarkers(loggingEvent.getMarkers(), null);
        stringBuilder = this.mergeKeyValuePairs(loggingEvent.getKeyValuePairs(), stringBuilder);
        String string = this.mergeMessage(loggingEvent.getMessage(), stringBuilder);
        return string;
    }

    private StringBuilder mergeMarkers(List<Marker> list, StringBuilder stringBuilder) {
        if (list == null || list.isEmpty()) {
            return stringBuilder;
        }
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }
        for (Marker marker : list) {
            stringBuilder.append(marker);
            stringBuilder.append(' ');
        }
        return stringBuilder;
    }

    private StringBuilder mergeKeyValuePairs(List<KeyValuePair> list, StringBuilder stringBuilder) {
        if (list == null || list.isEmpty()) {
            return stringBuilder;
        }
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }
        for (KeyValuePair keyValuePair : list) {
            stringBuilder.append(keyValuePair.key);
            stringBuilder.append('=');
            stringBuilder.append(keyValuePair.value);
            stringBuilder.append(' ');
        }
        return stringBuilder;
    }

    private String mergeMessage(String string, StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            stringBuilder.append(string);
            return stringBuilder.toString();
        }
        return string;
    }
}

