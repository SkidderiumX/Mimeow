/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import java.io.File;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.JSONConfiguration;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.plugins.Plugin;

@Plugin(name="JSONConfigurationFactory", category="ConfigurationFactory")
@Order(value=6)
public class JSONConfigurationFactory
extends ConfigurationFactory {
    public static final String[] SUFFIXES = new String[]{".json", ".jsn"};
    private static String[] dependencies = new String[]{"com.fasterxml.jackson.databind.ObjectMapper", "com.fasterxml.jackson.databind.JsonNode", "com.fasterxml.jackson.core.JsonParser"};
    private final File configFile = null;
    private boolean isActive;

    public JSONConfigurationFactory() {
        try {
            for (String string : dependencies) {
                Class.forName(string);
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOGGER.debug("Missing dependencies for Json support");
            this.isActive = false;
            return;
        }
        this.isActive = true;
    }

    @Override
    protected boolean isActive() {
        return this.isActive;
    }

    @Override
    public Configuration getConfiguration(ConfigurationFactory.ConfigurationSource configurationSource) {
        if (!this.isActive) {
            return null;
        }
        return new JSONConfiguration(configurationSource);
    }

    @Override
    public String[] getSupportedTypes() {
        return SUFFIXES;
    }
}

