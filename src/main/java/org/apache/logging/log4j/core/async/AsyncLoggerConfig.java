/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.async;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.async.AsyncLoggerConfigHelper;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;

@Plugin(name="asyncLogger", category="Core", printObject=true)
public class AsyncLoggerConfig
extends LoggerConfig {
    private AsyncLoggerConfigHelper helper;

    public AsyncLoggerConfig() {
    }

    public AsyncLoggerConfig(String string, Level level, boolean bl) {
        super(string, level, bl);
    }

    protected AsyncLoggerConfig(String string, List<AppenderRef> list, Filter filter, Level level, boolean bl, Property[] propertyArray, Configuration configuration, boolean bl2) {
        super(string, list, filter, level, bl, propertyArray, configuration, bl2);
    }

    @Override
    protected void callAppenders(LogEvent logEvent) {
        logEvent.getSource();
        logEvent.getThreadName();
        this.helper.callAppendersFromAnotherThread(logEvent);
    }

    void asyncCallAppenders(LogEvent logEvent) {
        super.callAppenders(logEvent);
    }

    @Override
    public void startFilter() {
        if (this.helper == null) {
            this.helper = new AsyncLoggerConfigHelper(this);
        } else {
            AsyncLoggerConfigHelper.claim();
        }
        super.startFilter();
    }

    @Override
    public void stopFilter() {
        AsyncLoggerConfigHelper.release();
        super.stopFilter();
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
        return new AsyncLoggerConfig(string5, list, filter, level, bl, propertyArray, configuration, AsyncLoggerConfig.includeLocation(string4));
    }

    protected static boolean includeLocation(String string) {
        return Boolean.parseBoolean(string);
    }

    @Plugin(name="asyncRoot", category="Core", printObject=true)
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
            return new AsyncLoggerConfig("", list, filter, level, bl, propertyArray, configuration, RootLogger.includeLocation(string3));
        }
    }
}

