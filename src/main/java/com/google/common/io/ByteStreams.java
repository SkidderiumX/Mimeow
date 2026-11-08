/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.Closer;
import com.google.common.io.InputSupplier;
import com.google.common.io.OutputSupplier;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

@Beta
public class ByteStreams {
    private static final int BUF_SIZE = 4096;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream(){

        @Override
        public void write(int n) {
        }

        @Override
        public void write(byte[] byArray) {
            Preconditions.checkNotNull(byArray);
        }

        @Override
        public void write(byte[] byArray, int n, int n2) {
            Preconditions.checkNotNull(byArray);
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    };

    private ByteStreams() {
    }

    @Deprecated
    public static InputSupplier<ByteArrayInputStream> newInputStreamSupplier(byte[] byArray) {
        return ByteStreams.asInputSupplier(ByteSource.wrap(byArray));
    }

    @Deprecated
    public static InputSupplier<ByteArrayInputStream> newInputStreamSupplier(byte[] byArray, int n, int n2) {
        return ByteStreams.asInputSupplier(ByteSource.wrap(byArray).slice(n, n2));
    }

    @Deprecated
    public static void write(byte[] byArray, OutputSupplier<? extends OutputStream> outputSupplier) throws IOException {
        ByteStreams.asByteSink(outputSupplier).write(byArray);
    }

    @Deprecated
    public static long copy(InputSupplier<? extends InputStream> inputSupplier, OutputSupplier<? extends OutputStream> outputSupplier) throws IOException {
        return ByteStreams.asByteSource(inputSupplier).copyTo(ByteStreams.asByteSink(outputSupplier));
    }

    @Deprecated
    public static long copy(InputSupplier<? extends InputStream> inputSupplier, OutputStream outputStream2) throws IOException {
        return ByteStreams.asByteSource(inputSupplier).copyTo(outputStream2);
    }

    @Deprecated
    public static long copy(InputStream inputStream2, OutputSupplier<? extends OutputStream> outputSupplier) throws IOException {
        return ByteStreams.asByteSink(outputSupplier).writeFrom(inputStream2);
    }

    public static long copy(InputStream inputStream2, OutputStream outputStream2) throws IOException {
        int n;
        Preconditions.checkNotNull(inputStream2);
        Preconditions.checkNotNull(outputStream2);
        byte[] byArray = new byte[4096];
        long l = 0L;
        while ((n = inputStream2.read(byArray)) != -1) {
            outputStream2.write(byArray, 0, n);
            l += (long)n;
        }
        return l;
    }

    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        long l = 0L;
        while (readableByteChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                l += (long)writableByteChannel.write(byteBuffer);
            }
            byteBuffer.clear();
        }
        return l;
    }

    public static byte[] toByteArray(InputStream inputStream2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteStreams.copy(inputStream2, (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    static byte[] toByteArray(InputStream inputStream2, int n) throws IOException {
        int n2;
        int n3;
        byte[] byArray = new byte[n];
        for (int i = n; i > 0; i -= n3) {
            n2 = n - i;
            n3 = inputStream2.read(byArray, n2, i);
            if (n3 != -1) continue;
            return Arrays.copyOf(byArray, n2);
        }
        n2 = inputStream2.read();
        if (n2 == -1) {
            return byArray;
        }
        FastByteArrayOutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
        fastByteArrayOutputStream.write(n2);
        ByteStreams.copy(inputStream2, (OutputStream)fastByteArrayOutputStream);
        byte[] byArray2 = new byte[byArray.length + fastByteArrayOutputStream.size()];
        System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
        fastByteArrayOutputStream.writeTo(byArray2, byArray.length);
        return byArray2;
    }

    @Deprecated
    public static byte[] toByteArray(InputSupplier<? extends InputStream> inputSupplier) throws IOException {
        return ByteStreams.asByteSource(inputSupplier).read();
    }

    public static ByteArrayDataInput newDataInput(byte[] byArray) {
        return ByteStreams.newDataInput(new ByteArrayInputStream(byArray));
    }

    public static ByteArrayDataInput newDataInput(byte[] byArray, int n) {
        Preconditions.checkPositionIndex(n, byArray.length);
        return ByteStreams.newDataInput(new ByteArrayInputStream(byArray, n, byArray.length - n));
    }

    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream(Preconditions.checkNotNull(byteArrayInputStream));
    }

    public static ByteArrayDataOutput newDataOutput() {
        return ByteStreams.newDataOutput(new ByteArrayOutputStream());
    }

    public static ByteArrayDataOutput newDataOutput(int n) {
        Preconditions.checkArgument(n >= 0, "Invalid size: %s", n);
        return ByteStreams.newDataOutput(new ByteArrayOutputStream(n));
    }

    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream(Preconditions.checkNotNull(byteArrayOutputStream));
    }

    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    public static InputStream limit(InputStream inputStream2, long l) {
        return new LimitedInputStream(inputStream2, l);
    }

    @Deprecated
    public static long length(InputSupplier<? extends InputStream> inputSupplier) throws IOException {
        return ByteStreams.asByteSource(inputSupplier).size();
    }

    @Deprecated
    public static boolean equal(InputSupplier<? extends InputStream> inputSupplier, InputSupplier<? extends InputStream> inputSupplier2) throws IOException {
        return ByteStreams.asByteSource(inputSupplier).contentEquals(ByteStreams.asByteSource(inputSupplier2));
    }

    public static void readFully(InputStream inputStream2, byte[] byArray) throws IOException {
        ByteStreams.readFully(inputStream2, byArray, 0, byArray.length);
    }

    public static void readFully(InputStream inputStream2, byte[] byArray, int n, int n2) throws IOException {
        int n3 = ByteStreams.read(inputStream2, byArray, n, n2);
        if (n3 != n2) {
            throw new EOFException("reached end of stream after reading " + n3 + " bytes; " + n2 + " bytes expected");
        }
    }

    public static void skipFully(InputStream inputStream2, long l) throws IOException {
        long l2 = l;
        while (l > 0L) {
            long l3 = inputStream2.skip(l);
            if (l3 == 0L) {
                if (inputStream2.read() == -1) {
                    long l4 = l2 - l;
                    throw new EOFException("reached end of stream after skipping " + l4 + " bytes; " + l2 + " bytes expected");
                }
                --l;
                continue;
            }
            l -= l3;
        }
    }

    @Deprecated
    public static <T> T readBytes(InputSupplier<? extends InputStream> inputSupplier, ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(inputSupplier);
        Preconditions.checkNotNull(byteProcessor);
        Closer closer = Closer.create();
        try {
            InputStream inputStream2 = (InputStream)closer.register((Closeable)inputSupplier.getInput());
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

    public static <T> T readBytes(InputStream inputStream2, ByteProcessor<T> byteProcessor) throws IOException {
        int n;
        Preconditions.checkNotNull(inputStream2);
        Preconditions.checkNotNull(byteProcessor);
        byte[] byArray = new byte[4096];
        while ((n = inputStream2.read(byArray)) != -1 && byteProcessor.processBytes(byArray, 0, n)) {
        }
        return byteProcessor.getResult();
    }

    @Deprecated
    public static HashCode hash(InputSupplier<? extends InputStream> inputSupplier, HashFunction hashFunction) throws IOException {
        return ByteStreams.asByteSource(inputSupplier).hash(hashFunction);
    }

    public static int read(InputStream inputStream2, byte[] byArray, int n, int n2) throws IOException {
        int n3;
        int n4;
        Preconditions.checkNotNull(inputStream2);
        Preconditions.checkNotNull(byArray);
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        for (n3 = 0; n3 < n2 && (n4 = inputStream2.read(byArray, n + n3, n2 - n3)) != -1; n3 += n4) {
        }
        return n3;
    }

    @Deprecated
    public static InputSupplier<InputStream> slice(InputSupplier<? extends InputStream> inputSupplier, long l, long l2) {
        return ByteStreams.asInputSupplier(ByteStreams.asByteSource(inputSupplier).slice(l, l2));
    }

    @Deprecated
    public static InputSupplier<InputStream> join(Iterable<? extends InputSupplier<? extends InputStream>> iterable) {
        Preconditions.checkNotNull(iterable);
        Iterable<ByteSource> iterable2 = Iterables.transform(iterable, new Function<InputSupplier<? extends InputStream>, ByteSource>(){

            @Override
            public ByteSource apply(InputSupplier<? extends InputStream> inputSupplier) {
                return ByteStreams.asByteSource(inputSupplier);
            }
        });
        return ByteStreams.asInputSupplier(ByteSource.concat(iterable2));
    }

    @Deprecated
    public static InputSupplier<InputStream> join(InputSupplier<? extends InputStream> ... inputSupplierArray) {
        return ByteStreams.join(Arrays.asList(inputSupplierArray));
    }

    @Deprecated
    public static ByteSource asByteSource(final InputSupplier<? extends InputStream> inputSupplier) {
        Preconditions.checkNotNull(inputSupplier);
        return new ByteSource(){

            @Override
            public InputStream openStream() throws IOException {
                return (InputStream)inputSupplier.getInput();
            }

            public String toString() {
                return "ByteStreams.asByteSource(" + inputSupplier + ")";
            }
        };
    }

    @Deprecated
    public static ByteSink asByteSink(final OutputSupplier<? extends OutputStream> outputSupplier) {
        Preconditions.checkNotNull(outputSupplier);
        return new ByteSink(){

            @Override
            public OutputStream openStream() throws IOException {
                return (OutputStream)outputSupplier.getOutput();
            }

            public String toString() {
                return "ByteStreams.asByteSink(" + outputSupplier + ")";
            }
        };
    }

    static <S extends InputStream> InputSupplier<S> asInputSupplier(ByteSource byteSource) {
        return Preconditions.checkNotNull(byteSource);
    }

    static <S extends OutputStream> OutputSupplier<S> asOutputSupplier(ByteSink byteSink) {
        return Preconditions.checkNotNull(byteSink);
    }

    private static final class LimitedInputStream
    extends FilterInputStream {
        private long left;
        private long mark = -1L;

        LimitedInputStream(InputStream inputStream2, long l) {
            super(inputStream2);
            Preconditions.checkNotNull(inputStream2);
            Preconditions.checkArgument(l >= 0L, "limit must be non-negative");
            this.left = l;
        }

        @Override
        public int available() throws IOException {
            return (int)Math.min((long)this.in.available(), this.left);
        }

        @Override
        public synchronized void mark(int n) {
            this.in.mark(n);
            this.mark = this.left;
        }

        @Override
        public int read() throws IOException {
            if (this.left == 0L) {
                return -1;
            }
            int n = this.in.read();
            if (n != -1) {
                --this.left;
            }
            return n;
        }

        @Override
        public int read(byte[] byArray, int n, int n2) throws IOException {
            if (this.left == 0L) {
                return -1;
            }
            int n3 = this.in.read(byArray, n, n2 = (int)Math.min((long)n2, this.left));
            if (n3 != -1) {
                this.left -= (long)n3;
            }
            return n3;
        }

        @Override
        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1L) {
                throw new IOException("Mark not set");
            }
            this.in.reset();
            this.left = this.mark;
        }

        @Override
        public long skip(long l) throws IOException {
            l = Math.min(l, this.left);
            long l2 = this.in.skip(l);
            this.left -= l2;
            return l2;
        }
    }

    private static class ByteArrayDataOutputStream
    implements ByteArrayDataOutput {
        final DataOutput output;
        final ByteArrayOutputStream byteArrayOutputSteam;

        ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            this.byteArrayOutputSteam = byteArrayOutputStream;
            this.output = new DataOutputStream(byteArrayOutputStream);
        }

        @Override
        public void write(int n) {
            try {
                this.output.write(n);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void write(byte[] byArray) {
            try {
                this.output.write(byArray);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void write(byte[] byArray, int n, int n2) {
            try {
                this.output.write(byArray, n, n2);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeBoolean(boolean bl) {
            try {
                this.output.writeBoolean(bl);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeByte(int n) {
            try {
                this.output.writeByte(n);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeBytes(String string) {
            try {
                this.output.writeBytes(string);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeChar(int n) {
            try {
                this.output.writeChar(n);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeChars(String string) {
            try {
                this.output.writeChars(string);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeDouble(double d) {
            try {
                this.output.writeDouble(d);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeFloat(float f) {
            try {
                this.output.writeFloat(f);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeInt(int n) {
            try {
                this.output.writeInt(n);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeLong(long l) {
            try {
                this.output.writeLong(l);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeShort(int n) {
            try {
                this.output.writeShort(n);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public void writeUTF(String string) {
            try {
                this.output.writeUTF(string);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }
    }

    private static class ByteArrayDataInputStream
    implements ByteArrayDataInput {
        final DataInput input;

        ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.input = new DataInputStream(byteArrayInputStream);
        }

        @Override
        public void readFully(byte[] byArray) {
            try {
                this.input.readFully(byArray);
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public void readFully(byte[] byArray, int n, int n2) {
            try {
                this.input.readFully(byArray, n, n2);
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public int skipBytes(int n) {
            try {
                return this.input.skipBytes(n);
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public byte readByte() {
            try {
                return this.input.readByte();
            }
            catch (EOFException eOFException) {
                throw new IllegalStateException(eOFException);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }

        @Override
        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public short readShort() {
            try {
                return this.input.readShort();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public char readChar() {
            try {
                return this.input.readChar();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public int readInt() {
            try {
                return this.input.readInt();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public long readLong() {
            try {
                return this.input.readLong();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public float readFloat() {
            try {
                return this.input.readFloat();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public double readDouble() {
            try {
                return this.input.readDouble();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public String readLine() {
            try {
                return this.input.readLine();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }

        @Override
        public String readUTF() {
            try {
                return this.input.readUTF();
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }
    }

    private static final class FastByteArrayOutputStream
    extends ByteArrayOutputStream {
        private FastByteArrayOutputStream() {
        }

        void writeTo(byte[] byArray, int n) {
            System.arraycopy(this.buf, 0, byArray, n, this.count);
        }
    }
}

