/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import java.util.Map;
import net.minecraft.client.resources.Locale;

public class I18n {
    private static Locale i18nLocale;

    static void setLocale(Locale locale) {
        i18nLocale = locale;
    }

    public static String format(String string, Object ... objectArray) {
        return i18nLocale.formatMessage(string, objectArray);
    }

    public static Map getLocaleProperties() {
        return I18n.i18nLocale.properties;
    }
}

