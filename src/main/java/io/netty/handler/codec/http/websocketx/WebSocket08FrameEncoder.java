/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrameEncoder;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.List;

public class WebSocket08FrameEncoder
extends MessageToMessageEncoder<WebSocketFrame>
implements WebSocketFrameEncoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocket08FrameEncoder.class);
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_TEXT = 1;
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private final boolean maskPayload;

    public WebSocket08FrameEncoder(boolean bl) {
        this.maskPayload = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        int n;
        ByteBuf byteBuf = webSocketFrame.content();
        if (webSocketFrame instanceof TextWebSocketFrame) {
            n = 1;
        } else if (webSocketFrame instanceof PingWebSocketFrame) {
            n = 9;
        } else if (webSocketFrame instanceof PongWebSocketFrame) {
            n = 10;
        } else if (webSocketFrame instanceof CloseWebSocketFrame) {
            n = 8;
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            n = 2;
        } else if (webSocketFrame instanceof ContinuationWebSocketFrame) {
            n = 0;
        } else {
            throw new UnsupportedOperationException("Cannot encode frame of type: " + webSocketFrame.getClass().getName());
        }
        int n2 = byteBuf.readableBytes();
        if (logger.isDebugEnabled()) {
            logger.debug("Encoding WebSocket Frame opCode=" + n + " length=" + n2);
        }
        int n3 = 0;
        if (webSocketFrame.isFinalFragment()) {
            n3 |= 0x80;
        }
        n3 |= webSocketFrame.rsv() % 8 << 4;
        n3 |= n % 128;
        if (n == 9 && n2 > 125) {
            throw new TooLongFrameException("invalid payload for PING (payload length must be <= 125, was " + n2);
        }
        boolean bl = true;
        ReferenceCounted referenceCounted = null;
        try {
            int n4;
            int n5;
            int n6;
            int n7 = n6 = this.maskPayload ? 4 : 0;
            if (n2 <= 125) {
                n5 = 2 + n6;
                if (this.maskPayload) {
                    n5 += n2;
                }
                referenceCounted = channelHandlerContext.alloc().buffer(n5);
                ((ByteBuf)referenceCounted).writeByte(n3);
                n4 = this.maskPayload ? (byte)(0x80 | (byte)n2) : (byte)n2;
                ((ByteBuf)referenceCounted).writeByte(n4);
            } else if (n2 <= 65535) {
                n5 = 4 + n6;
                if (this.maskPayload) {
                    n5 += n2;
                }
                referenceCounted = channelHandlerContext.alloc().buffer(n5);
                ((ByteBuf)referenceCounted).writeByte(n3);
                ((ByteBuf)referenceCounted).writeByte(this.maskPayload ? 254 : 126);
                ((ByteBuf)referenceCounted).writeByte(n2 >>> 8 & 0xFF);
                ((ByteBuf)referenceCounted).writeByte(n2 & 0xFF);
            } else {
                n5 = 10 + n6;
                if (this.maskPayload) {
                    n5 += n2;
                }
                referenceCounted = channelHandlerContext.alloc().buffer(n5);
                ((ByteBuf)referenceCounted).writeByte(n3);
                ((ByteBuf)referenceCounted).writeByte(this.maskPayload ? 255 : 127);
                ((ByteBuf)referenceCounted).writeLong(n2);
            }
            if (this.maskPayload) {
                n5 = (int)(Math.random() * 2.147483647E9);
                byte[] byArray = ByteBuffer.allocate(4).putInt(n5).array();
                ((ByteBuf)referenceCounted).writeBytes(byArray);
                n4 = 0;
                for (int i = byteBuf.readerIndex(); i < byteBuf.writerIndex(); ++i) {
                    byte by = byteBuf.getByte(i);
                    ((ByteBuf)referenceCounted).writeByte(by ^ byArray[n4++ % 4]);
                }
                list.add(referenceCounted);
            } else if (((ByteBuf)referenceCounted).writableBytes() >= byteBuf.readableBytes()) {
                ((ByteBuf)referenceCounted).writeBytes(byteBuf);
                list.add(referenceCounted);
            } else {
                list.add(referenceCounted);
                list.add(byteBuf.retain());
            }
            bl = false;
        }
        finally {
            if (bl && referenceCounted != null) {
                referenceCounted.release();
            }
        }
    }
}

