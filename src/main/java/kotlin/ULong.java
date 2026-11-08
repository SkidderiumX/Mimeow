/*
 * Decompiled with CFR 0.152.
 */
package kotlin;

import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;
import org.jetbrains.annotations.NotNull;

@JvmInline
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 ~2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001~B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%H\u00d6\u0003\u00a2\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010JJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010\u001dJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u0010\u000bJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\"J\u001e\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\f\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u0010\u001fJ\u001e\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\f\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bV\u0010\u001fJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bX\u0010\u001dJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bY\u0010\u001fJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bZ\u0010\u000bJ\u001b\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b[\u0010\"J\u0010\u0010\\\u001a\u00020]H\u0087\b\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020aH\u0087\b\u00a2\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010h\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\bi\u0010/J\u0010\u0010j\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bk\u0010\u0005J\u0010\u0010l\u001a\u00020mH\u0087\b\u00a2\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016\u00a2\u0006\u0004\br\u0010sJ\u0016\u0010t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bu\u0010_J\u0016\u0010v\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bw\u0010/J\u0016\u0010x\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\by\u0010\u0005J\u0016\u0010z\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b{\u0010oJ\u001b\u0010|\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b}\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u007f"}, d2={"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.5")
@WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
public class ULong
implements Comparable<ULong> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long data;
    public static final long MIN_VALUE = 0L;
    public static final long MAX_VALUE = -1L;
    public static final int SIZE_BYTES = 8;
    public static final int SIZE_BITS = 64;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @InlineOnly
    private static final int me547aa18ce(long l, byte by) {
        return Long.compareUnsigned(l, ULong.mc76128828a((long)by & 0xFFL));
    }

    @InlineOnly
    private static final int m4dc4293383(long l, short s) {
        return Long.compareUnsigned(l, ULong.mc76128828a((long)s & 0xFFFFL));
    }

    @InlineOnly
    private static final int m845fff1f8c(long l, int n) {
        return Long.compareUnsigned(l, ULong.mc76128828a((long)n & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static int m773f60146d(long l, long l2) {
        return UnsignedKt.ulongCompare(l, l2);
    }

    @InlineOnly
    private int m1f2b2551d8(long l) {
        return UnsignedKt.ulongCompare(this.m8c33c6a73b(), l);
    }

    @InlineOnly
    private static final long mdb7fd606ab(long l, byte by) {
        return ULong.mc76128828a(l + ULong.mc76128828a((long)by & 0xFFL));
    }

    @InlineOnly
    private static final long me954c48e40(long l, short s) {
        return ULong.mc76128828a(l + ULong.mc76128828a((long)s & 0xFFFFL));
    }

    @InlineOnly
    private static final long m67e0ac7530(long l, int n) {
        return ULong.mc76128828a(l + ULong.mc76128828a((long)n & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long m68df04b999(long l, long l2) {
        return ULong.mc76128828a(l + l2);
    }

    @InlineOnly
    private static final long me623ac69d0(long l, byte by) {
        return ULong.mc76128828a(l - ULong.mc76128828a((long)by & 0xFFL));
    }

    @InlineOnly
    private static final long m3b3eaa4500(long l, short s) {
        return ULong.mc76128828a(l - ULong.mc76128828a((long)s & 0xFFFFL));
    }

    @InlineOnly
    private static final long mf70c27d471(long l, int n) {
        return ULong.mc76128828a(l - ULong.mc76128828a((long)n & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long m3adef1f6b8(long l, long l2) {
        return ULong.mc76128828a(l - l2);
    }

    @InlineOnly
    private static final long m1e53633cb7(long l, byte by) {
        return ULong.mc76128828a(l * ULong.mc76128828a((long)by & 0xFFL));
    }

    @InlineOnly
    private static final long m7470a85966(long l, short s) {
        return ULong.mc76128828a(l * ULong.mc76128828a((long)s & 0xFFFFL));
    }

    @InlineOnly
    private static final long m35bdc6d9b9(long l, int n) {
        return ULong.mc76128828a(l * ULong.mc76128828a((long)n & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long m1d0b6fd691(long l, long l2) {
        return ULong.mc76128828a(l * l2);
    }

    @InlineOnly
    private static final long m5d378af277(long l, byte by) {
        return Long.divideUnsigned(l, ULong.mc76128828a((long)by & 0xFFL));
    }

    @InlineOnly
    private static final long m7618d65a0e(long l, short s) {
        return Long.divideUnsigned(l, ULong.mc76128828a((long)s & 0xFFFFL));
    }

    @InlineOnly
    private static final long m2f5c2ca440(long l, int n) {
        return Long.divideUnsigned(l, ULong.mc76128828a((long)n & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long m9cd6c65c75(long l, long l2) {
        return UnsignedKt.m12c738394f(l, l2);
    }

    @InlineOnly
    private static final long maea4458d90(long l, byte by) {
        return Long.remainderUnsigned(l, ULong.mc76128828a((long)by & 0xFFL));
    }

    @InlineOnly
    private static final long m8da6b96ad4(long l, short s) {
        return Long.remainderUnsigned(l, ULong.mc76128828a((long)s & 0xFFFFL));
    }

    @InlineOnly
    private static final long mdc23df52b5(long l, int n) {
        return Long.remainderUnsigned(l, ULong.mc76128828a((long)n & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long md37787b353(long l, long l2) {
        return UnsignedKt.m5206cd43ca(l, l2);
    }

    @InlineOnly
    private static final long m75253a6189(long l, byte by) {
        return Long.divideUnsigned(l, ULong.mc76128828a((long)by & 0xFFL));
    }

    @InlineOnly
    private static final long mb3cb15db1c(long l, short s) {
        return Long.divideUnsigned(l, ULong.mc76128828a((long)s & 0xFFFFL));
    }

    @InlineOnly
    private static final long m465e1bfee5(long l, int n) {
        return Long.divideUnsigned(l, ULong.mc76128828a((long)n & 0xFFFFFFFFL));
    }

    @InlineOnly
    private static final long m70cf0fd3cd(long l, long l2) {
        return Long.divideUnsigned(l, l2);
    }

    @InlineOnly
    private static final byte mad88b3740d(long l, byte by) {
        return UByte.m854efd65e6((byte)Long.remainderUnsigned(l, ULong.mc76128828a((long)by & 0xFFL)));
    }

    @InlineOnly
    private static final short ma75fe177de(long l, short s) {
        return UShort.m96ff20ce19((short)Long.remainderUnsigned(l, ULong.mc76128828a((long)s & 0xFFFFL)));
    }

    @InlineOnly
    private static final int m71b89b0927(long l, int n) {
        return UInt.mb680b9b7ba((int)Long.remainderUnsigned(l, ULong.mc76128828a((long)n & 0xFFFFFFFFL)));
    }

    @InlineOnly
    private static final long m18e7777561(long l, long l2) {
        return Long.remainderUnsigned(l, l2);
    }

    @InlineOnly
    private static final long m5d296c6c11(long l) {
        return ULong.mc76128828a(l + 1L);
    }

    @InlineOnly
    private static final long mdb47c47204(long l) {
        return ULong.mc76128828a(l + -1L);
    }

    @InlineOnly
    private static final ULongRange m6ea396b00e(long l, long l2) {
        return new ULongRange(l, l2, null);
    }

    @SinceKotlin(version="1.9")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    @InlineOnly
    private static final ULongRange me332993dcd(long l, long l2) {
        return URangesKt.until$eb3DHEI((long)l, (long)l2);
    }

    @InlineOnly
    private static final long md180cdbabf(long l, int n) {
        return ULong.mc76128828a(l << n);
    }

    @InlineOnly
    private static final long m3d457d0e82(long l, int n) {
        return ULong.mc76128828a(l >>> n);
    }

    @InlineOnly
    private static final long m923edf7ca7(long l, long l2) {
        return ULong.mc76128828a(l & l2);
    }

    @InlineOnly
    private static final long md3c7a56784(long l, long l2) {
        return ULong.mc76128828a(l | l2);
    }

    @InlineOnly
    private static final long mdb69643e6a(long l, long l2) {
        return ULong.mc76128828a(l ^ l2);
    }

    @InlineOnly
    private static final long m25b8b41237(long l) {
        return ULong.mc76128828a(l ^ 0xFFFFFFFFFFFFFFFFL);
    }

    @InlineOnly
    private static final byte m40a46d52f2(long l) {
        return (byte)l;
    }

    @InlineOnly
    private static final short m0a5a316646(long l) {
        return (short)l;
    }

    @InlineOnly
    private static final int mcac1aa58b6(long l) {
        return (int)l;
    }

    @InlineOnly
    private static final long mb75bd777f1(long l) {
        return l;
    }

    @InlineOnly
    private static final byte m824d5230b1(long l) {
        return UByte.m854efd65e6((byte)l);
    }

    @InlineOnly
    private static final short m0b8924aa5c(long l) {
        return UShort.m96ff20ce19((short)l);
    }

    @InlineOnly
    private static final int mc6bbff8739(long l) {
        return UInt.mb680b9b7ba((int)l);
    }

    @InlineOnly
    private static final long me9fdc73fac(long l) {
        return l;
    }

    @InlineOnly
    private static final float m43a6a881fb(long l) {
        return (float)UnsignedKt.ulongToDouble(l);
    }

    @InlineOnly
    private static final double ma9bfb6fbf1(long l) {
        return UnsignedKt.ulongToDouble(l);
    }

    @NotNull
    public static String mf9390bdacd(long l) {
        return UnsignedKt.ulongToString(l);
    }

    @NotNull
    public String toString() {
        return ULong.mf9390bdacd(this.data);
    }

    public static int mfb3831710e(long l) {
        return Long.hashCode(l);
    }

    public int hashCode() {
        return ULong.mfb3831710e(this.data);
    }

    public static boolean m37d12d5cc6(long l, Object object) {
        if (!(object instanceof ULong)) {
            return false;
        }
        long l2 = ((ULong)object).m8c33c6a73b();
        return l == l2;
    }

    public boolean equals(Object object) {
        return ULong.m37d12d5cc6(this.data, object);
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    private /* synthetic */ ULong(long l) {
        this.data = l;
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    public static long mc76128828a(long l) {
        return l;
    }

    public static final /* synthetic */ ULong ma7eeea8d7e(long l) {
        return new ULong(l);
    }

    public final /* synthetic */ long m8c33c6a73b() {
        return this.data;
    }

    public static final boolean mf7e41a7fbb(long l, long l2) {
        return l == l2;
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\n"}, d2={"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

