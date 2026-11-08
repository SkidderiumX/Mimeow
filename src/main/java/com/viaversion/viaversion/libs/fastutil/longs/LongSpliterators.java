/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.SafeMath;
import com.viaversion.viaversion.libs.fastutil.bytes.ByteSpliterator;
import com.viaversion.viaversion.libs.fastutil.chars.CharSpliterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongBigListIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongComparator;
import com.viaversion.viaversion.libs.fastutil.longs.LongComparators;
import com.viaversion.viaversion.libs.fastutil.longs.LongConsumer;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import com.viaversion.viaversion.libs.fastutil.shorts.ShortSpliterator;
import java.io.Serializable;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongPredicate;

public class LongSpliterators {
    static final int BASE_SPLITERATOR_CHARACTERISTICS = 256;
    public static final int COLLECTION_SPLITERATOR_CHARACTERISTICS = 320;
    public static final int LIST_SPLITERATOR_CHARACTERISTICS = 16720;
    public static final int SET_SPLITERATOR_CHARACTERISTICS = 321;
    private static final int SORTED_CHARACTERISTICS = 20;
    public static final int SORTED_SET_SPLITERATOR_CHARACTERISTICS = 341;
    public static final EmptySpliterator EMPTY_SPLITERATOR = new EmptySpliterator();

    private LongSpliterators() {
    }

    public static LongSpliterator singleton(long l) {
        return new SingletonSpliterator(l);
    }

    public static LongSpliterator singleton(long l, LongComparator longComparator) {
        return new SingletonSpliterator(l, longComparator);
    }

    public static LongSpliterator wrap(long[] lArray, int n, int n2) {
        LongArrays.ensureOffsetLength(lArray, n, n2);
        return new ArraySpliterator(lArray, n, n2, 0);
    }

    public static LongSpliterator wrap(long[] lArray) {
        return new ArraySpliterator(lArray, 0, lArray.length, 0);
    }

    public static LongSpliterator wrap(long[] lArray, int n, int n2, int n3) {
        LongArrays.ensureOffsetLength(lArray, n, n2);
        return new ArraySpliterator(lArray, n, n2, n3);
    }

    public static LongSpliterator wrapPreSorted(long[] lArray, int n, int n2, int n3, LongComparator longComparator) {
        LongArrays.ensureOffsetLength(lArray, n, n2);
        return new ArraySpliteratorWithComparator(lArray, n, n2, n3, longComparator);
    }

    public static LongSpliterator wrapPreSorted(long[] lArray, int n, int n2, LongComparator longComparator) {
        return LongSpliterators.wrapPreSorted(lArray, n, n2, 0, longComparator);
    }

    public static LongSpliterator wrapPreSorted(long[] lArray, LongComparator longComparator) {
        return LongSpliterators.wrapPreSorted(lArray, 0, lArray.length, longComparator);
    }

    public static LongSpliterator asLongSpliterator(Spliterator spliterator) {
        if (spliterator instanceof LongSpliterator) {
            return (LongSpliterator)spliterator;
        }
        if (spliterator instanceof Spliterator.OfLong) {
            return new PrimitiveSpliteratorWrapper((Spliterator.OfLong)spliterator);
        }
        return new SpliteratorWrapper(spliterator);
    }

    public static LongSpliterator asLongSpliterator(Spliterator spliterator, LongComparator longComparator) {
        if (spliterator instanceof LongSpliterator) {
            throw new IllegalArgumentException("Cannot override comparator on instance that is already a " + LongSpliterator.class.getSimpleName());
        }
        if (spliterator instanceof Spliterator.OfLong) {
            return new PrimitiveSpliteratorWrapperWithComparator((Spliterator.OfLong)spliterator, longComparator);
        }
        return new SpliteratorWrapperWithComparator(spliterator, longComparator);
    }

    public static void onEachMatching(LongSpliterator longSpliterator, LongPredicate longPredicate, java.util.function.LongConsumer longConsumer) {
        Objects.requireNonNull(longPredicate);
        Objects.requireNonNull(longConsumer);
        longSpliterator.forEachRemaining(l -> {
            if (longPredicate.test(l)) {
                longConsumer.accept(l);
            }
        });
    }

