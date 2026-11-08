/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.lookup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="date", category="Lookup")
public class DateLookup
implements StrLookup {
    private static final Logger LOGGER = StatusLogger.getLogger();

    @Override
    public String lookup(String string) {
        return this.formatDate(System.currentTimeMillis(), string);
    }

    @Override
    public String lookup(LogEvent logEvent, String string) {
        return this.formatDate(logEvent.getMillis(), string);
    }

    private String formatDate(long l, String string) {
        DateFormat dateFormat = null;
        if (string != null) {
            try {
                dateFormat = new SimpleDateFormat(string);
            }
            catch (Exception exception) {
                LOGGER.error("Invalid date format: \"" + string + "\", using default", (Throwable)exception);
            }
        }
        if (dateFormat == null) {
            dateFormat = DateFormat.getInstance();
        }
        return dateFormat.format(new Date(l));
    }
}

