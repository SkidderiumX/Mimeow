/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.util.concurrent.ThreadFactory;

public class DefaultEventExecutor
extends SingleThreadEventExecutor {
    DefaultEventExecutor(DefaultEventExecutorGroup defaultEventExecutorGroup, ThreadFactory threadFactory) {
        super(defaultEventExecutorGroup, threadFactory, true);
    }

    @Override
    protected void run() {
        do {
            Runnable runnable2;
            if ((runnable2 = this.takeTask()) == null) continue;
            runnable2.run();
            this.updateLastExecutionTime();
        } while (!this.confirmShutdown());
    }
}

