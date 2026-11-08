/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import com.google.common.collect.Lists;
import java.util.List;

public class IntCache {
    private static int intCacheSize = 256;
    private static List<int[]> freeSmallArrays = Lists.newArrayList();
    private static List<int[]> inUseSmallArrays = Lists.newArrayList();
    private static List<int[]> freeLargeArrays = Lists.newArrayList();
    private static List<int[]> inUseLargeArrays = Lists.newArrayList();

    public static synchronized int[] getIntCache(int n) {
        if (n <= 256) {
            if (freeSmallArrays.isEmpty()) {
                int[] nArray = new int[256];
                inUseSmallArrays.add(nArray);
                return nArray;
            }
            int[] nArray = freeSmallArrays.remove(freeSmallArrays.size() - 1);
            inUseSmallArrays.add(nArray);
            return nArray;
        }
        if (n > intCacheSize) {
            intCacheSize = n;
            freeLargeArrays.clear();
            inUseLargeArrays.clear();
            int[] nArray = new int[intCacheSize];
            inUseLargeArrays.add(nArray);
            return nArray;
        }
        if (freeLargeArrays.isEmpty()) {
            int[] nArray = new int[intCacheSize];
            inUseLargeArrays.add(nArray);
            return nArray;
        }
        int[] nArray = freeLargeArrays.remove(freeLargeArrays.size() - 1);
        inUseLargeArrays.add(nArray);
        return nArray;
    }

    public static synchronized void resetIntCache() {
        if (!freeLargeArrays.isEmpty()) {
            freeLargeArrays.remove(freeLargeArrays.size() - 1);
        }
        if (!freeSmallArrays.isEmpty()) {
            freeSmallArrays.remove(freeSmallArrays.size() - 1);
        }
        freeLargeArrays.addAll(inUseLargeArrays);
        freeSmallArrays.addAll(inUseSmallArrays);
        inUseLargeArrays.clear();
        inUseSmallArrays.clear();
    }

    public static synchronized String getCacheSizes() {
        return "cache: " + freeLargeArrays.size() + ", tcache: " + freeSmallArrays.size() + ", allocated: " + inUseLargeArrays.size() + ", tallocated: " + inUseSmallArrays.size();
    }
}

