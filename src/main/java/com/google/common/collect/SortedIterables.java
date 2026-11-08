/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedIterable;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
public class SortedIterables {
    private SortedIterables() {
    }

    public static boolean hasSameComparator(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator<Object> comparator2;
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = SortedIterables.comparator((SortedSet)iterable);
        } else if (iterable instanceof SortedIterable) {
            comparator2 = ((SortedIterable)iterable).comparator();
        } else {
            return false;
        }
        return comparator.equals(comparator2);
    }

    public static <E> Comparator<? super E> comparator(SortedSet<E> sortedSet) {
        Comparator<E> comparator = sortedSet.comparator();
        if (comparator == null) {
            comparator = Ordering.natural();
        }
        return comparator;
    }
}

