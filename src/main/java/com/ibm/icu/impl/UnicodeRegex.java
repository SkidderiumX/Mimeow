/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.text.StringTransform;
import com.ibm.icu.text.SymbolTable;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.Freezable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class UnicodeRegex
implements Cloneable,
Freezable<UnicodeRegex>,
StringTransform {
    private SymbolTable symbolTable;
    private static UnicodeRegex STANDARD = new UnicodeRegex();
    private String bnfCommentString = "#";
    private String bnfVariableInfix = "=";
    private String bnfLineSeparator = "\n";
    private Appendable log = null;
    private Comparator<Object> LongestFirst = new Comparator<Object>(){

        @Override
        public int compare(Object object, Object object2) {
            int n;
            String string = object.toString();
            String string2 = object2.toString();
            int n2 = string.length();
            if (n2 != (n = string2.length())) {
                return n - n2;
            }
            return string.compareTo(string2);
        }
    };

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public UnicodeRegex setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public String transform(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        UnicodeSet unicodeSet = new UnicodeSet();
        ParsePosition parsePosition = new ParsePosition(0);
        int n = 0;
        int n2 = 0;
        while (true) {
            block13: {
                if (n2 >= string.length()) {
                    return stringBuilder.toString();
                }
                char c = string.charAt(n2);
                switch (n) {
                    case 0: {
                        if (c == '\\') {
                            if (UnicodeSet.resemblesPattern(string, n2)) {
                                n2 = this.processSet(string, n2, stringBuilder, unicodeSet, parsePosition);
                                break block13;
                            } else {
                                n = 1;
                                break;
                            }
                        }
                        if (c != '[' || !UnicodeSet.resemblesPattern(string, n2)) break;
                        n2 = this.processSet(string, n2, stringBuilder, unicodeSet, parsePosition);
                        break block13;
                    }
                    case 1: {
                        if (c == 'Q') {
                            n = 1;
                            break;
                        }
                        n = 0;
                        break;
                    }
                    case 2: {
                        if (c != '\\') break;
                        n = 3;
                        break;
                    }
                    case 3: {
                        if (c == 'E') {
                            n = 0;
                        }
                        n = 2;
                    }
                }
                stringBuilder.append(c);
            }
            ++n2;
        }
    }

    public static String fix(String string) {
        return STANDARD.transform(string);
    }

    public static Pattern compile(String string) {
        return Pattern.compile(STANDARD.transform(string));
    }

    public static Pattern compile(String string, int n) {
        return Pattern.compile(STANDARD.transform(string), n);
    }

    public String compileBnf(String string) {
        return this.compileBnf(Arrays.asList(string.split("\\r\\n?|\\n")));
    }

    public String compileBnf(List<String> list) {
        Map<String, String> map = this.getVariables(list);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(map.keySet());
        for (int i = 0; i < 2; ++i) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String string = entry.getKey();
                String string2 = entry.getValue();
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    String string3;
                    String string4 = entry2.getKey();
                    String string5 = entry2.getValue();
                    if (string.equals(string4) || (string3 = string5.replace(string, string2)).equals(string5)) continue;
                    linkedHashSet.remove(string);
                    map.put(string4, string3);
                    if (this.log == null) continue;
                    try {
                        this.log.append(string4 + "=" + string3 + ";");
                    }
                    catch (IOException iOException) {
                        throw (IllegalArgumentException)new IllegalArgumentException().initCause(iOException);
                    }
                }
            }
        }
        if (linkedHashSet.size() != 1) {
            throw new IllegalArgumentException("Not a single root: " + linkedHashSet);
        }
        return map.get(linkedHashSet.iterator().next());
    }

    public String getBnfCommentString() {
        return this.bnfCommentString;
    }

    public void setBnfCommentString(String string) {
        this.bnfCommentString = string;
    }

    public String getBnfVariableInfix() {
        return this.bnfVariableInfix;
    }

    public void setBnfVariableInfix(String string) {
        this.bnfVariableInfix = string;
    }

    public String getBnfLineSeparator() {
        return this.bnfLineSeparator;
    }

    public void setBnfLineSeparator(String string) {
        this.bnfLineSeparator = string;
    }

    public static List<String> appendLines(List<String> list, String string, String string2) throws IOException {
        return UnicodeRegex.appendLines(list, new FileInputStream(string), string2);
    }

    public static List<String> appendLines(List<String> list, InputStream inputStream2, String string) throws UnsupportedEncodingException, IOException {
        String string2;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, string == null ? "UTF-8" : string));
        while ((string2 = bufferedReader.readLine()) != null) {
            list.add(string2);
        }
        return list;
    }

    @Override
    public UnicodeRegex cloneAsThawed() {
        try {
            return (UnicodeRegex)this.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public UnicodeRegex freeze() {
        return this;
    }

    @Override
    public boolean isFrozen() {
        return true;
    }

    private int processSet(String string, int n, StringBuilder stringBuilder, UnicodeSet unicodeSet, ParsePosition parsePosition) {
        try {
            parsePosition.setIndex(n);
            UnicodeSet unicodeSet2 = unicodeSet.clear().applyPattern(string, parsePosition, this.symbolTable, 0);
            unicodeSet2.complement().complement();
            stringBuilder.append(unicodeSet2.toPattern(false));
            n = parsePosition.getIndex() - 1;
            return n;
        }
        catch (Exception exception) {
            throw (IllegalArgumentException)new IllegalArgumentException("Error in " + string).initCause(exception);
        }
    }

    private Map<String, String> getVariables(List<String> list) {
        TreeMap<Object, String> treeMap = new TreeMap<Object, String>(this.LongestFirst);
        String string = null;
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        for (String string2 : list) {
            int n2;
            String string3;
            String string4;
            int n3;
            ++n;
            if (string2.length() == 0) continue;
            if (string2.charAt(0) == '\ufeff') {
                string2 = string2.substring(1);
            }
            if (this.bnfCommentString != null && (n3 = string2.indexOf(this.bnfCommentString)) >= 0) {
                string2 = string2.substring(0, n3);
            }
            if ((string4 = string2.trim()).length() == 0 || (string3 = string2).trim().length() == 0) continue;
            boolean bl = string4.endsWith(";");
            if (bl) {
                string3 = string3.substring(0, string3.lastIndexOf(59));
            }
            if ((n2 = string3.indexOf(this.bnfVariableInfix)) >= 0) {
                if (string != null) {
                    throw new IllegalArgumentException("Missing ';' before " + n + ") " + string2);
                }
                string = string3.substring(0, n2).trim();
                if (treeMap.containsKey(string)) {
                    throw new IllegalArgumentException("Duplicate variable definition in " + string2);
                }
                stringBuffer.append(string3.substring(n2 + 1).trim());
            } else {
                if (string == null) {
                    throw new IllegalArgumentException("Missing '=' at " + n + ") " + string2);
                }
                stringBuffer.append(this.bnfLineSeparator).append(string3);
            }
            if (!bl) continue;
            treeMap.put(string, stringBuffer.toString());
            string = null;
            stringBuffer.setLength(0);
        }
        if (string != null) {
            throw new IllegalArgumentException("Missing ';' at end");
        }
        return treeMap;
    }
}

