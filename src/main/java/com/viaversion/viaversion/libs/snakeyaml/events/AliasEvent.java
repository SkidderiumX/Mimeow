/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.events;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.events.Event;
import com.viaversion.viaversion.libs.snakeyaml.events.NodeEvent;

public class AliasEvent
extends NodeEvent {
    public AliasEvent(String string, Mark mark, Mark mark2) {
        super(string, mark, mark2);
        if (string == null) {
            throw new NullPointerException("anchor is not specified for alias");
        }
    }

    @Override
    public Event.ID getEventId() {
        return Event.ID.Alias;
    }
}

