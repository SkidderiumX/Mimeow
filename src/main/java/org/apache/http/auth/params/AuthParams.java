/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.auth.params;

import org.apache.http.annotation.Immutable;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

@Deprecated
@Immutable
public class AuthParams {
    private AuthParams() {
    }

    public static String getCredentialCharset(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        String string = (String)httpParams.getParameter("http.auth.credential-charset");
        if (string == null) {
            string = HTTP.DEF_PROTOCOL_CHARSET.name();
        }
        return string;
    }

    public static void setCredentialCharset(HttpParams httpParams, String string) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setParameter("http.auth.credential-charset", string);
    }
}

