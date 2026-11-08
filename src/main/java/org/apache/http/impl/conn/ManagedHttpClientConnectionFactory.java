/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.DefaultManagedHttpClientConnection;
import org.apache.http.impl.conn.LoggingManagedHttpClientConnection;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class ManagedHttpClientConnectionFactory
implements HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> {
    private static final AtomicLong COUNTER = new AtomicLong();
    public static final ManagedHttpClientConnectionFactory INSTANCE = new ManagedHttpClientConnectionFactory();
    private final Log log = LogFactory.getLog(DefaultManagedHttpClientConnection.class);
    private final Log headerlog = LogFactory.getLog("org.apache.http.headers");
    private final Log wirelog = LogFactory.getLog("org.apache.http.wire");
    private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
    private final HttpMessageParserFactory<HttpResponse> responseParserFactory;

    public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory<HttpRequest> defaultHttpRequestWriterFactory, HttpMessageParserFactory<HttpResponse> defaultHttpResponseParserFactory) {
        this.requestWriterFactory = defaultHttpRequestWriterFactory != null ? defaultHttpRequestWriterFactory : DefaultHttpRequestWriterFactory.INSTANCE;
        this.responseParserFactory = defaultHttpResponseParserFactory != null ? defaultHttpResponseParserFactory : DefaultHttpResponseParserFactory.INSTANCE;
    }

    public ManagedHttpClientConnectionFactory(HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        this(null, httpMessageParserFactory);
    }

    public ManagedHttpClientConnectionFactory() {
        this(null, null);
    }

    @Override
    public ManagedHttpClientConnection create(HttpRoute httpRoute, ConnectionConfig connectionConfig) {
        CodingErrorAction codingErrorAction;
        ConnectionConfig connectionConfig2 = connectionConfig != null ? connectionConfig : ConnectionConfig.DEFAULT;
        CharsetDecoder charsetDecoder = null;
        CharsetEncoder charsetEncoder = null;
        Charset charset = connectionConfig2.getCharset();
        CodingErrorAction codingErrorAction2 = connectionConfig2.getMalformedInputAction() != null ? connectionConfig2.getMalformedInputAction() : CodingErrorAction.REPORT;
        CodingErrorAction codingErrorAction3 = codingErrorAction = connectionConfig2.getUnmappableInputAction() != null ? connectionConfig2.getUnmappableInputAction() : CodingErrorAction.REPORT;
        if (charset != null) {
            charsetDecoder = charset.newDecoder();
            charsetDecoder.onMalformedInput(codingErrorAction2);
            charsetDecoder.onUnmappableCharacter(codingErrorAction);
            charsetEncoder = charset.newEncoder();
            charsetEncoder.onMalformedInput(codingErrorAction2);
            charsetEncoder.onUnmappableCharacter(codingErrorAction);
        }
        String string = "http-outgoing-" + Long.toString(COUNTER.getAndIncrement());
        return new LoggingManagedHttpClientConnection(string, this.log, this.headerlog, this.wirelog, connectionConfig2.getBufferSize(), connectionConfig2.getFragmentSizeHint(), charsetDecoder, charsetEncoder, connectionConfig2.getMessageConstraints(), null, null, this.requestWriterFactory, this.responseParserFactory);
    }
}

