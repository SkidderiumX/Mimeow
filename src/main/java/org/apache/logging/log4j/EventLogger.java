/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.StructuredDataMessage;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.AbstractLoggerWrapper;

public class EventLogger {
    private static final String NAME = "EventLogger";
    public static final Marker EVENT_MARKER = MarkerManager.getMarker("EVENT");
    private static final String FQCN = EventLogger.class.getName();
    private static AbstractLoggerWrapper loggerWrapper;

    private EventLogger() {
    }

    public static void logEvent(StructuredDataMessage structuredDataMessage) {
        loggerWrapper.log(EVENT_MARKER, FQCN, Level.OFF, structuredDataMessage, null);
    }

    public static void logEvent(StructuredDataMessage structuredDataMessage, Level level) {
        loggerWrapper.log(EVENT_MARKER, FQCN, level, structuredDataMessage, null);
    }

    static {
        Logger logger = LogManager.getLogger(NAME);
        if (!(logger instanceof AbstractLogger)) {
            throw new LoggingException("Logger returned must be based on AbstractLogger");
        }
        loggerWrapper = new AbstractLoggerWrapper((AbstractLogger)logger, NAME, null);
    }
}

