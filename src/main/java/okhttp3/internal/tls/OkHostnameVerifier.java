/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u0017\u001a\u00020\b*\u00020\bH\u0002J\f\u0010\u0018\u001a\u00020\u000e*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "asciiToLowercase", "isAscii", "okhttp"})
@SourceDebugExtension(value={"SMAP\nOkHostnameVerifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,208:1\n1747#2,3:209\n1747#2,3:212\n*S KotlinDebug\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n*L\n63#1:209,3\n71#1:212,3\n*E\n"})
public class OkHostnameVerifier
implements HostnameVerifier {
    @NotNull
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;

    private OkHostnameVerifier() {
    }

    @Override
    public boolean verify(@NotNull String string, @NotNull SSLSession sSLSession) {
        boolean bl;
        Intrinsics.checkNotNullParameter(string, "host");
        Intrinsics.checkNotNullParameter(sSLSession, "session");
        if (!this.isAscii(string)) {
            bl = false;
        } else {
            boolean bl2;
            try {
                Certificate certificate = sSLSession.getPeerCertificates()[0];
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                bl2 = this.verify(string, (X509Certificate)certificate);
            }
            catch (SSLException sSLException) {
                bl2 = false;
            }
            bl = bl2;
        }
        return bl;
    }

    public final boolean verify(@NotNull String string, @NotNull X509Certificate x509Certificate) {
        Intrinsics.checkNotNullParameter(string, "host");
        Intrinsics.checkNotNullParameter(x509Certificate, "certificate");
        return Util.canParseAsIpAddress(string) ? this.verifyIpAddress(string, x509Certificate) : this.verifyHostname(string, x509Certificate);
    }

    private final boolean verifyIpAddress(String string, X509Certificate x509Certificate) {
        boolean bl;
        block3: {
            String string2 = HostnamesKt.toCanonicalHost(string);
            Iterable iterable = this.getSubjectAltNames(x509Certificate, 7);
            boolean bl2 = false;
            if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                bl = false;
            } else {
                for (Object t : iterable) {
                    String string3 = (String)t;
                    boolean bl3 = false;
                    if (!Intrinsics.areEqual(string2, HostnamesKt.toCanonicalHost(string3))) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    private final boolean verifyHostname(String string, X509Certificate x509Certificate) {
        boolean bl;
        block3: {
            String string2 = this.asciiToLowercase(string);
            Iterable iterable = this.getSubjectAltNames(x509Certificate, 2);
            boolean bl2 = false;
            if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                bl = false;
            } else {
                for (Object t : iterable) {
                    String string3 = (String)t;
                    boolean bl3 = false;
                    if (!INSTANCE.verifyHostname(string2, string3)) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    private final String asciiToLowercase(String string) {
        String string2;
        if (this.isAscii(string)) {
            String string3 = string;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String string4 = string3.toLowerCase(locale);
            string2 = string4;
            Intrinsics.checkNotNullExpressionValue(string4, "this as java.lang.String).toLowerCase(locale)");
        } else {
            string2 = string;
        }
        return string2;
    }

    private final boolean isAscii(String string) {
        return string.length() == (int)Utf8.size$default(string, 0, 0, 3, null);
    }

    private final boolean verifyHostname(String string, String string2) {
        String string3 = string;
        String string4 = string2;
        CharSequence charSequence = string3;
        if (charSequence == null || charSequence.length() == 0 || StringsKt.startsWith$default(string3, ".", false, 2, null) || StringsKt.endsWith$default(string3, "..", false, 2, null)) {
            return false;
        }
        charSequence = string4;
        if (charSequence == null || charSequence.length() == 0 || StringsKt.startsWith$default(string4, ".", false, 2, null) || StringsKt.endsWith$default(string4, "..", false, 2, null)) {
            return false;
        }
        if (!StringsKt.endsWith$default(string3, ".", false, 2, null)) {
            string3 = string3 + '.';
        }
        if (!StringsKt.endsWith$default(string4, ".", false, 2, null)) {
            string4 = string4 + '.';
        }
        if (!StringsKt.contains$default((CharSequence)(string4 = this.asciiToLowercase(string4)), "*", false, 2, null)) {
            return Intrinsics.areEqual(string3, string4);
        }
        if (!StringsKt.startsWith$default(string4, "*.", false, 2, null) || StringsKt.indexOf$default((CharSequence)string4, '*', 1, false, 4, null) != -1) {
            return false;
        }
        if (string3.length() < string4.length()) {
            return false;
        }
        if (Intrinsics.areEqual("*.", string4)) {
            return false;
        }
        String string5 = string4.substring(1);
        Intrinsics.checkNotNullExpressionValue(string5, "this as java.lang.String).substring(startIndex)");
        charSequence = string5;
        if (!StringsKt.endsWith$default(string3, (String)charSequence, false, 2, null)) {
            return false;
        }
        int n = string3.length() - ((String)charSequence).length();
        return n <= 0 || StringsKt.lastIndexOf$default((CharSequence)string3, '.', n - 1, false, 4, null) == -1;
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate x509Certificate) {
        Intrinsics.checkNotNullParameter(x509Certificate, "certificate");
        List<String> list = this.getSubjectAltNames(x509Certificate, 7);
        List<String> list2 = this.getSubjectAltNames(x509Certificate, 2);
        return CollectionsKt.plus((Collection)list, (Iterable)list2);
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int n) {
        try {
            Collection<List<?>> collection = x509Certificate.getSubjectAlternativeNames();
            if (collection == null) {
                return CollectionsKt.emptyList();
            }
            Collection<List<?>> collection2 = collection;
            List list = new ArrayList();
            for (List<?> list2 : collection2) {
                Object obj;
                if (list2 == null || list2.size() < 2 || !Intrinsics.areEqual(list2.get(0), (Object)n) || list2.get(1) == null) continue;
                list.add((String)obj);
            }
            return list;
        }
        catch (CertificateParsingException certificateParsingException) {
            return CollectionsKt.emptyList();
        }
    }
}

