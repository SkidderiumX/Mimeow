/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.AWTError;
import x.oc4e871be632;
import x.oc69da1aa7f5;
import x.oc6ee405a8e2;
import x.oca4e1585b34;

public class oc95a52a4046 {
    private static final oc95a52a4046 \u04be = new oc95a52a4046(new oca4e1585b34(), new oc6ee405a8e2());
    private final oc4e871be632 \u014c;
    private final oc4e871be632 \u0452;
    private String \u01f8 = "";
    public static int \u03bd;

    oc95a52a4046(oc4e871be632 oc4e871be6322, oc4e871be632 oc4e871be6323) {
        this.\u014c = oc4e871be6322;
        this.\u0452 = oc4e871be6323;
    }

    public static String \u0217() {
        return \u04be.\u04f8();
    }

    public static void \u016e(String string) {
        \u04be.\u0157(string);
    }

    synchronized String \u04f8() {
        String string;
        block14: {
            boolean bl;
            block16: {
                block15: {
                    int n;
                    block12: {
                        block13: {
                            String string2;
                            block10: {
                                block11: {
                                    string2 = oc95a52a4046.\u013e(this.\u014c);
                                    n = \u03bd;
                                    string = string2;
                                    if (n != 0) break block10;
                                    if (string != null) break block11;
                                    string2 = oc95a52a4046.\u013e(this.\u0452);
                                }
                                string = string2;
                            }
                            if (n != 0) break block12;
                            if (string == null) break block13;
                            this.\u01f8 = string2;
                            return string2;
                        }
                        string = this.\u01f8;
                    }
                    if (n == 0) break block14;
                    if (!false) break block15;
                    bl = false;
                    break block16;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return string;
    }

    synchronized void \u0157(String string) {
        block8: {
            String string2;
            oc4e871be632 oc4e871be6322;
            block7: {
                int n = \u03bd;
                if (string == null) {
                    return;
                }
                this.\u01f8 = string;
                oc4e871be6322 = this.\u014c;
                string2 = string;
                if (n != 0) break block7;
                if (oc95a52a4046.\u0251(oc4e871be6322, string2)) break block8;
                oc4e871be6322 = this.\u0452;
                string2 = string;
            }
            oc95a52a4046.\u0251(oc4e871be6322, string2);
        }
    }

    private static String \u013e(oc4e871be632 oc4e871be6322) {
        try {
            return oc4e871be6322.z$qwjgoq304pul();
        }
        catch (AWTError | Exception | LinkageError throwable) {
            return null;
        }
    }

    private static boolean \u0251(oc4e871be632 oc4e871be6322, String string) {
        try {
            return oc4e871be6322.z$1w9fm5zod4yek(string);
        }
        catch (AWTError | Exception | LinkageError throwable) {
            return false;
        }
    }
}

