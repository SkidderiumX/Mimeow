/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class PairwiseEquivalence<T>
extends Equivalence<Iterable<T>>
implements Serializable {
    final Equivalence<? super T> elementEquivalence;
    private static final long serialVersionUID = 1L;

    PairwiseEquivalence(Equivalence<? super T> equivalence) {
        this.elementEquivalence = Preconditions.checkNotNull(equivalence);
    }

    @Override
    protected boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> iterator2 = iterable.iterator();
        Iterator<T> iterator3 = iterable2.iterator();
        while (iterator2.hasNext() && iterator3.hasNext()) {
            if (this.elementEquivalence.equivalent(iterator2.next(), iterator3.next())) continue;
            return false;
        }
        return !iterator2.hasNext() && !iterator3.hasNext();
    }

    @Override
    protected int doHash(Iterable<T> iterable) {
        int n = 78721;
        for (T t : iterable) {
            n = n * 24943 + this.elementEquivalence.hash(t);
        }
        return n;
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof PairwiseEquivalence) {
            PairwiseEquivalence pairwiseEquivalence = (PairwiseEquivalence)object;
            return this.elementEquivalence.equals(pairwiseEquivalence.elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 0x46A3EB07;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }
}

