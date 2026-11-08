/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

public class StreamStartEvent
extends Event {
    public StreamStartEvent(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override
    public Event.ID getEventId() {
        return Event.ID.StreamStart;
    }
}

