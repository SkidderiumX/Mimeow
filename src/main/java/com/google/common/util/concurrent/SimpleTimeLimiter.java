/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public class SimpleTimeLimiter
implements TimeLimiter {
    private final ExecutorService executor;

    public SimpleTimeLimiter(ExecutorService executorService) {
        this.executor = Preconditions.checkNotNull(executorService);
    }

    public SimpleTimeLimiter() {
        this(Executors.newCachedThreadPool());
    }

    @Override
    public <T> T newProxy(final T t, Class<T> clazz, final long l, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkArgument(l > 0L, "bad timeout: %s", l);
        Preconditions.checkArgument(clazz.isInterface(), "interfaceType must be an interface type");
        final Set<Method> set = SimpleTimeLimiter.findInterruptibleMethods(clazz);
        InvocationHandler invocationHandler = new InvocationHandler(){

            @Override
            public Object invoke(Object object, final Method method, final Object[] objectArray) throws Throwable {
                Callable<Object> callable = new Callable<Object>(){

                    @Override
                    public Object call() throws Exception {
                        try {
                            return method.invoke(t, objectArray);
                        }
                        catch (InvocationTargetException invocationTargetException) {
                            SimpleTimeLimiter.throwCause(invocationTargetException, false);
                            throw new AssertionError((Object)"can't get here");
                        }
                    }
                };
                return SimpleTimeLimiter.this.callWithTimeout(callable, l, timeUnit, set.contains(method));
            }
        };
        return SimpleTimeLimiter.newProxy(clazz, invocationHandler);
    }

    @Override
    public <T> T callWithTimeout(Callable<T> callable, long l, TimeUnit timeUnit, boolean bl) throws Exception {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkArgument(l > 0L, "timeout must be positive: %s", l);
        Future<T> future = this.executor.submit(callable);
        try {
            if (bl) {
                try {
                    return future.get(l, timeUnit);
                }
                catch (InterruptedException interruptedException) {
                    future.cancel(true);
                    throw interruptedException;
                }
            }
            return Uninterruptibles.getUninterruptibly(future, l, timeUnit);
        }
        catch (ExecutionException executionException) {
            throw SimpleTimeLimiter.throwCause(executionException, true);
        }
        catch (TimeoutException timeoutException) {
            future.cancel(true);
            throw new UncheckedTimeoutException(timeoutException);
        }
    }

    private static Exception throwCause(Exception exception, boolean bl) throws Exception {
        Throwable throwable = exception.getCause();
        if (throwable == null) {
            throw exception;
        }
        if (bl) {
            StackTraceElement[] stackTraceElementArray = ObjectArrays.concat(throwable.getStackTrace(), exception.getStackTrace(), StackTraceElement.class);
            throwable.setStackTrace(stackTraceElementArray);
        }
        if (throwable instanceof Exception) {
            throw (Exception)throwable;
        }
        if (throwable instanceof Error) {
            throw (Error)throwable;
        }
        throw exception;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> clazz) {
        HashSet<Method> hashSet = Sets.newHashSet();
        for (Method method : clazz.getMethods()) {
            if (!SimpleTimeLimiter.declaresInterruptedEx(method)) continue;
            hashSet.add(method);
        }
        return hashSet;
    }

    private static boolean declaresInterruptedEx(Method method) {
        for (Class<?> clazz : method.getExceptionTypes()) {
            if (clazz != InterruptedException.class) continue;
            return true;
        }
        return false;
    }

    private static <T> T newProxy(Class<T> clazz, InvocationHandler invocationHandler) {
        Object object = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, invocationHandler);
        return clazz.cast(object);
    }
}

