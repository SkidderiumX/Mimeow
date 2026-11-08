/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUDebug;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StringPrepDataReader
implements ICUBinary.Authenticate {
    private static final boolean debug = ICUDebug.enabled("NormalizerDataReader");
    private DataInputStream dataInputStream;
    private byte[] unicodeVersion;
    private static final byte[] DATA_FORMAT_ID = new byte[]{83, 80, 82, 80};
    private static final byte[] DATA_FORMAT_VERSION = new byte[]{3, 2, 5, 2};

    public StringPrepDataReader(InputStream inputStream2) throws IOException {
        if (debug) {
            System.out.println("Bytes in inputStream " + inputStream2.available());
        }
        this.unicodeVersion = ICUBinary.readHeader(inputStream2, DATA_FORMAT_ID, this);
        if (debug) {
            System.out.println("Bytes left in inputStream " + inputStream2.available());
        }
        this.dataInputStream = new DataInputStream(inputStream2);
        if (debug) {
            System.out.println("Bytes left in dataInputStream " + this.dataInputStream.available());
        }
    }

    public void read(byte[] byArray, char[] cArray) throws IOException {
        this.dataInputStream.readFully(byArray);
        for (int i = 0; i < cArray.length; ++i) {
            cArray[i] = this.dataInputStream.readChar();
        }
    }

    public byte[] getDataFormatVersion() {
        return DATA_FORMAT_VERSION;
    }

    public boolean isDataVersionAcceptable(byte[] byArray) {
        return byArray[0] == DATA_FORMAT_VERSION[0] && byArray[2] == DATA_FORMAT_VERSION[2] && byArray[3] == DATA_FORMAT_VERSION[3];
    }

    public int[] readIndexes(int n) throws IOException {
        int[] nArray = new int[n];
        for (int i = 0; i < n; ++i) {
            nArray[i] = this.dataInputStream.readInt();
        }
        return nArray;
    }

    public byte[] getUnicodeVersion() {
        return this.unicodeVersion;
    }
}

