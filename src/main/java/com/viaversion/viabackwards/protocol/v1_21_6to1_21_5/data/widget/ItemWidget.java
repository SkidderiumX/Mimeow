/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.TextWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemWidget
implements Widget {
    private final CompoundTag item;
    private final @Nullable TextWidget description;
    private final boolean showTooltip;
    private final int width;
    private final int height;

    public ItemWidget(CompoundTag compoundTag) {
        this.item = compoundTag.getCompoundTag("item");
        if (this.item == null) {
            throw new IllegalArgumentException("Item tag is missing in ItemWidget tag: " + String.valueOf(compoundTag));
        }
        this.description = compoundTag.contains("description") ? new TextWidget(compoundTag.getCompoundTag("description")) : null;
        this.showTooltip = compoundTag.getBoolean("show_tooltip", true);
        int n = compoundTag.getInt("width", 16);
        int n2 = compoundTag.getInt("height", 16);
        if (n < 1 || n > 256) {
            throw new IllegalArgumentException("Width must be between 1 and 256, got: " + n);
        }
        if (n2 < 1 || n2 > 256) {
            throw new IllegalArgumentException("Height must be between 1 and 256, got: " + n2);
        }
        this.width = n;
        this.height = n2;
    }

    public CompoundTag item() {
        return this.item;
    }

    public @Nullable TextWidget description() {
        return this.description;
    }

    public boolean showTooltip() {
        return this.showTooltip;
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }
}

