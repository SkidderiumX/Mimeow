/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtil {
    public static <T> T[] add(T[] TArray, T t) {
        int n = TArray.length;
        T[] TArray2 = Arrays.copyOf(TArray, n + 1);
        TArray2[n] = t;
        return TArray2;
    }

    @SafeVarargs
    public static <T> T[] add(T[] TArray, T ... TArray2) {
        int n = TArray.length;
        T[] TArray3 = Arrays.copyOf(TArray, n + TArray2.length);
        System.arraycopy(TArray2, 0, TArray3, n, TArray2.length);
        return TArray3;
    }

    public static <T> T[] remove(T[] TArray, int n) {
        T[] TArray2 = Arrays.copyOf(TArray, TArray.length - 1);
        System.arraycopy(TArray, n + 1, TArray2, n, TArray2.length - n);
        return TArray2;
    }

    public static Float[] boxedArray(float[] fArray) {
        Float[] floatArray = new Float[fArray.length];
        for (int i = 0; i < fArray.length; ++i) {
            floatArray[i] = Float.valueOf(fArray[i]);
        }
        return floatArray;
    }

    public static Integer[] boxedArray(int[] nArray) {
        Integer[] integerArray = new Integer[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            integerArray[i] = nArray[i];
        }
        return integerArray;
    }

    public static Boolean[] boxedArray(boolean[] blArray) {
        Boolean[] booleanArray = new Boolean[blArray.length];
        for (int i = 0; i < blArray.length; ++i) {
            booleanArray[i] = blArray[i];
        }
        return booleanArray;
    }

    public static String toString(Object object) {
        if (object == null || !object.getClass().isArray()) {
            return String.valueOf(object);
        }
        int n = Array.getLength(object);
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(Array.get(object, i));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

