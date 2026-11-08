/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;
import java.util.concurrent.ThreadFactory;

public class DefaultEventExecutorGroup
extends MultithreadEventExecutorGroup {
    public DefaultEventExecutorGroup(int n) {
        this(n, null);
    }

    public DefaultEventExecutorGroup(int n, ThreadFactory threadFactory) {
        super(n, threadFactory, new Object[0]);
    }

    @Override
    protected EventExecutor newChild(ThreadFactory threadFactory, Object ... objectArray) throws Exception {
        return new DefaultEventExecutor(this, threadFactory);
    }
}

