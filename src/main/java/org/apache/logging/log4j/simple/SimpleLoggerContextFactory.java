/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.simple;

import java.net.URI;
import org.apache.logging.log4j.simple.SimpleLoggerContext;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerContextFactory;

public class SimpleLoggerContextFactory
implements LoggerContextFactory {
    private static LoggerContext context = new SimpleLoggerContext();

    @Override
    public LoggerContext getContext(String string, ClassLoader classLoader, boolean bl) {
        return context;
    }

    @Override
    public LoggerContext getContext(String string, ClassLoader classLoader, boolean bl, URI uRI) {
        return context;
    }

    @Override
    public void removeContext(LoggerContext loggerContext) {
    }
}

