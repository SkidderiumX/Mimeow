package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@Beta
public class Uninterruptibles
{
    public static void awaitUninterruptibly(final CountDownLatch countDownLatch) {
        boolean b = false;
        while (true) {
            try {
                countDownLatch.await();
            }
            catch (final InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    public static boolean awaitUninterruptibly(final CountDownLatch countDownLatch, final long duration, final TimeUnit timeUnit) {
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(duration);
            final long n = System.nanoTime() + nanos;
            try {
                return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
            }
            catch (final InterruptedException ex) {
                b = true;
                nanos = n - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static void joinUninterruptibly(final Thread thread) {
        boolean b = false;
        while (true) {
            try {
                thread.join();
            }
            catch (final InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    public static <V> V getUninterruptibly(final Future<V> future) throws ExecutionException {
        boolean b = false;
        try {
            return future.get();
        }
        catch (final InterruptedException ex) {
            b = true;
            return future.get();
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static <V> V getUninterruptibly(final Future<V> future, final long duration, final TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(duration);
            final long n = System.nanoTime() + nanos;
            try {
                return future.get(nanos, TimeUnit.NANOSECONDS);
            }
            catch (final InterruptedException ex) {
                b = true;
                nanos = n - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static void joinUninterruptibly(final Thread thread, final long duration, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(thread);
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(duration);
            final long n = System.nanoTime() + nanos;
            try {
                TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
            }
            catch (final InterruptedException ex) {
                b = true;
                nanos = n - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static <E> E takeUninterruptibly(final BlockingQueue<E> blockingQueue) {
        boolean b = false;
        try {
            return blockingQueue.take();
        }
        catch (final InterruptedException ex) {
            b = true;
            return blockingQueue.take();
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static <E> void putUninterruptibly(final BlockingQueue<E> blockingQueue, final E e) {
        boolean b = false;
        while (true) {
            try {
                blockingQueue.put(e);
            }
            catch (final InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    public static void sleepUninterruptibly(final long duration, final TimeUnit timeUnit) {
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(duration);
            final long n = System.nanoTime() + nanos;
            try {
                TimeUnit.NANOSECONDS.sleep(nanos);
            }
            catch (final InterruptedException ex) {
                b = true;
                nanos = n - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    private Uninterruptibles() {
    }
}
