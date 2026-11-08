/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import org.checkerframework.checker.nullness.qual.Nullable;

public class TextInput
implements Input {
    private final String key;
    private final @Nullable Tag label;
    private final String initial;
    private final int maxLength;
    private final @Nullable MultilineOptions[] options;
    private String value;

    public TextInput(CompoundTag compoundTag) {
        this.key = compoundTag.getString("key");
        this.label = compoundTag.getBoolean("label_visible", true) ? compoundTag.get("label") : null;
        this.initial = compoundTag.getString("initial", "");
        this.maxLength = compoundTag.getInt("max_length", 32);
        if (this.maxLength < 1) {
            throw new IllegalArgumentException("Max length must be at least 1, got: " + this.maxLength);
        }
        ListTag<CompoundTag> listTag = compoundTag.getListTag("multiline", CompoundTag.class);
        this.options = listTag != null && !listTag.isEmpty() ? (MultilineOptions[])listTag.stream().map(MultilineOptions::new).toArray(MultilineOptions[]::new) : null;
        this.value = this.initial;
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String asCommandSubstitution() {
        return this.value;
    }

    @Override
    public Tag asTag() {
        return new StringTag(this.value);
    }

    public @Nullable Tag label() {
        return this.label;
    }

    public String initial() {
        return this.initial;
    }

    public int maxLength() {
        return this.maxLength;
    }

    public @Nullable MultilineOptions[] options() {
        return this.options;
    }

    public String value() {
        return this.value;
    }

    public void setValue(String string) {
        if (string.length() > this.maxLength) {
            throw new IllegalArgumentException("Value exceeds max length of " + this.maxLength + ": " + string);
        }
        this.value = string;
    }

    public void setClampedValue(String string) {
        this.value = string.length() > this.maxLength ? string.substring(0, this.maxLength) : string;
    }

    public static class MultilineOptions {
        private final @Nullable Integer maxLines;

        public MultilineOptions(CompoundTag compoundTag) {
            IntTag intTag = compoundTag.getIntTag("max_lines");
            if (intTag != null && intTag.asInt() < 1) {
                throw new IllegalArgumentException("Max lines must be at least 1, got: " + String.valueOf(intTag));
            }
            this.maxLines = intTag != null ? Integer.valueOf(intTag.asInt()) : null;
        }

        public @Nullable Integer maxLines() {
            return this.maxLines;
        }
    }
}

