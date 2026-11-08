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

public class ByteTag
implements NumberTag {
    public static final int ID = 1;
    public static final ByteTag ZERO = new ByteTag(0);
    private final byte value;

    public ByteTag(byte by) {
        this.value = by;
    }

    public ByteTag(boolean bl) {
        this.value = (byte)(bl ? 1 : 0);
    }

    public static ByteTag read(DataInput dataInput, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countByte();
        return new ByteTag(dataInput.readByte());
    }

    @Override
    @Deprecated
    public Byte getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return Byte.toString(this.value);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.value);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ByteTag byteTag = (ByteTag)object;
        return this.value == byteTag.value;
    }

    public int hashCode() {
        return this.value;
    }

    @Override
    public byte asByte() {
        return this.value;
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
        return 1;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

