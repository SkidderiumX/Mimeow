/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonNull;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.gson.TypeAdapter;
import com.viaversion.viaversion.libs.gson.internal.bind.TypeAdapters;

public enum LongSerializationPolicy {
    DEFAULT{

        @Override
        public JsonElement serialize(Long l) {
            if (l == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l);
        }

        @Override
        TypeAdapter<Number> typeAdapter() {
            return TypeAdapters.LONG;
        }
    }
    ,
    STRING{

        @Override
        public JsonElement serialize(Long l) {
            if (l == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l.toString());
        }

        @Override
        TypeAdapter<Number> typeAdapter() {
            return TypeAdapters.LONG_AS_STRING;
        }
    };


    public abstract JsonElement serialize(Long var1);

    abstract TypeAdapter<Number> typeAdapter();
}

