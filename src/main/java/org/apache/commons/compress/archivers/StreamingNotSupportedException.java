/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.archivers;

import org.apache.commons.compress.archivers.ArchiveException;

public class StreamingNotSupportedException
extends ArchiveException {
    private static final long serialVersionUID = 1L;
    private final String format;

    public StreamingNotSupportedException(String string) {
        super("The " + string + " doesn't support streaming.");
        this.format = string;
    }

    public String getFormat() {
        return this.format;
    }
}

