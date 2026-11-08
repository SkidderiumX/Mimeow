/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberArrayTag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayTag
implements NumberArrayTag {
    public static final int ID = 7;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private byte[] value;

    public ByteArrayTag() {
        this(EMPTY_ARRAY);
    }

    public ByteArrayTag(byte[] byArray) {
        if (byArray == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = byArray;
    }

    public static ByteArrayTag read(DataInput dataInput, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countInt();
        int n = dataInput.readInt();
        tagLimiter.countBytes(n);
        byte[] byArray = new byte[n];
        dataInput.readFully(byArray);
        return new ByteArrayTag(byArray);
    }

    public byte[] getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return Arrays.toString(this.value);
    }

    public void setValue(byte[] byArray) {
        if (byArray == null) {
            return;
        }
        this.value = byArray;
    }

    public byte get(int n) {
        return this.value[n];
    }

    public void set(int n, byte by) {
        this.value[n] = by;
    }

    @Override
    public int length() {
        return this.value.length;
    }

    public ListTag<ByteTag> toListTag() {
        ListTag<ByteTag> listTag = new ListTag<ByteTag>(ByteTag.class);
        for (byte by : this.value) {
            listTag.add(new ByteTag(by));
        }
        return listTag;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        dataOutput.write(this.value);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ByteArrayTag byteArrayTag = (ByteArrayTag)object;
        return Arrays.equals(this.value, byteArrayTag.value);
    }

    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    @Override
    public ByteArrayTag copy() {
        return new ByteArrayTag((byte[])this.value.clone());
    }

    @Override
    public int getTagId() {
        return 7;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

