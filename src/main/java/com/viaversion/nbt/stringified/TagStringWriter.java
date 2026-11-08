/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.stringified;

import com.viaversion.nbt.stringified.Tokens;
import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import java.util.Map;

public class TagStringWriter {
    private final StringBuilder out;
    private boolean needsSeparator;

    public TagStringWriter(StringBuilder stringBuilder) {
        this.out = stringBuilder;
    }

    public TagStringWriter writeTag(Tag tag) {
        if (tag instanceof CompoundTag) {
            return this.writeCompound((CompoundTag)tag);
        }
        if (tag instanceof ListTag) {
            return this.writeList((ListTag)tag);
        }
        if (tag instanceof ByteArrayTag) {
            return this.writeByteArray((ByteArrayTag)tag);
        }
        if (tag instanceof IntArrayTag) {
            return this.writeIntArray((IntArrayTag)tag);
        }
        if (tag instanceof LongArrayTag) {
            return this.writeLongArray((LongArrayTag)tag);
        }
        if (tag instanceof StringTag) {
            return this.value(((StringTag)tag).getValue(), '\u0000');
        }
        if (tag instanceof ByteTag) {
            return this.value(Byte.toString(((NumberTag)tag).asByte()), 'b');
        }
        if (tag instanceof ShortTag) {
            return this.value(Short.toString(((NumberTag)tag).asShort()), 's');
        }
        if (tag instanceof IntTag) {
            return this.value(Integer.toString(((NumberTag)tag).asInt()), 'i');
        }
        if (tag instanceof LongTag) {
            return this.value(Long.toString(((NumberTag)tag).asLong()), Character.toUpperCase('l'));
        }
        if (tag instanceof FloatTag) {
            return this.value(Float.toString(((NumberTag)tag).asFloat()), 'f');
        }
        if (tag instanceof DoubleTag) {
            return this.value(Double.toString(((NumberTag)tag).asDouble()), 'd');
        }
        throw new IllegalArgumentException("Unknown tag type: " + tag.getClass().getSimpleName());
    }

    private TagStringWriter writeCompound(CompoundTag compoundTag) {
        this.beginCompound();
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            this.key(entry.getKey());
            this.writeTag(entry.getValue());
        }
        this.endCompound();
        return this;
    }

    private TagStringWriter writeList(ListTag<?> listTag) {
        this.beginList();
        for (Tag tag : listTag) {
            this.printAndResetSeparator();
            this.writeTag(tag);
        }
        this.endList();
        return this;
    }

    private TagStringWriter writeByteArray(ByteArrayTag byteArrayTag) {
        this.beginArray('b');
        byte[] byArray = byteArrayTag.getValue();
        int n = byArray.length;
        for (int i = 0; i < n; ++i) {
            this.printAndResetSeparator();
            this.value(Byte.toString(byArray[i]), 'b');
        }
        this.endArray();
        return this;
    }

    private TagStringWriter writeIntArray(IntArrayTag intArrayTag) {
        this.beginArray('i');
        int[] nArray = intArrayTag.getValue();
        int n = nArray.length;
        for (int i = 0; i < n; ++i) {
            this.printAndResetSeparator();
            this.value(Integer.toString(nArray[i]), 'i');
        }
        this.endArray();
        return this;
    }

    private TagStringWriter writeLongArray(LongArrayTag longArrayTag) {
        this.beginArray('l');
        long[] lArray = longArrayTag.getValue();
        int n = lArray.length;
        for (int i = 0; i < n; ++i) {
            this.printAndResetSeparator();
            this.value(Long.toString(lArray[i]), 'l');
        }
        this.endArray();
        return this;
    }

    public TagStringWriter beginCompound() {
        this.printAndResetSeparator();
        this.out.append('{');
        return this;
    }

    public TagStringWriter endCompound() {
        this.out.append('}');
        this.needsSeparator = true;
        return this;
    }

    public TagStringWriter key(String string) {
        this.printAndResetSeparator();
        this.writeMaybeQuoted(string, false);
        this.out.append(':');
        return this;
    }

    public TagStringWriter value(String string, char c) {
        if (c == '\u0000') {
            this.writeMaybeQuoted(string, true);
        } else {
            this.out.append(string);
            if (c != 'i') {
                this.out.append(c);
            }
        }
        this.needsSeparator = true;
        return this;
    }

    public TagStringWriter beginList() {
        this.printAndResetSeparator();
        this.out.append('[');
        return this;
    }

    public TagStringWriter endList() {
        this.out.append(']');
        this.needsSeparator = true;
        return this;
    }

    private TagStringWriter beginArray(char c) {
        this.beginList().out.append(Character.toUpperCase(c)).append(';');
        return this;
    }

    private TagStringWriter endArray() {
        return this.endList();
    }

    private void writeMaybeQuoted(String string, boolean bl) {
        if (!bl) {
            for (int i = 0; i < string.length(); ++i) {
                if (Tokens.id(string.charAt(i))) continue;
                bl = true;
                break;
            }
        }
        if (bl) {
            this.out.append('\"');
            this.out.append(TagStringWriter.escape(string, '\"'));
            this.out.append('\"');
        } else {
            this.out.append(string);
        }
    }

    private static String escape(String string, char c) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); ++i) {
            char c2 = string.charAt(i);
            if (c2 == c || c2 == '\\') {
                stringBuilder.append('\\');
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    private void printAndResetSeparator() {
        if (this.needsSeparator) {
            this.out.append(',');
            this.needsSeparator = false;
        }
    }
}

