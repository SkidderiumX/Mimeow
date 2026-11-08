/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.base.Ticker;
import com.google.common.collect.ComputationException;
import com.google.common.collect.ComputingConcurrentHashMap;
import com.google.common.collect.GenericMapMaker;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.MapMakerInternalMap;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class MapMaker
extends GenericMapMaker<Object, Object> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    static final int UNSET_INT = -1;
    boolean useCustomMap;
    int initialCapacity = -1;
    int concurrencyLevel = -1;
    int maximumSize = -1;
    MapMakerInternalMap.Strength keyStrength;
    MapMakerInternalMap.Strength valueStrength;
    long expireAfterWriteNanos = -1L;
    long expireAfterAccessNanos = -1L;
    RemovalCause nullRemovalCause;
    Equivalence<Object> keyEquivalence;
    Ticker ticker;

    @GwtIncompatible(value="To be supported")
    MapMaker keyEquivalence(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = Preconditions.checkNotNull(equivalence);
        this.useCustomMap = true;
        return this;
    }

    Equivalence<Object> getKeyEquivalence() {
        return Objects.firstNonNull(this.keyEquivalence, this.getKeyStrength().defaultEquivalence());
    }

    public MapMaker initialCapacity(int n) {
        Preconditions.checkState(this.initialCapacity == -1, "initial capacity was already set to %s", this.initialCapacity);
        Preconditions.checkArgument(n >= 0);
        this.initialCapacity = n;
        return this;
    }

    int getInitialCapacity() {
        return this.initialCapacity == -1 ? 16 : this.initialCapacity;
    }

    @Deprecated
    MapMaker maximumSize(int n) {
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", this.maximumSize);
        Preconditions.checkArgument(n >= 0, "maximum size must not be negative");
        this.maximumSize = n;
        this.useCustomMap = true;
        if (this.maximumSize == 0) {
            this.nullRemovalCause = RemovalCause.SIZE;
        }
        return this;
    }

    public MapMaker concurrencyLevel(int n) {
        Preconditions.checkState(this.concurrencyLevel == -1, "concurrency level was already set to %s", this.concurrencyLevel);
        Preconditions.checkArgument(n > 0);
        this.concurrencyLevel = n;
        return this;
    }

    int getConcurrencyLevel() {
        return this.concurrencyLevel == -1 ? 4 : this.concurrencyLevel;
    }

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    public MapMaker weakKeys() {
        return this.setKeyStrength(MapMakerInternalMap.Strength.WEAK);
    }

    MapMaker setKeyStrength(MapMakerInternalMap.Strength strength) {
        Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", new Object[]{this.keyStrength});
        this.keyStrength = Preconditions.checkNotNull(strength);
        Preconditions.checkArgument(this.keyStrength != MapMakerInternalMap.Strength.SOFT, "Soft keys are not supported");
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    MapMakerInternalMap.Strength getKeyStrength() {
        return Objects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
    }

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    public MapMaker weakValues() {
        return this.setValueStrength(MapMakerInternalMap.Strength.WEAK);
    }

    @Deprecated
    @GwtIncompatible(value="java.lang.ref.SoftReference")
    public MapMaker softValues() {
        return this.setValueStrength(MapMakerInternalMap.Strength.SOFT);
    }

    MapMaker setValueStrength(MapMakerInternalMap.Strength strength) {
        Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", new Object[]{this.valueStrength});
        this.valueStrength = Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    MapMakerInternalMap.Strength getValueStrength() {
        return Objects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
    }

    @Deprecated
    MapMaker expireAfterWrite(long l, TimeUnit timeUnit) {
        this.checkExpiration(l, timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(l);
        if (l == 0L && this.nullRemovalCause == null) {
            this.nullRemovalCause = RemovalCause.EXPIRED;
        }
        this.useCustomMap = true;
        return this;
    }

    private void checkExpiration(long l, TimeUnit timeUnit) {
        Preconditions.checkState(this.expireAfterWriteNanos == -1L, "expireAfterWrite was already set to %s ns", this.expireAfterWriteNanos);
        Preconditions.checkState(this.expireAfterAccessNanos == -1L, "expireAfterAccess was already set to %s ns", this.expireAfterAccessNanos);
        Preconditions.checkArgument(l >= 0L, "duration cannot be negative: %s %s", new Object[]{l, timeUnit});
    }

    long getExpireAfterWriteNanos() {
        return this.expireAfterWriteNanos == -1L ? 0L : this.expireAfterWriteNanos;
    }

    @Deprecated
    @GwtIncompatible(value="To be supported")
    MapMaker expireAfterAccess(long l, TimeUnit timeUnit) {
        this.checkExpiration(l, timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(l);
        if (l == 0L && this.nullRemovalCause == null) {
            this.nullRemovalCause = RemovalCause.EXPIRED;
        }
        this.useCustomMap = true;
        return this;
    }

    long getExpireAfterAccessNanos() {
        return this.expireAfterAccessNanos == -1L ? 0L : this.expireAfterAccessNanos;
    }

    Ticker getTicker() {
        return Objects.firstNonNull(this.ticker, Ticker.systemTicker());
    }

    @Deprecated
    @GwtIncompatible(value="To be supported")
    <K, V> GenericMapMaker<K, V> removalListener(RemovalListener<K, V> removalListener) {
        Preconditions.checkState(this.removalListener == null);
        MapMaker mapMaker = this;
        mapMaker.removalListener = Preconditions.checkNotNull(removalListener);
        this.useCustomMap = true;
        return mapMaker;
    }

    @Override
    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.useCustomMap) {
            return new ConcurrentHashMap(this.getInitialCapacity(), 0.75f, this.getConcurrencyLevel());
        }
        return (ConcurrentMap)((Object)(this.nullRemovalCause == null ? new MapMakerInternalMap(this) : new NullConcurrentMap(this)));
    }

    @Override
    @GwtIncompatible(value="MapMakerInternalMap")
    <K, V> MapMakerInternalMap<K, V> makeCustomMap() {
        return new MapMakerInternalMap(this);
    }

    @Override
    @Deprecated
    <K, V> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> function) {
        return (ConcurrentMap)((Object)(this.nullRemovalCause == null ? new ComputingMapAdapter<K, V>(this, function) : new NullComputingConcurrentMap<K, V>(this, function)));
    }

    public String toString() {
        Objects.ToStringHelper toStringHelper = Objects.toStringHelper(this);
        if (this.initialCapacity != -1) {
            toStringHelper.add("initialCapacity", this.initialCapacity);
        }
        if (this.concurrencyLevel != -1) {
            toStringHelper.add("concurrencyLevel", this.concurrencyLevel);
        }
        if (this.maximumSize != -1) {
            toStringHelper.add("maximumSize", this.maximumSize);
        }
        if (this.expireAfterWriteNanos != -1L) {
            toStringHelper.add("expireAfterWrite", this.expireAfterWriteNanos + "ns");
        }
        if (this.expireAfterAccessNanos != -1L) {
            toStringHelper.add("expireAfterAccess", this.expireAfterAccessNanos + "ns");
        }
        if (this.keyStrength != null) {
            toStringHelper.add("keyStrength", Ascii.toLowerCase(this.keyStrength.toString()));
        }
        if (this.valueStrength != null) {
            toStringHelper.add("valueStrength", Ascii.toLowerCase(this.valueStrength.toString()));
        }
        if (this.keyEquivalence != null) {
            toStringHelper.addValue("keyEquivalence");
        }
        if (this.removalListener != null) {
            toStringHelper.addValue("removalListener");
        }
        return toStringHelper.toString();
    }

    public static final class ComputingMapAdapter<K, V>
    extends ComputingConcurrentHashMap<K, V>
    implements Serializable {
        private static final long serialVersionUID = 0L;

        ComputingMapAdapter(MapMaker mapMaker, Function<? super K, ? extends V> function) {
            super(mapMaker, function);
        }

        @Override
        public V get(Object object) {
            Object v;
            try {
                v = this.getOrCompute(object);
            }
            catch (ExecutionException executionException) {
                Throwable throwable = executionException.getCause();
                Throwables.propagateIfInstanceOf(throwable, ComputationException.class);
                throw new ComputationException(throwable);
            }
            if (v == null) {
                throw new NullPointerException(this.computingFunction + " returned null for key " + object + ".");
            }
            return v;
        }
    }

    public static final class NullComputingConcurrentMap<K, V>
    extends NullConcurrentMap<K, V> {
        private static final long serialVersionUID = 0L;
        final Function<? super K, ? extends V> computingFunction;

        NullComputingConcurrentMap(MapMaker mapMaker, Function<? super K, ? extends V> function) {
            super(mapMaker);
            this.computingFunction = Preconditions.checkNotNull(function);
        }

        @Override
        public V get(Object object) {
            Object object2 = object;
            V v = this.compute(object2);
            Preconditions.checkNotNull(v, "%s returned null for key %s.", this.computingFunction, object2);
            this.notifyRemoval(object2, v);
            return v;
        }

        private V compute(K k) {
            Preconditions.checkNotNull(k);
            try {
                return this.computingFunction.apply(k);
            }
            catch (ComputationException computationException) {
                throw computationException;
            }
            catch (Throwable throwable) {
                throw new ComputationException(throwable);
            }
        }
    }

    public static class NullConcurrentMap<K, V>
    extends AbstractMap<K, V>
    implements ConcurrentMap<K, V>,
    Serializable {
        private static final long serialVersionUID = 0L;
        private final RemovalListener<K, V> removalListener;
        private final RemovalCause removalCause;

        NullConcurrentMap(MapMaker mapMaker) {
            this.removalListener = mapMaker.getRemovalListener();
            this.removalCause = mapMaker.nullRemovalCause;
        }

        @Override
        public boolean containsKey(@Nullable Object object) {
            return false;
        }

        @Override
        public boolean containsValue(@Nullable Object object) {
            return false;
        }

        @Override
        public V get(@Nullable Object object) {
            return null;
        }

        void notifyRemoval(K k, V v) {
            RemovalNotification<K, V> removalNotification = new RemovalNotification<K, V>(k, v, this.removalCause);
            this.removalListener.onRemoval(removalNotification);
        }

        @Override
        public V put(K k, V v) {
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(v);
            this.notifyRemoval(k, v);
            return null;
        }

        @Override
        public V putIfAbsent(K k, V v) {
            return this.put(k, v);
        }

        @Override
        public V remove(@Nullable Object object) {
            return null;
        }

        @Override
        public boolean remove(@Nullable Object object, @Nullable Object object2) {
            return false;
        }

        @Override
        public V replace(K k, V v) {
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(v);
            return null;
        }

        @Override
        public boolean replace(K k, @Nullable V v, V v2) {
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(v2);
            return false;
        }

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            return Collections.emptySet();
        }
    }

    public static enum RemovalCause {
        EXPLICIT{

            @Override
            boolean wasEvicted() {
                return false;
            }
        }
        ,
        REPLACED{

            @Override
            boolean wasEvicted() {
                return false;
            }
        }
        ,
        COLLECTED{

            @Override
            boolean wasEvicted() {
                return true;
            }
        }
        ,
        EXPIRED{

            @Override
            boolean wasEvicted() {
                return true;
            }
        }
        ,
        SIZE{

            @Override
            boolean wasEvicted() {
                return true;
            }
        };


        abstract boolean wasEvicted();
    }

    public static final class RemovalNotification<K, V>
    extends ImmutableEntry<K, V> {
        private static final long serialVersionUID = 0L;
        private final RemovalCause cause;

        RemovalNotification(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
            super(k, v);
            this.cause = removalCause;
        }

        public RemovalCause getCause() {
            return this.cause;
        }

        public boolean wasEvicted() {
            return this.cause.wasEvicted();
        }
    }

    public static interface RemovalListener<K, V> {
        public void onRemoval(RemovalNotification<K, V> var1);
    }
}

