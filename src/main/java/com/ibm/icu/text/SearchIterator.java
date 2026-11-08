/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.BreakIterator;
import java.text.CharacterIterator;

public abstract class SearchIterator {
    public static final int DONE = -1;
    protected BreakIterator breakIterator;
    protected CharacterIterator targetText;
    protected int matchLength;
    private boolean m_isForwardSearching_;
    private boolean m_isOverlap_;
    private boolean m_reset_;
    private int m_setOffset_;
    private int m_lastMatchStart_;

    public void setIndex(int n) {
        if (n < this.targetText.getBeginIndex() || n > this.targetText.getEndIndex()) {
            throw new IndexOutOfBoundsException("setIndex(int) expected position to be between " + this.targetText.getBeginIndex() + " and " + this.targetText.getEndIndex());
        }
        this.m_setOffset_ = n;
        this.m_reset_ = false;
        this.matchLength = 0;
    }

    public void setOverlapping(boolean bl) {
        this.m_isOverlap_ = bl;
    }

    public void setBreakIterator(BreakIterator breakIterator) {
        this.breakIterator = breakIterator;
        if (this.breakIterator != null) {
            this.breakIterator.setText(this.targetText);
        }
    }

    public void setTarget(CharacterIterator characterIterator) {
        if (characterIterator == null || characterIterator.getEndIndex() == characterIterator.getIndex()) {
            throw new IllegalArgumentException("Illegal null or empty text");
        }
        this.targetText = characterIterator;
        this.targetText.setIndex(this.targetText.getBeginIndex());
        this.matchLength = 0;
        this.m_reset_ = true;
        this.m_isForwardSearching_ = true;
        if (this.breakIterator != null) {
            this.breakIterator.setText(this.targetText);
        }
    }

    public int getMatchStart() {
        return this.m_lastMatchStart_;
    }

    public abstract int getIndex();

    public int getMatchLength() {
        return this.matchLength;
    }

    public BreakIterator getBreakIterator() {
        return this.breakIterator;
    }

    public CharacterIterator getTarget() {
        return this.targetText;
    }

    public String getMatchedText() {
        if (this.matchLength > 0) {
            int n = this.m_lastMatchStart_ + this.matchLength;
            StringBuilder stringBuilder = new StringBuilder(this.matchLength);
            stringBuilder.append(this.targetText.current());
            this.targetText.next();
            while (this.targetText.getIndex() < n) {
                stringBuilder.append(this.targetText.current());
                this.targetText.next();
            }
            this.targetText.setIndex(this.m_lastMatchStart_);
            return stringBuilder.toString();
        }
        return null;
    }

    public int next() {
        int n = this.targetText.getIndex();
        if (this.m_setOffset_ != -1) {
            n = this.m_setOffset_;
            this.m_setOffset_ = -1;
        }
        if (this.m_isForwardSearching_) {
            if (!this.m_reset_ && n + this.matchLength >= this.targetText.getEndIndex()) {
                this.matchLength = 0;
                this.targetText.setIndex(this.targetText.getEndIndex());
                this.m_lastMatchStart_ = -1;
                return -1;
            }
            this.m_reset_ = false;
        } else {
            this.m_isForwardSearching_ = true;
            if (n != -1) {
                return n;
            }
        }
        if (n == -1) {
            n = this.targetText.getBeginIndex();
        }
        if (this.matchLength > 0) {
            n = this.m_isOverlap_ ? ++n : (n += this.matchLength);
        }
        this.m_lastMatchStart_ = this.handleNext(n);
        return this.m_lastMatchStart_;
    }

    public int previous() {
        int n = this.targetText.getIndex();
        if (this.m_setOffset_ != -1) {
            n = this.m_setOffset_;
            this.m_setOffset_ = -1;
        }
        if (this.m_reset_) {
            this.m_isForwardSearching_ = false;
            this.m_reset_ = false;
            n = this.targetText.getEndIndex();
        }
        if (this.m_isForwardSearching_) {
            this.m_isForwardSearching_ = false;
            if (n != this.targetText.getEndIndex()) {
                return n;
            }
        } else if (n == this.targetText.getBeginIndex()) {
            this.matchLength = 0;
            this.targetText.setIndex(this.targetText.getBeginIndex());
            this.m_lastMatchStart_ = -1;
            return -1;
        }
        this.m_lastMatchStart_ = this.handlePrevious(n);
        return this.m_lastMatchStart_;
    }

    public boolean isOverlapping() {
        return this.m_isOverlap_;
    }

    public void reset() {
        this.matchLength = 0;
        this.setIndex(this.targetText.getBeginIndex());
        this.m_isOverlap_ = false;
        this.m_isForwardSearching_ = true;
        this.m_reset_ = true;
        this.m_setOffset_ = -1;
    }

    public final int first() {
        this.m_isForwardSearching_ = true;
        this.setIndex(this.targetText.getBeginIndex());
        return this.next();
    }

    public final int following(int n) {
        this.m_isForwardSearching_ = true;
        this.setIndex(n);
        return this.next();
    }

    public final int last() {
        this.m_isForwardSearching_ = false;
        this.setIndex(this.targetText.getEndIndex());
        return this.previous();
    }

    public final int preceding(int n) {
        this.m_isForwardSearching_ = false;
        this.setIndex(n);
        return this.previous();
    }

    protected SearchIterator(CharacterIterator characterIterator, BreakIterator breakIterator) {
        if (characterIterator == null || characterIterator.getEndIndex() - characterIterator.getBeginIndex() == 0) {
            throw new IllegalArgumentException("Illegal argument target.  Argument can not be null or of length 0");
        }
        this.targetText = characterIterator;
        this.breakIterator = breakIterator;
        if (this.breakIterator != null) {
            this.breakIterator.setText(characterIterator);
        }
        this.matchLength = 0;
        this.m_lastMatchStart_ = -1;
        this.m_isOverlap_ = false;
        this.m_isForwardSearching_ = true;
        this.m_reset_ = true;
        this.m_setOffset_ = -1;
    }

    protected void setMatchLength(int n) {
        this.matchLength = n;
    }

    protected abstract int handleNext(int var1);

    protected abstract int handlePrevious(int var1);
}

