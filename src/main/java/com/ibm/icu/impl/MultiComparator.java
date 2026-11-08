/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import java.util.Comparator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MultiComparator<T>
implements Comparator<T> {
    private Comparator<T>[] comparators;

    public MultiComparator(Comparator<T> ... comparatorArray) {
        this.comparators = comparatorArray;
    }

    @Override
    public int compare(T t, T t2) {
        for (int i = 0; i < this.comparators.length; ++i) {
            int n = this.comparators[i].compare(t, t2);
            if (n == 0) continue;
            if (n > 0) {
                return i + 1;
            }
            return -(i + 1);
        }
        return 0;
    }
}

