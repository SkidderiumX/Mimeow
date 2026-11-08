/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.BaseConfiguration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.util.PropertiesUtil;

public class DefaultConfiguration
extends BaseConfiguration {
    public static final String DEFAULT_NAME = "Default";
    public static final String DEFAULT_LEVEL = "org.apache.logging.log4j.level";

    public DefaultConfiguration() {
        this.setName(DEFAULT_NAME);
        PatternLayout patternLayout = PatternLayout.createLayout("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n", null, null, null, null);
        ConsoleAppender consoleAppender = ConsoleAppender.createAppender(patternLayout, null, "SYSTEM_OUT", "Console", "false", "true");
        consoleAppender.start();
        this.addAppender(consoleAppender);
        LoggerConfig loggerConfig = this.getRootLogger();
        loggerConfig.addAppender(consoleAppender, null, null);
        String string = PropertiesUtil.getProperties().getStringProperty(DEFAULT_LEVEL);
        Level level = string != null && Level.valueOf(string) != null ? Level.valueOf(string) : Level.ERROR;
        loggerConfig.setLevel(level);
    }

    @Override
    protected void doConfigure() {
    }
}

