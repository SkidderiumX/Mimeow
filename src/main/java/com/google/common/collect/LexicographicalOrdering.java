/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class LexicographicalOrdering<T>
extends Ordering<Iterable<T>>
implements Serializable {
    final Ordering<? super T> elementOrder;
    private static final long serialVersionUID = 0L;

    LexicographicalOrdering(Ordering<? super T> ordering) {
        this.elementOrder = ordering;
    }

    @Override
    public int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> iterator2 = iterable.iterator();
        Iterator<T> iterator3 = iterable2.iterator();
        while (iterator2.hasNext()) {
            if (!iterator3.hasNext()) {
                return 1;
            }
            int n = this.elementOrder.compare(iterator2.next(), iterator3.next());
            if (n == 0) continue;
            return n;
        }
        if (iterator3.hasNext()) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof LexicographicalOrdering) {
            LexicographicalOrdering lexicographicalOrdering = (LexicographicalOrdering)object;
            return this.elementOrder.equals(lexicographicalOrdering.elementOrder);
        }
        return false;
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 0x7BB78CF5;
    }

    public String toString() {
        return this.elementOrder + ".lexicographical()";
    }
}

