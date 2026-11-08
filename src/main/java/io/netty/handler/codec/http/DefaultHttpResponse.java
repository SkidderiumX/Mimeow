/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http;

import io.netty.handler.codec.http.DefaultHttpMessage;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.internal.StringUtil;

public class DefaultHttpResponse
extends DefaultHttpMessage
implements HttpResponse {
    private HttpResponseStatus status;

    public DefaultHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus) {
        this(httpVersion, httpResponseStatus, true);
    }

    public DefaultHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean bl) {
        super(httpVersion, bl);
        if (httpResponseStatus == null) {
            throw new NullPointerException("status");
        }
        this.status = httpResponseStatus;
    }

    @Override
    public HttpResponseStatus getStatus() {
        return this.status;
    }

    @Override
    public HttpResponse setStatus(HttpResponseStatus httpResponseStatus) {
        if (httpResponseStatus == null) {
            throw new NullPointerException("status");
        }
        this.status = httpResponseStatus;
        return this;
    }

    @Override
    public HttpResponse setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtil.simpleClassName(this));
        stringBuilder.append("(decodeResult: ");
        stringBuilder.append(this.getDecoderResult());
        stringBuilder.append(')');
        stringBuilder.append(StringUtil.NEWLINE);
        stringBuilder.append(this.getProtocolVersion().text());
        stringBuilder.append(' ');
        stringBuilder.append(this.getStatus());
        stringBuilder.append(StringUtil.NEWLINE);
        this.appendHeaders(stringBuilder);
        stringBuilder.setLength(stringBuilder.length() - StringUtil.NEWLINE.length());
        return stringBuilder.toString();
    }
}

