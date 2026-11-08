/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public class ListenerCallQueue<L>
implements Runnable {
    private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final L listener;
    private final Executor executor;
    @GuardedBy(value="this")
    private final Queue<Callback<L>> waitQueue = Queues.newArrayDeque();
    @GuardedBy(value="this")
    private boolean isThreadScheduled;

    ListenerCallQueue(L l, Executor executor) {
        this.listener = Preconditions.checkNotNull(l);
        this.executor = Preconditions.checkNotNull(executor);
    }

    synchronized void add(Callback<L> callback) {
        this.waitQueue.add(callback);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void execute() {
        boolean bl = false;
        ListenerCallQueue listenerCallQueue = this;
        synchronized (listenerCallQueue) {
            if (!this.isThreadScheduled) {
                this.isThreadScheduled = true;
                bl = true;
            }
        }
        if (bl) {
            try {
                this.executor.execute(this);
            }
            catch (RuntimeException runtimeException) {
                ListenerCallQueue listenerCallQueue2 = this;
                synchronized (listenerCallQueue2) {
                    this.isThreadScheduled = false;
                }
                logger.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, runtimeException);
                throw runtimeException;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
            Object object;
            boolean bl = true;
        block18: try {
            block14: while (true) {
                while (true) {
                    ListenerCallQueue listenerCallQueue = this;
                    synchronized (listenerCallQueue) {
                        Preconditions.checkState(this.isThreadScheduled);
                        object = this.waitQueue.poll();
                        if (object == null) {
                            this.isThreadScheduled = false;
                            bl = false;
                            break block18;
                        }
                    }
                    try {
                        ((Callback)object).call(this.listener);
                        continue block14;
                    }
                    catch (RuntimeException runtimeException) {
                        logger.log(Level.SEVERE, "Exception while executing callback: " + this.listener + "." + ((Callback)object).methodCall, runtimeException);
                        continue;
                    }
                    break;
                }
            }
            }
            finally {
                if (bl) {
                    object = this;
                    synchronized (object) {
                        this.isThreadScheduled = false;
                    }
                }
            }
    }

    public static abstract class Callback<L> {
        private final String methodCall;

        Callback(String string) {
            this.methodCall = string;
        }

        abstract void call(L var1);

        void enqueueOn(Iterable<ListenerCallQueue<L>> iterable) {
            for (ListenerCallQueue<L> listenerCallQueue : iterable) {
                listenerCallQueue.add(this);
            }
        }
    }
}

