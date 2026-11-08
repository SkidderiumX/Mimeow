package com.ibm.icu.text;

import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUService;
import com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory;
import com.ibm.icu.impl.ICULocaleService.LocaleKey;
import com.ibm.icu.impl.ICULocaleService.LocaleKeyFactory;
import com.ibm.icu.impl.ICUService.Factory;
import com.ibm.icu.impl.ICUService.Key;
import com.ibm.icu.text.NumberFormat.NumberFormatFactory;
import com.ibm.icu.text.NumberFormat.NumberFormatShim;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ULocale;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;

public class NumberFormatServiceShim extends NumberFormatShim {
   private static ICULocaleService service = new NumberFormatServiceShim.NFService();

   NumberFormatServiceShim() {
   }

   Locale[] getAvailableLocales() {
      return service.isDefault() ? ICUResourceBundle.getAvailableLocales() : service.getAvailableLocales();
   }

   ULocale[] getAvailableULocales() {
      return service.isDefault() ? ICUResourceBundle.getAvailableULocales() : service.getAvailableULocales();
   }

   Object registerFactory(NumberFormatFactory var1) {
      return service.registerFactory(new NumberFormatServiceShim.NFFactory(var1));
   }

   boolean unregister(Object var1) {
      return service.unregisterFactory((Factory)var1);
   }

   NumberFormat createInstance(ULocale var1, int var2) {
      ULocale[] var3 = new ULocale[1];
      NumberFormat var4 = (NumberFormat)service.get(var1, var2, var3);
      if (var4 == null) {
         throw new MissingResourceException("Unable to construct NumberFormat", "", "");
      } else {
         var4 = (NumberFormat)var4.clone();
         if (var2 == 1 || var2 == 5 || var2 == 6) {
            var4.setCurrency(Currency.getInstance(var1));
         }

         ULocale var5 = var3[0];
         var4.setLocale(var5, var5);
         return var4;
      }
   }

   private static final class NFFactory extends LocaleKeyFactory {
      private NumberFormatFactory delegate;

      NFFactory(NumberFormatFactory var1) {
         super(var1.visible());
         this.delegate = var1;
      }

      public Object create(Key var1, ICUService var2) {
         if (this.handlesKey(var1) && var1 instanceof LocaleKey) {
            LocaleKey var3 = (LocaleKey)var1;
            Object var4 = this.delegate.createFormat(var3.canonicalLocale(), var3.kind());
            if (var4 == null) {
               var4 = var2.getKey(var1, null, this);
            }

            return var4;
         } else {
            return null;
         }
      }

      protected Set<String> getSupportedIDs() {
         return this.delegate.getSupportedLocaleNames();
      }
   }

   private static class NFService extends ICULocaleService {
      NFService() {
         super("NumberFormat");

         class RBNumberFormatFactory extends ICUResourceBundleFactory {
            protected Object handleCreate(ULocale var1, int var2, ICUService var3) {
               return NumberFormat.createInstance(var1, var2);
            }
         }

         this.registerFactory(new RBNumberFormatFactory());
         this.markDefault();
      }
   }
}
