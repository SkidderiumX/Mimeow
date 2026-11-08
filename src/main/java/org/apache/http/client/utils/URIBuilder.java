/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.message.BasicNameValuePair;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class URIBuilder {
    private String scheme;
    private String encodedSchemeSpecificPart;
    private String encodedAuthority;
    private String userInfo;
    private String encodedUserInfo;
    private String host;
    private int port;
    private String path;
    private String encodedPath;
    private String encodedQuery;
    private List<NameValuePair> queryParams;
    private String query;
    private String fragment;
    private String encodedFragment;

    public URIBuilder() {
        this.port = -1;
    }

    public URIBuilder(String string) throws URISyntaxException {
        this.digestURI(new URI(string));
    }

    public URIBuilder(URI uRI) {
        this.digestURI(uRI);
    }

    private List<NameValuePair> parseQuery(String string, Charset charset) {
        if (string != null && string.length() > 0) {
            return URLEncodedUtils.parse(string, charset);
        }
        return null;
    }

    public URI build() throws URISyntaxException {
        return new URI(this.buildString());
    }

    private String buildString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.scheme != null) {
            stringBuilder.append(this.scheme).append(':');
        }
        if (this.encodedSchemeSpecificPart != null) {
            stringBuilder.append(this.encodedSchemeSpecificPart);
        } else {
            if (this.encodedAuthority != null) {
                stringBuilder.append("//").append(this.encodedAuthority);
            } else if (this.host != null) {
                stringBuilder.append("//");
                if (this.encodedUserInfo != null) {
                    stringBuilder.append(this.encodedUserInfo).append("@");
                } else if (this.userInfo != null) {
                    stringBuilder.append(this.encodeUserInfo(this.userInfo)).append("@");
                }
                if (InetAddressUtils.isIPv6Address(this.host)) {
                    stringBuilder.append("[").append(this.host).append("]");
                } else {
                    stringBuilder.append(this.host);
                }
                if (this.port >= 0) {
                    stringBuilder.append(":").append(this.port);
                }
            }
            if (this.encodedPath != null) {
                stringBuilder.append(URIBuilder.normalizePath(this.encodedPath));
            } else if (this.path != null) {
                stringBuilder.append(this.encodePath(URIBuilder.normalizePath(this.path)));
            }
            if (this.encodedQuery != null) {
                stringBuilder.append("?").append(this.encodedQuery);
            } else if (this.queryParams != null) {
                stringBuilder.append("?").append(this.encodeUrlForm(this.queryParams));
            } else if (this.query != null) {
                stringBuilder.append("?").append(this.encodeUric(this.query));
            }
        }
        if (this.encodedFragment != null) {
            stringBuilder.append("#").append(this.encodedFragment);
        } else if (this.fragment != null) {
            stringBuilder.append("#").append(this.encodeUric(this.fragment));
        }
        return stringBuilder.toString();
    }

    private void digestURI(URI uRI) {
        this.scheme = uRI.getScheme();
        this.encodedSchemeSpecificPart = uRI.getRawSchemeSpecificPart();
        this.encodedAuthority = uRI.getRawAuthority();
        this.host = uRI.getHost();
        this.port = uRI.getPort();
        this.encodedUserInfo = uRI.getRawUserInfo();
        this.userInfo = uRI.getUserInfo();
        this.encodedPath = uRI.getRawPath();
        this.path = uRI.getPath();
        this.encodedQuery = uRI.getRawQuery();
        this.queryParams = this.parseQuery(uRI.getRawQuery(), Consts.UTF_8);
        this.encodedFragment = uRI.getRawFragment();
        this.fragment = uRI.getFragment();
    }

    private String encodeUserInfo(String string) {
        return URLEncodedUtils.encUserInfo(string, Consts.UTF_8);
    }

    private String encodePath(String string) {
        return URLEncodedUtils.encPath(string, Consts.UTF_8);
    }

    private String encodeUrlForm(List<NameValuePair> list) {
        return URLEncodedUtils.format(list, Consts.UTF_8);
    }

    private String encodeUric(String string) {
        return URLEncodedUtils.encUric(string, Consts.UTF_8);
    }

    public URIBuilder setScheme(String string) {
        this.scheme = string;
        return this;
    }

    public URIBuilder setUserInfo(String string) {
        this.userInfo = string;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    public URIBuilder setUserInfo(String string, String string2) {
        return this.setUserInfo(string + ':' + string2);
    }

    public URIBuilder setHost(String string) {
        this.host = string;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPort(int n) {
        this.port = n < 0 ? -1 : n;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPath(String string) {
        this.path = string;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    }

    public URIBuilder removeQuery() {
        this.queryParams = null;
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    @Deprecated
    public URIBuilder setQuery(String string) {
        this.queryParams = this.parseQuery(string, Consts.UTF_8);
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setParameters(List<NameValuePair> list) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList<NameValuePair>();
        } else {
            this.queryParams.clear();
        }
        this.queryParams.addAll(list);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameters(List<NameValuePair> list) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList<NameValuePair>();
        }
        this.queryParams.addAll(list);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(NameValuePair ... nameValuePairArray) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList<NameValuePair>();
        } else {
            this.queryParams.clear();
        }
        for (NameValuePair nameValuePair : nameValuePairArray) {
            this.queryParams.add(nameValuePair);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameter(String string, String string2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList<NameValuePair>();
        }
        this.queryParams.add(new BasicNameValuePair(string, string2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameter(String string, String string2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList<NameValuePair>();
        }
        if (!this.queryParams.isEmpty()) {
            Iterator<NameValuePair> iterator2 = this.queryParams.iterator();
            while (iterator2.hasNext()) {
                NameValuePair nameValuePair = iterator2.next();
                if (!nameValuePair.getName().equals(string)) continue;
                iterator2.remove();
            }
        }
        this.queryParams.add(new BasicNameValuePair(string, string2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder clearParameters() {
        this.queryParams = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setCustomQuery(String string) {
        this.query = string;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.queryParams = null;
        return this;
    }

    public URIBuilder setFragment(String string) {
        this.fragment = string;
        this.encodedFragment = null;
        return this;
    }

    public boolean isAbsolute() {
        return this.scheme != null;
    }

    public boolean isOpaque() {
        return this.path == null;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getPath() {
        return this.path;
    }

    public List<NameValuePair> getQueryParams() {
        if (this.queryParams != null) {
            return new ArrayList<NameValuePair>(this.queryParams);
        }
        return new ArrayList<NameValuePair>();
    }

    public String getFragment() {
        return this.fragment;
    }

    public String toString() {
        return this.buildString();
    }

    private static String normalizePath(String string) {
        int n;
        String string2 = string;
        if (string2 == null) {
            return null;
        }
        for (n = 0; n < string2.length() && string2.charAt(n) == '/'; ++n) {
        }
        if (n > 1) {
            string2 = string2.substring(n - 1);
        }
        return string2;
    }
}

