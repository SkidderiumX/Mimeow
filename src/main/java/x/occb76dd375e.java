/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public class occb76dd375e
extends Record {
    private final String \u0491;
    private final float \u03c4;
    private final float \u024b;
    private final float \u03e1;

    private occb76dd375e(String string, float f, float f2, float f3) {
        this.\u0491 = string;
        this.\u03c4 = f;
        this.\u024b = f2;
        this.\u03e1 = f3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{occb76dd375e.class, "\u0491;\u03c4;\u024b;\u03e1", "\u0491", "\u03c4", "\u024b", "\u03e1"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{occb76dd375e.class, "\u0491;\u03c4;\u024b;\u03e1", "\u0491", "\u03c4", "\u024b", "\u03e1"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{occb76dd375e.class, "\u0491;\u03c4;\u024b;\u03e1", "\u0491", "\u03c4", "\u024b", "\u03e1"}, this, object);
    }

    public String \u0490() {
        return this.\u0491;
    }

    public float \u03c4() {
        return this.\u03c4;
    }

    public float \u024a() {
        return this.\u024b;
    }

    public float \u03e1() {
        return this.\u03e1;
    }
}

