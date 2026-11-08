/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.Closer;
import com.google.common.io.OutputSupplier;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class ByteSink
implements OutputSupplier<OutputStream> {
    protected ByteSink() {
    }

    public CharSink asCharSink(Charset charset) {
        return new AsCharSink(charset);
    }

    public abstract OutputStream openStream() throws IOException;

    @Override
    @Deprecated
    public final OutputStream getOutput() throws IOException {
        return this.openStream();
    }

    public OutputStream openBufferedStream() throws IOException {
        OutputStream outputStream2 = this.openStream();
        return outputStream2 instanceof BufferedOutputStream ? (BufferedOutputStream)outputStream2 : new BufferedOutputStream(outputStream2);
    }

    public void write(byte[] byArray) throws IOException {
        Preconditions.checkNotNull(byArray);
        Closer closer = Closer.create();
        try {
            OutputStream outputStream2 = closer.register(this.openStream());
            outputStream2.write(byArray);
            outputStream2.flush();
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public long writeFrom(InputStream inputStream2) throws IOException {
        Preconditions.checkNotNull(inputStream2);
        Closer closer = Closer.create();
        try {
            OutputStream outputStream2 = closer.register(this.openStream());
            long l = ByteStreams.copy(inputStream2, outputStream2);
            outputStream2.flush();
            long l2 = l;
            return l2;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    private final class AsCharSink
    extends CharSink {
        private final Charset charset;

        private AsCharSink(Charset charset) {
            this.charset = Preconditions.checkNotNull(charset);
        }

        @Override
        public Writer openStream() throws IOException {
            return new OutputStreamWriter(ByteSink.this.openStream(), this.charset);
        }

        public String toString() {
            return ByteSink.this.toString() + ".asCharSink(" + this.charset + ")";
        }
    }
}

