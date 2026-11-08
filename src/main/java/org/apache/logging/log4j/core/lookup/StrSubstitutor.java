/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.lookup;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.lookup.MapLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.core.lookup.StrMatcher;

public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    private static final int BUF_SIZE = 256;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private StrMatcher suffixMatcher;
    private StrLookup variableResolver;
    private boolean enableSubstitutionInVariables;

    public StrSubstitutor() {
        this(null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public StrSubstitutor(Map<String, String> map) {
        this((StrLookup)new MapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public StrSubstitutor(Map<String, String> map, String string, String string2) {
        this((StrLookup)new MapLookup(map), string, string2, '$');
    }

    public StrSubstitutor(Map<String, String> map, String string, String string2, char c) {
        this((StrLookup)new MapLookup(map), string, string2, c);
    }

    public StrSubstitutor(StrLookup strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public StrSubstitutor(StrLookup strLookup, String string, String string2, char c) {
        this.setVariableResolver(strLookup);
        this.setVariablePrefix(string);
        this.setVariableSuffix(string2);
        this.setEscapeChar(c);
    }

    public StrSubstitutor(StrLookup strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c) {
        this.setVariableResolver(strLookup);
        this.setVariablePrefixMatcher(strMatcher);
        this.setVariableSuffixMatcher(strMatcher2);
        this.setEscapeChar(c);
    }

    public static String replace(Object object, Map<String, String> map) {
        return new StrSubstitutor(map).replace(object);
    }

    public static String replace(Object object, Map<String, String> map, String string, String string2) {
        return new StrSubstitutor(map, string, string2).replace(object);
    }

    public static String replace(Object object, Properties properties) {
        if (properties == null) {
            return object.toString();
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            String string2 = properties.getProperty(string);
            hashMap.put(string, string2);
        }
        return StrSubstitutor.replace(object, hashMap);
    }

    public String replace(String string) {
        return this.replace(null, string);
    }

    public String replace(LogEvent logEvent, String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        if (!this.substitute(logEvent, stringBuilder, 0, string.length())) {
            return string;
        }
        return stringBuilder.toString();
    }

    public String replace(String string, int n, int n2) {
        return this.replace(null, string, n, n2);
    }

    public String replace(LogEvent logEvent, String string, int n, int n2) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(n2).append(string, n, n2);
        if (!this.substitute(logEvent, stringBuilder, 0, n2)) {
            return string.substring(n, n + n2);
        }
        return stringBuilder.toString();
    }

    public String replace(char[] cArray) {
        return this.replace((LogEvent)null, cArray);
    }

    public String replace(LogEvent logEvent, char[] cArray) {
        if (cArray == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(cArray.length).append(cArray);
        this.substitute(logEvent, stringBuilder, 0, cArray.length);
        return stringBuilder.toString();
    }

    public String replace(char[] cArray, int n, int n2) {
        return this.replace(null, cArray, n, n2);
    }

    public String replace(LogEvent logEvent, char[] cArray, int n, int n2) {
        if (cArray == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(n2).append(cArray, n, n2);
        this.substitute(logEvent, stringBuilder, 0, n2);
        return stringBuilder.toString();
    }

    public String replace(StringBuffer stringBuffer) {
        return this.replace(null, stringBuffer);
    }

    public String replace(LogEvent logEvent, StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(stringBuffer.length()).append(stringBuffer);
        this.substitute(logEvent, stringBuilder, 0, stringBuilder.length());
        return stringBuilder.toString();
    }

    public String replace(StringBuffer stringBuffer, int n, int n2) {
        return this.replace(null, stringBuffer, n, n2);
    }

    public String replace(LogEvent logEvent, StringBuffer stringBuffer, int n, int n2) {
        if (stringBuffer == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(n2).append(stringBuffer, n, n2);
        this.substitute(logEvent, stringBuilder, 0, n2);
        return stringBuilder.toString();
    }

    public String replace(StringBuilder stringBuilder) {
        return this.replace(null, stringBuilder);
    }

    public String replace(LogEvent logEvent, StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.length()).append((CharSequence)stringBuilder);
        this.substitute(logEvent, stringBuilder2, 0, stringBuilder2.length());
        return stringBuilder2.toString();
    }

    public String replace(StringBuilder stringBuilder, int n, int n2) {
        return this.replace(null, stringBuilder, n, n2);
    }

    public String replace(LogEvent logEvent, StringBuilder stringBuilder, int n, int n2) {
        if (stringBuilder == null) {
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder(n2).append(stringBuilder, n, n2);
        this.substitute(logEvent, stringBuilder2, 0, n2);
        return stringBuilder2.toString();
    }

    public String replace(Object object) {
        return this.replace(null, object);
    }

    public String replace(LogEvent logEvent, Object object) {
        if (object == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder().append(object);
        this.substitute(logEvent, stringBuilder, 0, stringBuilder.length());
        return stringBuilder.toString();
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return this.replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public boolean replaceIn(StringBuffer stringBuffer, int n, int n2) {
        return this.replaceIn(null, stringBuffer, n, n2);
    }

    public boolean replaceIn(LogEvent logEvent, StringBuffer stringBuffer, int n, int n2) {
        if (stringBuffer == null) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(n2).append(stringBuffer, n, n2);
        if (!this.substitute(logEvent, stringBuilder, 0, n2)) {
            return false;
        }
        stringBuffer.replace(n, n + n2, stringBuilder.toString());
        return true;
    }

    public boolean replaceIn(StringBuilder stringBuilder) {
        return this.replaceIn(null, stringBuilder);
    }

    public boolean replaceIn(LogEvent logEvent, StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            return false;
        }
        return this.substitute(logEvent, stringBuilder, 0, stringBuilder.length());
    }

    public boolean replaceIn(StringBuilder stringBuilder, int n, int n2) {
        return this.replaceIn(null, stringBuilder, n, n2);
    }

    public boolean replaceIn(LogEvent logEvent, StringBuilder stringBuilder, int n, int n2) {
        if (stringBuilder == null) {
            return false;
        }
        return this.substitute(logEvent, stringBuilder, n, n2);
    }

    protected boolean substitute(LogEvent logEvent, StringBuilder stringBuilder, int n, int n2) {
        return this.substitute(logEvent, stringBuilder, n, n2, null) > 0;
    }

    private int substitute(LogEvent logEvent, StringBuilder stringBuilder, int n, int n2, List<String> list) {
        StrMatcher strMatcher = this.getVariablePrefixMatcher();
        StrMatcher strMatcher2 = this.getVariableSuffixMatcher();
        char c = this.getEscapeChar();
        boolean bl = list == null;
        boolean bl2 = false;
        int n3 = 0;
        char[] cArray = this.getChars(stringBuilder);
        int n4 = n + n2;
        int n5 = n;
        block0: while (n5 < n4) {
            int n6 = strMatcher.isMatch(cArray, n5, n, n4);
            if (n6 == 0) {
                ++n5;
                continue;
            }
            if (n5 > n && cArray[n5 - 1] == c) {
                stringBuilder.deleteCharAt(n5 - 1);
                cArray = this.getChars(stringBuilder);
                --n3;
                bl2 = true;
                --n4;
                continue;
            }
            int n7 = n5;
            n5 += n6;
            int n8 = 0;
            int n9 = 0;
            while (n5 < n4) {
                if (this.isEnableSubstitutionInVariables() && (n8 = strMatcher.isMatch(cArray, n5, n, n4)) != 0) {
                    ++n9;
                    n5 += n8;
                    continue;
                }
                n8 = strMatcher2.isMatch(cArray, n5, n, n4);
                if (n8 == 0) {
                    ++n5;
                    continue;
                }
                if (n9 == 0) {
                    String string = new String(cArray, n7 + n6, n5 - n7 - n6);
                    if (this.isEnableSubstitutionInVariables()) {
                        StringBuilder stringBuilder2 = new StringBuilder(string);
                        this.substitute(logEvent, stringBuilder2, 0, stringBuilder2.length());
                        string = stringBuilder2.toString();
                    }
                    int n10 = n5 += n8;
                    if (list == null) {
                        list = new ArrayList<String>();
                        list.add(new String(cArray, n, n2));
                    }
                    this.checkCyclicSubstitution(string, list);
                    list.add(string);
                    String string2 = this.resolveVariable(logEvent, string, stringBuilder, n7, n10);
                    if (string2 != null) {
                        int n11 = string2.length();
                        stringBuilder.replace(n7, n10, string2);
                        bl2 = true;
                        int n12 = this.substitute(logEvent, stringBuilder, n7, n11, list);
                        n5 += (n12 += n11 - (n10 - n7));
                        n4 += n12;
                        n3 += n12;
                        cArray = this.getChars(stringBuilder);
                    }
                    list.remove(list.size() - 1);
                    continue block0;
                }
                --n9;
                n5 += n8;
            }
        }
        if (bl) {
            return bl2 ? 1 : 0;
        }
        return n3;
    }

    private void checkCyclicSubstitution(String string, List<String> list) {
        if (!list.contains(string)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("Infinite loop in property interpolation of ");
        stringBuilder.append(list.remove(0));
        stringBuilder.append(": ");
        this.appendWithSeparators(stringBuilder, list, "->");
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected String resolveVariable(LogEvent logEvent, String string, StringBuilder stringBuilder, int n, int n2) {
        StrLookup strLookup = this.getVariableResolver();
        if (strLookup == null) {
            return null;
        }
        return strLookup.lookup(logEvent, string);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public void setEscapeChar(char c) {
        this.escapeChar = c;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            throw new IllegalArgumentException("Variable prefix matcher must not be null!");
        }
        this.prefixMatcher = strMatcher;
        return this;
    }

    public StrSubstitutor setVariablePrefix(char c) {
        return this.setVariablePrefixMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setVariablePrefix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Variable prefix must not be null!");
        }
        return this.setVariablePrefixMatcher(StrMatcher.stringMatcher(string));
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            throw new IllegalArgumentException("Variable suffix matcher must not be null!");
        }
        this.suffixMatcher = strMatcher;
        return this;
    }

    public StrSubstitutor setVariableSuffix(char c) {
        return this.setVariableSuffixMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setVariableSuffix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Variable suffix must not be null!");
        }
        return this.setVariableSuffixMatcher(StrMatcher.stringMatcher(string));
    }

    public StrLookup getVariableResolver() {
        return this.variableResolver;
    }

    public void setVariableResolver(StrLookup strLookup) {
        this.variableResolver = strLookup;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public void setEnableSubstitutionInVariables(boolean bl) {
        this.enableSubstitutionInVariables = bl;
    }

    private char[] getChars(StringBuilder stringBuilder) {
        char[] cArray = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), cArray, 0);
        return cArray;
    }

    public void appendWithSeparators(StringBuilder stringBuilder, Iterable<?> iterable, String string) {
        if (iterable != null) {
            string = string == null ? "" : string;
            Iterator<?> iterator2 = iterable.iterator();
            while (iterator2.hasNext()) {
                stringBuilder.append(iterator2.next());
                if (!iterator2.hasNext()) continue;
                stringBuilder.append(string);
            }
        }
    }

    public String toString() {
        return "StrSubstitutor(" + this.variableResolver.toString() + ")";
    }
}

