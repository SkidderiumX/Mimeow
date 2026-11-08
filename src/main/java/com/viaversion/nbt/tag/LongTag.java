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

public class LongTag
implements NumberTag {
    public static final int ID = 4;
    public static final LongTag ZERO = new LongTag(0L);
    private final long value;

    public LongTag(long l) {
        this.value = l;
    }

    public static LongTag read(DataInput dataInput, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countLong();
        return new LongTag(dataInput.readLong());
    }

    @Override
    @Deprecated
    public Long getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return Long.toString(this.value);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.value);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        LongTag longTag = (LongTag)object;
        return this.value == longTag.value;
    }

    public int hashCode() {
        return Long.hashCode(this.value);
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
        return 4;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

