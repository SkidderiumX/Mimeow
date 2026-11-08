/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.occaff2246e4;
import x.oce490879787;

public class oc752fc2db59 {
    private static final oc752fc2db59 \u0435 = new oc752fc2db59(occaff2246e4.\u0131, "");
    private final occaff2246e4 \u03ad;
    private final String \u0418;
    public static int \u01b0;

    private oc752fc2db59(occaff2246e4 occaff2246e42, String string) {
        this.\u03ad = occaff2246e42;
        this.\u0418 = string;
    }

    public static oc752fc2db59 \u0297(String string) {
        String string2;
        String string3;
        block19: {
            block20: {
                boolean bl;
                block17: {
                    String string4;
                    block18: {
                        String string5;
                        block15: {
                            block16: {
                                bl = oce490879787.\u0583;
                                string5 = string;
                                if (bl) break block15;
                                if (string5 != null) break block16;
                                return \u0435;
                            }
                            string5 = string.trim();
                        }
                        string4 = string5;
                        string3 = "#online";
                        string2 = string4;
                        if (bl) break block17;
                        if (!string3.equalsIgnoreCase(string2)) break block18;
                        return new oc752fc2db59(occaff2246e4.\u046e, "");
                    }
                    string3 = "#";
                    string2 = string4;
                }
                if (bl) break block19;
                if (!string3.equals(string2)) break block20;
                return new oc752fc2db59(occaff2246e4.\u0191, "");
            }
            string3 = string;
            string2 = "# ";
        }
        if (string3.startsWith(string2)) {
            return new oc752fc2db59(occaff2246e4.\u0191, string.substring(0x2E3EE075 ^ 0x2E3EE077).trim());
        }
        return \u0435;
    }

    public occaff2246e4 \u0138() {
        return this.\u03ad;
    }

    public String \u00ee() {
        return this.\u0418;
    }

    public boolean \u01c9() {
        boolean bl = this.\u03ad != occaff2246e4.\u0131;
        return bl;
    }
}

