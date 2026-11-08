/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oce79181588d;

public class oc7ebeda7e63 {
    private final float \u0140;
    private final float \u0575;
    private float \u03cb;
    private float \u010b;
    private float \u04bb;
    private float \u0282;
    private boolean \u048c;
    private boolean \u019d;
    private float \u046f = Float.POSITIVE_INFINITY;
    public static int \u0550;

    public oc7ebeda7e63(float f, float f2, float f3) {
        this(f, f2, f3, f3);
    }

    public oc7ebeda7e63(float f, float f2, float f3, float f4) {
        this.\u0140 = f;
        this.\u0575 = f2;
        this.\u03cb = f;
        this.\u010b = f2;
        this.\u04bb = f3;
        this.\u0282 = f4;
    }

    public boolean \u018c() {
        float f;
        block6: {
            block8: {
                block7: {
                    int n = oce79181588d.\u022d;
                    float f2 = this.\u0140 - this.\u03cb;
                    f = f2 == 0.0f ? 0 : (f2 > 0.0f ? 1 : -1);
                    if (n != 0) break block6;
                    if (f != false) break block7;
                    float f3 = this.\u0575 - this.\u010b;
                    f = f3 == 0.0f ? 0 : (f3 > 0.0f ? 1 : -1);
                    if (n != 0) break block6;
                    if (f == false) break block8;
                }
                f = 1.0f;
                break block6;
            }
            f = 0.0f;
        }
        return (boolean)f;
    }

    public float \u050b() {
        return this.\u03cb;
    }

    public void \u03a0(float f) {
        this.\u03cb = f;
    }

    public float \u0266() {
        return this.\u010b;
    }

    public void \u04fe(float f) {
        this.\u010b = f;
    }

    public float \u025f() {
        return Math.max(this.\u04bb, this.\u0282);
    }

    public void Z(float f) {
        this.\u04bb = f;
        this.\u0282 = f;
    }

    public float \u01e3() {
        return this.\u04bb;
    }

    public void \u0546(float f) {
        this.\u04bb = f;
    }

    public float \u0172() {
        return this.\u0282;
    }

    public void w(float f) {
        this.\u0282 = f;
    }

    public boolean \u02a7() {
        return this.\u048c;
    }

    public void \u0459(boolean bl) {
        this.\u048c = bl;
    }

    public boolean \u0524() {
        return this.\u019d;
    }

    public void \u04ee(boolean bl) {
        this.\u019d = bl;
    }

    public void \u057b(float f) {
        float f2;
        block6: {
            float f3;
            block4: {
                block5: {
                    int n = oce79181588d.\u022d;
                    oc7ebeda7e63 oc7ebeda7e632 = this;
                    f3 = f;
                    if (n != 0) break block4;
                    if (!Float.isNaN(f3)) break block5;
                    f2 = Float.POSITIVE_INFINITY;
                    break block6;
                }
                f3 = 0.0f;
            }
            f2 = Math.max(f3, f);
        }
        oc7ebeda7e632.\u046f = f2;
    }

    public float \u0511() {
        return this.\u046f;
    }
}

