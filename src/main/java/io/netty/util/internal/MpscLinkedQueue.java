/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.internal;

import io.netty.util.internal.MpscLinkedQueueNode;
import io.netty.util.internal.MpscLinkedQueueTailRef;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MpscLinkedQueue<E>
extends MpscLinkedQueueTailRef<E>
implements Queue<E> {
    private static final long serialVersionUID = -1878402552271506449L;
    long p00;
    long p01;
    long p02;
    long p03;
    long p04;
    long p05;
    long p06;
    long p07;
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;

    MpscLinkedQueue() {
        DefaultNode<Object> defaultNode = new DefaultNode<Object>(null);
        this.setHeadRef(defaultNode);
        this.setTailRef(defaultNode);
    }

    private MpscLinkedQueueNode<E> peekNode() {
        MpscLinkedQueueNode mpscLinkedQueueNode;
        do {
            MpscLinkedQueueNode mpscLinkedQueueNode2;
            if ((mpscLinkedQueueNode2 = (mpscLinkedQueueNode = this.headRef()).next()) == null) continue;
            return mpscLinkedQueueNode2;
        } while (mpscLinkedQueueNode != this.tailRef());
        return null;
    }

    @Override
    public boolean offer(E e) {
        DefaultNode<E> defaultNode;
        if (e == null) {
            throw new NullPointerException("value");
        }
        if (e instanceof MpscLinkedQueueNode) {
            defaultNode = (DefaultNode<E>)e;
            defaultNode.setNext(null);
        } else {
            defaultNode = new DefaultNode<E>(e);
        }
        MpscLinkedQueueNode<E> mpscLinkedQueueNode = this.getAndSetTailRef(defaultNode);
        mpscLinkedQueueNode.setNext(defaultNode);
        return true;
    }

    @Override
    public E poll() {
        MpscLinkedQueueNode<E> mpscLinkedQueueNode = this.peekNode();
        if (mpscLinkedQueueNode == null) {
            return null;
        }
        MpscLinkedQueueNode mpscLinkedQueueNode2 = this.headRef();
        this.lazySetHeadRef(mpscLinkedQueueNode);
        mpscLinkedQueueNode2.unlink();
        return mpscLinkedQueueNode.clearMaybe();
    }

    @Override
    public E peek() {
        MpscLinkedQueueNode<E> mpscLinkedQueueNode = this.peekNode();
        if (mpscLinkedQueueNode == null) {
            return null;
        }
        return mpscLinkedQueueNode.value();
    }

    @Override
    public int size() {
        int n = 0;
        for (MpscLinkedQueueNode<E> mpscLinkedQueueNode = this.peekNode(); mpscLinkedQueueNode != null; mpscLinkedQueueNode = mpscLinkedQueueNode.next()) {
            ++n;
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.peekNode() == null;
    }

    @Override
    public boolean contains(Object object) {
        for (MpscLinkedQueueNode<E> mpscLinkedQueueNode = this.peekNode(); mpscLinkedQueueNode != null; mpscLinkedQueueNode = mpscLinkedQueueNode.next()) {
            if (mpscLinkedQueueNode.value() != object) continue;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            private MpscLinkedQueueNode<E> node;
            {
                this.node = MpscLinkedQueue.this.peekNode();
            }

            @Override
            public boolean hasNext() {
                return this.node != null;
            }

            @Override
            public E next() {
                MpscLinkedQueueNode mpscLinkedQueueNode = this.node;
                if (mpscLinkedQueueNode == null) {
                    throw new NoSuchElementException();
                }
                Object e = mpscLinkedQueueNode.value();
                this.node = mpscLinkedQueueNode.next();
                return e;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public boolean add(E e) {
        if (this.offer(e)) {
            return true;
        }
        throw new IllegalStateException("queue full");
    }

    @Override
    public E remove() {
        E e = this.poll();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    @Override
    public E element() {
        E e = this.peek();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[this.size()];
        Iterator<E> iterator2 = this.iterator();
        for (int i = 0; i < objectArray.length; ++i) {
            if (!iterator2.hasNext()) {
                return Arrays.copyOf(objectArray, i);
            }
            objectArray[i] = iterator2.next();
        }
        return objectArray;
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        int n = this.size();
        Object[] objectArray = TArray.length >= n ? TArray : (Object[])Array.newInstance(TArray.getClass().getComponentType(), n);
        Iterator<E> iterator2 = this.iterator();
        for (int i = 0; i < objectArray.length; ++i) {
            if (!iterator2.hasNext()) {
                if (TArray == objectArray) {
                    objectArray[i] = null;
                    return objectArray;
                }
                if (TArray.length < i) {
                    return Arrays.copyOf(objectArray, i);
                }
                System.arraycopy(objectArray, 0, TArray, 0, i);
                if (TArray.length > i) {
                    TArray[i] = null;
                }
                return TArray;
            }
            objectArray[i] = iterator2.next();
        }
        return objectArray;
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (this.contains(obj)) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("c");
        }
        if (collection == this) {
            throw new IllegalArgumentException("c == this");
        }
        boolean bl = false;
        for (E e : collection) {
            this.add(e);
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        while (this.poll() != null) {
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (E e : this) {
            objectOutputStream.writeObject(e);
        }
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object object;
        objectInputStream.defaultReadObject();
        DefaultNode<Object> defaultNode = new DefaultNode<Object>(null);
        this.setHeadRef(defaultNode);
        this.setTailRef(defaultNode);
        while ((object = objectInputStream.readObject()) != null) {
            this.add(object);
        }
    }

    private static final class DefaultNode<T>
    extends MpscLinkedQueueNode<T> {
        private T value;

        DefaultNode(T t) {
            this.value = t;
        }

        @Override
        public T value() {
            return this.value;
        }

        @Override
        protected T clearMaybe() {
            T t = this.value;
            this.value = null;
            return t;
        }
    }
}

