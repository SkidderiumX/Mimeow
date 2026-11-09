/*
 * Decompiled with CFR 0.152.
 */
package x;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.X509TrustManager;

public class ocfbe13520d7
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

    public X509TrustManager \u01cf() {
        return this.\u01d0;
    }

    public X509TrustManager \u0531() {
        return this.\u0561;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ocfbe13520d7 other = (ocfbe13520d7)object;
        return java.util.Arrays.deepEquals(new Object[]{this.\u01d0, this.\u0561}, new Object[]{other.\u01d0, other.\u0561});
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(new Object[]{this.\u01d0, this.\u0561});
    }

    @Override
    public String toString() {
        return "ocfbe13520d7[\u01d0" + java.util.Arrays.deepToString(new Object[]{this.\u01d0}) + ", \u0561" + java.util.Arrays.deepToString(new Object[]{this.\u0561}) + "]";
    }
}

