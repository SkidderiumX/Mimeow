/*
 * Decompiled with CFR 0.152.
 */
package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0004BCDEB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0018\u00010\"R\u00020\fH\u0002J\b\u0010#\u001a\u00020 H\u0016J\u0006\u0010$\u001a\u00020 J\r\u0010\u0003\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b%J\u0006\u0010&\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0016J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0000\u00a2\u0006\u0002\b,J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020 J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0011J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020)H\u0000\u00a2\u0006\u0002\b1J\u0015\u00102\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0000\u00a2\u0006\u0002\b3J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u00104\u001a\u00020\u0006J\r\u00105\u001a\u00020 H\u0000\u00a2\u0006\u0002\b6J\u0015\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H\u0000\u00a2\u0006\u0002\b:J\u001d\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0000\u00a2\u0006\u0002\b>J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b\u00a8\u0006F"}, d2={"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Ljava/io/File;", "maxSize", "", "(Ljava/io/File;J)V", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "()Ljava/io/File;", "hitCount", "", "isClosed", "", "()Z", "networkCount", "requestCount", "writeAbortCount", "getWriteAbortCount$okhttp", "()I", "setWriteAbortCount$okhttp", "(I)V", "writeSuccessCount", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "abortQuietly", "", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "close", "delete", "-deprecated_directory", "evictAll", "flush", "get", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "get$okhttp", "initialize", "put", "Lokhttp3/internal/cache/CacheRequest;", "response", "put$okhttp", "remove", "remove$okhttp", "size", "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "trackResponse", "cacheStrategy", "Lokhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", "update", "cached", "network", "update$okhttp", "urls", "", "", "CacheResponseBody", "Companion", "Entry", "RealCacheRequest", "okhttp"})
public class Cache
implements Closeable,
Flushable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final DiskLruCache cache;
    private int writeSuccessCount;
    private int writeAbortCount;
    private int networkCount;
    private int hitCount;
    private int requestCount;
    private static final int VERSION = 201105;
    private static final int ENTRY_METADATA = 0;
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;

    public Cache(@NotNull File file, long l, @NotNull FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(file, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, file, 201105, 2, l, TaskRunner.INSTANCE);
    }

    @NotNull
    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final void setWriteSuccessCount$okhttp(int n) {
        this.writeSuccessCount = n;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final void setWriteAbortCount$okhttp(int n) {
        this.writeAbortCount = n;
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public Cache(@NotNull File file, long l) {
        Intrinsics.checkNotNullParameter(file, "directory");
        this(file, l, FileSystem.SYSTEM);
    }

    @Nullable
    public final Response get$okhttp(@NotNull Request request) {
        Object object;
        Object object2;
        Intrinsics.checkNotNullParameter(request, "request");
        String string = Companion.key(request.url());
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(string);
            if (snapshot == null) {
                return null;
            }
            object2 = snapshot;
        }
        catch (IOException iOException) {
            return null;
        }
        DiskLruCache.Snapshot snapshot = object2;
        try {
            object = new Entry(snapshot.getSource(0));
        }
        catch (IOException iOException) {
            Util.closeQuietly(snapshot);
            return null;
        }
        object2 = object;
        object = ((Entry)object2).response(snapshot);
        if (!((Entry)object2).matches(request, (Response)object)) {
            ResponseBody responseBody = ((Response)object).body();
            if (responseBody != null) {
                Util.closeQuietly(responseBody);
            }
            return null;
        }
        return object;
    }

    @Nullable
    public final CacheRequest put$okhttp(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        String string = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                this.remove$okhttp(response.request());
            }
            catch (IOException iOException) {
                // empty catch block
            }
            return null;
        }
        if (!Intrinsics.areEqual(string, "GET")) {
            return null;
        }
        if (Companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        DiskLruCache.Editor editor = null;
        try {
            DiskLruCache.Editor editor2 = DiskLruCache.edit$default(this.cache, Companion.key(response.request().url()), 0L, 2, null);
            if (editor2 == null) {
                return null;
            }
            editor = editor2;
            entry.writeTo(editor);
            return new RealCacheRequest(editor);
        }
        catch (IOException iOException) {
            this.abortQuietly(editor);
            return null;
        }
    }

    public final void remove$okhttp(@NotNull Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final void update$okhttp(@NotNull Response response, @NotNull Response response2) {
        Intrinsics.checkNotNullParameter(response, "cached");
        Intrinsics.checkNotNullParameter(response2, "network");
        Entry entry = new Entry(response2);
        ResponseBody responseBody = response.body();
        Intrinsics.checkNotNull(responseBody, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        DiskLruCache.Snapshot snapshot = ((CacheResponseBody)responseBody).getSnapshot();
        DiskLruCache.Editor editor = null;
        try {
            DiskLruCache.Editor editor2 = snapshot.edit();
            if (editor2 == null) {
                return;
            }
            editor = editor2;
            entry.writeTo(editor);
            editor.commit();
        }
        catch (IOException iOException) {
            this.abortQuietly(editor);
        }
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        try {
            DiskLruCache.Editor editor2 = editor;
            if (editor2 != null) {
                editor2.abort();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @NotNull
    public final Iterator<String> urls() throws IOException {
        return new Iterator<String>(this){
            @NotNull
            private final Iterator<DiskLruCache.Snapshot> delegate;
            @Nullable
            private String nextUrl;
            private boolean canRemove;
            {
                this.delegate = cache.getCache$okhttp().snapshots();
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    try {
                        Closeable closeable = this.delegate.next();
                        Throwable throwable = null;
                        try {
                            DiskLruCache.Snapshot snapshot = (DiskLruCache.Snapshot)closeable;
                            boolean bl = false;
                            BufferedSource bufferedSource = Okio.buffer(snapshot.getSource(0));
                            this.nextUrl = bufferedSource.readUtf8LineStrict();
                            boolean bl2 = true;
                            return bl2;
                        }
                        catch (Throwable throwable2) {
                            throwable = throwable2;
                            throw throwable2;
                        }
                        finally {
                            CloseableKt.closeFinally(closeable, throwable);
                        }
                    }
                    catch (IOException iOException) {
                    }
                }
                return false;
            }

            @NotNull
            public String next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                String string = this.nextUrl;
                Intrinsics.checkNotNull(string);
                String string2 = string;
                this.nextUrl = null;
                this.canRemove = true;
                return string2;
            }

            public void remove() {
                if (!this.canRemove) {
                    boolean bl = false;
                    String string = "remove() before next()";
                    throw new IllegalStateException(string.toString());
                }
                this.delegate.remove();
            }
        };
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Override
    public void close() throws IOException {
        this.cache.close();
    }

    @JvmName(name="directory")
    @NotNull
    public final File directory() {
        return this.cache.getDirectory();
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="directory", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_directory")
    @NotNull
    public final File mc706f20f3e() {
        return this.cache.getDirectory();
    }

    public final synchronized void trackResponse$okhttp(@NotNull CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        int n = this.requestCount;
        this.requestCount = n + 1;
        if (cacheStrategy.getNetworkRequest() != null) {
            n = this.networkCount;
            this.networkCount = n + 1;
        } else if (cacheStrategy.getCacheResponse() != null) {
            n = this.hitCount;
            this.hitCount = n + 1;
        }
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        int n = this.hitCount;
        this.hitCount = n + 1;
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    @JvmStatic
    @NotNull
    public static final String key(@NotNull HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0007\u001a\u00020\rH\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2={"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "Lokhttp3/MediaType;", "source", "okhttp"})
    private static final class CacheResponseBody
    extends ResponseBody {
        @NotNull
        private final DiskLruCache.Snapshot snapshot;
        @Nullable
        private final String contentType;
        @Nullable
        private final String contentLength;
        @NotNull
        private final BufferedSource bodySource;

        public CacheResponseBody(@NotNull DiskLruCache.Snapshot snapshot, @Nullable String string, @Nullable String string2) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = string;
            this.contentLength = string2;
            Source source2 = this.snapshot.getSource(1);
            this.bodySource = Okio.buffer(new ForwardingSource(source2){

                @Override
                public void close() throws IOException {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @NotNull
        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override
        @Nullable
        public MediaType contentType() {
            String string = this.contentType;
            return string != null ? MediaType.Companion.parse(string) : null;
        }

        @Override
        public long contentLength() {
            String string = this.contentLength;
            return string != null ? Util.toLongOrDefault(string, -1L) : -1L;
        }

        @Override
        @NotNull
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\n\u0010\u001b\u001a\u00020\u0015*\u00020\u0017J\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001d*\u00020\u0011H\u0002J\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lokhttp3/Cache$Companion;", "", "()V", "ENTRY_BODY", "", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "key", "", "url", "Lokhttp3/HttpUrl;", "readInt", "source", "Lokio/BufferedSource;", "readInt$okhttp", "varyHeaders", "Lokhttp3/Headers;", "requestHeaders", "responseHeaders", "varyMatches", "", "cachedResponse", "Lokhttp3/Response;", "cachedRequest", "newRequest", "Lokhttp3/Request;", "hasVaryAll", "varyFields", "", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cache.kt\nokhttp3/Cache$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,788:1\n2624#2,3:789\n*S KotlinDebug\n*F\n+ 1 Cache.kt\nokhttp3/Cache$Companion\n*L\n729#1:789,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final String key(@NotNull HttpUrl httpUrl) {
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            return ByteString.Companion.encodeUtf8(httpUrl.toString()).md5().hex();
        }

        public final int readInt$okhttp(@NotNull BufferedSource bufferedSource) throws IOException {
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            try {
                long l = bufferedSource.readDecimalLong();
                String string = bufferedSource.readUtf8LineStrict();
                if (l < 0L || l > Integer.MAX_VALUE || ((CharSequence)string).length() > 0) {
                    throw new IOException("expected an int but was \"" + l + string + '\"');
                }
                return (int)l;
            }
            catch (NumberFormatException numberFormatException) {
                throw new IOException(numberFormatException.getMessage());
            }
        }

        public final boolean varyMatches(@NotNull Response response, @NotNull Headers headers, @NotNull Request request) {
            boolean bl;
            block3: {
                Intrinsics.checkNotNullParameter(response, "cachedResponse");
                Intrinsics.checkNotNullParameter(headers, "cachedRequest");
                Intrinsics.checkNotNullParameter(request, "newRequest");
                Iterable iterable = this.varyFields(response.headers());
                boolean bl2 = false;
                if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                    bl = true;
                } else {
                    for (Object t : iterable) {
                        String string = (String)t;
                        boolean bl3 = false;
                        if (!(!Intrinsics.areEqual(headers.values(string), request.headers(string)))) continue;
                        bl = false;
                        break block3;
                    }
                    bl = true;
                }
            }
            return bl;
        }

        public final boolean hasVaryAll(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            return this.varyFields(response.headers()).contains("*");
        }

        private final Set<String> varyFields(Headers headers) {
            Set set = null;
            int n = headers.size();
            for (int i = 0; i < n; ++i) {
                if (!StringsKt.equals("Vary", headers.name(i), true)) continue;
                String string = headers.value(i);
                if (set == null) {
                    set = new TreeSet<String>(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                }
                Object object = new char[]{','};
                Iterator iterator2 = StringsKt.split$default((CharSequence)string, object, false, 0, 6, null).iterator();
                while (iterator2.hasNext()) {
                    object = (String)iterator2.next();
                    set.add(((Object)StringsKt.trim((CharSequence)object)).toString());
                }
            }
            Set set2 = set;
            if (set2 == null) {
                set2 = SetsKt.emptySet();
            }
            return set2;
        }

        @NotNull
        public final Headers varyHeaders(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            Response response2 = response.networkResponse();
            Intrinsics.checkNotNull(response2);
            Headers headers = response2.request().headers();
            Headers headers2 = response.headers();
            return this.varyHeaders(headers, headers2);
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> set = this.varyFields(headers2);
            if (set.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int n = headers.size();
            for (int i = 0; i < n; ++i) {
                String string = headers.name(i);
                if (!set.contains(string)) continue;
                builder.add(string, headers.value(i));
            }
            return builder.build();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010$\u001a\u00060%R\u00020&J\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0012\u0010,\u001a\u00020(2\n\u0010-\u001a\u00060.R\u00020&R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"Lokhttp3/Cache$Entry;", "", "rawSource", "Lokio/Source;", "(Lokio/Source;)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "code", "", "handshake", "Lokhttp3/Handshake;", "isHttps", "", "()Z", "message", "", "protocol", "Lokhttp3/Protocol;", "receivedResponseMillis", "", "requestMethod", "responseHeaders", "Lokhttp3/Headers;", "sentRequestMillis", "url", "Lokhttp3/HttpUrl;", "varyHeaders", "matches", "request", "Lokhttp3/Request;", "readCertificateList", "", "Ljava/security/cert/Certificate;", "source", "Lokio/BufferedSource;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "writeCertList", "", "sink", "Lokio/BufferedSink;", "certificates", "writeTo", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Companion", "okhttp"})
    private static final class Entry {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final HttpUrl url;
        @NotNull
        private final Headers varyHeaders;
        @NotNull
        private final String requestMethod;
        @NotNull
        private final Protocol protocol;
        private final int code;
        @NotNull
        private final String message;
        @NotNull
        private final Headers responseHeaders;
        @Nullable
        private final Handshake handshake;
        private final long sentRequestMillis;
        private final long receivedResponseMillis;
        @NotNull
        private static final String SENT_MILLIS = Platform.Companion.get().getPrefix() + "-Sent-Millis";
        @NotNull
        private static final String RECEIVED_MILLIS = Platform.Companion.get().getPrefix() + "-Received-Millis";

        private final boolean isHttps() {
            return Intrinsics.areEqual(this.url.scheme(), "https");
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Entry(@NotNull Source source2) throws IOException {
            Intrinsics.checkNotNullParameter(source2, "rawSource");
            Closeable closeable = source2;
            Throwable throwable = null;
            try {
                Object object = (Source)closeable;
                boolean bl = false;
                BufferedSource bufferedSource = Okio.buffer(source2);
                String string = bufferedSource.readUtf8LineStrict();
                HttpUrl httpUrl = HttpUrl.Companion.parse(string);
                if (httpUrl == null) {
                    IOException iOException;
                    IOException iOException2 = iOException = new IOException("Cache corruption for " + string);
                    Entry entry = this;
                    boolean bl2 = false;
                    Platform.Companion.get().log("cache corruption", 5, iOException2);
                    Entry entry2 = entry;
                    throw (Throwable)iOException;
                }
                this.url = httpUrl;
                this.requestMethod = bufferedSource.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int n = Companion.readInt$okhttp(bufferedSource);
                for (int i = 0; i < n; ++i) {
                    builder.addLenient$okhttp(bufferedSource.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                StatusLine statusLine = StatusLine.Companion.parse(bufferedSource.readUtf8LineStrict());
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder builder2 = new Headers.Builder();
                int n2 = Companion.readInt$okhttp(bufferedSource);
                for (int i = 0; i < n2; ++i) {
                    builder2.addLenient$okhttp(bufferedSource.readUtf8LineStrict());
                }
                String string2 = builder2.get(SENT_MILLIS);
                String string3 = builder2.get(RECEIVED_MILLIS);
                builder2.removeAll(SENT_MILLIS);
                builder2.removeAll(RECEIVED_MILLIS);
                String string4 = string2;
                this.sentRequestMillis = string4 != null ? Long.parseLong(string4) : 0L;
                String string5 = string3;
                this.receivedResponseMillis = string5 != null ? Long.parseLong(string5) : 0L;
                this.responseHeaders = builder2.build();
                if (this.isHttps()) {
                    String string6 = bufferedSource.readUtf8LineStrict();
                    if (((CharSequence)string6).length() > 0) {
                        throw new IOException("expected \"\" but was \"" + string6 + '\"');
                    }
                    String string7 = bufferedSource.readUtf8LineStrict();
                    CipherSuite cipherSuite = CipherSuite.Companion.forJavaName(string7);
                    List<Certificate> list = this.readCertificateList(bufferedSource);
                    List<Certificate> list2 = this.readCertificateList(bufferedSource);
                    TlsVersion tlsVersion = !bufferedSource.exhausted() ? TlsVersion.Companion.forJavaName(bufferedSource.readUtf8LineStrict()) : TlsVersion.SSL_3_0;
                    this.handshake = Handshake.Companion.get(tlsVersion, cipherSuite, list, list2);
                } else {
                    this.handshake = null;
                }
                object = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally(closeable, throwable);
            }
        }

        public Entry(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void writeTo(@NotNull DiskLruCache.Editor editor) throws IOException {
            Intrinsics.checkNotNullParameter(editor, "editor");
            Closeable closeable = Okio.buffer(editor.newSink(0));
            Throwable throwable = null;
            try {
                int n;
                Object object = (BufferedSink)closeable;
                boolean bl = false;
                object.writeUtf8(this.url.toString()).writeByte(10);
                object.writeUtf8(this.requestMethod).writeByte(10);
                object.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
                int n2 = this.varyHeaders.size();
                for (n = 0; n < n2; ++n) {
                    object.writeUtf8(this.varyHeaders.name(n)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(n)).writeByte(10);
                }
                object.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                object.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
                n2 = this.responseHeaders.size();
                for (n = 0; n < n2; ++n) {
                    object.writeUtf8(this.responseHeaders.name(n)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(n)).writeByte(10);
                }
                object.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
                object.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
                if (this.isHttps()) {
                    object.writeByte(10);
                    Handshake handshake2 = this.handshake;
                    Intrinsics.checkNotNull(handshake2);
                    object.writeUtf8(handshake2.cipherSuite().javaName()).writeByte(10);
                    this.writeCertList((BufferedSink)object, this.handshake.peerCertificates());
                    this.writeCertList((BufferedSink)object, this.handshake.localCertificates());
                    object.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                object = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally(closeable, throwable);
            }
        }

        private final List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int n = Companion.readInt$okhttp(bufferedSource);
            if (n == -1) {
                return CollectionsKt.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList<Certificate> arrayList = new ArrayList<Certificate>(n);
                for (int i = 0; i < n; ++i) {
                    ByteString byteString;
                    String string = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    if (ByteString.Companion.decodeBase64(string) == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    buffer.write(byteString);
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            }
            catch (CertificateException certificateException) {
                throw new IOException(certificateException.getMessage());
            }
        }

        private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                for (Certificate certificate : list) {
                    byte[] byArray = certificate.getEncoded();
                    Intrinsics.checkNotNullExpressionValue(byArray, "bytes");
                    String string = ByteString.Companion.of$default(ByteString.Companion, byArray, 0, 0, 3, null).base64();
                    bufferedSink.writeUtf8(string).writeByte(10);
                }
            }
            catch (CertificateEncodingException certificateEncodingException) {
                throw new IOException(certificateEncodingException.getMessage());
            }
        }

        public final boolean matches(@NotNull Request request, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            return Intrinsics.areEqual(this.url, request.url()) && Intrinsics.areEqual(this.requestMethod, request.method()) && Companion.varyMatches(response, this.varyHeaders, request);
        }

        @NotNull
        public final Response response(@NotNull DiskLruCache.Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            String string = this.responseHeaders.get("Content-Type");
            String string2 = this.responseHeaders.get("Content-Length");
            Request request = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
            return new Response.Builder().request(request).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, string, string2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lokhttp3/Cache$Entry$Companion;", "", "()V", "RECEIVED_MILLIS", "", "SENT_MILLIS", "okhttp"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "body", "Lokio/Sink;", "cacheOut", "done", "", "getDone", "()Z", "setDone", "(Z)V", "abort", "", "okhttp"})
    private final class RealCacheRequest
    implements CacheRequest {
        @NotNull
        private final DiskLruCache.Editor editor;
        @NotNull
        private final Sink cacheOut;
        @NotNull
        private final Sink body;
        private boolean done;

        public RealCacheRequest(DiskLruCache.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            this.editor = editor;
            this.cacheOut = this.editor.newSink(1);
            Sink sink2 = this.cacheOut;
            this.body = new ForwardingSink(sink2){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void close() throws IOException {
                    Cache cache = Cache.this;
                    RealCacheRequest realCacheRequest = this;
                    Cache cache2 = Cache.this;
                    Cache cache3 = cache;
                    synchronized (cache3) {
                        int n = 0;
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        int n2 = cache2.getWriteSuccessCount$okhttp();
                        cache2.setWriteSuccessCount$okhttp(n2 + 1);
                        n = n2;
                    }
                    super.close();
                    editor.commit();
                }
            };
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean bl) {
            this.done = bl;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void abort() {
            Cache cache = Cache.this;
            Cache cache2 = Cache.this;
            Cache cache3 = cache;
            synchronized (cache3) {
                int n = 0;
                if (this.done) {
                    return;
                }
                this.done = true;
                int n2 = cache2.getWriteAbortCount$okhttp();
                cache2.setWriteAbortCount$okhttp(n2 + 1);
                n = n2;
            }
            Util.closeQuietly(this.cacheOut);
            try {
                this.editor.abort();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }

        @Override
        @NotNull
        public Sink body() {
            return this.body;
        }
    }
}

