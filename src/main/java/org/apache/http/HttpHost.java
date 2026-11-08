/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public class HttpHost
implements Cloneable,
Serializable {
    private static final long serialVersionUID = -7529410654042457626L;
    public static final String DEFAULT_SCHEME_NAME = "http";
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;
    protected final InetAddress address;

    public HttpHost(String string, int n, String string2) {
        this.hostname = Args.notBlank(string, "Host name");
        this.lcHostname = string.toLowerCase(Locale.ENGLISH);
        this.schemeName = string2 != null ? string2.toLowerCase(Locale.ENGLISH) : DEFAULT_SCHEME_NAME;
        this.port = n;
        this.address = null;
    }

    public HttpHost(String string, int n) {
        this(string, n, null);
    }

    public HttpHost(String string) {
        this(string, -1, null);
    }

    public HttpHost(InetAddress inetAddress, int n, String string) {
        this.address = Args.notNull(inetAddress, "Inet address");
        this.hostname = inetAddress.getHostAddress();
        this.lcHostname = this.hostname.toLowerCase(Locale.ENGLISH);
        this.schemeName = string != null ? string.toLowerCase(Locale.ENGLISH) : DEFAULT_SCHEME_NAME;
        this.port = n;
    }

    public HttpHost(InetAddress inetAddress, int n) {
        this(inetAddress, n, null);
    }

    public HttpHost(InetAddress inetAddress) {
        this(inetAddress, -1, null);
    }

    public HttpHost(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.hostname = httpHost.hostname;
        this.lcHostname = httpHost.lcHostname;
        this.schemeName = httpHost.schemeName;
        this.port = httpHost.port;
        this.address = httpHost.address;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public String toURI() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.schemeName);
        stringBuilder.append("://");
        stringBuilder.append(this.hostname);
        if (this.port != -1) {
            stringBuilder.append(':');
            stringBuilder.append(Integer.toString(this.port));
        }
        return stringBuilder.toString();
    }

    public String toHostString() {
        if (this.port != -1) {
            StringBuilder stringBuilder = new StringBuilder(this.hostname.length() + 6);
            stringBuilder.append(this.hostname);
            stringBuilder.append(":");
            stringBuilder.append(Integer.toString(this.port));
            return stringBuilder.toString();
        }
        return this.hostname;
    }

    public String toString() {
        return this.toURI();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof HttpHost) {
            HttpHost httpHost = (HttpHost)object;
            return this.lcHostname.equals(httpHost.lcHostname) && this.port == httpHost.port && this.schemeName.equals(httpHost.schemeName);
        }
        return false;
    }

    public int hashCode() {
        int n = 17;
        n = LangUtils.hashCode(n, this.lcHostname);
        n = LangUtils.hashCode(n, this.port);
        n = LangUtils.hashCode(n, this.schemeName);
        return n;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

