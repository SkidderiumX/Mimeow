/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover;

import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import java.util.function.BiPredicate;
import javax.annotation.Nullable;

public enum HoverEventAction implements NamedType
{
    SHOW_TEXT("show_text", true),
    SHOW_ACHIEVEMENT("show_achievement", true),
    SHOW_ITEM("show_item", true),
    SHOW_ENTITY("show_entity", true);

    private final String name;
    private final boolean userDefinable;

    @Nullable
    public static HoverEventAction byName(String string) {
        return HoverEventAction.byName(string, true);
    }

    @Nullable
    public static HoverEventAction byName(String string, boolean bl) {
        return HoverEventAction.byName(string, bl ? String::equalsIgnoreCase : String::equals);
    }

    @Nullable
    public static HoverEventAction byName(String string, BiPredicate<String, String> biPredicate) {
        for (HoverEventAction hoverEventAction : HoverEventAction.values()) {
            if (!biPredicate.test(string, hoverEventAction.getName())) continue;
            return hoverEventAction;
        }
        return null;
    }

    private HoverEventAction(String string2, boolean bl) {
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

