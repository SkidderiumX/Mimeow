/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import javax.annotation.Nullable;

public abstract class AbstractRangeSet<C extends Comparable>
implements RangeSet<C> {
    AbstractRangeSet() {
    }

    @Override
    public boolean contains(C c) {
        return this.rangeContaining(c) != null;
    }

    @Override
    public abstract Range<C> rangeContaining(C var1);

    @Override
    public boolean isEmpty() {
        return this.asRanges().isEmpty();
    }

    @Override
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.remove(Range.all());
    }

    @Override
    public boolean enclosesAll(RangeSet<C> rangeSet) {
        for (Range<C> range : rangeSet.asRanges()) {
            if (this.encloses(range)) continue;
            return false;
        }
        return true;
    }

    @Override
    public void addAll(RangeSet<C> rangeSet) {
        for (Range<C> range : rangeSet.asRanges()) {
            this.add(range);
        }
    }

    @Override
    public void removeAll(RangeSet<C> rangeSet) {
        for (Range<C> range : rangeSet.asRanges()) {
            this.remove(range);
        }
    }

    @Override
    public abstract boolean encloses(Range<C> var1);

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof RangeSet) {
            RangeSet rangeSet = (RangeSet)object;
            return this.asRanges().equals(rangeSet.asRanges());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.asRanges().hashCode();
    }

    @Override
    public final String toString() {
        return this.asRanges().toString();
    }
}

