/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

public class SingleOptionInput
implements Input {
    private final String key;
    private final Entry[] options;
    private final @Nullable Tag label;
    private int value;

    public SingleOptionInput(CompoundTag compoundTag) {
        ListTag<CompoundTag> listTag = compoundTag.getListTag("options", CompoundTag.class);
        if (listTag == null || listTag.isEmpty()) {
            throw new IllegalArgumentException("Options must not be empty in tag: " + String.valueOf(compoundTag));
        }
        this.key = compoundTag.getString("key");
        this.options = (Entry[])listTag.stream().map(Entry::new).toArray(Entry[]::new);
        this.label = compoundTag.getBoolean("label_visible", true) ? compoundTag.get("label") : null;
        for (int i = 0; i < this.options.length; ++i) {
            if (!this.options[i].initial()) continue;
            if (this.value != 0) {
                throw new IllegalArgumentException("Multiple initial options found in tag: " + String.valueOf(compoundTag));
            }
            this.value = i;
        }
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String asCommandSubstitution() {
        return this.options[this.value].id;
    }

    @Override
    public Tag asTag() {
        return new StringTag(this.asCommandSubstitution());
    }

    public Entry[] options() {
        return this.options;
    }

    public @Nullable Tag label() {
        return this.label;
    }

    public int value() {
        return this.value;
    }

    public void setValue(int n) {
        if (n < 0 || n >= this.options.length) {
            throw new IllegalArgumentException("Value must be between 0 and " + (this.options.length - 1));
        }
        this.value = n;
    }

    public void setClampedValue(int n) {
        this.value = n < 0 ? 0 : (n >= this.options.length ? 0 : n);
    }

    public static class Entry {
        private final String id;
        private final Tag display;
        private final boolean initial;

        public Entry(CompoundTag compoundTag) {
            this.id = compoundTag.getString("id");
            this.display = compoundTag.get("display");
            this.initial = compoundTag.getBoolean("initial", false);
        }

        public String id() {
            return this.id;
        }

        public Tag display() {
            return this.display;
        }

        public boolean initial() {
            return this.initial;
        }

        public Tag computeDisplay() {
            return Objects.requireNonNullElseGet(this.display, () -> new StringTag(this.id));
        }
    }
}

