/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Integers;

@Plugin(name="TimeBasedTriggeringPolicy", category="Core", printObject=true)
public class TimeBasedTriggeringPolicy
implements TriggeringPolicy {
    private long nextRollover;
    private final int interval;
    private final boolean modulate;
    private RollingFileManager manager;

    private TimeBasedTriggeringPolicy(int n, boolean bl) {
        this.interval = n;
        this.modulate = bl;
    }

    @Override
    public void initialize(RollingFileManager rollingFileManager) {
        this.manager = rollingFileManager;
        this.nextRollover = rollingFileManager.getPatternProcessor().getNextTime(rollingFileManager.getFileTime(), this.interval, this.modulate);
    }

    @Override
    public boolean isTriggeringEvent(LogEvent logEvent) {
        if (this.manager.getFileSize() == 0L) {
            return false;
        }
        long l = System.currentTimeMillis();
        if (l > this.nextRollover) {
            this.nextRollover = this.manager.getPatternProcessor().getNextTime(l, this.interval, this.modulate);
            return true;
        }
        return false;
    }

    public String toString() {
        return "TimeBasedTriggeringPolicy";
    }

    @PluginFactory
    public static TimeBasedTriggeringPolicy createPolicy(@PluginAttribute(value="interval") String string, @PluginAttribute(value="modulate") String string2) {
        int n = Integers.parseInt(string, 1);
        boolean bl = Boolean.parseBoolean(string2);
        return new TimeBasedTriggeringPolicy(n, bl);
    }
}

