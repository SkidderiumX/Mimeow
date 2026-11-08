/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

@NotThreadSafe
public class HttpPatch
extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "PATCH";

    public HttpPatch() {
    }

    public HttpPatch(URI uRI) {
        this.setURI(uRI);
    }

    public HttpPatch(String string) {
        this.setURI(URI.create(string));
    }

    public String getMethod() {
        return METHOD_NAME;
    }
}

