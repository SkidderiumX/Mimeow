/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
public class Booleans {
    private Booleans() {
    }

    public static int hashCode(boolean bl) {
        return bl ? 1231 : 1237;
    }

    public static int compare(boolean bl, boolean bl2) {
        return bl == bl2 ? 0 : (bl ? 1 : -1);
    }

    public static boolean contains(boolean[] blArray, boolean bl) {
        for (boolean bl2 : blArray) {
            if (bl2 != bl) continue;
            return true;
        }
        return false;
    }

    public static int indexOf(boolean[] blArray, boolean bl) {
        return Booleans.indexOf(blArray, bl, 0, blArray.length);
    }

    private static int indexOf(boolean[] blArray, boolean bl, int n, int n2) {
        for (int i = n; i < n2; ++i) {
            if (blArray[i] != bl) continue;
            return i;
        }
        return -1;
    }

    public static int indexOf(boolean[] blArray, boolean[] blArray2) {
        Preconditions.checkNotNull(blArray, "array");
        Preconditions.checkNotNull(blArray2, "target");
        if (blArray2.length == 0) {
            return 0;
        }
        block0: for (int i = 0; i < blArray.length - blArray2.length + 1; ++i) {
            for (int j = 0; j < blArray2.length; ++j) {
                if (blArray[i + j] != blArray2[j]) continue block0;
            }
            return i;
        }
        return -1;
    }

    public static int lastIndexOf(boolean[] blArray, boolean bl) {
        return Booleans.lastIndexOf(blArray, bl, 0, blArray.length);
    }

    private static int lastIndexOf(boolean[] blArray, boolean bl, int n, int n2) {
        for (int i = n2 - 1; i >= n; --i) {
            if (blArray[i] != bl) continue;
            return i;
        }
        return -1;
    }

    public static boolean[] concat(boolean[] ... blArray) {
        int n = 0;
        for (boolean[] blArray2 : blArray) {
            n += blArray2.length;
        }
        boolean[] blArray3 = new boolean[n];
        int n2 = 0;
        for (boolean[] blArray4 : blArray) {
            System.arraycopy(blArray4, 0, blArray3, n2, blArray4.length);
            n2 += blArray4.length;
        }
        return blArray3;
    }

    public static boolean[] ensureCapacity(boolean[] blArray, int n, int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return blArray.length < n ? Booleans.copyOf(blArray, n + n2) : blArray;
    }

    private static boolean[] copyOf(boolean[] blArray, int n) {
        boolean[] blArray2 = new boolean[n];
        System.arraycopy(blArray, 0, blArray2, 0, Math.min(blArray.length, n));
        return blArray2;
    }

    public static String join(String string, boolean ... blArray) {
        Preconditions.checkNotNull(string);
        if (blArray.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(blArray.length * 7);
        stringBuilder.append(blArray[0]);
        for (int i = 1; i < blArray.length; ++i) {
            stringBuilder.append(string).append(blArray[i]);
        }
        return stringBuilder.toString();
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList)collection).toBooleanArray();
        }
        Object[] objectArray = collection.toArray();
        int n = objectArray.length;
        boolean[] blArray = new boolean[n];
        for (int i = 0; i < n; ++i) {
            blArray[i] = (Boolean)Preconditions.checkNotNull(objectArray[i]);
        }
        return blArray;
    }

    public static List<Boolean> asList(boolean ... blArray) {
        if (blArray.length == 0) {
            return Collections.emptyList();
        }
        return new BooleanArrayAsList(blArray);
    }

    @Beta
    public static int countTrue(boolean ... blArray) {
        int n = 0;
        for (boolean bl : blArray) {
            if (!bl) continue;
            ++n;
        }
        return n;
    }

    @GwtCompatible
    private static class BooleanArrayAsList
    extends AbstractList<Boolean>
    implements RandomAccess,
    Serializable {
        final boolean[] array;
        final int start;
        final int end;
        private static final long serialVersionUID = 0L;

        BooleanArrayAsList(boolean[] blArray) {
            this(blArray, 0, blArray.length);
        }

        BooleanArrayAsList(boolean[] blArray, int n, int n2) {
            this.array = blArray;
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
        public Boolean get(int n) {
            Preconditions.checkElementIndex(n, this.size());
            return this.array[this.start + n];
        }

        @Override
        public boolean contains(Object object) {
            return object instanceof Boolean && Booleans.indexOf(this.array, (Boolean)object, this.start, this.end) != -1;
        }

        @Override
        public int indexOf(Object object) {
            int n;
            if (object instanceof Boolean && (n = Booleans.indexOf(this.array, (Boolean)object, this.start, this.end)) >= 0) {
                return n - this.start;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object object) {
            int n;
            if (object instanceof Boolean && (n = Booleans.lastIndexOf(this.array, (Boolean)object, this.start, this.end)) >= 0) {
                return n - this.start;
            }
            return -1;
        }

        @Override
        public Boolean set(int n, Boolean bl) {
            Preconditions.checkElementIndex(n, this.size());
            boolean bl2 = this.array[this.start + n];
            this.array[this.start + n] = Preconditions.checkNotNull(bl);
            return bl2;
        }

        @Override
        public List<Boolean> subList(int n, int n2) {
            int n3 = this.size();
            Preconditions.checkPositionIndexes(n, n2, n3);
            if (n == n2) {
                return Collections.emptyList();
            }
            return new BooleanArrayAsList(this.array, this.start + n, this.start + n2);
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof BooleanArrayAsList) {
                BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList)object;
                int n = this.size();
                if (booleanArrayAsList.size() != n) {
                    return false;
                }
                for (int i = 0; i < n; ++i) {
                    if (this.array[this.start + i] == booleanArrayAsList.array[booleanArrayAsList.start + i]) continue;
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
                n = 31 * n + Booleans.hashCode(this.array[i]);
            }
            return n;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(this.size() * 7);
            stringBuilder.append(this.array[this.start] ? "[true" : "[false");
            for (int i = this.start + 1; i < this.end; ++i) {
                stringBuilder.append(this.array[i] ? ", true" : ", false");
            }
            return stringBuilder.append(']').toString();
        }

        boolean[] toBooleanArray() {
            int n = this.size();
            boolean[] blArray = new boolean[n];
            System.arraycopy(this.array, this.start, blArray, 0, n);
            return blArray;
        }
    }

    private static enum LexicographicalComparator implements Comparator<boolean[]>
    {
        INSTANCE;


        @Override
        public int compare(boolean[] blArray, boolean[] blArray2) {
            int n = Math.min(blArray.length, blArray2.length);
            for (int i = 0; i < n; ++i) {
                int n2 = Booleans.compare(blArray[i], blArray2[i]);
                if (n2 == 0) continue;
                return n2;
            }
            return blArray.length - blArray2.length;
        }
    }
}

