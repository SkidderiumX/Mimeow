/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class OpenFileClickEvent
extends ClickEvent {
    private String path;

    public OpenFileClickEvent(String string) {
        super(ClickEventAction.OPEN_FILE);
        this.path = string;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("path", this.path).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof OpenFileClickEvent)) {
            return false;
        }
        OpenFileClickEvent openFileClickEvent = (OpenFileClickEvent)object;
        if (!openFileClickEvent.canEqual(this)) {
            return false;
        }
        String string = this.getPath();
        String string2 = openFileClickEvent.getPath();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof OpenFileClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getPath();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }
}

