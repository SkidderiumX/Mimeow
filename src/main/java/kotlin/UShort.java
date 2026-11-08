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
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import org.jetbrains.annotations.NotNull;

@JvmInline
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#H\u00d6\u0003\u00a2\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010GJ\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010\u0010J\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010\u0013J\u001b\u0010J\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010\u001fJ\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010\u0018J\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u0010\u0010J\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\u0013J\u001b\u0010O\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010\u001fJ\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020UH\u0087\b\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b\u00a2\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020]H\u0087\b\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\ba\u0010-J\u0010\u0010b\u001a\u00020cH\u0087\b\u00a2\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bg\u0010\u0005J\u000f\u0010h\u001a\u00020iH\u0016\u00a2\u0006\u0004\bj\u0010kJ\u0016\u0010l\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bm\u0010WJ\u0016\u0010n\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bo\u0010-J\u0016\u0010p\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bq\u0010eJ\u0016\u0010r\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bs\u0010\u0005J\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006w"}, d2={"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.5")
@WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
public class UShort
implements Comparable<UShort> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final short data;
    public static final short MIN_VALUE = 0;
    public static final short MAX_VALUE = -1;
    public static final int SIZE_BYTES = 2;
    public static final int SIZE_BITS = 16;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @InlineOnly
    private static final int mdefc618e6b(short s, byte by) {
        return Intrinsics.compare(s & 0xFFFF, by & 0xFF);
    }

    @InlineOnly
    private static int me02c174d3c(short s, short s2) {
        return Intrinsics.compare(s & 0xFFFF, s2 & 0xFFFF);
    }

    @InlineOnly
    private int mb53994a206(short s) {
        return Intrinsics.compare(this.m0dfe878ce1() & 0xFFFF, s & 0xFFFF);
    }

    @InlineOnly
    private static final int m029011bc12(short s, int n) {
        return Integer.compareUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), n);
    }

    @InlineOnly
    private static final int mbe179f3c4a(short s, long l) {
        return Long.compareUnsigned(ULong.mc76128828a((long)s & 0xFFFFL), l);
    }

    @InlineOnly
    private static final int md90e6eb74f(short s, byte by) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) + UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int mcc5c90c57c(short s, short s2) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) + UInt.mb680b9b7ba(s2 & 0xFFFF));
    }

    @InlineOnly
    private static final int m7dab687b31(short s, int n) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) + n);
    }

    @InlineOnly
    private static final long m62f79a6898(short s, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)s & 0xFFFFL) + l);
    }

    @InlineOnly
    private static final int m746fa4ec0e(short s, byte by) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) - UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int m6f6b29f223(short s, short s2) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) - UInt.mb680b9b7ba(s2 & 0xFFFF));
    }

    @InlineOnly
    private static final int m96076fc8d1(short s, int n) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) - n);
    }

    @InlineOnly
    private static final long mf3c61b2ee0(short s, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)s & 0xFFFFL) - l);
    }

    @InlineOnly
    private static final int me154283fc4(short s, byte by) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) * UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int meb09807574(short s, short s2) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) * UInt.mb680b9b7ba(s2 & 0xFFFF));
    }

    @InlineOnly
    private static final int m6538356b1c(short s, int n) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(s & 0xFFFF) * n);
    }

    @InlineOnly
    private static final long me124aaf1c1(short s, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)s & 0xFFFFL) * l);
    }

    @InlineOnly
    private static final int m5adbd2c795(short s, byte by) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int md14337f89c(short s, short s2) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(s2 & 0xFFFF));
    }

    @InlineOnly
    private static final int m79e181f5c3(short s, int n) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), n);
    }

    @InlineOnly
    private static final long m88948b74c5(short s, long l) {
        return Long.divideUnsigned(ULong.mc76128828a((long)s & 0xFFFFL), l);
    }

    @InlineOnly
    private static final int m2bab6b3e67(short s, byte by) {
        return Integer.remainderUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int m0a9491bc1d(short s, short s2) {
        return Integer.remainderUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(s2 & 0xFFFF));
    }

    @InlineOnly
    private static final int m7506766409(short s, int n) {
        return Integer.remainderUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), n);
    }

    @InlineOnly
    private static final long mc08b88bd48(short s, long l) {
        return Long.remainderUnsigned(ULong.mc76128828a((long)s & 0xFFFFL), l);
    }

    @InlineOnly
    private static final int m9eefa4e9e4(short s, byte by) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(by & 0xFF));
    }

    @InlineOnly
    private static final int m6d7e66f4fd(short s, short s2) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(s2 & 0xFFFF));
    }

    @InlineOnly
    private static final int m8abf43f141(short s, int n) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), n);
    }

    @InlineOnly
    private static final long ma4bf301470(short s, long l) {
        return Long.divideUnsigned(ULong.mc76128828a((long)s & 0xFFFFL), l);
    }

    @InlineOnly
    private static final byte mdd2d9cec93(short s, byte by) {
        return UByte.m854efd65e6((byte)Integer.remainderUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(by & 0xFF)));
    }

    @InlineOnly
    private static final short mc20d9a33f7(short s, short s2) {
        return UShort.m96ff20ce19((short)Integer.remainderUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(s2 & 0xFFFF)));
    }

    @InlineOnly
    private static final int m6846919514(short s, int n) {
        return Integer.remainderUnsigned(UInt.mb680b9b7ba(s & 0xFFFF), n);
    }

    @InlineOnly
    private static final long m76b62bba06(short s, long l) {
        return Long.remainderUnsigned(ULong.mc76128828a((long)s & 0xFFFFL), l);
    }

    @InlineOnly
    private static final short mcb34411728(short s) {
        return UShort.m96ff20ce19((short)(s + 1));
    }

    @InlineOnly
    private static final short m713df2e0f8(short s) {
        return UShort.m96ff20ce19((short)(s + -1));
    }

    @InlineOnly
    private static final UIntRange m980c38db67(short s, short s2) {
        return new UIntRange(UInt.mb680b9b7ba(s & 0xFFFF), UInt.mb680b9b7ba(s2 & 0xFFFF), null);
    }

    @SinceKotlin(version="1.9")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    @InlineOnly
    private static final UIntRange m9cfae58165(short s, short s2) {
        return URangesKt.until$J1ME1BU((int)UInt.mb680b9b7ba(s & 0xFFFF), (int)UInt.mb680b9b7ba(s2 & 0xFFFF));
    }

    @InlineOnly
    private static final short m20301d458d(short s, short s2) {
        return UShort.m96ff20ce19((short)(s & s2));
    }

    @InlineOnly
    private static final short m5dc5340675(short s, short s2) {
        return UShort.m96ff20ce19((short)(s | s2));
    }

    @InlineOnly
    private static final short m51a3cfaec0(short s, short s2) {
        return UShort.m96ff20ce19((short)(s ^ s2));
    }

    @InlineOnly
    private static final short m1ddca7eb6c(short s) {
        return UShort.m96ff20ce19(~s);
    }

    @InlineOnly
    private static final byte m60886ad295(short s) {
        return (byte)s;
    }

    @InlineOnly
    private static final short mabec14b109(short s) {
        return s;
    }

    @InlineOnly
    private static final int m182cc1c46d(short s) {
        return s & 0xFFFF;
    }

    @InlineOnly
    private static final long m2ddad21b7a(short s) {
        return (long)s & 0xFFFFL;
    }

    @InlineOnly
    private static final byte mc3f4c7a479(short s) {
        return UByte.m854efd65e6((byte)s);
    }

    @InlineOnly
    private static final short m4fb14fac39(short s) {
        return s;
    }

    @InlineOnly
    private static final int m375f5b29e5(short s) {
        return UInt.mb680b9b7ba(s & 0xFFFF);
    }

    @InlineOnly
    private static final long md037122575(short s) {
        return ULong.mc76128828a((long)s & 0xFFFFL);
    }

    @InlineOnly
    private static final float m22112a022a(short s) {
        return s & 0xFFFF;
    }

    @InlineOnly
    private static final double m3d7a497532(short s) {
        return s & 0xFFFF;
    }

    @NotNull
    public static String m433139e0ad(short s) {
        return String.valueOf(s & 0xFFFF);
    }

    @NotNull
    public String toString() {
        return UShort.m433139e0ad(this.data);
    }

    public static int m71b99b3f1c(short s) {
        return Short.hashCode(s);
    }

    public int hashCode() {
        return UShort.m71b99b3f1c(this.data);
    }

    public static boolean m82fac9c0fb(short s, Object object) {
        if (!(object instanceof UShort)) {
            return false;
        }
        short s2 = ((UShort)object).m0dfe878ce1();
        return s == s2;
    }

    public boolean equals(Object object) {
        return UShort.m82fac9c0fb(this.data, object);
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    public static short m96ff20ce19(short s) {
        return s;
    }

    public static final /* synthetic */ UShort md68ce5e29d(short s) {
        return new UShort(s);
    }

    public final /* synthetic */ short m0dfe878ce1() {
        return this.data;
    }

    public static final boolean m3ff7e75705(short s, short s2) {
        return s == s2;
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\n"}, d2={"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

