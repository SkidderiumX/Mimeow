/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.model;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;

public class DecoratableMessage {
    private final String plain;
    private final JsonElement decorated;

    public DecoratableMessage(String string) {
        this(string, DecoratableMessage.createLiteralText(string));
    }

    public DecoratableMessage(String string, JsonElement jsonElement) {
        this.plain = string;
        this.decorated = jsonElement;
    }

    public String plain() {
        return this.plain;
    }

    public JsonElement decorated() {
        return this.decorated;
    }

    public boolean isDecorated() {
        return !this.decorated.equals(DecoratableMessage.createLiteralText(this.plain));
    }

    private static JsonElement createLiteralText(String string) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", string);
        return jsonObject;
    }
}

