/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.MessagePattern;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.PluralFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.text.RuleBasedNumberFormat;
import com.ibm.icu.text.SelectFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.text.UFormat;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.CharacterIterator;
import java.text.ChoiceFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MessageFormat
extends UFormat {
    static final long serialVersionUID = 7136212545847378652L;
    private transient ULocale ulocale;
    private transient MessagePattern msgPattern;
    private transient Map<Integer, Format> cachedFormatters;
    private transient Set<Integer> customFormatArgStarts;
    private transient Format stockDateFormatter;
    private transient Format stockNumberFormatter;
    private transient PluralSelectorProvider pluralProvider;
    private transient PluralSelectorProvider ordinalProvider;
    private static final String[] typeList = new String[]{"number", "date", "time", "spellout", "ordinal", "duration"};
    private static final int TYPE_NUMBER = 0;
    private static final int TYPE_DATE = 1;
    private static final int TYPE_TIME = 2;
    private static final int TYPE_SPELLOUT = 3;
    private static final int TYPE_ORDINAL = 4;
    private static final int TYPE_DURATION = 5;
    private static final String[] modifierList = new String[]{"", "currency", "percent", "integer"};
    private static final int MODIFIER_EMPTY = 0;
    private static final int MODIFIER_CURRENCY = 1;
    private static final int MODIFIER_PERCENT = 2;
    private static final int MODIFIER_INTEGER = 3;
    private static final String[] dateModifierList = new String[]{"", "short", "medium", "long", "full"};
    private static final int DATE_MODIFIER_EMPTY = 0;
    private static final int DATE_MODIFIER_SHORT = 1;
    private static final int DATE_MODIFIER_MEDIUM = 2;
    private static final int DATE_MODIFIER_LONG = 3;
    private static final int DATE_MODIFIER_FULL = 4;
    private static final Locale rootLocale = new Locale("");
    private static final char SINGLE_QUOTE = '\'';
    private static final char CURLY_BRACE_LEFT = '{';
    private static final char CURLY_BRACE_RIGHT = '}';
    private static final int STATE_INITIAL = 0;
    private static final int STATE_SINGLE_QUOTE = 1;
    private static final int STATE_IN_QUOTE = 2;
    private static final int STATE_MSG_ELEMENT = 3;

    public MessageFormat(String string) {
        this.ulocale = ULocale.getDefault(ULocale.Category.FORMAT);
        this.applyPattern(string);
    }

    public MessageFormat(String string, Locale locale) {
        this(string, ULocale.forLocale(locale));
    }

    public MessageFormat(String string, ULocale uLocale) {
        this.ulocale = uLocale;
        this.applyPattern(string);
    }

    public void setLocale(Locale locale) {
        this.setLocale(ULocale.forLocale(locale));
    }

    public void setLocale(ULocale uLocale) {
        String string = this.toPattern();
        this.ulocale = uLocale;
        this.stockDateFormatter = null;
        this.stockNumberFormatter = null;
        this.pluralProvider = null;
        this.ordinalProvider = null;
        this.applyPattern(string);
    }

    public Locale getLocale() {
        return this.ulocale.toLocale();
    }

    public ULocale getULocale() {
        return this.ulocale;
    }

    public void applyPattern(String string) {
        try {
            if (this.msgPattern == null) {
                this.msgPattern = new MessagePattern(string);
            } else {
                this.msgPattern.parse(string);
            }
            this.cacheExplicitFormats();
        }
        catch (RuntimeException runtimeException) {
            this.resetPattern();
            throw runtimeException;
        }
    }

    public void applyPattern(String string, MessagePattern.ApostropheMode apostropheMode) {
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern(apostropheMode);
        } else if (apostropheMode != this.msgPattern.getApostropheMode()) {
            this.msgPattern.clearPatternAndSetApostropheMode(apostropheMode);
        }
        this.applyPattern(string);
    }

    public MessagePattern.ApostropheMode getApostropheMode() {
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        return this.msgPattern.getApostropheMode();
    }

    public String toPattern() {
        if (this.customFormatArgStarts != null) {
            throw new IllegalStateException("toPattern() is not supported after custom Format objects have been set via setFormat() or similar APIs");
        }
        if (this.msgPattern == null) {
            return "";
        }
        String string = this.msgPattern.getPatternString();
        return string == null ? "" : string;
    }

    private int nextTopLevelArgStart(int n) {
        MessagePattern.Part.Type type;
        if (n != 0) {
            n = this.msgPattern.getLimitPartIndex(n);
        }
        do {
            if ((type = this.msgPattern.getPartType(++n)) != MessagePattern.Part.Type.ARG_START) continue;
            return n;
        } while (type != MessagePattern.Part.Type.MSG_LIMIT);
        return -1;
    }

    private boolean argNameMatches(int n, String string, int n2) {
        MessagePattern.Part part = this.msgPattern.getPart(n);
        return part.getType() == MessagePattern.Part.Type.ARG_NAME ? this.msgPattern.partSubstringMatches(part, string) : part.getValue() == n2;
    }

    private String getArgName(int n) {
        MessagePattern.Part part = this.msgPattern.getPart(n);
        if (part.getType() == MessagePattern.Part.Type.ARG_NAME) {
            return this.msgPattern.getSubstring(part);
        }
        return Integer.toString(part.getValue());
    }

    public void setFormatsByArgumentIndex(Format[] formatArray) {
        if (this.msgPattern.hasNamedArguments()) {
            throw new IllegalArgumentException("This method is not available in MessageFormat objects that use alphanumeric argument names.");
        }
        int n = 0;
        while ((n = this.nextTopLevelArgStart(n)) >= 0) {
            int n2 = this.msgPattern.getPart(n + 1).getValue();
            if (n2 >= formatArray.length) continue;
            this.setCustomArgStartFormat(n, formatArray[n2]);
        }
    }

    public void setFormatsByArgumentName(Map<String, Format> map) {
        int n = 0;
        while ((n = this.nextTopLevelArgStart(n)) >= 0) {
            String string = this.getArgName(n + 1);
            if (!map.containsKey(string)) continue;
            this.setCustomArgStartFormat(n, map.get(string));
        }
    }

    public void setFormats(Format[] formatArray) {
        int n = 0;
        for (int i = 0; i < formatArray.length && (n = this.nextTopLevelArgStart(n)) >= 0; ++i) {
            this.setCustomArgStartFormat(n, formatArray[i]);
        }
    }

    public void setFormatByArgumentIndex(int n, Format format) {
        if (this.msgPattern.hasNamedArguments()) {
            throw new IllegalArgumentException("This method is not available in MessageFormat objects that use alphanumeric argument names.");
        }
        int n2 = 0;
        while ((n2 = this.nextTopLevelArgStart(n2)) >= 0) {
            if (this.msgPattern.getPart(n2 + 1).getValue() != n) continue;
            this.setCustomArgStartFormat(n2, format);
        }
    }

    public void setFormatByArgumentName(String string, Format format) {
        int n = MessagePattern.validateArgumentName(string);
        if (n < -1) {
            return;
        }
        int n2 = 0;
        while ((n2 = this.nextTopLevelArgStart(n2)) >= 0) {
            if (!this.argNameMatches(n2 + 1, string, n)) continue;
            this.setCustomArgStartFormat(n2, format);
        }
    }

    public void setFormat(int n, Format format) {
        int n2 = 0;
        int n3 = 0;
        while ((n3 = this.nextTopLevelArgStart(n3)) >= 0) {
            if (n2 == n) {
                this.setCustomArgStartFormat(n3, format);
                return;
            }
            ++n2;
        }
        throw new ArrayIndexOutOfBoundsException(n);
    }

    public Format[] getFormatsByArgumentIndex() {
        if (this.msgPattern.hasNamedArguments()) {
            throw new IllegalArgumentException("This method is not available in MessageFormat objects that use alphanumeric argument names.");
        }
        ArrayList<Format> arrayList = new ArrayList<Format>();
        int n = 0;
        while ((n = this.nextTopLevelArgStart(n)) >= 0) {
            int n2 = this.msgPattern.getPart(n + 1).getValue();
            while (n2 >= arrayList.size()) {
                arrayList.add(null);
            }
            arrayList.set(n2, this.cachedFormatters == null ? null : this.cachedFormatters.get(n));
        }
        return arrayList.toArray(new Format[arrayList.size()]);
    }

    public Format[] getFormats() {
        ArrayList<Format> arrayList = new ArrayList<Format>();
        int n = 0;
        while ((n = this.nextTopLevelArgStart(n)) >= 0) {
            arrayList.add(this.cachedFormatters == null ? null : this.cachedFormatters.get(n));
        }
        return arrayList.toArray(new Format[arrayList.size()]);
    }

    public Set<String> getArgumentNames() {
        HashSet<String> hashSet = new HashSet<String>();
        int n = 0;
        while ((n = this.nextTopLevelArgStart(n)) >= 0) {
            hashSet.add(this.getArgName(n + 1));
        }
        return hashSet;
    }

    public Format getFormatByArgumentName(String string) {
        if (this.cachedFormatters == null) {
            return null;
        }
        int n = MessagePattern.validateArgumentName(string);
        if (n < -1) {
            return null;
        }
        int n2 = 0;
        while ((n2 = this.nextTopLevelArgStart(n2)) >= 0) {
            if (!this.argNameMatches(n2 + 1, string, n)) continue;
            return this.cachedFormatters.get(n2);
        }
        return null;
    }

    public final StringBuffer format(Object[] objectArray, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.format(objectArray, null, new AppendableWrapper(stringBuffer), fieldPosition);
        return stringBuffer;
    }

    public final StringBuffer format(Map<String, Object> map, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.format(null, map, new AppendableWrapper(stringBuffer), fieldPosition);
        return stringBuffer;
    }

    public static String format(String string, Object ... objectArray) {
        MessageFormat messageFormat = new MessageFormat(string);
        return messageFormat.format(objectArray);
    }

    public static String format(String string, Map<String, Object> map) {
        MessageFormat messageFormat = new MessageFormat(string);
        return messageFormat.format(map);
    }

    public boolean usesNamedArguments() {
        return this.msgPattern.hasNamedArguments();
    }

    @Override
    public final StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.format(object, new AppendableWrapper(stringBuffer), fieldPosition);
        return stringBuffer;
    }

    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        if (object == null) {
            throw new NullPointerException("formatToCharacterIterator must be passed non-null object");
        }
        StringBuilder stringBuilder = new StringBuilder();
        AppendableWrapper appendableWrapper = new AppendableWrapper(stringBuilder);
        appendableWrapper.useAttributes();
        this.format(object, appendableWrapper, null);
        AttributedString attributedString = new AttributedString(stringBuilder.toString());
        for (AttributeAndPosition attributeAndPosition : appendableWrapper.attributes) {
            attributedString.addAttribute(attributeAndPosition.key, attributeAndPosition.value, attributeAndPosition.start, attributeAndPosition.limit);
        }
        return attributedString.getIterator();
    }

    public Object[] parse(String string, ParsePosition parsePosition) {
        int n;
        if (this.msgPattern.hasNamedArguments()) {
            throw new IllegalArgumentException("This method is not available in MessageFormat objects that use named argument.");
        }
        int n2 = -1;
        int n3 = 0;
        while ((n3 = this.nextTopLevelArgStart(n3)) >= 0) {
            n = this.msgPattern.getPart(n3 + 1).getValue();
            if (n <= n2) continue;
            n2 = n;
        }
        Object[] objectArray = new Object[n2 + 1];
        n = parsePosition.getIndex();
        this.parse(0, string, parsePosition, objectArray, null);
        if (parsePosition.getIndex() == n) {
            return null;
        }
        return objectArray;
    }

    public Map<String, Object> parseToMap(String string, ParsePosition parsePosition) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int n = parsePosition.getIndex();
        this.parse(0, string, parsePosition, null, hashMap);
        if (parsePosition.getIndex() == n) {
            return null;
        }
        return hashMap;
    }

    public Object[] parse(String string) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Object[] objectArray = this.parse(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new ParseException("MessageFormat parse error!", parsePosition.getErrorIndex());
        }
        return objectArray;
    }

    private void parse(int n, String string, ParsePosition parsePosition, Object[] objectArray, Map<String, Object> map) {
        if (string == null) {
            return;
        }
        String string2 = this.msgPattern.getPatternString();
        int n2 = this.msgPattern.getPart(n).getLimit();
        int n3 = parsePosition.getIndex();
        ParsePosition parsePosition2 = new ParsePosition(0);
        int n4 = n + 1;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(n4);
            MessagePattern.Part.Type type = part.getType();
            int n5 = part.getIndex();
            int n6 = n5 - n2;
            if (n6 == 0 || string2.regionMatches(n2, string, n3, n6)) {
                n3 += n6;
                n2 += n6;
            } else {
                parsePosition.setErrorIndex(n3);
                return;
            }
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                parsePosition.setIndex(n3);
                return;
            }
            if (type == MessagePattern.Part.Type.SKIP_SYNTAX || type == MessagePattern.Part.Type.INSERT_CHAR) {
                n2 = part.getLimit();
            } else {
                assert (type == MessagePattern.Part.Type.ARG_START) : "Unexpected Part " + part + " in parsed message.";
                int n7 = this.msgPattern.getLimitPartIndex(n4);
                MessagePattern.ArgType argType = part.getArgType();
                part = this.msgPattern.getPart(++n4);
                Object object = null;
                int n8 = 0;
                String string3 = null;
                if (objectArray != null) {
                    n8 = part.getValue();
                    object = n8;
                } else {
                    string3 = part.getType() == MessagePattern.Part.Type.ARG_NAME ? this.msgPattern.getSubstring(part) : Integer.toString(part.getValue());
                    object = string3;
                }
                Format format = null;
                boolean bl = false;
                Object object2 = null;
                if (this.cachedFormatters != null && (format = this.cachedFormatters.get(++n4 - 2)) != null) {
                    parsePosition2.setIndex(n3);
                    object2 = format.parseObject(string, parsePosition2);
                    if (parsePosition2.getIndex() == n3) {
                        parsePosition.setErrorIndex(n3);
                        return;
                    }
                    bl = true;
                    n3 = parsePosition2.getIndex();
                } else if (argType == MessagePattern.ArgType.NONE || this.cachedFormatters != null && this.cachedFormatters.containsKey(n4 - 2)) {
                    String string4 = this.getLiteralStringUntilNextArgument(n7);
                    int n9 = string4.length() != 0 ? string.indexOf(string4, n3) : string.length();
                    if (n9 < 0) {
                        parsePosition.setErrorIndex(n3);
                        return;
                    }
                    String string5 = string.substring(n3, n9);
                    if (!string5.equals("{" + object.toString() + "}")) {
                        bl = true;
                        object2 = string5;
                    }
                    n3 = n9;
                } else if (argType == MessagePattern.ArgType.CHOICE) {
                    parsePosition2.setIndex(n3);
                    double d = MessageFormat.parseChoiceArgument(this.msgPattern, n4, string, parsePosition2);
                    if (parsePosition2.getIndex() == n3) {
                        parsePosition.setErrorIndex(n3);
                        return;
                    }
                    object2 = d;
                    bl = true;
                    n3 = parsePosition2.getIndex();
                } else {
                    if (argType.hasPluralStyle() || argType == MessagePattern.ArgType.SELECT) {
                        throw new UnsupportedOperationException("Parsing of plural/select/selectordinal argument is not supported.");
                    }
                    throw new IllegalStateException("unexpected argType " + (Object)((Object)argType));
                }
                if (bl) {
                    if (objectArray != null) {
                        objectArray[n8] = object2;
                    } else if (map != null) {
                        map.put(string3, object2);
                    }
                }
                n2 = this.msgPattern.getPart(n7).getLimit();
                n4 = n7;
            }
            ++n4;
        }
    }

    public Map<String, Object> parseToMap(String string) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        this.parse(0, string, parsePosition, null, hashMap);
        if (parsePosition.getIndex() == 0) {
            throw new ParseException("MessageFormat parse error!", parsePosition.getErrorIndex());
        }
        return hashMap;
    }

    @Override
    public Object parseObject(String string, ParsePosition parsePosition) {
        if (!this.msgPattern.hasNamedArguments()) {
            return this.parse(string, parsePosition);
        }
        return this.parseToMap(string, parsePosition);
    }

    @Override
    public Object clone() {
        MessageFormat messageFormat = (MessageFormat)super.clone();
        if (this.customFormatArgStarts != null) {
            messageFormat.customFormatArgStarts = new HashSet<Integer>();
            for (Integer object : this.customFormatArgStarts) {
                messageFormat.customFormatArgStarts.add(object);
            }
        } else {
            messageFormat.customFormatArgStarts = null;
        }
        if (this.cachedFormatters != null) {
            messageFormat.cachedFormatters = new HashMap<Integer, Format>();
            for (Map.Entry entry : this.cachedFormatters.entrySet()) {
                messageFormat.cachedFormatters.put((Integer)entry.getKey(), (Format)entry.getValue());
            }
        } else {
            messageFormat.cachedFormatters = null;
        }
        messageFormat.msgPattern = this.msgPattern == null ? null : (MessagePattern)this.msgPattern.clone();
        messageFormat.stockDateFormatter = this.stockDateFormatter == null ? null : (Format)this.stockDateFormatter.clone();
        messageFormat.stockNumberFormatter = this.stockNumberFormatter == null ? null : (Format)this.stockNumberFormatter.clone();
        messageFormat.pluralProvider = null;
        messageFormat.ordinalProvider = null;
        return messageFormat;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        MessageFormat messageFormat = (MessageFormat)object;
        return Utility.objectEquals(this.ulocale, messageFormat.ulocale) && Utility.objectEquals(this.msgPattern, messageFormat.msgPattern) && Utility.objectEquals(this.cachedFormatters, messageFormat.cachedFormatters) && Utility.objectEquals(this.customFormatArgStarts, messageFormat.customFormatArgStarts);
    }

    public int hashCode() {
        return this.msgPattern.getPatternString().hashCode();
    }

    private void format(int n, double d, Object[] objectArray, Map<String, Object> map, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        String string = this.msgPattern.getPatternString();
        int n2 = this.msgPattern.getPart(n).getLimit();
        int n3 = n + 1;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(n3);
            MessagePattern.Part.Type type = part.getType();
            int n4 = part.getIndex();
            appendableWrapper.append(string, n2, n4);
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                return;
            }
            n2 = part.getLimit();
            if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                if (this.stockNumberFormatter == null) {
                    this.stockNumberFormatter = NumberFormat.getInstance(this.ulocale);
                }
                appendableWrapper.formatAndAppend(this.stockNumberFormatter, d);
            } else if (type == MessagePattern.Part.Type.ARG_START) {
                Object object;
                int n5;
                int n6 = this.msgPattern.getLimitPartIndex(n3);
                MessagePattern.ArgType argType = part.getArgType();
                part = this.msgPattern.getPart(++n3);
                String string2 = null;
                Object object2 = null;
                if (objectArray != null) {
                    n5 = part.getValue();
                    if (appendableWrapper.attributes != null) {
                        object2 = n5;
                    }
                    if (0 <= n5 && n5 < objectArray.length) {
                        object = objectArray[n5];
                    } else {
                        object = null;
                        string2 = "{" + n5 + "}";
                    }
                } else {
                    String string3 = part.getType() == MessagePattern.Part.Type.ARG_NAME ? this.msgPattern.getSubstring(part) : Integer.toString(part.getValue());
                    object2 = string3;
                    if (map != null && map.containsKey(string3)) {
                        object = map.get(string3);
                    } else {
                        object = null;
                        string2 = "{" + string3 + "}";
                    }
                }
                ++n3;
                n5 = appendableWrapper.length;
                Format format = null;
                if (string2 != null) {
                    appendableWrapper.append(string2);
                } else if (object == null) {
                    appendableWrapper.append("null");
                } else if (this.cachedFormatters != null && (format = this.cachedFormatters.get(n3 - 2)) != null) {
                    if (format instanceof ChoiceFormat || format instanceof PluralFormat || format instanceof SelectFormat) {
                        String string4 = format.format(object);
                        if (string4.indexOf(123) >= 0 || string4.indexOf(39) >= 0 && !this.msgPattern.jdkAposMode()) {
                            MessageFormat messageFormat = new MessageFormat(string4, this.ulocale);
                            messageFormat.format(0, 0.0, objectArray, map, appendableWrapper, null);
                        } else if (appendableWrapper.attributes == null) {
                            appendableWrapper.append(string4);
                        } else {
                            appendableWrapper.formatAndAppend(format, object);
                        }
                    } else {
                        appendableWrapper.formatAndAppend(format, object);
                    }
                } else if (argType == MessagePattern.ArgType.NONE || this.cachedFormatters != null && this.cachedFormatters.containsKey(n3 - 2)) {
                    if (object instanceof Number) {
                        if (this.stockNumberFormatter == null) {
                            this.stockNumberFormatter = NumberFormat.getInstance(this.ulocale);
                        }
                        appendableWrapper.formatAndAppend(this.stockNumberFormatter, object);
                    } else if (object instanceof Date) {
                        if (this.stockDateFormatter == null) {
                            this.stockDateFormatter = DateFormat.getDateTimeInstance(3, 3, this.ulocale);
                        }
                        appendableWrapper.formatAndAppend(this.stockDateFormatter, object);
                    } else {
                        appendableWrapper.append(object.toString());
                    }
                } else if (argType == MessagePattern.ArgType.CHOICE) {
                    if (!(object instanceof Number)) {
                        throw new IllegalArgumentException("'" + object + "' is not a Number");
                    }
                    double d2 = ((Number)object).doubleValue();
                    int n7 = MessageFormat.findChoiceSubMessage(this.msgPattern, n3, d2);
                    this.formatComplexSubMessage(n7, 0.0, objectArray, map, appendableWrapper);
                } else if (argType.hasPluralStyle()) {
                    PluralSelectorProvider pluralSelectorProvider;
                    if (!(object instanceof Number)) {
                        throw new IllegalArgumentException("'" + object + "' is not a Number");
                    }
                    double d3 = ((Number)object).doubleValue();
                    if (argType == MessagePattern.ArgType.PLURAL) {
                        if (this.pluralProvider == null) {
                            this.pluralProvider = new PluralSelectorProvider(this.ulocale, PluralRules.PluralType.CARDINAL);
                        }
                        pluralSelectorProvider = this.pluralProvider;
                    } else {
                        if (this.ordinalProvider == null) {
                            this.ordinalProvider = new PluralSelectorProvider(this.ulocale, PluralRules.PluralType.ORDINAL);
                        }
                        pluralSelectorProvider = this.ordinalProvider;
                    }
                    int n8 = PluralFormat.findSubMessage(this.msgPattern, n3, pluralSelectorProvider, d3);
                    double d4 = this.msgPattern.getPluralOffset(n3);
                    this.formatComplexSubMessage(n8, d3 - d4, objectArray, map, appendableWrapper);
                } else if (argType == MessagePattern.ArgType.SELECT) {
                    int n9 = SelectFormat.findSubMessage(this.msgPattern, n3, object.toString());
                    this.formatComplexSubMessage(n9, 0.0, objectArray, map, appendableWrapper);
                } else {
                    throw new IllegalStateException("unexpected argType " + (Object)((Object)argType));
                }
                fieldPosition = this.updateMetaData(appendableWrapper, n5, fieldPosition, object2);
                n2 = this.msgPattern.getPart(n6).getLimit();
                n3 = n6;
            }
            ++n3;
        }
    }

    private void formatComplexSubMessage(int n, double d, Object[] objectArray, Map<String, Object> map, AppendableWrapper appendableWrapper) {
        String string;
        if (!this.msgPattern.jdkAposMode()) {
            this.format(n, d, objectArray, map, appendableWrapper, null);
            return;
        }
        String string2 = this.msgPattern.getPatternString();
        StringBuilder stringBuilder = null;
        int n2 = this.msgPattern.getPart(n).getLimit();
        int n3 = n;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(++n3);
            MessagePattern.Part.Type type = part.getType();
            int n4 = part.getIndex();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                if (stringBuilder == null) {
                    string = string2.substring(n2, n4);
                    break;
                }
                string = stringBuilder.append(string2, n2, n4).toString();
                break;
            }
            if (type == MessagePattern.Part.Type.REPLACE_NUMBER || type == MessagePattern.Part.Type.SKIP_SYNTAX) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(string2, n2, n4);
                if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                    if (this.stockNumberFormatter == null) {
                        this.stockNumberFormatter = NumberFormat.getInstance(this.ulocale);
                    }
                    stringBuilder.append(this.stockNumberFormatter.format(d));
                }
                n2 = part.getLimit();
                continue;
            }
            if (type != MessagePattern.Part.Type.ARG_START) continue;
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(string2, n2, n4);
            n2 = n4;
            n3 = this.msgPattern.getLimitPartIndex(n3);
            n4 = this.msgPattern.getPart(n3).getLimit();
            MessagePattern.appendReducedApostrophes(string2, n2, n4, stringBuilder);
            n2 = n4;
        }
        if (string.indexOf(123) >= 0) {
            MessageFormat messageFormat = new MessageFormat("", this.ulocale);
            messageFormat.applyPattern(string, MessagePattern.ApostropheMode.DOUBLE_REQUIRED);
            messageFormat.format(0, 0.0, objectArray, map, appendableWrapper, null);
        } else {
            appendableWrapper.append(string);
        }
    }

    private String getLiteralStringUntilNextArgument(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.msgPattern.getPatternString();
        int n2 = this.msgPattern.getPart(n).getLimit();
        int n3 = n + 1;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(n3);
            MessagePattern.Part.Type type = part.getType();
            int n4 = part.getIndex();
            stringBuilder.append(string, n2, n4);
            if (type == MessagePattern.Part.Type.ARG_START || type == MessagePattern.Part.Type.MSG_LIMIT) {
                return stringBuilder.toString();
            }
            assert (type == MessagePattern.Part.Type.SKIP_SYNTAX || type == MessagePattern.Part.Type.INSERT_CHAR) : "Unexpected Part " + part + " in parsed message.";
            n2 = part.getLimit();
            ++n3;
        }
    }

    private FieldPosition updateMetaData(AppendableWrapper appendableWrapper, int n, FieldPosition fieldPosition, Object object) {
        if (appendableWrapper.attributes != null && n < appendableWrapper.length) {
            appendableWrapper.attributes.add(new AttributeAndPosition(object, n, appendableWrapper.length));
        }
        if (fieldPosition != null && Field.ARGUMENT.equals(fieldPosition.getFieldAttribute())) {
            fieldPosition.setBeginIndex(n);
            fieldPosition.setEndIndex(appendableWrapper.length);
            return null;
        }
        return fieldPosition;
    }

    private static int findChoiceSubMessage(MessagePattern messagePattern, int n, double d) {
        int n2;
        double d2;
        int n3;
        char c;
        int n4 = messagePattern.countParts();
        n += 2;
        do {
            MessagePattern.Part part;
            MessagePattern.Part.Type type;
            n2 = n;
            n = messagePattern.getLimitPartIndex(n);
            if (++n >= n4 || (type = (part = messagePattern.getPart(n++)).getType()) == MessagePattern.Part.Type.ARG_LIMIT) break;
            assert (type.hasNumericValue());
            d2 = messagePattern.getNumericValue(part);
            n3 = messagePattern.getPatternIndex(n++);
        } while (!((c = messagePattern.getPatternString().charAt(n3)) == '<' ? !(d > d2) : !(d >= d2)));
        return n2;
    }

    private static double parseChoiceArgument(MessagePattern messagePattern, int n, String string, ParsePosition parsePosition) {
        int n2;
        int n3 = n2 = parsePosition.getIndex();
        double d = Double.NaN;
        double d2 = 0.0;
        while (messagePattern.getPartType(n) != MessagePattern.Part.Type.ARG_LIMIT) {
            int n4;
            int n5;
            int n6;
            d2 = messagePattern.getNumericValue(messagePattern.getPart(n));
            if ((n6 = MessageFormat.matchStringUntilLimitPart(messagePattern, n += 2, n5 = messagePattern.getLimitPartIndex(n), string, n2)) >= 0 && (n4 = n2 + n6) > n3) {
                n3 = n4;
                d = d2;
                if (n3 == string.length()) break;
            }
            n = n5 + 1;
        }
        if (n3 == n2) {
            parsePosition.setErrorIndex(n2);
        } else {
            parsePosition.setIndex(n3);
        }
        return d;
    }

    private static int matchStringUntilLimitPart(MessagePattern messagePattern, int n, int n2, String string, int n3) {
        int n4 = 0;
        String string2 = messagePattern.getPatternString();
        int n5 = messagePattern.getPart(n).getLimit();
        while (true) {
            MessagePattern.Part part = messagePattern.getPart(++n);
            if (n != n2 && part.getType() != MessagePattern.Part.Type.SKIP_SYNTAX) continue;
            int n6 = part.getIndex();
            int n7 = n6 - n5;
            if (n7 != 0 && !string.regionMatches(n3, string2, n5, n7)) {
                return -1;
            }
            n4 += n7;
            if (n == n2) {
                return n4;
            }
            n5 = part.getLimit();
        }
    }

    private void format(Object object, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        if (object == null || object instanceof Map) {
            this.format(null, (Map)object, appendableWrapper, fieldPosition);
        } else {
            this.format((Object[])object, null, appendableWrapper, fieldPosition);
        }
    }

    private void format(Object[] objectArray, Map<String, Object> map, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        if (objectArray != null && this.msgPattern.hasNamedArguments()) {
            throw new IllegalArgumentException("This method is not available in MessageFormat objects that use alphanumeric argument names.");
        }
        this.format(0, 0.0, objectArray, map, appendableWrapper, fieldPosition);
    }

    private void resetPattern() {
        if (this.msgPattern != null) {
            this.msgPattern.clear();
        }
        if (this.cachedFormatters != null) {
            this.cachedFormatters.clear();
        }
        this.customFormatArgStarts = null;
    }

    private Format createAppropriateFormat(String string, String string2) {
        UFormat uFormat = null;
        int n = MessageFormat.findKeyword(string, typeList);
        block3 : switch (n) {
            case 0: {
                switch (MessageFormat.findKeyword(string2, modifierList)) {
                    case 0: {
                        uFormat = NumberFormat.getInstance(this.ulocale);
                        break block3;
                    }
                    case 1: {
                        uFormat = NumberFormat.getCurrencyInstance(this.ulocale);
                        break block3;
                    }
                    case 2: {
                        uFormat = NumberFormat.getPercentInstance(this.ulocale);
                        break block3;
                    }
                    case 3: {
                        uFormat = NumberFormat.getIntegerInstance(this.ulocale);
                        break block3;
                    }
                }
                uFormat = new DecimalFormat(string2, new DecimalFormatSymbols(this.ulocale));
                break;
            }
            case 1: {
                switch (MessageFormat.findKeyword(string2, dateModifierList)) {
                    case 0: {
                        uFormat = DateFormat.getDateInstance(2, this.ulocale);
                        break block3;
                    }
                    case 1: {
                        uFormat = DateFormat.getDateInstance(3, this.ulocale);
                        break block3;
                    }
                    case 2: {
                        uFormat = DateFormat.getDateInstance(2, this.ulocale);
                        break block3;
                    }
                    case 3: {
                        uFormat = DateFormat.getDateInstance(1, this.ulocale);
                        break block3;
                    }
                    case 4: {
                        uFormat = DateFormat.getDateInstance(0, this.ulocale);
                        break block3;
                    }
                }
                uFormat = new SimpleDateFormat(string2, this.ulocale);
                break;
            }
            case 2: {
                switch (MessageFormat.findKeyword(string2, dateModifierList)) {
                    case 0: {
                        uFormat = DateFormat.getTimeInstance(2, this.ulocale);
                        break block3;
                    }
                    case 1: {
                        uFormat = DateFormat.getTimeInstance(3, this.ulocale);
                        break block3;
                    }
                    case 2: {
                        uFormat = DateFormat.getTimeInstance(2, this.ulocale);
                        break block3;
                    }
                    case 3: {
                        uFormat = DateFormat.getTimeInstance(1, this.ulocale);
                        break block3;
                    }
                    case 4: {
                        uFormat = DateFormat.getTimeInstance(0, this.ulocale);
                        break block3;
                    }
                }
                uFormat = new SimpleDateFormat(string2, this.ulocale);
                break;
            }
            case 3: {
                RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(this.ulocale, 1);
                String string3 = string2.trim();
                if (string3.length() != 0) {
                    try {
                        ruleBasedNumberFormat.setDefaultRuleSet(string3);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                uFormat = ruleBasedNumberFormat;
                break;
            }
            case 4: {
                RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(this.ulocale, 2);
                String string4 = string2.trim();
                if (string4.length() != 0) {
                    try {
                        ruleBasedNumberFormat.setDefaultRuleSet(string4);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                uFormat = ruleBasedNumberFormat;
                break;
            }
            case 5: {
                RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(this.ulocale, 3);
                String string5 = string2.trim();
                if (string5.length() != 0) {
                    try {
                        ruleBasedNumberFormat.setDefaultRuleSet(string5);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                uFormat = ruleBasedNumberFormat;
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown format type \"" + string + "\"");
            }
        }
        return uFormat;
    }

    private static final int findKeyword(String string, String[] stringArray) {
        string = PatternProps.trimWhiteSpace(string).toLowerCase(rootLocale);
        for (int i = 0; i < stringArray.length; ++i) {
            if (!string.equals(stringArray[i])) continue;
            return i;
        }
        return -1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.ulocale.toLanguageTag());
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        objectOutputStream.writeObject((Object)this.msgPattern.getApostropheMode());
        objectOutputStream.writeObject(this.msgPattern.getPatternString());
        if (this.customFormatArgStarts == null || this.customFormatArgStarts.isEmpty()) {
            objectOutputStream.writeInt(0);
        } else {
            objectOutputStream.writeInt(this.customFormatArgStarts.size());
            int n = 0;
            int n2 = 0;
            while ((n2 = this.nextTopLevelArgStart(n2)) >= 0) {
                if (this.customFormatArgStarts.contains(n2)) {
                    objectOutputStream.writeInt(n);
                    objectOutputStream.writeObject(this.cachedFormatters.get(n2));
                }
                ++n;
            }
        }
        objectOutputStream.writeInt(0);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int n;
        String string;
        objectInputStream.defaultReadObject();
        String string2 = (String)objectInputStream.readObject();
        this.ulocale = ULocale.forLanguageTag(string2);
        MessagePattern.ApostropheMode apostropheMode = (MessagePattern.ApostropheMode)((Object)objectInputStream.readObject());
        if (this.msgPattern == null || apostropheMode != this.msgPattern.getApostropheMode()) {
            this.msgPattern = new MessagePattern(apostropheMode);
        }
        if ((string = (String)objectInputStream.readObject()) != null) {
            this.applyPattern(string);
        }
        for (n = objectInputStream.readInt(); n > 0; --n) {
            int n2 = objectInputStream.readInt();
            Format format = (Format)objectInputStream.readObject();
            this.setFormat(n2, format);
        }
        for (n = objectInputStream.readInt(); n > 0; --n) {
            objectInputStream.readInt();
            objectInputStream.readObject();
        }
    }

    private void cacheExplicitFormats() {
        if (this.cachedFormatters != null) {
            this.cachedFormatters.clear();
        }
        this.customFormatArgStarts = null;
        int n = this.msgPattern.countParts() - 2;
        for (int i = 1; i < n; ++i) {
            MessagePattern.ArgType argType;
            MessagePattern.Part part = this.msgPattern.getPart(i);
            if (part.getType() != MessagePattern.Part.Type.ARG_START || (argType = part.getArgType()) != MessagePattern.ArgType.SIMPLE) continue;
            int n2 = i;
            i += 2;
            String string = this.msgPattern.getSubstring(this.msgPattern.getPart(i++));
            String string2 = "";
            part = this.msgPattern.getPart(i);
            if (part.getType() == MessagePattern.Part.Type.ARG_STYLE) {
                string2 = this.msgPattern.getSubstring(part);
                ++i;
            }
            Format format = this.createAppropriateFormat(string, string2);
            this.setArgStartFormat(n2, format);
        }
    }

    private void setArgStartFormat(int n, Format format) {
        if (this.cachedFormatters == null) {
            this.cachedFormatters = new HashMap<Integer, Format>();
        }
        this.cachedFormatters.put(n, format);
    }

    private void setCustomArgStartFormat(int n, Format format) {
        this.setArgStartFormat(n, format);
        if (this.customFormatArgStarts == null) {
            this.customFormatArgStarts = new HashSet<Integer>();
        }
        this.customFormatArgStarts.add(n);
    }

    public static String autoQuoteApostrophe(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length() * 2);
        int n = 0;
        int n2 = 0;
        int n3 = string.length();
        for (int i = 0; i < n3; ++i) {
            char c = string.charAt(i);
            block0 : switch (n) {
                case 0: {
                    switch (c) {
                        case '\'': {
                            n = 1;
                            break;
                        }
                        case '{': {
                            n = 3;
                            ++n2;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (c) {
                        case '\'': {
                            n = 0;
                            break block0;
                        }
                        case '{': 
                        case '}': {
                            n = 2;
                            break block0;
                        }
                    }
                    stringBuilder.append('\'');
                    n = 0;
                    break;
                }
                case 2: {
                    switch (c) {
                        case '\'': {
                            n = 0;
                        }
                    }
                    break;
                }
                case 3: {
                    switch (c) {
                        case '{': {
                            ++n2;
                            break;
                        }
                        case '}': {
                            if (--n2 != 0) break;
                            n = 0;
                        }
                    }
                    break;
                }
            }
            stringBuilder.append(c);
        }
        if (n == 1 || n == 2) {
            stringBuilder.append('\'');
        }
        return new String(stringBuilder);
    }

    private static final class AttributeAndPosition {
        private AttributedCharacterIterator.Attribute key;
        private Object value;
        private int start;
        private int limit;

        public AttributeAndPosition(Object object, int n, int n2) {
            this.init(Field.ARGUMENT, object, n, n2);
        }

        public AttributeAndPosition(AttributedCharacterIterator.Attribute attribute, Object object, int n, int n2) {
            this.init(attribute, object, n, n2);
        }

        public void init(AttributedCharacterIterator.Attribute attribute, Object object, int n, int n2) {
            this.key = attribute;
            this.value = object;
            this.start = n;
            this.limit = n2;
        }
    }

    private static final class AppendableWrapper {
        private Appendable app;
        private int length;
        private List<AttributeAndPosition> attributes;

        public AppendableWrapper(StringBuilder stringBuilder) {
            this.app = stringBuilder;
            this.length = stringBuilder.length();
            this.attributes = null;
        }

        public AppendableWrapper(StringBuffer stringBuffer) {
            this.app = stringBuffer;
            this.length = stringBuffer.length();
            this.attributes = null;
        }

        public void useAttributes() {
            this.attributes = new ArrayList<AttributeAndPosition>();
        }

        public void append(CharSequence charSequence) {
            try {
                this.app.append(charSequence);
                this.length += charSequence.length();
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }

        public void append(CharSequence charSequence, int n, int n2) {
            try {
                this.app.append(charSequence, n, n2);
                this.length += n2 - n;
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }

        public void append(CharacterIterator characterIterator) {
            this.length += AppendableWrapper.append(this.app, characterIterator);
        }

        public static int append(Appendable appendable, CharacterIterator characterIterator) {
            try {
                int n = characterIterator.getBeginIndex();
                int n2 = characterIterator.getEndIndex();
                int n3 = n2 - n;
                if (n < n2) {
                    appendable.append(characterIterator.first());
                    while (++n < n2) {
                        appendable.append(characterIterator.next());
                    }
                }
                return n3;
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }

        public void formatAndAppend(Format format, Object object) {
            if (this.attributes == null) {
                this.append(format.format(object));
            } else {
                AttributedCharacterIterator attributedCharacterIterator = format.formatToCharacterIterator(object);
                int n = this.length;
                this.append(attributedCharacterIterator);
                attributedCharacterIterator.first();
                int n2 = attributedCharacterIterator.getIndex();
                int n3 = attributedCharacterIterator.getEndIndex();
                int n4 = n - n2;
                while (n2 < n3) {
                    Map<AttributedCharacterIterator.Attribute, Object> map = attributedCharacterIterator.getAttributes();
                    int n5 = attributedCharacterIterator.getRunLimit();
                    if (map.size() != 0) {
                        for (Map.Entry<AttributedCharacterIterator.Attribute, Object> entry : map.entrySet()) {
                            this.attributes.add(new AttributeAndPosition(entry.getKey(), entry.getValue(), n4 + n2, n4 + n5));
                        }
                    }
                    n2 = n5;
                    attributedCharacterIterator.setIndex(n2);
                }
            }
        }
    }

    private static final class PluralSelectorProvider
    implements PluralFormat.PluralSelector {
        private ULocale locale;
        private PluralRules rules;
        private PluralRules.PluralType type;

        public PluralSelectorProvider(ULocale uLocale, PluralRules.PluralType pluralType) {
            this.locale = uLocale;
            this.type = pluralType;
        }

        public String select(double d) {
            if (this.rules == null) {
                this.rules = PluralRules.forLocale(this.locale, this.type);
            }
            return this.rules.select(d);
        }
    }

    public static class Field
    extends Format.Field {
        private static final long serialVersionUID = 7510380454602616157L;
        public static final Field ARGUMENT = new Field("message argument field");

        protected Field(String string) {
            super(string);
        }

        protected Object readResolve() throws InvalidObjectException {
            if (this.getClass() != Field.class) {
                throw new InvalidObjectException("A subclass of MessageFormat.Field must implement readResolve.");
            }
            if (this.getName().equals(ARGUMENT.getName())) {
                return ARGUMENT;
            }
            throw new InvalidObjectException("Unknown attribute name.");
        }
    }
}

