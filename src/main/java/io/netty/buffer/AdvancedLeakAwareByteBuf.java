/*
 * Decompiled with CFR 0.152.
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.WrappedByteBuf;
import io.netty.util.ResourceLeak;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public class AdvancedLeakAwareByteBuf
extends WrappedByteBuf {
    private final ResourceLeak leak;

    AdvancedLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeak resourceLeak) {
        super(byteBuf);
        this.leak = resourceLeak;
    }

    @Override
    public boolean release() {
        boolean bl = super.release();
        if (bl) {
            this.leak.close();
        } else {
            this.leak.m4edf77299b();
        }
        return bl;
    }

    @Override
    public boolean release(int n) {
        boolean bl = super.release(n);
        if (bl) {
            this.leak.close();
        } else {
            this.leak.m4edf77299b();
        }
        return bl;
    }

    @Override
    public ByteBuf order(ByteOrder byteOrder) {
        this.leak.m4edf77299b();
        if (this.order() == byteOrder) {
            return this;
        }
        return new AdvancedLeakAwareByteBuf(super.order(byteOrder), this.leak);
    }

    @Override
    public ByteBuf slice() {
        this.leak.m4edf77299b();
        return new AdvancedLeakAwareByteBuf(super.slice(), this.leak);
    }

    @Override
    public ByteBuf slice(int n, int n2) {
        this.leak.m4edf77299b();
        return new AdvancedLeakAwareByteBuf(super.slice(n, n2), this.leak);
    }

    @Override
    public ByteBuf duplicate() {
        this.leak.m4edf77299b();
        return new AdvancedLeakAwareByteBuf(super.duplicate(), this.leak);
    }

    @Override
    public ByteBuf readSlice(int n) {
        this.leak.m4edf77299b();
        return new AdvancedLeakAwareByteBuf(super.readSlice(n), this.leak);
    }

    @Override
    public ByteBuf discardReadBytes() {
        this.leak.m4edf77299b();
        return super.discardReadBytes();
    }

    @Override
    public ByteBuf discardSomeReadBytes() {
        this.leak.m4edf77299b();
        return super.discardSomeReadBytes();
    }

    @Override
    public ByteBuf ensureWritable(int n) {
        this.leak.m4edf77299b();
        return super.ensureWritable(n);
    }

    @Override
    public int ensureWritable(int n, boolean bl) {
        this.leak.m4edf77299b();
        return super.ensureWritable(n, bl);
    }

    @Override
    public boolean getBoolean(int n) {
        this.leak.m4edf77299b();
        return super.getBoolean(n);
    }

    @Override
    public byte getByte(int n) {
        this.leak.m4edf77299b();
        return super.getByte(n);
    }

    @Override
    public short getUnsignedByte(int n) {
        this.leak.m4edf77299b();
        return super.getUnsignedByte(n);
    }

    @Override
    public short getShort(int n) {
        this.leak.m4edf77299b();
        return super.getShort(n);
    }

    @Override
    public int getUnsignedShort(int n) {
        this.leak.m4edf77299b();
        return super.getUnsignedShort(n);
    }

    @Override
    public int getMedium(int n) {
        this.leak.m4edf77299b();
        return super.getMedium(n);
    }

    @Override
    public int getUnsignedMedium(int n) {
        this.leak.m4edf77299b();
        return super.getUnsignedMedium(n);
    }

    @Override
    public int getInt(int n) {
        this.leak.m4edf77299b();
        return super.getInt(n);
    }

    @Override
    public long getUnsignedInt(int n) {
        this.leak.m4edf77299b();
        return super.getUnsignedInt(n);
    }

    @Override
    public long getLong(int n) {
        this.leak.m4edf77299b();
        return super.getLong(n);
    }

    @Override
    public char getChar(int n) {
        this.leak.m4edf77299b();
        return super.getChar(n);
    }

    @Override
    public float getFloat(int n) {
        this.leak.m4edf77299b();
        return super.getFloat(n);
    }

    @Override
    public double getDouble(int n) {
        this.leak.m4edf77299b();
        return super.getDouble(n);
    }

    @Override
    public ByteBuf getBytes(int n, ByteBuf byteBuf) {
        this.leak.m4edf77299b();
        return super.getBytes(n, byteBuf);
    }

    @Override
    public ByteBuf getBytes(int n, ByteBuf byteBuf, int n2) {
        this.leak.m4edf77299b();
        return super.getBytes(n, byteBuf, n2);
    }

    @Override
    public ByteBuf getBytes(int n, ByteBuf byteBuf, int n2, int n3) {
        this.leak.m4edf77299b();
        return super.getBytes(n, byteBuf, n2, n3);
    }

    @Override
    public ByteBuf getBytes(int n, byte[] byArray) {
        this.leak.m4edf77299b();
        return super.getBytes(n, byArray);
    }

    @Override
    public ByteBuf getBytes(int n, byte[] byArray, int n2, int n3) {
        this.leak.m4edf77299b();
        return super.getBytes(n, byArray, n2, n3);
    }

    @Override
    public ByteBuf getBytes(int n, ByteBuffer byteBuffer) {
        this.leak.m4edf77299b();
        return super.getBytes(n, byteBuffer);
    }

    @Override
    public ByteBuf getBytes(int n, OutputStream outputStream2, int n2) throws IOException {
        this.leak.m4edf77299b();
        return super.getBytes(n, outputStream2, n2);
    }

    @Override
    public int getBytes(int n, GatheringByteChannel gatheringByteChannel, int n2) throws IOException {
        this.leak.m4edf77299b();
        return super.getBytes(n, gatheringByteChannel, n2);
    }

    @Override
    public ByteBuf setBoolean(int n, boolean bl) {
        this.leak.m4edf77299b();
        return super.setBoolean(n, bl);
    }

    @Override
    public ByteBuf setByte(int n, int n2) {
        this.leak.m4edf77299b();
        return super.setByte(n, n2);
    }

    @Override
    public ByteBuf setShort(int n, int n2) {
        this.leak.m4edf77299b();
        return super.setShort(n, n2);
    }

    @Override
    public ByteBuf setMedium(int n, int n2) {
        this.leak.m4edf77299b();
        return super.setMedium(n, n2);
    }

    @Override
    public ByteBuf setInt(int n, int n2) {
        this.leak.m4edf77299b();
        return super.setInt(n, n2);
    }

    @Override
    public ByteBuf setLong(int n, long l) {
        this.leak.m4edf77299b();
        return super.setLong(n, l);
    }

    @Override
    public ByteBuf setChar(int n, int n2) {
        this.leak.m4edf77299b();
        return super.setChar(n, n2);
    }

    @Override
    public ByteBuf setFloat(int n, float f) {
        this.leak.m4edf77299b();
        return super.setFloat(n, f);
    }

    @Override
    public ByteBuf setDouble(int n, double d) {
        this.leak.m4edf77299b();
        return super.setDouble(n, d);
    }

    @Override
    public ByteBuf setBytes(int n, ByteBuf byteBuf) {
        this.leak.m4edf77299b();
        return super.setBytes(n, byteBuf);
    }

    @Override
    public ByteBuf setBytes(int n, ByteBuf byteBuf, int n2) {
        this.leak.m4edf77299b();
        return super.setBytes(n, byteBuf, n2);
    }

    @Override
    public ByteBuf setBytes(int n, ByteBuf byteBuf, int n2, int n3) {
        this.leak.m4edf77299b();
        return super.setBytes(n, byteBuf, n2, n3);
    }

    @Override
    public ByteBuf setBytes(int n, byte[] byArray) {
        this.leak.m4edf77299b();
        return super.setBytes(n, byArray);
    }

    @Override
    public ByteBuf setBytes(int n, byte[] byArray, int n2, int n3) {
        this.leak.m4edf77299b();
        return super.setBytes(n, byArray, n2, n3);
    }

    @Override
    public ByteBuf setBytes(int n, ByteBuffer byteBuffer) {
        this.leak.m4edf77299b();
        return super.setBytes(n, byteBuffer);
    }

    @Override
    public int setBytes(int n, InputStream inputStream2, int n2) throws IOException {
        this.leak.m4edf77299b();
        return super.setBytes(n, inputStream2, n2);
    }

    @Override
    public int setBytes(int n, ScatteringByteChannel scatteringByteChannel, int n2) throws IOException {
        this.leak.m4edf77299b();
        return super.setBytes(n, scatteringByteChannel, n2);
    }

    @Override
    public ByteBuf setZero(int n, int n2) {
        this.leak.m4edf77299b();
        return super.setZero(n, n2);
    }

    @Override
    public boolean readBoolean() {
        this.leak.m4edf77299b();
        return super.readBoolean();
    }

    @Override
    public byte readByte() {
        this.leak.m4edf77299b();
        return super.readByte();
    }

    @Override
    public short readUnsignedByte() {
        this.leak.m4edf77299b();
        return super.readUnsignedByte();
    }

    @Override
    public short readShort() {
        this.leak.m4edf77299b();
        return super.readShort();
    }

    @Override
    public int readUnsignedShort() {
        this.leak.m4edf77299b();
        return super.readUnsignedShort();
    }

    @Override
    public int readMedium() {
        this.leak.m4edf77299b();
        return super.readMedium();
    }

    @Override
    public int readUnsignedMedium() {
        this.leak.m4edf77299b();
        return super.readUnsignedMedium();
    }

    @Override
    public int readInt() {
        this.leak.m4edf77299b();
        return super.readInt();
    }

    @Override
    public long readUnsignedInt() {
        this.leak.m4edf77299b();
        return super.readUnsignedInt();
    }

    @Override
    public long readLong() {
        this.leak.m4edf77299b();
        return super.readLong();
    }

    @Override
    public char readChar() {
        this.leak.m4edf77299b();
        return super.readChar();
    }

    @Override
    public float readFloat() {
        this.leak.m4edf77299b();
        return super.readFloat();
    }

    @Override
    public double readDouble() {
        this.leak.m4edf77299b();
        return super.readDouble();
    }

    @Override
    public ByteBuf readBytes(int n) {
        this.leak.m4edf77299b();
        return super.readBytes(n);
    }

    @Override
    public ByteBuf readBytes(ByteBuf byteBuf) {
        this.leak.m4edf77299b();
        return super.readBytes(byteBuf);
    }

    @Override
    public ByteBuf readBytes(ByteBuf byteBuf, int n) {
        this.leak.m4edf77299b();
        return super.readBytes(byteBuf, n);
    }

    @Override
    public ByteBuf readBytes(ByteBuf byteBuf, int n, int n2) {
        this.leak.m4edf77299b();
        return super.readBytes(byteBuf, n, n2);
    }

    @Override
    public ByteBuf readBytes(byte[] byArray) {
        this.leak.m4edf77299b();
        return super.readBytes(byArray);
    }

    @Override
    public ByteBuf readBytes(byte[] byArray, int n, int n2) {
        this.leak.m4edf77299b();
        return super.readBytes(byArray, n, n2);
    }

    @Override
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        this.leak.m4edf77299b();
        return super.readBytes(byteBuffer);
    }

    @Override
    public ByteBuf readBytes(OutputStream outputStream2, int n) throws IOException {
        this.leak.m4edf77299b();
        return super.readBytes(outputStream2, n);
    }

    @Override
    public int readBytes(GatheringByteChannel gatheringByteChannel, int n) throws IOException {
        this.leak.m4edf77299b();
        return super.readBytes(gatheringByteChannel, n);
    }

    @Override
    public ByteBuf skipBytes(int n) {
        this.leak.m4edf77299b();
        return super.skipBytes(n);
    }

    @Override
    public ByteBuf writeBoolean(boolean bl) {
        this.leak.m4edf77299b();
        return super.writeBoolean(bl);
    }

    @Override
    public ByteBuf writeByte(int n) {
        this.leak.m4edf77299b();
        return super.writeByte(n);
    }

    @Override
    public ByteBuf writeShort(int n) {
        this.leak.m4edf77299b();
        return super.writeShort(n);
    }

    @Override
    public ByteBuf writeMedium(int n) {
        this.leak.m4edf77299b();
        return super.writeMedium(n);
    }

    @Override
    public ByteBuf writeInt(int n) {
        this.leak.m4edf77299b();
        return super.writeInt(n);
    }

    @Override
    public ByteBuf writeLong(long l) {
        this.leak.m4edf77299b();
        return super.writeLong(l);
    }

    @Override
    public ByteBuf writeChar(int n) {
        this.leak.m4edf77299b();
        return super.writeChar(n);
    }

    @Override
    public ByteBuf writeFloat(float f) {
        this.leak.m4edf77299b();
        return super.writeFloat(f);
    }

    @Override
    public ByteBuf writeDouble(double d) {
        this.leak.m4edf77299b();
        return super.writeDouble(d);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.leak.m4edf77299b();
        return super.writeBytes(byteBuf);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf byteBuf, int n) {
        this.leak.m4edf77299b();
        return super.writeBytes(byteBuf, n);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf byteBuf, int n, int n2) {
        this.leak.m4edf77299b();
        return super.writeBytes(byteBuf, n, n2);
    }

    @Override
    public ByteBuf writeBytes(byte[] byArray) {
        this.leak.m4edf77299b();
        return super.writeBytes(byArray);
    }

    @Override
    public ByteBuf writeBytes(byte[] byArray, int n, int n2) {
        this.leak.m4edf77299b();
        return super.writeBytes(byArray, n, n2);
    }

    @Override
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.leak.m4edf77299b();
        return super.writeBytes(byteBuffer);
    }

    @Override
    public int writeBytes(InputStream inputStream2, int n) throws IOException {
        this.leak.m4edf77299b();
        return super.writeBytes(inputStream2, n);
    }

    @Override
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int n) throws IOException {
        this.leak.m4edf77299b();
        return super.writeBytes(scatteringByteChannel, n);
    }

    @Override
    public ByteBuf writeZero(int n) {
        this.leak.m4edf77299b();
        return super.writeZero(n);
    }

    @Override
    public int indexOf(int n, int n2, byte by) {
        this.leak.m4edf77299b();
        return super.indexOf(n, n2, by);
    }

    @Override
    public int bytesBefore(byte by) {
        this.leak.m4edf77299b();
        return super.bytesBefore(by);
    }

    @Override
    public int bytesBefore(int n, byte by) {
        this.leak.m4edf77299b();
        return super.bytesBefore(n, by);
    }

    @Override
    public int bytesBefore(int n, int n2, byte by) {
        this.leak.m4edf77299b();
        return super.bytesBefore(n, n2, by);
    }

    @Override
    public int forEachByte(ByteBufProcessor byteBufProcessor) {
        this.leak.m4edf77299b();
        return super.forEachByte(byteBufProcessor);
    }

    @Override
    public int forEachByte(int n, int n2, ByteBufProcessor byteBufProcessor) {
        this.leak.m4edf77299b();
        return super.forEachByte(n, n2, byteBufProcessor);
    }

    @Override
    public int forEachByteDesc(ByteBufProcessor byteBufProcessor) {
        this.leak.m4edf77299b();
        return super.forEachByteDesc(byteBufProcessor);
    }

    @Override
    public int forEachByteDesc(int n, int n2, ByteBufProcessor byteBufProcessor) {
        this.leak.m4edf77299b();
        return super.forEachByteDesc(n, n2, byteBufProcessor);
    }

    @Override
    public ByteBuf copy() {
        this.leak.m4edf77299b();
        return super.copy();
    }

    @Override
    public ByteBuf copy(int n, int n2) {
        this.leak.m4edf77299b();
        return super.copy(n, n2);
    }

    @Override
    public int nioBufferCount() {
        this.leak.m4edf77299b();
        return super.nioBufferCount();
    }

    @Override
    public ByteBuffer nioBuffer() {
        this.leak.m4edf77299b();
        return super.nioBuffer();
    }

    @Override
    public ByteBuffer nioBuffer(int n, int n2) {
        this.leak.m4edf77299b();
        return super.nioBuffer(n, n2);
    }

    @Override
    public ByteBuffer[] nioBuffers() {
        this.leak.m4edf77299b();
        return super.nioBuffers();
    }

    @Override
    public ByteBuffer[] nioBuffers(int n, int n2) {
        this.leak.m4edf77299b();
        return super.nioBuffers(n, n2);
    }

    @Override
    public ByteBuffer internalNioBuffer(int n, int n2) {
        this.leak.m4edf77299b();
        return super.internalNioBuffer(n, n2);
    }

    @Override
    public String toString(Charset charset) {
        this.leak.m4edf77299b();
        return super.toString(charset);
    }

    @Override
    public String toString(int n, int n2, Charset charset) {
        this.leak.m4edf77299b();
        return super.toString(n, n2, charset);
    }

    @Override
    public ByteBuf retain() {
        this.leak.m4edf77299b();
        return super.retain();
    }

    @Override
    public ByteBuf retain(int n) {
        this.leak.m4edf77299b();
        return super.retain(n);
    }

    @Override
    public ByteBuf capacity(int n) {
        this.leak.m4edf77299b();
        return super.capacity(n);
    }
}

