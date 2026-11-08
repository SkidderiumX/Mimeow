/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class CopyToClipboardClickEvent
extends ClickEvent {
    private String value;

    public CopyToClipboardClickEvent(String string) {
        super(ClickEventAction.COPY_TO_CLIPBOARD);
        this.value = string;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String string) {
        this.value = string;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("value", this.value).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CopyToClipboardClickEvent)) {
            return false;
        }
        CopyToClipboardClickEvent copyToClipboardClickEvent = (CopyToClipboardClickEvent)object;
        if (!copyToClipboardClickEvent.canEqual(this)) {
            return false;
        }
        String string = this.getValue();
        String string2 = copyToClipboardClickEvent.getValue();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof CopyToClipboardClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getValue();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }
}

