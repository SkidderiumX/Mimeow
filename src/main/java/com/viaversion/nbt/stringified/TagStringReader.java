/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.stringified;

import com.viaversion.nbt.stringified.CharBuffer;
import com.viaversion.nbt.stringified.StringifiedTagParseException;
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
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.jetbrains.annotations.Nullable;

public class TagStringReader {
    private static final int MAX_DEPTH = 512;
    private static final int HEX_RADIX = 16;
    private static final int BINARY_RADIX = 2;
    private static final int DECIMAL_RADIX = 10;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private final CharBuffer buffer;
    private boolean acceptLegacy = true;
    private int depth;

    TagStringReader(CharBuffer charBuffer) {
        this.buffer = charBuffer;
    }

    public CompoundTag compound() throws StringifiedTagParseException {
        this.buffer.expect('{');
        CompoundTag compoundTag = new CompoundTag();
        if (this.buffer.takeIf('}')) {
            return compoundTag;
        }
        while (this.buffer.hasMore()) {
            compoundTag.put(this.key(), this.tag());
            if (!this.separatorOrCompleteWith('}')) continue;
            return compoundTag;
        }
        throw this.buffer.makeError("Unterminated compound tag!");
    }

    public ListTag<?> list() throws StringifiedTagParseException {
        boolean bl;
        ArrayList<Tag> arrayList = new ArrayList<Tag>();
        this.buffer.expect('[');
        boolean bl2 = bl = this.acceptLegacy && this.buffer.peek() == '0' && this.buffer.peek(1) == ':';
        if (!bl && this.buffer.takeIf(']')) {
            return ListTag.of(arrayList);
        }
        while (this.buffer.hasMore()) {
            if (bl) {
                this.buffer.takeUntil(':');
            }
            Tag tag = this.tag();
            arrayList.add(tag);
            if (!this.separatorOrCompleteWith(']')) continue;
            return ListTag.of(arrayList);
        }
        throw this.buffer.makeError("Reached end of file without end of list tag!");
    }

    public Tag array(char c) throws StringifiedTagParseException {
        this.buffer.expect('[').expect(c).expect(';');
        c = Character.toLowerCase(c);
        if (c == 'b') {
            return new ByteArrayTag(this.byteArray());
        }
        if (c == 'i') {
            return new IntArrayTag(this.intArray());
        }
        if (c == 'l') {
            return new LongArrayTag(this.longArray());
        }
        throw this.buffer.makeError("Type " + c + " is not a valid element type in an array!");
    }

