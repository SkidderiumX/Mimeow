/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import x.oc66034502dd;
import x.oc6d9efd226f;
import x.oca8b96c4fe7;
import x.ocab1e1d632b;

public class oce12388a345 {
    public static final int \u021d = 64;
    private static final Comparator<oc6d9efd226f> \u03cd = new oca8b96c4fe7();
    public static boolean \u01fb;

    private oce12388a345() {
    }

    public static List<oc6d9efd226f> \u0149(oc66034502dd oc66034502dd2, String string) throws IOException {
        int n = oc6d9efd226f.\u03a5;
        if (oc66034502dd2 == null) {
            throw new IllegalArgumentException("A changelog page loader is required");
        }
        LinkedHashMap<String, oc6d9efd226f> linkedHashMap = new LinkedHashMap<String, oc6d9efd226f>();
        HashSet<Object> hashSet = new HashSet<Object>();
        Object object = null;
        boolean bl = false;
        boolean bl2 = false;
        for (int i = 0; i < (0x2B07FBE4 ^ 0x2B07FBA4); ++i) {
            boolean bl3;
            Object object2;
            block31: {
                block32: {
                    block30: {
                        ocab1e1d632b ocab1e1d632b2;
                        ocab1e1d632b ocab1e1d632b3;
                        block26: {
                            block27: {
                                ocab1e1d632b3 = oc66034502dd2.z$30pn5hy8v4k2i((String)object);
                                ocab1e1d632b2 = ocab1e1d632b3;
                                if (n != 0) break block26;
                                if (ocab1e1d632b2 != null) break block27;
                                throw new IOException("The changelog service returned an empty page");
                            }
                            ocab1e1d632b2 = ocab1e1d632b3;
                        }
                        Object object3 = object2 = ocab1e1d632b2.r().iterator();
                        while (object2.hasNext()) {
                            block28: {
                                oc6d9efd226f oc6d9efd226f2;
                                block29: {
                                    object3 = object2;
                                    if (n != 0) continue;
                                    oc6d9efd226f2 = object3.next();
                                    if (n != 0) break block28;
                                    if (oc6d9efd226f2 != null) break block29;
                                    throw new IOException("The changelog service returned an invalid entry");
                                }
                                linkedHashMap.put(oc6d9efd226f2.\u03b1(), oc6d9efd226f2);
                                bl |= oc6d9efd226f2.\u0259();
                                bl2 |= oce12388a345.\u0434(oc6d9efd226f2, string);
                            }
                            if (n == 0) continue;
                        }
                        object2 = ocab1e1d632b3.\u03af();
                        if (object2 == null) break block30;
                        bl3 = bl;
                        if (n != 0) break block31;
                        if (!bl3) break block32;
                        bl3 = bl2;
                        if (n != 0) break block31;
                        if (!bl3) break block32;
                    }
                    return oce12388a345.\u0428(linkedHashMap.values());
                }
                bl3 = hashSet.add(object2);
            }
            if (!bl3) {
                throw new IOException("The changelog service returned a cursor loop");
            }
            object = object2;
            if (n == 0) continue;
        }
        throw new IOException("The changelog service returned too many pages");
    }

    static boolean \u0434(oc6d9efd226f oc6d9efd226f2, String string) {
        String string2;
        block13: {
            String string3;
            block14: {
                String string4;
                int n;
                block11: {
                    block12: {
                        block10: {
                            n = oc6d9efd226f.\u03a5;
                            if (oc6d9efd226f2 == null) break block10;
                            string4 = string;
                            if (n != 0) break block11;
                            if (string4 != null) break block12;
                        }
                        return false;
                    }
                    string4 = oce12388a345.\u0126(string);
                }
                string3 = string4;
                string2 = string3;
                if (n != 0) break block13;
                if (!string2.isEmpty()) break block14;
                return false;
            }
            string2 = string3;
        }
        return string2.equalsIgnoreCase(oce12388a345.\u0126(oc6d9efd226f2.\u0235()));
    }

    static String \u0126(String string) {
        String string2;
        block22: {
            String string3;
            block23: {
                String string4;
                block24: {
                    block25: {
                        int n;
                        block20: {
                            block21: {
                                String string5;
                                block18: {
                                    block19: {
                                        n = oc6d9efd226f.\u03a5;
                                        string5 = string;
                                        if (n != 0) break block18;
                                        if (string5 != null) break block19;
                                        return "";
                                    }
                                    string5 = string.trim();
                                }
                                string3 = string5;
                                string2 = string3;
                                if (n != 0) break block20;
                                if (!string2.regionMatches(true, 0, "miau ", 0, 0xF5F9700E ^ 0xF5F9700B)) break block21;
                                string3 = string3.substring(0xF5F9700E ^ 0xF5F9700B).trim();
                            }
                            string2 = string3;
                        }
                        if (n != 0) break block22;
                        if (string2.length() <= 1) break block23;
                        string4 = string3;
                        if (n != 0) break block24;
                        if (string4.charAt(0) == (0xF5F9707D ^ 0xF5F9700B)) break block25;
                        string2 = string3;
                        if (n != 0) break block22;
                        if (string2.charAt(0) != (0xF5F9705D ^ 0xF5F9700B)) break block23;
                    }
                    string4 = string3.substring(1).trim();
                }
                string3 = string4;
            }
            string2 = string3;
        }
        return string2;
    }

    static List<oc6d9efd226f> \u0428(Iterable<oc6d9efd226f> iterable) {
        ArrayList<oc6d9efd226f> arrayList;
        block5: {
            arrayList = new ArrayList<oc6d9efd226f>();
            int n = oc6d9efd226f.\u03a5;
            for (oc6d9efd226f oc6d9efd226f2 : iterable) {
                block6: {
                    if (n != 0) break block5;
                    if (oc6d9efd226f2 == null) break block6;
                    arrayList.add(oc6d9efd226f2);
                }
                if (n == 0) continue;
            }
            Collections.sort(arrayList, \u03cd);
        }
        return Collections.unmodifiableList(arrayList);
    }
}

