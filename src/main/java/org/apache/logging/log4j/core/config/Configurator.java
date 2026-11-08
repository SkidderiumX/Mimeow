/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.impl.ContextAnchor;
import org.apache.logging.log4j.status.StatusLogger;

public class Configurator {
    protected static final StatusLogger LOGGER = StatusLogger.getLogger();

    private Configurator() {
    }

    public static LoggerContext initialize(String string, ClassLoader classLoader, String string2) {
        return Configurator.initialize(string, classLoader, string2, null);
    }

    public static LoggerContext initialize(String string, ClassLoader classLoader, String string2, Object object) {
        try {
            URI uRI = string2 == null ? null : new URI(string2);
            return Configurator.initialize(string, classLoader, uRI, object);
        }
        catch (URISyntaxException uRISyntaxException) {
            uRISyntaxException.printStackTrace();
            return null;
        }
    }

    public static LoggerContext initialize(String string, String string2) {
        return Configurator.initialize(string, null, string2);
    }

    public static LoggerContext initialize(String string, ClassLoader classLoader, URI uRI) {
        return Configurator.initialize(string, classLoader, uRI, null);
    }

    public static LoggerContext initialize(String string, ClassLoader classLoader, URI uRI, Object object) {
        try {
            org.apache.logging.log4j.spi.LoggerContext loggerContext = LogManager.getContext(classLoader, false, uRI);
            if (loggerContext instanceof LoggerContext) {
                LoggerContext loggerContext2 = (LoggerContext)loggerContext;
                ContextAnchor.THREAD_CONTEXT.set(loggerContext2);
                if (object != null) {
                    loggerContext2.setExternalContext(object);
                }
                Configuration configuration = ConfigurationFactory.getInstance().getConfiguration(string, uRI);
                loggerContext2.start(configuration);
                ContextAnchor.THREAD_CONTEXT.remove();
                return loggerContext2;
            }
            LOGGER.error("LogManager returned an instance of {} which does not implement {}. Unable to initialize Log4j", loggerContext.getClass().getName(), LoggerContext.class.getName());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static LoggerContext initialize(ClassLoader classLoader, ConfigurationFactory.ConfigurationSource configurationSource) {
        try {
            URI uRI = null;
            try {
                uRI = configurationSource.getLocation() == null ? null : new URI(configurationSource.getLocation());
            }
            catch (Exception exception) {
                // empty catch block
            }
            org.apache.logging.log4j.spi.LoggerContext loggerContext = LogManager.getContext(classLoader, false, uRI);
            if (loggerContext instanceof LoggerContext) {
                LoggerContext loggerContext2 = (LoggerContext)loggerContext;
                ContextAnchor.THREAD_CONTEXT.set(loggerContext2);
                Configuration configuration = ConfigurationFactory.getInstance().getConfiguration(configurationSource);
                loggerContext2.start(configuration);
                ContextAnchor.THREAD_CONTEXT.remove();
                return loggerContext2;
            }
            LOGGER.error("LogManager returned an instance of {} which does not implement {}. Unable to initialize Log4j", loggerContext.getClass().getName(), LoggerContext.class.getName());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static void shutdown(LoggerContext loggerContext) {
        if (loggerContext != null) {
            loggerContext.stop();
        }
    }
}

