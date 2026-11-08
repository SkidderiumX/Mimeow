/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.impl;

import java.net.URI;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.helpers.Loader;
import org.apache.logging.log4j.core.jmx.Server;
import org.apache.logging.log4j.core.selector.ClassLoaderContextSelector;
import org.apache.logging.log4j.core.selector.ContextSelector;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

public class Log4jContextFactory
implements LoggerContextFactory {
    private static final StatusLogger LOGGER = StatusLogger.getLogger();
    private ContextSelector selector;

    public Log4jContextFactory() {
        String string = PropertiesUtil.getProperties().getStringProperty("Log4jContextSelector");
        if (string != null) {
            try {
                Class<?> clazz = Loader.loadClass(string);
                if (clazz != null && ContextSelector.class.isAssignableFrom(clazz)) {
                    this.selector = (ContextSelector)clazz.newInstance();
                }
            }
            catch (Exception exception) {
                LOGGER.error("Unable to create context " + string, (Throwable)exception);
            }
        }
        if (this.selector == null) {
            this.selector = new ClassLoaderContextSelector();
        }
        try {
            Server.registerMBeans(this.selector);
        }
        catch (Exception exception) {
            LOGGER.error("Could not start JMX", (Throwable)exception);
        }
    }

    public ContextSelector getSelector() {
        return this.selector;
    }

    @Override
    public LoggerContext getContext(String string, ClassLoader classLoader, boolean bl) {
        LoggerContext loggerContext = this.selector.getContext(string, classLoader, bl);
        if (loggerContext.getStatus() == LoggerContext.Status.INITIALIZED) {
            loggerContext.start();
        }
        return loggerContext;
    }

    @Override
    public LoggerContext getContext(String string, ClassLoader classLoader, boolean bl, URI uRI) {
        LoggerContext loggerContext = this.selector.getContext(string, classLoader, bl, uRI);
        if (loggerContext.getStatus() == LoggerContext.Status.INITIALIZED) {
            loggerContext.start();
        }
        return loggerContext;
    }

    @Override
    public void removeContext(org.apache.logging.log4j.spi.LoggerContext loggerContext) {
        if (loggerContext instanceof LoggerContext) {
            this.selector.removeContext((LoggerContext)loggerContext);
        }
    }
}

