/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2={"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"})
public class CacheInterceptor
implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Cache cache;

    public CacheInterceptor(@Nullable Cache cache) {
        this.cache = cache;
    }

    @Nullable
    public final Cache getCache$okhttp() {
        return this.cache;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Response response;
        Object object;
        Response response2;
        Request request;
        Call call;
        block23: {
            ResponseBody responseBody;
            Object object2;
            Intrinsics.checkNotNullParameter(chain, "chain");
            call = chain.call();
            Cache cache = this.cache;
            Response response3 = cache != null ? cache.get$okhttp(chain.request()) : null;
            long l = System.currentTimeMillis();
            CacheStrategy cacheStrategy = new CacheStrategy.Factory(l, chain.request(), response3).compute();
            request = cacheStrategy.getNetworkRequest();
            response2 = cacheStrategy.getCacheResponse();
            Cache cache2 = this.cache;
            if (cache2 != null) {
                cache2.trackResponse$okhttp(cacheStrategy);
            }
            if ((object2 = call instanceof RealCall ? (RealCall)call : null) == null || (object2 = ((RealCall)object2).getEventListener$okhttp()) == null) {
                object2 = object = EventListener.NONE;
            }
            if (response3 != null && response2 == null) {
                ResponseBody responseBody2 = response3.body();
                if (responseBody2 != null) {
                    Util.closeQuietly(responseBody2);
                }
            }
            if (request == null && response2 == null) {
                Response response4;
                Response response5 = response4 = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
                boolean bl = false;
                ((EventListener)object).satisfactionFailure(call, response5);
                return response4;
            }
            if (request == null) {
                Response response6;
                Response response7 = response2;
                Intrinsics.checkNotNull(response7);
                Response response8 = response6 = response7.newBuilder().cacheResponse(CacheInterceptor.Companion.stripBody(response2)).build();
                boolean bl = false;
                ((EventListener)object).cacheHit(call, response8);
                return response6;
            }
            if (response2 != null) {
                ((EventListener)object).cacheConditionalHit(call, response2);
            } else if (this.cache != null) {
                ((EventListener)object).cacheMiss(call);
            }
            response = null;
            try {
                response = chain.proceed(request);
                if (response != null || response3 == null) break block23;
                responseBody = response3.body();
            }
            catch (Throwable throwable) {
                if (response3 != null) {
                    ResponseBody responseBody3 = response3.body();
                    if (responseBody3 != null) {
                        Util.closeQuietly(responseBody3);
                    }
                }
                throw throwable;
            }
            if (responseBody != null) {
                Util.closeQuietly(responseBody);
            }
        }
        if (response2 != null) {
            Response response9 = response;
            boolean bl = response9 != null ? response9.code() == 304 : false;
            if (bl) {
                Response response10;
                Response response11 = response2.newBuilder().headers(CacheInterceptor.Companion.combine(response2.headers(), response.headers())).sentRequestAtMillis(response.sentRequestAtMillis()).receivedResponseAtMillis(response.receivedResponseAtMillis()).cacheResponse(CacheInterceptor.Companion.stripBody(response2)).networkResponse(CacheInterceptor.Companion.stripBody(response)).build();
                ResponseBody responseBody = response.body();
                Intrinsics.checkNotNull(responseBody);
                responseBody.close();
                Cache cache = this.cache;
                Intrinsics.checkNotNull(cache);
                cache.trackConditionalCacheHit$okhttp();
                this.cache.update$okhttp(response2, response11);
                Response response12 = response10 = response11;
                boolean bl2 = false;
                ((EventListener)object).cacheHit(call, response12);
                return response10;
            }
            ResponseBody responseBody = response2.body();
            if (responseBody != null) {
                Util.closeQuietly(responseBody);
            }
        }
        Response response13 = response;
        Intrinsics.checkNotNull(response13);
        Response response14 = response13.newBuilder().cacheResponse(CacheInterceptor.Companion.stripBody(response2)).networkResponse(CacheInterceptor.Companion.stripBody(response)).build();
        if (this.cache != null) {
            if (HttpHeaders.promisesBody(response14) && CacheStrategy.Companion.isCacheable(response14, request)) {
                Response response15;
                CacheRequest cacheRequest = this.cache.put$okhttp(response14);
                Response response16 = response15 = this.cacheWritingResponse(cacheRequest, response14);
                boolean bl = false;
                if (response2 != null) {
                    ((EventListener)object).cacheMiss(call);
                }
                return response15;
            }
            if (HttpMethod.INSTANCE.invalidatesCache(request.method())) {
                try {
                    this.cache.remove$okhttp(request);
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
        return response14;
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink sink2 = cacheRequest.body();
        ResponseBody responseBody = response.body();
        Intrinsics.checkNotNull(responseBody);
        BufferedSource bufferedSource = responseBody.source();
        BufferedSink bufferedSink = Okio.buffer(sink2);
        Source source2 = new Source(bufferedSource, cacheRequest, bufferedSink){
            private boolean cacheRequestClosed;
            final /* synthetic */ BufferedSource $source;
            final /* synthetic */ CacheRequest $cacheRequest;
            final /* synthetic */ BufferedSink $cacheBody;
            {
                this.$source = bufferedSource;
                this.$cacheRequest = cacheRequest;
                this.$cacheBody = bufferedSink;
            }

            public long read(@NotNull Buffer buffer, long l) throws IOException {
                Intrinsics.checkNotNullParameter(buffer, "sink");
                long l2 = 0L;
                try {
                    l2 = this.$source.read(buffer, l);
                }
                catch (IOException iOException) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        this.$cacheRequest.abort();
                    }
                    throw iOException;
                }
                if (l2 == -1L) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        this.$cacheBody.close();
                    }
                    return -1L;
                }
                buffer.copyTo(this.$cacheBody.getBuffer(), buffer.size() - l2, l2);
                this.$cacheBody.emitCompleteSegments();
                return l2;
            }

            @NotNull
            public Timeout timeout() {
                return this.$source.timeout();
            }

            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    this.$cacheRequest.abort();
                }
                this.$source.close();
            }
        };
        String string = Response.header$default(response, "Content-Type", null, 2, null);
        long l = response.body().contentLength();
        return response.newBuilder().body(new RealResponseBody(string, l, Okio.buffer(source2))).build();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a8\u0006\u000f"}, d2={"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        private final Response stripBody(Response response) {
            Response response2 = response;
            return (response2 != null ? response2.body() : null) != null ? response.newBuilder().body(null).build() : response;
        }

        private final Headers combine(Headers headers, Headers headers2) {
            String string;
            int n;
            Headers.Builder builder = new Headers.Builder();
            int n2 = headers.size();
            for (n = 0; n < n2; ++n) {
                string = headers.name(n);
                String string2 = headers.value(n);
                if (StringsKt.equals("Warning", string, true) && StringsKt.startsWith$default(string2, "1", false, 2, null) || !this.isContentSpecificHeader(string) && this.isEndToEnd(string) && headers2.get(string) != null) continue;
                builder.addLenient$okhttp(string, string2);
            }
            n2 = headers2.size();
            for (n = 0; n < n2; ++n) {
                string = headers2.name(n);
                if (this.isContentSpecificHeader(string) || !this.isEndToEnd(string)) continue;
                builder.addLenient$okhttp(string, headers2.value(n));
            }
            return builder.build();
        }

        private final boolean isEndToEnd(String string) {
            return !StringsKt.equals("Connection", string, true) && !StringsKt.equals("Keep-Alive", string, true) && !StringsKt.equals("Proxy-Authenticate", string, true) && !StringsKt.equals("Proxy-Authorization", string, true) && !StringsKt.equals("TE", string, true) && !StringsKt.equals("Trailers", string, true) && !StringsKt.equals("Transfer-Encoding", string, true) && !StringsKt.equals("Upgrade", string, true);
        }

        private final boolean isContentSpecificHeader(String string) {
            return StringsKt.equals("Content-Length", string, true) || StringsKt.equals("Content-Encoding", string, true) || StringsKt.equals("Content-Type", string, true);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

