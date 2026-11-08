/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.lookup;

import java.util.Map;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.message.MapMessage;

@Plugin(name="map", category="Lookup")
public class MapLookup
implements StrLookup {
    private final Map<String, String> map;

    public MapLookup(Map<String, String> map) {
        this.map = map;
    }

    public MapLookup() {
        this.map = null;
    }

    @Override
    public String lookup(String string) {
        if (this.map == null) {
            return null;
        }
        String string2 = this.map.get(string);
        if (string2 == null) {
            return null;
        }
        return string2;
    }

    @Override
    public String lookup(LogEvent logEvent, String string) {
        String string2;
        if (this.map == null && !(logEvent.getMessage() instanceof MapMessage)) {
            return null;
        }
        if (this.map != null && this.map.containsKey(string) && (string2 = this.map.get(string)) != null) {
            return string2;
        }
        if (logEvent.getMessage() instanceof MapMessage) {
            return ((MapMessage)logEvent.getMessage()).get(string);
        }
        return null;
    }
}

