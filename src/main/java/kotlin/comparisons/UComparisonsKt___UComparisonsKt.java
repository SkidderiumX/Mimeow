/*
 * Decompiled with CFR 0.152.
 */
package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.comparisons.UComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv={1, 9, 0}, k=5, xi=49, d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2={"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, xs="kotlin/comparisons/UComparisonsKt")
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final int mb88ce3ab54(int n, int n2) {
        return Integer.compareUnsigned(n, n2) >= 0 ? n : n2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final long m28a11a296a(long l, long l2) {
        return Long.compareUnsigned(l, l2) >= 0 ? l : l2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final byte mab509b935d(byte by, byte by2) {
        return Intrinsics.compare(by & 0xFF, by2 & 0xFF) >= 0 ? by : by2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final short mb63a87f4b7(short s, short s2) {
        return Intrinsics.compare(s & 0xFFFF, s2 & 0xFFFF) >= 0 ? s : s2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int m62e2a76fc7(int n, int n2, int n3) {
        return UComparisonsKt.maxOf$J1ME1BU((int)n, (int)UComparisonsKt.maxOf$J1ME1BU((int)n2, (int)n3));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long m4ecf5ca425(long l, long l2, long l3) {
        return UComparisonsKt.maxOf$eb3DHEI((long)l, (long)UComparisonsKt.maxOf$eb3DHEI((long)l2, (long)l3));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte mb888a2a893(byte by, byte by2, byte by3) {
        return UComparisonsKt.maxOf$Kr8caGY((byte)by, (byte)UComparisonsKt.maxOf$Kr8caGY((byte)by2, (byte)by3));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short mda3abe2c85(short s, short s2, short s3) {
        return UComparisonsKt.maxOf$5PvTz6A((short)s, (short)UComparisonsKt.maxOf$5PvTz6A((short)s2, (short)s3));
    }

    @SinceKotlin(version="1.4")
    @ExperimentalUnsignedTypes
    public static final int mc911326c64(int n, int ... nArray) {
        Intrinsics.checkNotNullParameter(nArray, "other");
        int n2 = n;
        int n3 = UIntArray.m0ceafd2280(nArray);
        for (int i = 0; i < n3; ++i) {
            int n4 = UIntArray.mbcec8b6d58(nArray, i);
            n2 = UComparisonsKt.maxOf$J1ME1BU((int)n2, (int)n4);
        }
        return n2;
    }

    @SinceKotlin(version="1.4")
    @ExperimentalUnsignedTypes
    public static final long m7efbfc8da0(long l, long ... lArray) {
        Intrinsics.checkNotNullParameter(lArray, "other");
        long l2 = l;
        int n = ULongArray.m23e36e6a11(lArray);
        for (int i = 0; i < n; ++i) {
            long l3 = ULongArray.mc20eb45c93(lArray, i);
            l2 = UComparisonsKt.maxOf$eb3DHEI((long)l2, (long)l3);
        }
        return l2;
    }

    @SinceKotlin(version="1.4")
    @ExperimentalUnsignedTypes
    public static final byte mf6c2d743d7(byte by, byte ... byArray) {
        Intrinsics.checkNotNullParameter(byArray, "other");
        byte by2 = by;
        int n = UByteArray.m383afec9cb(byArray);
        for (int i = 0; i < n; ++i) {
            byte by3 = UByteArray.m0b2ab7f5bf(byArray, i);
            by2 = UComparisonsKt.maxOf$Kr8caGY((byte)by2, (byte)by3);
        }
        return by2;
    }

    @SinceKotlin(version="1.4")
    @ExperimentalUnsignedTypes
    public static final short m7df096b489(short s, short ... sArray) {
        Intrinsics.checkNotNullParameter(sArray, "other");
        short s2 = s;
        int n = UShortArray.m70c7c61d51(sArray);
        for (int i = 0; i < n; ++i) {
            short s3 = UShortArray.me287ce0640(sArray, i);
            s2 = UComparisonsKt.maxOf$5PvTz6A((short)s2, (short)s3);
        }
        return s2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final int mc25ec8ba28(int n, int n2) {
        return Integer.compareUnsigned(n, n2) <= 0 ? n : n2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final long m6d1ea465b0(long l, long l2) {
        return Long.compareUnsigned(l, l2) <= 0 ? l : l2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final byte me6a4ec9516(byte by, byte by2) {
        return Intrinsics.compare(by & 0xFF, by2 & 0xFF) <= 0 ? by : by2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final short m3b86a53384(short s, short s2) {
        return Intrinsics.compare(s & 0xFFFF, s2 & 0xFFFF) <= 0 ? s : s2;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int mecd0de685a(int n, int n2, int n3) {
        return UComparisonsKt.minOf$J1ME1BU((int)n, (int)UComparisonsKt.minOf$J1ME1BU((int)n2, (int)n3));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long m3514ca0396(long l, long l2, long l3) {
        return UComparisonsKt.minOf$eb3DHEI((long)l, (long)UComparisonsKt.minOf$eb3DHEI((long)l2, (long)l3));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte m54307f4d53(byte by, byte by2, byte by3) {
        return UComparisonsKt.minOf$Kr8caGY((byte)by, (byte)UComparisonsKt.minOf$Kr8caGY((byte)by2, (byte)by3));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short m2758b67224(short s, short s2, short s3) {
        return UComparisonsKt.minOf$5PvTz6A((short)s, (short)UComparisonsKt.minOf$5PvTz6A((short)s2, (short)s3));
    }

    @SinceKotlin(version="1.4")
    @ExperimentalUnsignedTypes
    public static final int m540bb5fc4f(int n, int ... nArray) {
        Intrinsics.checkNotNullParameter(nArray, "other");
        int n2 = n;
        int n3 = UIntArray.m0ceafd2280(nArray);
        for (int i = 0; i < n3; ++i) {
            int n4 = UIntArray.mbcec8b6d58(nArray, i);
            n2 = UComparisonsKt.minOf$J1ME1BU((int)n2, (int)n4);
        }
        return n2;
    }

    @SinceKotlin(version="1.4")
    @ExperimentalUnsignedTypes
    public static final long mc8cea5c663(long l, long ... lArray) {
        Intrinsics.checkNotNullParameter(lArray, "other");
        long l2 = l;
        int n = ULongArray.m23e36e6a11(lArray);
        for (int i = 0; i < n; ++i) {
            long l3 = ULongArray.mc20eb45c93(lArray, i);
            l2 = UComparisonsKt.minOf$eb3DHEI((long)l2, (long)l3);
        }
        return l2;
    }

    @SinceKotlin(version="1.4")
    @ExperimentalUnsignedTypes
    public static final byte m0e6b65119a(byte by, byte ... byArray) {
        Intrinsics.checkNotNullParameter(byArray, "other");
        byte by2 = by;
        int n = UByteArray.m383afec9cb(byArray);
        for (int i = 0; i < n; ++i) {
            byte by3 = UByteArray.m0b2ab7f5bf(byArray, i);
            by2 = UComparisonsKt.minOf$Kr8caGY((byte)by2, (byte)by3);
        }
        return by2;
    }

    @SinceKotlin(version="1.4")
    @ExperimentalUnsignedTypes
    public static final short m4b887d9657(short s, short ... sArray) {
        Intrinsics.checkNotNullParameter(sArray, "other");
        short s2 = s;
        int n = UShortArray.m70c7c61d51(sArray);
        for (int i = 0; i < n; ++i) {
            short s3 = UShortArray.me287ce0640(sArray, i);
            s2 = UComparisonsKt.minOf$5PvTz6A((short)s2, (short)s3);
        }
        return s2;
    }
}

