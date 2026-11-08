/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.NumberTag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FloatTag
implements NumberTag {
    public static final int ID = 5;
    public static final FloatTag ZERO = new FloatTag(0.0f);
    private final float value;

    public FloatTag(float f) {
        this.value = f;
    }

    public static FloatTag read(DataInput dataInput, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countFloat();
        return new FloatTag(dataInput.readFloat());
    }

    @Override
    @Deprecated
    public Float getValue() {
        return Float.valueOf(this.value);
    }

    @Override
    public String asRawString() {
        return Float.toString(this.value);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.value);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        FloatTag floatTag = (FloatTag)object;
        return this.value == floatTag.value;
    }

    public int hashCode() {
        return Float.hashCode(this.value);
    }

    @Override
    public byte asByte() {
        return (byte)this.value;
    }

    @Override
    public short asShort() {
        return (short)this.value;
    }

    @Override
    public int asInt() {
        return (int)this.value;
    }

    @Override
    public long asLong() {
        return (long)this.value;
    }

    @Override
    public float asFloat() {
        return this.value;
    }

    @Override
    public double asDouble() {
        return this.value;
    }

    @Override
    public int getTagId() {
        return 5;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

