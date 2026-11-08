/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProtocolLogger {
    private final Logger logger;
    private final String name;

    public ProtocolLogger(Class<? extends Protocol> clazz) {
        this(Via.getPlatform().getLogger(), clazz);
    }

    public ProtocolLogger(Logger logger, Class<? extends Protocol> clazz) {
        this.logger = logger;
        this.name = ProtocolUtil.toNiceName(clazz);
    }

    public void log(Level level, String string) {
        this.logger.log(level, this.formatMessage(string));
    }

    public void log(Level level, String string, Throwable throwable) {
        this.logger.log(level, this.formatMessage(string), throwable);
    }

    public void warning(String string) {
        this.logger.warning(this.formatMessage(string));
    }

    public void severe(String string) {
        this.logger.severe(this.formatMessage(string));
    }

    private String formatMessage(String string) {
        return "(" + this.name + ") " + string;
    }
}

