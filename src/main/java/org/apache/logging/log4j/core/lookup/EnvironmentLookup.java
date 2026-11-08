/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.lookup;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

@Plugin(name="env", category="Lookup")
public class EnvironmentLookup
implements StrLookup {
    @Override
    public String lookup(String string) {
        return System.getenv(string);
    }

    @Override
    public String lookup(LogEvent logEvent, String string) {
        return System.getenv(string);
    }
}

