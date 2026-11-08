/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public class oc2e4efea860
extends Record {
    private final String \u057a;
    private final String \u04f7;
    private final byte[] \u0373;
    private final byte[] \u03f8;

    private oc2e4efea860(String string, String string2, byte[] byArray, byte[] byArray2) {
        this.\u057a = string;
        this.\u04f7 = string2;
        this.\u0373 = byArray;
        this.\u03f8 = byArray2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{oc2e4efea860.class, "\u057a;\u04f7;\u0373;\u03f8", "\u057a", "\u04f7", "\u0373", "\u03f8"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{oc2e4efea860.class, "\u057a;\u04f7;\u0373;\u03f8", "\u057a", "\u04f7", "\u0373", "\u03f8"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{oc2e4efea860.class, "\u057a;\u04f7;\u0373;\u03f8", "\u057a", "\u04f7", "\u0373", "\u03f8"}, this, object);
    }

    public String \u054a() {
        return this.\u057a;
    }

    public String \u04f6() {
        return this.\u04f7;
    }

    public byte[] \u0372() {
        return this.\u0373;
    }

    public byte[] \u03f7() {
        return this.\u03f8;
    }
}

