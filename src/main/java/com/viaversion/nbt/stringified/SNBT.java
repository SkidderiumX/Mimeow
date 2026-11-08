/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.stringified;

import com.viaversion.nbt.stringified.CharBuffer;
import com.viaversion.nbt.stringified.StringifiedTagParseException;
import com.viaversion.nbt.stringified.TagStringReader;
import com.viaversion.nbt.stringified.TagStringWriter;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;

public class SNBT {
    private SNBT() {
    }

    public static Tag deserialize(String string) {
        CharBuffer charBuffer = new CharBuffer(string);
        TagStringReader tagStringReader = new TagStringReader(charBuffer);
        Tag tag = tagStringReader.tag();
        if (charBuffer.skipWhitespace().hasMore()) {
            throw new StringifiedTagParseException("Input has trailing content", charBuffer.index());
        }
        return tag;
    }

    public static CompoundTag deserializeCompoundTag(String string) {
        CharBuffer charBuffer = new CharBuffer(string);
        TagStringReader tagStringReader = new TagStringReader(charBuffer);
        CompoundTag compoundTag = tagStringReader.compound();
        if (charBuffer.skipWhitespace().hasMore()) {
            throw new StringifiedTagParseException("Input has trailing content", charBuffer.index());
        }
        return compoundTag;
    }

    public static String serialize(Tag tag) {
        StringBuilder stringBuilder = new StringBuilder();
        TagStringWriter tagStringWriter = new TagStringWriter(stringBuilder);
        tagStringWriter.writeTag(tag);
        return stringBuilder.toString();
    }
}

