/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.UResourceBundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Region
implements Comparable<Region> {
    public static final int UNDEFINED_NUMERIC_CODE = -1;
    private String id;
    private int code;
    private RegionType type;
    private Region containingRegion = null;
    private Set<Region> containedRegions = new TreeSet<Region>();
    private List<Region> preferredValues = null;
    private static boolean regionDataIsLoaded = false;
    private static Map<String, Region> regionIDMap = null;
    private static Map<Integer, Region> numericCodeMap = null;
    private static Map<String, Region> regionAliases = null;
    private static ArrayList<Region> regions = null;
    private static ArrayList<Set<Region>> availableRegions = null;
    private static final String UNKNOWN_REGION_ID = "ZZ";
    private static final String OUTLYING_OCEANIA_REGION_ID = "QO";
    private static final String WORLD_ID = "001";

    private Region() {
    }

    private static synchronized void loadRegionData() {
        int n;
        Object object;
        Object object2;
        Object object3;
        Comparable<Region> comparable;
        Object object4;
        Object object6;
        int n2;
        if (regionDataIsLoaded) {
            return;
        }
        regionAliases = new HashMap<String, Region>();
        regionIDMap = new HashMap<String, Region>();
        numericCodeMap = new HashMap<Integer, Region>();
        availableRegions = new ArrayList(RegionType.values().length);
        UResourceBundle uResourceBundle = null;
        UResourceBundle uResourceBundle2 = null;
        UResourceBundle uResourceBundle3 = null;
        UResourceBundle uResourceBundle4 = null;
        UResourceBundle uResourceBundle5 = null;
        UResourceBundle uResourceBundle6 = null;
        UResourceBundle uResourceBundle7 = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "metadata", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
        uResourceBundle = uResourceBundle7.get("regionCodes");
        uResourceBundle2 = uResourceBundle7.get("territoryAlias");
        UResourceBundle uResourceBundle8 = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
        uResourceBundle3 = uResourceBundle8.get("codeMappings");
        uResourceBundle5 = uResourceBundle8.get("territoryContainment");
        uResourceBundle4 = uResourceBundle5.get(WORLD_ID);
        uResourceBundle6 = uResourceBundle5.get("grouping");
        String[] stringArray = uResourceBundle4.getStringArray();
        List<String> list = Arrays.asList(stringArray);
        String[] stringArray2 = uResourceBundle6.getStringArray();
        List<String> list2 = Arrays.asList(stringArray2);
        int n3 = uResourceBundle.getSize();
        regions = new ArrayList(n3);
        for (n2 = 0; n2 < n3; ++n2) {
            String object52;
            object6 = new Region();
            ((Region)object6).id = object52 = uResourceBundle.getString(n2);
            ((Region)object6).type = RegionType.TERRITORY;
            regionIDMap.put(object52, (Region)object6);
            if (object52.matches("[0-9]{3}")) {
                ((Region)object6).code = Integer.valueOf(object52);
                numericCodeMap.put(((Region)object6).code, (Region)object6);
                ((Region)object6).type = RegionType.SUBCONTINENT;
            } else {
                ((Region)object6).code = -1;
            }
            regions.add((Region)object6);
        }
        for (n2 = 0; n2 < uResourceBundle2.getSize(); ++n2) {
            object6 = uResourceBundle2.get(n2);
            String string = ((UResourceBundle)object6).getKey();
            object4 = ((UResourceBundle)object6).getString();
            if (regionIDMap.containsKey(object4) && !regionIDMap.containsKey(string)) {
                regionAliases.put(string, regionIDMap.get(object4));
                continue;
            }
            if (regionIDMap.containsKey(string)) {
                comparable = regionIDMap.get(string);
            } else {
                comparable = new Region();
                ((Region)comparable).id = string;
                regionIDMap.put(string, (Region)comparable);
                if (string.matches("[0-9]{3}")) {
                    ((Region)comparable).code = Integer.valueOf(string);
                    numericCodeMap.put(((Region)comparable).code, (Region)comparable);
                } else {
                    ((Region)comparable).code = -1;
                }
                regions.add((Region)comparable);
            }
            ((Region)comparable).type = RegionType.DEPRECATED;
            object3 = Arrays.asList(((String)object4).split(" "));
            ((Region)comparable).preferredValues = new ArrayList<Region>();
            object2 = object3.iterator();
            while (object2.hasNext()) {
                object = (String)object2.next();
                if (!regionIDMap.containsKey(object)) continue;
                ((Region)comparable).preferredValues.add(regionIDMap.get(object));
            }
        }
        for (n2 = 0; n2 < uResourceBundle3.getSize(); ++n2) {
            object6 = uResourceBundle3.get(n2);
            if (((UResourceBundle)object6).getType() != 8) continue;
            String[] stringArray3 = ((UResourceBundle)object6).getStringArray();
            object4 = stringArray3[0];
            comparable = Integer.valueOf(stringArray3[1]);
            object3 = stringArray3[2];
            if (!regionIDMap.containsKey(object4)) continue;
            object2 = regionIDMap.get(object4);
            ((Region)object2).code = (Integer)comparable;
            numericCodeMap.put(((Region)object2).code, (Region)object2);
            regionAliases.put((String)object3, (Region)object2);
        }
        if (regionIDMap.containsKey(WORLD_ID)) {
            Region region = regionIDMap.get(WORLD_ID);
            region.type = RegionType.WORLD;
        }
        if (regionIDMap.containsKey(UNKNOWN_REGION_ID)) {
            Region region = regionIDMap.get(UNKNOWN_REGION_ID);
            region.type = RegionType.UNKNOWN;
        }
        for (String string : list) {
            if (!regionIDMap.containsKey(string)) continue;
            Region region = regionIDMap.get(string);
            region.type = RegionType.CONTINENT;
        }
        for (String string : list2) {
            if (!regionIDMap.containsKey(string)) continue;
            Region region = regionIDMap.get(string);
            region.type = RegionType.GROUPING;
        }
        if (regionIDMap.containsKey(OUTLYING_OCEANIA_REGION_ID)) {
            Region region = regionIDMap.get(OUTLYING_OCEANIA_REGION_ID);
            region.type = RegionType.SUBCONTINENT;
        }
        for (n = 0; n < uResourceBundle5.getSize(); ++n) {
            UResourceBundle uResourceBundle9 = uResourceBundle5.get(n);
            object4 = uResourceBundle9.getKey();
            comparable = regionIDMap.get(object4);
            for (int i = 0; i < uResourceBundle9.getSize(); ++i) {
                object2 = uResourceBundle9.getString(i);
                object = regionIDMap.get(object2);
                if (comparable == null || object == null) continue;
                ((Region)comparable).containedRegions.add((Region)object);
                if (((Region)comparable).getType() == RegionType.GROUPING) continue;
                ((Region)object).containingRegion = comparable;
            }
        }
        for (n = 0; n < RegionType.values().length; ++n) {
            availableRegions.add(new TreeSet());
        }
        for (Region region : regions) {
            object4 = availableRegions.get(region.type.ordinal());
            object4.add(region);
            availableRegions.set(region.type.ordinal(), (Set<Region>)object4);
        }
        regionDataIsLoaded = true;
    }

    public static Region getInstance(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        Region.loadRegionData();
        Region region = regionIDMap.get(string);
        if (region == null) {
            region = regionAliases.get(string);
        }
        if (region == null) {
            throw new IllegalArgumentException("Unknown region id: " + string);
        }
        if (region.type == RegionType.DEPRECATED && region.preferredValues.size() == 1) {
            region = region.preferredValues.get(0);
        }
        return region;
    }

    public static Region getInstance(int n) {
        Region.loadRegionData();
        Region region = numericCodeMap.get(n);
        if (region == null) {
            String string = "";
            if (n < 10) {
                string = "00";
            } else if (n < 100) {
                string = "0";
            }
            String string2 = string + Integer.toString(n);
            region = regionAliases.get(string2);
        }
        if (region == null) {
            throw new IllegalArgumentException("Unknown region code: " + n);
        }
        if (region.type == RegionType.DEPRECATED && region.preferredValues.size() == 1) {
            region = region.preferredValues.get(0);
        }
        return region;
    }

    public static Set<Region> getAvailable(RegionType regionType) {
        Region.loadRegionData();
        return Collections.unmodifiableSet(availableRegions.get(regionType.ordinal()));
    }

    public Region getContainingRegion() {
        Region.loadRegionData();
        return this.containingRegion;
    }

    public Region getContainingRegion(RegionType regionType) {
        Region.loadRegionData();
        if (this.containingRegion == null) {
            return null;
        }
        if (this.containingRegion.type.equals((Object)regionType)) {
            return this.containingRegion;
        }
        return this.containingRegion.getContainingRegion(regionType);
    }

    public Set<Region> getContainedRegions() {
        Region.loadRegionData();
        return Collections.unmodifiableSet(this.containedRegions);
    }

    public Set<Region> getContainedRegions(RegionType regionType) {
        Region.loadRegionData();
        TreeSet<Region> treeSet = new TreeSet<Region>();
        Set<Region> set = this.getContainedRegions();
        for (Region region : set) {
            if (region.getType() == regionType) {
                treeSet.add(region);
                continue;
            }
            treeSet.addAll(region.getContainedRegions(regionType));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public List<Region> getPreferredValues() {
        Region.loadRegionData();
        if (this.type == RegionType.DEPRECATED) {
            return Collections.unmodifiableList(this.preferredValues);
        }
        return null;
    }

    public boolean contains(Region region) {
        Region.loadRegionData();
        if (this.containedRegions.contains(region)) {
            return true;
        }
        for (Region region2 : this.containedRegions) {
            if (!region2.contains(region)) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        return this.id;
    }

    public int getNumericCode() {
        return this.code;
    }

    public RegionType getType() {
        return this.type;
    }

    @Override
    public int compareTo(Region region) {
        return this.id.compareTo(region.id);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum RegionType {
        UNKNOWN,
        TERRITORY,
        WORLD,
        CONTINENT,
        SUBCONTINENT,
        GROUPING,
        DEPRECATED;

    }
}

