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
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.BaseMetadataSectionSerializer;
import net.minecraft.util.JsonUtils;
import org.apache.commons.lang3.Validate;

public class AnimationMetadataSectionSerializer
extends BaseMetadataSectionSerializer<AnimationMetadataSection>
implements JsonSerializer<AnimationMetadataSection> {
    @Override
    public AnimationMetadataSection deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        int n;
        ArrayList<AnimationFrame> arrayList = Lists.newArrayList();
        JsonObject jsonObject = JsonUtils.getJsonObject(jsonElement, "metadata section");
        int n2 = JsonUtils.getInt(jsonObject, "frametime", 1);
        if (n2 != 1) {
            Validate.inclusiveBetween(1L, Integer.MAX_VALUE, n2, "Invalid default frame time");
        }
        if (jsonObject.has("frames")) {
            try {
                JsonArray jsonArray = JsonUtils.getJsonArray(jsonObject, "frames");
                for (n = 0; n < jsonArray.size(); ++n) {
                    JsonElement jsonElement2 = jsonArray.get(n);
                    AnimationFrame animationFrame = this.parseAnimationFrame(n, jsonElement2);
                    if (animationFrame == null) continue;
                    arrayList.add(animationFrame);
                }
            }
            catch (ClassCastException classCastException) {
                throw new JsonParseException("Invalid animation->frames: expected array, was " + String.valueOf(jsonObject.get("frames")), classCastException);
            }
        }
        int n3 = JsonUtils.getInt(jsonObject, "width", -1);
        n = JsonUtils.getInt(jsonObject, "height", -1);
        if (n3 != -1) {
            Validate.inclusiveBetween(1L, Integer.MAX_VALUE, n3, "Invalid width");
        }
        if (n != -1) {
            Validate.inclusiveBetween(1L, Integer.MAX_VALUE, n, "Invalid height");
        }
        boolean bl = JsonUtils.getBoolean(jsonObject, "interpolate", false);
        return new AnimationMetadataSection(arrayList, n3, n, n2, bl);
    }

    private AnimationFrame parseAnimationFrame(int n, JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive()) {
            return new AnimationFrame(JsonUtils.getInt(jsonElement, "frames[" + n + "]"));
        }
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = JsonUtils.getJsonObject(jsonElement, "frames[" + n + "]");
            int n2 = JsonUtils.getInt(jsonObject, "time", -1);
            if (jsonObject.has("time")) {
                Validate.inclusiveBetween(1L, Integer.MAX_VALUE, n2, "Invalid frame time");
            }
            int n3 = JsonUtils.getInt(jsonObject, "index");
            Validate.inclusiveBetween(0L, Integer.MAX_VALUE, n3, "Invalid frame index");
            return new AnimationFrame(n3, n2);
        }
        return null;
    }

    @Override
    public JsonElement serialize(AnimationMetadataSection animationMetadataSection, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("frametime", animationMetadataSection.getFrameTime());
        if (animationMetadataSection.getFrameWidth() != -1) {
            jsonObject.addProperty("width", animationMetadataSection.getFrameWidth());
        }
        if (animationMetadataSection.getFrameHeight() != -1) {
            jsonObject.addProperty("height", animationMetadataSection.getFrameHeight());
        }
        if (animationMetadataSection.getFrameCount() > 0) {
            JsonArray jsonArray = new JsonArray();
            for (int i = 0; i < animationMetadataSection.getFrameCount(); ++i) {
                if (animationMetadataSection.frameHasTime(i)) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("index", animationMetadataSection.getFrameIndex(i));
                    jsonObject2.addProperty("time", animationMetadataSection.getFrameTimeSingle(i));
                    jsonArray.add(jsonObject2);
                    continue;
                }
                jsonArray.add(new JsonPrimitive(animationMetadataSection.getFrameIndex(i)));
            }
            jsonObject.add("frames", jsonArray);
        }
        return jsonObject;
    }

    @Override
    public String getSectionName() {
        return "animation";
    }
}

