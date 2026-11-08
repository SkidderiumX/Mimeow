/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.lookup;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

@Plugin(name="sys", category="Lookup")
public class SystemPropertiesLookup
implements StrLookup {
    @Override
    public String lookup(String string) {
        try {
            return System.getProperty(string);
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Override
    public String lookup(LogEvent logEvent, String string) {
        try {
            return System.getProperty(string);
        }
        catch (Exception exception) {
            return null;
        }
    }
}

