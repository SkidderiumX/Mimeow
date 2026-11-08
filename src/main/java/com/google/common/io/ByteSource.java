/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import com.google.common.io.InputSupplier;
import com.google.common.io.MultiInputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

public abstract class ByteSource
implements InputSupplier<InputStream> {
    private static final int BUF_SIZE = 4096;
    private static final byte[] countBuffer = new byte[4096];

    protected ByteSource() {
    }

    public CharSource asCharSource(Charset charset) {
        return new AsCharSource(charset);
    }

    public abstract InputStream openStream() throws IOException;

    @Override
    @Deprecated
    public final InputStream getInput() throws IOException {
        return this.openStream();
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream inputStream2 = this.openStream();
        return inputStream2 instanceof BufferedInputStream ? (BufferedInputStream)inputStream2 : new BufferedInputStream(inputStream2);
    }

    public ByteSource slice(long l, long l2) {
        return new SlicedByteSource(l, l2);
    }

    public boolean isEmpty() throws IOException {
        Closer closer = Closer.create();
        try {
            InputStream inputStream2 = closer.register(this.openStream());
            boolean bl = inputStream2.read() == -1;
            return bl;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long size() throws IOException {
        Closer closer = Closer.create();
        try {
            InputStream inputStream2 = closer.register(this.openStream());
            long l = this.countBySkipping(inputStream2);
            return l;
        }
        catch (IOException iOException) {
        }
        finally {
            closer.close();
        }
        closer = Closer.create();
        try {
            InputStream inputStream3 = closer.register(this.openStream());
            long l = this.countByReading(inputStream3);
            return l;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    private long countBySkipping(InputStream inputStream2) throws IOException {
        long l = 0L;
        while (true) {
            long l2;
            if ((l2 = inputStream2.skip(Math.min(inputStream2.available(), Integer.MAX_VALUE))) <= 0L) {
                if (inputStream2.read() == -1) {
                    return l;
                }
                if (l == 0L && inputStream2.available() == 0) {
                    throw new IOException();
                }
                ++l;
                continue;
            }
            l += l2;
        }
    }

    private long countByReading(InputStream inputStream2) throws IOException {
        long l;
        long l2 = 0L;
        while ((l = (long)inputStream2.read(countBuffer)) != -1L) {
            l2 += l;
        }
        return l2;
    }

    public long copyTo(OutputStream outputStream2) throws IOException {
        Preconditions.checkNotNull(outputStream2);
        Closer closer = Closer.create();
        try {
            InputStream inputStream2 = closer.register(this.openStream());
            long l = ByteStreams.copy(inputStream2, outputStream2);
            return l;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public long copyTo(ByteSink byteSink) throws IOException {
        Preconditions.checkNotNull(byteSink);
        Closer closer = Closer.create();
        try {
            InputStream inputStream2 = closer.register(this.openStream());
            OutputStream outputStream2 = closer.register(byteSink.openStream());
            long l = ByteStreams.copy(inputStream2, outputStream2);
            return l;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public byte[] read() throws IOException {
        Closer closer = Closer.create();
        try {
            InputStream inputStream2 = closer.register(this.openStream());
            byte[] byArray = ByteStreams.toByteArray(inputStream2);
            return byArray;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    @Beta
    public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(byteProcessor);
        Closer closer = Closer.create();
        try {
            InputStream inputStream2 = closer.register(this.openStream());
            T t = ByteStreams.readBytes(inputStream2, byteProcessor);
            return t;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public HashCode hash(HashFunction hashFunction) throws IOException {
        Hasher hasher = hashFunction.newHasher();
        this.copyTo(Funnels.asOutputStream(hasher));
        return hasher.hash();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean contentEquals(ByteSource byteSource) throws IOException {
        Preconditions.checkNotNull(byteSource);
        byte[] byArray = new byte[4096];
        byte[] byArray2 = new byte[4096];
        Closer closer = Closer.create();
        try {
            InputStream inputStream2 = closer.register(this.openStream());
            InputStream inputStream3 = closer.register(byteSource.openStream());
            while (true) {
                int n;
                int n2;
                if ((n2 = ByteStreams.read(inputStream2, byArray, 0, 4096)) != (n = ByteStreams.read(inputStream3, byArray2, 0, 4096)) || !Arrays.equals(byArray, byArray2)) {
                    boolean bl = false;
                    return bl;
                }
                if (n2 != 4096) {
                    boolean bl = true;
                    return bl;
                }
                continue;
                break;
            }
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public static ByteSource concat(Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> iterator2) {
        return ByteSource.concat(ImmutableList.copyOf(iterator2));
    }

    public static ByteSource concat(ByteSource ... byteSourceArray) {
        return ByteSource.concat(ImmutableList.copyOf(byteSourceArray));
    }

    public static ByteSource wrap(byte[] byArray) {
        return new ByteArrayByteSource(byArray);
    }

    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }

    private static final class ConcatenatedByteSource
    extends ByteSource {
        private final Iterable<? extends ByteSource> sources;

        ConcatenatedByteSource(Iterable<? extends ByteSource> iterable) {
            this.sources = Preconditions.checkNotNull(iterable);
        }

        @Override
        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }

        @Override
        public boolean isEmpty() throws IOException {
            for (ByteSource byteSource : this.sources) {
                if (byteSource.isEmpty()) continue;
                return false;
            }
            return true;
        }

        @Override
        public long size() throws IOException {
            long l = 0L;
            for (ByteSource byteSource : this.sources) {
                l += byteSource.size();
            }
            return l;
        }

        public String toString() {
            return "ByteSource.concat(" + this.sources + ")";
        }
    }

    private static final class EmptyByteSource
    extends ByteArrayByteSource {
        private static final EmptyByteSource INSTANCE = new EmptyByteSource();

        private EmptyByteSource() {
            super(new byte[0]);
        }

        @Override
        public CharSource asCharSource(Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }

        @Override
        public byte[] read() {
            return this.bytes;
        }

        @Override
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    private static class ByteArrayByteSource
    extends ByteSource {
        protected final byte[] bytes;

        protected ByteArrayByteSource(byte[] byArray) {
            this.bytes = Preconditions.checkNotNull(byArray);
        }

        @Override
        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes);
        }

        @Override
        public InputStream openBufferedStream() throws IOException {
            return this.openStream();
        }

        @Override
        public boolean isEmpty() {
            return this.bytes.length == 0;
        }

        @Override
        public long size() {
            return this.bytes.length;
        }

        @Override
        public byte[] read() {
            return (byte[])this.bytes.clone();
        }

        @Override
        public long copyTo(OutputStream outputStream2) throws IOException {
            outputStream2.write(this.bytes);
            return this.bytes.length;
        }

        @Override
        public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.processBytes(this.bytes, 0, this.bytes.length);
            return byteProcessor.getResult();
        }

        @Override
        public HashCode hash(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.bytes);
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.bytes), 30, "...") + ")";
        }
    }

    private final class SlicedByteSource
    extends ByteSource {
        private final long offset;
        private final long length;

        private SlicedByteSource(long l, long l2) {
            Preconditions.checkArgument(l >= 0L, "offset (%s) may not be negative", l);
            Preconditions.checkArgument(l2 >= 0L, "length (%s) may not be negative", l2);
            this.offset = l;
            this.length = l2;
        }

        @Override
        public InputStream openStream() throws IOException {
            return this.sliceStream(ByteSource.this.openStream());
        }

        @Override
        public InputStream openBufferedStream() throws IOException {
            return this.sliceStream(ByteSource.this.openBufferedStream());
        }

        private InputStream sliceStream(InputStream inputStream2) throws IOException {
            if (this.offset > 0L) {
                try {
                    ByteStreams.skipFully(inputStream2, this.offset);
                }
                catch (Throwable throwable) {
                    Closer closer = Closer.create();
                    closer.register(inputStream2);
                    try {
                        throw closer.rethrow(throwable);
                    }
                    catch (Throwable throwable2) {
                        closer.close();
                        throw throwable2;
                    }
                }
            }
            return ByteStreams.limit(inputStream2, this.length);
        }

        @Override
        public ByteSource slice(long l, long l2) {
            Preconditions.checkArgument(l >= 0L, "offset (%s) may not be negative", l);
            Preconditions.checkArgument(l2 >= 0L, "length (%s) may not be negative", l2);
            long l3 = this.length - l;
            return ByteSource.this.slice(this.offset + l, Math.min(l2, l3));
        }

        @Override
        public boolean isEmpty() throws IOException {
            return this.length == 0L || super.isEmpty();
        }

        public String toString() {
            return ByteSource.this.toString() + ".slice(" + this.offset + ", " + this.length + ")";
        }
    }

    private final class AsCharSource
    extends CharSource {
        private final Charset charset;

        private AsCharSource(Charset charset) {
            this.charset = Preconditions.checkNotNull(charset);
        }

        @Override
        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.charset);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.charset + ")";
        }
    }
}

