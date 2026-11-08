/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable=true)
public class ReverseNaturalOrdering
extends Ordering<Comparable>
implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0L;

    @Override
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    @Override
    public <E extends Comparable> E min(E e, E e2) {
        return NaturalOrdering.INSTANCE.max(e, e2);
    }

    @Override
    public <E extends Comparable> E min(E e, E e2, E e3, E ... EArray) {
        return NaturalOrdering.INSTANCE.max(e, e2, e3, EArray);
    }

    @Override
    public <E extends Comparable> E min(Iterator<E> iterator2) {
        return (E)((Comparable)NaturalOrdering.INSTANCE.max(iterator2));
    }

    @Override
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (E)((Comparable)NaturalOrdering.INSTANCE.max(iterable));
    }

    @Override
    public <E extends Comparable> E max(E e, E e2) {
        return NaturalOrdering.INSTANCE.min(e, e2);
    }

    @Override
    public <E extends Comparable> E max(E e, E e2, E e3, E ... EArray) {
        return NaturalOrdering.INSTANCE.min(e, e2, e3, EArray);
    }

    @Override
    public <E extends Comparable> E max(Iterator<E> iterator2) {
        return (E)((Comparable)NaturalOrdering.INSTANCE.min(iterator2));
    }

    @Override
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E)((Comparable)NaturalOrdering.INSTANCE.min(iterable));
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private ReverseNaturalOrdering() {
    }
}

