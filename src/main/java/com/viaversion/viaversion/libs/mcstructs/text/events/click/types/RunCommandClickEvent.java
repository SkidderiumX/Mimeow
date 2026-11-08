/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class RunCommandClickEvent
extends ClickEvent {
    private String command;

    public RunCommandClickEvent(String string) {
        super(ClickEventAction.RUN_COMMAND);
        this.command = string;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String string) {
        this.command = string;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("command", this.command).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof RunCommandClickEvent)) {
            return false;
        }
        RunCommandClickEvent runCommandClickEvent = (RunCommandClickEvent)object;
        if (!runCommandClickEvent.canEqual(this)) {
            return false;
        }
        String string = this.getCommand();
        String string2 = runCommandClickEvent.getCommand();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof RunCommandClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getCommand();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }
}

