/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.util.Args;

@ThreadSafe
public class SystemDefaultCredentialsProvider
implements CredentialsProvider {
    private static final Map<String, String> SCHEME_MAP = new ConcurrentHashMap<String, String>();
    private final BasicCredentialsProvider internal = new BasicCredentialsProvider();

    private static String translateScheme(String string) {
        if (string == null) {
            return null;
        }
        String string2 = SCHEME_MAP.get(string);
        return string2 != null ? string2 : string;
    }

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        this.internal.setCredentials(authScope, credentials);
    }

    private static PasswordAuthentication getSystemCreds(AuthScope authScope, Authenticator.RequestorType requestorType) {
        String string = authScope.getHost();
        int n = authScope.getPort();
        String string2 = n == 443 ? "https" : "http";
        return Authenticator.requestPasswordAuthentication(string, null, n, string2, null, SystemDefaultCredentialsProvider.translateScheme(authScope.getScheme()), null, requestorType);
    }

    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Auth scope");
        Credentials credentials = this.internal.getCredentials(authScope);
        if (credentials != null) {
            return credentials;
        }
        if (authScope.getHost() != null) {
            PasswordAuthentication passwordAuthentication = SystemDefaultCredentialsProvider.getSystemCreds(authScope, Authenticator.RequestorType.SERVER);
            if (passwordAuthentication == null) {
                passwordAuthentication = SystemDefaultCredentialsProvider.getSystemCreds(authScope, Authenticator.RequestorType.PROXY);
            }
            if (passwordAuthentication != null) {
                String string = System.getProperty("http.auth.ntlm.domain");
                if (string != null) {
                    return new NTCredentials(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()), null, string);
                }
                if ("NTLM".equalsIgnoreCase(authScope.getScheme())) {
                    return new NTCredentials(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()), null, null);
                }
                return new UsernamePasswordCredentials(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()));
            }
        }
        return null;
    }

    public void clear() {
        this.internal.clear();
    }

    static {
        SCHEME_MAP.put("Basic".toUpperCase(Locale.ENGLISH), "Basic");
        SCHEME_MAP.put("Digest".toUpperCase(Locale.ENGLISH), "Digest");
        SCHEME_MAP.put("NTLM".toUpperCase(Locale.ENGLISH), "NTLM");
        SCHEME_MAP.put("negotiate".toUpperCase(Locale.ENGLISH), "SPNEGO");
        SCHEME_MAP.put("Kerberos".toUpperCase(Locale.ENGLISH), "Kerberos");
    }
}

