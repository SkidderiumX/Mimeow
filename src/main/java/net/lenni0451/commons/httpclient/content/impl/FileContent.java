/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.content.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import javax.annotation.Nonnull;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.model.ContentType;

public class FileContent
extends HttpContent {
    private final File file;

    public FileContent(File file) {
        this(ContentTypes.APPLICATION_OCTET_STREAM, file);
    }

    public FileContent(ContentType contentType, File file) {
        super(contentType);
        this.file = file;
    }

    @Override
    public boolean canBeStreamedMultipleTimes() {
        return true;
    }

    @Override
    public int getLength() {
        return (int)this.file.length();
    }

    @Override
    @Nonnull
    protected InputStream compute() throws IOException {
        return Files.newInputStream(this.file.toPath(), new OpenOption[0]);
    }
}

