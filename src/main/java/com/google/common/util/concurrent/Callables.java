/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public class Callables {
    private Callables() {
    }

    public static <T> Callable<T> returning(final @Nullable T t) {
        return new Callable<T>(){

            @Override
            public T call() {
                return t;
            }
        };
    }

    static <T> Callable<T> threadRenaming(final Callable<T> callable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new Callable<T>(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public T call() throws Exception {
                Thread thread2 = Thread.currentThread();
                String string = thread2.getName();
                boolean bl = Callables.trySetName((String)supplier.get(), thread2);
                try {
                    Object v = callable.call();
                    return v;
                }
                finally {
                    if (bl) {
                        Callables.trySetName(string, thread2);
                    }
                }
            }
        };
    }

    static Runnable threadRenaming(final Runnable runnable2, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable2);
        return new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                Thread thread2 = Thread.currentThread();
                String string = thread2.getName();
                boolean bl = Callables.trySetName((String)supplier.get(), thread2);
                try {
                    runnable2.run();
                }
                finally {
                    if (bl) {
                        Callables.trySetName(string, thread2);
                    }
                }
            }
        };
    }

    private static boolean trySetName(String string, Thread thread2) {
        try {
            thread2.setName(string);
            return true;
        }
        catch (SecurityException securityException) {
            return false;
        }
    }
}

