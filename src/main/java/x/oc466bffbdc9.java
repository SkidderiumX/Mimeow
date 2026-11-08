/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.N;
import x.oc321b4679dd;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.oca9cc61aada;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc466bffbdc9
extends oc69da1aa7f5 {
    private static final int \u0182 = 1;
    private static final String[] \u0540;
    private final oca9cc61aada \u0537;
    private final oc321b4679dd \u0408;
    public static int \u0531;

    public oc466bffbdc9() {
        super("CustomSuffix", oce4cea752dd.\u014e, 0);
        this.\u0105("Customizes the information shown beside modules.");
        this.\u0537 = new oca9cc61aada("Mode", 0, \u0540);
        this.\u028c(this.\u0537);
        this.\u0408 = new oc321b4679dd("Suffix", "CustomSuffix", "Type a custom suffix...", 0x56AF61E0 ^ 0x56AF61A0, this::\u0371);
        this.\u028c(this.\u0408);
    }

    @Override
    public String getInfo() {
        return \u0540[this.\u04ea()];
    }

    @Override
    public void onEnable() {
        this.\u0371();
    }

    @Override
    public void onDisable() {
        this.\u0371();
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        if (oca9cc61aada2 == this.\u0537) {
            this.\u0371();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$3tl278wzjcayb(N n) {
        block6: {
            N n2;
            block5: {
                boolean bl = oce6044968f8.\u0452;
                n2 = n;
                if (bl) break block5;
                if (n2 == this.\u0537) break block6;
                n2 = n;
            }
            if (n2 != this.\u0408) return;
        }
        this.\u0371();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static String P(oc69da1aa7f5 oc69da1aa7f52, String string) {
        oc69da1aa7f5 oc69da1aa7f53;
        oc466bffbdc9 oc466bffbdc92;
        block9: {
            boolean bl;
            block8: {
                oc466bffbdc92 = oc9755810e45.U;
                bl = oce6044968f8.\u0452;
                oc69da1aa7f53 = oc466bffbdc92;
                if (bl) break block8;
                if (oc69da1aa7f53 == null) return string;
                oc69da1aa7f53 = oc466bffbdc92;
            }
            if (bl) break block9;
            if (!oc69da1aa7f53.z$3rzb3dil7uydr()) return string;
            oc69da1aa7f53 = oc69da1aa7f52;
        }
        if (oc69da1aa7f53 != oc466bffbdc92) return oc466bffbdc92.\u021b(string);
        return string;
    }

    String \u021b(String string) {
        Object object;
        block22: {
            String string2;
            String string3;
            block20: {
                String string4;
                block21: {
                    boolean bl;
                    block19: {
                        int n;
                        block17: {
                            block18: {
                                String string5;
                                block15: {
                                    block16: {
                                        bl = oce6044968f8.\u0452;
                                        string5 = string;
                                        if (bl) break block15;
                                        if (string5 != null) break block16;
                                        string5 = "";
                                        break block15;
                                    }
                                    string5 = string;
                                }
                                string3 = string5;
                                string4 = this.\u0408.\u00ca().trim().replace((char)(0x20C4CCD6 ^ 0x20C4CCF0), (char)(0x20C4CC57 ^ 0x20C4CCF0));
                                n = this.\u04ea();
                                if (bl) break block17;
                                if (n != 1) break block18;
                                return string4;
                            }
                            string2 = string4;
                            if (bl) break block19;
                            n = string2.isEmpty() ? 1 : 0;
                        }
                        if (n != 0) {
                            return string3;
                        }
                        string2 = string3;
                    }
                    if (bl) break block20;
                    if (!string2.isEmpty()) break block21;
                    object = string4;
                    break block22;
                }
                string2 = string4;
            }
            object = string2 + " " + string3;
        }
        return object;
    }

    private int \u04ea() {
        return Math.max(0, Math.min((int)this.\u0537.\u04c1(), \u0540.length - 1));
    }

    private void \u0371() {
        oc69da1aa7f5.\u02e4 = true;
        oc9755810e45.\u042f();
    }

    static {
        String[] stringArray = new String[0x54302FC3 ^ 0x54302FC1];
        stringArray[0] = "Semi";
        stringArray[1] = "Full";
        \u0540 = stringArray;
    }
}