    public static LongSpliterator fromTo(long l, long l2) {
        return new IntervalSpliterator(l, l2);
    }

    public static LongSpliterator concat(LongSpliterator ... longSpliteratorArray) {
        return LongSpliterators.concat(longSpliteratorArray, 0, longSpliteratorArray.length);
    }

    public static LongSpliterator concat(LongSpliterator[] longSpliteratorArray, int n, int n2) {
        return new SpliteratorConcatenator(longSpliteratorArray, n, n2);
    }

    public static LongSpliterator asSpliterator(LongIterator longIterator, long l, int n) {
        return new SpliteratorFromIterator(longIterator, l, n);
    }

    public static LongSpliterator asSpliteratorFromSorted(LongIterator longIterator, long l, int n, LongComparator longComparator) {
        return new SpliteratorFromIteratorWithComparator(longIterator, l, n, longComparator);
    }

    public static LongSpliterator asSpliteratorUnknownSize(LongIterator longIterator, int n) {
        return new SpliteratorFromIterator(longIterator, n);
    }

    public static LongSpliterator asSpliteratorFromSortedUnknownSize(LongIterator longIterator, int n, LongComparator longComparator) {
        return new SpliteratorFromIteratorWithComparator(longIterator, n, longComparator);
    }

    public static LongIterator asIterator(LongSpliterator longSpliterator) {
        return new IteratorFromSpliterator(longSpliterator);
    }

    public static LongSpliterator wrap(ByteSpliterator byteSpliterator) {
        return new ByteSpliteratorWrapper(byteSpliterator);
    }

    public static LongSpliterator wrap(ShortSpliterator shortSpliterator) {
        return new ShortSpliteratorWrapper(shortSpliterator);
    }

    public static LongSpliterator wrap(CharSpliterator charSpliterator) {
        return new CharSpliteratorWrapper(charSpliterator);
    }

    public static LongSpliterator wrap(IntSpliterator intSpliterator) {
        return new IntSpliteratorWrapper(intSpliterator);
    }

    private static class SingletonSpliterator
    implements LongSpliterator {
        private final long element;
        private final LongComparator comparator;
        private boolean consumed = false;
        private static final int CHARACTERISTICS = 17749;

        public SingletonSpliterator(long l) {
            this(l, null);
        }

        public SingletonSpliterator(long l, LongComparator longComparator) {
            this.element = l;
            this.comparator = longComparator;
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            if (this.consumed) {
                return false;
            }
            this.consumed = true;
            longConsumer.accept(this.element);
            return true;
        }

        @Override
        public LongSpliterator trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return this.consumed ? 0L : 1L;
        }

        @Override
        public int characteristics() {
            return 17749;
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            if (!this.consumed) {
                this.consumed = true;
                longConsumer.accept(this.element);
            }
        }

        @Override
        public LongComparator getComparator() {
            return this.comparator;
        }

