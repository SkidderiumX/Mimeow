/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.CharsetUtil;
import java.util.HashMap;
import java.util.Map;

public class HttpMethod
implements Comparable<HttpMethod> {
    public static final HttpMethod OPTIONS = new HttpMethod("OPTIONS", true);
    public static final HttpMethod GET = new HttpMethod("GET", true);
    public static final HttpMethod HEAD = new HttpMethod("HEAD", true);
    public static final HttpMethod POST = new HttpMethod("POST", true);
    public static final HttpMethod PUT = new HttpMethod("PUT", true);
    public static final HttpMethod PATCH = new HttpMethod("PATCH", true);
    public static final HttpMethod DELETE = new HttpMethod("DELETE", true);
    public static final HttpMethod TRACE = new HttpMethod("TRACE", true);
    public static final HttpMethod CONNECT = new HttpMethod("CONNECT", true);
    private static final Map<String, HttpMethod> methodMap = new HashMap<String, HttpMethod>();
    private final String name;
    private final byte[] bytes;

    public static HttpMethod valueOf(String string) {
        if (string == null) {
            throw new NullPointerException("name");
        }
        if ((string = string.trim()).isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        HttpMethod httpMethod = methodMap.get(string);
        if (httpMethod != null) {
            return httpMethod;
        }
        return new HttpMethod(string);
    }

    public HttpMethod(String string) {
        this(string, false);
    }

    private HttpMethod(String string, boolean bl) {
        if (string == null) {
            throw new NullPointerException("name");
        }
        if ((string = string.trim()).isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        for (int i = 0; i < string.length(); ++i) {
            if (!Character.isISOControl(string.charAt(i)) && !Character.isWhitespace(string.charAt(i))) continue;
            throw new IllegalArgumentException("invalid character in name");
        }
        this.name = string;
        this.bytes = (byte[])(bl ? string.getBytes(CharsetUtil.US_ASCII) : null);
    }

    public String name() {
        return this.name;
    }

    public int hashCode() {
        return this.name().hashCode();
    }

    public boolean equals(Object object) {
        if (!(object instanceof HttpMethod)) {
            return false;
        }
        HttpMethod httpMethod = (HttpMethod)object;
        return this.name().equals(httpMethod.name());
    }

    public String toString() {
        return this.name();
    }

    @Override
    public int compareTo(HttpMethod httpMethod) {
        return this.name().compareTo(httpMethod.name());
    }

    void encode(ByteBuf byteBuf) {
        if (this.bytes == null) {
            HttpHeaders.encodeAscii0(this.name, byteBuf);
        } else {
            byteBuf.writeBytes(this.bytes);
        }
    }

    static {
        methodMap.put(OPTIONS.toString(), OPTIONS);
        methodMap.put(GET.toString(), GET);
        methodMap.put(HEAD.toString(), HEAD);
        methodMap.put(POST.toString(), POST);
        methodMap.put(PUT.toString(), PUT);
        methodMap.put(PATCH.toString(), PATCH);
        methodMap.put(DELETE.toString(), DELETE);
        methodMap.put(TRACE.toString(), TRACE);
        methodMap.put(CONNECT.toString(), CONNECT);
    }
}

