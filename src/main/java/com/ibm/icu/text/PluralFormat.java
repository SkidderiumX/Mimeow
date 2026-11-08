/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.MessagePattern;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.text.UFormat;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Map;

public class PluralFormat
extends UFormat {
    private static final long serialVersionUID = 1L;
    private ULocale ulocale = null;
    private PluralRules pluralRules = null;
    private String pattern = null;
    private transient MessagePattern msgPattern;
    private Map<String, String> parsedValues = null;
    private NumberFormat numberFormat = null;
    private transient double offset = 0.0;
    private transient PluralSelectorAdapter pluralRulesWrapper = new PluralSelectorAdapter();

    public PluralFormat() {
        this.init(null, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public PluralFormat(ULocale uLocale) {
        this.init(null, PluralRules.PluralType.CARDINAL, uLocale);
    }

    public PluralFormat(PluralRules pluralRules) {
        this.init(pluralRules, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public PluralFormat(ULocale uLocale, PluralRules pluralRules) {
        this.init(pluralRules, PluralRules.PluralType.CARDINAL, uLocale);
    }

    public PluralFormat(ULocale uLocale, PluralRules.PluralType pluralType) {
        this.init(null, pluralType, uLocale);
    }

    public PluralFormat(String string) {
        this.init(null, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT));
        this.applyPattern(string);
    }

    public PluralFormat(ULocale uLocale, String string) {
        this.init(null, PluralRules.PluralType.CARDINAL, uLocale);
        this.applyPattern(string);
    }

    public PluralFormat(PluralRules pluralRules, String string) {
        this.init(pluralRules, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT));
        this.applyPattern(string);
    }

    public PluralFormat(ULocale uLocale, PluralRules pluralRules, String string) {
        this.init(pluralRules, PluralRules.PluralType.CARDINAL, uLocale);
        this.applyPattern(string);
    }

    public PluralFormat(ULocale uLocale, PluralRules.PluralType pluralType, String string) {
        this.init(null, pluralType, uLocale);
        this.applyPattern(string);
    }

    private void init(PluralRules pluralRules, PluralRules.PluralType pluralType, ULocale uLocale) {
        this.ulocale = uLocale;
        this.pluralRules = pluralRules == null ? PluralRules.forLocale(this.ulocale, pluralType) : pluralRules;
        this.resetPattern();
        this.numberFormat = NumberFormat.getInstance(this.ulocale);
    }

    private void resetPattern() {
        this.pattern = null;
        if (this.msgPattern != null) {
            this.msgPattern.clear();
        }
        this.offset = 0.0;
    }

    public void applyPattern(String string) {
        this.pattern = string;
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        try {
            this.msgPattern.parsePluralStyle(string);
            this.offset = this.msgPattern.getPluralOffset(0);
        }
        catch (RuntimeException runtimeException) {
            this.resetPattern();
            throw runtimeException;
        }
    }

    public String toPattern() {
        return this.pattern;
    }

    static int findSubMessage(MessagePattern messagePattern, int n, PluralSelector pluralSelector, double d) {
        int n2 = messagePattern.countParts();
        MessagePattern.Part part = messagePattern.getPart(n);
        double d2 = part.getType().hasNumericValue() ? messagePattern.getNumericValue(part) : 0.0;
        String string = null;
        boolean bl = false;
        int n3 = 0;
        do {
            int n4 = ++n;
            ++n;
            part = messagePattern.getPart(n4);
            MessagePattern.Part.Type type = part.getType();
            if (type == MessagePattern.Part.Type.ARG_LIMIT) break;
            assert (type == MessagePattern.Part.Type.ARG_SELECTOR);
            if (messagePattern.getPartType(n).hasNumericValue()) {
                if (d == messagePattern.getNumericValue(part = messagePattern.getPart(n++))) {
                    return n;
                }
            } else if (!bl) {
                if (messagePattern.partSubstringMatches(part, "other")) {
                    if (n3 == 0) {
                        n3 = n;
                        if (string != null && string.equals("other")) {
                            bl = true;
                        }
                    }
                } else {
                    if (string == null) {
                        string = pluralSelector.select(d - d2);
                        if (n3 != 0 && string.equals("other")) {
                            bl = true;
                        }
                    }
                    if (!bl && messagePattern.partSubstringMatches(part, string)) {
                        n3 = n;
                        bl = true;
                    }
                }
            }
            n = messagePattern.getLimitPartIndex(n);
        } while (++n < n2);
        return n3;
    }

    public final String format(double d) {
        if (this.msgPattern == null || this.msgPattern.countParts() == 0) {
            return this.numberFormat.format(d);
        }
        int n = PluralFormat.findSubMessage(this.msgPattern, 0, this.pluralRulesWrapper, d);
        d -= this.offset;
        StringBuilder stringBuilder = null;
        int n2 = this.msgPattern.getPart(n).getLimit();
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(++n);
            MessagePattern.Part.Type type = part.getType();
            int n3 = part.getIndex();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                if (stringBuilder == null) {
                    return this.pattern.substring(n2, n3);
                }
                return stringBuilder.append(this.pattern, n2, n3).toString();
            }
            if (type == MessagePattern.Part.Type.REPLACE_NUMBER || type == MessagePattern.Part.Type.SKIP_SYNTAX && this.msgPattern.jdkAposMode()) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.pattern, n2, n3);
                if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                    stringBuilder.append(this.numberFormat.format(d));
                }
                n2 = part.getLimit();
                continue;
            }
            if (type != MessagePattern.Part.Type.ARG_START) continue;
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(this.pattern, n2, n3);
            n2 = n3;
            n = this.msgPattern.getLimitPartIndex(n);
            n3 = this.msgPattern.getPart(n).getLimit();
            MessagePattern.appendReducedApostrophes(this.pattern, n2, n3, stringBuilder);
            n2 = n3;
        }
    }

    public StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (object instanceof Number) {
            stringBuffer.append(this.format(((Number)object).doubleValue()));
            return stringBuffer;
        }
        throw new IllegalArgumentException("'" + object + "' is not a Number");
    }

    public Number parse(String string, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    public Object parseObject(String string, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    public void setLocale(ULocale uLocale) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        this.init(null, PluralRules.PluralType.CARDINAL, uLocale);
    }

    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        PluralFormat pluralFormat = (PluralFormat)object;
        return Utility.objectEquals(this.ulocale, pluralFormat.ulocale) && Utility.objectEquals(this.pluralRules, pluralFormat.pluralRules) && Utility.objectEquals(this.msgPattern, pluralFormat.msgPattern) && Utility.objectEquals(this.numberFormat, pluralFormat.numberFormat);
    }

    public boolean equals(PluralFormat pluralFormat) {
        return this.equals((Object)pluralFormat);
    }

    public int hashCode() {
        return this.pluralRules.hashCode() ^ ((Object)this.parsedValues).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("locale=" + this.ulocale);
        stringBuilder.append(", rules='" + this.pluralRules + "'");
        stringBuilder.append(", pattern='" + this.pattern + "'");
        stringBuilder.append(", format='" + this.numberFormat + "'");
        return stringBuilder.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.pluralRulesWrapper = new PluralSelectorAdapter();
        this.parsedValues = null;
        if (this.pattern != null) {
            this.applyPattern(this.pattern);
        }
    }

    private final class PluralSelectorAdapter
    implements PluralSelector {
        private PluralSelectorAdapter() {
        }

        public String select(double d) {
            return PluralFormat.this.pluralRules.select(d);
        }
    }

    public static interface PluralSelector {
        public String select(double var1);
    }
}

