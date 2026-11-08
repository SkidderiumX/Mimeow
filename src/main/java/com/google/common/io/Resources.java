/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.InputSupplier;
import com.google.common.io.LineProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Beta
public class Resources {
    private Resources() {
    }

    @Deprecated
    public static InputSupplier<InputStream> newInputStreamSupplier(URL uRL) {
        return ByteStreams.asInputSupplier(Resources.asByteSource(uRL));
    }

    public static ByteSource asByteSource(URL uRL) {
        return new UrlByteSource(uRL);
    }

    @Deprecated
    public static InputSupplier<InputStreamReader> newReaderSupplier(URL uRL, Charset charset) {
        return CharStreams.asInputSupplier(Resources.asCharSource(uRL, charset));
    }

    public static CharSource asCharSource(URL uRL, Charset charset) {
        return Resources.asByteSource(uRL).asCharSource(charset);
    }

    public static byte[] toByteArray(URL uRL) throws IOException {
        return Resources.asByteSource(uRL).read();
    }

    public static String toString(URL uRL, Charset charset) throws IOException {
        return Resources.asCharSource(uRL, charset).read();
    }

    public static <T> T readLines(URL uRL, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return CharStreams.readLines(Resources.newReaderSupplier(uRL, charset), lineProcessor);
    }

    public static List<String> readLines(URL uRL, Charset charset) throws IOException {
        return Resources.readLines(uRL, charset, new LineProcessor<List<String>>(){
            final List<String> result = Lists.newArrayList();

            @Override
            public boolean processLine(String string) {
                this.result.add(string);
                return true;
            }

            @Override
            public List<String> getResult() {
                return this.result;
            }
        });
    }

    public static void copy(URL uRL, OutputStream outputStream2) throws IOException {
        Resources.asByteSource(uRL).copyTo(outputStream2);
    }

    public static URL getResource(String string) {
        ClassLoader classLoader = Objects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader());
        URL uRL = classLoader.getResource(string);
        Preconditions.checkArgument(uRL != null, "resource %s not found.", string);
        return uRL;
    }

    public static URL getResource(Class<?> clazz, String string) {
        URL uRL = clazz.getResource(string);
        Preconditions.checkArgument(uRL != null, "resource %s relative to %s not found.", string, clazz.getName());
        return uRL;
    }

    private static final class UrlByteSource
    extends ByteSource {
        private final URL url;

        private UrlByteSource(URL uRL) {
            this.url = Preconditions.checkNotNull(uRL);
        }

        @Override
        public InputStream openStream() throws IOException {
            return this.url.openStream();
        }

        public String toString() {
            return "Resources.asByteSource(" + this.url + ")";
        }
    }
}

