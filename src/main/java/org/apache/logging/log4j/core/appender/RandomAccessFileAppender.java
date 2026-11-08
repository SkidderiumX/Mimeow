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
import org.apache.logging.log4j.core.appender.RandomAccessFileManager;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.net.Advertiser;

@Plugin(name="RandomAccessFile", category="Core", elementType="appender", printObject=true)
public class RandomAccessFileAppender
extends AbstractOutputStreamAppender {
    private final String fileName;
    private Object advertisement;
    private final Advertiser advertiser;

    private RandomAccessFileAppender(String string, Layout<? extends Serializable> layout, Filter filter, RandomAccessFileManager randomAccessFileManager, String string2, boolean bl, boolean bl2, Advertiser advertiser) {
        super(string, layout, filter, bl, bl2, randomAccessFileManager);
        if (advertiser != null) {
            HashMap<String, String> hashMap = new HashMap<String, String>(layout.getContentFormat());
            hashMap.putAll(randomAccessFileManager.getContentFormat());
            hashMap.put("contentType", layout.getContentType());
            hashMap.put("name", string);
            this.advertisement = advertiser.advertise(hashMap);
        }
        this.fileName = string2;
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
        ((RandomAccessFileManager)this.getManager()).setEndOfBatch(logEvent.isEndOfBatch());
        super.append(logEvent);
    }

    public String getFileName() {
        return this.fileName;
    }

    @PluginFactory
    public static RandomAccessFileAppender createAppender(@PluginAttribute(value="fileName") String string, @PluginAttribute(value="append") String string2, @PluginAttribute(value="name") String string3, @PluginAttribute(value="immediateFlush") String string4, @PluginAttribute(value="ignoreExceptions") String string5, @PluginElement(value="Layout") Layout<? extends Serializable> patternLayout, @PluginElement(value="Filters") Filter filter, @PluginAttribute(value="advertise") String string6, @PluginAttribute(value="advertiseURI") String string7, @PluginConfiguration Configuration configuration) {
        RandomAccessFileManager randomAccessFileManager;
        boolean bl = Booleans.parseBoolean(string2, true);
        boolean bl2 = Booleans.parseBoolean(string4, true);
        boolean bl3 = Booleans.parseBoolean(string5, true);
        boolean bl4 = Boolean.parseBoolean(string6);
        if (string3 == null) {
            LOGGER.error("No name provided for FileAppender");
            return null;
        }
        if (string == null) {
            LOGGER.error("No filename provided for FileAppender with name " + string3);
            return null;
        }
        if (patternLayout == null) {
            patternLayout = PatternLayout.createLayout(null, null, null, null, null);
        }
        if ((randomAccessFileManager = RandomAccessFileManager.getFileManager(string, bl, bl2, string7, patternLayout)) == null) {
            return null;
        }
        return new RandomAccessFileAppender(string3, patternLayout, filter, randomAccessFileManager, string, bl3, bl2, bl4 ? configuration.getAdvertiser() : null);
    }
}

