/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.BigArrays;
import com.viaversion.viaversion.libs.fastutil.bytes.ByteIterator;
import com.viaversion.viaversion.libs.fastutil.chars.CharIterator;
import com.viaversion.viaversion.libs.fastutil.ints.AbstractIntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrays;
import com.viaversion.viaversion.libs.fastutil.ints.IntBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntBigArrays;
import com.viaversion.viaversion.libs.fastutil.ints.IntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.IntConsumer;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterators;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;
import com.viaversion.viaversion.libs.fastutil.ints.IntListIterator;
import com.viaversion.viaversion.libs.fastutil.shorts.ShortIterator;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntPredicate;

public class IntIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private IntIterators() {
    }

    public static IntListIterator singleton(int n) {
        return new SingletonIterator(n);
    }

    public static IntListIterator wrap(int[] nArray, int n, int n2) {
        IntArrays.ensureOffsetLength(nArray, n, n2);
        return new ArrayIterator(nArray, n, n2);
    }

    public static IntListIterator wrap(int[] nArray) {
        return new ArrayIterator(nArray, 0, nArray.length);
    }

    public static int unwrap(IntIterator intIterator, int[] nArray, int n, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + n2 + ") is negative");
        }
        if (n < 0 || n + n2 > nArray.length) {
            throw new IllegalArgumentException();
        }
        int n3 = n2;
        while (n3-- != 0 && intIterator.hasNext()) {
            nArray[n++] = intIterator.nextInt();
        }
        return n2 - n3 - 1;
    }

    public static int unwrap(IntIterator intIterator, int[] nArray) {
        return IntIterators.unwrap(intIterator, nArray, 0, nArray.length);
    }

    public static int[] unwrap(IntIterator intIterator, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + n + ") is negative");
        }
        int[] nArray = new int[16];
        int n2 = 0;
        while (n-- != 0 && intIterator.hasNext()) {
            if (n2 == nArray.length) {
                nArray = IntArrays.grow(nArray, n2 + 1);
            }
            nArray[n2++] = intIterator.nextInt();
        }
        return IntArrays.trim(nArray, n2);
    }

    public static int[] unwrap(IntIterator intIterator) {
        return IntIterators.unwrap(intIterator, Integer.MAX_VALUE);
    }

    public static long unwrap(IntIterator intIterator, int[][] nArray, long l, long l2) {
        if (l2 < 0L) {
            throw new IllegalArgumentException("The maximum number of elements (" + l2 + ") is negative");
        }
        if (l < 0L || l + l2 > BigArrays.length((int[][])nArray)) {
            throw new IllegalArgumentException();
        }
        long l3 = l2;
        while (l3-- != 0L && intIterator.hasNext()) {
            BigArrays.set((int[][])nArray, (long)l++, (int)intIterator.nextInt());
        }
        return l2 - l3 - 1L;
    }

    public static long unwrap(IntIterator intIterator, int[][] nArray) {
        return IntIterators.unwrap(intIterator, nArray, 0L, BigArrays.length((int[][])nArray));
    }

    public static int unwrap(IntIterator intIterator, IntCollection intCollection, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + n + ") is negative");
        }
        int n2 = n;
        while (n2-- != 0 && intIterator.hasNext()) {
            intCollection.add(intIterator.nextInt());
        }
        return n - n2 - 1;
    }

    public static int[][] unwrapBig(IntIterator intIterator, long l) {
        if (l < 0L) {
            throw new IllegalArgumentException("The maximum number of elements (" + l + ") is negative");
        }
        int[][] nArray = IntBigArrays.newBigArray((long)16L);
        long l2 = 0L;
        while (l-- != 0L && intIterator.hasNext()) {
            if (l2 == BigArrays.length((int[][])nArray)) {
                nArray = BigArrays.grow((int[][])nArray, (long)(l2 + 1L));
            }
            BigArrays.set((int[][])nArray, (long)l2++, (int)intIterator.nextInt());
        }
        return BigArrays.trim((int[][])nArray, (long)l2);
    }

    public static int[][] unwrapBig(IntIterator intIterator) {
        return IntIterators.unwrapBig(intIterator, Long.MAX_VALUE);
    }

    public static long unwrap(IntIterator intIterator, IntCollection intCollection) {
        long l = 0L;
        while (intIterator.hasNext()) {
            intCollection.add(intIterator.nextInt());
            ++l;
        }
        return l;
    }

    public static int pour(IntIterator intIterator, IntCollection intCollection, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + n + ") is negative");
        }
        int n2 = n;
        while (n2-- != 0 && intIterator.hasNext()) {
            intCollection.add(intIterator.nextInt());
        }
        return n - n2 - 1;
    }

    public static int pour(IntIterator intIterator, IntCollection intCollection) {
        return IntIterators.pour(intIterator, intCollection, Integer.MAX_VALUE);
    }

    public static IntList pour(IntIterator intIterator, int n) {
        IntArrayList intArrayList = new IntArrayList();
        IntIterators.pour(intIterator, intArrayList, n);
        intArrayList.trim();
        return intArrayList;
    }

    public static IntList pour(IntIterator intIterator) {
        return IntIterators.pour(intIterator, Integer.MAX_VALUE);
    }

    public static IntIterator asIntIterator(Iterator iterator2) {
        if (iterator2 instanceof IntIterator) {
            return (IntIterator)iterator2;
        }
        if (iterator2 instanceof PrimitiveIterator.OfInt) {
            return new PrimitiveIteratorWrapper((PrimitiveIterator.OfInt)iterator2);
        }
        return new IteratorWrapper(iterator2);
    }

    public static IntListIterator asIntIterator(ListIterator listIterator2) {
        if (listIterator2 instanceof IntListIterator) {
            return (IntListIterator)listIterator2;
        }
        return new ListIteratorWrapper(listIterator2);
    }

    public static boolean any(IntIterator intIterator, IntPredicate intPredicate) {
        return IntIterators.indexOf(intIterator, intPredicate) != -1;
    }

    public static boolean all(IntIterator intIterator, IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        do {
            if (intIterator.hasNext()) continue;
            return true;
        } while (intPredicate.test(intIterator.nextInt()));
        return false;
    }

    public static int indexOf(IntIterator intIterator, IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        int n = 0;
        while (intIterator.hasNext()) {
            if (intPredicate.test(intIterator.nextInt())) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public static IntListIterator fromTo(int n, int n2) {
        return new IntervalIterator(n, n2);
    }

    public static IntIterator concat(IntIterator ... intIteratorArray) {
        return IntIterators.concat(intIteratorArray, 0, intIteratorArray.length);
    }

    public static IntIterator concat(IntIterator[] intIteratorArray, int n, int n2) {
        return new IteratorConcatenator(intIteratorArray, n, n2);
    }

    public static IntIterator unmodifiable(IntIterator intIterator) {
        return new UnmodifiableIterator(intIterator);
    }

    public static IntBidirectionalIterator unmodifiable(IntBidirectionalIterator intBidirectionalIterator) {
        return new UnmodifiableBidirectionalIterator(intBidirectionalIterator);
    }

    public static IntListIterator unmodifiable(IntListIterator intListIterator) {
        return new UnmodifiableListIterator(intListIterator);
    }

    public static IntIterator wrap(ByteIterator byteIterator) {
        return new ByteIteratorWrapper(byteIterator);
    }

    public static IntIterator wrap(ShortIterator shortIterator) {
        return new ShortIteratorWrapper(shortIterator);
    }

    public static IntIterator wrap(CharIterator charIterator) {
        return new CharIteratorWrapper(charIterator);
    }

    private static class SingletonIterator
    implements IntListIterator {
        private final int element;
        private byte curr;

        public SingletonIterator(int n) {
            this.element = n;
        }

        @Override
        public boolean hasNext() {
            return this.curr == 0;
        }

        @Override
        public boolean hasPrevious() {
            return this.curr == 1;
        }

        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override
        public int previousInt() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
            Objects.requireNonNull(intConsumer);
            if (this.curr == 0) {
                intConsumer.accept(this.element);
                this.curr = 1;
            }
        }

        @Override
        public int nextIndex() {
            return this.curr;
        }

        @Override
        public int previousIndex() {
            return this.curr - 1;
        }

        @Override
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            if (n == 0 || this.curr < 1) {
                return 0;
            }
            this.curr = 1;
            return 1;
        }

        @Override
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            if (n == 0 || this.curr > 0) {
                return 0;
            }
            this.curr = 0;
            return 1;
        }
    }

    private static class ArrayIterator
    implements IntListIterator {
        private final int[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(int[] nArray, int n, int n2) {
            this.array = nArray;
            this.offset = n;
            this.length = n2;
        }

        @Override
        public boolean hasNext() {
            return this.curr < this.length;
        }

        @Override
        public boolean hasPrevious() {
            return this.curr > 0;
        }

        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return this.array[this.offset + this.curr++];
        }

        @Override
        public int previousInt() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            return this.array[this.offset + --this.curr];
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
            Objects.requireNonNull(intConsumer);
            int[] nArray = this.array;
            while (this.curr < this.length) {
                intConsumer.accept(nArray[this.offset + this.curr]);
                ++this.curr;
            }
        }

        @Override
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            if (n <= this.length - this.curr) {
                this.curr += n;
                return n;
            }
            n = this.length - this.curr;
            this.curr = this.length;
            return n;
        }

        @Override
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            if (n <= this.curr) {
                this.curr -= n;
                return n;
            }
            n = this.curr;
            this.curr = 0;
            return n;
        }

        @Override
        public int nextIndex() {
            return this.curr;
        }

        @Override
        public int previousIndex() {
            return this.curr - 1;
        }
    }

    private static class PrimitiveIteratorWrapper
    implements IntIterator {
        final PrimitiveIterator.OfInt i;

        public PrimitiveIteratorWrapper(PrimitiveIterator.OfInt ofInt) {
            this.i = ofInt;
        }

        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }

        @Override
        public void remove() {
            this.i.remove();
        }

        @Override
        public int nextInt() {
            return this.i.nextInt();
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
            this.i.forEachRemaining(intConsumer);
        }
    }

    private static class IteratorWrapper
    implements IntIterator {
        final Iterator<Integer> i;

        public IteratorWrapper(Iterator<Integer> iterator2) {
            this.i = iterator2;
        }

        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }

        @Override
        public void remove() {
            this.i.remove();
        }

        @Override
        public int nextInt() {
            return this.i.next();
        }

        @Override
        public void forEachRemaining(IntConsumer intConsumer) {
            this.i.forEachRemaining(intConsumer);
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
            Objects.requireNonNull(intConsumer);
            this.i.forEachRemaining(intConsumer instanceof Consumer ? (Consumer<Integer>)((Object)intConsumer) : intConsumer::accept);
        }

        @Override
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> consumer) {
            this.i.forEachRemaining(consumer);
        }
    }

    private static class ListIteratorWrapper
    implements IntListIterator {
        final ListIterator<Integer> i;

        public ListIteratorWrapper(ListIterator<Integer> listIterator2) {
            this.i = listIterator2;
        }

        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }

        @Override
        public boolean hasPrevious() {
            return this.i.hasPrevious();
        }

        @Override
        public int nextIndex() {
            return this.i.nextIndex();
        }

        @Override
        public int previousIndex() {
            return this.i.previousIndex();
        }

        @Override
        public void set(int n) {
            this.i.set(n);
        }

        @Override
        public void add(int n) {
            this.i.add(n);
        }

        @Override
        public void remove() {
            this.i.remove();
        }

        @Override
        public int nextInt() {
            return this.i.next();
        }

        @Override
        public int previousInt() {
            return this.i.previous();
        }

        @Override
        public void forEachRemaining(IntConsumer intConsumer) {
            this.i.forEachRemaining(intConsumer);
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
            Objects.requireNonNull(intConsumer);
            this.i.forEachRemaining(intConsumer instanceof Consumer ? (Consumer<Integer>)((Object)intConsumer) : intConsumer::accept);
        }

        @Override
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> consumer) {
            this.i.forEachRemaining(consumer);
        }
    }

    private static class IntervalIterator
    implements IntListIterator {
        private final int from;
        private final int fedd0b1e9c7;
        int curr;

        public IntervalIterator(int n, int n2) {
            this.from = this.curr = n;
            this.fedd0b1e9c7 = n2;
        }

        @Override
        public boolean hasNext() {
            return this.curr < this.fedd0b1e9c7;
        }

        @Override
        public boolean hasPrevious() {
            return this.curr > this.from;
        }

        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return this.curr++;
        }

        @Override
        public int previousInt() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            return --this.curr;
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
            Objects.requireNonNull(intConsumer);
            while (this.curr < this.fedd0b1e9c7) {
                intConsumer.accept(this.curr);
                ++this.curr;
            }
        }

        @Override
        public int nextIndex() {
            return this.curr - this.from;
        }

        @Override
        public int previousIndex() {
            return this.curr - this.from - 1;
        }

        @Override
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            if (this.curr + n <= this.fedd0b1e9c7) {
                this.curr += n;
                return n;
            }
            n = this.fedd0b1e9c7 - this.curr;
            this.curr = this.fedd0b1e9c7;
            return n;
        }

        @Override
        public int back(int n) {
            if (this.curr - n >= this.from) {
                this.curr -= n;
                return n;
            }
            n = this.curr - this.from;
            this.curr = this.from;
            return n;
        }
    }

    private static class IteratorConcatenator
    implements IntIterator {
        final IntIterator[] a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(IntIterator[] intIteratorArray, int n, int n2) {
            this.a = intIteratorArray;
            this.offset = n;
            this.length = n2;
            this.advance();
        }

        private void advance() {
            while (this.length != 0 && !this.a[this.offset].hasNext()) {
                --this.length;
                ++this.offset;
            }
        }

        @Override
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.lastOffset = this.offset;
            int n = this.a[this.lastOffset].nextInt();
            this.advance();
            return n;
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
            while (this.length > 0) {
                this.lastOffset = this.offset;
                this.a[this.lastOffset].forEachRemaining(intConsumer);
                this.advance();
            }
        }

        @Override
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> consumer) {
            while (this.length > 0) {
                this.lastOffset = this.offset;
                this.a[this.lastOffset].forEachRemaining(consumer);
                this.advance();
            }
        }

        @Override
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.a[this.lastOffset].remove();
        }

        @Override
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int n2 = 0;
            while (n2 < n && this.length != 0) {
                n2 += this.a[this.offset].skip(n - n2);
                if (this.a[this.offset].hasNext()) break;
                --this.length;
                ++this.offset;
            }
            return n2;
        }
    }

    public static class EmptyIterator
    implements IntListIterator,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyIterator() {
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public int nextInt() {
            throw new NoSuchElementException();
        }

        @Override
        public int previousInt() {
            throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return -1;
        }

        @Override
        public int skip(int n) {
            return 0;
        }

        @Override
        public int back(int n) {
            return 0;
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
        }

        @Override
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> consumer) {
        }

        public Object clone() {
            return EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return EMPTY_ITERATOR;
        }
    }

    public static abstract class AbstractIndexBasedListIterator
    extends AbstractIndexBasedIterator
    implements IntListIterator {
        protected AbstractIndexBasedListIterator(int n, int n2) {
            super(n, n2);
        }

        protected abstract void add(int var1, int var2);

        protected abstract void set(int var1, int var2);

        @Override
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override
        public int previousInt() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.lastReturned = --this.pos;
            return this.get(this.pos);
        }

        @Override
        public int nextIndex() {
            return this.pos;
        }

        @Override
        public int previousIndex() {
            return this.pos - 1;
        }

        @Override
        public void add(int n) {
            this.add(this.pos++, n);
            this.lastReturned = -1;
        }

        @Override
        public void set(int n) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            this.set(this.lastReturned, n);
        }

        @Override
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int n2 = this.pos - this.minPos;
            if (n < n2) {
                this.pos -= n;
            } else {
                n = n2;
                this.pos = this.minPos;
            }
            this.lastReturned = this.pos;
            return n;
        }
    }

    public static abstract class AbstractIndexBasedIterator
    extends AbstractIntIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected AbstractIndexBasedIterator(int n, int n2) {
            this.minPos = n;
            this.pos = n2;
        }

        protected abstract int get(int var1);

        protected abstract void remove(int var1);

        protected abstract int getMaxPos();

        @Override
        public boolean hasNext() {
            return this.pos < this.getMaxPos();
        }

        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.pos++;
            return this.get(this.lastReturned);
        }

        @Override
        public void remove() {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            this.remove(this.lastReturned);
            if (this.lastReturned < this.pos) {
                --this.pos;
            }
            this.lastReturned = -1;
        }

        @Override
        public void forEachRemaining(java.util.function.IntConsumer intConsumer) {
            while (this.pos < this.getMaxPos()) {
                ++this.pos;
                this.lastReturned = this.lastReturned;
                intConsumer.accept(this.get(this.lastReturned));
            }
        }

        @Override
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int n2 = this.getMaxPos();
            int n3 = n2 - this.pos;
            if (n < n3) {
                this.pos += n;
            } else {
                n = n3;
                this.pos = n2;
            }
            this.lastReturned = this.pos - 1;
            return n;
        }
    }

	public static class UnmodifiableIterator implements IntIterator {
		protected final IntIterator i;

		public UnmodifiableIterator(final IntIterator i) {
			this.i = i;
		}

		@Override
		public boolean hasNext() {
			return i.hasNext();
		}

		@Override
		public int nextInt() {
			return i.nextInt();
		}

		@Override
		public void forEachRemaining(final java.util.function.IntConsumer action) {
			i.forEachRemaining(action);
		}

		@Deprecated
		@Override
		public void forEachRemaining(final Consumer<? super Integer> action) {
			i.forEachRemaining(action);
		}
	}

	public static class UnmodifiableBidirectionalIterator implements IntBidirectionalIterator {
		protected final IntBidirectionalIterator i;

		public UnmodifiableBidirectionalIterator(final IntBidirectionalIterator i) {
			this.i = i;
		}

		@Override
		public boolean hasNext() {
			return i.hasNext();
		}

		@Override
		public boolean hasPrevious() {
			return i.hasPrevious();
		}

		@Override
		public int nextInt() {
			return i.nextInt();
		}

		@Override
		public int previousInt() {
			return i.previousInt();
		}

		@Override
		public void forEachRemaining(final java.util.function.IntConsumer action) {
			i.forEachRemaining(action);
		}

		@Deprecated
		@Override
		public void forEachRemaining(final Consumer<? super Integer> action) {
			i.forEachRemaining(action);
		}
	}

	public static class UnmodifiableListIterator implements IntListIterator {
		protected final IntListIterator i;

		public UnmodifiableListIterator(final IntListIterator i) {
			this.i = i;
		}

		@Override
		public boolean hasNext() {
			return i.hasNext();
		}

		@Override
		public boolean hasPrevious() {
			return i.hasPrevious();
		}

		@Override
		public int nextInt() {
			return i.nextInt();
		}

		@Override
		public int previousInt() {
			return i.previousInt();
		}

		@Override
		public int nextIndex() {
			return i.nextIndex();
		}

		@Override
		public int previousIndex() {
			return i.previousIndex();
		}

		@Override
		public void forEachRemaining(final java.util.function.IntConsumer action) {
			i.forEachRemaining(action);
		}

		@Deprecated
		@Override
		public void forEachRemaining(final Consumer<? super Integer> action) {
			i.forEachRemaining(action);
		}
	}

	private final static class ByteIteratorWrapper implements IntIterator {
		final com.viaversion.viaversion.libs.fastutil.bytes.ByteIterator iterator;

		public ByteIteratorWrapper(final com.viaversion.viaversion.libs.fastutil.bytes.ByteIterator iterator) {
			this.iterator = iterator;
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Deprecated
		@Override
		public Integer next() {
			return Integer.valueOf(iterator.nextByte());
		}

		@Override
		public int nextInt() {
			return iterator.nextByte();
		}

		@Override
		public void forEachRemaining(final java.util.function.IntConsumer action) {
			Objects.requireNonNull(action);
			iterator.forEachRemaining(action::accept);
		}

		@Override
		public void remove() {
			iterator.remove();
		}

		@Override
		public int skip(final int n) {
			return iterator.skip(n);
		}
	}

	private final static class ShortIteratorWrapper implements IntIterator {
		final com.viaversion.viaversion.libs.fastutil.shorts.ShortIterator iterator;

		public ShortIteratorWrapper(final com.viaversion.viaversion.libs.fastutil.shorts.ShortIterator iterator) {
			this.iterator = iterator;
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Deprecated
		@Override
		public Integer next() {
			return Integer.valueOf(iterator.nextShort());
		}

		@Override
		public int nextInt() {
			return iterator.nextShort();
		}

		@Override
		public void forEachRemaining(final java.util.function.IntConsumer action) {
			Objects.requireNonNull(action);
			iterator.forEachRemaining(action::accept);
		}

		@Override
		public void remove() {
			iterator.remove();
		}

		@Override
		public int skip(final int n) {
			return iterator.skip(n);
		}
	}

	private final static class CharIteratorWrapper implements IntIterator {
		final com.viaversion.viaversion.libs.fastutil.chars.CharIterator iterator;

		public CharIteratorWrapper(final com.viaversion.viaversion.libs.fastutil.chars.CharIterator iterator) {
			this.iterator = iterator;
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Deprecated
		@Override
		public Integer next() {
			return Integer.valueOf(iterator.nextChar());
		}

		@Override
		public int nextInt() {
			return iterator.nextChar();
		}

		@Override
		public void forEachRemaining(final java.util.function.IntConsumer action) {
			Objects.requireNonNull(action);
			iterator.forEachRemaining(action::accept);
		}

		@Override
		public void remove() {
			iterator.remove();
		}

		@Override
		public int skip(final int n) {
			return iterator.skip(n);
		}
	}
}

