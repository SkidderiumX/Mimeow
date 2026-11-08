/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.internal.chmv8;

import io.netty.util.internal.chmv8.ForkJoinPool;

public class ForkJoinWorkerThread
extends Thread {
    final ForkJoinPool pool;
    final ForkJoinPool.WorkQueue workQueue;

    protected ForkJoinWorkerThread(ForkJoinPool forkJoinPool) {
        super("aForkJoinWorkerThread");
        this.pool = forkJoinPool;
        this.workQueue = forkJoinPool.registerWorker(this);
    }

    public ForkJoinPool getPool() {
        return this.pool;
    }

    public int getPoolIndex() {
        return this.workQueue.poolIndex >>> 1;
    }

    protected void onStart() {
    }

    protected void onTermination(Throwable throwable) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Throwable throwable = null;
        try {
            this.onStart();
            this.pool.runWorker(this.workQueue);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
        }
        finally {
            try {
                this.onTermination(throwable);
            }
            catch (Throwable throwable3) {
                if (throwable == null) {
                    throwable = throwable3;
                }
            }
            finally {
                this.pool.deregisterWorker(this, throwable);
            }
        }
    }
}

