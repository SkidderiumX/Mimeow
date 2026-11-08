/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.util.CompactByteArray;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class BreakDictionary {
    private char[] reverseColumnMap = null;
    private CompactByteArray columnMap = null;
    private int numCols;
    private short[] table = null;
    private short[] rowIndex = null;
    private int[] rowIndexFlags = null;
    private short[] rowIndexFlagsIndex = null;
    private byte[] rowIndexShifts = null;

    static void writeToFile(String string, String string2) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BreakDictionary breakDictionary = new BreakDictionary(new FileInputStream(string));
        PrintWriter printWriter = null;
        if (string2 != null) {
            printWriter = new PrintWriter(new OutputStreamWriter((OutputStream)new FileOutputStream(string2), "UnicodeLittle"));
        }
        breakDictionary.printWordList("", 0, printWriter);
        if (printWriter != null) {
            printWriter.close();
        }
    }

    void printWordList(String string, int n, PrintWriter printWriter) throws IOException {
        if (n == 65535) {
            System.out.println(string);
            if (printWriter != null) {
                printWriter.println(string);
            }
        } else {
            for (int i = 0; i < this.numCols; ++i) {
                int n2 = this.at(n, i) & 0xFFFF;
                if (n2 == 0) continue;
                char c = this.reverseColumnMap[i];
                String string2 = string;
                if (c != '\u0000') {
                    string2 = string2 + c;
                }
                this.printWordList(string2, n2, printWriter);
            }
        }
    }

    BreakDictionary(InputStream inputStream2) throws IOException {
        this.readDictionaryFile(new DataInputStream(inputStream2));
    }

    void readDictionaryFile(DataInputStream dataInputStream) throws IOException {
        char c;
        dataInputStream.readInt();
        int n = dataInputStream.readInt();
        char[] cArray = new char[n];
        for (int i = 0; i < cArray.length; ++i) {
            cArray[i] = (char)dataInputStream.readShort();
        }
        n = dataInputStream.readInt();
        byte[] byArray = new byte[n];
        for (c = '\u0000'; c < byArray.length; ++c) {
            byArray[c] = dataInputStream.readByte();
        }
        this.columnMap = new CompactByteArray(cArray, byArray);
        this.numCols = dataInputStream.readInt();
        dataInputStream.readInt();
        n = dataInputStream.readInt();
        this.rowIndex = new short[n];
        for (c = '\u0000'; c < this.rowIndex.length; ++c) {
            this.rowIndex[c] = dataInputStream.readShort();
        }
        n = dataInputStream.readInt();
        this.rowIndexFlagsIndex = new short[n];
        for (c = '\u0000'; c < this.rowIndexFlagsIndex.length; ++c) {
            this.rowIndexFlagsIndex[c] = dataInputStream.readShort();
        }
        n = dataInputStream.readInt();
        this.rowIndexFlags = new int[n];
        for (c = '\u0000'; c < this.rowIndexFlags.length; ++c) {
            this.rowIndexFlags[c] = dataInputStream.readInt();
        }
        n = dataInputStream.readInt();
        this.rowIndexShifts = new byte[n];
        for (c = '\u0000'; c < this.rowIndexShifts.length; ++c) {
            this.rowIndexShifts[c] = dataInputStream.readByte();
        }
        n = dataInputStream.readInt();
        this.table = new short[n];
        for (c = '\u0000'; c < this.table.length; ++c) {
            this.table[c] = dataInputStream.readShort();
        }
        this.reverseColumnMap = new char[this.numCols];
        for (c = '\u0000'; c < '\uffff'; c = (char)(c + '\u0001')) {
            byte by = this.columnMap.elementAt(c);
            if (by == 0) continue;
            this.reverseColumnMap[by] = c;
        }
        dataInputStream.close();
    }

    final short at(int n, char c) {
        byte by = this.columnMap.elementAt(c);
        return this.at(n, by);
    }

    final short at(int n, int n2) {
        if (this.cellIsPopulated(n, n2)) {
            return this.internalAt(this.rowIndex[n], n2 + this.rowIndexShifts[n]);
        }
        return 0;
    }

    private final boolean cellIsPopulated(int n, int n2) {
        if (this.rowIndexFlagsIndex[n] < 0) {
            return n2 == -this.rowIndexFlagsIndex[n];
        }
        int n3 = this.rowIndexFlags[this.rowIndexFlagsIndex[n] + (n2 >> 5)];
        return (n3 & 1 << (n2 & 0x1F)) != 0;
    }

    private final short internalAt(int n, int n2) {
        return this.table[n * this.numCols + n2];
    }
}

