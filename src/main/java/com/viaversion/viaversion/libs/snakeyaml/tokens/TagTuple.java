/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.tokens;

public class TagTuple {
    private final String handle;
    private final String suffix;

    public TagTuple(String string, String string2) {
        if (string2 == null) {
            throw new NullPointerException("Suffix must be provided.");
        }
        this.handle = string;
        this.suffix = string2;
    }

    public String getHandle() {
        return this.handle;
    }

    public String getSuffix() {
        return this.suffix;
    }
}

