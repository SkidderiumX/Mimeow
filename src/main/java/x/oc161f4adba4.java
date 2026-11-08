/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import x.oc17aaf5d285;
import x.oc2cf3d80e17;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc7b3527f5bb;
import x.ocaae9de8508;
import x.ocda171fe5d8;

public abstract class oc161f4adba4
implements ocda171fe5d8 {
    private final String \u03cd;
    private final String[] \u040f;
    private final String \u0575;
    private final oc17aaf5d285 \u0519;
    private final String[] \u0297;
    public static int \u04a7;

    protected oc161f4adba4(String string, String ... stringArray) {
        this(string, "No description available.", oc17aaf5d285.\u01e5, new String[]{string}, stringArray);
    }

    protected oc161f4adba4(String string, String string2, oc17aaf5d285 oc17aaf5d2852, String[] stringArray, String ... stringArray2) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("Command name cannot be empty");
        }
        this.\u03cd = string.trim().toLowerCase(Locale.ROOT);
        this.\u0575 = string2 == null || string2.trim().isEmpty() ? "No description available." : string2.trim();
        this.\u0519 = oc17aaf5d2852 == null ? oc17aaf5d285.\u01e5 : oc17aaf5d2852;
        this.\u0297 = this.\u01b9(stringArray);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        if (stringArray2 != null) {
            for (String string3 : stringArray2) {
                String string4;
                if (string3 == null || (string4 = string3.trim().toLowerCase(Locale.ROOT)).isEmpty() || string4.equals(this.\u03cd)) continue;
                linkedHashSet.add(string4);
            }
        }
        this.\u040f = linkedHashSet.toArray(new String[0]);
    }

    private String[] \u01b9(String[] stringArray) {
        LinkedHashSet<String> linkedHashSet;
        block22: {
            LinkedHashSet<String> linkedHashSet2;
            block19: {
                int n;
                block18: {
                    String[] stringArray2;
                    block17: {
                        linkedHashSet2 = new LinkedHashSet<String>();
                        n = \u04a7;
                        stringArray2 = stringArray;
                        if (n != 0) break block17;
                        if (stringArray2 == null) break block18;
                        stringArray2 = stringArray;
                    }
                    String[] stringArray3 = stringArray2;
                    int n2 = stringArray3.length;
                    int n3 = 0;
                    while (n3 < n2) {
                        block20: {
                            block21: {
                                String string = stringArray3[n3];
                                if (n != 0) break block19;
                                if (n != 0) break block20;
                                if (string == null) break block21;
                                boolean bl = string.trim().isEmpty();
                                if (n != 0) break block21;
                                if (bl) break block21;
                                bl = linkedHashSet2.add(string.trim());
                            }
                            ++n3;
                        }
                        if (n == 0) continue;
                    }
                }
                linkedHashSet = linkedHashSet2;
                if (n != 0) break block22;
                if (!linkedHashSet.isEmpty()) break block19;
                linkedHashSet2.add(this.\u03cd);
            }
            linkedHashSet = linkedHashSet2;
        }
        return linkedHashSet.toArray(new String[0]);
    }

    public final String \u03c3() {
        return this.\u03cd;
    }

    public final String[] \u04e3() {
        return (String[])this.\u040f.clone();
    }

    public final String \u03c1() {
        return this.\u0575;
    }

    public final oc17aaf5d285 \u00ca() {
        return this.\u0519;
    }

    public final String[] \u026e() {
        return (String[])this.\u0297.clone();
    }

    public final boolean \u04f3(String string) {
        boolean bl;
        block20: {
            oc161f4adba4 oc161f4adba42;
            int n;
            block18: {
                String string2;
                block16: {
                    block17: {
                        n = \u04a7;
                        string2 = string;
                        if (n != 0) break block16;
                        if (string2 != null) break block17;
                        return false;
                    }
                    oc161f4adba42 = this;
                    if (n != 0) break block18;
                    string2 = oc161f4adba42.\u03cd;
                }
                if (string2.equalsIgnoreCase(string)) {
                    return true;
                }
                oc161f4adba42 = this;
            }
            String[] stringArray = oc161f4adba42.\u040f;
            int n2 = stringArray.length;
            int n3 = 0;
            while (n3 < n2) {
                block19: {
                    block21: {
                        String string3 = stringArray[n3];
                        if (n != 0) break block19;
                        bl = string3.equalsIgnoreCase(string);
                        if (n != 0) break block20;
                        if (!bl) break block21;
                        return true;
                    }
                    ++n3;
                }
                if (n == 0) continue;
            }
            bl = false;
        }
        return bl;
    }

    public abstract void z$2uoow1halcq2f(ocaae9de8508 var1);

    public List<String> z$9ofids0wyz4j(ocaae9de8508 ocaae9de85082) {
        return Collections.emptyList();
    }

    public int z$7k2utc7u0w8s(ocaae9de8508 ocaae9de85082) {
        return Math.max(0, ocaae9de85082.\u04fe() - 1);
    }

    protected final void \u0247(String string) {
        this.\u0131(string);
    }

    protected final void \u00e5(String string) {
        this.\u0131(string);
    }

    protected final void \u01fb() {
        this.\u0131("&cInvalid syntax. &7Use &b.help " + this.\u03cd + "&7.");
    }

    protected final String \u0215(String string) {
        return "." + string;
    }

    protected final List<String> \u0495(ocaae9de8508 ocaae9de85082, List<String> list) {
        LinkedHashSet<String> linkedHashSet;
        block28: {
            List<String> list2;
            String string;
            int n;
            block27: {
                String string2;
                block26: {
                    String string3;
                    block24: {
                        String string4;
                        block25: {
                            String string5;
                            block23: {
                                ocaae9de8508 ocaae9de85083;
                                block21: {
                                    block22: {
                                        n = \u04a7;
                                        ocaae9de85083 = ocaae9de85082;
                                        if (n != 0) break block21;
                                        if (ocaae9de85083.\u04fe() != 0) break block22;
                                        string5 = "";
                                        break block23;
                                    }
                                    ocaae9de85083 = ocaae9de85082;
                                }
                                string5 = ocaae9de85083.\u044c(ocaae9de85082.\u04fe() - 1);
                            }
                            string4 = string5;
                            string3 = string4;
                            if (n != 0) break block24;
                            if (string3 != null) break block25;
                            string2 = "";
                            break block26;
                        }
                        string3 = string4;
                    }
                    string2 = string3.toLowerCase(Locale.ROOT);
                }
                string = string2;
                linkedHashSet = new LinkedHashSet<String>();
                list2 = list;
                if (n != 0) break block27;
                if (list2 == null) break block28;
                list2 = list;
            }
            for (String string6 : list2) {
                block30: {
                    String string7;
                    block29: {
                        string7 = string6;
                        if (n != 0) break block29;
                        if (string7 == null) break block30;
                        string7 = string6.toLowerCase(Locale.ROOT);
                    }
                    boolean bl = string7.startsWith(string);
                    if (n != 0 || !bl) break block30;
                    bl = linkedHashSet.add(string6);
                }
                if (n == 0) continue;
                boolean bl = !false;
                oc69da1aa7f5.\u04ac = bl;
                break;
            }
        }
        return new ArrayList<String>(linkedHashSet);
    }

    protected final List<String> \u0120(ocaae9de8508 ocaae9de85082, String ... stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (stringArray != null) {
            Collections.addAll(arrayList, stringArray);
        }
        return this.\u0495(ocaae9de85082, arrayList);
    }

    private void \u0131(String string) {
        oc7ab2161b9f.\u00fd(this.\u010b(string));
    }

    private String \u010b(String string) {
        String string2;
        block4: {
            block3: {
                oc7b3527f5bb oc7b3527f5bb2;
                block2: {
                    int n = \u04a7;
                    oc7b3527f5bb2 = oc2cf3d80e17.\u0449;
                    if (n != 0) break block2;
                    if (oc7b3527f5bb2 == null) break block3;
                    oc7b3527f5bb2 = oc2cf3d80e17.\u0449;
                }
                string2 = oc7b3527f5bb2.\u042d(string);
                break block4;
            }
            string2 = string;
        }
        return string2;
    }
}

