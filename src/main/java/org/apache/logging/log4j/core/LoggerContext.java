/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationListener;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.apache.logging.log4j.core.config.NullConfiguration;
import org.apache.logging.log4j.core.config.Reconfigurable;
import org.apache.logging.log4j.core.helpers.Assert;
import org.apache.logging.log4j.core.helpers.NetUtils;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.status.StatusLogger;

public class LoggerContext
implements org.apache.logging.log4j.spi.LoggerContext,
ConfigurationListener,
LifeCycle {
    public static final String PROPERTY_CONFIG = "config";
    private static final StatusLogger LOGGER = StatusLogger.getLogger();
    private final ConcurrentMap<String, Logger> loggers = new ConcurrentHashMap<String, Logger>();
    private final CopyOnWriteArrayList<PropertyChangeListener> propertyChangeListeners = new CopyOnWriteArrayList();
    private volatile Configuration config = new DefaultConfiguration();
    private Object externalContext;
    private final String name;
    private URI configLocation;
    private ShutdownThread shutdownThread = null;
    private volatile Status status = Status.INITIALIZED;
    private final Lock configLock = new ReentrantLock();

    public LoggerContext(String string) {
        this(string, null, (URI)null);
    }

    public LoggerContext(String string, Object object) {
        this(string, object, (URI)null);
    }

    public LoggerContext(String string, Object object, URI uRI) {
        this.name = string;
        this.externalContext = object;
        this.configLocation = uRI;
    }

    public LoggerContext(String string, Object object, String string2) {
        this.name = string;
        this.externalContext = object;
        if (string2 != null) {
            URI uRI;
            try {
                uRI = new File(string2).toURI();
            }
            catch (Exception exception) {
                uRI = null;
            }
            this.configLocation = uRI;
        } else {
            this.configLocation = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void start() {
        block8: {
            if (this.configLock.tryLock()) {
                try {
                    if (this.status != Status.INITIALIZED && this.status != Status.STOPPED) break block8;
                    this.status = Status.STARTING;
                    this.reconfigure();
                    if (this.config.isShutdownHookEnabled()) {
                        this.shutdownThread = new ShutdownThread(this);
                        try {
                            Runtime.getRuntime().addShutdownHook(this.shutdownThread);
                        }
                        catch (IllegalStateException illegalStateException) {
                            LOGGER.warn("Unable to register shutdown hook due to JVM state");
                            this.shutdownThread = null;
                        }
                        catch (SecurityException securityException) {
                            LOGGER.warn("Unable to register shutdown hook due to security restrictions");
                            this.shutdownThread = null;
                        }
                    }
                    this.status = Status.STARTED;
                }
                finally {
                    this.configLock.unlock();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start(Configuration configuration) {
        block7: {
            if (this.configLock.tryLock()) {
                try {
                    if (this.status != Status.INITIALIZED && this.status != Status.STOPPED || !configuration.isShutdownHookEnabled()) break block7;
                    this.shutdownThread = new ShutdownThread(this);
                    try {
                        Runtime.getRuntime().addShutdownHook(this.shutdownThread);
                    }
                    catch (IllegalStateException illegalStateException) {
                        LOGGER.warn("Unable to register shutdown hook due to JVM state");
                        this.shutdownThread = null;
                    }
                    catch (SecurityException securityException) {
                        LOGGER.warn("Unable to register shutdown hook due to security restrictions");
                        this.shutdownThread = null;
                    }
                    this.status = Status.STARTED;
                }
                finally {
                    this.configLock.unlock();
                }
            }
        }
        this.setConfiguration(configuration);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stop() {
        this.configLock.lock();
        try {
            if (this.status == Status.STOPPED) {
                return;
            }
            this.status = Status.STOPPING;
            if (this.shutdownThread != null) {
                Runtime.getRuntime().removeShutdownHook(this.shutdownThread);
                this.shutdownThread = null;
            }
            Configuration configuration = this.config;
            this.config = new NullConfiguration();
            this.updateLoggers();
            configuration.stop();
            this.externalContext = null;
            LogManager.getFactory().removeContext(this);
            this.status = Status.STOPPED;
        }
        finally {
            this.configLock.unlock();
        }
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }

    @Override
    public boolean isStarted() {
        return this.status == Status.STARTED;
    }

    public void setExternalContext(Object object) {
        this.externalContext = object;
    }

    @Override
    public Object getExternalContext() {
        return this.externalContext;
    }

    @Override
    public Logger getLogger(String string) {
        return this.getLogger(string, null);
    }

    @Override
    public Logger getLogger(String string, MessageFactory messageFactory) {
        Logger logger = (Logger)this.loggers.get(string);
        if (logger != null) {
            AbstractLogger.checkMessageFactory(logger, messageFactory);
            return logger;
        }
        logger = this.newInstance(this, string, messageFactory);
        Logger logger2 = this.loggers.putIfAbsent(string, logger);
        return logger2 == null ? logger : logger2;
    }

    @Override
    public boolean hasLogger(String string) {
        return this.loggers.containsKey(string);
    }

    public Configuration getConfiguration() {
        return this.config;
    }

    public void addFilter(Filter filter) {
        this.config.addFilter(filter);
    }

    public void removeFilter(Filter filter) {
        this.config.removeFilter(filter);
    }

    private synchronized Configuration setConfiguration(Configuration configuration) {
        if (configuration == null) {
            throw new NullPointerException("No Configuration was provided");
        }
        Configuration configuration2 = this.config;
        configuration.addListener(this);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("hostName", NetUtils.getLocalHostname());
        hashMap.put("contextName", this.name);
        configuration.addComponent("ContextProperties", hashMap);
        configuration.start();
        this.config = configuration;
        this.updateLoggers();
        if (configuration2 != null) {
            configuration2.removeListener(this);
            configuration2.stop();
        }
        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(this, PROPERTY_CONFIG, configuration2, configuration);
        for (PropertyChangeListener propertyChangeListener : this.propertyChangeListeners) {
            propertyChangeListener.propertyChange(propertyChangeEvent);
        }
        return configuration2;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeListeners.add(Assert.isNotNull(propertyChangeListener, "listener"));
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeListeners.remove(propertyChangeListener);
    }

    public synchronized URI getConfigLocation() {
        return this.configLocation;
    }

    public synchronized void setConfigLocation(URI uRI) {
        this.configLocation = uRI;
        this.reconfigure();
    }

    public synchronized void reconfigure() {
        LOGGER.debug("Reconfiguration started for context " + this.name);
        Configuration configuration = ConfigurationFactory.getInstance().getConfiguration(this.name, this.configLocation);
        this.setConfiguration(configuration);
        LOGGER.debug("Reconfiguration completed");
    }

    public void updateLoggers() {
        this.updateLoggers(this.config);
    }

    public void updateLoggers(Configuration configuration) {
        for (Logger logger : this.loggers.values()) {
            logger.updateConfiguration(configuration);
        }
    }

    @Override
    public synchronized void onChange(Reconfigurable reconfigurable) {
        LOGGER.debug("Reconfiguration started for context " + this.name);
        Configuration configuration = reconfigurable.reconfigure();
        if (configuration != null) {
            this.setConfiguration(configuration);
            LOGGER.debug("Reconfiguration completed");
        } else {
            LOGGER.debug("Reconfiguration failed");
        }
    }

    protected Logger newInstance(LoggerContext loggerContext, String string, MessageFactory messageFactory) {
        return new Logger(loggerContext, string, messageFactory);
    }

    private class ShutdownThread
    extends Thread {
        private final LoggerContext context;

        public ShutdownThread(LoggerContext loggerContext2) {
            this.context = loggerContext2;
        }

        @Override
        public void run() {
            this.context.shutdownThread = null;
            this.context.stop();
        }
    }

    public static enum Status {
        INITIALIZED,
        STARTING,
        STARTED,
        STOPPING,
        STOPPED;

    }
}

