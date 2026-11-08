/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.X509TrustManager;

public class ocfbe13520d7
extends Record
implements X509TrustManager {
    private final X509TrustManager \u01d0;
    private final X509TrustManager \u0561;

    private ocfbe13520d7(X509TrustManager x509TrustManager, X509TrustManager x509TrustManager2) {
        this.\u01d0 = x509TrustManager;
        this.\u0561 = x509TrustManager2;
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
        try {
            this.\u01d0.checkServerTrusted(x509CertificateArray, string);
        }
        catch (CertificateException certificateException) {
            try {
                this.\u0561.checkServerTrusted(x509CertificateArray, string);
            }
            catch (CertificateException certificateException2) {
                certificateException.addSuppressed(certificateException2);
                throw certificateException;
            }
        }
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
        this.\u01d0.checkClientTrusted(x509CertificateArray, string);
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        X509Certificate[] x509CertificateArray = this.\u01d0.getAcceptedIssuers();
        X509Certificate[] x509CertificateArray2 = this.\u0561.getAcceptedIssuers();
        X509Certificate[] x509CertificateArray3 = Arrays.copyOf(x509CertificateArray, x509CertificateArray.length + x509CertificateArray2.length);
        System.arraycopy(x509CertificateArray2, 0, x509CertificateArray3, x509CertificateArray.length, x509CertificateArray2.length);
        return x509CertificateArray3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ocfbe13520d7.class, "\u01d0;\u0561", "\u01d0", "\u0561"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ocfbe13520d7.class, "\u01d0;\u0561", "\u01d0", "\u0561"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ocfbe13520d7.class, "\u01d0;\u0561", "\u01d0", "\u0561"}, this, object);
    }

    public X509TrustManager \u01cf() {
        return this.\u01d0;
    }

    public X509TrustManager \u0531() {
        return this.\u0561;
    }
}

