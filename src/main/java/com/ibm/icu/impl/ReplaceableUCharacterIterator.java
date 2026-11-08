/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.text.Replaceable;
import com.ibm.icu.text.ReplaceableString;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.text.UTF16;

public class ReplaceableUCharacterIterator
extends UCharacterIterator {
    private Replaceable replaceable;
    private int currentIndex;

    public ReplaceableUCharacterIterator(Replaceable replaceable) {
        if (replaceable == null) {
            throw new IllegalArgumentException();
        }
        this.replaceable = replaceable;
        this.currentIndex = 0;
    }

    public ReplaceableUCharacterIterator(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        this.replaceable = new ReplaceableString(string);
        this.currentIndex = 0;
    }

    public ReplaceableUCharacterIterator(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            throw new IllegalArgumentException();
        }
        this.replaceable = new ReplaceableString(stringBuffer);
        this.currentIndex = 0;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public int current() {
        if (this.currentIndex < this.replaceable.length()) {
            return this.replaceable.charAt(this.currentIndex);
        }
        return -1;
    }

    public int currentCodePoint() {
        int n = this.current();
        if (UTF16.isLeadSurrogate((char)n)) {
            this.next();
            int n2 = this.current();
            this.previous();
            if (UTF16.isTrailSurrogate((char)n2)) {
                return UCharacterProperty.getRawSupplementary((char)n, (char)n2);
            }
        }
        return n;
    }

    public int getLength() {
        return this.replaceable.length();
    }

    public int getIndex() {
        return this.currentIndex;
    }

    public int next() {
        if (this.currentIndex < this.replaceable.length()) {
            return this.replaceable.charAt(this.currentIndex++);
        }
        return -1;
    }

    public int previous() {
        if (this.currentIndex > 0) {
            return this.replaceable.charAt(--this.currentIndex);
        }
        return -1;
    }

    public void setIndex(int n) throws IndexOutOfBoundsException {
        if (n < 0 || n > this.replaceable.length()) {
            throw new IndexOutOfBoundsException();
        }
        this.currentIndex = n;
    }

    public int getText(char[] cArray, int n) {
        int n2 = this.replaceable.length();
        if (n < 0 || n + n2 > cArray.length) {
            throw new IndexOutOfBoundsException(Integer.toString(n2));
        }
        this.replaceable.getChars(0, n2, cArray, n);
        return n2;
    }
}

