/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentMap;

@Beta
public class Interners {
    private Interners() {
    }

    public static <E> Interner<E> newStrongInterner() {
        final ConcurrentMap concurrentMap = new MapMaker().makeMap();
        return new Interner<E>(){

            @Override
            public E intern(E e) {
                Object e2 = concurrentMap.putIfAbsent(Preconditions.checkNotNull(e), e);
                return e2 == null ? e : e2;
            }
        };
    }

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    public static <E> Interner<E> newWeakInterner() {
        return new WeakInterner();
    }

    public static <E> Function<E, E> asFunction(Interner<E> interner) {
        return new InternerFunction<E>(Preconditions.checkNotNull(interner));
    }

    private static class InternerFunction<E>
    implements Function<E, E> {
        private final Interner<E> interner;

        public InternerFunction(Interner<E> interner) {
            this.interner = interner;
        }

        @Override
        public E apply(E e) {
            return this.interner.intern(e);
        }

        public int hashCode() {
            return this.interner.hashCode();
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof InternerFunction) {
                InternerFunction internerFunction = (InternerFunction)object;
                return this.interner.equals(internerFunction.interner);
            }
            return false;
        }
    }

    private static class WeakInterner<E>
    implements Interner<E> {
        private final MapMakerInternalMap<E, Dummy> map = ((MapMaker)new MapMaker().weakKeys().keyEquivalence((Equivalence)Equivalence.equals())).makeCustomMap();

        private WeakInterner() {
        }

        @Override
        public E intern(E e) {
            Object object;
            do {
                MapMakerInternalMap.ReferenceEntry<E, Dummy> referenceEntry;
                if ((referenceEntry = this.map.getEntry(e)) == null || (object = referenceEntry.getKey()) == null) continue;
                return object;
            } while ((object = this.map.putIfAbsent(e, Dummy.VALUE)) != null);
            return e;
        }

        private static enum Dummy {
            VALUE;

        }
    }
}

