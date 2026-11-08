/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory
implements ThreadFactory {
    private static final AtomicInteger poolId = new AtomicInteger();
    private final AtomicInteger nextId = new AtomicInteger();
    private final String prefix;
    private final boolean daemon;
    private final int priority;

    public DefaultThreadFactory(Class<?> clazz) {
        this(clazz, false, 5);
    }

    public DefaultThreadFactory(String string) {
        this(string, false, 5);
    }

    public DefaultThreadFactory(Class<?> clazz, boolean bl) {
        this(clazz, bl, 5);
    }

    public DefaultThreadFactory(String string, boolean bl) {
        this(string, bl, 5);
    }

    public DefaultThreadFactory(Class<?> clazz, int n) {
        this(clazz, false, n);
    }

    public DefaultThreadFactory(String string, int n) {
        this(string, false, n);
    }

    public DefaultThreadFactory(Class<?> clazz, boolean bl, int n) {
        this(DefaultThreadFactory.toPoolName(clazz), bl, n);
    }

    private static String toPoolName(Class<?> clazz) {
        if (clazz == null) {
            throw new NullPointerException("poolType");
        }
        String string = StringUtil.simpleClassName(clazz);
        switch (string.length()) {
            case 0: {
                return "unknown";
            }
            case 1: {
                return string.toLowerCase(Locale.US);
            }
        }
        if (Character.isUpperCase(string.charAt(0)) && Character.isLowerCase(string.charAt(1))) {
            return Character.toLowerCase(string.charAt(0)) + string.substring(1);
        }
        return string;
    }

    public DefaultThreadFactory(String string, boolean bl, int n) {
        if (string == null) {
            throw new NullPointerException("poolName");
        }
        if (n < 1 || n > 10) {
            throw new IllegalArgumentException("priority: " + n + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        }
        this.prefix = string + '-' + poolId.incrementAndGet() + '-';
        this.daemon = bl;
        this.priority = n;
    }

    @Override
    public Thread newThread(Runnable runnable2) {
        Thread thread2 = this.newThread(new DefaultRunnableDecorator(runnable2), this.prefix + this.nextId.incrementAndGet());
        try {
            if (thread2.isDaemon()) {
                if (!this.daemon) {
                    thread2.setDaemon(false);
                }
            } else if (this.daemon) {
                thread2.setDaemon(true);
            }
            if (thread2.getPriority() != this.priority) {
                thread2.setPriority(this.priority);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return thread2;
    }

    protected Thread newThread(Runnable runnable2, String string) {
        return new FastThreadLocalThread(runnable2, string);
    }

    private static final class DefaultRunnableDecorator
    implements Runnable {
        private final Runnable r;

        DefaultRunnableDecorator(Runnable runnable2) {
            this.r = runnable2;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            try {
                this.r.run();
            }
            finally {
                FastThreadLocal.removeAll();
            }
        }
    }
}

