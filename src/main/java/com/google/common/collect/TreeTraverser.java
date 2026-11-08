/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

@Beta
@GwtCompatible(emulated=true)
public abstract class TreeTraverser<T> {
    public abstract Iterable<T> children(T var1);

    public final FluentIterable<T> preOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>(){

            @Override
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.preOrderIterator(t);
            }
        };
    }

    UnmodifiableIterator<T> preOrderIterator(T t) {
        return new PreOrderIterator(t);
    }

    public final FluentIterable<T> postOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>(){

            @Override
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.postOrderIterator(t);
            }
        };
    }

    UnmodifiableIterator<T> postOrderIterator(T t) {
        return new PostOrderIterator(t);
    }

    public final FluentIterable<T> breadthFirstTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>(){

            @Override
            public UnmodifiableIterator<T> iterator() {
                return new BreadthFirstIterator(t);
            }
        };
    }

    private final class BreadthFirstIterator
    extends UnmodifiableIterator<T>
    implements PeekingIterator<T> {
        private final Queue<T> queue = new ArrayDeque();

        BreadthFirstIterator(T t) {
            this.queue.add(t);
        }

        @Override
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override
        public T peek() {
            return this.queue.element();
        }

        @Override
        public T next() {
            Object t = this.queue.remove();
            Iterables.addAll(this.queue, TreeTraverser.this.children(t));
            return t;
        }
    }

    private final class PostOrderIterator
    extends AbstractIterator<T> {
        private final ArrayDeque<PostOrderNode<T>> stack = new ArrayDeque();

        PostOrderIterator(T t) {
            this.stack.addLast(this.expand(t));
        }

        @Override
        protected T computeNext() {
            while (!this.stack.isEmpty()) {
                PostOrderNode postOrderNode = this.stack.getLast();
                if (postOrderNode.childIterator.hasNext()) {
                    Object t = postOrderNode.childIterator.next();
                    this.stack.addLast(this.expand(t));
                    continue;
                }
                this.stack.removeLast();
                return postOrderNode.root;
            }
            return this.endOfData();
        }

        private PostOrderNode<T> expand(T t) {
            return new PostOrderNode(t, TreeTraverser.this.children(t).iterator());
        }
    }

    private static final class PostOrderNode<T> {
        final T root;
        final Iterator<T> childIterator;

        PostOrderNode(T t, Iterator<T> iterator2) {
            this.root = Preconditions.checkNotNull(t);
            this.childIterator = Preconditions.checkNotNull(iterator2);
        }
    }

    private final class PreOrderIterator
    extends UnmodifiableIterator<T> {
        private final Deque<Iterator<T>> stack = new ArrayDeque();

        PreOrderIterator(T t) {
            this.stack.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(t)));
        }

        @Override
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override
        public T next() {
            Iterator iterator2;
            Iterator iterator3 = this.stack.getLast();
            Object t = Preconditions.checkNotNull(iterator3.next());
            if (!iterator3.hasNext()) {
                this.stack.removeLast();
            }
            if ((iterator2 = TreeTraverser.this.children(t).iterator()).hasNext()) {
                this.stack.addLast(iterator2);
            }
            return t;
        }
    }
}

