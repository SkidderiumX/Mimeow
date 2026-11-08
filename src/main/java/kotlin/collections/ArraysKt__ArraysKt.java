package kotlin.collections;

import kotlin.jvm.internal.*;
import kotlin.internal.*;
import kotlin.jvm.functions.*;
import org.jetbrains.annotations.*;
import java.util.*;
import kotlin.collections.unsigned.*;
import kotlin.*;
import kotlin.jvm.*;
import kotlin.ranges.*;

@Metadata(mv = { 1, 9, 0 }, k = 5, xi = 49, d1 = { "\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\"" }, d2 = { "contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib" }, xs = "kotlin/collections/ArraysKt")
@SourceDebugExtension({ "SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n" })
public class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt
{
    @NotNull
    public static final <T> List<T> flatten(@NotNull final T[][] array) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        final Object[] array2 = array;
        int initialCapacity = 0;
        for (int i = 0; i < array2.length; ++i) {
            initialCapacity += ((Object[])array2[i]).length;
        }
        final ArrayList list = new ArrayList<Object>(initialCapacity);
        for (int j = 0; j < array.length; ++j) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>)list, array[j]);
        }
        return (List<T>)list;
    }
    
    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull final Pair<? extends T, ? extends R>[] array) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        final ArrayList list = new ArrayList(array.length);
        final ArrayList list2 = new ArrayList(array.length);
        for (int i = 0; i < array.length; ++i) {
            final Pair<? extends T, ? extends R> pair = array[i];
            list.add(pair.getFirst());
            list2.add(pair.getSecond());
        }
        return (Pair<List<T>, List<R>>)TuplesKt.mcc4e6a6012(list, list2);
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean isNullOrEmpty(final Object[] array) {
        return array == null || array.length == 0;
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends Object[] & R, R> R ifEmpty(final C c, final Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return (c.length == 0) ? function0.invoke() : c;
    }
    
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static final <T> boolean contentDeepEquals(@Nullable final T[] array, @Nullable final T[] array2) {
        if (array == array2) {
            return true;
        }
        if (array == null || array2 == null || array.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            final T t = array[i];
            final T t2 = array2[i];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return false;
                }
                if (t instanceof Object[] && t2 instanceof Object[]) {
                    if (!contentDeepEquals((T[])(Object)t, (Object[])(T[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof byte[] && t2 instanceof byte[]) {
                    if (!Arrays.equals((byte[])(Object)t, (byte[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof short[] && t2 instanceof short[]) {
                    if (!Arrays.equals((short[])(Object)t, (short[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof int[] && t2 instanceof int[]) {
                    if (!Arrays.equals((int[])(Object)t, (int[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof long[] && t2 instanceof long[]) {
                    if (!Arrays.equals((long[])(Object)t, (long[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof float[] && t2 instanceof float[]) {
                    if (!Arrays.equals((float[])(Object)t, (float[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof double[] && t2 instanceof double[]) {
                    if (!Arrays.equals((double[])(Object)t, (double[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof char[] && t2 instanceof char[]) {
                    if (!Arrays.equals((char[])(Object)t, (char[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof boolean[] && t2 instanceof boolean[]) {
                    if (!Arrays.equals((boolean[])(Object)t, (boolean[])(Object)t2)) {
                        return false;
                    }
                }
                else if (t instanceof UByteArray && t2 instanceof UByteArray) {
                    if (!  UArraysKt.m6b633bcf83(((UByteArray)t).m5c6d3deafc(), ((UByteArray)t2).m5c6d3deafc())) {
                        return false;
                    }
                }
                else if (t instanceof UShortArray && t2 instanceof UShortArray) {
                    if (!  UArraysKt.m2f45300f3d(((UShortArray)t).m768f72efb9(), ((UShortArray)t2).m768f72efb9())) {
                        return false;
                    }
                }
                else if (t instanceof UIntArray && t2 instanceof UIntArray) {
                    if (!  UArraysKt.mdb98d3f468(((UIntArray)t).m07deda94de(), ((UIntArray)t2).m07deda94de())) {
                        return false;
                    }
                }
                else if (t instanceof ULongArray && t2 instanceof ULongArray) {
                    if (!  UArraysKt.m00d9a4e5ed(((ULongArray)t).mdcf8310d10(), ((ULongArray)t2).mdcf8310d10())) {
                        return false;
                    }
                }
                else if (!Intrinsics.areEqual(t, t2)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepToString")
    @NotNull
    public static final <T> String contentDeepToString(@Nullable final T[] array) {
        if (array == null) {
            return "null";
        }
        final StringBuilder sb = new StringBuilder(RangesKt___RangesKt.coerceAtMost(array.length, 429496729) * 5 + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(array, sb, new ArrayList<Object[]>());
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).\u2026builderAction).toString()");
        return string;
    }
    
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(final T[] array, final StringBuilder sb, final List<Object[]> list) {
        if (list.contains(array)) {
            sb.append("[...]");
            return;
        }
        list.add(array);
        sb.append('[');
        for (int i = 0; i < array.length; ++i) {
            if (i != 0) {
                sb.append(", ");
            }
            final T t2;
            final T t = t2 = array[i];
            if (t2 == null) {
                sb.append("null");
            }
            else if (t2 instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt((Object[])(T[])(Object)t, sb, list);
            }
            else if (t2 instanceof byte[]) {
                final String string = Arrays.toString((byte[])(Object)t);
                Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
                sb.append(string);
            }
            else if (t2 instanceof short[]) {
                final String string2 = Arrays.toString((short[])(Object)t);
                Intrinsics.checkNotNullExpressionValue(string2, "toString(this)");
                sb.append(string2);
            }
            else if (t2 instanceof int[]) {
                final String string3 = Arrays.toString((int[])(Object)t);
                Intrinsics.checkNotNullExpressionValue(string3, "toString(this)");
                sb.append(string3);
            }
            else if (t2 instanceof long[]) {
                final String string4 = Arrays.toString((long[])(Object)t);
                Intrinsics.checkNotNullExpressionValue(string4, "toString(this)");
                sb.append(string4);
            }
            else if (t2 instanceof float[]) {
                final String string5 = Arrays.toString((float[])(Object)t);
                Intrinsics.checkNotNullExpressionValue(string5, "toString(this)");
                sb.append(string5);
            }
            else if (t2 instanceof double[]) {
                final String string6 = Arrays.toString((double[])(Object)t);
                Intrinsics.checkNotNullExpressionValue(string6, "toString(this)");
                sb.append(string6);
            }
            else if (t2 instanceof char[]) {
                final String string7 = Arrays.toString((char[])(Object)t);
                Intrinsics.checkNotNullExpressionValue(string7, "toString(this)");
                sb.append(string7);
            }
            else if (t2 instanceof boolean[]) {
                final String string8 = Arrays.toString((boolean[])(Object)t);
                Intrinsics.checkNotNullExpressionValue(string8, "toString(this)");
                sb.append(string8);
            }
            else if (t2 instanceof UByteArray) {
                final UByteArray uByteArray = (UByteArray)t;
                sb.append(UArraysKt.m43fe7d5dd6((byte[])((uByteArray != null) ? uByteArray.m5c6d3deafc() : null)));
            }
            else if (t2 instanceof UShortArray) {
                final UShortArray uShortArray = (UShortArray)t;
                sb.append(UArraysKt.m25980594ae((short[])((uShortArray != null) ? uShortArray.m768f72efb9() : null)));
            }
            else if (t2 instanceof UIntArray) {
                final UIntArray uIntArray = (UIntArray)t;
                sb.append(UArraysKt.m9ba0f8a771((int[])((uIntArray != null) ? uIntArray.m07deda94de() : null)));
            }
            else if (t2 instanceof ULongArray) {
                final ULongArray uLongArray = (ULongArray)t;
                sb.append(UArraysKt.mf27ffc423a((long[])((uLongArray != null) ? uLongArray.mdcf8310d10() : null)));
            }
            else {
                sb.append(t.toString());
            }
        }
        sb.append(']');
        list.remove(CollectionsKt__CollectionsKt.getLastIndex((List<?>)list));
    }
}
