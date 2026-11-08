/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.converter.SerializedData;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class ShowDialogClickEvent
extends ClickEvent {
    private SerializedData<?> dialogData;

    public ShowDialogClickEvent(SerializedData<?> serializedData) {
        super(ClickEventAction.SHOW_DIALOG);
        this.dialogData = serializedData;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("dialogData", this.dialogData).toString();
    }

    @Generated
    public SerializedData<?> getDialogData() {
        return this.dialogData;
    }

    @Generated
    public void setDialogData(SerializedData<?> serializedData) {
        this.dialogData = serializedData;
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ShowDialogClickEvent)) {
            return false;
        }
        ShowDialogClickEvent showDialogClickEvent = (ShowDialogClickEvent)object;
        if (!showDialogClickEvent.canEqual(this)) {
            return false;
        }
        SerializedData<?> serializedData = this.getDialogData();
        SerializedData<?> serializedData2 = showDialogClickEvent.getDialogData();
        return !(serializedData == null ? serializedData2 != null : !((Object)serializedData).equals(serializedData2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof ShowDialogClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        SerializedData<?> serializedData = this.getDialogData();
        n2 = n2 * 59 + (serializedData == null ? 43 : ((Object)serializedData).hashCode());
        return n2;
    }
}

