/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StringTag
implements Tag {
    public static final int ID = 8;
    private String value;

    public StringTag() {
        this("");
    }

    public StringTag(String string) {
        if (string == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = string;
    }

    public static StringTag read(DataInput dataInput, TagLimiter tagLimiter) throws IOException {
        String string = dataInput.readUTF();
        tagLimiter.countBytes(2 * string.length());
        return new StringTag(string);
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return this.value;
    }

    public void setValue(String string) {
        if (string == null) {
            throw new NullPointerException("value cannot be null");
        }
        this.value = string;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.value);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        StringTag stringTag = (StringTag)object;
        return this.value.equals(stringTag.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public StringTag copy() {
        return new StringTag(this.value);
    }

    @Override
    public int getTagId() {
        return 8;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}

