/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.checkerframework.checker.nullness.qual.Nullable;

public class UUIDUtil {
    public static UUID fromIntArray(int[] nArray) {
        if (nArray.length != 4) {
            return new UUID(0L, 0L);
        }
        return new UUID((long)nArray[0] << 32 | (long)nArray[1] & 0xFFFFFFFFL, (long)nArray[2] << 32 | (long)nArray[3] & 0xFFFFFFFFL);
    }

    public static int[] toIntArray(UUID uUID) {
        return UUIDUtil.toIntArray(uUID.getMostSignificantBits(), uUID.getLeastSignificantBits());
    }

    public static int[] toIntArray(long l, long l2) {
        return new int[]{(int)(l >> 32), (int)l, (int)(l2 >> 32), (int)l2};
    }

    public static @Nullable UUID parseUUID(String string) {
        try {
            return UUID.fromString(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    public static UUID randomUUID() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        long l = threadLocalRandom.nextLong();
        long l2 = threadLocalRandom.nextLong();
        l = l & 0xFFFFFFFFFFFF0FFFL | 0x4000L;
        l2 = l2 & 0x3FFFFFFFFFFFFFFFL | Long.MIN_VALUE;
        return new UUID(l, l2);
    }
}

