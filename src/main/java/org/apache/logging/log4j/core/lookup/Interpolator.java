/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.lookup;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.apache.logging.log4j.core.config.plugins.PluginType;
import org.apache.logging.log4j.core.lookup.EnvironmentLookup;
import org.apache.logging.log4j.core.lookup.JndiLookup;
import org.apache.logging.log4j.core.lookup.MapLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.core.lookup.SystemPropertiesLookup;
import org.apache.logging.log4j.core.lookup.WebLookup;
import org.apache.logging.log4j.status.StatusLogger;

public class Interpolator
implements StrLookup {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final char PREFIX_SEPARATOR = ':';
    private final Map<String, StrLookup> lookups = new HashMap<String, StrLookup>();
    private final StrLookup defaultLookup;

    public Interpolator(StrLookup strLookup) {
        this.defaultLookup = strLookup == null ? new MapLookup(new HashMap<String, String>()) : strLookup;
        PluginManager pluginManager = new PluginManager("Lookup");
        pluginManager.collectPlugins();
        Map<String, PluginType<?>> map = pluginManager.getPlugins();
        for (Map.Entry<String, PluginType<?>> entry : map.entrySet()) {
            Class<?> clazz = entry.getValue().getPluginClass();
            try {
                this.lookups.put(entry.getKey(), (StrLookup)clazz.newInstance());
            }
            catch (Exception exception) {
                LOGGER.error("Unable to create Lookup for " + entry.getKey(), (Throwable)exception);
            }
        }
    }

    public Interpolator() {
        this.defaultLookup = new MapLookup(new HashMap<String, String>());
        this.lookups.put("sys", new SystemPropertiesLookup());
        this.lookups.put("env", new EnvironmentLookup());
        this.lookups.put("jndi", new JndiLookup());
        try {
            if (Class.forName("javax.servlet.ServletContext") != null) {
                this.lookups.put("web", new WebLookup());
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOGGER.debug("ServletContext not present - WebLookup not added");
        }
        catch (Exception exception) {
            LOGGER.error("Unable to locate ServletContext", (Throwable)exception);
        }
    }

    @Override
    public String lookup(String string) {
        return this.lookup(null, string);
    }

    @Override
    public String lookup(LogEvent logEvent, String string) {
        if (string == null) {
            return null;
        }
        int n = string.indexOf(58);
        if (n >= 0) {
            String string2 = string.substring(0, n);
            String string3 = string.substring(n + 1);
            StrLookup strLookup = this.lookups.get(string2);
            String string4 = null;
            if (strLookup != null) {
                String string5 = string4 = logEvent == null ? strLookup.lookup(string3) : strLookup.lookup(logEvent, string3);
            }
            if (string4 != null) {
                return string4;
            }
            string = string.substring(n + 1);
        }
        if (this.defaultLookup != null) {
            return logEvent == null ? this.defaultLookup.lookup(string) : this.defaultLookup.lookup(logEvent, string);
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : this.lookups.keySet()) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append("{");
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        }
        return stringBuilder.toString();
    }
}

