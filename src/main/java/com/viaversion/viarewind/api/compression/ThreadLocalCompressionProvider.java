/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.compression;

import com.velocitypowered.natives.compression.VelocityCompressor;
import com.velocitypowered.natives.compression.VelocityCompressorFactory;
import com.velocitypowered.natives.util.Natives;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ThreadLocalCompressionProvider {
    private static final boolean VELOCITY_NATIVES_AVAILABLE;
    private static final ThreadLocal<Deflater> JAVA_DEFLATER;
    private static final ThreadLocal<Inflater> JAVA_INFLATER;

    private ThreadLocalCompressionProvider() {
    }

    public static void deflate(ByteBuf byteBuf, ByteBuf byteBuf2) throws DataFormatException {
        if (VELOCITY_NATIVES_AVAILABLE) {
            ThreadLocalCompressionProvider.deflateVelocity(byteBuf, byteBuf2);
        } else {
            ThreadLocalCompressionProvider.deflateJava(byteBuf, byteBuf2);
        }
    }

    public static void inflate(ByteBuf byteBuf, ByteBuf byteBuf2, int n) throws DataFormatException {
        if (VELOCITY_NATIVES_AVAILABLE) {
            ThreadLocalCompressionProvider.inflateVelocity(byteBuf, byteBuf2, n);
        } else {
            ThreadLocalCompressionProvider.inflateJava(byteBuf, byteBuf2, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void deflateJava(ByteBuf byteBuf, ByteBuf byteBuf2) throws DataFormatException {
        ByteBuf byteBuf3 = byteBuf;
        if (!byteBuf.hasArray()) {
            byteBuf3 = ByteBufAllocator.DEFAULT.heapBuffer().writeBytes(byteBuf);
        } else {
            byteBuf.retain();
        }
        ByteBuf byteBuf4 = ByteBufAllocator.DEFAULT.heapBuffer();
        try {
            Deflater deflater = JAVA_DEFLATER.get();
            deflater.setInput(byteBuf3.array(), byteBuf3.arrayOffset() + byteBuf3.readerIndex(), byteBuf3.readableBytes());
            deflater.finish();
            while (!deflater.finished()) {
                byteBuf4.ensureWritable(4096);
                byteBuf4.writerIndex(byteBuf4.writerIndex() + deflater.deflate(byteBuf4.array(), byteBuf4.arrayOffset() + byteBuf4.writerIndex(), byteBuf4.writableBytes()));
            }
            byteBuf2.writeBytes(byteBuf4);
        }
        finally {
            byteBuf4.release();
            byteBuf3.release();
            JAVA_DEFLATER.get().reset();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void inflateJava(ByteBuf byteBuf, ByteBuf byteBuf2, int n) throws DataFormatException {
        ByteBuf byteBuf3 = byteBuf;
        if (!byteBuf.hasArray()) {
            byteBuf3 = ByteBufAllocator.DEFAULT.heapBuffer().writeBytes(byteBuf);
        } else {
            byteBuf.retain();
        }
        ByteBuf byteBuf4 = ByteBufAllocator.DEFAULT.heapBuffer(n, n);
        try {
            Inflater inflater = JAVA_INFLATER.get();
            inflater.setInput(byteBuf3.array(), byteBuf3.arrayOffset() + byteBuf3.readerIndex(), byteBuf3.readableBytes());
            byteBuf4.writerIndex(byteBuf4.writerIndex() + inflater.inflate(byteBuf4.array(), byteBuf4.arrayOffset(), n));
            byteBuf2.writeBytes(byteBuf4);
        }
        finally {
            byteBuf4.release();
            byteBuf3.release();
            JAVA_INFLATER.get().reset();
        }
    }

    private static void deflateVelocity(ByteBuf byteBuf, ByteBuf byteBuf2) throws DataFormatException {
        VelocityHolder.deflate(byteBuf, byteBuf2);
    }

    private static void inflateVelocity(ByteBuf byteBuf, ByteBuf byteBuf2, int n) throws DataFormatException {
        VelocityHolder.inflate(byteBuf, byteBuf2, n);
    }

    static {
        boolean bl = false;
        try {
            Class.forName("com.velocitypowered.natives.compression.VelocityCompressor");
            bl = true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        VELOCITY_NATIVES_AVAILABLE = bl;
        JAVA_DEFLATER = ThreadLocal.withInitial(Deflater::new);
        JAVA_INFLATER = ThreadLocal.withInitial(Inflater::new);
    }

    private static final class VelocityHolder {
        private static final ThreadLocal<VelocityCompressor> COMPRESSOR = ThreadLocal.withInitial(() -> ((VelocityCompressorFactory)Natives.compress.get()).create(-1));

        private VelocityHolder() {
        }

        static void deflate(ByteBuf byteBuf, ByteBuf byteBuf2) throws DataFormatException {
            COMPRESSOR.get().deflate(byteBuf, byteBuf2);
        }

        static void inflate(ByteBuf byteBuf, ByteBuf byteBuf2, int n) throws DataFormatException {
            COMPRESSOR.get().inflate(byteBuf, byteBuf2, n);
        }
    }
}

