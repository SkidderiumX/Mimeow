/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class DefaultFullHttpRequest
extends DefaultHttpRequest
implements FullHttpRequest {
    private final ByteBuf content;
    private final HttpHeaders trailingHeader;
    private final boolean validateHeaders;

    public DefaultFullHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String string) {
        this(httpVersion, httpMethod, string, Unpooled.buffer(0));
    }

    public DefaultFullHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String string, ByteBuf byteBuf) {
        this(httpVersion, httpMethod, string, byteBuf, true);
    }

    public DefaultFullHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String string, ByteBuf byteBuf, boolean bl) {
        super(httpVersion, httpMethod, string, bl);
        if (byteBuf == null) {
            throw new NullPointerException("content");
        }
        this.content = byteBuf;
        this.trailingHeader = new DefaultHttpHeaders(bl);
        this.validateHeaders = bl;
    }

    @Override
    public HttpHeaders trailingHeaders() {
        return this.trailingHeader;
    }

    @Override
    public ByteBuf content() {
        return this.content;
    }

    @Override
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override
    public FullHttpRequest retain() {
        this.content.retain();
        return this;
    }

    @Override
    public FullHttpRequest retain(int n) {
        this.content.retain(n);
        return this;
    }

    @Override
    public boolean release() {
        return this.content.release();
    }

    @Override
    public boolean release(int n) {
        return this.content.release(n);
    }

    @Override
    public FullHttpRequest setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    @Override
    public FullHttpRequest setMethod(HttpMethod httpMethod) {
        super.setMethod(httpMethod);
        return this;
    }

    @Override
    public FullHttpRequest setUri(String string) {
        super.setUri(string);
        return this;
    }

    @Override
    public FullHttpRequest copy() {
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(this.getProtocolVersion(), this.getMethod(), this.getUri(), this.content().copy(), this.validateHeaders);
        defaultFullHttpRequest.headers().set(this.headers());
        defaultFullHttpRequest.trailingHeaders().set(this.trailingHeaders());
        return defaultFullHttpRequest;
    }

    @Override
    public FullHttpRequest duplicate() {
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(this.getProtocolVersion(), this.getMethod(), this.getUri(), this.content().duplicate(), this.validateHeaders);
        defaultFullHttpRequest.headers().set(this.headers());
        defaultFullHttpRequest.trailingHeaders().set(this.trailingHeaders());
        return defaultFullHttpRequest;
    }
}

