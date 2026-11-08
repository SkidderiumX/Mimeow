/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public class LittleEndianDataInputStream
extends FilterInputStream
implements DataInput {
    public LittleEndianDataInputStream(InputStream inputStream2) {
        super(Preconditions.checkNotNull(inputStream2));
    }

    @Override
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override
    public void readFully(byte[] byArray) throws IOException {
        ByteStreams.readFully(this, byArray);
    }

    @Override
    public void readFully(byte[] byArray, int n, int n2) throws IOException {
        ByteStreams.readFully(this, byArray, n, n2);
    }

    @Override
    public int skipBytes(int n) throws IOException {
        return (int)this.in.skip(n);
    }

    @Override
    public int readUnsignedByte() throws IOException {
        int n = this.in.read();
        if (0 > n) {
            throw new EOFException();
        }
        return n;
    }

    @Override
    public int readUnsignedShort() throws IOException {
        byte by = this.readAndCheckByte();
        byte by2 = this.readAndCheckByte();
        return Ints.fromBytes((byte)0, (byte)0, by2, by);
    }

    @Override
    public int readInt() throws IOException {
        byte by = this.readAndCheckByte();
        byte by2 = this.readAndCheckByte();
        byte by3 = this.readAndCheckByte();
        byte by4 = this.readAndCheckByte();
        return Ints.fromBytes(by4, by3, by2, by);
    }

    @Override
    public long readLong() throws IOException {
        byte by = this.readAndCheckByte();
        byte by2 = this.readAndCheckByte();
        byte by3 = this.readAndCheckByte();
        byte by4 = this.readAndCheckByte();
        byte by5 = this.readAndCheckByte();
        byte by6 = this.readAndCheckByte();
        byte by7 = this.readAndCheckByte();
        byte by8 = this.readAndCheckByte();
        return Longs.fromBytes(by8, by7, by6, by5, by4, by3, by2, by);
    }

    @Override
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public String readUTF() throws IOException {
        return new DataInputStream(this.in).readUTF();
    }

    @Override
    public short readShort() throws IOException {
        return (short)this.readUnsignedShort();
    }

    @Override
    public char readChar() throws IOException {
        return (char)this.readUnsignedShort();
    }

    @Override
    public byte readByte() throws IOException {
        return (byte)this.readUnsignedByte();
    }

    @Override
    public boolean readBoolean() throws IOException {
        return this.readUnsignedByte() != 0;
    }

    private byte readAndCheckByte() throws IOException, EOFException {
        int n = this.in.read();
        if (-1 == n) {
            throw new EOFException();
        }
        return (byte)n;
    }
}

