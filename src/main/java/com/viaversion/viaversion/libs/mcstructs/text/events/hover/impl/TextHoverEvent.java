/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import lombok.Generated;

public class TextHoverEvent
extends HoverEvent {
    private TextComponent text;

    public TextHoverEvent(TextComponent textComponent) {
        super(HoverEventAction.SHOW_TEXT);
        this.text = textComponent;
    }

    public TextComponent getText() {
        return this.text;
    }

    public TextHoverEvent setText(TextComponent textComponent) {
        this.text = textComponent;
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("text", this.text).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextHoverEvent)) {
            return false;
        }
        TextHoverEvent textHoverEvent = (TextHoverEvent)object;
        if (!textHoverEvent.canEqual(this)) {
            return false;
        }
        TextComponent textComponent = this.getText();
        TextComponent textComponent2 = textHoverEvent.getText();
        return !(textComponent == null ? textComponent2 != null : !((Object)textComponent).equals(textComponent2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof TextHoverEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        TextComponent textComponent = this.getText();
        n2 = n2 * 59 + (textComponent == null ? 43 : ((Object)textComponent).hashCode());
        return n2;
    }
}

