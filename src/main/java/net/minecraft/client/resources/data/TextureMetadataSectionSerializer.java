/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources.data;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import net.minecraft.client.resources.data.BaseMetadataSectionSerializer;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.util.JsonUtils;

public class TextureMetadataSectionSerializer
extends BaseMetadataSectionSerializer<TextureMetadataSection> {
    @Override
    public TextureMetadataSection deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        boolean bl = JsonUtils.getBoolean(jsonObject, "blur", false);
        boolean bl2 = JsonUtils.getBoolean(jsonObject, "clamp", false);
        ArrayList<Integer> arrayList = Lists.newArrayList();
        if (jsonObject.has("mipmaps")) {
            try {
                JsonArray jsonArray = jsonObject.getAsJsonArray("mipmaps");
                for (int i = 0; i < jsonArray.size(); ++i) {
                    JsonElement jsonElement2 = jsonArray.get(i);
                    if (jsonElement2.isJsonPrimitive()) {
                        try {
                            arrayList.add(jsonElement2.getAsInt());
                            continue;
                        }
                        catch (NumberFormatException numberFormatException) {
                            throw new JsonParseException("Invalid texture->mipmap->" + i + ": expected number, was " + String.valueOf(jsonElement2), numberFormatException);
                        }
                    }
                    if (!jsonElement2.isJsonObject()) continue;
                    throw new JsonParseException("Invalid texture->mipmap->" + i + ": expected number, was " + String.valueOf(jsonElement2));
                }
            }
            catch (ClassCastException classCastException) {
                throw new JsonParseException("Invalid texture->mipmaps: expected array, was " + String.valueOf(jsonObject.get("mipmaps")), classCastException);
            }
        }
        return new TextureMetadataSection(bl, bl2, arrayList);
    }

    @Override
    public String getSectionName() {
        return "texture";
    }
}

