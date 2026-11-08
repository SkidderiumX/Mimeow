/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import java.util.concurrent.Executor;

public class ImmediateExecutor
implements Executor {
    public static final ImmediateExecutor INSTANCE = new ImmediateExecutor();

    private ImmediateExecutor() {
    }

    @Override
    public void execute(Runnable runnable2) {
        if (runnable2 == null) {
            throw new NullPointerException("command");
        }
        runnable2.run();
    }
}

