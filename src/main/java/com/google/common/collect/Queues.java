/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Synchronized;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Queues {
    private Queues() {
    }

    public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int n) {
        return new ArrayBlockingQueue(n);
    }

    public static <E> ArrayDeque<E> newArrayDeque() {
        return new ArrayDeque();
    }

    public static <E> ArrayDeque<E> newArrayDeque(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque<E>(Collections2.cast(iterable));
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterables.addAll(arrayDeque, iterable);
        return arrayDeque;
    }

    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue();
    }

    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue<E>(Collections2.cast(iterable));
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        Iterables.addAll(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque() {
        return new LinkedBlockingDeque();
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int n) {
        return new LinkedBlockingDeque(n);
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque<E>(Collections2.cast(iterable));
        }
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        Iterables.addAll(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue() {
        return new LinkedBlockingQueue();
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int n) {
        return new LinkedBlockingQueue(n);
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue<E>(Collections2.cast(iterable));
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Iterables.addAll(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }

    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue() {
        return new PriorityBlockingQueue();
    }

    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue<E>(Collections2.cast(iterable));
        }
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        Iterables.addAll(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue() {
        return new PriorityQueue();
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue<E>(Collections2.cast(iterable));
        }
        PriorityQueue priorityQueue = new PriorityQueue();
        Iterables.addAll(priorityQueue, iterable);
        return priorityQueue;
    }

    public static <E> SynchronousQueue<E> newSynchronousQueue() {
        return new SynchronousQueue();
    }

    @Beta
    public static <E> int drain(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int n, long l, TimeUnit timeUnit) throws InterruptedException {
        Preconditions.checkNotNull(collection);
        long l2 = System.nanoTime() + timeUnit.toNanos(l);
        int n2 = 0;
        while (n2 < n) {
            if ((n2 += blockingQueue.drainTo(collection, n - n2)) >= n) continue;
            E e = blockingQueue.poll(l2 - System.nanoTime(), TimeUnit.NANOSECONDS);
            if (e == null) break;
            collection.add(e);
            ++n2;
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Beta
    public static <E> int drainUninterruptibly(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int n, long l, TimeUnit timeUnit) {
        Preconditions.checkNotNull(collection);
        long l2 = System.nanoTime() + timeUnit.toNanos(l);
        int n2 = 0;
        boolean bl = false;
        try {
            while (n2 < n) {
                E e;
                if ((n2 += blockingQueue.drainTo(collection, n - n2)) >= n) continue;
                while (true) {
                    try {
                        e = blockingQueue.poll(l2 - System.nanoTime(), TimeUnit.NANOSECONDS);
                    }
                    catch (InterruptedException interruptedException) {
                        bl = true;
                        continue;
                    }
                    break;
                }
                if (e == null) {
                    break;
                }
                collection.add(e);
                ++n2;
            }
        }
        finally {
            if (bl) {
                Thread.currentThread().interrupt();
            }
        }
        return n2;
    }

    @Beta
    public static <E> Queue<E> synchronizedQueue(Queue<E> queue) {
        return Synchronized.queue(queue, null);
    }

    @Beta
    public static <E> Deque<E> synchronizedDeque(Deque<E> deque) {
        return Synchronized.deque(deque, null);
    }
}

