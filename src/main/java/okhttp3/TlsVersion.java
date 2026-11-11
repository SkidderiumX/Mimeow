/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0006R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2={"Lokhttp3/TlsVersion;", "", "javaName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "Companion", "okhttp"})
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    private static final TlsVersion[] $VALUES_REF;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String javaName;





    

    private TlsVersion(String string2) {
        this.javaName = string2;
    }

    @JvmName(name="javaName")
    @NotNull
    public final String javaName() {
        return this.javaName;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="javaName", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_javaName")
    @NotNull
    public final String m4c4b62e687() {
        return this.javaName;
    }



    @JvmStatic
    @NotNull
    public static final TlsVersion forJavaName(@NotNull String string) {
        return Companion.forJavaName(string);
    }

    static {





        $VALUES_REF = new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0, TlsVersion.SSL_3_0};
        Companion = new Companion(null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Lokhttp3/TlsVersion$Companion;", "", "()V", "forJavaName", "Lokhttp3/TlsVersion;", "javaName", "", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final TlsVersion forJavaName(@NotNull String string) {
            TlsVersion tlsVersion;
            Intrinsics.checkNotNullParameter(string, "javaName");
            switch (string) {
                case "TLSv1.3": {
                    tlsVersion = TLS_1_3;
                    break;
                }
                case "TLSv1.2": {
                    tlsVersion = TLS_1_2;
                    break;
                }
                case "TLSv1.1": {
                    tlsVersion = TLS_1_1;
                    break;
                }
                case "TLSv1": {
                    tlsVersion = TLS_1_0;
                    break;
                }
                case "SSLv3": {
                    tlsVersion = SSL_3_0;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unexpected TLS version: " + string);
                }
            }
            return tlsVersion;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

