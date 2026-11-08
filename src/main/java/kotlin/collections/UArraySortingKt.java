/*
 * Decompiled with CFR 0.152.
 */
package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2={"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"})
public class UArraySortingKt {
    @ExperimentalUnsignedTypes
    private static final int mad14bcc857(byte[] byArray, int n, int n2) {
        int n3 = n;
        int n4 = n2;
        byte by = UByteArray.m0b2ab7f5bf(byArray, (n + n2) / 2);
        while (n3 <= n4) {
            while (Intrinsics.compare(UByteArray.m0b2ab7f5bf(byArray, n3) & 0xFF, by & 0xFF) < 0) {
                ++n3;
            }
            while (Intrinsics.compare(UByteArray.m0b2ab7f5bf(byArray, n4) & 0xFF, by & 0xFF) > 0) {
                --n4;
            }
            if (n3 > n4) continue;
            byte by2 = UByteArray.m0b2ab7f5bf(byArray, n3);
            UByteArray.mbbd99e64b0(byArray, n3, UByteArray.m0b2ab7f5bf(byArray, n4));
            UByteArray.mbbd99e64b0(byArray, n4, by2);
            ++n3;
            --n4;
        }
        return n3;
    }

    @ExperimentalUnsignedTypes
    private static final void m799945e081(byte[] byArray, int n, int n2) {
        int n3 = UArraySortingKt.mad14bcc857(byArray, n, n2);
        if (n < n3 - 1) {
            UArraySortingKt.m799945e081(byArray, n, n3 - 1);
        }
        if (n3 < n2) {
            UArraySortingKt.m799945e081(byArray, n3, n2);
        }
    }

    @ExperimentalUnsignedTypes
    private static final int m61c509109a(short[] sArray, int n, int n2) {
        int n3 = n;
        int n4 = n2;
        short s = UShortArray.me287ce0640(sArray, (n + n2) / 2);
        while (n3 <= n4) {
            while (Intrinsics.compare(UShortArray.me287ce0640(sArray, n3) & 0xFFFF, s & 0xFFFF) < 0) {
                ++n3;
            }
            while (Intrinsics.compare(UShortArray.me287ce0640(sArray, n4) & 0xFFFF, s & 0xFFFF) > 0) {
                --n4;
            }
            if (n3 > n4) continue;
            short s2 = UShortArray.me287ce0640(sArray, n3);
            UShortArray.m5084587a43(sArray, n3, UShortArray.me287ce0640(sArray, n4));
            UShortArray.m5084587a43(sArray, n4, s2);
            ++n3;
            --n4;
        }
        return n3;
    }

    @ExperimentalUnsignedTypes
    private static final void ma868954e27(short[] sArray, int n, int n2) {
        int n3 = UArraySortingKt.m61c509109a(sArray, n, n2);
        if (n < n3 - 1) {
            UArraySortingKt.ma868954e27(sArray, n, n3 - 1);
        }
        if (n3 < n2) {
            UArraySortingKt.ma868954e27(sArray, n3, n2);
        }
    }

    @ExperimentalUnsignedTypes
    private static final int m7962bad5dd(int[] nArray, int n, int n2) {
        int n3 = n;
        int n4 = n2;
        int n5 = UIntArray.mbcec8b6d58(nArray, (n + n2) / 2);
        while (n3 <= n4) {
            while (Integer.compareUnsigned(UIntArray.mbcec8b6d58(nArray, n3), n5) < 0) {
                ++n3;
            }
            while (Integer.compareUnsigned(UIntArray.mbcec8b6d58(nArray, n4), n5) > 0) {
                --n4;
            }
            if (n3 > n4) continue;
            int n6 = UIntArray.mbcec8b6d58(nArray, n3);
            UIntArray.m09af249e0b(nArray, n3, UIntArray.mbcec8b6d58(nArray, n4));
            UIntArray.m09af249e0b(nArray, n4, n6);
            ++n3;
            --n4;
        }
        return n3;
    }

    @ExperimentalUnsignedTypes
    private static final void m3ad69de9e2(int[] nArray, int n, int n2) {
        int n3 = UArraySortingKt.m7962bad5dd(nArray, n, n2);
        if (n < n3 - 1) {
            UArraySortingKt.m3ad69de9e2(nArray, n, n3 - 1);
        }
        if (n3 < n2) {
            UArraySortingKt.m3ad69de9e2(nArray, n3, n2);
        }
    }

    @ExperimentalUnsignedTypes
    private static final int m44dd731638(long[] lArray, int n, int n2) {
        int n3 = n;
        int n4 = n2;
        long l = ULongArray.mc20eb45c93(lArray, (n + n2) / 2);
        while (n3 <= n4) {
            while (Long.compareUnsigned(ULongArray.mc20eb45c93(lArray, n3), l) < 0) {
                ++n3;
            }
            while (Long.compareUnsigned(ULongArray.mc20eb45c93(lArray, n4), l) > 0) {
                --n4;
            }
            if (n3 > n4) continue;
            long l2 = ULongArray.mc20eb45c93(lArray, n3);
            ULongArray.m5926563316(lArray, n3, ULongArray.mc20eb45c93(lArray, n4));
            ULongArray.m5926563316(lArray, n4, l2);
            ++n3;
            --n4;
        }
        return n3;
    }

    @ExperimentalUnsignedTypes
    private static final void mf668469cfc(long[] lArray, int n, int n2) {
        int n3 = UArraySortingKt.m44dd731638(lArray, n, n2);
        if (n < n3 - 1) {
            UArraySortingKt.mf668469cfc(lArray, n, n3 - 1);
        }
        if (n3 < n2) {
            UArraySortingKt.mf668469cfc(lArray, n3, n2);
        }
    }

    @ExperimentalUnsignedTypes
    public static final void me8ce19326d(@NotNull byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(byArray, "array");
        UArraySortingKt.m799945e081(byArray, n, n2 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void m3a216122e5(@NotNull short[] sArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(sArray, "array");
        UArraySortingKt.ma868954e27(sArray, n, n2 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void m6d8a0bc1b8(@NotNull int[] nArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(nArray, "array");
        UArraySortingKt.m3ad69de9e2(nArray, n, n2 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void m0635a38956(@NotNull long[] lArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(lArray, "array");
        UArraySortingKt.mf668469cfc(lArray, n, n2 - 1);
    }
}

