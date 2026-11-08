package com.ibm.icu.util;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUResourceTableAccess;
import com.ibm.icu.impl.LocaleIDParser;
import com.ibm.icu.impl.LocaleIDs;
import com.ibm.icu.impl.LocaleUtility;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.locale.AsciiUtil;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.impl.locale.Extension;
import com.ibm.icu.impl.locale.InternalLocaleBuilder;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.locale.LocaleExtensions;
import com.ibm.icu.impl.locale.LocaleSyntaxException;
import com.ibm.icu.impl.locale.ParseStatus;
import com.ibm.icu.impl.locale.UnicodeLocaleExtension;
import com.ibm.icu.text.LocaleDisplayNames;
import com.ibm.icu.text.LocaleDisplayNames.DialectHandling;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class ULocale implements Serializable {
   private static final long serialVersionUID = 3715177670352309217L;
   public static final ULocale ENGLISH = new ULocale("en", Locale.ENGLISH);
   public static final ULocale FRENCH = new ULocale("fr", Locale.FRENCH);
   public static final ULocale GERMAN = new ULocale("de", Locale.GERMAN);
   public static final ULocale ITALIAN = new ULocale("it", Locale.ITALIAN);
   public static final ULocale JAPANESE = new ULocale("ja", Locale.JAPANESE);
   public static final ULocale KOREAN = new ULocale("ko", Locale.KOREAN);
   public static final ULocale CHINESE = new ULocale("zh", Locale.CHINESE);
   public static final ULocale SIMPLIFIED_CHINESE = new ULocale("zh_Hans", Locale.CHINESE);
   public static final ULocale TRADITIONAL_CHINESE = new ULocale("zh_Hant", Locale.CHINESE);
   public static final ULocale FRANCE = new ULocale("fr_FR", Locale.FRANCE);
   public static final ULocale GERMANY = new ULocale("de_DE", Locale.GERMANY);
   public static final ULocale ITALY = new ULocale("it_IT", Locale.ITALY);
   public static final ULocale JAPAN = new ULocale("ja_JP", Locale.JAPAN);
   public static final ULocale KOREA = new ULocale("ko_KR", Locale.KOREA);
   public static final ULocale CHINA = new ULocale("zh_Hans_CN", Locale.CHINA);
   public static final ULocale PRC = CHINA;
   public static final ULocale TAIWAN = new ULocale("zh_Hant_TW", Locale.TAIWAN);
   public static final ULocale UK = new ULocale("en_GB", Locale.UK);
   public static final ULocale US = new ULocale("en_US", Locale.US);
   public static final ULocale CANADA = new ULocale("en_CA", Locale.CANADA);
   public static final ULocale CANADA_FRENCH = new ULocale("fr_CA", Locale.CANADA_FRENCH);
   private static final String EMPTY_STRING = "";
   private static final char UNDERSCORE = '_';
   private static final Locale EMPTY_LOCALE = new Locale("", "");
   private static final String LOCALE_ATTRIBUTE_KEY = "attribute";
   public static final ULocale ROOT = new ULocale("", EMPTY_LOCALE);
   private static final SimpleCache<Locale, ULocale> CACHE = new SimpleCache();
   private transient volatile Locale locale;
   private String localeID;
   private transient volatile BaseLocale baseLocale;
   private transient volatile LocaleExtensions extensions;
   private static String[][] CANONICALIZE_MAP;
   private static String[][] variantsToKeywords;
   private static ICUCache<String, String> nameCache = new SimpleCache();
   private static Locale defaultLocale = Locale.getDefault();
   private static ULocale defaultULocale = forLocale(defaultLocale);
   private static Locale[] defaultCategoryLocales = new Locale[ULocale.Category.values().length];
   private static ULocale[] defaultCategoryULocales = new ULocale[ULocale.Category.values().length];
   public static ULocale.Type ACTUAL_LOCALE;
   public static ULocale.Type VALID_LOCALE;
   private static final String UNDEFINED_LANGUAGE = "und";
   private static final String UNDEFINED_SCRIPT = "Zzzz";
   private static final String UNDEFINED_REGION = "ZZ";
   public static final char PRIVATE_USE_EXTENSION = 'x';
   public static final char UNICODE_LOCALE_EXTENSION = 'u';

   private static void initCANONICALIZE_MAP() {
      if (CANONICALIZE_MAP == null) {
         String[][] var0 = new String[][]{
            {"C", "en_US_POSIX", null, null},
            {"art_LOJBAN", "jbo", null, null},
            {"az_AZ_CYRL", "az_Cyrl_AZ", null, null},
            {"az_AZ_LATN", "az_Latn_AZ", null, null},
            {"ca_ES_PREEURO", "ca_ES", "currency", "ESP"},
            {"cel_GAULISH", "cel__GAULISH", null, null},
            {"de_1901", "de__1901", null, null},
            {"de_1906", "de__1906", null, null},
            {"de__PHONEBOOK", "de", "collation", "phonebook"},
            {"de_AT_PREEURO", "de_AT", "currency", "ATS"},
            {"de_DE_PREEURO", "de_DE", "currency", "DEM"},
            {"de_LU_PREEURO", "de_LU", "currency", "EUR"},
            {"el_GR_PREEURO", "el_GR", "currency", "GRD"},
            {"en_BOONT", "en__BOONT", null, null},
            {"en_SCOUSE", "en__SCOUSE", null, null},
            {"en_BE_PREEURO", "en_BE", "currency", "BEF"},
            {"en_IE_PREEURO", "en_IE", "currency", "IEP"},
            {"es__TRADITIONAL", "es", "collation", "traditional"},
            {"es_ES_PREEURO", "es_ES", "currency", "ESP"},
            {"eu_ES_PREEURO", "eu_ES", "currency", "ESP"},
            {"fi_FI_PREEURO", "fi_FI", "currency", "FIM"},
            {"fr_BE_PREEURO", "fr_BE", "currency", "BEF"},
            {"fr_FR_PREEURO", "fr_FR", "currency", "FRF"},
            {"fr_LU_PREEURO", "fr_LU", "currency", "LUF"},
            {"ga_IE_PREEURO", "ga_IE", "currency", "IEP"},
            {"gl_ES_PREEURO", "gl_ES", "currency", "ESP"},
            {"hi__DIRECT", "hi", "collation", "direct"},
            {"it_IT_PREEURO", "it_IT", "currency", "ITL"},
            {"ja_JP_TRADITIONAL", "ja_JP", "calendar", "japanese"},
            {"nl_BE_PREEURO", "nl_BE", "currency", "BEF"},
            {"nl_NL_PREEURO", "nl_NL", "currency", "NLG"},
            {"pt_PT_PREEURO", "pt_PT", "currency", "PTE"},
            {"sl_ROZAJ", "sl__ROZAJ", null, null},
            {"sr_SP_CYRL", "sr_Cyrl_RS", null, null},
            {"sr_SP_LATN", "sr_Latn_RS", null, null},
            {"sr_YU_CYRILLIC", "sr_Cyrl_RS", null, null},
            {"th_TH_TRADITIONAL", "th_TH", "calendar", "buddhist"},
            {"uz_UZ_CYRILLIC", "uz_Cyrl_UZ", null, null},
            {"uz_UZ_CYRL", "uz_Cyrl_UZ", null, null},
            {"uz_UZ_LATN", "uz_Latn_UZ", null, null},
            {"zh_CHS", "zh_Hans", null, null},
            {"zh_CHT", "zh_Hant", null, null},
            {"zh_GAN", "zh__GAN", null, null},
            {"zh_GUOYU", "zh", null, null},
            {"zh_HAKKA", "zh__HAKKA", null, null},
            {"zh_MIN", "zh__MIN", null, null},
            {"zh_MIN_NAN", "zh__MINNAN", null, null},
            {"zh_WUU", "zh__WUU", null, null},
            {"zh_XIANG", "zh__XIANG", null, null},
            {"zh_YUE", "zh__YUE", null, null}
         };
         synchronized (ULocale.class) {
            if (CANONICALIZE_MAP == null) {
               CANONICALIZE_MAP = var0;
            }
         }
      }

      if (variantsToKeywords == null) {
         String[][] var6 = new String[][]{{"EURO", "currency", "EUR"}, {"PINYIN", "collation", "pinyin"}, {"STROKE", "collation", "stroke"}};
         synchronized (ULocale.class) {
            if (variantsToKeywords == null) {
               variantsToKeywords = var6;
            }
         }
      }
   }

   private ULocale(String var1, Locale var2) {
      this.localeID = var1;
      this.locale = var2;
   }

   private ULocale(Locale var1) {
      this.localeID = getName(forLocale(var1).toString());
      this.locale = var1;
   }

   public static ULocale forLocale(Locale var0) {
      if (var0 == null) {
         return null;
      } else {
         ULocale var1 = (ULocale)CACHE.get(var0);
         if (var1 == null) {
            var1 = ULocale.JDKLocaleHelper.toULocale(var0);
            CACHE.put(var0, var1);
         }

         return var1;
      }
   }

   public ULocale(String var1) {
      this.localeID = getName(var1);
   }

   public ULocale(String var1, String var2) {
      this(var1, var2, null);
   }

   public ULocale(String var1, String var2, String var3) {
      this.localeID = getName(lscvToID(var1, var2, var3, ""));
   }

   public static ULocale createCanonical(String var0) {
      return new ULocale(canonicalize(var0), (Locale)null);
   }

   private static String lscvToID(String var0, String var1, String var2, String var3) {
      StringBuilder var4 = new StringBuilder();
      if (var0 != null && var0.length() > 0) {
         var4.append(var0);
      }

      if (var1 != null && var1.length() > 0) {
         var4.append('_');
         var4.append(var1);
      }

      if (var2 != null && var2.length() > 0) {
         var4.append('_');
         var4.append(var2);
      }

      if (var3 != null && var3.length() > 0) {
         if (var2 == null || var2.length() == 0) {
            var4.append('_');
         }

         var4.append('_');
         var4.append(var3);
      }

      return var4.toString();
   }

   public Locale toLocale() {
      if (this.locale == null) {
         this.locale = ULocale.JDKLocaleHelper.toLocale(this);
      }

      return this.locale;
   }

   public static ULocale getDefault() {
      synchronized (ULocale.class) {
         if (defaultULocale == null) {
            return ROOT;
         } else {
            Locale var1 = Locale.getDefault();
            if (!defaultLocale.equals(var1)) {
               defaultLocale = var1;
               defaultULocale = forLocale(var1);
               if (!ULocale.JDKLocaleHelper.isJava7orNewer()) {
                  for (ULocale.Category var5 : ULocale.Category.values()) {
                     int var6 = var5.ordinal();
                     defaultCategoryLocales[var6] = var1;
                     defaultCategoryULocales[var6] = forLocale(var1);
                  }
               }
            }

            return defaultULocale;
         }
      }
   }

   public static synchronized void setDefault(ULocale var0) {
      defaultLocale = var0.toLocale();
      Locale.setDefault(defaultLocale);
      defaultULocale = var0;

      for (ULocale.Category var4 : ULocale.Category.values()) {
         setDefault(var4, var0);
      }
   }

   public static ULocale getDefault(ULocale.Category var0) {
      synchronized (ULocale.class) {
         int var2 = var0.ordinal();
         if (defaultCategoryULocales[var2] == null) {
            return ROOT;
         } else {
            if (ULocale.JDKLocaleHelper.isJava7orNewer()) {
               Locale var3 = ULocale.JDKLocaleHelper.getDefault(var0);
               if (!defaultCategoryLocales[var2].equals(var3)) {
                  defaultCategoryLocales[var2] = var3;
                  defaultCategoryULocales[var2] = forLocale(var3);
               }
            } else {
               Locale var11 = Locale.getDefault();
               if (!defaultLocale.equals(var11)) {
                  defaultLocale = var11;
                  defaultULocale = forLocale(var11);

                  for (ULocale.Category var7 : ULocale.Category.values()) {
                     int var8 = var7.ordinal();
                     defaultCategoryLocales[var8] = var11;
                     defaultCategoryULocales[var8] = forLocale(var11);
                  }
               }
            }

            return defaultCategoryULocales[var2];
         }
      }
   }

   public static synchronized void setDefault(ULocale.Category var0, ULocale var1) {
      Locale var2 = var1.toLocale();
      int var3 = var0.ordinal();
      defaultCategoryULocales[var3] = var1;
      defaultCategoryLocales[var3] = var2;
      ULocale.JDKLocaleHelper.setDefault(var0, var2);
   }

   @Override
   public Object clone() {
      return this;
   }

   @Override
   public int hashCode() {
      return this.localeID.hashCode();
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         return var1 instanceof ULocale ? this.localeID.equals(((ULocale)var1).localeID) : false;
      }
   }

   public static ULocale[] getAvailableLocales() {
      return ICUResourceBundle.getAvailableULocales();
   }

   public static String[] getISOCountries() {
      return LocaleIDs.getISOCountries();
   }

   public static String[] getISOLanguages() {
      return LocaleIDs.getISOLanguages();
   }

   public String getLanguage() {
      return getLanguage(this.localeID);
   }

   public static String getLanguage(String var0) {
      return new LocaleIDParser(var0).getLanguage();
   }

   public String getScript() {
      return getScript(this.localeID);
   }

   public static String getScript(String var0) {
      return new LocaleIDParser(var0).getScript();
   }

   public String getCountry() {
      return getCountry(this.localeID);
   }

   public static String getCountry(String var0) {
      return new LocaleIDParser(var0).getCountry();
   }

   public String getVariant() {
      return getVariant(this.localeID);
   }

   public static String getVariant(String var0) {
      return new LocaleIDParser(var0).getVariant();
   }

   public static String getFallback(String var0) {
      return getFallbackString(getName(var0));
   }

   public ULocale getFallback() {
      return this.localeID.length() != 0 && this.localeID.charAt(0) != '@' ? new ULocale(getFallbackString(this.localeID), (Locale)null) : null;
   }

   private static String getFallbackString(String var0) {
      int var1 = var0.indexOf(64);
      if (var1 == -1) {
         var1 = var0.length();
      }

      int var2 = var0.lastIndexOf(95, var1);
      if (var2 == -1) {
         var2 = 0;
      } else {
         while (var2 > 0 && var0.charAt(var2 - 1) == '_') {
            var2--;
         }
      }

      return var0.substring(0, var2) + var0.substring(var1);
   }

   public String getBaseName() {
      return getBaseName(this.localeID);
   }

   public static String getBaseName(String var0) {
      return var0.indexOf(64) == -1 ? var0 : new LocaleIDParser(var0).getBaseName();
   }

   public String getName() {
      return this.localeID;
   }

   private static int getShortestSubtagLength(String var0) {
      int var1 = var0.length();
      int var2 = var1;
      boolean var3 = true;
      int var4 = 0;

      for (int var5 = 0; var5 < var1; var5++) {
         if (var0.charAt(var5) != '_' && var0.charAt(var5) != '-') {
            if (var3) {
               var3 = false;
               var4 = 0;
            }

            var4++;
         } else {
            if (var4 != 0 && var4 < var2) {
               var2 = var4;
            }

            var3 = true;
         }
      }

      return var2;
   }

   public static String getName(String var0) {
      String var1;
      if (var0 != null && !var0.contains("@") && getShortestSubtagLength(var0) == 1) {
         var1 = forLanguageTag(var0).getName();
         if (var1.length() == 0) {
            var1 = var0;
         }
      } else {
         var1 = var0;
      }

      String var2 = (String)nameCache.get(var1);
      if (var2 == null) {
         var2 = new LocaleIDParser(var1).getName();
         nameCache.put(var1, var2);
      }

      return var2;
   }

   @Override
   public String toString() {
      return this.localeID;
   }

   public Iterator<String> getKeywords() {
      return getKeywords(this.localeID);
   }

   public static Iterator<String> getKeywords(String var0) {
      return new LocaleIDParser(var0).getKeywords();
   }

   public String getKeywordValue(String var1) {
      return getKeywordValue(this.localeID, var1);
   }

   public static String getKeywordValue(String var0, String var1) {
      return new LocaleIDParser(var0).getKeywordValue(var1);
   }

   public static String canonicalize(String var0) {
      LocaleIDParser var1 = new LocaleIDParser(var0, true);
      String var2 = var1.getBaseName();
      boolean var3 = false;
      if (var0.equals("")) {
         return "";
      } else {
         initCANONICALIZE_MAP();

         for (int var4 = 0; var4 < variantsToKeywords.length; var4++) {
            String[] var5 = variantsToKeywords[var4];
            int var6 = var2.lastIndexOf("_" + var5[0]);
            if (var6 > -1) {
               var3 = true;
               var2 = var2.substring(0, var6);
               if (var2.endsWith("_")) {
                  var2 = var2.substring(0, --var6);
               }

               var1.setBaseName(var2);
               var1.defaultKeywordValue(var5[1], var5[2]);
               break;
            }
         }

         for (int var7 = 0; var7 < CANONICALIZE_MAP.length; var7++) {
            if (CANONICALIZE_MAP[var7][0].equals(var2)) {
               var3 = true;
               String[] var8 = CANONICALIZE_MAP[var7];
               var1.setBaseName(var8[1]);
               if (var8[2] != null) {
                  var1.defaultKeywordValue(var8[2], var8[3]);
               }
               break;
            }
         }

         if (!var3 && var1.getLanguage().equals("nb") && var1.getVariant().equals("NY")) {
            var1.setBaseName(lscvToID("nn", var1.getScript(), var1.getCountry(), null));
         }

         return var1.getName();
      }
   }

   public ULocale setKeywordValue(String var1, String var2) {
      return new ULocale(setKeywordValue(this.localeID, var1, var2), (Locale)null);
   }

   public static String setKeywordValue(String var0, String var1, String var2) {
      LocaleIDParser var3 = new LocaleIDParser(var0);
      var3.setKeywordValue(var1, var2);
      return var3.getName();
   }

   public String getISO3Language() {
      return getISO3Language(this.localeID);
   }

   public static String getISO3Language(String var0) {
      return LocaleIDs.getISO3Language(getLanguage(var0));
   }

   public String getISO3Country() {
      return getISO3Country(this.localeID);
   }

   public static String getISO3Country(String var0) {
      return LocaleIDs.getISO3Country(getCountry(var0));
   }

   public String getDisplayLanguage() {
      return getDisplayLanguageInternal(this, getDefault(ULocale.Category.DISPLAY), false);
   }

   public String getDisplayLanguage(ULocale var1) {
      return getDisplayLanguageInternal(this, var1, false);
   }

   public static String getDisplayLanguage(String var0, String var1) {
      return getDisplayLanguageInternal(new ULocale(var0), new ULocale(var1), false);
   }

   public static String getDisplayLanguage(String var0, ULocale var1) {
      return getDisplayLanguageInternal(new ULocale(var0), var1, false);
   }

   public String getDisplayLanguageWithDialect() {
      return getDisplayLanguageInternal(this, getDefault(ULocale.Category.DISPLAY), true);
   }

   public String getDisplayLanguageWithDialect(ULocale var1) {
      return getDisplayLanguageInternal(this, var1, true);
   }

   public static String getDisplayLanguageWithDialect(String var0, String var1) {
      return getDisplayLanguageInternal(new ULocale(var0), new ULocale(var1), true);
   }

   public static String getDisplayLanguageWithDialect(String var0, ULocale var1) {
      return getDisplayLanguageInternal(new ULocale(var0), var1, true);
   }

   private static String getDisplayLanguageInternal(ULocale var0, ULocale var1, boolean var2) {
      String var3 = var2 ? var0.getBaseName() : var0.getLanguage();
      return LocaleDisplayNames.getInstance(var1).languageDisplayName(var3);
   }

   public String getDisplayScript() {
      return getDisplayScriptInternal(this, getDefault(ULocale.Category.DISPLAY));
   }

   /** @deprecated */
   public String getDisplayScriptInContext() {
      return getDisplayScriptInContextInternal(this, getDefault(ULocale.Category.DISPLAY));
   }

   public String getDisplayScript(ULocale var1) {
      return getDisplayScriptInternal(this, var1);
   }

   /** @deprecated */
   public String getDisplayScriptInContext(ULocale var1) {
      return getDisplayScriptInContextInternal(this, var1);
   }

   public static String getDisplayScript(String var0, String var1) {
      return getDisplayScriptInternal(new ULocale(var0), new ULocale(var1));
   }

   /** @deprecated */
   public static String getDisplayScriptInContext(String var0, String var1) {
      return getDisplayScriptInContextInternal(new ULocale(var0), new ULocale(var1));
   }

   public static String getDisplayScript(String var0, ULocale var1) {
      return getDisplayScriptInternal(new ULocale(var0), var1);
   }

   /** @deprecated */
   public static String getDisplayScriptInContext(String var0, ULocale var1) {
      return getDisplayScriptInContextInternal(new ULocale(var0), var1);
   }

   private static String getDisplayScriptInternal(ULocale var0, ULocale var1) {
      return LocaleDisplayNames.getInstance(var1).scriptDisplayName(var0.getScript());
   }

   private static String getDisplayScriptInContextInternal(ULocale var0, ULocale var1) {
      return LocaleDisplayNames.getInstance(var1).scriptDisplayNameInContext(var0.getScript());
   }

   public String getDisplayCountry() {
      return getDisplayCountryInternal(this, getDefault(ULocale.Category.DISPLAY));
   }

   public String getDisplayCountry(ULocale var1) {
      return getDisplayCountryInternal(this, var1);
   }

   public static String getDisplayCountry(String var0, String var1) {
      return getDisplayCountryInternal(new ULocale(var0), new ULocale(var1));
   }

   public static String getDisplayCountry(String var0, ULocale var1) {
      return getDisplayCountryInternal(new ULocale(var0), var1);
   }

   private static String getDisplayCountryInternal(ULocale var0, ULocale var1) {
      return LocaleDisplayNames.getInstance(var1).regionDisplayName(var0.getCountry());
   }

   public String getDisplayVariant() {
      return getDisplayVariantInternal(this, getDefault(ULocale.Category.DISPLAY));
   }

   public String getDisplayVariant(ULocale var1) {
      return getDisplayVariantInternal(this, var1);
   }

   public static String getDisplayVariant(String var0, String var1) {
      return getDisplayVariantInternal(new ULocale(var0), new ULocale(var1));
   }

   public static String getDisplayVariant(String var0, ULocale var1) {
      return getDisplayVariantInternal(new ULocale(var0), var1);
   }

   private static String getDisplayVariantInternal(ULocale var0, ULocale var1) {
      return LocaleDisplayNames.getInstance(var1).variantDisplayName(var0.getVariant());
   }

   public static String getDisplayKeyword(String var0) {
      return getDisplayKeywordInternal(var0, getDefault(ULocale.Category.DISPLAY));
   }

   public static String getDisplayKeyword(String var0, String var1) {
      return getDisplayKeywordInternal(var0, new ULocale(var1));
   }

   public static String getDisplayKeyword(String var0, ULocale var1) {
      return getDisplayKeywordInternal(var0, var1);
   }

   private static String getDisplayKeywordInternal(String var0, ULocale var1) {
      return LocaleDisplayNames.getInstance(var1).keyDisplayName(var0);
   }

   public String getDisplayKeywordValue(String var1) {
      return getDisplayKeywordValueInternal(this, var1, getDefault(ULocale.Category.DISPLAY));
   }

   public String getDisplayKeywordValue(String var1, ULocale var2) {
      return getDisplayKeywordValueInternal(this, var1, var2);
   }

   public static String getDisplayKeywordValue(String var0, String var1, String var2) {
      return getDisplayKeywordValueInternal(new ULocale(var0), var1, new ULocale(var2));
   }

   public static String getDisplayKeywordValue(String var0, String var1, ULocale var2) {
      return getDisplayKeywordValueInternal(new ULocale(var0), var1, var2);
   }

   private static String getDisplayKeywordValueInternal(ULocale var0, String var1, ULocale var2) {
      var1 = AsciiUtil.toLowerString(var1.trim());
      String var3 = var0.getKeywordValue(var1);
      return LocaleDisplayNames.getInstance(var2).keyValueDisplayName(var1, var3);
   }

   public String getDisplayName() {
      return getDisplayNameInternal(this, getDefault(ULocale.Category.DISPLAY));
   }

   public String getDisplayName(ULocale var1) {
      return getDisplayNameInternal(this, var1);
   }

   public static String getDisplayName(String var0, String var1) {
      return getDisplayNameInternal(new ULocale(var0), new ULocale(var1));
   }

   public static String getDisplayName(String var0, ULocale var1) {
      return getDisplayNameInternal(new ULocale(var0), var1);
   }

   private static String getDisplayNameInternal(ULocale var0, ULocale var1) {
      return LocaleDisplayNames.getInstance(var1).localeDisplayName(var0);
   }

   public String getDisplayNameWithDialect() {
      return getDisplayNameWithDialectInternal(this, getDefault(ULocale.Category.DISPLAY));
   }

   public String getDisplayNameWithDialect(ULocale var1) {
      return getDisplayNameWithDialectInternal(this, var1);
   }

   public static String getDisplayNameWithDialect(String var0, String var1) {
      return getDisplayNameWithDialectInternal(new ULocale(var0), new ULocale(var1));
   }

   public static String getDisplayNameWithDialect(String var0, ULocale var1) {
      return getDisplayNameWithDialectInternal(new ULocale(var0), var1);
   }

   private static String getDisplayNameWithDialectInternal(ULocale var0, ULocale var1) {
      return LocaleDisplayNames.getInstance(var1, DialectHandling.DIALECT_NAMES).localeDisplayName(var0);
   }

   public String getCharacterOrientation() {
      return ICUResourceTableAccess.getTableString("com/ibm/icu/impl/data/icudt51b", this, "layout", "characters");
   }

   public String getLineOrientation() {
      return ICUResourceTableAccess.getTableString("com/ibm/icu/impl/data/icudt51b", this, "layout", "lines");
   }

   public static ULocale acceptLanguage(String var0, ULocale[] var1, boolean[] var2) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         Object var3 = null;

         try {
            var3 = parseAcceptLanguage(var0, true);
         } catch (ParseException var5) {
            var3 = null;
         }

         return var3 == null ? null : acceptLanguage((ULocale[])var3, var1, var2);
      }
   }

   public static ULocale acceptLanguage(ULocale[] var0, ULocale[] var1, boolean[] var2) {
      if (var2 != null) {
         var2[0] = true;
      }

      for (int var3 = 0; var3 < var0.length; var3++) {
         ULocale var5 = var0[var3];

         do {
            for (int var4 = 0; var4 < var1.length; var4++) {
               if (var1[var4].equals(var5)) {
                  if (var2 != null) {
                     var2[0] = false;
                  }

                  return var1[var4];
               }

               if (var5.getScript().length() == 0
                  && var1[var4].getScript().length() > 0
                  && var1[var4].getLanguage().equals(var5.getLanguage())
                  && var1[var4].getCountry().equals(var5.getCountry())
                  && var1[var4].getVariant().equals(var5.getVariant())) {
                  ULocale var7 = minimizeSubtags(var1[var4]);
                  if (var7.getScript().length() == 0) {
                     if (var2 != null) {
                        var2[0] = false;
                     }

                     return var5;
                  }
               }
            }

            Locale var9 = var5.toLocale();
            Locale var8 = LocaleUtility.fallback(var9);
            if (var8 != null) {
               var5 = new ULocale(var8);
            } else {
               Object var11 = null;
            }

            Object var6 = null;
         } while (var5 == null);
      }

      return null;
   }

   public static ULocale acceptLanguage(String var0, boolean[] var1) {
      return acceptLanguage(var0, getAvailableLocales(), var1);
   }

   public static ULocale acceptLanguage(ULocale[] var0, boolean[] var1) {
      return acceptLanguage(var0, getAvailableLocales(), var1);
   }

   static ULocale[] parseAcceptLanguage(String var0, boolean var1) throws ParseException {
      TreeMap var2 = new TreeMap();
      StringBuilder var3 = new StringBuilder();
      StringBuilder var4 = new StringBuilder();
      byte var5 = 0;
      var0 = var0 + ",";
      boolean var7 = false;
      boolean var8 = false;

      int var6;
      for (var6 = 0; var6 < var0.length(); var6++) {
         boolean var9 = false;
         char var10 = var0.charAt(var6);
         switch (var5) {
            case 0:
               if (('A' > var10 || var10 > 'Z') && ('a' > var10 || var10 > 'z')) {
                  if (var10 == '*') {
                     var3.append(var10);
                     var5 = 2;
                  } else if (var10 != ' ' && var10 != '\t') {
                     var5 = -1;
                  }
               } else {
                  var3.append(var10);
                  var5 = 1;
                  var7 = false;
               }
               break;
            case 1:
               if (('A' > var10 || var10 > 'Z') && ('a' > var10 || var10 > 'z')) {
                  if (var10 == '-') {
                     var7 = true;
                     var3.append(var10);
                  } else if (var10 == '_') {
                     if (var1) {
                        var7 = true;
                        var3.append(var10);
                     } else {
                        var5 = -1;
                     }
                  } else if ('0' <= var10 && var10 <= '9') {
                     if (var7) {
                        var3.append(var10);
                     } else {
                        var5 = -1;
                     }
                  } else if (var10 == ',') {
                     var9 = true;
                  } else if (var10 == ' ' || var10 == '\t') {
                     var5 = 3;
                  } else if (var10 == ';') {
                     var5 = 4;
                  } else {
                     var5 = -1;
                  }
               } else {
                  var3.append(var10);
               }
               break;
            case 2:
               if (var10 == ',') {
                  var9 = true;
               } else if (var10 == ' ' || var10 == '\t') {
                  var5 = 3;
               } else if (var10 == ';') {
                  var5 = 4;
               } else {
                  var5 = -1;
               }
               break;
            case 3:
               if (var10 == ',') {
                  var9 = true;
               } else if (var10 == ';') {
                  var5 = 4;
               } else if (var10 != ' ' && var10 != '\t') {
                  var5 = -1;
               }
               break;
            case 4:
               if (var10 == 'q') {
                  var5 = 5;
               } else if (var10 != ' ' && var10 != '\t') {
                  var5 = -1;
               }
               break;
            case 5:
               if (var10 == '=') {
                  var5 = 6;
               } else if (var10 != ' ' && var10 != '\t') {
                  var5 = -1;
               }
               break;
            case 6:
               if (var10 == '0') {
                  var8 = false;
                  var4.append(var10);
                  var5 = 7;
               } else if (var10 == '1') {
                  var4.append(var10);
                  var5 = 7;
               } else if (var10 == '.') {
                  if (var1) {
                     var4.append(var10);
                     var5 = 8;
                  } else {
                     var5 = -1;
                  }
               } else if (var10 != ' ' && var10 != '\t') {
                  var5 = -1;
               }
               break;
            case 7:
               if (var10 == '.') {
                  var4.append(var10);
                  var5 = 8;
               } else if (var10 == ',') {
                  var9 = true;
               } else if (var10 != ' ' && var10 != '\t') {
                  var5 = -1;
               } else {
                  var5 = 10;
               }
               break;
            case 8:
               if ('0' > var10 && var10 > '9') {
                  var5 = -1;
               } else if (var8 && var10 != '0' && !var1) {
                  var5 = -1;
               } else {
                  var4.append(var10);
                  var5 = 9;
               }
               break;
            case 9:
               if ('0' <= var10 && var10 <= '9') {
                  if (var8 && var10 != '0') {
                     var5 = -1;
                  } else {
                     var4.append(var10);
                  }
               } else if (var10 == ',') {
                  var9 = true;
               } else if (var10 != ' ' && var10 != '\t') {
                  var5 = -1;
               } else {
                  var5 = 10;
               }
               break;
            case 10:
               if (var10 == ',') {
                  var9 = true;
               } else if (var10 != ' ' && var10 != '\t') {
                  var5 = -1;
               }
         }

         if (var5 == -1) {
            throw new ParseException("Invalid Accept-Language", var6);
         }

         if (var9) {
            double var11 = 1.0;
            if (var4.length() != 0) {
               try {
                  var11 = Double.parseDouble(var4.toString());
               } catch (NumberFormatException var15) {
                  var11 = 1.0;
               }

               if (var11 > 1.0) {
                  var11 = 1.0;
               }
            }

            if (var3.charAt(0) != '*') {
               int var13 = var2.size();

               class ULocaleAcceptLanguageQ implements Comparable<ULocaleAcceptLanguageQ> {
                  private double q;
                  private double serial;

                  public ULocaleAcceptLanguageQ(double var1, int var3) {
                     this.q = var1;
                     this.serial = var3;
                  }

                  public int compareTo(ULocaleAcceptLanguageQ var1) {
                     if (this.q > var1.q) {
                        return -1;
                     } else if (this.q < var1.q) {
                        return 1;
                     } else if (this.serial < var1.serial) {
                        return -1;
                     } else {
                        return this.serial > var1.serial ? 1 : 0;
                     }
                  }
               }

               ULocaleAcceptLanguageQ var14 = new ULocaleAcceptLanguageQ(var11, var13);
               var2.put(var14, new ULocale(canonicalize(var3.toString())));
            }

            var3.setLength(0);
            var4.setLength(0);
            var5 = 0;
         }
      }

      if (var5 != 0) {
         throw new ParseException("Invalid AcceptlLanguage", var6);
      } else {
         return var2.values().toArray(new ULocale[var2.size()]);
      }
   }

   public static ULocale addLikelySubtags(ULocale var0) {
      String[] var1 = new String[3];
      String var2 = null;
      int var3 = parseTagString(var0.localeID, var1);
      if (var3 < var0.localeID.length()) {
         var2 = var0.localeID.substring(var3);
      }

      String var4 = createLikelySubtagsString(var1[0], var1[1], var1[2], var2);
      return var4 == null ? var0 : new ULocale(var4);
   }

   public static ULocale minimizeSubtags(ULocale var0) {
      String[] var1 = new String[3];
      int var2 = parseTagString(var0.localeID, var1);
      String var3 = var1[0];
      String var4 = var1[1];
      String var5 = var1[2];
      String var6 = null;
      if (var2 < var0.localeID.length()) {
         var6 = var0.localeID.substring(var2);
      }

      String var7 = createLikelySubtagsString(var3, var4, var5, null);
      if (isEmptyString(var7)) {
         return var0;
      } else {
         String var8 = createLikelySubtagsString(var3, null, null, null);
         if (var8.equals(var7)) {
            String var13 = createTagString(var3, null, null, var6);
            return new ULocale(var13);
         } else {
            if (var5.length() != 0) {
               var8 = createLikelySubtagsString(var3, null, var5, null);
               if (var8.equals(var7)) {
                  String var12 = createTagString(var3, null, var5, var6);
                  return new ULocale(var12);
               }
            }

            if (var5.length() != 0 && var4.length() != 0) {
               var8 = createLikelySubtagsString(var3, var4, null, null);
               if (var8.equals(var7)) {
                  String var9 = createTagString(var3, var4, null, var6);
                  return new ULocale(var9);
               }
            }

            return var0;
         }
      }
   }

   private static boolean isEmptyString(String var0) {
      return var0 == null || var0.length() == 0;
   }

   private static void appendTag(String var0, StringBuilder var1) {
      if (var1.length() != 0) {
         var1.append('_');
      }

      var1.append(var0);
   }

   private static String createTagString(String var0, String var1, String var2, String var3, String var4) {
      LocaleIDParser var5 = null;
      boolean var6 = false;
      StringBuilder var7 = new StringBuilder();
      if (!isEmptyString(var0)) {
         appendTag(var0, var7);
      } else if (isEmptyString(var4)) {
         appendTag("und", var7);
      } else {
         var5 = new LocaleIDParser(var4);
         String var8 = var5.getLanguage();
         appendTag(!isEmptyString(var8) ? var8 : "und", var7);
      }

      if (!isEmptyString(var1)) {
         appendTag(var1, var7);
      } else if (!isEmptyString(var4)) {
         if (var5 == null) {
            var5 = new LocaleIDParser(var4);
         }

         String var9 = var5.getScript();
         if (!isEmptyString(var9)) {
            appendTag(var9, var7);
         }
      }

      if (!isEmptyString(var2)) {
         appendTag(var2, var7);
         var6 = true;
      } else if (!isEmptyString(var4)) {
         if (var5 == null) {
            var5 = new LocaleIDParser(var4);
         }

         String var10 = var5.getCountry();
         if (!isEmptyString(var10)) {
            appendTag(var10, var7);
            var6 = true;
         }
      }

      if (var3 != null && var3.length() > 1) {
         byte var11 = 0;
         if (var3.charAt(0) == '_') {
            if (var3.charAt(1) == '_') {
               var11 = 2;
            }
         } else {
            var11 = 1;
         }

         if (var6) {
            if (var11 == 2) {
               var7.append(var3.substring(1));
            } else {
               var7.append(var3);
            }
         } else {
            if (var11 == 1) {
               var7.append('_');
            }

            var7.append(var3);
         }
      }

      return var7.toString();
   }

   static String createTagString(String var0, String var1, String var2, String var3) {
      return createTagString(var0, var1, var2, var3, null);
   }

   private static int parseTagString(String var0, String[] var1) {
      LocaleIDParser var2 = new LocaleIDParser(var0);
      String var3 = var2.getLanguage();
      String var4 = var2.getScript();
      String var5 = var2.getCountry();
      if (isEmptyString(var3)) {
         var1[0] = "und";
      } else {
         var1[0] = var3;
      }

      if (var4.equals("Zzzz")) {
         var1[1] = "";
      } else {
         var1[1] = var4;
      }

      if (var5.equals("ZZ")) {
         var1[2] = "";
      } else {
         var1[2] = var5;
      }

      String var6 = var2.getVariant();
      if (!isEmptyString(var6)) {
         int var8 = var0.indexOf(var6);
         return var8 > 0 ? var8 - 1 : var8;
      } else {
         int var7 = var0.indexOf(64);
         return var7 == -1 ? var0.length() : var7;
      }
   }

   private static String lookupLikelySubtags(String var0) {
      UResourceBundle var1 = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "likelySubtags");

      try {
         return var1.getString(var0);
      } catch (MissingResourceException var3) {
         return null;
      }
   }

   private static String createLikelySubtagsString(String var0, String var1, String var2, String var3) {
      if (!isEmptyString(var1) && !isEmptyString(var2)) {
         String var4 = createTagString(var0, var1, var2, null);
         String var5 = lookupLikelySubtags(var4);
         if (var5 != null) {
            return createTagString(null, null, null, var3, var5);
         }
      }

      if (!isEmptyString(var1)) {
         String var6 = createTagString(var0, var1, null, null);
         String var9 = lookupLikelySubtags(var6);
         if (var9 != null) {
            return createTagString(null, null, var2, var3, var9);
         }
      }

      if (!isEmptyString(var2)) {
         String var7 = createTagString(var0, null, var2, null);
         String var10 = lookupLikelySubtags(var7);
         if (var10 != null) {
            return createTagString(null, var1, null, var3, var10);
         }
      }

      String var8 = createTagString(var0, null, null, null);
      String var11 = lookupLikelySubtags(var8);
      return var11 != null ? createTagString(null, var1, var2, var3, var11) : null;
   }

   public String getExtension(char var1) {
      if (!LocaleExtensions.isValidKey(var1)) {
         throw new IllegalArgumentException("Invalid extension key: " + var1);
      } else {
         return this.extensions().getExtensionValue(var1);
      }
   }

   public Set<Character> getExtensionKeys() {
      return this.extensions().getKeys();
   }

   public Set<String> getUnicodeLocaleAttributes() {
      return this.extensions().getUnicodeLocaleAttributes();
   }

   public String getUnicodeLocaleType(String var1) {
      if (!LocaleExtensions.isValidUnicodeLocaleKey(var1)) {
         throw new IllegalArgumentException("Invalid Unicode locale key: " + var1);
      } else {
         return this.extensions().getUnicodeLocaleType(var1);
      }
   }

   public Set<String> getUnicodeLocaleKeys() {
      return this.extensions().getUnicodeLocaleKeys();
   }

   public String toLanguageTag() {
      BaseLocale var1 = this.base();
      LocaleExtensions var2 = this.extensions();
      if (var1.getVariant().equalsIgnoreCase("POSIX")) {
         var1 = BaseLocale.getInstance(var1.getLanguage(), var1.getScript(), var1.getRegion(), "");
         if (var2.getUnicodeLocaleType("va") == null) {
            InternalLocaleBuilder var3 = new InternalLocaleBuilder();

            try {
               var3.setLocale(BaseLocale.ROOT, var2);
               var3.setUnicodeLocaleKeyword("va", "posix");
               var2 = var3.getLocaleExtensions();
            } catch (LocaleSyntaxException var9) {
               throw new RuntimeException(var9);
            }
         }
      }

      LanguageTag var10 = LanguageTag.parseLocale(var1, var2);
      StringBuilder var4 = new StringBuilder();
      String var5 = var10.getLanguage();
      if (var5.length() > 0) {
         var4.append(LanguageTag.canonicalizeLanguage(var5));
      }

      var5 = var10.getScript();
      if (var5.length() > 0) {
         var4.append("-");
         var4.append(LanguageTag.canonicalizeScript(var5));
      }

      var5 = var10.getRegion();
      if (var5.length() > 0) {
         var4.append("-");
         var4.append(LanguageTag.canonicalizeRegion(var5));
      }

      for (String var8 : var10.getVariants()) {
         var4.append("-");
         var4.append(LanguageTag.canonicalizeVariant(var8));
      }

      for (String var16 : var10.getExtensions()) {
         var4.append("-");
         var4.append(LanguageTag.canonicalizeExtension(var16));
      }

      var5 = var10.getPrivateuse();
      if (var5.length() > 0) {
         if (var4.length() > 0) {
            var4.append("-");
         }

         var4.append("x").append("-");
         var4.append(LanguageTag.canonicalizePrivateuse(var5));
      }

      return var4.toString();
   }

   public static ULocale forLanguageTag(String var0) {
      LanguageTag var1 = LanguageTag.parse(var0, null);
      InternalLocaleBuilder var2 = new InternalLocaleBuilder();
      var2.setLanguageTag(var1);
      return getInstance(var2.getBaseLocale(), var2.getLocaleExtensions());
   }

   private static ULocale getInstance(BaseLocale var0, LocaleExtensions var1) {
      String var2 = lscvToID(var0.getLanguage(), var0.getScript(), var0.getRegion(), var0.getVariant());
      Set var3 = var1.getKeys();
      if (!var3.isEmpty()) {
         TreeMap var4 = new TreeMap();

         for (Character var6 : var3) {
            Extension var7 = var1.getExtension(var6);
            if (var7 instanceof UnicodeLocaleExtension) {
               UnicodeLocaleExtension var8 = (UnicodeLocaleExtension)var7;

               for (String var11 : var8.getUnicodeLocaleKeys()) {
                  String var12 = var8.getUnicodeLocaleType(var11);
                  String var13 = bcp47ToLDMLKey(var11);
                  String var14 = bcp47ToLDMLType(var13, var12.length() == 0 ? "yes" : var12);
                  if (var13.equals("va") && var14.equals("posix") && var0.getVariant().length() == 0) {
                     var2 = var2 + "_POSIX";
                  } else {
                     var4.put(var13, var14);
                  }
               }

               Set var20 = var8.getUnicodeLocaleAttributes();
               if (var20.size() > 0) {
                  StringBuilder var21 = new StringBuilder();

                  for (String var23 : var20) {
                     if (var21.length() > 0) {
                        var21.append('-');
                     }

                     var21.append(var23);
                  }

                  var4.put("attribute", var21.toString());
               }
            } else {
               var4.put(String.valueOf(var6), var7.getValue());
            }
         }

         if (!var4.isEmpty()) {
            StringBuilder var15 = new StringBuilder(var2);
            var15.append("@");
            Set var16 = var4.entrySet();
            boolean var17 = false;

            for (Entry var19 : var16) {
               if (var17) {
                  var15.append(";");
               } else {
                  var17 = true;
               }

               var15.append((String)var19.getKey());
               var15.append("=");
               var15.append((String)var19.getValue());
            }

            var2 = var15.toString();
         }
      }

      return new ULocale(var2);
   }

   private BaseLocale base() {
      if (this.baseLocale == null) {
         String var1 = this.getLanguage();
         if (this.equals(ROOT)) {
            var1 = "";
         }

         this.baseLocale = BaseLocale.getInstance(var1, this.getScript(), this.getCountry(), this.getVariant());
      }

      return this.baseLocale;
   }

   private LocaleExtensions extensions() {
      if (this.extensions == null) {
         Iterator var1 = this.getKeywords();
         if (var1 == null) {
            this.extensions = LocaleExtensions.EMPTY_EXTENSIONS;
         } else {
            InternalLocaleBuilder var2 = new InternalLocaleBuilder();

            while (var1.hasNext()) {
               String var3 = (String)var1.next();
               if (var3.equals("attribute")) {
                  String[] var13 = this.getKeywordValue(var3).split("[-_]");

                  for (String var8 : var13) {
                     try {
                        var2.addUnicodeLocaleAttribute(var8);
                     } catch (LocaleSyntaxException var12) {
                     }
                  }
               } else if (var3.length() >= 2) {
                  String var4 = ldmlKeyToBCP47(var3);
                  String var5 = ldmlTypeToBCP47(var3, this.getKeywordValue(var3));
                  if (var4 != null && var5 != null) {
                     try {
                        var2.setUnicodeLocaleKeyword(var4, var5);
                     } catch (LocaleSyntaxException var11) {
                     }
                  }
               } else if (var3.length() == 1 && var3.charAt(0) != 'u') {
                  try {
                     var2.setExtension(var3.charAt(0), this.getKeywordValue(var3).replace("_", "-"));
                  } catch (LocaleSyntaxException var10) {
                  }
               }
            }

            this.extensions = var2.getLocaleExtensions();
         }
      }

      return this.extensions;
   }

   private static String ldmlKeyToBCP47(String var0) {
      UResourceBundle var1 = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
      UResourceBundle var2 = var1.get("keyMap");
      var0 = AsciiUtil.toLowerString(var0);
      String var3 = null;

      try {
         var3 = var2.getString(var0);
      } catch (MissingResourceException var5) {
      }

      if (var3 == null) {
         return var0.length() == 2 && LanguageTag.isExtensionSubtag(var0) ? var0 : null;
      } else {
         return var3;
      }
   }

   private static String bcp47ToLDMLKey(String var0) {
      UResourceBundle var1 = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
      UResourceBundle var2 = var1.get("keyMap");
      var0 = AsciiUtil.toLowerString(var0);
      String var3 = null;

      for (int var4 = 0; var4 < var2.getSize(); var4++) {
         UResourceBundle var5 = var2.get(var4);
         if (var0.equals(var5.getString())) {
            var3 = var5.getKey();
            break;
         }
      }

      return var3 == null ? var0 : var3;
   }

   private static String ldmlTypeToBCP47(String var0, String var1) {
      UResourceBundle var2 = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
      UResourceBundle var3 = var2.get("typeMap");
      var0 = AsciiUtil.toLowerString(var0);
      UResourceBundle var4 = null;
      String var5 = null;
      String var6 = var0.equals("timezone") ? var1.replace('/', ':') : var1;

      try {
         var4 = var3.get(var0);
         var5 = var4.getString(var6);
      } catch (MissingResourceException var10) {
      }

      if (var5 == null && var4 != null) {
         UResourceBundle var7 = var2.get("typeAlias");

         try {
            UResourceBundle var8 = var7.get(var0);
            var6 = var8.getString(var6);
            var5 = var4.getString(var6.replace('/', ':'));
         } catch (MissingResourceException var9) {
         }
      }

      if (var5 == null) {
         int var13 = var1.length();
         return var13 >= 3 && var13 <= 8 && LanguageTag.isExtensionSubtag(var1) ? var1 : null;
      } else {
         return var5;
      }
   }

   private static String bcp47ToLDMLType(String var0, String var1) {
      UResourceBundle var2 = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
      UResourceBundle var3 = var2.get("typeMap");
      var0 = AsciiUtil.toLowerString(var0);
      var1 = AsciiUtil.toLowerString(var1);
      String var4 = null;

      try {
         UResourceBundle var5 = var3.get(var0);

         for (int var6 = 0; var6 < var5.getSize(); var6++) {
            UResourceBundle var7 = var5.get(var6);
            if (var1.equals(var7.getString())) {
               var4 = var7.getKey();
               if (var0.equals("timezone")) {
                  var4 = var4.replace(':', '/');
               }
               break;
            }
         }
      } catch (MissingResourceException var8) {
      }

      return var4 == null ? var1 : var4;
   }

   static {
      if (ULocale.JDKLocaleHelper.isJava7orNewer()) {
         for (ULocale.Category var3 : ULocale.Category.values()) {
            int var4 = var3.ordinal();
            defaultCategoryLocales[var4] = ULocale.JDKLocaleHelper.getDefault(var3);
            defaultCategoryULocales[var4] = forLocale(defaultCategoryLocales[var4]);
         }
      } else {
         if (ULocale.JDKLocaleHelper.isOriginalDefaultLocale(defaultLocale)) {
            String var5 = ULocale.JDKLocaleHelper.getSystemProperty("user.script");
            if (var5 != null && LanguageTag.isScript(var5)) {
               BaseLocale var7 = defaultULocale.base();
               BaseLocale var9 = BaseLocale.getInstance(var7.getLanguage(), var5, var7.getRegion(), var7.getVariant());
               defaultULocale = getInstance(var9, defaultULocale.extensions());
            }
         }

         for (ULocale.Category var11 : ULocale.Category.values()) {
            int var12 = var11.ordinal();
            defaultCategoryLocales[var12] = defaultLocale;
            defaultCategoryULocales[var12] = defaultULocale;
         }
      }

      ACTUAL_LOCALE = new ULocale.Type();
      VALID_LOCALE = new ULocale.Type();
   }

   public static final class Builder {
      private final InternalLocaleBuilder _locbld = new InternalLocaleBuilder();

      public ULocale.Builder setLocale(ULocale var1) {
         try {
            this._locbld.setLocale(var1.base(), var1.extensions());
            return this;
         } catch (LocaleSyntaxException var3) {
            throw new IllformedLocaleException(var3.getMessage(), var3.getErrorIndex());
         }
      }

      public ULocale.Builder setLanguageTag(String var1) {
         ParseStatus var2 = new ParseStatus();
         LanguageTag var3 = LanguageTag.parse(var1, var2);
         if (var2.isError()) {
            throw new IllformedLocaleException(var2.getErrorMessage(), var2.getErrorIndex());
         } else {
            this._locbld.setLanguageTag(var3);
            return this;
         }
      }

      public ULocale.Builder setLanguage(String var1) {
         try {
            this._locbld.setLanguage(var1);
            return this;
         } catch (LocaleSyntaxException var3) {
            throw new IllformedLocaleException(var3.getMessage(), var3.getErrorIndex());
         }
      }

      public ULocale.Builder setScript(String var1) {
         try {
            this._locbld.setScript(var1);
            return this;
         } catch (LocaleSyntaxException var3) {
            throw new IllformedLocaleException(var3.getMessage(), var3.getErrorIndex());
         }
      }

      public ULocale.Builder setRegion(String var1) {
         try {
            this._locbld.setRegion(var1);
            return this;
         } catch (LocaleSyntaxException var3) {
            throw new IllformedLocaleException(var3.getMessage(), var3.getErrorIndex());
         }
      }

      public ULocale.Builder setVariant(String var1) {
         try {
            this._locbld.setVariant(var1);
            return this;
         } catch (LocaleSyntaxException var3) {
            throw new IllformedLocaleException(var3.getMessage(), var3.getErrorIndex());
         }
      }

      public ULocale.Builder setExtension(char var1, String var2) {
         try {
            this._locbld.setExtension(var1, var2);
            return this;
         } catch (LocaleSyntaxException var4) {
            throw new IllformedLocaleException(var4.getMessage(), var4.getErrorIndex());
         }
      }

      public ULocale.Builder setUnicodeLocaleKeyword(String var1, String var2) {
         try {
            this._locbld.setUnicodeLocaleKeyword(var1, var2);
            return this;
         } catch (LocaleSyntaxException var4) {
            throw new IllformedLocaleException(var4.getMessage(), var4.getErrorIndex());
         }
      }

      public ULocale.Builder addUnicodeLocaleAttribute(String var1) {
         try {
            this._locbld.addUnicodeLocaleAttribute(var1);
            return this;
         } catch (LocaleSyntaxException var3) {
            throw new IllformedLocaleException(var3.getMessage(), var3.getErrorIndex());
         }
      }

      public ULocale.Builder removeUnicodeLocaleAttribute(String var1) {
         try {
            this._locbld.removeUnicodeLocaleAttribute(var1);
            return this;
         } catch (LocaleSyntaxException var3) {
            throw new IllformedLocaleException(var3.getMessage(), var3.getErrorIndex());
         }
      }

      public ULocale.Builder clear() {
         this._locbld.clear();
         return this;
      }

      public ULocale.Builder clearExtensions() {
         this._locbld.clearExtensions();
         return this;
      }

      public ULocale build() {
         return ULocale.getInstance(this._locbld.getBaseLocale(), this._locbld.getLocaleExtensions());
      }
   }

   public static enum Category {
      DISPLAY,
      FORMAT;
   }

   private static final class JDKLocaleHelper {
      private static boolean isJava7orNewer = false;
      private static Method mGetScript;
      private static Method mGetExtensionKeys;
      private static Method mGetExtension;
      private static Method mGetUnicodeLocaleKeys;
      private static Method mGetUnicodeLocaleAttributes;
      private static Method mGetUnicodeLocaleType;
      private static Method mForLanguageTag;
      private static Method mGetDefault;
      private static Method mSetDefault;
      private static Object eDISPLAY;
      private static Object eFORMAT;
      private static final String[][] JAVA6_MAPDATA = new String[][]{
         {"ja_JP_JP", "ja_JP", "calendar", "japanese", "ja"}, {"no_NO_NY", "nn_NO", null, null, "nn"}, {"th_TH_TH", "th_TH", "numbers", "thai", "th"}
      };

      public static boolean isJava7orNewer() {
         return isJava7orNewer;
      }

      public static ULocale toULocale(Locale var0) {
         return isJava7orNewer ? toULocale7(var0) : toULocale6(var0);
      }

      public static Locale toLocale(ULocale var0) {
         return isJava7orNewer ? toLocale7(var0) : toLocale6(var0);
      }

      private static ULocale toULocale7(Locale var0) {
         String var1 = var0.getLanguage();
         String var2 = "";
         String var3 = var0.getCountry();
         String var4 = var0.getVariant();
         TreeSet var5 = null;
         TreeMap var6 = null;

         try {
            var2 = (String)mGetScript.invoke(var0, (Object[])null);
            Set var7 = (Set)mGetExtensionKeys.invoke(var0, (Object[])null);
            if (!var7.isEmpty()) {
               for (Character var9 : var7) {
                  if (var9 == 'u') {
                     Set var23 = (Set)mGetUnicodeLocaleAttributes.invoke(var0, (Object[])null);
                     if (!var23.isEmpty()) {
                        var5 = new TreeSet();

                        for (String var12 : var23) {
                           var5.add(var12);
                        }
                     }

                     for (String var13 : (Set)mGetUnicodeLocaleKeys.invoke(var0, (Object[])null)) {
                        String var14 = (String)mGetUnicodeLocaleType.invoke(var0, var13);
                        if (var14 != null) {
                           if (var13.equals("va")) {
                              var4 = var4.length() == 0 ? var14 : var14 + "_" + var4;
                           } else {
                              if (var6 == null) {
                                 var6 = new TreeMap();
                              }

                              var6.put(var13, var14);
                           }
                        }
                     }
                  } else {
                     String var10 = (String)mGetExtension.invoke(var0, var9);
                     if (var10 != null) {
                        if (var6 == null) {
                           var6 = new TreeMap();
                        }

                        var6.put(String.valueOf(var9), var10);
                     }
                  }
               }
            }
         } catch (IllegalAccessException var15) {
            throw new RuntimeException(var15);
         } catch (InvocationTargetException var16) {
            throw new RuntimeException(var16);
         }

         if (var1.equals("no") && var3.equals("NO") && var4.equals("NY")) {
            var1 = "nn";
            var4 = "";
         }

         StringBuilder var18 = new StringBuilder(var1);
         if (var2.length() > 0) {
            var18.append('_');
            var18.append(var2);
         }

         if (var3.length() > 0) {
            var18.append('_');
            var18.append(var3);
         }

         if (var4.length() > 0) {
            if (var3.length() == 0) {
               var18.append('_');
            }

            var18.append('_');
            var18.append(var4);
         }

         if (var5 != null) {
            StringBuilder var19 = new StringBuilder();

            for (String var24 : var5) {
               if (var19.length() != 0) {
                  var19.append('-');
               }

               var19.append(var24);
            }

            if (var6 == null) {
               var6 = new TreeMap();
            }

            var6.put("attribute", var19.toString());
         }

         if (var6 != null) {
            var18.append('@');
            boolean var20 = false;

            for (Entry var25 : var6.entrySet()) {
               String var27 = (String)var25.getKey();
               String var29 = (String)var25.getValue();
               if (var27.length() != 1) {
                  var27 = ULocale.bcp47ToLDMLKey(var27);
                  var29 = ULocale.bcp47ToLDMLType(var27, var29.length() == 0 ? "yes" : var29);
               }

               if (var20) {
                  var18.append(';');
               } else {
                  var20 = true;
               }

               var18.append(var27);
               var18.append('=');
               var18.append(var29);
            }
         }

         return new ULocale(ULocale.getName(var18.toString()), var0);
      }

      private static ULocale toULocale6(Locale var0) {
         ULocale var1 = null;
         String var2 = var0.toString();
         if (var2.length() == 0) {
            var1 = ULocale.ROOT;
         } else {
            for (int var3 = 0; var3 < JAVA6_MAPDATA.length; var3++) {
               if (JAVA6_MAPDATA[var3][0].equals(var2)) {
                  LocaleIDParser var4 = new LocaleIDParser(JAVA6_MAPDATA[var3][1]);
                  var4.setKeywordValue(JAVA6_MAPDATA[var3][2], JAVA6_MAPDATA[var3][3]);
                  var2 = var4.getName();
                  break;
               }
            }

            var1 = new ULocale(ULocale.getName(var2), var0);
         }

         return var1;
      }

      private static Locale toLocale7(ULocale var0) {
         Locale var1 = null;
         String var2 = var0.getName();
         if (var0.getScript().length() > 0 || var2.contains("@")) {
            String var3 = var0.toLanguageTag();
            var3 = AsciiUtil.toUpperString(var3);

            try {
               var1 = (Locale)mForLanguageTag.invoke(null, var3);
            } catch (IllegalAccessException var5) {
               throw new RuntimeException(var5);
            } catch (InvocationTargetException var6) {
               throw new RuntimeException(var6);
            }
         }

         if (var1 == null) {
            var1 = new Locale(var0.getLanguage(), var0.getCountry(), var0.getVariant());
         }

         return var1;
      }

      private static Locale toLocale6(ULocale var0) {
         String var1 = var0.getBaseName();

         for (int var2 = 0; var2 < JAVA6_MAPDATA.length; var2++) {
            if (var1.equals(JAVA6_MAPDATA[var2][1]) || var1.equals(JAVA6_MAPDATA[var2][4])) {
               if (JAVA6_MAPDATA[var2][2] == null) {
                  var1 = JAVA6_MAPDATA[var2][0];
                  break;
               }

               String var3 = var0.getKeywordValue(JAVA6_MAPDATA[var2][2]);
               if (var3 != null && var3.equals(JAVA6_MAPDATA[var2][3])) {
                  var1 = JAVA6_MAPDATA[var2][0];
                  break;
               }
            }
         }

         LocaleIDParser var4 = new LocaleIDParser(var1);
         String[] var5 = var4.getLanguageScriptCountryVariant();
         return new Locale(var5[0], var5[2], var5[3]);
      }

      public static Locale getDefault(ULocale.Category var0) {
         Locale var1 = Locale.getDefault();
         if (isJava7orNewer) {
            Object var2 = null;
            switch (var0) {
               case DISPLAY:
                  var2 = eDISPLAY;
                  break;
               case FORMAT:
                  var2 = eFORMAT;
            }

            if (var2 != null) {
               try {
                  var1 = (Locale)mGetDefault.invoke(null, var2);
               } catch (InvocationTargetException var4) {
               } catch (IllegalArgumentException var5) {
               } catch (IllegalAccessException var6) {
               }
            }
         }

         return var1;
      }

      public static void setDefault(ULocale.Category var0, Locale var1) {
         if (isJava7orNewer) {
            Object var2 = null;
            switch (var0) {
               case DISPLAY:
                  var2 = eDISPLAY;
                  break;
               case FORMAT:
                  var2 = eFORMAT;
            }

            if (var2 != null) {
               try {
                  mSetDefault.invoke(null, var2, var1);
               } catch (InvocationTargetException var4) {
               } catch (IllegalArgumentException var5) {
               } catch (IllegalAccessException var6) {
               }
            }
         }
      }

      public static boolean isOriginalDefaultLocale(Locale var0) {
         if (isJava7orNewer) {
            String var1 = "";

            try {
               var1 = (String)mGetScript.invoke(var0, (Object[])null);
            } catch (Exception var3) {
               return false;
            }

            return var0.getLanguage().equals(getSystemProperty("user.language"))
               && var0.getCountry().equals(getSystemProperty("user.country"))
               && var0.getVariant().equals(getSystemProperty("user.variant"))
               && var1.equals(getSystemProperty("user.script"));
         } else {
            return var0.getLanguage().equals(getSystemProperty("user.language"))
               && var0.getCountry().equals(getSystemProperty("user.country"))
               && var0.getVariant().equals(getSystemProperty("user.variant"));
         }
      }

      public static String getSystemProperty(String var0) {
         String var1 = null;
         final String var2 = var0;
         if (System.getSecurityManager() != null) {
            try {
               var1 = AccessController.doPrivileged(new PrivilegedAction<String>() {
                  public String run() {
                     return System.getProperty(var2);
                  }
               });
            } catch (AccessControlException var4) {
            }
         } else {
            var1 = System.getProperty(var0);
         }

         return var1;
      }

      static {
         try {
            mGetScript = Locale.class.getMethod("getScript", (Class<?>[])null);
            mGetExtensionKeys = Locale.class.getMethod("getExtensionKeys", (Class<?>[])null);
            mGetExtension = Locale.class.getMethod("getExtension", char.class);
            mGetUnicodeLocaleKeys = Locale.class.getMethod("getUnicodeLocaleKeys", (Class<?>[])null);
            mGetUnicodeLocaleAttributes = Locale.class.getMethod("getUnicodeLocaleAttributes", (Class<?>[])null);
            mGetUnicodeLocaleType = Locale.class.getMethod("getUnicodeLocaleType", String.class);
            mForLanguageTag = Locale.class.getMethod("forLanguageTag", String.class);
            Class var0 = null;
            Class[] var1 = Locale.class.getDeclaredClasses();

            for (Class var5 : var1) {
               if (var5.getName().equals("java.util.Locale$Category")) {
                  var0 = var5;
                  break;
               }
            }

            if (var0 != null) {
               mGetDefault = Locale.class.getDeclaredMethod("getDefault", var0);
               mSetDefault = Locale.class.getDeclaredMethod("setDefault", var0, Locale.class);
               Method var14 = var0.getMethod("name", (Class<?>[])null);
               Object[] var15 = var0.getEnumConstants();

               for (Object var7 : var15) {
                  String var8 = (String)var14.invoke(var7, (Object[])null);
                  if (var8.equals("DISPLAY")) {
                     eDISPLAY = var7;
                  } else if (var8.equals("FORMAT")) {
                     eFORMAT = var7;
                  }
               }

               if (eDISPLAY != null && eFORMAT != null) {
                  isJava7orNewer = true;
               }
            }
         } catch (NoSuchMethodException var9) {
         } catch (IllegalArgumentException var10) {
         } catch (IllegalAccessException var11) {
         } catch (InvocationTargetException var12) {
         } catch (SecurityException var13) {
         }
      }
   }

   public static final class Type {
      private Type() {
      }
   }
}
