/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12;

import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;

public class StringReader_v1_12 {
    private final String s;
    private int index;

    public StringReader_v1_12(String string) {
        this.s = string;
    }

    public String getString() {
        return this.s;
    }

    public int getIndex() {
        return this.index;
    }

    public char read() {
        return this.s.charAt(this.index++);
    }

    public char charAt(int n) {
        return this.s.charAt(this.index + n);
    }

    public char peek() {
        return this.charAt(0);
    }

    public void skip() {
        ++this.index;
    }

    public boolean canRead() {
        return this.canRead(0);
    }

    public boolean canRead(int n) {
        return this.index + n < this.s.length();
    }

    public void skipWhitespaces() {
        while (this.canRead() && Character.isWhitespace(this.peek())) {
            ++this.index;
        }
    }

    public int readInt() throws SNbtDeserializeException {
        int n = this.index;
        while (this.canRead() && this.isNumerical(this.peek())) {
            ++this.index;
        }
        String string = this.s.substring(n, this.index);
        if (string.isEmpty()) {
            throw new SNbtDeserializeException("Expected double but got nothing", this.s, this.index);
        }
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new SNbtDeserializeException("Expected double but got '" + string + "'", this.s, n);
        }
    }

    public double readDouble() throws SNbtDeserializeException {
        int n = this.index;
        while (this.canRead() && this.isNumerical(this.peek())) {
            ++this.index;
        }
        String string = this.s.substring(n, this.index);
        if (string.isEmpty()) {
            throw new SNbtDeserializeException("Expected double but got nothing", this.s, this.index);
        }
        try {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new SNbtDeserializeException("Expected double but got '" + string + "'", this.s, n);
        }
    }

    public String readString() throws SNbtDeserializeException {
        this.skipWhitespaces();
        if (!this.canRead()) {
            return null;
        }
        return this.isQuote(this.peek()) ? this.readQuotedString() : this.readUnquotedString();
    }

    public String readUnquotedString() {
        int n = this.index;
        while (this.canRead() && this.isAlphanumeric(this.peek())) {
            ++this.index;
        }
        return this.s.substring(n, this.index);
    }

    public String readQuotedString() throws SNbtDeserializeException {
        char c = this.read();
        int n = this.index;
        StringBuilder stringBuilder = null;
        boolean bl = false;
        while (this.canRead()) {
            char c2 = this.read();
            if (bl) {
                if (c2 != '\\' && c2 != c) {
                    throw new SNbtDeserializeException("Invalid escape of '" + c2 + "'");
                }
                bl = false;
            } else {
                if (c2 == '\\') {
                    bl = true;
                    if (stringBuilder != null) continue;
                    stringBuilder = new StringBuilder(this.s.substring(n, this.index - 1));
                    continue;
                }
                if (c2 == c) {
                    return stringBuilder == null ? this.s.substring(n, this.index - 1) : stringBuilder.toString();
                }
            }
            if (stringBuilder == null) continue;
            stringBuilder.append(c2);
        }
        throw new SNbtDeserializeException("Missing termination quote", this.s, n - 1);
    }

    public void jumpTo(char c) throws SNbtDeserializeException {
        this.skipWhitespaces();
        boolean bl = this.canRead();
        if (bl && this.peek() == c) {
            ++this.index;
        } else {
            throw new SNbtDeserializeException("Expected '" + c + "' but got '" + (bl ? Character.valueOf(this.peek()) : "<EOL>") + "'", this.s, this.index + 1);
        }
    }

    protected boolean isQuote(char c) {
        return c == '\"';
    }

    private boolean isNumerical(char c) {
        return c >= '0' && c <= '9' || c == '.' || c == '-';
    }

    private boolean isAlphanumeric(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '_' || c == '-' || c == '.' || c == '+';
    }
}

