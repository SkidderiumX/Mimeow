/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.content.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.annotation.Nonnull;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.model.ContentType;

public class ByteArrayContent
extends HttpContent {
    private final byte[] content;
    private final int start;
    private final int length;

    public ByteArrayContent(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public ByteArrayContent(byte[] byArray, int n, int n2) {
        super(ContentTypes.APPLICATION_OCTET_STREAM);
        this.content = byArray;
        this.start = n;
        this.length = n2;
    }

    public ByteArrayContent(ContentType contentType, byte[] byArray) {
        this(contentType, byArray, 0, byArray.length);
    }

    public ByteArrayContent(ContentType contentType, byte[] byArray, int n, int n2) {
        super(contentType);
        this.content = byArray;
        this.start = n;
        this.length = n2;
    }

    @Override
    public boolean canBeStreamedMultipleTimes() {
        return true;
    }

    @Override
    public int getLength() {
        return this.content.length;
    }

    @Override
    @Nonnull
    protected InputStream compute() {
        return new ByteArrayInputStream(this.content, this.start, this.length);
    }
}

