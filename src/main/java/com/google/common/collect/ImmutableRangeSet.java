/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractRangeSet;
import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedLists;
import com.google.common.collect.TreeRangeSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@Beta
public class ImmutableRangeSet<C extends Comparable>
extends AbstractRangeSet<C>
implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet(ImmutableList.of());
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
    private final transient ImmutableList<Range<C>> ranges;
    private transient ImmutableRangeSet<C> complement;

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return ImmutableRangeSet.of();
        }
        if (range.equals(Range.all())) {
            return ImmutableRangeSet.all();
        }
        return new ImmutableRangeSet<C>(ImmutableList.of(range));
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> rangeSet) {
        ImmutableRangeSet immutableRangeSet;
        Preconditions.checkNotNull(rangeSet);
        if (rangeSet.isEmpty()) {
            return ImmutableRangeSet.of();
        }
        if (rangeSet.encloses(Range.all())) {
            return ImmutableRangeSet.all();
        }
        if (rangeSet instanceof ImmutableRangeSet && !(immutableRangeSet = (ImmutableRangeSet)rangeSet).isPartialView()) {
            return immutableRangeSet;
        }
        return new ImmutableRangeSet<C>(ImmutableList.copyOf(rangeSet.asRanges()));
    }

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    @Override
    public boolean encloses(Range<C> range) {
        int n = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return n != -1 && ((Range)this.ranges.get(n)).encloses(range);
    }

    @Override
    public Range<C> rangeContaining(C c) {
        int n = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (n != -1) {
            Range range = (Range)this.ranges.get(n);
            return range.contains(c) ? range : null;
        }
        return null;
    }

    @Override
    public Range<C> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(((Range)this.ranges.get((int)0)).lowerBound, ((Range)this.ranges.get((int)(this.ranges.size() - 1))).upperBound);
    }

    @Override
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    @Override
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet<Range<C>>(this.ranges, Range.RANGE_LEX_ORDERING);
    }

    @Override
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            this.complement = ImmutableRangeSet.all();
            return this.complement;
        }
        if (this.ranges.size() == 1 && ((Range)this.ranges.get(0)).equals(Range.all())) {
            this.complement = ImmutableRangeSet.of();
            return this.complement;
        }
        ComplementRanges complementRanges = new ComplementRanges();
        immutableRangeSet = this.complement = new ImmutableRangeSet<C>(complementRanges, this);
        return immutableRangeSet;
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(this.span())) {
            return this.ranges;
        }
        final int n = range.hasLowerBound() ? SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
        int n2 = range.hasUpperBound() ? SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : this.ranges.size();
        final int n3 = n2 - n;
        if (n3 == 0) {
            return ImmutableList.of();
        }
        return new ImmutableList<Range<C>>(){

            @Override
            public int size() {
                return n3;
            }

            @Override
            public Range<C> get(int n2) {
                Preconditions.checkElementIndex(n2, n3);
                if (n2 == 0 || n2 == n3 - 1) {
                    return ((Range)ImmutableRangeSet.this.ranges.get(n2 + n)).intersection(range);
                }
                return (Range)ImmutableRangeSet.this.ranges.get(n2 + n);
            }

            @Override
            boolean isPartialView() {
                return true;
            }
        };
    }

    @Override
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!this.isEmpty()) {
            Range<C> range2 = this.span();
            if (range.encloses(range2)) {
                return this;
            }
            if (range.isConnected(range2)) {
                return new ImmutableRangeSet<C>(this.intersectRanges(range));
            }
        }
        return ImmutableRangeSet.of();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        if (this.isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> range = this.span().canonical(discreteDomain);
        if (!range.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!range.hasUpperBound()) {
            try {
                discreteDomain.maxValue();
            }
            catch (NoSuchElementException noSuchElementException) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new AsSet(discreteDomain);
    }

    boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder();
    }

    Object writeReplace() {
        return new SerializedForm<C>(this.ranges);
    }

    private static final class SerializedForm<C extends Comparable>
    implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (this.ranges.equals(ImmutableList.of(Range.all()))) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet<C>(this.ranges);
        }
    }

    public static class Builder<C extends Comparable<?>> {
        private final RangeSet<C> rangeSet = TreeRangeSet.create();

        public Builder<C> add(Range<C> range) {
            if (range.isEmpty()) {
                throw new IllegalArgumentException("range must not be empty, but was " + range);
            }
            if (!this.rangeSet.complement().encloses(range)) {
                for (Range<C> range2 : this.rangeSet.asRanges()) {
                    Preconditions.checkArgument(!range2.isConnected(range) || range2.intersection(range).isEmpty(), "Ranges may not overlap, but received %s and %s", range2, range);
                }
                throw new AssertionError((Object)"should have thrown an IAE above");
            }
            this.rangeSet.add(range);
            return this;
        }

        public Builder<C> addAll(RangeSet<C> rangeSet) {
            for (Range<C> range : rangeSet.asRanges()) {
                this.add(range);
            }
            return this;
        }

        public ImmutableRangeSet<C> build() {
            return ImmutableRangeSet.copyOf(this.rangeSet);
        }
    }

    private static class AsSetSerializedForm<C extends Comparable>
    implements Serializable {
        private final ImmutableList<Range<C>> ranges;
        private final DiscreteDomain<C> domain;

        AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        Object readResolve() {
            return new ImmutableRangeSet<C>(this.ranges).asSet(this.domain);
        }
    }

    private final class AsSet
    extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;
        private transient Integer size;

        AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override
        public int size() {
            Integer n = this.size;
            if (n == null) {
                Range range;
                long l = 0L;
                Iterator iterator2 = ImmutableRangeSet.this.ranges.iterator();
                while (iterator2.hasNext() && (l += (long)ContiguousSet.create(range = (Range)iterator2.next(), this.domain).size()) < Integer.MAX_VALUE) {
                }
                n = this.size = Integer.valueOf(Ints.saturatedCast(l));
            }
            return n;
        }

        @Override
        public UnmodifiableIterator<C> iterator() {
            return new AbstractIterator<C>(){
                final Iterator<Range<C>> rangeItr;
                Iterator<C> elemItr;
                {
                    this.rangeItr = ImmutableRangeSet.this.ranges.iterator();
                    this.elemItr = Iterators.emptyIterator();
                }

                @Override
                protected C computeNext() {
                    while (!this.elemItr.hasNext()) {
                        if (this.rangeItr.hasNext()) {
                            this.elemItr = ContiguousSet.create(this.rangeItr.next(), AsSet.this.domain).iterator();
                            continue;
                        }
                        return (Comparable)this.endOfData();
                    }
                    return (Comparable)this.elemItr.next();
                }
            };
        }

        @Override
        @GwtIncompatible(value="NavigableSet")
        public UnmodifiableIterator<C> descendingIterator() {
            return new AbstractIterator<C>(){
                final Iterator<Range<C>> rangeItr;
                Iterator<C> elemItr;
                {
                    this.rangeItr = ImmutableRangeSet.this.ranges.reverse().iterator();
                    this.elemItr = Iterators.emptyIterator();
                }

                @Override
                protected C computeNext() {
                    while (!this.elemItr.hasNext()) {
                        if (this.rangeItr.hasNext()) {
                            this.elemItr = ContiguousSet.create(this.rangeItr.next(), AsSet.this.domain).descendingIterator();
                            continue;
                        }
                        return (Comparable)this.endOfData();
                    }
                    return (Comparable)this.elemItr.next();
                }
            };
        }

        ImmutableSortedSet<C> subSet(Range<C> range) {
            return ((ImmutableRangeSet)ImmutableRangeSet.this.subRangeSet(range)).asSet(this.domain);
        }

        @Override
        ImmutableSortedSet<C> headSetImpl(C c, boolean bl) {
            return this.subSet(Range.upTo(c, BoundType.forBoolean(bl)));
        }

        @Override
        ImmutableSortedSet<C> subSetImpl(C c, boolean bl, C c2, boolean bl2) {
            if (!bl && !bl2 && Range.compareOrThrow(c, c2) == 0) {
                return ImmutableSortedSet.of();
            }
            return this.subSet(Range.range(c, BoundType.forBoolean(bl), c2, BoundType.forBoolean(bl2)));
        }

        @Override
        ImmutableSortedSet<C> tailSetImpl(C c, boolean bl) {
            return this.subSet(Range.downTo(c, BoundType.forBoolean(bl)));
        }

        @Override
        public boolean contains(@Nullable Object object) {
            if (object == null) {
                return false;
            }
            try {
                Comparable comparable = (Comparable)object;
                return ImmutableRangeSet.this.contains(comparable);
            }
            catch (ClassCastException classCastException) {
                return false;
            }
        }

        @Override
        int indexOf(Object object) {
            if (this.contains(object)) {
                Comparable comparable = (Comparable)object;
                long l = 0L;
                for (Range range : ImmutableRangeSet.this.ranges) {
                    if (range.contains(comparable)) {
                        return Ints.saturatedCast(l + (long)ContiguousSet.create(range, this.domain).indexOf(comparable));
                    }
                    l += (long)ContiguousSet.create(range, this.domain).size();
                }
                throw new AssertionError((Object)"impossible");
            }
            return -1;
        }

        @Override
        boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        @Override
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override
        Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }
    }

    private final class ComplementRanges
    extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedBelow;
        private final boolean positiveBoundedAbove;
        private final int size;

        ComplementRanges() {
            this.positiveBoundedBelow = ((Range)ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedAbove = ((Range)Iterables.getLast(ImmutableRangeSet.this.ranges)).hasUpperBound();
            int n = ImmutableRangeSet.this.ranges.size() - 1;
            if (this.positiveBoundedBelow) {
                ++n;
            }
            if (this.positiveBoundedAbove) {
                ++n;
            }
            this.size = n;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public Range<C> get(int n) {
            Preconditions.checkElementIndex(n, this.size);
            Cut cut = this.positiveBoundedBelow ? (n == 0 ? Cut.belowAll() : ((Range)((ImmutableRangeSet)ImmutableRangeSet.this).ranges.get((int)(n - 1))).upperBound) : ((Range)((ImmutableRangeSet)ImmutableRangeSet.this).ranges.get((int)n)).upperBound;
            Cut cut2 = this.positiveBoundedAbove && n == this.size - 1 ? Cut.aboveAll() : ((Range)((ImmutableRangeSet)ImmutableRangeSet.this).ranges.get((int)(n + (this.positiveBoundedBelow ? 0 : 1)))).lowerBound;
            return Range.create(cut, cut2);
        }

        @Override
        boolean isPartialView() {
            return true;
        }
    }
}

