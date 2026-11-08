/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.io.AppendableWriter;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import com.google.common.io.InputSupplier;
import com.google.common.io.LineProcessor;
import com.google.common.io.LineReader;
import com.google.common.io.OutputSupplier;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Beta
public class CharStreams {
    private static final int BUF_SIZE = 2048;

    private CharStreams() {
    }

    @Deprecated
    public static InputSupplier<StringReader> newReaderSupplier(String string) {
        return CharStreams.asInputSupplier(CharSource.wrap(string));
    }

    @Deprecated
    public static InputSupplier<InputStreamReader> newReaderSupplier(InputSupplier<? extends InputStream> inputSupplier, Charset charset) {
        return CharStreams.asInputSupplier(ByteStreams.asByteSource(inputSupplier).asCharSource(charset));
    }

    @Deprecated
    public static OutputSupplier<OutputStreamWriter> newWriterSupplier(OutputSupplier<? extends OutputStream> outputSupplier, Charset charset) {
        return CharStreams.asOutputSupplier(ByteStreams.asByteSink(outputSupplier).asCharSink(charset));
    }

    @Deprecated
    public static <W extends Appendable & Closeable> void write(CharSequence charSequence, OutputSupplier<W> outputSupplier) throws IOException {
        CharStreams.asCharSink(outputSupplier).write(charSequence);
    }

    @Deprecated
    public static <R extends Readable & Closeable, W extends Appendable & Closeable> long copy(InputSupplier<R> inputSupplier, OutputSupplier<W> outputSupplier) throws IOException {
        return CharStreams.asCharSource(inputSupplier).copyTo(CharStreams.asCharSink(outputSupplier));
    }

    @Deprecated
    public static <R extends Readable & Closeable> long copy(InputSupplier<R> inputSupplier, Appendable appendable) throws IOException {
        return CharStreams.asCharSource(inputSupplier).copyTo(appendable);
    }

    public static long copy(Readable readable, Appendable appendable) throws IOException {
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        CharBuffer charBuffer = CharBuffer.allocate(2048);
        long l = 0L;
        while (readable.read(charBuffer) != -1) {
            charBuffer.flip();
            appendable.append(charBuffer);
            l += (long)charBuffer.remaining();
            charBuffer.clear();
        }
        return l;
    }

    public static String toString(Readable readable) throws IOException {
        return CharStreams.toStringBuilder(readable).toString();
    }

    @Deprecated
    public static <R extends Readable & Closeable> String toString(InputSupplier<R> inputSupplier) throws IOException {
        return CharStreams.asCharSource(inputSupplier).read();
    }

