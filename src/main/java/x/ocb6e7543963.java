/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.oca7b33a0538;
import x.ocaae9de8508;

public class ocb6e7543963
extends oc161f4adba4 {
    public static boolean c;

    public ocb6e7543963() {
        String[] stringArray = new String[0x751D6D21 ^ 0x751D6D22];
        stringArray[0] = "hide <module>";
        stringArray[1] = "hide all";
        stringArray[0x751D6D20 ^ 0x751D6D22] = "hide";
        super("hide", "Toggle a module's HUD visibility or hide every module.", oc17aaf5d285.\u0127, stringArray, "hideall");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        oc69da1aa7f5 oc69da1aa7f52;
        int n;
        block18: {
            block16: {
                ocaae9de8508 ocaae9de85083;
                block17: {
                    block15: {
                        n = oc24b4725b15.\u0395;
                        ocaae9de85083 = ocaae9de85082;
                        if (n != 0) break block15;
                        if (ocaae9de85083.\u04fe() == 0) break block16;
                        ocaae9de85083 = ocaae9de85082;
                    }
                    if (n != 0) break block17;
                    if (ocaae9de85083.\u04fe() != 1) break block18;
                    ocaae9de85083 = ocaae9de85082;
                }
                if (!ocaae9de85083.\u014e(0, "all")) break block18;
            }
            this.\u0411();
            return;
        }
        oc69da1aa7f5 oc69da1aa7f53 = oc69da1aa7f52 = this.\u042a(ocaae9de85082.\u037a(0));
        if (n == 0) {
            if (oc69da1aa7f53 == null) {
                this.\u0247("&cModule not found.");
                return;
            }
            oc69da1aa7f53 = oc69da1aa7f52;
        }
        boolean bl = oc69da1aa7f52.\u056c();
        if (n == 0) {
            bl = !bl;
        }
        oc69da1aa7f53.\u01e4(bl);
        oc9755810e45.\u042f();
        this.\u0247("&7" + oc69da1aa7f52.z$3i8m9vxwuvqj0() + " is now " + (oc69da1aa7f52.\u056c() ? "&chidden" : "&avisible") + " &7in HUD.");
    }

    @Override
    public List<String> z$9ofids0wyz4j(ocaae9de8508 ocaae9de85082) {
        int n;
        String string;
        ArrayList<String> arrayList;
        block12: {
            arrayList = new ArrayList<String>();
            string = oca7b33a0538.\u00d8(ocaae9de85082.\u037a(0));
            n = oc24b4725b15.\u0395;
            boolean bl = "all".startsWith(string);
            if (n != 0 || !bl) break block12;
            bl = arrayList.add("all");
        }
        for (oc69da1aa7f5 oc69da1aa7f52 : oc9755810e45.\u0154) {
            block13: {
                boolean bl = oca7b33a0538.\u00d8(oc69da1aa7f52.z$3i8m9vxwuvqj0()).startsWith(string);
                if (n != 0 || !bl) break block13;
                bl = arrayList.add(oc69da1aa7f52.z$3i8m9vxwuvqj0());
            }
            if (n == 0) continue;
        }
        ArrayList<String> arrayList2 = arrayList;
        if (false) {
            oc24b4725b15.\u0395 = ++n;
        }
        return arrayList2;
    }

    @Override
    public int z$7k2utc7u0w8s(ocaae9de8508 ocaae9de85082) {
        return 0;
    }

    private void \u0411() {
        int n;
        block9: {
            n = 0;
            int n2 = oc24b4725b15.\u0395;
            for (oc69da1aa7f5 oc69da1aa7f52 : oc9755810e45.\u0154) {
                block11: {
                    block10: {
                        if (n2 != 0) break block9;
                        if (n2 != 0) break block10;
                        if (oc69da1aa7f52.\u056c()) break block11;
                        oc69da1aa7f52.\u01e4(true);
                    }
                    ++n;
                }
                if (n2 == 0) continue;
            }
            oc9755810e45.\u042f();
        }
        ocb6e7543963 ocb6e75439632 = this;
        int n3 = n;
        String string = n == 1 ? "" : "s";
        ocb6e75439632.\u0247("&7Hidden &c" + n3 + " &7module" + string + " from HUD.");
    }

    private oc69da1aa7f5 \u042a(String string) {
        String string2 = oca7b33a0538.\u00d8(string);
        Iterator<oc69da1aa7f5> iterator2 = oc9755810e45.\u0154.iterator();
        int n = oc24b4725b15.\u0395;
        while (iterator2.hasNext()) {
            block6: {
                oc69da1aa7f5 oc69da1aa7f52;
                block5: {
                    oc69da1aa7f5 oc69da1aa7f53 = iterator2.next();
                    oc69da1aa7f52 = oc69da1aa7f53;
                    if (n != 0) break block5;
                    if (!oca7b33a0538.\u00d8(oc69da1aa7f52.z$3i8m9vxwuvqj0()).equals(string2)) break block6;
                    oc69da1aa7f52 = oc69da1aa7f53;
                }
                return oc69da1aa7f52;
            }
            if (n == 0) continue;
        }
        return null;
    }
}

