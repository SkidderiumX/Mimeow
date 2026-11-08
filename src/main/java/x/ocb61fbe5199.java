/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import x.oc0723d1b697;
import x.oc2cf3d80e17;
import x.oc4cd250c7b8;
import x.oc66034502dd;
import x.oc6d9efd226f;
import x.occ995d8031c;
import x.occf618e31fa;
import x.oce12388a345;

public class ocb61fbe5199 {
    private static final int \u03af = 4;
    private static final Pattern \u04fc = Pattern.compile("^(\\d+(?:\\.\\d+)*)(?:[^0-9].*)?$");
    private static final Object \u0159 = new Object();
    private static volatile oc0723d1b697 \u0218 = oc0723d1b697.\u0441();
    private static boolean \u040e;
    private static boolean \u0566;
    public static int \u047f;

    private ocb61fbe5199() {
    }

    public static oc0723d1b697 \u01f5() {
        return \u0218;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void \u0476() {
        Object object = \u0159;
        synchronized (object) {
            boolean bl;
            block9: {
                block10: {
                    block8: {
                        int n;
                        block7: {
                            n = oc6d9efd226f.\u03a5;
                            bl = \u040e;
                            if (n != 0) break block7;
                            if (bl) break block8;
                            bl = \u0566;
                        }
                        if (n != 0) break block9;
                        if (!bl) break block10;
                    }
                    return;
                }
                bl = true;
            }
            \u040e = bl;
            \u0218 = oc0723d1b697.\u0441();
        }
        try {
            oc2cf3d80e17.P().execute(new occf618e31fa());
        }
        catch (RuntimeException runtimeException) {
            ocb61fbe5199.\u03f1(oc0723d1b697.\u02a7(), false);
        }
    }

    static oc0723d1b697 \u017e(oc66034502dd oc66034502dd2, String string) throws IOException {
        return ocb61fbe5199.\u054b(oce12388a345.\u0149(oc66034502dd2, string), string);
    }

    static oc0723d1b697 \u054b(List<oc6d9efd226f> list, String string) {
        String string2;
        Integer n;
        List<occ995d8031c> list2;
        List<occ995d8031c> list3;
        oc6d9efd226f oc6d9efd226f2;
        int n2;
        block24: {
            Integer n3;
            block22: {
                block23: {
                    Integer n4;
                    block25: {
                        List<oc6d9efd226f> list4;
                        block21: {
                            int n5;
                            block20: {
                                List<oc6d9efd226f> list5;
                                block19: {
                                    block18: {
                                        List<oc6d9efd226f> list6;
                                        block16: {
                                            block17: {
                                                n2 = oc6d9efd226f.\u03a5;
                                                list6 = list;
                                                if (n2 != 0) break block16;
                                                if (list6 != null) break block17;
                                                list6 = Collections.emptyList();
                                                break block16;
                                            }
                                            list6 = list;
                                        }
                                        list4 = oce12388a345.\u0428(list6);
                                        oc6d9efd226f2 = null;
                                        list3 = Collections.emptyList();
                                        for (oc6d9efd226f object3 : list4) {
                                            list2 = oc4cd250c7b8.\u050b(object3.\u01b3());
                                            if (list2.isEmpty()) continue;
                                            oc6d9efd226f2 = object3;
                                            list3 = ocb61fbe5199.\u0570(list2, 0x31393699 ^ 0x3139369D);
                                            break;
                                        }
                                        if (oc6d9efd226f2 != null) break block18;
                                        list5 = list4;
                                        if (n2 != 0) break block19;
                                        if (list5.isEmpty()) break block18;
                                        oc6d9efd226f2 = list4.get(0);
                                    }
                                    list5 = list4;
                                }
                                int n42 = ocb61fbe5199.\u03ae(list5, string);
                                n5 = n42;
                                if (n2 != 0) break block20;
                                if (n5 < 0) break block21;
                                n5 = n42;
                            }
                            n4 = n5;
                            break block25;
                        }
                        n4 = ocb61fbe5199.\u0103(list4, string);
                    }
                    n = n4;
                    n3 = n;
                    if (n2 != 0) break block22;
                    if (n3 != null) break block23;
                    string2 = "Unable to determine whether this version of Miau is up to date.";
                    break block24;
                }
                n3 = n;
            }
            string2 = ocb61fbe5199.\u03f5(n3);
        }
        list2 = string2;
        oc0723d1b697 oc0723d1b6972 = new oc0723d1b697((String)((Object)list2), oc6d9efd226f2, list3, n, false, false);
        if (false) {
            oc6d9efd226f.\u03a5 = ++n2;
        }
        return oc0723d1b6972;
    }

    static String \u03f5(int n) {
        int n2;
        block6: {
            block7: {
                int n3 = oc6d9efd226f.\u03a5;
                n2 = n;
                if (n3 != 0) break block6;
                if (n2 > 0) break block7;
                return "You are running the latest version of Miau!";
            }
            n2 = n;
        }
        String string = n == 1 ? "version" : "versions";
        return "You are running " + n2 + " " + string + " behind the latest version of Miau.";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void \u03f1(oc0723d1b697 oc0723d1b6972, boolean bl) {
        Object object = \u0159;
        synchronized (object) {
            \u0218 = oc0723d1b6972;
            \u0566 = bl;
            \u040e = false;
        }
    }

    private static int \u03ae(List<oc6d9efd226f> list, String string) {
        int n;
        block5: {
            int n2 = oc6d9efd226f.\u03a5;
            for (int i = 0; i < list.size(); ++i) {
                int n3;
                block6: {
                    n = oce12388a345.\u0434(list.get(i), string) ? 1 : 0;
                    if (n2 != 0) break block5;
                    if (n2 != 0) break block6;
                    if (n == 0) continue;
                    n3 = i;
                }
                return n3;
            }
            n = -1;
        }
        return n;
    }

    private static Integer \u0103(List<oc6d9efd226f> list, String string) {
        Integer n;
        block34: {
            int n2;
            block33: {
                int n3;
                block30: {
                    int n4;
                    Set<String> set;
                    int n5;
                    block28: {
                        block29: {
                            Integer n6;
                            block26: {
                                Integer n7;
                                block27: {
                                    List<oc6d9efd226f> list2;
                                    block24: {
                                        block25: {
                                            n5 = oc6d9efd226f.\u03a5;
                                            list2 = list;
                                            if (n5 != 0) break block24;
                                            if (!list2.isEmpty()) break block25;
                                            return null;
                                        }
                                        list2 = list;
                                    }
                                    set = ocb61fbe5199.\u0490(list2);
                                    n7 = ocb61fbe5199.\u0431(list.get(0).\u0235(), string, set);
                                    n6 = n7;
                                    if (n5 != 0) break block26;
                                    if (n6 != null) break block27;
                                    return null;
                                }
                                n6 = n7;
                            }
                            n4 = n6;
                            if (n5 != 0) break block28;
                            if (n4 > 0) break block29;
                            return 0;
                        }
                        n4 = 0;
                    }
                    n3 = n4;
                    for (oc6d9efd226f oc6d9efd226f2 : list) {
                        block32: {
                            Integer n8;
                            block31: {
                                Integer n9 = ocb61fbe5199.\u0431(oc6d9efd226f2.\u0235(), string, set);
                                if (n5 != 0) break block30;
                                n8 = n9;
                                if (n5 != 0) break block31;
                                if (n8 == null) break block32;
                                n8 = n9;
                            }
                            if (n8 > 0) {
                                ++n3;
                            }
                        }
                        if (n5 == 0) continue;
                    }
                    n2 = n3;
                    if (n5 != 0) break block33;
                    if (n2 != 0) break block30;
                    n = null;
                    break block34;
                }
                n2 = n3;
            }
            n = n2;
        }
        return n;
    }

    static Integer \u0549(String string, String string2) {
        return ocb61fbe5199.\u0431(string, string2, Collections.emptySet());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Integer \u0431(String string, String string2, Set<String> set) {
        int n;
        List<BigInteger> list;
        List<BigInteger> list2;
        int n2;
        List<BigInteger> list3;
        block18: {
            block19: {
                block17: {
                    list3 = ocb61fbe5199.B(string, set);
                    n2 = oc6d9efd226f.\u03a5;
                    list2 = ocb61fbe5199.B(string2, set);
                    list = list3;
                    if (n2 != 0) break block17;
                    if (list == null) return null;
                    list = list2;
                }
                if (n2 != 0) break block18;
                if (list != null) break block19;
                return null;
            }
            list = list3;
        }
        int n3 = Math.max(list.size(), list2.size());
        int n4 = 0;
        while (n4 < n3) {
            block22: {
                block23: {
                    BigInteger bigInteger;
                    block21: {
                        block20: {
                            n = n4;
                            if (n2 != 0) return n;
                            if (n >= list3.size()) break block20;
                            bigInteger = list3.get(n4);
                            break block21;
                        }
                        bigInteger = BigInteger.ZERO;
                    }
                    BigInteger bigInteger2 = bigInteger;
                    BigInteger bigInteger3 = n4 < list2.size() ? list2.get(n4) : BigInteger.ZERO;
                    BigInteger bigInteger4 = bigInteger3;
                    int n5 = bigInteger2.compareTo(bigInteger4);
                    if (n2 != 0) break block22;
                    if (n5 == 0) break block23;
                    return n5;
                }
                ++n4;
            }
            if (n2 == 0) continue;
        }
        n = 0;
        return n;
    }

    private static List<BigInteger> B(String string, Set<String> set) {
        ArrayList<BigInteger> arrayList;
        block17: {
            String string2;
            ArrayList<BigInteger> arrayList2;
            int n;
            block15: {
                int n2;
                block16: {
                    Matcher matcher;
                    block13: {
                        Matcher matcher2;
                        block14: {
                            String string3 = oce12388a345.\u0126(string);
                            matcher2 = \u04fc.matcher(string3);
                            n = oc6d9efd226f.\u03a5;
                            matcher = matcher2;
                            if (n != 0) break block13;
                            if (matcher.matches()) break block14;
                            return null;
                        }
                        matcher = matcher2;
                    }
                    String[] stringArray = matcher.group(1).split("\\.");
                    arrayList2 = new ArrayList<BigInteger>();
                    for (int i = 0; i < stringArray.length - 1; ++i) {
                        arrayList2.add(new BigInteger(stringArray[i]));
                        if (n == 0) continue;
                    }
                    string2 = stringArray[stringArray.length - 1];
                    n2 = ocb61fbe5199.\u00ef(stringArray, string2, set);
                    if (n != 0) break block15;
                    if (n2 > 0) break block16;
                    arrayList2.add(new BigInteger(string2));
                    return arrayList2;
                }
                arrayList2.add(new BigInteger(string2.substring(0, n2)));
            }
            for (int i = n2; i < string2.length(); ++i) {
                String string4 = String.valueOf(string2.charAt(i));
                arrayList = arrayList2;
                if (n == 0) {
                    arrayList.add(new BigInteger(string4));
                    if (n == 0) continue;
                    break;
                }
                break block17;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    private static int \u00ef(String[] stringArray, String string, Set<String> set) {
        int n;
        block28: {
            int n2;
            StringBuilder stringBuilder;
            int n3;
            block27: {
                int n4;
                block25: {
                    block24: {
                        int n5;
                        block22: {
                            block23: {
                                n3 = oc6d9efd226f.\u03a5;
                                n5 = string.length();
                                if (n3 != 0) break block22;
                                if (n5 < (0x43B8F23B ^ 0x43B8F239)) break block23;
                                n5 = set.isEmpty() ? 1 : 0;
                                if (n3 != 0) break block22;
                                if (n5 == 0) break block24;
                            }
                            n5 = -1;
                        }
                        return n5;
                    }
                    stringBuilder = new StringBuilder();
                    for (n2 = 0; n2 < stringArray.length - 1; ++n2) {
                        StringBuilder stringBuilder2;
                        block26: {
                            if (n3 != 0) break block25;
                            stringBuilder2 = stringBuilder;
                            if (n3 != 0) continue;
                            if (stringBuilder2.length() <= 0) break block26;
                            stringBuilder.append((char)(0x43B8F217 ^ 0x43B8F239));
                        }
                        stringBuilder2 = stringBuilder.append(stringArray[n2]);
                        if (n3 == 0) continue;
                    }
                    n4 = stringBuilder.length();
                    if (n3 != 0) break block27;
                    if (n4 <= 0) break block25;
                    stringBuilder.append((char)(0x43B8F217 ^ 0x43B8F239));
                }
                n4 = n2 = string.length() - 1;
            }
            while (n2 >= 1) {
                block30: {
                    int n6;
                    block29: {
                        n = set.contains(stringBuilder.toString() + string.substring(0, n2)) ? 1 : 0;
                        if (n3 != 0) break block28;
                        if (n3 != 0) break block29;
                        if (n == 0) break block30;
                        n6 = n2;
                    }
                    return n6;
                }
                --n2;
                if (n3 == 0) continue;
            }
            n = -1;
        }
        return n;
    }

    private static Set<String> \u0490(List<oc6d9efd226f> list) {
        HashSet<String> hashSet = new HashSet<String>();
        Iterator<oc6d9efd226f> iterator2 = list.iterator();
        int n = oc6d9efd226f.\u03a5;
        while (iterator2.hasNext()) {
            block5: {
                oc6d9efd226f oc6d9efd226f2 = iterator2.next();
                String string = oce12388a345.\u0126(oc6d9efd226f2.\u0235());
                boolean bl = string.isEmpty();
                if (n != 0 || bl) break block5;
                bl = hashSet.add(string);
            }
            if (n == 0) continue;
        }
        return hashSet;
    }

    private static List<occ995d8031c> \u0570(List<occ995d8031c> list, int n) {
        int n2 = Math.min(n, list.size());
        return Collections.unmodifiableList(new ArrayList<occ995d8031c>(list.subList(0, n2)));
    }
}

