/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.ocaae9de8508;

public class ocaff2262bd0
extends oc161f4adba4 {
    public static boolean \u0177;

    public ocaff2262bd0() {
        super("unbind", "Remove a module key binding.", oc17aaf5d285.\u0127, new String[]{"unbind <module>"}, "ub");
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        block7: {
            oc69da1aa7f5 oc69da1aa7f52;
            block8: {
                int n = oc24b4725b15.\u0395;
                if (ocaae9de85082.\u04fe() == 0) {
                    this.\u01fb();
                    return;
                }
                oc69da1aa7f52 = this.D(ocaae9de85082.\u037a(0));
                if (n != 0) break block7;
                if (oc69da1aa7f52 != null) break block8;
                this.\u0247("&cModule not found.");
                return;
            }
            oc69da1aa7f52.\u04dd(0);
            this.\u0247("&7Unbound &b" + oc69da1aa7f52.z$3i8m9vxwuvqj0() + "&7.");
        }
    }

    @Override
    public List<String> z$9ofids0wyz4j(ocaae9de8508 ocaae9de85082) {
        String string;
        int n;
        block13: {
            ocaae9de8508 ocaae9de85083;
            block11: {
                block12: {
                    n = oc24b4725b15.\u0395;
                    ocaae9de85083 = ocaae9de85082;
                    if (n != 0) break block11;
                    if (ocaae9de85083.\u04fe() != 0) break block12;
                    string = "";
                    break block13;
                }
                ocaae9de85083 = ocaae9de85082;
            }
            string = ocaae9de85083.\u037a(0);
        }
        String string2 = string;
        ArrayList<String> arrayList = new ArrayList<String>();
        String string3 = this.\u01f5(string2);
        for (oc69da1aa7f5 oc69da1aa7f52 : oc9755810e45.\u0154) {
            block14: {
                String string4 = oc69da1aa7f52.z$3i8m9vxwuvqj0();
                boolean bl = this.\u01f5(string4).startsWith(string3);
                if (n != 0 || !bl) break block14;
                bl = arrayList.add(string4);
            }
            if (n == 0) continue;
            boolean bl = !false;
            oc69da1aa7f5.\u04ac = bl;
            break;
        }
        return arrayList;
    }

    @Override
    public int z$7k2utc7u0w8s(ocaae9de8508 ocaae9de85082) {
        return 0;
    }

    private oc69da1aa7f5 D(String string) {
        String string2 = this.\u01f5(string);
        int n = oc24b4725b15.\u0395;
        for (oc69da1aa7f5 oc69da1aa7f52 : oc9755810e45.\u0154) {
            if (this.\u01f5(oc69da1aa7f52.z$3i8m9vxwuvqj0()).equals(string2)) {
                return oc69da1aa7f52;
            }
            if (n == 0) continue;
        }
        return null;
    }

    private String \u01f5(String string) {
        String string2;
        block6: {
            String string3;
            block4: {
                block5: {
                    int n = oc24b4725b15.\u0395;
                    string3 = string;
                    if (n != 0) break block4;
                    if (string3 != null) break block5;
                    string2 = "";
                    break block6;
                }
                string3 = string.replaceAll("[^a-zA-Z0-9]", "");
            }
            string2 = string3.toLowerCase(Locale.ROOT);
        }
        return string2;
    }
}

