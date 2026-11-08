/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.text.UCharacterIterator;

public class StringUCharacterIterator
extends UCharacterIterator {
    private String m_text_;
    private int m_currentIndex_;

    public StringUCharacterIterator(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        this.m_text_ = string;
        this.m_currentIndex_ = 0;
    }

    public StringUCharacterIterator() {
        this.m_text_ = "";
        this.m_currentIndex_ = 0;
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
        if (this.m_currentIndex_ < this.m_text_.length()) {
            return this.m_text_.charAt(this.m_currentIndex_);
        }
        return -1;
    }

    public int getLength() {
        return this.m_text_.length();
    }

    public int getIndex() {
        return this.m_currentIndex_;
    }

    public int next() {
        if (this.m_currentIndex_ < this.m_text_.length()) {
            return this.m_text_.charAt(this.m_currentIndex_++);
        }
        return -1;
    }

    public int previous() {
        if (this.m_currentIndex_ > 0) {
            return this.m_text_.charAt(--this.m_currentIndex_);
        }
        return -1;
    }

    public void setIndex(int n) throws IndexOutOfBoundsException {
        if (n < 0 || n > this.m_text_.length()) {
            throw new IndexOutOfBoundsException();
        }
        this.m_currentIndex_ = n;
    }

    public int getText(char[] cArray, int n) {
        int n2 = this.m_text_.length();
        if (n < 0 || n + n2 > cArray.length) {
            throw new IndexOutOfBoundsException(Integer.toString(n2));
        }
        this.m_text_.getChars(0, n2, cArray, n);
        return n2;
    }

    public String getText() {
        return this.m_text_;
    }

    public void setText(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.m_text_ = string;
        this.m_currentIndex_ = 0;
    }
}

