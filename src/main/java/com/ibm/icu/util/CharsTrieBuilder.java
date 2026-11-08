/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.StringTrieBuilder;
import java.nio.CharBuffer;

public class CharsTrieBuilder
extends StringTrieBuilder {
    private final char[] intUnits = new char[3];
    private char[] chars;
    private int charsLength;

    public CharsTrieBuilder add(CharSequence charSequence, int n) {
        this.addImpl(charSequence, n);
        return this;
    }

    public CharsTrie build(StringTrieBuilder.Option option) {
        return new CharsTrie(this.buildCharSequence(option), 0);
    }

    public CharSequence buildCharSequence(StringTrieBuilder.Option option) {
        this.buildChars(option);
        return CharBuffer.wrap(this.chars, this.chars.length - this.charsLength, this.charsLength);
    }

    private void buildChars(StringTrieBuilder.Option option) {
        if (this.chars == null) {
            this.chars = new char[1024];
        }
        this.buildImpl(option);
    }

    public CharsTrieBuilder clear() {
        this.clearImpl();
        this.chars = null;
        this.charsLength = 0;
        return this;
    }

    protected boolean matchNodesCanHaveValues() {
        return true;
    }

    protected int getMaxBranchLinearSubNodeLength() {
        return 5;
    }

    protected int getMinLinearMatch() {
        return 48;
    }

    protected int getMaxLinearMatchLength() {
        return 16;
    }

    private void ensureCapacity(int n) {
        if (n > this.chars.length) {
            int n2 = this.chars.length;
            while ((n2 *= 2) <= n) {
            }
            char[] cArray = new char[n2];
            System.arraycopy(this.chars, this.chars.length - this.charsLength, cArray, cArray.length - this.charsLength, this.charsLength);
            this.chars = cArray;
        }
    }

    protected int write(int n) {
        int n2 = this.charsLength + 1;
        this.ensureCapacity(n2);
        this.charsLength = n2;
        this.chars[this.chars.length - this.charsLength] = (char)n;
        return this.charsLength;
    }

    protected int write(int n, int n2) {
        int n3 = this.charsLength + n2;
        this.ensureCapacity(n3);
        this.charsLength = n3;
        int n4 = this.chars.length - this.charsLength;
        while (n2 > 0) {
            this.chars[n4++] = this.strings.charAt(n++);
            --n2;
        }
        return this.charsLength;
    }

    private int write(char[] cArray, int n) {
        int n2 = this.charsLength + n;
        this.ensureCapacity(n2);
        this.charsLength = n2;
        System.arraycopy(cArray, 0, this.chars, this.chars.length - this.charsLength, n);
        return this.charsLength;
    }

    protected int writeValueAndFinal(int n, boolean bl) {
        int n2;
        if (0 <= n && n <= 16383) {
            return this.write(n | (bl ? 32768 : 0));
        }
        if (n < 0 || n > 0x3FFEFFFF) {
            this.intUnits[0] = Short.MAX_VALUE;
            this.intUnits[1] = (char)(n >> 16);
            this.intUnits[2] = (char)n;
            n2 = 3;
        } else {
            this.intUnits[0] = (char)(16384 + (n >> 16));
            this.intUnits[1] = (char)n;
            n2 = 2;
        }
        this.intUnits[0] = (char)(this.intUnits[0] | (bl ? 32768 : 0));
        return this.write(this.intUnits, n2);
    }

    protected int writeValueAndType(boolean bl, int n, int n2) {
        int n3;
        if (!bl) {
            return this.write(n2);
        }
        if (n < 0 || n > 0xFDFFFF) {
            this.intUnits[0] = 32704;
            this.intUnits[1] = (char)(n >> 16);
            this.intUnits[2] = (char)n;
            n3 = 3;
        } else if (n <= 255) {
            this.intUnits[0] = (char)(n + 1 << 6);
            n3 = 1;
        } else {
            this.intUnits[0] = (char)(16448 + (n >> 10 & 0x7FC0));
            this.intUnits[1] = (char)n;
            n3 = 2;
        }
        this.intUnits[0] = (char)(this.intUnits[0] | (char)n2);
        return this.write(this.intUnits, n3);
    }

    protected int writeDeltaTo(int n) {
        int n2;
        int n3 = this.charsLength - n;
        assert (n3 >= 0);
        if (n3 <= 64511) {
            return this.write(n3);
        }
        if (n3 <= 0x3FEFFFF) {
            this.intUnits[0] = (char)(64512 + (n3 >> 16));
            n2 = 1;
        } else {
            this.intUnits[0] = 65535;
            this.intUnits[1] = (char)(n3 >> 16);
            n2 = 2;
        }
        this.intUnits[n2++] = (char)n3;
        return this.write(this.intUnits, n2);
    }
}

