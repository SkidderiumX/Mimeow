/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lokhttp3/internal/cache/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(Lokhttp3/Request;Lokhttp3/Response;)V", "getCacheResponse", "()Lokhttp3/Response;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "okhttp"})
public class CacheStrategy {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Request networkRequest;
    @Nullable
    private final Response cacheResponse;

    public CacheStrategy(@Nullable Request request, @Nullable Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    @Nullable
    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    @Nullable
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "()V", "isCacheable", "", "response", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isCacheable(@NotNull Response response, @NotNull Request request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            switch (response.code()) {
                case 200: 
                case 203: 
                case 204: 
                case 300: 
                case 301: 
                case 308: 
                case 404: 
                case 405: 
                case 410: 
                case 414: 
                case 501: {
                    break;
                }
                case 302: 
                case 307: {
                    if (Response.header$default(response, "Expires", null, 2, null) != null || response.cacheControl().maxAgeSeconds() != -1 || response.cacheControl().isPublic() || response.cacheControl().isPrivate()) break;
                    return false;
                }
                default: {
                    return false;
                }
            }
            return !response.cacheControl().noStore() && !request.cacheControl().noStore();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "nowMillis", "", "request", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(JLokhttp3/Request;Lokhttp3/Response;)V", "ageSeconds", "", "etag", "", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "getRequest$okhttp", "()Lokhttp3/Request;", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "computeFreshnessLifetime", "hasConditions", "", "isFreshnessLifetimeHeuristic", "okhttp"})
    public static final class Factory {
        private final long nowMillis;
        @NotNull
        private final Request request;
        @Nullable
        private final Response cacheResponse;
        @Nullable
        private Date servedDate;
        @Nullable
        private String servedDateString;
        @Nullable
        private Date lastModified;
        @Nullable
        private String lastModifiedString;
        @Nullable
        private Date expires;
        private long sentRequestMillis;
        private long receivedResponseMillis;
        @Nullable
        private String etag;
        private int ageSeconds;

        public Factory(long l, @NotNull Request request, @Nullable Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.nowMillis = l;
            this.request = request;
            this.cacheResponse = response;
            this.ageSeconds = -1;
            if (this.cacheResponse != null) {
                this.sentRequestMillis = this.cacheResponse.sentRequestAtMillis();
                this.receivedResponseMillis = this.cacheResponse.receivedResponseAtMillis();
                Headers headers = this.cacheResponse.headers();
                int n = headers.size();
                for (int i = 0; i < n; ++i) {
                    String string = headers.name(i);
                    String string2 = headers.value(i);
                    if (StringsKt.equals(string, "Date", true)) {
                        this.servedDate = DatesKt.toHttpDateOrNull(string2);
                        this.servedDateString = string2;
                        continue;
                    }
                    if (StringsKt.equals(string, "Expires", true)) {
                        this.expires = DatesKt.toHttpDateOrNull(string2);
                        continue;
                    }
                    if (StringsKt.equals(string, "Last-Modified", true)) {
                        this.lastModified = DatesKt.toHttpDateOrNull(string2);
                        this.lastModifiedString = string2;
                        continue;
                    }
                    if (StringsKt.equals(string, "ETag", true)) {
                        this.etag = string2;
                        continue;
                    }
                    if (!StringsKt.equals(string, "Age", true)) continue;
                    this.ageSeconds = Util.toNonNegativeInt(string2, -1);
                }
            }
        }

        @NotNull
        public final Request getRequest$okhttp() {
            return this.request;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull(response);
            return response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        @NotNull
        public final CacheStrategy compute() {
            CacheStrategy cacheStrategy = this.computeCandidate();
            if (cacheStrategy.getNetworkRequest() != null && this.request.cacheControl().onlyIfCached()) {
                return new CacheStrategy(null, null);
            }
            return cacheStrategy;
        }

        private final CacheStrategy computeCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!Companion.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || this.hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long l = this.cacheResponseAge();
            long l2 = this.computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                l2 = Math.min(l2, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long l3 = 0L;
            if (cacheControl.minFreshSeconds() != -1) {
                l3 = TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds());
            }
            long l4 = 0L;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                l4 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache() && l + l3 < l2 + l4) {
                long l5;
                Response.Builder builder = this.cacheResponse.newBuilder();
                if (l + l3 >= l2) {
                    builder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (l > (l5 = 86400000L) && this.isFreshnessLifetimeHeuristic()) {
                    builder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new CacheStrategy(null, builder.build());
            }
            String string = null;
            String string2 = null;
            if (this.etag != null) {
                string = "If-None-Match";
                string2 = this.etag;
            } else if (this.lastModified != null) {
                string = "If-Modified-Since";
                string2 = this.lastModifiedString;
            } else if (this.servedDate != null) {
                string = "If-Modified-Since";
                string2 = this.servedDateString;
            } else {
                return new CacheStrategy(this.request, null);
            }
            Headers.Builder builder = this.request.headers().newBuilder();
            String string3 = string2;
            Intrinsics.checkNotNull(string3);
            builder.addLenient$okhttp(string, string3);
            Request request = this.request.newBuilder().headers(builder.build()).build();
            return new CacheStrategy(request, this.cacheResponse);
        }

        private final long computeFreshnessLifetime() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull(response);
            CacheControl cacheControl = response.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long l = date2 != null ? date2.getTime() : this.receivedResponseMillis;
                long l2 = date.getTime() - l;
                return l2 > 0L ? l2 : 0L;
            }
            if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
                Date date3 = this.servedDate;
                long l = date3 != null ? date3.getTime() : this.sentRequestMillis;
                Date date4 = this.lastModified;
                Intrinsics.checkNotNull(date4);
                long l3 = l - date4.getTime();
                return l3 > 0L ? l3 / (long)10 : 0L;
            }
            return 0L;
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long l = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            long l2 = this.ageSeconds != -1 ? Math.max(l, TimeUnit.SECONDS.toMillis(this.ageSeconds)) : l;
            long l3 = this.receivedResponseMillis - this.sentRequestMillis;
            long l4 = this.nowMillis - this.receivedResponseMillis;
            return l2 + l3 + l4;
        }

        private final boolean hasConditions(Request request) {
            return request.header("If-Modified-Since") != null || request.header("If-None-Match") != null;
        }
    }
}

