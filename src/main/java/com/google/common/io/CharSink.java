/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.CharStreams;
import com.google.common.io.Closer;
import com.google.common.io.OutputSupplier;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class CharSink
implements OutputSupplier<Writer> {
    protected CharSink() {
    }

    public abstract Writer openStream() throws IOException;

    @Override
    @Deprecated
    public final Writer getOutput() throws IOException {
        return this.openStream();
    }

    public Writer openBufferedStream() throws IOException {
        Writer writer = this.openStream();
        return writer instanceof BufferedWriter ? (BufferedWriter)writer : new BufferedWriter(writer);
    }

    public void write(CharSequence charSequence) throws IOException {
        Preconditions.checkNotNull(charSequence);
        Closer closer = Closer.create();
        try {
            Writer writer = closer.register(this.openStream());
            writer.append(charSequence);
            writer.flush();
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public void writeLines(Iterable<? extends CharSequence> iterable) throws IOException {
        this.writeLines(iterable, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> iterable, String string) throws IOException {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(string);
        Closer closer = Closer.create();
        try {
            Writer writer = closer.register(this.openBufferedStream());
            for (CharSequence charSequence : iterable) {
                writer.append(charSequence).append(string);
            }
            writer.flush();
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public long writeFrom(Readable readable) throws IOException {
        Preconditions.checkNotNull(readable);
        Closer closer = Closer.create();
        try {
            Writer writer = closer.register(this.openStream());
            long l = CharStreams.copy(readable, (Appendable)writer);
            writer.flush();
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
}

