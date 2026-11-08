/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class AbstractServer {
    private final LoggerContext context = (LoggerContext)LogManager.getContext(false);

    protected AbstractServer() {
    }

    protected void log(LogEvent logEvent) {
        Logger logger = this.context.getLogger(logEvent.getLoggerName());
        if (logger.config.filter(logEvent.getLevel(), logEvent.getMarker(), logEvent.getMessage(), logEvent.getThrown())) {
            logger.config.logEvent(logEvent);
        }
    }
}

