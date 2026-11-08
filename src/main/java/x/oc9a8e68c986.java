/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.ocaae9de8508;

public class oc9a8e68c986
extends oc161f4adba4 {
    public static boolean \u01f3;

    public oc9a8e68c986() {
        super("toggle", "Toggle a module on or off.", oc17aaf5d285.\u0127, new String[]{"toggle <module>"}, "t");
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        oc69da1aa7f5 oc69da1aa7f52;
        block9: {
            block10: {
                int n = oc24b4725b15.\u0395;
                if (ocaae9de85082.\u04fe() == 0) {
                    this.\u01fb();
                    return;
                }
                oc69da1aa7f52 = this.\u0405(ocaae9de85082.\u037a(0));
                if (n != 0) break block9;
                if (oc69da1aa7f52 != null) break block10;
                this.\u0247("&cModule not found.");
                return;
            }
            oc69da1aa7f52.z$11p1yfisf2riw();
        }
        oc9a8e68c986 oc9a8e68c9862 = this;
        String string = oc69da1aa7f52.z$3i8m9vxwuvqj0();
        String string2 = oc69da1aa7f52.z$3rzb3dil7uydr() ? "&aenabled" : "&cdisabled";
        oc9a8e68c9862.\u0247("&7" + string + " " + string2 + "&7.");
    }

    @Override
    public List<String> z$9ofids0wyz4j(ocaae9de8508 ocaae9de85082) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = oc24b4725b15.\u0395;
        String string = ocaae9de85082.\u04fe() == 0 ? "" : this.\u045a(ocaae9de85082.\u037a(0));
        String string2 = string;
        for (oc69da1aa7f5 oc69da1aa7f52 : oc9755810e45.\u0154) {
            block7: {
                boolean bl = this.\u045a(oc69da1aa7f52.z$3i8m9vxwuvqj0()).startsWith(string2);
                if (n != 0 || !bl) break block7;
                bl = arrayList.add(oc69da1aa7f52.z$3i8m9vxwuvqj0());
            }
            if (n == 0) continue;
        }
        return arrayList;
    }

    @Override
    public int z$7k2utc7u0w8s(ocaae9de8508 ocaae9de85082) {
        return 0;
    }

    private oc69da1aa7f5 \u0405(String string) {
        String string2 = this.\u045a(string);
        int n = oc24b4725b15.\u0395;
        for (oc69da1aa7f5 oc69da1aa7f52 : oc9755810e45.\u0154) {
            if (this.\u045a(oc69da1aa7f52.z$3i8m9vxwuvqj0()).equals(string2)) {
                return oc69da1aa7f52;
            }
            if (n == 0) continue;
        }
        return null;
    }

    private String \u045a(String string) {
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
            string2 = string3.toLowerCase();
        }
        return string2;
    }
}

