/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io;

public class ThreadMonitor
implements Runnable {
    private final Thread thread;
    private final long timeout;

    public static Thread start(long l) {
        return ThreadMonitor.start(Thread.currentThread(), l);
    }

    public static Thread start(Thread thread2, long l) {
        Thread thread3 = null;
        if (l > 0L) {
            ThreadMonitor threadMonitor = new ThreadMonitor(thread2, l);
            thread3 = new Thread((Runnable)threadMonitor, ThreadMonitor.class.getSimpleName());
            thread3.setDaemon(true);
            thread3.start();
        }
        return thread3;
    }

    public static void stop(Thread thread2) {
        if (thread2 != null) {
            thread2.interrupt();
        }
    }

    private ThreadMonitor(Thread thread2, long l) {
        this.thread = thread2;
        this.timeout = l;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.timeout);
            this.thread.interrupt();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }
}

