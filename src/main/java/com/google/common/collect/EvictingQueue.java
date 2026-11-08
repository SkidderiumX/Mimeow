/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingQueue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@Beta
@GwtIncompatible(value="java.util.ArrayDeque")
public class EvictingQueue<E>
extends ForwardingQueue<E>
implements Serializable {
    private final Queue<E> delegate;
    @VisibleForTesting
    final int maxSize;
    private static final long serialVersionUID = 0L;

    private EvictingQueue(int n) {
        Preconditions.checkArgument(n >= 0, "maxSize (%s) must >= 0", n);
        this.delegate = new ArrayDeque(n);
        this.maxSize = n;
    }

    public static <E> EvictingQueue<E> create(int n) {
        return new EvictingQueue<E>(n);
    }

    public int remainingCapacity() {
        return this.maxSize - this.size();
    }

    @Override
    protected Queue<E> delegate() {
        return this.delegate;
    }

    @Override
    public boolean offer(E e) {
        return this.add(e);
    }

    @Override
    public boolean add(E e) {
        Preconditions.checkNotNull(e);
        if (this.maxSize == 0) {
            return true;
        }
        if (this.size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return this.standardAddAll(collection);
    }

    @Override
    public boolean contains(Object object) {
        return this.delegate().contains(Preconditions.checkNotNull(object));
    }

    @Override
    public boolean remove(Object object) {
        return this.delegate().remove(Preconditions.checkNotNull(object));
    }
}

