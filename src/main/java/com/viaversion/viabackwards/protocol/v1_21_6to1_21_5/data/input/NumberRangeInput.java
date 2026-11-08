/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import com.viaversion.viabackwards.utils.ChatUtil;

public class NumberRangeInput
implements Input {
    private final String key;
    private final Tag label;
    private final String labelFormat;
    private final float start;
    private final float end;
    private final Float initial;
    private final Float step;
    private float value;

    public NumberRangeInput(CompoundTag compoundTag) {
        this.key = compoundTag.getString("key");
        this.label = compoundTag.get("label");
        this.labelFormat = compoundTag.getString("label_format", "options.generic_value");
        this.start = compoundTag.getFloat("start");
        this.end = compoundTag.getFloat("end");
        this.initial = Float.valueOf(compoundTag.getFloat("initial", (this.start + this.end) / 2.0f));
        FloatTag floatTag = compoundTag.getFloatTag("step");
        if (floatTag != null && floatTag.asFloat() < 0.0f) {
            throw new IllegalArgumentException("Step must be non-negative, got: " + floatTag.asFloat());
        }
        this.step = Float.valueOf(floatTag == null ? -1.0f : floatTag.asFloat());
        this.value = this.initial.floatValue();
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String asCommandSubstitution() {
        return this.valueAsString();
    }

    @Override
    public Tag asTag() {
        return new FloatTag(this.value);
    }

    public Tag label() {
        return this.label;
    }

    public String labelFormat() {
        return this.labelFormat;
    }

    public float start() {
        return this.start;
    }

    public float end() {
        return this.end;
    }

    public float initial() {
        return this.initial.floatValue();
    }

    public float step() {
        return this.step.floatValue();
    }

    public float value() {
        return this.value;
    }

    public String valueAsString() {
        int n = (int)this.value;
        return (float)n == this.value ? Integer.toString(n) : Float.toString(this.value);
    }

    public void setValue(float f) {
        this.value = f;
    }

    public void setClampedValue(float f) {
        this.value = f < this.start ? this.start : Math.min(f, this.end);
    }

    public Tag displayName() {
        return ChatUtil.translate(this.labelFormat, this.label, ChatUtil.translate(this.valueAsString()));
    }
}

