/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.CurrencyData;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.text.NumberingSystem;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ChoiceFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;

public class DecimalFormatSymbols
implements Cloneable,
Serializable {
    public static final int CURRENCY_SPC_CURRENCY_MATCH = 0;
    public static final int CURRENCY_SPC_SURROUNDING_MATCH = 1;
    public static final int CURRENCY_SPC_INSERT = 2;
    private String[] currencySpcBeforeSym;
    private String[] currencySpcAfterSym;
    private char zeroDigit;
    private char[] digits;
    private char groupingSeparator;
    private char decimalSeparator;
    private char perMill;
    private char percent;
    private char digit;
    private char sigDigit;
    private char patternSeparator;
    private String infinity;
    private String NaN;
    private char minusSign;
    private String currencySymbol;
    private String intlCurrencySymbol;
    private char monetarySeparator;
    private char monetaryGroupingSeparator;
    private char exponential;
    private String exponentSeparator;
    private char padEscape;
    private char plusSign;
    private Locale requestedLocale;
    private ULocale ulocale;
    private static final long serialVersionUID = 5772796243397350300L;
    private static final int currentSerialVersion = 6;
    private int serialVersionOnStream = 6;
    private static final ICUCache<ULocale, String[][]> cachedLocaleData = new SimpleCache<ULocale, String[][]>();
    private String currencyPattern = null;
    private ULocale validLocale;
    private ULocale actualLocale;
    private transient Currency currency;

    public DecimalFormatSymbols() {
        this.initialize(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public DecimalFormatSymbols(Locale locale) {
        this.initialize(ULocale.forLocale(locale));
    }

    public DecimalFormatSymbols(ULocale uLocale) {
        this.initialize(uLocale);
    }

    public static DecimalFormatSymbols getInstance() {
        return new DecimalFormatSymbols();
    }

    public static DecimalFormatSymbols getInstance(Locale locale) {
        return new DecimalFormatSymbols(locale);
    }

    public static DecimalFormatSymbols getInstance(ULocale uLocale) {
        return new DecimalFormatSymbols(uLocale);
    }

    public static Locale[] getAvailableLocales() {
        return ICUResourceBundle.getAvailableLocales();
    }

    public static ULocale[] getAvailableULocales() {
        return ICUResourceBundle.getAvailableULocales();
    }

    public char getZeroDigit() {
        if (this.digits != null) {
            return this.digits[0];
        }
        return this.zeroDigit;
    }

    public char[] getDigits() {
        if (this.digits != null) {
            return (char[])this.digits.clone();
        }
        char[] cArray = new char[10];
        for (int i = 0; i < 10; ++i) {
            cArray[i] = (char)(this.zeroDigit + i);
        }
        return cArray;
    }

    char[] getDigitsLocal() {
        if (this.digits != null) {
            return this.digits;
        }
        char[] cArray = new char[10];
        for (int i = 0; i < 10; ++i) {
            cArray[i] = (char)(this.zeroDigit + i);
        }
        return cArray;
    }

    public void setZeroDigit(char c) {
        if (this.digits != null) {
            this.digits[0] = c;
            if (Character.digit(c, 10) == 0) {
                for (int i = 1; i < 10; ++i) {
                    this.digits[i] = (char)(c + i);
                }
            }
        } else {
            this.zeroDigit = c;
        }
    }

    public char getSignificantDigit() {
        return this.sigDigit;
    }

    public void setSignificantDigit(char c) {
        this.sigDigit = c;
    }

    public char getGroupingSeparator() {
        return this.groupingSeparator;
    }

    public void setGroupingSeparator(char c) {
        this.groupingSeparator = c;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public void setDecimalSeparator(char c) {
        this.decimalSeparator = c;
    }

    public char getPerMill() {
        return this.perMill;
    }

    public void setPerMill(char c) {
        this.perMill = c;
    }

    public char getPercent() {
        return this.percent;
    }

    public void setPercent(char c) {
        this.percent = c;
    }

    public char getDigit() {
        return this.digit;
    }

    public void setDigit(char c) {
        this.digit = c;
    }

    public char getPatternSeparator() {
        return this.patternSeparator;
    }

    public void setPatternSeparator(char c) {
        this.patternSeparator = c;
    }

    public String getInfinity() {
        return this.infinity;
    }

    public void setInfinity(String string) {
        this.infinity = string;
    }

    public String getNaN() {
        return this.NaN;
    }

    public void setNaN(String string) {
        this.NaN = string;
    }

    public char getMinusSign() {
        return this.minusSign;
    }

    public void setMinusSign(char c) {
        this.minusSign = c;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public void setCurrencySymbol(String string) {
        this.currencySymbol = string;
    }

    public String getInternationalCurrencySymbol() {
        return this.intlCurrencySymbol;
    }

    public void setInternationalCurrencySymbol(String string) {
        this.intlCurrencySymbol = string;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new NullPointerException();
        }
        this.currency = currency;
        this.intlCurrencySymbol = currency.getCurrencyCode();
        this.currencySymbol = currency.getSymbol(this.requestedLocale);
    }

    public char getMonetaryDecimalSeparator() {
        return this.monetarySeparator;
    }

    public char getMonetaryGroupingSeparator() {
        return this.monetaryGroupingSeparator;
    }

    String getCurrencyPattern() {
        return this.currencyPattern;
    }

    public void setMonetaryDecimalSeparator(char c) {
        this.monetarySeparator = c;
    }

    public void setMonetaryGroupingSeparator(char c) {
        this.monetaryGroupingSeparator = c;
    }

    public String getExponentSeparator() {
        return this.exponentSeparator;
    }

    public void setExponentSeparator(String string) {
        this.exponentSeparator = string;
    }

    public char getPlusSign() {
        return this.plusSign;
    }

    public void setPlusSign(char c) {
        this.plusSign = c;
    }

    public char getPadEscape() {
        return this.padEscape;
    }

    public void setPadEscape(char c) {
        this.padEscape = c;
    }

    public String getPatternForCurrencySpacing(int n, boolean bl) {
        if (n < 0 || n > 2) {
            throw new IllegalArgumentException("unknown currency spacing: " + n);
        }
        if (bl) {
            return this.currencySpcBeforeSym[n];
        }
        return this.currencySpcAfterSym[n];
    }

    public void setPatternForCurrencySpacing(int n, boolean bl, String string) {
        if (n < 0 || n > 2) {
            throw new IllegalArgumentException("unknown currency spacing: " + n);
        }
        if (bl) {
            this.currencySpcBeforeSym[n] = string;
        } else {
            this.currencySpcAfterSym[n] = string;
        }
    }

    public Locale getLocale() {
        return this.requestedLocale;
    }

    public ULocale getULocale() {
        return this.ulocale;
    }

    public Object clone() {
        try {
            return (DecimalFormatSymbols)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new IllegalStateException();
        }
    }

    public boolean equals(Object object) {
        int n;
        if (!(object instanceof DecimalFormatSymbols)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        DecimalFormatSymbols decimalFormatSymbols = (DecimalFormatSymbols)object;
        for (n = 0; n <= 2; ++n) {
            if (!this.currencySpcBeforeSym[n].equals(decimalFormatSymbols.currencySpcBeforeSym[n])) {
                return false;
            }
            if (this.currencySpcAfterSym[n].equals(decimalFormatSymbols.currencySpcAfterSym[n])) continue;
            return false;
        }
        if (decimalFormatSymbols.digits == null) {
            for (n = 0; n < 10; ++n) {
                if (this.digits[n] == decimalFormatSymbols.zeroDigit + n) continue;
                return false;
            }
        } else if (!Arrays.equals(this.digits, decimalFormatSymbols.digits)) {
            return false;
        }
        return this.groupingSeparator == decimalFormatSymbols.groupingSeparator && this.decimalSeparator == decimalFormatSymbols.decimalSeparator && this.percent == decimalFormatSymbols.percent && this.perMill == decimalFormatSymbols.perMill && this.digit == decimalFormatSymbols.digit && this.minusSign == decimalFormatSymbols.minusSign && this.patternSeparator == decimalFormatSymbols.patternSeparator && this.infinity.equals(decimalFormatSymbols.infinity) && this.NaN.equals(decimalFormatSymbols.NaN) && this.currencySymbol.equals(decimalFormatSymbols.currencySymbol) && this.intlCurrencySymbol.equals(decimalFormatSymbols.intlCurrencySymbol) && this.padEscape == decimalFormatSymbols.padEscape && this.plusSign == decimalFormatSymbols.plusSign && this.exponentSeparator.equals(decimalFormatSymbols.exponentSeparator) && this.monetarySeparator == decimalFormatSymbols.monetarySeparator && this.monetaryGroupingSeparator == decimalFormatSymbols.monetaryGroupingSeparator;
    }

    public int hashCode() {
        int n = this.digits[0];
        n = n * 37 + this.groupingSeparator;
        n = n * 37 + this.decimalSeparator;
        return n;
    }

    private void initialize(ULocale uLocale) {
        Object object;
        Object[] objectArray;
        String string;
        Object object2;
        ICUResourceBundle iCUResourceBundle;
        String string2;
        String[][] stringArray;
        this.requestedLocale = uLocale.toLocale();
        this.ulocale = uLocale;
        NumberingSystem numberingSystem = NumberingSystem.getInstance(uLocale);
        this.digits = new char[10];
        if (numberingSystem != null && numberingSystem.getRadix() == 10 && !numberingSystem.isAlgorithmic() && NumberingSystem.isValidDigitString(numberingSystem.getDescription())) {
            stringArray = numberingSystem.getDescription();
            this.digits[0] = stringArray.charAt(0);
            this.digits[1] = stringArray.charAt(1);
            this.digits[2] = stringArray.charAt(2);
            this.digits[3] = stringArray.charAt(3);
            this.digits[4] = stringArray.charAt(4);
            this.digits[5] = stringArray.charAt(5);
            this.digits[6] = stringArray.charAt(6);
            this.digits[7] = stringArray.charAt(7);
            this.digits[8] = stringArray.charAt(8);
            this.digits[9] = stringArray.charAt(9);
            string2 = numberingSystem.getName();
        } else {
            this.digits[0] = 48;
            this.digits[1] = 49;
            this.digits[2] = 50;
            this.digits[3] = 51;
            this.digits[4] = 52;
            this.digits[5] = 53;
            this.digits[6] = 54;
            this.digits[7] = 55;
            this.digits[8] = 56;
            this.digits[9] = 57;
            string2 = "latn";
        }
        stringArray = cachedLocaleData.get(uLocale);
        if (stringArray == null) {
            stringArray = new String[1][];
            iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
            boolean bl = string2.equals("latn");
            object2 = "NumberElements/" + string2 + "/symbols/";
            string = "NumberElements/latn/symbols/";
            objectArray = new String[]{"decimal", "group", "list", "percentSign", "minusSign", "plusSign", "exponential", "perMille", "infinity", "nan", "currencyDecimal", "currencyGroup"};
            object = new String[]{".", ",", ";", "%", "-", "+", "E", "\u2030", "\u221e", "NaN", null, null};
            String[] stringArray2 = new String[objectArray.length];
            for (int i = 0; i < objectArray.length; ++i) {
                try {
                    stringArray2[i] = iCUResourceBundle.getStringWithFallback((String)object2 + objectArray[i]);
                    continue;
                }
                catch (MissingResourceException missingResourceException) {
                    if (!bl) {
                        try {
                            stringArray2[i] = iCUResourceBundle.getStringWithFallback(string + objectArray[i]);
                        }
                        catch (MissingResourceException missingResourceException2) {
                            stringArray2[i] = object[i];
                        }
                        continue;
                    }
                    stringArray2[i] = object[i];
                }
            }
            stringArray[0] = stringArray2;
            cachedLocaleData.put(uLocale, stringArray);
        }
        String[] stringArray3 = stringArray[0];
        iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
        ULocale uLocale2 = iCUResourceBundle.getULocale();
        this.setLocale(uLocale2, uLocale2);
        this.decimalSeparator = stringArray3[0].charAt(0);
        this.groupingSeparator = stringArray3[1].charAt(0);
        this.patternSeparator = stringArray3[2].charAt(0);
        this.percent = stringArray3[3].charAt(0);
        this.minusSign = stringArray3[4].charAt(0);
        this.plusSign = stringArray3[5].charAt(0);
        this.exponentSeparator = stringArray3[6];
        this.perMill = stringArray3[7].charAt(0);
        this.infinity = stringArray3[8];
        this.NaN = stringArray3[9];
        this.monetarySeparator = stringArray3[10] != null ? stringArray3[10].charAt(0) : this.decimalSeparator;
        this.monetaryGroupingSeparator = stringArray3[11] != null ? stringArray3[11].charAt(0) : this.groupingSeparator;
        this.digit = (char)35;
        this.padEscape = (char)42;
        this.sigDigit = (char)64;
        object2 = CurrencyData.provider.getInstance(uLocale, true);
        string = null;
        this.currency = Currency.getInstance(uLocale);
        if (this.currency != null) {
            this.intlCurrencySymbol = this.currency.getCurrencyCode();
            objectArray = new boolean[1];
            string = this.currency.getName(uLocale, 0, (boolean[])objectArray);
            this.currencySymbol = objectArray[0] != false ? new ChoiceFormat(string).format(2.0) : string;
            object = ((CurrencyData.CurrencyDisplayInfo)object2).getFormatInfo(this.intlCurrencySymbol);
            if (object != null) {
                this.currencyPattern = object.currencyPattern;
                this.monetarySeparator = object.monetarySeparator;
                this.monetaryGroupingSeparator = object.monetaryGroupingSeparator;
            }
        } else {
            this.intlCurrencySymbol = "XXX";
            this.currencySymbol = "\u00a4";
        }
        this.currencySpcBeforeSym = new String[3];
        this.currencySpcAfterSym = new String[3];
        this.initSpacingInfo(((CurrencyData.CurrencyDisplayInfo)object2).getSpacingInfo());
    }

    private void initSpacingInfo(CurrencyData.CurrencySpacingInfo currencySpacingInfo) {
        this.currencySpcBeforeSym[0] = currencySpacingInfo.beforeCurrencyMatch;
        this.currencySpcBeforeSym[1] = currencySpacingInfo.beforeContextMatch;
        this.currencySpcBeforeSym[2] = currencySpacingInfo.beforeInsert;
        this.currencySpcAfterSym[0] = currencySpacingInfo.afterCurrencyMatch;
        this.currencySpcAfterSym[1] = currencySpacingInfo.afterContextMatch;
        this.currencySpcAfterSym[2] = currencySpacingInfo.afterInsert;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            this.monetarySeparator = this.decimalSeparator;
            this.exponential = (char)69;
        }
        if (this.serialVersionOnStream < 2) {
            this.padEscape = (char)42;
            this.plusSign = (char)43;
            this.exponentSeparator = String.valueOf(this.exponential);
        }
        if (this.serialVersionOnStream < 3) {
            this.requestedLocale = Locale.getDefault();
        }
        if (this.serialVersionOnStream < 4) {
            this.ulocale = ULocale.forLocale(this.requestedLocale);
        }
        if (this.serialVersionOnStream < 5) {
            this.monetaryGroupingSeparator = this.groupingSeparator;
        }
        if (this.serialVersionOnStream < 6) {
            if (this.currencySpcBeforeSym == null) {
                this.currencySpcBeforeSym = new String[3];
            }
            if (this.currencySpcAfterSym == null) {
                this.currencySpcAfterSym = new String[3];
            }
            this.initSpacingInfo(CurrencyData.CurrencySpacingInfo.DEFAULT);
        }
        this.serialVersionOnStream = 6;
        this.currency = Currency.getInstance(this.intlCurrencySymbol);
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if (uLocale == null != (uLocale2 == null)) {
            throw new IllegalArgumentException();
        }
        this.validLocale = uLocale;
        this.actualLocale = uLocale2;
    }
}

