/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.internal;

public class Logger {
    private final java.util.logging.Logger logger;

    private Logger(String string) {
        this.logger = java.util.logging.Logger.getLogger(string);
    }

    public static Logger getLogger(String string) {
        return new Logger(string);
    }

    public boolean isLoggable(Level level) {
        return this.logger.isLoggable(level.level);
    }

    public void warn(String string) {
        this.logger.log(Level.WARNING.level, string);
    }

    public void debug(String string) {
        this.logger.log(Level.DEBUG.level, string);
    }

    public static enum Level {
        WARNING(java.util.logging.Level.WARNING),
        DEBUG(java.util.logging.Level.FINE);

        private final java.util.logging.Level level;

        private Level(java.util.logging.Level level) {
            this.level = level;
        }
    }
}

