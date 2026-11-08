/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.Consts;
import org.apache.http.annotation.Immutable;
import org.apache.http.impl.conn.Wire;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
@Immutable
public class LoggingSessionOutputBuffer
implements SessionOutputBuffer {
    private final SessionOutputBuffer out;
    private final Wire wire;
    private final String charset;

    public LoggingSessionOutputBuffer(SessionOutputBuffer sessionOutputBuffer, Wire wire, String string) {
        this.out = sessionOutputBuffer;
        this.wire = wire;
        this.charset = string != null ? string : Consts.ASCII.name();
    }

    public LoggingSessionOutputBuffer(SessionOutputBuffer sessionOutputBuffer, Wire wire) {
        this(sessionOutputBuffer, wire, null);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.out.write(byArray, n, n2);
        if (this.wire.enabled()) {
            this.wire.output(byArray, n, n2);
        }
    }

    public void write(int n) throws IOException {
        this.out.write(n);
        if (this.wire.enabled()) {
            this.wire.output(n);
        }
    }

    public void write(byte[] byArray) throws IOException {
        this.out.write(byArray);
        if (this.wire.enabled()) {
            this.wire.output(byArray);
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        this.out.writeLine(charArrayBuffer);
        if (this.wire.enabled()) {
            String string = new String(charArrayBuffer.buffer(), 0, charArrayBuffer.length());
            String string2 = string + "\r\n";
            this.wire.output(string2.getBytes(this.charset));
        }
    }

    public void writeLine(String string) throws IOException {
        this.out.writeLine(string);
        if (this.wire.enabled()) {
            String string2 = string + "\r\n";
            this.wire.output(string2.getBytes(this.charset));
        }
    }

    public HttpTransportMetrics getMetrics() {
        return this.out.getMetrics();
    }
}

