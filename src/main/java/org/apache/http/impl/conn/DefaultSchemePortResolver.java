/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.util.Args;

@Immutable
public class DefaultSchemePortResolver
implements SchemePortResolver {
    public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();

    public int resolve(HttpHost httpHost) throws UnsupportedSchemeException {
        Args.notNull(httpHost, "HTTP host");
        int n = httpHost.getPort();
        if (n > 0) {
            return n;
        }
        String string = httpHost.getSchemeName();
        if (string.equalsIgnoreCase("http")) {
            return 80;
        }
        if (string.equalsIgnoreCase("https")) {
            return 443;
        }
        throw new UnsupportedSchemeException(string + " protocol is not supported");
    }
}

