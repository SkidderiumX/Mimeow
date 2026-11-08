/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.HeaderGroup;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@NotThreadSafe
public abstract class AbstractHttpMessage
implements HttpMessage {
    protected HeaderGroup headergroup = new HeaderGroup();
    @Deprecated
    protected HttpParams params;

    @Deprecated
    protected AbstractHttpMessage(HttpParams httpParams) {
        this.params = httpParams;
    }

    protected AbstractHttpMessage() {
        this(null);
    }

    public boolean containsHeader(String string) {
        return this.headergroup.containsHeader(string);
    }

    public Header[] getHeaders(String string) {
        return this.headergroup.getHeaders(string);
    }

    public Header getFirstHeader(String string) {
        return this.headergroup.getFirstHeader(string);
    }

    public Header getLastHeader(String string) {
        return this.headergroup.getLastHeader(string);
    }

    public Header[] getAllHeaders() {
        return this.headergroup.getAllHeaders();
    }

    public void addHeader(Header header) {
        this.headergroup.addHeader(header);
    }

    public void addHeader(String string, String string2) {
        Args.notNull(string, "Header name");
        this.headergroup.addHeader(new BasicHeader(string, string2));
    }

    public void setHeader(Header header) {
        this.headergroup.updateHeader(header);
    }

    public void setHeader(String string, String string2) {
        Args.notNull(string, "Header name");
        this.headergroup.updateHeader(new BasicHeader(string, string2));
    }

    public void setHeaders(Header[] headerArray) {
        this.headergroup.setHeaders(headerArray);
    }

    public void removeHeader(Header header) {
        this.headergroup.removeHeader(header);
    }

    public void removeHeaders(String string) {
        if (string == null) {
            return;
        }
        HeaderIterator headerIterator = this.headergroup.iterator();
        while (headerIterator.hasNext()) {
            Header header = headerIterator.nextHeader();
            if (!string.equalsIgnoreCase(header.getName())) continue;
            headerIterator.remove();
        }
    }

    public HeaderIterator headerIterator() {
        return this.headergroup.iterator();
    }

    public HeaderIterator headerIterator(String string) {
        return this.headergroup.iterator(string);
    }

    @Deprecated
    public HttpParams getParams() {
        if (this.params == null) {
            this.params = new BasicHttpParams();
        }
        return this.params;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = Args.notNull(httpParams, "HTTP parameters");
    }
}

