/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import javax.annotation.Nullable;
import lombok.Generated;

public class CustomClickEvent
extends ClickEvent {
    private Identifier id;
    @Nullable
    private Tag payload;

    public CustomClickEvent(Identifier identifier, @Nullable Tag tag) {
        super(ClickEventAction.CUSTOM);
        this.id = identifier;
        this.payload = tag;
    }

    @Override
    public String toString() {
        return "";
    }

    @Generated
    public Identifier getId() {
        return this.id;
    }

    @Nullable
    @Generated
    public Tag getPayload() {
        return this.payload;
    }

    @Generated
    public void setId(Identifier identifier) {
        this.id = identifier;
    }

    @Generated
    public void setPayload(@Nullable Tag tag) {
        this.payload = tag;
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CustomClickEvent)) {
            return false;
        }
        CustomClickEvent customClickEvent = (CustomClickEvent)object;
        if (!customClickEvent.canEqual(this)) {
            return false;
        }
        Identifier identifier = this.getId();
        Identifier identifier2 = customClickEvent.getId();
        if (identifier == null ? identifier2 != null : !((Object)identifier).equals(identifier2)) {
            return false;
        }
        Tag tag = this.getPayload();
        Tag tag2 = customClickEvent.getPayload();
        return !(tag == null ? tag2 != null : !tag.equals(tag2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof CustomClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        Identifier identifier = this.getId();
        n2 = n2 * 59 + (identifier == null ? 43 : ((Object)identifier).hashCode());
        Tag tag = this.getPayload();
        n2 = n2 * 59 + (tag == null ? 43 : tag.hashCode());
        return n2;
    }
}

