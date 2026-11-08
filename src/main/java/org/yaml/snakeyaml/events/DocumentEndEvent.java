/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

public class DocumentEndEvent
extends Event {
    private final boolean explicit;

    public DocumentEndEvent(Mark mark, Mark mark2, boolean bl) {
        super(mark, mark2);
        this.explicit = bl;
    }

    public boolean getExplicit() {
        return this.explicit;
    }

    @Override
    public Event.ID getEventId() {
        return Event.ID.DocumentEnd;
    }
}

