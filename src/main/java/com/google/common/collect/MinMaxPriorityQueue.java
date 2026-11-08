/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@Beta
public class MinMaxPriorityQueue<E>
extends AbstractQueue<E> {
    private final Heap minHeap;
    private final Heap maxHeap;
    @VisibleForTesting
    final int maximumSize;
    private Object[] queue;
    private int size;
    private int modCount;
    private static final int EVEN_POWERS_OF_TWO = 0x55555555;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private static final int DEFAULT_CAPACITY = 11;

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder(comparator);
    }

    public static Builder<Comparable> expectedSize(int n) {
        return new Builder(Ordering.natural()).expectedSize(n);
    }

    public static Builder<Comparable> maximumSize(int n) {
        return new Builder(Ordering.natural()).maximumSize(n);
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int n) {
        Ordering ordering = ((Builder)builder).ordering();
        this.minHeap = new Heap(ordering);
        this.minHeap.otherHeap = this.maxHeap = new Heap(ordering.reverse());
        this.maxHeap.otherHeap = this.minHeap;
        this.maximumSize = ((Builder)builder).maximumSize;
        this.queue = new Object[n];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E e) {
        this.offer(e);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean bl = false;
        for (E e : collection) {
            this.offer(e);
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean offer(E e) {
        Preconditions.checkNotNull(e);
        ++this.modCount;
        int n = this.size++;
        this.growIfNeeded();
        this.heapForIndex(n).bubbleUp(n, e);
        return this.size <= this.maximumSize || this.pollLast() != e;
    }

    @Override
    public E poll() {
        return this.isEmpty() ? null : (E)this.removeAndGet(0);
    }

    E elementData(int n) {
        return (E)this.queue[n];
    }

    @Override
    public E peek() {
        return this.isEmpty() ? null : (E)this.elementData(0);
    }

    private int getMaxElementIndex() {
        switch (this.size) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
        }
        return this.maxHeap.compareElements(1, 2) <= 0 ? 1 : 2;
    }

    public E pollFirst() {
        return this.poll();
    }

    public E removeFirst() {
        return this.remove();
    }

    public E peekFirst() {
        return this.peek();
    }

    public E pollLast() {
        return this.isEmpty() ? null : (E)this.removeAndGet(this.getMaxElementIndex());
    }

    public E removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.removeAndGet(this.getMaxElementIndex());
    }

    public E peekLast() {
        return this.isEmpty() ? null : (E)this.elementData(this.getMaxElementIndex());
    }

    @VisibleForTesting
    MoveDesc<E> removeAt(int n) {
        Preconditions.checkPositionIndex(n, this.size);
        ++this.modCount;
        --this.size;
        if (this.size == n) {
            this.queue[this.size] = null;
            return null;
        }
        E e = this.elementData(this.size);
        int n2 = this.heapForIndex(this.size).getCorrectLastElement(e);
        E e2 = this.elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> moveDesc = this.fillHole(n, e2);
        if (n2 < n) {
            if (moveDesc == null) {
                return new MoveDesc<E>(e, e2);
            }
            return new MoveDesc<E>(e, moveDesc.replaced);
        }
        return moveDesc;
    }

    private MoveDesc<E> fillHole(int n, E e) {
        int n2;
        Heap heap = this.heapForIndex(n);
        int n3 = heap.bubbleUpAlternatingLevels(n2 = heap.fillHoleAt(n), e);
        if (n3 == n2) {
            return heap.tryCrossOverAndBubbleUp(n, n2, e);
        }
        return n3 < n ? new MoveDesc<E>(e, this.elementData(n)) : null;
    }

    private E removeAndGet(int n) {
        E e = this.elementData(n);
        this.removeAt(n);
        return e;
    }

    private Heap heapForIndex(int n) {
        return MinMaxPriorityQueue.isEvenLevel(n) ? this.minHeap : this.maxHeap;
    }

    @VisibleForTesting
    static boolean isEvenLevel(int n) {
        int n2 = n + 1;
        Preconditions.checkState(n2 > 0, "negative index");
        return (n2 & 0x55555555) > (n2 & 0xAAAAAAAA);
    }

    @VisibleForTesting
    boolean isIntact() {
        for (int i = 1; i < this.size; ++i) {
            if (this.heapForIndex(i).verifyIndex(i)) continue;
            return false;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; ++i) {
            this.queue[i] = null;
        }
        this.size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[this.size];
        System.arraycopy(this.queue, 0, objectArray, 0, this.size);
        return objectArray;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    @VisibleForTesting
    int capacity() {
        return this.queue.length;
    }

    @VisibleForTesting
    static int initialQueueSize(int n, int n2, Iterable<?> iterable) {
        int n3;
        int n4 = n3 = n == -1 ? 11 : n;
        if (iterable instanceof Collection) {
            int n5 = ((Collection)iterable).size();
            n3 = Math.max(n3, n5);
        }
        return MinMaxPriorityQueue.capAtMaximumSize(n3, n2);
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            int n = this.calculateNewCapacity();
            Object[] objectArray = new Object[n];
            System.arraycopy(this.queue, 0, objectArray, 0, this.queue.length);
            this.queue = objectArray;
        }
    }

    private int calculateNewCapacity() {
        int n = this.queue.length;
        int n2 = n < 64 ? (n + 1) * 2 : IntMath.checkedMultiply(n / 2, 3);
        return MinMaxPriorityQueue.capAtMaximumSize(n2, this.maximumSize);
    }

    private static int capAtMaximumSize(int n, int n2) {
        return Math.min(n - 1, n2) + 1;
    }

    private class QueueIterator
    implements Iterator<E> {
        private int cursor = -1;
        private int expectedModCount = MinMaxPriorityQueue.access$700(MinMaxPriorityQueue.this);
        private Queue<E> forgetMeNot;
        private List<E> skipMe;
        private E lastFromForgetMeNot;
        private boolean canRemove;

        private QueueIterator() {
        }

        @Override
        public boolean hasNext() {
            this.checkModCount();
            return this.nextNotInSkipMe(this.cursor + 1) < MinMaxPriorityQueue.this.size() || this.forgetMeNot != null && !this.forgetMeNot.isEmpty();
        }

        @Override
        public E next() {
            this.checkModCount();
            int n = this.nextNotInSkipMe(this.cursor + 1);
            if (n < MinMaxPriorityQueue.this.size()) {
                this.cursor = n;
                this.canRemove = true;
                return MinMaxPriorityQueue.this.elementData(this.cursor);
            }
            if (this.forgetMeNot != null) {
                this.cursor = MinMaxPriorityQueue.this.size();
                this.lastFromForgetMeNot = this.forgetMeNot.poll();
                if (this.lastFromForgetMeNot != null) {
                    this.canRemove = true;
                    return this.lastFromForgetMeNot;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            this.checkModCount();
            this.canRemove = false;
            ++this.expectedModCount;
            if (this.cursor < MinMaxPriorityQueue.this.size()) {
                MoveDesc moveDesc = MinMaxPriorityQueue.this.removeAt(this.cursor);
                if (moveDesc != null) {
                    if (this.forgetMeNot == null) {
                        this.forgetMeNot = new ArrayDeque();
                        this.skipMe = new ArrayList(3);
                    }
                    this.forgetMeNot.add(moveDesc.toTrickle);
                    this.skipMe.add(moveDesc.replaced);
                }
                --this.cursor;
            } else {
                Preconditions.checkState(this.removeExact(this.lastFromForgetMeNot));
                this.lastFromForgetMeNot = null;
            }
        }

        private boolean containsExact(Iterable<E> iterable, E e) {
            for (Object e2 : iterable) {
                if (e2 != e) continue;
                return true;
            }
            return false;
        }

        boolean removeExact(Object object) {
            for (int i = 0; i < MinMaxPriorityQueue.this.size; ++i) {
                if (MinMaxPriorityQueue.this.queue[i] != object) continue;
                MinMaxPriorityQueue.this.removeAt(i);
                return true;
            }
            return false;
        }

        void checkModCount() {
            if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private int nextNotInSkipMe(int n) {
            if (this.skipMe != null) {
                while (n < MinMaxPriorityQueue.this.size() && this.containsExact(this.skipMe, MinMaxPriorityQueue.this.elementData(n))) {
                    ++n;
                }
            }
            return n;
        }
    }

    private class Heap {
        final Ordering<E> ordering;
        Heap otherHeap;

        Heap(Ordering<E> ordering) {
            this.ordering = ordering;
        }

        int compareElements(int n, int n2) {
            return this.ordering.compare(MinMaxPriorityQueue.this.elementData(n), MinMaxPriorityQueue.this.elementData(n2));
        }

        MoveDesc<E> tryCrossOverAndBubbleUp(int n, int n2, E e) {
            int n3 = this.crossOver(n2, e);
            if (n3 == n2) {
                return null;
            }
            Object e2 = n3 < n ? MinMaxPriorityQueue.this.elementData(n) : MinMaxPriorityQueue.this.elementData(this.getParentIndex(n));
            if (this.otherHeap.bubbleUpAlternatingLevels(n3, e) < n) {
                return new MoveDesc(e, e2);
            }
            return null;
        }

        void bubbleUp(int n, E e) {
            Heap heap;
            int n2 = this.crossOverUp(n, e);
            if (n2 == n) {
                heap = this;
            } else {
                n = n2;
                heap = this.otherHeap;
            }
            heap.bubbleUpAlternatingLevels(n, e);
        }

        int bubbleUpAlternatingLevels(int n, E e) {
            int n2;
            Object e2;
            while (n > 2 && this.ordering.compare(e2 = MinMaxPriorityQueue.this.elementData(n2 = this.getGrandparentIndex(n)), e) > 0) {
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n] = e2;
                n = n2;
            }
            ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n] = e;
            return n;
        }

        int findMin(int n, int n2) {
            if (n >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(n > 0);
            int n3 = Math.min(n, MinMaxPriorityQueue.this.size - n2) + n2;
            int n4 = n;
            for (int i = n + 1; i < n3; ++i) {
                if (this.compareElements(i, n4) >= 0) continue;
                n4 = i;
            }
            return n4;
        }

        int findMinChild(int n) {
            return this.findMin(this.getLeftChildIndex(n), 2);
        }

        int findMinGrandChild(int n) {
            int n2 = this.getLeftChildIndex(n);
            if (n2 < 0) {
                return -1;
            }
            return this.findMin(this.getLeftChildIndex(n2), 4);
        }

        int crossOverUp(int n, E e) {
            Object e2;
            int n2;
            int n3;
            if (n == 0) {
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[0] = e;
                return 0;
            }
            int n4 = this.getParentIndex(n);
            Object e3 = MinMaxPriorityQueue.this.elementData(n4);
            if (n4 != 0 && (n3 = this.getRightChildIndex(n2 = this.getParentIndex(n4))) != n4 && this.getLeftChildIndex(n3) >= MinMaxPriorityQueue.this.size && this.ordering.compare(e2 = MinMaxPriorityQueue.this.elementData(n3), e3) < 0) {
                n4 = n3;
                e3 = e2;
            }
            if (this.ordering.compare(e3, e) < 0) {
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n] = e3;
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n4] = e;
                return n4;
            }
            ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n] = e;
            return n;
        }

        int getCorrectLastElement(E e) {
            Object e2;
            int n;
            int n2;
            int n3 = this.getParentIndex(MinMaxPriorityQueue.this.size);
            if (n3 != 0 && (n2 = this.getRightChildIndex(n = this.getParentIndex(n3))) != n3 && this.getLeftChildIndex(n2) >= MinMaxPriorityQueue.this.size && this.ordering.compare(e2 = MinMaxPriorityQueue.this.elementData(n2), e) < 0) {
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n2] = e;
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[((MinMaxPriorityQueue)MinMaxPriorityQueue.this).size] = e2;
                return n2;
            }
            return MinMaxPriorityQueue.this.size;
        }

        int crossOver(int n, E e) {
            int n2 = this.findMinChild(n);
            if (n2 > 0 && this.ordering.compare(MinMaxPriorityQueue.this.elementData(n2), e) < 0) {
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n] = MinMaxPriorityQueue.this.elementData(n2);
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n2] = e;
                return n2;
            }
            return this.crossOverUp(n, e);
        }

        int fillHoleAt(int n) {
            int n2;
            while ((n2 = this.findMinGrandChild(n)) > 0) {
                ((MinMaxPriorityQueue)MinMaxPriorityQueue.this).queue[n] = MinMaxPriorityQueue.this.elementData(n2);
                n = n2;
            }
            return n;
        }

        private boolean verifyIndex(int n) {
            if (this.getLeftChildIndex(n) < MinMaxPriorityQueue.this.size && this.compareElements(n, this.getLeftChildIndex(n)) > 0) {
                return false;
            }
            if (this.getRightChildIndex(n) < MinMaxPriorityQueue.this.size && this.compareElements(n, this.getRightChildIndex(n)) > 0) {
                return false;
            }
            if (n > 0 && this.compareElements(n, this.getParentIndex(n)) > 0) {
                return false;
            }
            return n <= 2 || this.compareElements(this.getGrandparentIndex(n), n) <= 0;
        }

        private int getLeftChildIndex(int n) {
            return n * 2 + 1;
        }

        private int getRightChildIndex(int n) {
            return n * 2 + 2;
        }

        private int getParentIndex(int n) {
            return (n - 1) / 2;
        }

        private int getGrandparentIndex(int n) {
            return this.getParentIndex(this.getParentIndex(n));
        }
    }

    public static class MoveDesc<E> {
        final E toTrickle;
        final E replaced;

        MoveDesc(E e, E e2) {
            this.toTrickle = e;
            this.replaced = e2;
        }
    }

    @Beta
    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize = -1;
        private int maximumSize = Integer.MAX_VALUE;

        private Builder(Comparator<B> comparator) {
            this.comparator = Preconditions.checkNotNull(comparator);
        }

        public Builder<B> expectedSize(int n) {
            Preconditions.checkArgument(n >= 0);
            this.expectedSize = n;
            return this;
        }

        public Builder<B> maximumSize(int n) {
            Preconditions.checkArgument(n > 0);
            this.maximumSize = n;
            return this;
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return this.create(Collections.emptySet());
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<T>(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable));
            for (T t : iterable) {
                minMaxPriorityQueue.offer(t);
            }
            return minMaxPriorityQueue;
        }

        private <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }
    }
}

