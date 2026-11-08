/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.lang.reflect.Array;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeBoundList<T> {
    private final T[] field_152759_a;
    private final Class<? extends T> field_152760_b;
    private final ReadWriteLock field_152761_c = new ReentrantReadWriteLock();
    private int field_152762_d;
    private int field_152763_e;

    public ThreadSafeBoundList(Class<? extends T> clazz, int n) {
        this.field_152760_b = clazz;
        this.field_152759_a = (Object[])Array.newInstance(clazz, n);
    }

    public T func_152757_a(T t) {
        this.field_152761_c.writeLock().lock();
        this.field_152759_a[this.field_152763_e] = t;
        this.field_152763_e = (this.field_152763_e + 1) % this.func_152758_b();
        if (this.field_152762_d < this.func_152758_b()) {
            ++this.field_152762_d;
        }
        this.field_152761_c.writeLock().unlock();
        return t;
    }

    public int func_152758_b() {
        this.field_152761_c.readLock().lock();
        int n = this.field_152759_a.length;
        this.field_152761_c.readLock().unlock();
        return n;
    }

    public T[] func_152756_c() {
        Object[] objectArray = (Object[])Array.newInstance(this.field_152760_b, this.field_152762_d);
        this.field_152761_c.readLock().lock();
        for (int i = 0; i < this.field_152762_d; ++i) {
            int n = (this.field_152763_e - this.field_152762_d + i) % this.func_152758_b();
            if (n < 0) {
                n += this.func_152758_b();
            }
            objectArray[i] = this.field_152759_a[n];
        }
        this.field_152761_c.readLock().unlock();
        return objectArray;
    }
}

