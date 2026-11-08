/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.io;

import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntMappedBigList;
import com.viaversion.viaversion.libs.fastutil.io.BinIO;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.NoSuchElementException;

public class BinIO$IntDataNioInputWrapper
implements IntIterator {
    private final ReadableByteChannel channel;
    private final ByteBuffer byteBuffer;
    private final IntBuffer buffer;

    public BinIO$IntDataNioInputWrapper(ReadableByteChannel readableByteChannel, ByteOrder byteOrder) {
        this.channel = readableByteChannel;
        this.byteBuffer = ByteBuffer.allocateDirect(BinIO.BUFFER_SIZE).order(byteOrder);
        this.buffer = this.byteBuffer.asIntBuffer();
        this.buffer.clear().flip();
    }

    @Override
    public boolean hasNext() {
        if (!this.buffer.hasRemaining()) {
            this.byteBuffer.clear();
            try {
                this.channel.read(this.byteBuffer);
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
            this.byteBuffer.flip();
            this.buffer.clear();
            this.buffer.limit(this.byteBuffer.limit() >>> IntMappedBigList.LOG2_BYTES);
        }
        return this.buffer.hasRemaining();
    }

    @Override
    public int nextInt() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.buffer.get();
    }
}

