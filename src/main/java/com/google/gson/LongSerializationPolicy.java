/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;

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

