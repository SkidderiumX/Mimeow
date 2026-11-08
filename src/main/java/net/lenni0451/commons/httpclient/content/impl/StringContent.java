/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.content.impl;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import net.lenni0451.commons.httpclient.content.impl.ByteArrayContent;
import net.lenni0451.commons.httpclient.model.ContentType;

public class StringContent
extends ByteArrayContent {
    public StringContent(String string) {
        this(string, StandardCharsets.UTF_8);
    }

    public StringContent(String string, Charset charset) {
        super(string.getBytes(charset));
    }

    public StringContent(ContentType contentType, String string) {
        this(contentType, string, StandardCharsets.UTF_8);
    }

    public StringContent(ContentType contentType, String string, Charset charset) {
        super(contentType, string.getBytes(charset));
    }
}

