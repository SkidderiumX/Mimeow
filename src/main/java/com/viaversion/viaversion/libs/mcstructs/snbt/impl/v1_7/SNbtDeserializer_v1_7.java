/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_7;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.SNbtDeserializer;
import java.util.Stack;

public class SNbtDeserializer_v1_7
implements SNbtDeserializer<Tag> {
    private static final String ARRAY_PATTERN = "\\[[-\\d|,\\s]+]";
    private static final String BYTE_PATTERN = "[-+]?[0-9]+[b|B]";
    private static final String SHORT_PATTERN = "[-+]?[0-9]+[s|S]";
    private static final String INT_PATTERN = "[-+]?[0-9]+";
    private static final String LONG_PATTERN = "[-+]?[0-9]+[l|L]";
    private static final String FLOAT_PATTERN = "[-+]?[0-9]*\\.?[0-9]+[f|F]";
    private static final String DOUBLE_PATTERN = "[-+]?[0-9]*\\.?[0-9]+[d|D]";
    private static final String SHORT_DOUBLE_PATTERN = "[-+]?[0-9]*\\.?[0-9]+";

    @Override
    public Tag deserialize(String string) throws SNbtDeserializeException {
        int n = this.getTagCount(string = string.trim());
        if (n != 1) {
            throw new SNbtDeserializeException("Encountered multiple top tags, only one expected");
        }
        Tag tag = string.startsWith("{") ? this.parse("tag", string) : this.parse(this.find(string, true, false), this.find(string, false, false));
        return tag;
    }

    @Override
    public Tag deserializeValue(String string) throws SNbtDeserializeException {
        return this.parse("tag", string);
    }

    private Tag parse(String string, String string2) throws SNbtDeserializeException {
        string2 = string2.trim();
        this.getTagCount(string2);
        if (string2.startsWith("{")) {
            if (!string2.endsWith("}")) {
                throw new SNbtDeserializeException("Unable to locate ending bracket } for: " + string2);
            }
            string2 = string2.substring(1, string2.length() - 1);
            CompoundTag compoundTag = new CompoundTag();
            while (!string2.isEmpty()) {
                String string3 = this.findPair(string2, false);
                if (string3.isEmpty()) continue;
                String string4 = this.find(string3, true, false);
                String string5 = this.find(string3, false, false);
                compoundTag.put(string4, this.parse(string4, string5));
                if (string2.length() < string3.length() + 1) break;
                char c = string2.charAt(string3.length());
                if (c != ',' && c != '{' && c != '}' && c != '[' && c != ']') {
                    throw new SNbtDeserializeException("Unexpected token '" + string + "' at: " + string2.substring(string3.length()));
                }
                string2 = string2.substring(string3.length() + 1);
            }
            return compoundTag;
        }
        if (string2.startsWith("[") && !string2.matches(ARRAY_PATTERN)) {
            if (!string2.endsWith("]")) {
                throw new SNbtDeserializeException("Unable to locate ending bracket ] for: " + string2);
            }
            string2 = string2.substring(1, string2.length() - 1);
            ListTag<Tag> listTag = new ListTag<Tag>();
            while (!string2.isEmpty()) {
                String string6 = this.findPair(string2, true);
                if (string6.isEmpty()) continue;
                String string7 = this.find(string6, true, true);
                String string8 = this.find(string6, false, true);
                try {
                    listTag.add(this.parse(string7, string8));
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    // empty catch block
                }
                if (string2.length() < string6.length() + 1) break;
                char c = string2.charAt(string6.length());
                if (c != ',' && c != '{' && c != '}' && c != '[' && c != ']') {
                    throw new SNbtDeserializeException("Unexpected token '" + string + "' at: " + string2.substring(string6.length()));
                }
                string2 = string2.substring(string6.length() + 1);
            }
            return listTag;
        }
        return this.parsePrimitive(string2);
    }

    /*
     * Exception decompiling
     */
    private Tag parsePrimitive(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK], 0[TRYBLOCK]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private int getTagCount(String string) throws SNbtDeserializeException {
        Stack<Character> stack = new Stack<Character>();
        boolean bl = false;
        int n = 0;
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            char c = cArray[i];
            if (c == '\"') {
                if (i > 0 && cArray[i - 1] == '\\') {
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
        if (n2 < 0 && !bl) {
            throw new SNbtDeserializeException("Unable to locate name/value for string: " + string);
        }
        int n3 = this.getCharIndex(string, ',');
        if (n3 >= 0 && n3 < n2 && !bl) {
            throw new SNbtDeserializeException("Name error at: " + string);
        }
        if (bl && (n2 < 0 || n2 > n3)) {
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
                if (n > 0 && cArray[n - 1] == '\\') {
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
        int n = string.indexOf(":");
        if (n < 0) {
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
        boolean bl = false;
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            char c2 = cArray[i];
            if (c2 == '\"') {
                if (i > 0 && cArray[i - 1] == '\\') continue;
                bl = !bl;
                continue;
            }
            if (bl) continue;
            if (c2 == c) {
                return i;
            }
            if (c2 != '{' && c2 != '[') continue;
            return -1;
        }
        return -1;
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

