/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.data;

import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import java.util.HashMap;
import java.util.Map;

public class PotionIdMappings1_9 {
    public static final Map<String, Integer> POTION_NAME_TO_ID = new HashMap<String, Integer>();
    public static final Map<Integer, String> POTION_ID_TO_NAME = new HashMap<Integer, String>();
    public static final Int2IntMap POTION_INDEX = new Int2IntOpenHashMap(36);

    public static String potionNameFromDamage(short s) {
        Object object;
        String string = POTION_ID_TO_NAME.get(s);
        if (string != null) {
            return string;
        }
        if (s == 0) {
            return "water";
        }
        int n = s & 0xF;
        int n2 = s & 0x3F;
        boolean bl = (s & 0x20) > 0;
        boolean bl2 = (s & 0x40) > 0;
        boolean bl3 = true;
        boolean bl4 = true;
        block0 : switch (n) {
            case 1: {
                object = "regeneration";
                break;
            }
            case 2: {
                object = "swiftness";
                break;
            }
            case 3: {
                object = "fire_resistance";
                bl3 = false;
                break;
            }
            case 4: {
                object = "poison";
                break;
            }
            case 5: {
                object = "healing";
                bl4 = false;
                break;
            }
            case 6: {
                object = "night_vision";
                bl3 = false;
                break;
            }
            case 8: {
                object = "weakness";
                bl3 = false;
                break;
            }
            case 9: {
                object = "strength";
                break;
            }
            case 10: {
                object = "slowness";
                bl3 = false;
                break;
            }
            case 11: {
                object = "leaping";
                break;
            }
            case 12: {
                object = "harming";
                bl4 = false;
                break;
            }
            case 13: {
                object = "water_breathing";
                bl3 = false;
                break;
            }
            case 14: {
                object = "invisibility";
                bl3 = false;
                break;
            }
            default: {
                bl3 = false;
                bl4 = false;
                switch (n2) {
                    case 0: {
                        Object object2 = "mundane";
                        break block0;
                    }
                    case 16: {
                        Object object2 = "awkward";
                        break block0;
                    }
                    case 32: {
                        Object object2 = "thick";
                        break block0;
                    }
                    default: {
                        Object object2 = object = "empty";
                    }
                }
            }
        }
        if (n > 0) {
            if (bl3 && bl) {
                object = "strong_" + (String)object;
            } else if (bl4 && bl2) {
                object = "long_" + (String)object;
            }
        }
        return object;
    }

    public static int getNewPotionID(int n) {
        int n2;
        if (n >= 16384) {
            n -= 8192;
        }
        if ((n2 = POTION_INDEX.get(n)) != -1) {
            return n2;
        }
        n2 = POTION_INDEX.get(n = POTION_NAME_TO_ID.get(PotionIdMappings1_9.potionNameFromDamage((short)n)).intValue());
        return n2 != -1 ? n2 : 0;
    }

    private static void register(int n, String string) {
        POTION_INDEX.put(n, POTION_ID_TO_NAME.size());
        POTION_ID_TO_NAME.put(n, string);
        POTION_NAME_TO_ID.put(string, n);
    }

    static {
        PotionIdMappings1_9.register(-1, "empty");
        PotionIdMappings1_9.register(0, "water");
        PotionIdMappings1_9.register(64, "mundane");
        PotionIdMappings1_9.register(32, "thick");
        PotionIdMappings1_9.register(16, "awkward");
        PotionIdMappings1_9.register(8198, "night_vision");
        PotionIdMappings1_9.register(8262, "long_night_vision");
        PotionIdMappings1_9.register(8206, "invisibility");
        PotionIdMappings1_9.register(8270, "long_invisibility");
        PotionIdMappings1_9.register(8203, "leaping");
        PotionIdMappings1_9.register(8267, "long_leaping");
        PotionIdMappings1_9.register(8235, "strong_leaping");
        PotionIdMappings1_9.register(8195, "fire_resistance");
        PotionIdMappings1_9.register(8259, "long_fire_resistance");
        PotionIdMappings1_9.register(8194, "swiftness");
        PotionIdMappings1_9.register(8258, "long_swiftness");
        PotionIdMappings1_9.register(8226, "strong_swiftness");
        PotionIdMappings1_9.register(8202, "slowness");
        PotionIdMappings1_9.register(8266, "long_slowness");
        PotionIdMappings1_9.register(8205, "water_breathing");
        PotionIdMappings1_9.register(8269, "long_water_breathing");
        PotionIdMappings1_9.register(8261, "healing");
        PotionIdMappings1_9.register(8229, "strong_healing");
        PotionIdMappings1_9.register(8204, "harming");
        PotionIdMappings1_9.register(8236, "strong_harming");
        PotionIdMappings1_9.register(8196, "poison");
        PotionIdMappings1_9.register(8260, "long_poison");
        PotionIdMappings1_9.register(8228, "strong_poison");
        PotionIdMappings1_9.register(8193, "regeneration");
        PotionIdMappings1_9.register(8257, "long_regeneration");
        PotionIdMappings1_9.register(8225, "strong_regeneration");
        PotionIdMappings1_9.register(8201, "strength");
        PotionIdMappings1_9.register(8265, "long_strength");
        PotionIdMappings1_9.register(8233, "strong_strength");
        PotionIdMappings1_9.register(8200, "weakness");
        PotionIdMappings1_9.register(8264, "long_weakness");
    }
}

