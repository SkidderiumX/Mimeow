/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.io;

import com.google.common.base.Preconditions;
import io.netty.buffer.ByteBuf;
import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UTFDataFormatException;

public class FastByteBufOutputStream
extends OutputStream
implements DataOutput {
    private final ByteBuf buf;

    public FastByteBufOutputStream(ByteBuf byteBuf) {
        Preconditions.checkNotNull(byteBuf);
        this.buf = byteBuf;
    }

    @Override
    public void writeUTF(String string) throws IOException {
        int n;
        int n2;
        int n3 = string.length();
        if (n3 == 0) {
            this.buf.writeShort(0);
            return;
        }
        if (n3 > 65535) {
            throw new UTFDataFormatException("encoded string too long: " + n3 + " characters");
        }
        int n4 = this.buf.writerIndex();
        int n5 = n4 + 2;
        this.buf.ensureWritable(2 + n3);
        this.buf.writeShort(n3);
        for (n2 = 0; n2 < n3 && (n = string.charAt(n2)) < 128 && n != 0; ++n2) {
            this.buf.writeByte(n);
        }
        if (n2 == n3) {
            return;
        }
        while (n2 < n3) {
            n = string.charAt(n2);
            if (n < 128 && n != 0) {
                this.buf.writeByte(n);
            } else if (n >= 2048) {
                this.buf.writeByte(0xE0 | n >> 12 & 0xF);
                this.buf.writeByte(0x80 | n >> 6 & 0x3F);
                this.buf.writeByte(0x80 | n & 0x3F);
            } else {
                this.buf.writeByte(0xC0 | n >> 6 & 0x1F);
                this.buf.writeByte(0x80 | n & 0x3F);
            }
            ++n2;
        }
        n = this.buf.writerIndex() - n5;
        if (n > 65535) {
            this.buf.writerIndex(n4);
            throw new UTFDataFormatException("encoded string too long: " + n + " bytes");
        }
        this.buf.setShort(n4, n);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.buf.writeBytes(byArray, n, n2);
    }

    @Override
    public void write(byte[] byArray) throws IOException {
        this.buf.writeBytes(byArray);
    }

    @Override
    public void write(int n) throws IOException {
        this.buf.writeByte(n);
    }

    @Override
    public void writeBoolean(boolean bl) throws IOException {
        this.buf.writeBoolean(bl);
    }

    @Override
    public void writeByte(int n) throws IOException {
        this.buf.writeByte(n);
    }

    @Override
    public void writeBytes(String string) throws IOException {
        int n = string.length();
        this.buf.ensureWritable(n);
        int n2 = this.buf.writerIndex();
        for (int i = 0; i < n; ++i) {
            this.buf.setByte(n2 + i, (byte)string.charAt(i));
        }
        this.buf.writerIndex(n2 + n);
    }

    @Override
    public void writeChar(int n) {
        this.buf.writeChar(n);
    }

    @Override
    public void writeChars(String string) {
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            this.buf.writeChar(string.charAt(i));
        }
    }

    @Override
    public void writeDouble(double d) throws IOException {
        this.buf.writeDouble(d);
    }

    @Override
    public void writeFloat(float f) throws IOException {
        this.buf.writeFloat(f);
    }

    @Override
    public void writeInt(int n) throws IOException {
        this.buf.writeInt(n);
    }

    @Override
    public void writeLong(long l) throws IOException {
        this.buf.writeLong(l);
    }

    @Override
    public void writeShort(int n) throws IOException {
        this.buf.writeShort((short)n);
    }
}

