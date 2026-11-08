/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.AchievementHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.TextHoverEvent;
import java.util.UUID;
import javax.annotation.Nullable;

public abstract class HoverEvent {
    protected HoverEventAction action;

    public static TextHoverEvent text(TextComponent textComponent) {
        return new TextHoverEvent(textComponent);
    }

    public static AchievementHoverEvent achievement(String string) {
        return new AchievementHoverEvent(string);
    }

    public static ItemHoverEvent item(Identifier identifier, int n, @Nullable CompoundTag compoundTag) {
        return new ItemHoverEvent(identifier, n, compoundTag);
    }

    public static EntityHoverEvent entity(Identifier identifier, UUID uUID, @Nullable TextComponent textComponent) {
        return new EntityHoverEvent(identifier, uUID, textComponent);
    }

    public HoverEvent(HoverEventAction hoverEventAction) {
        this.action = hoverEventAction;
    }

    public HoverEventAction getAction() {
        return this.action;
    }

    public abstract boolean equals(Object var1);

    public abstract int hashCode();

    public abstract String toString();
}

