/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "cookieHeader", "", "cookies", "", "Lokhttp3/Cookie;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"})
@SourceDebugExtension(value={"SMAP\nBridgeInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BridgeInterceptor.kt\nokhttp3/internal/http/BridgeInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,117:1\n1864#2,3:118\n*S KotlinDebug\n*F\n+ 1 BridgeInterceptor.kt\nokhttp3/internal/http/BridgeInterceptor\n*L\n111#1:118,3\n*E\n"})
public class BridgeInterceptor
implements Interceptor {
    @NotNull
    private final CookieJar cookieJar;

    public BridgeInterceptor(@NotNull CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    @Override
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        ResponseBody responseBody;
        List<Cookie> list;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            long l;
            MediaType mediaType = requestBody.contentType();
            if (mediaType != null) {
                builder.header("Content-Type", mediaType.toString());
            }
            if ((l = requestBody.contentLength()) != -1L) {
                builder.header("Content-Length", String.valueOf(l));
                builder.removeHeader("Transfer-Encoding");
            } else {
                builder.header("Transfer-Encoding", "chunked");
                builder.removeHeader("Content-Length");
            }
        }
        if (request.header("Host") == null) {
            builder.header("Host", Util.toHostHeader$default(request.url(), false, 1, null));
        }
        if (request.header("Connection") == null) {
            builder.header("Connection", "Keep-Alive");
        }
        boolean bl = false;
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            bl = true;
            builder.header("Accept-Encoding", "gzip");
        }
        if (!((Collection)(list = this.cookieJar.loadForRequest(request.url()))).isEmpty()) {
            builder.header("Cookie", this.cookieHeader(list));
        }
        if (request.header("User-Agent") == null) {
            builder.header("User-Agent", "okhttp/4.12.0");
        }
        Response response = chain.proceed(builder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), response.headers());
        Response.Builder builder2 = response.newBuilder().request(request);
        if (bl && StringsKt.equals("gzip", Response.header$default(response, "Content-Encoding", null, 2, null), true) && HttpHeaders.promisesBody(response) && (responseBody = response.body()) != null) {
            GzipSource gzipSource = new GzipSource(responseBody.source());
            Headers headers = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
            builder2.headers(headers);
            String string = Response.header$default(response, "Content-Type", null, 2, null);
            builder2.body(new RealResponseBody(string, -1L, Okio.buffer(gzipSource)));
        }
        return builder2.build();
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
        boolean bl = false;
        Iterable iterable = list;
        boolean bl2 = false;
        int n = 0;
        for (Object t : iterable) {
            int n2;
            if ((n2 = n++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Cookie cookie = (Cookie)t;
            int n3 = n2;
            boolean bl3 = false;
            if (n3 > 0) {
                stringBuilder2.append("; ");
            }
            stringBuilder2.append(cookie.name()).append('=').append(cookie.value());
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}

