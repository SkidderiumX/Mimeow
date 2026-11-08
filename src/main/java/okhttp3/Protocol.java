/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2={"Lokhttp3/Protocol;", "", "protocol", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "Companion", "okhttp"})
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    @Deprecated(message="OkHttp has dropped support for SPDY. Prefer {@link #HTTP_2}.") SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    private static final Protocol[] $VALUES_REF;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String protocol;






    

    private Protocol(String string2) {
        this.protocol = string2;
    }

    @NotNull
    public String toString() {
        return this.protocol;
    }



    @JvmStatic
    @NotNull
    public static final Protocol get(@NotNull String string) throws IOException {
        return Companion.get(string);
    }

    static {






        $VALUES_REF = new Protocol[]{Protocol.HTTP_1_0, Protocol.HTTP_1_1, Protocol.SPDY_3, Protocol.HTTP_2, Protocol.H2_PRIOR_KNOWLEDGE, Protocol.QUIC};
        Companion = new Companion(null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Lokhttp3/Protocol$Companion;", "", "()V", "get", "Lokhttp3/Protocol;", "protocol", "", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Protocol get(@NotNull String string) throws IOException {
            Protocol protocol;
            Intrinsics.checkNotNullParameter(string, "protocol");
            String string2 = string;
            if (Intrinsics.areEqual(string2, HTTP_1_0.protocol)) {
                protocol = HTTP_1_0;
            } else if (Intrinsics.areEqual(string2, HTTP_1_1.protocol)) {
                protocol = HTTP_1_1;
            } else if (Intrinsics.areEqual(string2, H2_PRIOR_KNOWLEDGE.protocol)) {
                protocol = H2_PRIOR_KNOWLEDGE;
            } else if (Intrinsics.areEqual(string2, HTTP_2.protocol)) {
                protocol = HTTP_2;
            } else if (Intrinsics.areEqual(string2, SPDY_3.protocol)) {
                protocol = SPDY_3;
            } else if (Intrinsics.areEqual(string2, QUIC.protocol)) {
                protocol = QUIC;
            } else {
                throw new IOException("Unexpected protocol: " + string);
            }
            return protocol;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

