/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.enums.Role;

public class SocketChannelIOHelper {
    private SocketChannelIOHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean read(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, ByteChannel byteChannel) throws IOException {
        byteBuffer.clear();
        int n = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (n == -1) {
            webSocketImpl.eot();
            return false;
        }
        return n != 0;
    }

    public static boolean readMore(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, WrappedByteChannel wrappedByteChannel) throws IOException {
        byteBuffer.clear();
        int n = wrappedByteChannel.readMore(byteBuffer);
        byteBuffer.flip();
        if (n == -1) {
            webSocketImpl.eot();
            return false;
        }
        return wrappedByteChannel.isNeedRead();
    }

    public static boolean batch(WebSocketImpl webSocketImpl, ByteChannel byteChannel) throws IOException {
        if (webSocketImpl == null) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer)webSocketImpl.outQueue.peek();
        WrappedByteChannel wrappedByteChannel = null;
        if (byteBuffer == null) {
            if (byteChannel instanceof WrappedByteChannel && (wrappedByteChannel = (WrappedByteChannel)byteChannel).isNeedWrite()) {
                wrappedByteChannel.writeMore();
            }
        } else {
            do {
                byteChannel.write(byteBuffer);
                if (byteBuffer.remaining() > 0) {
                    return false;
                }
                webSocketImpl.outQueue.poll();
            } while ((byteBuffer = (ByteBuffer)webSocketImpl.outQueue.peek()) != null);
        }
        if (webSocketImpl.outQueue.isEmpty() && webSocketImpl.isFlushAndClose() && webSocketImpl.getDraft() != null && webSocketImpl.getDraft().getRole() != null && webSocketImpl.getDraft().getRole() == Role.SERVER) {
            webSocketImpl.closeConnection();
        }
        return wrappedByteChannel == null || !((WrappedByteChannel)byteChannel).isNeedWrite();
    }
}

