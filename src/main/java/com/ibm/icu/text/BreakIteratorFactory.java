package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICULocaleService;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUService;
import com.ibm.icu.impl.ICULocaleService.ICUResourceBundleFactory;
import com.ibm.icu.impl.ICUService.Factory;
import com.ibm.icu.text.BreakIterator.BreakIteratorServiceShim;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.IOException;
import java.io.InputStream;
import java.text.StringCharacterIterator;
import java.util.Locale;
import java.util.MissingResourceException;

public class BreakIteratorFactory extends BreakIteratorServiceShim {
   static final ICULocaleService service = new BreakIteratorFactory.BFService();
   private static final String[] KIND_NAMES = new String[]{"grapheme", "word", "line", "sentence", "title"};

   BreakIteratorFactory() {
   }

   public Object registerInstance(BreakIterator var1, ULocale var2, int var3) {
      var1.setText(new StringCharacterIterator(""));
      return service.registerObject(var1, var2, var3);
   }

   public boolean unregister(Object var1) {
      return service.isDefault() ? false : service.unregisterFactory((Factory)var1);
   }

   public Locale[] getAvailableLocales() {
      return service == null ? ICUResourceBundle.getAvailableLocales() : service.getAvailableLocales();
   }

   public ULocale[] getAvailableULocales() {
      return service == null ? ICUResourceBundle.getAvailableULocales() : service.getAvailableULocales();
   }

   public BreakIterator createBreakIterator(ULocale var1, int var2) {
      if (service.isDefault()) {
         return createBreakInstance(var1, var2);
      } else {
         ULocale[] var3 = new ULocale[1];
         BreakIterator var4 = (BreakIterator)service.get(var1, var2, var3);
         var4.setLocale(var3[0], var3[0]);
         return var4;
      }
   }

   private static BreakIterator createBreakInstance(ULocale var0, int var1) {
      RuleBasedBreakIterator var2 = null;
      ICUResourceBundle var3 = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b/brkitr", var0);
      Object var4 = null;

      try {
         String var5 = KIND_NAMES[var1];
         String var6 = var3.getStringWithFallback("boundaries/" + var5);
         String var7 = "data/icudt51b/brkitr/" + var6;
         var4 = ICUData.getStream(var7);
      } catch (Exception var9) {
         throw new MissingResourceException(var9.toString(), "", "");
      }

      try {
         var2 = RuleBasedBreakIterator.getInstanceFromCompiledRules((InputStream)var4);
      } catch (IOException var8) {
         Assert.fail(var8);
      }

      ULocale var11 = ULocale.forLocale(var3.getLocale());
      var2.setLocale(var11, var11);
      var2.setBreakType(var1);
      return var2;
   }

   private static class BFService extends ICULocaleService {
      BFService() {
         super("BreakIterator");

         class RBBreakIteratorFactory extends ICUResourceBundleFactory {
            protected Object handleCreate(ULocale var1, int var2, ICUService var3) {
               return BreakIteratorFactory.createBreakInstance(var1, var2);
            }
         }

         this.registerFactory(new RBBreakIteratorFactory());
         this.markDefault();
      }
   }
}
