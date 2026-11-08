/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc05d664c647 {
    public static final double \u027b = 1.0;
    public static final double \u0269 = 0.9;
    public static final double \u04f2 = 1.1111111111111112;

    private oc05d664c647() {
    }

    public static float \u04e8(double d) {
        return (float)(oc05d664c647.\u043c(d) * 0.9);
    }

    public static double \u026a(double d) {
        return Double.isFinite(d) ? d * 1.1111111111111112 : 1.0;
    }

    public static double \u023c(double d, double d2, double d3) {
        double d4 = oc05d664c647.\u026a(d);
        return Math.max(d2, Math.min(d3, d4));
    }

    private static double \u043c(double d) {
        return Double.isFinite(d) ? d : 1.0;
    }
}

