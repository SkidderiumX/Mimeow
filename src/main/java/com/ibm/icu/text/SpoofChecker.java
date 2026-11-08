/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.impl.Trie2Writable;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.IdentifierInfo;
import com.ibm.icu.text.Normalizer2;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ULocale;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SpoofChecker {
    public static final UnicodeSet INCLUSION = new UnicodeSet("[\\-.\\u00B7\\u05F3\\u05F4\\u0F0B\\u200C\\u200D\\u2019]");
    public static final UnicodeSet RECOMMENDED = new UnicodeSet("[[0-z\\u00C0-\\u017E\\u01A0\\u01A1\\u01AF\\u01B0\\u01CD-\\u01DC\\u01DE-\\u01E3\\u01E6-\\u01F5\\u01F8-\\u021B\\u021E\\u021F\\u0226-\\u0233\\u02BB\\u02BC\\u02EC\\u0300-\\u0304\\u0306-\\u030C\\u030F-\\u0311\\u0313\\u0314\\u031B\\u0323-\\u0328\\u032D\\u032E\\u0330\\u0331\\u0335\\u0338\\u0339\\u0342-\\u0345\\u037B-\\u03CE\\u03FC-\\u045F\\u048A-\\u0525\\u0531-\\u0586\\u05D0-\\u05F2\\u0621-\\u063F\\u0641-\\u0655\\u0660-\\u0669\\u0670-\\u068D\\u068F-\\u06D5\\u06E5\\u06E6\\u06EE-\\u06FF\\u0750-\\u07B1\\u0901-\\u0939\\u093C-\\u094D\\u0950\\u0960-\\u0972\\u0979-\\u0A4D\\u0A5C-\\u0A74\\u0A81-\\u0B43\\u0B47-\\u0B61\\u0B66-\\u0C56\\u0C60\\u0C61\\u0C66-\\u0CD6\\u0CE0-\\u0CEF\\u0D02-\\u0D28\\u0D2A-\\u0D39\\u0D3D-\\u0D43\\u0D46-\\u0D4D\\u0D57-\\u0D61\\u0D66-\\u0D8E\\u0D91-\\u0DA5\\u0DA7-\\u0DDE\\u0DF2\\u0E01-\\u0ED9\\u0F00\\u0F20-\\u0F8B\\u0F90-\\u109D\\u10D0-\\u10F0\\u10F7-\\u10FA\\u1200-\\u135A\\u135F\\u1380-\\u138F\\u1401-\\u167F\\u1780-\\u17A2\\u17A5-\\u17A7\\u17A9-\\u17B3\\u17B6-\\u17CA\\u17D2\\u17D7-\\u17DC\\u17E0-\\u17E9\\u1810-\\u18A8\\u18AA-\\u18F5\\u1E00-\\u1E99\\u1F00-\\u1FFC\\u2D30-\\u2D65\\u2D80-\\u2DDE\\u3005-\\u3007\\u3041-\\u31B7\\u3400-\\u9FCB\\uA000-\\uA48C\\uA67F\\uA717-\\uA71F\\uA788\\uAA60-\\uAA7B\\uAC00-\\uD7A3\\uFA0E-\\uFA29\\U00020000-\\U0002B734]-[[:Cn:][:nfkcqc=n:][:XIDC=n:]]]");
    public static final int SINGLE_SCRIPT_CONFUSABLE = 1;
    public static final int MIXED_SCRIPT_CONFUSABLE = 2;
    public static final int WHOLE_SCRIPT_CONFUSABLE = 4;
    public static final int ANY_CASE = 8;
    public static final int RESTRICTION_LEVEL = 16;
    public static final int SINGLE_SCRIPT = 16;
    public static final int INVISIBLE = 32;
    public static final int CHAR_LIMIT = 64;
    public static final int MIXED_NUMBERS = 128;
    public static final int ALL_CHECKS = -1;
    static final int MAGIC = 944111087;
    private IdentifierInfo fCachedIdentifierInfo = null;
    private int fMagic;
    private int fChecks;
    private SpoofData fSpoofData;
    private Set<ULocale> fAllowedLocales;
    private UnicodeSet fAllowedCharsSet;
    private RestrictionLevel fRestrictionLevel;
    private static Normalizer2 nfdNormalizer = Normalizer2.getNFDInstance();
    static final int SL_TABLE_FLAG = 0x1000000;
    static final int SA_TABLE_FLAG = 0x2000000;
    static final int ML_TABLE_FLAG = 0x4000000;
    static final int MA_TABLE_FLAG = 0x8000000;
    static final int KEY_MULTIPLE_VALUES = 0x10000000;
    static final int KEY_LENGTH_SHIFT = 29;

    private SpoofChecker() {
    }

    public RestrictionLevel getRestrictionLevel() {
        return this.fRestrictionLevel;
    }

    public int getChecks() {
        return this.fChecks;
    }

    public Set<ULocale> getAllowedLocales() {
        return this.fAllowedLocales;
    }

    public UnicodeSet getAllowedChars() {
        return this.fAllowedCharsSet;
    }

    public boolean failsChecks(String string, CheckResult checkResult) {
        int n;
        Object object;
        int n2 = string.length();
        int n3 = 0;
        if (checkResult != null) {
            checkResult.position = 0;
            checkResult.numerics = null;
            checkResult.restrictionLevel = null;
        }
        IdentifierInfo identifierInfo = null;
        if (0 != (this.fChecks & 0x90)) {
            identifierInfo = this.getIdentifierInfo().setIdentifier(string).setIdentifierProfile(this.fAllowedCharsSet);
        }
        if (0 != (this.fChecks & 0x10)) {
            object = identifierInfo.getRestrictionLevel();
            if (object.compareTo(this.fRestrictionLevel) > 0) {
                n3 |= 0x10;
            }
            if (checkResult != null) {
                checkResult.restrictionLevel = object;
            }
        }
        if (0 != (this.fChecks & 0x80)) {
            object = identifierInfo.getNumerics();
            if (((UnicodeSet)object).size() > 1) {
                n3 |= 0x80;
            }
            if (checkResult != null) {
                checkResult.numerics = object;
            }
        }
        if (0 != (this.fChecks & 0x40)) {
            int n4 = 0;
            while (n4 < n2) {
                n = Character.codePointAt(string, n4);
                n4 = Character.offsetByCodePoints(string, n4, 1);
                if (this.fAllowedCharsSet.contains(n)) continue;
                n3 |= 0x40;
                break;
            }
        }
        if (0 != (this.fChecks & 0x26)) {
            int n5;
            String string2 = nfdNormalizer.normalize(string);
            if (0 != (this.fChecks & 0x20)) {
                n5 = 0;
                boolean bl = false;
                UnicodeSet unicodeSet = new UnicodeSet();
                n = 0;
                while (n < n2) {
                    int n6 = Character.codePointAt(string2, n);
                    n = Character.offsetByCodePoints(string2, n, 1);
                    if (Character.getType(n6) != 6) {
                        n5 = 0;
                        if (!bl) continue;
                        unicodeSet.clear();
                        bl = false;
                        continue;
                    }
                    if (n5 == 0) {
                        n5 = n6;
                        continue;
                    }
                    if (!bl) {
                        unicodeSet.add(n5);
                        bl = true;
                    }
                    if (unicodeSet.contains(n6)) {
                        n3 |= 0x20;
                        break;
                    }
                    unicodeSet.add(n6);
                }
            }
            if (0 != (this.fChecks & 6)) {
                if (identifierInfo == null) {
                    identifierInfo = this.getIdentifierInfo();
                    identifierInfo.setIdentifier(string);
                }
                n = identifierInfo.getScriptCount();
                ScriptSet scriptSet = new ScriptSet();
                this.wholeScriptCheck(string2, scriptSet);
                n5 = scriptSet.countMembers();
                if (0 != (this.fChecks & 4) && n5 >= 2 && n == 1) {
                    n3 |= 4;
                }
                if (0 != (this.fChecks & 2) && n5 >= 1 && n > 1) {
                    n3 |= 2;
                }
            }
        }
        if (checkResult != null) {
            checkResult.checks = n3;
        }
        this.releaseIdentifierInfo(identifierInfo);
        return 0 != n3;
    }

    public boolean failsChecks(String string) {
        return this.failsChecks(string, null);
    }

    public int areConfusable(String string, String string2) {
        String string3;
        boolean bl;
        String string4;
        String string5;
        if ((this.fChecks & 7) == 0) {
            throw new IllegalArgumentException("No confusable checks are enabled.");
        }
        int n = this.fChecks & 8;
        int n2 = 0;
        IdentifierInfo identifierInfo = this.getIdentifierInfo();
        identifierInfo.setIdentifier(string);
        int n3 = identifierInfo.getScriptCount();
        identifierInfo.setIdentifier(string2);
        int n4 = identifierInfo.getScriptCount();
        this.releaseIdentifierInfo(identifierInfo);
        if (0 != (this.fChecks & 1) && n3 <= 1 && n4 <= 1 && (string5 = this.getSkeleton(n |= 1, string)).equals(string4 = this.getSkeleton(n, string2))) {
            n2 |= 1;
        }
        if (n2 & true) {
            return n2;
        }
        boolean bl2 = bl = n3 <= 1 && n4 <= 1 && 0 != (this.fChecks & 4);
        if ((0 != (this.fChecks & 2) || bl) && (string4 = this.getSkeleton(n &= 0xFFFFFFFE, string)).equals(string3 = this.getSkeleton(n, string2))) {
            n2 |= 2;
            if (bl) {
                n2 |= 4;
            }
        }
        return n2;
    }

    public String getSkeleton(int n, String string) {
        int n2;
        int n3 = 0;
        switch (n) {
            case 0: {
                n3 = 0x4000000;
                break;
            }
            case 1: {
                n3 = 0x1000000;
                break;
            }
            case 8: {
                n3 = 0x8000000;
                break;
            }
            case 9: {
                n3 = 0x2000000;
                break;
            }
            default: {
                throw new IllegalArgumentException("SpoofChecker.getSkeleton(), bad type value.");
            }
        }
        String string2 = nfdNormalizer.normalize(string);
        int n4 = string2.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n4; i += Character.charCount(n2)) {
            n2 = Character.codePointAt(string2, i);
            this.confusableLookup(n2, n3, stringBuilder);
        }
        String string3 = stringBuilder.toString();
        string3 = nfdNormalizer.normalize(string3);
        return string3;
    }

    private void confusableLookup(int n, int n2, StringBuilder stringBuilder) {
        int n3;
        int n4;
        int n5 = 0;
        int n6 = 0;
        int n7 = this.fSpoofData.fRawData.fCFUKeysSize;
        boolean bl = false;
        do {
            int n8;
            if (n == (n8 = this.fSpoofData.fCFUKeys[n6 = n5 + (n4 = (n7 - n5) / 2)] & 0x1FFFFF)) {
                bl = true;
                break;
            }
            if (n < n8) {
                n7 = n6;
                continue;
            }
            n5 = n6 + 1;
        } while (n5 < n7);
        if (!bl) {
            stringBuilder.appendCodePoint(n);
            return;
        }
        n4 = 0;
        int n9 = this.fSpoofData.fCFUKeys[n6] & 0xFF000000;
        if ((n9 & n2) == 0) {
            if (0 != (n9 & 0x10000000)) {
                n3 = n6 - 1;
                while ((this.fSpoofData.fCFUKeys[n3] & 0xFFFFFF) == n) {
                    n9 = this.fSpoofData.fCFUKeys[n3] & 0xFF000000;
                    if (0 != (n9 & n2)) {
                        n6 = n3;
                        n4 = 1;
                        break;
                    }
                    --n3;
                }
                if (n4 == 0) {
                    n3 = n6 + 1;
                    while ((this.fSpoofData.fCFUKeys[n3] & 0xFFFFFF) == n) {
                        n9 = this.fSpoofData.fCFUKeys[n3] & 0xFF000000;
                        if (0 != (n9 & n2)) {
                            n6 = n3;
                            n4 = 1;
                            break;
                        }
                        ++n3;
                    }
                }
            }
            if (n4 == 0) {
                stringBuilder.appendCodePoint(n);
                return;
            }
        }
        n3 = SpoofChecker.getKeyLength(n9) + 1;
        int n10 = n6;
        short s = this.fSpoofData.fCFUValues[n10];
        if (n3 == 1) {
            stringBuilder.append((char)s);
            return;
        }
        if (n3 == 4) {
            int n11;
            int n12 = this.fSpoofData.fRawData.fCFUStringLengthsSize;
            for (n11 = 0; n11 < n12; ++n11) {
                if (this.fSpoofData.fCFUStringLengths[n11].fLastString < s) continue;
                n3 = this.fSpoofData.fCFUStringLengths[n11].fStrLength;
                break;
            }
            assert (n11 < n12);
        }
        assert (s + n3 <= this.fSpoofData.fRawData.fCFUStringTableLen);
        stringBuilder.append(this.fSpoofData.fCFUStrings, (int)s, n3);
    }

    void wholeScriptCheck(CharSequence charSequence, ScriptSet scriptSet) {
        int n = 0;
        Trie2 trie2 = 0 != (this.fChecks & 8) ? this.fSpoofData.fAnyCaseTrie : this.fSpoofData.fLowerCaseTrie;
        scriptSet.setAll();
        while (n < charSequence.length()) {
            int n2 = Character.codePointAt(charSequence, n);
            n = Character.offsetByCodePoints(charSequence, n, 1);
            int n3 = trie2.get(n2);
            if (n3 == 0) {
                int n4 = UScript.getScript(n2);
                assert (n4 > 1);
                scriptSet.intersect(n4);
                continue;
            }
            if (n3 == 1) continue;
            scriptSet.intersect(this.fSpoofData.fScriptSets[n3]);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private IdentifierInfo getIdentifierInfo() {
        IdentifierInfo identifierInfo = null;
        SpoofChecker spoofChecker = this;
        synchronized (spoofChecker) {
            identifierInfo = this.fCachedIdentifierInfo;
            this.fCachedIdentifierInfo = null;
        }
        if (identifierInfo == null) {
            identifierInfo = new IdentifierInfo();
        }
        return identifierInfo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void releaseIdentifierInfo(IdentifierInfo identifierInfo) {
        if (identifierInfo != null) {
            SpoofChecker spoofChecker = this;
            synchronized (spoofChecker) {
                if (this.fCachedIdentifierInfo == null) {
                    this.fCachedIdentifierInfo = identifierInfo;
                }
            }
        }
    }

    static final int getKeyLength(int n) {
        return n >> 29 & 3;
    }

    private static class ScriptSet {
        private int[] bits = new int[6];

        public ScriptSet() {
        }

        public ScriptSet(DataInputStream dataInputStream) throws IOException {
            for (int i = 0; i < this.bits.length; ++i) {
                this.bits[i] = dataInputStream.readInt();
            }
        }

        public void output(DataOutputStream dataOutputStream) throws IOException {
            for (int i = 0; i < this.bits.length; ++i) {
                dataOutputStream.writeInt(this.bits[i]);
            }
        }

        public boolean equals(ScriptSet scriptSet) {
            for (int i = 0; i < this.bits.length; ++i) {
                if (this.bits[i] == scriptSet.bits[i]) continue;
                return false;
            }
            return true;
        }

        public void Union(int n) {
            int n2 = n / 32;
            int n3 = 1 << (n & 0x1F);
            assert (n2 < this.bits.length * 4 * 4);
            int n4 = n2;
            this.bits[n4] = this.bits[n4] | n3;
        }

        public void Union(ScriptSet scriptSet) {
            for (int i = 0; i < this.bits.length; ++i) {
                int n = i;
                this.bits[n] = this.bits[n] | scriptSet.bits[i];
            }
        }

        public void intersect(ScriptSet scriptSet) {
            for (int i = 0; i < this.bits.length; ++i) {
                int n = i;
                this.bits[n] = this.bits[n] & scriptSet.bits[i];
            }
        }

        public void intersect(int n) {
            int n2;
            int n3 = n / 32;
            int n4 = 1 << (n & 0x1F);
            assert (n3 < this.bits.length * 4 * 4);
            for (n2 = 0; n2 < n3; ++n2) {
                this.bits[n2] = 0;
            }
            int n5 = n3;
            this.bits[n5] = this.bits[n5] & n4;
            for (n2 = n3 + 1; n2 < this.bits.length; ++n2) {
                this.bits[n2] = 0;
            }
        }

        public void setAll() {
            for (int i = 0; i < this.bits.length; ++i) {
                this.bits[i] = -1;
            }
        }

        public void resetAll() {
            for (int i = 0; i < this.bits.length; ++i) {
                this.bits[i] = 0;
            }
        }

        public int countMembers() {
            int n = 0;
            for (int i = 0; i < this.bits.length; ++i) {
                for (int j = this.bits[i]; j != 0; j &= j - 1) {
                    ++n;
                }
            }
            return n;
        }
    }

    private static class SpoofData {
        SpoofDataHeader fRawData;
        int[] fCFUKeys;
        short[] fCFUValues;
        SpoofStringLengthsElement[] fCFUStringLengths;
        char[] fCFUStrings;
        Trie2 fAnyCaseTrie;
        Trie2 fLowerCaseTrie;
        ScriptSet[] fScriptSets;

        public static SpoofData getDefault() throws IOException {
            InputStream inputStream2 = ICUData.getRequiredStream("data/icudt51b/confusables.cfu");
            SpoofData spoofData = new SpoofData(inputStream2);
            return spoofData;
        }

        public SpoofData() {
            this.fRawData = new SpoofDataHeader();
            this.fRawData.fMagic = 944111087;
            this.fRawData.fFormatVersion[0] = 1;
            this.fRawData.fFormatVersion[1] = 0;
            this.fRawData.fFormatVersion[2] = 0;
            this.fRawData.fFormatVersion[3] = 0;
        }

        public SpoofData(InputStream inputStream2) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream2));
            dataInputStream.skip(128L);
            assert (dataInputStream.markSupported());
            dataInputStream.mark(Integer.MAX_VALUE);
            this.fRawData = new SpoofDataHeader(dataInputStream);
            this.initPtrs(dataInputStream);
        }

        static boolean validateDataVersion(SpoofDataHeader spoofDataHeader) {
            return spoofDataHeader != null && spoofDataHeader.fMagic == 944111087 && spoofDataHeader.fFormatVersion[0] <= 1 && spoofDataHeader.fFormatVersion[1] <= 0;
        }

        void initPtrs(DataInputStream dataInputStream) throws IOException {
            int n;
            this.fCFUKeys = null;
            this.fCFUValues = null;
            this.fCFUStringLengths = null;
            this.fCFUStrings = null;
            dataInputStream.reset();
            dataInputStream.skip(this.fRawData.fCFUKeys);
            if (this.fRawData.fCFUKeys != 0) {
                this.fCFUKeys = new int[this.fRawData.fCFUKeysSize];
                for (n = 0; n < this.fRawData.fCFUKeysSize; ++n) {
                    this.fCFUKeys[n] = dataInputStream.readInt();
                }
            }
            dataInputStream.reset();
            dataInputStream.skip(this.fRawData.fCFUStringIndex);
            if (this.fRawData.fCFUStringIndex != 0) {
                this.fCFUValues = new short[this.fRawData.fCFUStringIndexSize];
                for (n = 0; n < this.fRawData.fCFUStringIndexSize; ++n) {
                    this.fCFUValues[n] = dataInputStream.readShort();
                }
            }
            dataInputStream.reset();
            dataInputStream.skip(this.fRawData.fCFUStringTable);
            if (this.fRawData.fCFUStringTable != 0) {
                this.fCFUStrings = new char[this.fRawData.fCFUStringTableLen];
                for (n = 0; n < this.fRawData.fCFUStringTableLen; ++n) {
                    this.fCFUStrings[n] = dataInputStream.readChar();
                }
            }
            dataInputStream.reset();
            dataInputStream.skip(this.fRawData.fCFUStringLengths);
            if (this.fRawData.fCFUStringLengths != 0) {
                this.fCFUStringLengths = new SpoofStringLengthsElement[this.fRawData.fCFUStringLengthsSize];
                for (n = 0; n < this.fRawData.fCFUStringLengthsSize; ++n) {
                    this.fCFUStringLengths[n] = new SpoofStringLengthsElement();
                    this.fCFUStringLengths[n].fLastString = dataInputStream.readShort();
                    this.fCFUStringLengths[n].fStrLength = dataInputStream.readShort();
                }
            }
            dataInputStream.reset();
            dataInputStream.skip(this.fRawData.fAnyCaseTrie);
            if (this.fAnyCaseTrie == null && this.fRawData.fAnyCaseTrie != 0) {
                this.fAnyCaseTrie = Trie2.createFromSerialized(dataInputStream);
            }
            dataInputStream.reset();
            dataInputStream.skip(this.fRawData.fLowerCaseTrie);
            if (this.fLowerCaseTrie == null && this.fRawData.fLowerCaseTrie != 0) {
                this.fLowerCaseTrie = Trie2.createFromSerialized(dataInputStream);
            }
            dataInputStream.reset();
            dataInputStream.skip(this.fRawData.fScriptSets);
            if (this.fRawData.fScriptSets != 0) {
                this.fScriptSets = new ScriptSet[this.fRawData.fScriptSetsLength];
                for (n = 0; n < this.fRawData.fScriptSetsLength; ++n) {
                    this.fScriptSets[n] = new ScriptSet(dataInputStream);
                }
            }
        }

        private static class SpoofStringLengthsElement {
            short fLastString;
            short fStrLength;

            private SpoofStringLengthsElement() {
            }
        }
    }

    private static class SpoofDataHeader {
        int fMagic;
        byte[] fFormatVersion = new byte[4];
        int fLength;
        int fCFUKeys;
        int fCFUKeysSize;
        int fCFUStringIndex;
        int fCFUStringIndexSize;
        int fCFUStringTable;
        int fCFUStringTableLen;
        int fCFUStringLengths;
        int fCFUStringLengthsSize;
        int fAnyCaseTrie;
        int fAnyCaseTrieLength;
        int fLowerCaseTrie;
        int fLowerCaseTrieLength;
        int fScriptSets;
        int fScriptSetsLength;
        int[] unused = new int[15];

        public SpoofDataHeader() {
        }

        public SpoofDataHeader(DataInputStream dataInputStream) throws IOException {
            int n;
            this.fMagic = dataInputStream.readInt();
            for (n = 0; n < this.fFormatVersion.length; ++n) {
                this.fFormatVersion[n] = dataInputStream.readByte();
            }
            this.fLength = dataInputStream.readInt();
            this.fCFUKeys = dataInputStream.readInt();
            this.fCFUKeysSize = dataInputStream.readInt();
            this.fCFUStringIndex = dataInputStream.readInt();
            this.fCFUStringIndexSize = dataInputStream.readInt();
            this.fCFUStringTable = dataInputStream.readInt();
            this.fCFUStringTableLen = dataInputStream.readInt();
            this.fCFUStringLengths = dataInputStream.readInt();
            this.fCFUStringLengthsSize = dataInputStream.readInt();
            this.fAnyCaseTrie = dataInputStream.readInt();
            this.fAnyCaseTrieLength = dataInputStream.readInt();
            this.fLowerCaseTrie = dataInputStream.readInt();
            this.fLowerCaseTrieLength = dataInputStream.readInt();
            this.fScriptSets = dataInputStream.readInt();
            this.fScriptSetsLength = dataInputStream.readInt();
            for (n = 0; n < this.unused.length; ++n) {
                this.unused[n] = dataInputStream.readInt();
            }
        }

        public void output(DataOutputStream dataOutputStream) throws IOException {
            int n;
            dataOutputStream.writeInt(this.fMagic);
            for (n = 0; n < this.fFormatVersion.length; ++n) {
                dataOutputStream.writeByte(this.fFormatVersion[n]);
            }
            dataOutputStream.writeInt(this.fLength);
            dataOutputStream.writeInt(this.fCFUKeys);
            dataOutputStream.writeInt(this.fCFUKeysSize);
            dataOutputStream.writeInt(this.fCFUStringIndex);
            dataOutputStream.writeInt(this.fCFUStringIndexSize);
            dataOutputStream.writeInt(this.fCFUStringTable);
            dataOutputStream.writeInt(this.fCFUStringTableLen);
            dataOutputStream.writeInt(this.fCFUStringLengths);
            dataOutputStream.writeInt(this.fCFUStringLengthsSize);
            dataOutputStream.writeInt(this.fAnyCaseTrie);
            dataOutputStream.writeInt(this.fAnyCaseTrieLength);
            dataOutputStream.writeInt(this.fLowerCaseTrie);
            dataOutputStream.writeInt(this.fLowerCaseTrieLength);
            dataOutputStream.writeInt(this.fScriptSets);
            dataOutputStream.writeInt(this.fScriptSetsLength);
            for (n = 0; n < this.unused.length; ++n) {
                dataOutputStream.writeInt(this.unused[n]);
            }
        }
    }

    public static class CheckResult {
        public int checks = 0;
        public int position = 0;
        public UnicodeSet numerics;
        public RestrictionLevel restrictionLevel;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Builder {
        int fMagic;
        int fChecks;
        SpoofData fSpoofData;
        final UnicodeSet fAllowedCharsSet = new UnicodeSet(0, 0x10FFFF);
        final Set<ULocale> fAllowedLocales = new LinkedHashSet<ULocale>();
        private RestrictionLevel fRestrictionLevel;

        public Builder() {
            this.fMagic = 944111087;
            this.fChecks = -1;
            this.fSpoofData = null;
            this.fRestrictionLevel = RestrictionLevel.HIGHLY_RESTRICTIVE;
        }

        public Builder(SpoofChecker spoofChecker) {
            this.fMagic = spoofChecker.fMagic;
            this.fChecks = spoofChecker.fChecks;
            this.fSpoofData = null;
            this.fAllowedCharsSet.set(spoofChecker.fAllowedCharsSet);
            this.fAllowedLocales.addAll(spoofChecker.fAllowedLocales);
            this.fRestrictionLevel = spoofChecker.fRestrictionLevel;
        }

        public SpoofChecker build() {
            if (this.fSpoofData == null) {
                try {
                    this.fSpoofData = SpoofData.getDefault();
                }
                catch (IOException iOException) {
                    return null;
                }
            }
            if (!SpoofData.validateDataVersion(this.fSpoofData.fRawData)) {
                return null;
            }
            SpoofChecker spoofChecker = new SpoofChecker();
            spoofChecker.fMagic = this.fMagic;
            spoofChecker.fChecks = this.fChecks;
            spoofChecker.fSpoofData = this.fSpoofData;
            spoofChecker.fAllowedCharsSet = (UnicodeSet)this.fAllowedCharsSet.clone();
            spoofChecker.fAllowedCharsSet.freeze();
            spoofChecker.fAllowedLocales = this.fAllowedLocales;
            spoofChecker.fRestrictionLevel = this.fRestrictionLevel;
            return spoofChecker;
        }

        public Builder setData(Reader reader, Reader reader2) throws ParseException, IOException {
            this.fSpoofData = new SpoofData();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            ConfusabledataBuilder.buildConfusableData(this.fSpoofData, reader);
            WSConfusableDataBuilder.buildWSConfusableData(this.fSpoofData, dataOutputStream, reader2);
            return this;
        }

        public Builder setChecks(int n) {
            if (0 != (n & 0)) {
                throw new IllegalArgumentException("Bad Spoof Checks value.");
            }
            this.fChecks = n & 0xFFFFFFFF;
            return this;
        }

        public Builder setAllowedLocales(Set<ULocale> set) {
            this.fAllowedCharsSet.clear();
            for (ULocale uLocale : set) {
                this.addScriptChars(uLocale, this.fAllowedCharsSet);
            }
            this.fAllowedLocales.clear();
            if (set.size() == 0) {
                this.fAllowedCharsSet.add(0, 0x10FFFF);
                this.fChecks &= 0xFFFFFFBF;
                return this;
            }
            UnicodeSet unicodeSet = new UnicodeSet();
            unicodeSet.applyIntPropertyValue(4106, 0);
            this.fAllowedCharsSet.addAll(unicodeSet);
            unicodeSet.applyIntPropertyValue(4106, 1);
            this.fAllowedCharsSet.addAll(unicodeSet);
            this.fAllowedLocales.addAll(set);
            this.fChecks |= 0x40;
            return this;
        }

        private void addScriptChars(ULocale uLocale, UnicodeSet unicodeSet) {
            int[] nArray = UScript.getCode(uLocale);
            UnicodeSet unicodeSet2 = new UnicodeSet();
            for (int i = 0; i < nArray.length; ++i) {
                unicodeSet2.applyIntPropertyValue(4106, nArray[i]);
                unicodeSet.addAll(unicodeSet2);
            }
        }

        public Builder setAllowedChars(UnicodeSet unicodeSet) {
            this.fAllowedCharsSet.set(unicodeSet);
            this.fAllowedLocales.clear();
            this.fChecks |= 0x40;
            return this;
        }

        public Builder setRestrictionLevel(RestrictionLevel restrictionLevel) {
            this.fRestrictionLevel = restrictionLevel;
            this.fChecks |= 0x10;
            return this;
        }

        /*
         * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
         */
        private static class ConfusabledataBuilder {
            private SpoofData fSpoofData;
            private ByteArrayOutputStream bos;
            private DataOutputStream os;
            private Hashtable<Integer, SPUString> fSLTable;
            private Hashtable<Integer, SPUString> fSATable;
            private Hashtable<Integer, SPUString> fMLTable;
            private Hashtable<Integer, SPUString> fMATable;
            private UnicodeSet fKeySet;
            private StringBuffer fStringTable;
            private Vector<Integer> fKeyVec;
            private Vector<Integer> fValueVec;
            private Vector<Integer> fStringLengthsTable;
            private SPUStringPool stringPool;
            private Pattern fParseLine;
            private Pattern fParseHexNum;
            private int fLineNum;

            ConfusabledataBuilder(SpoofData spoofData, ByteArrayOutputStream byteArrayOutputStream) {
                this.bos = byteArrayOutputStream;
                this.os = new DataOutputStream(byteArrayOutputStream);
                this.fSpoofData = spoofData;
                this.fSLTable = new Hashtable();
                this.fSATable = new Hashtable();
                this.fMLTable = new Hashtable();
                this.fMATable = new Hashtable();
                this.fKeySet = new UnicodeSet();
                this.fKeyVec = new Vector();
                this.fValueVec = new Vector();
                this.stringPool = new SPUStringPool();
            }

            void build(Reader reader) throws ParseException, IOException {
                int n;
                Object object;
                int n2;
                StringBuffer stringBuffer = new StringBuffer();
                WSConfusableDataBuilder.readWholeFileToString(reader, stringBuffer);
                this.fParseLine = Pattern.compile("(?m)^[ \\t]*([0-9A-Fa-f]+)[ \\t]+;[ \\t]*([0-9A-Fa-f]+(?:[ \\t]+[0-9A-Fa-f]+)*)[ \\t]*;\\s*(?:(SL)|(SA)|(ML)|(MA))[ \\t]*(?:#.*?)?$|^([ \\t]*(?:#.*?)?)$|^(.*?)$");
                this.fParseHexNum = Pattern.compile("\\s*([0-9A-F]+)");
                if (stringBuffer.charAt(0) == '\ufeff') {
                    stringBuffer.setCharAt(0, ' ');
                }
                Matcher matcher = this.fParseLine.matcher(stringBuffer);
                while (matcher.find()) {
                    ++this.fLineNum;
                    if (matcher.start(7) >= 0) continue;
                    if (matcher.start(8) >= 0) {
                        throw new ParseException("Confusables, line " + this.fLineNum + ": Unrecognized Line: " + matcher.group(8), matcher.start(8));
                    }
                    n2 = Integer.parseInt(matcher.group(1), 16);
                    if (n2 > 0x10FFFF) {
                        throw new ParseException("Confusables, line " + this.fLineNum + ": Bad code point: " + matcher.group(1), matcher.start(1));
                    }
                    Matcher matcher2 = this.fParseHexNum.matcher(matcher.group(2));
                    StringBuilder stringBuilder = new StringBuilder();
                    while (matcher2.find()) {
                        int n3 = Integer.parseInt(matcher2.group(1), 16);
                        if (n2 > 0x10FFFF) {
                            throw new ParseException("Confusables, line " + this.fLineNum + ": Bad code point: " + Integer.toString(n3, 16), matcher.start(2));
                        }
                        stringBuilder.appendCodePoint(n3);
                    }
                    assert (stringBuilder.length() >= 1);
                    SPUString sPUString = this.stringPool.addString(stringBuilder.toString());
                    Object object2 = matcher.start(3) >= 0 ? this.fSLTable : (matcher.start(4) >= 0 ? this.fSATable : (matcher.start(5) >= 0 ? this.fMLTable : (object = matcher.start(6) >= 0 ? this.fMATable : null)));
                    assert (object != null);
                    ((Hashtable)object).put(n2, sPUString);
                    this.fKeySet.add(n2);
                }
                this.stringPool.sort();
                this.fStringTable = new StringBuffer();
                this.fStringLengthsTable = new Vector();
                n2 = 0;
                int n4 = 0;
                int n5 = this.stringPool.size();
                for (int i = 0; i < n5; ++i) {
                    object = this.stringPool.getByIndex(i);
                    n = ((SPUString)object).fStr.length();
                    int n6 = this.fStringTable.length();
                    assert (n >= n2);
                    if (n == 1) {
                        ((SPUString)object).fStrTableIndex = ((SPUString)object).fStr.charAt(0);
                    } else {
                        if (n > n2 && n2 >= 4) {
                            this.fStringLengthsTable.addElement(n4);
                            this.fStringLengthsTable.addElement(n2);
                        }
                        ((SPUString)object).fStrTableIndex = n6;
                        this.fStringTable.append(((SPUString)object).fStr);
                    }
                    n2 = n;
                    n4 = n6;
                }
                if (n2 >= 4) {
                    this.fStringLengthsTable.addElement(n4);
                    this.fStringLengthsTable.addElement(n2);
                }
                for (int i = 0; i < this.fKeySet.getRangeCount(); ++i) {
                    for (n = this.fKeySet.getRangeStart(i); n <= this.fKeySet.getRangeEnd(i); ++n) {
                        this.addKeyEntry(n, this.fSLTable, 0x1000000);
                        this.addKeyEntry(n, this.fSATable, 0x2000000);
                        this.addKeyEntry(n, this.fMLTable, 0x4000000);
                        this.addKeyEntry(n, this.fMATable, 0x8000000);
                    }
                }
                this.outputData();
            }

            void addKeyEntry(int n, Hashtable<Integer, SPUString> hashtable, int n2) {
                int n3;
                int n4;
                SPUString sPUString = hashtable.get(n);
                if (sPUString == null) {
                    return;
                }
                boolean bl = false;
                for (int i = this.fKeyVec.size() - 1; i >= 0 && ((n4 = this.fKeyVec.elementAt(i).intValue()) & 0xFFFFFF) == n; --i) {
                    String string = this.getMapping(i);
                    if (string.equals(sPUString.fStr)) {
                        this.fKeyVec.setElementAt(n4 |= n2, i);
                        return;
                    }
                    bl = true;
                }
                n4 = n | n2;
                if (bl) {
                    n4 |= 0x10000000;
                }
                if ((n3 = sPUString.fStr.length() - 1) > 3) {
                    n3 = 3;
                }
                int n5 = sPUString.fStrTableIndex;
                this.fKeyVec.addElement(n4 |= n3 << 29);
                this.fValueVec.addElement(n5);
                if (bl) {
                    int n6 = this.fKeyVec.size() - 2;
                    int n7 = this.fKeyVec.elementAt(n6);
                    this.fKeyVec.setElementAt(n7 |= 0x10000000, n6);
                }
            }

            String getMapping(int n) {
                int n2 = this.fKeyVec.elementAt(n);
                int n3 = this.fValueVec.elementAt(n);
                int n4 = SpoofChecker.getKeyLength(n2);
                switch (n4) {
                    case 0: {
                        char[] cArray = new char[]{(char)n3};
                        return new String(cArray);
                    }
                    case 1: 
                    case 2: {
                        return this.fStringTable.substring(n3, n3 + n4 + 1);
                    }
                    case 3: {
                        n4 = 0;
                        for (int i = 0; i < this.fStringLengthsTable.size(); i += 2) {
                            int n5 = this.fStringLengthsTable.elementAt(i);
                            if (n3 > n5) continue;
                            n4 = this.fStringLengthsTable.elementAt(i + 1);
                            break;
                        }
                        assert (n4 >= 3);
                        return this.fStringTable.substring(n3, n3 + n4);
                    }
                }
                assert (false);
                return "";
            }

            void outputData() throws IOException {
                int n;
                int n2;
                int n3;
                SpoofDataHeader spoofDataHeader = this.fSpoofData.fRawData;
                int n4 = this.fKeyVec.size();
                int n5 = 0;
                spoofDataHeader.output(this.os);
                spoofDataHeader.fCFUKeys = this.os.size();
                assert (spoofDataHeader.fCFUKeys == 128);
                spoofDataHeader.fCFUKeysSize = n4;
                for (n3 = 0; n3 < n4; ++n3) {
                    n2 = this.fKeyVec.elementAt(n3);
                    assert ((n2 & 0xFFFFFF) >= (n5 & 0xFFFFFF));
                    assert ((n2 & 0xFF000000) != 0);
                    this.os.writeInt(n2);
                    n5 = n2;
                }
                n2 = this.fValueVec.size();
                assert (n4 == n2);
                spoofDataHeader.fCFUStringIndex = this.os.size();
                spoofDataHeader.fCFUStringIndexSize = n2;
                for (n3 = 0; n3 < n2; ++n3) {
                    n = this.fValueVec.elementAt(n3);
                    assert (n < 65535);
                    this.os.writeShort((short)n);
                }
                n = this.fStringTable.length();
                String string = this.fStringTable.toString();
                spoofDataHeader.fCFUStringTable = this.os.size();
                spoofDataHeader.fCFUStringTableLen = n;
                for (n3 = 0; n3 < n; ++n3) {
                    this.os.writeChar(string.charAt(n3));
                }
                int n6 = this.fStringLengthsTable.size();
                int n7 = 0;
                spoofDataHeader.fCFUStringLengthsSize = n6 / 2;
                spoofDataHeader.fCFUStringLengths = this.os.size();
                for (n3 = 0; n3 < n6; n3 += 2) {
                    int n8 = this.fStringLengthsTable.elementAt(n3);
                    int n9 = this.fStringLengthsTable.elementAt(n3 + 1);
                    assert (n8 < n);
                    assert (n9 < 40);
                    assert (n9 > n7);
                    this.os.writeShort((short)n8);
                    this.os.writeShort((short)n9);
                    n7 = n9;
                }
                this.os.flush();
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.bos.toByteArray()));
                dataInputStream.mark(Integer.MAX_VALUE);
                this.fSpoofData.initPtrs(dataInputStream);
            }

            public static void buildConfusableData(SpoofData spoofData, Reader reader) throws IOException, ParseException {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ConfusabledataBuilder confusabledataBuilder = new ConfusabledataBuilder(spoofData, byteArrayOutputStream);
                confusabledataBuilder.build(reader);
            }

            private static class SPUStringPool {
                private Vector<SPUString> fVec = new Vector();
                private Hashtable<String, SPUString> fHash = new Hashtable();

                public int size() {
                    return this.fVec.size();
                }

                public SPUString getByIndex(int n) {
                    SPUString sPUString = this.fVec.elementAt(n);
                    return sPUString;
                }

                public SPUString addString(String string) {
                    SPUString sPUString = this.fHash.get(string);
                    if (sPUString == null) {
                        sPUString = new SPUString(string);
                        this.fHash.put(string, sPUString);
                        this.fVec.addElement(sPUString);
                    }
                    return sPUString;
                }

                public void sort() {
                    Collections.sort(this.fVec, new SPUStringComparator());
                }
            }

            /*
             * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
             */
            private static class SPUStringComparator
            implements Comparator<SPUString> {
                private SPUStringComparator() {
                }

                @Override
                public int compare(SPUString sPUString, SPUString sPUString2) {
                    int n;
                    int n2 = sPUString.fStr.length();
                    if (n2 < (n = sPUString2.fStr.length())) {
                        return -1;
                    }
                    if (n2 > n) {
                        return 1;
                    }
                    return sPUString.fStr.compareTo(sPUString2.fStr);
                }
            }

            private static class SPUString {
                String fStr;
                int fStrTableIndex;

                SPUString(String string) {
                    this.fStr = string;
                    this.fStrTableIndex = 0;
                }
            }
        }

        private static class WSConfusableDataBuilder {
            static String parseExp = "(?m)^([ \\t]*(?:#.*?)?)$|^(?:\\s*([0-9A-F]{4,})(?:..([0-9A-F]{4,}))?\\s*;\\s*([A-Za-z]+)\\s*;\\s*([A-Za-z]+)\\s*;\\s*(?:(A)|(L))[ \\t]*(?:#.*?)?)$|^(.*?)$";

            private WSConfusableDataBuilder() {
            }

            static void readWholeFileToString(Reader reader, StringBuffer stringBuffer) throws IOException {
                String string;
                LineNumberReader lineNumberReader = new LineNumberReader(reader);
                while ((string = lineNumberReader.readLine()) != null) {
                    stringBuffer.append(string);
                    stringBuffer.append('\n');
                }
            }

            static void buildWSConfusableData(SpoofData spoofData, DataOutputStream dataOutputStream, Reader reader) throws ParseException, IOException {
                int n;
                Object object;
                int n2;
                Pattern pattern = null;
                StringBuffer stringBuffer = new StringBuffer();
                int n3 = 0;
                Vector<BuilderScriptSet> vector = null;
                int n4 = 2;
                Trie2Writable trie2Writable = new Trie2Writable(0, 0);
                Trie2Writable trie2Writable2 = new Trie2Writable(0, 0);
                vector = new Vector<BuilderScriptSet>();
                vector.addElement(null);
                vector.addElement(null);
                WSConfusableDataBuilder.readWholeFileToString(reader, stringBuffer);
                pattern = Pattern.compile(parseExp);
                if (stringBuffer.charAt(0) == '\ufeff') {
                    stringBuffer.setCharAt(0, ' ');
                }
                Matcher matcher = pattern.matcher(stringBuffer);
                while (matcher.find()) {
                    ++n3;
                    if (matcher.start(1) >= 0) continue;
                    if (matcher.start(8) >= 0) {
                        throw new ParseException("ConfusablesWholeScript, line " + n3 + ": Unrecognized input: " + matcher.group(), matcher.start());
                    }
                    n2 = Integer.parseInt(matcher.group(2), 16);
                    if (n2 > 0x10FFFF) {
                        throw new ParseException("ConfusablesWholeScript, line " + n3 + ": out of range code point: " + matcher.group(2), matcher.start(2));
                    }
                    int n5 = n2;
                    if (matcher.start(3) >= 0) {
                        n5 = Integer.parseInt(matcher.group(3), 16);
                    }
                    if (n5 > 0x10FFFF) {
                        throw new ParseException("ConfusablesWholeScript, line " + n3 + ": out of range code point: " + matcher.group(3), matcher.start(3));
                    }
                    String string = matcher.group(4);
                    object = matcher.group(5);
                    n = UCharacter.getPropertyValueEnum(4106, string);
                    int n6 = UCharacter.getPropertyValueEnum(4106, (CharSequence)object);
                    if (n == -1) {
                        throw new ParseException("ConfusablesWholeScript, line " + n3 + ": Invalid script code t: " + matcher.group(4), matcher.start(4));
                    }
                    if (n6 == -1) {
                        throw new ParseException("ConfusablesWholeScript, line " + n3 + ": Invalid script code t: " + matcher.group(5), matcher.start(5));
                    }
                    Trie2Writable trie2Writable3 = trie2Writable;
                    if (matcher.start(7) >= 0) {
                        trie2Writable3 = trie2Writable2;
                    }
                    for (int i = n2; i <= n5; ++i) {
                        int n7 = trie2Writable3.get(i);
                        BuilderScriptSet builderScriptSet = null;
                        if (n7 > 0) {
                            assert (n7 < vector.size());
                            builderScriptSet = (BuilderScriptSet)vector.elementAt(n7);
                        } else {
                            builderScriptSet = new BuilderScriptSet();
                            builderScriptSet.codePoint = i;
                            builderScriptSet.trie = trie2Writable3;
                            builderScriptSet.sset = new ScriptSet();
                            builderScriptSet.index = n7 = vector.size();
                            builderScriptSet.rindex = 0;
                            vector.addElement(builderScriptSet);
                            trie2Writable3.set(i, n7);
                        }
                        builderScriptSet.sset.Union(n6);
                        builderScriptSet.sset.Union(n);
                        int n8 = UScript.getScript(i);
                        if (n8 == n) continue;
                        throw new ParseException("ConfusablesWholeScript, line " + n3 + ": Mismatch between source script and code point " + Integer.toString(i, 16), matcher.start(5));
                    }
                }
                n4 = 2;
                for (n2 = 2; n2 < vector.size(); ++n2) {
                    BuilderScriptSet builderScriptSet = (BuilderScriptSet)vector.elementAt(n2);
                    if (builderScriptSet.index != n2) continue;
                    builderScriptSet.rindex = n4++;
                    for (int i = n2 + 1; i < vector.size(); ++i) {
                        object = (BuilderScriptSet)vector.elementAt(i);
                        if (!builderScriptSet.sset.equals(((BuilderScriptSet)object).sset) || builderScriptSet.sset == ((BuilderScriptSet)object).sset) continue;
                        ((BuilderScriptSet)object).sset = builderScriptSet.sset;
                        ((BuilderScriptSet)object).index = n2;
                        ((BuilderScriptSet)object).rindex = builderScriptSet.rindex;
                    }
                }
                for (n2 = 2; n2 < vector.size(); ++n2) {
                    BuilderScriptSet builderScriptSet = (BuilderScriptSet)vector.elementAt(n2);
                    if (builderScriptSet.rindex == n2) continue;
                    builderScriptSet.trie.set(builderScriptSet.codePoint, builderScriptSet.rindex);
                }
                UnicodeSet unicodeSet = new UnicodeSet();
                unicodeSet.applyIntPropertyValue(4106, 0);
                UnicodeSet unicodeSet2 = new UnicodeSet();
                unicodeSet2.applyIntPropertyValue(4106, 1);
                unicodeSet.addAll(unicodeSet2);
                for (int i = 0; i < unicodeSet.getRangeCount(); ++i) {
                    int n9 = unicodeSet.getRangeStart(i);
                    n = unicodeSet.getRangeEnd(i);
                    trie2Writable.setRange(n9, n, 1, true);
                    trie2Writable2.setRange(n9, n, 1, true);
                }
                trie2Writable.toTrie2_16().serialize(dataOutputStream);
                trie2Writable2.toTrie2_16().serialize(dataOutputStream);
                spoofData.fRawData.fScriptSetsLength = n4;
                int n10 = 2;
                for (int i = 2; i < vector.size(); ++i) {
                    BuilderScriptSet builderScriptSet = (BuilderScriptSet)vector.elementAt(i);
                    if (builderScriptSet.rindex < n10) continue;
                    assert (n10 == builderScriptSet.rindex);
                    builderScriptSet.sset.output(dataOutputStream);
                    ++n10;
                }
            }

            private static class BuilderScriptSet {
                int codePoint = -1;
                Trie2Writable trie = null;
                ScriptSet sset = null;
                int index = 0;
                int rindex = 0;

                BuilderScriptSet() {
                }
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum RestrictionLevel {
        ASCII,
        HIGHLY_RESTRICTIVE,
        MODERATELY_RESTRICTIVE,
        MINIMALLY_RESTRICTIVE,
        UNRESTRICTIVE;

    }
}

