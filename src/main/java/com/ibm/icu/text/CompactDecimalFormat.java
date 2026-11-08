/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.CompactDecimalDataCache;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CompactDecimalFormat
extends DecimalFormat {
    private static final long serialVersionUID = 4716293295276629682L;
    private static final int POSITIVE_PREFIX = 0;
    private static final int POSITIVE_SUFFIX = 1;
    private static final int AFFIX_SIZE = 2;
    private static final CompactDecimalDataCache cache = new CompactDecimalDataCache();
    private final Map<String, DecimalFormat.Unit[]> units;
    private final long[] divisor;
    private final String[] currencyAffixes;
    private final PluralRules pluralRules;

    public static CompactDecimalFormat getInstance(ULocale uLocale, CompactStyle compactStyle) {
        return new CompactDecimalFormat(uLocale, compactStyle);
    }

    public static CompactDecimalFormat getInstance(Locale locale, CompactStyle compactStyle) {
        return new CompactDecimalFormat(ULocale.forLocale(locale), compactStyle);
    }

    CompactDecimalFormat(ULocale uLocale, CompactStyle compactStyle) {
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(uLocale);
        CompactDecimalDataCache.Data data = this.getData(uLocale, compactStyle);
        this.units = data.units;
        this.divisor = data.divisors;
        this.applyPattern(decimalFormat.toPattern());
        this.setDecimalFormatSymbols(decimalFormat.getDecimalFormatSymbols());
        this.setMaximumSignificantDigits(3);
        this.setSignificantDigitsUsed(true);
        if (compactStyle == CompactStyle.SHORT) {
            this.setGroupingUsed(false);
        }
        this.pluralRules = PluralRules.forLocale(uLocale);
        DecimalFormat decimalFormat2 = (DecimalFormat)NumberFormat.getCurrencyInstance(uLocale);
        this.currencyAffixes = new String[2];
        this.currencyAffixes[0] = decimalFormat2.getPositivePrefix();
        this.currencyAffixes[1] = decimalFormat2.getPositiveSuffix();
        this.setCurrency(null);
    }

    public CompactDecimalFormat(String string, DecimalFormatSymbols decimalFormatSymbols, String[] stringArray, String[] stringArray2, long[] lArray, Collection<String> collection, CompactStyle compactStyle, String[] stringArray3) {
        if (stringArray.length < 15) {
            this.recordError(collection, "Must have at least 15 prefix items.");
        }
        if (stringArray.length != stringArray2.length || stringArray.length != lArray.length) {
            this.recordError(collection, "Prefix, suffix, and divisor arrays must have the same length.");
        }
        long l = 0L;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string2;
            Integer n;
            long l2;
            int n2;
            if (stringArray[i] == null || stringArray2[i] == null) {
                this.recordError(collection, "Prefix or suffix is null for " + i);
            }
            if ((n2 = (int)Math.log10(lArray[i])) > i) {
                this.recordError(collection, "Divisor[" + i + "] must be less than or equal to 10^" + i + ", but is: " + lArray[i]);
            }
            if ((l2 = (long)Math.pow(10.0, n2)) != lArray[i]) {
                this.recordError(collection, "Divisor[" + i + "] must be a power of 10, but is: " + lArray[i]);
            }
            if ((n = (Integer)hashMap.get(string2 = stringArray[i] + "\uffff" + stringArray2[i] + "\uffff" + (i - n2))) != null) {
                this.recordError(collection, "Collision between values for " + i + " and " + n + " for [prefix/suffix/index-log(divisor)" + string2.replace('\uffff', ';'));
            } else {
                hashMap.put(string2, i);
            }
            if (lArray[i] < l) {
                this.recordError(collection, "Bad divisor, the divisor for 10E" + i + "(" + lArray[i] + ") is less than the divisor for the divisor for 10E" + (i - 1) + "(" + l + ")");
            }
            l = lArray[i];
        }
        this.units = this.otherPluralVariant(stringArray, stringArray2);
        this.divisor = (long[])lArray.clone();
        this.applyPattern(string);
        this.setDecimalFormatSymbols(decimalFormatSymbols);
        this.setMaximumSignificantDigits(2);
        this.setSignificantDigitsUsed(true);
        this.setGroupingUsed(false);
        this.currencyAffixes = (String[])stringArray3.clone();
        this.pluralRules = null;
        this.setCurrency(null);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CompactDecimalFormat compactDecimalFormat = (CompactDecimalFormat)object;
        return this.mapsAreEqual(this.units, compactDecimalFormat.units) && Arrays.equals(this.divisor, compactDecimalFormat.divisor) && Arrays.equals(this.currencyAffixes, compactDecimalFormat.currencyAffixes) && this.pluralRules.equals(compactDecimalFormat.pluralRules);
    }

    private boolean mapsAreEqual(Map<String, DecimalFormat.Unit[]> map, Map<String, DecimalFormat.Unit[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, DecimalFormat.Unit[]> entry : map.entrySet()) {
            Object[] objectArray = map2.get(entry.getKey());
            if (objectArray != null && Arrays.equals(entry.getValue(), objectArray)) continue;
            return false;
        }
        return true;
    }

    @Override
    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        Amount amount = this.toAmount(d);
        DecimalFormat.Unit unit = amount.getUnit();
        unit.writePrefix(stringBuffer);
        super.format(amount.getQty(), stringBuffer, fieldPosition);
        unit.writeSuffix(stringBuffer);
        return stringBuffer;
    }

    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        if (!(object instanceof Number)) {
            throw new IllegalArgumentException();
        }
        Number number = (Number)object;
        Amount amount = this.toAmount(number.doubleValue());
        return super.formatToCharacterIterator(amount.getQty(), amount.getUnit());
    }

    @Override
    public StringBuffer format(long l, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format((double)l, stringBuffer, fieldPosition);
    }

    @Override
    public StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format(bigInteger.doubleValue(), stringBuffer, fieldPosition);
    }

    @Override
    public StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format(bigDecimal.doubleValue(), stringBuffer, fieldPosition);
    }

    @Override
    public StringBuffer format(com.ibm.icu.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format(bigDecimal.doubleValue(), stringBuffer, fieldPosition);
    }

    @Override
    public Number parse(String string, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        throw new NotSerializableException();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new NotSerializableException();
    }

    private Amount toAmount(double d) {
        int n;
        boolean bl = this.isNumberNegative(d);
        int n2 = n = (d = this.adjustNumberAsInFormatting(d)) <= 1.0 ? 0 : (int)Math.log10(d);
        if (n >= 15) {
            n = 14;
        }
        String string = this.getPluralForm(d /= (double)this.divisor[n]);
        if (bl) {
            d = -d;
        }
        return new Amount(d, CompactDecimalDataCache.getUnit(this.units, string, n));
    }

    private void recordError(Collection<String> collection, String string) {
        if (collection == null) {
            throw new IllegalArgumentException(string);
        }
        collection.add(string);
    }

    private Map<String, DecimalFormat.Unit[]> otherPluralVariant(String[] stringArray, String[] stringArray2) {
        HashMap<String, DecimalFormat.Unit[]> hashMap = new HashMap<String, DecimalFormat.Unit[]>();
        DecimalFormat.Unit[] unitArray = new DecimalFormat.Unit[stringArray.length];
        for (int i = 0; i < unitArray.length; ++i) {
            unitArray[i] = new DecimalFormat.Unit(stringArray[i], stringArray2[i]);
        }
        hashMap.put("other", unitArray);
        return hashMap;
    }

    private String getPluralForm(double d) {
        if (this.pluralRules == null) {
            return "other";
        }
        return this.pluralRules.select(d);
    }

    private CompactDecimalDataCache.Data getData(ULocale uLocale, CompactStyle compactStyle) {
        CompactDecimalDataCache.DataBundle dataBundle = cache.get(uLocale);
        switch (compactStyle) {
            case SHORT: {
                return dataBundle.shortData;
            }
            case LONG: {
                return dataBundle.longData;
            }
        }
        return dataBundle.shortData;
    }

    private static class Amount {
        private final double qty;
        private final DecimalFormat.Unit unit;

        public Amount(double d, DecimalFormat.Unit unit) {
            this.qty = d;
            this.unit = unit;
        }

        public double getQty() {
            return this.qty;
        }

        public DecimalFormat.Unit getUnit() {
            return this.unit;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum CompactStyle {
        SHORT,
        LONG;

    }
}

