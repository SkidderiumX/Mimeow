/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadFactoryBuilder {
    private String nameFormat = null;
    private Boolean daemon = null;
    private Integer priority = null;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
    private ThreadFactory backingThreadFactory = null;

    public ThreadFactoryBuilder setNameFormat(String string) {
        String.format(string, 0);
        this.nameFormat = string;
        return this;
    }

    public ThreadFactoryBuilder setDaemon(boolean bl) {
        this.daemon = bl;
        return this;
    }

    public ThreadFactoryBuilder setPriority(int n) {
        Preconditions.checkArgument(n >= 1, "Thread priority (%s) must be >= %s", n, 1);
        Preconditions.checkArgument(n <= 10, "Thread priority (%s) must be <= %s", n, 10);
        this.priority = n;
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        this.backingThreadFactory = Preconditions.checkNotNull(threadFactory);
        return this;
    }

    public ThreadFactory build() {
        return ThreadFactoryBuilder.build(this);
    }

    private static ThreadFactory build(ThreadFactoryBuilder threadFactoryBuilder) {
        final String string = threadFactoryBuilder.nameFormat;
        final Boolean bl = threadFactoryBuilder.daemon;
        final Integer n = threadFactoryBuilder.priority;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.uncaughtExceptionHandler;
        final ThreadFactory threadFactory = threadFactoryBuilder.backingThreadFactory != null ? threadFactoryBuilder.backingThreadFactory : Executors.defaultThreadFactory();
        final AtomicLong atomicLong = string != null ? new AtomicLong(0L) : null;
        return new ThreadFactory(){

            @Override
            public Thread newThread(Runnable runnable2) {
                Thread thread2 = threadFactory.newThread(runnable2);
                if (string != null) {
                    thread2.setName(String.format(string, atomicLong.getAndIncrement()));
                }
                if (bl != null) {
                    thread2.setDaemon(bl);
                }
                if (n != null) {
                    thread2.setPriority(n);
                }
                if (uncaughtExceptionHandler != null) {
                    thread2.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return thread2;
            }
        };
    }
}

