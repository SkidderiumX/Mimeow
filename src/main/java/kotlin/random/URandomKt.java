/*
 * Decompiled with CFR 0.152.
 */
package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2={"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
public class URandomKt {
    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UInt.mb680b9b7ba(random.nextInt());
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final int m3b1fc7e441(@NotNull Random random, int n) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        return URandomKt.m3277188816(random, 0, n);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final int m3277188816(@NotNull Random random, int n, int n2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        URandomKt.me498a4a6d5(n, n2);
        int n3 = n ^ Integer.MIN_VALUE;
        int n4 = n2 ^ Integer.MIN_VALUE;
        int n5 = random.nextInt(n3, n4) ^ Integer.MIN_VALUE;
        return UInt.mb680b9b7ba(n5);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@NotNull Random random, @NotNull UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(uIntRange, "range");
        if (uIntRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uIntRange);
        }
        return Integer.compareUnsigned(uIntRange.getLast$pVg5ArA(), -1) < 0 ? URandomKt.m3277188816(random, uIntRange.getFirst$pVg5ArA(), UInt.mb680b9b7ba(uIntRange.getLast$pVg5ArA() + 1)) : (Integer.compareUnsigned(uIntRange.getFirst$pVg5ArA(), 0) > 0 ? UInt.mb680b9b7ba(URandomKt.m3277188816(random, UInt.mb680b9b7ba(uIntRange.getFirst$pVg5ArA() - 1), uIntRange.getLast$pVg5ArA()) + 1) : URandomKt.nextUInt(random));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final long nextULong(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return ULong.mc76128828a(random.nextLong());
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final long m3c183499c7(@NotNull Random random, long l) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        return URandomKt.m86a7bb21c5(random, 0L, l);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final long m86a7bb21c5(@NotNull Random random, long l, long l2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        URandomKt.mfb2d4b3f78(l, l2);
        long l3 = l ^ Long.MIN_VALUE;
        long l4 = l2 ^ Long.MIN_VALUE;
        long l5 = random.nextLong(l3, l4) ^ Long.MIN_VALUE;
        return ULong.mc76128828a(l5);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final long nextULong(@NotNull Random random, @NotNull ULongRange uLongRange) {
        long l;
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(uLongRange, "range");
        if (uLongRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uLongRange);
        }
        if (Long.compareUnsigned(uLongRange.getLast-s-VKNKU(), -1L) < 0) {
            long l2 = uLongRange.getLast-s-VKNKU();
            int n = 1;
            l = URandomKt.m86a7bb21c5(random, uLongRange.getFirst-s-VKNKU(), ULong.mc76128828a(l2 + ULong.mc76128828a((long)n & 0xFFFFFFFFL)));
        } else if (Long.compareUnsigned(uLongRange.getFirst-s-VKNKU(), 0L) > 0) {
            long l3 = uLongRange.getFirst-s-VKNKU();
            int n = 1;
            l3 = URandomKt.m86a7bb21c5(random, ULong.mc76128828a(l3 - ULong.mc76128828a((long)n & 0xFFFFFFFFL)), uLongRange.getLast-s-VKNKU());
            n = 1;
            l = ULong.mc76128828a(l3 + ULong.mc76128828a((long)n & 0xFFFFFFFFL));
        } else {
            l = URandomKt.nextULong(random);
        }
        return l;
    }

    @SinceKotlin(version="1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] m7dea9632d6(@NotNull Random random, @NotNull byte[] byArray) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(byArray, "array");
        random.nextBytes(byArray);
        return byArray;
    }

    @SinceKotlin(version="1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] nextUBytes(@NotNull Random random, int n) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UByteArray.m30f32ebf35(random.nextBytes(n));
    }

    @SinceKotlin(version="1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] m5ce029d34b(@NotNull Random random, @NotNull byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(byArray, "array");
        random.nextBytes(byArray, n, n2);
        return byArray;
    }

    public static /* synthetic */ byte[] ma8ca98f2f9(Random random, byte[] byArray, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            n2 = UByteArray.m383afec9cb(byArray);
        }
        return URandomKt.m5ce029d34b(random, byArray, n, n2);
    }

    public static final void me498a4a6d5(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = Integer.compareUnsigned(n2, n) > 0;
        if (!bl) {
            boolean bl3 = false;
            String string = RandomKt.boundsErrorMessage(UInt.m3f97684bd0(n), UInt.m3f97684bd0(n2));
            throw new IllegalArgumentException(string.toString());
        }
    }

    public static final void mfb2d4b3f78(long l, long l2) {
        boolean bl;
        boolean bl2 = bl = Long.compareUnsigned(l2, l) > 0;
        if (!bl) {
            boolean bl3 = false;
            String string = RandomKt.boundsErrorMessage(ULong.ma7eeea8d7e(l), ULong.ma7eeea8d7e(l2));
            throw new IllegalArgumentException(string.toString());
        }
    }
}

