/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongList;
import com.viaversion.viaversion.libs.fastutil.longs.LongListIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongStack;
import com.viaversion.viaversion.libs.fastutil.longs.LongUnaryOperator;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.LongConsumer;

public abstract class AbstractLongList
extends AbstractLongCollection
implements LongList,
LongStack {
    protected AbstractLongList() {
    }

    protected void ensureIndex(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is negative");
        }
        if (n > this.size()) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than list size (" + this.size() + ")");
        }
    }

    protected void ensureRestrictedIndex(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is negative");
        }
        if (n >= this.size()) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than or equal to list size (" + this.size() + ")");
        }
    }

    @Override
    public void add(int n, long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(long l) {
        this.add(this.size(), l);
        return true;
    }

    @Override
    public long removeLong(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long set(int n, long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int n, Collection<? extends Long> collection) {
        if (collection instanceof LongCollection) {
            return this.addAll(n, (LongCollection)collection);
        }
        this.ensureIndex(n);
        Iterator<? extends Long> iterator2 = collection.iterator();
        boolean bl = iterator2.hasNext();
        while (iterator2.hasNext()) {
            this.add(n++, (long)iterator2.next());
        }
        return bl;
    }

    @Override
    public boolean addAll(Collection<? extends Long> collection) {
        return this.addAll(this.size(), collection);
    }

    @Override
    public LongListIterator iterator() {
        return this.listIterator();
    }

    @Override
    public LongListIterator listIterator() {
        return this.listIterator(0);
    }

    @Override
    public LongListIterator listIterator(int n) {
        this.ensureIndex(n);
        return new LongIterators.AbstractIndexBasedListIterator(0, n){

            @Override
            protected final long get(int n) {
                return AbstractLongList.this.getLong(n);
            }

            @Override
            protected final void add(int n, long l) {
                AbstractLongList.this.add(n, l);
            }

            @Override
            protected final void set(int n, long l) {
                AbstractLongList.this.set(n, l);
            }

            @Override
            protected final void remove(int n) {
                AbstractLongList.this.removeLong(n);
            }

            @Override
            protected final int getMaxPos() {
                return AbstractLongList.this.size();
            }
        };
    }

    @Override
    public boolean contains(long l) {
        return this.indexOf(l) >= 0;
    }

    @Override
    public int indexOf(long l) {
        LongListIterator longListIterator = this.listIterator();
        while (longListIterator.hasNext()) {
            long l2 = longListIterator.nextLong();
            if (l != l2) continue;
            return longListIterator.previousIndex();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(long l) {
        LongListIterator longListIterator = this.listIterator(this.size());
        while (longListIterator.hasPrevious()) {
            long l2 = longListIterator.previousLong();
            if (l != l2) continue;
            return longListIterator.nextIndex();
        }
        return -1;
    }

    @Override
    public void size(int n) {
        int n2 = this.size();
        if (n > n2) {
            while (n2++ < n) {
                this.add(0L);
            }
        } else {
            while (n2-- != n) {
                this.removeLong(n2);
            }
        }
    }

    @Override
    public LongList subList(int n, int n2) {
        this.ensureIndex(n);
        this.ensureIndex(n2);
        if (n > n2) {
            throw new IndexOutOfBoundsException("Start index (" + n + ") is greater than end index (" + n2 + ")");
        }
        return this instanceof RandomAccess ? new LongRandomAccessSubList(this, n, n2) : new LongSubList(this, n, n2);
    }

    @Override
    public void forEach(LongConsumer longConsumer) {
        if (this instanceof RandomAccess) {
            int n = this.size();
            for (int i = 0; i < n; ++i) {
                longConsumer.accept(this.getLong(i));
            }
        } else {
            LongList.super.forEach(longConsumer);
        }
    }

    @Override
    public void removeElements(int n, int n2) {
        this.ensureIndex(n2);
        LongListIterator longListIterator = this.listIterator(n);
        int n3 = n2 - n;
        if (n3 < 0) {
            throw new IllegalArgumentException("Start index (" + n + ") is greater than end index (" + n2 + ")");
        }
        while (n3-- != 0) {
            longListIterator.nextLong();
            longListIterator.remove();
        }
    }

    @Override
    public void addElements(int n, long[] lArray, int n2, int n3) {
        this.ensureIndex(n);
        LongArrays.ensureOffsetLength(lArray, n2, n3);
        if (this instanceof RandomAccess) {
            while (n3-- != 0) {
                this.add(n++, lArray[n2++]);
            }
        } else {
            LongListIterator longListIterator = this.listIterator(n);
            while (n3-- != 0) {
                longListIterator.add(lArray[n2++]);
            }
        }
    }

    @Override
    public void addElements(int n, long[] lArray) {
        this.addElements(n, lArray, 0, lArray.length);
    }

    @Override
    public void getElements(int n, long[] lArray, int n2, int n3) {
        this.ensureIndex(n);
        LongArrays.ensureOffsetLength(lArray, n2, n3);
        if (n + n3 > this.size()) {
            throw new IndexOutOfBoundsException("End index (" + (n + n3) + ") is greater than list size (" + this.size() + ")");
        }
        if (this instanceof RandomAccess) {
            int n4 = n;
            while (n3-- != 0) {
                lArray[n2++] = this.getLong(n4++);
            }
        } else {
            LongListIterator longListIterator = this.listIterator(n);
            while (n3-- != 0) {
                lArray[n2++] = longListIterator.nextLong();
            }
        }
    }

    @Override
    public void setElements(int n, long[] lArray, int n2, int n3) {
        this.ensureIndex(n);
        LongArrays.ensureOffsetLength(lArray, n2, n3);
        if (n + n3 > this.size()) {
            throw new IndexOutOfBoundsException("End index (" + (n + n3) + ") is greater than list size (" + this.size() + ")");
        }
        if (this instanceof RandomAccess) {
            for (int i = 0; i < n3; ++i) {
                this.set(i + n, lArray[i + n2]);
            }
        } else {
            LongListIterator longListIterator = this.listIterator(n);
            int n4 = 0;
            while (n4 < n3) {
                longListIterator.nextLong();
                longListIterator.set(lArray[n2 + n4++]);
            }
        }
    }

    @Override
    public void clear() {
        this.removeElements(0, this.size());
    }

    @Override
    public int hashCode() {
        LongListIterator longListIterator = this.iterator();
        int n = 1;
        int n2 = this.size();
        while (n2-- != 0) {
            long l = longListIterator.nextLong();
            n = 31 * n + HashCommon.long2int(l);
        }
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        List list = (List)object;
        int n = this.size();
        if (n != list.size()) {
            return false;
        }
        if (list instanceof LongList) {
            LongListIterator longListIterator = this.listIterator();
            LongListIterator longListIterator2 = ((LongList)list).listIterator();
            while (n-- != 0) {
                if (longListIterator.nextLong() == longListIterator2.nextLong()) continue;
                return false;
            }
            return true;
        }
        LongListIterator longListIterator = this.listIterator();
        ListIterator listIterator2 = list.listIterator();
        while (n-- != 0) {
            if (Objects.equals(longListIterator.next(), listIterator2.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(List<? extends Long> list) {
        if (list == this) {
            return 0;
        }
        if (list instanceof LongList) {
            LongListIterator longListIterator = this.listIterator();
            LongListIterator longListIterator2 = ((LongList)list).listIterator();
            while (longListIterator.hasNext() && longListIterator2.hasNext()) {
                long l;
                long l2 = longListIterator.nextLong();
                int n = Long.compare(l2, l = longListIterator2.nextLong());
                if (n == 0) continue;
                return n;
            }
            return longListIterator2.hasNext() ? -1 : (longListIterator.hasNext() ? 1 : 0);
        }
        LongListIterator longListIterator = this.listIterator();
        ListIterator<? extends Long> listIterator2 = list.listIterator();
        while (longListIterator.hasNext() && listIterator2.hasNext()) {
            int n = ((Comparable)longListIterator.next()).compareTo(listIterator2.next());
            if (n == 0) continue;
            return n;
        }
        return listIterator2.hasNext() ? -1 : (longListIterator.hasNext() ? 1 : 0);
    }

    @Override
    public void push(long l) {
        this.add(l);
    }

    @Override
    public long popLong() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.removeLong(this.size() - 1);
    }

    @Override
    public long topLong() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.getLong(this.size() - 1);
    }

    @Override
    public long peekLong(int n) {
        return this.getLong(this.size() - 1 - n);
    }

    @Override
    public boolean rem(long l) {
        int n = this.indexOf(l);
        if (n == -1) {
            return false;
        }
        this.removeLong(n);
        return true;
    }

    @Override
    public long[] toLongArray() {
        int n = this.size();
        if (n == 0) {
            return LongArrays.EMPTY_ARRAY;
        }
        long[] lArray = new long[n];
        this.getElements(0, lArray, 0, n);
        return lArray;
    }

    @Override
    public long[] toArray(long[] lArray) {
        int n = this.size();
        if (lArray.length < n) {
            lArray = Arrays.copyOf(lArray, n);
        }
        this.getElements(0, lArray, 0, n);
        return lArray;
    }

    @Override
    public boolean addAll(int n, LongCollection longCollection) {
        this.ensureIndex(n);
        LongIterator longIterator = longCollection.iterator();
        boolean bl = longIterator.hasNext();
        while (longIterator.hasNext()) {
            this.add(n++, longIterator.nextLong());
        }
        return bl;
    }

    @Override
    public boolean addAll(LongCollection longCollection) {
        return this.addAll(this.size(), longCollection);
    }

    @Override
    public final void replaceAll(LongUnaryOperator longUnaryOperator) {
        this.replaceAll((java.util.function.LongUnaryOperator)longUnaryOperator);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        LongListIterator longListIterator = this.iterator();
        int n = this.size();
        boolean bl = true;
        stringBuilder.append("[");
        while (n-- != 0) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            long l = longListIterator.nextLong();
            stringBuilder.append(String.valueOf(l));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class LongRandomAccessSubList
    extends LongSubList
    implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public LongRandomAccessSubList(LongList longList, int n, int n2) {
            super(longList, n, n2);
        }

        @Override
        public LongList subList(int n, int n2) {
            this.ensureIndex(n);
            this.ensureIndex(n2);
            if (n > n2) {
                throw new IllegalArgumentException("Start index (" + n + ") is greater than end index (" + n2 + ")");
            }
            return new LongRandomAccessSubList(this, n, n2);
        }
    }

    public static class LongSubList
    extends AbstractLongList
    implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongList l;
        protected final int from;
        protected int to;

        public LongSubList(LongList longList, int n, int n2) {
            this.l = longList;
            this.from = n;
            this.to = n2;
        }

        private boolean assertRange() {
            assert (this.from <= this.l.size());
            assert (this.to <= this.l.size());
            assert (this.to >= this.from);
            return true;
        }

        @Override
        public boolean add(long l) {
            this.l.add(this.to, l);
            ++this.to;
            assert (this.assertRange());
            return true;
        }

        @Override
        public void add(int n, long l) {
            this.ensureIndex(n);
            this.l.add(this.from + n, l);
            ++this.to;
            assert (this.assertRange());
        }

        @Override
        public boolean addAll(int n, Collection<? extends Long> collection) {
            this.ensureIndex(n);
            this.to += collection.size();
            return this.l.addAll(this.from + n, collection);
        }

        @Override
        public long getLong(int n) {
            this.ensureRestrictedIndex(n);
            return this.l.getLong(this.from + n);
        }

        @Override
        public long removeLong(int n) {
            this.ensureRestrictedIndex(n);
            --this.to;
            return this.l.removeLong(this.from + n);
        }

        @Override
        public long set(int n, long l) {
            this.ensureRestrictedIndex(n);
            return this.l.set(this.from + n, l);
        }

        @Override
        public int size() {
            return this.to - this.from;
        }

        @Override
        public void getElements(int n, long[] lArray, int n2, int n3) {
            this.ensureIndex(n);
            if (n + n3 > this.size()) {
                throw new IndexOutOfBoundsException("End index (" + n + n3 + ") is greater than list size (" + this.size() + ")");
            }
            this.l.getElements(this.from + n, lArray, n2, n3);
        }

        @Override
        public void removeElements(int n, int n2) {
            this.ensureIndex(n);
            this.ensureIndex(n2);
            this.l.removeElements(this.from + n, this.from + n2);
            this.to -= n2 - n;
            assert (this.assertRange());
        }

        @Override
        public void addElements(int n, long[] lArray, int n2, int n3) {
            this.ensureIndex(n);
            this.l.addElements(this.from + n, lArray, n2, n3);
            this.to += n3;
            assert (this.assertRange());
        }

        @Override
        public void setElements(int n, long[] lArray, int n2, int n3) {
            this.ensureIndex(n);
            this.l.setElements(this.from + n, lArray, n2, n3);
            assert (this.assertRange());
        }

        @Override
        public LongListIterator listIterator(int n) {
            this.ensureIndex(n);
            return this.l instanceof RandomAccess ? new RandomAccessIter(n) : new ParentWrappingIter(this.l.listIterator(n + this.from));
        }

        @Override
        public LongSpliterator spliterator() {
            return this.l instanceof RandomAccess ? new IndexBasedSpliterator(this.l, this.from, this.to) : super.spliterator();
        }

        @Override
        public LongList subList(int n, int n2) {
            this.ensureIndex(n);
            this.ensureIndex(n2);
            if (n > n2) {
                throw new IllegalArgumentException("Start index (" + n + ") is greater than end index (" + n2 + ")");
            }
            return new LongSubList(this, n, n2);
        }

        @Override
        public boolean rem(long l) {
            int n = this.indexOf(l);
            if (n == -1) {
                return false;
            }
            --this.to;
            this.l.removeLong(this.from + n);
            assert (this.assertRange());
            return true;
        }

        @Override
        public boolean addAll(int n, LongCollection longCollection) {
            this.ensureIndex(n);
            return super.addAll(n, longCollection);
        }

        @Override
        public boolean addAll(int n, LongList longList) {
            this.ensureIndex(n);
            return super.addAll(n, longList);
        }

        private final class RandomAccessIter
        extends LongIterators.AbstractIndexBasedListIterator {
            RandomAccessIter(int n) {
                super(0, n);
            }

            @Override
            protected final long get(int n) {
                return LongSubList.this.l.getLong(LongSubList.this.from + n);
            }

            @Override
            protected final void add(int n, long l) {
                LongSubList.this.add(n, l);
            }

            @Override
            protected final void set(int n, long l) {
                LongSubList.this.set(n, l);
            }

            @Override
            protected final void remove(int n) {
                LongSubList.this.removeLong(n);
            }

            @Override
            protected final int getMaxPos() {
                return LongSubList.this.to - LongSubList.this.from;
            }

            @Override
            public void add(long l) {
                super.add(l);
                assert (LongSubList.this.assertRange());
            }

            @Override
            public void remove() {
                super.remove();
                assert (LongSubList.this.assertRange());
            }
        }

        private class ParentWrappingIter
        implements LongListIterator {
            private LongListIterator parent;

            ParentWrappingIter(LongListIterator longListIterator) {
                this.parent = longListIterator;
            }

            @Override
            public int nextIndex() {
                return this.parent.nextIndex() - LongSubList.this.from;
            }

            @Override
            public int previousIndex() {
                return this.parent.previousIndex() - LongSubList.this.from;
            }

            @Override
            public boolean hasNext() {
                return this.parent.nextIndex() < LongSubList.this.to;
            }

            @Override
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= LongSubList.this.from;
            }

            @Override
            public long nextLong() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return this.parent.nextLong();
            }

            @Override
            public long previousLong() {
                if (!this.hasPrevious()) {
                    throw new NoSuchElementException();
                }
                return this.parent.previousLong();
            }

            @Override
            public void add(long l) {
                this.parent.add(l);
            }

            @Override
            public void set(long l) {
                this.parent.set(l);
            }

            @Override
            public void remove() {
                this.parent.remove();
            }

            @Override
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int n2 = this.parent.previousIndex();
                int n3 = n2 - n;
                if (n3 < LongSubList.this.from - 1) {
                    n3 = LongSubList.this.from - 1;
                }
                int n4 = n3 - n2;
                return this.parent.back(n4);
            }

            @Override
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int n2 = this.parent.nextIndex();
                int n3 = n2 + n;
                if (n3 > LongSubList.this.to) {
                    n3 = LongSubList.this.to;
                }
                int n4 = n3 - n2;
                return this.parent.skip(n4);
            }
        }
    }

    public static final class IndexBasedSpliterator
    extends LongSpliterators.LateBindingSizeIndexBasedSpliterator {
        final LongList l;

        IndexBasedSpliterator(LongList longList, int n) {
            super(n);
            this.l = longList;
        }

        IndexBasedSpliterator(LongList longList, int n, int n2) {
            super(n, n2);
            this.l = longList;
        }

        @Override
        protected final int getMaxPosFromBackingStore() {
            return this.l.size();
        }

        @Override
        protected final long get(int n) {
            return this.l.getLong(n);
        }

        @Override
        protected final IndexBasedSpliterator makeForSplit(int n, int n2) {
            return new IndexBasedSpliterator(this.l, n, n2);
        }
    }
}