    private byte[] byteArray() throws StringifiedTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_BYTE_ARRAY;
        }
        IntArrayList intArrayList = new IntArrayList();
        while (this.buffer.hasMore()) {
            CharSequence charSequence = this.buffer.skipWhitespace().takeUntil('b');
            try {
                intArrayList.add(Byte.parseByte(charSequence.toString()));
            }
            catch (NumberFormatException numberFormatException) {
                throw this.buffer.makeError("All elements of a byte array must be bytes!");
            }
            if (!this.separatorOrCompleteWith(']')) continue;
            byte[] byArray = new byte[intArrayList.size()];
            for (int i = 0; i < intArrayList.size(); ++i) {
                byArray[i] = (byte)intArrayList.getInt(i);
            }
            return byArray;
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    private int[] intArray() throws StringifiedTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_INT_ARRAY;
        }
        IntStream.Builder builder = IntStream.builder();
        while (this.buffer.hasMore()) {
            Tag tag = this.tag();
            if (!(tag instanceof IntTag)) {
                throw this.buffer.makeError("All elements of an int array must be ints!");
            }
            builder.add(((NumberTag)tag).asInt());
            if (!this.separatorOrCompleteWith(']')) continue;
            return builder.build().toArray();
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    private long[] longArray() throws StringifiedTagParseException {
        if (this.buffer.takeIf(']')) {
            return EMPTY_LONG_ARRAY;
        }
        LongStream.Builder builder = LongStream.builder();
        while (this.buffer.hasMore()) {
            CharSequence charSequence = this.buffer.skipWhitespace().takeUntil('l');
            try {
                builder.add(Long.parseLong(charSequence.toString()));
            }
            catch (NumberFormatException numberFormatException) {
                throw this.buffer.makeError("All elements of a long array must be longs!");
            }
            if (!this.separatorOrCompleteWith(']')) continue;
            return builder.build().toArray();
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String key() throws StringifiedTagParseException {
        this.buffer.skipWhitespace();
        char c = this.buffer.peek();
        try {
            if (c == '\'' || c == '\"') {
                String string = TagStringReader.unescape(this.buffer.takeUntil(this.buffer.take()).toString());
                return string;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (this.buffer.hasMore()) {
                char c2 = this.buffer.peek();
                if (!Tokens.id(c2)) {
                    if (!this.acceptLegacy) break;
                    if (c2 == '\\') {
                        this.buffer.take();
                        continue;
                    }
                    if (c2 == ':') break;
                    stringBuilder.append(this.buffer.take());
                    continue;
                }
                stringBuilder.append(this.buffer.take());
            }
            String string = stringBuilder.toString();
            return string;
        }
        finally {
            this.buffer.expect(':');
        }
    }

    public Tag tag() throws StringifiedTagParseException {
        if (this.depth++ > 512) {
            throw this.buffer.makeError("Exceeded maximum allowed depth of 512 when reading tag");
        }
        try {
            char c = this.buffer.skipWhitespace().peek();
            switch (c) {
                case '{': {
                    CompoundTag compoundTag = this.compound();
                    return compoundTag;
                }
                case '[': {
                    if (this.buffer.hasMore(2) && this.buffer.peek(2) == ';') {
                        Tag tag = this.array(this.buffer.peek(1));
                        return tag;
                    }
                    ListTag<?> listTag = this.list();
                    return listTag;
                }
                case '\"': 
                case '\'': {
                    this.buffer.advance();
                    StringTag stringTag = new StringTag(TagStringReader.unescape(this.buffer.takeUntil(c).toString()));
                    return stringTag;
                }
            }
            Tag tag = this.scalar();
            return tag;
        }
        finally {
            --this.depth;
        }
    }

    private Tag scalar() throws StringifiedTagParseException {
        String string;
        block18: {
            char c;
            boolean bl;
            StringBuilder stringBuilder = new StringBuilder();
            while (this.buffer.hasMore()) {
                char c2 = this.buffer.peek();
                if (c2 == '\\') {
                    this.buffer.advance();
                    c2 = this.buffer.take();
                } else {
                    if (!Tokens.id(c2)) break;
                    this.buffer.advance();
                }
                stringBuilder.append(c2);
            }
            if (stringBuilder.length() == 0) {
                throw this.buffer.makeError("Expected a value but got nothing");
            }
            string = stringBuilder.toString();
            int n = this.extractRadix(stringBuilder, string);
            char c3 = stringBuilder.charAt(stringBuilder.length() - 1);
            boolean bl2 = false;
            boolean bl3 = bl = n != 16;
            if (stringBuilder.length() > 2 && ((c = stringBuilder.charAt(stringBuilder.length() - 2)) == 's' || c == 'u')) {
                bl2 = true;
                bl = c == 's';
                stringBuilder.deleteCharAt(stringBuilder.length() - 2);
            }
            c = '\u0000';
            char c4 = 'i';
            if (Tokens.numericType(c3) && (bl2 || n != 16)) {
                c = '\u0001';
                c4 = Character.toLowerCase(c3);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (!(bl || c4 != 'f' && c4 != 'd')) {
                throw this.buffer.makeError("Cannot create unsigned floating point numbers");
            }
            String string2 = stringBuilder.toString().replace("_", "");
            if (c != '\u0000') {
                try {
                    NumberTag numberTag = this.parseNumberTag(string2, c4, n, bl);
                    if (numberTag != null) {
                        return numberTag;
                    }
                }
                catch (NumberFormatException numberFormatException) {}
            } else {
                try {
                    return new IntTag(this.parseInt(string2, n, bl));
                }
                catch (NumberFormatException numberFormatException) {
                    if (string2.indexOf(46) == -1) break block18;
                    try {
                        return new DoubleTag(Double.parseDouble(string2));
                    }
                    catch (NumberFormatException numberFormatException2) {
                        // empty catch block
                    }
                }
            }
        }
        if (string.equalsIgnoreCase("true")) {
            return new ByteTag(1);
        }
        if (string.equalsIgnoreCase("false")) {
            return new ByteTag(0);
        }
        return new StringTag(string);
    }

    private int extractRadix(StringBuilder stringBuilder, String string) {
        int n;
        int n2 = 0;
        char c = stringBuilder.charAt(0);
        if (c == '+' || c == '-') {
            n2 = 1;
        }
        if (stringBuilder.length() < 3 + n2) {
            return 10;
        }
        if (string.startsWith("0b", n2) || string.startsWith("0B", n2)) {
            n = 2;
        } else if (string.startsWith("0x", n2) || string.startsWith("0X", n2)) {
            n = 16;
        } else {
            return 10;
        }
        stringBuilder.delete(n2, 2 + n2);
        return n;
    }

    @Nullable
    private NumberTag parseNumberTag(String string, char c, int n, boolean bl) {
        switch (c) {
            case 'b': {
                return new ByteTag(this.parseByte(string, n, bl));
            }
            case 's': {
                return new ShortTag(this.parseShort(string, n, bl));
            }
            case 'i': {
                return new IntTag(this.parseInt(string, n, bl));
            }
            case 'l': {
                return new LongTag(this.parseLong(string, n, bl));
            }
            case 'f': {
                float f = Float.parseFloat(string);
                if (!Float.isFinite(f)) break;
                return new FloatTag(f);
            }
            case 'd': {
                double d = Double.parseDouble(string);
                if (!Double.isFinite(d)) break;
                return new DoubleTag(d);
            }
        }
        return null;
    }

    private byte parseByte(String string, int n, boolean bl) {
        if (bl) {
            return Byte.parseByte(string, n);
        }
        int n2 = Integer.parseInt(string, n);
        if (n2 >> 8 == 0) {
            return (byte)n2;
        }
        throw new NumberFormatException();
    }

    private short parseShort(String string, int n, boolean bl) {
        if (bl) {
            return Short.parseShort(string, n);
        }
        int n2 = Integer.parseInt(string, n);
        if (n2 >> 16 == 0) {
            return (short)n2;
        }
        throw new NumberFormatException();
    }

    private int parseInt(String string, int n, boolean bl) {
        return bl ? Integer.parseInt(string, n) : Integer.parseUnsignedInt(string, n);
    }

    private long parseLong(String string, int n, boolean bl) {
        return bl ? Long.parseLong(string, n) : Long.parseUnsignedLong(string, n);
    }

    private boolean separatorOrCompleteWith(char c) throws StringifiedTagParseException {
        if (this.buffer.takeIf(c)) {
            return true;
        }
        this.buffer.expect(',');
        return this.buffer.takeIf(c);
    }

    private static String unescape(String string) {
        int n = string.indexOf(92);
        if (n == -1) {
            return string;
        }
        int n2 = 0;
        StringBuilder stringBuilder = new StringBuilder(string.length());
        do {
            stringBuilder.append(string, n2, n);
        } while ((n = string.indexOf(92, (n2 = n + 1) + 1)) != -1);
        stringBuilder.append(string.substring(n2));
        return stringBuilder.toString();
    }

    public void legacy(boolean bl) {
        this.acceptLegacy = bl;
    }
}

