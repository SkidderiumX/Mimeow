/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpRequestBase;

@NotThreadSafe
public class HttpGet
extends HttpRequestBase {
    public static final String METHOD_NAME = "GET";

    public HttpGet() {
    }

    public HttpGet(URI uRI) {
        this.setURI(uRI);
    }

    public HttpGet(String string) {
        this.setURI(URI.create(string));
    }

    public String getMethod() {
        return METHOD_NAME;
    }
}

