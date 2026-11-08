/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.data;

import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.MappingData1_13;
import com.viaversion.viaversion.util.GsonUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecipeData {
    public static Map<String, Recipe> recipes;

    public static void init() {
        Object object;
        JsonObject jsonObject;
        JsonObject jsonObject2;
        InputStream inputStream2 = MappingData1_13.class.getClassLoader().getResourceAsStream("assets/viaversion/data/itemrecipes1_12_2to1_13.json");
        try (Iterator<Map.Entry<String, JsonElement>> iterator2 = new InputStreamReader(inputStream2);){
            jsonObject2 = GsonUtil.getGson().fromJson((Reader)((Object)iterator2), JsonObject.class);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        recipes = new LinkedHashMap<String, Recipe>();
        for (Map.Entry<String, JsonElement> entry : jsonObject2.getAsJsonObject("shapeless").entrySet()) {
            jsonObject = ((JsonElement)entry.getValue()).getAsJsonObject();
            object = RecipeData.ingredients(jsonObject.getAsJsonArray("ingredients"));
            recipes.put("viaversion:legacy/" + entry.getKey(), new Recipe("crafting_shapeless", RecipeData.group(jsonObject), 0, 0, 0.0f, 0, null, (DataItem[][])object, RecipeData.result(jsonObject)));
        }
        for (Map.Entry<String, JsonElement> entry : jsonObject2.getAsJsonObject("shaped").entrySet()) {
            jsonObject = entry.getValue().getAsJsonObject();
            object = jsonObject.getAsJsonArray("grid");
            int n = ((JsonArray)object).size();
            int n2 = ((JsonArray)object).get(0).getAsJsonArray().size();
            DataItem[][] dataItemArray = new DataItem[n2 * n][];
            int n3 = 0;
            Iterator<JsonElement> iterator3 = ((JsonArray)object).iterator();
            while (iterator3.hasNext()) {
                JsonElement jsonElement = iterator3.next();
                for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                    dataItemArray[n3++] = RecipeData.ingredient(jsonElement2);
                }
            }
            recipes.put("viaversion:legacy/" + entry.getKey(), new Recipe("crafting_shaped", RecipeData.group(jsonObject), n2, n, 0.0f, 0, null, dataItemArray, RecipeData.result(jsonObject)));
        }
        for (Map.Entry<String, JsonElement> entry : jsonObject2.getAsJsonObject("smelting").entrySet()) {
            jsonObject = entry.getValue().getAsJsonObject();
            float f = jsonObject.get("experience").getAsFloat();
            recipes.put(entry.getKey(), new Recipe("smelting", RecipeData.group(jsonObject), 0, 0, f, 200, RecipeData.ingredient(jsonObject.get("ingredient")), null, RecipeData.result(jsonObject)));
        }
        for (Map.Entry<String, JsonElement> entry : jsonObject2.getAsJsonObject("special").entrySet()) {
            recipes.put(entry.getKey(), new Recipe("crafting_special_" + entry.getValue().getAsString(), "", 0, 0, 0.0f, 0, null, null, null));
        }
    }

    private static String group(JsonObject jsonObject) {
        JsonElement jsonElement = jsonObject.get("group");
        return jsonElement != null ? jsonElement.getAsString() : "";
    }

    private static DataItem result(JsonObject jsonObject) {
        JsonElement jsonElement = jsonObject.get("count");
        return new DataItem(jsonObject.get("result").getAsInt(), jsonElement != null ? jsonElement.getAsByte() : (byte)1, null);
    }

    private static DataItem[] ingredient(JsonElement jsonElement) {
        if (jsonElement.isJsonNull()) {
            return new DataItem[0];
        }
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            DataItem[] dataItemArray = new DataItem[jsonArray.size()];
            for (int i = 0; i < dataItemArray.length; ++i) {
                dataItemArray[i] = new DataItem(jsonArray.get(i).getAsInt(), 1, null);
            }
            return dataItemArray;
        }
        return new DataItem[]{new DataItem(jsonElement.getAsInt(), 1, null)};
    }

    private static DataItem[][] ingredients(JsonArray jsonArray) {
        DataItem[][] dataItemArray = new DataItem[jsonArray.size()][];
        for (int i = 0; i < dataItemArray.length; ++i) {
            dataItemArray[i] = RecipeData.ingredient(jsonArray.get(i));
        }
        return dataItemArray;
    }

    public record Recipe(String type, String group, int width, int height, float experience, int cookingTime, DataItem[] ingredient, DataItem[][] ingredients, DataItem result) {
    }
}

