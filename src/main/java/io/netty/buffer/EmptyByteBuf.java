/*
 * Decompiled with CFR 0.152.
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public class EmptyByteBuf
extends ByteBuf {
    private static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.allocateDirect(0);
    private static final long EMPTY_BYTE_BUFFER_ADDRESS;
    private final ByteBufAllocator alloc;
    private final ByteOrder order;
    private final String str;
    private EmptyByteBuf swapped;

    public EmptyByteBuf(ByteBufAllocator byteBufAllocator) {
        this(byteBufAllocator, ByteOrder.BIG_ENDIAN);
    }

    private EmptyByteBuf(ByteBufAllocator byteBufAllocator, ByteOrder byteOrder) {
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        this.alloc = byteBufAllocator;
        this.order = byteOrder;
        this.str = StringUtil.simpleClassName(this) + (byteOrder == ByteOrder.BIG_ENDIAN ? "BE" : "LE");
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public ByteBuf capacity(int n) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override
    public ByteOrder order() {
        return this.order;
    }

    @Override
    public ByteBuf unwrap() {
        return null;
    }

    @Override
    public boolean isDirect() {
        return true;
    }

    @Override
    public int maxCapacity() {
        return 0;
    }

    @Override
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == this.order()) {
            return this;
        }
        EmptyByteBuf emptyByteBuf = this.swapped;
        if (emptyByteBuf != null) {
            return emptyByteBuf;
        }
        this.swapped = emptyByteBuf = new EmptyByteBuf(this.alloc(), byteOrder);
        return emptyByteBuf;
    }

    @Override
    public int readerIndex() {
        return 0;
    }

    @Override
    public ByteBuf readerIndex(int n) {
        return this.checkIndex(n);
    }

    @Override
    public int writerIndex() {
        return 0;
    }

    @Override
    public ByteBuf writerIndex(int n) {
        return this.checkIndex(n);
    }

    @Override
    public ByteBuf setIndex(int n, int n2) {
        this.checkIndex(n);
        this.checkIndex(n2);
        return this;
    }

    @Override
    public int readableBytes() {
        return 0;
    }

    @Override
    public int writableBytes() {
        return 0;
    }

    @Override
    public int maxWritableBytes() {
        return 0;
    }

    @Override
    public boolean isReadable() {
        return false;
    }

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public ByteBuf clear() {
        return this;
    }

    @Override
    public ByteBuf markReaderIndex() {
        return this;
    }

    @Override
    public ByteBuf resetReaderIndex() {
        return this;
    }

    @Override
    public ByteBuf markWriterIndex() {
        return this;
    }

    @Override
    public ByteBuf resetWriterIndex() {
        return this;
    }

    @Override
    public ByteBuf discardReadBytes() {
        return this;
    }

    @Override
    public ByteBuf discardSomeReadBytes() {
        return this;
    }

    @Override
    public ByteBuf ensureWritable(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("minWritableBytes: " + n + " (expected: >= 0)");
        }
        if (n != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    @Override
    public int ensureWritable(int n, boolean bl) {
        if (n < 0) {
            throw new IllegalArgumentException("minWritableBytes: " + n + " (expected: >= 0)");
        }
        if (n == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public boolean getBoolean(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public byte getByte(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public short getUnsignedByte(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public short getShort(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getUnsignedShort(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getMedium(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getUnsignedMedium(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getInt(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public long getUnsignedInt(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public long getLong(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public char getChar(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public float getFloat(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public double getDouble(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf getBytes(int n, ByteBuf byteBuf) {
        return this.checkIndex(n, byteBuf.writableBytes());
    }

    @Override
    public ByteBuf getBytes(int n, ByteBuf byteBuf, int n2) {
        return this.checkIndex(n, n2);
    }

    @Override
    public ByteBuf getBytes(int n, ByteBuf byteBuf, int n2, int n3) {
        return this.checkIndex(n, n3);
    }

    @Override
    public ByteBuf getBytes(int n, byte[] byArray) {
        return this.checkIndex(n, byArray.length);
    }

    @Override
    public ByteBuf getBytes(int n, byte[] byArray, int n2, int n3) {
        return this.checkIndex(n, n3);
    }

    @Override
    public ByteBuf getBytes(int n, ByteBuffer byteBuffer) {
        return this.checkIndex(n, byteBuffer.remaining());
    }

    @Override
    public ByteBuf getBytes(int n, OutputStream outputStream2, int n2) {
        return this.checkIndex(n, n2);
    }

    @Override
    public int getBytes(int n, GatheringByteChannel gatheringByteChannel, int n2) {
        this.checkIndex(n, n2);
        return 0;
    }

    @Override
    public ByteBuf setBoolean(int n, boolean bl) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setByte(int n, int n2) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setShort(int n, int n2) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setMedium(int n, int n2) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setInt(int n, int n2) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setLong(int n, long l) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setChar(int n, int n2) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setFloat(int n, float f) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setDouble(int n, double d) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setBytes(int n, ByteBuf byteBuf) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf setBytes(int n, ByteBuf byteBuf, int n2) {
        return this.checkIndex(n, n2);
    }

    @Override
    public ByteBuf setBytes(int n, ByteBuf byteBuf, int n2, int n3) {
        return this.checkIndex(n, n3);
    }

    @Override
    public ByteBuf setBytes(int n, byte[] byArray) {
        return this.checkIndex(n, byArray.length);
    }

    @Override
    public ByteBuf setBytes(int n, byte[] byArray, int n2, int n3) {
        return this.checkIndex(n, n3);
    }

    @Override
    public ByteBuf setBytes(int n, ByteBuffer byteBuffer) {
        return this.checkIndex(n, byteBuffer.remaining());
    }

    @Override
    public int setBytes(int n, InputStream inputStream2, int n2) {
        this.checkIndex(n, n2);
        return 0;
    }

    @Override
    public int setBytes(int n, ScatteringByteChannel scatteringByteChannel, int n2) {
        this.checkIndex(n, n2);
        return 0;
    }

    @Override
    public ByteBuf setZero(int n, int n2) {
        return this.checkIndex(n, n2);
    }

    @Override
    public boolean readBoolean() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public byte readByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public short readUnsignedByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public short readShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int readUnsignedShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int readMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int readUnsignedMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int readInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public long readUnsignedInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public long readLong() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public char readChar() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public float readFloat() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public double readDouble() {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf readBytes(int n) {
        return this.checkLength(n);
    }

    @Override
    public ByteBuf readSlice(int n) {
        return this.checkLength(n);
    }

    @Override
    public ByteBuf readBytes(ByteBuf byteBuf) {
        return this.checkLength(byteBuf.writableBytes());
    }

    @Override
    public ByteBuf readBytes(ByteBuf byteBuf, int n) {
        return this.checkLength(n);
    }

    @Override
    public ByteBuf readBytes(ByteBuf byteBuf, int n, int n2) {
        return this.checkLength(n2);
    }

    @Override
    public ByteBuf readBytes(byte[] byArray) {
        return this.checkLength(byArray.length);
    }

    @Override
    public ByteBuf readBytes(byte[] byArray, int n, int n2) {
        return this.checkLength(n2);
    }

    @Override
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        return this.checkLength(byteBuffer.remaining());
    }

    @Override
    public ByteBuf readBytes(OutputStream outputStream2, int n) {
        return this.checkLength(n);
    }

    @Override
    public int readBytes(GatheringByteChannel gatheringByteChannel, int n) {
        this.checkLength(n);
        return 0;
    }

    @Override
    public ByteBuf skipBytes(int n) {
        return this.checkLength(n);
    }

    @Override
    public ByteBuf writeBoolean(boolean bl) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeByte(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeShort(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeMedium(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeInt(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeLong(long l) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeChar(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeFloat(float f) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeDouble(double d) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ByteBuf writeBytes(ByteBuf byteBuf, int n) {
        return this.checkLength(n);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf byteBuf, int n, int n2) {
        return this.checkLength(n2);
    }

    @Override
    public ByteBuf writeBytes(byte[] byArray) {
        return this.checkLength(byArray.length);
    }

    @Override
    public ByteBuf writeBytes(byte[] byArray, int n, int n2) {
        return this.checkLength(n2);
    }

    @Override
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        return this.checkLength(byteBuffer.remaining());
    }

    @Override
    public int writeBytes(InputStream inputStream2, int n) {
        this.checkLength(n);
        return 0;
    }

    @Override
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int n) {
        this.checkLength(n);
        return 0;
    }

    @Override
    public ByteBuf writeZero(int n) {
        return this.checkLength(n);
    }

    @Override
    public int indexOf(int n, int n2, byte by) {
        this.checkIndex(n);
        this.checkIndex(n2);
        return -1;
    }

    @Override
    public int bytesBefore(byte by) {
        return -1;
    }

    @Override
    public int bytesBefore(int n, byte by) {
        this.checkLength(n);
        return -1;
    }

    @Override
    public int bytesBefore(int n, int n2, byte by) {
        this.checkIndex(n, n2);
        return -1;
    }

    @Override
    public int forEachByte(ByteBufProcessor byteBufProcessor) {
        return -1;
    }

    @Override
    public int forEachByte(int n, int n2, ByteBufProcessor byteBufProcessor) {
        this.checkIndex(n, n2);
        return -1;
    }

    @Override
    public int forEachByteDesc(ByteBufProcessor byteBufProcessor) {
        return -1;
    }

    @Override
    public int forEachByteDesc(int n, int n2, ByteBufProcessor byteBufProcessor) {
        this.checkIndex(n, n2);
        return -1;
    }

    @Override
    public ByteBuf copy() {
        return this;
    }

    @Override
    public ByteBuf copy(int n, int n2) {
        return this.checkIndex(n, n2);
    }

    @Override
    public ByteBuf slice() {
        return this;
    }

    @Override
    public ByteBuf slice(int n, int n2) {
        return this.checkIndex(n, n2);
    }

    @Override
    public ByteBuf duplicate() {
        return this;
    }

    @Override
    public int nioBufferCount() {
        return 1;
    }

    @Override
    public ByteBuffer nioBuffer() {
        return EMPTY_BYTE_BUFFER;
    }

    @Override
    public ByteBuffer nioBuffer(int n, int n2) {
        this.checkIndex(n, n2);
        return this.nioBuffer();
    }

    @Override
    public ByteBuffer[] nioBuffers() {
        return new ByteBuffer[]{EMPTY_BYTE_BUFFER};
    }

    @Override
    public ByteBuffer[] nioBuffers(int n, int n2) {
        this.checkIndex(n, n2);
        return this.nioBuffers();
    }

    @Override
    public ByteBuffer internalNioBuffer(int n, int n2) {
        return EMPTY_BYTE_BUFFER;
    }

    @Override
    public boolean hasArray() {
        return true;
    }

    @Override
    public byte[] array() {
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override
    public int arrayOffset() {
        return 0;
    }

    @Override
    public boolean hasMemoryAddress() {
        return EMPTY_BYTE_BUFFER_ADDRESS != 0L;
    }

    @Override
    public long memoryAddress() {
        if (this.hasMemoryAddress()) {
            return EMPTY_BYTE_BUFFER_ADDRESS;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString(Charset charset) {
        return "";
    }

    @Override
    public String toString(int n, int n2, Charset charset) {
        this.checkIndex(n, n2);
        return this.toString(charset);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof ByteBuf && !((ByteBuf)object).isReadable();
    }

    @Override
    public int compareTo(ByteBuf byteBuf) {
        return byteBuf.isReadable() ? -1 : 0;
    }

    @Override
    public String toString() {
        return this.str;
    }

    @Override
    public boolean isReadable(int n) {
        return false;
    }

    @Override
    public boolean isWritable(int n) {
        return false;
    }

    @Override
    public int refCnt() {
        return 1;
    }

    @Override
    public ByteBuf retain() {
        return this;
    }

    @Override
    public ByteBuf retain(int n) {
        return this;
    }

    @Override
    public boolean release() {
        return false;
    }

    @Override
    public boolean release(int n) {
        return false;
    }

    private ByteBuf checkIndex(int n) {
        if (n != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private ByteBuf checkIndex(int n, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("length: " + n2);
        }
        if (n != 0 || n2 != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private ByteBuf checkLength(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("length: " + n + " (expected: >= 0)");
        }
        if (n != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    static {
        long l = 0L;
        try {
            if (PlatformDependent.hasUnsafe()) {
                l = PlatformDependent.directBufferAddress(EMPTY_BYTE_BUFFER);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        EMPTY_BYTE_BUFFER_ADDRESS = l;
    }
}

