/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

@NotThreadSafe
public class HttpPost
extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "POST";

    public HttpPost() {
    }

    public HttpPost(URI uRI) {
        this.setURI(uRI);
    }

    public HttpPost(String string) {
        this.setURI(URI.create(string));
    }

    public String getMethod() {
        return METHOD_NAME;
    }
}