        @Override
        public long skip(long l) {
            if (l < 0L) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + l);
            }
            if (l == 0L || this.consumed) {
                return 0L;
            }
            this.consumed = true;
            return 1L;
        }
    }

    private static class ArraySpliterator
    implements LongSpliterator {
        private static final int BASE_CHARACTERISTICS = 16720;
        final long[] array;
        private final int offset;
        private int length;
        private int curr;
        final int characteristics;

        public ArraySpliterator(long[] lArray, int n, int n2, int n3) {
            this.array = lArray;
            this.offset = n;
            this.length = n2;
            this.characteristics = 0x4150 | n3;
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            if (this.curr >= this.length) {
                return false;
            }
            Objects.requireNonNull(longConsumer);
            longConsumer.accept(this.array[this.offset + this.curr++]);
            return true;
        }

        @Override
        public long estimateSize() {
            return this.length - this.curr;
        }

        @Override
        public int characteristics() {
            return this.characteristics;
        }

        protected ArraySpliterator makeForSplit(int n, int n2) {
            return new ArraySpliterator(this.array, n, n2, this.characteristics);
        }

        @Override
        public LongSpliterator trySplit() {
            int n = this.length - this.curr >> 1;
            if (n <= 1) {
                return null;
            }
            int n2 = this.curr + n;
            int n3 = this.offset + this.curr;
            this.curr = n2;
            return this.makeForSplit(n3, n);
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            long[] lArray = this.array;
            while (this.curr < this.length) {
                longConsumer.accept(lArray[this.offset + this.curr]);
                ++this.curr;
            }
        }

        @Override
        public long skip(long l) {
            if (l < 0L) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + l);
            }
            if (this.curr >= this.length) {
                return 0L;
            }
            int n = this.length - this.curr;
            if (l < (long)n) {
                this.curr = SafeMath.safeLongToInt((long)this.curr + l);
                return l;
            }
            l = n;
            this.curr = this.length;
            return l;
        }
    }

    private static class ArraySpliteratorWithComparator
    extends ArraySpliterator {
        private final LongComparator comparator;

        public ArraySpliteratorWithComparator(long[] lArray, int n, int n2, int n3, LongComparator longComparator) {
            super(lArray, n, n2, n3 | 0x14);
            this.comparator = longComparator;
        }

        @Override
        protected ArraySpliteratorWithComparator makeForSplit(int n, int n2) {
            return new ArraySpliteratorWithComparator(this.array, n, n2, this.characteristics, this.comparator);
        }

        @Override
        public LongComparator getComparator() {
            return this.comparator;
        }
    }

    private static class PrimitiveSpliteratorWrapper
    implements LongSpliterator {
        final Spliterator.OfLong i;

        public PrimitiveSpliteratorWrapper(Spliterator.OfLong ofLong) {
            this.i = ofLong;
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            return this.i.tryAdvance(longConsumer);
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            this.i.forEachRemaining(longConsumer);
        }

        @Override
        public long estimateSize() {
            return this.i.estimateSize();
        }

        @Override
        public int characteristics() {
            return this.i.characteristics();
        }

        @Override
        public LongComparator getComparator() {
            return LongComparators.asLongComparator(this.i.getComparator());
        }

        @Override
        public LongSpliterator trySplit() {
            Spliterator.OfLong ofLong = this.i.trySplit();
            if (ofLong == null) {
                return null;
            }
            return new PrimitiveSpliteratorWrapper(ofLong);
        }
    }

    private static class SpliteratorWrapper
    implements LongSpliterator {
        final Spliterator<Long> i;

        public SpliteratorWrapper(Spliterator<Long> spliterator) {
            this.i = spliterator;
        }

        @Override
        public boolean tryAdvance(LongConsumer longConsumer) {
            return this.i.tryAdvance(longConsumer);
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            return this.i.tryAdvance(longConsumer instanceof Consumer ? (Consumer<Long>)((Object)longConsumer) : longConsumer::accept);
        }

        @Override
        @Deprecated
        public boolean tryAdvance(Consumer<? super Long> consumer) {
            return this.i.tryAdvance(consumer);
        }

        @Override
        public void forEachRemaining(LongConsumer longConsumer) {
            this.i.forEachRemaining(longConsumer);
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            this.i.forEachRemaining(longConsumer instanceof Consumer ? (Consumer<Long>)((Object)longConsumer) : longConsumer::accept);
        }

        @Override
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> consumer) {
            this.i.forEachRemaining(consumer);
        }

        @Override
        public long estimateSize() {
            return this.i.estimateSize();
        }

        @Override
        public int characteristics() {
            return this.i.characteristics();
        }

        @Override
        public LongComparator getComparator() {
            return LongComparators.asLongComparator(this.i.getComparator());
        }

        @Override
        public LongSpliterator trySplit() {
            Spliterator<Long> spliterator = this.i.trySplit();
            if (spliterator == null) {
                return null;
            }
            return new SpliteratorWrapper(spliterator);
        }
    }

    private static class PrimitiveSpliteratorWrapperWithComparator
    extends PrimitiveSpliteratorWrapper {
        final LongComparator comparator;

        public PrimitiveSpliteratorWrapperWithComparator(Spliterator.OfLong ofLong, LongComparator longComparator) {
            super(ofLong);
            this.comparator = longComparator;
        }

        @Override
        public LongComparator getComparator() {
            return this.comparator;
        }

        @Override
        public LongSpliterator trySplit() {
            Spliterator.OfLong ofLong = this.i.trySplit();
            if (ofLong == null) {
                return null;
            }
            return new PrimitiveSpliteratorWrapperWithComparator(ofLong, this.comparator);
        }
    }

    private static class SpliteratorWrapperWithComparator
    extends SpliteratorWrapper {
        final LongComparator comparator;

        public SpliteratorWrapperWithComparator(Spliterator<Long> spliterator, LongComparator longComparator) {
            super(spliterator);
            this.comparator = longComparator;
        }

        @Override
        public LongComparator getComparator() {
            return this.comparator;
        }

        @Override
        public LongSpliterator trySplit() {
            Spliterator<Long> spliterator = this.i.trySplit();
            if (spliterator == null) {
                return null;
            }
            return new SpliteratorWrapperWithComparator(spliterator, this.comparator);
        }
    }

    private static class IntervalSpliterator
    implements LongSpliterator {
        private static final int DONT_SPLIT_THRESHOLD = 2;
        private static final long MAX_SPLIT_SIZE = 0x40000000L;
        private static final int CHARACTERISTICS = 17749;
        private long curr;
        private long f600023e318;

        public IntervalSpliterator(long l, long l2) {
            this.curr = l;
            this.f600023e318 = l2;
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            if (this.curr >= this.f600023e318) {
                return false;
            }
            longConsumer.accept(this.curr++);
            return true;
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            while (this.curr < this.f600023e318) {
                longConsumer.accept(this.curr);
                ++this.curr;
            }
        }

        @Override
        public long estimateSize() {
            return this.f600023e318 - this.curr;
        }

        @Override
        public int characteristics() {
            return 17749;
        }

        @Override
        public LongComparator getComparator() {
            return null;
        }

        @Override
        public LongSpliterator trySplit() {
            long l = this.f600023e318 - this.curr;
            long l2 = this.curr + (l >> 1);
            if (l > 0x80000000L || l < 0L) {
                l2 = this.curr + 0x40000000L;
            }
            if (l >= 0L && l <= 2L) {
                return null;
            }
            long l3 = this.curr;
            this.curr = l2;
            return new IntervalSpliterator(l3, l2);
        }

        @Override
        public long skip(long l) {
            if (l < 0L) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + l);
            }
            if (this.curr >= this.f600023e318) {
                return 0L;
            }
            long l2 = this.curr + l;
            if (l2 <= this.f600023e318 && l2 >= this.curr) {
                this.curr = l2;
                return l;
            }
            l = this.f600023e318 - this.curr;
            this.curr = this.f600023e318;
            return l;
        }
    }

    private static class SpliteratorConcatenator
    implements LongSpliterator {
        private static final int EMPTY_CHARACTERISTICS = 16448;
        private static final int CHARACTERISTICS_NOT_SUPPORTED_WHILE_MULTIPLE = 5;
        final LongSpliterator[] a;
        int offset;
        int length;
        long remainingEstimatedExceptCurrent = Long.MAX_VALUE;
        int characteristics = 0;

        public SpliteratorConcatenator(LongSpliterator[] longSpliteratorArray, int n, int n2) {
            this.a = longSpliteratorArray;
            this.offset = n;
            this.length = n2;
            this.remainingEstimatedExceptCurrent = this.recomputeRemaining();
            this.characteristics = this.computeCharacteristics();
        }

        private long recomputeRemaining() {
            int n = this.offset + 1;
            long l = 0L;
            for (int i = this.length - 1; i > 0; --i) {
                long l2 = this.a[n++].estimateSize();
                if (l2 != Long.MAX_VALUE) continue;
                return Long.MAX_VALUE;
            }
            return l;
        }

        private int computeCharacteristics() {
            if (this.length <= 0) {
                return 16448;
            }
            int n = -1;
            int n2 = this.length;
            int n3 = this.offset;
            if (n2 > 1) {
                n &= 0xFFFFFFFA;
            }
            while (n2 > 0) {
                n &= this.a[n3++].characteristics();
                --n2;
            }
            return n;
        }

        private void advanceNextSpliterator() {
            if (this.length <= 0) {
                throw new AssertionError((Object)"advanceNextSpliterator() called with none remaining");
            }
            ++this.offset;
            --this.length;
            this.remainingEstimatedExceptCurrent = this.recomputeRemaining();
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            boolean bl = false;
            while (this.length > 0) {
                if (this.a[this.offset].tryAdvance(longConsumer)) {
                    bl = true;
                    break;
                }
                this.advanceNextSpliterator();
            }
            return bl;
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            while (this.length > 0) {
                this.a[this.offset].forEachRemaining(longConsumer);
                this.advanceNextSpliterator();
            }
        }

        @Override
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> consumer) {
            while (this.length > 0) {
                this.a[this.offset].forEachRemaining(consumer);
                this.advanceNextSpliterator();
            }
        }

        @Override
        public long estimateSize() {
            if (this.length <= 0) {
                return 0L;
            }
            long l = this.a[this.offset].estimateSize() + this.remainingEstimatedExceptCurrent;
            if (l < 0L) {
                return Long.MAX_VALUE;
            }
            return l;
        }

        @Override
        public int characteristics() {
            return this.characteristics;
        }

        @Override
        public LongComparator getComparator() {
            if (this.length == 1 && (this.characteristics & 4) != 0) {
                return this.a[this.offset].getComparator();
            }
            throw new IllegalStateException();
        }

        @Override
        public LongSpliterator trySplit() {
            switch (this.length) {
                case 0: {
                    return null;
                }
                case 1: {
                    LongSpliterator longSpliterator = this.a[this.offset].trySplit();
                    this.characteristics = this.a[this.offset].characteristics();
                    return longSpliterator;
                }
                case 2: {
                    LongSpliterator longSpliterator = this.a[this.offset++];
                    --this.length;
                    this.characteristics = this.a[this.offset].characteristics();
                    this.remainingEstimatedExceptCurrent = 0L;
                    return longSpliterator;
                }
            }
            int n = this.length >> 1;
            int n2 = this.offset;
            int n3 = this.offset + n;
            int n4 = n;
            int n5 = this.length - n;
            this.offset = n3;
            this.length = n5;
            this.remainingEstimatedExceptCurrent = this.recomputeRemaining();
            this.characteristics = this.computeCharacteristics();
            return new SpliteratorConcatenator(this.a, n2, n4);
        }

        @Override
        public long skip(long l) {
            long l2 = 0L;
            if (this.length <= 0) {
                return 0L;
            }
            while (l2 < l && this.length >= 0) {
                long l3;
                if ((l2 += (l3 = this.a[this.offset].skip(l - l2))) >= l) continue;
                this.advanceNextSpliterator();
            }
            return l2;
        }
    }

    private static class SpliteratorFromIterator
    implements LongSpliterator {
        private static final int BATCH_INCREMENT_SIZE = 1024;
        private static final int BATCH_MAX_SIZE = 0x2000000;
        private final LongIterator iter;
        final int characteristics;
        private final boolean knownSize;
        private long size = Long.MAX_VALUE;
        private int nextBatchSize = 1024;
        private LongSpliterator delegate = null;

        SpliteratorFromIterator(LongIterator longIterator, int n) {
            this.iter = longIterator;
            this.characteristics = 0x100 | n;
            this.knownSize = false;
        }

        SpliteratorFromIterator(LongIterator longIterator, long l, int n) {
            this.iter = longIterator;
            this.knownSize = true;
            this.size = l;
            this.characteristics = (n & 0x1000) != 0 ? 0x100 | n : 0x4140 | n;
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            if (this.delegate != null) {
                boolean bl = this.delegate.tryAdvance(longConsumer);
                if (!bl) {
                    this.delegate = null;
                }
                return bl;
            }
            if (!this.iter.hasNext()) {
                return false;
            }
            --this.size;
            longConsumer.accept(this.iter.nextLong());
            return true;
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            if (this.delegate != null) {
                this.delegate.forEachRemaining(longConsumer);
                this.delegate = null;
            }
            this.iter.forEachRemaining(longConsumer);
            this.size = 0L;
        }

        @Override
        public long estimateSize() {
            if (this.delegate != null) {
                return this.delegate.estimateSize();
            }
            if (!this.iter.hasNext()) {
                return 0L;
            }
            return this.knownSize && this.size >= 0L ? this.size : Long.MAX_VALUE;
        }

        @Override
        public int characteristics() {
            return this.characteristics;
        }

        protected LongSpliterator makeForSplit(long[] lArray, int n) {
            return LongSpliterators.wrap(lArray, 0, n, this.characteristics);
        }

        @Override
        public LongSpliterator trySplit() {
            if (!this.iter.hasNext()) {
                return null;
            }
            int n = this.knownSize && this.size > 0L ? (int)Math.min((long)this.nextBatchSize, this.size) : this.nextBatchSize;
            long[] lArray = new long[n];
            int n2 = 0;
            while (n2 < n && this.iter.hasNext()) {
                lArray[n2++] = this.iter.nextLong();
                --this.size;
            }
            if (n < this.nextBatchSize && this.iter.hasNext()) {
                lArray = Arrays.copyOf(lArray, this.nextBatchSize);
                while (this.iter.hasNext() && n2 < this.nextBatchSize) {
                    lArray[n2++] = this.iter.nextLong();
                    --this.size;
                }
            }
            this.nextBatchSize = Math.min(0x2000000, this.nextBatchSize + 1024);
            LongSpliterator longSpliterator = this.makeForSplit(lArray, n2);
            if (!this.iter.hasNext()) {
                this.delegate = longSpliterator;
                return longSpliterator.trySplit();
            }
            return longSpliterator;
        }

        @Override
        public long skip(long l) {
            long l2;
            int n;
            if (l < 0L) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + l);
            }
            if (this.iter instanceof LongBigListIterator) {
                long l3 = ((LongBigListIterator)this.iter).skip(l);
                this.size -= l3;
                return l3;
            }
            for (l2 = 0L; l2 < l && this.iter.hasNext(); l2 += (long)n) {
                n = this.iter.skip(SafeMath.safeLongToInt(Math.min(l, Integer.MAX_VALUE)));
                this.size -= (long)n;
            }
            return l2;
        }
    }

    private static class SpliteratorFromIteratorWithComparator
    extends SpliteratorFromIterator {
        private final LongComparator comparator;

        SpliteratorFromIteratorWithComparator(LongIterator longIterator, int n, LongComparator longComparator) {
            super(longIterator, n | 0x14);
            this.comparator = longComparator;
        }

        SpliteratorFromIteratorWithComparator(LongIterator longIterator, long l, int n, LongComparator longComparator) {
            super(longIterator, l, n | 0x14);
            this.comparator = longComparator;
        }

        @Override
        public LongComparator getComparator() {
            return this.comparator;
        }

        @Override
        protected LongSpliterator makeForSplit(long[] lArray, int n) {
            return LongSpliterators.wrapPreSorted(lArray, 0, n, this.characteristics, this.comparator);
        }
    }

    private static final class IteratorFromSpliterator
    implements LongIterator,
    LongConsumer {
        private final LongSpliterator spliterator;
        private long holder = 0L;
        private boolean hasPeeked = false;

        IteratorFromSpliterator(LongSpliterator longSpliterator) {
            this.spliterator = longSpliterator;
        }

        @Override
        public void accept(long l) {
            this.holder = l;
        }

        @Override
        public boolean hasNext() {
            if (this.hasPeeked) {
                return true;
            }
            boolean bl = this.spliterator.tryAdvance(this);
            if (!bl) {
                return false;
            }
            this.hasPeeked = true;
            return true;
        }

        @Override
        public long nextLong() {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                return this.holder;
            }
            boolean bl = this.spliterator.tryAdvance(this);
            if (!bl) {
                throw new NoSuchElementException();
            }
            return this.holder;
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                longConsumer.accept(this.holder);
            }
            this.spliterator.forEachRemaining(longConsumer);
        }

        @Override
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int n2 = 0;
            if (this.hasPeeked) {
                this.hasPeeked = false;
                this.spliterator.skip(1L);
                ++n2;
                --n;
            }
            if (n > 0) {
                n2 += SafeMath.safeLongToInt(this.spliterator.skip(n));
            }
            return n2;
        }
    }

    private static final class IntSpliteratorWrapper
    implements LongSpliterator {
        final IntSpliterator spliterator;

        public IntSpliteratorWrapper(IntSpliterator intSpliterator) {
            this.spliterator = intSpliterator;
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            return this.spliterator.tryAdvance(longConsumer::accept);
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            this.spliterator.forEachRemaining(longConsumer::accept);
        }

        @Override
        public long estimateSize() {
            return this.spliterator.estimateSize();
        }

        @Override
        public int characteristics() {
            return this.spliterator.characteristics();
        }

        @Override
        public long skip(long l) {
            return this.spliterator.skip(l);
        }

        @Override
        public LongSpliterator trySplit() {
            IntSpliterator intSpliterator = this.spliterator.trySplit();
            if (intSpliterator == null) {
                return null;
            }
            return new IntSpliteratorWrapper(intSpliterator);
        }
    }

    public static class EmptySpliterator
    implements LongSpliterator,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = 8379247926738230492L;
        private static final int CHARACTERISTICS = 16448;

        protected EmptySpliterator() {
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            return false;
        }

        @Override
        @Deprecated
        public boolean tryAdvance(Consumer<? super Long> consumer) {
            return false;
        }

        @Override
        public LongSpliterator trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0L;
        }

        @Override
        public int characteristics() {
            return 16448;
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
        }

        @Override
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> consumer) {
        }

        public Object clone() {
            return EMPTY_SPLITERATOR;
        }

        private Object readResolve() {
            return EMPTY_SPLITERATOR;
        }
    }

    public static abstract class LateBindingSizeIndexBasedSpliterator
    extends AbstractIndexBasedSpliterator {
        protected int maxPos = -1;
        private boolean maxPosFixed;

        protected LateBindingSizeIndexBasedSpliterator(int n) {
            super(n);
            this.maxPosFixed = false;
        }

        protected LateBindingSizeIndexBasedSpliterator(int n, int n2) {
            super(n);
            this.maxPos = n2;
            this.maxPosFixed = true;
        }

        protected abstract int getMaxPosFromBackingStore();

        @Override
        protected final int getMaxPos() {
            return this.maxPosFixed ? this.maxPos : this.getMaxPosFromBackingStore();
        }

        @Override
        public LongSpliterator trySplit() {
            LongSpliterator longSpliterator = super.trySplit();
            if (!this.maxPosFixed && longSpliterator != null) {
                this.maxPos = this.getMaxPosFromBackingStore();
                this.maxPosFixed = true;
            }
            return longSpliterator;
        }
    }

    public static abstract class EarlyBindingSizeIndexBasedSpliterator
    extends AbstractIndexBasedSpliterator {
        protected final int maxPos;

        protected EarlyBindingSizeIndexBasedSpliterator(int n, int n2) {
            super(n);
            this.maxPos = n2;
        }

        @Override
        protected final int getMaxPos() {
            return this.maxPos;
        }
    }

    public static abstract class AbstractIndexBasedSpliterator
    extends AbstractLongSpliterator {
        protected int pos;

        protected AbstractIndexBasedSpliterator(int n) {
            this.pos = n;
        }

        protected abstract long get(int var1);

        protected abstract int getMaxPos();

        protected abstract LongSpliterator makeForSplit(int var1, int var2);

        protected int computeSplitPoint() {
            return this.pos + (this.getMaxPos() - this.pos) / 2;
        }

        private void splitPointCheck(int n, int n2) {
            if (n < this.pos || n > n2) {
                throw new IndexOutOfBoundsException("splitPoint " + n + " outside of range of current position " + this.pos + " and range end " + n2);
            }
        }

        @Override
        public int characteristics() {
            return 16720;
        }

        @Override
        public long estimateSize() {
            return (long)this.getMaxPos() - (long)this.pos;
        }

        @Override
        public boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
            if (this.pos >= this.getMaxPos()) {
                return false;
            }
            longConsumer.accept(this.get(this.pos++));
            return true;
        }

        @Override
        public void forEachRemaining(java.util.function.LongConsumer longConsumer) {
            int n = this.getMaxPos();
            while (this.pos < n) {
                longConsumer.accept(this.get(this.pos));
                ++this.pos;
            }
        }

        @Override
        public long skip(long l) {
            if (l < 0L) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + l);
            }
            int n = this.getMaxPos();
            if (this.pos >= n) {
                return 0L;
            }
            int n2 = n - this.pos;
            if (l < (long)n2) {
                this.pos = SafeMath.safeLongToInt((long)this.pos + l);
                return l;
            }
            l = n2;
            this.pos = n;
            return l;
        }

        @Override
        public LongSpliterator trySplit() {
            int n = this.getMaxPos();
            int n2 = this.computeSplitPoint();
            if (n2 == this.pos || n2 == n) {
                return null;
            }
            this.splitPointCheck(n2, n);
            int n3 = this.pos;
            LongSpliterator longSpliterator = this.makeForSplit(n3, n2);
            if (longSpliterator != null) {
                this.pos = n2;
            }
            return longSpliterator;
        }
    }

	private static final class ByteSpliteratorWrapper implements LongSpliterator {
		final com.viaversion.viaversion.libs.fastutil.bytes.ByteSpliterator spliterator;

		public ByteSpliteratorWrapper(final com.viaversion.viaversion.libs.fastutil.bytes.ByteSpliterator spliterator) {
			this.spliterator = spliterator;
		}

		@Override
		public boolean tryAdvance(final java.util.function.LongConsumer action) {
			Objects.requireNonNull(action);
			return spliterator.tryAdvance(action::accept);
		}

		@Override
		public void forEachRemaining(final java.util.function.LongConsumer action) {
			Objects.requireNonNull(action);
			spliterator.forEachRemaining(action::accept);
		}

		@Override
		public long estimateSize() {
			return spliterator.estimateSize();
		}

		@Override
		public int characteristics() {
			return spliterator.characteristics();
		}

		@Override
		public long skip(long n) {
			return spliterator.skip(n);
		}

		@Override
		public LongSpliterator trySplit() {
			com.viaversion.viaversion.libs.fastutil.bytes.ByteSpliterator possibleSplit = spliterator.trySplit();
			if (possibleSplit == null) return null;
			return new ByteSpliteratorWrapper(possibleSplit);
		}
	}

	private static final class ShortSpliteratorWrapper implements LongSpliterator {
		final com.viaversion.viaversion.libs.fastutil.shorts.ShortSpliterator spliterator;

		public ShortSpliteratorWrapper(final com.viaversion.viaversion.libs.fastutil.shorts.ShortSpliterator spliterator) {
			this.spliterator = spliterator;
		}

		@Override
		public boolean tryAdvance(final java.util.function.LongConsumer action) {
			Objects.requireNonNull(action);
			return spliterator.tryAdvance(action::accept);
		}

		@Override
		public void forEachRemaining(final java.util.function.LongConsumer action) {
			Objects.requireNonNull(action);
			spliterator.forEachRemaining(action::accept);
		}

		@Override
		public long estimateSize() {
			return spliterator.estimateSize();
		}

		@Override
		public int characteristics() {
			return spliterator.characteristics();
		}

		@Override
		public long skip(long n) {
			return spliterator.skip(n);
		}

		@Override
		public LongSpliterator trySplit() {
			com.viaversion.viaversion.libs.fastutil.shorts.ShortSpliterator possibleSplit = spliterator.trySplit();
			if (possibleSplit == null) return null;
			return new ShortSpliteratorWrapper(possibleSplit);
		}
	}

	private static final class CharSpliteratorWrapper implements LongSpliterator {
		final com.viaversion.viaversion.libs.fastutil.chars.CharSpliterator spliterator;

		public CharSpliteratorWrapper(final com.viaversion.viaversion.libs.fastutil.chars.CharSpliterator spliterator) {
			this.spliterator = spliterator;
		}

		@Override
		public boolean tryAdvance(final java.util.function.LongConsumer action) {
			Objects.requireNonNull(action);
			return spliterator.tryAdvance(action::accept);
		}

		@Override
		public void forEachRemaining(final java.util.function.LongConsumer action) {
			Objects.requireNonNull(action);
			spliterator.forEachRemaining(action::accept);
		}

		@Override
		public long estimateSize() {
			return spliterator.estimateSize();
		}

		@Override
		public int characteristics() {
			return spliterator.characteristics();
		}

		@Override
		public long skip(long n) {
			return spliterator.skip(n);
		}

		@Override
		public LongSpliterator trySplit() {
			com.viaversion.viaversion.libs.fastutil.chars.CharSpliterator possibleSplit = spliterator.trySplit();
			if (possibleSplit == null) return null;
			return new CharSpliteratorWrapper(possibleSplit);
		}
	}
}

