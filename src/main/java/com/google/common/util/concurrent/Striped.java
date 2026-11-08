/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Beta
public abstract class Striped<L> {
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>(){

        @Override
        public ReadWriteLock get() {
            return new ReentrantReadWriteLock();
        }
    };
    private static final int ALL_SET = -1;

    private Striped() {
    }

    public abstract L get(Object var1);

    public abstract L getAt(int var1);

    abstract int indexFor(Object var1);

    public abstract int size();

    public Iterable<L> bulkGet(Iterable<?> iterable) {
        int n;
        Object[] objectArray = Iterables.toArray(iterable, Object.class);
        if (objectArray.length == 0) {
            return ImmutableList.of();
        }
        int[] nArray = new int[objectArray.length];
        for (n = 0; n < objectArray.length; ++n) {
            nArray[n] = this.indexFor(objectArray[n]);
        }
        Arrays.sort(nArray);
        n = nArray[0];
        objectArray[0] = this.getAt(n);
        for (int i = 1; i < objectArray.length; ++i) {
            int n2 = nArray[i];
            if (n2 == n) {
                objectArray[i] = objectArray[i - 1];
                continue;
            }
            objectArray[i] = this.getAt(n2);
            n = n2;
        }
        List<Object> list = Arrays.asList(objectArray);
        return Collections.unmodifiableList(list);
    }

    public static Striped<Lock> lock(int n) {
        return new CompactStriped<Lock>(n, new Supplier<Lock>(){

            @Override
            public Lock get() {
                return new PaddedLock();
            }
        });
    }

    public static Striped<Lock> lazyWeakLock(int n) {
        return Striped.lazy(n, new Supplier<Lock>(){

            @Override
            public Lock get() {
                return new ReentrantLock(false);
            }
        });
    }

    private static <L> Striped<L> lazy(int n, Supplier<L> supplier) {
        return n < 1024 ? new SmallLazyStriped<L>(n, supplier) : new LargeLazyStriped<L>(n, supplier);
    }

    public static Striped<Semaphore> semaphore(int n, final int n2) {
        return new CompactStriped<Semaphore>(n, new Supplier<Semaphore>(){

            @Override
            public Semaphore get() {
                return new PaddedSemaphore(n2);
            }
        });
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int n, final int n2) {
        return Striped.lazy(n, new Supplier<Semaphore>(){

            @Override
            public Semaphore get() {
                return new Semaphore(n2, false);
            }
        });
    }

    public static Striped<ReadWriteLock> readWriteLock(int n) {
        return new CompactStriped<ReadWriteLock>(n, READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int n) {
        return Striped.lazy(n, READ_WRITE_LOCK_SUPPLIER);
    }

    private static int ceilToPowerOfTwo(int n) {
        return 1 << IntMath.log2(n, RoundingMode.CEILING);
    }

    private static int smear(int n) {
        n ^= n >>> 20 ^ n >>> 12;
        return n ^ n >>> 7 ^ n >>> 4;
    }

    private static class PaddedSemaphore
    extends Semaphore {
        long q1;
        long q2;
        long q3;

        PaddedSemaphore(int n) {
            super(n, false);
        }
    }

    private static class PaddedLock
    extends ReentrantLock {
        long q1;
        long q2;
        long q3;

        PaddedLock() {
            super(false);
        }
    }

    @VisibleForTesting
    public static class LargeLazyStriped<L>
    extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final Supplier<L> supplier;
        final int size;

        LargeLazyStriped(int n, Supplier<L> supplier) {
            super(n);
            this.size = this.mask == -1 ? Integer.MAX_VALUE : this.mask + 1;
            this.supplier = supplier;
            this.locks = new MapMaker().weakValues().makeMap();
        }

        @Override
        public L getAt(int n) {
            Object object;
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(n, this.size());
            }
            if ((object = this.locks.get(n)) != null) {
                return (L)object;
            }
            L l = this.supplier.get();
            object = this.locks.putIfAbsent(n, l);
            return (L)Objects.firstNonNull(object, l);
        }

        @Override
        public int size() {
            return this.size;
        }
    }

    @VisibleForTesting
    public static class SmallLazyStriped<L>
    extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final Supplier<L> supplier;
        final int size;
        final ReferenceQueue<L> queue = new ReferenceQueue();

        SmallLazyStriped(int n, Supplier<L> supplier) {
            super(n);
            this.size = this.mask == -1 ? Integer.MAX_VALUE : this.mask + 1;
            this.locks = new AtomicReferenceArray(this.size);
            this.supplier = supplier;
        }

        @Override
        public L getAt(int n) {
            ArrayReference<? extends L> arrayReference;
            L l;
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(n, this.size());
            }
            L l2 = l = (arrayReference = this.locks.get(n)) == null ? null : (L)arrayReference.get();
            if (l != null) {
                return l;
            }
            L l3 = this.supplier.get();
            ArrayReference<L> arrayReference2 = new ArrayReference<L>(l3, n, this.queue);
            while (!this.locks.compareAndSet(n, arrayReference, arrayReference2)) {
                arrayReference = this.locks.get(n);
                l = arrayReference == null ? null : (L)arrayReference.get();
                if (l == null) continue;
                return l;
            }
            this.drainQueue();
            return l3;
        }

        private void drainQueue() {
            Reference<L> reference;
            while ((reference = this.queue.poll()) != null) {
                ArrayReference arrayReference = (ArrayReference)reference;
                this.locks.compareAndSet(arrayReference.index, arrayReference, null);
            }
        }

        @Override
        public int size() {
            return this.size;
        }

        private static final class ArrayReference<L>
        extends WeakReference<L> {
            final int index;

            ArrayReference(L l, int n, ReferenceQueue<L> referenceQueue) {
                super(l, referenceQueue);
                this.index = n;
            }
        }
    }

    private static class CompactStriped<L>
    extends PowerOfTwoStriped<L> {
        private final Object[] array;

        private CompactStriped(int n, Supplier<L> supplier) {
            super(n);
            Preconditions.checkArgument(n <= 0x40000000, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
            for (int i = 0; i < this.array.length; ++i) {
                this.array[i] = supplier.get();
            }
        }

        @Override
        public L getAt(int n) {
            return (L)this.array[n];
        }

        @Override
        public int size() {
            return this.array.length;
        }
    }

    private static abstract class PowerOfTwoStriped<L>
    extends Striped<L> {
        final int mask;

        PowerOfTwoStriped(int n) {
            Preconditions.checkArgument(n > 0, "Stripes must be positive");
            this.mask = n > 0x40000000 ? -1 : Striped.ceilToPowerOfTwo(n) - 1;
        }

        @Override
        final int indexFor(Object object) {
            int n = Striped.smear(object.hashCode());
            return n & this.mask;
        }

        @Override
        public final L get(Object object) {
            return this.getAt(this.indexFor(object));
        }
    }
}

