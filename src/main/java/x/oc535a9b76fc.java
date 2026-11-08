/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc535a9b76fc {
    private double \u017e;
    private double \u0510;

    private oc535a9b76fc(double d, double d2) {
        this.\u017e = d;
        this.\u0510 = d2;
    }

    private void S(oc535a9b76fc oc535a9b76fc2) {
        this.\u017e += oc535a9b76fc2.\u017e;
        this.\u0510 += oc535a9b76fc2.\u0510;
    }

    private double \u0200(oc535a9b76fc oc535a9b76fc2) {
        return this.\u017e * oc535a9b76fc2.\u017e + this.\u0510 * oc535a9b76fc2.\u0510;
    }

    private double \u03d6() {
        return Math.sqrt(this.\u017e * this.\u017e + this.\u0510 * this.\u0510);
    }
}

