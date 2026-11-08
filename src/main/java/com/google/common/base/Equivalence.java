/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.FunctionalEquivalence;
import com.google.common.base.Objects;
import com.google.common.base.PairwiseEquivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Equivalence<T> {
    protected Equivalence() {
    }

    public final boolean equivalent(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return this.doEquivalent(t, t2);
    }

    protected abstract boolean doEquivalent(T var1, T var2);

    public final int hash(@Nullable T t) {
        if (t == null) {
            return 0;
        }
        return this.doHash(t);
    }

    protected abstract int doHash(T var1);

    public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> function) {
        return new FunctionalEquivalence<F, T>(function, this);
    }

    public final <S extends T> Wrapper<S> wrap(@Nullable S s) {
        return new Wrapper(this, s);
    }

    @GwtCompatible(serializable=true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    @Beta
    public final Predicate<T> equivalentTo(@Nullable T t) {
        return new EquivalentToPredicate<T>(this, t);
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    public static final class Identity
    extends Equivalence<Object>
    implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1L;

        Identity() {
        }

        @Override
        protected boolean doEquivalent(Object object, Object object2) {
            return false;
        }

        @Override
        protected int doHash(Object object) {
            return System.identityHashCode(object);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static final class Equals
    extends Equivalence<Object>
    implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1L;

        Equals() {
        }

        @Override
        protected boolean doEquivalent(Object object, Object object2) {
            return object.equals(object2);
        }

        @Override
        public int doHash(Object object) {
            return object.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class EquivalentToPredicate<T>
    implements Predicate<T>,
    Serializable {
        private final Equivalence<T> equivalence;
        @Nullable
        private final T target;
        private static final long serialVersionUID = 0L;

        EquivalentToPredicate(Equivalence<T> equivalence, @Nullable T t) {
            this.equivalence = Preconditions.checkNotNull(equivalence);
            this.target = t;
        }

        @Override
        public boolean apply(@Nullable T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof EquivalentToPredicate) {
                EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate)object;
                return this.equivalence.equals(equivalentToPredicate.equivalence) && Objects.equal(this.target, equivalentToPredicate.target);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.equivalence, this.target);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    public static final class Wrapper<T>
    implements Serializable {
        private final Equivalence<? super T> equivalence;
        @Nullable
        private final T reference;
        private static final long serialVersionUID = 0L;

        private Wrapper(Equivalence<? super T> equivalence, @Nullable T t) {
            this.equivalence = Preconditions.checkNotNull(equivalence);
            this.reference = t;
        }

        @Nullable
        public T get() {
            return this.reference;
        }

        public boolean equals(@Nullable Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof Wrapper) {
                Wrapper wrapper = (Wrapper)object;
                if (this.equivalence.equals(wrapper.equivalence)) {
                    Equivalence<T> equivalence = this.equivalence;
                    return equivalence.equivalent(this.reference, wrapper.reference);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }
}

