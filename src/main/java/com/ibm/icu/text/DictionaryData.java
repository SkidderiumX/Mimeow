/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.text.BytesDictionaryMatcher;
import com.ibm.icu.text.CharsDictionaryMatcher;
import com.ibm.icu.text.DictionaryMatcher;
import com.ibm.icu.util.UResourceBundle;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DictionaryData {
    public static final int TRIE_TYPE_BYTES = 0;
    public static final int TRIE_TYPE_UCHARS = 1;
    public static final int TRIE_TYPE_MASK = 7;
    public static final int TRIE_HAS_VALUES = 8;
    public static final int TRANSFORM_NONE = 0;
    public static final int TRANSFORM_TYPE_OFFSET = 0x1000000;
    public static final int TRANSFORM_TYPE_MASK = 0x7F000000;
    public static final int TRANSFORM_OFFSET_MASK = 0x1FFFFF;
    public static final int IX_STRING_TRIE_OFFSET = 0;
    public static final int IX_RESERVED1_OFFSET = 1;
    public static final int IX_RESERVED2_OFFSET = 2;
    public static final int IX_TOTAL_SIZE = 3;
    public static final int IX_TRIE_TYPE = 4;
    public static final int IX_TRANSFORM = 5;
    public static final int IX_RESERVED6 = 6;
    public static final int IX_RESERVED7 = 7;
    public static final int IX_COUNT = 8;
    private static final byte[] DATA_FORMAT_ID = new byte[]{68, 105, 99, 116};

    private DictionaryData() {
    }

    public static DictionaryMatcher loadDictionaryFor(String string) throws IOException {
        int n;
        int n2;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b/brkitr");
        String string2 = iCUResourceBundle.getStringWithFallback("dictionaries/" + string);
        string2 = "data/icudt51b/brkitr/" + string2;
        InputStream inputStream2 = ICUData.getStream(string2);
        ICUBinary.readHeader(inputStream2, DATA_FORMAT_ID, null);
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        int[] nArray = new int[8];
        for (n2 = 0; n2 < 8; ++n2) {
            nArray[n2] = dataInputStream.readInt();
        }
        n2 = nArray[0];
        Assert.assrt(n2 >= 32);
        if (n2 > 32) {
            n = n2 - 32;
            dataInputStream.skipBytes(n);
        }
        n = nArray[4] & 7;
        int n3 = nArray[3] - n2;
        DictionaryMatcher dictionaryMatcher = null;
        if (n == 0) {
            int n4;
            int n5 = nArray[5];
            byte[] byArray = new byte[n3];
            for (n4 = 0; n4 < byArray.length; ++n4) {
                byArray[n4] = dataInputStream.readByte();
            }
            Assert.assrt(n4 == n3);
            dictionaryMatcher = new BytesDictionaryMatcher(byArray, n5);
        } else if (n == 1) {
            Assert.assrt(n3 % 2 == 0);
            int n6 = n3 / 2;
            char[] cArray = new char[n3 / 2];
            for (int i = 0; i < n6; ++i) {
                cArray[i] = dataInputStream.readChar();
            }
            dictionaryMatcher = new CharsDictionaryMatcher(new String(cArray));
        } else {
            dictionaryMatcher = null;
        }
        dataInputStream.close();
        inputStream2.close();
        return dictionaryMatcher;
    }
}

