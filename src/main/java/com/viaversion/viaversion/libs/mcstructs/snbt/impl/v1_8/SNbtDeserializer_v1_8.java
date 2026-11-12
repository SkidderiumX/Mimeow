/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_8;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.SNbtDeserializer;
import java.util.Arrays;
import java.util.Stack;

public class SNbtDeserializer_v1_8
implements SNbtDeserializer<CompoundTag> {
    private static final String ARRAY_PATTERN = "\\[[-+\\d|,\\s]+]";
    private static final String BYTE_PATTERN = "[-+]?[0-9]+[b|B]";
    private static final String SHORT_PATTERN = "[-+]?[0-9]+[s|S]";
    private static final String INT_PATTERN = "[-+]?[0-9]+";
    private static final String LONG_PATTERN = "[-+]?[0-9]+[l|L]";
    private static final String FLOAT_PATTERN = "[-+]?[0-9]*\\.?[0-9]+[f|F]";
    private static final String DOUBLE_PATTERN = "[-+]?[0-9]*\\.?[0-9]+[d|D]";
    private static final String SHORT_DOUBLE_PATTERN = "[-+]?[0-9]*\\.?[0-9]+";

    @Override
    public CompoundTag deserialize(String string) throws SNbtDeserializeException {
        if (!(string = string.trim()).startsWith("{")) {
            throw new SNbtDeserializeException("Invalid tag encountered, expected '{' as first char.");
        }
        if (this.getTagCount(string) != 1) {
            throw new SNbtDeserializeException("Encountered multiple top tags, only one expected");
        }
        return (CompoundTag)this.parseTag(string);
    }

    @Override
    public Tag deserializeValue(String string) throws SNbtDeserializeException {
        return this.parseTag(string);
    }

    private Tag parseTag(String string) throws SNbtDeserializeException {
        if ((string = string.trim()).startsWith("{")) {
            string = string.substring(1, string.length() - 1);
            CompoundTag compoundTag = new CompoundTag();
            while (string.length() > 0) {
                String string2 = this.findPair(string, false);
                if (string2.length() > 0) {
                    String string3 = this.find(string2, true, false);
                    String string4 = this.find(string2, false, false);
                    compoundTag.put(string3, this.parseTag(string4));
                }
                if (string.length() < string2.length() + 1) break;
                char c = string.charAt(string2.length());
                if (c != ',' && c != '{' && c != '}' && c != '[' && c != ']') {
                    throw new SNbtDeserializeException("Unexpected token '" + c + "' at: " + string.substring(string2.length()));
                }
                string = string.substring(string2.length() + 1);
            }
            return compoundTag;
        }
        if (string.startsWith("[") && !string.matches(ARRAY_PATTERN)) {
            string = string.substring(1, string.length() - 1);
            ListTag<Tag> listTag = new ListTag<Tag>();
            while (string.length() > 0) {
                String string5 = this.findPair(string, true);
                if (string5.length() > 0) {
                    String string6 = this.find(string5, false, true);
                    try {
                        listTag.add(this.parseTag(string6));
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        // empty catch block
                    }
                }
                if (string.length() < string5.length() + 1) break;
                char c = string.charAt(string5.length());
                if (c != ',' && c != '{' && c != '}' && c != '[' && c != ']') {
                    throw new SNbtDeserializeException("Unexpected token '" + c + "' at: " + string.substring(string5.length()));
                }
                string = string.substring(string5.length() + 1);
            }
            return listTag;
        }
        return this.parsePrimitive(string);
    }

    private Tag parsePrimitive(String string) {
        try {
            if (string.matches(DOUBLE_PATTERN)) {
                return new DoubleTag(Double.parseDouble(string.substring(0, string.length() - 1)));
            }
            if (string.matches(FLOAT_PATTERN)) {
                return new FloatTag(Float.parseFloat(string.substring(0, string.length() - 1)));
            }
            if (string.matches(BYTE_PATTERN)) {
                return new ByteTag(Byte.parseByte(string.substring(0, string.length() - 1)));
            }
            if (string.matches(LONG_PATTERN)) {
                return new LongTag(Long.parseLong(string.substring(0, string.length() - 1)));
            }
            if (string.matches(SHORT_PATTERN)) {
                return new ShortTag(Short.parseShort(string.substring(0, string.length() - 1)));
            }
            if (string.matches(INT_PATTERN)) {
                return new IntTag(Integer.parseInt(string));
            }
            if (string.matches(SHORT_DOUBLE_PATTERN)) {
                return new DoubleTag(Double.parseDouble(string));
            }
            if (string.equalsIgnoreCase("false")) {
                return new ByteTag((byte)0);
            }
            if (string.equalsIgnoreCase("true")) {
                return new ByteTag((byte)1);
            }
        }
        catch (NumberFormatException numberFormatException) {
            return new StringTag(string.replace("\\\"", "\""));
        }
        if (string.startsWith("[") && string.endsWith("]")) {
            String string2 = string.substring(1, string.length() - 1);
            String[] stringArray = this.trimSplit(string2);
            try {
                int[] nArray = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; ++i) {
                    nArray[i] = Integer.parseInt(stringArray[i].trim());
                }
                return new IntArrayTag(nArray);
            }
            catch (NumberFormatException numberFormatException) {
                return new StringTag(string);
            }
        }
        if (string.startsWith("\"") && string.endsWith("\"")) {
            string = string.substring(1, string.length() - 1);
        }
        string = string.replace("\\\"", "\"");
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            char c = cArray[i];
            if (i < cArray.length - 1 && c == '\\' && cArray[i + 1] == '\\') {
                stringBuilder.append("\\");
                ++i;
                continue;
            }
            stringBuilder.append(c);
        }
        return new StringTag(stringBuilder.toString());
    }

    private int getTagCount(String string) throws SNbtDeserializeException {
        Stack<Character> stack = new Stack<Character>();
        boolean bl = false;
        int n = 0;
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            char c = cArray[i];
            if (c == '\"') {
                if (this.isEscaped(string, i)) {
                    if (bl) continue;
                    throw new SNbtDeserializeException("Illegal use of \\\": " + string);
                }
                bl = !bl;
                continue;
            }
            if (bl) continue;
            if (c == '{' || c == '[') {
                if (stack.isEmpty()) {
                    ++n;
                }
                stack.push(Character.valueOf(c));
                continue;
            }
            this.checkBrackets(string, c, stack);
        }
        if (bl) {
            throw new SNbtDeserializeException("Unbalanced quotation: " + string);
        }
        if (!stack.isEmpty()) {
            throw new SNbtDeserializeException("Unbalanced brackets " + this.quotesToString(stack) + ": " + string);
        }
        if (n == 0 && !string.isEmpty()) {
            return 1;
        }
        return n;
    }

    private String findPair(String string, boolean bl) throws SNbtDeserializeException {
        int n;
        int n2 = this.getCharIndex(string, ':');
        if (n2 == -1 && !bl) {
            throw new SNbtDeserializeException("Unable to locate name/value separator for string: " + string);
        }
        int n3 = this.getCharIndex(string, ',');
        if (n3 != -1 && n3 < n2 && !bl) {
            throw new SNbtDeserializeException("Name error at: " + string);
        }
        if (bl && (n2 == -1 || n2 > n3)) {
            n2 = -1;
        }
        Stack<Character> stack = new Stack<Character>();
        int n4 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        char[] cArray = string.toCharArray();
        for (n = n2 + 1; n < cArray.length; ++n) {
            char c = cArray[n];
            if (c == '\"') {
                if (this.isEscaped(string, n)) {
                    if (!bl2) {
                        throw new SNbtDeserializeException("Illegal use of \\\": " + string);
                    }
                } else {
                    boolean bl5 = bl2 = !bl2;
                    if (bl2 && !bl3) {
                        bl4 = true;
                    }
                    if (!bl2) {
                        n4 = n;
                    }
                }
            } else if (!bl2) {
                if (c == '{' || c == '[') {
                    stack.push(Character.valueOf(c));
                } else {
                    this.checkBrackets(string, c, stack);
                    if (c == ',' && stack.isEmpty()) {
                        return string.substring(0, n);
                    }
                }
            }
            if (Character.isWhitespace(c)) continue;
            if (!bl2 && bl4 && n4 != n) {
                return string.substring(0, n4 + 1);
            }
            bl3 = true;
        }
        return string.substring(0, n);
    }

    private String find(String string, boolean bl, boolean bl2) throws SNbtDeserializeException {
        if (bl2 && ((string = string.trim()).startsWith("{") || string.startsWith("["))) {
            if (bl) {
                return "";
            }
            return string;
        }
        int n = this.getCharIndex(string, ':');
        if (n == -1) {
            if (bl2) {
                if (bl) {
                    return "";
                }
                return string;
            }
            throw new SNbtDeserializeException("Unable to locate name/value separator for string: " + string);
        }
        if (bl) {
            return string.substring(0, n).trim();
        }
        return string.substring(n + 1).trim();
    }

    private int getCharIndex(String string, char c) {
        boolean bl = true;
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            char c2 = cArray[i];
            if (c2 == '\"') {
                if (this.isEscaped(string, i)) continue;
                bl = !bl;
                continue;
            }
            if (!bl) continue;
            if (c2 == c) {
                return i;
            }
            if (c2 != '{' && c2 != '[') continue;
            return -1;
        }
        return -1;
    }

    private String[] trimSplit(String string) {
        String[] stringArray = string.split(",");
        String[] stringArray2 = new String[stringArray.length];
        int n = 0;
        for (String string2 : stringArray) {
            if (string2.isEmpty()) continue;
            stringArray2[n++] = string2;
        }
        return Arrays.copyOfRange(stringArray2, 0, n);
    }

    private boolean isEscaped(String string, int n) {
        return n > 0 && string.charAt(n - 1) == '\\' && !this.isEscaped(string, n - 1);
    }

    private void checkBrackets(String string, char c, Stack<Character> stack) throws SNbtDeserializeException {
        if (c == '}' && (stack.isEmpty() || stack.pop().charValue() != '{')) {
            throw new SNbtDeserializeException("Unbalanced curly brackets {}: " + string);
        }
        if (c == ']' && (stack.isEmpty() || stack.pop().charValue() != '[')) {
            throw new SNbtDeserializeException("Unbalanced square brackets []: " + string);
        }
    }

    private String quotesToString(Stack<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

