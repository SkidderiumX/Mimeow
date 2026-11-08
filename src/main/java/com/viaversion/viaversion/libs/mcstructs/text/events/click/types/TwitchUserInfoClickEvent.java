/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class TwitchUserInfoClickEvent
extends ClickEvent {
    private String user;

    public TwitchUserInfoClickEvent(String string) {
        super(ClickEventAction.TWITCH_USER_INFO);
        this.user = string;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String string) {
        this.user = string;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("user", this.user).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TwitchUserInfoClickEvent)) {
            return false;
        }
        TwitchUserInfoClickEvent twitchUserInfoClickEvent = (TwitchUserInfoClickEvent)object;
        if (!twitchUserInfoClickEvent.canEqual(this)) {
            return false;
        }
        String string = this.getUser();
        String string2 = twitchUserInfoClickEvent.getUser();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof TwitchUserInfoClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getUser();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }
}

