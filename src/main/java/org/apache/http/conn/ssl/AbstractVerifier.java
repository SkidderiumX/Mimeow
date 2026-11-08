/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.conn.util.InetAddressUtils;

@Immutable
public abstract class AbstractVerifier
implements X509HostnameVerifier {
    private static final String[] BAD_COUNTRY_2LDS = new String[]{"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
    private final Log log = LogFactory.getLog(this.getClass());

    public final void verify(String string, SSLSocket sSLSocket) throws IOException {
        Certificate[] certificateArray;
        if (string == null) {
            throw new NullPointerException("host to verify is null");
        }
        SSLSession sSLSession = sSLSocket.getSession();
        if (sSLSession == null) {
            certificateArray = sSLSocket.getInputStream();
            certificateArray.available();
            sSLSession = sSLSocket.getSession();
            if (sSLSession == null) {
                sSLSocket.startHandshake();
                sSLSession = sSLSocket.getSession();
            }
        }
        certificateArray = sSLSession.getPeerCertificates();
        X509Certificate x509Certificate = (X509Certificate)certificateArray[0];
        this.verify(string, x509Certificate);
    }

    public final boolean verify(String string, SSLSession sSLSession) {
        try {
            Certificate[] certificateArray = sSLSession.getPeerCertificates();
            X509Certificate x509Certificate = (X509Certificate)certificateArray[0];
            this.verify(string, x509Certificate);
            return true;
        }
        catch (SSLException sSLException) {
            return false;
        }
    }

    public final void verify(String string, X509Certificate x509Certificate) throws SSLException {
        String[] stringArray = AbstractVerifier.getCNs(x509Certificate);
        String[] stringArray2 = AbstractVerifier.getSubjectAlts(x509Certificate, string);
        this.verify(string, stringArray, stringArray2);
    }

    public final void verify(String string, String[] stringArray, String[] stringArray2, boolean bl) throws SSLException {
        Object object;
        LinkedList<String> linkedList = new LinkedList<String>();
        if (stringArray != null && stringArray.length > 0 && stringArray[0] != null) {
            linkedList.add(stringArray[0]);
        }
        if (stringArray2 != null) {
            for (String object22 : stringArray2) {
                if (object22 == null) continue;
                linkedList.add(object22);
            }
        }
        if (linkedList.isEmpty()) {
            object = "Certificate for <" + string + "> doesn't contain CN or DNS subjectAlt";
            throw new SSLException((String)object);
        }
        object = new StringBuilder();
        String string2 = this.normaliseIPv6Address(string.trim().toLowerCase(Locale.US));
        int n = 0;
        Iterator iterator2 = linkedList.iterator();
        while (iterator2.hasNext()) {
            String[] stringArray3;
            boolean bl2;
            String string3 = (String)iterator2.next();
            string3 = string3.toLowerCase(Locale.US);
            ((StringBuilder)object).append(" <");
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append('>');
            if (iterator2.hasNext()) {
                ((StringBuilder)object).append(" OR");
            }
            boolean bl3 = bl2 = (stringArray3 = string3.split("\\.")).length >= 3 && stringArray3[0].endsWith("*") && this.validCountryWildcard(string3) && !AbstractVerifier.isIPAddress(string);
            if (bl2) {
                String string4 = stringArray3[0];
                if (string4.length() > 1) {
                    String string5 = string4.substring(0, string4.length() - 1);
                    String string6 = string3.substring(string4.length());
                    String string7 = string2.substring(string5.length());
                    n = string2.startsWith(string5) && string7.endsWith(string6) ? 1 : 0;
                } else {
                    n = string2.endsWith(string3.substring(1)) ? 1 : 0;
                }
                if (n != 0 && bl) {
                    n = AbstractVerifier.countDots(string2) == AbstractVerifier.countDots(string3) ? 1 : 0;
                }
            } else {
                n = string2.equals(this.normaliseIPv6Address(string3)) ? 1 : 0;
            }
            if (n == 0) continue;
            break;
        }
        if (n == 0) {
            throw new SSLException("hostname in certificate didn't match: <" + string + "> !=" + object);
        }
    }

    @Deprecated
    public static boolean acceptableCountryWildcard(String string) {
        String[] stringArray = string.split("\\.");
        if (stringArray.length != 3 || stringArray[2].length() != 2) {
            return true;
        }
        return Arrays.binarySearch(BAD_COUNTRY_2LDS, stringArray[1]) < 0;
    }

    boolean validCountryWildcard(String string) {
        String[] stringArray = string.split("\\.");
        if (stringArray.length != 3 || stringArray[2].length() != 2) {
            return true;
        }
        return Arrays.binarySearch(BAD_COUNTRY_2LDS, stringArray[1]) < 0;
    }

    public static String[] getCNs(X509Certificate x509Certificate) {
        String[] stringArray;
        LinkedList<String> linkedList = new LinkedList<String>();
        String string = x509Certificate.getSubjectX500Principal().toString();
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",+");
        while (stringTokenizer.hasMoreTokens()) {
            stringArray = stringTokenizer.nextToken().trim();
            if (stringArray.length() <= 3 || !stringArray.substring(0, 3).equalsIgnoreCase("CN=")) continue;
            linkedList.add(stringArray.substring(3));
        }
        if (!linkedList.isEmpty()) {
            stringArray = new String[linkedList.size()];
            linkedList.toArray(stringArray);
            return stringArray;
        }
        return null;
    }

    private static String[] getSubjectAlts(X509Certificate x509Certificate, String string) {
        int n = AbstractVerifier.isIPAddress(string) ? 7 : 2;
        LinkedList<String> linkedList = new LinkedList<String>();
        Collection<List<?>> collection = null;
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        }
        catch (CertificateParsingException certificateParsingException) {
            // empty catch block
        }
        if (collection != null) {
            for (List list : collection) {
                List list2 = list;
                int n2 = (Integer)list2.get(0);
                if (n2 != n) continue;
                String string2 = (String)list2.get(1);
                linkedList.add(string2);
            }
        }
        if (!linkedList.isEmpty()) {
            String[] stringArray = new String[linkedList.size()];
            linkedList.toArray(stringArray);
            return stringArray;
        }
        return null;
    }

    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate) {
        return AbstractVerifier.getSubjectAlts(x509Certificate, null);
    }

    public static int countDots(String string) {
        int n = 0;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) != '.') continue;
            ++n;
        }
        return n;
    }

    private static boolean isIPAddress(String string) {
        return string != null && (InetAddressUtils.isIPv4Address(string) || InetAddressUtils.isIPv6Address(string));
    }

    private String normaliseIPv6Address(String string) {
        if (string == null || !InetAddressUtils.isIPv6Address(string)) {
            return string;
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(string);
            return inetAddress.getHostAddress();
        }
        catch (UnknownHostException unknownHostException) {
            this.log.error("Unexpected error converting " + string, unknownHostException);
            return string;
        }
    }

    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
}

