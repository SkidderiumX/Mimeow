/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryUtil;

public class IOUtil {
    private IOUtil() {
    }

    private static ByteBuffer resizeBuffer(ByteBuffer byteBuffer, int n) {
        ByteBuffer byteBuffer2 = BufferUtils.createByteBuffer(n);
        byteBuffer.flip();
        byteBuffer2.put(byteBuffer);
        return byteBuffer2;
    }

    public static ByteBuffer ioResourceToByteBuffer(String string, int n) throws IOException {
        ByteBuffer byteBuffer;
        Path path = Paths.get(string, new String[0]);
        if (Files.isReadable(path)) {
            try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(path, new OpenOption[0]);){
                byteBuffer = BufferUtils.createByteBuffer((int)seekableByteChannel.size() + 1);
                while (seekableByteChannel.read(byteBuffer) != -1) {
                }
            }
        }
        try (InputStream inputStream2 = IOUtil.class.getClassLoader().getResourceAsStream(string);
             ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream2);){
            int n2;
            byteBuffer = BufferUtils.createByteBuffer(n);
            while ((n2 = readableByteChannel.read(byteBuffer)) != -1) {
                if (byteBuffer.remaining() != 0) continue;
                byteBuffer = IOUtil.resizeBuffer(byteBuffer, byteBuffer.capacity() * 3 / 2);
            }
        }
        byteBuffer.flip();
        return MemoryUtil.memSlice(byteBuffer);
    }
}

