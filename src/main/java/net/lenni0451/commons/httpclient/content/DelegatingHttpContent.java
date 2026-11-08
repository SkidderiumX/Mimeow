/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.content;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;
import net.lenni0451.commons.httpclient.content.HttpContent;

public class DelegatingHttpContent
extends HttpContent {
    private final HttpContent content;

    public DelegatingHttpContent(HttpContent httpContent) {
        super(httpContent.getType());
        this.content = httpContent;
    }

    @Override
    public boolean canBeStreamedMultipleTimes() {
        return this.content.canBeStreamedMultipleTimes();
    }

    @Override
    public int getLength() {
        return this.content.getLength();
    }

    @Override
    @Nonnull
    protected InputStream compute() throws IOException {
        return this.content.compute();
    }

    @Override
    protected InputStream modify(InputStream inputStream2) throws IOException {
        return this.content.modify(inputStream2);
    }
}

