/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.model;

import lombok.Generated;

public class CodecException
extends RuntimeException {
    @Override
    public void printStackTrace() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Generated
    public CodecException() {
        this(null, null);
    }

    @Generated
    public CodecException(String string) {
        this(string, null);
    }

    @Generated
    public CodecException(Throwable throwable) {
        this(throwable != null ? throwable.getMessage() : null, throwable);
    }

    @Generated
    public CodecException(String string, Throwable throwable) {
        super(string);
        if (throwable != null) {
            super.initCause(throwable);
        }
    }
}

