/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.logging.Log;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.conn.DefaultManagedHttpClientConnection;
import org.apache.http.impl.conn.LoggingInputStream;
import org.apache.http.impl.conn.LoggingOutputStream;
import org.apache.http.impl.conn.Wire;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class LoggingManagedHttpClientConnection
extends DefaultManagedHttpClientConnection {
    private final Log log;
    private final Log headerlog;
    private final Wire wire;

    public LoggingManagedHttpClientConnection(String string, Log log, Log log2, Log log3, int n, int n2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(string, n, n2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.log = log;
        this.headerlog = log2;
        this.wire = new Wire(log3, string);
    }

    @Override
    public void close() throws IOException {
        if (this.log.isDebugEnabled()) {
            this.log.debug(this.getId() + ": Close connection");
        }
        super.close();
    }

    @Override
    public void shutdown() throws IOException {
        if (this.log.isDebugEnabled()) {
            this.log.debug(this.getId() + ": Shutdown connection");
        }
        super.shutdown();
    }

    @Override
    protected InputStream getSocketInputStream(Socket socket) throws IOException {
        InputStream inputStream2 = super.getSocketInputStream(socket);
        if (this.wire.enabled()) {
            inputStream2 = new LoggingInputStream(inputStream2, this.wire);
        }
        return inputStream2;
    }

    @Override
    protected OutputStream getSocketOutputStream(Socket socket) throws IOException {
        OutputStream outputStream2 = super.getSocketOutputStream(socket);
        if (this.wire.enabled()) {
            outputStream2 = new LoggingOutputStream(outputStream2, this.wire);
        }
        return outputStream2;
    }

    @Override
    protected void onResponseReceived(HttpResponse httpResponse) {
        if (httpResponse != null && this.headerlog.isDebugEnabled()) {
            Header[] headerArray;
            this.headerlog.debug(this.getId() + " << " + httpResponse.getStatusLine().toString());
            for (Header header : headerArray = httpResponse.getAllHeaders()) {
                this.headerlog.debug(this.getId() + " << " + header.toString());
            }
        }
    }

    @Override
    protected void onRequestSubmitted(HttpRequest httpRequest) {
        if (httpRequest != null && this.headerlog.isDebugEnabled()) {
            Header[] headerArray;
            this.headerlog.debug(this.getId() + " >> " + httpRequest.getRequestLine().toString());
            for (Header header : headerArray = httpRequest.getAllHeaders()) {
                this.headerlog.debug(this.getId() + " >> " + header.toString());
            }
        }
    }
}

