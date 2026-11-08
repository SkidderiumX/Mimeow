/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.JsonElementTypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        boolean bl = true;
        try {
            JsonToken jsonToken = jsonReader.peek();
            bl = false;
            return JsonElementTypeAdapter.ADAPTER.read(jsonReader);
        }
        catch (EOFException eOFException) {
            if (bl) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException(eOFException);
        }
        catch (MalformedJsonException malformedJsonException) {
            throw new JsonSyntaxException(malformedJsonException);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        catch (NumberFormatException numberFormatException) {
            throw new JsonSyntaxException(numberFormatException);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        JsonElementTypeAdapter.ADAPTER.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer)appendable : new AppendableWriter(appendable);
    }

    private static final class AppendableWriter
    extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        AppendableWriter(Appendable appendable) {
            this.appendable = appendable;
        }

        @Override
        public void write(char[] cArray, int n, int n2) throws IOException {
            this.currentWrite.setChars(cArray);
            this.appendable.append(this.currentWrite, n, n + n2);
        }

        @Override
        public void flush() throws IOException {
            if (this.appendable instanceof Flushable) {
                ((Flushable)((Object)this.appendable)).flush();
            }
        }

        @Override
        public void close() throws IOException {
            if (this.appendable instanceof Closeable) {
                ((Closeable)((Object)this.appendable)).close();
            }
        }

        @Override
        public void write(int n) throws IOException {
            this.appendable.append((char)n);
        }

        @Override
        public void write(String string, int n, int n2) throws IOException {
            Objects.requireNonNull(string);
            this.appendable.append(string, n, n + n2);
        }

        @Override
        public Writer append(CharSequence charSequence) throws IOException {
            this.appendable.append(charSequence);
            return this;
        }

        @Override
        public Writer append(CharSequence charSequence, int n, int n2) throws IOException {
            this.appendable.append(charSequence, n, n2);
            return this;
        }

        private static class CurrentWrite
        implements CharSequence {
            private char[] chars;
            private String cachedString;

            private CurrentWrite() {
            }

            void setChars(char[] cArray) {
                this.chars = cArray;
                this.cachedString = null;
            }

            @Override
            public int length() {
                return this.chars.length;
            }

            @Override
            public char charAt(int n) {
                return this.chars[n];
            }

            @Override
            public CharSequence subSequence(int n, int n2) {
                return new String(this.chars, n, n2 - n);
            }

            @Override
            public String toString() {
                if (this.cachedString == null) {
                    this.cachedString = new String(this.chars);
                }
                return this.cachedString;
            }
        }
    }
}

