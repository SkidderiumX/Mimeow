/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import x.oc0af730cc9f;
import x.oc75d51ec7eb;
import x.occ36fe312d9;
import x.oceec1bc68ed;

public class oc9be9d1e2c8 {
    private static final int \u0113 = 100;
    private static final int \u037c = 16384;
    private static List<occ36fe312d9> \u0435;
    private static Map<String, occ36fe312d9> \u00c4;
    private static final Map<Integer, ItemStack> \u024e;
    public static boolean \u0568;

    private oc9be9d1e2c8() {
    }

    public static List<occ36fe312d9> \u01d2(String string, oc0af730cc9f oc0af730cc9f2) {
        ArrayList arrayList;
        block26: {
            ArrayList<oceec1bc68ed> arrayList2;
            int n;
            block22: {
                String string2;
                block21: {
                    String string3;
                    block19: {
                        block20: {
                            oc9be9d1e2c8.\u04de();
                            n = oc75d51ec7eb.\u03e9;
                            string3 = string;
                            if (n != 0) break block19;
                            if (string3 != null) break block20;
                            string2 = "";
                            break block21;
                        }
                        string3 = string;
                    }
                    string2 = string3.trim();
                }
                String string4 = string2;
                String string5 = string4.toLowerCase(Locale.ROOT);
                arrayList2 = new ArrayList<oceec1bc68ed>();
                for (occ36fe312d9 occ36fe312d92 : \u0435) {
                    block25: {
                        int n2;
                        block23: {
                            block24: {
                                if (n != 0) break block22;
                                n2 = oc0af730cc9f2.\u0397(occ36fe312d92.\u03e2);
                                if (n != 0) break block23;
                                if (n2 == 0) break block24;
                                if (n == 0) continue;
                            }
                            n2 = oc9be9d1e2c8.\u03b4(occ36fe312d92, string5);
                        }
                        int n3 = n2;
                        int n4 = n3;
                        if (n != 0 || n4 <= 0) break block25;
                        n4 = arrayList2.add(new oceec1bc68ed(occ36fe312d92, n3)) ? 1 : 0;
                    }
                    if (n == 0) continue;
                }
                arrayList2.sort(Comparator.comparingInt(oceec1bc68ed2 -> -oceec1bc68ed2.\u01f3).thenComparing(oceec1bc68ed2 -> oceec1bc68ed2.\u044e.\u01b6, String.CASE_INSENSITIVE_ORDER).thenComparing(oceec1bc68ed2 -> oceec1bc68ed2.\u044e.\u03e2));
            }
            ArrayList arrayList3 = new ArrayList(Math.min(0xEDDAC308 ^ 0xEDDAC36C, arrayList2.size()));
            for (int i = 0; i < Math.min(0xEDDAC308 ^ 0xEDDAC36C, arrayList2.size()); ++i) {
                arrayList = arrayList3;
                if (n == 0) {
                    arrayList.add(((oceec1bc68ed)arrayList2.get((int)i)).\u044e);
                    if (n == 0) continue;
                    break;
                }
                break block26;
            }
            arrayList = arrayList3;
        }
        return arrayList;
    }

    public static String \u047f(String string) {
        String string2;
        block4: {
            block3: {
                occ36fe312d9 occ36fe312d92;
                block2: {
                    oc9be9d1e2c8.\u04de();
                    occ36fe312d9 occ36fe312d93 = \u00c4.get(string);
                    int n = oc75d51ec7eb.\u03e9;
                    occ36fe312d92 = occ36fe312d93;
                    if (n != 0) break block2;
                    if (occ36fe312d92 == null) break block3;
                    occ36fe312d92 = occ36fe312d93;
                }
                string2 = occ36fe312d92.\u01b6;
                break block4;
            }
            string2 = string;
        }
        return string2;
    }

    public static ItemStack \u03ce(String string) {
        ItemStack itemStack;
        block17: {
            block18: {
                int n;
                int n2;
                occ36fe312d9 occ36fe312d92;
                block13: {
                    block14: {
                        ItemStack itemStack2;
                        block15: {
                            block16: {
                                oc9be9d1e2c8.\u04de();
                                occ36fe312d92 = \u00c4.get(string);
                                n2 = oc75d51ec7eb.\u03e9;
                                if (occ36fe312d92 == null) {
                                    return null;
                                }
                                n = \u024e.containsKey(occ36fe312d92.\u0423);
                                if (n2 != 0) break block13;
                                if (n == 0) break block14;
                                ItemStack itemStack3 = \u024e.get(occ36fe312d92.\u0423);
                                itemStack2 = itemStack3;
                                if (n2 != 0) break block15;
                                if (itemStack2 == null) break block16;
                                itemStack2 = itemStack3.copy();
                                break block15;
                            }
                            itemStack2 = null;
                        }
                        return itemStack2;
                    }
                    n = occ36fe312d92.\u0423;
                }
                ItemStack itemStack4 = oc9be9d1e2c8.\u042d(n);
                \u024e.put(occ36fe312d92.\u0423, itemStack4);
                itemStack = itemStack4;
                if (n2 != 0) break block17;
                if (itemStack == null) break block18;
                itemStack = itemStack4.copy();
                break block17;
            }
            itemStack = null;
        }
        return itemStack;
    }

