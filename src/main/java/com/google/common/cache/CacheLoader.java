/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@GwtCompatible(emulated=true)
public abstract class CacheLoader<K, V> {
    protected CacheLoader() {
    }

    public abstract V load(K var1) throws Exception;

    @GwtIncompatible(value="Futures")
    public ListenableFuture<V> reload(K k, V v) throws Exception {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        return Futures.immediateFuture(this.load(k));
    }

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @Beta
    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new FunctionToCacheLoader<K, V>(function);
    }

    @Beta
    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new SupplierToCacheLoader<V>(supplier);
    }

    @Beta
    @GwtIncompatible(value="Executor + Futures")
    public static <K, V> CacheLoader<K, V> asyncReloading(final CacheLoader<K, V> cacheLoader, final Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        return new CacheLoader<K, V>(){

            @Override
            public V load(K k) throws Exception {
                return cacheLoader.load(k);
            }

            @Override
            public ListenableFuture<V> reload(final K k, final V v) throws Exception {
                ListenableFutureTask listenableFutureTask = ListenableFutureTask.create(new Callable<V>(){

                    @Override
                    public V call() throws Exception {
                        return cacheLoader.reload(k, v).get();
                    }
                });
                executor.execute(listenableFutureTask);
                return listenableFutureTask;
            }

            @Override
            public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
                return cacheLoader.loadAll(iterable);
            }
        };
    }

    public static final class InvalidCacheLoadException
    extends RuntimeException {
        public InvalidCacheLoadException(String string) {
            super(string);
        }
    }

    public static final class UnsupportedLoadingOperationException
    extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    private static final class SupplierToCacheLoader<V>
    extends CacheLoader<Object, V>
    implements Serializable {
        private final Supplier<V> computingSupplier;
        private static final long serialVersionUID = 0L;

        public SupplierToCacheLoader(Supplier<V> supplier) {
            this.computingSupplier = Preconditions.checkNotNull(supplier);
        }

        @Override
        public V load(Object object) {
            Preconditions.checkNotNull(object);
            return this.computingSupplier.get();
        }
    }

    private static final class FunctionToCacheLoader<K, V>
    extends CacheLoader<K, V>
    implements Serializable {
        private final Function<K, V> computingFunction;
        private static final long serialVersionUID = 0L;

        public FunctionToCacheLoader(Function<K, V> function) {
            this.computingFunction = Preconditions.checkNotNull(function);
        }

        @Override
        public V load(K k) {
            return this.computingFunction.apply(Preconditions.checkNotNull(k));
        }
    }
}

