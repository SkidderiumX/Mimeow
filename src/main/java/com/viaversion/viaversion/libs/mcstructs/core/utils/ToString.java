/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ToString {
    private final Class<?> clazz;
    private final List<String> fields;

    public static ToString of(Object object) {
        return ToString.of(object.getClass());
    }

    public static ToString of(Class<?> clazz) {
        return new ToString(clazz);
    }

    private ToString(Class<?> clazz) {
        this.clazz = clazz;
        this.fields = new ArrayList<String>();
    }

    public <T> ToString add(String string, T t) {
        return this.add(string, t, object -> true);
    }

    public <T> ToString add(String string, T t, Predicate<T> predicate) {
        return this.add(string, t, predicate, String::valueOf);
    }

    public <T> ToString add(String string, T t, Predicate<T> predicate, Function<T, String> function) {
        if (predicate.test(t)) {
            String string2 = function.apply(t);
            if (t instanceof String) {
                string2 = "'" + string2 + "'";
            }
            this.fields.add(string + "=" + string2);
        }
        return this;
    }

    public <T> ToString put(String string, T t) {
        return this.add(string, t);
    }

    public <T> ToString put(String string, T t, Predicate<T> predicate) {
        return this.add(string, t, predicate);
    }

    public String toString() {
        return this.clazz.getSimpleName() + "{" + String.join((CharSequence)", ", this.fields) + "}";
    }
}

