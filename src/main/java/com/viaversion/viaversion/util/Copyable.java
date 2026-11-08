/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.Tag;
import java.lang.reflect.Array;

public interface Copyable {
    public static <T> T copy(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Tag) {
            Tag tag = (Tag)t;
            return (T)tag.copy();
        }
        if (t instanceof Copyable) {
            Copyable copyable = (Copyable)t;
            return (T)copyable.copy();
        }
        if (t.getClass().isArray()) {
            Class<?> clazz = t.getClass().getComponentType();
            int n = Array.getLength(t);
            Object object = Array.newInstance(clazz, n);
            if (clazz.isPrimitive()) {
                for (int i = 0; i < n; ++i) {
                    Array.set(object, i, Array.get(t, i));
                }
            } else {
                for (int i = 0; i < n; ++i) {
                    Array.set(object, i, Copyable.copy(Array.get(t, i)));
                }
            }
            return (T)object;
        }
        return t;
    }

    public Object copy();
}

