/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongComparator;
import java.io.Serializable;
import java.util.Comparator;

public class LongComparators {
    public static final LongComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final LongComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private LongComparators() {
    }

    public static LongComparator oppositeComparator(LongComparator longComparator) {
        if (longComparator instanceof OppositeComparator) {
            return ((OppositeComparator)longComparator).comparator;
        }
        return new OppositeComparator(longComparator);
    }

    public static LongComparator asLongComparator(final Comparator<? super Long> comparator) {
        if (comparator == null || comparator instanceof LongComparator) {
            return (LongComparator)comparator;
        }
        return new LongComparator(){

            @Override
            public int compare(long l, long l2) {
                return comparator.compare(l, l2);
            }

            @Override
            public int compare(Long l, Long l2) {
                return comparator.compare(l, l2);
            }
        };
    }

    protected static class OppositeComparator
    implements LongComparator,
    Serializable {
        private static final long serialVersionUID = 1L;
        final LongComparator comparator;

        protected OppositeComparator(LongComparator longComparator) {
            this.comparator = longComparator;
        }

        @Override
        public final int compare(long l, long l2) {
            return this.comparator.compare(l2, l);
        }

        @Override
        public final LongComparator reversed() {
            return this.comparator;
        }
    }

    protected static class NaturalImplicitComparator
    implements LongComparator,
    Serializable {
        private static final long serialVersionUID = 1L;

        protected NaturalImplicitComparator() {
        }

        @Override
        public final int compare(long l, long l2) {
            return Long.compare(l, l2);
        }

        @Override
        public LongComparator reversed() {
            return OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return NATURAL_COMPARATOR;
        }
    }

    protected static class OppositeImplicitComparator
    implements LongComparator,
    Serializable {
        private static final long serialVersionUID = 1L;

        protected OppositeImplicitComparator() {
        }

        @Override
        public final int compare(long l, long l2) {
            return -Long.compare(l, l2);
        }

        @Override
        public LongComparator reversed() {
            return NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return OPPOSITE_COMPARATOR;
        }
    }
}

