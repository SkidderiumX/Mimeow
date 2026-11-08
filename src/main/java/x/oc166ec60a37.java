/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc70db705765;

public class oc166ec60a37 {
    public float \u04b0;
    public float \u0520;
    public boolean \u0449;
    public boolean \u00e5;
    public static boolean \u0217;

    public oc166ec60a37(oc70db705765 oc70db7057652, byte by) {
        this.\u04b0 = oc70db7057652.\u0509();
        this.\u0520 = oc70db7057652.\u01f6();
        this.\u0449 = oc70db7057652.\u03e7();
        this.\u00e5 = oc70db7057652.\u04a7();
    }

    public oc166ec60a37(float f, float f2, boolean bl, boolean bl2) {
        this.\u04b0 = f;
        this.\u0520 = f2;
        this.\u0449 = bl;
        this.\u00e5 = bl2;
    }

    public oc166ec60a37(Object[] objectArray) {
        this.\u04b0 = ((Float)objectArray[0]).floatValue();
        this.\u0520 = ((Float)objectArray[1]).floatValue();
        this.\u0449 = (Boolean)objectArray[0xBF1F404A ^ 0xBF1F4048];
        this.\u00e5 = (Boolean)objectArray[0xBF1F404B ^ 0xBF1F4048];
    }

    public Object[] \u01de() {
        Object[] objectArray = new Object[0x6DF23903 ^ 0x6DF23907];
        objectArray[0] = Float.valueOf(this.\u04b0);
        objectArray[1] = Float.valueOf(this.\u0520);
        objectArray[0x6DF23905 ^ 0x6DF23907] = this.\u0449;
        objectArray[0x6DF23904 ^ 0x6DF23907] = this.\u00e5;
        return objectArray;
    }

    public boolean \u0404(oc166ec60a37 oc166ec60a372) {
        boolean bl;
        block26: {
            block23: {
                oc166ec60a37 oc166ec60a373;
                block25: {
                    oc166ec60a37 oc166ec60a374;
                    boolean bl2;
                    block24: {
                        block22: {
                            block20: {
                                block21: {
                                    bl2 = \u0217;
                                    oc166ec60a374 = oc166ec60a372;
                                    if (bl2) break block20;
                                    if (oc166ec60a374 != null) break block21;
                                    return false;
                                }
                                oc166ec60a374 = this;
                            }
                            if (bl2) break block22;
                            if (oc166ec60a374.\u04b0 != oc166ec60a372.\u04b0) break block23;
                            oc166ec60a374 = this;
                        }
                        if (bl2) break block24;
                        if (oc166ec60a374.\u0520 != oc166ec60a372.\u0520) break block23;
                        oc166ec60a374 = this;
                    }
                    bl = oc166ec60a374.\u0449;
                    oc166ec60a373 = oc166ec60a372;
                    if (bl2) break block25;
                    if (bl != oc166ec60a373.\u0449) break block23;
                    bl = this.\u00e5;
                    if (bl2) break block26;
                    oc166ec60a373 = oc166ec60a372;
                }
                if (bl != oc166ec60a373.\u00e5) break block23;
                bl = true;
                break block26;
            }
            bl = false;
        }
        return bl;
    }
}

