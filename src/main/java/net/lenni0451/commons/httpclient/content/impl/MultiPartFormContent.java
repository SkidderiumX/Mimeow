/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.content.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.lenni0451.commons.httpclient.HeaderStore;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.model.ContentType;
import net.lenni0451.commons.httpclient.utils.stream.MultiInputStream;

public class MultiPartFormContent
extends HttpContent {
    private final String boundary;
    private final List<FormPart> parts = new ArrayList<FormPart>();
    private boolean unknownLength = false;

    public MultiPartFormContent() {
        this("---" + UUID.randomUUID() + "---");
    }

    public MultiPartFormContent(String string) {
        super(new ContentType("multipart/form-data; boundary=" + string));
        this.boundary = string;
    }

    public MultiPartFormContent addPart(String string, HttpContent httpContent) {
        if (httpContent.getLength() < 0) {
            this.unknownLength = true;
        }
        return this.addPart(new FormPart(string, httpContent));
    }

    public MultiPartFormContent addPart(String string, HttpContent httpContent, @Nullable String string2) {
        if (httpContent.getLength() < 0) {
            this.unknownLength = true;
        }
        return this.addPart(new FormPart(string, httpContent, string2));
    }

    public MultiPartFormContent addPart(FormPart formPart) {
        if (formPart.getContent().getLength() < 0) {
            this.unknownLength = true;
        }
        this.parts.add(formPart);
        return this;
    }

    @Override
    public boolean canBeStreamedMultipleTimes() {
        return false;
    }

    @Override
    public int getLength() {
        if (this.unknownLength) {
            return -1;
        }
        int n = ("--" + this.boundary + "\r\n").getBytes().length;
        int[] nArray = new int[]{0};
        for (FormPart formPart : this.parts) {
            nArray[0] = nArray[0] + n;
            formPart.forEachHeader(string -> {
                nArray[0] = nArray[0] + string.getBytes().length;
            });
            nArray[0] = nArray[0] + 2;
            nArray[0] = nArray[0] + formPart.getContent().getLength();
            nArray[0] = nArray[0] + 2;
        }
        return nArray[0] + n;
    }

    @Override
    @Nonnull
    protected InputStream compute() throws IOException {
        ArrayDeque<InputStream> arrayDeque = new ArrayDeque<InputStream>(this.parts.size() * 4 + 1);
        byte[] byArray = "\r\n".getBytes();
        byte[] byArray2 = ("--" + this.boundary + "\r\n").getBytes();
        byte[] byArray3 = ("--" + this.boundary + "--").getBytes();
        for (FormPart formPart : this.parts) {
            arrayDeque.add(new ByteArrayInputStream(byArray2));
            formPart.forEachHeader(string -> arrayDeque.add(new ByteArrayInputStream(string.getBytes())));
            arrayDeque.add(new ByteArrayInputStream(byArray));
            arrayDeque.add(formPart.getContent().getAsStream());
            arrayDeque.add(new ByteArrayInputStream(byArray));
        }
        arrayDeque.add(new ByteArrayInputStream(byArray3));
        return new MultiInputStream(arrayDeque);
    }

    public static class FormPart
    extends HeaderStore<FormPart> {
        private final HttpContent content;

        public FormPart(String string, HttpContent httpContent) {
            this(string, httpContent, null);
        }

        public FormPart(String string, HttpContent httpContent, @Nullable String string2) {
            this.content = httpContent;
            this.setHeader("Content-Disposition", "form-data; name=\"" + string + "\"" + (string2 == null ? "" : "; filename=\"" + string2 + "\""));
            this.setHeader("Content-Type", httpContent.getType().toString());
        }

        public HttpContent getContent() {
            return this.content;
        }

        private void forEachHeader(Consumer<String> consumer) {
            this.forEachHeader((String string, String string2) -> consumer.accept(string + ": " + string2 + "\r\n"));
        }
    }
}

