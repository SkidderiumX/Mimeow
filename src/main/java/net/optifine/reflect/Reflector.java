/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.reflect;

import com.google.common.base.Optional;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import javax.vecmath.Matrix4f;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.model.ModelBanner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.model.ModelEnderCrystal;
import net.minecraft.client.model.ModelEnderMite;
import net.minecraft.client.model.ModelGhast;
import net.minecraft.client.model.ModelGuardian;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelLeashKnot;
import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelRabbit;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.model.ModelWither;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.entity.RenderLeashKnot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.tileentity.RenderEnderCrystal;
import net.minecraft.client.renderer.tileentity.RenderItemFrame;
import net.minecraft.client.renderer.tileentity.RenderWitherSkull;
import net.minecraft.client.renderer.tileentity.TileEntityBannerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnchantmentTableRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnderChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelRotation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.Log;
import net.optifine.reflect.FieldLocatorTypes;
import net.optifine.reflect.IResolvable;
import net.optifine.reflect.ReflectorClass;
import net.optifine.reflect.ReflectorConstructor;
import net.optifine.reflect.ReflectorField;
import net.optifine.reflect.ReflectorFields;
import net.optifine.reflect.ReflectorMethod;
import net.optifine.reflect.ReflectorResolver;
import net.optifine.util.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reflector {
    private static final Logger LOGGER = LogManager.getLogger();
    private static boolean logCompat = Reflector.logEntry("*** Optional integrations disabled ***");
    public static ReflectorClass BetterFoliageClient = new ReflectorClass("mods.betterfoliage.client.BetterFoliageClient");
    public static ReflectorClass BlamingTransformer = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod BlamingTransformer_onCrash = new ReflectorMethod(BlamingTransformer, "onCrash");
    public static ReflectorClass ChunkWatchEvent_UnWatch = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor ChunkWatchEvent_UnWatch_Constructor = new ReflectorConstructor(ChunkWatchEvent_UnWatch, new Class[]{ChunkCoordIntPair.class, EntityPlayerMP.class});
    public static ReflectorClass CoreModManager = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod CoreModManager_onCrash = new ReflectorMethod(CoreModManager, "onCrash");
    public static ReflectorClass DimensionManager = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod DimensionManager_createProviderFor = new ReflectorMethod(DimensionManager, "createProviderFor");
    public static ReflectorMethod DimensionManager_getStaticDimensionIDs = new ReflectorMethod(DimensionManager, "getStaticDimensionIDs");
    public static ReflectorClass DrawScreenEvent_Pre = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor DrawScreenEvent_Pre_Constructor = new ReflectorConstructor(DrawScreenEvent_Pre, new Class[]{GuiScreen.class, Integer.TYPE, Integer.TYPE, Float.TYPE});
    public static ReflectorClass DrawScreenEvent_Post = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor DrawScreenEvent_Post_Constructor = new ReflectorConstructor(DrawScreenEvent_Post, new Class[]{GuiScreen.class, Integer.TYPE, Integer.TYPE, Float.TYPE});
    public static ReflectorClass EntityViewRenderEvent_CameraSetup = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor EntityViewRenderEvent_CameraSetup_Constructor = new ReflectorConstructor(EntityViewRenderEvent_CameraSetup, new Class[]{EntityRenderer.class, Entity.class, Block.class, Double.TYPE, Float.TYPE, Float.TYPE, Float.TYPE});
    public static ReflectorField EntityViewRenderEvent_CameraSetup_yaw = new ReflectorField(EntityViewRenderEvent_CameraSetup, "yaw");
    public static ReflectorField EntityViewRenderEvent_CameraSetup_pitch = new ReflectorField(EntityViewRenderEvent_CameraSetup, "pitch");
    public static ReflectorField EntityViewRenderEvent_CameraSetup_roll = new ReflectorField(EntityViewRenderEvent_CameraSetup, "roll");
    public static ReflectorClass EntityViewRenderEvent_FogColors = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor EntityViewRenderEvent_FogColors_Constructor = new ReflectorConstructor(EntityViewRenderEvent_FogColors, new Class[]{EntityRenderer.class, Entity.class, Block.class, Double.TYPE, Float.TYPE, Float.TYPE, Float.TYPE});
    public static ReflectorField EntityViewRenderEvent_FogColors_red = new ReflectorField(EntityViewRenderEvent_FogColors, "red");
    public static ReflectorField EntityViewRenderEvent_FogColors_green = new ReflectorField(EntityViewRenderEvent_FogColors, "green");
    public static ReflectorField EntityViewRenderEvent_FogColors_blue = new ReflectorField(EntityViewRenderEvent_FogColors, "blue");
    public static ReflectorClass Event = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod Event_isCanceled = new ReflectorMethod(Event, "isCanceled");
    public static ReflectorClass EventBus = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod EventBus_post = new ReflectorMethod(EventBus, "post");
    public static ReflectorClass Event_Result = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorField Event_Result_DENY = new ReflectorField(Event_Result, "DENY");
    public static ReflectorField Event_Result_ALLOW = new ReflectorField(Event_Result, "ALLOW");
    public static ReflectorField Event_Result_DEFAULT = new ReflectorField(Event_Result, "DEFAULT");
    public static ReflectorClass ExtendedBlockState = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor ExtendedBlockState_Constructor = new ReflectorConstructor(ExtendedBlockState, new Class[]{Block.class, IProperty[].class, Object[].class});
    public static ReflectorClass OptionalLoaderClientHandler = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod OptionalLoaderClientHandler_instance = new ReflectorMethod(OptionalLoaderClientHandler, "instance");
    public static ReflectorMethod OptionalLoaderClientHandler_handleLoadingScreen = new ReflectorMethod(OptionalLoaderClientHandler, "handleLoadingScreen");
    public static ReflectorMethod OptionalLoaderClientHandler_isLoading = new ReflectorMethod(OptionalLoaderClientHandler, "isLoading");
    public static ReflectorMethod OptionalLoaderClientHandler_trackBrokenTexture = new ReflectorMethod(OptionalLoaderClientHandler, "trackBrokenTexture");
    public static ReflectorMethod OptionalLoaderClientHandler_trackMissingTexture = new ReflectorMethod(OptionalLoaderClientHandler, "trackMissingTexture");
    public static ReflectorClass OptionalLoaderCommonHandler = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod OptionalLoaderCommonHandler_callFuture = new ReflectorMethod(OptionalLoaderCommonHandler, "callFuture");
    public static ReflectorMethod OptionalLoaderCommonHandler_enhanceCrashReport = new ReflectorMethod(OptionalLoaderCommonHandler, "enhanceCrashReport");
    public static ReflectorMethod OptionalLoaderCommonHandler_getBrandings = new ReflectorMethod(OptionalLoaderCommonHandler, "getBrandings");
    public static ReflectorMethod OptionalLoaderCommonHandler_handleServerAboutToStart = new ReflectorMethod(OptionalLoaderCommonHandler, "handleServerAboutToStart");
    public static ReflectorMethod OptionalLoaderCommonHandler_handleServerStarting = new ReflectorMethod(OptionalLoaderCommonHandler, "handleServerStarting");
    public static ReflectorMethod OptionalLoaderCommonHandler_instance = new ReflectorMethod(OptionalLoaderCommonHandler, "instance");
    public static ReflectorClass CompatBiome = new ReflectorClass(BiomeGenBase.class);
    public static ReflectorMethod CompatBiome_getWaterColorMultiplier = new ReflectorMethod(CompatBiome, "getWaterColorMultiplier");
    public static ReflectorClass CompatBlock = new ReflectorClass(Block.class);
    public static ReflectorMethod CompatBlock_addDestroyEffects = new ReflectorMethod(CompatBlock, "addDestroyEffects");
    public static ReflectorMethod CompatBlock_addHitEffects = new ReflectorMethod(CompatBlock, "addHitEffects");
    public static ReflectorMethod CompatBlock_canCreatureSpawn = new ReflectorMethod(CompatBlock, "canCreatureSpawn");
    public static ReflectorMethod CompatBlock_canRenderInLayer = new ReflectorMethod(CompatBlock, "canRenderInLayer", new Class[]{EnumWorldBlockLayer.class});
    public static ReflectorMethod CompatBlock_doesSideBlockRendering = new ReflectorMethod(CompatBlock, "doesSideBlockRendering");
    public static ReflectorMethod CompatBlock_getBedDirection = new ReflectorMethod(CompatBlock, "getBedDirection");
    public static ReflectorMethod CompatBlock_getExtendedState = new ReflectorMethod(CompatBlock, "getExtendedState");
    public static ReflectorMethod CompatBlock_getLightOpacity = new ReflectorMethod(CompatBlock, "getLightOpacity", new Class[]{IBlockAccess.class, BlockPos.class});
    public static ReflectorMethod CompatBlock_getLightValue = new ReflectorMethod(CompatBlock, "getLightValue", new Class[]{IBlockAccess.class, BlockPos.class});
    public static ReflectorMethod CompatBlock_hasTileEntity = new ReflectorMethod(CompatBlock, "hasTileEntity", new Class[]{IBlockState.class});
    public static ReflectorMethod CompatBlock_isAir = new ReflectorMethod(CompatBlock, "isAir");
    public static ReflectorMethod CompatBlock_isBed = new ReflectorMethod(CompatBlock, "isBed");
    public static ReflectorMethod CompatBlock_isBedFoot = new ReflectorMethod(CompatBlock, "isBedFoot");
    public static ReflectorMethod CompatBlock_isSideSolid = new ReflectorMethod(CompatBlock, "isSideSolid");
    public static ReflectorClass CompatChunkCache = new ReflectorClass(ChunkCache.class);
    public static ReflectorMethod CompatChunkCache_isSideSolid = new ReflectorMethod(CompatChunkCache, "isSideSolid");
    public static ReflectorClass CompatEntity = new ReflectorClass(Entity.class);
    public static ReflectorMethod CompatEntity_canRiderInteract = new ReflectorMethod(CompatEntity, "canRiderInteract");
    public static ReflectorField CompatEntity_captureDrops = new ReflectorField(CompatEntity, "captureDrops");
    public static ReflectorField CompatEntity_capturedDrops = new ReflectorField(CompatEntity, "capturedDrops");
    public static ReflectorMethod CompatEntity_shouldRenderInPass = new ReflectorMethod(CompatEntity, "shouldRenderInPass");
    public static ReflectorMethod CompatEntity_shouldRiderSit = new ReflectorMethod(CompatEntity, "shouldRiderSit");
    public static ReflectorClass CompatEventFactory = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod CompatEventFactory_canEntityDespawn = new ReflectorMethod(CompatEventFactory, "canEntityDespawn");
    public static ReflectorMethod CompatEventFactory_canEntitySpawn = new ReflectorMethod(CompatEventFactory, "canEntitySpawn");
    public static ReflectorMethod CompatEventFactory_doSpecialSpawn = new ReflectorMethod(CompatEventFactory, "doSpecialSpawn", new Class[]{EntityLiving.class, World.class, Float.TYPE, Float.TYPE, Float.TYPE});
    public static ReflectorMethod CompatEventFactory_getMaxSpawnPackSize = new ReflectorMethod(CompatEventFactory, "getMaxSpawnPackSize");
    public static ReflectorMethod CompatEventFactory_renderBlockOverlay = new ReflectorMethod(CompatEventFactory, "renderBlockOverlay");
    public static ReflectorMethod CompatEventFactory_renderFireOverlay = new ReflectorMethod(CompatEventFactory, "renderFireOverlay");
    public static ReflectorMethod CompatEventFactory_renderWaterOverlay = new ReflectorMethod(CompatEventFactory, "renderWaterOverlay");
    public static ReflectorClass CompatHooks = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod CompatHooks_onLivingAttack = new ReflectorMethod(CompatHooks, "onLivingAttack");
    public static ReflectorMethod CompatHooks_onLivingDeath = new ReflectorMethod(CompatHooks, "onLivingDeath");
    public static ReflectorMethod CompatHooks_onLivingDrops = new ReflectorMethod(CompatHooks, "onLivingDrops");
    public static ReflectorMethod CompatHooks_onLivingFall = new ReflectorMethod(CompatHooks, "onLivingFall");
    public static ReflectorMethod CompatHooks_onLivingHurt = new ReflectorMethod(CompatHooks, "onLivingHurt");
    public static ReflectorMethod CompatHooks_onLivingJump = new ReflectorMethod(CompatHooks, "onLivingJump");
    public static ReflectorMethod CompatHooks_onLivingSetAttackTarget = new ReflectorMethod(CompatHooks, "onLivingSetAttackTarget");
    public static ReflectorMethod CompatHooks_onLivingUpdate = new ReflectorMethod(CompatHooks, "onLivingUpdate");
    public static ReflectorClass CompatHooksClient = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod CompatHooksClient_applyTransform = new ReflectorMethod(CompatHooksClient, "applyTransform", new Class[]{Matrix4f.class, Optional.class});
    public static ReflectorMethod CompatHooksClient_dispatchRenderLast = new ReflectorMethod(CompatHooksClient, "dispatchRenderLast");
    public static ReflectorMethod CompatHooksClient_drawScreen = new ReflectorMethod(CompatHooksClient, "drawScreen");
    public static ReflectorMethod CompatHooksClient_fillNormal = new ReflectorMethod(CompatHooksClient, "fillNormal");
    public static ReflectorMethod CompatHooksClient_handleCameraTransforms = new ReflectorMethod(CompatHooksClient, "handleCameraTransforms");
    public static ReflectorMethod CompatHooksClient_getArmorModel = new ReflectorMethod(CompatHooksClient, "getArmorModel");
    public static ReflectorMethod CompatHooksClient_getArmorTexture = new ReflectorMethod(CompatHooksClient, "getArmorTexture");
    public static ReflectorMethod CompatHooksClient_getFogDensity = new ReflectorMethod(CompatHooksClient, "getFogDensity");
    public static ReflectorMethod CompatHooksClient_getFOVModifier = new ReflectorMethod(CompatHooksClient, "getFOVModifier");
    public static ReflectorMethod CompatHooksClient_getMatrix = new ReflectorMethod(CompatHooksClient, "getMatrix", new Class[]{ModelRotation.class});
    public static ReflectorMethod CompatHooksClient_getOffsetFOV = new ReflectorMethod(CompatHooksClient, "getOffsetFOV");
    public static ReflectorMethod CompatHooksClient_loadEntityShader = new ReflectorMethod(CompatHooksClient, "loadEntityShader");
    public static ReflectorMethod CompatHooksClient_onDrawBlockHighlight = new ReflectorMethod(CompatHooksClient, "onDrawBlockHighlight");
    public static ReflectorMethod CompatHooksClient_onFogRender = new ReflectorMethod(CompatHooksClient, "onFogRender");
    public static ReflectorMethod CompatHooksClient_onTextureStitchedPre = new ReflectorMethod(CompatHooksClient, "onTextureStitchedPre");
    public static ReflectorMethod CompatHooksClient_onTextureStitchedPost = new ReflectorMethod(CompatHooksClient, "onTextureStitchedPost");
    public static ReflectorMethod CompatHooksClient_orientBedCamera = new ReflectorMethod(CompatHooksClient, "orientBedCamera");
    public static ReflectorMethod CompatHooksClient_putQuadColor = new ReflectorMethod(CompatHooksClient, "putQuadColor");
    public static ReflectorMethod CompatHooksClient_renderFirstPersonHand = new ReflectorMethod(CompatHooksClient, "renderFirstPersonHand");
    public static ReflectorMethod CompatHooksClient_renderMainMenu = new ReflectorMethod(CompatHooksClient, "renderMainMenu");
    public static ReflectorMethod CompatHooksClient_setRenderLayer = new ReflectorMethod(CompatHooksClient, "setRenderLayer");
    public static ReflectorMethod CompatHooksClient_setRenderPass = new ReflectorMethod(CompatHooksClient, "setRenderPass");
    public static ReflectorMethod CompatHooksClient_transform = new ReflectorMethod(CompatHooksClient, "transform");
    public static ReflectorClass CompatItem = new ReflectorClass(Item.class);
    public static ReflectorField CompatItem_delegate = new ReflectorField(CompatItem, "delegate");
    public static ReflectorMethod CompatItem_getDurabilityForDisplay = new ReflectorMethod(CompatItem, "getDurabilityForDisplay");
    public static ReflectorMethod CompatItem_getModel = new ReflectorMethod(CompatItem, "getModel");
    public static ReflectorMethod CompatItem_onEntitySwing = new ReflectorMethod(CompatItem, "onEntitySwing");
    public static ReflectorMethod CompatItem_shouldCauseReequipAnimation = new ReflectorMethod(CompatItem, "shouldCauseReequipAnimation");
    public static ReflectorMethod CompatItem_showDurabilityBar = new ReflectorMethod(CompatItem, "showDurabilityBar");
    public static ReflectorClass CompatModContainer = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorField CompatModContainer_compatLightPipelineEnabled = new ReflectorField(CompatModContainer, "compatLightPipelineEnabled");
    public static ReflectorClass CompatPotionEffect = new ReflectorClass(PotionEffect.class);
    public static ReflectorMethod CompatPotionEffect_isCurativeItem = new ReflectorMethod(CompatPotionEffect, "isCurativeItem");
    public static ReflectorClass CompatTileEntity = new ReflectorClass(TileEntity.class);
    public static ReflectorMethod CompatTileEntity_canRenderBreaking = new ReflectorMethod(CompatTileEntity, "canRenderBreaking");
    public static ReflectorMethod CompatTileEntity_getRenderBoundingBox = new ReflectorMethod(CompatTileEntity, "getRenderBoundingBox");
    public static ReflectorMethod CompatTileEntity_hasFastRenderer = new ReflectorMethod(CompatTileEntity, "hasFastRenderer");
    public static ReflectorMethod CompatTileEntity_shouldRenderInPass = new ReflectorMethod(CompatTileEntity, "shouldRenderInPass");
    public static ReflectorClass CompatVertexFormatElementEnumUseage = new ReflectorClass(VertexFormatElement.EnumUsage.class);
    public static ReflectorMethod CompatVertexFormatElementEnumUseage_preDraw = new ReflectorMethod(CompatVertexFormatElementEnumUseage, "preDraw");
    public static ReflectorMethod CompatVertexFormatElementEnumUseage_postDraw = new ReflectorMethod(CompatVertexFormatElementEnumUseage, "postDraw");
    public static ReflectorClass CompatWorld = new ReflectorClass(World.class);
    public static ReflectorMethod CompatWorld_countEntities = new ReflectorMethod(CompatWorld, "countEntities", new Class[]{EnumCreatureType.class, Boolean.TYPE});
    public static ReflectorMethod CompatWorld_getPerWorldStorage = new ReflectorMethod(CompatWorld, "getPerWorldStorage");
    public static ReflectorClass CompatWorldProvider = new ReflectorClass(WorldProvider.class);
    public static ReflectorMethod CompatWorldProvider_getCloudRenderer = new ReflectorMethod(CompatWorldProvider, "getCloudRenderer");
    public static ReflectorMethod CompatWorldProvider_getSkyRenderer = new ReflectorMethod(CompatWorldProvider, "getSkyRenderer");
    public static ReflectorMethod CompatWorldProvider_getWeatherRenderer = new ReflectorMethod(CompatWorldProvider, "getWeatherRenderer");
    public static ReflectorMethod CompatWorldProvider_getSaveFolder = new ReflectorMethod(CompatWorldProvider, "getSaveFolder");
    public static ReflectorClass GuiModList = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor GuiModList_Constructor = new ReflectorConstructor(GuiModList, new Class[]{GuiScreen.class});
    public static ReflectorClass IColoredBakedQuad = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorClass IExtendedBlockState = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod IExtendedBlockState_getClean = new ReflectorMethod(IExtendedBlockState, "getClean");
    public static ReflectorClass IModel = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod IModel_getTextures = new ReflectorMethod(IModel, "getTextures");
    public static ReflectorClass IRenderHandler = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod IRenderHandler_render = new ReflectorMethod(IRenderHandler, "render");
    public static ReflectorClass ItemModelMesherCompat = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor ItemModelMesherCompat_Constructor = new ReflectorConstructor(ItemModelMesherCompat, new Class[]{ModelManager.class});
    public static ReflectorClass Launch = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorField Launch_blackboard = new ReflectorField(Launch, "blackboard");
    public static ReflectorClass LightUtil = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorField LightUtil_itemConsumer = new ReflectorField(LightUtil, "itemConsumer");
    public static ReflectorMethod LightUtil_putBakedQuad = new ReflectorMethod(LightUtil, "putBakedQuad");
    public static ReflectorMethod LightUtil_renderQuadColor = new ReflectorMethod(LightUtil, "renderQuadColor");
    public static ReflectorField LightUtil_tessellator = new ReflectorField(LightUtil, "tessellator");
    public static ReflectorClass Loader = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod Loader_getActiveModList = new ReflectorMethod(Loader, "getActiveModList");
    public static ReflectorMethod Loader_instance = new ReflectorMethod(Loader, "instance");
    public static ReflectorClass MinecraftCompat = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorField MinecraftCompat_EVENT_BUS = new ReflectorField(MinecraftCompat, "EVENT_BUS");
    public static ReflectorClass MinecraftCompatClient = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod MinecraftCompatClient_getRenderPass = new ReflectorMethod(MinecraftCompatClient, "getRenderPass");
    public static ReflectorMethod MinecraftCompatClient_onRebuildChunk = new ReflectorMethod(MinecraftCompatClient, "onRebuildChunk");
    public static ReflectorClass ModContainer = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod ModContainer_getModId = new ReflectorMethod(ModContainer, "getModId");
    public static ReflectorClass ModelLoader = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorField ModelLoader_stateModels = new ReflectorField(ModelLoader, "stateModels");
    public static ReflectorMethod ModelLoader_onRegisterItems = new ReflectorMethod(ModelLoader, "onRegisterItems");
    public static ReflectorMethod ModelLoader_getInventoryVariant = new ReflectorMethod(ModelLoader, "getInventoryVariant");
    public static ReflectorField ModelLoader_textures = new ReflectorField(ModelLoader, "textures");
    public static ReflectorClass ModelLoader_VanillaLoader = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorField ModelLoader_VanillaLoader_INSTANCE = new ReflectorField(ModelLoader_VanillaLoader, "instance");
    public static ReflectorMethod ModelLoader_VanillaLoader_loadModel = new ReflectorMethod(ModelLoader_VanillaLoader, "loadModel");
    public static ReflectorClass RenderBlockOverlayEvent_OverlayType = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorField RenderBlockOverlayEvent_OverlayType_BLOCK = new ReflectorField(RenderBlockOverlayEvent_OverlayType, "BLOCK");
    public static ReflectorClass RenderingRegistry = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorMethod RenderingRegistry_loadEntityRenderers = new ReflectorMethod(RenderingRegistry, "loadEntityRenderers", new Class[]{RenderManager.class, Map.class});
    public static ReflectorClass RenderItemInFrameEvent = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor RenderItemInFrameEvent_Constructor = new ReflectorConstructor(RenderItemInFrameEvent, new Class[]{EntityItemFrame.class, RenderItemFrame.class});
    public static ReflectorClass RenderLivingEvent_Pre = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor RenderLivingEvent_Pre_Constructor = new ReflectorConstructor(RenderLivingEvent_Pre, new Class[]{EntityLivingBase.class, RendererLivingEntity.class, Double.TYPE, Double.TYPE, Double.TYPE});
    public static ReflectorClass RenderLivingEvent_Post = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor RenderLivingEvent_Post_Constructor = new ReflectorConstructor(RenderLivingEvent_Post, new Class[]{EntityLivingBase.class, RendererLivingEntity.class, Double.TYPE, Double.TYPE, Double.TYPE});
    public static ReflectorClass RenderLivingEvent_Specials_Pre = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor RenderLivingEvent_Specials_Pre_Constructor = new ReflectorConstructor(RenderLivingEvent_Specials_Pre, new Class[]{EntityLivingBase.class, RendererLivingEntity.class, Double.TYPE, Double.TYPE, Double.TYPE});
    public static ReflectorClass RenderLivingEvent_Specials_Post = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor RenderLivingEvent_Specials_Post_Constructor = new ReflectorConstructor(RenderLivingEvent_Specials_Post, new Class[]{EntityLivingBase.class, RendererLivingEntity.class, Double.TYPE, Double.TYPE, Double.TYPE});
    public static ReflectorClass SplashScreen = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorClass WorldEvent_Load = new ReflectorClass("net.optifine.compat.DisabledIntegration");
    public static ReflectorConstructor WorldEvent_Load_Constructor = new ReflectorConstructor(WorldEvent_Load, new Class[]{World.class});
    private static boolean logVanilla = Reflector.logEntry("*** Reflector Vanilla ***");
    public static ReflectorClass ChunkProviderClient = new ReflectorClass(ChunkProviderClient.class);
    public static ReflectorField ChunkProviderClient_chunkMapping = new ReflectorField(ChunkProviderClient, LongHashMap.class);
    public static ReflectorClass EntityVillager = new ReflectorClass(EntityVillager.class);
    public static ReflectorField EntityVillager_careerId = new ReflectorField(new FieldLocatorTypes(EntityVillager.class, new Class[0], Integer.TYPE, new Class[]{Integer.TYPE, Boolean.TYPE, Boolean.TYPE, InventoryBasic.class}, "EntityVillager.careerId"));
    public static ReflectorField EntityVillager_careerLevel = new ReflectorField(new FieldLocatorTypes(EntityVillager.class, new Class[]{Integer.TYPE}, Integer.TYPE, new Class[]{Boolean.TYPE, Boolean.TYPE, InventoryBasic.class}, "EntityVillager.careerLevel"));
    public static ReflectorClass GuiBeacon = new ReflectorClass(GuiBeacon.class);
    public static ReflectorField GuiBeacon_tileBeacon = new ReflectorField(GuiBeacon, IInventory.class);
    public static ReflectorClass GuiBrewingStand = new ReflectorClass(GuiBrewingStand.class);
    public static ReflectorField GuiBrewingStand_tileBrewingStand = new ReflectorField(GuiBrewingStand, IInventory.class);
    public static ReflectorClass GuiChest = new ReflectorClass(GuiChest.class);
    public static ReflectorField GuiChest_lowerChestInventory = new ReflectorField(GuiChest, IInventory.class, 1);
    public static ReflectorClass GuiEnchantment = new ReflectorClass(GuiEnchantment.class);
    public static ReflectorField GuiEnchantment_nameable = new ReflectorField(GuiEnchantment, IWorldNameable.class);
    public static ReflectorClass GuiFurnace = new ReflectorClass(GuiFurnace.class);
    public static ReflectorField GuiFurnace_tileFurnace = new ReflectorField(GuiFurnace, IInventory.class);
    public static ReflectorClass GuiHopper = new ReflectorClass(GuiHopper.class);
    public static ReflectorField GuiHopper_hopperInventory = new ReflectorField(GuiHopper, IInventory.class, 1);
    public static ReflectorClass GuiMainMenu = new ReflectorClass(GuiMainMenu.class);
    public static ReflectorField GuiMainMenu_splashText = new ReflectorField(GuiMainMenu, String.class);
    public static ReflectorClass Minecraft = new ReflectorClass(Minecraft.class);
    public static ReflectorField Minecraft_defaultResourcePack = new ReflectorField(Minecraft, DefaultResourcePack.class);
    public static ReflectorClass ModelHumanoidHead = new ReflectorClass(ModelHumanoidHead.class);
    public static ReflectorField ModelHumanoidHead_head = new ReflectorField(ModelHumanoidHead, ModelRenderer.class);
    public static ReflectorClass ModelBat = new ReflectorClass(ModelBat.class);
    public static ReflectorFields ModelBat_ModelRenderers = new ReflectorFields(ModelBat, ModelRenderer.class, 6);
    public static ReflectorClass ModelBlaze = new ReflectorClass(ModelBlaze.class);
    public static ReflectorField ModelBlaze_blazeHead = new ReflectorField(ModelBlaze, ModelRenderer.class);
    public static ReflectorField ModelBlaze_blazeSticks = new ReflectorField(ModelBlaze, ModelRenderer[].class);
    public static ReflectorClass ModelBlock = new ReflectorClass(ModelBlock.class);
    public static ReflectorField ModelBlock_parentLocation = new ReflectorField(ModelBlock, ResourceLocation.class);
    public static ReflectorField ModelBlock_textures = new ReflectorField(ModelBlock, Map.class);
    public static ReflectorClass ModelDragon = new ReflectorClass(ModelDragon.class);
    public static ReflectorFields ModelDragon_ModelRenderers = new ReflectorFields(ModelDragon, ModelRenderer.class, 12);
    public static ReflectorClass ModelEnderCrystal = new ReflectorClass(ModelEnderCrystal.class);
    public static ReflectorFields ModelEnderCrystal_ModelRenderers = new ReflectorFields(ModelEnderCrystal, ModelRenderer.class, 3);
    public static ReflectorClass RenderEnderCrystal = new ReflectorClass(RenderEnderCrystal.class);
    public static ReflectorField RenderEnderCrystal_modelEnderCrystal = new ReflectorField(RenderEnderCrystal, ModelBase.class, 0);
    public static ReflectorClass ModelEnderMite = new ReflectorClass(ModelEnderMite.class);
    public static ReflectorField ModelEnderMite_bodyParts = new ReflectorField(ModelEnderMite, ModelRenderer[].class);
    public static ReflectorClass ModelGhast = new ReflectorClass(ModelGhast.class);
    public static ReflectorField ModelGhast_body = new ReflectorField(ModelGhast, ModelRenderer.class);
    public static ReflectorField ModelGhast_tentacles = new ReflectorField(ModelGhast, ModelRenderer[].class);
    public static ReflectorClass ModelGuardian = new ReflectorClass(ModelGuardian.class);
    public static ReflectorField ModelGuardian_body = new ReflectorField(ModelGuardian, ModelRenderer.class, 0);
    public static ReflectorField ModelGuardian_eye = new ReflectorField(ModelGuardian, ModelRenderer.class, 1);
    public static ReflectorField ModelGuardian_spines = new ReflectorField(ModelGuardian, ModelRenderer[].class, 0);
    public static ReflectorField ModelGuardian_tail = new ReflectorField(ModelGuardian, ModelRenderer[].class, 1);
    public static ReflectorClass ModelHorse = new ReflectorClass(ModelHorse.class);
    public static ReflectorFields ModelHorse_ModelRenderers = new ReflectorFields(ModelHorse, ModelRenderer.class, 39);
    public static ReflectorClass RenderLeashKnot = new ReflectorClass(RenderLeashKnot.class);
    public static ReflectorField RenderLeashKnot_leashKnotModel = new ReflectorField(RenderLeashKnot, ModelLeashKnot.class);
    public static ReflectorClass ModelMagmaCube = new ReflectorClass(ModelMagmaCube.class);
    public static ReflectorField ModelMagmaCube_core = new ReflectorField(ModelMagmaCube, ModelRenderer.class);
    public static ReflectorField ModelMagmaCube_segments = new ReflectorField(ModelMagmaCube, ModelRenderer[].class);
    public static ReflectorClass ModelOcelot = new ReflectorClass(ModelOcelot.class);
    public static ReflectorFields ModelOcelot_ModelRenderers = new ReflectorFields(ModelOcelot, ModelRenderer.class, 8);
    public static ReflectorClass ModelRabbit = new ReflectorClass(ModelRabbit.class);
    public static ReflectorFields ModelRabbit_renderers = new ReflectorFields(ModelRabbit, ModelRenderer.class, 12);
    public static ReflectorClass ModelSilverfish = new ReflectorClass(ModelSilverfish.class);
    public static ReflectorField ModelSilverfish_bodyParts = new ReflectorField(ModelSilverfish, ModelRenderer[].class, 0);
    public static ReflectorField ModelSilverfish_wingParts = new ReflectorField(ModelSilverfish, ModelRenderer[].class, 1);
    public static ReflectorClass ModelSlime = new ReflectorClass(ModelSlime.class);
    public static ReflectorFields ModelSlime_ModelRenderers = new ReflectorFields(ModelSlime, ModelRenderer.class, 4);
    public static ReflectorClass ModelSquid = new ReflectorClass(ModelSquid.class);
    public static ReflectorField ModelSquid_body = new ReflectorField(ModelSquid, ModelRenderer.class);
    public static ReflectorField ModelSquid_tentacles = new ReflectorField(ModelSquid, ModelRenderer[].class);
    public static ReflectorClass ModelWitch = new ReflectorClass(ModelWitch.class);
    public static ReflectorField ModelWitch_mole = new ReflectorField(ModelWitch, ModelRenderer.class, 0);
    public static ReflectorField ModelWitch_hat = new ReflectorField(ModelWitch, ModelRenderer.class, 1);
    public static ReflectorClass ModelWither = new ReflectorClass(ModelWither.class);
    public static ReflectorField ModelWither_bodyParts = new ReflectorField(ModelWither, ModelRenderer[].class, 0);
    public static ReflectorField ModelWither_heads = new ReflectorField(ModelWither, ModelRenderer[].class, 1);
    public static ReflectorClass ModelWolf = new ReflectorClass(ModelWolf.class);
    public static ReflectorField ModelWolf_tail = new ReflectorField(ModelWolf, ModelRenderer.class, 6);
    public static ReflectorField ModelWolf_mane = new ReflectorField(ModelWolf, ModelRenderer.class, 7);
    public static ReflectorClass OptiFineClassTransformer = new ReflectorClass("optifine.OptiFineClassTransformer");
    public static ReflectorField OptiFineClassTransformer_instance = new ReflectorField(OptiFineClassTransformer, "instance");
    public static ReflectorMethod OptiFineClassTransformer_getOptiFineResource = new ReflectorMethod(OptiFineClassTransformer, "getOptiFineResource");
    public static ReflectorClass RenderBoat = new ReflectorClass(RenderBoat.class);
    public static ReflectorField RenderBoat_modelBoat = new ReflectorField(RenderBoat, ModelBase.class);
    public static ReflectorClass RenderMinecart = new ReflectorClass(RenderMinecart.class);
    public static ReflectorField RenderMinecart_modelMinecart = new ReflectorField(RenderMinecart, ModelBase.class);
    public static ReflectorClass RenderWitherSkull = new ReflectorClass(RenderWitherSkull.class);
    public static ReflectorField RenderWitherSkull_model = new ReflectorField(RenderWitherSkull, ModelSkeletonHead.class);
    public static ReflectorClass TileEntityBannerRenderer = new ReflectorClass(TileEntityBannerRenderer.class);
    public static ReflectorField TileEntityBannerRenderer_bannerModel = new ReflectorField(TileEntityBannerRenderer, ModelBanner.class);
    public static ReflectorClass TileEntityBeacon = new ReflectorClass(TileEntityBeacon.class);
    public static ReflectorField TileEntityBeacon_customName = new ReflectorField(TileEntityBeacon, String.class);
    public static ReflectorClass TileEntityBrewingStand = new ReflectorClass(TileEntityBrewingStand.class);
    public static ReflectorField TileEntityBrewingStand_customName = new ReflectorField(TileEntityBrewingStand, String.class);
    public static ReflectorClass TileEntityChestRenderer = new ReflectorClass(TileEntityChestRenderer.class);
    public static ReflectorField TileEntityChestRenderer_simpleChest = new ReflectorField(TileEntityChestRenderer, ModelChest.class, 0);
    public static ReflectorField TileEntityChestRenderer_largeChest = new ReflectorField(TileEntityChestRenderer, ModelChest.class, 1);
    public static ReflectorClass TileEntityEnchantmentTable = new ReflectorClass(TileEntityEnchantmentTable.class);
    public static ReflectorField TileEntityEnchantmentTable_customName = new ReflectorField(TileEntityEnchantmentTable, String.class);
    public static ReflectorClass TileEntityEnchantmentTableRenderer = new ReflectorClass(TileEntityEnchantmentTableRenderer.class);
    public static ReflectorField TileEntityEnchantmentTableRenderer_modelBook = new ReflectorField(TileEntityEnchantmentTableRenderer, ModelBook.class);
    public static ReflectorClass TileEntityEnderChestRenderer = new ReflectorClass(TileEntityEnderChestRenderer.class);
    public static ReflectorField TileEntityEnderChestRenderer_modelChest = new ReflectorField(TileEntityEnderChestRenderer, ModelChest.class);
    public static ReflectorClass TileEntityFurnace = new ReflectorClass(TileEntityFurnace.class);
    public static ReflectorField TileEntityFurnace_customName = new ReflectorField(TileEntityFurnace, String.class);
    public static ReflectorClass TileEntitySignRenderer = new ReflectorClass(TileEntitySignRenderer.class);
    public static ReflectorField TileEntitySignRenderer_model = new ReflectorField(TileEntitySignRenderer, ModelSign.class);
    public static ReflectorClass TileEntitySkullRenderer = new ReflectorClass(TileEntitySkullRenderer.class);
    public static ReflectorField TileEntitySkullRenderer_skeletonHead = new ReflectorField(TileEntitySkullRenderer, ModelSkeletonHead.class, 0);
    public static ReflectorField TileEntitySkullRenderer_humanoidHead = new ReflectorField(TileEntitySkullRenderer, ModelSkeletonHead.class, 1);

    public static void callVoid(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return;
            }
            method.invoke(null, objectArray);
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
        }
    }

    public static boolean callBoolean(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return false;
            }
            Boolean bl = (Boolean)method.invoke(null, objectArray);
            return bl;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return false;
        }
    }

    public static int callInt(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0;
            }
            Integer n = (Integer)method.invoke(null, objectArray);
            return n;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return 0;
        }
    }

    public static float callFloat(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0.0f;
            }
            Float f = (Float)method.invoke(null, objectArray);
            return f.floatValue();
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return 0.0f;
        }
    }

    public static double callDouble(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0.0;
            }
            Double d = (Double)method.invoke(null, objectArray);
            return d;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return 0.0;
        }
    }

    public static String callString(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return null;
            }
            String string = (String)method.invoke(null, objectArray);
            return string;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return null;
        }
    }

    public static Object call(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return null;
            }
            Object object = method.invoke(null, objectArray);
            return object;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return null;
        }
    }

    public static void callVoid(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            if (object == null) {
                return;
            }
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return;
            }
            method.invoke(object, objectArray);
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
        }
    }

    public static boolean callBoolean(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return false;
            }
            Boolean bl = (Boolean)method.invoke(object, objectArray);
            return bl;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return false;
        }
    }

    public static int callInt(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0;
            }
            Integer n = (Integer)method.invoke(object, objectArray);
            return n;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return 0;
        }
    }

    public static float callFloat(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0.0f;
            }
            Float f = (Float)method.invoke(object, objectArray);
            return f.floatValue();
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return 0.0f;
        }
    }

    public static double callDouble(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0.0;
            }
            Double d = (Double)method.invoke(object, objectArray);
            return d;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return 0.0;
        }
    }

    public static String callString(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return null;
            }
            String string = (String)method.invoke(object, objectArray);
            return string;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return null;
        }
    }

    public static Object call(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return null;
            }
            Object object2 = method.invoke(object, objectArray);
            return object2;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return null;
        }
    }

    public static Object getFieldValue(ReflectorField reflectorField) {
        return Reflector.getFieldValue(null, reflectorField);
    }

    public static Object getFieldValue(Object object, ReflectorField reflectorField) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return null;
            }
            Object object2 = field.get(object);
            return object2;
        }
        catch (Throwable throwable) {
            Log.error("", throwable);
            return null;
        }
    }

    public static boolean getFieldValueBoolean(ReflectorField reflectorField, boolean bl) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return bl;
            }
            boolean bl2 = field.getBoolean(null);
            return bl2;
        }
        catch (Throwable throwable) {
            Log.error("", throwable);
            return bl;
        }
    }

    public static boolean getFieldValueBoolean(Object object, ReflectorField reflectorField, boolean bl) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return bl;
            }
            boolean bl2 = field.getBoolean(object);
            return bl2;
        }
        catch (Throwable throwable) {
            Log.error("", throwable);
            return bl;
        }
    }

    public static Object getFieldValue(ReflectorFields reflectorFields, int n) {
        ReflectorField reflectorField = reflectorFields.getReflectorField(n);
        return reflectorField == null ? null : Reflector.getFieldValue(reflectorField);
    }

    public static Object getFieldValue(Object object, ReflectorFields reflectorFields, int n) {
        ReflectorField reflectorField = reflectorFields.getReflectorField(n);
        return reflectorField == null ? null : Reflector.getFieldValue(object, reflectorField);
    }

    public static float getFieldValueFloat(Object object, ReflectorField reflectorField, float f) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return f;
            }
            float f2 = field.getFloat(object);
            return f2;
        }
        catch (Throwable throwable) {
            Log.error("", throwable);
            return f;
        }
    }

    public static int getFieldValueInt(Object object, ReflectorField reflectorField, int n) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return n;
            }
            int n2 = field.getInt(object);
            return n2;
        }
        catch (Throwable throwable) {
            Log.error("", throwable);
            return n;
        }
    }

    public static long getFieldValueLong(Object object, ReflectorField reflectorField, long l) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return l;
            }
            long l2 = field.getLong(object);
            return l2;
        }
        catch (Throwable throwable) {
            Log.error("", throwable);
            return l;
        }
    }

    public static boolean setFieldValue(ReflectorField reflectorField, Object object) {
        return Reflector.setFieldValue(null, reflectorField, object);
    }

    public static boolean setFieldValue(Object object, ReflectorField reflectorField, Object object2) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return false;
            }
            field.set(object, object2);
            return true;
        }
        catch (Throwable throwable) {
            Log.error("", throwable);
            return false;
        }
    }

    public static boolean setFieldValueInt(ReflectorField reflectorField, int n) {
        return Reflector.setFieldValueInt(null, reflectorField, n);
    }

    public static boolean setFieldValueInt(Object object, ReflectorField reflectorField, int n) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return false;
            }
            field.setInt(object, n);
            return true;
        }
        catch (Throwable throwable) {
            Log.error("", throwable);
            return false;
        }
    }

    public static boolean postCompatBusEvent(ReflectorConstructor reflectorConstructor, Object ... objectArray) {
        Object object = Reflector.newInstance(reflectorConstructor, objectArray);
        return object == null ? false : Reflector.postCompatBusEvent(object);
    }

    public static boolean postCompatBusEvent(Object object) {
        if (object == null) {
            return false;
        }
        Object object2 = Reflector.getFieldValue(MinecraftCompat_EVENT_BUS);
        if (object2 == null) {
            return false;
        }
        Object object3 = Reflector.call(object2, EventBus_post, object);
        if (!(object3 instanceof Boolean)) {
            return false;
        }
        Boolean bl = (Boolean)object3;
        return bl;
    }

    public static Object newInstance(ReflectorConstructor reflectorConstructor, Object ... objectArray) {
        Constructor constructor = reflectorConstructor.getTargetConstructor();
        if (constructor == null) {
            return null;
        }
        try {
            Object t = constructor.newInstance(objectArray);
            return t;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, reflectorConstructor, objectArray);
            return null;
        }
    }

    public static boolean matchesTypes(Class[] classArray, Class[] classArray2) {
        if (classArray.length != classArray2.length) {
            return false;
        }
        for (int i = 0; i < classArray2.length; ++i) {
            Class clazz = classArray[i];
            Class clazz2 = classArray2[i];
            if (clazz == clazz2) continue;
            return false;
        }
        return true;
    }

    private static void dbgCall(boolean bl, String string, ReflectorMethod reflectorMethod, Object[] objectArray, Object object) {
        String string2 = reflectorMethod.getTargetMethod().getDeclaringClass().getName();
        String string3 = reflectorMethod.getTargetMethod().getName();
        String string4 = "";
        if (bl) {
            string4 = " static";
        }
        Log.dbg(string + string4 + " " + string2 + "." + string3 + "(" + ArrayUtils.arrayToString(objectArray) + ") => " + String.valueOf(object));
    }

    private static void dbgCallVoid(boolean bl, String string, ReflectorMethod reflectorMethod, Object[] objectArray) {
        String string2 = reflectorMethod.getTargetMethod().getDeclaringClass().getName();
        String string3 = reflectorMethod.getTargetMethod().getName();
        String string4 = "";
        if (bl) {
            string4 = " static";
        }
        Log.dbg(string + string4 + " " + string2 + "." + string3 + "(" + ArrayUtils.arrayToString(objectArray) + ")");
    }

    private static void dbgFieldValue(boolean bl, String string, ReflectorField reflectorField, Object object) {
        String string2 = reflectorField.getTargetField().getDeclaringClass().getName();
        String string3 = reflectorField.getTargetField().getName();
        String string4 = "";
        if (bl) {
            string4 = " static";
        }
        Log.dbg(string + string4 + " " + string2 + "." + string3 + " => " + String.valueOf(object));
    }

    private static void handleException(Throwable throwable, Object object, ReflectorMethod reflectorMethod, Object[] objectArray) {
        if (throwable instanceof InvocationTargetException) {
            Throwable throwable2 = throwable.getCause();
            if (throwable2 instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException)throwable2;
                throw runtimeException;
            }
            Log.error("", throwable);
        } else {
            Log.warn("*** Exception outside of method ***");
            Log.warn("Method deactivated: " + String.valueOf(reflectorMethod.getTargetMethod()));
            reflectorMethod.deactivate();
            if (throwable instanceof IllegalArgumentException) {
                Log.warn("*** IllegalArgumentException ***");
                Log.warn("Method: " + String.valueOf(reflectorMethod.getTargetMethod()));
                Log.warn("Object: " + String.valueOf(object));
                Log.warn("Parameter classes: " + ArrayUtils.arrayToString(Reflector.getClasses(objectArray)));
                Log.warn("Parameters: " + ArrayUtils.arrayToString(objectArray));
            }
            Log.warn("", throwable);
        }
    }

    private static void handleException(Throwable throwable, ReflectorConstructor reflectorConstructor, Object[] objectArray) {
        if (throwable instanceof InvocationTargetException) {
            Log.error("", throwable);
        } else {
            Log.warn("*** Exception outside of constructor ***");
            Log.warn("Constructor deactivated: " + String.valueOf(reflectorConstructor.getTargetConstructor()));
            reflectorConstructor.deactivate();
            if (throwable instanceof IllegalArgumentException) {
                Log.warn("*** IllegalArgumentException ***");
                Log.warn("Constructor: " + String.valueOf(reflectorConstructor.getTargetConstructor()));
                Log.warn("Parameter classes: " + ArrayUtils.arrayToString(Reflector.getClasses(objectArray)));
                Log.warn("Parameters: " + ArrayUtils.arrayToString(objectArray));
            }
            Log.warn("", throwable);
        }
    }

    private static Object[] getClasses(Object[] objectArray) {
        if (objectArray == null) {
            return new Class[0];
        }
        Object[] objectArray2 = new Class[objectArray.length];
        for (int i = 0; i < objectArray2.length; ++i) {
            Object object = objectArray[i];
            if (object == null) continue;
            objectArray2[i] = object.getClass();
        }
        return objectArray2;
    }

    private static ReflectorField[] getReflectorFields(ReflectorClass reflectorClass, Class clazz, int n) {
        ReflectorField[] reflectorFieldArray = new ReflectorField[n];
        for (int i = 0; i < reflectorFieldArray.length; ++i) {
            reflectorFieldArray[i] = new ReflectorField(reflectorClass, clazz, i);
        }
        return reflectorFieldArray;
    }

    private static boolean logEntry(String string) {
        LOGGER.info("[OptiFine] " + string);
        return true;
    }

    private static boolean registerResolvable(final String string) {
        IResolvable iResolvable = new IResolvable(){

            @Override
            public void resolve() {
                LOGGER.info("[OptiFine] " + string);
            }
        };
        ReflectorResolver.register(iResolvable);
        return true;
    }
}

