/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.ErrorHandler;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.status.StatusLogger;

public class DefaultErrorHandler
implements ErrorHandler {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final int MAX_EXCEPTIONS = 3;
    private static final int EXCEPTION_INTERVAL = 300000;
    private int exceptionCount = 0;
    private long lastException;
    private final Appender appender;

    public DefaultErrorHandler(Appender appender) {
        this.appender = appender;
    }

    @Override
    public void error(String string) {
        long l = System.currentTimeMillis();
        if (this.lastException + 300000L < l || this.exceptionCount++ < 3) {
            LOGGER.error(string);
        }
        this.lastException = l;
    }

    @Override
    public void error(String string, Throwable throwable) {
        long l = System.currentTimeMillis();
        if (this.lastException + 300000L < l || this.exceptionCount++ < 3) {
            LOGGER.error(string, throwable);
        }
        this.lastException = l;
        if (!this.appender.ignoreExceptions() && throwable != null && !(throwable instanceof AppenderLoggingException)) {
            throw new AppenderLoggingException(string, throwable);
        }
    }

    @Override
    public void error(String string, LogEvent logEvent, Throwable throwable) {
        long l = System.currentTimeMillis();
        if (this.lastException + 300000L < l || this.exceptionCount++ < 3) {
            LOGGER.error(string, throwable);
        }
        this.lastException = l;
        if (!this.appender.ignoreExceptions() && throwable != null && !(throwable instanceof AppenderLoggingException)) {
            throw new AppenderLoggingException(string, throwable);
        }
    }
}

