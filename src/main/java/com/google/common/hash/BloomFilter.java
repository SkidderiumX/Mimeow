/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.hash.Funnel;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
public class BloomFilter<T>
implements Predicate<T>,
Serializable {
    private final BloomFilterStrategies.BitArray bits;
    private final int numHashFunctions;
    private final Funnel<T> funnel;
    private final Strategy strategy;
    private static final Strategy DEFAULT_STRATEGY = BloomFilter.getDefaultStrategyFromSystemProperty();
    @VisibleForTesting
    static final String USE_MITZ32_PROPERTY = "com.google.common.hash.BloomFilter.useMitz32";

    private BloomFilter(BloomFilterStrategies.BitArray bitArray, int n, Funnel<T> funnel, Strategy strategy) {
        Preconditions.checkArgument(n > 0, "numHashFunctions (%s) must be > 0", n);
        Preconditions.checkArgument(n <= 255, "numHashFunctions (%s) must be <= 255", n);
        this.bits = Preconditions.checkNotNull(bitArray);
        this.numHashFunctions = n;
        this.funnel = Preconditions.checkNotNull(funnel);
        this.strategy = Preconditions.checkNotNull(strategy);
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<T>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    @Override
    @Deprecated
    public boolean apply(T t) {
        return this.mightContain(t);
    }

    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public double expectedFpp() {
        return Math.pow((double)this.bits.bitCount() / (double)this.bitSize(), this.numHashFunctions);
    }

    @VisibleForTesting
    long bitSize() {
        return this.bits.bitSize();
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && this.bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        Preconditions.checkArgument(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
        Preconditions.checkArgument(this.bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", this.bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BloomFilter) {
            BloomFilter bloomFilter = (BloomFilter)object;
            return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.numHashFunctions, this.funnel, this.strategy, this.bits);
    }

    @VisibleForTesting
    static Strategy getDefaultStrategyFromSystemProperty() {
        return Boolean.parseBoolean(System.getProperty(USE_MITZ32_PROPERTY)) ? BloomFilterStrategies.MURMUR128_MITZ_32 : BloomFilterStrategies.MURMUR128_MITZ_64;
    }

    public static <T> BloomFilter<T> create(Funnel<T> funnel, int n, double d) {
        return BloomFilter.create(funnel, n, d, DEFAULT_STRATEGY);
    }

    @VisibleForTesting
    static <T> BloomFilter<T> create(Funnel<T> funnel, int n, double d, Strategy strategy) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(n >= 0, "Expected insertions (%s) must be >= 0", n);
        Preconditions.checkArgument(d > 0.0, "False positive probability (%s) must be > 0.0", d);
        Preconditions.checkArgument(d < 1.0, "False positive probability (%s) must be < 1.0", d);
        Preconditions.checkNotNull(strategy);
        if (n == 0) {
            n = 1;
        }
        long l = BloomFilter.optimalNumOfBits(n, d);
        int n2 = BloomFilter.optimalNumOfHashFunctions(n, l);
        try {
            return new BloomFilter<T>(new BloomFilterStrategies.BitArray(l), n2, funnel, strategy);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + l + " bits", illegalArgumentException);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<T> funnel, int n) {
        return BloomFilter.create(funnel, n, 0.03);
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(long l, long l2) {
        return Math.max(1, (int)Math.round((double)(l2 / l) * Math.log(2.0)));
    }

    @VisibleForTesting
    static long optimalNumOfBits(long l, double d) {
        if (d == 0.0) {
            d = Double.MIN_VALUE;
        }
        return (long)((double)(-l) * Math.log(d) / (Math.log(2.0) * Math.log(2.0)));
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    private static class SerialForm<T>
    implements Serializable {
        final long[] data;
        final int numHashFunctions;
        final Funnel<T> funnel;
        final Strategy strategy;
        private static final long serialVersionUID = 1L;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = ((BloomFilter)bloomFilter).bits.data;
            this.numHashFunctions = ((BloomFilter)bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter)bloomFilter).funnel;
            this.strategy = ((BloomFilter)bloomFilter).strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public static interface Strategy
    extends Serializable {
        public <T> boolean put(T var1, Funnel<? super T> var2, int var3, BloomFilterStrategies.BitArray var4);

        public <T> boolean mightContain(T var1, Funnel<? super T> var2, int var3, BloomFilterStrategies.BitArray var4);

        public int ordinal();
    }
}

