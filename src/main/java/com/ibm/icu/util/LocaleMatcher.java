/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.impl.Row;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.LocalePriorityList;
import com.ibm.icu.util.ULocale;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class LocaleMatcher {
    private static final boolean DEBUG = false;
    private static final double DEFAULT_THRESHOLD = 0.5;
    private final ULocale defaultLanguage;
    Map<ULocale, Row.R2<ULocale, Double>> maximizedLanguageToWeight = new LinkedHashMap<ULocale, Row.R2<ULocale, Double>>();
    LanguageMatcherData matcherData;
    private static LanguageMatcherData defaultWritten = LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$100(LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$000(LanguageMatcherData.access$000(new LanguageMatcherData().addDistance("no", "nb", 100, "The language no is normally taken as nb in content; we might alias this for lookup."), "nn", "nb", 96), "nn", "no", 96).addDistance("da", "no", 90, "Danish and norwegian are reasonably close."), "da", "nb", 90).addDistance("hr", "br", 96, "Serbo-croatian variants are all very close."), "sh", "br", 96), "sr", "br", 96), "sh", "hr", 96), "sr", "hr", 96), "sh", "sr", 96).addDistance("sr-Latn", "sr-Cyrl", 90, "Most serbs can read either script."), "*-Hans", "*-Hant", 85, true, "Readers of simplified can read traditional much better than reverse.").addDistance("*-Hant", "*-Hans", 75, true).addDistance("en-*-US", "en-*-CA", 98, "US is different than others, and Canadian is inbetween."), "en-*-US", "en-*-*", 97), "en-*-CA", "en-*-*", 98), "en-*-*", "en-*-*", 99).addDistance("es-*-ES", "es-*-ES", 100, "Latin American Spanishes are closer to each other. Approximate by having es-ES be further from everything else."), "es-*-ES", "es-*-*", 93).addDistance("*", "*", 1, "[Default value -- must be at end!] Normally there is no comprehension of different languages.").addDistance("*-*", "*-*", 20, "[Default value -- must be at end!] Normally there is little comprehension of different scripts.").addDistance("*-*-*", "*-*-*", 96, "[Default value -- must be at end!] Normally there are small differences across regions.").freeze();
    private static HashMap<String, String> canonicalMap = new HashMap();

    public LocaleMatcher(LocalePriorityList localePriorityList) {
        this(localePriorityList, defaultWritten);
    }

    public LocaleMatcher(String string) {
        this(LocalePriorityList.add(string).build());
    }

    public LocaleMatcher(LocalePriorityList localePriorityList, LanguageMatcherData languageMatcherData) {
        this.matcherData = languageMatcherData;
        for (ULocale uLocale : localePriorityList) {
            this.add(uLocale, localePriorityList.getWeight(uLocale));
        }
        Iterator<ULocale> iterator2 = localePriorityList.iterator();
        this.defaultLanguage = iterator2.hasNext() ? iterator2.next() : null;
    }

    public double match(ULocale uLocale, ULocale uLocale2, ULocale uLocale3, ULocale uLocale4) {
        return this.matcherData.match(uLocale, uLocale2, uLocale3, uLocale4);
    }

    public ULocale canonicalize(ULocale uLocale) {
        String string = uLocale.getLanguage();
        String string2 = canonicalMap.get(string);
        String string3 = uLocale.getScript();
        String string4 = canonicalMap.get(string3);
        String string5 = uLocale.getCountry();
        String string6 = canonicalMap.get(string5);
        if (string2 != null || string4 != null || string6 != null) {
            return new ULocale(string2 == null ? string : string2, string4 == null ? string3 : string4, string6 == null ? string5 : string6);
        }
        return uLocale;
    }

    public ULocale getBestMatch(LocalePriorityList localePriorityList) {
        double d = 0.0;
        ULocale uLocale = null;
        for (ULocale uLocale2 : localePriorityList) {
            Row.R2<ULocale, Double> r2 = this.getBestMatchInternal(uLocale2);
            double d2 = (Double)r2.get1() * localePriorityList.getWeight(uLocale2);
            if (!(d2 > d)) continue;
            d = d2;
            uLocale = (ULocale)r2.get0();
        }
        if (d < 0.5) {
            uLocale = this.defaultLanguage;
        }
        return uLocale;
    }

    public ULocale getBestMatch(String string) {
        return this.getBestMatch(LocalePriorityList.add(string).build());
    }

    public ULocale getBestMatch(ULocale uLocale) {
        return (ULocale)this.getBestMatchInternal(uLocale).get0();
    }

    public String toString() {
        return "{" + this.defaultLanguage + ", " + this.maximizedLanguageToWeight + "}";
    }

    private Row.R2<ULocale, Double> getBestMatchInternal(ULocale uLocale) {
        uLocale = this.canonicalize(uLocale);
        ULocale uLocale2 = this.addLikelySubtags(uLocale);
        double d = 0.0;
        ULocale uLocale3 = null;
        for (ULocale uLocale4 : this.maximizedLanguageToWeight.keySet()) {
            Row.R2<ULocale, Double> r2;
            double d2 = this.match(uLocale, uLocale2, uLocale4, (ULocale)(r2 = this.maximizedLanguageToWeight.get(uLocale4)).get0());
            double d3 = d2 * (Double)r2.get1();
            if (!(d3 > d)) continue;
            d = d3;
            uLocale3 = uLocale4;
        }
        if (d < 0.5) {
            uLocale3 = this.defaultLanguage;
        }
        return Row.R2.of(uLocale3, d);
    }

    private void add(ULocale uLocale, Double d) {
        uLocale = this.canonicalize(uLocale);
        Row.R2<ULocale, Double> r2 = Row.of(this.addLikelySubtags(uLocale), d);
        this.maximizedLanguageToWeight.put(uLocale, r2);
    }

    private ULocale addLikelySubtags(ULocale uLocale) {
        ULocale uLocale2 = ULocale.addLikelySubtags(uLocale);
        if (uLocale2 == null || uLocale2.equals(uLocale)) {
            String string = uLocale.getLanguage();
            String string2 = uLocale.getScript();
            String string3 = uLocale.getCountry();
            return new ULocale((string.length() == 0 ? "und" : string) + "_" + (string2.length() == 0 ? "Zzzz" : string2) + "_" + (string3.length() == 0 ? "ZZ" : string3));
        }
        return uLocale2;
    }

    static {
        canonicalMap.put("iw", "he");
        canonicalMap.put("mo", "ro");
        canonicalMap.put("tl", "fil");
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class LanguageMatcherData
    implements Freezable<LanguageMatcherData> {
        ScoreData languageScores = new ScoreData(Level.language);
        ScoreData scriptScores = new ScoreData(Level.script);
        ScoreData regionScores = new ScoreData(Level.region);
        private boolean frozen = false;

        public double match(ULocale uLocale, ULocale uLocale2, ULocale uLocale3, ULocale uLocale4) {
            double d = 0.0;
            d += this.languageScores.getScore(uLocale, uLocale2, uLocale.getLanguage(), uLocale2.getLanguage(), uLocale3, uLocale4, uLocale3.getLanguage(), uLocale4.getLanguage());
            d += this.scriptScores.getScore(uLocale, uLocale2, uLocale.getScript(), uLocale2.getScript(), uLocale3, uLocale4, uLocale3.getScript(), uLocale4.getScript());
            d += this.regionScores.getScore(uLocale, uLocale2, uLocale.getCountry(), uLocale2.getCountry(), uLocale3, uLocale4, uLocale3.getCountry(), uLocale4.getCountry());
            if (!uLocale.getVariant().equals(uLocale3.getVariant())) {
                d += 1.0;
            }
            if (d < 0.0) {
                d = 0.0;
            } else if (d > 1.0) {
                d = 1.0;
            }
            return 1.0 - d;
        }

        private LanguageMatcherData addDistance(String string, String string2, int n) {
            return this.addDistance(string, string2, n, false, null);
        }

        public LanguageMatcherData addDistance(String string, String string2, int n, String string3) {
            return this.addDistance(string, string2, n, false, string3);
        }

        public LanguageMatcherData addDistance(String string, String string2, int n, boolean bl) {
            return this.addDistance(string, string2, n, bl, null);
        }

        private LanguageMatcherData addDistance(String string, String string2, int n, boolean bl, String string3) {
            LocalePatternMatcher localePatternMatcher;
            Level level;
            double d = 1.0 - (double)n / 100.0;
            LocalePatternMatcher localePatternMatcher2 = new LocalePatternMatcher(string);
            Level level2 = localePatternMatcher2.getLevel();
            if (level2 != (level = (localePatternMatcher = new LocalePatternMatcher(string2)).getLevel())) {
                throw new IllegalArgumentException();
            }
            Row.R3<LocalePatternMatcher, LocalePatternMatcher, Double> r3 = Row.of(localePatternMatcher2, localePatternMatcher, d);
            Row.R3<LocalePatternMatcher, LocalePatternMatcher, Double> r32 = bl ? null : Row.of(localePatternMatcher, localePatternMatcher2, d);
            switch (level2) {
                case language: {
                    String string4 = localePatternMatcher2.getLanguage();
                    String string5 = localePatternMatcher.getLanguage();
                    this.languageScores.addDataToScores(string4, string5, r3);
                    if (bl) break;
                    this.languageScores.addDataToScores(string5, string4, r32);
                    break;
                }
                case script: {
                    String string6 = localePatternMatcher2.getScript();
                    String string7 = localePatternMatcher.getScript();
                    this.scriptScores.addDataToScores(string6, string7, r3);
                    if (bl) break;
                    this.scriptScores.addDataToScores(string7, string6, r32);
                    break;
                }
                case region: {
                    String string8 = localePatternMatcher2.getRegion();
                    String string9 = localePatternMatcher.getRegion();
                    this.regionScores.addDataToScores(string8, string9, r3);
                    if (bl) break;
                    this.regionScores.addDataToScores(string9, string8, r32);
                }
            }
            return this;
        }

        @Override
        public LanguageMatcherData cloneAsThawed() {
            try {
                LanguageMatcherData languageMatcherData = (LanguageMatcherData)this.clone();
                languageMatcherData.languageScores = this.languageScores.cloneAsThawed();
                languageMatcherData.scriptScores = this.scriptScores.cloneAsThawed();
                languageMatcherData.regionScores = this.regionScores.cloneAsThawed();
                languageMatcherData.frozen = false;
                return languageMatcherData;
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                throw new IllegalArgumentException(cloneNotSupportedException);
            }
        }

        @Override
        public LanguageMatcherData freeze() {
            return this;
        }

        @Override
        public boolean isFrozen() {
            return this.frozen;
        }

        static /* synthetic */ LanguageMatcherData access$000(LanguageMatcherData languageMatcherData, String string, String string2, int n) {
            return languageMatcherData.addDistance(string, string2, n);
        }

        static /* synthetic */ LanguageMatcherData access$100(LanguageMatcherData languageMatcherData, String string, String string2, int n, boolean bl, String string3) {
            return languageMatcherData.addDistance(string, string2, n, bl, string3);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ScoreData
    implements Freezable<ScoreData> {
        LinkedHashSet<Row.R3<LocalePatternMatcher, LocalePatternMatcher, Double>> scores = new LinkedHashSet();
        final double worst;
        final Level level;
        private boolean frozen = false;

        public ScoreData(Level level) {
            this.level = level;
            this.worst = (double)(1 - (level == Level.language ? 90 : (level == Level.script ? 20 : 4))) / 100.0;
        }

        void addDataToScores(String string, String string2, Row.R3<LocalePatternMatcher, LocalePatternMatcher, Double> r3) {
            this.scores.add(r3);
        }

        double getScore(ULocale uLocale, ULocale uLocale2, String string, String string2, ULocale uLocale3, ULocale uLocale4, String string3, String string4) {
            double d;
            boolean bl = string.equals(string2);
            boolean bl2 = string3.equals(string4);
            if (!string2.equals(string4)) {
                d = this.getRawScore(uLocale2, uLocale4);
                if (bl == bl2) {
                    d *= 0.75;
                } else if (bl) {
                    d *= 0.5;
                }
            } else {
                d = bl == bl2 ? 0.0 : 0.25 * this.worst;
            }
            return d;
        }

        private double getRawScore(ULocale uLocale, ULocale uLocale2) {
            for (Row.R3 r3 : this.scores) {
                if (!((LocalePatternMatcher)r3.get0()).matches(uLocale) || !((LocalePatternMatcher)r3.get1()).matches(uLocale2)) continue;
                return (Double)r3.get2();
            }
            return this.worst;
        }

        public String toString() {
            return (Object)((Object)this.level) + ", " + this.scores;
        }

        @Override
        public ScoreData cloneAsThawed() {
            try {
                ScoreData scoreData = (ScoreData)this.clone();
                scoreData.scores = (LinkedHashSet)scoreData.scores.clone();
                scoreData.frozen = false;
                return scoreData;
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                throw new IllegalArgumentException(cloneNotSupportedException);
            }
        }

        @Override
        public ScoreData freeze() {
            return this;
        }

        @Override
        public boolean isFrozen() {
            return this.frozen;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum Level {
        language,
        script,
        region;

    }

    private static class LocalePatternMatcher {
        private String lang;
        private String script;
        private String region;
        private Level level;
        static Pattern pattern = Pattern.compile("([a-zA-Z]{1,8}|\\*)(?:-([a-zA-Z]{4}|\\*))?(?:-([a-zA-Z]{2}|[0-9]{3}|\\*))?");

        public LocalePatternMatcher(String string) {
            Matcher matcher = pattern.matcher(string);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Bad pattern: " + string);
            }
            this.lang = matcher.group(1);
            this.script = matcher.group(2);
            this.region = matcher.group(3);
            Level level = this.region != null ? Level.region : (this.level = this.script != null ? Level.script : Level.language);
            if (this.lang.equals("*")) {
                this.lang = null;
            }
            if (this.script != null && this.script.equals("*")) {
                this.script = null;
            }
            if (this.region != null && this.region.equals("*")) {
                this.region = null;
            }
        }

        boolean matches(ULocale uLocale) {
            if (this.lang != null && !this.lang.equals(uLocale.getLanguage())) {
                return false;
            }
            if (this.script != null && !this.script.equals(uLocale.getScript())) {
                return false;
            }
            return this.region == null || this.region.equals(uLocale.getCountry());
        }

        public Level getLevel() {
            return this.level;
        }

        public String getLanguage() {
            return this.lang == null ? "*" : this.lang;
        }

        public String getScript() {
            return this.script == null ? "*" : this.script;
        }

        public String getRegion() {
            return this.region == null ? "*" : this.region;
        }

        public String toString() {
            String string = this.getLanguage();
            if (this.level != Level.language) {
                string = string + "-" + this.getScript();
                if (this.level != Level.script) {
                    string = string + "-" + this.getRegion();
                }
            }
            return string;
        }
    }
}

