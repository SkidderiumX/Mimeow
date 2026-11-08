/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.status;

import java.io.PrintStream;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.status.StatusData;
import org.apache.logging.log4j.status.StatusListener;
import org.apache.logging.log4j.util.PropertiesUtil;

public class StatusConsoleListener
implements StatusListener {
    private static final String STATUS_LEVEL = "org.apache.logging.log4j.StatusLevel";
    private Level level = Level.FATAL;
    private String[] filters = null;
    private final PrintStream stream;

    public StatusConsoleListener() {
        String string = PropertiesUtil.getProperties().getStringProperty(STATUS_LEVEL);
        if (string != null) {
            this.level = Level.toLevel(string, Level.FATAL);
        }
        this.stream = System.out;
    }

    public StatusConsoleListener(Level level) {
        this.level = level;
        this.stream = System.out;
    }

    public StatusConsoleListener(Level level, PrintStream printStream) {
        this.level = level;
        this.stream = printStream;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public Level getStatusLevel() {
        return this.level;
    }

    @Override
    public void log(StatusData statusData) {
        if (!this.filtered(statusData)) {
            this.stream.println(statusData.getFormattedStatus());
        }
    }

    public void setFilters(String ... stringArray) {
        this.filters = stringArray;
    }

    private boolean filtered(StatusData statusData) {
        if (this.filters == null) {
            return false;
        }
        String string = statusData.getStackTraceElement().getClassName();
        for (String string2 : this.filters) {
            if (!string.startsWith(string2)) continue;
            return true;
        }
        return false;
    }
}

