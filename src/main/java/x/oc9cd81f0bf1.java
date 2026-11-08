/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import x.oc7ab2161b9f;
import x.oc93499ec6de;
import x.oce6044968f8;

public class oc9cd81f0bf1
extends Record {
    private final float \u0239;
    private final int \u017a;
    private final boolean \u04ef;
    private final int \u0149;
    private final float \u057e;
    private final boolean \u0463;
    private final int \u037c;
    private final float \u00e3;
    private final int \u022f;
    public static int \u04ff;

    public oc9cd81f0bf1(float f, int n, boolean bl, int n2, float f2, boolean bl2, int n3, float f3, int n4) {
        this.\u0239 = f;
        this.\u017a = n;
        this.\u04ef = bl;
        this.\u0149 = n2;
        this.\u057e = f2;
        this.\u0463 = bl2;
        this.\u037c = n3;
        this.\u00e3 = f3;
        this.\u022f = n4;
    }

    public static oc9cd81f0bf1 \u044b(float f, int n, boolean bl, boolean bl2) {
        double d;
        int n2;
        oc93499ec6de oc93499ec6de2;
        block2: {
            block3: {
                oc93499ec6de2 = oce6044968f8.\u015c();
                boolean bl3 = oce6044968f8.\u0452;
                n2 = Math.round((float)oc93499ec6de2.\u0405.\u04c1());
                double d2 = oc93499ec6de2.\u02a4.\u04c1() - 2.0;
                d = d2 == 0.0 ? 0 : (d2 > 0.0 ? 1 : -1);
                if (bl3) break block2;
                if (d != false) break block3;
                d = -1;
                break block2;
            }
            d = 0x921FE79F ^ 0x6D1FE79F;
        }
        double d3 = d;
        return new oc9cd81f0bf1(f, n, bl, (int)oc93499ec6de2.\u03f7.\u04c1(), oce6044968f8.\u018a(), bl2, (int)oc93499ec6de2.\u0517.\u04c1(), oce6044968f8.\u01f4(), oc7ab2161b9f.\u04ac((int)d3, n2));
    }

    public static oc9cd81f0bf1 \u04ce(float f, int n, boolean bl, float f2, boolean bl2, float f3) {
        return new oc9cd81f0bf1(f, n, bl, 0xF3504CF3 ^ 0xF3504CF1, f2, bl2, 0xF3504CF3 ^ 0xF3504CF1, f3, -1);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{oc9cd81f0bf1.class, "\u0239;\u017a;\u04ef;\u0149;\u057e;\u0463;\u037c;\u00e3;\u022f", "\u0239", "\u017a", "\u04ef", "\u0149", "\u057e", "\u0463", "\u037c", "\u00e3", "\u022f"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{oc9cd81f0bf1.class, "\u0239;\u017a;\u04ef;\u0149;\u057e;\u0463;\u037c;\u00e3;\u022f", "\u0239", "\u017a", "\u04ef", "\u0149", "\u057e", "\u0463", "\u037c", "\u00e3", "\u022f"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{oc9cd81f0bf1.class, "\u0239;\u017a;\u04ef;\u0149;\u057e;\u0463;\u037c;\u00e3;\u022f", "\u0239", "\u017a", "\u04ef", "\u0149", "\u057e", "\u0463", "\u037c", "\u00e3", "\u022f"}, this, object);
    }

    public float \u0239() {
        return this.\u0239;
    }

    public int \u017a() {
        return this.\u017a;
    }

    public boolean \u04ef() {
        return this.\u04ef;
    }

    public int \u0149() {
        return this.\u0149;
    }

    public float \u057e() {
        return this.\u057e;
    }

    public boolean \u0462() {
        return this.\u0463;
    }

    public int \u03fe() {
        return this.\u037c;
    }

    public float \u00e3() {
        return this.\u00e3;
    }

    public int \u022f() {
        return this.\u022f;
    }
}

