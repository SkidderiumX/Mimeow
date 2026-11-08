/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.util.CharsetUtil;

public class ContinuationWebSocketFrame
extends WebSocketFrame {
    public ContinuationWebSocketFrame() {
        this(Unpooled.buffer(0));
    }

    public ContinuationWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public ContinuationWebSocketFrame(boolean bl, int n, ByteBuf byteBuf) {
        super(bl, n, byteBuf);
    }

    public ContinuationWebSocketFrame(boolean bl, int n, String string) {
        this(bl, n, ContinuationWebSocketFrame.fromText(string));
    }

    public String text() {
        return this.content().toString(CharsetUtil.UTF_8);
    }

    private static ByteBuf fromText(String string) {
        if (string == null || string.isEmpty()) {
            return Unpooled.EMPTY_BUFFER;
        }
        return Unpooled.copiedBuffer(string, CharsetUtil.UTF_8);
    }

    @Override
    public ContinuationWebSocketFrame copy() {
        return new ContinuationWebSocketFrame(this.isFinalFragment(), this.rsv(), this.content().copy());
    }

    @Override
    public ContinuationWebSocketFrame duplicate() {
        return new ContinuationWebSocketFrame(this.isFinalFragment(), this.rsv(), this.content().duplicate());
    }

    @Override
    public ContinuationWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override
    public ContinuationWebSocketFrame retain(int n) {
        super.retain(n);
        return this;
    }
}

