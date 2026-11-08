/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.Q;

public class ocbe9732642b {
    public static final String \u0278 = "miau.client.version";
    public static final String \u0167 = "miau.client.displayName";
    public static int \u020d;

    private ocbe9732642b() {
    }

    public static String \u012f() {
        return ocbe9732642b.\u00ea("2.5");
    }

    public static String \u00ea(String string) {
        return ocbe9732642b.\u04d0(string, "");
    }

    public static String \u04d0(String string, String string2) {
        String string3 = ocbe9732642b.\u0573(string, "2.5");
        return "Miau " + string3;
    }

    private static String \u0573(String string, String string2) {
        String string3;
        block25: {
            String string4;
            block26: {
                StringBuilder stringBuilder;
                boolean bl;
                block21: {
                    String string5;
                    block19: {
                        block20: {
                            bl = Q.\u02a7;
                            string5 = string;
                            if (bl) break block19;
                            if (string5 != null) break block20;
                            string5 = "";
                            break block19;
                        }
                        string5 = string;
                    }
                    String string6 = string5;
                    StringBuilder stringBuilder2 = new StringBuilder(Math.min(string6.length(), 0x2D0BE891 ^ 0x2D0BE8D1));
                    for (int i = 0; i < string6.length(); ++i) {
                        int n;
                        StringBuilder stringBuilder3;
                        block22: {
                            int n2;
                            block24: {
                                block23: {
                                    stringBuilder = stringBuilder2;
                                    if (bl || bl) break block21;
                                    if (stringBuilder.length() >= (0x2D0BE891 ^ 0x2D0BE8D1)) break;
                                    n2 = string6.charAt(i);
                                    stringBuilder3 = stringBuilder2;
                                    n = n2;
                                    if (bl) break block22;
                                    if (n < (0x2D0BE8F1 ^ 0x2D0BE8D1)) break block23;
                                    n = n2;
                                    if (bl) break block22;
                                    if (n != (0x2D0BE8AE ^ 0x2D0BE8D1)) break block24;
                                }
                                n = 0x2D0BE8F1 ^ 0x2D0BE8D1;
                                break block22;
                            }
                            n = n2;
                        }
                        stringBuilder3.append((char)n);
                        if (!bl) continue;
                    }
                    stringBuilder = stringBuilder2;
                }
                string4 = stringBuilder.toString().trim();
                string3 = string4;
                if (bl) break block25;
                if (!string3.isEmpty()) break block26;
                string3 = string2;
                break block25;
            }
            string3 = string4;
        }
        return string3;
    }
}

