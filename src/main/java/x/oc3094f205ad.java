/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc3094f205ad {
    final int \u01dc;
    final float \u0202;
    final float \u0147;
    final float \u04fc;
    final float \u00d1;
    final float J;
    final float \u0393;
    final float \u02a4;
    final float \u0190;

    oc3094f205ad(int n, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.\u01dc = n;
        this.\u0202 = f;
        this.\u0147 = f2;
        this.\u04fc = f3;
        this.\u00d1 = f4;
        this.J = f5;
        this.\u0393 = f6;
        this.\u02a4 = f7;
        this.\u0190 = f8;
    }

    oc3094f205ad \u00f3(float f, float f2) {
        return new oc3094f205ad(this.\u01dc, this.\u0202 + f, this.\u0147 + f2, this.\u04fc + f, this.\u00d1 + f2, this.J + f, this.\u0393, this.\u02a4 + f, this.\u0190 + f);
    }
}

