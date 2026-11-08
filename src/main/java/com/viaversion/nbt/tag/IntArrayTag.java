/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberArrayTag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class IntArrayTag
implements NumberArrayTag {
    public static final int ID = 11;
    private static final int[] EMPTY_ARRAY = new int[0];
    private int[] value;

    public IntArrayTag() {
        this(EMPTY_ARRAY);
    }

    public IntArrayTag(int[] nArray) {
        if (nArray == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = nArray;
    }

    public static IntArrayTag read(DataInput dataInput, TagLimiter tagLimiter) throws IOException {
        tagLimiter.countInt();
        int n = dataInput.readInt();
        tagLimiter.countBytes(4 * n);
        int[] nArray = new int[n];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = dataInput.readInt();
        }
        return new IntArrayTag(nArray);
    }

    public int[] getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return Arrays.toString(this.value);
    }

    public void setValue(int[] nArray) {
        if (nArray == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = nArray;
    }

    public int get(int n) {
        return this.value[n];
    }

    public void set(int n, int n2) {
        this.value[n] = n2;
    }

    @Override
    public int length() {
        return this.value.length;
    }

    public ListTag<IntTag> toListTag() {
        ListTag<IntTag> listTag = new ListTag<IntTag>(IntTag.class);
        for (int n : this.value) {
            listTag.add(new IntTag(n));
        }
        return listTag;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (int n : this.value) {
            dataOutput.writeInt(n);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        IntArrayTag intArrayTag = (IntArrayTag)object;
        return Arrays.equals(this.value, intArrayTag.value);
    }

    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    @Override
    public IntArrayTag copy() {
        return new IntArrayTag((int[])this.value.clone());
    }

    @Override
    public int getTagId() {
        return 11;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

