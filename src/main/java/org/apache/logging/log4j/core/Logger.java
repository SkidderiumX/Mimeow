/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.filter.CompositeFilter;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.spi.AbstractLogger;

public class Logger
extends AbstractLogger {
    protected volatile PrivateConfig config;
    private final LoggerContext context;

    protected Logger(LoggerContext loggerContext, String string, MessageFactory messageFactory) {
        super(string, messageFactory);
        this.context = loggerContext;
        this.config = new PrivateConfig(loggerContext.getConfiguration(), this);
    }

    public Logger getParent() {
        LoggerConfig loggerConfig;
        LoggerConfig loggerConfig2 = loggerConfig = this.config.loggerConfig.getName().equals(this.getName()) ? this.config.loggerConfig.getParent() : this.config.loggerConfig;
        if (loggerConfig == null) {
            return null;
        }
        if (this.context.hasLogger(loggerConfig.getName())) {
            return this.context.getLogger(loggerConfig.getName(), this.getMessageFactory());
        }
        return new Logger(this.context, loggerConfig.getName(), this.getMessageFactory());
    }

    public LoggerContext getContext() {
        return this.context;
    }

    public synchronized void setLevel(Level level) {
        if (level != null) {
            this.config = new PrivateConfig(this.config, level);
        }
    }

    public Level getLevel() {
        return this.config.level;
    }

    @Override
    public void log(Marker marker, String string, Level level, Message message, Throwable throwable) {
        if (message == null) {
            message = new SimpleMessage("");
        }
        this.config.config.getConfigurationMonitor().checkConfiguration();
        this.config.loggerConfig.log(this.getName(), marker, string, level, message, throwable);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String string) {
        return this.config.filter(level, marker, string);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String string, Throwable throwable) {
        return this.config.filter(level, marker, string, throwable);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, String string, Object ... objectArray) {
        return this.config.filter(level, marker, string, objectArray);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, Object object, Throwable throwable) {
        return this.config.filter(level, marker, object, throwable);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker, Message message, Throwable throwable) {
        return this.config.filter(level, marker, message, throwable);
    }

    public void addAppender(Appender appender) {
        this.config.config.addLoggerAppender(this, appender);
    }

    public void removeAppender(Appender appender) {
        this.config.loggerConfig.removeAppender(appender.getName());
    }

    public Map<String, Appender> getAppenders() {
        return this.config.loggerConfig.getAppenders();
    }

    public Iterator<Filter> getFilters() {
        Filter filter = this.config.loggerConfig.getFilter();
        if (filter == null) {
            return new ArrayList().iterator();
        }
        if (filter instanceof CompositeFilter) {
            return ((CompositeFilter)filter).iterator();
        }
        ArrayList<Filter> arrayList = new ArrayList<Filter>();
        arrayList.add(filter);
        return arrayList.iterator();
    }

    public int filterCount() {
        Filter filter = this.config.loggerConfig.getFilter();
        if (filter == null) {
            return 0;
        }
        if (filter instanceof CompositeFilter) {
            return ((CompositeFilter)filter).size();
        }
        return 1;
    }

    public void addFilter(Filter filter) {
        this.config.config.addLoggerFilter(this, filter);
    }

    public boolean isAdditive() {
        return this.config.loggerConfig.isAdditive();
    }

    public void setAdditive(boolean bl) {
        this.config.config.setLoggerAdditive(this, bl);
    }

    void updateConfiguration(Configuration configuration) {
        this.config = new PrivateConfig(configuration, this);
    }

    @Override
    public String toString() {
        String string = "" + this.getName() + ":" + (Object)((Object)this.getLevel());
        if (this.context == null) {
            return string;
        }
        String string2 = this.context.getName();
        return string2 == null ? string : string + " in " + string2;
    }

    protected class PrivateConfig {
        public final LoggerConfig loggerConfig;
        public final Configuration config;
        private final Level level;
        private final int intLevel;
        private final Logger logger;

        public PrivateConfig(Configuration configuration, Logger logger2) {
            this.config = configuration;
            this.loggerConfig = configuration.getLoggerConfig(Logger.this.getName());
            this.level = this.loggerConfig.getLevel();
            this.intLevel = this.level.intLevel();
            this.logger = logger2;
        }

        public PrivateConfig(PrivateConfig privateConfig, Level level) {
            this.config = privateConfig.config;
            this.loggerConfig = privateConfig.loggerConfig;
            this.level = level;
            this.intLevel = this.level.intLevel();
            this.logger = privateConfig.logger;
        }

        public PrivateConfig(PrivateConfig privateConfig, LoggerConfig loggerConfig) {
            this.config = privateConfig.config;
            this.loggerConfig = loggerConfig;
            this.level = loggerConfig.getLevel();
            this.intLevel = this.level.intLevel();
            this.logger = privateConfig.logger;
        }

        public void logEvent(LogEvent logEvent) {
            this.config.getConfigurationMonitor().checkConfiguration();
            this.loggerConfig.log(logEvent);
        }

        boolean filter(Level level, Marker marker, String string) {
            Filter.Result result;
            this.config.getConfigurationMonitor().checkConfiguration();
            Filter filter = this.config.getFilter();
            if (filter != null && (result = filter.filter(this.logger, level, marker, string, new Object[0])) != Filter.Result.NEUTRAL) {
                return result == Filter.Result.ACCEPT;
            }
            return this.intLevel >= level.intLevel();
        }

        boolean filter(Level level, Marker marker, String string, Throwable throwable) {
            Filter.Result result;
            this.config.getConfigurationMonitor().checkConfiguration();
            Filter filter = this.config.getFilter();
            if (filter != null && (result = filter.filter(this.logger, level, marker, (Object)string, throwable)) != Filter.Result.NEUTRAL) {
                return result == Filter.Result.ACCEPT;
            }
            return this.intLevel >= level.intLevel();
        }

        boolean filter(Level level, Marker marker, String string, Object ... objectArray) {
            Filter.Result result;
            this.config.getConfigurationMonitor().checkConfiguration();
            Filter filter = this.config.getFilter();
            if (filter != null && (result = filter.filter(this.logger, level, marker, string, objectArray)) != Filter.Result.NEUTRAL) {
                return result == Filter.Result.ACCEPT;
            }
            return this.intLevel >= level.intLevel();
        }

        boolean filter(Level level, Marker marker, Object object, Throwable throwable) {
            Filter.Result result;
            this.config.getConfigurationMonitor().checkConfiguration();
            Filter filter = this.config.getFilter();
            if (filter != null && (result = filter.filter(this.logger, level, marker, object, throwable)) != Filter.Result.NEUTRAL) {
                return result == Filter.Result.ACCEPT;
            }
            return this.intLevel >= level.intLevel();
        }

        boolean filter(Level level, Marker marker, Message message, Throwable throwable) {
            Filter.Result result;
            this.config.getConfigurationMonitor().checkConfiguration();
            Filter filter = this.config.getFilter();
            if (filter != null && (result = filter.filter(this.logger, level, marker, message, throwable)) != Filter.Result.NEUTRAL) {
                return result == Filter.Result.ACCEPT;
            }
            return this.intLevel >= level.intLevel();
        }
    }
}

