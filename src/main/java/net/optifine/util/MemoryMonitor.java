/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

public class MemoryMonitor {
    private static long startTimeMs = System.currentTimeMillis();
    private static long startMemory = MemoryMonitor.getMemoryUsed();
    private static long lastTimeMs = startTimeMs;
    private static long lastMemory = startMemory;
    private static boolean gcEvent = false;
    private static int memBytesSec = 0;
    private static long MB = 0x100000L;

    public static void update() {
        long l = System.currentTimeMillis();
        long l2 = MemoryMonitor.getMemoryUsed();
        boolean bl = gcEvent = l2 < lastMemory;
        if (gcEvent) {
            long l3 = lastMemory - startMemory;
            long l4 = lastTimeMs - startTimeMs;
            double d = (double)l4 / 1000.0;
            int n = (int)((double)l3 / d);
            if (n > 0) {
                memBytesSec = n;
            }
            startTimeMs = l;
            startMemory = l2;
        }
        lastTimeMs = l;
        lastMemory = l2;
    }

    private static long getMemoryUsed() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public static long getStartTimeMs() {
        return startTimeMs;
    }

    public static long getStartMemoryMb() {
        return startMemory / MB;
    }

    public static boolean isGcEvent() {
        return gcEvent;
    }

    public static long getAllocationRateMb() {
        return (long)memBytesSec / MB;
    }
}

