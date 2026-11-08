/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import sun.misc.Unsafe;

public class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = -128;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    private UnsignedBytes() {
    }

    public static int toInt(byte by) {
        return by & 0xFF;
    }

    public static byte checkedCast(long l) {
        if (l >> 8 != 0L) {
            throw new IllegalArgumentException("Out of range: " + l);
        }
        return (byte)l;
    }

    public static byte saturatedCast(long l) {
        if (l > (long)UnsignedBytes.toInt((byte)-1)) {
            return -1;
        }
        if (l < 0L) {
            return 0;
        }
        return (byte)l;
    }

    public static int compare(byte by, byte by2) {
        return UnsignedBytes.toInt(by) - UnsignedBytes.toInt(by2);
    }

    public static byte min(byte ... byArray) {
        Preconditions.checkArgument(byArray.length > 0);
        int n = UnsignedBytes.toInt(byArray[0]);
        for (int i = 1; i < byArray.length; ++i) {
            int n2 = UnsignedBytes.toInt(byArray[i]);
            if (n2 >= n) continue;
            n = n2;
        }
        return (byte)n;
    }

    public static byte max(byte ... byArray) {
        Preconditions.checkArgument(byArray.length > 0);
        int n = UnsignedBytes.toInt(byArray[0]);
        for (int i = 1; i < byArray.length; ++i) {
            int n2 = UnsignedBytes.toInt(byArray[i]);
            if (n2 <= n) continue;
            n = n2;
        }
        return (byte)n;
    }

    @Beta
    public static String toString(byte by) {
        return UnsignedBytes.toString(by, 10);
    }

    @Beta
    public static String toString(byte by, int n) {
        Preconditions.checkArgument(n >= 2 && n <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", n);
        return Integer.toString(UnsignedBytes.toInt(by), n);
    }

    @Beta
    public static byte parseUnsignedByte(String string) {
        return UnsignedBytes.parseUnsignedByte(string, 10);
    }

    @Beta
    public static byte parseUnsignedByte(String string, int n) {
        int n2 = Integer.parseInt(Preconditions.checkNotNull(string), n);
        if (n2 >> 8 == 0) {
            return (byte)n2;
        }
        throw new NumberFormatException("out of range: " + n2);
    }

    public static String join(String string, byte ... byArray) {
        Preconditions.checkNotNull(string);
        if (byArray.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(byArray.length * (3 + string.length()));
        stringBuilder.append(UnsignedBytes.toInt(byArray[0]));
        for (int i = 1; i < byArray.length; ++i) {
            stringBuilder.append(string).append(UnsignedBytes.toString(byArray[i]));
        }
        return stringBuilder.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    @VisibleForTesting
    static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    @VisibleForTesting
    public static class LexicographicalComparatorHolder {
        static final String UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
        static final Comparator<byte[]> BEST_COMPARATOR = LexicographicalComparatorHolder.getBestComparator();

        LexicographicalComparatorHolder() {
        }

        static Comparator<byte[]> getBestComparator() {
            try {
                Class<?> clazz = Class.forName(UNSAFE_COMPARATOR_NAME);
                Comparator comparator = (Comparator)clazz.getEnumConstants()[0];
                return comparator;
            }
            catch (Throwable throwable) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }

        public static enum PureJavaComparator implements Comparator<byte[]>
        {
            INSTANCE;


            @Override
            public int compare(byte[] byArray, byte[] byArray2) {
                int n = Math.min(byArray.length, byArray2.length);
                for (int i = 0; i < n; ++i) {
                    int n2 = UnsignedBytes.compare(byArray[i], byArray2[i]);
                    if (n2 == 0) continue;
                    return n2;
                }
                return byArray.length - byArray2.length;
            }
        }

        @VisibleForTesting
        public static enum UnsafeComparator implements Comparator<byte[]>
        {
            INSTANCE;

            static final boolean BIG_ENDIAN;
            static final Unsafe theUnsafe;
            static final int BYTE_ARRAY_BASE_OFFSET;

            private static Unsafe getUnsafe() {
                try {
                    return Unsafe.getUnsafe();
                }
                catch (SecurityException securityException) {
                    try {
                        return AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>(){

                            @Override
                            public Unsafe run() throws Exception {
                                Class<Unsafe> clazz = Unsafe.class;
                                for (Field field : clazz.getDeclaredFields()) {
                                    field.setAccessible(true);
                                    Object object = field.get(null);
                                    if (!clazz.isInstance(object)) continue;
                                    return (Unsafe)clazz.cast(object);
                                }
                                throw new NoSuchFieldError("the Unsafe");
                            }
                        });
                    }
                    catch (PrivilegedActionException privilegedActionException) {
                        throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
                    }
                }
            }

            @Override
            public int compare(byte[] byArray, byte[] byArray2) {
                int n;
                int n2 = Math.min(byArray.length, byArray2.length);
                int n3 = n2 / 8;
                for (n = 0; n < n3 * 8; n += 8) {
                    long l;
                    long l2 = theUnsafe.getLong(byArray, (long)BYTE_ARRAY_BASE_OFFSET + (long)n);
                    if (l2 == (l = theUnsafe.getLong(byArray2, (long)BYTE_ARRAY_BASE_OFFSET + (long)n))) continue;
                    if (BIG_ENDIAN) {
                        return UnsignedLongs.compare(l2, l);
                    }
                    int n4 = Long.numberOfTrailingZeros(l2 ^ l) & 0xFFFFFFF8;
                    return (int)((l2 >>> n4 & 0xFFL) - (l >>> n4 & 0xFFL));
                }
                for (n = n3 * 8; n < n2; ++n) {
                    int n5 = UnsignedBytes.compare(byArray[n], byArray2[n]);
                    if (n5 == 0) continue;
                    return n5;
                }
                return byArray.length - byArray2.length;
            }

            static {
                BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
                theUnsafe = UnsafeComparator.getUnsafe();
                BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
                if (theUnsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new AssertionError();
                }
            }
        }
    }
}

