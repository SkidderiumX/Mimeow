/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.spi;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;

public class AbstractLoggerWrapper
extends AbstractLogger {
    protected final AbstractLogger logger;

    public AbstractLoggerWrapper(AbstractLogger abstractLogger, String string, MessageFactory messageFactory) {
        super(string, messageFactory);
        this.logger = abstractLogger;
    }

    @Override
    public void log(Marker marker, String string, Level level, Message message, Throwable throwable) {
        this.logger.log(marker, string, level, message, throwable);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String string) {
        return this.logger.isEnabled(level, marker, string);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String string, Throwable throwable) {
        return this.logger.isEnabled(level, marker, string, throwable);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String string, Object ... objectArray) {
        return this.logger.isEnabled(level, marker, string, objectArray);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, Object object, Throwable throwable) {
        return this.logger.isEnabled(level, marker, object, throwable);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, Message message, Throwable throwable) {
        return this.logger.isEnabled(level, marker, message, throwable);
    }
}

