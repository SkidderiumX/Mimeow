/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.apache.http.conn.ssl.TrustStrategy;

public class TrustSelfSignedStrategy
implements TrustStrategy {
    public boolean isTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
        return x509CertificateArray.length == 1;
    }
}

