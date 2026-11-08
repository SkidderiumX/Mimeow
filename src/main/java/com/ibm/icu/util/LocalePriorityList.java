/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.util.ULocale;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class LocalePriorityList
implements Iterable<ULocale> {
    private static final double D0 = 0.0;
    private static final Double D1 = 1.0;
    private static final Pattern languageSplitter = Pattern.compile("\\s*,\\s*");
    private static final Pattern weightSplitter = Pattern.compile("\\s*(\\S*)\\s*;\\s*q\\s*=\\s*(\\S*)");
    private final Map<ULocale, Double> languagesAndWeights;
    private static Comparator<Double> myDescendingDouble = new Comparator<Double>(){

        @Override
        public int compare(Double d, Double d2) {
            return -d.compareTo(d2);
        }
    };

    public static Builder add(ULocale uLocale) {
        return new Builder().add(uLocale);
    }

    public static Builder add(ULocale uLocale, double d) {
        return new Builder().add(uLocale, d);
    }

    public static Builder add(LocalePriorityList localePriorityList) {
        return new Builder().add(localePriorityList);
    }

    public static Builder add(String string) {
        return new Builder().add(string);
    }

    public Double getWeight(ULocale uLocale) {
        return this.languagesAndWeights.get(uLocale);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ULocale uLocale : this.languagesAndWeights.keySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(uLocale);
            double d = this.languagesAndWeights.get(uLocale);
            if (d == D1) continue;
            stringBuilder.append(";q=").append(d);
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<ULocale> iterator() {
        return this.languagesAndWeights.keySet().iterator();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        try {
            LocalePriorityList localePriorityList = (LocalePriorityList)object;
            return ((Object)this.languagesAndWeights).equals(localePriorityList.languagesAndWeights);
        }
        catch (RuntimeException runtimeException) {
            return false;
        }
    }

    public int hashCode() {
        return ((Object)this.languagesAndWeights).hashCode();
    }

    private LocalePriorityList(Map<ULocale, Double> map) {
        this.languagesAndWeights = map;
    }

    public static class Builder {
        private final Map<ULocale, Double> languageToWeight = new LinkedHashMap<ULocale, Double>();

        private Builder() {
        }

        public LocalePriorityList build() {
            return this.build(false);
        }

        public LocalePriorityList build(boolean bl) {
            Set set;
            TreeMap treeMap = new TreeMap(myDescendingDouble);
            for (ULocale object : this.languageToWeight.keySet()) {
                Double d = this.languageToWeight.get(object);
                set = (Set)treeMap.get(d);
                if (set == null) {
                    set = new LinkedHashSet();
                    treeMap.put(d, set);
                }
                set.add(object);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : treeMap.entrySet()) {
                set = (Double)entry.getKey();
                for (ULocale uLocale : (Set)entry.getValue()) {
                    linkedHashMap.put(uLocale, bl ? set : D1);
                }
            }
            return new LocalePriorityList(Collections.unmodifiableMap(linkedHashMap));
        }

        public Builder add(LocalePriorityList localePriorityList) {
            for (ULocale uLocale : localePriorityList.languagesAndWeights.keySet()) {
                this.add(uLocale, (Double)localePriorityList.languagesAndWeights.get(uLocale));
            }
            return this;
        }

        public Builder add(ULocale uLocale) {
            return this.add(uLocale, D1);
        }

        public Builder add(ULocale ... uLocaleArray) {
            for (ULocale uLocale : uLocaleArray) {
                this.add(uLocale, D1);
            }
            return this;
        }

        public Builder add(ULocale uLocale, double d) {
            if (this.languageToWeight.containsKey(uLocale)) {
                this.languageToWeight.remove(uLocale);
            }
            if (d <= 0.0) {
                return this;
            }
            if (d > D1) {
                d = D1;
            }
            this.languageToWeight.put(uLocale, d);
            return this;
        }

        public Builder add(String string) {
            String[] stringArray = languageSplitter.split(string.trim());
            Matcher matcher = weightSplitter.matcher("");
            for (String string2 : stringArray) {
                if (matcher.reset(string2).matches()) {
                    ULocale uLocale = new ULocale(matcher.group(1));
                    double d = Double.parseDouble(matcher.group(2));
                    if (!(d >= 0.0) || !(d <= D1)) {
                        throw new IllegalArgumentException("Illegal weight, must be 0..1: " + d);
                    }
                    this.add(uLocale, d);
                    continue;
                }
                if (string2.length() == 0) continue;
                this.add(new ULocale(string2));
            }
            return this;
        }
    }
}

