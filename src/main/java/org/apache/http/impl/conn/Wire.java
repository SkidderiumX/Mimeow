/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class Wire {
    private final Log log;
    private final String id;

    public Wire(Log log, String string) {
        this.log = log;
        this.id = string;
    }

    public Wire(Log log) {
        this(log, "");
    }

    private void wire(String string, InputStream inputStream2) throws IOException {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        while ((n = inputStream2.read()) != -1) {
            if (n == 13) {
                stringBuilder.append("[\\r]");
                continue;
            }
            if (n == 10) {
                stringBuilder.append("[\\n]\"");
                stringBuilder.insert(0, "\"");
                stringBuilder.insert(0, string);
                this.log.debug(this.id + " " + stringBuilder.toString());
                stringBuilder.setLength(0);
                continue;
            }
            if (n < 32 || n > 127) {
                stringBuilder.append("[0x");
                stringBuilder.append(Integer.toHexString(n));
                stringBuilder.append("]");
                continue;
            }
            stringBuilder.append((char)n);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append('\"');
            stringBuilder.insert(0, '\"');
            stringBuilder.insert(0, string);
            this.log.debug(this.id + " " + stringBuilder.toString());
        }
    }

    public boolean enabled() {
        return this.log.isDebugEnabled();
    }

    public void output(InputStream inputStream2) throws IOException {
        Args.notNull(inputStream2, "Output");
        this.wire(">> ", inputStream2);
    }

    public void input(InputStream inputStream2) throws IOException {
        Args.notNull(inputStream2, "Input");
        this.wire("<< ", inputStream2);
    }

    public void output(byte[] byArray, int n, int n2) throws IOException {
        Args.notNull(byArray, "Output");
        this.wire(">> ", new ByteArrayInputStream(byArray, n, n2));
    }

    public void input(byte[] byArray, int n, int n2) throws IOException {
        Args.notNull(byArray, "Input");
        this.wire("<< ", new ByteArrayInputStream(byArray, n, n2));
    }

    public void output(byte[] byArray) throws IOException {
        Args.notNull(byArray, "Output");
        this.wire(">> ", new ByteArrayInputStream(byArray));
    }

    public void input(byte[] byArray) throws IOException {
        Args.notNull(byArray, "Input");
        this.wire("<< ", new ByteArrayInputStream(byArray));
    }

    public void output(int n) throws IOException {
        this.output(new byte[]{(byte)n});
    }

    public void input(int n) throws IOException {
        this.input(new byte[]{(byte)n});
    }

    public void output(String string) throws IOException {
        Args.notNull(string, "Output");
        this.output(string.getBytes());
    }

    public void input(String string) throws IOException {
        Args.notNull(string, "Input");
        this.input(string.getBytes());
    }
}

