package kotlin.collections.unsigned;

import kotlin.jvm.internal.*;
import kotlin.internal.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.functions.*;
import kotlin.ranges.*;
import kotlin.collections.*;
import java.util.*;
import kotlin.*;
import kotlin.jvm.*;
import java.math.*;

@Metadata(mv = { 1, 9, 0 }, k = 5, xi = 49, d1 = { "\u0000h\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b0\u00101\u001a@\u00102\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b7\u00108\u001a@\u00102\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a@\u00102\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a@\u00102\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a4\u0010?\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a4\u0010?\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a4\u0010?\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a4\u0010?\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007\u00f8\u0001\u0000¢\u0006\u0004\bL\u0010+\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007\u00f8\u0001\u0000¢\u0006\u0004\bM\u0010-\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bN\u0010/\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bO\u00101\u001a@\u0010P\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a@\u0010P\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a@\u0010P\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a@\u0010P\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a4\u0010U\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bV\u0010D\u001a4\u0010U\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bW\u0010F\u001a4\u0010U\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bX\u0010H\u001a4\u0010U\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bY\u0010J\u001a.\u0010Z\u001a\u00020[*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020[06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a.\u0010Z\u001a\u00020^*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020^06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a.\u0010Z\u001a\u00020[*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020[06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\\\u0010a\u001a.\u0010Z\u001a\u00020^*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020^06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010b\u001a.\u0010Z\u001a\u00020[*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\\\u0010c\u001a.\u0010Z\u001a\u00020^*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010d\u001a.\u0010Z\u001a\u00020[*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020[06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\\\u0010e\u001a.\u0010Z\u001a\u00020^*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020^06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006g" }, d2 = { "asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "max", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min-GBYM_sE", "min--ajY-9A", "min-QwZRm1k", "min-rL5Bavg", "minBy", "minBy-JOV_ifY", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-xTcfx_M", "minWith", "minWith-XMRcp5o", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib" }, xs = "kotlin/collections/unsigned/UArraysKt", pn = "kotlin.collections")
public class UArraysKt___UArraysJvmKt
{
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int ma7a4576ec1(final int[] array, final int n) {
        Intrinsics.checkNotNullParameter(array, "$this$elementAt");
        return UIntArray.mbcec8b6d58(array, n);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long m9a6aadeb9a(final long[] array, final int n) {
        Intrinsics.checkNotNullParameter(array, "$this$elementAt");
        return ULongArray.mc20eb45c93(array, n);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte m07102ec172(final byte[] array, final int n) {
        Intrinsics.checkNotNullParameter(array, "$this$elementAt");
        return UByteArray.m0b2ab7f5bf(array, n);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short m1ace9069db(final short[] array, final int n) {
        Intrinsics.checkNotNullParameter(array, "$this$elementAt");
        return UShortArray.me287ce0640(array, n);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<UInt> m68c1fb0ccd(@NotNull final int[] array) {
        Intrinsics.checkNotNullParameter(array, "$this$asList");
        return (List<UInt>)new UArraysKt___UArraysJvmKt$asList.UArraysKt___UArraysJvmKt$asList$1(array);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<ULong> mbfe77ffcfa(@NotNull final long[] array) {
        Intrinsics.checkNotNullParameter(array, "$this$asList");
        return (List<ULong>)new UArraysKt___UArraysJvmKt$asList.UArraysKt___UArraysJvmKt$asList$2(array);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<UByte> mde08b903dc(@NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(array, "$this$asList");
        return (List<UByte>)new UArraysKt___UArraysJvmKt$asList.UArraysKt___UArraysJvmKt$asList$3(array);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<UShort> mf8ca49a4ec(@NotNull final short[] array) {
        Intrinsics.checkNotNullParameter(array, "$this$asList");
        return (List<UShort>)new UArraysKt___UArraysJvmKt$asList.UArraysKt___UArraysJvmKt$asList$4(array);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int m65c206fdb5(@NotNull final int[] array, final int n, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(array, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n2, n3, UIntArray.m0ceafd2280(array));
        int i = n2;
        int n4 = n3 - 1;
        while (i <= n4) {
            final int n5 = i + n4 >>> 1;
            final int uintCompare = UnsignedKt.uintCompare(array[n5], n);
            if (uintCompare < 0) {
                i = n5 + 1;
            }
            else {
                if (uintCompare <= 0) {
                    return n5;
                }
                n4 = n5 - 1;
            }
        }
        return -(i + 1);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int m5249891ff1(@NotNull final long[] array, final long n, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(array, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n2, n3, ULongArray.m23e36e6a11(array));
        int i = n2;
        int n4 = n3 - 1;
        while (i <= n4) {
            final int n5 = i + n4 >>> 1;
            final int ulongCompare = UnsignedKt.ulongCompare(array[n5], n);
            if (ulongCompare < 0) {
                i = n5 + 1;
            }
            else {
                if (ulongCompare <= 0) {
                    return n5;
                }
                n4 = n5 - 1;
            }
        }
        return -(i + 1);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int m176fd2d402(@NotNull final byte[] array, final byte b, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(array, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n, n2, UByteArray.m383afec9cb(array));
        final int n3 = b & 0xFF;
        int i = n;
        int n4 = n2 - 1;
        while (i <= n4) {
            final int n5 = i + n4 >>> 1;
            final int uintCompare = UnsignedKt.uintCompare(array[n5], n3);
            if (uintCompare < 0) {
                i = n5 + 1;
            }
            else {
                if (uintCompare <= 0) {
                    return n5;
                }
                n4 = n5 - 1;
            }
        }
        return -(i + 1);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int ma7e572bc8e(@NotNull final short[] array, final short n, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(array, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(n2, n3, UShortArray.m70c7c61d51(array));
        final int n4 = n & 0xFFFF;
        int i = n2;
        int n5 = n3 - 1;
        while (i <= n5) {
            final int n6 = i + n5 >>> 1;
            final int uintCompare = UnsignedKt.uintCompare(array[n6], n4);
            if (uintCompare < 0) {
                i = n6 + 1;
            }
            else {
                if (uintCompare <= 0) {
                    return n6;
                }
                n5 = n6 - 1;
            }
        }
        return -(i + 1);
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final int[] array, final Function1<? super UInt, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(array, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal bigDecimal = value;
        for (int i = 0; i < UIntArray.m0ceafd2280(array); ++i) {
            final BigDecimal add = bigDecimal.add((BigDecimal)function1.invoke(UInt.m3f97684bd0(UIntArray.mbcec8b6d58(array, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            bigDecimal = add;
        }
        return bigDecimal;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final long[] array, final Function1<? super ULong, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(array, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal bigDecimal = value;
        for (int i = 0; i < ULongArray.m23e36e6a11(array); ++i) {
            final BigDecimal add = bigDecimal.add((BigDecimal)function1.invoke(ULong.ma7eeea8d7e(ULongArray.mc20eb45c93(array, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            bigDecimal = add;
        }
        return bigDecimal;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final byte[] array, final Function1<? super UByte, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(array, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal bigDecimal = value;
        for (int i = 0; i < UByteArray.m383afec9cb(array); ++i) {
            final BigDecimal add = bigDecimal.add((BigDecimal)function1.invoke(UByte.me30452dd28(UByteArray.m0b2ab7f5bf(array, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            bigDecimal = add;
        }
        return bigDecimal;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final short[] array, final Function1<? super UShort, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(array, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal bigDecimal = value;
        for (int i = 0; i < UShortArray.m70c7c61d51(array); ++i) {
            final BigDecimal add = bigDecimal.add((BigDecimal)function1.invoke(UShort.md68ce5e29d(UShortArray.me287ce0640(array, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            bigDecimal = add;
        }
        return bigDecimal;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final int[] array, final Function1<? super UInt, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(array, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger bigInteger = value;
        for (int i = 0; i < UIntArray.m0ceafd2280(array); ++i) {
            final BigInteger add = bigInteger.add((BigInteger)function1.invoke(UInt.m3f97684bd0(UIntArray.mbcec8b6d58(array, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            bigInteger = add;
        }
        return bigInteger;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final long[] array, final Function1<? super ULong, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(array, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger bigInteger = value;
        for (int i = 0; i < ULongArray.m23e36e6a11(array); ++i) {
            final BigInteger add = bigInteger.add((BigInteger)function1.invoke(ULong.ma7eeea8d7e(ULongArray.mc20eb45c93(array, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            bigInteger = add;
        }
        return bigInteger;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final byte[] array, final Function1<? super UByte, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(array, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger bigInteger = value;
        for (int i = 0; i < UByteArray.m383afec9cb(array); ++i) {
            final BigInteger add = bigInteger.add((BigInteger)function1.invoke(UByte.me30452dd28(UByteArray.m0b2ab7f5bf(array, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            bigInteger = add;
        }
        return bigInteger;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final short[] array, final Function1<? super UShort, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(array, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger bigInteger = value;
        for (int i = 0; i < UShortArray.m70c7c61d51(array); ++i) {
            final BigInteger add = bigInteger.add((BigInteger)function1.invoke(UShort.md68ce5e29d(UShortArray.me287ce0640(array, i))));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            bigInteger = add;
        }
        return bigInteger;
    }
}
