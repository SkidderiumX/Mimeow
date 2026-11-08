/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.UCharacterName;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class UCharacterNameReader
implements ICUBinary.Authenticate {
    private DataInputStream m_dataInputStream_;
    private static final int GROUP_INFO_SIZE_ = 3;
    private int m_tokenstringindex_;
    private int m_groupindex_;
    private int m_groupstringindex_;
    private int m_algnamesindex_;
    private static final int ALG_INFO_SIZE_ = 12;
    private static final byte[] DATA_FORMAT_VERSION_ = new byte[]{1, 0, 0, 0};
    private static final byte[] DATA_FORMAT_ID_ = new byte[]{117, 110, 97, 109};

    public boolean isDataVersionAcceptable(byte[] byArray) {
        return byArray[0] == DATA_FORMAT_VERSION_[0];
    }

    protected UCharacterNameReader(InputStream inputStream2) throws IOException {
        ICUBinary.readHeader(inputStream2, DATA_FORMAT_ID_, this);
        this.m_dataInputStream_ = new DataInputStream(inputStream2);
    }

    protected void read(UCharacterName uCharacterName) throws IOException {
        int n;
        this.m_tokenstringindex_ = this.m_dataInputStream_.readInt();
        this.m_groupindex_ = this.m_dataInputStream_.readInt();
        this.m_groupstringindex_ = this.m_dataInputStream_.readInt();
        this.m_algnamesindex_ = this.m_dataInputStream_.readInt();
        int n2 = this.m_dataInputStream_.readChar();
        char[] cArray = new char[n2];
        for (n = 0; n < n2; n = (int)((char)(n + 1))) {
            cArray[n] = this.m_dataInputStream_.readChar();
        }
        n = this.m_groupindex_ - this.m_tokenstringindex_;
        byte[] byArray = new byte[n];
        this.m_dataInputStream_.readFully(byArray);
        uCharacterName.setToken(cArray, byArray);
        n2 = this.m_dataInputStream_.readChar();
        uCharacterName.setGroupCountSize(n2, 3);
        char[] cArray2 = new char[n2 *= 3];
        for (int i = 0; i < n2; ++i) {
            cArray2[i] = this.m_dataInputStream_.readChar();
        }
        n = this.m_algnamesindex_ - this.m_groupstringindex_;
        byte[] byArray2 = new byte[n];
        this.m_dataInputStream_.readFully(byArray2);
        uCharacterName.setGroup(cArray2, byArray2);
        n2 = this.m_dataInputStream_.readInt();
        UCharacterName.AlgorithmName[] algorithmNameArray = new UCharacterName.AlgorithmName[n2];
        for (int i = 0; i < n2; ++i) {
            UCharacterName.AlgorithmName algorithmName = this.readAlg();
            if (algorithmName == null) {
                throw new IOException("unames.icu read error: Algorithmic names creation error");
            }
            algorithmNameArray[i] = algorithmName;
        }
        uCharacterName.setAlgorithm(algorithmNameArray);
    }

    protected boolean authenticate(byte[] byArray, byte[] byArray2) {
        return Arrays.equals(DATA_FORMAT_ID_, byArray) && Arrays.equals(DATA_FORMAT_VERSION_, byArray2);
    }

    private UCharacterName.AlgorithmName readAlg() throws IOException {
        char c;
        Object object;
        char c2;
        byte by;
        int n;
        UCharacterName.AlgorithmName algorithmName = new UCharacterName.AlgorithmName();
        int n2 = this.m_dataInputStream_.readInt();
        if (!algorithmName.setInfo(n2, n = this.m_dataInputStream_.readInt(), by = this.m_dataInputStream_.readByte(), (byte)(c2 = this.m_dataInputStream_.readByte()))) {
            return null;
        }
        int n3 = this.m_dataInputStream_.readChar();
        if (by == 1) {
            object = new char[c2];
            for (c = '\u0000'; c < c2; c = (char)(c + 1)) {
                object[c] = this.m_dataInputStream_.readChar();
            }
            algorithmName.setFactor((char[])object);
            n3 -= c2 << 1;
        }
        object = new StringBuilder();
        c = (char)(this.m_dataInputStream_.readByte() & 0xFF);
        while (c != '\u0000') {
            ((StringBuilder)object).append(c);
            c = (char)(this.m_dataInputStream_.readByte() & 0xFF);
        }
        algorithmName.setPrefix(((StringBuilder)object).toString());
        if ((n3 -= 12 + ((StringBuilder)object).length() + 1) > 0) {
            byte[] byArray = new byte[n3];
            this.m_dataInputStream_.readFully(byArray);
            algorithmName.setFactorString(byArray);
        }
        return algorithmName;
    }
}