    private static StringBuilder toStringBuilder(Readable readable) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        CharStreams.copy(readable, (Appendable)stringBuilder);
        return stringBuilder;
    }

    @Deprecated
    public static <R extends Readable & Closeable> String readFirstLine(InputSupplier<R> inputSupplier) throws IOException {
        return CharStreams.asCharSource(inputSupplier).readFirstLine();
    }

    @Deprecated
    public static <R extends Readable & Closeable> List<String> readLines(InputSupplier<R> inputSupplier) throws IOException {
        Closer closer = Closer.create();
        try {
            Readable readable = (Readable)((Object)closer.register((Closeable)inputSupplier.getInput()));
            List<String> list = CharStreams.readLines(readable);
            return list;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public static List<String> readLines(Readable readable) throws IOException {
        String string;
        ArrayList<String> arrayList = new ArrayList<String>();
        LineReader lineReader = new LineReader(readable);
        while ((string = lineReader.readLine()) != null) {
            arrayList.add(string);
        }
        return arrayList;
    }

    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String string;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        while ((string = lineReader.readLine()) != null && lineProcessor.processLine(string)) {
        }
        return lineProcessor.getResult();
    }

    @Deprecated
    public static <R extends Readable & Closeable, T> T readLines(InputSupplier<R> inputSupplier, LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(inputSupplier);
        Preconditions.checkNotNull(lineProcessor);
        Closer closer = Closer.create();
        try {
            Readable readable = (Readable)((Object)closer.register((Closeable)inputSupplier.getInput()));
            T t = CharStreams.readLines(readable, lineProcessor);
            return t;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    @Deprecated
    public static InputSupplier<Reader> join(Iterable<? extends InputSupplier<? extends Reader>> iterable) {
        Preconditions.checkNotNull(iterable);
        Iterable<CharSource> iterable2 = Iterables.transform(iterable, new Function<InputSupplier<? extends Reader>, CharSource>(){

            @Override
            public CharSource apply(InputSupplier<? extends Reader> inputSupplier) {
                return CharStreams.asCharSource(inputSupplier);
            }
        });
        return CharStreams.asInputSupplier(CharSource.concat(iterable2));
    }

    @Deprecated
    public static InputSupplier<Reader> join(InputSupplier<? extends Reader> ... inputSupplierArray) {
        return CharStreams.join(Arrays.asList(inputSupplierArray));
    }

    public static void skipFully(Reader reader, long l) throws IOException {
        Preconditions.checkNotNull(reader);
        while (l > 0L) {
            long l2 = reader.skip(l);
            if (l2 == 0L) {
                if (reader.read() == -1) {
                    throw new EOFException();
                }
                --l;
                continue;
            }
            l -= l2;
        }
    }

    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    public static Writer asWriter(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer)appendable;
        }
        return new AppendableWriter(appendable);
    }

    static Reader asReader(final Readable readable) {
        Preconditions.checkNotNull(readable);
        if (readable instanceof Reader) {
            return (Reader)readable;
        }
        return new Reader(){

            @Override
            public int read(char[] cArray, int n, int n2) throws IOException {
                return this.read(CharBuffer.wrap(cArray, n, n2));
            }

            @Override
            public int read(CharBuffer charBuffer) throws IOException {
                return readable.read(charBuffer);
            }

            @Override
            public void close() throws IOException {
                if (readable instanceof Closeable) {
                    ((Closeable)((Object)readable)).close();
                }
            }
        };
    }

    @Deprecated
    public static CharSource asCharSource(final InputSupplier<? extends Readable> inputSupplier) {
        Preconditions.checkNotNull(inputSupplier);
        return new CharSource(){

            @Override
            public Reader openStream() throws IOException {
                return CharStreams.asReader((Readable)inputSupplier.getInput());
            }

            public String toString() {
                return "CharStreams.asCharSource(" + inputSupplier + ")";
            }
        };
    }

    @Deprecated
    public static CharSink asCharSink(final OutputSupplier<? extends Appendable> outputSupplier) {
        Preconditions.checkNotNull(outputSupplier);
        return new CharSink(){

            @Override
            public Writer openStream() throws IOException {
                return CharStreams.asWriter((Appendable)outputSupplier.getOutput());
            }

            public String toString() {
                return "CharStreams.asCharSink(" + outputSupplier + ")";
            }
        };
    }

    static <R extends Reader> InputSupplier<R> asInputSupplier(CharSource charSource) {
        return Preconditions.checkNotNull(charSource);
    }

    static <W extends Writer> OutputSupplier<W> asOutputSupplier(CharSink charSink) {
        return Preconditions.checkNotNull(charSink);
    }

    private static final class NullWriter
    extends Writer {
        private static final NullWriter INSTANCE = new NullWriter();

        private NullWriter() {
        }

        @Override
        public void write(int n) {
        }

        @Override
        public void write(char[] cArray) {
            Preconditions.checkNotNull(cArray);
        }

        @Override
        public void write(char[] cArray, int n, int n2) {
            Preconditions.checkPositionIndexes(n, n + n2, cArray.length);
        }

        @Override
        public void write(String string) {
            Preconditions.checkNotNull(string);
        }

        @Override
        public void write(String string, int n, int n2) {
            Preconditions.checkPositionIndexes(n, n + n2, string.length());
        }

        @Override
        public Writer append(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return this;
        }

        @Override
        public Writer append(CharSequence charSequence, int n, int n2) {
            Preconditions.checkPositionIndexes(n, n2, charSequence.length());
            return this;
        }

        @Override
        public Writer append(char c) {
            return this;
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }
    }
}

