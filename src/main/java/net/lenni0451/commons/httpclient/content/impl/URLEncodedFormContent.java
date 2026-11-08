/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.content.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import lombok.Generated;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.utils.URLCoder;

public class URLEncodedFormContent
extends HttpContent {
    private final List<FormEntry> entries;
    private final Charset charset;

    public URLEncodedFormContent() {
        this(StandardCharsets.UTF_8);
    }

    public URLEncodedFormContent(Map<String, String> map) {
        this(map, StandardCharsets.UTF_8);
    }

    public URLEncodedFormContent(Charset charset) {
        super(ContentTypes.APPLICATION_FORM_URLENCODED);
        this.entries = new ArrayList<FormEntry>();
        this.charset = charset;
    }

    public URLEncodedFormContent(Map<String, String> map, Charset charset) {
        super(ContentTypes.APPLICATION_FORM_URLENCODED);
        this.entries = map.entrySet().stream().map(entry -> new FormEntry((String)entry.getKey(), (String)entry.getValue(), charset)).collect(Collectors.toList());
        this.charset = charset;
    }

    public URLEncodedFormContent put(String string, String string2) {
        this.entries.add(new FormEntry(string, string2, this.charset));
        this.clearCache();
        return this;
    }

    @Override
    public boolean canBeStreamedMultipleTimes() {
        return true;
    }

    @Override
    public int getLength() {
        int n = this.entries.size() - 1;
        for (FormEntry formEntry : this.entries) {
            n += formEntry.getLength();
        }
        return n;
    }

    @Override
    @Nonnull
    protected InputStream compute() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.getLength());
        for (int i = 0; i < this.entries.size(); ++i) {
            FormEntry formEntry = this.entries.get(i);
            byteArrayOutputStream.write(formEntry.getKey());
            byteArrayOutputStream.write(61);
            byteArrayOutputStream.write(formEntry.getValue());
            if (i >= this.entries.size() - 1) continue;
            byteArrayOutputStream.write(38);
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    private static class FormEntry {
        private final byte[] key;
        private final byte[] value;

        private FormEntry(String string, String string2, Charset charset) {
            this.key = URLCoder.encode(string).getBytes(charset);
            this.value = URLCoder.encode(string2).getBytes(charset);
        }

        public int getLength() {
            return this.key.length + 1 + this.value.length;
        }

        @Generated
        public byte[] getKey() {
            return this.key;
        }

        @Generated
        public byte[] getValue() {
            return this.value;
        }
    }
}

