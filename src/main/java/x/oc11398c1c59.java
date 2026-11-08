/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.oc2cf3d80e17;
import x.ocaae9de8508;
import x.occecd0ef754;

public class oc11398c1c59
extends oc161f4adba4 {
    public static int \u010e;

    public oc11398c1c59() {
        super("debug", "Toggle diagnostic logging.", oc17aaf5d285.\u0572, new String[]{"debug"}, new String[0]);
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        block30: {
            boolean bl;
            block31: {
                block32: {
                    int n;
                    block28: {
                        block29: {
                            ocaae9de8508 ocaae9de85083;
                            block26: {
                                block27: {
                                    block22: {
                                        block23: {
                                            boolean bl2;
                                            block24: {
                                                block25: {
                                                    n = oc24b4725b15.\u0395;
                                                    ocaae9de85083 = ocaae9de85082;
                                                    if (n != 0) break block22;
                                                    if (ocaae9de85083.\u04fe() != 0) break block23;
                                                    bl2 = oc2cf3d80e17.\u0125;
                                                    if (n != 0) break block24;
                                                    if (bl2) break block25;
                                                    bl2 = true;
                                                    break block24;
                                                }
                                                bl2 = false;
                                            }
                                            oc2cf3d80e17.\u0125 = bl2;
                                            oc11398c1c59 oc11398c1c592 = this;
                                            String string = oc2cf3d80e17.\u0125 ? "&aenabled" : "&cdisabled";
                                            oc11398c1c592.\u0247("&7Debug " + string + "&7.");
                                            return;
                                        }
                                        ocaae9de85083 = ocaae9de85082;
                                    }
                                    if (n != 0) break block26;
                                    if (ocaae9de85083.\u04fe() == 1) break block27;
                                    this.\u01fb();
                                    return;
                                }
                                ocaae9de85083 = ocaae9de85082;
                            }
                            String string = ocaae9de85083.\u044c(0).toLowerCase();
                            bl = "bg".equals(string);
                            if (n != 0) break block28;
                            if (bl) break block29;
                            bl = "background".equals(string);
                            if (n != 0) break block28;
                            if (!bl) break block30;
                        }
                        bl = occecd0ef754.\u0122;
                    }
                    if (n != 0) break block31;
                    if (bl) break block32;
                    bl = true;
                    break block31;
                }
                bl = false;
            }
            occecd0ef754.\u0122 = bl;
            oc11398c1c59 oc11398c1c593 = this;
            String string = occecd0ef754.\u0122 ? "&aenabled" : "&cdisabled";
            oc11398c1c593.\u0247("&6Background &7debug " + string + "&7.");
            return;
        }
        this.\u01fb();
    }
}

