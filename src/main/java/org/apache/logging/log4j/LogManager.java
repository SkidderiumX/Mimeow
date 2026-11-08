/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j;

import java.io.Serializable;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.StringFormatterMessageFactory;
import org.apache.logging.log4j.simple.SimpleLoggerContextFactory;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.apache.logging.log4j.spi.Provider;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ProviderUtil;

public class LogManager {
    private static LoggerContextFactory factory;
    private static final String FACTORY_PROPERTY_NAME = "log4j2.loggerContextFactory";
    private static final Logger LOGGER;
    public static final String ROOT_LOGGER_NAME = "";

    private static String getClassName(int n) {
        return new Throwable().getStackTrace()[n].getClassName();
    }

    public static LoggerContext getContext() {
        return factory.getContext(LogManager.class.getName(), null, true);
    }

    public static LoggerContext getContext(boolean bl) {
        return factory.getContext(LogManager.class.getName(), null, bl);
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean bl) {
        return factory.getContext(LogManager.class.getName(), classLoader, bl);
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean bl, URI uRI) {
        return factory.getContext(LogManager.class.getName(), classLoader, bl, uRI);
    }

    protected static LoggerContext getContext(String string, boolean bl) {
        return factory.getContext(string, null, bl);
    }

    protected static LoggerContext getContext(String string, ClassLoader classLoader, boolean bl) {
        return factory.getContext(string, classLoader, bl);
    }

    public static LoggerContextFactory getFactory() {
        return factory;
    }

    public static Logger getFormatterLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz != null ? clazz.getName() : LogManager.getClassName(2), (MessageFactory)StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getFormatterLogger(Object object) {
        return LogManager.getLogger(object != null ? object.getClass().getName() : LogManager.getClassName(2), (MessageFactory)StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getFormatterLogger(String string) {
        return LogManager.getLogger(string != null ? string : LogManager.getClassName(2), (MessageFactory)StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getLogger() {
        return LogManager.getLogger(LogManager.getClassName(2));
    }

    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz != null ? clazz.getName() : LogManager.getClassName(2));
    }

    public static Logger getLogger(Class<?> clazz, MessageFactory messageFactory) {
        return LogManager.getLogger(clazz != null ? clazz.getName() : LogManager.getClassName(2), messageFactory);
    }

    public static Logger getLogger(MessageFactory messageFactory) {
        return LogManager.getLogger(LogManager.getClassName(2), messageFactory);
    }

    public static Logger getLogger(Object object) {
        return LogManager.getLogger(object != null ? object.getClass().getName() : LogManager.getClassName(2));
    }

    public static Logger getLogger(Object object, MessageFactory messageFactory) {
        return LogManager.getLogger(object != null ? object.getClass().getName() : LogManager.getClassName(2), messageFactory);
    }

    public static Logger getLogger(String string) {
        String string2 = string != null ? string : LogManager.getClassName(2);
        return factory.getContext(LogManager.class.getName(), null, false).getLogger(string2);
    }

    public static Logger getLogger(String string, MessageFactory messageFactory) {
        String string2 = string != null ? string : LogManager.getClassName(2);
        return factory.getContext(LogManager.class.getName(), null, false).getLogger(string2, messageFactory);
    }

    protected static Logger getLogger(String string, String string2) {
        return factory.getContext(string, null, false).getLogger(string2);
    }

    public static Logger getRootLogger() {
        return LogManager.getLogger(ROOT_LOGGER_NAME);
    }

    protected LogManager() {
    }

    static {
        Serializable serializable;
        LOGGER = StatusLogger.getLogger();
        PropertiesUtil propertiesUtil = PropertiesUtil.getProperties();
        String string = propertiesUtil.getStringProperty(FACTORY_PROPERTY_NAME);
        ClassLoader classLoader = ProviderUtil.findClassLoader();
        if (string != null) {
            try {
                serializable = classLoader.loadClass(string);
                if (LoggerContextFactory.class.isAssignableFrom((Class<?>)serializable)) {
                    factory = (LoggerContextFactory)((Class)serializable).newInstance();
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
                LOGGER.error("Unable to locate configured LoggerContextFactory {}", string);
            }
            catch (Exception exception) {
                LOGGER.error("Unable to create configured LoggerContextFactory {}", string, exception);
            }
        }
        if (factory == null) {
            serializable = new TreeMap();
            if (ProviderUtil.hasProviders()) {
                Object object;
                Iterator<Provider> iterator2 = ProviderUtil.getProviders();
                while (iterator2.hasNext()) {
                    object = iterator2.next();
                    String string2 = ((Provider)object).getClassName();
                    if (string2 == null) continue;
                    try {
                        Class<?> classNotFoundException = classLoader.loadClass(string2);
                        if (LoggerContextFactory.class.isAssignableFrom(classNotFoundException)) {
                            serializable.put(((Provider)object).getPriority(), (LoggerContextFactory)classNotFoundException.newInstance());
                            continue;
                        }
                        LOGGER.error((String)string2 + " does not implement " + LoggerContextFactory.class.getName());
                    }
                    catch (ClassNotFoundException illegalAccessException) {
                        LOGGER.error("Unable to locate class " + (String)string2 + " specified in " + ((Provider)object).getURL().toString(), (Throwable)illegalAccessException);
                    }
                    catch (IllegalAccessException exception) {
                        LOGGER.error("Unable to create class " + (String)string2 + " specified in " + ((Provider)object).getURL().toString(), (Throwable)exception);
                    }
                    catch (Exception exception) {
                        LOGGER.error("Unable to create class " + (String)string2 + " specified in " + ((Provider)object).getURL().toString(), (Throwable)exception);
                        exception.printStackTrace();
                    }
                }
                if (serializable.size() == 0) {
                    LOGGER.error("Unable to locate a logging implementation, using SimpleLogger");
                    factory = new SimpleLoggerContextFactory();
                } else {
                    object = new StringBuilder("Multiple logging implementations found: \n");
                    for (Map.Entry entry : serializable.entrySet()) {
                        ((StringBuilder)object).append("Factory: ").append(((LoggerContextFactory)entry.getValue()).getClass().getName());
                        ((StringBuilder)object).append(", Weighting: ").append(entry.getKey()).append("\n");
                    }
                    factory = (LoggerContextFactory)serializable.get(serializable.lastKey());
                    ((StringBuilder)object).append("Using factory: ").append(factory.getClass().getName());
                    LOGGER.warn(((StringBuilder)object).toString());
                }
            } else {
                LOGGER.error("Unable to locate a logging implementation, using SimpleLogger");
                factory = new SimpleLoggerContextFactory();
            }
        }
    }
}

