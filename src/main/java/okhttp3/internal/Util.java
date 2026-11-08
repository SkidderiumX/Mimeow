/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u00b8\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017\u001a'\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"\u00a2\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\b\u00f8\u0001\u0000\u001a-\u0010'\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u0002H)0!\"\u0002H)H\u0007\u00a2\u0006\u0002\u0010+\u001a\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011\u001a1\u0010-\u001a\u0004\u0018\u0001H)\"\u0004\b\u0000\u0010)2\u0006\u0010.\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H)002\u0006\u00101\u001a\u00020\u0011\u00a2\u0006\u0002\u00102\u001a\u0016\u00103\u001a\u0002042\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u000f\u001a\"\u00106\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\b\u00f8\u0001\u0000\u001a%\u00107\u001a\u00020\u001b\"\u0004\b\u0000\u00108*\b\u0012\u0004\u0012\u0002H8092\u0006\u0010:\u001a\u0002H8H\u0000\u00a2\u0006\u0002\u0010;\u001a\u0015\u0010<\u001a\u00020\u0014*\u00020=2\u0006\u0010>\u001a\u00020\u0014H\u0086\u0004\u001a\u0015\u0010<\u001a\u00020\u0017*\u00020\u00142\u0006\u0010>\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010<\u001a\u00020\u0014*\u00020?2\u0006\u0010>\u001a\u00020\u0014H\u0086\u0004\u001a\n\u0010@\u001a\u00020A*\u00020B\u001a\r\u0010C\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\r\u0010D\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\n\u0010E\u001a\u00020\u000f*\u00020\u0011\u001a\u0012\u0010F\u001a\u00020\u000f*\u00020G2\u0006\u0010H\u001a\u00020G\u001a\n\u0010I\u001a\u00020\u001b*\u00020J\u001a\n\u0010I\u001a\u00020\u001b*\u00020K\u001a\n\u0010I\u001a\u00020\u001b*\u00020L\u001a#\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010N\u001a\u00020\u0011\u00a2\u0006\u0002\u0010O\u001a&\u0010P\u001a\u00020\u0014*\u00020\u00112\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a&\u0010P\u001a\u00020\u0014*\u00020\u00112\u0006\u0010U\u001a\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u001a\u0010V\u001a\u00020\u000f*\u00020W2\u0006\u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u0019\u001a;\u0010Z\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0[2\u0017\u0010\\\u001a\u0013\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u00020\u000f0]\u00a2\u0006\u0002\b^H\u0086\b\u00f8\u0001\u0000\u001a5\u0010_\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010!2\u000e\u0010`\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110a\u00a2\u0006\u0002\u0010b\u001a\n\u0010c\u001a\u00020\u0017*\u00020d\u001a+\u0010e\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010N\u001a\u00020\u00112\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00110a\u00a2\u0006\u0002\u0010f\u001a\n\u0010g\u001a\u00020\u0014*\u00020\u0011\u001a\u001e\u0010h\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u001e\u0010i\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u0014\u0010j\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u0014\u001a9\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010`\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110a\u00a2\u0006\u0002\u0010l\u001a\u0012\u0010m\u001a\u00020\u000f*\u00020n2\u0006\u0010o\u001a\u00020p\u001a\u0012\u0010q\u001a\u00020\u000f*\u00020L2\u0006\u0010r\u001a\u00020s\u001a\r\u0010t\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a\r\u0010u\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a\n\u0010v\u001a\u00020\u0014*\u00020R\u001a\n\u0010w\u001a\u00020\u0011*\u00020L\u001a\u0012\u0010x\u001a\u00020y*\u00020s2\u0006\u0010z\u001a\u00020y\u001a\n\u0010{\u001a\u00020\u0014*\u00020s\u001a\u0012\u0010|\u001a\u00020\u0014*\u00020}2\u0006\u0010~\u001a\u00020=\u001a\u001a\u0010|\u001a\u00020\u000f*\u00020W2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u0019\u001a\u0011\u0010\u007f\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010(*\u00020\u0003\u001a\u0012\u0010\u0081\u0001\u001a\u00020\u0003*\t\u0012\u0005\u0012\u00030\u0080\u00010(\u001a\u000b\u0010\u0082\u0001\u001a\u00020\u0011*\u00020\u0014\u001a\u000b\u0010\u0082\u0001\u001a\u00020\u0011*\u00020\u0017\u001a\u0016\u0010\u0083\u0001\u001a\u00020\u0011*\u00020G2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u000f\u001a\u001d\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(\u001a7\u0010\u0086\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u0088\u0001\u0012\u0005\u0012\u0003H\u0089\u00010\u0087\u0001\"\u0005\b\u0000\u0010\u0088\u0001\"\u0005\b\u0001\u0010\u0089\u0001*\u0011\u0012\u0005\u0012\u0003H\u0088\u0001\u0012\u0005\u0012\u0003H\u0089\u00010\u0087\u0001\u001a\u0014\u0010\u008a\u0001\u001a\u00020\u0017*\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0017\u001a\u0016\u0010\u008c\u0001\u001a\u00020\u0014*\u0004\u0018\u00010\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0014\u001a\u001f\u0010\u008d\u0001\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u000e\u0010\u008e\u0001\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a'\u0010\u008f\u0001\u001a\u00030\u0090\u0001*\b0\u0091\u0001j\u0003`\u0092\u00012\u0013\u0010\u0093\u0001\u001a\u000e\u0012\n\u0012\b0\u0091\u0001j\u0003`\u0092\u00010(\u001a\u0015\u0010\u0094\u0001\u001a\u00020\u001b*\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u0014\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u00118\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0097\u0001"}, d2={"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "", "okHttpName", "", "userAgent", "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", "offset", "count", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableListOf", "", "T", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "isSensitiveHeader", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "addIfAbsent", "E", "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "concat", "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", "discard", "Lokio/Source;", "timeout", "timeUnit", "filterList", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hasIntersection", "comparator", "Ljava/util/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "Lokhttp3/internal/io/FileSystem;", "file", "Ljava/io/File;", "isHealthy", "source", "Lokio/BufferedSource;", "notify", "notifyAll", "parseHexDigit", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", "V", "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "wait", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"})
@JvmName(name="Util")
@SourceDebugExtension(value={"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokhttp3/internal/Util\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,636:1\n37#2,2:637\n1627#3,6:639\n1#4:645\n1549#5:646\n1620#5,3:647\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokhttp3/internal/Util\n*L\n127#1:637,2\n167#1:639,6\n300#1:646\n300#1:647,3\n*E\n"})
public class Util {
    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, EMPTY_BYTE_ARRAY, null, 1, null);
    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, EMPTY_BYTE_ARRAY, null, 0, 0, 7, null);
    @NotNull
    private static final Options UNICODE_BOMS;
    @JvmField
    @NotNull
    public static final TimeZone UTC;
    @NotNull
    private static final Regex VERIFY_AS_IP_ADDRESS;
    @JvmField
    public static final boolean assertionsEnabled;
    @JvmField
    @NotNull
    public static final String okHttpName;
    @NotNull
    public static final String userAgent = "okhttp/4.12.0";

    public static final void checkOffsetAndCount(long l, long l2, long l3) {
        if ((l2 | l3) < 0L || l2 > l || l - l2 < l3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull String string, boolean bl) {
        Intrinsics.checkNotNullParameter(string, "name");
        return arg_0 -> Util.threadFactory$lambda$1(string, bl, arg_0);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] stringArray, @NotNull String[] stringArray2, @NotNull Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(stringArray, "<this>");
        Intrinsics.checkNotNullParameter(stringArray2, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        List list = new ArrayList();
        block0: for (String object2 : stringArray) {
            for (String string : stringArray2) {
                if (comparator.compare(object2, string) != 0) continue;
                list.add(object2);
                continue block0;
            }
        }
        Collection collection = list;
        int n = 0;
        Collection collection2 = collection;
        return collection2.toArray(new String[0]);
    }

    public static final boolean hasIntersection(@NotNull String[] stringArray, @Nullable String[] stringArray2, @NotNull Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(stringArray, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (stringArray.length == 0 || stringArray2 == null || stringArray2.length == 0) {
            return false;
        }
        for (String string : stringArray) {
            Iterator<String> iterator2 = ArrayIteratorKt.iterator(stringArray2);
            while (iterator2.hasNext()) {
                String string2 = iterator2.next();
                if (comparator.compare(string, string2) != 0) continue;
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl httpUrl, boolean bl) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        String string = StringsKt.contains$default((CharSequence)httpUrl.host(), ":", false, 2, null) ? '[' + httpUrl.host() + ']' : httpUrl.host();
        return bl || httpUrl.port() != HttpUrl.Companion.defaultPort(httpUrl.scheme()) ? string + ':' + httpUrl.port() : string;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return Util.toHostHeader(httpUrl, bl);
    }

    public static final int indexOf(@NotNull String[] stringArray, @NotNull String string, @NotNull Comparator<String> comparator) {
        int n;
        block1: {
            Intrinsics.checkNotNullParameter(stringArray, "<this>");
            Intrinsics.checkNotNullParameter(string, "value");
            Intrinsics.checkNotNullParameter(comparator, "comparator");
            String[] stringArray2 = stringArray;
            boolean bl = false;
            int n2 = stringArray2.length;
            for (int i = 0; i < n2; ++i) {
                String string2 = stringArray2[i];
                boolean bl2 = false;
                if (!(comparator.compare(string2, string) == 0)) continue;
                n = i;
                break block1;
            }
            n = -1;
        }
        return n;
    }

    @NotNull
    public static final String[] concat(@NotNull String[] stringArray, @NotNull String string) {
        Intrinsics.checkNotNullParameter(stringArray, "<this>");
        Intrinsics.checkNotNullParameter(string, "value");
        String[] stringArray2 = Arrays.copyOf(stringArray, stringArray.length + 1);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "copyOf(this, newSize)");
        String[] stringArray3 = stringArray2;
        stringArray3[ArraysKt.getLastIndex(stringArray3)] = string;
        return stringArray3;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String string, int n, int n2) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        for (int i = n; i < n2; ++i) {
            char c = string.charAt(i);
            if ((((c == '\t' ? true : c == '\n') ? true : c == '\f') ? true : c == '\r') ? true : c == ' ') continue;
            return i;
        }
        return n2;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        return Util.indexOfFirstNonAsciiWhitespace(string, n, n2);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String string, int n, int n2) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        int n3 = n2 - 1;
        if (n <= n3) {
            while (true) {
                char c;
                if (!(((((c = string.charAt(n3)) == '\t' ? true : c == '\n') ? true : c == '\f') ? true : c == '\r') ? true : c == ' ')) {
                    return n3 + 1;
                }
                if (n3 == n) break;
                --n3;
            }
        }
        return n;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        return Util.indexOfLastNonAsciiWhitespace(string, n, n2);
    }

    @NotNull
    public static final String trimSubstring(@NotNull String string, int n, int n2) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        int n3 = Util.indexOfFirstNonAsciiWhitespace(string, n, n2);
        int n4 = Util.indexOfLastNonAsciiWhitespace(string, n3, n2);
        String string2 = string.substring(n3, n4);
        Intrinsics.checkNotNullExpressionValue(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static /* synthetic */ String trimSubstring$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        return Util.trimSubstring(string, n, n2);
    }

    public static final int delimiterOffset(@NotNull String string, @NotNull String string2, int n, int n2) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        Intrinsics.checkNotNullParameter(string2, "delimiters");
        for (int i = n; i < n2; ++i) {
            if (!StringsKt.contains$default((CharSequence)string2, string.charAt(i), false, 2, null)) continue;
            return i;
        }
        return n2;
    }

    public static /* synthetic */ int delimiterOffset$default(String string, String string2, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            n2 = string.length();
        }
        return Util.delimiterOffset(string, string2, n, n2);
    }

    public static final int delimiterOffset(@NotNull String string, char c, int n, int n2) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        for (int i = n; i < n2; ++i) {
            if (string.charAt(i) != c) continue;
            return i;
        }
        return n2;
    }

    public static /* synthetic */ int delimiterOffset$default(String string, char c, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            n2 = string.length();
        }
        return Util.delimiterOffset(string, c, n, n2);
    }

    public static final int indexOfControlOrNonAscii(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (Intrinsics.compare(c, 31) > 0 && Intrinsics.compare(c, 127) < 0) continue;
            return i;
        }
        return -1;
    }

    public static final boolean canParseAsIpAddress(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(string);
    }

    public static final boolean isSensitiveHeader(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "name");
        return StringsKt.equals(string, "Authorization", true) || StringsKt.equals(string, "Cookie", true) || StringsKt.equals(string, "Proxy-Authorization", true) || StringsKt.equals(string, "Set-Cookie", true);
    }

    @NotNull
    public static final String format(@NotNull String string, Object ... objectArray) {
        Intrinsics.checkNotNullParameter(string, "format");
        Intrinsics.checkNotNullParameter(objectArray, "args");
        Locale locale = Locale.US;
        Object[] objectArray2 = Arrays.copyOf(objectArray, objectArray.length);
        String string2 = String.format(locale, string, Arrays.copyOf(objectArray2, objectArray2.length));
        Intrinsics.checkNotNullExpressionValue(string2, "format(locale, format, *args)");
        return string2;
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource bufferedSource, @NotNull Charset charset) throws IOException {
        Charset charset2;
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        switch (bufferedSource.select(UNICODE_BOMS)) {
            case 0: {
                Charset charset3 = StandardCharsets.UTF_8;
                charset2 = charset3;
                Intrinsics.checkNotNullExpressionValue(charset3, "UTF_8");
                break;
            }
            case 1: {
                Charset charset4 = StandardCharsets.UTF_16BE;
                charset2 = charset4;
                Intrinsics.checkNotNullExpressionValue(charset4, "UTF_16BE");
                break;
            }
            case 2: {
                Charset charset5 = StandardCharsets.UTF_16LE;
                charset2 = charset5;
                Intrinsics.checkNotNullExpressionValue(charset5, "UTF_16LE");
                break;
            }
            case 3: {
                charset2 = Charsets.INSTANCE.UTF32_BE();
                break;
            }
            case 4: {
                charset2 = Charsets.INSTANCE.UTF32_LE();
                break;
            }
            case -1: {
                charset2 = charset;
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return charset2;
    }

    public static final int checkDuration(@NotNull String string, long l, @Nullable TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(string, "name");
        if (!(l >= 0L)) {
            boolean bl = false;
            String string2 = string + " < 0";
            throw new IllegalStateException(string2.toString());
        }
        if (!(timeUnit != null)) {
            boolean bl = false;
            String string3 = "unit == null";
            throw new IllegalStateException(string3.toString());
        }
        long l2 = timeUnit.toMillis(l);
        if (!(l2 <= Integer.MAX_VALUE)) {
            boolean bl = false;
            String string4 = string + " too large.";
            throw new IllegalArgumentException(string4.toString());
        }
        if (!(l2 != 0L || l <= 0L)) {
            boolean bl = false;
            String string5 = string + " too small.";
            throw new IllegalArgumentException(string5.toString());
        }
        return (int)l2;
    }

    public static final int parseHexDigit(char c) {
        int n;
        block1: {
            char c2;
            block0: {
                c2 = c;
                boolean bl = '0' <= c2 ? c2 < ':' : false;
                if (!bl) break block0;
                n = c - 48;
                break block1;
            }
            n = ('a' <= c2 ? c2 < 'g' : false) ? c - 97 + 10 : (('A' <= c2 ? c2 < 'G' : false) ? c - 65 + 10 : -1);
        }
        return n;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            ByteString byteString = header.component1();
            ByteString byteString2 = header.component2();
            builder.addLenient$okhttp(byteString.utf8(), byteString2.utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Iterable iterable = RangesKt.until(0, headers.size());
        boolean bl = false;
        Iterable iterable2 = iterable;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        boolean bl2 = false;
        Iterator iterator2 = iterable2.iterator();
        while (iterator2.hasNext()) {
            int n;
            int n2 = n = ((IntIterator)iterator2).nextInt();
            Collection collection2 = collection;
            boolean bl3 = false;
            collection2.add(new Header(headers.name(n2), headers.value(n2)));
        }
        return (List)collection;
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl httpUrl, @NotNull HttpUrl httpUrl2) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        Intrinsics.checkNotNullParameter(httpUrl2, "other");
        return Intrinsics.areEqual(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && Intrinsics.areEqual(httpUrl.scheme(), httpUrl2.scheme());
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull EventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "<this>");
        return arg_0 -> Util.asFactory$lambda$8(eventListener, arg_0);
    }

    public static final int and(byte by, int n) {
        return by & n;
    }

    public static final int and(short s, int n) {
        return s & n;
    }

    public static final long and(int n, long l) {
        return (long)n & l;
    }

    public static final void writeMedium(@NotNull BufferedSink bufferedSink, int n) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "<this>");
        bufferedSink.writeByte(n >>> 16 & 0xFF);
        bufferedSink.writeByte(n >>> 8 & 0xFF);
        bufferedSink.writeByte(n & 0xFF);
    }

    public static final int readMedium(@NotNull BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        return Util.and(bufferedSource.readByte(), 255) << 16 | Util.and(bufferedSource.readByte(), 255) << 8 | Util.and(bufferedSource.readByte(), 255);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final boolean skipAll(@NotNull Source source2, int n, @NotNull TimeUnit timeUnit) throws IOException {
        boolean bl;
        Intrinsics.checkNotNullParameter(source2, "<this>");
        Intrinsics.checkNotNullParameter((Object)timeUnit, "timeUnit");
        long l = System.nanoTime();
        long l2 = source2.timeout().hasDeadline() ? source2.timeout().deadlineNanoTime() - l : Long.MAX_VALUE;
        source2.timeout().deadlineNanoTime(l + Math.min(l2, timeUnit.toNanos(n)));
        try {
            Buffer buffer = new Buffer();
            while (source2.read(buffer, 8192L) != -1L) {
                buffer.clear();
            }
            bl = true;
        }
        catch (InterruptedIOException interruptedIOException) {
            bl = false;
        }
        finally {
            if (l2 == Long.MAX_VALUE) {
                source2.timeout().clearDeadline();
            } else {
                source2.timeout().deadlineNanoTime(l + l2);
            }
        }
        return bl;
    }

    public static final boolean discard(@NotNull Source source2, int n, @NotNull TimeUnit timeUnit) {
        boolean bl;
        Intrinsics.checkNotNullParameter(source2, "<this>");
        Intrinsics.checkNotNullParameter((Object)timeUnit, "timeUnit");
        try {
            bl = Util.skipAll(source2, n, timeUnit);
        }
        catch (IOException iOException) {
            bl = false;
        }
        return bl;
    }

    @NotNull
    public static final String peerName(@NotNull Socket socket) {
        String string;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        SocketAddress socketAddress = socket.getRemoteSocketAddress();
        if (socketAddress instanceof InetSocketAddress) {
            String string2 = ((InetSocketAddress)socketAddress).getHostName();
            string = string2;
            Intrinsics.checkNotNullExpressionValue(string2, "address.hostName");
        } else {
            string = socketAddress.toString();
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final boolean isHealthy(@NotNull Socket socket, @NotNull BufferedSource bufferedSource) {
        int n;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        try {
            int n2;
            n = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                n2 = !bufferedSource.exhausted() ? 1 : 0;
            }
            finally {
                socket.setSoTimeout(n);
            }
            n = n2;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            n = 1;
        }
        catch (IOException iOException) {
            n = 0;
        }
        return n != 0;
    }

    public static final void ignoreIoExceptions(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean bl = false;
        try {
            function0.invoke();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void threadName(@NotNull String string, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(string, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean bl = false;
        Thread thread2 = Thread.currentThread();
        String string2 = thread2.getName();
        thread2.setName(string);
        try {
            function0.invoke();
        }
        finally {
            InlineMarker.finallyStart(1);
            thread2.setName(string2);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final int skipAll(@NotNull Buffer buffer, byte by) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int n = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == by) {
            ++n;
            buffer.readByte();
        }
        return n;
    }

    public static final int indexOfNonWhitespace(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        int n2 = string.length();
        for (int i = n; i < n2; ++i) {
            char c = string.charAt(i);
            if (c == ' ' || c == '\t') continue;
            return i;
        }
        return string.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String string, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        return Util.indexOfNonWhitespace(string, n);
    }

    public static final long headersContentLength(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        String string = response.headers().get("Content-Length");
        return string != null ? Util.toLongOrDefault(string, -1L) : -1L;
    }

    public static final long toLongOrDefault(@NotNull String string, long l) {
        long l2;
        Intrinsics.checkNotNullParameter(string, "<this>");
        try {
            l2 = Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            l2 = l;
        }
        return l2;
    }

    public static final int toNonNegativeInt(@Nullable String string, int n) {
        try {
            String string2 = string;
            if (string2 == null) {
                return n;
            }
            long l = Long.parseLong(string2);
            return l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (l < 0L ? 0 : (int)l);
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List list2 = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection)list));
        Intrinsics.checkNotNullExpressionValue(list2, "unmodifiableList(toMutableList())");
        return list2;
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(T ... TArray) {
        Intrinsics.checkNotNullParameter(TArray, "elements");
        Object[] objectArray = (Object[])TArray.clone();
        List<Object> list = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(objectArray, objectArray.length)));
        Intrinsics.checkNotNullExpressionValue(list, "unmodifiableList(listOf(*elements.clone()))");
        return list;
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> map) {
        Map map2;
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.isEmpty()) {
            map2 = MapsKt.emptyMap();
        } else {
            Map map3 = Collections.unmodifiableMap((Map)new LinkedHashMap<K, V>(map));
            map2 = map3;
            Intrinsics.checkNotNullExpressionValue(map3, "{\n    Collections.unmodi\u2026(LinkedHashMap(this))\n  }");
        }
        return map2;
    }

    public static final void closeQuietly(@NotNull Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void closeQuietly(@NotNull Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        try {
            socket.close();
        }
        catch (AssertionError assertionError) {
            throw assertionError;
        }
        catch (RuntimeException runtimeException) {
            if (Intrinsics.areEqual(runtimeException.getMessage(), "bio == null")) {
                return;
            }
            throw runtimeException;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void closeQuietly(@NotNull ServerSocket serverSocket) {
        Intrinsics.checkNotNullParameter(serverSocket, "<this>");
        try {
            serverSocket.close();
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Exception decompiling
     */
    public static final boolean isCivilized(@NotNull FileSystem var0, @NotNull File var1_1) {
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

    @NotNull
    public static final String toHexString(long l) {
        String string = Long.toHexString(l);
        Intrinsics.checkNotNullExpressionValue(string, "toHexString(this)");
        return string;
    }

    @NotNull
    public static final String toHexString(int n) {
        String string = Integer.toHexString(n);
        Intrinsics.checkNotNullExpressionValue(string, "toHexString(this)");
        return string;
    }

    public static final void wait(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "<this>");
        boolean bl = false;
        object.wait();
    }

    public static final void notify(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "<this>");
        boolean bl = false;
        object.notify();
    }

    public static final void notifyAll(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "<this>");
        boolean bl = false;
        object.notifyAll();
    }

    @Nullable
    public static final <T> T readFieldOrNull(@NotNull Object object, @NotNull Class<T> clazz, @NotNull String string) {
        Object object2;
        Intrinsics.checkNotNullParameter(object, "instance");
        Intrinsics.checkNotNullParameter(clazz, "fieldType");
        Intrinsics.checkNotNullParameter(string, "fieldName");
        Class<?> clazz2 = object.getClass();
        while (!Intrinsics.areEqual(clazz2, Object.class)) {
            try {
                Field field = clazz2.getDeclaredField(string);
                field.setAccessible(true);
                Object object3 = field.get(object);
                return !clazz.isInstance(object3) ? null : (T)clazz.cast(object3);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Intrinsics.checkNotNullExpressionValue(clazz2.getSuperclass(), "c.superclass");
            }
        }
        if (!Intrinsics.areEqual(string, "delegate") && (object2 = Util.readFieldOrNull(object, Object.class, "delegate")) != null) {
            return Util.readFieldOrNull(object2, clazz, string);
        }
        return null;
    }

    public static final <E> void addIfAbsent(@NotNull List<E> list, E e) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.contains(e)) {
            list.add(e);
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "<this>");
        boolean bl = false;
        if (assertionsEnabled && !Thread.holdsLock(object)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + object));
        }
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "<this>");
        boolean bl = false;
        if (assertionsEnabled && Thread.holdsLock(object)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + object));
        }
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception exception, @NotNull List<? extends Exception> list) {
        Exception exception2;
        Intrinsics.checkNotNullParameter(exception, "<this>");
        Intrinsics.checkNotNullParameter(list, "suppressed");
        Exception exception3 = exception2 = exception;
        boolean bl = false;
        for (Exception exception4 : list) {
            ExceptionsKt.addSuppressed(exception3, exception4);
        }
        return exception2;
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        boolean bl = false;
        List list = CollectionsKt.emptyList();
        for (T t : iterable) {
            if (!function1.invoke(t).booleanValue()) continue;
            if (list.isEmpty()) {
                list = new ArrayList();
            }
            List list2 = list;
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
            TypeIntrinsics.asMutableList(list2).add(t);
        }
        return list;
    }

    private static final Thread threadFactory$lambda$1(String string, boolean bl, Runnable runnable2) {
        Thread thread2;
        Intrinsics.checkNotNullParameter(string, "$name");
        Thread thread3 = thread2 = new Thread(runnable2, string);
        boolean bl2 = false;
        thread3.setDaemon(bl);
        return thread2;
    }

    private static final EventListener asFactory$lambda$8(EventListener eventListener, Call call) {
        Intrinsics.checkNotNullParameter(eventListener, "$this_asFactory");
        Intrinsics.checkNotNullParameter(call, "it");
        return eventListener;
    }

    static {
        ByteString[] byteStringArray = new ByteString[]{ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000")};
        UNICODE_BOMS = Options.Companion.of(byteStringArray);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = OkHttpClient.class.desiredAssertionStatus();
        String string = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(string, "OkHttpClient::class.java.name");
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(string, (CharSequence)"okhttp3."), (CharSequence)"Client");
    }
}

