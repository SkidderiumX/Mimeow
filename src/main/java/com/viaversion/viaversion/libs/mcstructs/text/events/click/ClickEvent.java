/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.converter.SerializedData;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ChangePageClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.CopyToClipboardClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.CustomClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenFileClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenUrlClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.RunCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ShowDialogClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.SuggestCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.TwitchUserInfoClickEvent;
import java.net.URI;
import javax.annotation.Nullable;

public abstract class ClickEvent {
    protected final ClickEventAction action;

    public static OpenUrlClickEvent openUrl(String string) {
        return new OpenUrlClickEvent(string);
    }

    public static OpenUrlClickEvent openUrl(URI uRI) {
        return new OpenUrlClickEvent(uRI);
    }

    public static OpenFileClickEvent openFile(String string) {
        return new OpenFileClickEvent(string);
    }

    public static RunCommandClickEvent runCommand(String string) {
        return new RunCommandClickEvent(string);
    }

    public static TwitchUserInfoClickEvent twitchUserInfo(String string) {
        return new TwitchUserInfoClickEvent(string);
    }

    public static SuggestCommandClickEvent suggestCommand(String string) {
        return new SuggestCommandClickEvent(string);
    }

    public static ChangePageClickEvent changePage(int n) {
        return new ChangePageClickEvent(n);
    }

    public static CopyToClipboardClickEvent copyToClipboard(String string) {
        return new CopyToClipboardClickEvent(string);
    }

    public static ShowDialogClickEvent showDialog(SerializedData<?> serializedData) {
        return new ShowDialogClickEvent(serializedData);
    }

    public static CustomClickEvent custom(Identifier identifier, @Nullable Tag tag) {
        return new CustomClickEvent(identifier, tag);
    }

    public ClickEvent(ClickEventAction clickEventAction) {
        this.action = clickEventAction;
    }

    public ClickEventAction getAction() {
        return this.action;
    }

    public abstract boolean equals(Object var1);

    public abstract int hashCode();

    public abstract String toString();
}

