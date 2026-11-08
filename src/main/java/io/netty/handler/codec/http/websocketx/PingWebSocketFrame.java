/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public class PingWebSocketFrame
extends WebSocketFrame {
    public PingWebSocketFrame() {
        super(true, 0, Unpooled.buffer(0));
    }

    public PingWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public PingWebSocketFrame(boolean bl, int n, ByteBuf byteBuf) {
        super(bl, n, byteBuf);
    }

    @Override
    public PingWebSocketFrame copy() {
        return new PingWebSocketFrame(this.isFinalFragment(), this.rsv(), this.content().copy());
    }

    @Override
    public PingWebSocketFrame duplicate() {
        return new PingWebSocketFrame(this.isFinalFragment(), this.rsv(), this.content().duplicate());
    }

    @Override
    public PingWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override
    public PingWebSocketFrame retain(int n) {
        super.retain(n);
        return this;
    }
}

