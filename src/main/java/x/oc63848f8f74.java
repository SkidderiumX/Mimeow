/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public class oc63848f8f74
extends Record {
    private final String \u046b;
    private final String \u03d9;

    oc63848f8f74(String string, String string2) {
        this.\u046b = string;
        this.\u03d9 = string2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{oc63848f8f74.class, "\u046b;\u03d9", "\u046b", "\u03d9"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{oc63848f8f74.class, "\u046b;\u03d9", "\u046b", "\u03d9"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{oc63848f8f74.class, "\u046b;\u03d9", "\u046b", "\u03d9"}, this, object);
    }

    public String \u046a() {
        return this.\u046b;
    }

    public String \u03d9() {
        return this.\u03d9;
    }
}

