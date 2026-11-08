/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;
import java.util.Iterator;

@Beta
@GwtCompatible(emulated=true)
public abstract class BinaryTreeTraverser<T>
extends TreeTraverser<T> {
    public abstract Optional<T> leftChild(T var1);

    public abstract Optional<T> rightChild(T var1);

    @Override
    public final Iterable<T> children(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>(){

            @Override
            public Iterator<T> iterator() {
                return new AbstractIterator<T>(){
                    boolean doneLeft;
                    boolean doneRight;

                    @Override
                    protected T computeNext() {
                        Optional<Object> optional;
                        if (!this.doneLeft) {
                            this.doneLeft = true;
                            optional = BinaryTreeTraverser.this.leftChild(t);
                            if (optional.isPresent()) {
                                return optional.get();
                            }
                        }
                        if (!this.doneRight) {
                            this.doneRight = true;
                            optional = BinaryTreeTraverser.this.rightChild(t);
                            if (optional.isPresent()) {
                                return optional.get();
                            }
                        }
                        return this.endOfData();
                    }
                };
            }
        };
    }

    @Override
    UnmodifiableIterator<T> preOrderIterator(T t) {
        return new PreOrderIterator(t);
    }

    @Override
    UnmodifiableIterator<T> postOrderIterator(T t) {
        return new PostOrderIterator(t);
    }

    public final FluentIterable<T> inOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>(){

            @Override
            public UnmodifiableIterator<T> iterator() {
                return new InOrderIterator(t);
            }
        };
    }

    private static <T> void pushIfPresent(Deque<T> deque, Optional<T> optional) {
        if (optional.isPresent()) {
            deque.addLast(optional.get());
        }
    }

    private final class InOrderIterator
    extends AbstractIterator<T> {
        private final Deque<T> stack = new ArrayDeque();
        private final BitSet hasExpandedLeft = new BitSet();

        InOrderIterator(T t) {
            this.stack.addLast(t);
        }

        @Override
        protected T computeNext() {
            while (!this.stack.isEmpty()) {
                Object t = this.stack.getLast();
                if (this.hasExpandedLeft.get(this.stack.size() - 1)) {
                    this.stack.removeLast();
                    this.hasExpandedLeft.clear(this.stack.size());
                    BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(t));
                    return t;
                }
                this.hasExpandedLeft.set(this.stack.size() - 1);
                BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(t));
            }
            return this.endOfData();
        }
    }

    private final class PostOrderIterator
    extends UnmodifiableIterator<T> {
        private final Deque<T> stack = new ArrayDeque();
        private final BitSet hasExpanded;

        PostOrderIterator(T t) {
            this.stack.addLast(t);
            this.hasExpanded = new BitSet();
        }

        @Override
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override
        public T next() {
            while (true) {
                Object t = this.stack.getLast();
                boolean bl = this.hasExpanded.get(this.stack.size() - 1);
                if (bl) {
                    this.stack.removeLast();
                    this.hasExpanded.clear(this.stack.size());
                    return t;
                }
                this.hasExpanded.set(this.stack.size() - 1);
                BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(t));
                BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(t));
            }
        }
    }

    private final class PreOrderIterator
    extends UnmodifiableIterator<T>
    implements PeekingIterator<T> {
        private final Deque<T> stack = new ArrayDeque();

        PreOrderIterator(T t) {
            this.stack.addLast(t);
        }

        @Override
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override
        public T next() {
            Object t = this.stack.removeLast();
            BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(t));
            BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(t));
            return t;
        }

        @Override
        public T peek() {
            return this.stack.getLast();
        }
    }
}

