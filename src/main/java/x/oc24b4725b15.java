/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc26930a666f;
import x.oc2746fee649;
import x.oc2851d7404f;
import x.oc41720aed4a;
import x.oc9e5a7eeec6;
import x.ocaae9de8508;

public class oc24b4725b15
extends oc161f4adba4 {
    private final oc26930a666f \u050c;
    private final List<oc41720aed4a> \u020f;
    private boolean \u011c;
    private boolean \u044f;
    private int \u046f;
    public static int \u0395;

    public oc24b4725b15() {
        String[] stringArray = new String[0x50C568FB ^ 0x50C568F8];
        stringArray[0] = "officialconfig";
        stringArray[1] = "officialconfig list";
        stringArray[0x50C568FA ^ 0x50C568F8] = "officialconfig load <name>";
        super("officialconfig", "Load official configurations from the Miau servers.", oc17aaf5d285.\u029d, stringArray, "oc");
        this.\u050c = new oc26930a666f();
        this.\u020f = new ArrayList<oc41720aed4a>();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        int n;
        block27: {
            String string;
            int n2 = \u0395;
            ocaae9de8508 ocaae9de85083 = ocaae9de85082;
            if (n2 == 0) {
                if (ocaae9de85083.\u04fe() == 0) {
                    this.\u00e2();
                    return;
                }
                ocaae9de85083 = ocaae9de85082;
            }
            String string2 = string = ocaae9de85083.\u044c(0).toLowerCase(Locale.ROOT);
            int n3 = -1;
            n = string2.hashCode();
            if (n2 != 0) break block27;
            switch (n) {
                case 3322014: {
                    n = string2.equals("list") ? 1 : 0;
                    if (n2 == 0) {
                        if (n == 0) break;
                        n3 = 0;
                        if (n2 == 0) break;
                    }
                    break block27;
                }
                case 3463: {
                    n = string2.equals("ls") ? 1 : 0;
                    if (n2 == 0) {
                        if (n == 0) break;
                        n3 = 1;
                        if (n2 == 0) break;
                    }
                    break block27;
                }
                case 3327206: {
                    n = string2.equals("load") ? 1 : 0;
                    if (n2 == 0) {
                        if (n == 0) break;
                        n3 = 0x8220D95B ^ 0x8220D959;
                        if (n2 == 0) break;
                    }
                    break block27;
                }
                case 108: {
                    n = string2.equals("l") ? 1 : 0;
                    if (n2 != 0) break block27;
                    if (n == 0) break;
                    n3 = 0x8220D95A ^ 0x8220D959;
                }
            }
            n = n3;
        }
        switch (n) {
            case 0: 
            case 1: {
                this.\u00e2();
                return;
            }
            case 2: 
            case 3: {
                this.\u041c(ocaae9de85082);
                return;
            }
        }
        this.\u01fb();
    }

    @Override
    public List<String> z$9ofids0wyz4j(ocaae9de8508 ocaae9de85082) {
        block14: {
            int n;
            block13: {
                int n2;
                block11: {
                    block12: {
                        n2 = \u0395;
                        n = ocaae9de85082.\u04fe();
                        if (n2 != 0) break block11;
                        if (n != 1) break block12;
                        String[] stringArray = new String[0xC371DC34 ^ 0xC371DC30];
                        stringArray[0] = "list";
                        stringArray[1] = "ls";
                        stringArray[0xC371DC32 ^ 0xC371DC30] = "load";
                        stringArray[0xC371DC33 ^ 0xC371DC30] = "l";
                        return this.\u0120(ocaae9de85082, stringArray);
                    }
                    n = this.R(ocaae9de85082.\u044c(0)) ? 1 : 0;
                }
                if (n2 != 0) break block13;
                if (n == 0) break block14;
                n = ocaae9de85082.\u04fe();
            }
            if (n == (0xC371DC32 ^ 0xC371DC30)) {
                return this.\u0495(ocaae9de85082, this.E());
            }
        }
        return new ArrayList<String>();
    }

    @Override
    public int z$7k2utc7u0w8s(ocaae9de8508 ocaae9de85082) {
        ocaae9de8508 ocaae9de85083;
        oc24b4725b15 oc24b4725b152;
        block4: {
            block5: {
                int n = \u0395;
                oc24b4725b152 = this;
                ocaae9de85083 = ocaae9de85082;
                if (n != 0) break block4;
                if (!oc24b4725b152.R(ocaae9de85083.\u044c(0))) break block5;
                return 1;
            }
            oc24b4725b152 = this;
            ocaae9de85083 = ocaae9de85082;
        }
        return super.z$7k2utc7u0w8s(ocaae9de85083);
    }

    private void \u00e2() {
        oc24b4725b15 oc24b4725b152;
        block10: {
            block11: {
                int n;
                block8: {
                    block9: {
                        n = \u0395;
                        oc24b4725b152 = this;
                        if (n != 0) break block8;
                        if (!oc24b4725b152.\u044f) break block9;
                        this.\u0247("&7Already fetching official configs, please wait.");
                        return;
                    }
                    oc24b4725b152 = this;
                }
                if (n != 0) break block10;
                if (!oc24b4725b152.\u011c) break block11;
                this.\u0247("&7Cached list, use again after configs change to refresh.");
            }
            oc24b4725b152 = this;
        }
        oc24b4725b152.\u01a7(new oc2851d7404f(this));
    }

    private void \u041c(ocaae9de8508 ocaae9de85082) {
        block10: {
            String string;
            block11: {
                ocaae9de8508 ocaae9de85083;
                int n;
                block8: {
                    block9: {
                        n = \u0395;
                        ocaae9de85083 = ocaae9de85082;
                        if (n != 0) break block8;
                        if (ocaae9de85083.\u04fe() >= (0x60FDD354 ^ 0x60FDD356)) break block9;
                        this.\u01fb();
                        return;
                    }
                    ocaae9de85083 = ocaae9de85082;
                }
                string = ocaae9de85083.\u037a(1);
                if (n != 0) break block10;
                if (!this.\u044f) break block11;
                this.\u0247("&7Still fetching official configs, please wait.");
                return;
            }
            this.\u01a7(new oc2746fee649(this, string));
        }
    }

    private void \u01a7(Runnable runnable2) {
        oc24b4725b15 oc24b4725b152;
        block4: {
            block5: {
                int n = \u0395;
                oc24b4725b152 = this;
                if (n != 0) break block4;
                if (!oc24b4725b152.\u011c) break block5;
                runnable2.run();
                return;
            }
            this.\u044f = true;
            oc24b4725b152 = this;
        }
        int n = ++oc24b4725b152.\u046f;
        this.\u0247("&7Fetching official configs...");
        this.\u050c.\u04e6(oc9e5a7eeec6.\u044d, list -> {
            block4: {
                int n2;
                block5: {
                    int n3 = \u0395;
                    n2 = n;
                    if (n3 != 0) break block4;
                    if (n2 == this.\u046f) break block5;
                    return;
                }
                this.\u020f.clear();
                n2 = this.\u020f.addAll((Collection<oc41720aed4a>)list) ? 1 : 0;
            }
            this.\u020f.sort((oc41720aed4a2, oc41720aed4a3) -> oc41720aed4a2.\u00d6().compareToIgnoreCase(oc41720aed4a3.\u00d6()));
            this.\u011c = true;
            this.\u044f = false;
            runnable2.run();
        }, string -> {
            if (n != this.\u046f) {
                return;
            }
            this.\u044f = false;
            this.\u0247("&cFailed to fetch official configs: &7" + string);
        });
    }

    private void \u0285() {
        oc24b4725b15 oc24b4725b152;
        int n;
        block9: {
            block10: {
                n = \u0395;
                oc24b4725b152 = this;
                if (n != 0) break block9;
                if (!oc24b4725b152.\u020f.isEmpty()) break block10;
                this.\u0247("&7No official configs found.");
                return;
            }
            oc24b4725b152 = this;
        }
        int n2 = this.\u020f.size();
        String string = this.\u020f.size() == 1 ? "" : "s";
        oc24b4725b152.\u0247("&b" + n2 + " &7official config" + string + ":");
        for (oc41720aed4a oc41720aed4a2 : this.\u020f) {
            block11: {
                String string2;
                block12: {
                    int n3 = oc41720aed4a2.\u057b();
                    String string3 = oc41720aed4a2.\u00db();
                    String string4 = oc41720aed4a2.\u00d6();
                    string2 = " &7" + string4 + " &7by " + string3 + " | " + n3 + " loads";
                    if (n != 0) break block11;
                    if (oc41720aed4a2.\u0437().isEmpty()) break block12;
                    string2 = string2 + " | " + oc41720aed4a2.\u0437();
                }
                this.\u00e5(string2);
            }
            if (n == 0) continue;
        }
    }

    private void \u040b(String string2) {
        oc41720aed4a oc41720aed4a2;
        block36: {
            oc41720aed4a oc41720aed4a3;
            block37: {
                int n;
                block33: {
                    block34: {
                        ArrayList<oc41720aed4a> arrayList;
                        block35: {
                            ArrayList<oc41720aed4a> arrayList2;
                            block30: {
                                block31: {
                                    ArrayList<oc41720aed4a> arrayList3;
                                    block32: {
                                        oc41720aed4a3 = null;
                                        n = \u0395;
                                        arrayList2 = new ArrayList<oc41720aed4a>();
                                        for (oc41720aed4a oc41720aed4a4 : this.\u020f) {
                                            String string3;
                                            block28: {
                                                block29: {
                                                    string3 = oc41720aed4a4.\u00d6();
                                                    if (n != 0) break block28;
                                                    if (!string3.equalsIgnoreCase(string2)) break block29;
                                                    oc41720aed4a3 = oc41720aed4a4;
                                                    break;
                                                }
                                                string3 = oc41720aed4a4.\u00d6().toLowerCase(Locale.ROOT);
                                            }
                                            boolean bl2 = string3.startsWith(string2.toLowerCase(Locale.ROOT));
                                            if (n != 0) continue;
                                            if (!bl2) continue;
                                            bl2 = arrayList2.add(oc41720aed4a4);
                                        }
                                        oc41720aed4a2 = oc41720aed4a3;
                                        if (n != 0) break block30;
                                        if (oc41720aed4a2 != null) break block31;
                                        arrayList3 = arrayList2;
                                        if (n != 0) break block32;
                                        if (arrayList3.size() != 1) break block31;
                                        arrayList3 = arrayList2.get(0);
                                    }
                                    oc41720aed4a3 = (oc41720aed4a)((Object)arrayList3);
                                }
                                oc41720aed4a2 = oc41720aed4a3;
                            }
                            if (n != 0) break block33;
                            if (oc41720aed4a2 != null) break block34;
                            arrayList = arrayList2;
                            if (n != 0) break block35;
                            if (arrayList.size() <= 1) break block34;
                            this.\u0247("&cMultiple official configs match &b" + string2 + "&c:");
                            arrayList = arrayList2;
                        }
                        for (oc41720aed4a oc41720aed4a4 : arrayList) {
                            this.\u00e5(" &7" + oc41720aed4a4.\u00d6());
                            if (n == 0) continue;
                        }
                        return;
                    }
                    oc41720aed4a2 = oc41720aed4a3;
                }
                if (n != 0) break block36;
                if (oc41720aed4a2 != null) break block37;
                this.\u0247("&7Official config &b" + string2 + " &7does not exist.");
                return;
            }
            oc41720aed4a2 = oc41720aed4a3;
        }
        Iterator iterator2 = oc41720aed4a2;
        this.\u0247("&7Loading official config: &b" + ((oc41720aed4a)((Object)iterator2)).\u00d6());
        this.\u050c.\u0160(oc9e5a7eeec6.\u044d, (oc41720aed4a)((Object)iterator2), bl -> {
            block5: {
                block4: {
                    int n = \u0395;
                    if (!bl.booleanValue()) break block4;
                    this.\u0247("&7Loaded official config: &b" + iterator2.\u00d6());
                    if (n == 0) break block5;
                }
                this.\u0247("&cFailed to apply official config: &b" + iterator2.\u00d6());
            }
        }, string -> this.\u0247("&cFailed to load official config: &7" + string));
    }

    private List<String> E() {
        ArrayList<String> arrayList;
        block4: {
            ArrayList<String> arrayList2 = new ArrayList<String>();
            Iterator<oc41720aed4a> iterator2 = this.\u020f.iterator();
            int n = \u0395;
            while (iterator2.hasNext()) {
                oc41720aed4a oc41720aed4a2 = iterator2.next();
                arrayList = arrayList2;
                if (n == 0) {
                    arrayList.add(oc41720aed4a2.\u00d6());
                    if (n == 0) continue;
                    break;
                }
                break block4;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    private boolean R(String string) {
        boolean bl;
        block6: {
            block8: {
                block7: {
                    int n = \u0395;
                    bl = "load".equalsIgnoreCase(string);
                    if (n != 0) break block6;
                    if (bl) break block7;
                    bl = "l".equalsIgnoreCase(string);
                    if (n != 0) break block6;
                    if (!bl) break block8;
                }
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }
}

