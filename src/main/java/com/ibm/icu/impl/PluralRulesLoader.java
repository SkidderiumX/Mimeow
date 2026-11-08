/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class PluralRulesLoader {
    private final Map<String, PluralRules> rulesIdToRules = new HashMap<String, PluralRules>();
    private Map<String, String> localeIdToCardinalRulesId;
    private Map<String, String> localeIdToOrdinalRulesId;
    private Map<String, ULocale> rulesIdToEquivalentULocale;
    public static final PluralRulesLoader loader = new PluralRulesLoader();

    private PluralRulesLoader() {
    }

    public ULocale[] getAvailableULocales() {
        Set<String> set = this.getLocaleIdToRulesIdMap(PluralRules.PluralType.CARDINAL).keySet();
        ULocale[] uLocaleArray = new ULocale[set.size()];
        int n = 0;
        Iterator<String> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            uLocaleArray[n++] = ULocale.createCanonical(iterator2.next());
        }
        return uLocaleArray;
    }

    public ULocale getFunctionalEquivalent(ULocale uLocale, boolean[] blArray) {
        Object object;
        String string;
        if (blArray != null && blArray.length > 0) {
            string = ULocale.canonicalize(uLocale.getBaseName());
            object = this.getLocaleIdToRulesIdMap(PluralRules.PluralType.CARDINAL);
            blArray[0] = object.containsKey(string);
        }
        if ((string = this.getRulesIdForLocale(uLocale, PluralRules.PluralType.CARDINAL)) == null || string.trim().length() == 0) {
            return ULocale.ROOT;
        }
        object = this.getRulesIdToEquivalentULocaleMap().get(string);
        if (object == null) {
            return ULocale.ROOT;
        }
        return object;
    }

    private Map<String, String> getLocaleIdToRulesIdMap(PluralRules.PluralType pluralType) {
        this.checkBuildRulesIdMaps();
        return pluralType == PluralRules.PluralType.CARDINAL ? this.localeIdToCardinalRulesId : this.localeIdToOrdinalRulesId;
    }

    private Map<String, ULocale> getRulesIdToEquivalentULocaleMap() {
        this.checkBuildRulesIdMaps();
        return this.rulesIdToEquivalentULocale;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkBuildRulesIdMaps() {
        boolean bl;
        TreeMap<String, String> treeMap = this;
        synchronized (treeMap) {
            bl = this.localeIdToCardinalRulesId != null;
        }
        if (!bl) {
            Map<String, String> map;
            Map<String, ULocale> map2;
            Object object;
            try {
                String string;
                String string2;
                UResourceBundle uResourceBundle;
                int n;
                object = this.getPluralBundle();
                UResourceBundle uResourceBundle2 = ((UResourceBundle)object).get("locales");
                treeMap = new TreeMap<String, String>();
                map2 = new HashMap();
                for (n = 0; n < uResourceBundle2.getSize(); ++n) {
                    uResourceBundle = uResourceBundle2.get(n);
                    string2 = uResourceBundle.getKey();
                    string = uResourceBundle.getString().intern();
                    treeMap.put(string2, string);
                    if (map2.containsKey(string)) continue;
                    map2.put(string, new ULocale(string2));
                }
                uResourceBundle2 = ((UResourceBundle)object).get("locales_ordinals");
                map = new TreeMap();
                for (n = 0; n < uResourceBundle2.getSize(); ++n) {
                    uResourceBundle = uResourceBundle2.get(n);
                    string2 = uResourceBundle.getKey();
                    string = uResourceBundle.getString().intern();
                    map.put(string2, string);
                }
            }
            catch (MissingResourceException missingResourceException) {
                treeMap = Collections.emptyMap();
                map = Collections.emptyMap();
                map2 = Collections.emptyMap();
            }
            object = this;
            synchronized (object) {
                if (this.localeIdToCardinalRulesId == null) {
                    this.localeIdToCardinalRulesId = treeMap;
                    this.localeIdToOrdinalRulesId = map;
                    this.rulesIdToEquivalentULocale = map2;
                }
            }
        }
    }

    public String getRulesIdForLocale(ULocale uLocale, PluralRules.PluralType pluralType) {
        int n;
        Map<String, String> map = this.getLocaleIdToRulesIdMap(pluralType);
        String string = ULocale.canonicalize(uLocale.getBaseName());
        String string2 = null;
        while (null == (string2 = map.get(string)) && (n = string.lastIndexOf("_")) != -1) {
            string = string.substring(0, n);
        }
        return string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PluralRules getRulesForRulesId(String string) {
        boolean bl;
        PluralRules pluralRules = null;
        Map<String, PluralRules> map = this.rulesIdToRules;
        synchronized (map) {
            bl = this.rulesIdToRules.containsKey(string);
            if (bl) {
                pluralRules = this.rulesIdToRules.get(string);
            }
        }
        if (!bl) {
            try {
                map = this.getPluralBundle();
                UResourceBundle uResourceBundle = ((UResourceBundle)((Object)map)).get("rules");
                UResourceBundle uResourceBundle2 = uResourceBundle.get(string);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < uResourceBundle2.getSize(); ++i) {
                    UResourceBundle uResourceBundle3 = uResourceBundle2.get(i);
                    if (i > 0) {
                        stringBuilder.append("; ");
                    }
                    stringBuilder.append(uResourceBundle3.getKey());
                    stringBuilder.append(": ");
                    stringBuilder.append(uResourceBundle3.getString());
                }
                pluralRules = PluralRules.parseDescription(stringBuilder.toString());
            }
            catch (ParseException parseException) {
            }
            catch (MissingResourceException missingResourceException) {
                // empty catch block
            }
            map = this.rulesIdToRules;
            synchronized (map) {
                if (this.rulesIdToRules.containsKey(string)) {
                    pluralRules = this.rulesIdToRules.get(string);
                } else {
                    this.rulesIdToRules.put(string, pluralRules);
                }
            }
        }
        return pluralRules;
    }

    public UResourceBundle getPluralBundle() throws MissingResourceException {
        return ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "plurals", ICUResourceBundle.ICU_DATA_CLASS_LOADER, true);
    }

    public PluralRules forLocale(ULocale uLocale, PluralRules.PluralType pluralType) {
        String string = this.getRulesIdForLocale(uLocale, pluralType);
        if (string == null || string.trim().length() == 0) {
            return PluralRules.DEFAULT;
        }
        PluralRules pluralRules = this.getRulesForRulesId(string);
        if (pluralRules == null) {
            pluralRules = PluralRules.DEFAULT;
        }
        return pluralRules;
    }
}

