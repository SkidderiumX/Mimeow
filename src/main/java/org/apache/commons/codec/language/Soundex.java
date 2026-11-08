/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.language.SoundexUtils;

public class Soundex
implements StringEncoder {
    public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
    private static final char[] US_ENGLISH_MAPPING = "01230120022455012623010202".toCharArray();
    public static final Soundex US_ENGLISH = new Soundex();
    @Deprecated
    private int maxLength = 4;
    private final char[] soundexMapping;

    public Soundex() {
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public Soundex(char[] cArray) {
        this.soundexMapping = new char[cArray.length];
        System.arraycopy(cArray, 0, this.soundexMapping, 0, cArray.length);
    }

    public Soundex(String string) {
        this.soundexMapping = string.toCharArray();
    }

    public int difference(String string, String string2) throws EncoderException {
        return SoundexUtils.difference(this, string, string2);
    }

    @Override
    public Object encode(Object object) throws EncoderException {
        if (!(object instanceof String)) {
            throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
        }
        return this.soundex((String)object);
    }

    @Override
    public String encode(String string) {
        return this.soundex(string);
    }

    private char getMappingCode(String string, int n) {
        char c;
        char c2;
        char c3;
        char c4 = this.map(string.charAt(n));
        if (!(n <= 1 || c4 == '0' || 'H' != (c3 = string.charAt(n - 1)) && 'W' != c3 || (c2 = this.map(c = string.charAt(n - 2))) != c4 && 'H' != c && 'W' != c)) {
            return '\u0000';
        }
        return c4;
    }

    @Deprecated
    public int getMaxLength() {
        return this.maxLength;
    }

    private char[] getSoundexMapping() {
        return this.soundexMapping;
    }

    private char map(char c) {
        int n = c - 65;
        if (n < 0 || n >= this.getSoundexMapping().length) {
            throw new IllegalArgumentException("The character is not mapped: " + c);
        }
        return this.getSoundexMapping()[n];
    }

    @Deprecated
    public void setMaxLength(int n) {
        this.maxLength = n;
    }

    public String soundex(String string) {
        if (string == null) {
            return null;
        }
        if ((string = SoundexUtils.clean(string)).length() == 0) {
            return string;
        }
        char[] cArray = new char[]{'0', '0', '0', '0'};
        int n = 1;
        int n2 = 1;
        cArray[0] = string.charAt(0);
        char c = this.getMappingCode(string, 0);
        while (n < string.length() && n2 < cArray.length) {
            char c2;
            if ((c2 = this.getMappingCode(string, n++)) == '\u0000') continue;
            if (c2 != '0' && c2 != c) {
                cArray[n2++] = c2;
            }
            c = c2;
        }
        return new String(cArray);
    }
}

