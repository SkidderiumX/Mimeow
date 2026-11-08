/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class ExplicitOrdering<T>
extends Ordering<T>
implements Serializable {
    final ImmutableMap<T, Integer> rankMap;
    private static final long serialVersionUID = 0L;

    ExplicitOrdering(List<T> list) {
        this(ExplicitOrdering.buildRankMap(list));
    }

    ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }

    @Override
    public int compare(T t, T t2) {
        return this.rank(t) - this.rank(t2);
    }

    private int rank(T t) {
        Integer n = this.rankMap.get(t);
        if (n == null) {
            throw new Ordering.IncomparableValueException(t);
        }
        return n;
    }

    private static <T> ImmutableMap<T, Integer> buildRankMap(List<T> list) {
        ImmutableMap.Builder<T, Integer> builder = ImmutableMap.builder();
        int n = 0;
        for (T t : list) {
            builder.put(t, n++);
        }
        return builder.build();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object instanceof ExplicitOrdering) {
            ExplicitOrdering explicitOrdering = (ExplicitOrdering)object;
            return this.rankMap.equals(explicitOrdering.rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}

