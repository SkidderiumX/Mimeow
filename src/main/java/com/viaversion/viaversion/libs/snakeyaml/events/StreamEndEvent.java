/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.events;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.events.Event;

public class StreamEndEvent
extends Event {
    public StreamEndEvent(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override
    public Event.ID getEventId() {
        return Event.ID.StreamEnd;
    }
}

