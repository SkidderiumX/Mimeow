/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12;

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
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.SNbtDeserializer;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12.StringReader_v1_12;
import java.util.regex.Pattern;

public class SNbtDeserializer_v1_12
implements SNbtDeserializer<CompoundTag> {
    private static final Pattern BYTE_PATTERN = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)b", 2);
    private static final Pattern SHORT_PATTERN = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)s", 2);
    private static final Pattern INT_PATTERN = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)");
    private static final Pattern LONG_PATTERN = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)l", 2);
    private static final Pattern FLOAT_PATTERN = Pattern.compile("[-+]?(?:[0-9]+[.]?|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?f", 2);
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("[-+]?(?:[0-9]+[.]?|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?d", 2);
    private static final Pattern SHORT_DOUBLE_PATTERN = Pattern.compile("[-+]?(?:[0-9]+[.]|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?", 2);

    @Override
    public CompoundTag deserialize(String string) throws SNbtDeserializeException {
        StringReader_v1_12 stringReader_v1_12 = this.makeReader(string);
        CompoundTag compoundTag = this.readCompound(stringReader_v1_12);
        stringReader_v1_12.skipWhitespaces();
        if (stringReader_v1_12.canRead()) {
            throw this.makeException(stringReader_v1_12, "Trailing data found");
        }
        return compoundTag;
    }

    @Override
    public Tag deserializeValue(String string) throws SNbtDeserializeException {
        return this.readValue(this.makeReader(string));
    }

    protected CompoundTag readCompound(StringReader_v1_12 stringReader_v1_12) throws SNbtDeserializeException {
        stringReader_v1_12.jumpTo('{');
        CompoundTag compoundTag = new CompoundTag();
        stringReader_v1_12.skipWhitespaces();
        while (stringReader_v1_12.canRead() && stringReader_v1_12.peek() != '}') {
            String string = stringReader_v1_12.readString();
            if (string == null) {
                throw this.makeException(stringReader_v1_12, "Expected key");
            }
            if (string.isEmpty()) {
                throw this.makeException(stringReader_v1_12, "Expected non-empty key");
            }
            stringReader_v1_12.jumpTo(':');
            compoundTag.put(string, this.readValue(stringReader_v1_12));
            if (!this.hasNextValue(stringReader_v1_12)) break;
            if (stringReader_v1_12.canRead()) continue;
            throw this.makeException(stringReader_v1_12, "Expected key");
        }
        stringReader_v1_12.jumpTo('}');
        return compoundTag;
    }

    protected Tag readListOrArray(StringReader_v1_12 stringReader_v1_12) throws SNbtDeserializeException {
        if (stringReader_v1_12.canRead(2) && !this.isQuote(stringReader_v1_12.charAt(1)) && stringReader_v1_12.charAt(2) == ';') {
            return this.readArray(stringReader_v1_12);
        }
        return this.readList(stringReader_v1_12);
    }

    protected ListTag<Tag> readList(StringReader_v1_12 stringReader_v1_12) throws SNbtDeserializeException {
        stringReader_v1_12.jumpTo('[');
        stringReader_v1_12.skipWhitespaces();
        if (!stringReader_v1_12.canRead()) {
            throw this.makeException(stringReader_v1_12, "Expected value");
        }
        ListTag<Tag> listTag = new ListTag<Tag>();
        while (stringReader_v1_12.peek() != ']') {
            Tag tag = this.readValue(stringReader_v1_12);
            listTag.add(tag);
            if (!this.hasNextValue(stringReader_v1_12)) break;
            if (stringReader_v1_12.canRead()) continue;
            throw this.makeException(stringReader_v1_12, "Expected value");
        }
        stringReader_v1_12.jumpTo(']');
        return listTag;
    }

    protected <T extends NumberTag> ListTag<T> readPrimitiveList(StringReader_v1_12 stringReader_v1_12, Class<T> clazz, Class<? extends Tag> clazz2) throws SNbtDeserializeException {
        ListTag<NumberTag> listTag = new ListTag<NumberTag>();
        while (stringReader_v1_12.peek() != ']') {
            Tag tag = this.readValue(stringReader_v1_12);
            if (!clazz.isAssignableFrom(tag.getClass())) {
                throw new SNbtDeserializeException("Unable to insert " + tag.getClass().getSimpleName() + " into " + clazz2.getSimpleName());
            }
            listTag.add((NumberTag)tag);
            if (!this.hasNextValue(stringReader_v1_12)) break;
            if (stringReader_v1_12.canRead()) continue;
            throw this.makeException(stringReader_v1_12, "Expected value");
        }
        stringReader_v1_12.jumpTo(']');
        return listTag;
    }

    protected Tag readArray(StringReader_v1_12 stringReader_v1_12) throws SNbtDeserializeException {
        stringReader_v1_12.jumpTo('[');
        char c = stringReader_v1_12.read();
        stringReader_v1_12.read();
        stringReader_v1_12.skipWhitespaces();
        if (!stringReader_v1_12.canRead()) {
            throw this.makeException(stringReader_v1_12, "Expected value");
        }
        if (c == 'B') {
            ListTag<ByteTag> listTag = this.readPrimitiveList(stringReader_v1_12, ByteTag.class, ByteArrayTag.class);
            byte[] byArray = new byte[listTag.size()];
            for (int i = 0; i < listTag.size(); ++i) {
                byArray[i] = listTag.get(i).asByte();
            }
            return new ByteArrayTag(byArray);
        }
        if (c == 'L') {
            ListTag<LongTag> listTag = this.readPrimitiveList(stringReader_v1_12, LongTag.class, LongArrayTag.class);
            long[] lArray = new long[listTag.size()];
            for (int i = 0; i < listTag.size(); ++i) {
                lArray[i] = listTag.get(i).asLong();
            }
            return new LongArrayTag(lArray);
        }
        if (c == 'I') {
            ListTag<IntTag> listTag = this.readPrimitiveList(stringReader_v1_12, IntTag.class, IntArrayTag.class);
            int[] nArray = new int[listTag.size()];
            for (int i = 0; i < listTag.size(); ++i) {
                nArray[i] = listTag.get(i).asInt();
            }
            return new IntArrayTag(nArray);
        }
        throw new SNbtDeserializeException("Invalid array type '" + c + "' found");
    }

    protected Tag readValue(StringReader_v1_12 stringReader_v1_12) throws SNbtDeserializeException {
        stringReader_v1_12.skipWhitespaces();
        if (!stringReader_v1_12.canRead()) {
            throw this.makeException(stringReader_v1_12, "Expected value");
        }
        char c = stringReader_v1_12.peek();
        if (c == '{') {
            return this.readCompound(stringReader_v1_12);
        }
        if (c == '[') {
            return this.readListOrArray(stringReader_v1_12);
        }
        return this.readPrimitive(stringReader_v1_12);
    }

    protected Tag readPrimitive(StringReader_v1_12 stringReader_v1_12) throws SNbtDeserializeException {
        stringReader_v1_12.skipWhitespaces();
        if (this.isQuote(stringReader_v1_12.peek())) {
            return new StringTag(stringReader_v1_12.readQuotedString());
        }
        String string = stringReader_v1_12.readUnquotedString();
        if (string.isEmpty()) {
            throw this.makeException(stringReader_v1_12, "Expected value");
        }
        return this.readPrimitive(string);
    }

    protected Tag readPrimitive(String string) {
        if (string.equalsIgnoreCase("false")) {
            return new ByteTag((byte)0);
        }
        if (string.equalsIgnoreCase("true")) {
            return new ByteTag((byte)1);
        }
        return this.readNumber(string);
    }

    protected Tag readNumber(String string) {
        try {
            if (FLOAT_PATTERN.matcher(string).matches()) {
                return new FloatTag(Float.parseFloat(string.substring(0, string.length() - 1)));
            }
            if (BYTE_PATTERN.matcher(string).matches()) {
                return new ByteTag(Byte.parseByte(string.substring(0, string.length() - 1)));
            }
            if (LONG_PATTERN.matcher(string).matches()) {
                return new LongTag(Long.parseLong(string.substring(0, string.length() - 1)));
            }
            if (SHORT_PATTERN.matcher(string).matches()) {
                return new ShortTag(Short.parseShort(string.substring(0, string.length() - 1)));
            }
            if (INT_PATTERN.matcher(string).matches()) {
                return new IntTag(Integer.parseInt(string));
            }
            if (DOUBLE_PATTERN.matcher(string).matches()) {
                return new DoubleTag(Double.parseDouble(string.substring(0, string.length() - 1)));
            }
            if (SHORT_DOUBLE_PATTERN.matcher(string).matches()) {
                return new DoubleTag(Double.parseDouble(string));
            }
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        return new StringTag(string);
    }

    protected boolean hasNextValue(StringReader_v1_12 stringReader_v1_12) {
        stringReader_v1_12.skipWhitespaces();
        if (stringReader_v1_12.canRead() && stringReader_v1_12.peek() == ',') {
            stringReader_v1_12.skip();
            stringReader_v1_12.skipWhitespaces();
            return true;
        }
        return false;
    }

    protected SNbtDeserializeException makeException(StringReader_v1_12 stringReader_v1_12, String string) {
        return new SNbtDeserializeException(string, stringReader_v1_12.getString(), stringReader_v1_12.getIndex());
    }

    protected StringReader_v1_12 makeReader(String string) {
        return new StringReader_v1_12(string);
    }

    protected boolean isQuote(char c) {
        return c == '\"';
    }
}

