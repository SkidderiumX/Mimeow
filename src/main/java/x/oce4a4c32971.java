/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc3004491957;
import x.oc62a465bc97;
import x.oc98904eb9e7;
import x.ocd9db3ede42;

public class oce4a4c32971 {
    public ocd9db3ede42 \u04e0;
    public ocd9db3ede42 \u040e;
    public float \u04fb;
    public float \u012e;
    public float \u0527;
    public float \u028a;
    public int \u03fb = 1;
    public int \u045a;
    public boolean \u0198;
    final ocd9db3ede42[] \u00ff = new ocd9db3ede42[0x12E96BC0 ^ 0x12E96BC4];

    oce4a4c32971(ocd9db3ede42 ocd9db3ede422, float f, float f2) {
        this.\u04e0 = ocd9db3ede422;
        this.\u04fb = f;
        this.\u012e = f2;
        this.\u028a = ocd9db3ede422.\u00c8;
        this.\u0527 = ocd9db3ede422.\u0151;
    }

    private void \u04bc(float f) {
        if (this.\u045a != 0) {
            int n = this.\u045a - 1;
            ocd9db3ede42 ocd9db3ede422 = this.\u00ff[n & (0xE1816F52 ^ 0xE1816F51)];
            float f2 = ocd9db3ede422.\u0151 + ocd9db3ede422.\u0462;
            float f3 = f;
            for (int i = n - n % this.\u03fb; i <= n; ++i) {
                f3 = oc62a465bc97.\u057f(f2, f3);
            }
            if (f3 != f) {
                this.\u0527 = f3 + this.\u04fb;
            }
        }
    }

    public void \u03b1(int n) {
        this.\u04bc(oc98904eb9e7.\u0132(0x8A565B19 ^ 0x8A42533D));
        this.\u03fb = n == 0 ? 1 : Math.min(0x8A425339 ^ 0x8A42533D, n);
        this.\u045a = 0;
    }

    public void \u00ee(float f) {
        this.\u04bc(oc98904eb9e7.\u0132(0x8B5950E6 ^ 0x8B4D58CE));
        this.\u03fb = oc3004491957.\u0182((this.\u04e0.\u0423 + this.\u04fb) / (f + this.\u04fb));
        this.\u03fb = this.\u03fb == 0 ? 1 : Math.min(0x8B4D58CA ^ 0x8B4D58CE, this.\u03fb);
        this.\u045a = 0;
    }

    public ocd9db3ede42 \u027d(float f) {
        float f2;
        float f3;
        float f4;
        ocd9db3ede42 ocd9db3ede422;
        int n;
        ocd9db3ede42 ocd9db3ede423;
        ocd9db3ede42 ocd9db3ede424 = ocd9db3ede423 = (n = this.\u045a++) >= this.\u03fb ? this.\u00ff[n - this.\u03fb & (0x61FAFE50 ^ 0x61FAFE53)] : null;
        if (n % this.\u03fb != 0) {
            ocd9db3ede422 = this.\u00ff[n - 1 & (0x61FAFE50 ^ 0x61FAFE53)];
            f4 = ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423 + this.\u04fb;
            f3 = ocd9db3ede422.\u0423;
            f2 = n >= this.\u03fb ? this.\u04fb + (ocd9db3ede423.\u0151 + ocd9db3ede423.\u0462) : this.\u0527;
        } else {
            f4 = this.\u028a;
            if (n < this.\u03fb) {
                f2 = this.\u0527;
                f3 = (this.\u04e0.\u0423 - (float)(this.\u03fb - 1) * this.\u04fb) / (float)this.\u03fb;
            } else {
                f2 = ocd9db3ede423.\u0151 + ocd9db3ede423.\u0462 + this.\u04fb;
                f3 = ocd9db3ede423.\u0423;
            }
        }
        this.\u00ff[n & (0x61FAFE50 ^ 0x61FAFE53)] = ocd9db3ede422 = new ocd9db3ede42(f4, f2, f3, f);
        return oc98904eb9e7.\u03aa(ocd9db3ede422);
    }

    public float \u054b() {
        this.\u04bc(oc98904eb9e7.\u0132(0xB49847AD ^ 0xB48C4F8D));
        return this.\u04fb + this.\u04fb + (this.\u0527 - this.\u04e0.\u0151);
    }
}

