/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHttpRequest;

@NotThreadSafe
public class BasicHttpEntityEnclosingRequest
extends BasicHttpRequest
implements HttpEntityEnclosingRequest {
    private HttpEntity entity;

    public BasicHttpEntityEnclosingRequest(String string, String string2) {
        super(string, string2);
    }

    public BasicHttpEntityEnclosingRequest(String string, String string2, ProtocolVersion protocolVersion) {
        super(string, string2, protocolVersion);
    }

    public BasicHttpEntityEnclosingRequest(RequestLine requestLine) {
        super(requestLine);
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
    }

    public boolean expectContinue() {
        Header header = this.getFirstHeader("Expect");
        return header != null && "100-continue".equalsIgnoreCase(header.getValue());
    }
}

