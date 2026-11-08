package com.google.common.util.concurrent;

import java.util.concurrent.*;
import javax.annotation.concurrent.*;
import java.util.*;
import com.google.common.base.*;
import java.util.logging.*;

public class SerializingExecutor implements Executor
{
    private static final Logger log;
    private final Executor executor;
    @GuardedBy("internalLock")
    private final Queue<Runnable> waitQueue;
    @GuardedBy("internalLock")
    private boolean isThreadScheduled;
    private final TaskRunner taskRunner;
    private final Object internalLock;
    
    public SerializingExecutor(final Executor executor) {
        this.waitQueue = new ArrayDeque<Runnable>();
        this.isThreadScheduled = false;
        this.taskRunner = new TaskRunner();
        this.internalLock = new Object() {
            @Override
            public String toString() {
                return "SerializingExecutor lock: " + super.toString();
            }
        };
        Preconditions.checkNotNull(executor, (Object)"'executor' must not be null.");
        this.executor = executor;
    }
    
    @Override
    public void execute(final Runnable runnable) {
        Preconditions.checkNotNull(runnable, (Object)"'r' must not be null.");
        boolean b = false;
        synchronized (this.internalLock) {
            this.waitQueue.add(runnable);
            if (!this.isThreadScheduled) {
                this.isThreadScheduled = true;
                b = true;
            }
        }
        if (b) {
            boolean b2 = true;
            try {
                this.executor.execute(this.taskRunner);
                b2 = false;
            }
            finally {
                if (b2) {
                    synchronized (this.internalLock) {
                        this.isThreadScheduled = false;
                    }
                }
            }
        }
    }
    
    static {
        log = Logger.getLogger(SerializingExecutor.class.getName());
    }
    
    private class TaskRunner implements Runnable
    {
        @Override
        public void run() {
            boolean b = true;
            try {
                while (true) {
                    Preconditions.checkState(SerializingExecutor.this.isThreadScheduled);
                    final Runnable obj;
                    synchronized (SerializingExecutor.this.internalLock) {
                        obj = SerializingExecutor.this.waitQueue.poll();
                        if (obj == null) {
                            SerializingExecutor.this.isThreadScheduled = false;
                            b = false;
                            break;
                        }
                    }
                    try {
                        obj.run();
                    }
                    catch (final RuntimeException thrown) {
                        SerializingExecutor.log.log(Level.SEVERE, "Exception while executing runnable " + obj, thrown);
                    }
                }
            }
            finally {
                if (b) {
                    synchronized (SerializingExecutor.this.internalLock) {
                        SerializingExecutor.this.isThreadScheduled = false;
                    }
                }
            }
        }
    }
}
