/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.HttpMethod;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", "", "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "call", "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"})
public class RetryAndFollowUpInterceptor
implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final OkHttpClient client;
    private static final int MAX_FOLLOW_UPS = 20;

    public RetryAndFollowUpInterceptor(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        this.client = okHttpClient;
    }

    /*
     * Exception decompiling
     */
    @Override
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain var1_1) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean bl) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if (bl && this.requestIsOneShot(iOException, request)) {
            return false;
        }
        if (!this.isRecoverable(iOException, bl)) {
            return false;
        }
        return realCall.retryAfterFailure();
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody requestBody = request.body();
        return requestBody != null && requestBody.isOneShot() || iOException instanceof FileNotFoundException;
    }

    private final boolean isRecoverable(IOException iOException, boolean bl) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException && !bl;
        }
        if (iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException) {
            return false;
        }
        return !(iOException instanceof SSLPeerUnverifiedException);
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        Object object = exchange;
        Route route = object != null && (object = ((Exchange)object).getConnection$okhttp()) != null ? ((RealConnection)object).route() : null;
        int n = response.code();
        String string = response.request().method();
        switch (n) {
            case 407: {
                Route route2 = route;
                Intrinsics.checkNotNull(route2);
                Proxy proxy = route2.proxy();
                if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.client.proxyAuthenticator().authenticate(route, response);
            }
            case 401: {
                return this.client.authenticator().authenticate(route, response);
            }
            case 300: 
            case 301: 
            case 302: 
            case 303: 
            case 307: 
            case 308: {
                return this.buildRedirectRequest(response, string);
            }
            case 408: {
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody requestBody = response.request().body();
                if (requestBody != null && requestBody.isOneShot()) {
                    return null;
                }
                Response response2 = response.priorResponse();
                if (response2 != null && response2.code() == 408) {
                    return null;
                }
                if (this.retryAfter(response, 0) > 0) {
                    return null;
                }
                return response.request();
            }
            case 503: {
                Response response3 = response.priorResponse();
                if (response3 != null && response3.code() == 503) {
                    return null;
                }
                if (this.retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            case 421: {
                RequestBody requestBody = response.request().body();
                if (requestBody != null && requestBody.isOneShot()) {
                    return null;
                }
                if (exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return response.request();
            }
        }
        return null;
    }

    private final Request buildRedirectRequest(Response response, String string) {
        if (!this.client.followRedirects()) {
            return null;
        }
        String string2 = Response.header$default(response, "Location", null, 2, null);
        if (string2 == null) {
            return null;
        }
        String string3 = string2;
        HttpUrl httpUrl = response.request().url().resolve(string3);
        if (httpUrl == null) {
            return null;
        }
        HttpUrl httpUrl2 = httpUrl;
        boolean bl = Intrinsics.areEqual(httpUrl2.scheme(), response.request().url().scheme());
        if (!bl && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder builder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(string)) {
            boolean bl2;
            int n = response.code();
            boolean bl3 = bl2 = HttpMethod.INSTANCE.redirectsWithBody(string) || n == 308 || n == 307;
            if (HttpMethod.INSTANCE.redirectsToGet(string) && n != 308 && n != 307) {
                builder.method("GET", null);
            } else {
                RequestBody requestBody = bl2 ? response.request().body() : null;
                builder.method(string, requestBody);
            }
            if (!bl2) {
                builder.removeHeader("Transfer-Encoding");
                builder.removeHeader("Content-Length");
                builder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), httpUrl2)) {
            builder.removeHeader("Authorization");
        }
        return builder.url(httpUrl2).build();
    }

    private final int retryAfter(Response response, int n) {
        String string = Response.header$default(response, "Retry-After", null, 2, null);
        if (string == null) {
            return n;
        }
        String string2 = string;
        CharSequence charSequence = string2;
        if (new Regex("\\d+").matches(charSequence)) {
            Integer n2 = Integer.valueOf(string2);
            Intrinsics.checkNotNullExpressionValue(n2, "valueOf(header)");
            return ((Number)n2).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "()V", "MAX_FOLLOW_UPS", "", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

