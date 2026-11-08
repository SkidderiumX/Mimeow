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
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import net.minecraft.client.renderer.block.model.BlockPart;
import net.minecraft.client.renderer.block.model.BlockPartFace;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemTransformVec3f;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModelBlock {
    private static final Logger LOGGER = LogManager.getLogger();
    static final Gson SERIALIZER = new GsonBuilder().registerTypeAdapter((Type)((Object)ModelBlock.class), new Deserializer()).registerTypeAdapter((Type)((Object)BlockPart.class), new BlockPart.Deserializer()).registerTypeAdapter((Type)((Object)BlockPartFace.class), new BlockPartFace.Deserializer()).registerTypeAdapter((Type)((Object)BlockFaceUV.class), new BlockFaceUV.Deserializer()).registerTypeAdapter((Type)((Object)ItemTransformVec3f.class), new ItemTransformVec3f.Deserializer()).registerTypeAdapter((Type)((Object)ItemCameraTransforms.class), new ItemCameraTransforms.Deserializer()).create();
    private final List<BlockPart> elements;
    private final boolean gui3d;
    private final boolean ambientOcclusion;
    private ItemCameraTransforms cameraTransforms;
    public String name = "";
    protected final Map<String, String> textures;
    protected ModelBlock parent;
    protected ResourceLocation parentLocation;

    public static ModelBlock deserialize(Reader reader) {
        return SERIALIZER.fromJson(reader, ModelBlock.class);
    }

    public static ModelBlock deserialize(String string) {
        return ModelBlock.deserialize(new StringReader(string));
    }

    protected ModelBlock(List<BlockPart> list, Map<String, String> map, boolean bl, boolean bl2, ItemCameraTransforms itemCameraTransforms) {
        this(null, list, map, bl, bl2, itemCameraTransforms);
    }

    protected ModelBlock(ResourceLocation resourceLocation, Map<String, String> map, boolean bl, boolean bl2, ItemCameraTransforms itemCameraTransforms) {
        this(resourceLocation, Collections.emptyList(), map, bl, bl2, itemCameraTransforms);
    }

    private ModelBlock(ResourceLocation resourceLocation, List<BlockPart> list, Map<String, String> map, boolean bl, boolean bl2, ItemCameraTransforms itemCameraTransforms) {
        this.elements = list;
        this.ambientOcclusion = bl;
        this.gui3d = bl2;
        this.textures = map;
        this.parentLocation = resourceLocation;
        this.cameraTransforms = itemCameraTransforms;
    }

    public List<BlockPart> getElements() {
        return this.hasParent() ? this.parent.getElements() : this.elements;
    }

    private boolean hasParent() {
        return this.parent != null;
    }

    public boolean isAmbientOcclusion() {
        return this.hasParent() ? this.parent.isAmbientOcclusion() : this.ambientOcclusion;
    }

    public boolean isGui3d() {
        return this.gui3d;
    }

    public boolean isResolved() {
        return this.parentLocation == null || this.parent != null && this.parent.isResolved();
    }

    public void getParentFromMap(Map<ResourceLocation, ModelBlock> map) {
        if (this.parentLocation != null) {
            this.parent = map.get(this.parentLocation);
        }
    }

    public boolean isTexturePresent(String string) {
        return !"missingno".equals(this.resolveTextureName(string));
    }

    public String resolveTextureName(String object) {
        if (!this.startsWithHash((String)object)) {
            object = "#" + (String)object;
        }
        return this.resolveTextureName((String)object, new Bookkeep(this));
    }

    private String resolveTextureName(String string, Bookkeep bookkeep) {
        if (this.startsWithHash(string)) {
            if (this == bookkeep.modelExt) {
                LOGGER.warn("Unable to resolve texture due to upward reference: " + string + " in " + this.name);
                return "missingno";
            }
            String string2 = this.textures.get(string.substring(1));
            if (string2 == null && this.hasParent()) {
                string2 = this.parent.resolveTextureName(string, bookkeep);
            }
            bookkeep.modelExt = this;
            if (string2 != null && this.startsWithHash(string2)) {
                string2 = bookkeep.model.resolveTextureName(string2, bookkeep);
            }
            return string2 != null && !this.startsWithHash(string2) ? string2 : "missingno";
        }
        return string;
    }

    private boolean startsWithHash(String string) {
        return string.charAt(0) == '#';
    }

    public ResourceLocation getParentLocation() {
        return this.parentLocation;
    }

    public ModelBlock getRootModel() {
        return this.hasParent() ? this.parent.getRootModel() : this;
    }

    public ItemCameraTransforms getAllTransforms() {
        ItemTransformVec3f itemTransformVec3f = this.getTransform(ItemCameraTransforms.TransformType.THIRD_PERSON);
        ItemTransformVec3f itemTransformVec3f2 = this.getTransform(ItemCameraTransforms.TransformType.FIRST_PERSON);
        ItemTransformVec3f itemTransformVec3f3 = this.getTransform(ItemCameraTransforms.TransformType.HEAD);
        ItemTransformVec3f itemTransformVec3f4 = this.getTransform(ItemCameraTransforms.TransformType.GUI);
        ItemTransformVec3f itemTransformVec3f5 = this.getTransform(ItemCameraTransforms.TransformType.GROUND);
        ItemTransformVec3f itemTransformVec3f6 = this.getTransform(ItemCameraTransforms.TransformType.FIXED);
        return new ItemCameraTransforms(itemTransformVec3f, itemTransformVec3f2, itemTransformVec3f3, itemTransformVec3f4, itemTransformVec3f5, itemTransformVec3f6);
    }

    private ItemTransformVec3f getTransform(ItemCameraTransforms.TransformType transformType) {
        return this.parent != null && !this.cameraTransforms.func_181687_c(transformType) ? this.parent.getTransform(transformType) : this.cameraTransforms.getTransform(transformType);
    }

    public static void checkModelHierarchy(Map<ResourceLocation, ModelBlock> map) {
        for (ModelBlock modelBlock : map.values()) {
            try {
                ModelBlock modelBlock2 = modelBlock.parent;
                ModelBlock modelBlock3 = modelBlock2.parent;
                while (modelBlock2 != modelBlock3) {
                    modelBlock2 = modelBlock2.parent;
                    modelBlock3 = modelBlock3.parent.parent;
                }
                throw new LoopException();
            }
            catch (NullPointerException nullPointerException) {
            }
        }
    }

    public static final class Bookkeep {
        public final ModelBlock model;
        public ModelBlock modelExt;

        private Bookkeep(ModelBlock modelBlock) {
            this.model = modelBlock;
        }
    }

    public static class LoopException
    extends RuntimeException {
    }

    public static class Deserializer
    implements JsonDeserializer<ModelBlock> {
        @Override
        public ModelBlock deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            List<BlockPart> list = this.getModelElements(jsonDeserializationContext, jsonObject);
            String string = this.getParent(jsonObject);
            boolean bl = StringUtils.isEmpty(string);
            boolean bl2 = list.isEmpty();
            if (bl2 && bl) {
                throw new JsonParseException("BlockModel requires either elements or parent, found neither");
            }
            if (!bl && !bl2) {
                throw new JsonParseException("BlockModel requires either elements or parent, found both");
            }
            Map<String, String> map = this.getTextures(jsonObject);
            boolean bl3 = this.getAmbientOcclusionEnabled(jsonObject);
            ItemCameraTransforms itemCameraTransforms = ItemCameraTransforms.DEFAULT;
            if (jsonObject.has("display")) {
                JsonObject jsonObject2 = JsonUtils.getJsonObject(jsonObject, "display");
                itemCameraTransforms = (ItemCameraTransforms)jsonDeserializationContext.deserialize(jsonObject2, (Type)((Object)ItemCameraTransforms.class));
            }
            return bl2 ? new ModelBlock(new ResourceLocation(string), map, bl3, true, itemCameraTransforms) : new ModelBlock(list, map, bl3, true, itemCameraTransforms);
        }

        private Map<String, String> getTextures(JsonObject jsonObject) {
            HashMap<String, String> hashMap = Maps.newHashMap();
            if (jsonObject.has("textures")) {
                JsonObject jsonObject2 = jsonObject.getAsJsonObject("textures");
                for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue().getAsString());
                }
            }
            return hashMap;
        }

        private String getParent(JsonObject jsonObject) {
            return JsonUtils.getString(jsonObject, "parent", "");
        }

        protected boolean getAmbientOcclusionEnabled(JsonObject jsonObject) {
            return JsonUtils.getBoolean(jsonObject, "ambientocclusion", true);
        }

        protected List<BlockPart> getModelElements(JsonDeserializationContext jsonDeserializationContext, JsonObject jsonObject) {
            ArrayList<BlockPart> arrayList = Lists.newArrayList();
            if (jsonObject.has("elements")) {
                for (JsonElement jsonElement : JsonUtils.getJsonArray(jsonObject, "elements")) {
                    arrayList.add((BlockPart)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)BlockPart.class)));
                }
            }
            return arrayList;
        }
    }
}

