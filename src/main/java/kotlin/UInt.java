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
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import org.jetbrains.annotations.NotNull;

@JvmInline
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!H\u00d6\u0003\u00a2\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003H\u00d6\u0001\u00a2\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bG\u0010EJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010\u000bJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010\u001dJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010\u0016J\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\f\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\u000bJ\u001e\u0010P\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\f\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\u000bJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010\u000fJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u0010\u000bJ\u001b\u0010R\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bU\u0010\u001dJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bV\u0010\u0016J\u0010\u0010W\u001a\u00020XH\u0087\b\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\\H\u0087\b\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u00020`H\u0087\b\u00a2\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bd\u0010\u0005J\u0010\u0010e\u001a\u00020fH\u0087\b\u00a2\u0006\u0004\bg\u0010hJ\u0010\u0010i\u001a\u00020jH\u0087\b\u00a2\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020nH\u0016\u00a2\u0006\u0004\bo\u0010pJ\u0016\u0010q\u001a\u00020\rH\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\br\u0010ZJ\u0016\u0010s\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bt\u0010\u0005J\u0016\u0010u\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bv\u0010hJ\u0016\u0010w\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bx\u0010lJ\u001b\u0010y\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bz\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006|"}, d2={"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.5")
@WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
public class UInt
implements Comparable<UInt> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int data;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = -1;
    public static final int SIZE_BYTES = 4;
    public static final int SIZE_BITS = 32;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @InlineOnly
    private static final int m9c75d142ce(int n, byte by) {
        return Integer.compareUnsigned(n, UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int m55c317b575(int n, short s) {
        return Integer.compareUnsigned(n, UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static int mb6d1d672ff(int n, int n2) {
        return UnsignedKt.uintCompare(n, n2);
    }

    @InlineOnly
    private int mf5bfe75b16(int n) {
        return UnsignedKt.uintCompare(this.md975fdc550(), n);
    }

    @InlineOnly
    private static final int m3ef2d5a278(int n, long l) {
        return Long.compareUnsigned(ULong.mc76128828a((long)n & 0xFFFFFFFFL), l);
    }

    @InlineOnly
    private static final int meeb6df0e15(int n, byte by) {
        return UInt.mb680b9b7ba(n + UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int m6751d6996d(int n, short s) {
        return UInt.mb680b9b7ba(n + UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int md9e1e1b667(int n, int n2) {
        return UInt.mb680b9b7ba(n + n2);
    }

    @InlineOnly
    private static final long mb4884a2114(int n, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)n & 0xFFFFFFFFL) + l);
    }

    @InlineOnly
    private static final int md579cb9fab(int n, byte by) {
        return UInt.mb680b9b7ba(n - UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int md27acd7579(int n, short s) {
        return UInt.mb680b9b7ba(n - UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int m84f31a4857(int n, int n2) {
        return UInt.mb680b9b7ba(n - n2);
    }

    @InlineOnly
    private static final long m613064dba5(int n, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)n & 0xFFFFFFFFL) - l);
    }

    @InlineOnly
    private static final int m2bd2bf1542(int n, byte by) {
        return UInt.mb680b9b7ba(n * UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int m17d5ddcfe0(int n, short s) {
        return UInt.mb680b9b7ba(n * UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int m8084ad7207(int n, int n2) {
        return UInt.mb680b9b7ba(n * n2);
    }

    @InlineOnly
    private static final long mf03f7920b9(int n, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)n & 0xFFFFFFFFL) * l);
    }

    @InlineOnly
    private static final int m2c836f47dc(int n, byte by) {
        return Integer.divideUnsigned(n, UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int ma071ab6eef(int n, short s) {
        return Integer.divideUnsigned(n, UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int m77d4bca2bd(int n, int n2) {
        return UnsignedKt.mf567cda180(n, n2);
    }

    @InlineOnly
    private static final long me52d608346(int n, long l) {
        return Long.divideUnsigned(ULong.mc76128828a((long)n & 0xFFFFFFFFL), l);
    }

    @InlineOnly
    private static final int ma38abadaa4(int n, byte by) {
        return Integer.remainderUnsigned(n, UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int m8af07fe914(int n, short s) {
        return Integer.remainderUnsigned(n, UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int m54e5b14e65(int n, int n2) {
        return UnsignedKt.m210dbbec7f(n, n2);
    }

    @InlineOnly
    private static final long mecc00a3939(int n, long l) {
        return Long.remainderUnsigned(ULong.mc76128828a((long)n & 0xFFFFFFFFL), l);
    }

    @InlineOnly
    private static final int ma9c002c4ba(int n, byte by) {
        return Integer.divideUnsigned(n, UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int m7cb9e112d6(int n, short s) {
        return Integer.divideUnsigned(n, UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int m98cf2046fa(int n, int n2) {
        return Integer.divideUnsigned(n, n2);
    }

    @InlineOnly
    private static final long m4be6dc5a69(int n, long l) {
        return Long.divideUnsigned(ULong.mc76128828a((long)n & 0xFFFFFFFFL), l);
    }

    @InlineOnly
    private static final byte m2dbe9e4c45(int n, byte by) {
        return UByte.m854efd65e6((byte)Integer.remainderUnsigned(n, UInt.mb680b9b7ba(by & 0xFF)));
    }

    @InlineOnly
    private static final short m529a5f5eca(int n, short s) {
        return UShort.m96ff20ce19((short)Integer.remainderUnsigned(n, UInt.mb680b9b7ba(s & 0xFFFF)));
    }

    @InlineOnly
    private static final int m3a38f7ed76(int n, int n2) {
        return Integer.remainderUnsigned(n, n2);
    }

    @InlineOnly
    private static final long m53e95f63b3(int n, long l) {
        return Long.remainderUnsigned(ULong.mc76128828a((long)n & 0xFFFFFFFFL), l);
    }

    @InlineOnly
    private static final int m6e7e64fb48(int n) {
        return UInt.mb680b9b7ba(n + 1);
    }

    @InlineOnly
    private static final int mc2afd76bfa(int n) {
        return UInt.mb680b9b7ba(n + -1);
    }

    @InlineOnly
    private static final UIntRange m4103eb2219(int n, int n2) {
        return new UIntRange(n, n2, null);
    }

    @SinceKotlin(version="1.9")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    @InlineOnly
    private static final UIntRange m86041dfa7f(int n, int n2) {
        return URangesKt.until$J1ME1BU((int)n, (int)n2);
    }

    @InlineOnly
    private static final int m345c9aad28(int n, int n2) {
        return UInt.mb680b9b7ba(n << n2);
    }

    @InlineOnly
    private static final int mcb60830813(int n, int n2) {
        return UInt.mb680b9b7ba(n >>> n2);
    }

    @InlineOnly
    private static final int m314fb9e49c(int n, int n2) {
        return UInt.mb680b9b7ba(n & n2);
    }

    @InlineOnly
    private static final int mf37e829c44(int n, int n2) {
        return UInt.mb680b9b7ba(n | n2);
    }

    @InlineOnly
    private static final int mc2c90d9426(int n, int n2) {
        return UInt.mb680b9b7ba(n ^ n2);
    }

    @InlineOnly
    private static final int ma880ebaf59(int n) {
        return UInt.mb680b9b7ba(~n);
    }

    @InlineOnly
    private static final byte m738bd4c99c(int n) {
        return (byte)n;
    }

    @InlineOnly
    private static final short mb4bd9d1c40(int n) {
        return (short)n;
    }

    @InlineOnly
    private static final int m9a6687ab69(int n) {
        return n;
    }

    @InlineOnly
    private static final long m9b79c993ed(int n) {
        return (long)n & 0xFFFFFFFFL;
    }

    @InlineOnly
    private static final byte m100924ea56(int n) {
        return UByte.m854efd65e6((byte)n);
    }

    @InlineOnly
    private static final short m6891ee728f(int n) {
        return UShort.m96ff20ce19((short)n);
    }

    @InlineOnly
    private static final int mefdb072d02(int n) {
        return n;
    }

    @InlineOnly
    private static final long m8ff7a26c40(int n) {
        return ULong.mc76128828a((long)n & 0xFFFFFFFFL);
    }

    @InlineOnly
    private static final float mea0ffde73a(int n) {
        return (float)UnsignedKt.uintToDouble(n);
    }

    @InlineOnly
    private static final double mb8542bb9e3(int n) {
        return UnsignedKt.uintToDouble(n);
    }

    @NotNull
    public static String m7ea9a3e0e8(int n) {
        return String.valueOf((long)n & 0xFFFFFFFFL);
    }

    @NotNull
    public String toString() {
        return UInt.m7ea9a3e0e8(this.data);
    }

    public static int mfe6c2a1f8c(int n) {
        return Integer.hashCode(n);
    }

    public int hashCode() {
        return UInt.mfe6c2a1f8c(this.data);
    }

    public static boolean mf3b32ff6db(int n, Object object) {
        if (!(object instanceof UInt)) {
            return false;
        }
        int n2 = ((UInt)object).md975fdc550();
        return n == n2;
    }

    public boolean equals(Object object) {
        return UInt.mf3b32ff6db(this.data, object);
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    private /* synthetic */ UInt(int n) {
        this.data = n;
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    public static int mb680b9b7ba(int n) {
        return n;
    }

    public static final /* synthetic */ UInt m3f97684bd0(int n) {
        return new UInt(n);
    }

    public final /* synthetic */ int md975fdc550() {
        return this.data;
    }

    public static final boolean mb10456f9c9(int n, int n2) {
        return n == n2;
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\n"}, d2={"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

