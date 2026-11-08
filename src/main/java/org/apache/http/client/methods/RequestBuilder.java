/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.methods;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.HeaderGroup;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class RequestBuilder {
    private String method;
    private ProtocolVersion version;
    private URI uri;
    private HeaderGroup headergroup;
    private HttpEntity entity;
    private LinkedList<NameValuePair> parameters;
    private RequestConfig config;

    RequestBuilder(String string) {
        this.method = string;
    }

    RequestBuilder() {
        this(null);
    }

    public static RequestBuilder create(String string) {
        Args.notBlank(string, "HTTP method");
        return new RequestBuilder(string);
    }

    public static RequestBuilder get() {
        return new RequestBuilder("GET");
    }

    public static RequestBuilder head() {
        return new RequestBuilder("HEAD");
    }

    public static RequestBuilder post() {
        return new RequestBuilder("POST");
    }

    public static RequestBuilder put() {
        return new RequestBuilder("PUT");
    }

    public static RequestBuilder delete() {
        return new RequestBuilder("DELETE");
    }

    public static RequestBuilder trace() {
        return new RequestBuilder("TRACE");
    }

    public static RequestBuilder options() {
        return new RequestBuilder("OPTIONS");
    }

    public static RequestBuilder copy(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return new RequestBuilder().doCopy(httpRequest);
    }

    private RequestBuilder doCopy(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return this;
        }
        this.method = httpRequest.getRequestLine().getMethod();
        this.version = httpRequest.getRequestLine().getProtocolVersion();
        this.uri = httpRequest instanceof HttpUriRequest ? ((HttpUriRequest)httpRequest).getURI() : URI.create(httpRequest.getRequestLine().getMethod());
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.clear();
        this.headergroup.setHeaders(httpRequest.getAllHeaders());
        this.entity = httpRequest instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest)httpRequest).getEntity() : null;
        this.config = httpRequest instanceof Configurable ? ((Configurable)((Object)httpRequest)).getConfig() : null;
        this.parameters = null;
        return this;
    }

    public String getMethod() {
        return this.method;
    }

    public ProtocolVersion getVersion() {
        return this.version;
    }

    public RequestBuilder setVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
        return this;
    }

    public URI getUri() {
        return this.uri;
    }

    public RequestBuilder setUri(URI uRI) {
        this.uri = uRI;
        return this;
    }

    public RequestBuilder setUri(String string) {
        this.uri = string != null ? URI.create(string) : null;
        return this;
    }

    public Header getFirstHeader(String string) {
        return this.headergroup != null ? this.headergroup.getFirstHeader(string) : null;
    }

    public Header getLastHeader(String string) {
        return this.headergroup != null ? this.headergroup.getLastHeader(string) : null;
    }

    public Header[] getHeaders(String string) {
        return this.headergroup != null ? this.headergroup.getHeaders(string) : null;
    }

    public RequestBuilder addHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.addHeader(header);
        return this;
    }

    public RequestBuilder addHeader(String string, String string2) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.addHeader(new BasicHeader(string, string2));
        return this;
    }

    public RequestBuilder removeHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.removeHeader(header);
        return this;
    }

    public RequestBuilder removeHeaders(String string) {
        if (string == null || this.headergroup == null) {
            return this;
        }
        HeaderIterator headerIterator = this.headergroup.iterator();
        while (headerIterator.hasNext()) {
            Header header = headerIterator.nextHeader();
            if (!string.equalsIgnoreCase(header.getName())) continue;
            headerIterator.remove();
        }
        return this;
    }

    public RequestBuilder setHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.updateHeader(header);
        return this;
    }

    public RequestBuilder setHeader(String string, String string2) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.updateHeader(new BasicHeader(string, string2));
        return this;
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public RequestBuilder setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
        return this;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters != null ? new ArrayList<NameValuePair>(this.parameters) : new ArrayList();
    }

    public RequestBuilder addParameter(NameValuePair nameValuePair) {
        Args.notNull(nameValuePair, "Name value pair");
        if (this.parameters == null) {
            this.parameters = new LinkedList();
        }
        this.parameters.add(nameValuePair);
        return this;
    }

    public RequestBuilder addParameter(String string, String string2) {
        return this.addParameter(new BasicNameValuePair(string, string2));
    }

    public RequestBuilder addParameters(NameValuePair ... nameValuePairArray) {
        for (NameValuePair nameValuePair : nameValuePairArray) {
            this.addParameter(nameValuePair);
        }
        return this;
    }

    public RequestConfig getConfig() {
        return this.config;
    }

    public RequestBuilder setConfig(RequestConfig requestConfig) {
        this.config = requestConfig;
        return this;
    }

    public HttpUriRequest build() {
        HttpRequestBase httpRequestBase;
        URI uRI = this.uri != null ? this.uri : URI.create("/");
        HttpEntity httpEntity = this.entity;
        if (this.parameters != null && !this.parameters.isEmpty()) {
            if (httpEntity == null && ("POST".equalsIgnoreCase(this.method) || "PUT".equalsIgnoreCase(this.method))) {
                httpEntity = new UrlEncodedFormEntity(this.parameters, HTTP.DEF_CONTENT_CHARSET);
            } else {
                try {
                    uRI = new URIBuilder(uRI).addParameters(this.parameters).build();
                }
                catch (URISyntaxException uRISyntaxException) {
                    // empty catch block
                }
            }
        }
        if (httpEntity == null) {
            httpRequestBase = new InternalRequest(this.method);
        } else {
            InternalEntityEclosingRequest internalEntityEclosingRequest = new InternalEntityEclosingRequest(this.method);
            internalEntityEclosingRequest.setEntity(httpEntity);
            httpRequestBase = internalEntityEclosingRequest;
        }
        httpRequestBase.setProtocolVersion(this.version);
        httpRequestBase.setURI(uRI);
        if (this.headergroup != null) {
            httpRequestBase.setHeaders(this.headergroup.getAllHeaders());
        }
        httpRequestBase.setConfig(this.config);
        return httpRequestBase;
    }

    public static class InternalEntityEclosingRequest
    extends HttpEntityEnclosingRequestBase {
        private final String method;

        InternalEntityEclosingRequest(String string) {
            this.method = string;
        }

        public String getMethod() {
            return this.method;
        }
    }

    public static class InternalRequest
    extends HttpRequestBase {
        private final String method;

        InternalRequest(String string) {
            this.method = string;
        }

        public String getMethod() {
            return this.method;
        }
    }
}

