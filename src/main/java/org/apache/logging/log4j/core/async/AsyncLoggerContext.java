/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.async;

import java.net.URI;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.async.AsyncLogger;
import org.apache.logging.log4j.message.MessageFactory;

public class AsyncLoggerContext
extends LoggerContext {
    public AsyncLoggerContext(String string) {
        super(string);
    }

    public AsyncLoggerContext(String string, Object object) {
        super(string, object);
    }

    public AsyncLoggerContext(String string, Object object, URI uRI) {
        super(string, object, uRI);
    }

    public AsyncLoggerContext(String string, Object object, String string2) {
        super(string, object, string2);
    }

    @Override
    protected Logger newInstance(LoggerContext loggerContext, String string, MessageFactory messageFactory) {
        return new AsyncLogger(loggerContext, string, messageFactory);
    }

    @Override
    public void stop() {
        AsyncLogger.stop();
        super.stop();
    }
}

