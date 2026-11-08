/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.block.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.client.resources.model.ModelRotation;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;

public class ModelBlockDefinition {
    static final Gson GSON = new GsonBuilder().registerTypeAdapter((Type)((Object)ModelBlockDefinition.class), new Deserializer()).registerTypeAdapter((Type)((Object)Variant.class), new Variant.Deserializer()).create();
    private final Map<String, Variants> mapVariants = Maps.newHashMap();

    public static ModelBlockDefinition parseFromReader(Reader reader) {
        return GSON.fromJson(reader, ModelBlockDefinition.class);
    }

    public ModelBlockDefinition(Collection<Variants> collection) {
        for (Variants variants : collection) {
            this.mapVariants.put(variants.name, variants);
        }
    }

    public ModelBlockDefinition(List<ModelBlockDefinition> list) {
        for (ModelBlockDefinition modelBlockDefinition : list) {
            this.mapVariants.putAll(modelBlockDefinition.mapVariants);
        }
    }

    public Variants getVariants(String string) {
        Variants variants = this.mapVariants.get(string);
        if (variants == null) {
            throw new MissingVariantException();
        }
        return variants;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ModelBlockDefinition) {
            ModelBlockDefinition modelBlockDefinition = (ModelBlockDefinition)object;
            return this.mapVariants.equals(modelBlockDefinition.mapVariants);
        }
        return false;
    }

    public int hashCode() {
        return this.mapVariants.hashCode();
    }

    public static class Variants {
        private final String name;
        private final List<Variant> listVariants;

        public Variants(String string, List<Variant> list) {
            this.name = string;
            this.listVariants = list;
        }

        public List<Variant> getVariants() {
            return this.listVariants;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Variants)) {
                return false;
            }
            Variants variants = (Variants)object;
            return !this.name.equals(variants.name) ? false : this.listVariants.equals(variants.listVariants);
        }

        public int hashCode() {
            int n = this.name.hashCode();
            n = 31 * n + this.listVariants.hashCode();
            return n;
        }
    }

    public class MissingVariantException
    extends RuntimeException {
    }

    public static class Deserializer
    implements JsonDeserializer<ModelBlockDefinition> {
        @Override
        public ModelBlockDefinition deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            List<Variants> list = this.parseVariantsList(jsonDeserializationContext, jsonObject);
            return new ModelBlockDefinition((Collection<Variants>)list);
        }

        protected List<Variants> parseVariantsList(JsonDeserializationContext jsonDeserializationContext, JsonObject jsonObject) {
            JsonObject jsonObject2 = JsonUtils.getJsonObject(jsonObject, "variants");
            ArrayList<Variants> arrayList = Lists.newArrayList();
            for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
                arrayList.add(this.parseVariants(jsonDeserializationContext, entry));
            }
            return arrayList;
        }

        protected Variants parseVariants(JsonDeserializationContext jsonDeserializationContext, Map.Entry<String, JsonElement> entry) {
            String string = entry.getKey();
            ArrayList<Variant> arrayList = Lists.newArrayList();
            JsonElement jsonElement = entry.getValue();
            if (jsonElement.isJsonArray()) {
                for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                    arrayList.add((Variant)jsonDeserializationContext.deserialize(jsonElement2, (Type)((Object)Variant.class)));
                }
            } else {
                arrayList.add((Variant)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)Variant.class)));
            }
            return new Variants(string, arrayList);
        }
    }

    public static class Variant {
        private final ResourceLocation modelLocation;
        private final ModelRotation modelRotation;
        private final boolean uvLock;
        private final int weight;

        public Variant(ResourceLocation resourceLocation, ModelRotation modelRotation, boolean bl, int n) {
            this.modelLocation = resourceLocation;
            this.modelRotation = modelRotation;
            this.uvLock = bl;
            this.weight = n;
        }

        public ResourceLocation getModelLocation() {
            return this.modelLocation;
        }

        public ModelRotation getRotation() {
            return this.modelRotation;
        }

        public boolean isUvLocked() {
            return this.uvLock;
        }

        public int getWeight() {
            return this.weight;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Variant)) {
                return false;
            }
            Variant variant = (Variant)object;
            return this.modelLocation.equals(variant.modelLocation) && this.modelRotation == variant.modelRotation && this.uvLock == variant.uvLock;
        }

        public int hashCode() {
            int n = this.modelLocation.hashCode();
            n = 31 * n + (this.modelRotation != null ? this.modelRotation.hashCode() : 0);
            n = 31 * n + (this.uvLock ? 1 : 0);
            return n;
        }

        public static class Deserializer
        implements JsonDeserializer<Variant> {
            @Override
            public Variant deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String string = this.parseModel(jsonObject);
                ModelRotation modelRotation = this.parseRotation(jsonObject);
                boolean bl = this.parseUvLock(jsonObject);
                int n = this.parseWeight(jsonObject);
                return new Variant(this.makeModelLocation(string), modelRotation, bl, n);
            }

            private ResourceLocation makeModelLocation(String string) {
                ResourceLocation resourceLocation = new ResourceLocation(string);
                resourceLocation = new ResourceLocation(resourceLocation.getResourceDomain(), "block/" + resourceLocation.getResourcePath());
                return resourceLocation;
            }

            private boolean parseUvLock(JsonObject jsonObject) {
                return JsonUtils.getBoolean(jsonObject, "uvlock", false);
            }

            protected ModelRotation parseRotation(JsonObject jsonObject) {
                int n;
                int n2 = JsonUtils.getInt(jsonObject, "x", 0);
                ModelRotation modelRotation = ModelRotation.getModelRotation(n2, n = JsonUtils.getInt(jsonObject, "y", 0));
                if (modelRotation == null) {
                    throw new JsonParseException("Invalid BlockModelRotation x: " + n2 + ", y: " + n);
                }
                return modelRotation;
            }

            protected String parseModel(JsonObject jsonObject) {
                return JsonUtils.getString(jsonObject, "model");
            }

            protected int parseWeight(JsonObject jsonObject) {
                return JsonUtils.getInt(jsonObject, "weight", 1);
            }
        }
    }
}

