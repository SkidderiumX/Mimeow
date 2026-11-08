/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.async.AsyncLoggerContextSelector;
import org.apache.logging.log4j.core.config.AppenderControl;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilterable;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.helpers.Loader;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.core.impl.DefaultLogEventFactory;
import org.apache.logging.log4j.core.impl.LogEventFactory;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

@Plugin(name="logger", category="Core", printObject=true)
public class LoggerConfig
extends AbstractFilterable {
    protected static final Logger LOGGER = StatusLogger.getLogger();
    private static final int MAX_RETRIES = 3;
    private static final long WAIT_TIME = 1000L;
    private static LogEventFactory LOG_EVENT_FACTORY = null;
    private List<AppenderRef> appenderRefs = new ArrayList<AppenderRef>();
    private final Map<String, AppenderControl> appenders = new ConcurrentHashMap<String, AppenderControl>();
    private final String name;
    private LogEventFactory logEventFactory;
    private Level level;
    private boolean additive = true;
    private boolean includeLocation = true;
    private LoggerConfig parent;
    private final AtomicInteger counter = new AtomicInteger();
    private boolean shutdown = false;
    private final Map<Property, Boolean> properties;
    private final Configuration config;

    public LoggerConfig() {
        this.logEventFactory = LOG_EVENT_FACTORY;
        this.level = Level.ERROR;
        this.name = "";
        this.properties = null;
        this.config = null;
    }

    public LoggerConfig(String string, Level level, boolean bl) {
        this.logEventFactory = LOG_EVENT_FACTORY;
        this.name = string;
        this.level = level;
        this.additive = bl;
        this.properties = null;
        this.config = null;
    }

    protected LoggerConfig(String string, List<AppenderRef> list, Filter filter, Level level, boolean bl, Property[] propertyArray, Configuration configuration, boolean bl2) {
        super(filter);
        this.logEventFactory = LOG_EVENT_FACTORY;
        this.name = string;
        this.appenderRefs = list;
        this.level = level;
        this.additive = bl;
        this.includeLocation = bl2;
        this.config = configuration;
        if (propertyArray != null && propertyArray.length > 0) {
            this.properties = new HashMap<Property, Boolean>(propertyArray.length);
            for (Property property : propertyArray) {
                boolean bl3 = property.getValue().contains("${");
                this.properties.put(property, bl3);
            }
        } else {
            this.properties = null;
        }
    }

    @Override
    public Filter getFilter() {
        return super.getFilter();
    }

    public String getName() {
        return this.name;
    }

    public void setParent(LoggerConfig loggerConfig) {
        this.parent = loggerConfig;
    }

    public LoggerConfig getParent() {
        return this.parent;
    }

    public void addAppender(Appender appender, Level level, Filter filter) {
        this.appenders.put(appender.getName(), new AppenderControl(appender, level, filter));
    }

    public void removeAppender(String string) {
        AppenderControl appenderControl = this.appenders.remove(string);
        if (appenderControl != null) {
            this.cleanupFilter(appenderControl);
        }
    }

    public Map<String, Appender> getAppenders() {
        HashMap<String, Appender> hashMap = new HashMap<String, Appender>();
        for (Map.Entry<String, AppenderControl> entry : this.appenders.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().getAppender());
        }
        return hashMap;
    }

    protected void clearAppenders() {
        this.waitForCompletion();
        Collection<AppenderControl> collection = this.appenders.values();
        Iterator<AppenderControl> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            AppenderControl appenderControl = iterator2.next();
            iterator2.remove();
            this.cleanupFilter(appenderControl);
        }
    }

    private void cleanupFilter(AppenderControl appenderControl) {
        Filter filter = null;
        int n = 2053514065;
        block6: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case 2053514065: {
                    filter = appenderControl.getFilter();
                    if (filter != null) {
                        n = -1941485657;
                        continue block6;
                    }
                    n = 405945390;
                    continue block6;
                }
                case -1941485657: {
                    appenderControl.removeFilter(filter);
                    if (filter instanceof LifeCycle) {
                        n = 1003068606;
                        continue block6;
                    }
                    n = 405945390;
                    continue block6;
                }
                case 405945390: {
                    return;
                }
                case 1003068606: 
            }
            ((LifeCycle)((Object)filter)).stop();
            n = 405945390;
        }
    }

    public List<AppenderRef> getAppenderRefs() {
        return this.appenderRefs;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public LogEventFactory getLogEventFactory() {
        return this.logEventFactory;
    }

    public void setLogEventFactory(LogEventFactory logEventFactory) {
        this.logEventFactory = logEventFactory;
    }

    public boolean isAdditive() {
        return this.additive;
    }

    public void setAdditive(boolean bl) {
        this.additive = bl;
    }

    public boolean isIncludeLocation() {
        return this.includeLocation;
    }

    public Map<Property, Boolean> getProperties() {
        return this.properties == null ? null : Collections.unmodifiableMap(this.properties);
    }

    public void log(String string, Marker marker, String string2, Level level, Message message, Throwable throwable) {
        ArrayList<Property> arrayList = null;
        if (this.properties != null) {
            arrayList = new ArrayList<Property>(this.properties.size());
            for (Map.Entry entry : this.properties.entrySet()) {
                Property property = (Property)entry.getKey();
                String string3 = (Boolean)entry.getValue() != false ? this.config.getStrSubstitutor().replace(property.getValue()) : property.getValue();
                arrayList.add(Property.createProperty(property.getName(), string3));
            }
        }
        LogEvent logEvent = this.logEventFactory.createEvent(string, marker, string2, level, message, arrayList, throwable);
        this.log(logEvent);
    }

    private synchronized void waitForCompletion() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        int n = 0;
        while (this.counter.get() > 0) {
            try {
                this.wait(1000L * (long)(n + 1));
            }
            catch (InterruptedException interruptedException) {
                if (++n <= 3) continue;
                break;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void log(LogEvent logEvent) {
        this.counter.incrementAndGet();
        try {
            if (this.isFiltered(logEvent)) {
                return;
            }
            logEvent.setIncludeLocation(this.isIncludeLocation());
            this.callAppenders(logEvent);
            if (this.additive && this.parent != null) {
                this.parent.log(logEvent);
            }
        }
        finally {
            if (this.counter.decrementAndGet() == 0) {
                LoggerConfig loggerConfig = this;
                synchronized (loggerConfig) {
                    if (this.shutdown) {
                        this.notifyAll();
                    }
                }
            }
        }
    }

    protected void callAppenders(LogEvent logEvent) {
        for (AppenderControl appenderControl : this.appenders.values()) {
            appenderControl.callAppender(logEvent);
        }
    }

    public String toString() {
        return Strings.isEmpty(this.name) ? "root" : this.name;
    }

    @PluginFactory
    public static LoggerConfig createLogger(@PluginAttribute(value="additivity") String string, @PluginAttribute(value="level") String string2, @PluginAttribute(value="name") String string3, @PluginAttribute(value="includeLocation") String string4, @PluginElement(value="AppenderRef") AppenderRef[] appenderRefArray, @PluginElement(value="Properties") Property[] propertyArray, @PluginConfiguration Configuration configuration, @PluginElement(value="Filters") Filter filter) {
        Level level;
        if (string3 == null) {
            LOGGER.error("Loggers cannot be configured without a name");
            return null;
        }
        List<AppenderRef> list = Arrays.asList(appenderRefArray);
        try {
            level = Level.toLevel(string2, Level.ERROR);
        }
        catch (Exception exception) {
            LOGGER.error("Invalid Log level specified: {}. Defaulting to Error", string2);
            level = Level.ERROR;
        }
        String string5 = string3.equals("root") ? "" : string3;
        boolean bl = Booleans.parseBoolean(string, true);
        return new LoggerConfig(string5, list, filter, level, bl, propertyArray, configuration, LoggerConfig.includeLocation(string4));
    }

    protected static boolean includeLocation(String string) {
        if (string == null) {
            boolean bl = !AsyncLoggerContextSelector.class.getName().equals(System.getProperty("Log4jContextSelector"));
            return bl;
        }
        return Boolean.parseBoolean(string);
    }

    static {
        String string = PropertiesUtil.getProperties().getStringProperty("Log4jLogEventFactory");
        if (string != null) {
            try {
                Class<?> clazz = Loader.loadClass(string);
                if (clazz != null && LogEventFactory.class.isAssignableFrom(clazz)) {
                    LOG_EVENT_FACTORY = (LogEventFactory)clazz.newInstance();
                }
            }
            catch (Exception exception) {
                LOGGER.error("Unable to create LogEventFactory " + string, (Throwable)exception);
            }
        }
        if (LOG_EVENT_FACTORY == null) {
            LOG_EVENT_FACTORY = new DefaultLogEventFactory();
        }
    }

    @Plugin(name="root", category="Core", printObject=true)
    public static class RootLogger
    extends LoggerConfig {
        @PluginFactory
        public static LoggerConfig createLogger(@PluginAttribute(value="additivity") String string, @PluginAttribute(value="level") String string2, @PluginAttribute(value="includeLocation") String string3, @PluginElement(value="AppenderRef") AppenderRef[] appenderRefArray, @PluginElement(value="Properties") Property[] propertyArray, @PluginConfiguration Configuration configuration, @PluginElement(value="Filters") Filter filter) {
            Level level;
            List<AppenderRef> list = Arrays.asList(appenderRefArray);
            try {
                level = Level.toLevel(string2, Level.ERROR);
            }
            catch (Exception exception) {
                LOGGER.error("Invalid Log level specified: {}. Defaulting to Error", string2);
                level = Level.ERROR;
            }
            boolean bl = Booleans.parseBoolean(string, true);
            return new LoggerConfig("", list, filter, level, bl, propertyArray, configuration, RootLogger.includeLocation(string3));
        }
    }
}

