/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.content.impl;

import java.io.InputStream;
import javax.annotation.Nonnull;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.model.ContentType;

public class InputStreamContent
extends HttpContent {
    private final InputStream inputStream;
    private final int contentLength;

    public InputStreamContent(ContentType contentType, InputStream inputStream2, int n) {
        super(contentType);
        this.inputStream = inputStream2;
        this.contentLength = n;
    }

    @Override
    public boolean canBeStreamedMultipleTimes() {
        return false;
    }

    @Override
    public int getLength() {
        return this.contentLength;
    }

    @Override
    @Nonnull
    protected InputStream compute() {
        return this.inputStream;
    }
}

