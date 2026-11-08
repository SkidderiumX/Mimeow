/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

import org.apache.logging.log4j.core.helpers.CachedClock;
import org.apache.logging.log4j.core.helpers.Clock;
import org.apache.logging.log4j.core.helpers.CoarseCachedClock;
import org.apache.logging.log4j.core.helpers.SystemClock;
import org.apache.logging.log4j.status.StatusLogger;

public class ClockFactory {
    public static final String PROPERTY_NAME = "log4j.Clock";
    private static final StatusLogger LOGGER = StatusLogger.getLogger();

    private ClockFactory() {
    }

    public static Clock getClock() {
        return ClockFactory.createClock();
    }

    private static Clock createClock() {
        String string = System.getProperty(PROPERTY_NAME);
        if (string == null || "SystemClock".equals(string)) {
            LOGGER.debug("Using default SystemClock for timestamps");
            return new SystemClock();
        }
        if (CachedClock.class.getName().equals(string) || "CachedClock".equals(string)) {
            LOGGER.debug("Using specified CachedClock for timestamps");
            return CachedClock.instance();
        }
        if (CoarseCachedClock.class.getName().equals(string) || "CoarseCachedClock".equals(string)) {
            LOGGER.debug("Using specified CoarseCachedClock for timestamps");
            return CoarseCachedClock.instance();
        }
        try {
            Clock clock = (Clock)Class.forName(string).newInstance();
            LOGGER.debug("Using {} for timestamps", string);
            return clock;
        }
        catch (Exception exception) {
            String string2 = "Could not create {}: {}, using default SystemClock for timestamps";
            LOGGER.error("Could not create {}: {}, using default SystemClock for timestamps", string, exception);
            return new SystemClock();
        }
    }
}

