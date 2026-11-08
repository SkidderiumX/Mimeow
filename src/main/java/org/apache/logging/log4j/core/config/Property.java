/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.config.plugins.PluginValue;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="property", category="Core", printObject=true)
public class Property {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final String name;
    private final String value;

    private Property(String string, String string2) {
        this.name = string;
        this.value = string2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    @PluginFactory
    public static Property createProperty(@PluginAttribute(value="name") String string, @PluginValue(value="value") String string2) {
        if (string == null) {
            LOGGER.error("Property key cannot be null");
        }
        return new Property(string, string2);
    }

    public String toString() {
        return this.name + "=" + this.value;
    }
}

