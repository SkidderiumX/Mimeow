/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLInitializationException;

@Immutable
public class SSLContexts {
    public static SSLContext createDefault() throws SSLInitializationException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new SSLInitializationException(noSuchAlgorithmException.getMessage(), noSuchAlgorithmException);
        }
        catch (KeyManagementException keyManagementException) {
            throw new SSLInitializationException(keyManagementException.getMessage(), keyManagementException);
        }
    }

    public static SSLContext createSystemDefault() throws SSLInitializationException {
        try {
            return SSLContext.getInstance("Default");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return SSLContexts.createDefault();
        }
    }

    public static SSLContextBuilder custom() {
        return new SSLContextBuilder();
    }
}

