/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.content;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.WillNotClose;
import net.lenni0451.commons.httpclient.content.impl.ByteArrayContent;
import net.lenni0451.commons.httpclient.content.impl.FileContent;
import net.lenni0451.commons.httpclient.content.impl.InputStreamContent;
import net.lenni0451.commons.httpclient.content.impl.MultiPartFormContent;
import net.lenni0451.commons.httpclient.content.impl.StringContent;
import net.lenni0451.commons.httpclient.content.impl.URLEncodedFormContent;
import net.lenni0451.commons.httpclient.model.ContentType;
import org.jetbrains.annotations.ApiStatus;

public abstract class HttpContent {
    private final ContentType contentType;
    private int bufferSize = 1024;
    private boolean computed = false;
    private byte[] byteCache;

    public static HttpContent bytes(byte[] byArray) {
        return new ByteArrayContent(byArray);
    }

    public static HttpContent bytes(byte[] byArray, int n, int n2) {
        return new ByteArrayContent(byArray, n, n2);
    }

    public static HttpContent string(String string) {
        return new StringContent(string);
    }

    public static HttpContent string(String string, Charset charset) {
        return new StringContent(string, charset);
    }

    public static HttpContent file(File file) {
        return new FileContent(file);
    }

    public static HttpContent form(String string, String string2) {
        return new URLEncodedFormContent().put(string, string2);
    }

    public static HttpContent form(Map<String, String> map) {
        return new URLEncodedFormContent(map);
    }

    public static MultiPartFormContent multiPartForm() {
        return new MultiPartFormContent();
    }

    public static InputStreamContent inputStream(ContentType contentType, InputStream inputStream2, int n) {
        return new InputStreamContent(contentType, inputStream2, n);
    }

    public HttpContent(ContentType contentType) {
        this.contentType = contentType;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public final ContentType getContentType() {
        return this.getType();
    }

    public final ContentType getType() {
        return this.contentType;
    }

    public final int getBufferSize() {
        return this.bufferSize;
    }

    public final HttpContent setBufferSize(int n) {
        this.bufferSize = n;
        return this;
    }

    public final void transferTo(@WillNotClose OutputStream outputStream2) throws IOException {
        try (InputStream inputStream2 = this.getAsStream();){
            int n;
            byte[] byArray = new byte[this.bufferSize];
            while ((n = inputStream2.read(byArray)) >= 0) {
                outputStream2.write(byArray, 0, n);
            }
        }
    }

    public final InputStream getAsStream() throws IOException {
        if (this.byteCache != null) {
            return new ByteArrayInputStream(this.byteCache);
        }
        if (!this.computed || this.canBeStreamedMultipleTimes()) {
            this.computed = true;
            return this.modify(this.compute());
        }
        throw new IOException("This content cannot be streamed multiple times");
    }

    @Nonnull
    public final byte[] getAsBytes() throws IOException {
        if (this.byteCache == null) {
            int n = this.getLength() > 0 ? this.getLength() : this.bufferSize;
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n);){
                this.transferTo(byteArrayOutputStream);
                this.byteCache = byteArrayOutputStream.toByteArray();
            }
        }
        return this.byteCache;
    }

    @Nonnull
    public final String getAsString() throws IOException {
        return this.getAsString(StandardCharsets.UTF_8);
    }

    @Nonnull
    public final String getAsString(Charset charset) throws IOException {
        return new String(this.getAsBytes(), charset);
    }

    protected final void clearCache() {
        this.byteCache = null;
        this.computed = false;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public final int getContentLength() {
        return this.getLength();
    }

    public abstract boolean canBeStreamedMultipleTimes();

    public abstract int getLength();

    @Nonnull
    protected abstract InputStream compute() throws IOException;

    protected InputStream modify(InputStream inputStream2) throws IOException {
        return inputStream2;
    }
}

