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
import org.apache.logging.log4j.core.appender.rolling.RollingRandomAccessFileManager;
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

@Plugin(name="RollingRandomAccessFile", category="Core", elementType="appender", printObject=true)
public class RollingRandomAccessFileAppender
extends AbstractOutputStreamAppender {
    private final String fileName;
    private final String filePattern;
    private Object advertisement;
    private final Advertiser advertiser;

    private RollingRandomAccessFileAppender(String string, Layout<? extends Serializable> layout, Filter filter, RollingFileManager rollingFileManager, String string2, String string3, boolean bl, boolean bl2, Advertiser advertiser) {
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
        RollingRandomAccessFileManager rollingRandomAccessFileManager = (RollingRandomAccessFileManager)this.getManager();
        rollingRandomAccessFileManager.checkRollover(logEvent);
        rollingRandomAccessFileManager.setEndOfBatch(logEvent.isEndOfBatch());
        super.append(logEvent);
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePattern() {
        return this.filePattern;
    }

    @PluginFactory
    public static RollingRandomAccessFileAppender createAppender(@PluginAttribute(value="fileName") String string, @PluginAttribute(value="filePattern") String string2, @PluginAttribute(value="append") String string3, @PluginAttribute(value="name") String string4, @PluginAttribute(value="immediateFlush") String string5, @PluginElement(value="Policy") TriggeringPolicy triggeringPolicy, @PluginElement(value="Strategy") RolloverStrategy rolloverStrategy, @PluginElement(value="Layout") Layout<? extends Serializable> patternLayout, @PluginElement(value="Filter") Filter filter, @PluginAttribute(value="ignoreExceptions") String string6, @PluginAttribute(value="advertise") String string7, @PluginAttribute(value="advertiseURI") String string8, @PluginConfiguration Configuration configuration) {
        RollingRandomAccessFileManager rollingRandomAccessFileManager;
        boolean bl = Booleans.parseBoolean(string3, true);
        boolean bl2 = Booleans.parseBoolean(string6, true);
        boolean bl3 = Booleans.parseBoolean(string5, true);
        boolean bl4 = Boolean.parseBoolean(string7);
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
        if ((rollingRandomAccessFileManager = RollingRandomAccessFileManager.getRollingRandomAccessFileManager(string, string2, bl, bl3, triggeringPolicy, rolloverStrategy, string8, patternLayout)) == null) {
            return null;
        }
        return new RollingRandomAccessFileAppender(string4, patternLayout, filter, rollingRandomAccessFileManager, string, string2, bl2, bl3, bl4 ? configuration.getAdvertiser() : null);
    }
}

