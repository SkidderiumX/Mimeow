/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.LastHttpContent;

public class ComposedLastHttpContent
implements LastHttpContent {
    private final HttpHeaders trailingHeaders;
    private DecoderResult result;

    ComposedLastHttpContent(HttpHeaders httpHeaders) {
        this.trailingHeaders = httpHeaders;
    }

    @Override
    public HttpHeaders trailingHeaders() {
        return this.trailingHeaders;
    }

    @Override
    public LastHttpContent copy() {
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.trailingHeaders().set(this.trailingHeaders());
        return defaultLastHttpContent;
    }

    @Override
    public LastHttpContent retain(int n) {
        return this;
    }

    @Override
    public LastHttpContent retain() {
        return this;
    }

    @Override
    public HttpContent duplicate() {
        return this.copy();
    }

    @Override
    public ByteBuf content() {
        return Unpooled.EMPTY_BUFFER;
    }

    @Override
    public DecoderResult getDecoderResult() {
        return this.result;
    }

    @Override
    public void setDecoderResult(DecoderResult decoderResult) {
        this.result = decoderResult;
    }

    @Override
    public int refCnt() {
        return 1;
    }

    @Override
    public boolean release() {
        return false;
    }

    @Override
    public boolean release(int n) {
        return false;
    }
}

