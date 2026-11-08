/*
 * Decompiled with CFR 0.152.
 */
package kotlin;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"})
@JvmName(name="UnsignedKt")
public class UnsignedKt {
    @PublishedApi
    public static final int uintCompare(int n, int n2) {
        return Intrinsics.compare(n ^ Integer.MIN_VALUE, n2 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int ulongCompare(long l, long l2) {
        return Intrinsics.compare(l ^ Long.MIN_VALUE, l2 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    public static final int mf567cda180(int n, int n2) {
        return UInt.mb680b9b7ba((int)(((long)n & 0xFFFFFFFFL) / ((long)n2 & 0xFFFFFFFFL)));
    }

    @PublishedApi
    public static final int m210dbbec7f(int n, int n2) {
        return UInt.mb680b9b7ba((int)(((long)n & 0xFFFFFFFFL) % ((long)n2 & 0xFFFFFFFFL)));
    }

    @PublishedApi
    public static final long m12c738394f(long l, long l2) {
        long l3;
        long l4 = l;
        long l5 = l2;
        if (l5 < 0L) {
            return Long.compareUnsigned(l, l2) < 0 ? ULong.mc76128828a(0L) : ULong.mc76128828a(1L);
        }
        if (l4 >= 0L) {
            return ULong.mc76128828a(l4 / l5);
        }
        long l6 = l4 - (l3 = (l4 >>> 1) / l5 << 1) * l5;
        return ULong.mc76128828a(l3 + (long)(Long.compareUnsigned(ULong.mc76128828a(l6), ULong.mc76128828a(l5)) >= 0 ? 1 : 0));
    }

    @PublishedApi
    public static final long m5206cd43ca(long l, long l2) {
        long l3;
        long l4 = l;
        long l5 = l2;
        if (l5 < 0L) {
            return Long.compareUnsigned(l, l2) < 0 ? l : ULong.mc76128828a(l - l2);
        }
        if (l4 >= 0L) {
            return ULong.mc76128828a(l4 % l5);
        }
        long l6 = (l4 >>> 1) / l5 << 1;
        return ULong.mc76128828a(l3 - (Long.compareUnsigned(ULong.mc76128828a(l3 = l4 - l6 * l5), ULong.mc76128828a(l5)) >= 0 ? l5 : 0L));
    }

    @PublishedApi
    public static final int doubleToUInt(double d) {
        return Double.isNaN(d) ? 0 : (d <= UnsignedKt.uintToDouble(0) ? 0 : (d >= UnsignedKt.uintToDouble(-1) ? -1 : (d <= 2.147483647E9 ? UInt.mb680b9b7ba((int)d) : UInt.mb680b9b7ba(UInt.mb680b9b7ba((int)(d - (double)Integer.MAX_VALUE)) + UInt.mb680b9b7ba(Integer.MAX_VALUE)))));
    }

    @PublishedApi
    public static final long doubleToULong(double d) {
        return Double.isNaN(d) ? 0L : (d <= UnsignedKt.ulongToDouble(0L) ? 0L : (d >= UnsignedKt.ulongToDouble(-1L) ? -1L : (d < 9.223372036854776E18 ? ULong.mc76128828a((long)d) : ULong.mc76128828a(ULong.mc76128828a((long)(d - 9.223372036854776E18)) + Long.MIN_VALUE))));
    }

    @PublishedApi
    public static final double uintToDouble(int n) {
        return (double)(n & Integer.MAX_VALUE) + (double)(n >>> 31 << 30) * (double)2;
    }

    @PublishedApi
    public static final double ulongToDouble(long l) {
        return (double)(l >>> 11) * (double)2048 + (double)(l & 0x7FFL);
    }

    @NotNull
    public static final String ulongToString(long l) {
        return UnsignedKt.ulongToString(l, 10);
    }

    @NotNull
    public static final String ulongToString(long l, int n) {
        if (l >= 0L) {
            String string = Long.toString(l, CharsKt.checkRadix(n));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            return string;
        }
        long l2 = (l >>> 1) / (long)n << 1;
        long l3 = l - l2 * (long)n;
        if (l3 >= (long)n) {
            l3 -= (long)n;
            ++l2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string = Long.toString(l2, CharsKt.checkRadix(n));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        StringBuilder stringBuilder2 = stringBuilder.append(string);
        String string2 = Long.toString(l3, CharsKt.checkRadix(n));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
        return stringBuilder2.append(string2).toString();
    }
}

