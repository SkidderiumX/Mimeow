/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.NumberArrayTag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class LongArrayTag
implements NumberArrayTag {
    public static final int ID = 12;
    private static final long[] EMPTY_ARRAY = new long[0];
    private long[] value;

    public LongArrayTag() {
        this(EMPTY_ARRAY);
    }

    public LongArrayTag(long[] lArray) {
        if (lArray == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = lArray;
    }

    public static LongArrayTag read(DataInput dataInput, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countInt();
        int n = dataInput.readInt();
        tagLimiter.countBytes(8 * n);
        long[] lArray = new long[n];
        for (int i = 0; i < lArray.length; ++i) {
            lArray[i] = dataInput.readLong();
        }
        return new LongArrayTag(lArray);
    }

    public long[] getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return Arrays.toString(this.value);
    }

    public void setValue(long[] lArray) {
        if (lArray == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = lArray;
    }

    public long get(int n) {
        return this.value[n];
    }

    public void set(int n, long l) {
        this.value[n] = l;
    }

    @Override
    public int length() {
        return this.value.length;
    }

    public ListTag<LongTag> toListTag() {
        ListTag<LongTag> listTag = new ListTag<LongTag>(LongTag.class);
        for (long l : this.value) {
            listTag.add(new LongTag(l));
        }
        return listTag;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (long l : this.value) {
            dataOutput.writeLong(l);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        LongArrayTag longArrayTag = (LongArrayTag)object;
        return Arrays.equals(this.value, longArrayTag.value);
    }

    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    @Override
    public LongArrayTag copy() {
        return new LongArrayTag((long[])this.value.clone());
    }

    @Override
    public int getTagId() {
        return 12;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

