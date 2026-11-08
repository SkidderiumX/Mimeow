/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;

public class FastThreadLocalThread
extends Thread {
    private InternalThreadLocalMap threadLocalMap;

    public FastThreadLocalThread() {
    }

    public FastThreadLocalThread(Runnable runnable2) {
        super(runnable2);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable2) {
        super(threadGroup, runnable2);
    }

    public FastThreadLocalThread(String string) {
        super(string);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, String string) {
        super(threadGroup, string);
    }

    public FastThreadLocalThread(Runnable runnable2, String string) {
        super(runnable2, string);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable2, String string) {
        super(threadGroup, runnable2, string);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable2, String string, long l) {
        super(threadGroup, runnable2, string, l);
    }

    public final InternalThreadLocalMap threadLocalMap() {
        return this.threadLocalMap;
    }

    public final void setThreadLocalMap(InternalThreadLocalMap internalThreadLocalMap) {
        this.threadLocalMap = internalThreadLocalMap;
    }
}

