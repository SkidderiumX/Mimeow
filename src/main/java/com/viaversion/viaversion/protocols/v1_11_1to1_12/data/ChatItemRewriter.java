/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_11_1to1_12.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;

public class ChatItemRewriter {
    public static void toClient(JsonElement jsonElement) {
        block7: {
            block5: {
                JsonObject jsonObject;
                block8: {
                    block6: {
                        if (!(jsonElement instanceof JsonObject)) break block5;
                        jsonObject = (JsonObject)jsonElement;
                        if (!jsonObject.has("hoverEvent")) break block6;
                        Object object = jsonObject.get("hoverEvent");
                        if (!(object instanceof JsonObject)) {
                            return;
                        }
                        JsonObject jsonObject2 = (JsonObject)object;
                        if (!jsonObject2.has("action") || !jsonObject2.has("value")) {
                            return;
                        }
                        object = jsonObject2.get("action").getAsString();
                        JsonElement jsonElement2 = jsonObject2.get("value");
                        if (((String)object).equals("show_item")) {
                            CompoundTag compoundTag = ComponentUtil.deserializeLegacyShowItem(jsonElement2, SerializerVersion.V1_8);
                            jsonObject2.addProperty("value", SerializerVersion.V1_12.toSNBT(compoundTag));
                        }
                        break block7;
                    }
                    if (!jsonObject.has("extra")) break block8;
                    ChatItemRewriter.toClient(jsonObject.get("extra"));
                    break block7;
                }
                if (!jsonObject.has("translate") || !jsonObject.has("with")) break block7;
                ChatItemRewriter.toClient(jsonObject.get("with"));
                break block7;
            }
            if (jsonElement instanceof JsonArray) {
                JsonArray jsonArray = (JsonArray)jsonElement;
                for (JsonElement jsonElement3 : jsonArray) {
                    ChatItemRewriter.toClient(jsonElement3);
                }
            }
        }
    }
}

