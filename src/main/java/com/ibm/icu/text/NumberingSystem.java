/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingResourceException;

public class NumberingSystem {
    private String desc = "0123456789";
    private int radix = 10;
    private boolean algorithmic = false;
    private String name = "latn";
    private static ICUCache<String, NumberingSystem> cachedLocaleData = new SimpleCache<String, NumberingSystem>();
    private static ICUCache<String, NumberingSystem> cachedStringData = new SimpleCache<String, NumberingSystem>();

    public static NumberingSystem getInstance(int n, boolean bl, String string) {
        return NumberingSystem.getInstance(null, n, bl, string);
    }

    private static NumberingSystem getInstance(String string, int n, boolean bl, String string2) {
        if (n < 2) {
            throw new IllegalArgumentException("Invalid radix for numbering system");
        }
        if (!(bl || string2.length() == n && NumberingSystem.isValidDigitString(string2))) {
            throw new IllegalArgumentException("Invalid digit string for numbering system");
        }
        NumberingSystem numberingSystem = new NumberingSystem();
        numberingSystem.radix = n;
        numberingSystem.algorithmic = bl;
        numberingSystem.desc = string2;
        numberingSystem.name = string;
        return numberingSystem;
    }

    public static NumberingSystem getInstance(Locale locale) {
        return NumberingSystem.getInstance(ULocale.forLocale(locale));
    }

    public static NumberingSystem getInstance(ULocale uLocale) {
        NumberingSystem numberingSystem;
        Object object;
        Object object2;
        String[] stringArray = new String[]{"native", "traditional", "finance"};
        Boolean bl = true;
        String string = uLocale.getKeywordValue("numbers");
        if (string != null) {
            object2 = stringArray;
            int n = ((String[])object2).length;
            for (int i = 0; i < n; ++i) {
                object = object2[i];
                if (!string.equals(object)) continue;
                bl = false;
                break;
            }
        } else {
            string = "default";
            bl = false;
        }
        if (bl.booleanValue()) {
            numberingSystem = NumberingSystem.getInstanceByName(string);
            if (numberingSystem != null) {
                return numberingSystem;
            }
            string = "default";
            bl = false;
        }
        if ((numberingSystem = cachedLocaleData.get((String)(object2 = uLocale.getBaseName()) + "@numbers=" + string)) != null) {
            return numberingSystem;
        }
        String string2 = string;
        String string3 = null;
        while (!bl.booleanValue()) {
            try {
                object = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
                object = ((ICUResourceBundle)object).getWithFallback("NumberElements");
                string3 = ((ICUResourceBundle)object).getStringWithFallback(string);
                bl = true;
            }
            catch (MissingResourceException missingResourceException) {
                if (string.equals("native") || string.equals("finance")) {
                    string = "default";
                    continue;
                }
                if (string.equals("traditional")) {
                    string = "native";
                    continue;
                }
                bl = true;
            }
        }
        if (string3 != null) {
            numberingSystem = NumberingSystem.getInstanceByName(string3);
        }
        if (numberingSystem == null) {
            numberingSystem = new NumberingSystem();
        }
        cachedLocaleData.put((String)object2 + "@numbers=" + string2, numberingSystem);
        return numberingSystem;
    }

    public static NumberingSystem getInstance() {
        return NumberingSystem.getInstance(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public static NumberingSystem getInstanceByName(String string) {
        boolean bl;
        int n;
        String string2;
        NumberingSystem numberingSystem = cachedStringData.get(string);
        if (numberingSystem != null) {
            return numberingSystem;
        }
        try {
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "numberingSystems");
            UResourceBundle uResourceBundle2 = uResourceBundle.get("numberingSystems");
            UResourceBundle uResourceBundle3 = uResourceBundle2.get(string);
            string2 = uResourceBundle3.getString("desc");
            UResourceBundle uResourceBundle4 = uResourceBundle3.get("radix");
            UResourceBundle uResourceBundle5 = uResourceBundle3.get("algorithmic");
            n = uResourceBundle4.getInt();
            int n2 = uResourceBundle5.getInt();
            bl = n2 == 1;
        }
        catch (MissingResourceException missingResourceException) {
            return null;
        }
        numberingSystem = NumberingSystem.getInstance(string, n, bl, string2);
        cachedStringData.put(string, numberingSystem);
        return numberingSystem;
    }

    public static String[] getAvailableNames() {
        UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "numberingSystems");
        UResourceBundle uResourceBundle2 = uResourceBundle.get("numberingSystems");
        ArrayList<String> arrayList = new ArrayList<String>();
        UResourceBundleIterator uResourceBundleIterator = uResourceBundle2.getIterator();
        while (uResourceBundleIterator.hasNext()) {
            UResourceBundle uResourceBundle3 = uResourceBundleIterator.next();
            String string = uResourceBundle3.getKey();
            arrayList.add(string);
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean isValidDigitString(String string) {
        int n;
        int n2 = 0;
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(string);
        uCharacterIterator.setToStart();
        while ((n = uCharacterIterator.nextCodePoint()) != -1) {
            if (UCharacter.isSupplementary(n)) {
                return false;
            }
            ++n2;
        }
        return n2 == 10;
    }

    public int getRadix() {
        return this.radix;
    }

    public String getDescription() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAlgorithmic() {
        return this.algorithmic;
    }
}

