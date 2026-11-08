/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import java.util.HashMap;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AbstractOutputStreamAppender;
import org.apache.logging.log4j.core.appender.FileManager;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.net.Advertiser;

@Plugin(name="File", category="Core", elementType="appender", printObject=true)
public class FileAppender
extends AbstractOutputStreamAppender {
    private final String fileName;
    private final Advertiser advertiser;
    private Object advertisement;

    private FileAppender(String string, Layout<? extends Serializable> layout, Filter filter, FileManager fileManager, String string2, boolean bl, boolean bl2, Advertiser advertiser) {
        super(string, layout, filter, bl, bl2, fileManager);
        if (advertiser != null) {
            HashMap<String, String> hashMap = new HashMap<String, String>(layout.getContentFormat());
            hashMap.putAll(fileManager.getContentFormat());
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

    public String getFileName() {
        return this.fileName;
    }

    @PluginFactory
    public static FileAppender createAppender(@PluginAttribute(value="fileName") String string, @PluginAttribute(value="append") String string2, @PluginAttribute(value="locking") String string3, @PluginAttribute(value="name") String string4, @PluginAttribute(value="immediateFlush") String string5, @PluginAttribute(value="ignoreExceptions") String string6, @PluginAttribute(value="bufferedIO") String string7, @PluginElement(value="Layout") Layout<? extends Serializable> patternLayout, @PluginElement(value="Filters") Filter filter, @PluginAttribute(value="advertise") String string8, @PluginAttribute(value="advertiseURI") String string9, @PluginConfiguration Configuration configuration) {
        FileManager fileManager;
        boolean bl = Booleans.parseBoolean(string2, true);
        boolean bl2 = Boolean.parseBoolean(string3);
        boolean bl3 = Booleans.parseBoolean(string7, true);
        boolean bl4 = Boolean.parseBoolean(string8);
        if (bl2 && bl3) {
            if (string7 != null) {
                LOGGER.warn("Locking and buffering are mutually exclusive. No buffering will occur for " + string);
            }
            bl3 = false;
        }
        boolean bl5 = Booleans.parseBoolean(string5, true);
        boolean bl6 = Booleans.parseBoolean(string6, true);
        if (string4 == null) {
            LOGGER.error("No name provided for FileAppender");
            return null;
        }
        if (string == null) {
            LOGGER.error("No filename provided for FileAppender with name " + string4);
            return null;
        }
        if (patternLayout == null) {
            patternLayout = PatternLayout.createLayout(null, null, null, null, null);
        }
        if ((fileManager = FileManager.getFileManager(string, bl, bl2, bl3, string9, patternLayout)) == null) {
            return null;
        }
        return new FileAppender(string4, patternLayout, filter, fileManager, string, bl6, bl5, bl4 ? configuration.getAdvertiser() : null);
    }
}

