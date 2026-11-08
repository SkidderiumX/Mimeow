/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.glfw.GLFW;

public class Sync {
    private static final long NANOS_IN_SECOND = 1000000000L;
    private static long nextFrame = 0L;
    private static boolean initialised = false;
    private static RunningAvg sleepDurations = new RunningAvg(10);
    private static RunningAvg yieldDurations = new RunningAvg(10);

    Sync() {
    }

    public static void sync(int n) {
        if (n <= 0) {
            return;
        }
        if (!initialised) {
            Sync.initialise();
        }
        try {
            long l;
            long l2 = Sync.getTime();
            while (nextFrame - l2 > sleepDurations.avg()) {
                Thread.sleep(1L);
                l = Sync.getTime();
                sleepDurations.add(l - l2);
                l2 = l;
            }
            sleepDurations.dampenForLowResTicker();
            l2 = Sync.getTime();
            while (nextFrame - l2 > yieldDurations.avg()) {
                Thread.yield();
                l = Sync.getTime();
                yieldDurations.add(l - l2);
                l2 = l;
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        nextFrame = Math.max(nextFrame + 1000000000L / (long)n, Sync.getTime());
    }

    private static void initialise() {
        initialised = true;
        sleepDurations.init(1000000L);
        yieldDurations.init((int)((double)(-(Sync.getTime() - Sync.getTime())) * 1.333));
        nextFrame = Sync.getTime();
        String string = System.getProperty("os.name");
        if (string.startsWith("Win")) {
            Thread thread2 = new Thread(new Runnable(){

                @Override
                public void run() {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            });
            thread2.setName("LWJGL Timer");
            thread2.setDaemon(true);
            thread2.start();
        }
    }

    private static long getTime() {
        return (long)(GLFW.glfwGetTime() * 1.0E9);
    }

    private static class RunningAvg {
        private final long[] slots;
        private int offset;
        private static final long DAMPEN_THRESHOLD = 10000000L;
        private static final float DAMPEN_FACTOR = 0.9f;

        public RunningAvg(int n) {
            this.slots = new long[n];
            this.offset = 0;
        }

        public void init(long l) {
            while (this.offset < this.slots.length) {
                this.slots[this.offset++] = l;
            }
        }

        public void add(long l) {
            this.slots[this.offset++ % this.slots.length] = l;
            this.offset %= this.slots.length;
        }

        public long avg() {
            long l = 0L;
            for (int i = 0; i < this.slots.length; ++i) {
                l += this.slots[i];
            }
            return l / (long)this.slots.length;
        }

        public void dampenForLowResTicker() {
            if (this.avg() > 10000000L) {
                int n = 0;
                while (n < this.slots.length) {
                    int n2 = n++;
                    this.slots[n2] = (long)((float)this.slots[n2] * 0.9f);
                }
            }
        }
    }
}

