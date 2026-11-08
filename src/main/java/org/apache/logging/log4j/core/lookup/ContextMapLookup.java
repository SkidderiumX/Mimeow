/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.lookup;

import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

@Plugin(name="ctx", category="Lookup")
public class ContextMapLookup
implements StrLookup {
    @Override
    public String lookup(String string) {
        return ThreadContext.get(string);
    }

    @Override
    public String lookup(LogEvent logEvent, String string) {
        return logEvent.getContextMap().get(string);
    }
}

