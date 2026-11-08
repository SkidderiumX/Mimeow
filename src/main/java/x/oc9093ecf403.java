/*
 * Decompiled with CFR 0.152.
 */
package x;

public enum oc9093ecf403 {
    Z;
    private static final oc9093ecf403[] $VALUES_REF;

    public static final /* enum */ oc9093ecf403 \u0218 = new oc9093ecf403(true, false);
    public static final /* enum */ oc9093ecf403 \u03ab = new oc9093ecf403(false, true);
    public static final /* enum */ oc9093ecf403 \u028c = new oc9093ecf403(true, true);
    private final boolean \u04dd;
    private final boolean \u0581;
    private static final /* synthetic */ oc9093ecf403[] \u03ff;
    public static boolean \u0109;



    private oc9093ecf403(boolean bl, boolean bl2) {
        this.\u04dd = bl;
        this.\u0581 = bl2;
    }

    public boolean \u027e() {
        return this.\u04dd;
    }

    public boolean E() {
        return this.\u0581;
    }

    private static /* synthetic */ oc9093ecf403[] \u01cc() {
        oc9093ecf403[] oc9093ecf403Array = new oc9093ecf403[0x7892B23F ^ 0x7892B23B];
        oc9093ecf403Array[0] = Z;
        oc9093ecf403Array[1] = \u0218;
        oc9093ecf403Array[0x7892B239 ^ 0x7892B23B] = \u03ab;
        oc9093ecf403Array[0x7892B238 ^ 0x7892B23B] = \u028c;
        return oc9093ecf403Array;
    }

    static {
        \u03ff = oc9093ecf403.\u01cc();
    }
}

