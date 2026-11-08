package com.ibm.icu.util;

import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUService;
import com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory;
import com.ibm.icu.impl.ICUService.Factory;
import com.ibm.icu.util.Currency.ServiceShim;
import java.util.Locale;

public class CurrencyServiceShim extends ServiceShim {
   static final ICULocaleService service = new CurrencyServiceShim.CFService();

   CurrencyServiceShim() {
   }

   Locale[] getAvailableLocales() {
      return service.isDefault() ? ICUResourceBundle.getAvailableLocales() : service.getAvailableLocales();
   }

   ULocale[] getAvailableULocales() {
      return service.isDefault() ? ICUResourceBundle.getAvailableULocales() : service.getAvailableULocales();
   }

   Currency createInstance(ULocale var1) {
      return service.isDefault() ? Currency.createCurrency(var1) : (Currency)service.get(var1);
   }

   Object registerInstance(Currency var1, ULocale var2) {
      return service.registerObject(var1, var2);
   }

   boolean unregister(Object var1) {
      return service.unregisterFactory((Factory)var1);
   }

   private static class CFService extends ICULocaleService {
      CFService() {
         super("Currency");

         class CurrencyFactory extends ICUResourceBundleFactory {
            protected Object handleCreate(ULocale var1, int var2, ICUService var3) {
               return Currency.createCurrency(var1);
            }
         }

         this.registerFactory(new CurrencyFactory());
         this.markDefault();
      }
   }
}
