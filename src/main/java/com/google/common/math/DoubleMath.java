/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.LongMath;
import com.google.common.math.MathPreconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated=true)
public class DoubleMath {
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18;
    private static final double LN_2 = Math.log(2.0);
    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    @VisibleForTesting
    static final double[] everySixteenthFactorial = new double[]{1.0, 2.0922789888E13, 2.631308369336935E35, 1.2413915592536073E61, 1.2688693218588417E89, 7.156945704626381E118, 9.916779348709496E149, 1.974506857221074E182, 3.856204823625804E215, 5.5502938327393044E249, 4.7147236359920616E284};

    @GwtIncompatible(value="#isMathematicalInteger, com.google.common.math.DoubleUtils")
    static double roundIntermediate(double d, RoundingMode roundingMode) {
        if (!DoubleUtils.isFinite(d)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (roundingMode) {
            case UNNECESSARY: {
                MathPreconditions.checkRoundingUnnecessary(DoubleMath.isMathematicalInteger(d));
                return d;
            }
            case FLOOR: {
                if (d >= 0.0 || DoubleMath.isMathematicalInteger(d)) {
                    return d;
                }
                return d - 1.0;
            }
            case CEILING: {
                if (d <= 0.0 || DoubleMath.isMathematicalInteger(d)) {
                    return d;
                }
                return d + 1.0;
            }
            case DOWN: {
                return d;
            }
            case UP: {
                if (DoubleMath.isMathematicalInteger(d)) {
                    return d;
                }
                return d + Math.copySign(1.0, d);
            }
            case HALF_EVEN: {
                return Math.rint(d);
            }
            case HALF_UP: {
                double d2 = Math.rint(d);
                if (Math.abs(d - d2) == 0.5) {
                    return d + Math.copySign(0.5, d);
                }
                return d2;
            }
            case HALF_DOWN: {
                double d3 = Math.rint(d);
                if (Math.abs(d - d3) == 0.5) {
                    return d;
                }
                return d3;
            }
        }
        throw new AssertionError();
    }

    @GwtIncompatible(value="#roundIntermediate")
    public static int roundToInt(double d, RoundingMode roundingMode) {
        double d2 = DoubleMath.roundIntermediate(d, roundingMode);
        MathPreconditions.checkInRange(d2 > -2.147483649E9 & d2 < 2.147483648E9);
        return (int)d2;
    }

    @GwtIncompatible(value="#roundIntermediate")
    public static long roundToLong(double d, RoundingMode roundingMode) {
        double d2 = DoubleMath.roundIntermediate(d, roundingMode);
        MathPreconditions.checkInRange(-9.223372036854776E18 - d2 < 1.0 & d2 < 9.223372036854776E18);
        return (long)d2;
    }

    @GwtIncompatible(value="#roundIntermediate, java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static BigInteger roundToBigInteger(double d, RoundingMode roundingMode) {
        if (-9.223372036854776E18 - (d = DoubleMath.roundIntermediate(d, roundingMode)) < 1.0 & d < 9.223372036854776E18) {
            return BigInteger.valueOf((long)d);
        }
        int n = Math.getExponent(d);
        long l = DoubleUtils.getSignificand(d);
        BigInteger bigInteger = BigInteger.valueOf(l).shiftLeft(n - 52);
        return d < 0.0 ? bigInteger.negate() : bigInteger;
    }

    @GwtIncompatible(value="com.google.common.math.DoubleUtils")
    public static boolean isPowerOfTwo(double d) {
        return d > 0.0 && DoubleUtils.isFinite(d) && LongMath.isPowerOfTwo(DoubleUtils.getSignificand(d));
    }

    public static double log2(double d) {
        return Math.log(d) / LN_2;
    }

    @GwtIncompatible(value="java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static int log2(double d, RoundingMode roundingMode) {
        boolean bl;
        Preconditions.checkArgument(d > 0.0 && DoubleUtils.isFinite(d), "x must be positive and finite");
        int n = Math.getExponent(d);
        if (!DoubleUtils.isNormal(d)) {
            return DoubleMath.log2(d * 4.503599627370496E15, roundingMode) - 52;
        }
        switch (roundingMode) {
            case UNNECESSARY: {
                MathPreconditions.checkRoundingUnnecessary(DoubleMath.isPowerOfTwo(d));
            }
            case FLOOR: {
                bl = false;
                break;
            }
            case CEILING: {
                bl = !DoubleMath.isPowerOfTwo(d);
                break;
            }
            case DOWN: {
                bl = n < 0 & !DoubleMath.isPowerOfTwo(d);
                break;
            }
            case UP: {
                bl = n >= 0 & !DoubleMath.isPowerOfTwo(d);
                break;
            }
            case HALF_EVEN: 
            case HALF_UP: 
            case HALF_DOWN: {
                double d2 = DoubleUtils.scaleNormalize(d);
                bl = d2 * d2 > 2.0;
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return bl ? n + 1 : n;
    }

    @GwtIncompatible(value="java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static boolean isMathematicalInteger(double d) {
        return DoubleUtils.isFinite(d) && (d == 0.0 || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d)) <= Math.getExponent(d));
    }

    public static double factorial(int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d = 1.0;
        for (int i = 1 + (n & 0xFFFFFFF0); i <= n; ++i) {
            d *= (double)i;
        }
        return d * everySixteenthFactorial[n >> 4];
    }

    public static boolean fuzzyEquals(double d, double d2, double d3) {
        MathPreconditions.checkNonNegative("tolerance", d3);
        return Math.copySign(d - d2, 1.0) <= d3 || d == d2 || Double.isNaN(d) && Double.isNaN(d2);
    }

    public static int fuzzyCompare(double d, double d2, double d3) {
        if (DoubleMath.fuzzyEquals(d, d2, d3)) {
            return 0;
        }
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d), Double.isNaN(d2));
    }

    @GwtIncompatible(value="MeanAccumulator")
    public static double mean(double ... dArray) {
        MeanAccumulator meanAccumulator = new MeanAccumulator();
        for (double d : dArray) {
            meanAccumulator.add(d);
        }
        return meanAccumulator.mean();
    }

    @GwtIncompatible(value="MeanAccumulator")
    public static double mean(int ... nArray) {
        MeanAccumulator meanAccumulator = new MeanAccumulator();
        for (int n : nArray) {
            meanAccumulator.add(n);
        }
        return meanAccumulator.mean();
    }

    @GwtIncompatible(value="MeanAccumulator")
    public static double mean(long ... lArray) {
        MeanAccumulator meanAccumulator = new MeanAccumulator();
        for (long l : lArray) {
            meanAccumulator.add(l);
        }
        return meanAccumulator.mean();
    }

    @GwtIncompatible(value="MeanAccumulator")
    public static double mean(Iterable<? extends Number> iterable) {
        MeanAccumulator meanAccumulator = new MeanAccumulator();
        for (Number number : iterable) {
            meanAccumulator.add(number.doubleValue());
        }
        return meanAccumulator.mean();
    }

    @GwtIncompatible(value="MeanAccumulator")
    public static double mean(Iterator<? extends Number> iterator2) {
        MeanAccumulator meanAccumulator = new MeanAccumulator();
        while (iterator2.hasNext()) {
            meanAccumulator.add(iterator2.next().doubleValue());
        }
        return meanAccumulator.mean();
    }

    private DoubleMath() {
    }

    @GwtIncompatible(value="com.google.common.math.DoubleUtils")
    private static final class MeanAccumulator {
        private long count = 0L;
        private double mean = 0.0;

        private MeanAccumulator() {
        }

        void add(double d) {
            Preconditions.checkArgument(DoubleUtils.isFinite(d));
            ++this.count;
            this.mean += (d - this.mean) / (double)this.count;
        }

        double mean() {
            Preconditions.checkArgument(this.count > 0L, "Cannot take mean of 0 values");
            return this.mean;
        }
    }
}

