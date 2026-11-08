/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.CipherSuite;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0002#$B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0000\u00a2\u0006\u0002\b\u0017J\u0015\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0015J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b J\u0015\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\rR\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000e\u00a8\u0006%"}, d2={"Lokhttp3/ConnectionSpec;", "", "isTls", "", "supportsTlsExtensions", "cipherSuitesAsString", "", "", "tlsVersionsAsString", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "cipherSuites", "", "Lokhttp3/CipherSuite;", "()Ljava/util/List;", "[Ljava/lang/String;", "()Z", "tlsVersions", "Lokhttp3/TlsVersion;", "apply", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "apply$okhttp", "-deprecated_cipherSuites", "equals", "other", "hashCode", "", "isCompatible", "socket", "supportedSpec", "-deprecated_supportsTlsExtensions", "-deprecated_tlsVersions", "toString", "Builder", "Companion", "okhttp"})
@SourceDebugExtension(value={"SMAP\nConnectionSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionSpec.kt\nokhttp3/ConnectionSpec\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,350:1\n11065#2:351\n11400#2,3:352\n11065#2:355\n11400#2,3:356\n*S KotlinDebug\n*F\n+ 1 ConnectionSpec.kt\nokhttp3/ConnectionSpec\n*L\n59#1:351\n59#1:352,3\n75#1:355\n75#1:356,3\n*E\n"})
public class ConnectionSpec {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    @Nullable
    private final String[] cipherSuitesAsString;
    @Nullable
    private final String[] tlsVersionsAsString;
    @NotNull
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES;
    @NotNull
    private static final CipherSuite[] APPROVED_CIPHER_SUITES;
    @JvmField
    @NotNull
    public static final ConnectionSpec RESTRICTED_TLS;
    @JvmField
    @NotNull
    public static final ConnectionSpec MODERN_TLS;
    @JvmField
    @NotNull
    public static final ConnectionSpec COMPATIBLE_TLS;
    @JvmField
    @NotNull
    public static final ConnectionSpec CLEARTEXT;

    public ConnectionSpec(boolean bl, boolean bl2, @Nullable String[] stringArray, @Nullable String[] stringArray2) {
        this.isTls = bl;
        this.supportsTlsExtensions = bl2;
        this.cipherSuitesAsString = stringArray;
        this.tlsVersionsAsString = stringArray2;
    }

    @JvmName(name="isTls")
    public final boolean isTls() {
        return this.isTls;
    }

