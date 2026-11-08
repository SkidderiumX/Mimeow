/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.CharsetMatch;
import com.ibm.icu.text.CharsetRecog_2022;
import com.ibm.icu.text.CharsetRecog_UTF8;
import com.ibm.icu.text.CharsetRecog_Unicode;
import com.ibm.icu.text.CharsetRecog_mbcs;
import com.ibm.icu.text.CharsetRecog_sbcs;
import com.ibm.icu.text.CharsetRecognizer;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CharsetDetector {
    private static final int kBufSize = 8000;
    byte[] fInputBytes = new byte[8000];
    int fInputLen;
    short[] fByteStats = new short[256];
    boolean fC1Bytes = false;
    String fDeclaredEncoding;
    byte[] fRawInput;
    int fRawLength;
    InputStream fInputStream;
    boolean fStripTags = false;
    private static ArrayList<CharsetRecognizer> fCSRecognizers = CharsetDetector.createRecognizers();
    private static String[] fCharsetNames;

    public CharsetDetector setDeclaredEncoding(String string) {
        this.fDeclaredEncoding = string;
        return this;
    }

    public CharsetDetector setText(byte[] byArray) {
        this.fRawInput = byArray;
        this.fRawLength = byArray.length;
        return this;
    }

    public CharsetDetector setText(InputStream inputStream2) throws IOException {
        int n;
        this.fInputStream = inputStream2;
        this.fInputStream.mark(8000);
        this.fRawInput = new byte[8000];
        this.fRawLength = 0;
        for (int i = 8000; i > 0 && (n = this.fInputStream.read(this.fRawInput, this.fRawLength, i)) > 0; i -= n) {
            this.fRawLength += n;
        }
        this.fInputStream.reset();
        return this;
    }

    public CharsetMatch detect() {
        CharsetMatch[] charsetMatchArray = this.detectAll();
        if (charsetMatchArray == null || charsetMatchArray.length == 0) {
            return null;
        }
        return charsetMatchArray[0];
    }

    public CharsetMatch[] detectAll() {
        ArrayList<CharsetMatch> arrayList = new ArrayList<CharsetMatch>();
        this.MungeInput();
        for (CharsetRecognizer charsetRecognizer : fCSRecognizers) {
            CharsetMatch charsetMatch = charsetRecognizer.match(this);
            if (charsetMatch == null) continue;
            arrayList.add(charsetMatch);
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        CharsetMatch[] charsetMatchArray = new CharsetMatch[arrayList.size()];
        charsetMatchArray = arrayList.toArray(charsetMatchArray);
        return charsetMatchArray;
    }

    public Reader getReader(InputStream inputStream2, String string) {
        this.fDeclaredEncoding = string;
        try {
            this.setText(inputStream2);
            CharsetMatch charsetMatch = this.detect();
            if (charsetMatch == null) {
                return null;
            }
            return charsetMatch.getReader();
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public String getString(byte[] byArray, String string) {
        this.fDeclaredEncoding = string;
        try {
            this.setText(byArray);
            CharsetMatch charsetMatch = this.detect();
            if (charsetMatch == null) {
                return null;
            }
            return charsetMatch.getString(-1);
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static String[] getAllDetectableCharsets() {
        return fCharsetNames;
    }

    public boolean inputFilterEnabled() {
        return this.fStripTags;
    }

    public boolean enableInputFilter(boolean bl) {
        boolean bl2 = this.fStripTags;
        this.fStripTags = bl;
        return bl2;
    }

    private void MungeInput() {
        int n;
        int n2 = 0;
        int n3 = 0;
        boolean bl = false;
        int n4 = 0;
        int n5 = 0;
        if (this.fStripTags) {
            for (n2 = 0; n2 < this.fRawLength && n3 < this.fInputBytes.length; ++n2) {
                byte by = this.fRawInput[n2];
                if (by == 60) {
                    if (bl) {
                        ++n5;
                    }
                    bl = true;
                    ++n4;
                }
                if (!bl) {
                    this.fInputBytes[n3++] = by;
                }
                if (by != 62) continue;
                bl = false;
            }
            this.fInputLen = n3;
        }
        if (n4 < 5 || n4 / 5 < n5 || this.fInputLen < 100 && this.fRawLength > 600) {
            n = this.fRawLength;
            if (n > 8000) {
                n = 8000;
            }
            for (n2 = 0; n2 < n; ++n2) {
                this.fInputBytes[n2] = this.fRawInput[n2];
            }
            this.fInputLen = n2;
        }
        Arrays.fill(this.fByteStats, (short)0);
        for (n2 = 0; n2 < this.fInputLen; ++n2) {
            int n6 = n = this.fInputBytes[n2] & 0xFF;
            this.fByteStats[n6] = (short)(this.fByteStats[n6] + 1);
        }
        this.fC1Bytes = false;
        for (n = 128; n <= 159; ++n) {
            if (this.fByteStats[n] == 0) continue;
            this.fC1Bytes = true;
            break;
        }
    }

    private static ArrayList<CharsetRecognizer> createRecognizers() {
        ArrayList<CharsetRecognizer> arrayList = new ArrayList<CharsetRecognizer>();
        arrayList.add(new CharsetRecog_UTF8());
        arrayList.add(new CharsetRecog_Unicode.CharsetRecog_UTF_16_BE());
        arrayList.add(new CharsetRecog_Unicode.CharsetRecog_UTF_16_LE());
        arrayList.add(new CharsetRecog_Unicode.CharsetRecog_UTF_32_BE());
        arrayList.add(new CharsetRecog_Unicode.CharsetRecog_UTF_32_LE());
        arrayList.add(new CharsetRecog_mbcs.CharsetRecog_sjis());
        arrayList.add(new CharsetRecog_2022.CharsetRecog_2022JP());
        arrayList.add(new CharsetRecog_2022.CharsetRecog_2022CN());
        arrayList.add(new CharsetRecog_2022.CharsetRecog_2022KR());
        arrayList.add(new CharsetRecog_mbcs.CharsetRecog_gb_18030());
        arrayList.add(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_jp());
        arrayList.add(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_kr());
        arrayList.add(new CharsetRecog_mbcs.CharsetRecog_big5());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_8859_1());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_8859_2());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_8859_5_ru());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_8859_6_ar());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_8859_7_el());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_8859_8_I_he());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_8859_8_he());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_windows_1251());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_windows_1256());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_KOI8_R());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_8859_9_tr());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_rtl());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_ltr());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_rtl());
        arrayList.add(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_ltr());
        String[] stringArray = new String[arrayList.size()];
        int n = 0;
        for (int i = 0; i < arrayList.size(); ++i) {
            String string = ((CharsetRecognizer)arrayList.get(i)).getName();
            if (n != 0 && string.equals(stringArray[n - 1])) continue;
            stringArray[n++] = string;
        }
        fCharsetNames = new String[n];
        System.arraycopy(stringArray, 0, fCharsetNames, 0, n);
        return arrayList;
    }
}

