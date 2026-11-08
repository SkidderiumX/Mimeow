/*
 * Decompiled with CFR 0.152.
 */
package x;

public class ocd9db3ede42 {
    public final float \u00c8;
    public final float \u0151;
    public final float \u0423;
    public final float \u0462;

    public ocd9db3ede42(float f, float f2, float f3, float f4) {
        this.\u00c8 = f;
        this.\u0151 = f2;
        this.\u0423 = f3;
        this.\u0462 = f4;
    }

    public boolean \u011e(float f, float f2) {
        return f >= this.\u00c8 && f2 >= this.\u0151 && this.\u00c8 + this.\u0423 > f && this.\u0151 + this.\u0462 > f2;
    }

    public ocd9db3ede42 \u0427(float f) {
        return new ocd9db3ede42(f + this.\u00c8, f + this.\u0151, this.\u0423 - (f + f), this.\u0462 - (f + f));
    }
}

