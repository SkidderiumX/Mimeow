/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.StringTranslate;

public class StatCollector {
    private static StringTranslate localizedName = StringTranslate.getInstance();
    private static StringTranslate fallbackTranslator = new StringTranslate();

    public static String translateToLocal(String string) {
        return localizedName.translateKey(string);
    }

    public static String translateToLocalFormatted(String string, Object ... objectArray) {
        return localizedName.translateKeyFormat(string, objectArray);
    }

    public static String translateToFallback(String string) {
        return fallbackTranslator.translateKey(string);
    }

    public static boolean canTranslate(String string) {
        return localizedName.isKeyTranslated(string);
    }

    public static long getLastTranslationUpdateTimeInMilliseconds() {
        return localizedName.getLastUpdateTimeInMilliseconds();
    }
}

