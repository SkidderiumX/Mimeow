package okhttp3.internal.connection;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import okhttp3.internal.platform.*;
import kotlin.collections.*;
import okhttp3.internal.cache.*;
import okhttp3.internal.http.*;
import okhttp3.internal.*;
import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import okio.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import okhttp3.*;
import kotlin.*;
import java.lang.ref.*;

@Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\u0018\u00002\u00020\u0001:\u0002deB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u000fJ!\u00103\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u00106\u001a\u0002H4H\u0002¢\u0006\u0002\u00107J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0016J\b\u0010:\u001a\u00020\u0000H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AH\u0016J\u0016\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0007J\b\u0010E\u001a\u00020FH\u0016J\u0015\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\u0007H\u0000¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020FH\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020NH\u0000¢\u0006\u0002\bOJ\b\u0010P\u001a\u00020\u0007H\u0016J\b\u0010Q\u001a\u00020\u0007H\u0016J;\u0010R\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u00106\u001a\u0002H4H\u0000¢\u0006\u0004\bU\u0010VJ\u0019\u0010W\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\u000f\u0010\\\u001a\u0004\u0018\u00010]H\u0000¢\u0006\u0002\b^J\b\u0010C\u001a\u00020\u0005H\u0016J\u0006\u0010_\u001a\u00020\u0007J\b\u0010-\u001a\u00020`H\u0016J\u0006\u00100\u001a\u000202J!\u0010a\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u0010b\u001a\u0002H4H\u0002¢\u0006\u0002\u00107J\b\u0010c\u001a\u00020ZH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001e@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f" }, d2 = { "Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", "connection", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionToCancel", "getConnectionToCancel", "setConnectionToCancel", "(Lokhttp3/internal/connection/RealConnection;)V", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "expectMoreExchanges", "getForWebSocket", "()Z", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getOriginalRequest", "()Lokhttp3/Request;", "requestBodyOpen", "responseBodyOpen", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callDone", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "callStart", "cancel", "clone", "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", "request", "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange$okhttp", "isCanceled", "isExecuted", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/AsyncTimeout;", "timeoutExit", "cause", "toLoggableString", "AsyncCall", "CallReference", "okhttp" })
@SourceDebugExtension({ "SMAP\nRealCall.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,551:1\n1#2:552\n608#3,4:553\n615#3,4:557\n615#3,4:561\n608#3,4:565\n350#4,7:569\n*S KotlinDebug\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall\n*L\n269#1:553,4\n344#1:557,4\n348#1:561,4\n375#1:565,4\n378#1:569,7\n*E\n" })
public class RealCall implements Call
{
    @NotNull
    private final OkHttpClient client;
    @NotNull
    private final Request originalRequest;
    private final boolean forWebSocket;
    @NotNull
    private final RealConnectionPool connectionPool;
    @NotNull
    private final EventListener eventListener;
    @NotNull
    private final RealCall$timeout.RealCall$timeout$1 timeout;
    @NotNull
    private final AtomicBoolean executed;
    @Nullable
    private Object callStackTrace;
    @Nullable
    private ExchangeFinder exchangeFinder;
    @Nullable
    private RealConnection connection;
    private boolean timeoutEarlyExit;
    @Nullable
    private Exchange interceptorScopedExchange;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private boolean expectMoreExchanges;
    private volatile boolean canceled;
    @Nullable
    private volatile Exchange exchange;
    @Nullable
    private volatile RealConnection connectionToCancel;
    
    public RealCall(@NotNull final OkHttpClient client, @NotNull final Request originalRequest, final boolean forWebSocket) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = forWebSocket;
        this.connectionPool = this.client.connectionPool().getDelegate$okhttp();
        this.eventListener = this.client.eventListenerFactory().create(this);
        final RealCall$timeout.RealCall$timeout$1 timeout = new RealCall$timeout.RealCall$timeout$1(this);
        timeout.timeout((long)this.client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = timeout;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }
    
    @NotNull
    public final OkHttpClient getClient() {
        return this.client;
    }
    
    @NotNull
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }
    
    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }
    
    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }
    
    @Nullable
    public final RealConnection getConnection() {
        return this.connection;
    }
    
    @Nullable
    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }
    
    @Nullable
    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }
    
    public final void setConnectionToCancel(@Nullable final RealConnection connectionToCancel) {
        this.connectionToCancel = connectionToCancel;
    }
    
    @NotNull
    @Override
    public AsyncTimeout timeout() {
        return (AsyncTimeout)this.timeout;
    }
    
    @NotNull
    @Override
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
    
    @NotNull
    @Override
    public Request request() {
        return this.originalRequest;
    }
    
    @Override
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        final Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        final RealConnection connectionToCancel = this.connectionToCancel;
        if (connectionToCancel != null) {
            connectionToCancel.cancel();
        }
        this.eventListener.canceled(this);
    }
    
    @Override
    public boolean isCanceled() {
        return this.canceled;
    }
    
    @NotNull
    @Override
    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.timeout.enter();
        this.callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return this.getResponseWithInterceptorChain$okhttp();
        }
        finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }
    
    @Override
    public void enqueue(@NotNull final Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(callback));
    }
    
    @Override
    public boolean isExecuted() {
        return this.executed.get();
    }
    
    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }
    
    @NotNull
    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        final List list = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super Object>)list, (Iterable<?>)this.client.interceptors());
        list.add(new RetryAndFollowUpInterceptor(this.client));
        list.add(new BridgeInterceptor(this.client.cookieJar()));
        list.add(new CacheInterceptor(this.client.cache()));
        list.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super Object>)list, (Iterable<?>)this.client.networkInterceptors());
        }
        list.add(new CallServerInterceptor(this.forWebSocket));
        final RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this, list, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        boolean b = false;
        try {
            final Response proceed = realInterceptorChain.proceed(this.originalRequest);
            if (this.isCanceled()) {
                Util.closeQuietly(proceed);
                throw new IOException("Canceled");
            }
            final Response response = proceed;
            this.noMoreExchanges$okhttp(null);
            return response;
        }
        catch (final IOException ex) {
            b = true;
            final IOException noMoreExchanges$okhttp = this.noMoreExchanges$okhttp(ex);
            Intrinsics.checkNotNull(noMoreExchanges$okhttp, "null cannot be cast to non-null type kotlin.Throwable");
            throw noMoreExchanges$okhttp;
        }
        finally {
            if (!b) {
                this.noMoreExchanges$okhttp(null);
            }
        }
    }
    
    public final void enterNetworkInterceptorExchange(@NotNull final Request request, final boolean b) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (this.responseBodyOpen) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.".toString());
            }
            final Unit instance = Unit.INSTANCE;
        }
        if (b) {
            this.exchangeFinder = new ExchangeFinder(this.connectionPool, this.createAddress(request.url()), this, this.eventListener);
        }
    }
    
    @NotNull
    public final Exchange initExchange$okhttp(@NotNull final RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            if (this.responseBodyOpen) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.".toString());
            }
            final Unit instance = Unit.INSTANCE;
        }
        final ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        final ExchangeFinder exchangeFinder2 = exchangeFinder;
        final Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder2, exchangeFinder2.find(this.client, realInterceptorChain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
            final Unit instance2 = Unit.INSTANCE;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return exchange;
    }
    
    public final void acquireConnectionNoEvents(@NotNull final RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(realConnection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection));
        }
        if (this.connection != null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.connection = realConnection;
        realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
    }
    
    public final <E extends IOException> E messageDone$okhttp(@NotNull final Exchange exchange, final boolean b, final boolean b2, final E e) {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (!Intrinsics.areEqual(exchange, this.exchange)) {
            return e;
        }
        int n = 0;
        int n2 = 0;
        synchronized (this) {
            if ((b && this.requestBodyOpen) || (b2 && this.responseBodyOpen)) {
                if (b) {
                    this.requestBodyOpen = false;
                }
                if (b2) {
                    this.responseBodyOpen = false;
                }
                n = ((!this.requestBodyOpen && !this.responseBodyOpen) ? 1 : 0);
                n2 = ((!this.requestBodyOpen && !this.responseBodyOpen && !this.expectMoreExchanges) ? 1 : 0);
            }
            final Unit instance = Unit.INSTANCE;
        }
        if (n != 0) {
            this.exchange = null;
            final RealConnection connection = this.connection;
            if (connection != null) {
                connection.incrementSuccessCount$okhttp();
            }
        }
        if (n2 != 0) {
            return this.callDone(e);
        }
        return e;
    }
    
    @Nullable
    public final IOException noMoreExchanges$okhttp(@Nullable final IOException ex) {
        int n = 0;
        synchronized (this) {
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                n = ((!this.requestBodyOpen && !this.responseBodyOpen) ? 1 : 0);
            }
            final Unit instance = Unit.INSTANCE;
        }
        if (n != 0) {
            return this.callDone(ex);
        }
        return ex;
    }
    
    private final <E extends IOException> E callDone(final E p0) {
        // 
        if (Util.assertionsEnabled && Thread.holdsLock((Object)p0)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + (Object)p0));
        }
        RealConnection connection = this.connection;
        Socket socket = null;
        if (connection != null) {
            final RealConnection connectionLock = connection;
            synchronized (connectionLock) {
                socket = this.releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (socket != null) {
                    Util.closeQuietly(socket);
                }
                this.eventListener.connectionReleased((Call)this, connection);
            }
            else {
                if (socket == null) {
                    throw new IllegalStateException("Check failed.");
                }
            }
        }
        p0 = this.timeoutExit(p0);
        if (p0 != null) {
            this.eventListener.callFailed((Call)this, p0);
        }
        else {
            this.eventListener.callEnd((Call)this);
        }
    }
    
    @Nullable
    public final Socket releaseConnectionNoEvents$okhttp() {
        final RealConnection connection = this.connection;
        Intrinsics.checkNotNull(connection);
        final RealConnection obj;
        final RealConnection realConnection = obj = connection;
        if (Util.assertionsEnabled && !Thread.holdsLock(obj)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj));
        }
        final List<Reference<RealCall>> calls;
        final List<Reference<RealCall>> list = calls = realConnection.getCalls();
        int n = 0;
        final Iterator<Reference<RealCall>> iterator = calls.iterator();
        while (true) {
            while (iterator.hasNext()) {
                if (Intrinsics.areEqual(((Reference<Object>)iterator.next()).get(), this)) {
                    final int n2 = n;
                    final int n3 = n2;
                    if (n3 == -1) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    list.remove(n3);
                    this.connection = null;
                    if (list.isEmpty()) {
                        realConnection.setIdleAtNs$okhttp(System.nanoTime());
                        if (this.connectionPool.connectionBecameIdle(realConnection)) {
                            return realConnection.socket();
                        }
                    }
                    return null;
                }
                else {
                    ++n;
                }
            }
            final int n2 = -1;
            continue;
        }
    }
    
    private final <E extends IOException> E timeoutExit(final E e) {
        if (this.timeoutEarlyExit) {
            return e;
        }
        if (!this.timeout.exit()) {
            return e;
        }
        final IOException ex = new InterruptedIOException("timeout");
        if (e != null) {
            ex.initCause(e);
        }
        return (E)ex;
    }
    
    public final void timeoutEarlyExit() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.timeoutEarlyExit = true;
        this.timeout.exit();
    }
    
    public final void exitNetworkInterceptorExchange$okhttp(final boolean b) {
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            final Unit instance = Unit.INSTANCE;
        }
        if (b) {
            final Exchange exchange = this.exchange;
            if (exchange != null) {
                exchange.detachWithViolence();
            }
        }
        this.interceptorScopedExchange = null;
    }
    
    private final Address createAddress(final HttpUrl httpUrl) {
        SSLSocketFactory sslSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (httpUrl.isHttps()) {
            sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }
    
    public final boolean retryAfterFailure() {
        final ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        return exchangeFinder.retryAfterFailure();
    }
    
    private final String toLoggableString() {
        return (this.isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : "call") + " to " + this.redactedUrl$okhttp();
    }
    
    @NotNull
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }
    
    public static final /* synthetic */ RealCall$timeout.RealCall$timeout$1 access$getTimeout$p(final RealCall realCall) {
        return realCall.timeout;
    }
    
    @Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0000R\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d" }, d2 = { "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "call", "Lokhttp3/internal/connection/RealCall;", "getCall", "()Lokhttp3/internal/connection/RealCall;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "host", "", "getHost", "()Ljava/lang/String;", "request", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "reuseCallsPerHostFrom", "other", "run", "okhttp" })
    @SourceDebugExtension({ "SMAP\nRealCall.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall$AsyncCall\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,551:1\n615#2,4:552\n409#2,9:556\n*S KotlinDebug\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall$AsyncCall\n*L\n494#1:552,4\n513#1:556,9\n*E\n" })
    public final class AsyncCall implements Runnable
    {
        @NotNull
        private final Callback responseCallback;
        @NotNull
        private volatile AtomicInteger callsPerHost;
        
        public AsyncCall(final Callback responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }
        
        @NotNull
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }
        
        public final void reuseCallsPerHostFrom(@NotNull final AsyncCall asyncCall) {
            Intrinsics.checkNotNullParameter(asyncCall, "other");
            this.callsPerHost = asyncCall.callsPerHost;
        }
        
        @NotNull
        public final String getHost() {
            return RealCall.this.getOriginalRequest().url().host();
        }
        
        @NotNull
        public final Request getRequest() {
            return RealCall.this.getOriginalRequest();
        }
        
        @NotNull
        public final RealCall getCall() {
            return RealCall.this;
        }
        
        public final void executeOn(@NotNull final ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            final Dispatcher dispatcher = RealCall.this.getClient().dispatcher();
            if (Util.assertionsEnabled && Thread.holdsLock(dispatcher)) {
                throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher));
            }
            try {
                executorService.execute(this);
            }
            catch (final RejectedExecutionException ex) {
                final InterruptedIOException ex2 = new InterruptedIOException("executor rejected");
                ex2.initCause(ex);
                RealCall.this.noMoreExchanges$okhttp(ex2);
                this.responseCallback.onFailure(RealCall.this, ex2);
            }
            finally {
                RealCall.this.getClient().dispatcher().finished$okhttp(this);
            }
        }
        
        @Override
        public void run() {
            final String string = "OkHttp " + RealCall.this.redactedUrl$okhttp();
            final RealCall this$0 = RealCall.this;
            final Thread currentThread = Thread.currentThread();
            final String name = currentThread.getName();
            currentThread.setName(string);
            try {
                boolean b = false;
                RealCall.access$getTimeout$p(this$0).enter();
                try {
                    final Response responseWithInterceptorChain$okhttp = this$0.getResponseWithInterceptorChain$okhttp();
                    b = true;
                    this.responseCallback.onResponse(this$0, responseWithInterceptorChain$okhttp);
                }
                catch (final IOException ex) {
                    if (b) {
                        Platform.Companion.get().log("Callback failure for " + this$0.toLoggableString(), 4, ex);
                    }
                    else {
                        this.responseCallback.onFailure(this$0, ex);
                    }
                }
                catch (final Throwable obj) {
                    this$0.cancel();
                    if (!b) {
                        final IOException ex2 = new IOException("canceled due to " + obj);
                        ExceptionsKt__ExceptionsKt.addSuppressed(ex2, obj);
                        this.responseCallback.onFailure(this$0, ex2);
                    }
                    throw obj;
                }
                finally {
                    this$0.getClient().dispatcher().finished$okhttp(this);
                }
            }
            finally {
                currentThread.setName(name);
            }
        }
    }
    
    @Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t" }, d2 = { "Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp" })
    public static final class CallReference extends WeakReference<RealCall>
    {
        @Nullable
        private final Object callStackTrace;
        
        public CallReference(@NotNull final RealCall referent, @Nullable final Object callStackTrace) {
            Intrinsics.checkNotNullParameter(referent, "referent");
            super(referent);
            this.callStackTrace = callStackTrace;
        }
        
        @Nullable
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }
}
