/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import net.minecraft.client.resources.data.BaseMetadataSectionSerializer;
import net.minecraft.client.resources.data.FontMetadataSection;
import net.minecraft.util.JsonUtils;
import org.apache.commons.lang3.Validate;

public class FontMetadataSectionSerializer
extends BaseMetadataSectionSerializer<FontMetadataSection> {
    @Override
    public FontMetadataSection deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        float[] fArray = new float[256];
        float[] fArray2 = new float[256];
        float[] fArray3 = new float[256];
        float f = 1.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (jsonObject.has("characters")) {
            if (!jsonObject.get("characters").isJsonObject()) {
                throw new JsonParseException("Invalid font->characters: expected object, was " + String.valueOf(jsonObject.get("characters")));
            }
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("characters");
            if (jsonObject2.has("default")) {
                if (!jsonObject2.get("default").isJsonObject()) {
                    throw new JsonParseException("Invalid font->characters->default: expected object, was " + String.valueOf(jsonObject2.get("default")));
                }
                JsonObject jsonObject3 = jsonObject2.getAsJsonObject("default");
                f = JsonUtils.getFloat(jsonObject3, "width", f);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, f, "Invalid default width");
                f2 = JsonUtils.getFloat(jsonObject3, "spacing", f2);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, f2, "Invalid default spacing");
                f3 = JsonUtils.getFloat(jsonObject3, "left", f2);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, f3, "Invalid default left");
            }
            for (int i = 0; i < 256; ++i) {
                JsonElement jsonElement2 = jsonObject2.get(Integer.toString(i));
                float f4 = f;
                float f5 = f2;
                float f6 = f3;
                if (jsonElement2 != null) {
                    JsonObject jsonObject4 = JsonUtils.getJsonObject(jsonElement2, "characters[" + i + "]");
                    f4 = JsonUtils.getFloat(jsonObject4, "width", f);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, f4, "Invalid width");
                    f5 = JsonUtils.getFloat(jsonObject4, "spacing", f2);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, f5, "Invalid spacing");
                    f6 = JsonUtils.getFloat(jsonObject4, "left", f3);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, f6, "Invalid left");
                }
                fArray[i] = f4;
                fArray2[i] = f5;
                fArray3[i] = f6;
            }
        }
        return new FontMetadataSection(fArray, fArray3, fArray2);
    }

    @Override
    public String getSectionName() {
        return "font";
    }
}

