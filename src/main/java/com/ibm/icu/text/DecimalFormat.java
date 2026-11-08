package com.ibm.icu.text;

import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.math.MathContext;
import com.ibm.icu.text.NumberFormat.Field;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.ULocale.Category;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.ChoiceFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DecimalFormat extends NumberFormat {
   private static double epsilon = 1.0E-11;
   private static final int CURRENCY_SIGN_COUNT_IN_SYMBOL_FORMAT = 1;
   private static final int CURRENCY_SIGN_COUNT_IN_ISO_FORMAT = 2;
   private static final int CURRENCY_SIGN_COUNT_IN_PLURAL_FORMAT = 3;
   private static final int STATUS_INFINITE = 0;
   private static final int STATUS_POSITIVE = 1;
   private static final int STATUS_UNDERFLOW = 2;
   private static final int STATUS_LENGTH = 3;
   private static final UnicodeSet dotEquivalents = new UnicodeSet(46, 46, 8228, 8228, 12290, 12290, 65042, 65042, 65106, 65106, 65294, 65294, 65377, 65377)
      .freeze();
   private static final UnicodeSet commaEquivalents = new UnicodeSet(
         44, 44, 1548, 1548, 1643, 1643, 12289, 12289, 65040, 65041, 65104, 65105, 65292, 65292, 65380, 65380
      )
      .freeze();
   private static final UnicodeSet strictDotEquivalents = new UnicodeSet(46, 46, 8228, 8228, 65106, 65106, 65294, 65294, 65377, 65377).freeze();
   private static final UnicodeSet strictCommaEquivalents = new UnicodeSet(44, 44, 1643, 1643, 65040, 65040, 65104, 65104, 65292, 65292).freeze();
   private static final UnicodeSet defaultGroupingSeparators = new UnicodeSet(
         32,
         32,
         39,
         39,
         44,
         44,
         46,
         46,
         160,
         160,
         1548,
         1548,
         1643,
         1644,
         8192,
         8202,
         8216,
         8217,
         8228,
         8228,
         8239,
         8239,
         8287,
         8287,
         12288,
         12290,
         65040,
         65042,
         65104,
         65106,
         65287,
         65287,
         65292,
         65292,
         65294,
         65294,
         65377,
         65377,
         65380,
         65380
      )
      .freeze();
   private static final UnicodeSet strictDefaultGroupingSeparators = new UnicodeSet(
         32,
         32,
         39,
         39,
         44,
         44,
         46,
         46,
         160,
         160,
         1643,
         1644,
         8192,
         8202,
         8216,
         8217,
         8228,
         8228,
         8239,
         8239,
         8287,
         8287,
         12288,
         12288,
         65040,
         65040,
         65104,
         65104,
         65106,
         65106,
         65287,
         65287,
         65292,
         65292,
         65294,
         65294,
         65377,
         65377
      )
      .freeze();
   private int PARSE_MAX_EXPONENT = 1000;
   static final double roundingIncrementEpsilon = 1.0E-9;
   private transient DigitList digitList = new DigitList();
   private String positivePrefix = "";
   private String positiveSuffix = "";
   private String negativePrefix = "-";
   private String negativeSuffix = "";
   private String posPrefixPattern;
   private String posSuffixPattern;
   private String negPrefixPattern;
   private String negSuffixPattern;
   private ChoiceFormat currencyChoice;
   private int multiplier = 1;
   private byte groupingSize = 3;
   private byte groupingSize2 = 0;
   private boolean decimalSeparatorAlwaysShown = false;
   private DecimalFormatSymbols symbols = null;
   private boolean useSignificantDigits = false;
   private int minSignificantDigits = 1;
   private int maxSignificantDigits = 6;
   private boolean useExponentialNotation;
   private byte minExponentDigits;
   private boolean exponentSignAlwaysShown = false;
   private BigDecimal roundingIncrement = null;
   private transient com.ibm.icu.math.BigDecimal roundingIncrementICU = null;
   private transient double roundingDouble = 0.0;
   private transient double roundingDoubleReciprocal = 0.0;
   private int roundingMode = 6;
   private MathContext mathContext = new MathContext(0, 0);
   private int formatWidth = 0;
   private char pad = ' ';
   private int padPosition = 0;
   private boolean parseBigDecimal = false;
   static final int currentSerialVersion = 3;
   private int serialVersionOnStream = 3;
   public static final int PAD_BEFORE_PREFIX = 0;
   public static final int PAD_AFTER_PREFIX = 1;
   public static final int PAD_BEFORE_SUFFIX = 2;
   public static final int PAD_AFTER_SUFFIX = 3;
   static final char PATTERN_ZERO_DIGIT = '0';
   static final char PATTERN_ONE_DIGIT = '1';
   static final char PATTERN_TWO_DIGIT = '2';
   static final char PATTERN_THREE_DIGIT = '3';
   static final char PATTERN_FOUR_DIGIT = '4';
   static final char PATTERN_FIVE_DIGIT = '5';
   static final char PATTERN_SIX_DIGIT = '6';
   static final char PATTERN_SEVEN_DIGIT = '7';
   static final char PATTERN_EIGHT_DIGIT = '8';
   static final char PATTERN_NINE_DIGIT = '9';
   static final char PATTERN_GROUPING_SEPARATOR = ',';
   static final char PATTERN_DECIMAL_SEPARATOR = '.';
   static final char PATTERN_DIGIT = '#';
   static final char PATTERN_SIGNIFICANT_DIGIT = '@';
   static final char PATTERN_EXPONENT = 'E';
   static final char PATTERN_PLUS_SIGN = '+';
   private static final char PATTERN_PER_MILLE = '‰';
   private static final char PATTERN_PERCENT = '%';
   static final char PATTERN_PAD_ESCAPE = '*';
   private static final char PATTERN_MINUS = '-';
   private static final char PATTERN_SEPARATOR = ';';
   private static final char CURRENCY_SIGN = '¤';
   private static final char QUOTE = '\'';
   static final int DOUBLE_INTEGER_DIGITS = 309;
   static final int DOUBLE_FRACTION_DIGITS = 340;
   static final int MAX_SCIENTIFIC_INTEGER_DIGITS = 8;
   private static final long serialVersionUID = 864413376551465018L;
   private ArrayList<FieldPosition> attributes = new ArrayList<>();
   private String formatPattern = "";
   private int style = 0;
   private int currencySignCount = 0;
   private transient Set<DecimalFormat.AffixForCurrency> affixPatternsForCurrency = null;
   private transient boolean isReadyForParsing = false;
   private CurrencyPluralInfo currencyPluralInfo = null;
   static final DecimalFormat.Unit NULL_UNIT = new DecimalFormat.Unit("", "");

   public DecimalFormat() {
      ULocale var1 = ULocale.getDefault(Category.FORMAT);
      String var2 = getPattern(var1, 0);
      this.symbols = new DecimalFormatSymbols(var1);
      this.setCurrency(Currency.getInstance(var1));
      this.applyPatternWithoutExpandAffix(var2, false);
      if (this.currencySignCount == 3) {
         this.currencyPluralInfo = new CurrencyPluralInfo(var1);
      } else {
         this.expandAffixAdjustWidth(null);
      }
   }

   public DecimalFormat(String var1) {
      ULocale var2 = ULocale.getDefault(Category.FORMAT);
      this.symbols = new DecimalFormatSymbols(var2);
      this.setCurrency(Currency.getInstance(var2));
      this.applyPatternWithoutExpandAffix(var1, false);
      if (this.currencySignCount == 3) {
         this.currencyPluralInfo = new CurrencyPluralInfo(var2);
      } else {
         this.expandAffixAdjustWidth(null);
      }
   }

   public DecimalFormat(String var1, DecimalFormatSymbols var2) {
      this.createFromPatternAndSymbols(var1, var2);
   }

   private void createFromPatternAndSymbols(String var1, DecimalFormatSymbols var2) {
      this.symbols = (DecimalFormatSymbols)var2.clone();
      this.setCurrencyForSymbols();
      this.applyPatternWithoutExpandAffix(var1, false);
      if (this.currencySignCount == 3) {
         this.currencyPluralInfo = new CurrencyPluralInfo(this.symbols.getULocale());
      } else {
         this.expandAffixAdjustWidth(null);
      }
   }

   public DecimalFormat(String var1, DecimalFormatSymbols var2, CurrencyPluralInfo var3, int var4) {
      CurrencyPluralInfo var5 = var3;
      if (var4 == 6) {
         var5 = (CurrencyPluralInfo)var3.clone();
      }

      this.create(var1, var2, var5, var4);
   }

   private void create(String var1, DecimalFormatSymbols var2, CurrencyPluralInfo var3, int var4) {
      if (var4 != 6) {
         this.createFromPatternAndSymbols(var1, var2);
      } else {
         this.symbols = (DecimalFormatSymbols)var2.clone();
         this.currencyPluralInfo = var3;
         String var5 = this.currencyPluralInfo.getCurrencyPluralPattern("other");
         this.applyPatternWithoutExpandAffix(var5, false);
         this.setCurrencyForSymbols();
      }

      this.style = var4;
   }

   DecimalFormat(String var1, DecimalFormatSymbols var2, int var3) {
      CurrencyPluralInfo var4 = null;
      if (var3 == 6) {
         var4 = new CurrencyPluralInfo(var2.getULocale());
      }

      this.create(var1, var2, var4, var3);
   }

   public StringBuffer format(double var1, StringBuffer var3, FieldPosition var4) {
      return this.format(var1, var3, var4, false);
   }

   private boolean isNegative(double var1) {
      return var1 < 0.0 || var1 == 0.0 && 1.0 / var1 < 0.0;
   }

   private double round(double var1) {
      boolean var3 = this.isNegative(var1);
      if (var3) {
         var1 = -var1;
      }

      return this.roundingDouble > 0.0 ? round(var1, this.roundingDouble, this.roundingDoubleReciprocal, this.roundingMode, var3) : var1;
   }

   private double multiply(double var1) {
      return this.multiplier != 1 ? var1 * this.multiplier : var1;
   }

   private StringBuffer format(double var1, StringBuffer var3, FieldPosition var4, boolean var5) {
      var4.setBeginIndex(0);
      var4.setEndIndex(0);
      if (Double.isNaN(var1)) {
         if (var4.getField() == 0) {
            var4.setBeginIndex(var3.length());
         } else if (var4.getFieldAttribute() == Field.INTEGER) {
            var4.setBeginIndex(var3.length());
         }

         var3.append(this.symbols.getNaN());
         if (var5) {
            this.addAttribute(Field.INTEGER, var3.length() - this.symbols.getNaN().length(), var3.length());
         }

         if (var4.getField() == 0) {
            var4.setEndIndex(var3.length());
         } else if (var4.getFieldAttribute() == Field.INTEGER) {
            var4.setEndIndex(var3.length());
         }

         this.addPadding(var3, var4, 0, 0);
         return var3;
      } else {
         var1 = this.multiply(var1);
         boolean var6 = this.isNegative(var1);
         var1 = this.round(var1);
         if (Double.isInfinite(var1)) {
            int var13 = this.appendAffix(var3, var6, true, var5);
            if (var4.getField() == 0) {
               var4.setBeginIndex(var3.length());
            } else if (var4.getFieldAttribute() == Field.INTEGER) {
               var4.setBeginIndex(var3.length());
            }

            var3.append(this.symbols.getInfinity());
            if (var5) {
               this.addAttribute(Field.INTEGER, var3.length() - this.symbols.getInfinity().length(), var3.length());
            }

            if (var4.getField() == 0) {
               var4.setEndIndex(var3.length());
            } else if (var4.getFieldAttribute() == Field.INTEGER) {
               var4.setEndIndex(var3.length());
            }

            int var8 = this.appendAffix(var3, var6, false, var5);
            this.addPadding(var3, var4, var13, var8);
            return var3;
         } else {
            synchronized (this.digitList) {
               this.digitList.set(var1, this.precision(false), !this.useExponentialNotation && !this.areSignificantDigitsUsed());
               return this.subformat(var1, var3, var4, var6, false, var5);
            }
         }
      }
   }

   @Deprecated
   double adjustNumberAsInFormatting(double var1) {
      if (Double.isNaN(var1)) {
         return var1;
      } else {
         var1 = this.round(this.multiply(var1));
         if (Double.isInfinite(var1)) {
            return var1;
         } else {
            DigitList var3 = new DigitList();
            var3.set(var1, this.precision(false), false);
            return var3.getDouble();
         }
      }
   }

   @Deprecated
   boolean isNumberNegative(double var1) {
      return Double.isNaN(var1) ? false : this.isNegative(this.multiply(var1));
   }

   private static double round(double var0, double var2, double var4, int var6, boolean var7) {
      double var8 = var4 == 0.0 ? var0 / var2 : var0 * var4;
      switch (var6) {
         case 0:
            var8 = Math.ceil(var8 - epsilon);
            break;
         case 1:
            var8 = Math.floor(var8 + epsilon);
            break;
         case 2:
            var8 = var7 ? Math.floor(var8 + epsilon) : Math.ceil(var8 - epsilon);
            break;
         case 3:
            var8 = var7 ? Math.ceil(var8 - epsilon) : Math.floor(var8 + epsilon);
            break;
         case 4:
         case 5:
         case 6:
         default:
            double var10 = Math.ceil(var8);
            double var12 = var10 - var8;
            double var14 = Math.floor(var8);
            double var16 = var8 - var14;
            switch (var6) {
               case 4:
                  var8 = var12 <= var16 + epsilon ? var10 : var14;
                  return var4 == 0.0 ? var8 * var2 : var8 / var4;
               case 5:
                  var8 = var16 <= var12 + epsilon ? var14 : var10;
                  return var4 == 0.0 ? var8 * var2 : var8 / var4;
               case 6:
                  if (!(var16 + epsilon < var12)) {
                     if (var12 + epsilon < var16) {
                        var8 = var10;
                     } else {
                        double var18 = var14 / 2.0;
                        var8 = var18 == Math.floor(var18) ? var14 : var10;
                     }

                     return var4 == 0.0 ? var8 * var2 : var8 / var4;
                  }

                  return var4 == 0.0 ? var14 * var2 : var14 / var4;
               default:
                  throw new IllegalArgumentException("Invalid rounding mode: " + var6);
            }
         case 7:
            if (var8 != Math.floor(var8)) {
               throw new ArithmeticException("Rounding necessary");
            }

            return var0;
      }

      return var4 == 0.0 ? var8 * var2 : var8 / var4;
   }

   public StringBuffer format(long var1, StringBuffer var3, FieldPosition var4) {
      return this.format(var1, var3, var4, false);
   }

   private StringBuffer format(long var1, StringBuffer var3, FieldPosition var4, boolean var5) {
      var4.setBeginIndex(0);
      var4.setEndIndex(0);
      if (this.roundingIncrementICU != null) {
         return this.format(com.ibm.icu.math.BigDecimal.valueOf(var1), var3, var4);
      } else {
         boolean var6 = var1 < 0L;
         if (var6) {
            var1 = -var1;
         }

         if (this.multiplier != 1) {
            boolean var7 = false;
            if (var1 < 0L) {
               long var8 = Long.MIN_VALUE / this.multiplier;
               var7 = var1 <= var8;
            } else {
               long var15 = Long.MAX_VALUE / this.multiplier;
               var7 = var1 > var15;
            }

            if (var7) {
               return this.format(BigInteger.valueOf(var6 ? -var1 : var1), var3, var4, var5);
            }
         }

         var1 *= this.multiplier;
         synchronized (this.digitList) {
            this.digitList.set(var1, this.precision(true));
            return this.subformat((double)var1, var3, var4, var6, true, var5);
         }
      }
   }

   public StringBuffer format(BigInteger var1, StringBuffer var2, FieldPosition var3) {
      return this.format(var1, var2, var3, false);
   }

   private StringBuffer format(BigInteger var1, StringBuffer var2, FieldPosition var3, boolean var4) {
      if (this.roundingIncrementICU != null) {
         return this.format(new com.ibm.icu.math.BigDecimal(var1), var2, var3);
      } else {
         if (this.multiplier != 1) {
            var1 = var1.multiply(BigInteger.valueOf(this.multiplier));
         }

         synchronized (this.digitList) {
            this.digitList.set(var1, this.precision(true));
            return this.subformat(var1.intValue(), var2, var3, var1.signum() < 0, true, var4);
         }
      }
   }

   public StringBuffer format(BigDecimal var1, StringBuffer var2, FieldPosition var3) {
      return this.format(var1, var2, var3, false);
   }

   private StringBuffer format(BigDecimal var1, StringBuffer var2, FieldPosition var3, boolean var4) {
      if (this.multiplier != 1) {
         var1 = var1.multiply(BigDecimal.valueOf((long)this.multiplier));
      }

      if (this.roundingIncrement != null) {
         var1 = var1.divide(this.roundingIncrement, 0, this.roundingMode).multiply(this.roundingIncrement);
      }

      synchronized (this.digitList) {
         this.digitList.set(var1, this.precision(false), !this.useExponentialNotation && !this.areSignificantDigitsUsed());
         return this.subformat(var1.doubleValue(), var2, var3, var1.signum() < 0, false, var4);
      }
   }

   public StringBuffer format(com.ibm.icu.math.BigDecimal var1, StringBuffer var2, FieldPosition var3) {
      if (this.multiplier != 1) {
         var1 = var1.multiply(com.ibm.icu.math.BigDecimal.valueOf(this.multiplier), this.mathContext);
      }

      if (this.roundingIncrementICU != null) {
         var1 = var1.divide(this.roundingIncrementICU, 0, this.roundingMode).multiply(this.roundingIncrementICU, this.mathContext);
      }

      synchronized (this.digitList) {
         this.digitList.set(var1, this.precision(false), !this.useExponentialNotation && !this.areSignificantDigitsUsed());
         return this.subformat(var1.doubleValue(), var2, var3, var1.signum() < 0, false, false);
      }
   }

   private boolean isGroupingPosition(int var1) {
      boolean var2 = false;
      if (this.isGroupingUsed() && var1 > 0 && this.groupingSize > 0) {
         if (this.groupingSize2 > 0 && var1 > this.groupingSize) {
            var2 = (var1 - this.groupingSize) % this.groupingSize2 == 0;
         } else {
            var2 = var1 % this.groupingSize == 0;
         }
      }

      return var2;
   }

   private int precision(boolean var1) {
      if (this.areSignificantDigitsUsed()) {
         return this.getMaximumSignificantDigits();
      } else if (this.useExponentialNotation) {
         return this.getMinimumIntegerDigits() + this.getMaximumFractionDigits();
      } else {
         return var1 ? 0 : this.getMaximumFractionDigits();
      }
   }

   private StringBuffer subformat(int var1, StringBuffer var2, FieldPosition var3, boolean var4, boolean var5, boolean var6) {
      return this.currencySignCount == 3
         ? this.subformat(this.currencyPluralInfo.select(var1), var2, var3, var4, var5, var6)
         : this.subformat(var2, var3, var4, var5, var6);
   }

   private StringBuffer subformat(double var1, StringBuffer var3, FieldPosition var4, boolean var5, boolean var6, boolean var7) {
      return this.currencySignCount == 3
         ? this.subformat(this.currencyPluralInfo.select(var1), var3, var4, var5, var6, var7)
         : this.subformat(var3, var4, var5, var6, var7);
   }

   private StringBuffer subformat(String var1, StringBuffer var2, FieldPosition var3, boolean var4, boolean var5, boolean var6) {
      if (this.style == 6) {
         String var7 = this.currencyPluralInfo.getCurrencyPluralPattern(var1);
         if (!this.formatPattern.equals(var7)) {
            this.applyPatternWithoutExpandAffix(var7, false);
         }
      }

      this.expandAffixAdjustWidth(var1);
      return this.subformat(var2, var3, var4, var5, var6);
   }

   private StringBuffer subformat(StringBuffer var1, FieldPosition var2, boolean var3, boolean var4, boolean var5) {
      if (this.digitList.isZero()) {
         this.digitList.decimalAt = 0;
      }

      int var6 = this.appendAffix(var1, var3, true, var5);
      if (this.useExponentialNotation) {
         this.subformatExponential(var1, var2, var5);
      } else {
         this.subformatFixed(var1, var2, var4, var5);
      }

      int var7 = this.appendAffix(var1, var3, false, var5);
      this.addPadding(var1, var2, var6, var7);
      return var1;
   }

   private void subformatFixed(StringBuffer var1, FieldPosition var2, boolean var3, boolean var4) {
      char[] var5 = this.symbols.getDigitsLocal();
      char var6 = this.currencySignCount > 0 ? this.symbols.getMonetaryGroupingSeparator() : this.symbols.getGroupingSeparator();
      char var7 = this.currencySignCount > 0 ? this.symbols.getMonetaryDecimalSeparator() : this.symbols.getDecimalSeparator();
      boolean var8 = this.areSignificantDigitsUsed();
      int var9 = this.getMaximumIntegerDigits();
      int var10 = this.getMinimumIntegerDigits();
      int var12 = var1.length();
      if (var2.getField() == 0) {
         var2.setBeginIndex(var1.length());
      } else if (var2.getFieldAttribute() == Field.INTEGER) {
         var2.setBeginIndex(var1.length());
      }

      int var13 = 0;
      int var14 = this.getMinimumSignificantDigits();
      int var15 = this.getMaximumSignificantDigits();
      if (!var8) {
         var14 = 0;
         var15 = Integer.MAX_VALUE;
      }

      int var16 = var8 ? Math.max(1, this.digitList.decimalAt) : var10;
      if (this.digitList.decimalAt > 0 && var16 < this.digitList.decimalAt) {
         var16 = this.digitList.decimalAt;
      }

      int var17 = 0;
      if (var16 > var9 && var9 >= 0) {
         var16 = var9;
         var17 = this.digitList.decimalAt - var9;
      }

      int var18 = var1.length();

      for (int var11 = var16 - 1; var11 >= 0; var11--) {
         if (var11 < this.digitList.decimalAt && var17 < this.digitList.count && var13 < var15) {
            var1.append(var5[this.digitList.getDigitValue(var17++)]);
            var13++;
         } else {
            var1.append(var5[0]);
            if (var13 > 0) {
               var13++;
            }
         }

         if (this.isGroupingPosition(var11)) {
            var1.append(var6);
            if (var4) {
               this.addAttribute(Field.GROUPING_SEPARATOR, var1.length() - 1, var1.length());
            }
         }
      }

      if (var2.getField() == 0) {
         var2.setEndIndex(var1.length());
      } else if (var2.getFieldAttribute() == Field.INTEGER) {
         var2.setEndIndex(var1.length());
      }

      boolean var19 = !var3 && var17 < this.digitList.count || (var8 ? var13 < var14 : this.getMinimumFractionDigits() > 0);
      if (!var19 && var1.length() == var18) {
         var1.append(var5[0]);
      }

      if (var4) {
         this.addAttribute(Field.INTEGER, var12, var1.length());
      }

      if (this.decimalSeparatorAlwaysShown || var19) {
         if (var2.getFieldAttribute() == Field.DECIMAL_SEPARATOR) {
            var2.setBeginIndex(var1.length());
         }

         var1.append(var7);
         if (var2.getFieldAttribute() == Field.DECIMAL_SEPARATOR) {
            var2.setEndIndex(var1.length());
         }

         if (var4) {
            this.addAttribute(Field.DECIMAL_SEPARATOR, var1.length() - 1, var1.length());
         }
      }

      if (var2.getField() == 1) {
         var2.setBeginIndex(var1.length());
      } else if (var2.getFieldAttribute() == Field.FRACTION) {
         var2.setBeginIndex(var1.length());
      }

      int var20 = var1.length();
      var16 = var8 ? Integer.MAX_VALUE : this.getMaximumFractionDigits();
      if (var8 && (var13 == var15 || var13 >= var14 && var17 == this.digitList.count)) {
         var16 = 0;
      }

      for (int var21 = 0; var21 < var16 && (var8 || var21 < this.getMinimumFractionDigits() || !var3 && var17 < this.digitList.count); var21++) {
         if (-1 - var21 > this.digitList.decimalAt - 1) {
            var1.append(var5[0]);
         } else {
            if (!var3 && var17 < this.digitList.count) {
               var1.append(var5[this.digitList.getDigitValue(var17++)]);
            } else {
               var1.append(var5[0]);
            }

            var13++;
            if (var8 && (var13 == var15 || var17 == this.digitList.count && var13 >= var14)) {
               break;
            }
         }
      }

      if (var2.getField() == 1) {
         var2.setEndIndex(var1.length());
      } else if (var2.getFieldAttribute() == Field.FRACTION) {
         var2.setEndIndex(var1.length());
      }

      if (var4 && (this.decimalSeparatorAlwaysShown || var19)) {
         this.addAttribute(Field.FRACTION, var20, var1.length());
      }
   }

   private void subformatExponential(StringBuffer var1, FieldPosition var2, boolean var3) {
      char[] var4 = this.symbols.getDigitsLocal();
      char var5 = this.currencySignCount > 0 ? this.symbols.getMonetaryDecimalSeparator() : this.symbols.getDecimalSeparator();
      boolean var6 = this.areSignificantDigitsUsed();
      int var7 = this.getMaximumIntegerDigits();
      int var8 = this.getMinimumIntegerDigits();
      if (var2.getField() == 0) {
         var2.setBeginIndex(var1.length());
         var2.setEndIndex(-1);
      } else if (var2.getField() == 1) {
         var2.setBeginIndex(-1);
      } else if (var2.getFieldAttribute() == Field.INTEGER) {
         var2.setBeginIndex(var1.length());
         var2.setEndIndex(-1);
      } else if (var2.getFieldAttribute() == Field.FRACTION) {
         var2.setBeginIndex(-1);
      }

      int var10 = var1.length();
      int var11 = -1;
      int var12 = -1;
      int var13 = 0;
      if (var6) {
         var8 = 1;
         var7 = 1;
         var13 = this.getMinimumSignificantDigits() - 1;
      } else {
         var13 = this.getMinimumFractionDigits();
         if (var7 > 8) {
            var7 = 1;
            if (var7 < var8) {
               var7 = var8;
            }
         }

         if (var7 > var8) {
            var8 = 1;
         }
      }

      int var14 = this.digitList.decimalAt;
      if (var7 > 1 && var7 != var8) {
         var14 = var14 > 0 ? (var14 - 1) / var7 : var14 / var7 - 1;
         var14 *= var7;
      } else {
         var14 -= var8 <= 0 && var13 <= 0 ? 1 : var8;
      }

      int var15 = var8 + var13;
      int var16 = this.digitList.isZero() ? var8 : this.digitList.decimalAt - var14;
      int var17 = this.digitList.count;
      if (var15 > var17) {
         var17 = var15;
      }

      if (var16 > var17) {
         var17 = var16;
      }

      for (int var9 = 0; var9 < var17; var9++) {
         if (var9 == var16) {
            if (var2.getField() == 0) {
               var2.setEndIndex(var1.length());
            } else if (var2.getFieldAttribute() == Field.INTEGER) {
               var2.setEndIndex(var1.length());
            }

            if (var3) {
               var11 = var1.length();
               this.addAttribute(Field.INTEGER, var10, var1.length());
            }

            var1.append(var5);
            if (var3) {
               int var18 = var1.length() - 1;
               this.addAttribute(Field.DECIMAL_SEPARATOR, var18, var1.length());
               var12 = var1.length();
            }

            if (var2.getField() == 1) {
               var2.setBeginIndex(var1.length());
            } else if (var2.getFieldAttribute() == Field.FRACTION) {
               var2.setBeginIndex(var1.length());
            }
         }

         var1.append(var9 < this.digitList.count ? var4[this.digitList.getDigitValue(var9)] : var4[0]);
      }

      if (this.digitList.isZero() && var17 == 0) {
         var1.append(var4[0]);
      }

      if (var2.getField() == 0) {
         if (var2.getEndIndex() < 0) {
            var2.setEndIndex(var1.length());
         }
      } else if (var2.getField() == 1) {
         if (var2.getBeginIndex() < 0) {
            var2.setBeginIndex(var1.length());
         }

         var2.setEndIndex(var1.length());
      } else if (var2.getFieldAttribute() == Field.INTEGER) {
         if (var2.getEndIndex() < 0) {
            var2.setEndIndex(var1.length());
         }
      } else if (var2.getFieldAttribute() == Field.FRACTION) {
         if (var2.getBeginIndex() < 0) {
            var2.setBeginIndex(var1.length());
         }

         var2.setEndIndex(var1.length());
      }

      if (var3) {
         if (var11 < 0) {
            this.addAttribute(Field.INTEGER, var10, var1.length());
         }

         if (var12 > 0) {
            this.addAttribute(Field.FRACTION, var12, var1.length());
         }
      }

      var1.append(this.symbols.getExponentSeparator());
      if (var3) {
         this.addAttribute(Field.EXPONENT_SYMBOL, var1.length() - this.symbols.getExponentSeparator().length(), var1.length());
      }

      if (this.digitList.isZero()) {
         var14 = 0;
      }

      boolean var26 = var14 < 0;
      if (var26) {
         var14 = -var14;
         var1.append(this.symbols.getMinusSign());
         if (var3) {
            this.addAttribute(Field.EXPONENT_SIGN, var1.length() - 1, var1.length());
         }
      } else if (this.exponentSignAlwaysShown) {
         var1.append(this.symbols.getPlusSign());
         if (var3) {
            int var19 = var1.length() - 1;
            this.addAttribute(Field.EXPONENT_SIGN, var19, var1.length());
         }
      }

      int var27 = var1.length();
      this.digitList.set(var14);
      byte var20 = this.minExponentDigits;
      if (this.useExponentialNotation && var20 < 1) {
         var20 = 1;
      }

      for (int var21 = this.digitList.decimalAt; var21 < var20; var21++) {
         var1.append(var4[0]);
      }

      for (int var22 = 0; var22 < this.digitList.decimalAt; var22++) {
         var1.append(var22 < this.digitList.count ? var4[this.digitList.getDigitValue(var22)] : var4[0]);
      }

      if (var3) {
         this.addAttribute(Field.EXPONENT, var27, var1.length());
      }
   }

   private final void addPadding(StringBuffer var1, FieldPosition var2, int var3, int var4) {
      if (this.formatWidth > 0) {
         int var5 = this.formatWidth - var1.length();
         if (var5 > 0) {
            char[] var6 = new char[var5];

            for (int var7 = 0; var7 < var5; var7++) {
               var6[var7] = this.pad;
            }

            switch (this.padPosition) {
               case 0:
                  var1.insert(0, var6);
                  break;
               case 1:
                  var1.insert(var3, var6);
                  break;
               case 2:
                  var1.insert(var1.length() - var4, var6);
                  break;
               case 3:
                  var1.append(var6);
            }

            if (this.padPosition == 0 || this.padPosition == 1) {
               var2.setBeginIndex(var2.getBeginIndex() + var5);
               var2.setEndIndex(var2.getEndIndex() + var5);
            }
         }
      }
   }

   public Number parse(String var1, ParsePosition var2) {
      return (Number)this.parse(var1, var2, null);
   }

   public CurrencyAmount parseCurrency(CharSequence var1, ParsePosition var2) {
      Currency[] var3 = new Currency[1];
      return (CurrencyAmount)this.parse(var1.toString(), var2, var3);
   }

   private Object parse(String var1, ParsePosition var2, Currency[] var3) {
      int var4;
      int var5 = var4 = var2.getIndex();
      if (this.formatWidth > 0 && (this.padPosition == 0 || this.padPosition == 1)) {
         var5 = this.skipPadding(var1, var5);
      }

      if (var1.regionMatches(var5, this.symbols.getNaN(), 0, this.symbols.getNaN().length())) {
         var5 += this.symbols.getNaN().length();
         if (this.formatWidth > 0 && (this.padPosition == 2 || this.padPosition == 3)) {
            var5 = this.skipPadding(var1, var5);
         }

         var2.setIndex(var5);
         return new Double(Double.NaN);
      } else {
         boolean[] var6 = new boolean[3];
         if (this.currencySignCount > 0) {
            if (!this.parseForCurrency(var1, var2, var3, var6)) {
               return null;
            }
         } else if (!this.subparse(
            var1, var2, this.digitList, var6, var3, this.negPrefixPattern, this.negSuffixPattern, this.posPrefixPattern, this.posSuffixPattern, 0
         )) {
            var2.setIndex(var4);
            return null;
         }

         Object var7 = null;
         if (var6[0]) {
            var7 = new Double(var6[1] ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
         } else if (var6[2]) {
            var7 = var6[1] ? new Double("0.0") : new Double("-0.0");
         } else if (!var6[1] && this.digitList.isZero()) {
            var7 = new Double("-0.0");
         } else {
            int var8;
            for (var8 = this.multiplier; var8 % 10 == 0; var8 /= 10) {
               this.digitList.decimalAt--;
            }

            if (this.parseBigDecimal || var8 != 1 || !this.digitList.isIntegral()) {
               com.ibm.icu.math.BigDecimal var15 = this.digitList.getBigDecimalICU(var6[1]);
               var7 = var15;
               if (var8 != 1) {
                  var7 = var15.divide(com.ibm.icu.math.BigDecimal.valueOf(var8), this.mathContext);
               }
            } else if (this.digitList.decimalAt < 12) {
               long var9 = 0L;
               if (this.digitList.count > 0) {
                  int var11 = 0;

                  while (var11 < this.digitList.count) {
                     var9 = var9 * 10L + (char)this.digitList.digits[var11++] - 48L;
                  }

                  while (var11++ < this.digitList.decimalAt) {
                     var9 *= 10L;
                  }

                  if (!var6[1]) {
                     var9 = -var9;
                  }
               }

               var7 = var9;
            } else {
               BigInteger var14 = this.digitList.getBigInteger(var6[1]);
               var7 = var14.bitLength() < 64 ? var14.longValue() : var14;
            }
         }

         return var3 != null ? new CurrencyAmount((Number)var7, var3[0]) : var7;
      }
   }

   private boolean parseForCurrency(String var1, ParsePosition var2, Currency[] var3, boolean[] var4) {
      int var5 = var2.getIndex();
      if (!this.isReadyForParsing) {
         int var6 = this.currencySignCount;
         this.setupCurrencyAffixForAllPatterns();
         if (var6 == 3) {
            this.applyPatternWithoutExpandAffix(this.formatPattern, false);
         } else {
            this.applyPattern(this.formatPattern, false);
         }

         this.isReadyForParsing = true;
      }

      int var16 = var5;
      int var7 = -1;
      boolean[] var8 = null;
      boolean[] var9 = new boolean[3];
      ParsePosition var10 = new ParsePosition(var5);
      DigitList var11 = new DigitList();
      boolean var12;
      if (this.style == 6) {
         var12 = this.subparse(var1, var10, var11, var9, var3, this.negPrefixPattern, this.negSuffixPattern, this.posPrefixPattern, this.posSuffixPattern, 1);
      } else {
         var12 = this.subparse(var1, var10, var11, var9, var3, this.negPrefixPattern, this.negSuffixPattern, this.posPrefixPattern, this.posSuffixPattern, 0);
      }

      if (var12) {
         if (var10.getIndex() > var5) {
            var16 = var10.getIndex();
            var8 = var9;
            this.digitList = var11;
         }
      } else {
         var7 = var10.getErrorIndex();
      }

      for (DecimalFormat.AffixForCurrency var14 : this.affixPatternsForCurrency) {
         var9 = new boolean[3];
         var10 = new ParsePosition(var5);
         var11 = new DigitList();
         boolean var15 = this.subparse(
            var1, var10, var11, var9, var3, var14.getNegPrefix(), var14.getNegSuffix(), var14.getPosPrefix(), var14.getPosSuffix(), var14.getPatternType()
         );
         if (var15) {
            var12 = true;
            if (var10.getIndex() > var16) {
               var16 = var10.getIndex();
               var8 = var9;
               this.digitList = var11;
            }
         } else {
            var7 = var10.getErrorIndex() > var7 ? var10.getErrorIndex() : var7;
         }
      }

      var9 = new boolean[3];
      var10 = new ParsePosition(var5);
      var11 = new DigitList();
      int var23 = this.currencySignCount;
      this.currencySignCount = -1;
      boolean var24 = this.subparse(var1, var10, var11, var9, var3, this.negativePrefix, this.negativeSuffix, this.positivePrefix, this.positiveSuffix, 0);
      this.currencySignCount = var23;
      if (var24) {
         if (var10.getIndex() > var16) {
            var16 = var10.getIndex();
            var8 = var9;
            this.digitList = var11;
         }

         var12 = true;
      } else {
         var7 = var10.getErrorIndex() > var7 ? var10.getErrorIndex() : var7;
      }

      if (!var12) {
         var2.setErrorIndex(var7);
      } else {
         var2.setIndex(var16);
         var2.setErrorIndex(-1);

         for (int var25 = 0; var25 < 3; var25++) {
            var4[var25] = var8[var25];
         }
      }

      return var12;
   }

   private void setupCurrencyAffixForAllPatterns() {
      if (this.currencyPluralInfo == null) {
         this.currencyPluralInfo = new CurrencyPluralInfo(this.symbols.getULocale());
      }

      this.affixPatternsForCurrency = new HashSet<>();
      String var1 = this.formatPattern;
      this.applyPatternWithoutExpandAffix(getPattern(this.symbols.getULocale(), 1), false);
      DecimalFormat.AffixForCurrency var2 = new DecimalFormat.AffixForCurrency(
         this.negPrefixPattern, this.negSuffixPattern, this.posPrefixPattern, this.posSuffixPattern, 0
      );
      this.affixPatternsForCurrency.add(var2);
      Iterator var3 = this.currencyPluralInfo.pluralPatternIterator();
      HashSet var4 = new HashSet();

      while (var3.hasNext()) {
         String var5 = (String)var3.next();
         String var6 = this.currencyPluralInfo.getCurrencyPluralPattern(var5);
         if (var6 != null && !var4.contains(var6)) {
            var4.add(var6);
            this.applyPatternWithoutExpandAffix(var6, false);
            var2 = new DecimalFormat.AffixForCurrency(this.negPrefixPattern, this.negSuffixPattern, this.posPrefixPattern, this.posSuffixPattern, 1);
            this.affixPatternsForCurrency.add(var2);
         }
      }

      this.formatPattern = var1;
   }

   private final boolean subparse(
      String var1, ParsePosition var2, DigitList var3, boolean[] var4, Currency[] var5, String var6, String var7, String var8, String var9, int var10
   ) {
      int var11 = var2.getIndex();
      int var12 = var2.getIndex();
      if (this.formatWidth > 0 && this.padPosition == 0) {
         var11 = this.skipPadding(var1, var11);
      }

      int var13 = this.compareAffix(var1, var11, false, true, var8, var10, var5);
      int var14 = this.compareAffix(var1, var11, true, true, var6, var10, var5);
      if (var13 >= 0 && var14 >= 0) {
         if (var13 > var14) {
            var14 = -1;
         } else if (var14 > var13) {
            var13 = -1;
         }
      }

      if (var13 >= 0) {
         var11 += var13;
      } else {
         if (var14 < 0) {
            var2.setErrorIndex(var11);
            return false;
         }

         var11 += var14;
      }

      if (this.formatWidth > 0 && this.padPosition == 1) {
         var11 = this.skipPadding(var1, var11);
      }

      var4[0] = false;
      if (var1.regionMatches(var11, this.symbols.getInfinity(), 0, this.symbols.getInfinity().length())) {
         var11 += this.symbols.getInfinity().length();
         var4[0] = true;
      } else {
         var3.decimalAt = var3.count = 0;
         char[] var15 = this.symbols.getDigitsLocal();
         char var16 = this.currencySignCount == 0 ? this.symbols.getDecimalSeparator() : this.symbols.getMonetaryDecimalSeparator();
         char var17 = this.symbols.getGroupingSeparator();
         String var18 = this.symbols.getExponentSeparator();
         boolean var19 = false;
         boolean var20 = false;
         boolean var21 = false;
         boolean var22 = false;
         long var23 = 0L;
         int var25 = 0;
         boolean var26 = this.isParseStrict();
         boolean var27 = false;
         int var28 = -1;
         int var29 = var11;
         byte var30 = this.groupingSize2 == 0 ? this.groupingSize : this.groupingSize2;
         boolean var31 = ICUConfig.get("com.ibm.icu.text.DecimalFormat.SkipExtendedSeparatorParsing", "false").equals("true");
         UnicodeSet var32 = var31 ? UnicodeSet.EMPTY : this.getEquivalentDecimals(var16, var26);
         UnicodeSet var33 = var31 ? UnicodeSet.EMPTY : (var26 ? strictDefaultGroupingSeparators : defaultGroupingSeparators);
         int var34 = 0;
         int var35 = -1;

         while (var11 < var1.length()) {
            int var36 = UTF16.charAt(var1, var11);
            var25 = var36 - var15[0];
            if (var25 < 0 || var25 > 9) {
               var25 = UCharacter.digit(var36, 10);
            }

            if (var25 < 0 || var25 > 9) {
               var25 = 0;

               while (var25 < 10 && var36 != var15[var25]) {
                  var25++;
               }
            }

            if (var25 == 0) {
               if (var26 && var35 != -1) {
                  if (var28 != -1 && this.countCodePoints(var1, var28, var35) - 1 != var30
                     || var28 == -1 && this.countCodePoints(var1, var29, var11) - 1 > var30) {
                     var27 = true;
                     break;
                  }

                  var28 = var35;
               }

               var35 = -1;
               var22 = true;
               if (var3.count == 0) {
                  if (var19) {
                     var3.decimalAt--;
                  }
               } else {
                  var34++;
                  var3.append((char)(var25 + 48));
               }
            } else if (var25 > 0 && var25 <= 9) {
               if (var26 && var35 != -1) {
                  if (var28 != -1 && this.countCodePoints(var1, var28, var35) - 1 != var30
                     || var28 == -1 && this.countCodePoints(var1, var29, var11) - 1 > var30) {
                     var27 = true;
                     break;
                  }

                  var28 = var35;
               }

               var22 = true;
               var34++;
               var3.append((char)(var25 + 48));
               var35 = -1;
            } else if (var36 == var16) {
               if (var26 && (var35 != -1 || var28 != -1 && this.countCodePoints(var1, var28, var11) != this.groupingSize + 1)) {
                  var27 = true;
                  break;
               }

               if (this.isParseIntegerOnly() || var19) {
                  break;
               }

               var3.decimalAt = var34;
               var19 = true;
            } else if (this.isGroupingUsed() && var36 == var17) {
               if (var19) {
                  break;
               }

               if (var26 && (!var22 || var35 != -1)) {
                  var27 = true;
                  break;
               }

               var35 = var11;
               var20 = true;
            } else if (!var19 && var32.contains(var36)) {
               if (var26 && (var35 != -1 || var28 != -1 && this.countCodePoints(var1, var28, var11) != this.groupingSize + 1)) {
                  var27 = true;
                  break;
               }

               if (this.isParseIntegerOnly()) {
                  break;
               }

               var3.decimalAt = var34;
               var16 = (char)var36;
               var19 = true;
            } else {
               if (!this.isGroupingUsed() || var20 || !var33.contains(var36)) {
                  if (var21 || !var1.regionMatches(true, var11, var18, 0, var18.length())) {
                     break;
                  }

                  boolean var37 = false;
                  int var38 = var11 + var18.length();
                  if (var38 < var1.length()) {
                     var36 = UTF16.charAt(var1, var38);
                     if (var36 == this.symbols.getPlusSign()) {
                        var38++;
                     } else if (var36 == this.symbols.getMinusSign()) {
                        var38++;
                        var37 = true;
                     }
                  }

                  DigitList var39 = new DigitList();

                  for (var39.count = 0; var38 < var1.length(); var38 += UTF16.getCharCount(UTF16.charAt(var1, var38))) {
                     var25 = UTF16.charAt(var1, var38) - var15[0];
                     if (var25 < 0 || var25 > 9) {
                        var25 = UCharacter.digit(UTF16.charAt(var1, var38), 10);
                     }

                     if (var25 < 0 || var25 > 9) {
                        break;
                     }

                     var39.append((char)(var25 + 48));
                  }

                  if (var39.count <= 0) {
                     break;
                  }

                  if (!var26 || var35 == -1 && var28 == -1) {
                     if (var39.count > 10) {
                        if (var37) {
                           var4[2] = true;
                        } else {
                           var4[0] = true;
                        }
                     } else {
                        var39.decimalAt = var39.count;
                        var23 = var39.getLong();
                        if (var37) {
                           var23 = -var23;
                        }
                     }

                     var11 = var38;
                     var21 = true;
                     break;
                  }

                  var27 = true;
                  break;
               }

               if (var19) {
                  break;
               }

               if (var26 && (!var22 || var35 != -1)) {
                  var27 = true;
                  break;
               }

               var17 = (char)var36;
               var35 = var11;
               var20 = true;
            }

            var11 += UTF16.getCharCount(var36);
         }

         if (var35 != -1) {
            var11 = var35;
         }

         if (!var19) {
            var3.decimalAt = var34;
         }

         if (var26 && !var19 && var28 != -1 && this.countCodePoints(var1, var28, var11) != this.groupingSize + 1) {
            var27 = true;
         }

         if (var27) {
            var2.setIndex(var12);
            var2.setErrorIndex(var11);
            return false;
         }

         var23 += var3.decimalAt;
         if (var23 < -this.getParseMaxDigits()) {
            var4[2] = true;
         } else if (var23 > this.getParseMaxDigits()) {
            var4[0] = true;
         } else {
            var3.decimalAt = (int)var23;
         }

         if (!var22 && var34 == 0) {
            var2.setIndex(var12);
            var2.setErrorIndex(var12);
            return false;
         }
      }

      if (this.formatWidth > 0 && this.padPosition == 2) {
         var11 = this.skipPadding(var1, var11);
      }

      if (var13 >= 0) {
         var13 = this.compareAffix(var1, var11, false, false, var9, var10, var5);
      }

      if (var14 >= 0) {
         var14 = this.compareAffix(var1, var11, true, false, var7, var10, var5);
      }

      if (var13 >= 0 && var14 >= 0) {
         if (var13 > var14) {
            var14 = -1;
         } else if (var14 > var13) {
            var13 = -1;
         }
      }

      if (var13 >= 0 == var14 >= 0) {
         var2.setErrorIndex(var11);
         return false;
      } else {
         var11 += var13 >= 0 ? var13 : var14;
         if (this.formatWidth > 0 && this.padPosition == 3) {
            var11 = this.skipPadding(var1, var11);
         }

         var2.setIndex(var11);
         var4[1] = var13 >= 0;
         if (var2.getIndex() == var12) {
            var2.setErrorIndex(var11);
            return false;
         } else {
            return true;
         }
      }
   }

   private int countCodePoints(String var1, int var2, int var3) {
      int var4 = 0;
      int var5 = var2;

      while (var5 < var3) {
         var4++;
         var5 += UTF16.getCharCount(UTF16.charAt(var1, var5));
      }

      return var4;
   }

   private UnicodeSet getEquivalentDecimals(char var1, boolean var2) {
      UnicodeSet var3 = UnicodeSet.EMPTY;
      if (var2) {
         if (strictDotEquivalents.contains(var1)) {
            var3 = strictDotEquivalents;
         } else if (strictCommaEquivalents.contains(var1)) {
            var3 = strictCommaEquivalents;
         }
      } else if (dotEquivalents.contains(var1)) {
         var3 = dotEquivalents;
      } else if (commaEquivalents.contains(var1)) {
         var3 = commaEquivalents;
      }

      return var3;
   }

   private final int skipPadding(String var1, int var2) {
      while (var2 < var1.length() && var1.charAt(var2) == this.pad) {
         var2++;
      }

      return var2;
   }

   private int compareAffix(String var1, int var2, boolean var3, boolean var4, String var5, int var6, Currency[] var7) {
      if (var7 != null || this.currencyChoice != null || this.currencySignCount > 0) {
         return this.compareComplexAffix(var5, var1, var2, var6, var7);
      } else {
         return var4
            ? compareSimpleAffix(var3 ? this.negativePrefix : this.positivePrefix, var1, var2)
            : compareSimpleAffix(var3 ? this.negativeSuffix : this.positiveSuffix, var1, var2);
      }
   }

   private static int compareSimpleAffix(String var0, String var1, int var2) {
      int var3 = var2;
      int var4 = 0;

      while (var4 < var0.length()) {
         int var5 = UTF16.charAt(var0, var4);
         int var6 = UTF16.getCharCount(var5);
         if (!PatternProps.isWhiteSpace(var5)) {
            if (var2 >= var1.length() || UTF16.charAt(var1, var2) != var5) {
               return -1;
            }

            var4 += var6;
            var2 += var6;
         } else {
            boolean var7 = false;

            while (true) {
               if (var2 < var1.length() && UTF16.charAt(var1, var2) == var5) {
                  var7 = true;
                  var4 += var6;
                  var2 += var6;
                  if (var4 != var0.length()) {
                     var5 = UTF16.charAt(var0, var4);
                     var6 = UTF16.getCharCount(var5);
                     if (PatternProps.isWhiteSpace(var5)) {
                        continue;
                     }
                  }
               }

               var4 = skipPatternWhiteSpace(var0, var4);
               int var8 = var2;
               var2 = skipUWhiteSpace(var1, var2);
               if (var2 == var8 && !var7) {
                  return -1;
               }

               var4 = skipUWhiteSpace(var0, var4);
               break;
            }
         }
      }

      return var2 - var3;
   }

   private static int skipPatternWhiteSpace(String var0, int var1) {
      while (var1 < var0.length()) {
         int var2 = UTF16.charAt(var0, var1);
         if (PatternProps.isWhiteSpace(var2)) {
            var1 += UTF16.getCharCount(var2);
            continue;
         }
         break;
      }

      return var1;
   }

   private static int skipUWhiteSpace(String var0, int var1) {
      while (var1 < var0.length()) {
         int var2 = UTF16.charAt(var0, var1);
         if (UCharacter.isUWhiteSpace(var2)) {
            var1 += UTF16.getCharCount(var2);
            continue;
         }
         break;
      }

      return var1;
   }

   private int compareComplexAffix(String var1, String var2, int var3, int var4, Currency[] var5) {
      int var6 = var3;
      int var7 = 0;

      while (var7 < var1.length() && var3 >= 0) {
         char var8 = var1.charAt(var7++);
         if (var8 == '\'') {
            while (true) {
               int var16 = var1.indexOf(39, var7);
               if (var16 == var7) {
                  var3 = match(var2, var3, 39);
                  var7 = var16 + 1;
                  break;
               }

               if (var16 <= var7) {
                  throw new RuntimeException();
               }

               var3 = match(var2, var3, var1.substring(var7, var16));
               var7 = var16 + 1;
               if (var7 >= var1.length() || var1.charAt(var7) != '\'') {
                  break;
               }

               var3 = match(var2, var3, 39);
               var7++;
            }
         } else {
            switch (var8) {
               case '%':
                  var8 = this.symbols.getPercent();
                  break;
               case '-':
                  var8 = this.symbols.getMinusSign();
                  break;
               case '¤':
                  boolean var9 = var7 < var1.length() && var1.charAt(var7) == 164;
                  if (var9) {
                     var7++;
                  }

                  boolean var10 = var7 < var1.length() && var1.charAt(var7) == 164;
                  if (var10) {
                     var7++;
                     var9 = false;
                  }

                  ULocale var11 = this.getLocale(ULocale.VALID_LOCALE);
                  if (var11 == null) {
                     var11 = this.symbols.getLocale(ULocale.VALID_LOCALE);
                  }

                  ParsePosition var12 = new ParsePosition(var3);
                  String var13 = Currency.parse(var11, var2, var4, var12);
                  if (var13 != null) {
                     if (var5 != null) {
                        var5[0] = Currency.getInstance(var13);
                     } else {
                        Currency var14 = this.getEffectiveCurrency();
                        if (var13.compareTo(var14.getCurrencyCode()) != 0) {
                           var3 = -1;
                           continue;
                        }
                     }

                     var3 = var12.getIndex();
                     continue;
                  }

                  var3 = -1;
                  continue;
               case '‰':
                  var8 = this.symbols.getPerMill();
            }

            var3 = match(var2, var3, var8);
            if (PatternProps.isWhiteSpace(var8)) {
               var7 = skipPatternWhiteSpace(var1, var7);
            }
         }
      }

      return var3 - var6;
   }

   static final int match(String var0, int var1, int var2) {
      if (var1 >= var0.length()) {
         return -1;
      } else if (PatternProps.isWhiteSpace(var2)) {
         int var4 = skipPatternWhiteSpace(var0, var1);
         return var4 == var1 ? -1 : var4;
      } else {
         return var1 >= 0 && UTF16.charAt(var0, var1) == var2 ? var1 + UTF16.getCharCount(var2) : -1;
      }
   }

   static final int match(String var0, int var1, String var2) {
      int var3 = 0;

      while (var3 < var2.length() && var1 >= 0) {
         int var4 = UTF16.charAt(var2, var3);
         var3 += UTF16.getCharCount(var4);
         var1 = match(var0, var1, var4);
         if (PatternProps.isWhiteSpace(var4)) {
            var3 = skipPatternWhiteSpace(var2, var3);
         }
      }

      return var1;
   }

   public DecimalFormatSymbols getDecimalFormatSymbols() {
      try {
         return (DecimalFormatSymbols)this.symbols.clone();
      } catch (Exception var2) {
         return null;
      }
   }

   public void setDecimalFormatSymbols(DecimalFormatSymbols var1) {
      this.symbols = (DecimalFormatSymbols)var1.clone();
      this.setCurrencyForSymbols();
      this.expandAffixes(null);
   }

   private void setCurrencyForSymbols() {
      DecimalFormatSymbols var1 = new DecimalFormatSymbols(this.symbols.getULocale());
      if (this.symbols.getCurrencySymbol().equals(var1.getCurrencySymbol())
         && this.symbols.getInternationalCurrencySymbol().equals(var1.getInternationalCurrencySymbol())) {
         this.setCurrency(Currency.getInstance(this.symbols.getULocale()));
      } else {
         this.setCurrency(null);
      }
   }

   public String getPositivePrefix() {
      return this.positivePrefix;
   }

   public void setPositivePrefix(String var1) {
      this.positivePrefix = var1;
      this.posPrefixPattern = null;
   }

   public String getNegativePrefix() {
      return this.negativePrefix;
   }

   public void setNegativePrefix(String var1) {
      this.negativePrefix = var1;
      this.negPrefixPattern = null;
   }

   public String getPositiveSuffix() {
      return this.positiveSuffix;
   }

   public void setPositiveSuffix(String var1) {
      this.positiveSuffix = var1;
      this.posSuffixPattern = null;
   }

   public String getNegativeSuffix() {
      return this.negativeSuffix;
   }

   public void setNegativeSuffix(String var1) {
      this.negativeSuffix = var1;
      this.negSuffixPattern = null;
   }

   public int getMultiplier() {
      return this.multiplier;
   }

   public void setMultiplier(int var1) {
      if (var1 == 0) {
         throw new IllegalArgumentException("Bad multiplier: " + var1);
      } else {
         this.multiplier = var1;
      }
   }

   public BigDecimal getRoundingIncrement() {
      return this.roundingIncrementICU == null ? null : this.roundingIncrementICU.toBigDecimal();
   }

   public void setRoundingIncrement(BigDecimal var1) {
      if (var1 == null) {
         this.setRoundingIncrement((com.ibm.icu.math.BigDecimal)null);
      } else {
         this.setRoundingIncrement(new com.ibm.icu.math.BigDecimal(var1));
      }
   }

   public void setRoundingIncrement(com.ibm.icu.math.BigDecimal var1) {
      int var2 = var1 == null ? 0 : var1.compareTo(com.ibm.icu.math.BigDecimal.ZERO);
      if (var2 < 0) {
         throw new IllegalArgumentException("Illegal rounding increment");
      } else {
         if (var2 == 0) {
            this.setInternalRoundingIncrement(null);
         } else {
            this.setInternalRoundingIncrement(var1);
         }

         this.setRoundingDouble();
      }
   }

   public void setRoundingIncrement(double var1) {
      if (var1 < 0.0) {
         throw new IllegalArgumentException("Illegal rounding increment");
      } else {
         this.roundingDouble = var1;
         this.roundingDoubleReciprocal = 0.0;
         if (var1 == 0.0) {
            this.setRoundingIncrement((com.ibm.icu.math.BigDecimal)null);
         } else {
            this.roundingDouble = var1;
            if (this.roundingDouble < 1.0) {
               double var3 = 1.0 / this.roundingDouble;
               this.setRoundingDoubleReciprocal(var3);
            }

            this.setInternalRoundingIncrement(new com.ibm.icu.math.BigDecimal(var1));
         }
      }
   }

   private void setRoundingDoubleReciprocal(double var1) {
      this.roundingDoubleReciprocal = Math.rint(var1);
      if (Math.abs(var1 - this.roundingDoubleReciprocal) > 1.0E-9) {
         this.roundingDoubleReciprocal = 0.0;
      }
   }

   public int getRoundingMode() {
      return this.roundingMode;
   }

   public void setRoundingMode(int var1) {
      if (var1 >= 0 && var1 <= 7) {
         this.roundingMode = var1;
         if (this.getRoundingIncrement() == null) {
            this.setRoundingIncrement(Math.pow(10.0, -this.getMaximumFractionDigits()));
         }
      } else {
         throw new IllegalArgumentException("Invalid rounding mode: " + var1);
      }
   }

   public int getFormatWidth() {
      return this.formatWidth;
   }

   public void setFormatWidth(int var1) {
      if (var1 < 0) {
         throw new IllegalArgumentException("Illegal format width");
      } else {
         this.formatWidth = var1;
      }
   }

   public char getPadCharacter() {
      return this.pad;
   }

   public void setPadCharacter(char var1) {
      this.pad = var1;
   }

   public int getPadPosition() {
      return this.padPosition;
   }

   public void setPadPosition(int var1) {
      if (var1 >= 0 && var1 <= 3) {
         this.padPosition = var1;
      } else {
         throw new IllegalArgumentException("Illegal pad position");
      }
   }

   public boolean isScientificNotation() {
      return this.useExponentialNotation;
   }

   public void setScientificNotation(boolean var1) {
      this.useExponentialNotation = var1;
   }

   public byte getMinimumExponentDigits() {
      return this.minExponentDigits;
   }

   public void setMinimumExponentDigits(byte var1) {
      if (var1 < 1) {
         throw new IllegalArgumentException("Exponent digits must be >= 1");
      } else {
         this.minExponentDigits = var1;
      }
   }

   public boolean isExponentSignAlwaysShown() {
      return this.exponentSignAlwaysShown;
   }

   public void setExponentSignAlwaysShown(boolean var1) {
      this.exponentSignAlwaysShown = var1;
   }

   public int getGroupingSize() {
      return this.groupingSize;
   }

   public void setGroupingSize(int var1) {
      this.groupingSize = (byte)var1;
   }

   public int getSecondaryGroupingSize() {
      return this.groupingSize2;
   }

   public void setSecondaryGroupingSize(int var1) {
      this.groupingSize2 = (byte)var1;
   }

   public MathContext getMathContextICU() {
      return this.mathContext;
   }

   public java.math.MathContext getMathContext() {
      try {
         return this.mathContext == null
            ? null
            : new java.math.MathContext(this.mathContext.getDigits(), RoundingMode.valueOf(this.mathContext.getRoundingMode()));
      } catch (Exception var2) {
         return null;
      }
   }

   public void setMathContextICU(MathContext var1) {
      this.mathContext = var1;
   }

   public void setMathContext(java.math.MathContext var1) {
      this.mathContext = new MathContext(var1.getPrecision(), 1, false, var1.getRoundingMode().ordinal());
   }

   public boolean isDecimalSeparatorAlwaysShown() {
      return this.decimalSeparatorAlwaysShown;
   }

   public void setDecimalSeparatorAlwaysShown(boolean var1) {
      this.decimalSeparatorAlwaysShown = var1;
   }

   public CurrencyPluralInfo getCurrencyPluralInfo() {
      try {
         return this.currencyPluralInfo == null ? null : (CurrencyPluralInfo)this.currencyPluralInfo.clone();
      } catch (Exception var2) {
         return null;
      }
   }

   public void setCurrencyPluralInfo(CurrencyPluralInfo var1) {
      this.currencyPluralInfo = (CurrencyPluralInfo)var1.clone();
      this.isReadyForParsing = false;
   }

   public Object clone() {
      try {
         DecimalFormat var1 = (DecimalFormat)super.clone();
         var1.symbols = (DecimalFormatSymbols)this.symbols.clone();
         var1.digitList = new DigitList();
         if (this.currencyPluralInfo != null) {
            var1.currencyPluralInfo = (CurrencyPluralInfo)this.currencyPluralInfo.clone();
         }

         var1.attributes = new ArrayList<>();
         return var1;
      } catch (Exception var2) {
         throw new IllegalStateException();
      }
   }

   public boolean equals(Object var1) {
      if (var1 == null) {
         return false;
      } else if (!super.equals(var1)) {
         return false;
      } else {
         DecimalFormat var2 = (DecimalFormat)var1;
         return this.currencySignCount == var2.currencySignCount
            && (
               this.style != 6
                  || this.equals(this.posPrefixPattern, var2.posPrefixPattern)
                     && this.equals(this.posSuffixPattern, var2.posSuffixPattern)
                     && this.equals(this.negPrefixPattern, var2.negPrefixPattern)
                     && this.equals(this.negSuffixPattern, var2.negSuffixPattern)
            )
            && this.multiplier == var2.multiplier
            && this.groupingSize == var2.groupingSize
            && this.groupingSize2 == var2.groupingSize2
            && this.decimalSeparatorAlwaysShown == var2.decimalSeparatorAlwaysShown
            && this.useExponentialNotation == var2.useExponentialNotation
            && (!this.useExponentialNotation || this.minExponentDigits == var2.minExponentDigits)
            && this.useSignificantDigits == var2.useSignificantDigits
            && (!this.useSignificantDigits || this.minSignificantDigits == var2.minSignificantDigits && this.maxSignificantDigits == var2.maxSignificantDigits)
            && this.symbols.equals(var2.symbols)
            && Utility.objectEquals(this.currencyPluralInfo, var2.currencyPluralInfo);
      }
   }

   private boolean equals(String var1, String var2) {
      if (var1 != null && var2 != null) {
         return var1.equals(var2) ? true : this.unquote(var1).equals(this.unquote(var2));
      } else {
         return var1 == null && var2 == null;
      }
   }

   private String unquote(String var1) {
      StringBuilder var2 = new StringBuilder(var1.length());
      int var3 = 0;

      while (var3 < var1.length()) {
         char var4 = var1.charAt(var3++);
         if (var4 != '\'') {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   public int hashCode() {
      return super.hashCode() * 37 + this.positivePrefix.hashCode();
   }

   public String toPattern() {
      return this.style == 6 ? this.formatPattern : this.toPattern(false);
   }

   public String toLocalizedPattern() {
      return this.style == 6 ? this.formatPattern : this.toPattern(true);
   }

   private void expandAffixes(String var1) {
      this.currencyChoice = null;
      StringBuffer var2 = new StringBuffer();
      if (this.posPrefixPattern != null) {
         this.expandAffix(this.posPrefixPattern, var1, var2, false);
         this.positivePrefix = var2.toString();
      }

      if (this.posSuffixPattern != null) {
         this.expandAffix(this.posSuffixPattern, var1, var2, false);
         this.positiveSuffix = var2.toString();
      }

      if (this.negPrefixPattern != null) {
         this.expandAffix(this.negPrefixPattern, var1, var2, false);
         this.negativePrefix = var2.toString();
      }

      if (this.negSuffixPattern != null) {
         this.expandAffix(this.negSuffixPattern, var1, var2, false);
         this.negativeSuffix = var2.toString();
      }
   }

   private void expandAffix(String var1, String var2, StringBuffer var3, boolean var4) {
      var3.setLength(0);
      int var5 = 0;

      while (var5 < var1.length()) {
         char var6 = var1.charAt(var5++);
         if (var6 == '\'') {
            while (true) {
               int var13 = var1.indexOf(39, var5);
               if (var13 == var5) {
                  var3.append('\'');
                  var5 = var13 + 1;
                  break;
               }

               if (var13 <= var5) {
                  throw new RuntimeException();
               }

               var3.append(var1.substring(var5, var13));
               var5 = var13 + 1;
               if (var5 >= var1.length() || var1.charAt(var5) != '\'') {
                  break;
               }

               var3.append('\'');
               var5++;
            }
         } else {
            switch (var6) {
               case '%':
                  var6 = this.symbols.getPercent();
                  break;
               case '-':
                  var6 = this.symbols.getMinusSign();
                  break;
               case '¤':
                  boolean var7 = var5 < var1.length() && var1.charAt(var5) == 164;
                  boolean var8 = false;
                  if (var7) {
                     var5++;
                     if (var5 < var1.length() && var1.charAt(var5) == 164) {
                        var8 = true;
                        var7 = false;
                        var5++;
                     }
                  }

                  Object var9 = null;
                  Currency var10 = this.getCurrency();
                  if (var10 != null) {
                     if (var8 && var2 != null) {
                        boolean[] var15 = new boolean[1];
                        var9 = var10.getName(this.symbols.getULocale(), 2, var2, var15);
                     } else if (!var7) {
                        boolean[] var11 = new boolean[1];
                        var9 = var10.getName(this.symbols.getULocale(), 0, var11);
                        if (var11[0]) {
                           if (var4) {
                              FieldPosition var12 = new FieldPosition(0);
                              this.currencyChoice.format(this.digitList.getDouble(), var3, var12);
                              continue;
                           }

                           if (this.currencyChoice == null) {
                              this.currencyChoice = new ChoiceFormat((String)var9);
                           }

                           var9 = String.valueOf('¤');
                        }
                     } else {
                        var9 = var10.getCurrencyCode();
                     }
                  } else {
                     var9 = var7 ? this.symbols.getInternationalCurrencySymbol() : this.symbols.getCurrencySymbol();
                  }

                  var3.append((String)var9);
                  continue;
               case '‰':
                  var6 = this.symbols.getPerMill();
            }

            var3.append(var6);
         }
      }
   }

   private int appendAffix(StringBuffer var1, boolean var2, boolean var3, boolean var4) {
      if (this.currencyChoice != null) {
         Object var8 = null;
         if (var3) {
            var8 = var2 ? this.negPrefixPattern : this.posPrefixPattern;
         } else {
            var8 = var2 ? this.negSuffixPattern : this.posSuffixPattern;
         }

         StringBuffer var10 = new StringBuffer();
         this.expandAffix((String)var8, null, var10, true);
         var1.append(var10);
         return var10.length();
      } else {
         String var5 = null;
         if (var3) {
            var5 = var2 ? this.negativePrefix : this.positivePrefix;
         } else {
            var5 = var2 ? this.negativeSuffix : this.positiveSuffix;
         }

         if (var4) {
            int var6 = var5.indexOf(this.symbols.getCurrencySymbol());
            if (-1 == var6) {
               var6 = var5.indexOf(this.symbols.getPercent());
               if (-1 == var6) {
                  var6 = 0;
               }
            }

            this.formatAffix2Attribute(var5, var1.length() + var6, var1.length() + var5.length());
         }

         var1.append(var5);
         return var5.length();
      }
   }

   private void formatAffix2Attribute(String var1, int var2, int var3) {
      if (var1.indexOf(this.symbols.getCurrencySymbol()) > -1) {
         this.addAttribute(Field.CURRENCY, var2, var3);
      } else if (var1.indexOf(this.symbols.getMinusSign()) > -1) {
         this.addAttribute(Field.SIGN, var2, var3);
      } else if (var1.indexOf(this.symbols.getPercent()) > -1) {
         this.addAttribute(Field.PERCENT, var2, var3);
      } else if (var1.indexOf(this.symbols.getPerMill()) > -1) {
         this.addAttribute(Field.PERMILLE, var2, var3);
      }
   }

   private void addAttribute(Field var1, int var2, int var3) {
      FieldPosition var4 = new FieldPosition(var1);
      var4.setBeginIndex(var2);
      var4.setEndIndex(var3);
      this.attributes.add(var4);
   }

   public AttributedCharacterIterator formatToCharacterIterator(Object var1) {
      return this.formatToCharacterIterator(var1, NULL_UNIT);
   }

   AttributedCharacterIterator formatToCharacterIterator(Object var1, DecimalFormat.Unit var2) {
      if (!(var1 instanceof Number)) {
         throw new IllegalArgumentException();
      } else {
         Number var3 = (Number)var1;
         StringBuffer var4 = new StringBuffer();
         var2.writePrefix(var4);
         this.attributes.clear();
         if (var1 instanceof BigInteger) {
            this.format((BigInteger)var3, var4, new FieldPosition(0), true);
         } else if (var1 instanceof BigDecimal) {
            this.format((BigDecimal)var3, var4, new FieldPosition(0), true);
         } else if (var1 instanceof Double) {
            this.format(var3.doubleValue(), var4, new FieldPosition(0), true);
         } else {
            if (!(var1 instanceof Integer) && !(var1 instanceof Long)) {
               throw new IllegalArgumentException();
            }

            this.format(var3.longValue(), var4, new FieldPosition(0), true);
         }

         var2.writeSuffix(var4);
         AttributedString var5 = new AttributedString(var4.toString());

         for (int var6 = 0; var6 < this.attributes.size(); var6++) {
            FieldPosition var7 = this.attributes.get(var6);
            java.text.Format.Field var8 = var7.getFieldAttribute();
            var5.addAttribute(var8, var8, var7.getBeginIndex(), var7.getEndIndex());
         }

         return var5.getIterator();
      }
   }

   private void appendAffixPattern(StringBuffer var1, boolean var2, boolean var3, boolean var4) {
      String var5 = null;
      if (var3) {
         var5 = var2 ? this.negPrefixPattern : this.posPrefixPattern;
      } else {
         var5 = var2 ? this.negSuffixPattern : this.posSuffixPattern;
      }

      if (var5 == null) {
         String var10 = null;
         if (var3) {
            var10 = var2 ? this.negativePrefix : this.positivePrefix;
         } else {
            var10 = var2 ? this.negativeSuffix : this.positiveSuffix;
         }

         var1.append('\'');

         for (int var12 = 0; var12 < var10.length(); var12++) {
            char var13 = var10.charAt(var12);
            if (var13 == '\'') {
               var1.append(var13);
            }

            var1.append(var13);
         }

         var1.append('\'');
      } else {
         if (!var4) {
            var1.append(var5);
         } else {
            for (int var6 = 0; var6 < var5.length(); var6++) {
               char var8 = var5.charAt(var6);
               switch (var8) {
                  case '%':
                     var8 = this.symbols.getPercent();
                     break;
                  case '\'':
                     int var7 = var5.indexOf(39, var6 + 1);
                     if (var7 < 0) {
                        throw new IllegalArgumentException("Malformed affix pattern: " + var5);
                     }

                     var1.append(var5.substring(var6, var7 + 1));
                     var6 = var7;
                     continue;
                  case '-':
                     var8 = this.symbols.getMinusSign();
                     break;
                  case '‰':
                     var8 = this.symbols.getPerMill();
               }

               if (var8 != this.symbols.getDecimalSeparator() && var8 != this.symbols.getGroupingSeparator()) {
                  var1.append(var8);
               } else {
                  var1.append('\'');
                  var1.append(var8);
                  var1.append('\'');
               }
            }
         }
      }
   }

   private String toPattern(boolean var1) {
      StringBuffer var2 = new StringBuffer();
      char var3 = var1 ? this.symbols.getZeroDigit() : 48;
      char var4 = var1 ? this.symbols.getDigit() : 35;
      char var5 = 0;
      boolean var6 = this.areSignificantDigitsUsed();
      if (var6) {
         var5 = var1 ? this.symbols.getSignificantDigit() : 64;
      }

      char var7 = var1 ? this.symbols.getGroupingSeparator() : 44;
      int var9 = 0;
      String var10 = null;
      int var11 = this.formatWidth > 0 ? this.padPosition : -1;
      String var12 = this.formatWidth > 0 ? new StringBuffer(2).append(var1 ? this.symbols.getPadEscape() : '*').append(this.pad).toString() : null;
      if (this.roundingIncrementICU != null) {
         int var8 = this.roundingIncrementICU.scale();
         var10 = this.roundingIncrementICU.movePointRight(var8).toString();
         var9 = var10.length() - var8;
      }

      for (int var13 = 0; var13 < 2; var13++) {
         if (var11 == 0) {
            var2.append(var12);
         }

         this.appendAffixPattern(var2, var13 != 0, true, var1);
         if (var11 == 1) {
            var2.append(var12);
         }

         int var14 = var2.length();
         int var15 = this.isGroupingUsed() ? Math.max(0, this.groupingSize) : 0;
         if (var15 > 0 && this.groupingSize2 > 0 && this.groupingSize2 != this.groupingSize) {
            var15 += this.groupingSize2;
         }

         int var16 = 0;
         int var17 = 0;
         int var18 = 0;
         if (var6) {
            var17 = this.getMinimumSignificantDigits();
            var16 = var18 = this.getMaximumSignificantDigits();
         } else {
            var17 = this.getMinimumIntegerDigits();
            var16 = this.getMaximumIntegerDigits();
         }

         if (this.useExponentialNotation) {
            if (var16 > 8) {
               var16 = 1;
            }
         } else if (var6) {
            var16 = Math.max(var16, var15 + 1);
         } else {
            var16 = Math.max(Math.max(var15, this.getMinimumIntegerDigits()), var9) + 1;
         }

         for (int var20 = var16; var20 > 0; var20--) {
            if (!this.useExponentialNotation && var20 < var16 && this.isGroupingPosition(var20)) {
               var2.append(var7);
            }

            if (var6) {
               var2.append(var18 >= var20 && var20 > var18 - var17 ? var5 : var4);
            } else {
               if (var10 != null) {
                  int var19 = var9 - var20;
                  if (var19 >= 0 && var19 < var10.length()) {
                     var2.append((char)(var10.charAt(var19) - '0' + var3));
                     continue;
                  }
               }

               var2.append(var20 <= var17 ? var3 : var4);
            }
         }

         if (!var6) {
            if (this.getMaximumFractionDigits() > 0 || this.decimalSeparatorAlwaysShown) {
               var2.append(var1 ? this.symbols.getDecimalSeparator() : '.');
            }

            int var25 = var9;

            for (int var21 = 0; var21 < this.getMaximumFractionDigits(); var21++) {
               if (var10 != null && var25 < var10.length()) {
                  var2.append(var25 < 0 ? var3 : (char)(var10.charAt(var25) - '0' + var3));
                  var25++;
               } else {
                  var2.append(var21 < this.getMinimumFractionDigits() ? var3 : var4);
               }
            }
         }

         if (this.useExponentialNotation) {
            if (var1) {
               var2.append(this.symbols.getExponentSeparator());
            } else {
               var2.append('E');
            }

            if (this.exponentSignAlwaysShown) {
               var2.append(var1 ? this.symbols.getPlusSign() : '+');
            }

            for (int var22 = 0; var22 < this.minExponentDigits; var22++) {
               var2.append(var3);
            }
         }

         if (var12 != null && !this.useExponentialNotation) {
            int var26 = this.formatWidth
               - var2.length()
               + var14
               - (var13 == 0 ? this.positivePrefix.length() + this.positiveSuffix.length() : this.negativePrefix.length() + this.negativeSuffix.length());

            while (var26 > 0) {
               var2.insert(var14, var4);
               var16++;
               if (--var26 > 1 && this.isGroupingPosition(var16)) {
                  var2.insert(var14, var7);
                  var26--;
               }
            }
         }

         if (var11 == 2) {
            var2.append(var12);
         }

         this.appendAffixPattern(var2, var13 != 0, false, var1);
         if (var11 == 3) {
            var2.append(var12);
         }

         if (var13 == 0) {
            if (this.negativeSuffix.equals(this.positiveSuffix) && this.negativePrefix.equals('-' + this.positivePrefix)) {
               break;
            }

            var2.append(var1 ? this.symbols.getPatternSeparator() : ';');
         }
      }

      return var2.toString();
   }

   public void applyPattern(String var1) {
      this.applyPattern(var1, false);
   }

   public void applyLocalizedPattern(String var1) {
      this.applyPattern(var1, true);
   }

   private void applyPattern(String var1, boolean var2) {
      this.applyPatternWithoutExpandAffix(var1, var2);
      this.expandAffixAdjustWidth(null);
   }

   private void expandAffixAdjustWidth(String var1) {
      this.expandAffixes(var1);
      if (this.formatWidth > 0) {
         this.formatWidth = this.formatWidth + this.positivePrefix.length() + this.positiveSuffix.length();
      }
   }

   private void applyPatternWithoutExpandAffix(String var1, boolean var2) {
      char var3 = '0';
      char var4 = '@';
      char var5 = ',';
      char var6 = '.';
      char var7 = '%';
      char var8 = 8240;
      char var9 = '#';
      char var10 = ';';
      String var11 = String.valueOf('E');
      char var12 = '+';
      char var13 = '*';
      char var14 = '-';
      if (var2) {
         var3 = this.symbols.getZeroDigit();
         var4 = this.symbols.getSignificantDigit();
         var5 = this.symbols.getGroupingSeparator();
         var6 = this.symbols.getDecimalSeparator();
         var7 = this.symbols.getPercent();
         var8 = this.symbols.getPerMill();
         var9 = this.symbols.getDigit();
         var10 = this.symbols.getPatternSeparator();
         var11 = this.symbols.getExponentSeparator();
         var12 = this.symbols.getPlusSign();
         var13 = this.symbols.getPadEscape();
         var14 = this.symbols.getMinusSign();
      }

      char var15 = (char)(var3 + '\t');
      boolean var16 = false;
      int var17 = 0;

      for (int var18 = 0; var18 < 2 && var17 < var1.length(); var18++) {
         byte var19 = 1;
         int var20 = 0;
         int var21 = 0;
         int var22 = 0;
         StringBuilder var23 = new StringBuilder();
         StringBuilder var24 = new StringBuilder();
         int var25 = -1;
         int var26 = 1;
         int var27 = 0;
         int var28 = 0;
         int var29 = 0;
         int var30 = 0;
         byte var31 = -1;
         byte var32 = -1;
         int var33 = -1;
         char var34 = 0;
         int var35 = -1;
         long var36 = 0L;
         byte var38 = -1;
         boolean var39 = false;
         byte var40 = 0;
         StringBuilder var41 = var23;

         int var42;
         label496:
         for (var42 = var17; var17 < var1.length(); var17++) {
            int var43 = var1.charAt(var17);
            switch (var19) {
               case 0:
                  if (var43 == var9) {
                     if (var28 <= 0 && var30 <= 0) {
                        var27++;
                     } else {
                        var29++;
                     }

                     if (var31 >= 0 && var25 < 0) {
                        var31++;
                     }
                  } else if ((var43 < var3 || var43 > var15) && var43 != var4) {
                     if (var43 == var5) {
                        if (var43 == 39 && var17 + 1 < var1.length()) {
                           char var52 = var1.charAt(var17 + 1);
                           if (var52 != var9 && (var52 < var3 || var52 > var15)) {
                              if (var52 != '\'') {
                                 if (var31 < 0) {
                                    var19 = 3;
                                 } else {
                                    var19 = 2;
                                    var41 = var24;
                                    var21 = var17--;
                                 }
                                 continue;
                              }

                              var17++;
                           }
                        }

                        if (var25 >= 0) {
                           this.patternError("Grouping separator after decimal", var1);
                        }

                        var32 = var31;
                        var31 = 0;
                     } else if (var43 == var6) {
                        if (var25 >= 0) {
                           this.patternError("Multiple decimal separators", var1);
                        }

                        var25 = var27 + var28 + var29;
                     } else {
                        if (var1.regionMatches(var17, var11, 0, var11.length())) {
                           if (var38 >= 0) {
                              this.patternError("Multiple exponential symbols", var1);
                           }

                           if (var31 >= 0) {
                              this.patternError("Grouping separator in exponential", var1);
                           }

                           var17 += var11.length();
                           if (var17 < var1.length() && var1.charAt(var17) == var12) {
                              var39 = true;
                              var17++;
                           }

                           for (var38 = 0; var17 < var1.length() && var1.charAt(var17) == var3; var17++) {
                              var38++;
                           }

                           if (var27 + var28 < 1 && var30 + var29 < 1 || var30 > 0 && var27 > 0 || var38 < 1) {
                              this.patternError("Malformed exponential", var1);
                           }
                        }

                        var19 = 2;
                        var41 = var24;
                        var21 = var17--;
                     }
                  } else {
                     if (var29 > 0) {
                        this.patternError("Unexpected '" + var43 + '\'', var1);
                     }

                     if (var43 == var4) {
                        var30++;
                     } else {
                        var28++;
                        if (var43 != var3) {
                           int var51 = var27 + var28 + var29;
                           if (var35 >= 0) {
                              while (var35 < var51) {
                                 var36 *= 10L;
                                 var35++;
                              }
                           } else {
                              var35 = var51;
                           }

                           var36 += var43 - var3;
                        }
                     }

                     if (var31 >= 0 && var25 < 0) {
                        var31++;
                     }
                  }
                  break;
               case 1:
               case 2:
                  if (var43 != var9 && var43 != var5 && var43 != var6 && (var43 < var3 || var43 > var15) && var43 != var4) {
                     if (var43 == 164) {
                        boolean var44 = var17 + 1 < var1.length() && var1.charAt(var17 + 1) == 164;
                        if (var44) {
                           var17++;
                           var41.append((char)var43);
                           if (var17 + 1 < var1.length() && var1.charAt(var17 + 1) == 164) {
                              var17++;
                              var41.append((char)var43);
                              var40 = 3;
                           } else {
                              var40 = 2;
                           }
                        } else {
                           var40 = 1;
                        }
                     } else if (var43 == 39) {
                        if (var17 + 1 < var1.length() && var1.charAt(var17 + 1) == '\'') {
                           var17++;
                           var41.append((char)var43);
                        } else {
                           var19 += 2;
                        }
                     } else {
                        if (var43 == var10) {
                           if (var19 == 1 || var18 == 1) {
                              this.patternError("Unquoted special character '" + var43 + '\'', var1);
                           }

                           var22 = var17++;
                           break label496;
                        }

                        if (var43 != var7 && var43 != var8) {
                           if (var43 == var14) {
                              var43 = 45;
                           } else if (var43 == var13) {
                              if (var33 >= 0) {
                                 this.patternError("Multiple pad specifiers", var1);
                              }

                              if (var17 + 1 == var1.length()) {
                                 this.patternError("Invalid pad specifier", var1);
                              }

                              var33 = var17++;
                              var34 = var1.charAt(var17);
                              break;
                           }
                        } else {
                           if (var26 != 1) {
                              this.patternError("Too many percent/permille characters", var1);
                           }

                           var26 = var43 == var7 ? 100 : 1000;
                           var43 = var43 == var7 ? 37 : 8240;
                        }
                     }
                  } else {
                     if (var19 == 1) {
                        var19 = 0;
                        var20 = var17--;
                        break;
                     }

                     if (var43 == 39) {
                        if (var17 + 1 < var1.length() && var1.charAt(var17 + 1) == '\'') {
                           var17++;
                           var41.append((char)var43);
                        } else {
                           var19 += 2;
                        }
                        break;
                     }

                     this.patternError("Unquoted special character '" + var43 + '\'', var1);
                  }

                  var41.append((char)var43);
                  break;
               case 3:
               case 4:
                  if (var43 == 39) {
                     if (var17 + 1 < var1.length() && var1.charAt(var17 + 1) == '\'') {
                        var17++;
                        var41.append((char)var43);
                     } else {
                        var19 -= 2;
                     }
                  }

                  var41.append((char)var43);
            }
         }

         if (var19 == 3 || var19 == 4) {
            this.patternError("Unterminated quote", var1);
         }

         if (var21 == 0) {
            var21 = var1.length();
         }

         if (var22 == 0) {
            var22 = var1.length();
         }

         if (var28 == 0 && var30 == 0 && var27 > 0 && var25 >= 0) {
            int var49 = var25;
            if (var25 == 0) {
               var49 = var25 + 1;
            }

            var29 = var27 - var49;
            var27 = var49 - 1;
            var28 = 1;
         }

         if (var25 < 0 && var29 > 0 && var30 == 0
            || var25 >= 0 && (var30 > 0 || var25 < var27 || var25 > var27 + var28)
            || var31 == 0
            || var32 == 0
            || var30 > 0 && var28 > 0
            || var19 > 2) {
            this.patternError("Malformed pattern", var1);
         }

         if (var33 >= 0) {
            if (var33 == var42) {
               var33 = 0;
            } else if (var33 + 2 == var20) {
               var33 = 1;
            } else if (var33 == var21) {
               var33 = 2;
            } else if (var33 + 2 == var22) {
               var33 = 3;
            } else {
               this.patternError("Illegal pad position", var1);
            }
         }

         if (var18 == 0) {
            this.posPrefixPattern = this.negPrefixPattern = var23.toString();
            this.posSuffixPattern = this.negSuffixPattern = var24.toString();
            this.useExponentialNotation = var38 >= 0;
            if (this.useExponentialNotation) {
               this.minExponentDigits = var38;
               this.exponentSignAlwaysShown = var39;
            }

            int var50 = var27 + var28 + var29;
            int var53 = var25 >= 0 ? var25 : var50;
            boolean var45 = var30 > 0;
            this.setSignificantDigitsUsed(var45);
            if (var45) {
               this.setMinimumSignificantDigits(var30);
               this.setMaximumSignificantDigits(var30 + var29);
            } else {
               int var46 = var53 - var27;
               this.setMinimumIntegerDigits(var46);
               this.setMaximumIntegerDigits(this.useExponentialNotation ? var27 + var46 : 309);
               this.setMaximumFractionDigits(var25 >= 0 ? var50 - var25 : 0);
               this.setMinimumFractionDigits(var25 >= 0 ? var27 + var28 - var25 : 0);
            }

            this.setGroupingUsed(var31 > 0);
            this.groupingSize = var31 > 0 ? var31 : 0;
            this.groupingSize2 = var32 > 0 && var32 != var31 ? var32 : 0;
            this.multiplier = var26;
            this.setDecimalSeparatorAlwaysShown(var25 == 0 || var25 == var50);
            if (var33 >= 0) {
               this.padPosition = var33;
               this.formatWidth = var21 - var20;
               this.pad = var34;
            } else {
               this.formatWidth = 0;
            }

            if (var36 != 0L) {
               int var54 = var35 - var53;
               this.roundingIncrementICU = com.ibm.icu.math.BigDecimal.valueOf(var36, var54 > 0 ? var54 : 0);
               if (var54 < 0) {
                  this.roundingIncrementICU = this.roundingIncrementICU.movePointRight(-var54);
               }

               this.setRoundingDouble();
               this.roundingMode = 6;
            } else {
               this.setRoundingIncrement((com.ibm.icu.math.BigDecimal)null);
            }

            this.currencySignCount = var40;
         } else {
            this.negPrefixPattern = var23.toString();
            this.negSuffixPattern = var24.toString();
            var16 = true;
         }
      }

      if (var1.length() == 0) {
         this.posPrefixPattern = this.posSuffixPattern = "";
         this.setMinimumIntegerDigits(0);
         this.setMaximumIntegerDigits(309);
         this.setMinimumFractionDigits(0);
         this.setMaximumFractionDigits(340);
      }

      if (!var16 || this.negPrefixPattern.equals(this.posPrefixPattern) && this.negSuffixPattern.equals(this.posSuffixPattern)) {
         this.negSuffixPattern = this.posSuffixPattern;
         this.negPrefixPattern = '-' + this.posPrefixPattern;
      }

      this.setLocale(null, null);
      this.formatPattern = var1;
      if (this.currencySignCount > 0) {
         Currency var47 = this.getCurrency();
         if (var47 != null) {
            this.setRoundingIncrement(var47.getRoundingIncrement());
            int var48 = var47.getDefaultFractionDigits();
            this.setMinimumFractionDigits(var48);
            this.setMaximumFractionDigits(var48);
         }

         if (this.currencySignCount == 3 && this.currencyPluralInfo == null) {
            this.currencyPluralInfo = new CurrencyPluralInfo(this.symbols.getULocale());
         }
      }
   }

   private void setRoundingDouble() {
      if (this.roundingIncrementICU == null) {
         this.roundingDouble = 0.0;
         this.roundingDoubleReciprocal = 0.0;
      } else {
         this.roundingDouble = this.roundingIncrementICU.doubleValue();
         this.setRoundingDoubleReciprocal(1.0 / this.roundingDouble);
      }
   }

   private void patternError(String var1, String var2) {
      throw new IllegalArgumentException(var1 + " in pattern \"" + var2 + '"');
   }

   public void setMaximumIntegerDigits(int var1) {
      super.setMaximumIntegerDigits(Math.min(var1, 309));
   }

   public void setMinimumIntegerDigits(int var1) {
      super.setMinimumIntegerDigits(Math.min(var1, 309));
   }

   public int getMinimumSignificantDigits() {
      return this.minSignificantDigits;
   }

   public int getMaximumSignificantDigits() {
      return this.maxSignificantDigits;
   }

   public void setMinimumSignificantDigits(int var1) {
      if (var1 < 1) {
         var1 = 1;
      }

      int var2 = Math.max(this.maxSignificantDigits, var1);
      this.minSignificantDigits = var1;
      this.maxSignificantDigits = var2;
   }

   public void setMaximumSignificantDigits(int var1) {
      if (var1 < 1) {
         var1 = 1;
      }

      int var2 = Math.min(this.minSignificantDigits, var1);
      this.minSignificantDigits = var2;
      this.maxSignificantDigits = var1;
   }

   public boolean areSignificantDigitsUsed() {
      return this.useSignificantDigits;
   }

   public void setSignificantDigitsUsed(boolean var1) {
      this.useSignificantDigits = var1;
   }

   public void setCurrency(Currency var1) {
      super.setCurrency(var1);
      if (var1 != null) {
         boolean[] var2 = new boolean[1];
         String var3 = var1.getName(this.symbols.getULocale(), 0, var2);
         this.symbols.setCurrency(var1);
         this.symbols.setCurrencySymbol(var3);
      }

      if (this.currencySignCount > 0) {
         if (var1 != null) {
            this.setRoundingIncrement(var1.getRoundingIncrement());
            int var4 = var1.getDefaultFractionDigits();
            this.setMinimumFractionDigits(var4);
            this.setMaximumFractionDigits(var4);
         }

         if (this.currencySignCount != 3) {
            this.expandAffixes(null);
         }
      }
   }

   @Deprecated
   protected Currency getEffectiveCurrency() {
      Currency var1 = this.getCurrency();
      if (var1 == null) {
         var1 = Currency.getInstance(this.symbols.getInternationalCurrencySymbol());
      }

      return var1;
   }

   public void setMaximumFractionDigits(int var1) {
      super.setMaximumFractionDigits(Math.min(var1, 340));
   }

   public void setMinimumFractionDigits(int var1) {
      super.setMinimumFractionDigits(Math.min(var1, 340));
   }

   public void setParseBigDecimal(boolean var1) {
      this.parseBigDecimal = var1;
   }

   public boolean isParseBigDecimal() {
      return this.parseBigDecimal;
   }

   public void setParseMaxDigits(int var1) {
      if (var1 > 0) {
         this.PARSE_MAX_EXPONENT = var1;
      }
   }

   public int getParseMaxDigits() {
      return this.PARSE_MAX_EXPONENT;
   }

   private void writeObject(ObjectOutputStream var1) throws IOException {
      this.attributes.clear();
      var1.defaultWriteObject();
   }

   private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
      var1.defaultReadObject();
      if (this.getMaximumIntegerDigits() > 309) {
         this.setMaximumIntegerDigits(309);
      }

      if (this.getMaximumFractionDigits() > 340) {
         this.setMaximumFractionDigits(340);
      }

      if (this.serialVersionOnStream < 2) {
         this.exponentSignAlwaysShown = false;
         this.setInternalRoundingIncrement(null);
         this.setRoundingDouble();
         this.roundingMode = 6;
         this.formatWidth = 0;
         this.pad = ' ';
         this.padPosition = 0;
         if (this.serialVersionOnStream < 1) {
            this.useExponentialNotation = false;
         }
      }

      if (this.serialVersionOnStream < 3) {
         this.setCurrencyForSymbols();
      }

      this.serialVersionOnStream = 3;
      this.digitList = new DigitList();
      if (this.roundingIncrement != null) {
         this.setInternalRoundingIncrement(new com.ibm.icu.math.BigDecimal(this.roundingIncrement));
         this.setRoundingDouble();
      }
   }

   private void setInternalRoundingIncrement(com.ibm.icu.math.BigDecimal var1) {
      this.roundingIncrementICU = var1;
      this.roundingIncrement = var1 == null ? null : var1.toBigDecimal();
   }

   private static final class AffixForCurrency {
      private String negPrefixPatternForCurrency = null;
      private String negSuffixPatternForCurrency = null;
      private String posPrefixPatternForCurrency = null;
      private String posSuffixPatternForCurrency = null;
      private final int patternType;

      public AffixForCurrency(String var1, String var2, String var3, String var4, int var5) {
         this.negPrefixPatternForCurrency = var1;
         this.negSuffixPatternForCurrency = var2;
         this.posPrefixPatternForCurrency = var3;
         this.posSuffixPatternForCurrency = var4;
         this.patternType = var5;
      }

      public String getNegPrefix() {
         return this.negPrefixPatternForCurrency;
      }

      public String getNegSuffix() {
         return this.negSuffixPatternForCurrency;
      }

      public String getPosPrefix() {
         return this.posPrefixPatternForCurrency;
      }

      public String getPosSuffix() {
         return this.posSuffixPatternForCurrency;
      }

      public int getPatternType() {
         return this.patternType;
      }
   }

   static class Unit {
      private final String prefix;
      private final String suffix;

      public Unit(String var1, String var2) {
         this.prefix = var1;
         this.suffix = var2;
      }

      public void writeSuffix(StringBuffer var1) {
         var1.append(this.suffix);
      }

      public void writePrefix(StringBuffer var1) {
         var1.append(this.prefix);
      }

      @Override
      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof DecimalFormat.Unit)) {
            return false;
         } else {
            DecimalFormat.Unit var2 = (DecimalFormat.Unit)var1;
            return this.prefix.equals(var2.prefix) && this.suffix.equals(var2.suffix);
         }
      }
   }
}
