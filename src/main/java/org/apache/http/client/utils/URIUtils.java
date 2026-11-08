/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class URIUtils {
    @Deprecated
    public static URI createURI(String string, String string2, int n, String string3, String string4, String string5) throws URISyntaxException {
        StringBuilder stringBuilder = new StringBuilder();
        if (string2 != null) {
            if (string != null) {
                stringBuilder.append(string);
                stringBuilder.append("://");
            }
            stringBuilder.append(string2);
            if (n > 0) {
                stringBuilder.append(':');
                stringBuilder.append(n);
            }
        }
        if (string3 == null || !string3.startsWith("/")) {
            stringBuilder.append('/');
        }
        if (string3 != null) {
            stringBuilder.append(string3);
        }
        if (string4 != null) {
            stringBuilder.append('?');
            stringBuilder.append(string4);
        }
        if (string5 != null) {
            stringBuilder.append('#');
            stringBuilder.append(string5);
        }
        return new URI(stringBuilder.toString());
    }

    public static URI rewriteURI(URI uRI, HttpHost httpHost, boolean bl) throws URISyntaxException {
        Args.notNull(uRI, "URI");
        if (uRI.isOpaque()) {
            return uRI;
        }
        URIBuilder uRIBuilder = new URIBuilder(uRI);
        if (httpHost != null) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        } else {
            uRIBuilder.setScheme(null);
            uRIBuilder.setHost(null);
            uRIBuilder.setPort(-1);
        }
        if (bl) {
            uRIBuilder.setFragment(null);
        }
        if (TextUtils.isEmpty(uRIBuilder.getPath())) {
            uRIBuilder.setPath("/");
        }
        return uRIBuilder.build();
    }

    public static URI rewriteURI(URI uRI, HttpHost httpHost) throws URISyntaxException {
        return URIUtils.rewriteURI(uRI, httpHost, false);
    }

    public static URI rewriteURI(URI uRI) throws URISyntaxException {
        Args.notNull(uRI, "URI");
        if (uRI.isOpaque()) {
            return uRI;
        }
        URIBuilder uRIBuilder = new URIBuilder(uRI);
        if (uRIBuilder.getUserInfo() != null) {
            uRIBuilder.setUserInfo(null);
        }
        if (TextUtils.isEmpty(uRIBuilder.getPath())) {
            uRIBuilder.setPath("/");
        }
        if (uRIBuilder.getHost() != null) {
            uRIBuilder.setHost(uRIBuilder.getHost().toLowerCase(Locale.ENGLISH));
        }
        uRIBuilder.setFragment(null);
        return uRIBuilder.build();
    }

    public static URI resolve(URI uRI, String string) {
        return URIUtils.resolve(uRI, URI.create(string));
    }

    public static URI resolve(URI uRI, URI uRI2) {
        boolean bl;
        Args.notNull(uRI, "Base URI");
        Args.notNull(uRI2, "Reference URI");
        URI uRI3 = uRI2;
        String string = uRI3.toString();
        if (string.startsWith("?")) {
            return URIUtils.resolveReferenceStartingWithQueryString(uRI, uRI3);
        }
        boolean bl2 = bl = string.length() == 0;
        if (bl) {
            uRI3 = URI.create("#");
        }
        URI uRI4 = uRI.resolve(uRI3);
        if (bl) {
            String string2 = uRI4.toString();
            uRI4 = URI.create(string2.substring(0, string2.indexOf(35)));
        }
        return URIUtils.normalizeSyntax(uRI4);
    }

    private static URI resolveReferenceStartingWithQueryString(URI uRI, URI uRI2) {
        String string = uRI.toString();
        string = string.indexOf(63) > -1 ? string.substring(0, string.indexOf(63)) : string;
        return URI.create(string + uRI2.toString());
    }

    private static URI normalizeSyntax(URI uRI) {
        if (uRI.isOpaque() || uRI.getAuthority() == null) {
            return uRI;
        }
        Args.check(uRI.isAbsolute(), "Base URI must be absolute");
        String string = uRI.getPath() == null ? "" : uRI.getPath();
        String[] stringArray = string.split("/");
        Stack<String> stack = new Stack<String>();
        for (String object : stringArray) {
            if (object.length() == 0 || ".".equals(object)) continue;
            if ("..".equals(object)) {
                if (stack.isEmpty()) continue;
                stack.pop();
                continue;
            }
            stack.push(object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : stack) {
            stringBuilder.append('/').append(string2);
        }
        if (string.lastIndexOf(47) == string.length() - 1) {
            stringBuilder.append('/');
        }
        try {
            String string3 = uRI.getScheme().toLowerCase();
            String string4 = uRI.getAuthority().toLowerCase();
            URI uRI2 = new URI(string3, string4, stringBuilder.toString(), null, null);
            if (uRI.getQuery() == null && uRI.getFragment() == null) {
                return uRI2;
            }
            StringBuilder stringBuilder2 = new StringBuilder(uRI2.toASCIIString());
            if (uRI.getQuery() != null) {
                stringBuilder2.append('?').append(uRI.getRawQuery());
            }
            if (uRI.getFragment() != null) {
                stringBuilder2.append('#').append(uRI.getRawFragment());
            }
            return URI.create(stringBuilder2.toString());
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalArgumentException(uRISyntaxException);
        }
    }

    public static HttpHost extractHost(URI uRI) {
        if (uRI == null) {
            return null;
        }
        HttpHost httpHost = null;
        if (uRI.isAbsolute()) {
            int n = uRI.getPort();
            String string = uRI.getHost();
            if (string == null && (string = uRI.getAuthority()) != null) {
                int n2;
                int n3 = string.indexOf(64);
                if (n3 >= 0) {
                    string = string.length() > n3 + 1 ? string.substring(n3 + 1) : null;
                }
                if (string != null && (n2 = string.indexOf(58)) >= 0) {
                    int n4 = n2 + 1;
                    int n5 = 0;
                    for (int i = n4; i < string.length() && Character.isDigit(string.charAt(i)); ++i) {
                        ++n5;
                    }
                    if (n5 > 0) {
                        try {
                            n = Integer.parseInt(string.substring(n4, n4 + n5));
                        }
                        catch (NumberFormatException numberFormatException) {
                            // empty catch block
                        }
                    }
                    string = string.substring(0, n2);
                }
            }
            String string2 = uRI.getScheme();
            if (string != null) {
                httpHost = new HttpHost(string, n, string2);
            }
        }
        return httpHost;
    }

    public static URI resolve(URI uRI, HttpHost httpHost, List<URI> list) throws URISyntaxException {
        URIBuilder uRIBuilder;
        Args.notNull(uRI, "Request URI");
        if (list == null || list.isEmpty()) {
            uRIBuilder = new URIBuilder(uRI);
        } else {
            uRIBuilder = new URIBuilder(list.get(list.size() - 1));
            String string = uRIBuilder.getFragment();
            for (int i = list.size() - 1; string == null && i >= 0; --i) {
                string = list.get(i).getFragment();
            }
            uRIBuilder.setFragment(string);
        }
        if (uRIBuilder.getFragment() == null) {
            uRIBuilder.setFragment(uRI.getFragment());
        }
        if (httpHost != null && !uRIBuilder.isAbsolute()) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        }
        return uRIBuilder.build();
    }

    private URIUtils() {
    }
}

