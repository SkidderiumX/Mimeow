/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.stringified;

import com.viaversion.nbt.stringified.StringifiedTagParseException;

public class CharBuffer {
    private final CharSequence sequence;
    private int index;

    CharBuffer(CharSequence charSequence) {
        this.sequence = charSequence;
    }

    public char peek() {
        return this.sequence.charAt(this.index);
    }

    public char peek(int n) {
        return this.sequence.charAt(this.index + n);
    }

    public char take() {
        return this.sequence.charAt(this.index++);
    }

    public boolean advance() {
        ++this.index;
        return this.hasMore();
    }

    public boolean hasMore() {
        return this.index < this.sequence.length();
    }

    public boolean hasMore(int n) {
        return this.index + n < this.sequence.length();
    }

    public CharSequence takeUntil(char c) throws StringifiedTagParseException {
        c = Character.toLowerCase(c);
        int n = -1;
        for (int i = this.index; i < this.sequence.length(); ++i) {
            if (this.sequence.charAt(i) == '\\') {
                ++i;
                continue;
            }
            if (Character.toLowerCase(this.sequence.charAt(i)) != c) continue;
            n = i;
            break;
        }
        if (n == -1) {
            throw this.makeError("No occurrence of " + c + " was found");
        }
        CharSequence charSequence = this.sequence.subSequence(this.index, n);
        this.index = n + 1;
        return charSequence;
    }

    public CharBuffer expect(char c) throws StringifiedTagParseException {
        this.skipWhitespace();
        if (!this.hasMore()) {
            throw this.makeError("Expected character '" + c + "' but got EOF");
        }
        if (this.peek() != c) {
            throw this.makeError("Expected character '" + c + "' but got '" + this.peek() + "'");
        }
        this.take();
        return this;
    }

    public boolean takeIf(char c) {
        this.skipWhitespace();
        if (this.hasMore() && this.peek() == c) {
            this.advance();
            return true;
        }
        return false;
    }

    public int index() {
        return this.index;
    }

    public CharBuffer skipWhitespace() {
        while (this.hasMore() && Character.isWhitespace(this.peek())) {
            this.advance();
        }
        return this;
    }

    public StringifiedTagParseException makeError(String string) {
        return new StringifiedTagParseException(string, this.index);
    }
}

