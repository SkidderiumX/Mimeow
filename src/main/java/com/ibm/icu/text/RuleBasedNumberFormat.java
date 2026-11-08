/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.RBNFPostProcessor;
import com.ibm.icu.text.RbnfLenientScanner;
import com.ibm.icu.text.RbnfLenientScannerProvider;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

public class RuleBasedNumberFormat
extends NumberFormat {
    static final long serialVersionUID = -7664252765575395068L;
    public static final int SPELLOUT = 1;
    public static final int ORDINAL = 2;
    public static final int DURATION = 3;
    public static final int NUMBERING_SYSTEM = 4;
    private transient NFRuleSet[] ruleSets = null;
    private transient String[] ruleSetDescriptions = null;
    private transient NFRuleSet defaultRuleSet = null;
    private ULocale locale = null;
    private transient RbnfLenientScannerProvider scannerProvider = null;
    private transient boolean lookedForScanner;
    private transient DecimalFormatSymbols decimalFormatSymbols = null;
    private transient DecimalFormat decimalFormat = null;
    private boolean lenientParse = false;
    private transient String lenientParseRules;
    private transient String postProcessRules;
    private transient RBNFPostProcessor postProcessor;
    private Map<String, String[]> ruleSetDisplayNames;
    private String[] publicRuleSetNames;
    private static final boolean DEBUG = ICUDebug.enabled("rbnf");
    private static final String[] rulenames = new String[]{"SpelloutRules", "OrdinalRules", "DurationRules", "NumberingSystemRules"};
    private static final String[] locnames = new String[]{"SpelloutLocalizations", "OrdinalLocalizations", "DurationLocalizations", "NumberingSystemLocalizations"};

    public RuleBasedNumberFormat(String string) {
        this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        this.init(string, null);
    }

    public RuleBasedNumberFormat(String string, String[][] stringArray) {
        this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        this.init(string, stringArray);
    }

    public RuleBasedNumberFormat(String string, Locale locale) {
        this(string, ULocale.forLocale(locale));
    }

    public RuleBasedNumberFormat(String string, ULocale uLocale) {
        this.locale = uLocale;
        this.init(string, null);
    }

    public RuleBasedNumberFormat(String string, String[][] stringArray, ULocale uLocale) {
        this.locale = uLocale;
        this.init(string, stringArray);
    }

    public RuleBasedNumberFormat(Locale locale, int n) {
        this(ULocale.forLocale(locale), n);
    }

    public RuleBasedNumberFormat(ULocale uLocale, int n) {
        this.locale = uLocale;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b/rbnf", uLocale);
        ULocale uLocale2 = iCUResourceBundle.getULocale();
        this.setLocale(uLocale2, uLocale2);
        String string = "";
        String[][] stringArray = null;
        try {
            string = iCUResourceBundle.getString(rulenames[n - 1]);
        }
        catch (MissingResourceException missingResourceException) {
            try {
                ICUResourceBundle iCUResourceBundle2 = iCUResourceBundle.getWithFallback("RBNFRules/" + rulenames[n - 1]);
                UResourceBundleIterator uResourceBundleIterator = iCUResourceBundle2.getIterator();
                while (uResourceBundleIterator.hasNext()) {
                    string = string.concat(uResourceBundleIterator.nextString());
                }
            }
            catch (MissingResourceException missingResourceException2) {
                // empty catch block
            }
        }
        try {
            UResourceBundle uResourceBundle = iCUResourceBundle.get(locnames[n - 1]);
            stringArray = new String[uResourceBundle.getSize()][];
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray[i] = uResourceBundle.get(i).getStringArray();
            }
        }
        catch (MissingResourceException missingResourceException) {
            // empty catch block
        }
        this.init(string, stringArray);
    }

    public RuleBasedNumberFormat(int n) {
        this(ULocale.getDefault(ULocale.Category.FORMAT), n);
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (!(object instanceof RuleBasedNumberFormat)) {
            return false;
        }
        RuleBasedNumberFormat ruleBasedNumberFormat = (RuleBasedNumberFormat)object;
        if (!this.locale.equals(ruleBasedNumberFormat.locale) || this.lenientParse != ruleBasedNumberFormat.lenientParse) {
            return false;
        }
        if (this.ruleSets.length != ruleBasedNumberFormat.ruleSets.length) {
            return false;
        }
        for (int i = 0; i < this.ruleSets.length; ++i) {
            if (this.ruleSets[i].equals(ruleBasedNumberFormat.ruleSets[i])) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.ruleSets.length; ++i) {
            stringBuilder.append(this.ruleSets[i].toString());
        }
        return stringBuilder.toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.toString());
        objectOutputStream.writeObject(this.locale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ULocale uLocale;
        String string = objectInputStream.readUTF();
        try {
            uLocale = (ULocale)objectInputStream.readObject();
        }
        catch (Exception exception) {
            uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(string, uLocale);
        this.ruleSets = ruleBasedNumberFormat.ruleSets;
        this.defaultRuleSet = ruleBasedNumberFormat.defaultRuleSet;
        this.publicRuleSetNames = ruleBasedNumberFormat.publicRuleSetNames;
        this.decimalFormatSymbols = ruleBasedNumberFormat.decimalFormatSymbols;
        this.decimalFormat = ruleBasedNumberFormat.decimalFormat;
        this.locale = ruleBasedNumberFormat.locale;
    }

    public String[] getRuleSetNames() {
        return (String[])this.publicRuleSetNames.clone();
    }

    public ULocale[] getRuleSetDisplayNameLocales() {
        if (this.ruleSetDisplayNames != null) {
            Set<String> set = this.ruleSetDisplayNames.keySet();
            String[] stringArray = set.toArray(new String[set.size()]);
            Arrays.sort(stringArray, String.CASE_INSENSITIVE_ORDER);
            ULocale[] uLocaleArray = new ULocale[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                uLocaleArray[i] = new ULocale(stringArray[i]);
            }
            return uLocaleArray;
        }
        return null;
    }

    private String[] getNameListForLocale(ULocale uLocale) {
        if (uLocale != null && this.ruleSetDisplayNames != null) {
            String[] stringArray = new String[]{uLocale.getBaseName(), ULocale.getDefault(ULocale.Category.DISPLAY).getBaseName()};
            for (int i = 0; i < stringArray.length; ++i) {
                String string = stringArray[i];
                while (string.length() > 0) {
                    String[] stringArray2 = this.ruleSetDisplayNames.get(string);
                    if (stringArray2 != null) {
                        return stringArray2;
                    }
                    string = ULocale.getFallback(string);
                }
            }
        }
        return null;
    }

    public String[] getRuleSetDisplayNames(ULocale uLocale) {
        String[] stringArray = this.getNameListForLocale(uLocale);
        if (stringArray != null) {
            return (String[])stringArray.clone();
        }
        stringArray = this.getRuleSetNames();
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = stringArray[i].substring(1);
        }
        return stringArray;
    }

    public String[] getRuleSetDisplayNames() {
        return this.getRuleSetDisplayNames(ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public String getRuleSetDisplayName(String string, ULocale uLocale) {
        String[] stringArray = this.publicRuleSetNames;
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].equals(string)) continue;
            String[] stringArray2 = this.getNameListForLocale(uLocale);
            if (stringArray2 != null) {
                return stringArray2[i];
            }
            return stringArray[i].substring(1);
        }
        throw new IllegalArgumentException("unrecognized rule set name: " + string);
    }

    public String getRuleSetDisplayName(String string) {
        return this.getRuleSetDisplayName(string, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public String format(double d, String string) throws IllegalArgumentException {
        if (string.startsWith("%%")) {
            throw new IllegalArgumentException("Can't use internal rule set");
        }
        return this.format(d, this.findRuleSet(string));
    }

    public String format(long l, String string) throws IllegalArgumentException {
        if (string.startsWith("%%")) {
            throw new IllegalArgumentException("Can't use internal rule set");
        }
        return this.format(l, this.findRuleSet(string));
    }

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(this.format(d, this.defaultRuleSet));
        return stringBuffer;
    }

    public StringBuffer format(long l, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(this.format(l, this.defaultRuleSet));
        return stringBuffer;
    }

    public StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format(new com.ibm.icu.math.BigDecimal(bigInteger), stringBuffer, fieldPosition);
    }

    public StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format(new com.ibm.icu.math.BigDecimal(bigDecimal), stringBuffer, fieldPosition);
    }

    public StringBuffer format(com.ibm.icu.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.format(bigDecimal.doubleValue(), stringBuffer, fieldPosition);
    }

    public Number parse(String string, ParsePosition parsePosition) {
        String string2 = string.substring(parsePosition.getIndex());
        ParsePosition parsePosition2 = new ParsePosition(0);
        Number number = null;
        Number number2 = 0L;
        ParsePosition parsePosition3 = new ParsePosition(parsePosition2.getIndex());
        for (int i = this.ruleSets.length - 1; i >= 0; --i) {
            if (!this.ruleSets[i].isPublic() || !this.ruleSets[i].isParseable()) continue;
            number = this.ruleSets[i].parse(string2, parsePosition2, Double.MAX_VALUE);
            if (parsePosition2.getIndex() > parsePosition3.getIndex()) {
                number2 = number;
                parsePosition3.setIndex(parsePosition2.getIndex());
            }
            if (parsePosition3.getIndex() == string2.length()) break;
            parsePosition2.setIndex(0);
        }
        parsePosition.setIndex(parsePosition.getIndex() + parsePosition3.getIndex());
        return number2;
    }

    public void setLenientParseMode(boolean bl) {
        this.lenientParse = bl;
    }

    public boolean lenientParseEnabled() {
        return this.lenientParse;
    }

    public void setLenientScannerProvider(RbnfLenientScannerProvider rbnfLenientScannerProvider) {
        this.scannerProvider = rbnfLenientScannerProvider;
    }

    public RbnfLenientScannerProvider getLenientScannerProvider() {
        if (this.scannerProvider == null && this.lenientParse && !this.lookedForScanner) {
            try {
                this.lookedForScanner = true;
                Class<?> clazz = Class.forName("com.ibm.icu.text.RbnfScannerProviderImpl");
                RbnfLenientScannerProvider rbnfLenientScannerProvider = (RbnfLenientScannerProvider)clazz.newInstance();
                this.setLenientScannerProvider(rbnfLenientScannerProvider);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.scannerProvider;
    }

    public void setDefaultRuleSet(String string) {
        if (string == null) {
            if (this.publicRuleSetNames.length > 0) {
                this.defaultRuleSet = this.findRuleSet(this.publicRuleSetNames[0]);
            } else {
                this.defaultRuleSet = null;
                int n = this.ruleSets.length;
                while (--n >= 0) {
                    String string2 = this.ruleSets[n].getName();
                    if (!string2.equals("%spellout-numbering") && !string2.equals("%digits-ordinal") && !string2.equals("%duration")) continue;
                    this.defaultRuleSet = this.ruleSets[n];
                    return;
                }
                n = this.ruleSets.length;
                while (--n >= 0) {
                    if (!this.ruleSets[n].isPublic()) continue;
                    this.defaultRuleSet = this.ruleSets[n];
                    break;
                }
            }
        } else {
            if (string.startsWith("%%")) {
                throw new IllegalArgumentException("cannot use private rule set: " + string);
            }
            this.defaultRuleSet = this.findRuleSet(string);
        }
    }

    public String getDefaultRuleSetName() {
        if (this.defaultRuleSet != null && this.defaultRuleSet.isPublic()) {
            return this.defaultRuleSet.getName();
        }
        return "";
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        if (decimalFormatSymbols != null) {
            this.decimalFormatSymbols = (DecimalFormatSymbols)decimalFormatSymbols.clone();
            if (this.decimalFormat != null) {
                this.decimalFormat.setDecimalFormatSymbols(this.decimalFormatSymbols);
            }
            for (int i = 0; i < this.ruleSets.length; ++i) {
                this.ruleSets[i].parseRules(this.ruleSetDescriptions[i], this);
            }
        }
    }

    NFRuleSet getDefaultRuleSet() {
        return this.defaultRuleSet;
    }

    RbnfLenientScanner getLenientScanner() {
        RbnfLenientScannerProvider rbnfLenientScannerProvider;
        if (this.lenientParse && (rbnfLenientScannerProvider = this.getLenientScannerProvider()) != null) {
            return rbnfLenientScannerProvider.get(this.locale, this.lenientParseRules);
        }
        return null;
    }

    DecimalFormatSymbols getDecimalFormatSymbols() {
        if (this.decimalFormatSymbols == null) {
            this.decimalFormatSymbols = new DecimalFormatSymbols(this.locale);
        }
        return this.decimalFormatSymbols;
    }

    DecimalFormat getDecimalFormat() {
        if (this.decimalFormat == null) {
            this.decimalFormat = (DecimalFormat)NumberFormat.getInstance(this.locale);
            if (this.decimalFormatSymbols != null) {
                this.decimalFormat.setDecimalFormatSymbols(this.decimalFormatSymbols);
            }
        }
        return this.decimalFormat;
    }

    private String extractSpecial(StringBuilder stringBuilder, String string) {
        String string2 = null;
        int n = stringBuilder.indexOf(string);
        if (n != -1 && (n == 0 || stringBuilder.charAt(n - 1) == ';')) {
            int n2;
            int n3 = stringBuilder.indexOf(";%", n);
            if (n3 == -1) {
                n3 = stringBuilder.length() - 1;
            }
            for (n2 = n + string.length(); n2 < n3 && PatternProps.isWhiteSpace(stringBuilder.charAt(n2)); ++n2) {
            }
            string2 = stringBuilder.substring(n2, n3);
            stringBuilder.delete(n, n3 + 1);
        }
        return string2;
    }

    private void init(String string, String[][] stringArray) {
        int n;
        int n2;
        this.initLocalizations(stringArray);
        StringBuilder stringBuilder = this.stripWhitespace(string);
        this.lenientParseRules = this.extractSpecial(stringBuilder, "%%lenient-parse:");
        this.postProcessRules = this.extractSpecial(stringBuilder, "%%post-process:");
        int n3 = 0;
        int n4 = stringBuilder.indexOf(";%");
        while (n4 != -1) {
            ++n3;
            ++n4;
            n4 = stringBuilder.indexOf(";%", n4);
        }
        this.ruleSets = new NFRuleSet[++n3];
        this.ruleSetDescriptions = new String[n3];
        n4 = 0;
        int n5 = 0;
        int n6 = stringBuilder.indexOf(";%");
        while (n6 != -1) {
            this.ruleSetDescriptions[n4] = stringBuilder.substring(n5, n6 + 1);
            this.ruleSets[n4] = new NFRuleSet(this.ruleSetDescriptions, n4);
            ++n4;
            n5 = n6 + 1;
            n6 = stringBuilder.indexOf(";%", n5);
        }
        this.ruleSetDescriptions[n4] = stringBuilder.substring(n5);
        this.ruleSets[n4] = new NFRuleSet(this.ruleSetDescriptions, n4);
        n6 = 0;
        int n7 = this.ruleSets.length;
        this.defaultRuleSet = this.ruleSets[this.ruleSets.length - 1];
        while (--n7 >= 0) {
            String string2 = this.ruleSets[n7].getName();
            if (!string2.equals("%spellout-numbering") && !string2.equals("%digits-ordinal") && !string2.equals("%duration")) continue;
            this.defaultRuleSet = this.ruleSets[n7];
            n6 = 1;
            break;
        }
        if (n6 == 0) {
            for (int i = this.ruleSets.length - 1; i >= 0; --i) {
                if (this.ruleSets[i].getName().startsWith("%%")) continue;
                this.defaultRuleSet = this.ruleSets[i];
                break;
            }
        }
        for (n2 = 0; n2 < this.ruleSets.length; ++n2) {
            this.ruleSets[n2].parseRules(this.ruleSetDescriptions[n2], this);
        }
        n2 = 0;
        for (int i = 0; i < this.ruleSets.length; ++i) {
            if (this.ruleSets[i].getName().startsWith("%%")) continue;
            ++n2;
        }
        String[] stringArray2 = new String[n2];
        n2 = 0;
        for (n = this.ruleSets.length - 1; n >= 0; --n) {
            if (this.ruleSets[n].getName().startsWith("%%")) continue;
            stringArray2[n2++] = this.ruleSets[n].getName();
        }
        if (this.publicRuleSetNames != null) {
            block7: for (n = 0; n < this.publicRuleSetNames.length; ++n) {
                String string3 = this.publicRuleSetNames[n];
                for (int i = 0; i < stringArray2.length; ++i) {
                    if (string3.equals(stringArray2[i])) continue block7;
                }
                throw new IllegalArgumentException("did not find public rule set: " + string3);
            }
            this.defaultRuleSet = this.findRuleSet(this.publicRuleSetNames[0]);
        } else {
            this.publicRuleSetNames = stringArray2;
        }
    }

    private void initLocalizations(String[][] stringArray) {
        if (stringArray != null) {
            this.publicRuleSetNames = (String[])stringArray[0].clone();
            HashMap<String, String[]> hashMap = new HashMap<String, String[]>();
            for (int i = 1; i < stringArray.length; ++i) {
                String[] stringArray2 = stringArray[i];
                String string = stringArray2[0];
                String[] stringArray3 = new String[stringArray2.length - 1];
                if (stringArray3.length != this.publicRuleSetNames.length) {
                    throw new IllegalArgumentException("public name length: " + this.publicRuleSetNames.length + " != localized names[" + i + "] length: " + stringArray3.length);
                }
                System.arraycopy(stringArray2, 1, stringArray3, 0, stringArray3.length);
                hashMap.put(string, stringArray3);
            }
            if (!hashMap.isEmpty()) {
                this.ruleSetDisplayNames = hashMap;
            }
        }
    }

    private StringBuilder stripWhitespace(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        while (n != -1 && n < string.length()) {
            while (n < string.length() && PatternProps.isWhiteSpace(string.charAt(n))) {
                ++n;
            }
            if (n < string.length() && string.charAt(n) == ';') {
                ++n;
                continue;
            }
            int n2 = string.indexOf(59, n);
            if (n2 == -1) {
                stringBuilder.append(string.substring(n));
                n = -1;
                continue;
            }
            if (n2 < string.length()) {
                stringBuilder.append(string.substring(n, n2 + 1));
                n = n2 + 1;
                continue;
            }
            n = -1;
        }
        return stringBuilder;
    }

    private String format(double d, NFRuleSet nFRuleSet) {
        StringBuffer stringBuffer = new StringBuffer();
        nFRuleSet.format(d, stringBuffer, 0);
        this.postProcess(stringBuffer, nFRuleSet);
        return stringBuffer.toString();
    }

    private String format(long l, NFRuleSet nFRuleSet) {
        StringBuffer stringBuffer = new StringBuffer();
        nFRuleSet.format(l, stringBuffer, 0);
        this.postProcess(stringBuffer, nFRuleSet);
        return stringBuffer.toString();
    }

    private void postProcess(StringBuffer stringBuffer, NFRuleSet nFRuleSet) {
        if (this.postProcessRules != null) {
            if (this.postProcessor == null) {
                int n = this.postProcessRules.indexOf(";");
                if (n == -1) {
                    n = this.postProcessRules.length();
                }
                String string = this.postProcessRules.substring(0, n).trim();
                try {
                    Class<?> clazz = Class.forName(string);
                    this.postProcessor = (RBNFPostProcessor)clazz.newInstance();
                    this.postProcessor.init(this, this.postProcessRules);
                }
                catch (Exception exception) {
                    if (DEBUG) {
                        System.out.println("could not locate " + string + ", error " + exception.getClass().getName() + ", " + exception.getMessage());
                    }
                    this.postProcessor = null;
                    this.postProcessRules = null;
                    return;
                }
            }
            this.postProcessor.process(stringBuffer, nFRuleSet);
        }
    }

    NFRuleSet findRuleSet(String string) throws IllegalArgumentException {
        for (int i = 0; i < this.ruleSets.length; ++i) {
            if (!this.ruleSets[i].getName().equals(string)) continue;
            return this.ruleSets[i];
        }
        throw new IllegalArgumentException("No rule set named " + string);
    }
}

