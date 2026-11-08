/*
 * Decompiled with CFR 0.152.
 */
package kotlin;

import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
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
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#H\u00d6\u0003\u00a2\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010GJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010\u000fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010\u0012J\u001b\u0010J\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010\u001fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010\u0018J\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u0010\u000fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\u0012J\u001b\u0010O\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010\u001fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b\u00a2\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b\u00a2\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016\u00a2\u0006\u0004\bj\u0010kJ\u0016\u0010l\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bm\u0010\u0005J\u0016\u0010n\u001a\u00020\u0010H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bo\u0010-J\u0016\u0010p\u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bq\u0010cJ\u0016\u0010r\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bs\u0010gJ\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006w"}, d2={"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.5")
@WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
public class UByte
implements Comparable<UByte> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final byte data;
    public static final byte MIN_VALUE = 0;
    public static final byte MAX_VALUE = -1;
    public static final int SIZE_BYTES = 1;
    public static final int SIZE_BITS = 8;

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @InlineOnly
    private static int m008565bf17(byte by, byte by2) {
        return Intrinsics.compare(by & 0xFF, by2 & 0xFF);
    }

    @InlineOnly
    private int m6bf72861ef(byte by) {
        return Intrinsics.compare(this.mc2c6800511() & 0xFF, by & 0xFF);
    }

    @InlineOnly
    private static final int m6d472e66be(byte by, short s) {
        return Intrinsics.compare(by & 0xFF, s & 0xFFFF);
    }

    @InlineOnly
    private static final int m2fea0bca2a(byte by, int n) {
        return Integer.compareUnsigned(UInt.mb680b9b7ba(by & 0xFF), n);
    }

    @InlineOnly
    private static final int m9f2640a7fa(byte by, long l) {
        return Long.compareUnsigned(ULong.mc76128828a((long)by & 0xFFL), l);
    }

    @InlineOnly
    private static final int m8364bb739c(byte by, byte by2) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) + UInt.mb680b9b7ba(by2 & 0xFF));
    }

    @InlineOnly
    private static final int m272de0b639(byte by, short s) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) + UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int md4105bf1a3(byte by, int n) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) + n);
    }

    @InlineOnly
    private static final long m4cd03bfc34(byte by, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)by & 0xFFL) + l);
    }

    @InlineOnly
    private static final int m3aad280e1d(byte by, byte by2) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) - UInt.mb680b9b7ba(by2 & 0xFF));
    }

    @InlineOnly
    private static final int md7129e9292(byte by, short s) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) - UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int maf0b0de692(byte by, int n) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) - n);
    }

    @InlineOnly
    private static final long mefc592ed03(byte by, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)by & 0xFFL) - l);
    }

    @InlineOnly
    private static final int md47b76d550(byte by, byte by2) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) * UInt.mb680b9b7ba(by2 & 0xFF));
    }

    @InlineOnly
    private static final int m296fa60238(byte by, short s) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) * UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int m7b1a2c593a(byte by, int n) {
        return UInt.mb680b9b7ba(UInt.mb680b9b7ba(by & 0xFF) * n);
    }

    @InlineOnly
    private static final long mf45c6a5538(byte by, long l) {
        return ULong.mc76128828a(ULong.mc76128828a((long)by & 0xFFL) * l);
    }

    @InlineOnly
    private static final int m3d75fda7a5(byte by, byte by2) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(by2 & 0xFF));
    }

    @InlineOnly
    private static final int m5c835b3be2(byte by, short s) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int mf7267a08aa(byte by, int n) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(by & 0xFF), n);
    }

    @InlineOnly
    private static final long m21993cb066(byte by, long l) {
        return Long.divideUnsigned(ULong.mc76128828a((long)by & 0xFFL), l);
    }

    @InlineOnly
    private static final int md985ebe599(byte by, byte by2) {
        return Integer.remainderUnsigned(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(by2 & 0xFF));
    }

    @InlineOnly
    private static final int m62f41ac51b(byte by, short s) {
        return Integer.remainderUnsigned(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int m45e512fb20(byte by, int n) {
        return Integer.remainderUnsigned(UInt.mb680b9b7ba(by & 0xFF), n);
    }

    @InlineOnly
    private static final long m49f191398b(byte by, long l) {
        return Long.remainderUnsigned(ULong.mc76128828a((long)by & 0xFFL), l);
    }

    @InlineOnly
    private static final int m266de53967(byte by, byte by2) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(by2 & 0xFF));
    }

    @InlineOnly
    private static final int m0394212df1(byte by, short s) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(s & 0xFFFF));
    }

    @InlineOnly
    private static final int mf598283b6c(byte by, int n) {
        return Integer.divideUnsigned(UInt.mb680b9b7ba(by & 0xFF), n);
    }

    @InlineOnly
    private static final long m997278bf87(byte by, long l) {
        return Long.divideUnsigned(ULong.mc76128828a((long)by & 0xFFL), l);
    }

    @InlineOnly
    private static final byte m6fe3bb3249(byte by, byte by2) {
        return UByte.m854efd65e6((byte)Integer.remainderUnsigned(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(by2 & 0xFF)));
    }

    @InlineOnly
    private static final short ma2befd0a28(byte by, short s) {
        return UShort.m96ff20ce19((short)Integer.remainderUnsigned(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(s & 0xFFFF)));
    }

    @InlineOnly
    private static final int mcbc5149317(byte by, int n) {
        return Integer.remainderUnsigned(UInt.mb680b9b7ba(by & 0xFF), n);
    }

    @InlineOnly
    private static final long mbc70048490(byte by, long l) {
        return Long.remainderUnsigned(ULong.mc76128828a((long)by & 0xFFL), l);
    }

    @InlineOnly
    private static final byte m334c542b3e(byte by) {
        return UByte.m854efd65e6((byte)(by + 1));
    }

    @InlineOnly
    private static final byte m68eab0d9df(byte by) {
        return UByte.m854efd65e6((byte)(by + -1));
    }

    @InlineOnly
    private static final UIntRange md6e42e835e(byte by, byte by2) {
        return new UIntRange(UInt.mb680b9b7ba(by & 0xFF), UInt.mb680b9b7ba(by2 & 0xFF), null);
    }

    @SinceKotlin(version="1.9")
    @WasExperimental(markerClass={ExperimentalStdlibApi.class})
    @InlineOnly
    private static final UIntRange mdaedb2da38(byte by, byte by2) {
        return URangesKt.until$J1ME1BU((int)UInt.mb680b9b7ba(by & 0xFF), (int)UInt.mb680b9b7ba(by2 & 0xFF));
    }

    @InlineOnly
    private static final byte mab84c1e924(byte by, byte by2) {
        return UByte.m854efd65e6((byte)(by & by2));
    }

    @InlineOnly
    private static final byte m472040824a(byte by, byte by2) {
        return UByte.m854efd65e6((byte)(by | by2));
    }

    @InlineOnly
    private static final byte m545a5f9f24(byte by, byte by2) {
        return UByte.m854efd65e6((byte)(by ^ by2));
    }

    @InlineOnly
    private static final byte m5b7dfbb582(byte by) {
        return UByte.m854efd65e6(~by);
    }

    @InlineOnly
    private static final byte m02fbe51d12(byte by) {
        return by;
    }

    @InlineOnly
    private static final short m78259ba7b5(byte by) {
        return (short)((short)by & 0xFF);
    }

    @InlineOnly
    private static final int ma631dbd6a1(byte by) {
        return by & 0xFF;
    }

    @InlineOnly
    private static final long mc1aa9fa9b4(byte by) {
        return (long)by & 0xFFL;
    }

    @InlineOnly
    private static final byte ma8095c77e3(byte by) {
        return by;
    }

    @InlineOnly
    private static final short mb032c4a175(byte by) {
        return UShort.m96ff20ce19((short)((short)by & 0xFF));
    }

    @InlineOnly
    private static final int m483429ec8e(byte by) {
        return UInt.mb680b9b7ba(by & 0xFF);
    }

    @InlineOnly
    private static final long m0512604ef1(byte by) {
        return ULong.mc76128828a((long)by & 0xFFL);
    }

    @InlineOnly
    private static final float mc12f98ce1f(byte by) {
        return by & 0xFF;
    }

    @InlineOnly
    private static final double ma89aab7fd0(byte by) {
        return by & 0xFF;
    }

    @NotNull
    public static String m6c60473116(byte by) {
        return String.valueOf(by & 0xFF);
    }

    @NotNull
    public String toString() {
        return UByte.m6c60473116(this.data);
    }

    public static int m2cc2008f90(byte by) {
        return Byte.hashCode(by);
    }

    public int hashCode() {
        return UByte.m2cc2008f90(this.data);
    }

    public static boolean m2ebd6787a3(byte by, Object object) {
        if (!(object instanceof UByte)) {
            return false;
        }
        byte by2 = ((UByte)object).mc2c6800511();
        return by == by2;
    }

    public boolean equals(Object object) {
        return UByte.m2ebd6787a3(this.data, object);
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    private /* synthetic */ UByte(byte by) {
        this.data = by;
    }

    @IntrinsicConstEvaluation
    @PublishedApi
    public static byte m854efd65e6(byte by) {
        return by;
    }

    public static final /* synthetic */ UByte me30452dd28(byte by) {
        return new UByte(by);
    }

    public final /* synthetic */ byte mc2c6800511() {
        return this.data;
    }

    public static final boolean m907c2be379(byte by, byte by2) {
        return by == by2;
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\n"}, d2={"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

