/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.JsonParseException;

public class JsonSyntaxException
extends JsonParseException {
    private static final long serialVersionUID = 1L;

    public JsonSyntaxException(String string) {
        super(string);
    }

    public JsonSyntaxException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public JsonSyntaxException(Throwable throwable) {
        super(throwable);
    }
}

