/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAliases;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="AppenderRef", category="Core", printObject=true)
@PluginAliases(value={"appender-ref"})
public class AppenderRef {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final String ref;
    private final Level level;
    private final Filter filter;

    private AppenderRef(String string, Level level, Filter filter) {
        this.ref = string;
        this.level = level;
        this.filter = filter;
    }

    public String getRef() {
        return this.ref;
    }

    public Level getLevel() {
        return this.level;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String toString() {
        return this.ref;
    }

    @PluginFactory
    public static AppenderRef createAppenderRef(@PluginAttribute(value="ref") String string, @PluginAttribute(value="level") String string2, @PluginElement(value="Filters") Filter filter) {
        if (string == null) {
            LOGGER.error("Appender references must contain a reference");
            return null;
        }
        Level level = null;
        if (string2 != null && (level = Level.toLevel(string2, null)) == null) {
            LOGGER.error("Invalid level " + string2 + " on Appender reference " + string);
        }
        return new AppenderRef(string, level, filter);
    }
}

