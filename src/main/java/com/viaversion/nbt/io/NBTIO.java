/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.io;

import com.viaversion.nbt.io.TagReader;
import com.viaversion.nbt.io.TagRegistry;
import com.viaversion.nbt.io.TagWriter;
import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.tag.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.jetbrains.annotations.Nullable;

public class NBTIO {
    private NBTIO() {
    }

    public static TagReader<Tag> reader() {
        return new TagReader<Tag>(null);
    }

    public static <T extends Tag> TagReader<T> reader(Class<T> clazz) {
        return new TagReader<T>(clazz);
    }

    public static TagWriter writer() {
        return new TagWriter();
    }

    public static <T extends Tag> T readTag(DataInput dataInput, TagLimiter tagLimiter, boolean bl, @Nullable Class<T> clazz) throws IOException {
        byte by = dataInput.readByte();
        if (clazz != null && clazz != TagRegistry.getClassFor(by)) {
            throw new IOException("Expected tag type " + clazz.getSimpleName() + " but got " + TagRegistry.getClassFor(by).getSimpleName());
        }
        if (bl) {
            dataInput.skipBytes(dataInput.readUnsignedShort());
        }
        return (T)TagRegistry.read(by, dataInput, tagLimiter, 0);
    }

    public static void writeTag(DataOutput dataOutput, Tag tag, boolean bl) throws IOException {
        dataOutput.writeByte(tag.getTagId());
        if (bl) {
            dataOutput.writeUTF("");
        }
        tag.write(dataOutput);
    }
}

