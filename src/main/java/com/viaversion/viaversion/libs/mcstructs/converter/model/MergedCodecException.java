/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.model;

import com.viaversion.viaversion.libs.mcstructs.converter.model.CodecException;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Collection;

public class MergedCodecException
extends CodecException {
    private final String error;
    private final Collection<Result<?>> errors;

    public MergedCodecException(String string, Collection<Result<?>> collection) {
        this.error = string;
        this.errors = collection;
        for (Result<?> result : collection) {
            if (!result.isError()) continue;
            this.addSuppressed(result.getError());
        }
    }

    @Override
    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder(128);
        for (Result<?> result : this.errors) {
            if (!result.isError()) continue;
            if (stringBuilder.length() > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append('[').append(result.getError().getMessage()).append(']');
        }
        return this.error + ": " + stringBuilder;
    }
}

