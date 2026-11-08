/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jdbc;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="Column", category="Core", printObject=true)
public class ColumnConfig {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final String columnName;
    private final PatternLayout layout;
    private final String literalValue;
    private final boolean eventTimestamp;
    private final boolean unicode;
    private final boolean clob;

    private ColumnConfig(String string, PatternLayout patternLayout, String string2, boolean bl, boolean bl2, boolean bl3) {
        this.columnName = string;
        this.layout = patternLayout;
        this.literalValue = string2;
        this.eventTimestamp = bl;
        this.unicode = bl2;
        this.clob = bl3;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public PatternLayout getLayout() {
        return this.layout;
    }

    public String getLiteralValue() {
        return this.literalValue;
    }

    public boolean isEventTimestamp() {
        return this.eventTimestamp;
    }

    public boolean isUnicode() {
        return this.unicode;
    }

    public boolean isClob() {
        return this.clob;
    }

    public String toString() {
        return "{ name=" + this.columnName + ", layout=" + this.layout + ", literal=" + this.literalValue + ", timestamp=" + this.eventTimestamp + " }";
    }

    @PluginFactory
    public static ColumnConfig createColumnConfig(@PluginConfiguration Configuration configuration, @PluginAttribute(value="name") String string, @PluginAttribute(value="pattern") String string2, @PluginAttribute(value="literal") String string3, @PluginAttribute(value="isEventTimestamp") String string4, @PluginAttribute(value="isUnicode") String string5, @PluginAttribute(value="isClob") String string6) {
        if (Strings.isEmpty(string)) {
            LOGGER.error("The column config is not valid because it does not contain a column name.");
            return null;
        }
        boolean bl = Strings.isNotEmpty(string2);
        boolean bl2 = Strings.isNotEmpty(string3);
        boolean bl3 = Boolean.parseBoolean(string4);
        boolean bl4 = Booleans.parseBoolean(string5, true);
        boolean bl5 = Boolean.parseBoolean(string6);
        if (bl && bl2 || bl && bl3 || bl2 && bl3) {
            LOGGER.error("The pattern, literal, and isEventTimestamp attributes are mutually exclusive.");
            return null;
        }
        if (bl3) {
            return new ColumnConfig(string, null, null, true, false, false);
        }
        if (bl2) {
            return new ColumnConfig(string, null, string3, false, false, false);
        }
        if (bl) {
            return new ColumnConfig(string, PatternLayout.createLayout(string2, configuration, null, null, "false"), null, false, bl4, bl5);
        }
        LOGGER.error("To configure a column you must specify a pattern or literal or set isEventDate to true.");
        return null;
    }
}

