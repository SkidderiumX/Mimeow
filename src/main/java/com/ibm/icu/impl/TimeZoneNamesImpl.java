/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.Grego;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.impl.ZoneMeta;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TimeZoneNamesImpl
extends TimeZoneNames {
    private static final long serialVersionUID = -2179814848495897472L;
    private static final String ZONE_STRINGS_BUNDLE = "zoneStrings";
    private static final String MZ_PREFIX = "meta:";
    private static Set<String> METAZONE_IDS;
    private static final TZ2MZsCache TZ_TO_MZS_CACHE;
    private static final MZ2TZsCache MZ_TO_TZS_CACHE;
    private transient ICUResourceBundle _zoneStrings;
    private transient ConcurrentHashMap<String, ZNames> _mzNamesMap;
    private transient ConcurrentHashMap<String, TZNames> _tzNamesMap;
    private transient TextTrieMap<NameInfo> _namesTrie;
    private transient boolean _namesTrieFullyLoaded;
    private static final Pattern LOC_EXCLUSION_PATTERN;

    public TimeZoneNamesImpl(ULocale uLocale) {
        this.initialize(uLocale);
    }

    @Override
    public synchronized Set<String> getAvailableMetaZoneIDs() {
        if (METAZONE_IDS == null) {
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "metaZones");
            UResourceBundle uResourceBundle2 = uResourceBundle.get("mapTimezones");
            Set<String> set = uResourceBundle2.keySet();
            METAZONE_IDS = Collections.unmodifiableSet(set);
        }
        return METAZONE_IDS;
    }

    @Override
    public Set<String> getAvailableMetaZoneIDs(String string) {
        if (string == null || string.length() == 0) {
            return Collections.emptySet();
        }
        List list = (List)TZ_TO_MZS_CACHE.getInstance(string, string);
        if (list.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet<String> hashSet = new HashSet<String>(list.size());
        for (MZMapEntry mZMapEntry : list) {
            hashSet.add(mZMapEntry.mzID());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override
    public String getMetaZoneID(String string, long l) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String string2 = null;
        List list = (List)TZ_TO_MZS_CACHE.getInstance(string, string);
        for (MZMapEntry mZMapEntry : list) {
            if (l < mZMapEntry.from() || l >= mZMapEntry.mfd54c56e39()) continue;
            string2 = mZMapEntry.mzID();
            break;
        }
        return string2;
    }

    @Override
    public String getReferenceZoneID(String string, String string2) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String string3 = null;
        Map map = (Map)MZ_TO_TZS_CACHE.getInstance(string, string);
        if (!map.isEmpty() && (string3 = (String)map.get(string2)) == null) {
            string3 = (String)map.get("001");
        }
        return string3;
    }

    @Override
    public String getMetaZoneDisplayName(String string, TimeZoneNames.NameType nameType) {
        if (string == null || string.length() == 0) {
            return null;
        }
        return this.loadMetaZoneNames(string).getName(nameType);
    }

    @Override
    public String getTimeZoneDisplayName(String string, TimeZoneNames.NameType nameType) {
        if (string == null || string.length() == 0) {
            return null;
        }
        return this.loadTimeZoneNames(string).getName(nameType);
    }

    @Override
    public String getExemplarLocationName(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String string2 = this.loadTimeZoneNames(string).getName(TimeZoneNames.NameType.EXEMPLAR_LOCATION);
        return string2;
    }

    @Override
    public synchronized Collection<TimeZoneNames.MatchInfo> find(CharSequence charSequence, int n, EnumSet<TimeZoneNames.NameType> enumSet) {
        if (charSequence == null || charSequence.length() == 0 || n < 0 || n >= charSequence.length()) {
            throw new IllegalArgumentException("bad input text or range");
        }
        NameSearchHandler nameSearchHandler = new NameSearchHandler(enumSet);
        this._namesTrie.find(charSequence, n, (TextTrieMap.ResultHandler<NameInfo>)nameSearchHandler);
        if (nameSearchHandler.getMaxMatchLen() == charSequence.length() - n || this._namesTrieFullyLoaded) {
            return nameSearchHandler.getMatches();
        }
        Set<String> set = TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.CANONICAL, null, null);
        for (String object2 : set) {
            this.loadTimeZoneNames(object2);
        }
        Set<String> set2 = this.getAvailableMetaZoneIDs();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            this.loadMetaZoneNames(string);
        }
        this._namesTrieFullyLoaded = true;
        nameSearchHandler.resetResults();
        this._namesTrie.find(charSequence, n, (TextTrieMap.ResultHandler<NameInfo>)nameSearchHandler);
        return nameSearchHandler.getMatches();
    }

    private void initialize(ULocale uLocale) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)ICUResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b/zone", uLocale);
        this._zoneStrings = (ICUResourceBundle)iCUResourceBundle.get(ZONE_STRINGS_BUNDLE);
        this._tzNamesMap = new ConcurrentHashMap();
        this._mzNamesMap = new ConcurrentHashMap();
        this._namesTrie = new TextTrieMap(true);
        this._namesTrieFullyLoaded = false;
        TimeZone timeZone = TimeZone.getDefault();
        String string = ZoneMeta.getCanonicalCLDRID(timeZone);
        if (string != null) {
            this.loadStrings(string);
        }
    }

    private synchronized void loadStrings(String string) {
        if (string == null || string.length() == 0) {
            return;
        }
        this.loadTimeZoneNames(string);
        Set<String> set = this.getAvailableMetaZoneIDs(string);
        for (String string2 : set) {
            this.loadMetaZoneNames(string2);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ULocale uLocale = this._zoneStrings.getULocale();
        objectOutputStream.writeObject(uLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ULocale uLocale = (ULocale)objectInputStream.readObject();
        this.initialize(uLocale);
    }

    private synchronized ZNames loadMetaZoneNames(String string) {
        ZNames zNames = this._mzNamesMap.get(string);
        if (zNames == null) {
            zNames = ZNames.getInstance(this._zoneStrings, MZ_PREFIX + string);
            string = string.intern();
            for (TimeZoneNames.NameType nameType : TimeZoneNames.NameType.values()) {
                String string2 = zNames.getName(nameType);
                if (string2 == null) continue;
                NameInfo nameInfo = new NameInfo();
                nameInfo.mzID = string;
                nameInfo.type = nameType;
                this._namesTrie.put(string2, nameInfo);
            }
            ZNames zNames2 = this._mzNamesMap.putIfAbsent(string, zNames);
            zNames = zNames2 == null ? zNames : zNames2;
        }
        return zNames;
    }

    private synchronized TZNames loadTimeZoneNames(String string) {
        TZNames tZNames = this._tzNamesMap.get(string);
        if (tZNames == null) {
            tZNames = TZNames.getInstance(this._zoneStrings, string.replace('/', ':'), string);
            string = string.intern();
            for (TimeZoneNames.NameType nameType : TimeZoneNames.NameType.values()) {
                String string2 = tZNames.getName(nameType);
                if (string2 == null) continue;
                NameInfo nameInfo = new NameInfo();
                nameInfo.tzID = string;
                nameInfo.type = nameType;
                this._namesTrie.put(string2, nameInfo);
            }
            TZNames tZNames2 = this._tzNamesMap.putIfAbsent(string, tZNames);
            tZNames = tZNames2 == null ? tZNames : tZNames2;
        }
        return tZNames;
    }

    public static String getDefaultExemplarLocationName(String string) {
        if (string == null || string.length() == 0 || LOC_EXCLUSION_PATTERN.matcher(string).matches()) {
            return null;
        }
        String string2 = null;
        int n = string.lastIndexOf(47);
        if (n > 0 && n + 1 < string.length()) {
            string2 = string.substring(n + 1).replace('_', ' ');
        }
        return string2;
    }

    static {
        TZ_TO_MZS_CACHE = new TZ2MZsCache();
        MZ_TO_TZS_CACHE = new MZ2TZsCache();
        LOC_EXCLUSION_PATTERN = Pattern.compile("Etc/.*|SystemV/.*|.*/Riyadh8[7-9]");
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class MZ2TZsCache
    extends SoftCache<String, Map<String, String>, String> {
        private MZ2TZsCache() {
        }

        @Override
        protected Map<String, String> createInstance(String string, String string2) {
            Map<String, String> map = null;
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "metaZones");
            UResourceBundle uResourceBundle2 = uResourceBundle.get("mapTimezones");
            try {
                UResourceBundle uResourceBundle3 = uResourceBundle2.get(string);
                Set<String> set = uResourceBundle3.keySet();
                map = new HashMap<String, String>(set.size());
                for (String string3 : set) {
                    String string4 = uResourceBundle3.getString(string3).intern();
                    map.put(string3.intern(), string4);
                }
            }
            catch (MissingResourceException missingResourceException) {
                map = Collections.emptyMap();
            }
            return map;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class TZ2MZsCache
    extends SoftCache<String, List<MZMapEntry>, String> {
        private TZ2MZsCache() {
        }

        @Override
        protected List<MZMapEntry> createInstance(String string, String string2) {
            List<MZMapEntry> list = null;
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "metaZones");
            UResourceBundle uResourceBundle2 = uResourceBundle.get("metazoneInfo");
            String string3 = string2.replace('/', ':');
            try {
                UResourceBundle uResourceBundle3 = uResourceBundle2.get(string3);
                list = new ArrayList<MZMapEntry>(uResourceBundle3.getSize());
                for (int i = 0; i < uResourceBundle3.getSize(); ++i) {
                    UResourceBundle uResourceBundle4 = uResourceBundle3.get(i);
                    String string4 = uResourceBundle4.getString(0);
                    String string5 = "1970-01-01 00:00";
                    String string6 = "9999-12-31 23:59";
                    if (uResourceBundle4.getSize() == 3) {
                        string5 = uResourceBundle4.getString(1);
                        string6 = uResourceBundle4.getString(2);
                    }
                    long l = TZ2MZsCache.parseDate(string5);
                    long l2 = TZ2MZsCache.parseDate(string6);
                    list.add(new MZMapEntry(string4, l, l2));
                }
            }
            catch (MissingResourceException missingResourceException) {
                list = Collections.emptyList();
            }
            return list;
        }

        private static long parseDate(String string) {
            int n;
            int n2;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            for (n2 = 0; n2 <= 3; ++n2) {
                n = string.charAt(n2) - 48;
                if (n < 0 || n >= 10) {
                    throw new IllegalArgumentException("Bad year");
                }
                n3 = 10 * n3 + n;
            }
            for (n2 = 5; n2 <= 6; ++n2) {
                n = string.charAt(n2) - 48;
                if (n < 0 || n >= 10) {
                    throw new IllegalArgumentException("Bad month");
                }
                n4 = 10 * n4 + n;
            }
            for (n2 = 8; n2 <= 9; ++n2) {
                n = string.charAt(n2) - 48;
                if (n < 0 || n >= 10) {
                    throw new IllegalArgumentException("Bad day");
                }
                n5 = 10 * n5 + n;
            }
            for (n2 = 11; n2 <= 12; ++n2) {
                n = string.charAt(n2) - 48;
                if (n < 0 || n >= 10) {
                    throw new IllegalArgumentException("Bad hour");
                }
                n6 = 10 * n6 + n;
            }
            for (n2 = 14; n2 <= 15; ++n2) {
                n = string.charAt(n2) - 48;
                if (n < 0 || n >= 10) {
                    throw new IllegalArgumentException("Bad minute");
                }
                n7 = 10 * n7 + n;
            }
            long l = Grego.fieldsToDay(n3, n4 - 1, n5) * 86400000L + (long)n6 * 3600000L + (long)n7 * 60000L;
            return l;
        }
    }

    private static class MZMapEntry {
        private String _mzID;
        private long _from;
        private long _to;

        MZMapEntry(String string, long l, long l2) {
            this._mzID = string;
            this._from = l;
            this._to = l2;
        }

        String mzID() {
            return this._mzID;
        }

        long from() {
            return this._from;
        }

        long mfd54c56e39() {
            return this._to;
        }
    }

    private static class TZNames
    extends ZNames {
        private String _locationName;
        private static final TZNames EMPTY_TZNAMES = new TZNames(null, null);

        public static TZNames getInstance(ICUResourceBundle iCUResourceBundle, String string, String string2) {
            if (iCUResourceBundle == null || string == null || string.length() == 0) {
                return EMPTY_TZNAMES;
            }
            String[] stringArray = TZNames.loadData(iCUResourceBundle, string);
            String string3 = null;
            ICUResourceBundle iCUResourceBundle2 = null;
            try {
                iCUResourceBundle2 = iCUResourceBundle.getWithFallback(string);
                string3 = iCUResourceBundle2.getStringWithFallback("ec");
            }
            catch (MissingResourceException missingResourceException) {
                // empty catch block
            }
            if (string3 == null) {
                string3 = TimeZoneNamesImpl.getDefaultExemplarLocationName(string2);
            }
            if (string3 == null && stringArray == null) {
                return EMPTY_TZNAMES;
            }
            return new TZNames(stringArray, string3);
        }

        public String getName(TimeZoneNames.NameType nameType) {
            if (nameType == TimeZoneNames.NameType.EXEMPLAR_LOCATION) {
                return this._locationName;
            }
            return super.getName(nameType);
        }

        private TZNames(String[] stringArray, String string) {
            super(stringArray);
            this._locationName = string;
        }
    }

    private static class ZNames {
        private static final ZNames EMPTY_ZNAMES = new ZNames(null);
        private String[] _names;
        private static final String[] KEYS = new String[]{"lg", "ls", "ld", "sg", "ss", "sd"};

        protected ZNames(String[] stringArray) {
            this._names = stringArray;
        }

        public static ZNames getInstance(ICUResourceBundle iCUResourceBundle, String string) {
            String[] stringArray = ZNames.loadData(iCUResourceBundle, string);
            if (stringArray == null) {
                return EMPTY_ZNAMES;
            }
            return new ZNames(stringArray);
        }

        public String getName(TimeZoneNames.NameType nameType) {
            if (this._names == null) {
                return null;
            }
            String string = null;
            switch (nameType) {
                case LONG_GENERIC: {
                    string = this._names[0];
                    break;
                }
                case LONG_STANDARD: {
                    string = this._names[1];
                    break;
                }
                case LONG_DAYLIGHT: {
                    string = this._names[2];
                    break;
                }
                case SHORT_GENERIC: {
                    string = this._names[3];
                    break;
                }
                case SHORT_STANDARD: {
                    string = this._names[4];
                    break;
                }
                case SHORT_DAYLIGHT: {
                    string = this._names[5];
                    break;
                }
                case EXEMPLAR_LOCATION: {
                    string = null;
                }
            }
            return string;
        }

        protected static String[] loadData(ICUResourceBundle iCUResourceBundle, String string) {
            if (iCUResourceBundle == null || string == null || string.length() == 0) {
                return null;
            }
            ICUResourceBundle iCUResourceBundle2 = null;
            try {
                iCUResourceBundle2 = iCUResourceBundle.getWithFallback(string);
            }
            catch (MissingResourceException missingResourceException) {
                return null;
            }
            boolean bl = true;
            String[] stringArray = new String[KEYS.length];
            for (int i = 0; i < stringArray.length; ++i) {
                try {
                    stringArray[i] = iCUResourceBundle2.getStringWithFallback(KEYS[i]);
                    bl = false;
                    continue;
                }
                catch (MissingResourceException missingResourceException) {
                    stringArray[i] = null;
                }
            }
            if (bl) {
                return null;
            }
            return stringArray;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class NameSearchHandler
    implements TextTrieMap.ResultHandler<NameInfo> {
        private EnumSet<TimeZoneNames.NameType> _nameTypes;
        private Collection<TimeZoneNames.MatchInfo> _matches;
        private int _maxMatchLen;

        NameSearchHandler(EnumSet<TimeZoneNames.NameType> enumSet) {
            this._nameTypes = enumSet;
        }

        @Override
        public boolean handlePrefixMatch(int n, Iterator<NameInfo> iterator2) {
            while (iterator2.hasNext()) {
                TimeZoneNames.MatchInfo matchInfo;
                NameInfo nameInfo = iterator2.next();
                if (this._nameTypes != null && !this._nameTypes.contains((Object)nameInfo.type)) continue;
                if (nameInfo.tzID != null) {
                    matchInfo = new TimeZoneNames.MatchInfo(nameInfo.type, nameInfo.tzID, null, n);
                } else {
                    assert (nameInfo.mzID != null);
                    matchInfo = new TimeZoneNames.MatchInfo(nameInfo.type, null, nameInfo.mzID, n);
                }
                if (this._matches == null) {
                    this._matches = new LinkedList<TimeZoneNames.MatchInfo>();
                }
                this._matches.add(matchInfo);
                if (n <= this._maxMatchLen) continue;
                this._maxMatchLen = n;
            }
            return true;
        }

        public Collection<TimeZoneNames.MatchInfo> getMatches() {
            if (this._matches == null) {
                return Collections.emptyList();
            }
            return this._matches;
        }

        public int getMaxMatchLen() {
            return this._maxMatchLen;
        }

        public void resetResults() {
            this._matches = null;
            this._maxMatchLen = 0;
        }
    }

    private static class NameInfo {
        String tzID;
        String mzID;
        TimeZoneNames.NameType type;

        private NameInfo() {
        }
    }
}