    private static int \u03b4(occ36fe312d9 occ36fe312d92, String string) {
        int n;
        block54: {
            block55: {
                int n2;
                block52: {
                    block53: {
                        String string2;
                        String string3;
                        int n3;
                        block51: {
                            String string4;
                            String string5;
                            block49: {
                                String string6;
                                String string7;
                                block46: {
                                    block47: {
                                        block44: {
                                            block45: {
                                                block42: {
                                                    block43: {
                                                        block40: {
                                                            block41: {
                                                                String string8;
                                                                block38: {
                                                                    block39: {
                                                                        n3 = oc75d51ec7eb.\u03e9;
                                                                        string8 = string;
                                                                        if (n3 != 0) break block38;
                                                                        if (!string8.isEmpty()) break block39;
                                                                        return 1;
                                                                    }
                                                                    string8 = occ36fe312d92.\u01b6.toLowerCase(Locale.ROOT);
                                                                }
                                                                string7 = string8;
                                                                string3 = occ36fe312d92.\u03e2.toLowerCase(Locale.ROOT);
                                                                string5 = oc9be9d1e2c8.\u0470(occ36fe312d92.\u03e2).toLowerCase(Locale.ROOT);
                                                                string6 = string7;
                                                                if (n3 != 0) break block40;
                                                                if (!string6.equals(string)) break block41;
                                                                return 0xE4651B8C ^ 0xE4651864;
                                                            }
                                                            string6 = string5;
                                                        }
                                                        if (n3 != 0) break block42;
                                                        if (!string6.equals(string)) break block43;
                                                        return 0xE4651BE0 ^ 0xE4651864;
                                                    }
                                                    string6 = string7;
                                                }
                                                if (n3 != 0) break block44;
                                                if (!string6.startsWith(string)) break block45;
                                                return 0xE4651B44 ^ 0xE4651864;
                                            }
                                            string6 = string5;
                                        }
                                        if (n3 != 0) break block46;
                                        if (!string6.startsWith(string)) break block47;
                                        return 0xE4651AD8 ^ 0xE4651864;
                                    }
                                    string6 = string7;
                                }
                                String[] stringArray = string6.split("\\s+");
                                int n4 = stringArray.length;
                                int n5 = 0;
                                while (n5 < n4) {
                                    block48: {
                                        block50: {
                                            String string9 = stringArray[n5];
                                            if (n3 != 0) break block48;
                                            String string4 = string9;
                                            string4 = string;
                                            if (n3 != 0) break block49;
                                            if (!string2.startsWith(string4)) break block50;
                                            return 0xE4651A3C ^ 0xE4651864;
                                        }
                                        ++n5;
                                    }
                                    if (n3 == 0) continue;
                                }
                                string2 = string7;
                                if (n3 != 0) break block51;
                                string4 = string;
                            }
                            if (string2.contains(string4)) {
                                return 0xE4651990 ^ 0xE4651864;
                            }
                            string2 = string5;
                        }
                        n2 = string2.contains(string);
                        if (n3 != 0) break block52;
                        if (n2 != 0) break block53;
                        n = string3.contains(string);
                        if (n3 != 0) break block54;
                        if (n == 0) break block55;
                    }
                    n2 = 0xE46519F4 ^ 0xE4651864;
                }
                return n2;
            }
            n = 0;
        }
        return n;
    }

    private static String \u0470(String string) {
        String string2;
        block18: {
            block17: {
                int n;
                int n2;
                block16: {
                    String string3;
                    int n3;
                    block14: {
                        block15: {
                            String string4;
                            block12: {
                                block13: {
                                    n3 = oc75d51ec7eb.\u03e9;
                                    string4 = string;
                                    if (n3 != 0) break block12;
                                    if (string4 == null) break block13;
                                    string3 = string;
                                    if (n3 != 0) break block14;
                                    if (!string3.isEmpty()) break block15;
                                }
                                string4 = "";
                            }
                            return string4;
                        }
                        string3 = string;
                    }
                    n2 = string3.lastIndexOf(0xF92AA19F ^ 0xF92AA1B1);
                    n = n2;
                    if (n3 != 0) break block16;
                    if (n < 0) break block17;
                    n = n2;
                }
                if (n >= string.length() - 1) break block17;
                string2 = string.substring(n2 + 1);
                break block18;
            }
            string2 = string;
        }
        return string2;
    }

