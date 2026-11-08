/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import java.util.HashMap;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractOutputStreamAppender;
import org.apache.logging.log4j.core.appender.rolling.DefaultRolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.RolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.net.Advertiser;

@Plugin(name="RollingFile", category="Core", elementType="appender", printObject=true)
public class RollingFileAppender
extends AbstractOutputStreamAppender {
    private final String fileName;
    private final String filePattern;
    private Object advertisement;
    private final Advertiser advertiser;

    private RollingFileAppender(String string, Layout<? extends Serializable> layout, Filter filter, RollingFileManager rollingFileManager, String string2, String string3, boolean bl, boolean bl2, Advertiser advertiser) {
        super(string, layout, filter, bl, bl2, rollingFileManager);
        if (advertiser != null) {
            HashMap<String, String> hashMap = new HashMap<String, String>(layout.getContentFormat());
            hashMap.put("contentType", layout.getContentType());
            hashMap.put("name", string);
            this.advertisement = advertiser.advertise(hashMap);
        }
        this.fileName = string2;
        this.filePattern = string3;
        this.advertiser = advertiser;
    }

    @Override
    public void stop() {
        super.stop();
        if (this.advertiser != null) {
            this.advertiser.unadvertise(this.advertisement);
        }
    }

    @Override
    public void append(LogEvent logEvent) {
        ((RollingFileManager)this.getManager()).checkRollover(logEvent);
        super.append(logEvent);
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePattern() {
        return this.filePattern;
    }

    @PluginFactory
    public static RollingFileAppender createAppender(@PluginAttribute(value="fileName") String string, @PluginAttribute(value="filePattern") String string2, @PluginAttribute(value="append") String string3, @PluginAttribute(value="name") String string4, @PluginAttribute(value="bufferedIO") String string5, @PluginAttribute(value="immediateFlush") String string6, @PluginElement(value="Policy") TriggeringPolicy triggeringPolicy, @PluginElement(value="Strategy") RolloverStrategy rolloverStrategy, @PluginElement(value="Layout") Layout<? extends Serializable> patternLayout, @PluginElement(value="Filter") Filter filter, @PluginAttribute(value="ignoreExceptions") String string7, @PluginAttribute(value="advertise") String string8, @PluginAttribute(value="advertiseURI") String string9, @PluginConfiguration Configuration configuration) {
        RollingFileManager rollingFileManager;
        boolean bl = Booleans.parseBoolean(string3, true);
        boolean bl2 = Booleans.parseBoolean(string7, true);
        boolean bl3 = Booleans.parseBoolean(string5, true);
        boolean bl4 = Booleans.parseBoolean(string6, true);
        boolean bl5 = Boolean.parseBoolean(string8);
        if (string4 == null) {
            LOGGER.error("No name provided for FileAppender");
            return null;
        }
        if (string == null) {
            LOGGER.error("No filename was provided for FileAppender with name " + string4);
            return null;
        }
        if (string2 == null) {
            LOGGER.error("No filename pattern provided for FileAppender with name " + string4);
            return null;
        }
        if (triggeringPolicy == null) {
            LOGGER.error("A TriggeringPolicy must be provided");
            return null;
        }
        if (rolloverStrategy == null) {
            rolloverStrategy = DefaultRolloverStrategy.createStrategy(null, null, null, String.valueOf(-1), configuration);
        }
        if (patternLayout == null) {
            patternLayout = PatternLayout.createLayout(null, null, null, null, null);
        }
        if ((rollingFileManager = RollingFileManager.getFileManager(string, string2, bl, bl3, triggeringPolicy, rolloverStrategy, string9, patternLayout)) == null) {
            return null;
        }
        return new RollingFileAppender(string4, patternLayout, filter, rollingFileManager, string, string2, bl2, bl4, bl5 ? configuration.getAdvertiser() : null);
    }
}

