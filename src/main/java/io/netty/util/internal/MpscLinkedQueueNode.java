/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.internal;

import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class MpscLinkedQueueNode<T> {
    private static final AtomicReferenceFieldUpdater<MpscLinkedQueueNode, MpscLinkedQueueNode> nextUpdater;
    private volatile MpscLinkedQueueNode<T> next;

    final MpscLinkedQueueNode<T> next() {
        return this.next;
    }

    final void setNext(MpscLinkedQueueNode<T> mpscLinkedQueueNode) {
        nextUpdater.lazySet(this, mpscLinkedQueueNode);
    }

    public abstract T value();

    protected T clearMaybe() {
        return this.value();
    }

    void unlink() {
        this.setNext(null);
    }

    static {
        AtomicReferenceFieldUpdater<MpscLinkedQueueNode, Object> atomicReferenceFieldUpdater = PlatformDependent.newAtomicReferenceFieldUpdater(MpscLinkedQueueNode.class, "next");
        if (atomicReferenceFieldUpdater == null) {
            atomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MpscLinkedQueueNode.class, MpscLinkedQueueNode.class, "next");
        }
        nextUpdater = atomicReferenceFieldUpdater;
    }
}

