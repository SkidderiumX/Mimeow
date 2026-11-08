/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.apache.logging.log4j.core.config.plugins.PluginType;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.ExtendedThrowablePatternConverter;
import org.apache.logging.log4j.core.pattern.FormattingInfo;
import org.apache.logging.log4j.core.pattern.LiteralPatternConverter;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;
import org.apache.logging.log4j.core.pattern.PatternFormatter;
import org.apache.logging.log4j.status.StatusLogger;

public class PatternParser {
    private static final char ESCAPE_CHAR = '%';
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final int BUF_SIZE = 32;
    private static final int DECIMAL = 10;
    private final Configuration config;
    private final Map<String, Class<PatternConverter>> converterRules;

    public PatternParser(String string) {
        this(null, string, null, null);
    }

    public PatternParser(Configuration configuration, String string, Class<?> clazz) {
        this(configuration, string, clazz, null);
    }

    public PatternParser(Configuration configuration, String string, Class<?> clazz, Class<?> clazz2) {
        this.config = configuration;
        PluginManager pluginManager = new PluginManager(string, clazz);
        pluginManager.collectPlugins();
        Map<String, PluginType<?>> map = pluginManager.getPlugins();
        HashMap<String, Class<PatternConverter>> hashMap = new HashMap<String, Class<PatternConverter>>();
        for (PluginType<?> pluginType : map.values()) {
            try {
                ConverterKeys converterKeys;
                Class<?> clazz3 = pluginType.getPluginClass();
                if (clazz2 != null && !clazz2.isAssignableFrom(clazz3) || (converterKeys = clazz3.getAnnotation(ConverterKeys.class)) == null) continue;
                for (String string2 : converterKeys.value()) {
                    hashMap.put(string2, clazz3);
                }
            }
            catch (Exception exception) {
                LOGGER.error("Error processing plugin " + pluginType.getElementName(), (Throwable)exception);
            }
        }
        this.converterRules = hashMap;
    }

    public List<PatternFormatter> parse(String string) {
        return this.parse(string, false);
    }

    public List<PatternFormatter> parse(String string, boolean bl) {
        ArrayList<PatternFormatter> arrayList = new ArrayList<PatternFormatter>();
        ArrayList<PatternConverter> arrayList2 = new ArrayList<PatternConverter>();
        ArrayList<FormattingInfo> arrayList3 = new ArrayList<FormattingInfo>();
        this.parse(string, arrayList2, arrayList3);
        Iterator iterator2 = arrayList3.iterator();
        boolean bl2 = false;
        for (PatternConverter patternConverter : arrayList2) {
            LogEventPatternConverter logEventPatternConverter;
            if (patternConverter instanceof LogEventPatternConverter) {
                logEventPatternConverter = (LogEventPatternConverter)patternConverter;
                bl2 |= logEventPatternConverter.handlesThrowable();
            } else {
                logEventPatternConverter = new LiteralPatternConverter(this.config, "");
            }
            FormattingInfo formattingInfo = iterator2.hasNext() ? (FormattingInfo)iterator2.next() : FormattingInfo.getDefault();
            arrayList.add(new PatternFormatter(logEventPatternConverter, formattingInfo));
        }
        if (bl && !bl2) {
            ExtendedThrowablePatternConverter extendedThrowablePatternConverter = ExtendedThrowablePatternConverter.newInstance(null);
            arrayList.add(new PatternFormatter(extendedThrowablePatternConverter, FormattingInfo.getDefault()));
        }
        return arrayList;
    }

    private static int extractConverter(char c, String string, int n, StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        stringBuilder.setLength(0);
        if (!Character.isUnicodeIdentifierStart(c)) {
            return n;
        }
        stringBuilder.append(c);
        while (n < string.length() && Character.isUnicodeIdentifierPart(string.charAt(n))) {
            stringBuilder.append(string.charAt(n));
            stringBuilder2.append(string.charAt(n));
            ++n;
        }
        return n;
    }

    private static int extractOptions(String string, int n, List<String> list) {
        while (n < string.length() && string.charAt(n) == '{') {
            int n2;
            int n3 = n++;
            int n4 = 0;
            do {
                if ((n2 = string.indexOf(125, n)) == -1) continue;
                int n5 = string.indexOf("{", n);
                if (n5 != -1 && n5 < n2) {
                    n = n2 + 1;
                    ++n4;
                    continue;
                }
                if (n4 <= 0) continue;
                --n4;
            } while (n4 > 0);
            if (n2 == -1) break;
            String string2 = string.substring(n3 + 1, n2);
            list.add(string2);
            n = n2 + 1;
        }
        return n;
    }