    @JvmName(name="supportsTlsExtensions")
    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @JvmName(name="cipherSuites")
    @Nullable
    public final List<CipherSuite> cipherSuites() {
        List list;
        if (this.cipherSuitesAsString != null) {
            String[] stringArray = this.cipherSuitesAsString;
            boolean bl = false;
            String[] stringArray2 = stringArray;
            Collection collection = new ArrayList(stringArray.length);
            boolean bl2 = false;
            int n = stringArray2.length;
            for (int i = 0; i < n; ++i) {
                String string;
                String string2 = string = stringArray2[i];
                Collection collection2 = collection;
                boolean bl3 = false;
                collection2.add(CipherSuite.Companion.forJavaName(string2));
            }
            list = CollectionsKt.toList((List)collection);
        } else {
            list = null;
        }
        return list;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="cipherSuites", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_cipherSuites")
    @Nullable
    public final List<CipherSuite> m60b1c46c95() {
        return this.cipherSuites();
    }

    @JvmName(name="tlsVersions")
    @Nullable
    public final List<TlsVersion> tlsVersions() {
        List list;
        if (this.tlsVersionsAsString != null) {
            String[] stringArray = this.tlsVersionsAsString;
            boolean bl = false;
            String[] stringArray2 = stringArray;
            Collection collection = new ArrayList(stringArray.length);
            boolean bl2 = false;
            int n = stringArray2.length;
            for (int i = 0; i < n; ++i) {
                String string;
                String string2 = string = stringArray2[i];
                Collection collection2 = collection;
                boolean bl3 = false;
                collection2.add(TlsVersion.Companion.forJavaName(string2));
            }
            list = CollectionsKt.toList((List)collection);
        } else {
            list = null;
        }
        return list;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="tlsVersions", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_tlsVersions")
    @Nullable
    public final List<TlsVersion> mb059bfc0a9() {
        return this.tlsVersions();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="supportsTlsExtensions", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_supportsTlsExtensions")
    public final boolean m651900360b() {
        return this.supportsTlsExtensions;
    }

    public final void apply$okhttp(@NotNull SSLSocket sSLSocket, boolean bl) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        ConnectionSpec connectionSpec = this.supportedSpec(sSLSocket, bl);
        if (connectionSpec.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(connectionSpec.tlsVersionsAsString);
        }
        if (connectionSpec.cipherSuites() != null) {
            sSLSocket.setEnabledCipherSuites(connectionSpec.cipherSuitesAsString);
        }
    }

    private final ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean bl) {
        String[] stringArray;
        String[] stringArray2;
        String[] stringArray3;
        if (this.cipherSuitesAsString != null) {
            String[] stringArray4 = sSLSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(stringArray4, "sslSocket.enabledCipherSuites");
            stringArray3 = Util.intersect(stringArray4, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        } else {
            stringArray3 = stringArray2 = sSLSocket.getEnabledCipherSuites();
        }
        if (this.tlsVersionsAsString != null) {
            String[] stringArray5 = sSLSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(stringArray5, "sslSocket.enabledProtocols");
            stringArray = Util.intersect(stringArray5, this.tlsVersionsAsString, ComparisonsKt.naturalOrder());
        } else {
            stringArray = sSLSocket.getEnabledProtocols();
        }
        String[] stringArray6 = stringArray;
        String[] stringArray7 = sSLSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(stringArray7, "supportedCipherSuites");
        int n = Util.indexOf(stringArray7, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        if (bl && n != -1) {
            Intrinsics.checkNotNullExpressionValue(stringArray2, "cipherSuitesIntersection");
            String string = stringArray7[n];
            Intrinsics.checkNotNullExpressionValue(string, "supportedCipherSuites[indexOfFallbackScsv]");
            stringArray2 = Util.concat(stringArray2, string);
        }
        Builder builder = new Builder(this);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "cipherSuitesIntersection");
        String[] stringArray8 = stringArray2;
        Builder builder2 = builder.cipherSuites(Arrays.copyOf(stringArray8, stringArray8.length));
        Intrinsics.checkNotNullExpressionValue(stringArray6, "tlsVersionsIntersection");
        stringArray8 = stringArray6;
        return builder2.tlsVersions(Arrays.copyOf(stringArray8, stringArray8.length)).build();
    }

    public final boolean isCompatible(@NotNull SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter(sSLSocket, "socket");
        if (!this.isTls) {
            return false;
        }
        if (this.tlsVersionsAsString != null && !Util.hasIntersection(this.tlsVersionsAsString, sSLSocket.getEnabledProtocols(), ComparisonsKt.naturalOrder())) {
            return false;
        }
        return this.cipherSuitesAsString == null || Util.hasIntersection(this.cipherSuitesAsString, sSLSocket.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp());
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof ConnectionSpec)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (this.isTls != ((ConnectionSpec)object).isTls) {
            return false;
        }
        if (this.isTls) {
            if (!Arrays.equals(this.cipherSuitesAsString, ((ConnectionSpec)object).cipherSuitesAsString)) {
                return false;
            }
            if (!Arrays.equals(this.tlsVersionsAsString, ((ConnectionSpec)object).tlsVersionsAsString)) {
                return false;
            }
            if (this.supportsTlsExtensions != ((ConnectionSpec)object).supportsTlsExtensions) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 17;
        if (this.isTls) {
            n = 31 * n + (this.cipherSuitesAsString != null ? Arrays.hashCode(this.cipherSuitesAsString) : 0);
            n = 31 * n + (this.tlsVersionsAsString != null ? Arrays.hashCode(this.tlsVersionsAsString) : 0);
            n = 31 * n + (this.supportsTlsExtensions ? 0 : 1);
        }
        return n;
    }

    @NotNull
    public String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(this.cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(this.tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }

    static {
        Object[] objectArray = new CipherSuite[]{CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
        RESTRICTED_CIPHER_SUITES = objectArray;
        objectArray = new CipherSuite[]{CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = objectArray;
        objectArray = RESTRICTED_CIPHER_SUITES;
        Builder builder = new Builder(true).cipherSuites(Arrays.copyOf(objectArray, objectArray.length));
        objectArray = new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2};
        RESTRICTED_TLS = builder.tlsVersions((TlsVersion[])objectArray).supportsTlsExtensions(true).build();
        objectArray = APPROVED_CIPHER_SUITES;
        Builder builder2 = new Builder(true).cipherSuites(Arrays.copyOf(objectArray, objectArray.length));
        objectArray = new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2};
        MODERN_TLS = builder2.tlsVersions((TlsVersion[])objectArray).supportsTlsExtensions(true).build();
        objectArray = APPROVED_CIPHER_SUITES;
        Builder builder3 = new Builder(true).cipherSuites(Arrays.copyOf(objectArray, objectArray.length));
        objectArray = new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0};
        COMPATIBLE_TLS = builder3.tlsVersions((TlsVersion[])objectArray).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u0000J\u0006\u0010\u001b\u001a\u00020\u0006J\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n\u00a2\u0006\u0002\u0010\u001cJ\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\t\"\u00020\u001d\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0007J\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n\u00a2\u0006\u0002\u0010\u001cJ\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\t\"\u00020\u001f\u00a2\u0006\u0002\u0010 R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0004R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e\u00a8\u0006!"}, d2={"Lokhttp3/ConnectionSpec$Builder;", "", "tls", "", "(Z)V", "connectionSpec", "Lokhttp3/ConnectionSpec;", "(Lokhttp3/ConnectionSpec;)V", "cipherSuites", "", "", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "supportsTlsExtensions", "getSupportsTlsExtensions$okhttp", "()Z", "setSupportsTlsExtensions$okhttp", "getTls$okhttp", "setTls$okhttp", "tlsVersions", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "allEnabledCipherSuites", "allEnabledTlsVersions", "build", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/CipherSuite;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/TlsVersion;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nConnectionSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionSpec.kt\nokhttp3/ConnectionSpec$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,350:1\n1#2:351\n11065#3:352\n11400#3,3:353\n11065#3:358\n11400#3,3:359\n37#4,2:356\n37#4,2:362\n*S KotlinDebug\n*F\n+ 1 ConnectionSpec.kt\nokhttp3/ConnectionSpec$Builder\n*L\n225#1:352\n225#1:353,3\n244#1:358\n244#1:359,3\n225#1:356,2\n244#1:362,2\n*E\n"})
    public static final class Builder {
        private boolean tls;
        @Nullable
        private String[] cipherSuites;
        @Nullable
        private String[] tlsVersions;
        private boolean supportsTlsExtensions;

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        public final void setTls$okhttp(boolean bl) {
            this.tls = bl;
        }

        @Nullable
        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final void setCipherSuites$okhttp(@Nullable String[] stringArray) {
            this.cipherSuites = stringArray;
        }

        @Nullable
        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setTlsVersions$okhttp(@Nullable String[] stringArray) {
            this.tlsVersions = stringArray;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean bl) {
            this.supportsTlsExtensions = bl;
        }

        public Builder(boolean bl) {
            this.tls = bl;
        }

        public Builder(@NotNull ConnectionSpec connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.isTls();
            this.cipherSuites = connectionSpec.cipherSuitesAsString;
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
        }

        @NotNull
        public final Builder allEnabledCipherSuites() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!builder2.tls) {
                boolean bl2 = false;
                String string = "no cipher suites for cleartext connections";
                throw new IllegalArgumentException(string.toString());
            }
            builder2.cipherSuites = null;
            return builder;
        }

        @NotNull
        public final Builder cipherSuites(CipherSuite ... cipherSuiteArray) {
            Intrinsics.checkNotNullParameter(cipherSuiteArray, "cipherSuites");
            Builder builder = this;
            boolean bl = false;
            if (!builder.tls) {
                boolean bl2 = false;
                String string = "no cipher suites for cleartext connections";
                throw new IllegalArgumentException(string.toString());
            }
            Object object = cipherSuiteArray;
            boolean bl3 = false;
            CipherSuite[] cipherSuiteArray2 = object;
            Collection collection = new ArrayList(((CipherSuite[])object).length);
            boolean bl4 = false;
            int n = cipherSuiteArray2.length;
            for (int i = 0; i < n; ++i) {
                CipherSuite cipherSuite;
                CipherSuite cipherSuite2 = cipherSuite = cipherSuiteArray2[i];
                Collection collection2 = collection;
                boolean bl5 = false;
                collection2.add(cipherSuite2.javaName());
            }
            object = (List)collection;
            bl3 = false;
            cipherSuiteArray2 = object;
            String[] stringArray = cipherSuiteArray2.toArray(new String[0]);
            return builder.cipherSuites(Arrays.copyOf(stringArray, stringArray.length));
        }

        @NotNull
        public final Builder cipherSuites(String ... stringArray) {
            Builder builder;
            Intrinsics.checkNotNullParameter(stringArray, "cipherSuites");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!builder2.tls) {
                boolean bl2 = false;
                String string = "no cipher suites for cleartext connections";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(!(stringArray.length == 0))) {
                boolean bl3 = false;
                String string = "At least one cipher suite is required";
                throw new IllegalArgumentException(string.toString());
            }
            builder2.cipherSuites = (String[])stringArray.clone();
            return builder;
        }

        @NotNull
        public final Builder allEnabledTlsVersions() {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!builder2.tls) {
                boolean bl2 = false;
                String string = "no TLS versions for cleartext connections";
                throw new IllegalArgumentException(string.toString());
            }
            builder2.tlsVersions = null;
            return builder;
        }

