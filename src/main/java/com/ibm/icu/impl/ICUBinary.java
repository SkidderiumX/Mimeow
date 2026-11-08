/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.util.VersionInfo;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ICUBinary {
    private static final byte MAGIC1 = -38;
    private static final byte MAGIC2 = 39;
    private static final byte BIG_ENDIAN_ = 1;
    private static final byte CHAR_SET_ = 0;
    private static final byte CHAR_SIZE_ = 2;
    private static final String MAGIC_NUMBER_AUTHENTICATION_FAILED_ = "ICU data file error: Not an ICU data file";
    private static final String HEADER_AUTHENTICATION_FAILED_ = "ICU data file error: Header authentication failed, please check if you have a valid ICU data file";

    public static final byte[] readHeader(InputStream inputStream2, byte[] byArray, Authenticate authenticate) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        char c = dataInputStream.readChar();
        char c2 = '\u0002';
        byte by = dataInputStream.readByte();
        ++c2;
        byte by2 = dataInputStream.readByte();
        ++c2;
        if (by != -38 || by2 != 39) {
            throw new IOException(MAGIC_NUMBER_AUTHENTICATION_FAILED_);
        }
        dataInputStream.readChar();
        c2 += 2;
        dataInputStream.readChar();
        c2 += 2;
        byte by3 = dataInputStream.readByte();
        ++c2;
        byte by4 = dataInputStream.readByte();
        ++c2;
        byte by5 = dataInputStream.readByte();
        ++c2;
        dataInputStream.readByte();
        ++c2;
        byte[] byArray2 = new byte[4];
        dataInputStream.readFully(byArray2);
        c2 += 4;
        byte[] byArray3 = new byte[4];
        dataInputStream.readFully(byArray3);
        c2 += 4;
        byte[] byArray4 = new byte[4];
        dataInputStream.readFully(byArray4);
        if (c < (c2 += 4)) {
            throw new IOException("Internal Error: Header size error");
        }
        dataInputStream.skipBytes(c - c2);
        if (by3 != 1 || by4 != 0 || by5 != 2 || !Arrays.equals(byArray, byArray2) || authenticate != null && !authenticate.isDataVersionAcceptable(byArray3)) {
            throw new IOException(HEADER_AUTHENTICATION_FAILED_);
        }
        return byArray4;
    }

    public static final VersionInfo readHeaderAndDataVersion(InputStream inputStream2, byte[] byArray, Authenticate authenticate) throws IOException {
        byte[] byArray2 = ICUBinary.readHeader(inputStream2, byArray, authenticate);
        return VersionInfo.getInstance(byArray2[0], byArray2[1], byArray2[2], byArray2[3]);
    }

    public static interface Authenticate {
        public boolean isDataVersionAcceptable(byte[] var1);
    }
}

