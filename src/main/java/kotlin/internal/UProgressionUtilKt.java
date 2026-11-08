/*
 * Decompiled with CFR 0.152.
 */
package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"})
public class UProgressionUtilKt {
    private static final int mf61ecd7085(int n, int n2, int n3) {
        int n4;
        int n5 = Integer.remainderUnsigned(n, n3);
        return Integer.compareUnsigned(n5, n4 = Integer.remainderUnsigned(n2, n3)) >= 0 ? UInt.mb680b9b7ba(n5 - n4) : UInt.mb680b9b7ba(UInt.mb680b9b7ba(n5 - n4) + n3);
    }

    private static final long m6d143635ff(long l, long l2, long l3) {
        long l4;
        long l5 = Long.remainderUnsigned(l, l3);
        return Long.compareUnsigned(l5, l4 = Long.remainderUnsigned(l2, l3)) >= 0 ? ULong.mc76128828a(l5 - l4) : ULong.mc76128828a(ULong.mc76128828a(l5 - l4) + l3);
    }

    @PublishedApi
    @SinceKotlin(version="1.3")
    public static final int m194a5b1924(int n, int n2, int n3) {
        int n4;
        if (n3 > 0) {
            n4 = Integer.compareUnsigned(n, n2) >= 0 ? n2 : UInt.mb680b9b7ba(n2 - UProgressionUtilKt.mf61ecd7085(n2, n, UInt.mb680b9b7ba(n3)));
        } else if (n3 < 0) {
            n4 = Integer.compareUnsigned(n, n2) <= 0 ? n2 : UInt.mb680b9b7ba(n2 + UProgressionUtilKt.mf61ecd7085(n, n2, UInt.mb680b9b7ba(-n3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return n4;
    }

    @PublishedApi
    @SinceKotlin(version="1.3")
    public static final long m81c056ab86(long l, long l2, long l3) {
        long l4;
        if (l3 > 0L) {
            l4 = Long.compareUnsigned(l, l2) >= 0 ? l2 : ULong.mc76128828a(l2 - UProgressionUtilKt.m6d143635ff(l2, l, ULong.mc76128828a(l3)));
        } else if (l3 < 0L) {
            l4 = Long.compareUnsigned(l, l2) <= 0 ? l2 : ULong.mc76128828a(l2 + UProgressionUtilKt.m6d143635ff(l, l2, ULong.mc76128828a(-l3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return l4;
    }
}

