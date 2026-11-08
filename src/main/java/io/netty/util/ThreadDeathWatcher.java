/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.internal.MpscLinkedQueueNode;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadDeathWatcher {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadDeathWatcher.class);
    private static final ThreadFactory threadFactory = new DefaultThreadFactory(ThreadDeathWatcher.class, true, 1);
    private static final Queue<Entry> pendingEntries = PlatformDependent.newMpscQueue();
    private static final Watcher watcher = new Watcher();
    private static final AtomicBoolean started = new AtomicBoolean();
    private static volatile Thread watcherThread;

    public static void watch(Thread thread2, Runnable runnable2) {
        if (thread2 == null) {
            throw new NullPointerException("thread");
        }
        if (runnable2 == null) {
            throw new NullPointerException("task");
        }
        if (!thread2.isAlive()) {
            throw new IllegalArgumentException("thread must be alive.");
        }
        ThreadDeathWatcher.schedule(thread2, runnable2, true);
    }

    public static void unwatch(Thread thread2, Runnable runnable2) {
        if (thread2 == null) {
            throw new NullPointerException("thread");
        }
        if (runnable2 == null) {
            throw new NullPointerException("task");
        }
        ThreadDeathWatcher.schedule(thread2, runnable2, false);
    }

    private static void schedule(Thread thread2, Runnable runnable2, boolean bl) {
        pendingEntries.add(new Entry(thread2, runnable2, bl));
        if (started.compareAndSet(false, true)) {
            Thread thread3 = threadFactory.newThread(watcher);
            thread3.start();
            watcherThread = thread3;
        }
    }

    public static boolean awaitInactivity(long l, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        Thread thread2 = watcherThread;
        if (thread2 != null) {
            thread2.join(timeUnit.toMillis(l));
            return !thread2.isAlive();
        }
        return true;
    }

    private ThreadDeathWatcher() {
    }

    private static final class Entry
    extends MpscLinkedQueueNode<Entry> {
        final Thread thread;
        final Runnable task;
        final boolean isWatch;

        Entry(Thread thread2, Runnable runnable2, boolean bl) {
            this.thread = thread2;
            this.task = runnable2;
            this.isWatch = bl;
        }

        @Override
        public Entry value() {
            return this;
        }

        public int hashCode() {
            return this.thread.hashCode() ^ this.task.hashCode();
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry)object;
            return this.thread == entry.thread && this.task == entry.task;
        }
    }

    private static final class Watcher
    implements Runnable {
        private final List<Entry> watchees = new ArrayList<Entry>();

        private Watcher() {
        }

        @Override
        public void run() {
            while (true) {
                this.fetchWatchees();
                this.notifyWatchees();
                this.fetchWatchees();
                this.notifyWatchees();
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                if (!this.watchees.isEmpty() || !pendingEntries.isEmpty()) continue;
                boolean bl = started.compareAndSet(true, false);
                assert (bl);
                if (pendingEntries.isEmpty() || !started.compareAndSet(false, true)) break;
            }
        }

        private void fetchWatchees() {
            Entry entry;
            while ((entry = (Entry)pendingEntries.poll()) != null) {
                if (entry.isWatch) {
                    this.watchees.add(entry);
                    continue;
                }
                this.watchees.remove(entry);
            }
        }

        private void notifyWatchees() {
            List<Entry> list = this.watchees;
            int n = 0;
            while (n < list.size()) {
                Entry entry = list.get(n);
                if (!entry.thread.isAlive()) {
                    list.remove(n);
                    try {
                        entry.task.run();
                    }
                    catch (Throwable throwable) {
                        logger.warn("Thread death watcher task raised an exception:", throwable);
                    }
                    continue;
                }
                ++n;
            }
        }
    }
}

