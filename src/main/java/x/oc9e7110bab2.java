/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Locale;
import x.oc46245c2b20;

public enum oc9e7110bab2 {
    \u01b4("linux-x64", "linux/x64/idle/miau/notifications/libmimeow_vlkr_notifications.so", "libmimeow_vlkr_notifications.so"),
    \u04da("windows-x64", "windows/x64/idle/miau/notifications/mimeow_vlkr_notifications.dll", "mimeow_vlkr_notifications.dll");
    private static final oc9e7110bab2[] $VALUES_REF;
    static {
        $VALUES_REF = oc9e7110bab2.\u0282();
    }


    private final String \u011e;
    private final String \u01d1;
    private final String \u04cd;


    private oc9e7110bab2(String string2, String string3, String string4) {
        this.\u011e = string2;
        this.\u01d1 = string3;
        this.\u04cd = string4;
    }

    static oc9e7110bab2 \u0290(String string, String string2) {
        String string3;
        String string4;
        block41: {
            boolean bl;
            String string5;
            block39: {
                int n;
                block40: {
                    boolean bl2;
                    block36: {
                        block38: {
                            block37: {
                                String string6;
                                block35: {
                                    String string7;
                                    block33: {
                                        block34: {
                                            String string8;
                                            block32: {
                                                String string9;
                                                block30: {
                                                    block31: {
                                                        n = oc46245c2b20.\u04a5;
                                                        string9 = string;
                                                        if (n != 0) break block30;
                                                        if (string9 != null) break block31;
                                                        string8 = "";
                                                        break block32;
                                                    }
                                                    string9 = string;
                                                }
                                                string8 = string9.toLowerCase(Locale.ROOT);
                                            }
                                            string5 = string8;
                                            string7 = string2;
                                            if (n != 0) break block33;
                                            if (string7 != null) break block34;
                                            string6 = "";
                                            break block35;
                                        }
                                        string7 = string2;
                                    }
                                    string6 = string7.toLowerCase(Locale.ROOT);
                                }
                                String string10 = string6;
                                bl2 = string10.equals("amd64");
                                if (n != 0) break block36;
                                if (bl2) break block37;
                                bl2 = string10.equals("x86_64");
                                if (n != 0) break block36;
                                if (bl2) break block37;
                                bl2 = string10.equals("x64");
                                if (n != 0) break block36;
                                if (!bl2) break block38;
                            }
                            bl2 = true;
                            break block36;
                        }
                        bl2 = false;
                    }
                    boolean bl3 = bl2;
                    bl = bl3;
                    if (n != 0) break block39;
                    if (bl) break block40;
                    return null;
                }
                string4 = string5;
                string3 = "linux";
                if (n != 0) break block41;
                bl = string4.contains(string3);
            }
            if (bl) {
                return \u01b4;
            }
            string4 = string5;
            string3 = "win";
        }
        if (string4.contains(string3)) {
            return \u04da;
        }
        return null;
    }

    private static oc9e7110bab2[] \u0282() {
        oc9e7110bab2[] oc9e7110bab2Array = new oc9e7110bab2[0xAEC33A47 ^ 0xAEC33A45];
        oc9e7110bab2Array[0] = \u01b4;
        oc9e7110bab2Array[1] = \u04da;
        return oc9e7110bab2Array;
    }
}

