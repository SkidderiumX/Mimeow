/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.local;

import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.local.LocalEventLoopGroup;
import java.util.concurrent.ThreadFactory;

public class LocalEventLoop
extends SingleThreadEventLoop {
    LocalEventLoop(LocalEventLoopGroup localEventLoopGroup, ThreadFactory threadFactory) {
        super(localEventLoopGroup, threadFactory, true);
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

