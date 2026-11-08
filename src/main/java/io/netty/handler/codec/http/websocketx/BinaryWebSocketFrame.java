/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public class BinaryWebSocketFrame
extends WebSocketFrame {
    public BinaryWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    public BinaryWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public BinaryWebSocketFrame(boolean bl, int n, ByteBuf byteBuf) {
        super(bl, n, byteBuf);
    }

    @Override
    public BinaryWebSocketFrame copy() {
        return new BinaryWebSocketFrame(this.isFinalFragment(), this.rsv(), this.content().copy());
    }

    @Override
    public BinaryWebSocketFrame duplicate() {
        return new BinaryWebSocketFrame(this.isFinalFragment(), this.rsv(), this.content().duplicate());
    }

    @Override
    public BinaryWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override
    public BinaryWebSocketFrame retain(int n) {
        super.retain(n);
        return this;
    }
}

