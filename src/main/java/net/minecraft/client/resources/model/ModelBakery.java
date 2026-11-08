/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources.model;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockPart;
import net.minecraft.client.renderer.block.model.BlockPartFace;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition;
import net.minecraft.client.renderer.texture.IIconCreator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.BuiltInModel;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.ModelRotation;
import net.minecraft.client.resources.model.SimpleBakedModel;
import net.minecraft.client.resources.model.WeightedBakedModel;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IRegistry;
import net.minecraft.util.RegistrySimple;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomItems;
import net.optifine.compat.model.ITransformation;
import net.optifine.compat.model.TRSRTransformation;
import net.optifine.compat.registry.RegistryDelegate;
import net.optifine.reflect.Reflector;
import net.optifine.util.StrUtils;
import net.optifine.util.TextureUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModelBakery {
    private static final Set<ResourceLocation> LOCATIONS_BUILTIN_TEXTURES = Sets.newHashSet(new ResourceLocation("blocks/water_flow"), new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/lava_flow"), new ResourceLocation("blocks/lava_still"), new ResourceLocation("blocks/destroy_stage_0"), new ResourceLocation("blocks/destroy_stage_1"), new ResourceLocation("blocks/destroy_stage_2"), new ResourceLocation("blocks/destroy_stage_3"), new ResourceLocation("blocks/destroy_stage_4"), new ResourceLocation("blocks/destroy_stage_5"), new ResourceLocation("blocks/destroy_stage_6"), new ResourceLocation("blocks/destroy_stage_7"), new ResourceLocation("blocks/destroy_stage_8"), new ResourceLocation("blocks/destroy_stage_9"), new ResourceLocation("items/empty_armor_slot_helmet"), new ResourceLocation("items/empty_armor_slot_chestplate"), new ResourceLocation("items/empty_armor_slot_leggings"), new ResourceLocation("items/empty_armor_slot_boots"));
    private static final Logger LOGGER = LogManager.getLogger();
    protected static final ModelResourceLocation MODEL_MISSING = new ModelResourceLocation("builtin/missing", "missing");
    private static final Map<String, String> BUILT_IN_MODELS = Maps.newHashMap();
    private static final Joiner JOINER = Joiner.on(" -> ");
    private final IResourceManager resourceManager;
    private final Map<ResourceLocation, TextureAtlasSprite> sprites = Maps.newHashMap();
    private final Map<ResourceLocation, ModelBlock> models = Maps.newLinkedHashMap();
    private final Map<ModelResourceLocation, ModelBlockDefinition.Variants> variants = Maps.newLinkedHashMap();
    private final TextureMap textureMap;
    private final BlockModelShapes blockModelShapes;
    private final FaceBakery faceBakery = new FaceBakery();
    private final ItemModelGenerator itemModelGenerator = new ItemModelGenerator();
    private RegistrySimple<ModelResourceLocation, IBakedModel> bakedRegistry = new RegistrySimple();
    private static final ModelBlock MODEL_GENERATED = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
    private static final ModelBlock MODEL_COMPASS = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
    private static final ModelBlock MODEL_CLOCK = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
    private static final ModelBlock MODEL_ENTITY = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
    private Map<String, ResourceLocation> itemLocations = Maps.newLinkedHashMap();
    private final Map<ResourceLocation, ModelBlockDefinition> blockDefinitions = Maps.newHashMap();
    private Map<Item, List<String>> variantNames = Maps.newIdentityHashMap();
    private static Map<RegistryDelegate<Item>, Set<String>> customVariantNames = Maps.newHashMap();

    public ModelBakery(IResourceManager iResourceManager, TextureMap textureMap, BlockModelShapes blockModelShapes) {
        this.resourceManager = iResourceManager;
        this.textureMap = textureMap;
        this.blockModelShapes = blockModelShapes;
    }

    public IRegistry<ModelResourceLocation, IBakedModel> setupModelRegistry() {
        this.loadVariantItemModels();
        this.loadModelsCheck();
        this.loadSprites();
        this.bakeItemModels();
        this.bakeBlockModels();
        return this.bakedRegistry;
    }

    private void loadVariantItemModels() {
        this.loadVariants(this.blockModelShapes.getBlockStateMapper().putAllStateModelLocations().values());
        this.variants.put(MODEL_MISSING, new ModelBlockDefinition.Variants(MODEL_MISSING.getVariant(), Lists.newArrayList(new ModelBlockDefinition.Variant(new ResourceLocation(MODEL_MISSING.getResourcePath()), ModelRotation.X0_Y0, false, 1))));
        ResourceLocation resourceLocation = new ResourceLocation("item_frame");
        ModelBlockDefinition modelBlockDefinition = this.getModelBlockDefinition(resourceLocation);
        this.registerVariant(modelBlockDefinition, new ModelResourceLocation(resourceLocation, "normal"));
        this.registerVariant(modelBlockDefinition, new ModelResourceLocation(resourceLocation, "map"));
        this.loadVariantModels();
        this.loadItemModels();
    }

    private void loadVariants(Collection<ModelResourceLocation> collection) {
        for (ModelResourceLocation modelResourceLocation : collection) {
            try {
                ModelBlockDefinition modelBlockDefinition = this.getModelBlockDefinition(modelResourceLocation);
                try {
                    this.registerVariant(modelBlockDefinition, modelResourceLocation);
                }
                catch (Exception exception) {
                    LOGGER.warn("Unable to load variant: " + modelResourceLocation.getVariant() + " from " + String.valueOf(modelResourceLocation), (Throwable)exception);
                }
            }
            catch (Exception exception) {
                LOGGER.warn("Unable to load definition " + String.valueOf(modelResourceLocation), (Throwable)exception);
            }
        }
    }

    private void registerVariant(ModelBlockDefinition modelBlockDefinition, ModelResourceLocation modelResourceLocation) {
        this.variants.put(modelResourceLocation, modelBlockDefinition.getVariants(modelResourceLocation.getVariant()));
    }

    private ModelBlockDefinition getModelBlockDefinition(ResourceLocation resourceLocation) {
        ResourceLocation resourceLocation2 = this.getBlockStateLocation(resourceLocation);
        ModelBlockDefinition modelBlockDefinition = this.blockDefinitions.get(resourceLocation2);
        if (modelBlockDefinition == null) {
            ArrayList<ModelBlockDefinition> arrayList = Lists.newArrayList();
            try {
                for (IResource iResource : this.resourceManager.getAllResources(resourceLocation2)) {
                    InputStream inputStream2 = null;
                    try {
                        inputStream2 = iResource.getInputStream();
                        ModelBlockDefinition modelBlockDefinition2 = ModelBlockDefinition.parseFromReader(new InputStreamReader(inputStream2, Charsets.UTF_8));
                        arrayList.add(modelBlockDefinition2);
                    }
                    catch (Exception exception) {
                        throw new RuntimeException("Encountered an exception when loading model definition of '" + String.valueOf(resourceLocation) + "' from: '" + String.valueOf(iResource.getResourceLocation()) + "' in resourcepack: '" + iResource.getResourcePackName() + "'", exception);
                    }
                    finally {
                        IOUtils.closeQuietly(inputStream2);
                    }
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException("Encountered an exception when loading model definition of model " + resourceLocation2.toString(), iOException);
            }
            modelBlockDefinition = new ModelBlockDefinition((List<ModelBlockDefinition>)arrayList);
            this.blockDefinitions.put(resourceLocation2, modelBlockDefinition);
        }
        return modelBlockDefinition;
    }

    private ResourceLocation getBlockStateLocation(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getResourceDomain(), "blockstates/" + resourceLocation.getResourcePath() + ".json");
    }

    private void loadVariantModels() {
        for (ModelResourceLocation modelResourceLocation : this.variants.keySet()) {
            for (ModelBlockDefinition.Variant variant : this.variants.get(modelResourceLocation).getVariants()) {
                ResourceLocation resourceLocation = variant.getModelLocation();
                if (this.models.get(resourceLocation) != null) continue;
                try {
                    ModelBlock modelBlock = this.loadModel(resourceLocation);
                    this.models.put(resourceLocation, modelBlock);
                }
                catch (Exception exception) {
                    LOGGER.warn("Unable to load block model: '" + String.valueOf(resourceLocation) + "' for variant: '" + String.valueOf(modelResourceLocation) + "'", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ModelBlock loadModel(ResourceLocation resourceLocation) throws IOException {
        Reader reader;
        Object object;
        Object object2;
        String string = resourceLocation.getResourcePath();
        if ("builtin/generated".equals(string)) {
            return MODEL_GENERATED;
        }
        if ("builtin/compass".equals(string)) {
            return MODEL_COMPASS;
        }
        if ("builtin/clock".equals(string)) {
            return MODEL_CLOCK;
        }
        if ("builtin/entity".equals(string)) {
            return MODEL_ENTITY;
        }
        if (string.startsWith("builtin/")) {
            object2 = string.substring("builtin/".length());
            object = BUILT_IN_MODELS.get(object2);
            if (object == null) {
                throw new FileNotFoundException(resourceLocation.toString());
            }
            reader = new StringReader((String)object);
        } else {
            resourceLocation = this.getModelLocation(resourceLocation);
            object2 = this.resourceManager.getResource(resourceLocation);
            reader = new InputStreamReader(object2.getInputStream(), Charsets.UTF_8);
        }
        try {
            object = ModelBlock.deserialize(reader);
            ((ModelBlock)object).name = resourceLocation.toString();
            object2 = object;
            String string2 = TextureUtils.getBasePath(resourceLocation.getResourcePath());
            ModelBakery.fixModelLocations((ModelBlock)object, string2);
        }
        finally {
            reader.close();
        }
        return object2;
    }

    private ResourceLocation getModelLocation(ResourceLocation resourceLocation) {
        ResourceLocation resourceLocation2 = resourceLocation;
        String string = resourceLocation.getResourcePath();
        if (!string.startsWith("mcpatcher") && !string.startsWith("optifine")) {
            return new ResourceLocation(resourceLocation.getResourceDomain(), "models/" + resourceLocation.getResourcePath() + ".json");
        }
        if (!string.endsWith(".json")) {
            resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), string + ".json");
        }
        return resourceLocation2;
    }

    private void loadItemModels() {
        this.registerVariantNames();
        for (Item item : Item.itemRegistry) {
            for (String string : this.getVariantNames(item)) {
                ResourceLocation resourceLocation = this.getItemLocation(string);
                this.itemLocations.put(string, resourceLocation);
                if (this.models.get(resourceLocation) != null) continue;
                try {
                    ModelBlock modelBlock = this.loadModel(resourceLocation);
                    this.models.put(resourceLocation, modelBlock);
                }
                catch (Exception exception) {
                    LOGGER.warn("Unable to load item model: '" + String.valueOf(resourceLocation) + "' for item: '" + String.valueOf(Item.itemRegistry.getNameForObject(item)) + "'", (Throwable)exception);
                }
            }
        }
    }

    public void loadItemModel(String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        this.itemLocations.put(string, resourceLocation);
        if (this.models.get(resourceLocation) == null) {
            try {
                ModelBlock modelBlock = this.loadModel(resourceLocation);
                this.models.put(resourceLocation, modelBlock);
            }
            catch (Exception exception) {
                LOGGER.warn("Unable to load item model: '{}' for item: '{}'", resourceLocation, resourceLocation2);
                LOGGER.warn(exception.getClass().getName() + ": " + exception.getMessage());
            }
        }
    }

    private void registerVariantNames() {
        this.variantNames.clear();
        this.variantNames.put(Item.getItemFromBlock(Blocks.stone), Lists.newArrayList("stone", "granite", "granite_smooth", "diorite", "diorite_smooth", "andesite", "andesite_smooth"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.dirt), Lists.newArrayList("dirt", "coarse_dirt", "podzol"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.planks), Lists.newArrayList("oak_planks", "spruce_planks", "birch_planks", "jungle_planks", "acacia_planks", "dark_oak_planks"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.sapling), Lists.newArrayList("oak_sapling", "spruce_sapling", "birch_sapling", "jungle_sapling", "acacia_sapling", "dark_oak_sapling"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.sand), Lists.newArrayList("sand", "red_sand"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.log), Lists.newArrayList("oak_log", "spruce_log", "birch_log", "jungle_log"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.leaves), Lists.newArrayList("oak_leaves", "spruce_leaves", "birch_leaves", "jungle_leaves"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.sponge), Lists.newArrayList("sponge", "sponge_wet"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.sandstone), Lists.newArrayList("sandstone", "chiseled_sandstone", "smooth_sandstone"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.red_sandstone), Lists.newArrayList("red_sandstone", "chiseled_red_sandstone", "smooth_red_sandstone"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.tallgrass), Lists.newArrayList("dead_bush", "tall_grass", "fern"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.deadbush), Lists.newArrayList("dead_bush"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.wool), Lists.newArrayList("black_wool", "red_wool", "green_wool", "brown_wool", "blue_wool", "purple_wool", "cyan_wool", "silver_wool", "gray_wool", "pink_wool", "lime_wool", "yellow_wool", "light_blue_wool", "magenta_wool", "orange_wool", "white_wool"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.yellow_flower), Lists.newArrayList("dandelion"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.red_flower), Lists.newArrayList("poppy", "blue_orchid", "allium", "houstonia", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stone_slab), Lists.newArrayList("stone_slab", "sandstone_slab", "cobblestone_slab", "brick_slab", "stone_brick_slab", "nether_brick_slab", "quartz_slab"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stone_slab2), Lists.newArrayList("red_sandstone_slab"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stained_glass), Lists.newArrayList("black_stained_glass", "red_stained_glass", "green_stained_glass", "brown_stained_glass", "blue_stained_glass", "purple_stained_glass", "cyan_stained_glass", "silver_stained_glass", "gray_stained_glass", "pink_stained_glass", "lime_stained_glass", "yellow_stained_glass", "light_blue_stained_glass", "magenta_stained_glass", "orange_stained_glass", "white_stained_glass"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.monster_egg), Lists.newArrayList("stone_monster_egg", "cobblestone_monster_egg", "stone_brick_monster_egg", "mossy_brick_monster_egg", "cracked_brick_monster_egg", "chiseled_brick_monster_egg"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stonebrick), Lists.newArrayList("stonebrick", "mossy_stonebrick", "cracked_stonebrick", "chiseled_stonebrick"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.wooden_slab), Lists.newArrayList("oak_slab", "spruce_slab", "birch_slab", "jungle_slab", "acacia_slab", "dark_oak_slab"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.cobblestone_wall), Lists.newArrayList("cobblestone_wall", "mossy_cobblestone_wall"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.anvil), Lists.newArrayList("anvil_intact", "anvil_slightly_damaged", "anvil_very_damaged"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.quartz_block), Lists.newArrayList("quartz_block", "chiseled_quartz_block", "quartz_column"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stained_hardened_clay), Lists.newArrayList("black_stained_hardened_clay", "red_stained_hardened_clay", "green_stained_hardened_clay", "brown_stained_hardened_clay", "blue_stained_hardened_clay", "purple_stained_hardened_clay", "cyan_stained_hardened_clay", "silver_stained_hardened_clay", "gray_stained_hardened_clay", "pink_stained_hardened_clay", "lime_stained_hardened_clay", "yellow_stained_hardened_clay", "light_blue_stained_hardened_clay", "magenta_stained_hardened_clay", "orange_stained_hardened_clay", "white_stained_hardened_clay"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.stained_glass_pane), Lists.newArrayList("black_stained_glass_pane", "red_stained_glass_pane", "green_stained_glass_pane", "brown_stained_glass_pane", "blue_stained_glass_pane", "purple_stained_glass_pane", "cyan_stained_glass_pane", "silver_stained_glass_pane", "gray_stained_glass_pane", "pink_stained_glass_pane", "lime_stained_glass_pane", "yellow_stained_glass_pane", "light_blue_stained_glass_pane", "magenta_stained_glass_pane", "orange_stained_glass_pane", "white_stained_glass_pane"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.leaves2), Lists.newArrayList("acacia_leaves", "dark_oak_leaves"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.log2), Lists.newArrayList("acacia_log", "dark_oak_log"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.prismarine), Lists.newArrayList("prismarine", "prismarine_bricks", "dark_prismarine"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.carpet), Lists.newArrayList("black_carpet", "red_carpet", "green_carpet", "brown_carpet", "blue_carpet", "purple_carpet", "cyan_carpet", "silver_carpet", "gray_carpet", "pink_carpet", "lime_carpet", "yellow_carpet", "light_blue_carpet", "magenta_carpet", "orange_carpet", "white_carpet"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.double_plant), Lists.newArrayList("sunflower", "syringa", "double_grass", "double_fern", "double_rose", "paeonia"));
        this.variantNames.put(Items.bow, Lists.newArrayList("bow", "bow_pulling_0", "bow_pulling_1", "bow_pulling_2"));
        this.variantNames.put(Items.coal, Lists.newArrayList("coal", "charcoal"));
        this.variantNames.put(Items.fishing_rod, Lists.newArrayList("fishing_rod", "fishing_rod_cast"));
        this.variantNames.put(Items.fish, Lists.newArrayList("cod", "salmon", "clownfish", "pufferfish"));
        this.variantNames.put(Items.cooked_fish, Lists.newArrayList("cooked_cod", "cooked_salmon"));
        this.variantNames.put(Items.dye, Lists.newArrayList("dye_black", "dye_red", "dye_green", "dye_brown", "dye_blue", "dye_purple", "dye_cyan", "dye_silver", "dye_gray", "dye_pink", "dye_lime", "dye_yellow", "dye_light_blue", "dye_magenta", "dye_orange", "dye_white"));
        this.variantNames.put(Items.potionitem, Lists.newArrayList("bottle_drinkable", "bottle_splash"));
        this.variantNames.put(Items.skull, Lists.newArrayList("skull_skeleton", "skull_wither", "skull_zombie", "skull_char", "skull_creeper"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.oak_fence_gate), Lists.newArrayList("oak_fence_gate"));
        this.variantNames.put(Item.getItemFromBlock(Blocks.oak_fence), Lists.newArrayList("oak_fence"));
        this.variantNames.put(Items.oak_door, Lists.newArrayList("oak_door"));
        for (Map.Entry<RegistryDelegate<Item>, Set<String>> entry : customVariantNames.entrySet()) {
            this.variantNames.put(entry.getKey().get(), Lists.newArrayList(entry.getValue().iterator()));
        }
        CustomItems.update();
        CustomItems.loadModels(this);
    }

    private List<String> getVariantNames(Item item) {
        List<String> list = this.variantNames.get(item);
        if (list == null) {
            list = Collections.singletonList(Item.itemRegistry.getNameForObject(item).toString());
        }
        return list;
    }

    private ResourceLocation getItemLocation(String string) {
        ResourceLocation resourceLocation = new ResourceLocation(string);
        if (Reflector.CompatHooksClient.exists()) {
            resourceLocation = new ResourceLocation(string.replaceAll("#.*", ""));
        }
        return new ResourceLocation(resourceLocation.getResourceDomain(), "item/" + resourceLocation.getResourcePath());
    }

    private void bakeBlockModels() {
        Object object;
        Object object2;
        for (ModelResourceLocation object3 : this.variants.keySet()) {
            object2 = new WeightedBakedModel.Builder();
            int modelResourceLocation = 0;
            object = this.variants.get(object3).getVariants().iterator();
            while (object.hasNext()) {
                ModelBlockDefinition.Variant variant = object.next();
                ModelBlock modelBlock = this.models.get(variant.getModelLocation());
                if (modelBlock != null && modelBlock.isResolved()) {
                    ++modelResourceLocation;
                    ((WeightedBakedModel.Builder)object2).add(this.bakeModel(modelBlock, variant.getRotation(), variant.isUvLocked()), variant.getWeight());
                    continue;
                }
                LOGGER.warn("Missing model for: " + String.valueOf(object3));
            }
            if (modelResourceLocation == 0) {
                LOGGER.warn("No weighted models for: " + String.valueOf(object3));
                continue;
            }
            if (modelResourceLocation == 1) {
                this.bakedRegistry.putObject(object3, ((WeightedBakedModel.Builder)object2).first());
                continue;
            }
            this.bakedRegistry.putObject(object3, ((WeightedBakedModel.Builder)object2).build());
        }
        for (Map.Entry entry : this.itemLocations.entrySet()) {
            object2 = (ResourceLocation)entry.getValue();
            ModelResourceLocation modelResourceLocation = new ModelResourceLocation((String)entry.getKey(), "inventory");
            if (Reflector.ModelLoader_getInventoryVariant.exists()) {
                modelResourceLocation = (ModelResourceLocation)Reflector.call(Reflector.ModelLoader_getInventoryVariant, entry.getKey());
            }
            if ((object = this.models.get(object2)) != null && ((ModelBlock)object).isResolved()) {
                if (this.isCustomRenderer((ModelBlock)object)) {
                    this.bakedRegistry.putObject(modelResourceLocation, new BuiltInModel(((ModelBlock)object).getAllTransforms()));
                    continue;
                }
                this.bakedRegistry.putObject(modelResourceLocation, this.bakeModel((ModelBlock)object, ModelRotation.X0_Y0, false));
                continue;
            }
            LOGGER.warn("Missing model for: " + String.valueOf(object2));
        }
    }

    private Set<ResourceLocation> getVariantsTextureLocations() {
        HashSet<ResourceLocation> hashSet = Sets.newHashSet();
        ArrayList<ModelResourceLocation> arrayList = Lists.newArrayList(this.variants.keySet());
        Collections.sort(arrayList, new Comparator<ModelResourceLocation>(){

            @Override
            public int compare(ModelResourceLocation modelResourceLocation, ModelResourceLocation modelResourceLocation2) {
                return modelResourceLocation.toString().compareTo(modelResourceLocation2.toString());
            }
        });
        for (ModelResourceLocation modelResourceLocation : arrayList) {
            ModelBlockDefinition.Variants variants = this.variants.get(modelResourceLocation);
            for (ModelBlockDefinition.Variant variant : variants.getVariants()) {
                ModelBlock modelBlock = this.models.get(variant.getModelLocation());
                if (modelBlock == null) {
                    LOGGER.warn("Missing model for: " + String.valueOf(modelResourceLocation));
                    continue;
                }
                hashSet.addAll(this.getTextureLocations(modelBlock));
            }
        }
        hashSet.addAll(LOCATIONS_BUILTIN_TEXTURES);
        return hashSet;
    }

    public IBakedModel bakeModel(ModelBlock modelBlock, ModelRotation modelRotation, boolean bl) {
        return this.bakeModel(modelBlock, (ITransformation)modelRotation, bl);
    }

    protected IBakedModel bakeModel(ModelBlock modelBlock, ITransformation iTransformation, boolean bl) {
        TextureAtlasSprite textureAtlasSprite = this.sprites.get(new ResourceLocation(modelBlock.resolveTextureName("particle")));
        SimpleBakedModel.Builder builder = new SimpleBakedModel.Builder(modelBlock).setTexture(textureAtlasSprite);
        for (BlockPart blockPart : modelBlock.getElements()) {
            for (EnumFacing enumFacing : blockPart.mapFaces.keySet()) {
                BlockPartFace blockPartFace = blockPart.mapFaces.get(enumFacing);
                TextureAtlasSprite textureAtlasSprite2 = this.sprites.get(new ResourceLocation(modelBlock.resolveTextureName(blockPartFace.texture)));
                boolean bl2 = true;
                if (Reflector.CompatHooksClient.exists()) {
                    bl2 = TRSRTransformation.isInteger(iTransformation.getMatrix());
                }
                if (blockPartFace.cullFace != null && bl2) {
                    builder.addFaceQuad(iTransformation.rotate(blockPartFace.cullFace), this.makeBakedQuad(blockPart, blockPartFace, textureAtlasSprite2, enumFacing, iTransformation, bl));
                    continue;
                }
                builder.addGeneralQuad(this.makeBakedQuad(blockPart, blockPartFace, textureAtlasSprite2, enumFacing, iTransformation, bl));
            }
        }
        return builder.makeBakedModel();
    }

    private BakedQuad makeBakedQuad(BlockPart blockPart, BlockPartFace blockPartFace, TextureAtlasSprite textureAtlasSprite, EnumFacing enumFacing, ModelRotation modelRotation, boolean bl) {
        return Reflector.CompatHooksClient.exists() ? this.makeBakedQuad(blockPart, blockPartFace, textureAtlasSprite, enumFacing, modelRotation, bl) : this.faceBakery.makeBakedQuad(blockPart.positionFrom, blockPart.positionTo, blockPartFace, textureAtlasSprite, enumFacing, modelRotation, blockPart.partRotation, bl, blockPart.shade);
    }

    protected BakedQuad makeBakedQuad(BlockPart blockPart, BlockPartFace blockPartFace, TextureAtlasSprite textureAtlasSprite, EnumFacing enumFacing, ITransformation iTransformation, boolean bl) {
        return this.faceBakery.makeBakedQuad(blockPart.positionFrom, blockPart.positionTo, blockPartFace, textureAtlasSprite, enumFacing, iTransformation, blockPart.partRotation, bl, blockPart.shade);
    }

    private void loadModelsCheck() {
        this.loadModels();
        for (ModelBlock modelBlock : this.models.values()) {
            modelBlock.getParentFromMap(this.models);
        }
        ModelBlock.checkModelHierarchy(this.models);
    }

    private void loadModels() {
        ResourceLocation resourceLocation;
        ArrayDeque<ResourceLocation> arrayDeque = Queues.newArrayDeque();
        HashSet<Object> hashSet = Sets.newHashSet();
        for (ResourceLocation object : this.models.keySet()) {
            hashSet.add(object);
            resourceLocation = this.models.get(object).getParentLocation();
            if (resourceLocation == null) continue;
            arrayDeque.add(resourceLocation);
        }
        while (!arrayDeque.isEmpty()) {
            ResourceLocation resourceLocation2 = (ResourceLocation)arrayDeque.pop();
            try {
                if (this.models.get(resourceLocation2) != null) continue;
                ModelBlock modelBlock = this.loadModel(resourceLocation2);
                this.models.put(resourceLocation2, modelBlock);
                resourceLocation = modelBlock.getParentLocation();
                if (resourceLocation != null && !hashSet.contains(resourceLocation)) {
                    arrayDeque.add(resourceLocation);
                }
            }
            catch (Exception exception) {
                LOGGER.warn("In parent chain: " + JOINER.join(this.getParentPath(resourceLocation2)) + "; unable to load model: '" + String.valueOf(resourceLocation2) + "'");
            }
            hashSet.add(resourceLocation2);
        }
    }

    private List<ResourceLocation> getParentPath(ResourceLocation resourceLocation) {
        ArrayList<ResourceLocation> arrayList = Lists.newArrayList(resourceLocation);
        ResourceLocation resourceLocation2 = resourceLocation;
        while ((resourceLocation2 = this.getParentLocation(resourceLocation2)) != null) {
            arrayList.add(0, resourceLocation2);
        }
        return arrayList;
    }

    private ResourceLocation getParentLocation(ResourceLocation resourceLocation) {
        for (Map.Entry<ResourceLocation, ModelBlock> entry : this.models.entrySet()) {
            ModelBlock modelBlock = entry.getValue();
            if (modelBlock == null || !resourceLocation.equals(modelBlock.getParentLocation())) continue;
            return entry.getKey();
        }
        return null;
    }

    private Set<ResourceLocation> getTextureLocations(ModelBlock modelBlock) {
        HashSet<ResourceLocation> hashSet = Sets.newHashSet();
        for (BlockPart blockPart : modelBlock.getElements()) {
            for (BlockPartFace blockPartFace : blockPart.mapFaces.values()) {
                ResourceLocation resourceLocation = new ResourceLocation(modelBlock.resolveTextureName(blockPartFace.texture));
                hashSet.add(resourceLocation);
            }
        }
        hashSet.add(new ResourceLocation(modelBlock.resolveTextureName("particle")));
        return hashSet;
    }

    private void loadSprites() {
        final Set<ResourceLocation> set = this.getVariantsTextureLocations();
        set.addAll(this.getItemsTextureLocations());
        set.remove(TextureMap.LOCATION_MISSING_TEXTURE);
        IIconCreator iIconCreator = new IIconCreator(){

            @Override
            public void registerSprites(TextureMap textureMap) {
                for (ResourceLocation resourceLocation : set) {
                    TextureAtlasSprite textureAtlasSprite = textureMap.registerSprite(resourceLocation);
                    ModelBakery.this.sprites.put(resourceLocation, textureAtlasSprite);
                }
            }
        };
        this.textureMap.loadSprites(this.resourceManager, iIconCreator);
        this.sprites.put(new ResourceLocation("missingno"), this.textureMap.getMissingSprite());
    }

    private Set<ResourceLocation> getItemsTextureLocations() {
        HashSet<ResourceLocation> hashSet = Sets.newHashSet();
        for (ResourceLocation resourceLocation : this.itemLocations.values()) {
            ModelBlock modelBlock = this.models.get(resourceLocation);
            if (modelBlock == null) continue;
            hashSet.add(new ResourceLocation(modelBlock.resolveTextureName("particle")));
            if (this.hasItemModel(modelBlock)) {
                for (String string : ItemModelGenerator.LAYERS) {
                    ResourceLocation resourceLocation2 = new ResourceLocation(modelBlock.resolveTextureName(string));
                    if (modelBlock.getRootModel() == MODEL_COMPASS && !TextureMap.LOCATION_MISSING_TEXTURE.equals(resourceLocation2)) {
                        TextureAtlasSprite.setLocationNameCompass(resourceLocation2.toString());
                    } else if (modelBlock.getRootModel() == MODEL_CLOCK && !TextureMap.LOCATION_MISSING_TEXTURE.equals(resourceLocation2)) {
                        TextureAtlasSprite.setLocationNameClock(resourceLocation2.toString());
                    }
                    hashSet.add(resourceLocation2);
                }
                continue;
            }
            if (this.isCustomRenderer(modelBlock)) continue;
            for (BlockPart blockPart : modelBlock.getElements()) {
                for (BlockPartFace blockPartFace : blockPart.mapFaces.values()) {
                    ResourceLocation resourceLocation3 = new ResourceLocation(modelBlock.resolveTextureName(blockPartFace.texture));
                    hashSet.add(resourceLocation3);
                }
            }
        }
        return hashSet;
    }

    private boolean hasItemModel(ModelBlock modelBlock) {
        if (modelBlock == null) {
            return false;
        }
        ModelBlock modelBlock2 = modelBlock.getRootModel();
        return modelBlock2 == MODEL_GENERATED || modelBlock2 == MODEL_COMPASS || modelBlock2 == MODEL_CLOCK;
    }

    private boolean isCustomRenderer(ModelBlock modelBlock) {
        if (modelBlock == null) {
            return false;
        }
        ModelBlock modelBlock2 = modelBlock.getRootModel();
        return modelBlock2 == MODEL_ENTITY;
    }

    private void bakeItemModels() {
        for (ResourceLocation object : this.itemLocations.values()) {
            ModelBlock modelBlock = this.models.get(object);
            if (this.hasItemModel(modelBlock)) {
                ModelBlock modelBlock2 = this.makeItemModel(modelBlock);
                if (modelBlock2 != null) {
                    modelBlock2.name = object.toString();
                }
                this.models.put(object, modelBlock2);
                continue;
            }
            if (!this.isCustomRenderer(modelBlock)) continue;
            this.models.put(object, modelBlock);
        }
        for (TextureAtlasSprite textureAtlasSprite : this.sprites.values()) {
            if (textureAtlasSprite.hasAnimationMetadata()) continue;
            textureAtlasSprite.clearFramesTextureData();
        }
    }

    private ModelBlock makeItemModel(ModelBlock modelBlock) {
        return this.itemModelGenerator.makeItemModel(this.textureMap, modelBlock);
    }

    public ModelBlock getModelBlock(ResourceLocation resourceLocation) {
        ModelBlock modelBlock = this.models.get(resourceLocation);
        return modelBlock;
    }

    public static void fixModelLocations(ModelBlock modelBlock, String string) {
        Map map;
        ResourceLocation resourceLocation = ModelBakery.fixModelLocation(modelBlock.getParentLocation(), string);
        if (resourceLocation != modelBlock.getParentLocation()) {
            Reflector.setFieldValue(modelBlock, Reflector.ModelBlock_parentLocation, resourceLocation);
        }
        if ((map = (Map)Reflector.getFieldValue(modelBlock, Reflector.ModelBlock_textures)) != null) {
            for (Map.Entry entry : map.entrySet()) {
                String string2 = (String)entry.getValue();
                String string3 = ModelBakery.fixResourcePath(string2, string);
                if (string3 == string2) continue;
                entry.setValue(string3);
            }
        }
    }

    public static ResourceLocation fixModelLocation(ResourceLocation resourceLocation, String string) {
        if (resourceLocation != null && string != null) {
            if (!resourceLocation.getResourceDomain().equals("minecraft")) {
                return resourceLocation;
            }
            String string2 = resourceLocation.getResourcePath();
            String string3 = ModelBakery.fixResourcePath(string2, string);
            if (string3 != string2) {
                resourceLocation = new ResourceLocation(resourceLocation.getResourceDomain(), string3);
            }
            return resourceLocation;
        }
        return resourceLocation;
    }

    private static String fixResourcePath(String string, String string2) {
        string = TextureUtils.fixResourcePath(string, string2);
        string = StrUtils.removeSuffix(string, ".json");
        string = StrUtils.removeSuffix(string, ".png");
        return string;
    }

    @Deprecated
    public static void addVariantName(Item item, String ... stringArray) {
        RegistryDelegate registryDelegate = (RegistryDelegate)Reflector.getFieldValue(item, Reflector.CompatItem_delegate);
        if (customVariantNames.containsKey(registryDelegate)) {
            customVariantNames.get(registryDelegate).addAll(Lists.newArrayList(stringArray));
        } else {
            customVariantNames.put(registryDelegate, Sets.newHashSet(stringArray));
        }
    }

    public static <T extends ResourceLocation> void registerItemVariants(Item item, T ... TArray) {
        RegistryDelegate registryDelegate = (RegistryDelegate)Reflector.getFieldValue(item, Reflector.CompatItem_delegate);
        if (!customVariantNames.containsKey(registryDelegate)) {
            customVariantNames.put(registryDelegate, Sets.newHashSet());
        }
        for (T t : TArray) {
            customVariantNames.get(registryDelegate).add(((ResourceLocation)t).toString());
        }
    }

    static {
        BUILT_IN_MODELS.put("missing", "{ \"textures\": {   \"particle\": \"missingno\",   \"missingno\": \"missingno\"}, \"elements\": [ {     \"from\": [ 0, 0, 0 ],     \"to\": [ 16, 16, 16 ],     \"faces\": {         \"down\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"down\", \"texture\": \"#missingno\" },         \"up\":    { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"up\", \"texture\": \"#missingno\" },         \"north\": { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"north\", \"texture\": \"#missingno\" },         \"south\": { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"south\", \"texture\": \"#missingno\" },         \"west\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"west\", \"texture\": \"#missingno\" },         \"east\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"east\", \"texture\": \"#missingno\" }    }}]}");
        ModelBakery.MODEL_GENERATED.name = "generation marker";
        ModelBakery.MODEL_COMPASS.name = "compass generation marker";
        ModelBakery.MODEL_CLOCK.name = "class generation marker";
        ModelBakery.MODEL_ENTITY.name = "block entity marker";
    }
}

