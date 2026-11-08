/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0000\u00a2\u0006\u0002\b\u0014J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H\u0007\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006$"}, d2={"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "getPins", "()Ljava/util/Set;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", "other", "findMatchingPins", "hashCode", "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"})
@SourceDebugExtension(value={"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,370:1\n625#2,8:371\n*S KotlinDebug\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n*L\n216#1:371,8\n*E\n"})
public class CertificatePinner {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Set<Pin> pins;
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    @JvmField
    @NotNull
    public static final CertificatePinner DEFAULT = new Builder().build();

    public CertificatePinner(@NotNull Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            certificateChainCleaner = null;
        }
        this(set, certificateChainCleaner);
    }

    @NotNull
    public final Set<Pin> getPins() {
        return this.pins;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final void check(@NotNull String string, @NotNull List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(string, "hostname");
        Intrinsics.checkNotNullParameter(list, "peerCertificates");
        this.check$okhttp(string, (Function0<? extends List<? extends X509Certificate>>)new Function0<List<? extends X509Certificate>>(this, list, string){
            final /* synthetic */ CertificatePinner this$0;
            final /* synthetic */ List<Certificate> $peerCertificates;
            final /* synthetic */ String $hostname;
            {
                this.this$0 = certificatePinner;
                this.$peerCertificates = list;
                this.$hostname = string;
                super(0);
            }

            @NotNull
            public final List<X509Certificate> invoke() {
                Object object = this.this$0.getCertificateChainCleaner$okhttp();
                if (object == null || (object = ((CertificateChainCleaner)object).clean(this.$peerCertificates, this.$hostname)) == null) {
                    object = this.$peerCertificates;
                }
                Iterable iterable = (Iterable)object;
                boolean bl = false;
                Iterable iterable2 = iterable;
                Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                boolean bl2 = false;
                for (T t : iterable2) {
                    Certificate certificate = (Certificate)t;
                    Collection collection2 = collection;
                    boolean bl3 = false;
                    Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    collection2.add((X509Certificate)certificate);
                }
                return (List)collection;
            }
        });
    }

    public final void check$okhttp(@NotNull String string, @NotNull Function0<? extends List<? extends X509Certificate>> function0) {
        Comparable<StringBuilder> comparable;
        Intrinsics.checkNotNullParameter(string, "hostname");
        Intrinsics.checkNotNullParameter(function0, "cleanedPeerCertificatesFn");
        List<Pin> list = this.findMatchingPins(string);
        if (list.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> list2 = function0.invoke();
        for (X509Certificate serializable22 : list2) {
            comparable = null;
            ByteString bl = null;
            for (Pin pin : list) {
                String string2 = pin.getHashAlgorithm();
                if (Intrinsics.areEqual(string2, "sha256")) {
                    if (bl == null) {
                        bl = Companion.sha256Hash(serializable22);
                    }
                    if (!Intrinsics.areEqual(pin.getHash(), bl)) continue;
                    return;
                }
                if (Intrinsics.areEqual(string2, "sha1")) {
                    if (comparable == null) {
                        comparable = Companion.sha1Hash(serializable22);
                    }
                    if (!Intrinsics.areEqual(pin.getHash(), comparable)) continue;
                    return;
                }
                throw new AssertionError((Object)("unsupported hashAlgorithm: " + pin.getHashAlgorithm()));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        comparable = stringBuilder;
        boolean bl = false;
        ((StringBuilder)comparable).append("Certificate pinning failure!");
        ((StringBuilder)comparable).append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate : list2) {
            ((StringBuilder)comparable).append("\n    ");
            ((StringBuilder)comparable).append(Companion.pin(x509Certificate));
            ((StringBuilder)comparable).append(": ");
            ((StringBuilder)comparable).append(x509Certificate.getSubjectDN().getName());
        }
        ((StringBuilder)comparable).append("\n  Pinned certificates for ");
        ((StringBuilder)comparable).append(string);
        ((StringBuilder)comparable).append(":");
        for (Pin pin : list) {
            ((StringBuilder)comparable).append("\n    ");
            ((StringBuilder)comparable).append(pin);
        }
        String string3 = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "StringBuilder().apply(builderAction).toString()");
        String string4 = string3;
        throw new SSLPeerUnverifiedException(string4);
    }

    @Deprecated(message="replaced with {@link #check(String, List)}.", replaceWith=@ReplaceWith(expression="check(hostname, peerCertificates.toList())", imports={}))
    public final void check(@NotNull String string, Certificate ... certificateArray) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(string, "hostname");
        Intrinsics.checkNotNullParameter(certificateArray, "peerCertificates");
        this.check(string, ArraysKt.toList(certificateArray));
    }

    @NotNull
    public final List<Pin> findMatchingPins(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "hostname");
        Iterable iterable = this.pins;
        boolean bl = false;
        List list = CollectionsKt.emptyList();
        for (Object t : iterable) {
            Pin pin = (Pin)t;
            boolean bl2 = false;
            if (!pin.matchesHostname(string)) continue;
            if (list.isEmpty()) {
                list = new ArrayList();
            }
            List list2 = list;
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
            TypeIntrinsics.asMutableList(list2).add(t);
        }
        return list;
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
        return Intrinsics.areEqual(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof CertificatePinner && Intrinsics.areEqual(((CertificatePinner)object).pins, this.pins) && Intrinsics.areEqual(((CertificatePinner)object).certificateChainCleaner, this.certificateChainCleaner);
    }

    public int hashCode() {
        int n = 37;
        n = 41 * n + ((Object)this.pins).hashCode();
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        n = 41 * n + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
        return n;
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    @JvmStatic
    @NotNull
    public static final String pin(@NotNull Certificate certificate) {
        return Companion.pin(certificate);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b\"\u00020\n\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2={"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", "add", "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"})
    public static final class Builder {
        @NotNull
        private final List<Pin> pins = new ArrayList();

        @NotNull
        public final List<Pin> getPins() {
            return this.pins;
        }

        @NotNull
        public final Builder add(@NotNull String string, String ... stringArray) {
            Builder builder;
            Intrinsics.checkNotNullParameter(string, "pattern");
            Intrinsics.checkNotNullParameter(stringArray, "pins");
            Builder builder2 = builder = this;
            boolean bl = false;
            for (String string2 : stringArray) {
                builder2.pins.add(new Pin(string, string2));
            }
            return builder;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt.toSet((Iterable)this.pins), null, 2, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "pin", "", "certificate", "Ljava/security/cert/Certificate;", "sha1Hash", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,370:1\n1#2:371\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            byte[] byArray = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(byArray, "publicKey.encoded");
            return ByteString.Companion.of$default(ByteString.Companion, byArray, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            byte[] byArray = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(byArray, "publicKey.encoded");
            return ByteString.Companion.of$default(ByteString.Companion, byArray, 0, 0, 3, null).sha256();
        }

        @JvmStatic
        @NotNull
        public final String pin(@NotNull Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                boolean bl = false;
                String string = "Certificate pinning requires X509 certificates";
                throw new IllegalArgumentException(string.toString());
            }
            return "sha256/" + this.sha256Hash((X509Certificate)certificate).base64();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0019"}, d2={"Lokhttp3/CertificatePinner$Pin;", "", "pattern", "", "pin", "(Ljava/lang/String;Ljava/lang/String;)V", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "hashAlgorithm", "getHashAlgorithm", "()Ljava/lang/String;", "getPattern", "equals", "", "other", "hashCode", "", "matchesCertificate", "certificate", "Ljava/security/cert/X509Certificate;", "matchesHostname", "hostname", "toString", "okhttp"})
    public static final class Pin {
        @NotNull
        private final String pattern;
        @NotNull
        private final String hashAlgorithm;
        @NotNull
        private final ByteString hash;

        public Pin(@NotNull String string, @NotNull String string2) {
            Intrinsics.checkNotNullParameter(string, "pattern");
            Intrinsics.checkNotNullParameter(string2, "pin");
            if (!(StringsKt.startsWith$default(string, "*.", false, 2, null) && StringsKt.indexOf$default((CharSequence)string, "*", 1, false, 4, null) == -1 || StringsKt.startsWith$default(string, "**.", false, 2, null) && StringsKt.indexOf$default((CharSequence)string, "*", 2, false, 4, null) == -1 || StringsKt.indexOf$default((CharSequence)string, "*", 0, false, 6, null) == -1)) {
                boolean bl = false;
                String string3 = "Unexpected pattern: " + string;
                throw new IllegalArgumentException(string3.toString());
            }
            String string4 = HostnamesKt.toCanonicalHost(string);
            if (string4 == null) {
                throw new IllegalArgumentException("Invalid pattern: " + string);
            }
            this.pattern = string4;
            if (StringsKt.startsWith$default(string2, "sha1/", false, 2, null)) {
                this.hashAlgorithm = "sha1";
                String string5 = string2.substring(5);
                Intrinsics.checkNotNullExpressionValue(string5, "this as java.lang.String).substring(startIndex)");
                ByteString byteString = ByteString.Companion.decodeBase64(string5);
                if (byteString == null) {
                    throw new IllegalArgumentException("Invalid pin hash: " + string2);
                }
                this.hash = byteString;
            } else if (StringsKt.startsWith$default(string2, "sha256/", false, 2, null)) {
                this.hashAlgorithm = "sha256";
                String string6 = string2.substring(7);
                Intrinsics.checkNotNullExpressionValue(string6, "this as java.lang.String).substring(startIndex)");
                ByteString byteString = ByteString.Companion.decodeBase64(string6);
                if (byteString == null) {
                    throw new IllegalArgumentException("Invalid pin hash: " + string2);
                }
                this.hash = byteString;
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + string2);
            }
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        public final boolean matchesHostname(@NotNull String string) {
            boolean bl;
            Intrinsics.checkNotNullParameter(string, "hostname");
            if (StringsKt.startsWith$default(this.pattern, "**.", false, 2, null)) {
                int n = this.pattern.length() - 3;
                int n2 = string.length() - n;
                bl = StringsKt.regionMatches$default(string, string.length() - n, this.pattern, 3, n, false, 16, null) && (n2 == 0 || string.charAt(n2 - 1) == '.');
            } else if (StringsKt.startsWith$default(this.pattern, "*.", false, 2, null)) {
                int n = this.pattern.length() - 1;
                int n3 = string.length() - n;
                bl = StringsKt.regionMatches$default(string, string.length() - n, this.pattern, 1, n, false, 16, null) && StringsKt.lastIndexOf$default((CharSequence)string, '.', n3 - 1, false, 4, null) == -1;
            } else {
                bl = Intrinsics.areEqual(string, this.pattern);
            }
            return bl;
        }

        public final boolean matchesCertificate(@NotNull X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "certificate");
            String string = this.hashAlgorithm;
            return Intrinsics.areEqual(string, "sha256") ? Intrinsics.areEqual(this.hash, Companion.sha256Hash(x509Certificate)) : (Intrinsics.areEqual(string, "sha1") ? Intrinsics.areEqual(this.hash, Companion.sha1Hash(x509Certificate)) : false);
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }

        public boolean equals(@Nullable Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Pin)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.pattern, ((Pin)object).pattern)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.hashAlgorithm, ((Pin)object).hashAlgorithm)) {
                return false;
            }
            return Intrinsics.areEqual(this.hash, ((Pin)object).hash);
        }

        public int hashCode() {
            int n = this.pattern.hashCode();
            n = 31 * n + this.hashAlgorithm.hashCode();
            n = 31 * n + this.hash.hashCode();
            return n;
        }
    }
}

