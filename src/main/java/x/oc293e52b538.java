/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oce33cf14e5f;
import x.oce490879787;

public class oc293e52b538 {
    private oc293e52b538() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static String \u01f3(oce33cf14e5f oce33cf14e5f2) {
        String string;
        StringBuilder stringBuilder;
        block15: {
            StringBuilder stringBuilder2;
            block16: {
                block17: {
                    String string2;
                    boolean bl;
                    String string3;
                    String string4;
                    block13: {
                        block14: {
                            string4 = oce33cf14e5f2.\u0462();
                            string3 = oc293e52b538.\u03c0(oce33cf14e5f2.\u0495());
                            stringBuilder2 = new StringBuilder();
                            bl = oce490879787.\u0583;
                            string2 = "discord";
                            if (bl) break block13;
                            if (!string2.equals(string4)) break block14;
                            stringBuilder = stringBuilder2;
                            string = "\u00a77[\u00a7bDiscord\u00a77] ";
                            if (bl) break block15;
                            stringBuilder.append(string);
                            if (string3.isEmpty()) break block16;
                            stringBuilder2.append(string3).append((char)(0x35530847 ^ 0x35530867));
                            if (!bl) break block16;
                        }
                        string2 = "dashboard";
                    }
                    if (!string2.equals(string4)) break block17;
                    String string5 = string3;
                    if (!bl) {
                        string5 = string5.isEmpty() ? "\u00a77[\u00a7eDashboard\u00a77]" : string3;
                    }
                    stringBuilder2.append(string5).append((char)(0x35530847 ^ 0x35530867));
                    if (!bl) break block16;
                }
                stringBuilder2.append("\u00a77[\u00a7dIRC\u00a77] ");
            }
            stringBuilder = stringBuilder2.append("\u00a7f").append(oce33cf14e5f2.i()).append("\u00a77: \u00a7f");
            string = oce33cf14e5f2.\u04bc();
        }
        return stringBuilder.append(string).toString();
    }

    private static String \u03c0(String string) {
        String string2;
        block35: {
            String string3;
            block33: {
                boolean bl;
                block34: {
                    block32: {
                        String string4;
                        block30: {
                            block31: {
                                block28: {
                                    block29: {
                                        block26: {
                                            block27: {
                                                bl = oce490879787.\u0583;
                                                string2 = "owner";
                                                if (bl) break block26;
                                                if (!string2.equals(string)) break block27;
                                                return "\u00a77[\u00a74Owner\u00a77]";
                                            }
                                            string2 = "dev";
                                        }
                                        string4 = string;
                                        if (bl) break block28;
                                        if (!string2.equals(string4)) break block29;
                                        return "\u00a77[\u00a7cDev\u00a77]";
                                    }
                                    string2 = "manager";
                                    string4 = string;
                                }
                                if (bl) break block30;
                                if (!string2.equals(string4)) break block31;
                                return "\u00a77[\u00a76Manager\u00a77]";
                            }
                            string2 = "helper";
                            if (bl) break block32;
                            string4 = string;
                        }
                        if (string2.equals(string4)) {
                            return "\u00a77[\u00a7aHelper\u00a77]";
                        }
                        string2 = "media";
                    }
                    string3 = string;
                    if (bl) break block33;
                    if (!string2.equals(string3)) break block34;
                    return "\u00a77[\u00a7bMedia\u00a77]";
                }
                string2 = "friends";
                if (bl) break block35;
                string3 = string;
            }
            if (string2.equals(string3)) {
                return "\u00a77[\u00a7dFriends\u00a77]";
            }
            string2 = "";
        }
        return string2;
    }
}

