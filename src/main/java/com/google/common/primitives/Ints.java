/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated=true)
public class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 0x40000000;
    private static final byte[] asciiDigits;

    private Ints() {
    }

    public static int hashCode(int n) {
        return n;
    }

    public static int checkedCast(long l) {
        int n = (int)l;
        if ((long)n != l) {
            throw new IllegalArgumentException("Out of range: " + l);
        }
        return n;
    }

    public static int saturatedCast(long l) {
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)l;
    }

    public static int compare(int n, int n2) {
        return n < n2 ? -1 : (n > n2 ? 1 : 0);
    }

    public static boolean contains(int[] nArray, int n) {
        for (int n2 : nArray) {
            if (n2 != n) continue;
            return true;
        }
        return false;
    }

    public static int indexOf(int[] nArray, int n) {
        return Ints.indexOf(nArray, n, 0, nArray.length);
    }

    private static int indexOf(int[] nArray, int n, int n2, int n3) {
        for (int i = n2; i < n3; ++i) {
            if (nArray[i] != n) continue;
            return i;
        }
        return -1;
    }

    public static int indexOf(int[] nArray, int[] nArray2) {
        Preconditions.checkNotNull(nArray, "array");
        Preconditions.checkNotNull(nArray2, "target");
        if (nArray2.length == 0) {
            return 0;
        }
        block0: for (int i = 0; i < nArray.length - nArray2.length + 1; ++i) {
            for (int j = 0; j < nArray2.length; ++j) {
                if (nArray[i + j] != nArray2[j]) continue block0;
            }
            return i;
        }
        return -1;
    }

    public static int lastIndexOf(int[] nArray, int n) {
        return Ints.lastIndexOf(nArray, n, 0, nArray.length);
    }

    private static int lastIndexOf(int[] nArray, int n, int n2, int n3) {
        for (int i = n3 - 1; i >= n2; --i) {
            if (nArray[i] != n) continue;
            return i;
        }
        return -1;
    }

    public static int min(int ... nArray) {
        Preconditions.checkArgument(nArray.length > 0);
        int n = nArray[0];
        for (int i = 1; i < nArray.length; ++i) {
            if (nArray[i] >= n) continue;
            n = nArray[i];
        }
        return n;
    }

    public static int max(int ... nArray) {
        Preconditions.checkArgument(nArray.length > 0);
        int n = nArray[0];
        for (int i = 1; i < nArray.length; ++i) {
            if (nArray[i] <= n) continue;
            n = nArray[i];
        }
        return n;
    }

    public static int[] concat(int[] ... nArray) {
        int n = 0;
        for (int[] nArray2 : nArray) {
            n += nArray2.length;
        }
        int[] nArray3 = new int[n];
        int n2 = 0;
        for (int[] nArray4 : nArray) {
            System.arraycopy(nArray4, 0, nArray3, n2, nArray4.length);
            n2 += nArray4.length;
        }
        return nArray3;
    }

    @GwtIncompatible(value="doesn't work")
    public static byte[] toByteArray(int n) {
        return new byte[]{(byte)(n >> 24), (byte)(n >> 16), (byte)(n >> 8), (byte)n};
    }

    @GwtIncompatible(value="doesn't work")
    public static int fromByteArray(byte[] byArray) {
        Preconditions.checkArgument(byArray.length >= 4, "array too small: %s < %s", byArray.length, 4);
        return Ints.fromBytes(byArray[0], byArray[1], byArray[2], byArray[3]);
    }

    @GwtIncompatible(value="doesn't work")
    public static int fromBytes(byte by, byte by2, byte by3, byte by4) {
        return by << 24 | (by2 & 0xFF) << 16 | (by3 & 0xFF) << 8 | by4 & 0xFF;
    }

    @Beta
    public static Converter<String, Integer> stringConverter() {
        return IntConverter.INSTANCE;
    }

    public static int[] ensureCapacity(int[] nArray, int n, int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return nArray.length < n ? Ints.copyOf(nArray, n + n2) : nArray;
    }

    private static int[] copyOf(int[] nArray, int n) {
        int[] nArray2 = new int[n];
        System.arraycopy(nArray, 0, nArray2, 0, Math.min(nArray.length, n));
        return nArray2;
    }

    public static String join(String string, int ... nArray) {
        Preconditions.checkNotNull(string);
        if (nArray.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(nArray.length * 5);
        stringBuilder.append(nArray[0]);
        for (int i = 1; i < nArray.length; ++i) {
            stringBuilder.append(string).append(nArray[i]);
        }
        return stringBuilder.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList)collection).toIntArray();
        }
        Object[] objectArray = collection.toArray();
        int n = objectArray.length;
        int[] nArray = new int[n];
        for (int i = 0; i < n; ++i) {
            nArray[i] = ((Number)Preconditions.checkNotNull(objectArray[i])).intValue();
        }
        return nArray;
    }

    public static List<Integer> asList(int ... nArray) {
        if (nArray.length == 0) {
            return Collections.emptyList();
        }
        return new IntArrayAsList(nArray);
    }

    private static int digit(char c) {
        return c < '\u0080' ? asciiDigits[c] : -1;
    }

    @CheckForNull
    @Beta
    @GwtIncompatible(value="TODO")
    public static Integer tryParse(String string) {
        return Ints.tryParse(string, 10);
    }

    @CheckForNull
    @GwtIncompatible(value="TODO")
    static Integer tryParse(String string, int n) {
        int n2;
        int n3;
        if (Preconditions.checkNotNull(string).isEmpty()) {
            return null;
        }
        if (n < 2 || n > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + n);
        }
        boolean bl = string.charAt(0) == '-';
        int n4 = n3 = bl ? 1 : 0;
        if (n3 == string.length()) {
            return null;
        }
        if ((n2 = Ints.digit(string.charAt(n3++))) < 0 || n2 >= n) {
            return null;
        }
        int n5 = -n2;
        int n6 = Integer.MIN_VALUE / n;
        while (n3 < string.length()) {
            if ((n2 = Ints.digit(string.charAt(n3++))) < 0 || n2 >= n || n5 < n6) {
                return null;
            }
            if ((n5 *= n) < Integer.MIN_VALUE + n2) {
                return null;
            }
            n5 -= n2;
        }
        if (bl) {
            return n5;
        }
        if (n5 == Integer.MIN_VALUE) {
            return null;
        }
        return -n5;
    }

    static {
        int n;
        asciiDigits = new byte[128];
        Arrays.fill(asciiDigits, (byte)-1);
        for (n = 0; n <= 9; ++n) {
            Ints.asciiDigits[48 + n] = (byte)n;
        }
        for (n = 0; n <= 26; ++n) {
            Ints.asciiDigits[65 + n] = (byte)(10 + n);
            Ints.asciiDigits[97 + n] = (byte)(10 + n);
        }
    }

    @GwtCompatible
    private static class IntArrayAsList
    extends AbstractList<Integer>
    implements RandomAccess,
    Serializable {
        final int[] array;
        final int start;
        final int end;
        private static final long serialVersionUID = 0L;

        IntArrayAsList(int[] nArray) {
            this(nArray, 0, nArray.length);
        }

        IntArrayAsList(int[] nArray, int n, int n2) {
            this.array = nArray;
            this.start = n;
            this.end = n2;
        }

        @Override
        public int size() {
            return this.end - this.start;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Integer get(int n) {
            Preconditions.checkElementIndex(n, this.size());
            return this.array[this.start + n];
        }

        @Override
        public boolean contains(Object object) {
            return object instanceof Integer && Ints.indexOf(this.array, (Integer)object, this.start, this.end) != -1;
        }

        @Override
        public int indexOf(Object object) {
            int n;
            if (object instanceof Integer && (n = Ints.indexOf(this.array, (Integer)object, this.start, this.end)) >= 0) {
                return n - this.start;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object object) {
            int n;
            if (object instanceof Integer && (n = Ints.lastIndexOf(this.array, (Integer)object, this.start, this.end)) >= 0) {
                return n - this.start;
            }
            return -1;
        }

        @Override
        public Integer set(int n, Integer n2) {
            Preconditions.checkElementIndex(n, this.size());
            int n3 = this.array[this.start + n];
            this.array[this.start + n] = Preconditions.checkNotNull(n2);
            return n3;
        }

        @Override
        public List<Integer> subList(int n, int n2) {
            int n3 = this.size();
            Preconditions.checkPositionIndexes(n, n2, n3);
            if (n == n2) {
                return Collections.emptyList();
            }
            return new IntArrayAsList(this.array, this.start + n, this.start + n2);
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof IntArrayAsList) {
                IntArrayAsList intArrayAsList = (IntArrayAsList)object;
                int n = this.size();
                if (intArrayAsList.size() != n) {
                    return false;
                }
                for (int i = 0; i < n; ++i) {
                    if (this.array[this.start + i] == intArrayAsList.array[intArrayAsList.start + i]) continue;
                    return false;
                }
                return true;
            }
            return super.equals(object);
        }

        @Override
        public int hashCode() {
            int n = 1;
            for (int i = this.start; i < this.end; ++i) {
                n = 31 * n + Ints.hashCode(this.array[i]);
            }
            return n;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(this.size() * 5);
            stringBuilder.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; ++i) {
                stringBuilder.append(", ").append(this.array[i]);
            }
            return stringBuilder.append(']').toString();
        }

        int[] toIntArray() {
            int n = this.size();
            int[] nArray = new int[n];
            System.arraycopy(this.array, this.start, nArray, 0, n);
            return nArray;
        }
    }

    private static enum LexicographicalComparator implements Comparator<int[]>
    {
        INSTANCE;


        @Override
        public int compare(int[] nArray, int[] nArray2) {
            int n = Math.min(nArray.length, nArray2.length);
            for (int i = 0; i < n; ++i) {
                int n2 = Ints.compare(nArray[i], nArray2[i]);
                if (n2 == 0) continue;
                return n2;
            }
            return nArray.length - nArray2.length;
        }
    }

    private static final class IntConverter
    extends Converter<String, Integer>
    implements Serializable {
        static final IntConverter INSTANCE = new IntConverter();
        private static final long serialVersionUID = 1L;

        private IntConverter() {
        }

        @Override
        protected Integer doForward(String string) {
            return Integer.decode(string);
        }

        @Override
        protected String doBackward(Integer n) {
            return n.toString();
        }

        public String toString() {
            return "Ints.stringConverter()";
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}

