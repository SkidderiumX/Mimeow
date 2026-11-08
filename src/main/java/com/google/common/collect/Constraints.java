/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ForwardingList;
import com.google.common.collect.ForwardingListIterator;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
public class Constraints {
    private Constraints() {
    }

    public static <E> Collection<E> constrainedCollection(Collection<E> collection, Constraint<? super E> constraint) {
        return new ConstrainedCollection<E>(collection, constraint);
    }

    public static <E> Set<E> constrainedSet(Set<E> set, Constraint<? super E> constraint) {
        return new ConstrainedSet<E>(set, constraint);
    }

    public static <E> SortedSet<E> constrainedSortedSet(SortedSet<E> sortedSet, Constraint<? super E> constraint) {
        return new ConstrainedSortedSet<E>(sortedSet, constraint);
    }

    public static <E> List<E> constrainedList(List<E> list, Constraint<? super E> constraint) {
        return list instanceof RandomAccess ? new ConstrainedRandomAccessList<E>(list, constraint) : new ConstrainedList<E>(list, constraint);
    }

    private static <E> ListIterator<E> constrainedListIterator(ListIterator<E> listIterator2, Constraint<? super E> constraint) {
        return new ConstrainedListIterator<E>(listIterator2, constraint);
    }

    static <E> Collection<E> constrainedTypePreservingCollection(Collection<E> collection, Constraint<E> constraint) {
        if (collection instanceof SortedSet) {
            return Constraints.constrainedSortedSet((SortedSet)collection, constraint);
        }
        if (collection instanceof Set) {
            return Constraints.constrainedSet((Set)collection, constraint);
        }
        if (collection instanceof List) {
            return Constraints.constrainedList((List)collection, constraint);
        }
        return Constraints.constrainedCollection(collection, constraint);
    }

    private static <E> Collection<E> checkElements(Collection<E> collection, Constraint<? super E> constraint) {
        ArrayList<E> arrayList = Lists.newArrayList(collection);
        for (Object e : arrayList) {
            constraint.checkElement(e);
        }
        return arrayList;
    }

    public static class ConstrainedListIterator<E>
    extends ForwardingListIterator<E> {
        private final ListIterator<E> delegate;
        private final Constraint<? super E> constraint;

        public ConstrainedListIterator(ListIterator<E> listIterator2, Constraint<? super E> constraint) {
            this.delegate = listIterator2;
            this.constraint = constraint;
        }

        @Override
        protected ListIterator<E> delegate() {
            return this.delegate;
        }

        @Override
        public void add(E e) {
            this.constraint.checkElement(e);
            this.delegate.add(e);
        }

        @Override
        public void set(E e) {
            this.constraint.checkElement(e);
            this.delegate.set(e);
        }
    }

    public static class ConstrainedRandomAccessList<E>
    extends ConstrainedList<E>
    implements RandomAccess {
        ConstrainedRandomAccessList(List<E> list, Constraint<? super E> constraint) {
            super(list, constraint);
        }
    }

    @GwtCompatible
    private static class ConstrainedList<E>
    extends ForwardingList<E> {
        final List<E> delegate;
        final Constraint<? super E> constraint;

        ConstrainedList(List<E> list, Constraint<? super E> constraint) {
            this.delegate = Preconditions.checkNotNull(list);
            this.constraint = Preconditions.checkNotNull(constraint);
        }

        @Override
        protected List<E> delegate() {
            return this.delegate;
        }

        @Override
        public boolean add(E e) {
            this.constraint.checkElement(e);
            return this.delegate.add(e);
        }

        @Override
        public void add(int n, E e) {
            this.constraint.checkElement(e);
            this.delegate.add(n, e);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            return this.delegate.addAll(Constraints.checkElements(collection, this.constraint));
        }

        @Override
        public boolean addAll(int n, Collection<? extends E> collection) {
            return this.delegate.addAll(n, Constraints.checkElements(collection, this.constraint));
        }

        @Override
        public ListIterator<E> listIterator() {
            return Constraints.constrainedListIterator(this.delegate.listIterator(), this.constraint);
        }

        @Override
        public ListIterator<E> listIterator(int n) {
            return Constraints.constrainedListIterator(this.delegate.listIterator(n), this.constraint);
        }

        @Override
        public E set(int n, E e) {
            this.constraint.checkElement(e);
            return this.delegate.set(n, e);
        }

        @Override
        public List<E> subList(int n, int n2) {
            return Constraints.constrainedList(this.delegate.subList(n, n2), this.constraint);
        }
    }

    private static class ConstrainedSortedSet<E>
    extends ForwardingSortedSet<E> {
        final SortedSet<E> delegate;
        final Constraint<? super E> constraint;

        ConstrainedSortedSet(SortedSet<E> sortedSet, Constraint<? super E> constraint) {
            this.delegate = Preconditions.checkNotNull(sortedSet);
            this.constraint = Preconditions.checkNotNull(constraint);
        }

        @Override
        protected SortedSet<E> delegate() {
            return this.delegate;
        }

        @Override
        public SortedSet<E> headSet(E e) {
            return Constraints.constrainedSortedSet(this.delegate.headSet(e), this.constraint);
        }

        @Override
        public SortedSet<E> subSet(E e, E e2) {
            return Constraints.constrainedSortedSet(this.delegate.subSet(e, e2), this.constraint);
        }

        @Override
        public SortedSet<E> tailSet(E e) {
            return Constraints.constrainedSortedSet(this.delegate.tailSet(e), this.constraint);
        }

        @Override
        public boolean add(E e) {
            this.constraint.checkElement(e);
            return this.delegate.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            return this.delegate.addAll(Constraints.checkElements(collection, this.constraint));
        }
    }

    public static class ConstrainedSet<E>
    extends ForwardingSet<E> {
        private final Set<E> delegate;
        private final Constraint<? super E> constraint;

        public ConstrainedSet(Set<E> set, Constraint<? super E> constraint) {
            this.delegate = Preconditions.checkNotNull(set);
            this.constraint = Preconditions.checkNotNull(constraint);
        }

        @Override
        protected Set<E> delegate() {
            return this.delegate;
        }

        @Override
        public boolean add(E e) {
            this.constraint.checkElement(e);
            return this.delegate.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            return this.delegate.addAll(Constraints.checkElements(collection, this.constraint));
        }
    }

    public static class ConstrainedCollection<E>
    extends ForwardingCollection<E> {
        private final Collection<E> delegate;
        private final Constraint<? super E> constraint;

        public ConstrainedCollection(Collection<E> collection, Constraint<? super E> constraint) {
            this.delegate = Preconditions.checkNotNull(collection);
            this.constraint = Preconditions.checkNotNull(constraint);
        }

        @Override
        protected Collection<E> delegate() {
            return this.delegate;
        }

        @Override
        public boolean add(E e) {
            this.constraint.checkElement(e);
            return this.delegate.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            return this.delegate.addAll(Constraints.checkElements(collection, this.constraint));
        }
    }
}

