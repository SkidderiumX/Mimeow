/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.util;

import java.nio.ByteBuffer;

public class ByteBufferUtils {
    private ByteBufferUtils() {
    }

    public static int transferByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int n;
        if (byteBuffer == null || byteBuffer2 == null) {
            throw new IllegalArgumentException();
        }
        int n2 = byteBuffer.remaining();
        if (n2 > (n = byteBuffer2.remaining())) {
            int n3 = Math.min(n2, n);
            byteBuffer.limit(n3);
            byteBuffer2.put(byteBuffer);
            return n3;
        }
        byteBuffer2.put(byteBuffer);
        return n2;
    }

    public static ByteBuffer getEmptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }
}

