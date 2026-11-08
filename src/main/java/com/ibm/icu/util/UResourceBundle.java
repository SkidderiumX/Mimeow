/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUResourceBundleReader;
import com.ibm.icu.impl.ResourceBundleWrapper;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundleIterator;
import com.ibm.icu.util.UResourceTypeMismatchException;
import com.ibm.icu.util.VersionInfo;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class UResourceBundle
extends ResourceBundle {
    private static ICUCache<ResourceCacheKey, UResourceBundle> BUNDLE_CACHE = new SimpleCache<ResourceCacheKey, UResourceBundle>();
    private static final ResourceCacheKey cacheKey = new ResourceCacheKey();
    private static final int ROOT_MISSING = 0;
    private static final int ROOT_ICU = 1;
    private static final int ROOT_JAVA = 2;
    private static SoftReference<ConcurrentHashMap<String, Integer>> ROOT_CACHE = new SoftReference(new ConcurrentHashMap());
    private Set<String> keys = null;
    public static final int NONE = -1;
    public static final int STRING = 0;
    public static final int BINARY = 1;
    public static final int TABLE = 2;
    public static final int INT = 7;
    public static final int ARRAY = 8;
    public static final int INT_VECTOR = 14;

    public static UResourceBundle getBundleInstance(String string, String string2) {
        return UResourceBundle.getBundleInstance(string, string2, ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String string, String string2, ClassLoader classLoader) {
        return UResourceBundle.getBundleInstance(string, string2, classLoader, false);
    }

    protected static UResourceBundle getBundleInstance(String string, String string2, ClassLoader classLoader, boolean bl) {
        return UResourceBundle.instantiateBundle(string, string2, classLoader, bl);
    }

    public static UResourceBundle getBundleInstance(ULocale uLocale) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale.toString(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String string) {
        if (string == null) {
            string = "com/ibm/icu/impl/data/icudt51b";
        }
        ULocale uLocale = ULocale.getDefault();
        return UResourceBundle.getBundleInstance(string, uLocale.toString(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String string, Locale locale) {
        if (string == null) {
            string = "com/ibm/icu/impl/data/icudt51b";
        }
        ULocale uLocale = locale == null ? ULocale.getDefault() : ULocale.forLocale(locale);
        return UResourceBundle.getBundleInstance(string, uLocale.toString(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String string, ULocale uLocale) {
        if (string == null) {
            string = "com/ibm/icu/impl/data/icudt51b";
        }
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return UResourceBundle.getBundleInstance(string, uLocale.toString(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String string, Locale locale, ClassLoader classLoader) {
        if (string == null) {
            string = "com/ibm/icu/impl/data/icudt51b";
        }
        ULocale uLocale = locale == null ? ULocale.getDefault() : ULocale.forLocale(locale);
        return UResourceBundle.getBundleInstance(string, uLocale.toString(), classLoader, false);
    }

    public static UResourceBundle getBundleInstance(String string, ULocale uLocale, ClassLoader classLoader) {
        if (string == null) {
            string = "com/ibm/icu/impl/data/icudt51b";
        }
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return UResourceBundle.getBundleInstance(string, uLocale.toString(), classLoader, false);
    }

    public abstract ULocale getULocale();

    protected abstract String getLocaleID();

    protected abstract String getBaseName();

    protected abstract UResourceBundle getParent();

    @Override
    public Locale getLocale() {
        return this.getULocale().toLocale();
    }

    public static void resetBundleCache() {
        BUNDLE_CACHE = new SimpleCache<ResourceCacheKey, UResourceBundle>();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected static UResourceBundle addToCache(ClassLoader classLoader, String string, ULocale uLocale, UResourceBundle uResourceBundle) {
        ResourceCacheKey resourceCacheKey = cacheKey;
        synchronized (resourceCacheKey) {
            UResourceBundle.cacheKey.setKeyValues(classLoader, string, uLocale);
            UResourceBundle uResourceBundle2 = BUNDLE_CACHE.get(cacheKey);
            if (uResourceBundle2 != null) {
                return uResourceBundle2;
            }
            BUNDLE_CACHE.put((ResourceCacheKey)cacheKey.clone(), uResourceBundle);
            return uResourceBundle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected static UResourceBundle loadFromCache(ClassLoader classLoader, String string, ULocale uLocale) {
        ResourceCacheKey resourceCacheKey = cacheKey;
        synchronized (resourceCacheKey) {
            UResourceBundle.cacheKey.setKeyValues(classLoader, string, uLocale);
            return BUNDLE_CACHE.get(cacheKey);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static int getRootType(String string, ClassLoader classLoader) {
        Integer n;
        Object object;
        ConcurrentHashMap<String, Integer> concurrentHashMap = null;
        concurrentHashMap = ROOT_CACHE.get();
        if (concurrentHashMap == null) {
            object = UResourceBundle.class;
            // MONITORENTER : com.ibm.icu.util.UResourceBundle.class
            concurrentHashMap = ROOT_CACHE.get();
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap();
                ROOT_CACHE = new SoftReference<ConcurrentHashMap<String, Integer>>(concurrentHashMap);
            }
            // MONITOREXIT : object
        }
        if ((n = concurrentHashMap.get(string)) != null) return n;
        object = string.indexOf(46) == -1 ? "root" : "";
        int n2 = 0;
        try {
            ICUResourceBundle.getBundleInstance(string, (String)object, classLoader, true);
            n2 = 1;
        }
        catch (MissingResourceException missingResourceException) {
            try {
                ResourceBundleWrapper.getBundleInstance(string, (String)object, classLoader, true);
                n2 = 2;
            }
            catch (MissingResourceException missingResourceException2) {
                // empty catch block
            }
        }
        n = n2;
        concurrentHashMap.putIfAbsent(string, n);
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static void setRootType(String string, int n) {
        Integer n2 = n;
        ConcurrentHashMap<String, Integer> concurrentHashMap = null;
        concurrentHashMap = ROOT_CACHE.get();
        if (concurrentHashMap == null) {
            Class<UResourceBundle> clazz = UResourceBundle.class;
            // MONITORENTER : com.ibm.icu.util.UResourceBundle.class
            concurrentHashMap = ROOT_CACHE.get();
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap();
                ROOT_CACHE = new SoftReference<ConcurrentHashMap<String, Integer>>(concurrentHashMap);
            }
            // MONITOREXIT : clazz
        }
        concurrentHashMap.put(string, n2);
    }

    protected static UResourceBundle instantiateBundle(String string, String string2, ClassLoader classLoader, boolean bl) {
        UResourceBundle uResourceBundle = null;
        int n = UResourceBundle.getRootType(string, classLoader);
        ULocale uLocale = ULocale.getDefault();
        switch (n) {
            case 1: {
                if (bl) {
                    String string3 = ICUResourceBundleReader.getFullName(string, string2);
                    uResourceBundle = UResourceBundle.loadFromCache(classLoader, string3, uLocale);
                    if (uResourceBundle == null) {
                        uResourceBundle = ICUResourceBundle.getBundleInstance(string, string2, classLoader, bl);
                    }
                } else {
                    uResourceBundle = ICUResourceBundle.getBundleInstance(string, string2, classLoader, bl);
                }
                return uResourceBundle;
            }
            case 2: {
                return ResourceBundleWrapper.getBundleInstance(string, string2, classLoader, bl);
            }
        }
        try {
            uResourceBundle = ICUResourceBundle.getBundleInstance(string, string2, classLoader, bl);
            UResourceBundle.setRootType(string, 1);
        }
        catch (MissingResourceException missingResourceException) {
            uResourceBundle = ResourceBundleWrapper.getBundleInstance(string, string2, classLoader, bl);
            UResourceBundle.setRootType(string, 2);
        }
        return uResourceBundle;
    }

    public ByteBuffer getBinary() {
        throw new UResourceTypeMismatchException("");
    }

    public String getString() {
        throw new UResourceTypeMismatchException("");
    }

    public String[] getStringArray() {
        throw new UResourceTypeMismatchException("");
    }

    public byte[] getBinary(byte[] byArray) {
        throw new UResourceTypeMismatchException("");
    }

    public int[] getIntVector() {
        throw new UResourceTypeMismatchException("");
    }

    public int getInt() {
        throw new UResourceTypeMismatchException("");
    }

    public int getUInt() {
        throw new UResourceTypeMismatchException("");
    }

    public UResourceBundle get(String string) {
        UResourceBundle uResourceBundle = this.findTopLevel(string);
        if (uResourceBundle == null) {
            String string2 = ICUResourceBundleReader.getFullName(this.getBaseName(), this.getLocaleID());
            throw new MissingResourceException("Can't find resource for bundle " + string2 + ", key " + string, this.getClass().getName(), string);
        }
        return uResourceBundle;
    }

    protected UResourceBundle findTopLevel(String string) {
        for (UResourceBundle uResourceBundle = this; uResourceBundle != null; uResourceBundle = uResourceBundle.getParent()) {
            UResourceBundle uResourceBundle2 = uResourceBundle.handleGet(string, null, this);
            if (uResourceBundle2 == null) continue;
            ((ICUResourceBundle)uResourceBundle2).setLoadingStatus(this.getLocaleID());
            return uResourceBundle2;
        }
        return null;
    }

    public String getString(int n) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)this.get(n);
        if (iCUResourceBundle.getType() == 0) {
            return iCUResourceBundle.getString();
        }
        throw new UResourceTypeMismatchException("");
    }

    public UResourceBundle get(int n) {
        UResourceBundle uResourceBundle = this.handleGet(n, null, this);
        if (uResourceBundle == null) {
            uResourceBundle = (ICUResourceBundle)this.getParent();
            if (uResourceBundle != null) {
                uResourceBundle = uResourceBundle.get(n);
            }
            if (uResourceBundle == null) {
                throw new MissingResourceException("Can't find resource for bundle " + this.getClass().getName() + ", key " + this.getKey(), this.getClass().getName(), this.getKey());
            }
        }
        ((ICUResourceBundle)uResourceBundle).setLoadingStatus(this.getLocaleID());
        return uResourceBundle;
    }

    protected UResourceBundle findTopLevel(int n) {
        for (UResourceBundle uResourceBundle = this; uResourceBundle != null; uResourceBundle = uResourceBundle.getParent()) {
            UResourceBundle uResourceBundle2 = uResourceBundle.handleGet(n, null, this);
            if (uResourceBundle2 == null) continue;
            ((ICUResourceBundle)uResourceBundle2).setLoadingStatus(this.getLocaleID());
            return uResourceBundle2;
        }
        return null;
    }

    @Override
    public Enumeration<String> getKeys() {
        return Collections.enumeration(this.keySet());
    }

    @Override
    public Set<String> keySet() {
        if (this.keys == null) {
            if (this.isTopLevelResource()) {
                TreeSet<Object> treeSet;
                if (this.parent == null) {
                    treeSet = new TreeSet<String>();
                } else if (this.parent instanceof UResourceBundle) {
                    treeSet = new TreeSet<String>(((UResourceBundle)this.parent).keySet());
                } else {
                    treeSet = new TreeSet();
                    Enumeration<String> enumeration = this.parent.getKeys();
                    while (enumeration.hasMoreElements()) {
                        treeSet.add(enumeration.nextElement());
                    }
                }
                treeSet.addAll(this.handleKeySet());
                this.keys = Collections.unmodifiableSet(treeSet);
            } else {
                return this.handleKeySet();
            }
        }
        return this.keys;
    }

    @Override
    protected Set<String> handleKeySet() {
        return Collections.emptySet();
    }

    public int getSize() {
        return 1;
    }

    public int getType() {
        return -1;
    }

    public VersionInfo getVersion() {
        return null;
    }

    public UResourceBundleIterator getIterator() {
        return new UResourceBundleIterator(this);
    }

    public String getKey() {
        return null;
    }

    protected UResourceBundle handleGet(String string, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        return null;
    }

    protected UResourceBundle handleGet(int n, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        return null;
    }

    protected String[] handleGetStringArray() {
        return null;
    }

    protected Enumeration<String> handleGetKeys() {
        return null;
    }

    @Override
    protected Object handleGetObject(String string) {
        return this.handleGetObjectImpl(string, this);
    }

    private Object handleGetObjectImpl(String string, UResourceBundle uResourceBundle) {
        Object object = this.resolveObject(string, uResourceBundle);
        if (object == null) {
            UResourceBundle uResourceBundle2 = this.getParent();
            if (uResourceBundle2 != null) {
                object = uResourceBundle2.handleGetObjectImpl(string, uResourceBundle);
            }
            if (object == null) {
                throw new MissingResourceException("Can't find resource for bundle " + this.getClass().getName() + ", key " + string, this.getClass().getName(), string);
            }
        }
        return object;
    }

    private Object resolveObject(String string, UResourceBundle uResourceBundle) {
        if (this.getType() == 0) {
            return this.getString();
        }
        UResourceBundle uResourceBundle2 = this.handleGet(string, null, uResourceBundle);
        if (uResourceBundle2 != null) {
            if (uResourceBundle2.getType() == 0) {
                return uResourceBundle2.getString();
            }
            try {
                if (uResourceBundle2.getType() == 8) {
                    return uResourceBundle2.handleGetStringArray();
                }
            }
            catch (UResourceTypeMismatchException uResourceTypeMismatchException) {
                return uResourceBundle2;
            }
        }
        return uResourceBundle2;
    }

    protected abstract void setLoadingStatus(int var1);

    protected boolean isTopLevelResource() {
        return true;
    }

    private static final class ResourceCacheKey
    implements Cloneable {
        private SoftReference<ClassLoader> loaderRef;
        private String searchName;
        private ULocale defaultLocale;
        private int hashCodeCache;

        private ResourceCacheKey() {
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (this == object) {
                return true;
            }
            try {
                ResourceCacheKey resourceCacheKey = (ResourceCacheKey)object;
                if (this.hashCodeCache != resourceCacheKey.hashCodeCache) {
                    return false;
                }
                if (!this.searchName.equals(resourceCacheKey.searchName)) {
                    return false;
                }
                if (this.defaultLocale == null ? resourceCacheKey.defaultLocale != null : !this.defaultLocale.equals(resourceCacheKey.defaultLocale)) {
                    return false;
                }
                if (this.loaderRef == null) {
                    return resourceCacheKey.loaderRef == null;
                }
                return resourceCacheKey.loaderRef != null && this.loaderRef.get() == resourceCacheKey.loaderRef.get();
            }
            catch (NullPointerException nullPointerException) {
                return false;
            }
            catch (ClassCastException classCastException) {
                return false;
            }
        }

        public int hashCode() {
            return this.hashCodeCache;
        }

        public Object clone() {
            try {
                return super.clone();
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                throw new IllegalStateException();
            }
        }

        private synchronized void setKeyValues(ClassLoader classLoader, String string, ULocale uLocale) {
            this.searchName = string;
            this.hashCodeCache = string.hashCode();
            this.defaultLocale = uLocale;
            if (uLocale != null) {
                this.hashCodeCache ^= uLocale.hashCode();
            }
            if (classLoader == null) {
                this.loaderRef = null;
            } else {
                this.loaderRef = new SoftReference<ClassLoader>(classLoader);
                this.hashCodeCache ^= classLoader.hashCode();
            }
        }
    }
}

