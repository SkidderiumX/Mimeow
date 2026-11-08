/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import javax.annotation.Nullable;
import net.lenni0451.commons.httpclient.HeaderStore;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.constants.StatusCodes;
import net.lenni0451.commons.httpclient.content.DelegatingHttpContent;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.content.impl.ByteArrayContent;
import net.lenni0451.commons.httpclient.content.impl.InputStreamContent;
import net.lenni0451.commons.httpclient.model.ContentType;
import org.jetbrains.annotations.ApiStatus;

public class HttpResponse
extends HeaderStore<HttpResponse> {
    private static final Map<String, InputStreamMapper> DEFAULT_DECODERS = new HashMap<String, InputStreamMapper>();
    private final URL url;
    private final int statusCode;
    private final HttpContent content;

    @Nullable
    private static InputStreamMapper getExistingDecoder(String ... stringArray) {
        for (String string : stringArray) {
            try {
                Class<InputStream> clazz = Class.forName(string).asSubclass(InputStream.class);
                Constructor<InputStream> constructor = clazz.getDeclaredConstructor(InputStream.class);
                return inputStream2 -> {
                    try {
                        return (InputStream)constructor.newInstance(inputStream2);
                    }
                    catch (Throwable throwable) {
                        throw new IOException("Failed to create decoder input stream of type " + string, throwable);
                    }
                };
            }
            catch (Throwable throwable) {
            }
        }
        return null;
    }

    public HttpResponse(URL uRL, int n, byte[] byArray, Map<String, List<String>> map) {
        super(map);
        this.url = uRL;
        this.statusCode = n;
        this.content = new ByteArrayContent(this.getFirstHeader("Content-Type").map(ContentType::parse).orElse(ContentTypes.APPLICATION_OCTET_STREAM), byArray);
    }

    public HttpResponse(URL uRL, int n, InputStream inputStream2, Map<String, List<String>> map) {
        super(map);
        this.url = uRL;
        this.statusCode = n;
        this.content = new InputStreamContent(this.getFirstHeader("Content-Type").map(ContentType::parse).orElse(ContentTypes.APPLICATION_OCTET_STREAM), inputStream2, this.getFirstHeader("Content-Length").map(string -> {
            try {
                return Integer.valueOf(string);
            }
            catch (NumberFormatException numberFormatException) {
                return -1;
            }
        }).orElse(-1));
    }

    public HttpResponse(URL uRL, int n, HttpContent httpContent, Map<String, List<String>> map) {
        super(map);
        this.url = uRL;
        this.statusCode = n;
        this.content = httpContent;
    }

    public URL getURL() {
        return this.url;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return StatusCodes.STATUS_CODES.getOrDefault(this.statusCode, "Unknown");
    }

    public HttpContent getContent() {
        return this.content;
    }

    public HttpContent getDecodedContent() {
        return this.getDecodedContent(string -> DEFAULT_DECODERS.get(string.toLowerCase(Locale.ROOT)));
    }

    public HttpContent getDecodedContent(DecoderProvider decoderProvider) {
        String string = this.getFirstHeader("Content-Encoding").orElse(null);
        if (string == null) {
            return this.content;
        }
        String[] stringArray = string.split(",\\s*");
        final ArrayList<InputStreamMapper> arrayList = new ArrayList<InputStreamMapper>(stringArray.length);
        for (String string2 : stringArray) {
            InputStreamMapper inputStreamMapper = decoderProvider.get(string2);
            if (inputStreamMapper == null) {
                return this.content;
            }
            arrayList.add(inputStreamMapper);
        }
        this.removeHeader("Content-Encoding");
        this.setHeader("Original-Content-Encoding", string);
        return new DelegatingHttpContent(this.content){

            @Override
            protected InputStream modify(InputStream inputStream2) throws IOException {
                inputStream2 = super.modify(inputStream2);
                for (int i = arrayList.size() - 1; i >= 0; --i) {
                    inputStream2 = ((InputStreamMapper)arrayList.get(i)).map(inputStream2);
                }
                return inputStream2;
            }
        };
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public InputStream getInputStream() {
        return this.content.getAsStream();
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public String getContentAsString() {
        return this.content.getAsString();
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public String getContentAsString(Charset charset) {
        return this.content.getAsString(charset);
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public Optional<ContentType> getContentType() {
        return this.getFirstHeader("Content-Type").map(ContentType::parse);
    }

    static {
        DEFAULT_DECODERS.put("identity", inputStream2 -> inputStream2);
        DEFAULT_DECODERS.put("gzip", GZIPInputStream::new);
        DEFAULT_DECODERS.put("x-gzip", GZIPInputStream::new);
        DEFAULT_DECODERS.put("deflate", InflaterInputStream::new);
        DEFAULT_DECODERS.put("br", HttpResponse.getExistingDecoder("com.aayushatharva.brotli4j.decoder.BrotliInputStream", "org.brotli.dec.BrotliInputStream"));
        DEFAULT_DECODERS.put("zstd", HttpResponse.getExistingDecoder("io.airlift.compress.zstd.ZstdInputStream", "io.airlift.compress.v3.zstd.ZstdInputStream", "com.github.luben.zstd.ZstdInputStream"));
    }

    @FunctionalInterface
    public static interface DecoderProvider {
        @Nullable
        public InputStreamMapper get(String var1);
    }

    @FunctionalInterface
    public static interface InputStreamMapper {
        public InputStream map(InputStream var1) throws IOException;
    }
}

