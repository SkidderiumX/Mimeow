/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.AppenderControl;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;

@Plugin(name="Failover", category="Core", elementType="appender", printObject=true)
public class FailoverAppender
extends AbstractAppender {
    private static final int DEFAULT_INTERVAL_SECONDS = 60;
    private final String primaryRef;
    private final String[] failovers;
    private final Configuration config;
    private AppenderControl primary;
    private final List<AppenderControl> failoverAppenders = new ArrayList<AppenderControl>();
    private final long intervalMillis;
    private long nextCheckMillis = 0L;
    private volatile boolean failure = false;

    private FailoverAppender(String string, Filter filter, String string2, String[] stringArray, int n, Configuration configuration, boolean bl) {
        super(string, filter, null, bl);
        this.primaryRef = string2;
        this.failovers = stringArray;
        this.config = configuration;
        this.intervalMillis = n;
    }

    @Override
    public void start() {
        Map<String, Appender> map = this.config.getAppenders();
        int n = 0;
        if (map.containsKey(this.primaryRef)) {
            this.primary = new AppenderControl(map.get(this.primaryRef), null, null);
        } else {
            LOGGER.error("Unable to locate primary Appender " + this.primaryRef);
            ++n;
        }
        for (String string : this.failovers) {
            if (map.containsKey(string)) {
                this.failoverAppenders.add(new AppenderControl(map.get(string), null, null));
                continue;
            }
            LOGGER.error("Failover appender " + string + " is not configured");
        }
        if (this.failoverAppenders.size() == 0) {
            LOGGER.error("No failover appenders are available");
            ++n;
        }
        if (n == 0) {
            super.start();
        }
    }

    @Override
    public void append(LogEvent logEvent) {
        if (!this.isStarted()) {
            this.error("FailoverAppender " + this.getName() + " did not start successfully");
            return;
        }
        if (!this.failure) {
            this.callAppender(logEvent);
        } else {
            long l = System.currentTimeMillis();
            if (l >= this.nextCheckMillis) {
                this.callAppender(logEvent);
            } else {
                this.failover(logEvent, null);
            }
        }
    }

    private void callAppender(LogEvent logEvent) {
        try {
            this.primary.callAppender(logEvent);
        }
        catch (Exception exception) {
            this.nextCheckMillis = System.currentTimeMillis() + this.intervalMillis;
            this.failure = true;
            this.failover(logEvent, exception);
        }
    }

    private void failover(LogEvent logEvent, Exception exception) {
        LoggingException loggingException = exception != null ? (exception instanceof LoggingException ? (LoggingException)exception : new LoggingException(exception)) : null;
        boolean bl = false;
        Exception exception2 = null;
        for (AppenderControl appenderControl : this.failoverAppenders) {
            try {
                appenderControl.callAppender(logEvent);
                bl = true;
                break;
            }
            catch (Exception exception3) {
                if (exception2 != null) continue;
                exception2 = exception3;
            }
        }
        if (!bl && !this.ignoreExceptions()) {
            if (loggingException != null) {
                throw loggingException;
            }
            throw new LoggingException("Unable to write to failover appenders", exception2);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getName());
        stringBuilder.append(" primary=").append(this.primary).append(", failover={");
        boolean bl = true;
        for (String string : this.failovers) {
            if (!bl) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
            bl = false;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @PluginFactory
    public static FailoverAppender createAppender(@PluginAttribute(value="name") String string, @PluginAttribute(value="primary") String string2, @PluginElement(value="Failovers") String[] stringArray, @PluginAttribute(value="retryInterval") String string3, @PluginConfiguration Configuration configuration, @PluginElement(value="Filters") Filter filter, @PluginAttribute(value="ignoreExceptions") String string4) {
        int n;
        if (string == null) {
            LOGGER.error("A name for the Appender must be specified");
            return null;
        }
        if (string2 == null) {
            LOGGER.error("A primary Appender must be specified");
            return null;
        }
        if (stringArray == null || stringArray.length == 0) {
            LOGGER.error("At least one failover Appender must be specified");
            return null;
        }
        int n2 = FailoverAppender.parseInt(string3, 60);
        if (n2 >= 0) {
            n = n2 * 1000;
        } else {
            LOGGER.warn("Interval " + string3 + " is less than zero. Using default");
            n = 60000;
        }
        boolean bl = Booleans.parseBoolean(string4, true);
        return new FailoverAppender(string, filter, string2, stringArray, n, configuration, bl);
    }
}

