/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.events;

import com.viaversion.viaversion.libs.snakeyaml.DumperOptions;
import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.events.Event;
import com.viaversion.viaversion.libs.snakeyaml.events.ImplicitTuple;
import com.viaversion.viaversion.libs.snakeyaml.events.NodeEvent;

public class ScalarEvent
extends NodeEvent {
    private final String tag;
    private final DumperOptions.ScalarStyle style;
    private final String value;
    private final ImplicitTuple implicit;

    public ScalarEvent(String string, String string2, ImplicitTuple implicitTuple, String string3, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(string, mark, mark2);
        this.tag = string2;
        this.implicit = implicitTuple;
        if (string3 == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.value = string3;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.style = scalarStyle;
    }

    public String getTag() {
        return this.tag;
    }

    public DumperOptions.ScalarStyle getScalarStyle() {
        return this.style;
    }

    public String getValue() {
        return this.value;
    }

    public ImplicitTuple getImplicit() {
        return this.implicit;
    }

    @Override
    protected String getArguments() {
        return super.getArguments() + ", tag=" + this.tag + ", style=" + (Object)((Object)this.style) + "," + this.implicit + ", value=" + this.value;
    }

    @Override
    public Event.ID getEventId() {
        return Event.ID.Scalar;
    }

    public boolean isPlain() {
        return this.style == DumperOptions.ScalarStyle.PLAIN;
    }

    public boolean isLiteral() {
        return this.style == DumperOptions.ScalarStyle.LITERAL;
    }

    public boolean isSQuoted() {
        return this.style == DumperOptions.ScalarStyle.SINGLE_QUOTED;
    }

    public boolean isDQuoted() {
        return this.style == DumperOptions.ScalarStyle.DOUBLE_QUOTED;
    }

    public boolean isFolded() {
        return this.style == DumperOptions.ScalarStyle.FOLDED;
    }

    public boolean isJson() {
        return this.style == DumperOptions.ScalarStyle.JSON_SCALAR_STYLE;
    }
}