    public void parse(String string, List<PatternConverter> list, List<FormattingInfo> list2) {
        if (string == null) {
            throw new NullPointerException("pattern");
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        int n = string.length();
        ParserState parserState = ParserState.LITERAL_STATE;
        int n2 = 0;
        FormattingInfo formattingInfo = FormattingInfo.getDefault();
        while (n2 < n) {
            char c = string.charAt(n2++);
            block0 : switch (parserState) {
                case LITERAL_STATE: {
                    if (n2 == n) {
                        stringBuilder.append(c);
                        break;
                    }
                    if (c == '%') {
                        switch (string.charAt(n2)) {
                            case '%': {
                                stringBuilder.append(c);
                                ++n2;
                                break block0;
                            }
                        }
                        if (stringBuilder.length() != 0) {
                            list.add(new LiteralPatternConverter(this.config, stringBuilder.toString()));
                            list2.add(FormattingInfo.getDefault());
                        }
                        stringBuilder.setLength(0);
                        stringBuilder.append(c);
                        parserState = ParserState.CONVERTER_STATE;
                        formattingInfo = FormattingInfo.getDefault();
                        break;
                    }
                    stringBuilder.append(c);
                    break;
                }
                case CONVERTER_STATE: {
                    stringBuilder.append(c);
                    switch (c) {
                        case '-': {
                            formattingInfo = new FormattingInfo(true, formattingInfo.getMinLength(), formattingInfo.getMaxLength());
                            break block0;
                        }
                        case '.': {
                            parserState = ParserState.DOT_STATE;
                            break block0;
                        }
                    }
                    if (c >= '0' && c <= '9') {
                        formattingInfo = new FormattingInfo(formattingInfo.isLeftAligned(), c - 48, formattingInfo.getMaxLength());
                        parserState = ParserState.MIN_STATE;
                        break;
                    }
                    n2 = this.finalizeConverter(c, string, n2, stringBuilder, formattingInfo, this.converterRules, list, list2);
                    parserState = ParserState.LITERAL_STATE;
                    formattingInfo = FormattingInfo.getDefault();
                    stringBuilder.setLength(0);
                    break;
                }
                case MIN_STATE: {
                    stringBuilder.append(c);
                    if (c >= '0' && c <= '9') {
                        formattingInfo = new FormattingInfo(formattingInfo.isLeftAligned(), formattingInfo.getMinLength() * 10 + c - 48, formattingInfo.getMaxLength());
                        break;
                    }
                    if (c == '.') {
                        parserState = ParserState.DOT_STATE;
                        break;
                    }
                    n2 = this.finalizeConverter(c, string, n2, stringBuilder, formattingInfo, this.converterRules, list, list2);
                    parserState = ParserState.LITERAL_STATE;
                    formattingInfo = FormattingInfo.getDefault();
                    stringBuilder.setLength(0);
                    break;
                }
                case DOT_STATE: {
                    stringBuilder.append(c);
                    if (c >= '0' && c <= '9') {
                        formattingInfo = new FormattingInfo(formattingInfo.isLeftAligned(), formattingInfo.getMinLength(), c - 48);
                        parserState = ParserState.MAX_STATE;
                        break;
                    }
                    LOGGER.error("Error occurred in position " + n2 + ".\n Was expecting digit, instead got char \"" + c + "\".");
                    parserState = ParserState.LITERAL_STATE;
                    break;
                }
                case MAX_STATE: {
                    stringBuilder.append(c);
                    if (c >= '0' && c <= '9') {
                        formattingInfo = new FormattingInfo(formattingInfo.isLeftAligned(), formattingInfo.getMinLength(), formattingInfo.getMaxLength() * 10 + c - 48);
                        break;
                    }
                    n2 = this.finalizeConverter(c, string, n2, stringBuilder, formattingInfo, this.converterRules, list, list2);
                    parserState = ParserState.LITERAL_STATE;
                    formattingInfo = FormattingInfo.getDefault();
                    stringBuilder.setLength(0);
                }
            }
        }
        if (stringBuilder.length() != 0) {
            list.add(new LiteralPatternConverter(this.config, stringBuilder.toString()));
            list2.add(FormattingInfo.getDefault());
        }
    }

    private PatternConverter createConverter(String string, StringBuilder stringBuilder, Map<String, Class<PatternConverter>> map, List<String> list) {
        Object[] objectArray;
        String string2 = string;
        Class<PatternConverter> clazz = null;
        for (int i = string.length(); i > 0 && clazz == null; --i) {
            string2 = string2.substring(0, i);
            if (clazz != null || map == null) continue;
            clazz = map.get(string2);
        }
        if (clazz == null) {
            LOGGER.error("Unrecognized format specifier [" + string + "]");
            return null;
        }
        Method[] methodArray = clazz.getDeclaredMethods();
        Method method = null;
        for (Method method2 : methodArray) {
            if (!Modifier.isStatic(method2.getModifiers()) || !method2.getDeclaringClass().equals(clazz) || !method2.getName().equals("newInstance")) continue;
            if (method == null) {
                method = method2;
                continue;
            }
            if (!method2.getReturnType().equals(method.getReturnType())) continue;
            LOGGER.error("Class " + clazz + " cannot contain multiple static newInstance methods");
            return null;
        }
        if (method == null) {
            LOGGER.error("Class " + clazz + " does not contain a static newInstance method");
            return null;
        }
        GenericDeclaration[] genericDeclarationArray = method.getParameterTypes();
        Object[] objectArray2 = objectArray = genericDeclarationArray.length > 0 ? new Object[genericDeclarationArray.length] : null;
        if (objectArray != null) {
            int n = 0;
            boolean bl = false;
            for (GenericDeclaration genericDeclaration : genericDeclarationArray) {
                if (((Class)genericDeclaration).isArray() && ((Class)genericDeclaration).getName().equals("[Ljava.lang.String;")) {
                    String[] stringArray;
                    objectArray[n] = stringArray = list.toArray(new String[list.size()]);
                } else if (((Class)genericDeclaration).isAssignableFrom(Configuration.class)) {
                    objectArray[n] = this.config;
                } else {
                    LOGGER.error("Unknown parameter type " + ((Class)genericDeclaration).getName() + " for static newInstance method of " + clazz.getName());
                    bl = true;
                }
                ++n;
            }
            if (bl) {
                return null;
            }
        }
        try {
            Object object = method.invoke(null, objectArray);
            if (object instanceof PatternConverter) {
                stringBuilder.delete(0, stringBuilder.length() - (string.length() - string2.length()));
                return (PatternConverter)object;
            }
            LOGGER.warn("Class " + clazz.getName() + " does not extend PatternConverter.");
        }
        catch (Exception exception) {
            LOGGER.error("Error creating converter for " + string, (Throwable)exception);
        }
        return null;
    }

    private int finalizeConverter(char c, String string, int n, StringBuilder stringBuilder, FormattingInfo formattingInfo, Map<String, Class<PatternConverter>> map, List<PatternConverter> list, List<FormattingInfo> list2) {
        StringBuilder stringBuilder2 = new StringBuilder();
        n = PatternParser.extractConverter(c, string, n, stringBuilder2, stringBuilder);
        String string2 = stringBuilder2.toString();
        ArrayList<String> arrayList = new ArrayList<String>();
        n = PatternParser.extractOptions(string, n, arrayList);
        PatternConverter patternConverter = this.createConverter(string2, stringBuilder, map, arrayList);
        if (patternConverter == null) {
            StringBuilder stringBuilder3;
            if (Strings.isEmpty(string2)) {
                stringBuilder3 = new StringBuilder("Empty conversion specifier starting at position ");
            } else {
                stringBuilder3 = new StringBuilder("Unrecognized conversion specifier [");
                stringBuilder3.append(string2);
                stringBuilder3.append("] starting at position ");
            }
            stringBuilder3.append(Integer.toString(n));
            stringBuilder3.append(" in conversion pattern.");
            LOGGER.error(stringBuilder3.toString());
            list.add(new LiteralPatternConverter(this.config, stringBuilder.toString()));
            list2.add(FormattingInfo.getDefault());
        } else {
            list.add(patternConverter);
            list2.add(formattingInfo);
            if (stringBuilder.length() > 0) {
                list.add(new LiteralPatternConverter(this.config, stringBuilder.toString()));
                list2.add(FormattingInfo.getDefault());
            }
        }
        stringBuilder.setLength(0);
        return n;
    }

    private static enum ParserState {
        LITERAL_STATE,
        CONVERTER_STATE,
        DOT_STATE,
        MIN_STATE,
        MAX_STATE;

    }
}

