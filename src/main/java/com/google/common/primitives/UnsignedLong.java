/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class UnsignedLong
extends Number
implements Comparable<UnsignedLong>,
Serializable {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO = new UnsignedLong(0L);
    public static final UnsignedLong ONE = new UnsignedLong(1L);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1L);
    private final long value;

    private UnsignedLong(long l) {
        this.value = l;
    }

    public static UnsignedLong fromLongBits(long l) {
        return new UnsignedLong(l);
    }

    public static UnsignedLong valueOf(long l) {
        Preconditions.checkArgument(l >= 0L, "value (%s) is outside the range for an unsigned long value", l);
        return UnsignedLong.fromLongBits(l);
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return UnsignedLong.fromLongBits(bigInteger.longValue());
    }

    public static UnsignedLong valueOf(String string) {
        return UnsignedLong.valueOf(string, 10);
    }

    public static UnsignedLong valueOf(String string, int n) {
        return UnsignedLong.fromLongBits(UnsignedLongs.parseUnsignedLong(string, n));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(this.value + Preconditions.checkNotNull(unsignedLong).value);
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(this.value - Preconditions.checkNotNull(unsignedLong).value);
    }

    @CheckReturnValue
    public UnsignedLong times(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(this.value * Preconditions.checkNotNull(unsignedLong).value);
    }

    @CheckReturnValue
    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(UnsignedLongs.divide(this.value, Preconditions.checkNotNull(unsignedLong).value));
    }

    @CheckReturnValue
    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return UnsignedLong.fromLongBits(UnsignedLongs.remainder(this.value, Preconditions.checkNotNull(unsignedLong).value));
    }

    @Override
    public int intValue() {
        return (int)this.value;
    }

    @Override
    public long longValue() {
        return this.value;
    }

    @Override
    public float floatValue() {
        float f = this.value & Long.MAX_VALUE;
        if (this.value < 0L) {
            f += 9.223372E18f;
        }
        return f;
    }

    @Override
    public double doubleValue() {
        double d = this.value & Long.MAX_VALUE;
        if (this.value < 0L) {
            d += 9.223372036854776E18;
        }
        return d;
    }

    public BigInteger bigIntegerValue() {
        BigInteger bigInteger = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0L) {
            bigInteger = bigInteger.setBit(63);
        }
        return bigInteger;
    }

    @Override
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.value, unsignedLong.value);
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof UnsignedLong) {
            UnsignedLong unsignedLong = (UnsignedLong)object;
            return this.value == unsignedLong.value;
        }
        return false;
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public String toString(int n) {
        return UnsignedLongs.toString(this.value, n);
    }
}

