/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.async;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DaemonThreadFactory
implements ThreadFactory {
    final ThreadGroup group;
    final AtomicInteger threadNumber = new AtomicInteger(1);
    final String threadNamePrefix;

    public DaemonThreadFactory(String string) {
        this.threadNamePrefix = string;
        SecurityManager securityManager = System.getSecurityManager();
        this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable2) {
        Thread thread2 = new Thread(this.group, runnable2, this.threadNamePrefix + this.threadNumber.getAndIncrement(), 0L);
        if (!thread2.isDaemon()) {
            thread2.setDaemon(true);
        }
        if (thread2.getPriority() != 5) {
            thread2.setPriority(5);
        }
        return thread2;
    }
}