        @NotNull
        public final Builder tlsVersions(TlsVersion ... tlsVersionArray) {
            Intrinsics.checkNotNullParameter(tlsVersionArray, "tlsVersions");
            Builder builder = this;
            boolean bl = false;
            if (!builder.tls) {
                boolean bl2 = false;
                String string = "no TLS versions for cleartext connections";
                throw new IllegalArgumentException(string.toString());
            }
            Object object = tlsVersionArray;
            boolean bl3 = false;
            TlsVersion[] tlsVersionArray2 = object;
            Collection collection = new ArrayList(((TlsVersion[])object).length);
            boolean bl4 = false;
            int n = tlsVersionArray2.length;
            for (int i = 0; i < n; ++i) {
                TlsVersion tlsVersion;
                TlsVersion tlsVersion2 = tlsVersion = tlsVersionArray2[i];
                Collection collection2 = collection;
                boolean bl5 = false;
                collection2.add(tlsVersion2.javaName());
            }
            object = (List)collection;
            bl3 = false;
            tlsVersionArray2 = object;
            String[] stringArray = tlsVersionArray2.toArray(new String[0]);
            return builder.tlsVersions(Arrays.copyOf(stringArray, stringArray.length));
        }

        @NotNull
        public final Builder tlsVersions(String ... stringArray) {
            Builder builder;
            Intrinsics.checkNotNullParameter(stringArray, "tlsVersions");
            Builder builder2 = builder = this;
            boolean bl = false;
            if (!builder2.tls) {
                boolean bl2 = false;
                String string = "no TLS versions for cleartext connections";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(!(stringArray.length == 0))) {
                boolean bl3 = false;
                String string = "At least one TLS version is required";
                throw new IllegalArgumentException(string.toString());
            }
            builder2.tlsVersions = (String[])stringArray.clone();
            return builder;
        }

        @Deprecated(message="since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        @NotNull
        public final Builder supportsTlsExtensions(boolean bl) {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl2 = false;
            if (!builder2.tls) {
                boolean bl3 = false;
                String string = "no TLS extensions for cleartext connections";
                throw new IllegalArgumentException(string.toString());
            }
            builder2.supportsTlsExtensions = bl;
            return builder;
        }

        @NotNull
        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokhttp3/ConnectionSpec$Companion;", "", "()V", "APPROVED_CIPHER_SUITES", "", "Lokhttp3/CipherSuite;", "[Lokhttp3/CipherSuite;", "CLEARTEXT", "Lokhttp3/ConnectionSpec;", "COMPATIBLE_TLS", "MODERN_TLS", "RESTRICTED_CIPHER_SUITES", "RESTRICTED_TLS", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

