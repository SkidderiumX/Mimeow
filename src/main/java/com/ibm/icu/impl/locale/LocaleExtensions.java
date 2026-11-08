package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.locale.InternalLocaleBuilder.CaseInsensitiveChar;
import com.ibm.icu.impl.locale.InternalLocaleBuilder.CaseInsensitiveString;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class LocaleExtensions {
   private SortedMap<Character, Extension> _map;
   private String _id;
   private static final SortedMap<Character, Extension> EMPTY_MAP = Collections.unmodifiableSortedMap(new TreeMap<>());
   public static final LocaleExtensions EMPTY_EXTENSIONS = new LocaleExtensions();
   public static final LocaleExtensions CALENDAR_JAPANESE = new LocaleExtensions();
   public static final LocaleExtensions NUMBER_THAI = new LocaleExtensions();

   private LocaleExtensions() {
   }

   LocaleExtensions(Map<CaseInsensitiveChar, String> var1, Set<CaseInsensitiveString> var2, Map<CaseInsensitiveString, String> var3) {
      boolean var4 = var1 != null && var1.size() > 0;
      boolean var5 = var2 != null && var2.size() > 0;
      boolean var6 = var3 != null && var3.size() > 0;
      if (!var4 && !var5 && !var6) {
         this._map = EMPTY_MAP;
         this._id = "";
      } else {
         this._map = new TreeMap<>();
         if (var4) {
            for (Entry var8 : var1.entrySet()) {
               char var9 = AsciiUtil.toLower(((CaseInsensitiveChar)var8.getKey()).value());
               String var10 = (String)var8.getValue();
               if (LanguageTag.isPrivateusePrefixChar(var9)) {
                  var10 = InternalLocaleBuilder.removePrivateuseVariant(var10);
                  if (var10 == null) {
                     continue;
                  }
               }

               Extension var11 = new Extension(var9, AsciiUtil.toLowerString(var10));
               this._map.put(var9, var11);
            }
         }

         if (var5 || var6) {
            TreeSet var13 = null;
            TreeMap var14 = null;
            if (var5) {
               var13 = new TreeSet();

               for (CaseInsensitiveString var18 : var2) {
                  var13.add(AsciiUtil.toLowerString(var18.value()));
               }
            }

            if (var6) {
               var14 = new TreeMap();

               for (Entry var19 : var3.entrySet()) {
                  String var20 = AsciiUtil.toLowerString(((CaseInsensitiveString)var19.getKey()).value());
                  String var12 = AsciiUtil.toLowerString((String)var19.getValue());
                  var14.put(var20, var12);
               }
            }

            UnicodeLocaleExtension var17 = new UnicodeLocaleExtension(var13, var14);
            this._map.put('u', var17);
         }

         if (this._map.size() == 0) {
            this._map = EMPTY_MAP;
            this._id = "";
         } else {
            this._id = toID(this._map);
         }
      }
   }

   public Set<Character> getKeys() {
      return Collections.unmodifiableSet(this._map.keySet());
   }

   public Extension getExtension(Character var1) {
      return this._map.get(AsciiUtil.toLower(var1));
   }

   public String getExtensionValue(Character var1) {
      Extension var2 = this._map.get(AsciiUtil.toLower(var1));
      return var2 == null ? null : var2.getValue();
   }

   public Set<String> getUnicodeLocaleAttributes() {
      Extension var1 = this._map.get('u');
      if (var1 == null) {
         return Collections.emptySet();
      } else {
         assert var1 instanceof UnicodeLocaleExtension;

         return ((UnicodeLocaleExtension)var1).getUnicodeLocaleAttributes();
      }
   }

   public Set<String> getUnicodeLocaleKeys() {
      Extension var1 = this._map.get('u');
      if (var1 == null) {
         return Collections.emptySet();
      } else {
         assert var1 instanceof UnicodeLocaleExtension;

         return ((UnicodeLocaleExtension)var1).getUnicodeLocaleKeys();
      }
   }

   public String getUnicodeLocaleType(String var1) {
      Extension var2 = this._map.get('u');
      if (var2 == null) {
         return null;
      } else {
         assert var2 instanceof UnicodeLocaleExtension;

         return ((UnicodeLocaleExtension)var2).getUnicodeLocaleType(AsciiUtil.toLowerString(var1));
      }
   }

   public boolean isEmpty() {
      return this._map.isEmpty();
   }

   public static boolean isValidKey(char var0) {
      return LanguageTag.isExtensionSingletonChar(var0) || LanguageTag.isPrivateusePrefixChar(var0);
   }

   public static boolean isValidUnicodeLocaleKey(String var0) {
      return UnicodeLocaleExtension.isKey(var0);
   }

   private static String toID(SortedMap<Character, Extension> var0) {
      StringBuilder var1 = new StringBuilder();
      Extension var2 = null;

      for (Entry var4 : var0.entrySet()) {
         char var5 = (Character)var4.getKey();
         Extension var6 = (Extension)var4.getValue();
         if (LanguageTag.isPrivateusePrefixChar(var5)) {
            var2 = var6;
         } else {
            if (var1.length() > 0) {
               var1.append("-");
            }

            var1.append(var6);
         }
      }

      if (var2 != null) {
         if (var1.length() > 0) {
            var1.append("-");
         }

         var1.append(var2);
      }

      return var1.toString();
   }

   @Override
   public String toString() {
      return this._id;
   }

   public String getID() {
      return this._id;
   }

   @Override
   public int hashCode() {
      return this._id.hashCode();
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         return !(var1 instanceof LocaleExtensions) ? false : this._id.equals(((LocaleExtensions)var1)._id);
      }
   }

   static {
      EMPTY_EXTENSIONS._id = "";
      EMPTY_EXTENSIONS._map = EMPTY_MAP;
      CALENDAR_JAPANESE._id = "u-ca-japanese";
      CALENDAR_JAPANESE._map = new TreeMap<>();
      CALENDAR_JAPANESE._map.put('u', UnicodeLocaleExtension.CA_JAPANESE);
      NUMBER_THAI._id = "u-nu-thai";
      NUMBER_THAI._map = new TreeMap<>();
      NUMBER_THAI._map.put('u', UnicodeLocaleExtension.NU_THAI);
   }
}
