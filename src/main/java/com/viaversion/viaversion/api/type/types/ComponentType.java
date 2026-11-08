/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.StringType;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import io.netty.buffer.ByteBuf;

public class ComponentType
extends Type<JsonElement> {
    private static final StringType STRING_TAG = new StringType(262144);

    public ComponentType() {
        super(JsonElement.class);
    }

    @Override
    public JsonElement read(ByteBuf byteBuf) {
        String string = STRING_TAG.read(byteBuf);
        try {
            return JsonParser.parseString(string);
        }
        catch (JsonSyntaxException jsonSyntaxException) {
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().severe("Error when trying to parse json: " + string);
            }
            throw jsonSyntaxException;
        }
    }

    @Override
    public void write(ByteBuf byteBuf, JsonElement jsonElement) {
        STRING_TAG.write(byteBuf, jsonElement.toString());
    }

    public static final class OptionalComponentType
    extends OptionalType<JsonElement> {
        public OptionalComponentType() {
            super(Types.COMPONENT);
        }
    }
}

