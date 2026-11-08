/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.ICUResourceBundleImpl;
import com.ibm.icu.impl.ICUResourceBundleReader;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.URLHandler;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ICUResourceBundle
extends UResourceBundle {
    protected static final String ICU_DATA_PATH = "com/ibm/icu/impl/";
    public static final String ICU_BUNDLE = "data/icudt51b";
    public static final String ICU_BASE_NAME = "com/ibm/icu/impl/data/icudt51b";
    public static final String ICU_COLLATION_BASE_NAME = "com/ibm/icu/impl/data/icudt51b/coll";
    public static final String ICU_BRKITR_NAME = "/brkitr";
    public static final String ICU_BRKITR_BASE_NAME = "com/ibm/icu/impl/data/icudt51b/brkitr";
    public static final String ICU_RBNF_BASE_NAME = "com/ibm/icu/impl/data/icudt51b/rbnf";
    public static final String ICU_TRANSLIT_BASE_NAME = "com/ibm/icu/impl/data/icudt51b/translit";
    public static final String ICU_LANG_BASE_NAME = "com/ibm/icu/impl/data/icudt51b/lang";
    public static final String ICU_CURR_BASE_NAME = "com/ibm/icu/impl/data/icudt51b/curr";
    public static final String ICU_REGION_BASE_NAME = "com/ibm/icu/impl/data/icudt51b/region";
    public static final String ICU_ZONE_BASE_NAME = "com/ibm/icu/impl/data/icudt51b/zone";
    private static final String NO_INHERITANCE_MARKER = "\u2205\u2205\u2205";
    protected String resPath;
    public static final ClassLoader ICU_DATA_CLASS_LOADER;
    protected static final String INSTALLED_LOCALES = "InstalledLocales";
    public static final int FROM_FALLBACK = 1;
    public static final int FROM_ROOT = 2;
    public static final int FROM_DEFAULT = 3;
    public static final int FROM_LOCALE = 4;
    private int loadingStatus = -1;
    private static final String ICU_RESOURCE_INDEX = "res_index";
    private static final String DEFAULT_TAG = "default";
    private static final String FULL_LOCALE_NAMES_LIST = "fullLocaleNames.lst";
    private static final boolean DEBUG;
    private static CacheBase<String, AvailEntry, ClassLoader> GET_AVAILABLE_CACHE;
    protected String localeID;
    protected String baseName;
    protected ULocale ulocale;
    protected ClassLoader loader;
    protected ICUResourceBundleReader reader;
    protected String key;
    protected int resource;
    public static final int RES_BOGUS = -1;
    public static final int ALIAS = 3;
    public static final int TABLE32 = 4;
    public static final int TABLE16 = 5;
    public static final int STRING_V2 = 6;
    public static final int ARRAY16 = 9;
    private static final int[] gPublicTypes;
    private static final char RES_PATH_SEP_CHAR = '/';
    private static final String RES_PATH_SEP_STR = "/";
    private static final String ICUDATA = "ICUDATA";
    private static final char HYPHEN = '-';
    private static final String LOCALE = "LOCALE";
    protected ICUCache<Object, UResourceBundle> lookup;
    private static final int MAX_INITIAL_LOOKUP_SIZE = 64;

    @Override
    public void setLoadingStatus(int n) {
        this.loadingStatus = n;
    }

    public int getLoadingStatus() {
        return this.loadingStatus;
    }

    public void setLoadingStatus(String string) {
        String string2 = this.getLocaleID();
        if (string2.equals("root")) {
            this.setLoadingStatus(2);
        } else if (string2.equals(string)) {
            this.setLoadingStatus(4);
        } else {
            this.setLoadingStatus(1);
        }
    }

    public String getResPath() {
        return this.resPath;
    }

    public static final ULocale getFunctionalEquivalent(String string, ClassLoader classLoader, String string2, String string3, ULocale uLocale, boolean[] blArray, boolean bl) {
        Object object;
        String string4 = uLocale.getKeywordValue(string3);
        String string5 = uLocale.getBaseName();
        String string6 = null;
        ULocale uLocale2 = new ULocale(string5);
        ULocale uLocale3 = null;
        boolean bl2 = false;
        ULocale uLocale4 = null;
        int n = 0;
        int n2 = 0;
        if (string4 == null || string4.length() == 0 || string4.equals(DEFAULT_TAG)) {
            string4 = "";
            bl2 = true;
        }
        ICUResourceBundle iCUResourceBundle = null;
        iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance(string, uLocale2);
        if (blArray != null) {
            blArray[0] = false;
            object = ICUResourceBundle.getAvailEntry(string, classLoader).getULocaleList();
            for (int i = 0; i < ((ULocale[])object).length; ++i) {
                if (!uLocale2.equals(object[i])) continue;
                blArray[0] = true;
                break;
            }
        }
        do {
            try {
                object = (ULocale[])iCUResourceBundle.get(string2);
                string6 = ((ResourceBundle)object).getString(DEFAULT_TAG);
                if (bl2) {
                    string4 = string6;
                    bl2 = false;
                }
                uLocale3 = iCUResourceBundle.getULocale();
            }
            catch (MissingResourceException missingResourceException) {
                // empty catch block
            }
            if (uLocale3 != null) continue;
            iCUResourceBundle = (ICUResourceBundle)iCUResourceBundle.getParent();
            ++n;
        } while (iCUResourceBundle != null && uLocale3 == null);
        uLocale2 = new ULocale(string5);
        iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance(string, uLocale2);
        do {
            try {
                object = (ICUResourceBundle)iCUResourceBundle.get(string2);
                ((UResourceBundle)object).get(string4);
                uLocale4 = ((ICUResourceBundle)object).getULocale();
                if (uLocale4 != null && n2 > n) {
                    string6 = ((ResourceBundle)object).getString(DEFAULT_TAG);
                    uLocale3 = iCUResourceBundle.getULocale();
                    n = n2;
                }
            }
            catch (MissingResourceException missingResourceException) {
                // empty catch block
            }
            if (uLocale4 != null) continue;
            iCUResourceBundle = (ICUResourceBundle)iCUResourceBundle.getParent();
            ++n2;
        } while (iCUResourceBundle != null && uLocale4 == null);
        if (uLocale4 == null && string6 != null && !string6.equals(string4)) {
            string4 = string6;
            uLocale2 = new ULocale(string5);
            iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance(string, uLocale2);
            n2 = 0;
            do {
                try {
                    object = (ICUResourceBundle)iCUResourceBundle.get(string2);
                    UResourceBundle uResourceBundle = ((UResourceBundle)object).get(string4);
                    uLocale4 = iCUResourceBundle.getULocale();
                    if (!uLocale4.toString().equals(uResourceBundle.getLocale().toString())) {
                        uLocale4 = null;
                    }
                    if (uLocale4 != null && n2 > n) {
                        string6 = ((ResourceBundle)object).getString(DEFAULT_TAG);
                        uLocale3 = iCUResourceBundle.getULocale();
                        n = n2;
                    }
                }
                catch (MissingResourceException missingResourceException) {
                    // empty catch block
                }
                if (uLocale4 != null) continue;
                iCUResourceBundle = (ICUResourceBundle)iCUResourceBundle.getParent();
                ++n2;
            } while (iCUResourceBundle != null && uLocale4 == null);
        }
        if (uLocale4 == null) {
            throw new MissingResourceException("Could not find locale containing requested or default keyword.", string, string3 + "=" + string4);
        }
        if (bl && string6.equals(string4) && n2 <= n) {
            return uLocale4;
        }
        return new ULocale(uLocale4.toString() + "@" + string3 + "=" + string4);
    }

    public static final String[] getKeywordValues(String string, String string2) {
        HashSet<String> hashSet = new HashSet<String>();
        ULocale[] uLocaleArray = ICUResourceBundle.createULocaleList(string, ICU_DATA_CLASS_LOADER);
        for (int i = 0; i < uLocaleArray.length; ++i) {
            try {
                UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance(string, uLocaleArray[i]);
                ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)uResourceBundle.getObject(string2);
                Enumeration<String> enumeration = iCUResourceBundle.getKeys();
                while (enumeration.hasMoreElements()) {
                    String string3 = enumeration.nextElement();
                    if (DEFAULT_TAG.equals(string3)) continue;
                    hashSet.add(string3);
                }
                continue;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return hashSet.toArray(new String[0]);
    }

    public ICUResourceBundle getWithFallback(String string) throws MissingResourceException {
        ICUResourceBundle iCUResourceBundle = null;
        ICUResourceBundle iCUResourceBundle2 = this;
        iCUResourceBundle = ICUResourceBundle.findResourceWithFallback(string, iCUResourceBundle2, null);
        if (iCUResourceBundle == null) {
            throw new MissingResourceException("Can't find resource for bundle " + this.getClass().getName() + ", key " + this.getType(), string, this.getKey());
        }
        if (iCUResourceBundle.getType() == 0 && iCUResourceBundle.getString().equals(NO_INHERITANCE_MARKER)) {
            throw new MissingResourceException("Encountered NO_INHERITANCE_MARKER", string, this.getKey());
        }
        return iCUResourceBundle;
    }

    public ICUResourceBundle at(int n) {
        return (ICUResourceBundle)this.handleGet(n, null, (UResourceBundle)this);
    }

    public ICUResourceBundle at(String string) {
        if (this instanceof ICUResourceBundleImpl.ResourceTable) {
            return (ICUResourceBundle)this.handleGet(string, null, (UResourceBundle)this);
        }
        return null;
    }

    @Override
    public ICUResourceBundle findTopLevel(int n) {
        return (ICUResourceBundle)super.findTopLevel(n);
    }

    @Override
    public ICUResourceBundle findTopLevel(String string) {
        return (ICUResourceBundle)super.findTopLevel(string);
    }

    public ICUResourceBundle findWithFallback(String string) {
        return ICUResourceBundle.findResourceWithFallback(string, this, null);
    }

    public String getStringWithFallback(String string) throws MissingResourceException {
        return this.getWithFallback(string).getString();
    }

    public static Set<String> getAvailableLocaleNameSet(String string, ClassLoader classLoader) {
        return ICUResourceBundle.getAvailEntry(string, classLoader).getLocaleNameSet();
    }

    public static Set<String> getFullLocaleNameSet() {
        return ICUResourceBundle.getFullLocaleNameSet(ICU_BASE_NAME, ICU_DATA_CLASS_LOADER);
    }

    public static Set<String> getFullLocaleNameSet(String string, ClassLoader classLoader) {
        return ICUResourceBundle.getAvailEntry(string, classLoader).getFullLocaleNameSet();
    }

    public static Set<String> getAvailableLocaleNameSet() {
        return ICUResourceBundle.getAvailableLocaleNameSet(ICU_BASE_NAME, ICU_DATA_CLASS_LOADER);
    }

    public static final ULocale[] getAvailableULocales(String string, ClassLoader classLoader) {
        return ICUResourceBundle.getAvailEntry(string, classLoader).getULocaleList();
    }

    public static final ULocale[] getAvailableULocales() {
        return ICUResourceBundle.getAvailableULocales(ICU_BASE_NAME, ICU_DATA_CLASS_LOADER);
    }

    public static final Locale[] getAvailableLocales(String string, ClassLoader classLoader) {
        return ICUResourceBundle.getAvailEntry(string, classLoader).getLocaleList();
    }

    public static final Locale[] getAvailableLocales() {
        return ICUResourceBundle.getAvailEntry(ICU_BASE_NAME, ICU_DATA_CLASS_LOADER).getLocaleList();
    }

    public static final Locale[] getLocaleList(ULocale[] uLocaleArray) {
        ArrayList<Locale> arrayList = new ArrayList<Locale>(uLocaleArray.length);
        HashSet<Locale> hashSet = new HashSet<Locale>();
        for (int i = 0; i < uLocaleArray.length; ++i) {
            Locale locale = uLocaleArray[i].toLocale();
            if (hashSet.contains(locale)) continue;
            arrayList.add(locale);
            hashSet.add(locale);
        }
        return arrayList.toArray(new Locale[arrayList.size()]);
    }

    @Override
    public Locale getLocale() {
        return this.getULocale().toLocale();
    }

    private static final ULocale[] createULocaleList(String string, ClassLoader classLoader) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.instantiateBundle(string, ICU_RESOURCE_INDEX, classLoader, true);
        iCUResourceBundle = (ICUResourceBundle)iCUResourceBundle.get(INSTALLED_LOCALES);
        int n = iCUResourceBundle.getSize();
        int n2 = 0;
        ULocale[] uLocaleArray = new ULocale[n];
        UResourceBundleIterator uResourceBundleIterator = iCUResourceBundle.getIterator();
        uResourceBundleIterator.reset();
        while (uResourceBundleIterator.hasNext()) {
            String string2 = uResourceBundleIterator.next().getKey();
            if (string2.equals("root")) {
                uLocaleArray[n2++] = ULocale.ROOT;
                continue;
            }
            uLocaleArray[n2++] = new ULocale(string2);
        }
        iCUResourceBundle = null;
        return uLocaleArray;
    }

    private static final Locale[] createLocaleList(String string, ClassLoader classLoader) {
        ULocale[] uLocaleArray = ICUResourceBundle.getAvailEntry(string, classLoader).getULocaleList();
        return ICUResourceBundle.getLocaleList(uLocaleArray);
    }

    private static final String[] createLocaleNameArray(String string, ClassLoader classLoader) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.instantiateBundle(string, ICU_RESOURCE_INDEX, classLoader, true);
        iCUResourceBundle = (ICUResourceBundle)iCUResourceBundle.get(INSTALLED_LOCALES);
        int n = iCUResourceBundle.getSize();
        int n2 = 0;
        String[] stringArray = new String[n];
        UResourceBundleIterator uResourceBundleIterator = iCUResourceBundle.getIterator();
        uResourceBundleIterator.reset();
        while (uResourceBundleIterator.hasNext()) {
            String string2 = uResourceBundleIterator.next().getKey();
            if (string2.equals("root")) {
                stringArray[n2++] = ULocale.ROOT.toString();
                continue;
            }
            stringArray[n2++] = string2;
        }
        iCUResourceBundle = null;
        return stringArray;
    }

    private static final List<String> createFullLocaleNameArray(final String string, final ClassLoader classLoader) {
        List<String> list = AccessController.doPrivileged(new PrivilegedAction<List<String>>(){

            @Override
            public List<String> run() {
                Object object;
                Object object2;
                Object object3;
                String string3 = string.endsWith(ICUResourceBundle.RES_PATH_SEP_STR) ? string : string + ICUResourceBundle.RES_PATH_SEP_STR;
                ArrayList<Object> arrayList = null;
                String string2 = ICUConfig.get("com.ibm.icu.impl.ICUResourceBundle.skipRuntimeLocaleResourceScan", "false");
                if (!string2.equalsIgnoreCase("true")) {
                    try {
                        object3 = classLoader.getResources(string3);
                        while (object3.hasMoreElements()) {
                            object2 = object3.nextElement();
                            object = URLHandler.get((URL)object2);
                            if (object != null) {
                                final ArrayList arrayList2 = new ArrayList();
                                URLHandler.URLVisitor uRLVisitor = new URLHandler.URLVisitor(){

                                    public void visit(String string) {
                                        if (string.endsWith(".res")) {
                                            String string2 = string.substring(0, string.length() - 4);
                                            if (string2.contains("_") && !string2.equals(ICUResourceBundle.ICU_RESOURCE_INDEX)) {
                                                arrayList2.add(string2);
                                            } else if (string2.length() == 2 || string2.length() == 3) {
                                                arrayList2.add(string2);
                                            } else if (string2.equalsIgnoreCase("root")) {
                                                arrayList2.add(ULocale.ROOT.toString());
                                            }
                                        }
                                    }
                                };
                                ((URLHandler)object).guide(uRLVisitor, false);
                                if (arrayList == null) {
                                    arrayList = new ArrayList(arrayList2);
                                    continue;
                                }
                                arrayList.addAll(arrayList2);
                                continue;
                            }
                            if (!DEBUG) continue;
                            System.out.println("handler for " + object2 + " is null");
                        }
                    }
                    catch (IOException iOException) {
                        if (DEBUG) {
                            System.out.println("ouch: " + iOException.getMessage());
                        }
                        arrayList = null;
                    }
                }
                if (arrayList == null) {
                    try {
                        object3 = classLoader.getResourceAsStream(string3 + ICUResourceBundle.FULL_LOCALE_NAMES_LIST);
                        if (object3 != null) {
                            arrayList = new ArrayList<Object>();
                            object2 = new BufferedReader(new InputStreamReader((InputStream)object3, "ASCII"));
                            while ((object = ((BufferedReader)object2).readLine()) != null) {
                                if (((String)object).length() == 0 || ((String)object).startsWith("#")) continue;
                                if (((String)object).equalsIgnoreCase("root")) {
                                    arrayList.add(ULocale.ROOT.toString());
                                    continue;
                                }
                                arrayList.add(object);
                            }
                            ((BufferedReader)object2).close();
                        }
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                return arrayList;
            }
        });
        return list;
    }

    private static Set<String> createFullLocaleNameSet(String string, ClassLoader classLoader) {
        List<String> list = ICUResourceBundle.createFullLocaleNameArray(string, classLoader);
        if (list == null) {
            String string2;
            Set<String> set;
            if (DEBUG) {
                System.out.println("createFullLocaleNameArray returned null");
            }
            if (!(set = ICUResourceBundle.createLocaleNameSet(string, classLoader)).contains(string2 = ULocale.ROOT.toString())) {
                HashSet<String> hashSet = new HashSet<String>(set);
                hashSet.add(string2);
                set = Collections.unmodifiableSet(hashSet);
            }
            return set;
        }
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.addAll(list);
        return Collections.unmodifiableSet(hashSet);
    }

    private static Set<String> createLocaleNameSet(String string, ClassLoader classLoader) {
        try {
            String[] stringArray = ICUResourceBundle.createLocaleNameArray(string, classLoader);
            HashSet<String> hashSet = new HashSet<String>();
            hashSet.addAll(Arrays.asList(stringArray));
            return Collections.unmodifiableSet(hashSet);
        }
        catch (MissingResourceException missingResourceException) {
            if (DEBUG) {
                System.out.println("couldn't find index for bundleName: " + string);
                Thread.dumpStack();
            }
            return Collections.emptySet();
        }
    }

    private static AvailEntry getAvailEntry(String string, ClassLoader classLoader) {
        return GET_AVAILABLE_CACHE.getInstance(string, classLoader);
    }

    protected static final ICUResourceBundle findResourceWithFallback(String string, UResourceBundle uResourceBundle, UResourceBundle uResourceBundle2) {
        String string2;
        ICUResourceBundle iCUResourceBundle = null;
        if (uResourceBundle2 == null) {
            uResourceBundle2 = uResourceBundle;
        }
        String string3 = string2 = ((ICUResourceBundle)uResourceBundle).resPath.length() > 0 ? ((ICUResourceBundle)uResourceBundle).resPath : "";
        for (ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle)uResourceBundle; iCUResourceBundle2 != null; iCUResourceBundle2 = (ICUResourceBundle)iCUResourceBundle2.getParent()) {
            if (string.indexOf(47) == -1) {
                iCUResourceBundle = (ICUResourceBundle)iCUResourceBundle2.handleGet(string, null, uResourceBundle2);
                if (iCUResourceBundle != null) {
                    break;
                }
            } else {
                String string4;
                ICUResourceBundle iCUResourceBundle3 = iCUResourceBundle2;
                StringTokenizer stringTokenizer = new StringTokenizer(string, RES_PATH_SEP_STR);
                while (stringTokenizer.hasMoreTokens() && (iCUResourceBundle = ICUResourceBundle.findResourceWithFallback(string4 = stringTokenizer.nextToken(), iCUResourceBundle3, uResourceBundle2)) != null) {
                    iCUResourceBundle3 = iCUResourceBundle;
                }
                if (iCUResourceBundle != null) break;
            }
            string = string2.length() > 0 ? string2 + RES_PATH_SEP_STR + string : string;
            string2 = "";
        }
        if (iCUResourceBundle != null) {
            iCUResourceBundle.setLoadingStatus(((ICUResourceBundle)uResourceBundle2).getLocaleID());
        }
        return iCUResourceBundle;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ICUResourceBundle) {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)object;
            if (this.getBaseName().equals(iCUResourceBundle.getBaseName()) && this.getLocaleID().equals(iCUResourceBundle.getLocaleID())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    public static UResourceBundle getBundleInstance(String string, String string2, ClassLoader classLoader, boolean bl) {
        UResourceBundle uResourceBundle = ICUResourceBundle.instantiateBundle(string, string2, classLoader, bl);
        if (uResourceBundle == null) {
            throw new MissingResourceException("Could not find the bundle " + string + RES_PATH_SEP_STR + string2 + ".res", "", "");
        }
        return uResourceBundle;
    }

    protected static synchronized UResourceBundle instantiateBundle(String string, String string2, ClassLoader classLoader, boolean bl) {
        ULocale uLocale = ULocale.getDefault();
        String string3 = string2;
        if (string3.indexOf(64) >= 0) {
            string3 = ULocale.getBaseName(string2);
        }
        String string4 = ICUResourceBundleReader.getFullName(string, string3);
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)ICUResourceBundle.loadFromCache(classLoader, string4, uLocale);
        String string5 = string.indexOf(46) == -1 ? "root" : "";
        String string6 = uLocale.getBaseName();
        if (string3.equals("")) {
            string3 = string5;
        }
        if (DEBUG) {
            System.out.println("Creating " + string4 + " currently b is " + iCUResourceBundle);
        }
        if (iCUResourceBundle == null) {
            iCUResourceBundle = ICUResourceBundle.createBundle(string, string3, classLoader);
            if (DEBUG) {
                System.out.println("The bundle created is: " + iCUResourceBundle + " and disableFallback=" + bl + " and bundle.getNoFallback=" + (iCUResourceBundle != null && iCUResourceBundle.getNoFallback()));
            }
            if (bl || iCUResourceBundle != null && iCUResourceBundle.getNoFallback()) {
                return ICUResourceBundle.addToCache(classLoader, string4, uLocale, iCUResourceBundle);
            }
            if (iCUResourceBundle == null) {
                int n = string3.lastIndexOf(95);
                if (n != -1) {
                    String string7 = string3.substring(0, n);
                    iCUResourceBundle = (ICUResourceBundle)ICUResourceBundle.instantiateBundle(string, string7, classLoader, bl);
                    if (iCUResourceBundle != null && iCUResourceBundle.getULocale().getName().equals(string7)) {
                        iCUResourceBundle.setLoadingStatus(1);
                    }
                } else if (string6.indexOf(string3) == -1) {
                    iCUResourceBundle = (ICUResourceBundle)ICUResourceBundle.instantiateBundle(string, string6, classLoader, bl);
                    if (iCUResourceBundle != null) {
                        iCUResourceBundle.setLoadingStatus(3);
                    }
                } else if (string5.length() != 0 && (iCUResourceBundle = ICUResourceBundle.createBundle(string, string5, classLoader)) != null) {
                    iCUResourceBundle.setLoadingStatus(2);
                }
            } else {
                UResourceBundle uResourceBundle = null;
                string3 = iCUResourceBundle.getLocaleID();
                int n = string3.lastIndexOf(95);
                if ((iCUResourceBundle = (ICUResourceBundle)ICUResourceBundle.addToCache(classLoader, string4, uLocale, iCUResourceBundle)).getTableResource("%%Parent") != -1) {
                    String string8 = iCUResourceBundle.getString("%%Parent");
                    uResourceBundle = ICUResourceBundle.instantiateBundle(string, string8, classLoader, bl);
                } else if (n != -1) {
                    uResourceBundle = ICUResourceBundle.instantiateBundle(string, string3.substring(0, n), classLoader, bl);
                } else if (!string3.equals(string5)) {
                    uResourceBundle = ICUResourceBundle.instantiateBundle(string, string5, classLoader, true);
                }
                if (!iCUResourceBundle.equals(uResourceBundle)) {
                    iCUResourceBundle.setParent(uResourceBundle);
                }
            }
        }
        return iCUResourceBundle;
    }

    UResourceBundle get(String string, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)this.handleGet(string, hashMap, uResourceBundle);
        if (iCUResourceBundle == null) {
            iCUResourceBundle = (ICUResourceBundle)this.getParent();
            if (iCUResourceBundle != null) {
                iCUResourceBundle = (ICUResourceBundle)iCUResourceBundle.get(string, hashMap, uResourceBundle);
            }
            if (iCUResourceBundle == null) {
                String string2 = ICUResourceBundleReader.getFullName(this.getBaseName(), this.getLocaleID());
                throw new MissingResourceException("Can't find resource for bundle " + string2 + ", key " + string, this.getClass().getName(), string);
            }
        }
        iCUResourceBundle.setLoadingStatus(((ICUResourceBundle)uResourceBundle).getLocaleID());
        return iCUResourceBundle;
    }

    public static ICUResourceBundle createBundle(String string, String string2, ClassLoader classLoader) {
        ICUResourceBundleReader iCUResourceBundleReader = ICUResourceBundleReader.getReader(string, string2, classLoader);
        if (iCUResourceBundleReader == null) {
            return null;
        }
        return ICUResourceBundle.getBundle(iCUResourceBundleReader, string, string2, classLoader);
    }

    @Override
    protected String getLocaleID() {
        return this.localeID;
    }

    @Override
    protected String getBaseName() {
        return this.baseName;
    }

    @Override
    public ULocale getULocale() {
        return this.ulocale;
    }

    @Override
    public UResourceBundle getParent() {
        return (UResourceBundle)this.parent;
    }

    @Override
    protected void setParent(ResourceBundle resourceBundle) {
        this.parent = resourceBundle;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int getType() {
        return gPublicTypes[ICUResourceBundleReader.RES_GET_TYPE(this.resource)];
    }

    private boolean getNoFallback() {
        return this.reader.getNoFallback();
    }

    private static ICUResourceBundle getBundle(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, ClassLoader classLoader) {
        int n = iCUResourceBundleReader.getRootResource();
        if (gPublicTypes[ICUResourceBundleReader.RES_GET_TYPE(n)] != 2) {
            throw new IllegalStateException("Invalid format error");
        }
        ICUResourceBundleImpl.ResourceTable resourceTable = new ICUResourceBundleImpl.ResourceTable(iCUResourceBundleReader, null, "", n, null);
        resourceTable.baseName = string;
        resourceTable.localeID = string2;
        resourceTable.ulocale = new ULocale(string2);
        resourceTable.loader = classLoader;
        UResourceBundle uResourceBundle = ((ICUResourceBundle)resourceTable).handleGetImpl("%%ALIAS", null, resourceTable, null, null);
        if (uResourceBundle != null) {
            return (ICUResourceBundle)UResourceBundle.getBundleInstance(string, uResourceBundle.getString());
        }
        return resourceTable;
    }

    protected ICUResourceBundle(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundle iCUResourceBundle) {
        this.reader = iCUResourceBundleReader;
        this.key = string;
        this.resPath = string2;
        this.resource = n;
        if (iCUResourceBundle != null) {
            this.baseName = iCUResourceBundle.baseName;
            this.localeID = iCUResourceBundle.localeID;
            this.ulocale = iCUResourceBundle.ulocale;
            this.loader = iCUResourceBundle.loader;
            this.parent = iCUResourceBundle.parent;
        }
    }

    private String getAliasValue(int n) {
        String string = this.reader.getAlias(n);
        return string != null ? string : "";
    }

    protected ICUResourceBundle findResource(String string, String string2, int n, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        String string3;
        int n2;
        ClassLoader classLoader = this.loader;
        String string4 = null;
        String string5 = null;
        String string6 = this.getAliasValue(n);
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        if (hashMap.get(string6) != null) {
            throw new IllegalArgumentException("Circular references in the resource bundles");
        }
        hashMap.put(string6, "");
        if (string6.indexOf(47) == 0) {
            int n3;
            n2 = string6.indexOf(47, 1);
            int n4 = string6.indexOf(47, n2 + 1);
            string3 = string6.substring(1, n2);
            if (n4 < 0) {
                string4 = string6.substring(n2 + 1);
                string5 = string2;
            } else {
                string4 = string6.substring(n2 + 1, n4);
                string5 = string6.substring(n4 + 1, string6.length());
            }
            if (string3.equals(ICUDATA)) {
                string3 = ICU_BASE_NAME;
                classLoader = ICU_DATA_CLASS_LOADER;
            } else if (string3.indexOf(ICUDATA) > -1 && (n3 = string3.indexOf(45)) > -1) {
                string3 = "com/ibm/icu/impl/data/icudt51b/" + string3.substring(n3 + 1, string3.length());
                classLoader = ICU_DATA_CLASS_LOADER;
            }
        } else {
            n2 = string6.indexOf(47);
            if (n2 != -1) {
                string4 = string6.substring(0, n2);
                string5 = string6.substring(n2 + 1);
            } else {
                string4 = string6;
                string5 = string2;
            }
            string3 = this.baseName;
        }
        ICUResourceBundle iCUResourceBundle = null;
        ICUResourceBundle iCUResourceBundle2 = null;
        if (string3.equals(LOCALE)) {
            string3 = this.baseName;
            string5 = string6.substring(LOCALE.length() + 2, string6.length());
            string4 = ((ICUResourceBundle)uResourceBundle).getLocaleID();
            iCUResourceBundle = (ICUResourceBundle)ICUResourceBundle.getBundleInstance(string3, string4, classLoader, false);
            if (iCUResourceBundle != null) {
                iCUResourceBundle2 = ICUResourceBundle.findResourceWithFallback(string5, iCUResourceBundle, null);
            }
        } else {
            String string7;
            iCUResourceBundle = string4 == null ? (ICUResourceBundle)ICUResourceBundle.getBundleInstance(string3, "", classLoader, false) : (ICUResourceBundle)ICUResourceBundle.getBundleInstance(string3, string4, classLoader, false);
            StringTokenizer stringTokenizer = new StringTokenizer(string5, RES_PATH_SEP_STR);
            ICUResourceBundle iCUResourceBundle3 = iCUResourceBundle;
            while (stringTokenizer.hasMoreTokens() && (iCUResourceBundle2 = (ICUResourceBundle)iCUResourceBundle3.get(string7 = stringTokenizer.nextToken(), hashMap, uResourceBundle)) != null) {
                iCUResourceBundle3 = iCUResourceBundle2;
            }
        }
        if (iCUResourceBundle2 == null) {
            throw new MissingResourceException(this.localeID, this.baseName, string);
        }
        return iCUResourceBundle2;
    }

    protected void createLookupCache() {
        this.lookup = new SimpleCache<Object, UResourceBundle>(1, Math.max(this.getSize() * 2, 64));
    }

    @Override
    protected UResourceBundle handleGet(String string, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        boolean[] blArray;
        int[] nArray;
        UResourceBundle uResourceBundle2 = null;
        if (this.lookup != null) {
            uResourceBundle2 = this.lookup.get(string);
        }
        if (uResourceBundle2 == null && (uResourceBundle2 = this.handleGetImpl(string, hashMap, uResourceBundle, nArray = new int[1], blArray = new boolean[1])) != null && this.lookup != null && !blArray[0]) {
            this.lookup.put(string, uResourceBundle2);
            this.lookup.put(nArray[0], uResourceBundle2);
        }
        return uResourceBundle2;
    }

    @Override
    protected UResourceBundle handleGet(int n, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        boolean[] blArray;
        UResourceBundle uResourceBundle2 = null;
        Integer n2 = null;
        if (this.lookup != null) {
            n2 = n;
            uResourceBundle2 = this.lookup.get(n2);
        }
        if (uResourceBundle2 == null && (uResourceBundle2 = this.handleGetImpl(n, hashMap, uResourceBundle, blArray = new boolean[1])) != null && this.lookup != null && !blArray[0]) {
            this.lookup.put(uResourceBundle2.getKey(), uResourceBundle2);
            this.lookup.put(n2, uResourceBundle2);
        }
        return uResourceBundle2;
    }

    protected UResourceBundle handleGetImpl(String string, HashMap<String, String> hashMap, UResourceBundle uResourceBundle, int[] nArray, boolean[] blArray) {
        return null;
    }

    protected UResourceBundle handleGetImpl(int n, HashMap<String, String> hashMap, UResourceBundle uResourceBundle, boolean[] blArray) {
        return null;
    }

    protected int getTableResource(String string) {
        return -1;
    }

    protected int getTableResource(int n) {
        return -1;
    }

    public boolean isAlias(int n) {
        return ICUResourceBundleReader.RES_GET_TYPE(this.getTableResource(n)) == 3;
    }

    public boolean isAlias() {
        return ICUResourceBundleReader.RES_GET_TYPE(this.resource) == 3;
    }

    public boolean isAlias(String string) {
        return ICUResourceBundleReader.RES_GET_TYPE(this.getTableResource(string)) == 3;
    }

    public String getAliasPath(int n) {
        return this.getAliasValue(this.getTableResource(n));
    }

    public String getAliasPath() {
        return this.getAliasValue(this.resource);
    }

    public String getAliasPath(String string) {
        return this.getAliasValue(this.getTableResource(string));
    }

    protected String getKey(int n) {
        return null;
    }

    public Enumeration<String> getKeysSafe() {
        if (!ICUResourceBundleReader.URES_IS_TABLE(this.resource)) {
            return this.getKeys();
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = this.getSize();
        for (int i = 0; i < n; ++i) {
            String string = this.getKey(i);
            arrayList.add(string);
        }
        return Collections.enumeration(arrayList);
    }

    @Override
    protected Enumeration<String> handleGetKeys() {
        return Collections.enumeration(this.handleKeySet());
    }

    @Override
    protected boolean isTopLevelResource() {
        return this.resPath.length() == 0;
    }

    static {
        ClassLoader classLoader = ICUData.class.getClassLoader();
        if (classLoader == null) {
            classLoader = Utility.getFallbackClassLoader();
        }
        ICU_DATA_CLASS_LOADER = classLoader;
        DEBUG = ICUDebug.enabled("localedata");
        GET_AVAILABLE_CACHE = new SoftCache<String, AvailEntry, ClassLoader>(){

            @Override
            protected AvailEntry createInstance(String string, ClassLoader classLoader) {
                return new AvailEntry(string, classLoader);
            }
        };
        gPublicTypes = new int[]{0, 1, 2, 3, 2, 2, 0, 7, 8, 8, -1, -1, -1, -1, 14, -1};
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static final class AvailEntry {
        private String prefix;
        private ClassLoader loader;
        private volatile ULocale[] ulocales;
        private volatile Locale[] locales;
        private volatile Set<String> nameSet;
        private volatile Set<String> fullNameSet;

        AvailEntry(String string, ClassLoader classLoader) {
            this.prefix = string;
            this.loader = classLoader;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        ULocale[] getULocaleList() {
            if (this.ulocales == null) {
                AvailEntry availEntry = this;
                synchronized (availEntry) {
                    if (this.ulocales == null) {
                        this.ulocales = ICUResourceBundle.createULocaleList(this.prefix, this.loader);
                    }
                }
            }
            return this.ulocales;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Locale[] getLocaleList() {
            if (this.locales == null) {
                AvailEntry availEntry = this;
                synchronized (availEntry) {
                    if (this.locales == null) {
                        this.locales = ICUResourceBundle.createLocaleList(this.prefix, this.loader);
                    }
                }
            }
            return this.locales;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Set<String> getLocaleNameSet() {
            if (this.nameSet == null) {
                AvailEntry availEntry = this;
                synchronized (availEntry) {
                    if (this.nameSet == null) {
                        this.nameSet = ICUResourceBundle.createLocaleNameSet(this.prefix, this.loader);
                    }
                }
            }
            return this.nameSet;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Set<String> getFullLocaleNameSet() {
            if (this.fullNameSet == null) {
                AvailEntry availEntry = this;
                synchronized (availEntry) {
                    if (this.fullNameSet == null) {
                        this.fullNameSet = ICUResourceBundle.createFullLocaleNameSet(this.prefix, this.loader);
                    }
                }
            }
            return this.fullNameSet;
        }
    }
}

