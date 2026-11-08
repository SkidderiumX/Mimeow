/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.PushObserver;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u0099\u00012\u00020\u0001:\b\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020QH\u0016J'\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010WH\u0000\u00a2\u0006\u0002\bXJ\u0012\u0010Y\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010WH\u0002J\u0006\u0010[\u001a\u00020QJ\u0010\u0010\\\u001a\u0004\u0018\u00010B2\u0006\u0010]\u001a\u00020\u0012J\u000e\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u0006J&\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tH\u0002J\u001c\u0010`\u001a\u00020B2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0006\u0010f\u001a\u00020\u0012J-\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\tH\u0000\u00a2\u0006\u0002\bmJ+\u0010n\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010l\u001a\u00020\tH\u0000\u00a2\u0006\u0002\boJ#\u0010p\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000\u00a2\u0006\u0002\bqJ\u001d\u0010r\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000\u00a2\u0006\u0002\btJ$\u0010u\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0015\u0010v\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\bwJ\u0017\u0010x\u001a\u0004\u0018\u00010B2\u0006\u0010h\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\byJ\r\u0010z\u001a\u00020QH\u0000\u00a2\u0006\u0002\b{J\u000e\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020&J\u000e\u0010~\u001a\u00020Q2\u0006\u0010\u007f\u001a\u00020TJ\u001e\u0010\u0080\u0001\u001a\u00020Q2\t\b\u0002\u0010\u0081\u0001\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020FH\u0007J\u0018\u0010\u0082\u0001\u001a\u00020Q2\u0007\u0010\u0083\u0001\u001a\u00020\u0006H\u0000\u00a2\u0006\u0003\b\u0084\u0001J,\u0010\u0085\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u00020\t2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u0006\u0010k\u001a\u00020\u0006J/\u0010\u0089\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u00020\t2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000\u00a2\u0006\u0003\b\u008b\u0001J\u0007\u0010\u008c\u0001\u001a\u00020QJ\"\u0010\u008c\u0001\u001a\u00020Q2\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u00122\u0007\u0010\u008f\u0001\u001a\u00020\u0012J\u0007\u0010\u0090\u0001\u001a\u00020QJ\u001f\u0010\u0091\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010\u007f\u001a\u00020TH\u0000\u00a2\u0006\u0003\b\u0092\u0001J\u001f\u0010\u0093\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000\u00a2\u0006\u0003\b\u0094\u0001J \u0010\u0095\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0096\u0001\u001a\u00020\u0006H\u0000\u00a2\u0006\u0003\b\u0097\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0012X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0012X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u0011\u0010%\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010(\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0015\u00107\u001a\u000608R\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020=X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020B0AX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00104R\u001e\u0010I\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010K\u001a\u00020L\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009c\u0001"}, d2={"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "awaitPingsSent", "", "awaitPongsReceived", "client", "", "getClient$okhttp", "()Z", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "currentPushRequests", "", "", "degradedPingsSent", "degradedPongDeadlineNs", "degradedPongsReceived", "intervalPingsSent", "intervalPongsReceived", "isShutdown", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "pushQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "settingsListenerQueue", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "streams", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerQueue", "awaitPong", "", "close", "connectionCode", "Lokhttp3/internal/http2/ErrorCode;", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", "flush", "getStream", "id", "isHealthy", "nowNs", "newStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "openStreamCount", "pushDataLater", "streamId", "source", "Lokio/BufferedSource;", "byteCount", "inFinished", "pushDataLater$okhttp", "pushHeadersLater", "pushHeadersLater$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushResetLater", "errorCode", "pushResetLater$okhttp", "pushStream", "pushedStream", "pushedStream$okhttp", "removeStream", "removeStream$okhttp", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "setSettings", "settings", "shutdown", "statusCode", "start", "sendConnectionPreface", "updateConnectionFlowControl", "read", "updateConnectionFlowControl$okhttp", "writeData", "outFinished", "buffer", "Lokio/Buffer;", "writeHeaders", "alternating", "writeHeaders$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "writeSynReset", "writeSynReset$okhttp", "writeSynResetLater", "writeSynResetLater$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "Builder", "Companion", "Listener", "ReaderRunnable", "okhttp"})
@SourceDebugExtension(value={"SMAP\nHttp2Connection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n+ 2 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1006:1\n84#2,4:1007\n90#2,13:1014\n90#2,13:1027\n90#2,13:1069\n90#2,13:1082\n90#2,13:1095\n90#2,13:1108\n90#2,13:1121\n90#2,13:1134\n563#3:1011\n557#3:1013\n557#3:1040\n615#3,4:1041\n402#3,5:1045\n402#3,5:1053\n402#3,5:1059\n402#3,5:1064\n1#4:1012\n37#5,2:1050\n13309#6:1052\n13310#6:1058\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n152#1:1007,4\n340#1:1014,13\n361#1:1027,13\n506#1:1069,13\n554#1:1082,13\n893#1:1095,13\n911#1:1108,13\n938#1:1121,13\n952#1:1134,13\n183#1:1011\n319#1:1013\n402#1:1040\n446#1:1041,4\n448#1:1045,5\n461#1:1053,5\n467#1:1059,5\n472#1:1064,5\n455#1:1050,2\n460#1:1052\n460#1:1058\n*E\n"})
public class Http2Connection
implements Closeable {
    @NotNull
    public static final Companion Companion;
    private final boolean client;
    @NotNull
    private final Listener listener;
    @NotNull
    private final Map<Integer, Http2Stream> streams;
    @NotNull
    private final String connectionName;
    private int lastGoodStreamId;
    private int nextStreamId;
    private boolean isShutdown;
    @NotNull
    private final TaskRunner taskRunner;
    @NotNull
    private final TaskQueue writerQueue;
    @NotNull
    private final TaskQueue pushQueue;
    @NotNull
    private final TaskQueue settingsListenerQueue;
    @NotNull
    private final PushObserver pushObserver;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private long degradedPingsSent;
    private long degradedPongsReceived;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private long degradedPongDeadlineNs;
    @NotNull
    private final Settings okHttpSettings;
    @NotNull
    private Settings peerSettings;
    private long readBytesTotal;
    private long readBytesAcknowledged;
    private long writeBytesTotal;
    private long writeBytesMaximum;
    @NotNull
    private final Socket socket;
    @NotNull
    private final Http2Writer writer;
    @NotNull
    private final ReaderRunnable readerRunnable;
    @NotNull
    private final Set<Integer> currentPushRequests;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 0x1000000;
    @NotNull
    private static final Settings DEFAULT_SETTINGS;
    public static final int INTERVAL_PING = 1;
    public static final int DEGRADED_PING = 2;
    public static final int AWAIT_PING = 3;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;

    public Http2Connection(@NotNull Builder builder) {
        Settings settings;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.client = builder.getClient$okhttp();
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        this.connectionName = builder.getConnectionName$okhttp();
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        this.taskRunner = builder.getTaskRunner$okhttp();
        this.writerQueue = this.taskRunner.newQueue();
        this.pushQueue = this.taskRunner.newQueue();
        this.settingsListenerQueue = this.taskRunner.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings2 = settings = new Settings();
        Http2Connection http2Connection = this;
        boolean bl = false;
        if (builder.getClient$okhttp()) {
            settings2.set(7, 0x1000000);
        }
        http2Connection.okHttpSettings = settings;
        this.peerSettings = DEFAULT_SETTINGS;
        this.writeBytesMaximum = this.peerSettings.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), this.client);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder.getSource$okhttp(), this.client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            long l = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            TaskQueue taskQueue = this.writerQueue;
            String string = this.connectionName + " ping";
            boolean bl2 = false;
            taskQueue.schedule(new Task(string, this, l){
                final /* synthetic */ Http2Connection this$0;
                final /* synthetic */ long $pingIntervalNanos$inlined;
                {
                    this.this$0 = http2Connection;
                    this.$pingIntervalNanos$inlined = l;
                    super(string, false, 2, null);
                }

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public long runOnce() {
                    long l;
                    boolean bl;
                    boolean bl2 = false;
                    Http2Connection http2Connection = this.this$0;
                    synchronized (http2Connection) {
                        boolean bl3;
                        bl = false;
                        if (Http2Connection.access$getIntervalPongsReceived$p(this.this$0) < Http2Connection.access$getIntervalPingsSent$p(this.this$0)) {
                            bl3 = true;
                        } else {
                            long l2 = Http2Connection.access$getIntervalPingsSent$p(this.this$0);
                            Http2Connection.access$setIntervalPingsSent$p(this.this$0, l2 + 1L);
                            bl3 = false;
                        }
                        bl = bl3;
                    }
                    boolean bl4 = bl;
                    if (bl4) {
                        Http2Connection.access$failConnection(this.this$0, null);
                        l = -1L;
                    } else {
                        this.this$0.writePing(false, 1, 0);
                        l = this.$pingIntervalNanos$inlined;
                    }
                    return l;
                }
            }, l);
        }
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @NotNull
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    @NotNull
    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    @NotNull
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final void setLastGoodStreamId$okhttp(int n) {
        this.lastGoodStreamId = n;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final void setNextStreamId$okhttp(int n) {
        this.nextStreamId = n;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final void setPeerSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    @NotNull
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    @Nullable
    public final synchronized Http2Stream getStream(int n) {
        return this.streams.get(n);
    }

    @Nullable
    public final synchronized Http2Stream removeStream$okhttp(int n) {
        Http2Stream http2Stream = this.streams.remove(n);
        Http2Connection http2Connection = this;
        boolean bl = false;
        Intrinsics.checkNotNull(http2Connection, "null cannot be cast to non-null type java.lang.Object");
        ((Object)http2Connection).notifyAll();
        return http2Stream;
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long l) {
        this.readBytesTotal += l;
        long l2 = this.readBytesTotal - this.readBytesAcknowledged;
        if (l2 >= (long)(this.okHttpSettings.getInitialWindowSize() / 2)) {
            this.writeWindowUpdateLater$okhttp(0, l2);
            this.readBytesAcknowledged += l2;
        }
    }

    @NotNull
    public final Http2Stream pushStream(int n, @NotNull List<Header> list, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        if (!(!this.client)) {
            boolean bl2 = false;
            String string = "Client cannot push requests.";
            throw new IllegalStateException(string.toString());
        }
        return this.newStream(n, list, bl);
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List<Header> list, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        return this.newStream(0, list, bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Http2Stream newStream(int n, List<Header> list, boolean bl) throws IOException {
        boolean bl2 = !bl;
        boolean bl3 = false;
        boolean bl4 = false;
        Http2Stream http2Stream = null;
        int n2 = 0;
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            boolean bl5 = false;
            Http2Connection http2Connection = this;
            synchronized (http2Connection) {
                boolean bl6 = false;
                if (this.nextStreamId > 0x3FFFFFFF) {
                    this.shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                n2 = this.nextStreamId;
                this.nextStreamId += 2;
                http2Stream = new Http2Stream(n2, this, bl2, bl3, null);
                boolean bl7 = bl4 = !bl || this.writeBytesTotal >= this.writeBytesMaximum || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
                if (http2Stream.isOpen()) {
                    this.streams.put(n2, http2Stream);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (n == 0) {
                this.writer.headers(bl2, n2, list);
            } else {
                if (!(!this.client)) {
                    boolean bl8 = false;
                    String string = "client streams shouldn't have associated stream IDs";
                    throw new IllegalArgumentException(string.toString());
                }
                this.writer.pushPromise(n, n2, list);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (bl4) {
            this.writer.flush();
        }
        return http2Stream;
    }

    public final void writeHeaders$okhttp(int n, boolean bl, @NotNull List<Header> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "alternating");
        this.writer.headers(bl, n, list);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void writeData(int n, boolean bl, @Nullable Buffer buffer, long l) throws IOException {
        if (l == 0L) {
            this.writer.data(bl, n, buffer, 0);
            return;
        }
        long l2 = 0L;
        l2 = l;
        while (l2 > 0L) {
            int n2 = 0;
            Http2Connection http2Connection = this;
            synchronized (http2Connection) {
                boolean bl2 = false;
                try {
                    while (this.writeBytesTotal >= this.writeBytesMaximum) {
                        if (!this.streams.containsKey(n)) {
                            throw new IOException("stream closed");
                        }
                        Http2Connection http2Connection2 = this;
                        boolean bl3 = false;
                        Intrinsics.checkNotNull(http2Connection2, "null cannot be cast to non-null type java.lang.Object");
                        ((Object)http2Connection2).wait();
                    }
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
                n2 = (int)Math.min(l2, this.writeBytesMaximum - this.writeBytesTotal);
                n2 = Math.min(n2, this.writer.maxDataLength());
                this.writeBytesTotal += (long)n2;
                Unit unit = Unit.INSTANCE;
            }
            this.writer.data(bl && (l2 -= (long)n2) == 0L, n, buffer, n2);
        }
    }

    public final void writeSynResetLater$okhttp(int n, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter((Object)errorCode, "errorCode");
        TaskQueue taskQueue = this.writerQueue;
        String string = this.connectionName + '[' + n + "] writeSynReset";
        long l = 0L;
        boolean bl = true;
        boolean bl2 = false;
        taskQueue.schedule(new Task(string, bl, this, n, errorCode){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ ErrorCode $errorCode$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$errorCode$inlined = errorCode;
                super(string, bl);
            }

            public long runOnce() {
                boolean bl = false;
                try {
                    this.this$0.writeSynReset$okhttp(this.$streamId$inlined, this.$errorCode$inlined);
                }
                catch (IOException iOException) {
                    Http2Connection.access$failConnection(this.this$0, iOException);
                }
                return -1L;
            }
        }, l);
    }

    public final void writeSynReset$okhttp(int n, @NotNull ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter((Object)errorCode, "statusCode");
        this.writer.rstStream(n, errorCode);
    }

    public final void writeWindowUpdateLater$okhttp(int n, long l) {
        TaskQueue taskQueue = this.writerQueue;
        String string = this.connectionName + '[' + n + "] windowUpdate";
        long l2 = 0L;
        boolean bl = true;
        boolean bl2 = false;
        taskQueue.schedule(new Task(string, bl, this, n, l){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ long $unacknowledgedBytesRead$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$unacknowledgedBytesRead$inlined = l;
                super(string, bl);
            }

            public long runOnce() {
                boolean bl = false;
                try {
                    this.this$0.getWriter().windowUpdate(this.$streamId$inlined, this.$unacknowledgedBytesRead$inlined);
                }
                catch (IOException iOException) {
                    Http2Connection.access$failConnection(this.this$0, iOException);
                }
                return -1L;
            }
        }, l2);
    }

    public final void writePing(boolean bl, int n, int n2) {
        try {
            this.writer.ping(bl, n, n2);
        }
        catch (IOException iOException) {
            this.failConnection(iOException);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        this.writePing();
        this.awaitPong();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void writePing() throws InterruptedException {
        Http2Connection http2Connection = this;
        synchronized (http2Connection) {
            boolean bl = false;
            long l = this.awaitPingsSent;
            this.awaitPingsSent = l + 1L;
            long l2 = l;
        }
        this.writePing(false, 3, 1330343787);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            Http2Connection http2Connection = this;
            boolean bl = false;
            Intrinsics.checkNotNull(http2Connection, "null cannot be cast to non-null type java.lang.Object");
            ((Object)http2Connection).wait();
        }
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void shutdown(@NotNull ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter((Object)errorCode, "statusCode");
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            boolean bl = false;
            Ref.IntRef intRef = new Ref.IntRef();
            Http2Connection http2Connection = this;
            synchronized (http2Connection) {
                boolean bl2 = false;
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                intRef.element = this.lastGoodStreamId;
                Unit unit = Unit.INSTANCE;
            }
            this.writer.goAway(intRef.element, errorCode, Util.EMPTY_BYTE_ARRAY);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override
    public void close() {
        this.close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void close$okhttp(@NotNull ErrorCode errorCode, @NotNull ErrorCode errorCode2, @Nullable IOException iOException) {
        Http2Stream[] http2StreamArray;
        int n;
        Intrinsics.checkNotNullParameter((Object)errorCode, "connectionCode");
        Intrinsics.checkNotNullParameter((Object)errorCode2, "streamCode");
        Http2Connection http2Connection = this;
        boolean bl = false;
        if (Util.assertionsEnabled && Thread.holdsLock(http2Connection)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Connection));
        }
        boolean bl2 = false;
        try {
            bl = false;
            this.shutdown(errorCode);
        }
        catch (IOException iOException2) {
        }
        Http2Stream[] http2StreamArray2 = null;
        Http2Connection http2Connection2 = this;
        synchronized (http2Connection2) {
            boolean bl3 = false;
            if (!this.streams.isEmpty()) {
                Collection<Http2Stream> collection = this.streams.values();
                n = 0;
                Collection<Http2Stream> collection2 = collection;
                http2StreamArray2 = collection2.toArray(new Http2Stream[0]);
                this.streams.clear();
            }
            http2StreamArray = Unit.INSTANCE;
        }
        Http2Stream[] http2StreamArray3 = http2StreamArray2;
        if (http2StreamArray3 != null) {
            http2StreamArray = http2StreamArray3;
            boolean bl4 = false;
            int n2 = http2StreamArray.length;
            for (n = 0; n < n2; ++n) {
                Http2Stream http2Stream;
                Http2Stream http2Stream2 = http2Stream = http2StreamArray[n];
                boolean bl5 = false;
                boolean bl6 = false;
                try {
                    boolean bl7 = false;
                    http2Stream2.close(errorCode2, iOException);
                    continue;
                }
                catch (IOException iOException3) {
                }
            }
        }
        boolean bl8 = false;
        try {
            boolean bl9 = false;
            this.writer.close();
        }
        catch (IOException iOException4) {
        }
        bl8 = false;
        try {
            boolean bl10 = false;
            this.socket.close();
        }
        catch (IOException iOException5) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    private final void failConnection(IOException iOException) {
        this.close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, iOException);
    }

    @JvmOverloads
    public final void start(boolean bl, @NotNull TaskRunner taskRunner) throws IOException {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        if (bl) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int n = this.okHttpSettings.getInitialWindowSize();
            if (n != 65535) {
                this.writer.windowUpdate(0, n - 65535);
            }
        }
        TaskQueue taskQueue = taskRunner.newQueue();
        String string = this.connectionName;
        Function0 function0 = this.readerRunnable;
        long l = 0L;
        boolean bl2 = true;
        boolean bl3 = false;
        taskQueue.schedule(new Task(string, bl2, function0){
            final /* synthetic */ Function0<Unit> $block;
            {
                this.$block = function0;
                super(string, bl);
            }

            public long runOnce() {
                this.$block.invoke();
                return -1L;
            }
        }, l);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean bl, TaskRunner taskRunner, int n, Object object) throws IOException {
        if ((n & 1) != 0) {
            bl = true;
        }
        if ((n & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(bl, taskRunner);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setSettings(@NotNull Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            boolean bl = false;
            Http2Connection http2Connection = this;
            synchronized (http2Connection) {
                boolean bl2 = false;
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
                Unit unit = Unit.INSTANCE;
            }
            this.writer.settings(settings);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final synchronized boolean isHealthy(long l) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || l < this.degradedPongDeadlineNs;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void sendDegradedPingLater$okhttp() {
        Object object;
        long l;
        Object object2 = this;
        synchronized (object2) {
            boolean bl = false;
            if (this.degradedPongsReceived < this.degradedPingsSent) {
                return;
            }
            l = this.degradedPingsSent;
            this.degradedPingsSent = l + 1L;
            this.degradedPongDeadlineNs = System.nanoTime() + (long)1000000000;
            object = Unit.INSTANCE;
        }
        object2 = this.writerQueue;
        object = this.connectionName + " ping";
        l = 0L;
        boolean bl = true;
        boolean bl2 = false;
        ((TaskQueue)object2).schedule(new Task((String)object, bl, this){
            final /* synthetic */ Http2Connection this$0;
            {
                this.this$0 = http2Connection;
                super(string, bl);
            }

            public long runOnce() {
                boolean bl = false;
                this.this$0.writePing(false, 2, 0);
                return -1L;
            }
        }, l);
    }

    public final boolean pushedStream$okhttp(int n) {
        return n != 0 && (n & 1) == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void pushRequestLater$okhttp(int n, @NotNull List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        Object object = this;
        synchronized (object) {
            boolean bl = false;
            if (this.currentPushRequests.contains(n)) {
                this.writeSynResetLater$okhttp(n, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            bl = this.currentPushRequests.add(n);
        }
        object = this.pushQueue;
        String string = this.connectionName + '[' + n + "] onRequest";
        long l = 0L;
        boolean bl = true;
        boolean bl2 = false;
        ((TaskQueue)object).schedule(new Task(string, bl, this, n, list){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ List $requestHeaders$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$requestHeaders$inlined = list;
                super(string, bl);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long runOnce() {
                block5: {
                    boolean bl = false;
                    boolean bl2 = Http2Connection.access$getPushObserver$p(this.this$0).onRequest(this.$streamId$inlined, this.$requestHeaders$inlined);
                    boolean bl3 = false;
                    try {
                        boolean bl4 = false;
                        if (!bl2) break block5;
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                        Http2Connection http2Connection = this.this$0;
                        synchronized (http2Connection) {
                            boolean bl5 = false;
                            bl5 = Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove(this.$streamId$inlined);
                        }
                    }
                    catch (IOException iOException) {
                    }
                }
                return -1L;
            }
        }, l);
    }

    public final void pushHeadersLater$okhttp(int n, @NotNull List<Header> list, boolean bl) {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        String string = this.connectionName + '[' + n + "] onHeaders";
        long l = 0L;
        boolean bl2 = true;
        boolean bl3 = false;
        taskQueue.schedule(new Task(string, bl2, this, n, list, bl){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ List $requestHeaders$inlined;
            final /* synthetic */ boolean $inFinished$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$requestHeaders$inlined = list;
                this.$inFinished$inlined = bl2;
                super(string, bl);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long runOnce() {
                block6: {
                    boolean bl = false;
                    boolean bl2 = Http2Connection.access$getPushObserver$p(this.this$0).onHeaders(this.$streamId$inlined, this.$requestHeaders$inlined, this.$inFinished$inlined);
                    boolean bl3 = false;
                    try {
                        boolean bl4 = false;
                        if (bl2) {
                            this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                        }
                        if (!bl2 && !this.$inFinished$inlined) break block6;
                        Http2Connection http2Connection = this.this$0;
                        synchronized (http2Connection) {
                            boolean bl5 = false;
                            bl5 = Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove(this.$streamId$inlined);
                        }
                    }
                    catch (IOException iOException) {
                    }
                }
                return -1L;
            }
        }, l);
    }

    public final void pushDataLater$okhttp(int n, @NotNull BufferedSource bufferedSource, int n2, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        Buffer buffer = new Buffer();
        bufferedSource.require(n2);
        bufferedSource.read(buffer, n2);
        TaskQueue taskQueue = this.pushQueue;
        String string = this.connectionName + '[' + n + "] onData";
        long l = 0L;
        boolean bl2 = true;
        boolean bl3 = false;
        taskQueue.schedule(new Task(string, bl2, this, n, buffer, n2, bl){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Buffer $buffer$inlined;
            final /* synthetic */ int $byteCount$inlined;
            final /* synthetic */ boolean $inFinished$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$buffer$inlined = buffer;
                this.$byteCount$inlined = n2;
                this.$inFinished$inlined = bl2;
                super(string, bl);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long runOnce() {
                block6: {
                    boolean bl = false;
                    boolean bl2 = false;
                    try {
                        boolean bl3 = false;
                        boolean bl4 = Http2Connection.access$getPushObserver$p(this.this$0).onData(this.$streamId$inlined, this.$buffer$inlined, this.$byteCount$inlined, this.$inFinished$inlined);
                        if (bl4) {
                            this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                        }
                        if (!bl4 && !this.$inFinished$inlined) break block6;
                        Http2Connection http2Connection = this.this$0;
                        synchronized (http2Connection) {
                            boolean bl5 = false;
                            bl5 = Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove(this.$streamId$inlined);
                        }
                    }
                    catch (IOException iOException) {
                    }
                }
                return -1L;
            }
        }, l);
    }

    public final void pushResetLater$okhttp(int n, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter((Object)errorCode, "errorCode");
        TaskQueue taskQueue = this.pushQueue;
        String string = this.connectionName + '[' + n + "] onReset";
        long l = 0L;
        boolean bl = true;
        boolean bl2 = false;
        taskQueue.schedule(new Task(string, bl, this, n, errorCode){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ ErrorCode $errorCode$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$errorCode$inlined = errorCode;
                super(string, bl);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long runOnce() {
                boolean bl = false;
                Http2Connection.access$getPushObserver$p(this.this$0).onReset(this.$streamId$inlined, this.$errorCode$inlined);
                Http2Connection http2Connection = this.this$0;
                synchronized (http2Connection) {
                    boolean bl2 = false;
                    Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove(this.$streamId$inlined);
                    Unit unit = Unit.INSTANCE;
                }
                return -1L;
            }
        }, l);
    }

    @JvmOverloads
    public final void start(boolean bl) throws IOException {
        Http2Connection.start$default(this, bl, null, 2, null);
    }

    @JvmOverloads
    public final void start() throws IOException {
        Http2Connection.start$default(this, false, null, 3, null);
    }

    public static final /* synthetic */ long access$getIntervalPingsSent$p(Http2Connection http2Connection) {
        return http2Connection.intervalPingsSent;
    }

    public static final /* synthetic */ void access$setIntervalPingsSent$p(Http2Connection http2Connection, long l) {
        http2Connection.intervalPingsSent = l;
    }

    public static final /* synthetic */ Set access$getCurrentPushRequests$p(Http2Connection http2Connection) {
        return http2Connection.currentPushRequests;
    }

    public static final /* synthetic */ PushObserver access$getPushObserver$p(Http2Connection http2Connection) {
        return http2Connection.pushObserver;
    }

    static {
        Settings settings;
        Companion = new Companion(null);
        Settings settings2 = settings = new Settings();
        boolean bl = false;
        settings2.set(7, 65535);
        settings2.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u00107\u001a\u000208J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ.\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010#\u001a\u00020$H\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106\u00a8\u0006:"}, d2={"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "client", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "build", "Lokhttp3/internal/http2/Http2Connection;", "peerName", "okhttp"})
    public static final class Builder {
        private boolean client;
        @NotNull
        private final TaskRunner taskRunner;
        public Socket socket;
        public String connectionName;
        public BufferedSource source;
        public BufferedSink sink;
        @NotNull
        private Listener listener;
        @NotNull
        private PushObserver pushObserver;
        private int pingIntervalMillis;

        public Builder(boolean bl, @NotNull TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = bl;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final void setClient$okhttp(boolean bl) {
            this.client = bl;
        }

        @NotNull
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @NotNull
        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final void setSocket$okhttp(@NotNull Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "<set-?>");
            this.socket = socket;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String string = this.connectionName;
            if (string != null) {
                return string;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final void setConnectionName$okhttp(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "<set-?>");
            this.connectionName = string;
        }

        @NotNull
        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        public final void setSource$okhttp(@NotNull BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        @NotNull
        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final void setSink$okhttp(@NotNull BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        @NotNull
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final void setListener$okhttp(@NotNull Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "<set-?>");
            this.listener = listener;
        }

        @NotNull
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final void setPingIntervalMillis$okhttp(int n) {
            this.pingIntervalMillis = n;
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String string, @NotNull BufferedSource bufferedSource, @NotNull BufferedSink bufferedSink) throws IOException {
            Builder builder;
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(string, "peerName");
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            Intrinsics.checkNotNullParameter(bufferedSink, "sink");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.setSocket$okhttp(socket);
            builder2.setConnectionName$okhttp(builder2.client ? Util.okHttpName + ' ' + string : "MockWebServer " + string);
            builder2.setSource$okhttp(bufferedSource);
            builder2.setSink$okhttp(bufferedSink);
            return builder;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String string, BufferedSource bufferedSource, BufferedSink bufferedSink, int n, Object object) throws IOException {
            if ((n & 2) != 0) {
                string = Util.peerName(socket);
            }
            if ((n & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((n & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, string, bufferedSource, bufferedSink);
        }

        @NotNull
        public final Builder listener(@NotNull Listener listener) {
            Builder builder;
            Intrinsics.checkNotNullParameter(listener, "listener");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.listener = listener;
            return builder;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver pushObserver) {
            Builder builder;
            Intrinsics.checkNotNullParameter(pushObserver, "pushObserver");
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.pushObserver = pushObserver;
            return builder;
        }

        @NotNull
        public final Builder pingIntervalMillis(int n) {
            Builder builder;
            Builder builder2 = builder = this;
            boolean bl = false;
            builder2.pingIntervalMillis = n;
            return builder;
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String string, @NotNull BufferedSource bufferedSource) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(string, "peerName");
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            return Builder.socket$default(this, socket, string, bufferedSource, null, 8, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String string) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(string, "peerName");
            return Builder.socket$default(this, socket, string, null, null, 12, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            return Builder.socket$default(this, socket, null, null, null, 14, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "()V", "AWAIT_PING", "", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return DEFAULT_SETTINGS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2={"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"})
    public static abstract class Listener {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @JvmField
        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener(){

            public void onStream(@NotNull Http2Stream http2Stream) throws IOException {
                Intrinsics.checkNotNullParameter(http2Stream, "stream");
                http2Stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        public abstract void onStream(@NotNull Http2Stream var1) throws IOException;

        public void onSettings(@NotNull Http2Connection http2Connection, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter(http2Connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J.\u0010$\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\t\u0010)\u001a\u00020\u0003H\u0096\u0002J \u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0016J(\u0010.\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0017H\u0016J&\u00102\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u00068"}, d2={"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "reader", "Lokhttp3/internal/http2/Http2Reader;", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "ackSettings", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "applyAndAckSettings", "clearPrevious", "", "settings", "Lokhttp3/internal/http2/Settings;", "data", "inFinished", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "invoke", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "windowUpdate", "windowSizeIncrement", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHttp2Connection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n+ 2 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Util.kt\nokhttp3/internal/Util\n*L\n1#1,1006:1\n90#2,13:1007\n90#2,13:1020\n90#2,13:1035\n90#2,13:1049\n37#3,2:1033\n37#3,2:1062\n563#4:1048\n563#4:1064\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n*L\n687#1:1007,13\n715#1:1020,13\n758#1:1035,13\n806#1:1049,13\n753#1:1033,2\n824#1:1062,2\n797#1:1048\n841#1:1064\n*E\n"})
    public final class ReaderRunnable
    implements Http2Reader.Handler,
    Function0<Unit> {
        @NotNull
        private final Http2Reader reader;

        public ReaderRunnable(Http2Reader http2Reader) {
            Intrinsics.checkNotNullParameter(http2Reader, "reader");
            this.reader = http2Reader;
        }

        @NotNull
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void invoke() {
            ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException iOException = null;
            try {
                this.reader.readConnectionPreface(this);
                while (this.reader.nextFrame(false, this)) {
                }
                errorCode = ErrorCode.NO_ERROR;
                errorCode2 = ErrorCode.CANCEL;
            }
            catch (IOException iOException2) {
                iOException = iOException2;
                errorCode = ErrorCode.PROTOCOL_ERROR;
                errorCode2 = ErrorCode.PROTOCOL_ERROR;
            }
            finally {
                Http2Connection.this.close$okhttp(errorCode, errorCode2, iOException);
                Util.closeQuietly(this.reader);
            }
        }

        @Override
        public void data(boolean bl, int n, @NotNull BufferedSource bufferedSource, int n2) throws IOException {
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            if (Http2Connection.this.pushedStream$okhttp(n)) {
                Http2Connection.this.pushDataLater$okhttp(n, bufferedSource, n2, bl);
                return;
            }
            Http2Stream http2Stream = Http2Connection.this.getStream(n);
            if (http2Stream == null) {
                Http2Connection.this.writeSynResetLater$okhttp(n, ErrorCode.PROTOCOL_ERROR);
                Http2Connection.this.updateConnectionFlowControl$okhttp(n2);
                bufferedSource.skip(n2);
                return;
            }
            http2Stream.receiveData(bufferedSource, n2);
            if (bl) {
                http2Stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void headers(boolean bl, int n, int n2, @NotNull List<Header> list) {
            Intrinsics.checkNotNullParameter(list, "headerBlock");
            if (Http2Connection.this.pushedStream$okhttp(n)) {
                Http2Connection.this.pushHeadersLater$okhttp(n, list, bl);
                return;
            }
            Http2Stream http2Stream = null;
            Http2Connection http2Connection = Http2Connection.this;
            Http2Connection http2Connection2 = Http2Connection.this;
            Http2Connection http2Connection3 = http2Connection;
            synchronized (http2Connection3) {
                boolean bl2 = false;
                http2Stream = http2Connection2.getStream(n);
                if (http2Stream == null) {
                    if (http2Connection2.isShutdown) {
                        return;
                    }
                    if (n <= http2Connection2.getLastGoodStreamId$okhttp()) {
                        return;
                    }
                    if (n % 2 == http2Connection2.getNextStreamId$okhttp() % 2) {
                        return;
                    }
                    Headers headers = Util.toHeaders(list);
                    Http2Stream http2Stream2 = new Http2Stream(n, http2Connection2, false, bl, headers);
                    http2Connection2.setLastGoodStreamId$okhttp(n);
                    Object object = n;
                    http2Connection2.getStreams$okhttp().put((Integer)object, http2Stream2);
                    TaskQueue taskQueue = http2Connection2.taskRunner.newQueue();
                    object = http2Connection2.getConnectionName$okhttp() + '[' + n + "] onStream";
                    long l = 0L;
                    boolean bl3 = true;
                    boolean bl4 = false;
                    taskQueue.schedule(new Task((String)object, bl3, http2Connection2, http2Stream2){
                        final /* synthetic */ Http2Connection this$0;
                        final /* synthetic */ Http2Stream $newStream$inlined;
                        {
                            this.this$0 = http2Connection;
                            this.$newStream$inlined = http2Stream;
                            super(string, bl);
                        }

                        public long runOnce() {
                            boolean bl = false;
                            try {
                                this.this$0.getListener$okhttp().onStream(this.$newStream$inlined);
                            }
                            catch (IOException iOException) {
                                Platform.Companion.get().log("Http2Connection.Listener failure for " + this.this$0.getConnectionName$okhttp(), 4, iOException);
                                boolean bl2 = false;
                                try {
                                    boolean bl3 = false;
                                    this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, iOException);
                                }
                                catch (IOException iOException2) {
                                }
                            }
                            return -1L;
                        }
                    }, l);
                    return;
                }
                Unit unit = Unit.INSTANCE;
            }
            http2Stream.receiveHeaders(Util.toHeaders(list), bl);
        }

        @Override
        public void rstStream(int n, @NotNull ErrorCode errorCode) {
            block1: {
                Http2Stream http2Stream;
                Intrinsics.checkNotNullParameter((Object)errorCode, "errorCode");
                if (Http2Connection.this.pushedStream$okhttp(n)) {
                    Http2Connection.this.pushResetLater$okhttp(n, errorCode);
                    return;
                }
                Http2Stream http2Stream2 = http2Stream = Http2Connection.this.removeStream$okhttp(n);
                if (http2Stream2 == null) break block1;
                http2Stream2.receiveRstStream(errorCode);
            }
        }

        @Override
        public void settings(boolean bl, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            TaskQueue taskQueue = Http2Connection.this.writerQueue;
            String string = Http2Connection.this.getConnectionName$okhttp() + " applyAndAckSettings";
            long l = 0L;
            boolean bl2 = true;
            boolean bl3 = false;
            taskQueue.schedule(new Task(string, bl2, this, bl, settings){
                final /* synthetic */ ReaderRunnable this$0;
                final /* synthetic */ boolean $clearPrevious$inlined;
                final /* synthetic */ Settings $settings$inlined;
                {
                    this.this$0 = readerRunnable;
                    this.$clearPrevious$inlined = bl2;
                    this.$settings$inlined = settings;
                    super(string, bl);
                }

                public long runOnce() {
                    boolean bl = false;
                    this.this$0.applyAndAckSettings(this.$clearPrevious$inlined, this.$settings$inlined);
                    return -1L;
                }
            }, l);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void applyAndAckSettings(boolean bl, @NotNull Settings settings) {
            Object object;
            Unit unit;
            Object object2;
            Intrinsics.checkNotNullParameter(settings, "settings");
            long l = 0L;
            Http2Stream[] http2StreamArray = null;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Http2Stream[] http2StreamArray2 = Http2Connection.this.getWriter();
            Http2Connection http2Connection = Http2Connection.this;
            Http2Stream[] http2StreamArray3 = http2StreamArray2;
            synchronized (http2StreamArray3) {
                boolean bl2 = false;
                object2 = http2Connection;
                synchronized (object2) {
                    Http2Stream[] http2StreamArray4;
                    Settings settings2;
                    boolean bl3 = false;
                    Settings settings3 = http2Connection.getPeerSettings();
                    Ref.ObjectRef objectRef2 = objectRef;
                    if (bl) {
                        settings2 = settings;
                    } else {
                        Settings settings4;
                        Settings settings5 = settings4 = new Settings();
                        Ref.ObjectRef objectRef3 = objectRef2;
                        boolean bl4 = false;
                        settings5.merge(settings3);
                        settings5.merge(settings);
                        objectRef2 = objectRef3;
                        settings2 = settings4;
                    }
                    objectRef2.element = settings2;
                    long l2 = ((Settings)objectRef.element).getInitialWindowSize();
                    l = l2 - (long)settings3.getInitialWindowSize();
                    if (l == 0L || http2Connection.getStreams$okhttp().isEmpty()) {
                        http2StreamArray4 = null;
                    } else {
                        Collection<Http2Stream> collection = http2Connection.getStreams$okhttp().values();
                        boolean bl5 = false;
                        Collection<Http2Stream> collection2 = collection;
                        http2StreamArray4 = collection2.toArray(new Http2Stream[0]);
                    }
                    http2StreamArray = http2StreamArray4;
                    http2Connection.setPeerSettings((Settings)objectRef.element);
                    TaskQueue taskQueue = http2Connection.settingsListenerQueue;
                    String string = http2Connection.getConnectionName$okhttp() + " onSettings";
                    long l3 = 0L;
                    boolean bl6 = true;
                    boolean bl7 = false;
                    taskQueue.schedule(new Task(string, bl6, http2Connection, objectRef){
                        final /* synthetic */ Http2Connection this$0;
                        final /* synthetic */ Ref.ObjectRef $newPeerSettings$inlined;
                        {
                            this.this$0 = http2Connection;
                            this.$newPeerSettings$inlined = objectRef;
                            super(string, bl);
                        }

                        public long runOnce() {
                            boolean bl = false;
                            this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings)this.$newPeerSettings$inlined.element);
                            return -1L;
                        }
                    }, l3);
                    unit = Unit.INSTANCE;
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings)objectRef.element);
                }
                catch (IOException iOException) {
                    http2Connection.failConnection(iOException);
                }
                object = Unit.INSTANCE;
            }
            if (http2StreamArray != null) {
                http2StreamArray2 = http2StreamArray;
                int n = http2StreamArray2.length;
                for (int i = 0; i < n; ++i) {
                    object2 = object = http2StreamArray2[i];
                    synchronized (object2) {
                        boolean bl8 = false;
                        ((Http2Stream)object).addBytesToWriteWindow(l);
                        unit = Unit.INSTANCE;
                        continue;
                    }
                }
            }
        }

        @Override
        public void ackSettings() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void ping(boolean bl, int n, int n2) {
            if (bl) {
                Http2Connection http2Connection = Http2Connection.this;
                Http2Connection http2Connection2 = Http2Connection.this;
                Http2Connection http2Connection3 = http2Connection;
                synchronized (http2Connection3) {
                    Object object;
                    boolean bl2 = false;
                    switch (n) {
                        case 1: {
                            long l = http2Connection2.intervalPongsReceived;
                            http2Connection2.intervalPongsReceived = l + 1L;
                            object = l;
                            break;
                        }
                        case 2: {
                            long l = http2Connection2.degradedPongsReceived;
                            http2Connection2.degradedPongsReceived = l + 1L;
                            object = l;
                            break;
                        }
                        case 3: {
                            long l = http2Connection2.awaitPongsReceived;
                            http2Connection2.awaitPongsReceived = l + 1L;
                            Http2Connection http2Connection4 = http2Connection2;
                            boolean bl3 = false;
                            Intrinsics.checkNotNull(http2Connection4, "null cannot be cast to non-null type java.lang.Object");
                            ((Object)http2Connection4).notifyAll();
                            object = Unit.INSTANCE;
                            break;
                        }
                        default: {
                            object = Unit.INSTANCE;
                        }
                    }
                    Unit unit = object;
                }
            } else {
                TaskQueue taskQueue = Http2Connection.this.writerQueue;
                String string = Http2Connection.this.getConnectionName$okhttp() + " ping";
                Http2Connection http2Connection = Http2Connection.this;
                long l = 0L;
                boolean bl4 = true;
                boolean bl5 = false;
                taskQueue.schedule(new Task(string, bl4, http2Connection, n, n2){
                    final /* synthetic */ Http2Connection this$0;
                    final /* synthetic */ int $payload1$inlined;
                    final /* synthetic */ int $payload2$inlined;
                    {
                        this.this$0 = http2Connection;
                        this.$payload1$inlined = n;
                        this.$payload2$inlined = n2;
                        super(string, bl);
                    }

                    public long runOnce() {
                        boolean bl = false;
                        this.this$0.writePing(true, this.$payload1$inlined, this.$payload2$inlined);
                        return -1L;
                    }
                }, l);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void goAway(int n, @NotNull ErrorCode errorCode, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter((Object)errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(byteString, "debugData");
            if (byteString.size() > 0) {
                // empty if block
            }
            Http2Stream[] http2StreamArray = null;
            Http2Stream[] http2StreamArray2 = Http2Connection.this;
            Http2Connection http2Connection = Http2Connection.this;
            Http2Stream[] http2StreamArray3 = http2StreamArray2;
            synchronized (http2StreamArray3) {
                boolean bl = false;
                Collection<Http2Stream> collection = http2Connection.getStreams$okhttp().values();
                boolean bl2 = false;
                Collection<Http2Stream> collection2 = collection;
                http2StreamArray = collection2.toArray(new Http2Stream[0]);
                http2Connection.isShutdown = true;
                Unit object = Unit.INSTANCE;
            }
            for (Http2Stream http2Stream : http2StreamArray) {
                if (http2Stream.getId() <= n || !http2Stream.isLocallyInitiated()) continue;
                http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                Http2Connection.this.removeStream$okhttp(http2Stream.getId());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void windowUpdate(int n, long l) {
            if (n == 0) {
                Http2Connection http2Connection = Http2Connection.this;
                Http2Connection http2Connection2 = Http2Connection.this;
                Http2Connection http2Connection3 = http2Connection;
                synchronized (http2Connection3) {
                    boolean bl = false;
                    http2Connection2.writeBytesMaximum = http2Connection2.getWriteBytesMaximum() + l;
                    Http2Connection http2Connection4 = http2Connection2;
                    boolean bl2 = false;
                    Intrinsics.checkNotNull(http2Connection4, "null cannot be cast to non-null type java.lang.Object");
                    ((Object)http2Connection4).notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
            }
            Http2Stream http2Stream = Http2Connection.this.getStream(n);
            if (http2Stream != null) {
                Http2Stream http2Stream2 = http2Stream;
                synchronized (http2Stream2) {
                    boolean bl = false;
                    http2Stream.addBytesToWriteWindow(l);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        @Override
        public void priority(int n, int n2, int n3, boolean bl) {
        }

        @Override
        public void pushPromise(int n, int n2, @NotNull List<Header> list) {
            Intrinsics.checkNotNullParameter(list, "requestHeaders");
            Http2Connection.this.pushRequestLater$okhttp(n2, list);
        }

        @Override
        public void alternateService(int n, @NotNull String string, @NotNull ByteString byteString, @NotNull String string2, int n2, long l) {
            Intrinsics.checkNotNullParameter(string, "origin");
            Intrinsics.checkNotNullParameter(byteString, "protocol");
            Intrinsics.checkNotNullParameter(string2, "host");
        }
    }
}

