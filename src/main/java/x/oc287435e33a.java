/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.potion.Potion;

public class oc287435e33a
extends Record {
    private final Potion \u04ed;
    private final String \u04e3;
    private final String \u03b6;
    private final float \u0571;
    private final float \u0499;

    private oc287435e33a(Potion potion, String string, String string2, float f, float f2) {
        this.\u04ed = potion;
        this.\u04e3 = string;
        this.\u03b6 = string2;
        this.\u0571 = f;
        this.\u0499 = f2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{oc287435e33a.class, "\u04ed;\u04e3;\u03b6;\u0571;\u0499", "\u04ed", "\u04e3", "\u03b6", "\u0571", "\u0499"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{oc287435e33a.class, "\u04ed;\u04e3;\u03b6;\u0571;\u0499", "\u04ed", "\u04e3", "\u03b6", "\u0571", "\u0499"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{oc287435e33a.class, "\u04ed;\u04e3;\u03b6;\u0571;\u0499", "\u04ed", "\u04e3", "\u03b6", "\u0571", "\u0499"}, this, object);
    }

    public Potion \u04ec() {
        return this.\u04ed;
    }

    public String \u04e2() {
        return this.\u04e3;
    }

    public String \u0396() {
        return this.\u03b6;
    }

    public float \u0571() {
        return this.\u0571;
    }

    public float \u0498() {
        return this.\u0499;
    }
}

