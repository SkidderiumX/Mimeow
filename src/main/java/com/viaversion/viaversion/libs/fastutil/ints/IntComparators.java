/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.ints.IntComparator;
import java.io.Serializable;
import java.util.Comparator;

public class IntComparators {
    public static final IntComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final IntComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private IntComparators() {
    }

    public static IntComparator oppositeComparator(IntComparator intComparator) {
        if (intComparator instanceof OppositeComparator) {
            return ((OppositeComparator)intComparator).comparator;
        }
        return new OppositeComparator(intComparator);
    }

    public static IntComparator asIntComparator(final Comparator<? super Integer> comparator) {
        if (comparator == null || comparator instanceof IntComparator) {
            return (IntComparator)comparator;
        }
        return new IntComparator(){

            @Override
            public int compare(int n, int n2) {
                return comparator.compare(n, n2);
            }

            @Override
            public int compare(Integer n, Integer n2) {
                return comparator.compare(n, n2);
            }
        };
    }

    protected static class OppositeComparator
    implements IntComparator,
    Serializable {
        private static final long serialVersionUID = 1L;
        final IntComparator comparator;

        protected OppositeComparator(IntComparator intComparator) {
            this.comparator = intComparator;
        }

        @Override
        public final int compare(int n, int n2) {
            return this.comparator.compare(n2, n);
        }

        @Override
        public final IntComparator reversed() {
            return this.comparator;
        }
    }

    protected static class NaturalImplicitComparator
    implements IntComparator,
    Serializable {
        private static final long serialVersionUID = 1L;

        protected NaturalImplicitComparator() {
        }

        @Override
        public final int compare(int n, int n2) {
            return Integer.compare(n, n2);
        }

        @Override
        public IntComparator reversed() {
            return OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return NATURAL_COMPARATOR;
        }
    }

    protected static class OppositeImplicitComparator
    implements IntComparator,
    Serializable {
        private static final long serialVersionUID = 1L;

        protected OppositeImplicitComparator() {
        }

        @Override
        public final int compare(int n, int n2) {
            return -Integer.compare(n, n2);
        }

        @Override
        public IntComparator reversed() {
            return NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return OPPOSITE_COMPARATOR;
        }
    }
}

