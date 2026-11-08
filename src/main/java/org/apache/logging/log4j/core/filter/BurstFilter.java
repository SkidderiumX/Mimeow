/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.filter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

@Plugin(name="BurstFilter", category="Core", elementType="filter", printObject=true)
public class BurstFilter
extends AbstractFilter {
    private static final long NANOS_IN_SECONDS = 1000000000L;
    private static final int DEFAULT_RATE = 10;
    private static final int DEFAULT_RATE_MULTIPLE = 100;
    private static final int HASH_SHIFT = 32;
    private final Level level;
    private final long burstInterval;
    private final DelayQueue<LogDelay> history = new DelayQueue();
    private final Queue<LogDelay> available = new ConcurrentLinkedQueue<LogDelay>();

    private BurstFilter(Level level, float f, long l, Filter.Result result, Filter.Result result2) {
        super(result, result2);
        this.level = level;
        this.burstInterval = (long)(1.0E9f * ((float)l / f));
        int n = 0;
        while ((long)n < l) {
            this.available.add(new LogDelay());
            ++n;
        }
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object ... objectArray) {
        return this.filter(level);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Object object, Throwable throwable) {
        return this.filter(level);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
        return this.filter(level);
    }

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        return this.filter(logEvent.getLevel());
    }

    private Filter.Result filter(Level level) {
        if (this.level.isAtLeastAsSpecificAs(level)) {
            LogDelay logDelay = (LogDelay)this.history.poll();
            while (logDelay != null) {
                this.available.add(logDelay);
                logDelay = (LogDelay)this.history.poll();
            }
            logDelay = this.available.poll();
            if (logDelay != null) {
                logDelay.setDelay(this.burstInterval);
                this.history.add(logDelay);
                return this.onMatch;
            }
            return this.onMismatch;
        }
        return this.onMatch;
    }

    public int getAvailable() {
        return this.available.size();
    }

    public void clear() {
        for (LogDelay logDelay : this.history) {
            this.history.remove(logDelay);
            this.available.add(logDelay);
        }
    }

    @Override
    public String toString() {
        return "level=" + this.level.toString() + ", interval=" + this.burstInterval + ", max=" + this.history.size();
    }

    @PluginFactory
    public static BurstFilter createFilter(@PluginAttribute(value="level") String string, @PluginAttribute(value="rate") String string2, @PluginAttribute(value="maxBurst") String string3, @PluginAttribute(value="onMatch") String string4, @PluginAttribute(value="onMismatch") String string5) {
        float f;
        Filter.Result result = Filter.Result.toResult(string4, Filter.Result.NEUTRAL);
        Filter.Result result2 = Filter.Result.toResult(string5, Filter.Result.DENY);
        Level level = Level.toLevel(string, Level.WARN);
        float f2 = f = string2 == null ? 10.0f : Float.parseFloat(string2);
        if (f <= 0.0f) {
            f = 10.0f;
        }
        long l = string3 == null ? (long)(f * 100.0f) : Long.parseLong(string3);
        return new BurstFilter(level, f, l, result, result2);
    }

    private class LogDelay
    implements Delayed {
        private long expireTime;

        public void setDelay(long l) {
            this.expireTime = l + System.nanoTime();
        }

        @Override
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.expireTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed delayed) {
            if (this.expireTime < ((LogDelay)delayed).expireTime) {
                return -1;
            }
            if (this.expireTime > ((LogDelay)delayed).expireTime) {
                return 1;
            }
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            LogDelay logDelay = (LogDelay)object;
            return this.expireTime == logDelay.expireTime;
        }

        public int hashCode() {
            return (int)(this.expireTime ^ this.expireTime >>> 32);
        }
    }
}

