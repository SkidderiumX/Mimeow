/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.Args;

@Deprecated
@NotThreadSafe
public class RequestWrapper
extends AbstractHttpMessage
implements HttpUriRequest {
    private final HttpRequest original;
    private URI uri;
    private String method;
    private ProtocolVersion version;
    private int execCount;

    public RequestWrapper(HttpRequest httpRequest) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        this.original = httpRequest;
        this.setParams(httpRequest.getParams());
        this.setHeaders(httpRequest.getAllHeaders());
        if (httpRequest instanceof HttpUriRequest) {
            this.uri = ((HttpUriRequest)httpRequest).getURI();
            this.method = ((HttpUriRequest)httpRequest).getMethod();
            this.version = null;
        } else {
            RequestLine requestLine = httpRequest.getRequestLine();
            try {
                this.uri = new URI(requestLine.getUri());
            }
            catch (URISyntaxException uRISyntaxException) {
                throw new ProtocolException("Invalid request URI: " + requestLine.getUri(), uRISyntaxException);
            }
            this.method = requestLine.getMethod();
            this.version = httpRequest.getProtocolVersion();
        }
        this.execCount = 0;
    }

    public void resetHeaders() {
        this.headergroup.clear();
        this.setHeaders(this.original.getAllHeaders());
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String string) {
        Args.notNull(string, "Method name");
        this.method = string;
    }

    public ProtocolVersion getProtocolVersion() {
        if (this.version == null) {
            this.version = HttpProtocolParams.getVersion(this.getParams());
        }
        return this.version;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    public URI getURI() {
        return this.uri;
    }

    public void setURI(URI uRI) {
        this.uri = uRI;
    }

    public RequestLine getRequestLine() {
        String string = this.getMethod();
        ProtocolVersion protocolVersion = this.getProtocolVersion();
        String string2 = null;
        if (this.uri != null) {
            string2 = this.uri.toASCIIString();
        }
        if (string2 == null || string2.length() == 0) {
            string2 = "/";
        }
        return new BasicRequestLine(string, string2, protocolVersion);
    }

    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public boolean isAborted() {
        return false;
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    public boolean isRepeatable() {
        return true;
    }

    public int getExecCount() {
        return this.execCount;
    }

    public void incrementExecCount() {
        ++this.execCount;
    }
}

