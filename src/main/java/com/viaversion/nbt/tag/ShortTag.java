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

public class ShortTag
implements NumberTag {
    public static final int ID = 2;
    public static final ShortTag ZERO = new ShortTag(0);
    private final short value;

    public ShortTag(short s) {
        this.value = s;
    }

    public static ShortTag read(DataInput dataInput, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countShort();
        return new ShortTag(dataInput.readShort());
    }

    @Override
    @Deprecated
    public Short getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return Short.toString(this.value);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(this.value);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ShortTag shortTag = (ShortTag)object;
        return this.value == shortTag.value;
    }

    public int hashCode() {
        return this.value;
    }

    @Override
    public byte asByte() {
        return (byte)this.value;
    }

    @Override
    public short asShort() {
        return this.value;
    }

    @Override
    public int asInt() {
        return this.value;
    }

    @Override
    public long asLong() {
        return this.value;
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
        return 2;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

