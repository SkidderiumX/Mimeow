/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc1e36b6c903;
import x.oc24b4725b15;
import x.oc2cf3d80e17;
import x.oc64151e84ee;
import x.oc7ab2161b9f;
import x.ocaae9de8508;

public class oc17d6eef96a
extends oc161f4adba4 {
    public static boolean \u00d9;

    public oc17d6eef96a() {
        String[] stringArray = new String[0x149D2DF5 ^ 0x149D2DF7];
        stringArray[0] = "enemy <name>";
        stringArray[1] = "enemy clear";
        super("enemy", "Add, remove, list, or clear enemies.", oc17aaf5d285.\u01e5, stringArray, "e");
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        block27: {
            String string;
            String string2;
            block25: {
                block26: {
                    int n;
                    block23: {
                        block24: {
                            ocaae9de8508 ocaae9de85083;
                            block21: {
                                block22: {
                                    block19: {
                                        block20: {
                                            n = oc24b4725b15.\u0395;
                                            ocaae9de85083 = ocaae9de85082;
                                            if (n != 0) break block19;
                                            if (ocaae9de85083.\u04fe() != 0) break block20;
                                            List<oc1e36b6c903> list = oc2cf3d80e17.\u022c.\u02a3(oc64151e84ee.\u020d);
                                            oc17d6eef96a oc17d6eef96a2 = this;
                                            int n2 = list.size();
                                            String string3 = list.size() == 1 ? "y" : "ies";
                                            oc17d6eef96a2.\u0247("&b" + n2 + " &7enem" + string3 + ".");
                                            for (oc1e36b6c903 oc1e36b6c9032 : list) {
                                                this.\u0247(" &b" + oc1e36b6c9032.\u0273());
                                                if (n == 0) continue;
                                            }
                                            return;
                                        }
                                        ocaae9de85083 = ocaae9de85082;
                                    }
                                    if (n != 0) break block21;
                                    if (ocaae9de85083.\u04fe() == 1) break block22;
                                    this.\u01fb();
                                    return;
                                }
                                ocaae9de85083 = ocaae9de85082;
                            }
                            string2 = ocaae9de85083.\u044c(0);
                            string = "clear";
                            if (n != 0) break block23;
                            if (!string.equalsIgnoreCase(string2)) break block24;
                            int n3 = oc2cf3d80e17.\u022c.\u0196(oc64151e84ee.\u020d);
                            oc2cf3d80e17.\u022c.\u01d3();
                            oc17d6eef96a oc17d6eef96a3 = this;
                            int n4 = n3;
                            String string4 = n3 == 1 ? "y" : "ies";
                            oc17d6eef96a3.\u0247("&b" + n4 + " &7enem" + string4 + " cleared.");
                            return;
                        }
                        string = string2;
                    }
                    if (n != 0) break block25;
                    if (!oc7ab2161b9f.\u0513(string)) break block26;
                    this.\u0247("&7Added enemy&7: &b" + string2);
                    if (n == 0) break block27;
                }
                string = string2;
            }
            oc7ab2161b9f.\u03d3(string);
            this.\u0247("&7Removed enemy&7: &b" + string2);
        }
    }
}

