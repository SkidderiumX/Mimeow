/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.io;

import com.google.common.base.Preconditions;
import io.netty.buffer.ByteBuf;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UTFDataFormatException;
import java.nio.charset.StandardCharsets;

public class FastByteBufInputStream
extends InputStream
implements DataInput {
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final char[] EMPTY_CHARS = new char[0];
    private byte[] bytearr = EMPTY_BYTES;
    private char[] chararr = EMPTY_CHARS;
    private final ByteBuf buf;

    public FastByteBufInputStream(ByteBuf byteBuf) {
        Preconditions.checkNotNull(byteBuf);
        this.buf = byteBuf;
        byteBuf.markReaderIndex();
    }

    @Override
    public String readUTF() throws IOException {
        String string;
        int n = this.readUnsignedShort();
        if (n == 0) {
            return "";
        }
        ByteBuf byteBuf = this.buf;
        int n2 = byteBuf.readerIndex();
        if (byteBuf.readableBytes() < n) {
            throw new EOFException();
        }
        if (byteBuf.hasArray()) {
            string = this.decodeFromArray(byteBuf.array(), byteBuf.arrayOffset() + n2, n);
            byteBuf.readerIndex(n2 + n);
        } else {
            byte[] byArray = this.ensureBytes(n);
            byteBuf.readBytes(byArray, 0, n);
            string = this.decodeFromArray(byArray, 0, n);
        }
        return string;
    }

    private String decodeFromArray(byte[] byArray, int n, int n2) throws UTFDataFormatException {
        int n3;
        int n4;
        for (n4 = 0; n4 < n2 && byArray[n + n4] >= 0; ++n4) {
        }
        if (n4 == n2) {
            return new String(byArray, n, n2, StandardCharsets.ISO_8859_1);
        }
        char[] cArray = this.ensureChars(n2);
        for (n3 = 0; n3 < n4; ++n3) {
            cArray[n3] = (char)byArray[n + n3];
        }
        n3 = FastByteBufInputStream.decode(byArray, n + n4, n + n2, cArray, n4);
        return new String(cArray, 0, n3);
    }

    private static int decode(byte[] byArray, int n, int n2, char[] cArray, int n3) throws UTFDataFormatException {
        block5: while (n < n2) {
            int n4 = byArray[n] & 0xFF;
            switch (n4 >> 4) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    ++n;
                    cArray[n3++] = (char)n4;
                    continue block5;
                }
                case 12: 
                case 13: {
                    if (n + 2 > n2) {
                        throw new UTFDataFormatException("malformed input: partial character at end");
                    }
                    byte by = byArray[n + 1];
                    if ((by & 0xC0) != 128) {
                        throw new UTFDataFormatException("malformed input around byte " + (n + 2));
                    }
                    cArray[n3++] = (char)((n4 & 0x1F) << 6 | by & 0x3F);
                    n += 2;
                    continue block5;
                }
                case 14: {
                    if (n + 3 > n2) {
                        throw new UTFDataFormatException("malformed input: partial character at end");
                    }
                    byte by = byArray[n + 1];
                    byte by2 = byArray[n + 2];
                    if ((by & 0xC0) != 128 || (by2 & 0xC0) != 128) {
                        throw new UTFDataFormatException("malformed input around byte " + (n + 2));
                    }
                    cArray[n3++] = (char)((n4 & 0xF) << 12 | (by & 0x3F) << 6 | by2 & 0x3F);
                    n += 3;
                    continue block5;
                }
            }
            throw new UTFDataFormatException("malformed input around byte " + n);
        }
        return n3;
    }

    private byte[] ensureBytes(int n) {
        if (this.bytearr.length < n) {
            this.bytearr = new byte[Math.max(n, 64)];
        }
        return this.bytearr;
    }

    private char[] ensureChars(int n) {
        if (this.chararr.length < n) {
            this.chararr = new char[Math.max(n, 64)];
        }
        return this.chararr;
    }

    @Override
    public int available() {
        return this.buf.readableBytes();
    }

    @Override
    public void mark(int n) {
        this.buf.markReaderIndex();
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public int read() throws IOException {
        if (!this.buf.isReadable()) {
            return -1;
        }
        return this.buf.readByte() & 0xFF;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = this.buf.readableBytes();
        if (n3 == 0) {
            return -1;
        }
        n2 = Math.min(n3, n2);
        this.buf.readBytes(byArray, n, n2);
        return n2;
    }

    @Override
    public void reset() throws IOException {
        this.buf.resetReaderIndex();
    }

    @Override
    public long skip(long l) throws IOException {
        if (l > Integer.MAX_VALUE) {
            return this.skipBytes(Integer.MAX_VALUE);
        }
        return this.skipBytes((int)l);
    }

    @Override
    public boolean readBoolean() throws IOException {
        this.checkAvailable(1);
        return this.buf.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        this.checkAvailable(1);
        return this.buf.readByte();
    }

    @Override
    public char readChar() {
        return (char)this.buf.readShort();
    }

    @Override
    public double readDouble() {
        return Double.longBitsToDouble(this.buf.readLong());
    }

    @Override
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.buf.readInt());
    }

    @Override
    public void readFully(byte[] byArray) throws IOException {
        this.readFully(byArray, 0, byArray.length);
    }

    @Override
    public void readFully(byte[] byArray, int n, int n2) throws IOException {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
        }
        this.checkAvailable(n2);
        this.buf.readBytes(byArray, n, n2);
    }

    @Override
    public int readInt() throws IOException {
        this.checkAvailable(4);
        return this.buf.readInt();
    }

    @Override
    public String readLine() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = this.available();
        if (n == 0) {
            return null;
        }
        block4: while (true) {
            short s = this.buf.readUnsignedByte();
            --n;
            switch (s) {
                case 10: {
                    break block4;
                }
                case 13: {
                    if (n <= 0 || (char)this.buf.getUnsignedByte(this.buf.readerIndex()) != '\n') break block4;
                    this.buf.skipBytes(1);
                    --n;
                    break block4;
                }
                default: {
                    stringBuilder.append((char)s);
                    if (n > 0) continue block4;
                }
            }
            break;
        }
        return !stringBuilder.isEmpty() ? stringBuilder.toString() : "";
    }

    @Override
    public long readLong() throws IOException {
        this.checkAvailable(8);
        return this.buf.readLong();
    }

    @Override
    public short readShort() throws IOException {
        this.checkAvailable(2);
        return this.buf.readShort();
    }

    @Override
    public int readUnsignedByte() {
        return this.buf.readByte() & 0xFF;
    }

    @Override
    public int readUnsignedShort() {
        return this.buf.readShort() & 0xFFFF;
    }

    @Override
    public int skipBytes(int n) {
        int n2 = Math.min(this.available(), n);
        this.buf.skipBytes(n2);
        return n2;
    }

    private void checkAvailable(int n) throws IOException {
        if (n > this.buf.readableBytes()) {
            throw new EOFException("fieldSize is too long! Length is " + n + ", but maximum is " + this.available());
        }
    }
}

