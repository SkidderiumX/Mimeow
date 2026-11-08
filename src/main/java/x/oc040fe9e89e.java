/*
 * Decompiled with CFR 0.152.
 */
package x;

public enum oc040fe9e89e {
    K, t;
    private static final oc040fe9e89e[] $VALUES_REF;
    public static final /* enum */ oc040fe9e89e \u04eb = new oc040fe9e89e("Terrain");
    public static final /* enum */ oc040fe9e89e \u03be = new oc040fe9e89e("Sky");

    public static final /* enum */ oc040fe9e89e \u0217 = new oc040fe9e89e("BEs");
    public static final /* enum */ oc040fe9e89e \u03d4 = new oc040fe9e89e("Particles");
    public static final /* enum */ oc040fe9e89e \u0291 = new oc040fe9e89e("Text");
    public static final /* enum */ oc040fe9e89e \u04d8 = new oc040fe9e89e("GUI");

    private final String \u021f;
    private static final oc040fe9e89e[] \u0167 = oc040fe9e89e.\u050a();
    public static int \u016b;



    private oc040fe9e89e(String string2) {
        this.\u021f = string2;
    }

    private static oc040fe9e89e[] \u050a() {
        oc040fe9e89e[] oc040fe9e89eArray = new oc040fe9e89e[0x172BA8FF ^ 0x172BA8F7];
        oc040fe9e89eArray[0] = \u04eb;
        oc040fe9e89eArray[1] = \u03be;
        oc040fe9e89eArray[0x172BA8F5 ^ 0x172BA8F7] = K;
        oc040fe9e89eArray[0x172BA8F4 ^ 0x172BA8F7] = \u0217;
        oc040fe9e89eArray[0x172BA8F3 ^ 0x172BA8F7] = \u03d4;
        oc040fe9e89eArray[0x172BA8F2 ^ 0x172BA8F7] = \u0291;
        oc040fe9e89eArray[0x172BA8F1 ^ 0x172BA8F7] = \u04d8;
        oc040fe9e89eArray[0x172BA8F0 ^ 0x172BA8F7] = t;
        return oc040fe9e89eArray;
    }
}

