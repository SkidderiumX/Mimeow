/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc70db705765;
import x.occ0b63c0426;

public class oc03c41781f6 {
    public float J;
    public float \u0212;
    public boolean \u0430;
    public boolean \u053f;
    public double \u0462 = 0.3;
    public static int \u015f;

    public oc03c41781f6() {
    }

    public oc03c41781f6(float f, float f2, boolean bl, boolean bl2, double d) {
        this.J = f;
        this.\u0212 = f2;
        this.\u0430 = bl;
        this.\u053f = bl2;
        this.\u0462 = d;
    }

    public oc03c41781f6(float f, float f2, boolean bl, boolean bl2) {
        this(f, f2, bl, bl2, 0.3);
    }

    public oc03c41781f6(oc70db705765 oc70db7057652, byte by) {
        this(oc70db7057652 == null ? 0.0f : oc70db7057652.\u0509(), oc70db7057652 == null ? 0.0f : oc70db7057652.\u01f6(), oc70db7057652 != null && oc70db7057652.\u03e7(), oc70db7057652 != null && oc70db7057652.\u04a7(), oc70db7057652 == null ? 0.3 : oc70db7057652.\u016b());
    }

    public oc03c41781f6(Object[] objectArray) {
        this(objectArray == null ? 0.0f : (float)oc03c41781f6.d(objectArray, 0, 0.0), objectArray == null ? 0.0f : (float)oc03c41781f6.d(objectArray, 1, 0.0), objectArray != null && oc03c41781f6.C(objectArray, 0x5D1F0739 ^ 0x5D1F073B), objectArray != null && oc03c41781f6.C(objectArray, 0x5D1F0738 ^ 0x5D1F073B), objectArray == null ? 0.3 : oc03c41781f6.d(objectArray, 0x5D1F073F ^ 0x5D1F073B, 0.3));
    }

    public Object[] \u01ad() {
        Object[] objectArray = new Object[0x50D4735D ^ 0x50D47359];
        objectArray[0] = Float.valueOf(this.J);
        objectArray[1] = Float.valueOf(this.\u0212);
        objectArray[0x50D4735B ^ 0x50D47359] = this.\u0430;
        objectArray[0x50D4735A ^ 0x50D47359] = this.\u053f;
        return objectArray;
    }

    public boolean \u039d(oc03c41781f6 oc03c41781f62) {
        boolean bl;
        block23: {
            block19: {
                int n;
                block22: {
                    oc03c41781f6 oc03c41781f63;
                    block21: {
                        float f;
                        float f2;
                        block20: {
                            oc03c41781f6 oc03c41781f64;
                            block18: {
                                n = occ0b63c0426.\u039f;
                                oc03c41781f64 = oc03c41781f62;
                                if (n != 0) break block18;
                                if (oc03c41781f64 == null) break block19;
                                oc03c41781f64 = this;
                            }
                            f2 = oc03c41781f64.J;
                            f = oc03c41781f62.J;
                            if (n != 0) break block20;
                            if (f2 != f) break block19;
                            oc03c41781f63 = this;
                            if (n != 0) break block21;
                            f2 = oc03c41781f63.\u0212;
                            f = oc03c41781f62.\u0212;
                        }
                        if (f2 != f) break block19;
                        oc03c41781f63 = this;
                    }
                    bl = oc03c41781f63.\u0430;
                    if (n != 0) break block22;
                    if (bl != oc03c41781f62.\u0430) break block19;
                    bl = this.\u053f;
                }
                if (n != 0) break block23;
                if (bl != oc03c41781f62.\u053f) break block19;
                bl = true;
                break block23;
            }
            bl = false;
        }
        return bl;
    }

    private static double d(Object[] objectArray, int n, double d) {
        double d2;
        block11: {
            block9: {
                Object object;
                block10: {
                    int n2;
                    block8: {
                        int n3 = occ0b63c0426.\u039f;
                        n2 = n;
                        if (n3 != 0) break block8;
                        if (n2 >= objectArray.length) break block9;
                        object = objectArray;
                        if (n3 != 0) break block10;
                        n2 = object[n] instanceof Number;
                    }
                    if (n2 == 0) break block9;
                    object = objectArray[n];
                }
                d2 = ((Number)object).doubleValue();
                break block11;
            }
            d2 = d;
        }
        return d2;
    }

    private static boolean C(Object[] objectArray, int n) {
        boolean bl;
        block13: {
            block11: {
                int n2;
                Object[] objectArray2;
                int n3;
                block12: {
                    int n4;
                    block10: {
                        n3 = occ0b63c0426.\u039f;
                        n4 = n;
                        if (n3 != 0) break block10;
                        if (n4 >= objectArray.length) break block11;
                        objectArray2 = objectArray;
                        n2 = n;
                        if (n3 != 0) break block12;
                        n4 = objectArray2[n2] instanceof Boolean;
                    }
                    if (n4 == 0) break block11;
                    objectArray2 = objectArray;
                    n2 = n;
                }
                bl = (Boolean)objectArray2[n2];
                if (n3 != 0) break block13;
                if (!bl) break block11;
                bl = true;
                break block13;
            }
            bl = false;
        }
        return bl;
    }
}

