/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.gson.elements;

import com.google.gson.JsonPrimitive;
import net.lenni0451.commons.gson.elements.GsonElement;

public class GsonPrimitive
extends GsonElement {
    private final JsonPrimitive primitive;

    public GsonPrimitive(String string) {
        this(new JsonPrimitive(string));
    }

    public GsonPrimitive(boolean bl) {
        this(new JsonPrimitive(bl));
    }

    public GsonPrimitive(Number number) {
        this(new JsonPrimitive(number));
    }

    public GsonPrimitive(JsonPrimitive jsonPrimitive) {
        super(jsonPrimitive);
        this.primitive = jsonPrimitive;
    }

    public JsonPrimitive getJsonPrimitive() {
        return this.primitive;
    }

    public boolean isBoolean() {
        return this.primitive.isBoolean();
    }

    public boolean isNumber() {
        return this.primitive.isNumber();
    }

    public boolean isString() {
        return this.primitive.isString();
    }
}

