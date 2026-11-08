/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

@GwtCompatible(emulated=true)
public class GwtWorkarounds {
    private GwtWorkarounds() {
    }

    @GwtIncompatible(value="Reader")
    static CharInput asCharInput(final Reader reader) {
        Preconditions.checkNotNull(reader);
        return new CharInput(){

            @Override
            public int read() throws IOException {
                return reader.read();
            }

            @Override
            public void close() throws IOException {
                reader.close();
            }
        };
    }

    static CharInput asCharInput(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new CharInput(){
            int index = 0;

            @Override
            public int read() {
                if (this.index < charSequence.length()) {
                    return charSequence.charAt(this.index++);
                }
                return -1;
            }

            @Override
            public void close() {
                this.index = charSequence.length();
            }
        };
    }

    @GwtIncompatible(value="InputStream")
    static InputStream asInputStream(final ByteInput byteInput) {
        Preconditions.checkNotNull(byteInput);
        return new InputStream(){

            @Override
            public int read() throws IOException {
                return byteInput.read();
            }

            @Override
            public int read(byte[] byArray, int n, int n2) throws IOException {
                Preconditions.checkNotNull(byArray);
                Preconditions.checkPositionIndexes(n, n + n2, byArray.length);
                if (n2 == 0) {
                    return 0;
                }
                int n3 = this.read();
                if (n3 == -1) {
                    return -1;
                }
                byArray[n] = (byte)n3;
                for (int i = 1; i < n2; ++i) {
                    int n4 = this.read();
                    if (n4 == -1) {
                        return i;
                    }
                    byArray[n + i] = (byte)n4;
                }
                return n2;
            }

            @Override
            public void close() throws IOException {
                byteInput.close();
            }
        };
    }

    @GwtIncompatible(value="OutputStream")
    static OutputStream asOutputStream(final ByteOutput byteOutput) {
        Preconditions.checkNotNull(byteOutput);
        return new OutputStream(){

            @Override
            public void write(int n) throws IOException {
                byteOutput.write((byte)n);
            }

            @Override
            public void flush() throws IOException {
                byteOutput.flush();
            }

            @Override
            public void close() throws IOException {
                byteOutput.close();
            }
        };
    }

    @GwtIncompatible(value="Writer")
    static CharOutput asCharOutput(final Writer writer) {
        Preconditions.checkNotNull(writer);
        return new CharOutput(){

            @Override
            public void write(char c) throws IOException {
                writer.append(c);
            }

            @Override
            public void flush() throws IOException {
                writer.flush();
            }

            @Override
            public void close() throws IOException {
                writer.close();
            }
        };
    }

    static CharOutput stringBuilderOutput(int n) {
        final StringBuilder stringBuilder = new StringBuilder(n);
        return new CharOutput(){

            @Override
            public void write(char c) {
                stringBuilder.append(c);
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() {
            }

            public String toString() {
                return stringBuilder.toString();
            }
        };
    }

    public static interface CharOutput {
        public void write(char var1) throws IOException;

        public void flush() throws IOException;

        public void close() throws IOException;
    }

    public static interface ByteOutput {
        public void write(byte var1) throws IOException;

        public void flush() throws IOException;

        public void close() throws IOException;
    }

    public static interface ByteInput {
        public int read() throws IOException;

        public void close() throws IOException;
    }

    public static interface CharInput {
        public int read() throws IOException;

        public void close() throws IOException;
    }
}

