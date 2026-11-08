/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtCompatible
public class Suppliers {
    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(supplier);
        return new SupplierComposition<F, T>(function, supplier);
    }

    public static <T> Supplier<T> memoize(Supplier<T> memoizingSupplier) {
        return memoizingSupplier instanceof MemoizingSupplier ? memoizingSupplier : new MemoizingSupplier(Preconditions.checkNotNull(memoizingSupplier));
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> supplier, long l, TimeUnit timeUnit) {
        return new ExpiringMemoizingSupplier<T>(supplier, l, timeUnit);
    }

    public static <T> Supplier<T> ofInstance(@Nullable T t) {
        return new SupplierOfInstance<T>(t);
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> supplier) {
        return new ThreadSafeSupplier<T>(Preconditions.checkNotNull(supplier));
    }

    @Beta
    public static <T> Function<Supplier<T>, T> supplierFunction() {
        SupplierFunctionImpl supplierFunctionImpl = SupplierFunctionImpl.INSTANCE;
        return supplierFunctionImpl;
    }

    private static enum SupplierFunctionImpl implements SupplierFunction<Object>
    {
        INSTANCE;


        @Override
        public Object apply(Supplier<Object> supplier) {
            return supplier.get();
        }

        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    private static interface SupplierFunction<T>
    extends Function<Supplier<T>, T> {
    }

    private static class ThreadSafeSupplier<T>
    implements Supplier<T>,
    Serializable {
        final Supplier<T> delegate;
        private static final long serialVersionUID = 0L;

        ThreadSafeSupplier(Supplier<T> supplier) {
            this.delegate = supplier;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public T get() {
            Supplier<T> supplier = this.delegate;
            synchronized (supplier) {
                return this.delegate.get();
            }
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    private static class SupplierOfInstance<T>
    implements Supplier<T>,
    Serializable {
        final T instance;
        private static final long serialVersionUID = 0L;

        SupplierOfInstance(@Nullable T t) {
            this.instance = t;
        }

        @Override
        public T get() {
            return this.instance;
        }

        public boolean equals(@Nullable Object object) {
            if (object instanceof SupplierOfInstance) {
                SupplierOfInstance supplierOfInstance = (SupplierOfInstance)object;
                return Objects.equal(this.instance, supplierOfInstance.instance);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    @VisibleForTesting
    public static class ExpiringMemoizingSupplier<T>
    implements Supplier<T>,
    Serializable {
        final Supplier<T> delegate;
        final long durationNanos;
        volatile transient T value;
        volatile transient long expirationNanos;
        private static final long serialVersionUID = 0L;

        ExpiringMemoizingSupplier(Supplier<T> supplier, long l, TimeUnit timeUnit) {
            this.delegate = Preconditions.checkNotNull(supplier);
            this.durationNanos = timeUnit.toNanos(l);
            Preconditions.checkArgument(l > 0L);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public T get() {
            long l = this.expirationNanos;
            long l2 = Platform.systemNanoTime();
            if (l == 0L || l2 - l >= 0L) {
                ExpiringMemoizingSupplier expiringMemoizingSupplier = this;
                synchronized (expiringMemoizingSupplier) {
                    if (l == this.expirationNanos) {
                        T t = this.delegate.get();
                        this.value = t;
                        l = l2 + this.durationNanos;
                        this.expirationNanos = l == 0L ? 1L : l;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
        }
    }

    @VisibleForTesting
    public static class MemoizingSupplier<T>
    implements Supplier<T>,
    Serializable {
        final Supplier<T> delegate;
        volatile transient boolean initialized;
        transient T value;
        private static final long serialVersionUID = 0L;

        MemoizingSupplier(Supplier<T> supplier) {
            this.delegate = supplier;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public T get() {
            if (!this.initialized) {
                MemoizingSupplier memoizingSupplier = this;
                synchronized (memoizingSupplier) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            return "Suppliers.memoize(" + this.delegate + ")";
        }
    }

    private static class SupplierComposition<F, T>
    implements Supplier<T>,
    Serializable {
        final Function<? super F, T> function;
        final Supplier<F> supplier;
        private static final long serialVersionUID = 0L;

        SupplierComposition(Function<? super F, T> function, Supplier<F> supplier) {
            this.function = function;
            this.supplier = supplier;
        }

        @Override
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public boolean equals(@Nullable Object object) {
            if (object instanceof SupplierComposition) {
                SupplierComposition supplierComposition = (SupplierComposition)object;
                return this.function.equals(supplierComposition.function) && this.supplier.equals(supplierComposition.supplier);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.function, this.supplier);
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }
    }
}

