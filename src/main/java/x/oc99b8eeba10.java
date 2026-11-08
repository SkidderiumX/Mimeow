/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public class oc99b8eeba10
extends Record {
    private final float \u04e9;
    private final float \u026a;
    private final float \u0167;
    private final float \u04ce;
    private final float \u01f9;
    private final Runnable \u0267;
    private final Runnable \u04b1;
    public static int \u053a;

    public oc99b8eeba10(float f, float f2, float f3, float f4, Runnable runnable2) {
        this(f, f2, f3, f4, 1.0f, runnable2, null);
    }

    public oc99b8eeba10(float f, float f2, float f3, float f4, float f5, Runnable runnable2, Runnable runnable3) {
        this.\u04e9 = f;
        this.\u026a = f2;
        this.\u0167 = f3;
        this.\u04ce = f4;
        this.\u01f9 = f5;
        this.\u0267 = runnable2;
        this.\u04b1 = runnable3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{oc99b8eeba10.class, "\u04e9;\u026a;\u0167;\u04ce;\u01f9;\u0267;\u04b1", "\u04e9", "\u026a", "\u0167", "\u04ce", "\u01f9", "\u0267", "\u04b1"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{oc99b8eeba10.class, "\u04e9;\u026a;\u0167;\u04ce;\u01f9;\u0267;\u04b1", "\u04e9", "\u026a", "\u0167", "\u04ce", "\u01f9", "\u0267", "\u04b1"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{oc99b8eeba10.class, "\u04e9;\u026a;\u0167;\u04ce;\u01f9;\u0267;\u04b1", "\u04e9", "\u026a", "\u0167", "\u04ce", "\u01f9", "\u0267", "\u04b1"}, this, object);
    }

    public float \u04e8() {
        return this.\u04e9;
    }

    public float \u026a() {
        return this.\u026a;
    }

    public float \u0166() {
        return this.\u0167;
    }

    public float \u04cd() {
        return this.\u04ce;
    }

    public float \u01f9() {
        return this.\u01f9;
    }

    public Runnable \u0267() {
        return this.\u0267;
    }

    public Runnable \u04b0() {
        return this.\u04b1;
    }
}

