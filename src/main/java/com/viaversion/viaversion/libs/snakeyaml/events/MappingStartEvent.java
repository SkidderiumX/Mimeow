/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.events;

import com.viaversion.viaversion.libs.snakeyaml.DumperOptions;
import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.events.CollectionStartEvent;
import com.viaversion.viaversion.libs.snakeyaml.events.Event;

public class MappingStartEvent
extends CollectionStartEvent {
    public MappingStartEvent(String string, String string2, boolean bl, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(string, string2, bl, mark, mark2, flowStyle);
    }

    @Override
    public Event.ID getEventId() {
        return Event.ID.MappingStart;
    }
}

