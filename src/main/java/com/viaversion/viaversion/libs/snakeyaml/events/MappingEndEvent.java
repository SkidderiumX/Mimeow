/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.events;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.events.CollectionEndEvent;
import com.viaversion.viaversion.libs.snakeyaml.events.Event;

public class MappingEndEvent
extends CollectionEndEvent {
    public MappingEndEvent(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override
    public Event.ID getEventId() {
        return Event.ID.MappingEnd;
    }
}