    private static void \u04de() {
        int n;
        block33: {
            n = oc75d51ec7eb.\u03e9;
            if (\u0435 == null || \u00c4 == null) break block33;
            return;
        }
        LinkedHashMap<String, occ36fe312d9> linkedHashMap = new LinkedHashMap<String, occ36fe312d9>();
        int n2 = 0;
        while (n2 < Potion.potionTypes.length) {
            block34: {
                block35: {
                    Object object;
                    String string;
                    String string2;
                    block41: {
                        String string3;
                        block39: {
                            block40: {
                                Potion potion;
                                block37: {
                                    Potion potion2;
                                    block38: {
                                        block36: {
                                            potion2 = Potion.potionTypes[n2];
                                            if (n != 0) break block34;
                                            if (potion2 == null) break block35;
                                            potion = potion2;
                                            if (n != 0) break block36;
                                            if (potion.getName() == null) break block35;
                                            potion = potion2;
                                        }
                                        if (n != 0) break block37;
                                        if (!potion.getName().isEmpty()) break block38;
                                        if (n == 0) break block35;
                                    }
                                    potion = potion2;
                                }
                                string2 = potion.getName();
                                if (linkedHashMap.containsKey(string2) && n == 0) break block35;
                                string = StatCollector.translateToLocal(string2);
                                string3 = string;
                                if (n != 0) break block39;
                                if (string3 == null) break block40;
                                string3 = string;
                                if (n != 0) break block39;
                                if (string3.isEmpty()) break block40;
                                object = string;
                                if (n != 0) break block35;
                                if (!((String)object).equals(string2)) break block41;
                            }
                            string3 = oc9be9d1e2c8.\u0470(string2);
                        }
                        string = string3;
                    }
                    object = linkedHashMap.put(string2, new occ36fe312d9(n2, string2, string));
                }
                ++n2;
            }
            if (n == 0) continue;
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.values());
        arrayList.sort(Comparator.comparing(occ36fe312d92 -> occ36fe312d92.\u01b6, String.CASE_INSENSITIVE_ORDER).thenComparing(occ36fe312d92 -> occ36fe312d92.\u03e2));
        \u0435 = Collections.unmodifiableList(arrayList);
        \u00c4 = linkedHashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ItemStack \u042d(int n) {
        ItemStack itemStack;
        block37: {
            int n2 = oc75d51ec7eb.\u03e9;
            ItemPotion itemPotion = Items.potionitem;
            if (n2 == 0) {
                if (!(itemPotion instanceof ItemPotion)) {
                    return null;
                }
                itemPotion = Items.potionitem;
            }
            ItemPotion itemPotion2 = itemPotion;
            ItemStack itemStack2 = null;
            int n3 = 0x75CE7FD ^ 0x875CE7FD;
            int n4 = 0;
            while (n4 <= (0x875CA7FD ^ 0x875CE7FD)) {
                block39: {
                    block40: {
                        int n5;
                        block49: {
                            int n6;
                            block48: {
                                int n7;
                                block47: {
                                    block46: {
                                        List<PotionEffect> list;
                                        block38: {
                                            int n8;
                                            block41: {
                                                if (n2 != 0) break block37;
                                                list = itemPotion2.getEffects(n4);
                                                if (n2 != 0) break block39;
                                                if (list == null) break block40;
                                                n8 = list.isEmpty();
                                                if (n2 != 0) break block41;
                                                if (n8 != 0 && n2 == 0) break block40;
                                                n8 = 0;
                                            }
                                            n6 = n8;
                                            int n9 = 0;
                                            for (PotionEffect potionEffect : list) {
                                                block45: {
                                                    block43: {
                                                        block44: {
                                                            block42: {
                                                                if (n2 != 0) break block42;
                                                                n7 = potionEffect.getPotionID();
                                                                if (n2 != 0) break block38;
                                                                if (n7 != n) break block43;
                                                                n9 = 1;
                                                                if (n2 != 0) break block44;
                                                                n6 += 100;
                                                            }
                                                            if (potionEffect.getAmplifier() != 0) break block45;
                                                            n6 += 10;
                                                        }
                                                        if (n2 == 0) break block45;
                                                    }
                                                    n6 -= 20;
                                                }
                                                if (n2 == 0) continue;
                                            }
                                            n7 = n9;
                                        }
                                        if (n2 != 0) break block46;
                                        if (n7 == 0 && n2 == 0) break block40;
                                        n7 = list.size();
                                    }
                                    if (n2 != 0) break block47;
                                    if (n7 == 1) {
                                        n6 += 50;
                                    }
                                    n5 = n4;
                                    if (n2 != 0) break block48;
                                    n7 = ItemPotion.isSplash(n5) ? 1 : 0;
                                }
                                if (n7 == 0) {
                                    n6 += 25;
                                }
                                n5 = n6;
                            }
                            if (n2 != 0) break block49;
                            if (n5 <= n3) break block40;
                            n5 = n6;
                        }
                        n3 = n5;
                        itemStack2 = new ItemStack(Items.potionitem, 1, n4);
                    }
                    ++n4;
                }
                if (n2 == 0) continue;
            }
            itemStack = itemStack2;
            if (n2 != 0) return itemStack;
            if (itemStack != null) {
                itemStack = itemStack2;
                return itemStack;
            }
        }
        itemStack = new ItemStack(Items.potionitem);
        return itemStack;
    }

    static {
        \u024e = new HashMap<Integer, ItemStack>();
    }
}

