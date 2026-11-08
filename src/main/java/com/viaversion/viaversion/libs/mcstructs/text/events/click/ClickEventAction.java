/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click;

import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import java.util.function.BiPredicate;
import javax.annotation.Nullable;

public enum ClickEventAction implements NamedType
{
    OPEN_URL("open_url", true),
    OPEN_FILE("open_file", false),
    RUN_COMMAND("run_command", true),
    TWITCH_USER_INFO("twitch_user_info", false),
    SUGGEST_COMMAND("suggest_command", true),
    CHANGE_PAGE("change_page", true),
    COPY_TO_CLIPBOARD("copy_to_clipboard", true),
    SHOW_DIALOG("show_dialog", true),
    CUSTOM("custom", true);

    private final String name;
    private final boolean userDefinable;

    @Nullable
    public static ClickEventAction byName(String string) {
        return ClickEventAction.byName(string, true);
    }

    @Nullable
    public static ClickEventAction byName(String string, boolean bl) {
        return ClickEventAction.byName(string, bl ? String::equalsIgnoreCase : String::equals);
    }

    @Nullable
    public static ClickEventAction byName(String string, BiPredicate<String, String> biPredicate) {
        for (ClickEventAction clickEventAction : ClickEventAction.values()) {
            if (!biPredicate.test(string, clickEventAction.getName())) continue;
            return clickEventAction;
        }
        return null;
    }

    private ClickEventAction(String string2, boolean bl) {
        this.name = string2;
        this.userDefinable = bl;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public boolean isUserDefinable() {
        return this.userDefinable;
    }
}

