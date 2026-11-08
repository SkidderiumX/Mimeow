/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

public abstract class Striped64
extends Number {
    static final ThreadHashCode threadHashCode = new ThreadHashCode();
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    volatile transient Cell[] cells;
    volatile transient long base;
    volatile transient int busy;
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;

    Striped64() {
    }

    final boolean casBase(long l, long l2) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, l, l2);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long fn(long var1, long var3);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void retryUpdate(long l, HashCode hashCode, boolean bl) {
        int n = hashCode.code;
        boolean bl2 = false;
        while (true) {
            long l2;
            int n2;
            Cell[] cellArray = this.cells;
            if (this.cells != null && (n2 = cellArray.length) > 0) {
                Cell[] cellArray2;
                Cell cell = cellArray[n2 - 1 & n];
                if (cell == null) {
                    if (this.busy == 0) {
                        cellArray2 = new Cell(l);
                        if (this.busy == 0 && this.casBusy()) {
                            boolean bl3 = false;
                            try {
                                int n3;
                                int n4;
                                Cell[] cellArray3 = this.cells;
                                if (this.cells != null && (n4 = cellArray3.length) > 0 && cellArray3[n3 = n4 - 1 & n] == null) {
                                    cellArray3[n3] = cellArray2;
                                    bl3 = true;
                                }
                            }
                            finally {
                                this.busy = 0;
                            }
                            if (!bl3) continue;
                            break;
                        }
                    }
                    bl2 = false;
                } else if (!bl) {
                    bl = true;
                } else {
                    l2 = cell.value;
                    if (cell.cas(l2, this.fn(l2, l))) break;
                    if (n2 >= NCPU || this.cells != cellArray) {
                        bl2 = false;
                    } else if (!bl2) {
                        bl2 = true;
                    } else if (this.busy == 0 && this.casBusy()) {
                        try {
                            if (this.cells == cellArray) {
                                cellArray2 = new Cell[n2 << 1];
                                for (int i = 0; i < n2; ++i) {
                                    cellArray2[i] = cellArray[i];
                                }
                                this.cells = cellArray2;
                            }
                        }
                        finally {
                            this.busy = 0;
                        }
                        bl2 = false;
                        continue;
                    }
                }
                n ^= n << 13;
                n ^= n >>> 17;
                n ^= n << 5;
                continue;
            }
            if (this.busy == 0 && this.cells == cellArray && this.casBusy()) {
                boolean bl4 = false;
                try {
                    if (this.cells == cellArray) {
                        Cell[] cellArray4 = new Cell[2];
                        cellArray4[n & 1] = new Cell(l);
                        this.cells = cellArray4;
                        bl4 = true;
                    }
                }
                finally {
                    this.busy = 0;
                }
                if (!bl4) continue;
                break;
            }
            l2 = this.base;
            if (this.casBase(l2, this.fn(l2, l))) break;
        }
        hashCode.code = n;
    }

    final void internalReset(long l) {
        Cell[] cellArray = this.cells;
        this.base = l;
        if (cellArray != null) {
            for (Cell cell : cellArray) {
                if (cell == null) continue;
                cell.value = l;
            }
        }
    }

    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException securityException) {
            try {
                return AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>(){

                    @Override
                    public Unsafe run() throws Exception {
                        Class<Unsafe> clazz = Unsafe.class;
                        for (Field field : clazz.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object object = field.get(null);
                            if (!clazz.isInstance(object)) continue;
                            return (Unsafe)clazz.cast(object);
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            catch (PrivilegedActionException privilegedActionException) {
                throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
            }
        }
    }

    static {
        try {
            UNSAFE = Striped64.getUnsafe();
            Class<Striped64> clazz = Striped64.class;
            baseOffset = UNSAFE.objectFieldOffset(clazz.getDeclaredField("base"));
            busyOffset = UNSAFE.objectFieldOffset(clazz.getDeclaredField("busy"));
        }
        catch (Exception exception) {
            throw new Error(exception);
        }
    }

    public static final class ThreadHashCode
    extends ThreadLocal<HashCode> {
        ThreadHashCode() {
        }

        @Override
        public HashCode initialValue() {
            return new HashCode();
        }
    }

    public static final class HashCode {
        static final Random rng = new Random();
        int code;

        HashCode() {
            int n = rng.nextInt();
            this.code = n == 0 ? 1 : n;
        }
    }

    public static final class Cell {
        volatile long p0;
        volatile long p1;
        volatile long p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;
        volatile long value;
        volatile long q0;
        volatile long q1;
        volatile long q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        Cell(long l) {
            this.value = l;
        }

        final boolean cas(long l, long l2) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, l, l2);
        }

        static {
            try {
                UNSAFE = Striped64.getUnsafe();
                Class<Cell> clazz = Cell.class;
                valueOffset = UNSAFE.objectFieldOffset(clazz.getDeclaredField("value"));
            }
            catch (Exception exception) {
                throw new Error(exception);
            }
        }
    }
}

