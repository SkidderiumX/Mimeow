/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.codec.language.bm.NameType;

public class Lang {
    private static final Map<NameType, Lang> Langs = new EnumMap<NameType, Lang>(NameType.class);
    private static final String LANGUAGE_RULES_RN = "org/apache/commons/codec/language/bm/lang.txt";
    private final Languages languages;
    private final List<LangRule> rules;

    public static Lang instance(NameType nameType) {
        return Langs.get((Object)nameType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Lang loadFromResource(String string, Languages languages) {
        ArrayList<LangRule> arrayList = new ArrayList<LangRule>();
        InputStream inputStream2 = Lang.class.getClassLoader().getResourceAsStream(string);
        if (inputStream2 == null) {
            throw new IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/lang.txt");
        }
        Scanner scanner = new Scanner(inputStream2, "UTF-8");
        try {
            boolean bl = false;
            while (scanner.hasNextLine()) {
                String string2;
                String string3 = string2 = scanner.nextLine();
                if (bl) {
                    if (!string3.endsWith("*/")) continue;
                    bl = false;
                    continue;
                }
                if (string3.startsWith("/*")) {
                    bl = true;
                    continue;
                }
                int n = string3.indexOf("//");
                if (n >= 0) {
                    string3 = string3.substring(0, n);
                }
                if ((string3 = string3.trim()).length() == 0) continue;
                String[] stringArray = string3.split("\\s+");
                if (stringArray.length != 3) {
                    throw new IllegalArgumentException("Malformed line '" + string2 + "' in language resource '" + string + "'");
                }
                Pattern pattern = Pattern.compile(stringArray[0]);
                String[] stringArray2 = stringArray[1].split("\\+");
                boolean bl2 = stringArray[2].equals("true");
                arrayList.add(new LangRule(pattern, new HashSet<String>(Arrays.asList(stringArray2)), bl2));
            }
        }
        finally {
            scanner.close();
        }
        return new Lang(arrayList, languages);
    }

    private Lang(List<LangRule> list, Languages languages) {
        this.rules = Collections.unmodifiableList(list);
        this.languages = languages;
    }

    public String guessLanguage(String string) {
        Languages.LanguageSet languageSet = this.guessLanguages(string);
        return languageSet.isSingleton() ? languageSet.getAny() : "any";
    }

    public Languages.LanguageSet guessLanguages(String string) {
        String string2 = string.toLowerCase(Locale.ENGLISH);
        HashSet<String> hashSet = new HashSet<String>(this.languages.getLanguages());
        for (LangRule langRule : this.rules) {
            if (!langRule.matches(string2)) continue;
            if (langRule.acceptOnMatch) {
                hashSet.retainAll(langRule.languages);
                continue;
            }
            hashSet.removeAll(langRule.languages);
        }
        Languages.LanguageSet languageSet = Languages.LanguageSet.from(hashSet);
        return languageSet.equals(Languages.NO_LANGUAGES) ? Languages.ANY_LANGUAGE : languageSet;
    }

    static {
        for (NameType nameType : NameType.values()) {
            Langs.put(nameType, Lang.loadFromResource(LANGUAGE_RULES_RN, Languages.getInstance(nameType)));
        }
    }

    private static final class LangRule {
        private final boolean acceptOnMatch;
        private final Set<String> languages;
        private final Pattern pattern;

        private LangRule(Pattern pattern, Set<String> set, boolean bl) {
            this.pattern = pattern;
            this.languages = set;
            this.acceptOnMatch = bl;
        }

        public boolean matches(String string) {
            return this.pattern.matcher(string).find();
        }
    }
}

