package net.minecraft.client.renderer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockSign;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.Block.EnumOffsetType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.IRenderChunkFactory;
import net.minecraft.client.renderer.chunk.ListChunkFactory;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.chunk.VboChunkFactory;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.RenderItemFrame;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumType;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumUsage;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemRecord;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Matrix4f;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vector3d;
import net.minecraft.util.BlockPos.MutableBlockPos;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.optifine.CustomColors;
import net.optifine.CustomSky;
import net.optifine.DynamicLights;
import net.optifine.Lagometer;
import net.optifine.RandomEntities;
import net.optifine.SmartAnimations;
import net.optifine.model.BlockModelUtils;
import net.optifine.reflect.Reflector;
import net.optifine.render.ChunkVisibility;
import net.optifine.render.CloudRenderer;
import net.optifine.render.RenderEnv;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.ShadersRender;
import net.optifine.shaders.ShadowUtils;
import net.optifine.shaders.gui.GuiShaderOptions;
import net.optifine.util.ChunkUtils;
import net.optifine.util.RenderChunkUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import x.oc2cf3d80e17;
import x.oc4e1b577a95;
import x.oc9755810e45;
import x.oce4b2178c11;
import x.ocea775c9d5c;
import x.ocee33618a8d;

public class RenderGlobal implements IWorldAccess, IResourceManagerReloadListener {
   private static final Logger logger = LogManager.getLogger();
   private static final ResourceLocation locationMoonPhasesPng = new ResourceLocation("textures/environment/moon_phases.png");
   private static final ResourceLocation locationSunPng = new ResourceLocation("textures/environment/sun.png");
   private static final ResourceLocation locationCloudsPng = new ResourceLocation("textures/environment/clouds.png");
   private static final ResourceLocation locationEndSkyPng = new ResourceLocation("textures/environment/end_sky.png");
   private static final ResourceLocation locationForcefieldPng = new ResourceLocation("textures/misc/forcefield.png");
   private static final double maximumWorldBorderGeometryRadius = 512.0;
   private static final int worldBorderBatchQuads = 512;
   public final Minecraft mc;
   private final TextureManager renderEngine;
   private final RenderManager renderManager;
   private WorldClient theWorld;
   private Set<RenderChunk> chunksToUpdate = Sets.newLinkedHashSet();
   private List<RenderGlobal.ContainerLocalRenderInformation> renderInfos = Lists.newArrayListWithCapacity(69696);
   private final Set<TileEntity> setTileEntities = Sets.newHashSet();
   private ViewFrustum viewFrustum;
   private int starGLCallList = -1;
   private int glSkyList = -1;
   private int glSkyList2 = -1;
   private final VertexFormat vertexBufferFormat;
   private VertexBuffer starVBO;
   private VertexBuffer skyVBO;
   private VertexBuffer sky2VBO;
   private int cloudTickCounter;
   public final Map<Integer, DestroyBlockProgress> damagedBlocks = Maps.newHashMap();
   private final Map<BlockPos, ISound> mapSoundPositions = Maps.newHashMap();
   private final TextureAtlasSprite[] destroyBlockIcons = new TextureAtlasSprite[10];
   private Framebuffer entityOutlineFramebuffer;
   private ShaderGroup entityOutlineShader;
   private double frustumUpdatePosX = Double.MIN_VALUE;
   private double frustumUpdatePosY = Double.MIN_VALUE;
   private double frustumUpdatePosZ = Double.MIN_VALUE;
   private int frustumUpdatePosChunkX = Integer.MIN_VALUE;
   private int frustumUpdatePosChunkY = Integer.MIN_VALUE;
   private int frustumUpdatePosChunkZ = Integer.MIN_VALUE;
   private double lastViewEntityX = Double.MIN_VALUE;
   private double lastViewEntityY = Double.MIN_VALUE;
   private double lastViewEntityZ = Double.MIN_VALUE;
   private double lastViewEntityPitch = Double.MIN_VALUE;
   private double lastViewEntityYaw = Double.MIN_VALUE;
   private final ChunkRenderDispatcher renderDispatcher = new ChunkRenderDispatcher();
   private ChunkRenderContainer renderContainer;
   private int renderDistanceChunks = -1;
   private int renderEntitiesStartupCounter = 2;
   private int countEntitiesTotal;
   private int countEntitiesRendered;
   private int countEntitiesHidden;
   private boolean debugFixTerrainFrustum = false;
   private ClippingHelper debugFixedClippingHelper;
   private final Vector4f[] debugTerrainMatrix = new Vector4f[8];
   private final Vector3d debugTerrainFrustumPosition = new Vector3d();
   private boolean vboEnabled = false;
   IRenderChunkFactory renderChunkFactory;
   private double prevRenderSortX;
   private double prevRenderSortY;
   private double prevRenderSortZ;
   public boolean displayListEntitiesDirty = true;
   private final CloudRenderer cloudRenderer;
   public Entity renderedEntity;
   public Set chunksToResortTransparency = new LinkedHashSet();
   public Set chunksToUpdateForced = new LinkedHashSet();
   private final Deque visibilityDeque = new ArrayDeque();
   private List<RenderGlobal.ContainerLocalRenderInformation> renderInfosEntities = new ArrayList<>(1024);
   private List renderInfosTileEntities = new ArrayList(1024);
   private final List renderInfosNormal = new ArrayList(1024);
   private final List renderInfosEntitiesNormal = new ArrayList(1024);
   private final List renderInfosTileEntitiesNormal = new ArrayList(1024);
   private final List renderInfosShadow = new ArrayList(1024);
   private final List renderInfosEntitiesShadow = new ArrayList(1024);
   private final List renderInfosTileEntitiesShadow = new ArrayList(1024);
   private int renderDistance = 0;
   private int renderDistanceSq = 0;
   private static final Set SET_ALL_FACINGS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(EnumFacing.VALUES)));
   private int countTileEntitiesRendered;
   private IChunkProvider worldChunkProvider = null;
   private LongHashMap worldChunkProviderMap = null;
   private int countLoadedChunksPrev = 0;
   private final RenderEnv renderEnv = new RenderEnv(Blocks.air.getDefaultState(), new BlockPos(0, 0, 0));
   public boolean renderOverlayDamaged = false;
   public boolean renderOverlayEyes = false;
   private boolean firstWorldLoad = false;
   private static int renderEntitiesCounter = 0;

   public RenderGlobal(Minecraft var1) {
      this.cloudRenderer = new CloudRenderer(var1);
      this.mc = var1;
      this.renderManager = var1.getRenderManager();
      this.renderEngine = var1.getTextureManager();
      this.renderEngine.bindTexture(locationForcefieldPng);
      GL11.glTexParameteri(3553, 10242, 10497);
      GL11.glTexParameteri(3553, 10243, 10497);
      GlStateManager.bindTexture(0);
      this.updateDestroyBlockIcons();
      this.vboEnabled = OpenGlHelper.useVbo();
      if (this.vboEnabled) {
         this.renderContainer = new VboRenderList();
         this.renderChunkFactory = new VboChunkFactory();
      } else {
         this.renderContainer = new RenderList();
         this.renderChunkFactory = new ListChunkFactory();
      }

      this.vertexBufferFormat = new VertexFormat();
      this.vertexBufferFormat.addElement(new VertexFormatElement(0, EnumType.FLOAT, EnumUsage.POSITION, 3));
      this.generateStars();
      this.generateSky();
      this.generateSky2();
   }

   public void onResourceManagerReload(IResourceManager var1) {
      this.updateDestroyBlockIcons();
   }

   private void updateDestroyBlockIcons() {
      TextureMap var1 = this.mc.getTextureMapBlocks();

      for (int var2 = 0; var2 < this.destroyBlockIcons.length; var2++) {
         this.destroyBlockIcons[var2] = var1.getAtlasSprite("minecraft:blocks/destroy_stage_" + var2);
      }
   }

   public void makeEntityOutlineShader() {
      if (OpenGlHelper.shadersSupported) {
         if (ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
         }

         ResourceLocation var1 = new ResourceLocation("shaders/post/entity_outline.json");

         try {
            this.entityOutlineShader = new ShaderGroup(this.mc.getTextureManager(), this.mc.getResourceManager(), this.mc.getFramebuffer(), var1);
            this.entityOutlineShader.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
            this.entityOutlineFramebuffer = this.entityOutlineShader.getFramebufferRaw("final");
         } catch (IOException var3) {
            logger.warn("Failed to load shader: " + var1, var3);
            this.entityOutlineShader = null;
            this.entityOutlineFramebuffer = null;
         } catch (JsonSyntaxException var4) {
            logger.warn("Failed to load shader: " + var1, var4);
            this.entityOutlineShader = null;
            this.entityOutlineFramebuffer = null;
         }
      } else {
         this.entityOutlineShader = null;
         this.entityOutlineFramebuffer = null;
      }
   }

   public void renderEntityOutlineFramebuffer() {
      if (this.isRenderEntityOutlines()) {
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
         this.entityOutlineFramebuffer.framebufferRenderExt(this.mc.displayWidth, this.mc.displayHeight, false);
         GlStateManager.disableBlend();
      }
   }

   protected boolean isRenderEntityOutlines() {
      return !Config.isFastRender() && !Config.isShaders() && !Config.isAntialiasing()
         ? this.entityOutlineFramebuffer != null
            && this.entityOutlineShader != null
            && this.mc.thePlayer != null
            && this.mc.thePlayer.isSpectator()
            && this.mc.gameSettings.keyBindSpectatorOutlines.isKeyDown()
         : false;
   }

   private void generateSky2() {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      if (this.sky2VBO != null) {
         this.sky2VBO.deleteGlBuffers();
      }

      if (this.glSkyList2 >= 0) {
         GLAllocation.deleteDisplayLists(this.glSkyList2);
         this.glSkyList2 = -1;
      }

      if (this.vboEnabled) {
         this.sky2VBO = new VertexBuffer(this.vertexBufferFormat);
         this.renderSky(var2, -16.0F, true);
         var2.finishDrawing();
         var2.reset();
         this.sky2VBO.bufferData(var2.getByteBuffer());
      } else {
         this.glSkyList2 = GLAllocation.generateDisplayLists(1);
         GL11.glNewList(this.glSkyList2, 4864);
         this.renderSky(var2, -16.0F, true);
         var1.draw();
         GL11.glEndList();
      }
   }

   private void generateSky() {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      if (this.skyVBO != null) {
         this.skyVBO.deleteGlBuffers();
      }

      if (this.glSkyList >= 0) {
         GLAllocation.deleteDisplayLists(this.glSkyList);
         this.glSkyList = -1;
      }

      if (this.vboEnabled) {
         this.skyVBO = new VertexBuffer(this.vertexBufferFormat);
         this.renderSky(var2, 16.0F, false);
         var2.finishDrawing();
         var2.reset();
         this.skyVBO.bufferData(var2.getByteBuffer());
      } else {
         this.glSkyList = GLAllocation.generateDisplayLists(1);
         GL11.glNewList(this.glSkyList, 4864);
         this.renderSky(var2, 16.0F, false);
         var1.draw();
         GL11.glEndList();
      }
   }

   private void renderSky(WorldRenderer var1, float var2, boolean var3) {
      byte var4 = 64;
      byte var5 = 6;
      var1.begin(7, DefaultVertexFormats.POSITION);
      int var6 = (this.renderDistance / 64 + 1) * 64 + 64;

      for (int var7 = -var6; var7 <= var6; var7 += 64) {
         for (int var8 = -var6; var8 <= var6; var8 += 64) {
            float var9 = var7;
            float var10 = var7 + 64;
            if (var3) {
               var10 = var7;
               var9 = var7 + 64;
            }

            var1.pos(var9, var2, var8).endVertex();
            var1.pos(var10, var2, var8).endVertex();
            var1.pos(var10, var2, var8 + 64).endVertex();
            var1.pos(var9, var2, var8 + 64).endVertex();
         }
      }
   }

   private void generateStars() {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      if (this.starVBO != null) {
         this.starVBO.deleteGlBuffers();
      }

      if (this.starGLCallList >= 0) {
         GLAllocation.deleteDisplayLists(this.starGLCallList);
         this.starGLCallList = -1;
      }

      if (this.vboEnabled) {
         this.starVBO = new VertexBuffer(this.vertexBufferFormat);
         this.renderStars(var2);
         var2.finishDrawing();
         var2.reset();
         this.starVBO.bufferData(var2.getByteBuffer());
      } else {
         this.starGLCallList = GLAllocation.generateDisplayLists(1);
         GlStateManager.pushMatrix();
         GL11.glNewList(this.starGLCallList, 4864);
         this.renderStars(var2);
         var1.draw();
         GL11.glEndList();
         GlStateManager.popMatrix();
      }
   }

   private void renderStars(WorldRenderer var1) {
      Random var2 = new Random(10842L);
      var1.begin(7, DefaultVertexFormats.POSITION);

      for (int var3 = 0; var3 < 1500; var3++) {
         double var4 = var2.nextFloat() * 2.0F - 1.0F;
         double var6 = var2.nextFloat() * 2.0F - 1.0F;
         double var8 = var2.nextFloat() * 2.0F - 1.0F;
         double var10 = 0.15F + var2.nextFloat() * 0.1F;
         double var12 = var4 * var4 + var6 * var6 + var8 * var8;
         if (var12 < 1.0 && var12 > 0.01) {
            var12 = 1.0 / Math.sqrt(var12);
            var4 *= var12;
            var6 *= var12;
            var8 *= var12;
            double var14 = var4 * 100.0;
            double var16 = var6 * 100.0;
            double var18 = var8 * 100.0;
            double var20 = Math.atan2(var4, var8);
            double var22 = Math.sin(var20);
            double var24 = Math.cos(var20);
            double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
            double var28 = Math.sin(var26);
            double var30 = Math.cos(var26);
            double var32 = var2.nextDouble() * Math.PI * 2.0;
            double var34 = Math.sin(var32);
            double var36 = Math.cos(var32);

            for (int var38 = 0; var38 < 4; var38++) {
               double var39 = 0.0;
               double var41 = ((var38 & 2) - 1) * var10;
               double var43 = ((var38 + 1 & 2) - 1) * var10;
               double var45 = 0.0;
               double var47 = var41 * var36 - var43 * var34;
               double var49 = var43 * var36 + var41 * var34;
               double var51 = var47 * var28 + 0.0 * var30;
               double var53 = 0.0 * var28 - var47 * var30;
               double var55 = var53 * var22 - var49 * var24;
               double var57 = var49 * var22 + var53 * var24;
               var1.pos(var14 + var55, var16 + var51, var18 + var57).endVertex();
            }
         }
      }
   }

   public void setWorldAndLoadRenderers(WorldClient var1) {
      if (this.theWorld != null) {
         this.theWorld.removeWorldAccess(this);
      }

      this.frustumUpdatePosX = Double.MIN_VALUE;
      this.frustumUpdatePosY = Double.MIN_VALUE;
      this.frustumUpdatePosZ = Double.MIN_VALUE;
      this.frustumUpdatePosChunkX = Integer.MIN_VALUE;
      this.frustumUpdatePosChunkY = Integer.MIN_VALUE;
      this.frustumUpdatePosChunkZ = Integer.MIN_VALUE;
      this.renderManager.set(var1);
      this.theWorld = var1;
      if (Config.isDynamicLights()) {
         DynamicLights.clear();
      }

      ChunkVisibility.reset();
      this.worldChunkProvider = null;
      this.worldChunkProviderMap = null;
      this.renderEnv.reset((IBlockState)null, (BlockPos)null);
      Shaders.checkWorldChanged(this.theWorld);
      if (var1 != null) {
         var1.addWorldAccess(this);
         this.loadRenderers();
      } else {
         this.chunksToUpdate.clear();
         this.clearRenderInfos();
         if (this.viewFrustum != null) {
            this.viewFrustum.deleteGlResources();
         }

         this.viewFrustum = null;
      }
   }

   public void loadRenderers() {
      if (this.theWorld != null) {
         this.displayListEntitiesDirty = true;
         Blocks.leaves.setGraphicsLevel(Config.isTreesFancy());
         Blocks.leaves2.setGraphicsLevel(Config.isTreesFancy());
         BlockModelRenderer.updateAoLightValue();
         if (Config.isDynamicLights()) {
            DynamicLights.clear();
         }

         SmartAnimations.update();
         this.renderDistanceChunks = this.mc.gameSettings.renderDistanceChunks;
         this.renderDistance = this.renderDistanceChunks * 16;
         this.renderDistanceSq = this.renderDistance * this.renderDistance;
         boolean var1 = this.vboEnabled;
         this.vboEnabled = OpenGlHelper.useVbo();
         if (var1 && !this.vboEnabled) {
            this.renderContainer = new RenderList();
            this.renderChunkFactory = new ListChunkFactory();
         } else if (!var1 && this.vboEnabled) {
            this.renderContainer = new VboRenderList();
            this.renderChunkFactory = new VboChunkFactory();
         }

         this.generateStars();
         this.generateSky();
         this.generateSky2();
         if (this.viewFrustum != null) {
            this.viewFrustum.deleteGlResources();
         }

         this.stopChunkUpdates();
         synchronized (this.setTileEntities) {
            this.setTileEntities.clear();
         }

         this.viewFrustum = new ViewFrustum(this.theWorld, this.mc.gameSettings.renderDistanceChunks, this, this.renderChunkFactory);
         if (this.theWorld != null) {
            Entity var5 = this.mc.getRenderViewEntity();
            if (var5 != null) {
               this.viewFrustum.updateChunkPositions(var5.posX, var5.posZ);
            }
         }

         this.renderEntitiesStartupCounter = 2;
      }

      if (this.mc.thePlayer == null) {
         this.firstWorldLoad = true;
      }
   }

   protected void stopChunkUpdates() {
      this.chunksToUpdate.clear();
      this.renderDispatcher.stopChunkUpdates();
   }

   public void createBindEntityOutlineFbs(int var1, int var2) {
      if (OpenGlHelper.shadersSupported && this.entityOutlineShader != null) {
         this.entityOutlineShader.createBindFramebuffers(var1, var2);
      }
   }

   public void renderEntities(Entity var1, ICamera var2, float var3) {
      int var4 = 0;
      if (Reflector.MinecraftCompatClient_getRenderPass.exists()) {
         var4 = Reflector.callInt(Reflector.MinecraftCompatClient_getRenderPass, new Object[0]);
      }

      if (this.renderEntitiesStartupCounter > 0) {
         if (var4 > 0) {
            return;
         }

         this.renderEntitiesStartupCounter--;
      } else {
         double var5 = var1.prevPosX + (var1.posX - var1.prevPosX) * var3;
         double var7 = var1.prevPosY + (var1.posY - var1.prevPosY) * var3;
         double var9 = var1.prevPosZ + (var1.posZ - var1.prevPosZ) * var3;
         this.theWorld.theProfiler.startSection("prepare");
         TileEntityRendererDispatcher.instance
            .cacheActiveRenderInfo(this.theWorld, this.mc.getTextureManager(), this.mc.fontRendererObj, this.mc.getRenderViewEntity(), var3);
         this.renderManager
            .cacheActiveRenderInfo(this.theWorld, this.mc.fontRendererObj, this.mc.getRenderViewEntity(), this.mc.pointedEntity, this.mc.gameSettings, var3);
         renderEntitiesCounter++;
         if (var4 == 0) {
            this.countEntitiesTotal = 0;
            this.countEntitiesRendered = 0;
            this.countEntitiesHidden = 0;
            this.countTileEntitiesRendered = 0;
         }

         Entity var11 = this.mc.getRenderViewEntity();
         double var12 = var11.lastTickPosX + (var11.posX - var11.lastTickPosX) * var3;
         double var14 = var11.lastTickPosY + (var11.posY - var11.lastTickPosY) * var3;
         double var16 = var11.lastTickPosZ + (var11.posZ - var11.lastTickPosZ) * var3;
         TileEntityRendererDispatcher.staticPlayerX = var12;
         TileEntityRendererDispatcher.staticPlayerY = var14;
         TileEntityRendererDispatcher.staticPlayerZ = var16;
         this.renderManager.setRenderPosition(var12, var14, var16);
         this.mc.entityRenderer.enableLightmap();
         this.theWorld.theProfiler.endStartSection("global");
         List var18 = this.theWorld.getLoadedEntityList();
         if (var4 == 0) {
            this.countEntitiesTotal = var18.size();
         }

         if (Config.isFogOff() && this.mc.entityRenderer.fogStandard) {
            GlStateManager.disableFog();
         }

         boolean var19 = Reflector.CompatEntity_shouldRenderInPass.exists();
         boolean var20 = Reflector.CompatTileEntity_shouldRenderInPass.exists();

         for (Entity var22 : this.theWorld.weatherEffects) {
            if (!var19 || Reflector.callBoolean(var22, Reflector.CompatEntity_shouldRenderInPass, new Object[]{var4})) {
               this.countEntitiesRendered++;
               if (var22.isInRangeToRender3d(var5, var7, var9)) {
                  this.renderManager.renderEntitySimple(var22, var3);
               }
            }
         }

         if (this.isRenderEntityOutlines()) {
            GlStateManager.depthFunc(519);
            GlStateManager.disableFog();
            this.entityOutlineFramebuffer.framebufferClear();
            this.entityOutlineFramebuffer.bindFramebuffer(false);
            this.theWorld.theProfiler.endStartSection("entityOutlines");
            RenderHelper.disableStandardItemLighting();
            this.renderManager.setRenderOutlines(true);

            for (Entity var36 : var18) {
               boolean var24 = this.mc.getRenderViewEntity() instanceof EntityLivingBase
                  && ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping();
               boolean var25 = var36.isInRangeToRender3d(var5, var7, var9)
                  && (var36.ignoreFrustumCheck || var2.isBoundingBoxInFrustum(var36.getEntityBoundingBox()) || var36.riddenByEntity == this.mc.thePlayer)
                  && var36 instanceof EntityPlayer;
               if ((var36 != this.mc.getRenderViewEntity() || this.mc.gameSettings.thirdPersonView != 0 || var24) && var25) {
                  this.renderManager.renderEntitySimple(var36, var3);
               }
            }

            this.renderManager.setRenderOutlines(false);
            RenderHelper.enableStandardItemLighting();
            GlStateManager.depthMask(false);
            this.entityOutlineShader.loadShaderGroup(var3);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            this.mc.getFramebuffer().bindFramebuffer(false);
            GlStateManager.enableFog();
            GlStateManager.enableBlend();
            GlStateManager.enableColorMaterial();
            GlStateManager.depthFunc(515);
            GlStateManager.enableDepth();
            GlStateManager.enableAlpha();
         }

         this.theWorld.theProfiler.endStartSection("entities");
         boolean var35 = Config.isShaders();
         if (var35) {
            Shaders.beginEntities();
         }

         RenderItemFrame.updateItemRenderDistance();
         boolean var37 = this.mc.gameSettings.fancyGraphics;
         this.mc.gameSettings.fancyGraphics = Config.isDroppedItemsFancy();
         boolean var23 = Shaders.isShadowPass && !this.mc.thePlayer.isSpectator();

         for (RenderGlobal.ContainerLocalRenderInformation var42 : this.renderInfosEntities) {
            Chunk var26 = var42.renderChunk.getChunk();
            ClassInheritanceMultiMap var27 = var26.getEntityLists()[var42.renderChunk.getPosition().getY() / 16];
            if (!var27.isEmpty()) {
               for (Entity var29 : var27) {
                  if (!var19 || Reflector.callBoolean(var29, Reflector.CompatEntity_shouldRenderInPass, new Object[]{var4})) {
                     boolean var30 = this.mimeow$redirect$interpolateBacktrackPosition(this.renderManager, var29, var2, var5, var7, var9)
                        || var29.riddenByEntity == this.mc.thePlayer;
                     if (var30) {
                        boolean var31 = this.mc.getRenderViewEntity() instanceof EntityLivingBase
                           ? ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping()
                           : false;
                        if (var29 == this.mc.getRenderViewEntity() && !var23 && this.mc.gameSettings.thirdPersonView == 0 && !var31
                           || !(var29.posY < 0.0) && !(var29.posY >= 256.0) && !this.theWorld.isBlockLoaded(new BlockPos(var29))) {
                           continue;
                        }

                        this.countEntitiesRendered++;
                        this.renderedEntity = var29;
                        if (var35) {
                           Shaders.nextEntity(var29);
                        }

                        this.renderManager.renderEntitySimple(var29, var3);
                        this.renderedEntity = null;
                     }

                     if (!var30
                        && var29 instanceof EntityWitherSkull
                        && (!var19 || Reflector.callBoolean(var29, Reflector.CompatEntity_shouldRenderInPass, new Object[]{var4}))) {
                        this.renderedEntity = var29;
                        if (var35) {
                           Shaders.nextEntity(var29);
                        }

                        this.mc.getRenderManager().renderWitherSkull(var29, var3);
                        this.renderedEntity = null;
                     }
                  }
               }
            }
         }

         this.mc.gameSettings.fancyGraphics = var37;
         if (var35) {
            Shaders.endEntities();
            Shaders.beginBlockEntities();
         }

         this.theWorld.theProfiler.endStartSection("blockentities");
         RenderHelper.enableStandardItemLighting();
         if (Reflector.CompatTileEntity_hasFastRenderer.exists()) {
            TileEntityRendererDispatcher.instance.preDrawBatch();
         }

         TileEntitySignRenderer.updateTextRenderDistance();

         for (RenderGlobal.ContainerLocalRenderInformation var43 : this.renderInfos) {
            List var46 = var43.renderChunk.getCompiledChunk().getTileEntities();
            if (!var46.isEmpty()) {
               for (TileEntity var51 : var46) {
                  if (var20) {
                     if (!Reflector.callBoolean(var51, Reflector.CompatTileEntity_shouldRenderInPass, new Object[]{var4})) {
                        continue;
                     }

                     AxisAlignedBB var54 = (AxisAlignedBB)Reflector.call(var51, Reflector.CompatTileEntity_getRenderBoundingBox, new Object[0]);
                     if (var54 != null && !var2.isBoundingBoxInFrustum(var54)) {
                        continue;
                     }
                  }

                  if (var35) {
                     Shaders.nextBlockEntity(var51);
                  }

                  TileEntityRendererDispatcher.instance.renderTileEntity(var51, var3, -1);
                  this.countTileEntitiesRendered++;
               }
            }
         }

         synchronized (this.setTileEntities) {
            for (TileEntity var47 : this.setTileEntities) {
               if (!var20 || Reflector.callBoolean(var47, Reflector.CompatTileEntity_shouldRenderInPass, new Object[]{var4})) {
                  if (var35) {
                     Shaders.nextBlockEntity(var47);
                  }

                  TileEntityRendererDispatcher.instance.renderTileEntity(var47, var3, -1);
               }
            }
         }

         if (Reflector.CompatTileEntity_hasFastRenderer.exists()) {
            TileEntityRendererDispatcher.instance.drawBatch(var4);
         }

         this.renderOverlayDamaged = true;
         this.preRenderDamagedBlocks();

         for (DestroyBlockProgress var45 : this.damagedBlocks.values()) {
            BlockPos var48 = var45.getPosition();
            TileEntity var50 = this.theWorld.getTileEntity(var48);
            if (var50 instanceof TileEntityChest var52) {
               if (var52.adjacentChestXNeg != null) {
                  var48 = var48.offset(EnumFacing.WEST);
                  var50 = this.theWorld.getTileEntity(var48);
               } else if (var52.adjacentChestZNeg != null) {
                  var48 = var48.offset(EnumFacing.NORTH);
                  var50 = this.theWorld.getTileEntity(var48);
               }
            }

            Block var53 = this.theWorld.getBlockState(var48).getBlock();
            boolean var55;
            if (var20) {
               var55 = false;
               if (var50 != null
                  && Reflector.callBoolean(var50, Reflector.CompatTileEntity_shouldRenderInPass, new Object[]{var4})
                  && Reflector.callBoolean(var50, Reflector.CompatTileEntity_canRenderBreaking, new Object[0])) {
                  AxisAlignedBB var56 = (AxisAlignedBB)Reflector.call(var50, Reflector.CompatTileEntity_getRenderBoundingBox, new Object[0]);
                  if (var56 != null) {
                     var55 = var2.isBoundingBoxInFrustum(var56);
                  }
               }
            } else {
               var55 = var50 != null
                  && (var53 instanceof BlockChest || var53 instanceof BlockEnderChest || var53 instanceof BlockSign || var53 instanceof BlockSkull);
            }

            if (var55) {
               if (var35) {
                  Shaders.nextBlockEntity(var50);
               }

               TileEntityRendererDispatcher.instance.renderTileEntity(var50, var3, var45.getPartialBlockDamage());
            }
         }

         this.postRenderDamagedBlocks();
         this.renderOverlayDamaged = false;
         if (var35) {
            Shaders.endBlockEntities();
         }

         renderEntitiesCounter--;
         this.mc.entityRenderer.disableLightmap();
         this.mc.mcProfiler.endSection();
      }
   }

   public String getDebugInfoRenders() {
      int var1 = this.viewFrustum.renderChunks.length;
      int var2 = 0;

      for (RenderGlobal.ContainerLocalRenderInformation var4 : this.renderInfos) {
         CompiledChunk var5 = var4.renderChunk.compiledChunk;
         if (var5 != CompiledChunk.DUMMY && !var5.isEmpty()) {
            var2++;
         }
      }

      return String.format(
         "C: %d/%d %sD: %d, %s", var2, var1, this.mc.renderChunksMany ? "(s) " : "", this.renderDistanceChunks, this.renderDispatcher.getDebugInfo()
      );
   }

   public String getDebugInfoEntities() {
      return "E: "
         + this.countEntitiesRendered
         + "/"
         + this.countEntitiesTotal
         + ", B: "
         + this.countEntitiesHidden
         + ", I: "
         + (this.countEntitiesTotal - this.countEntitiesHidden - this.countEntitiesRendered)
         + ", "
         + Config.getVersionDebug();
   }

   public void setupTerrain(Entity var1, double var2, ICamera var4, int var5, boolean var6) {
      if (this.mc.gameSettings.renderDistanceChunks != this.renderDistanceChunks) {
         this.loadRenderers();
      }

      this.theWorld.theProfiler.startSection("camera");
      double var7 = var1.posX - this.frustumUpdatePosX;
      double var9 = var1.posY - this.frustumUpdatePosY;
      double var11 = var1.posZ - this.frustumUpdatePosZ;
      if (this.frustumUpdatePosChunkX != var1.chunkCoordX
         || this.frustumUpdatePosChunkY != var1.chunkCoordY
         || this.frustumUpdatePosChunkZ != var1.chunkCoordZ
         || var7 * var7 + var9 * var9 + var11 * var11 > 16.0) {
         this.frustumUpdatePosX = var1.posX;
         this.frustumUpdatePosY = var1.posY;
         this.frustumUpdatePosZ = var1.posZ;
         this.frustumUpdatePosChunkX = var1.chunkCoordX;
         this.frustumUpdatePosChunkY = var1.chunkCoordY;
         this.frustumUpdatePosChunkZ = var1.chunkCoordZ;
         this.viewFrustum.updateChunkPositions(var1.posX, var1.posZ);
      }

      if (Config.isDynamicLights()) {
         DynamicLights.update(this);
      }

      this.theWorld.theProfiler.endStartSection("renderlistcamera");
      double var13 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * var2;
      double var15 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * var2;
      double var17 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * var2;
      this.renderContainer.initialize(var13, var15, var17);
      this.theWorld.theProfiler.endStartSection("cull");
      if (this.debugFixedClippingHelper != null) {
         Frustum var19 = new Frustum(this.debugFixedClippingHelper);
         var19.setPosition(this.debugTerrainFrustumPosition.x, this.debugTerrainFrustumPosition.y, this.debugTerrainFrustumPosition.z);
         var4 = var19;
      }

      this.mc.mcProfiler.endStartSection("culling");
      BlockPos var39 = new BlockPos(var13, var15 + var1.getEyeHeight(), var17);
      RenderChunk var20 = this.viewFrustum.getRenderChunk(var39);
      new BlockPos(MathHelper.floor_double(var13 / 16.0) * 16, MathHelper.floor_double(var15 / 16.0) * 16, MathHelper.floor_double(var17 / 16.0) * 16);
      this.displayListEntitiesDirty = this.displayListEntitiesDirty
         || !this.chunksToUpdate.isEmpty()
         || var1.posX != this.lastViewEntityX
         || var1.posY != this.lastViewEntityY
         || var1.posZ != this.lastViewEntityZ
         || this.mimeow$redirect$setupTerrainRotationPitch(var1) != this.lastViewEntityPitch
         || this.mimeow$redirect$setupTerrainRotationYaw(var1) != this.lastViewEntityYaw;
      this.lastViewEntityX = var1.posX;
      this.lastViewEntityY = var1.posY;
      this.lastViewEntityZ = var1.posZ;
      this.lastViewEntityPitch = this.mimeow$redirect$setupTerrainRotationPitch(var1);
      this.lastViewEntityYaw = this.mimeow$redirect$setupTerrainRotationYaw(var1);
      boolean var21 = this.debugFixedClippingHelper != null;
      this.mc.mcProfiler.endStartSection("update");
      Lagometer.timerVisibility.start();
      int var22 = this.getCountLoadedChunks();
      if (var22 != this.countLoadedChunksPrev) {
         this.countLoadedChunksPrev = var22;
         this.displayListEntitiesDirty = true;
      }

      int var23 = 256;
      if (!ChunkVisibility.isFinished()) {
         this.displayListEntitiesDirty = true;
      }

      if (!var21 && this.displayListEntitiesDirty && Config.isIntegratedServerRunning()) {
         var23 = ChunkVisibility.getMaxChunkY(this.theWorld, var1, this.renderDistanceChunks);
      }

      RenderChunk var24 = this.viewFrustum.getRenderChunk(new BlockPos(var1.posX, var1.posY, var1.posZ));
      if (Shaders.isShadowPass) {
         this.renderInfos = this.renderInfosShadow;
         this.renderInfosEntities = this.renderInfosEntitiesShadow;
         this.renderInfosTileEntities = this.renderInfosTileEntitiesShadow;
         if (!var21 && this.displayListEntitiesDirty) {
            this.clearRenderInfos();
            if (var24 != null && var24.getPosition().getY() > var23) {
               this.renderInfosEntities.add(var24.getRenderInfo());
            }

            Iterator var25 = ShadowUtils.makeShadowChunkIterator(this.theWorld, var2, var1, this.renderDistanceChunks, this.viewFrustum);

            while (var25.hasNext()) {
               RenderChunk var26 = (RenderChunk)var25.next();
               if (var26 != null && var26.getPosition().getY() <= var23) {
                  RenderGlobal.ContainerLocalRenderInformation var27 = var26.getRenderInfo();
                  if (!var26.compiledChunk.isEmpty() || var26.isNeedsUpdate()) {
                     this.renderInfos.add(var27);
                  }

                  if (ChunkUtils.hasEntities(var26.getChunk())) {
                     this.renderInfosEntities.add(var27);
                  }

                  if (var26.getCompiledChunk().getTileEntities().size() > 0) {
                     this.renderInfosTileEntities.add(var27);
                  }
               }
            }
         }
      } else {
         this.renderInfos = this.renderInfosNormal;
         this.renderInfosEntities = this.renderInfosEntitiesNormal;
         this.renderInfosTileEntities = this.renderInfosTileEntitiesNormal;
      }

      if (!var21 && this.displayListEntitiesDirty && !Shaders.isShadowPass) {
         this.displayListEntitiesDirty = false;
         this.clearRenderInfos();
         this.visibilityDeque.clear();
         Deque var40 = this.visibilityDeque;
         boolean var42 = this.mc.renderChunksMany;
         if (var20 != null && var20.getPosition().getY() <= var23) {
            boolean var45 = false;
            RenderGlobal.ContainerLocalRenderInformation var48 = new RenderGlobal.ContainerLocalRenderInformation(var20, (EnumFacing)null, 0);
            Set var51 = SET_ALL_FACINGS;
            if (var51.size() == 1) {
               Vector3f var54 = this.mimeow$redirect$setupTerrainViewVector(this, var1, var2);
               EnumFacing var57 = EnumFacing.getFacingFromVector(var54.x, var54.y, var54.z).getOpposite();
               var51.remove(var57);
            }

            if (var51.isEmpty()) {
               var45 = true;
            }

            if (var45 && !var6) {
               this.renderInfos.add(var48);
            } else {
               if (var6 && this.theWorld.getBlockState(var39).getBlock().isOpaqueCube()) {
                  var42 = false;
               }

               var20.setFrameIndex(var5);
               var40.add(var48);
            }
         } else {
            int var44 = var39.getY() > 0 ? Math.min(var23, 248) : 8;
            if (var24 != null) {
               this.renderInfosEntities.add(var24.getRenderInfo());
            }

            for (int var28 = -this.renderDistanceChunks; var28 <= this.renderDistanceChunks; var28++) {
               for (int var29 = -this.renderDistanceChunks; var29 <= this.renderDistanceChunks; var29++) {
                  RenderChunk var30 = this.viewFrustum.getRenderChunk(new BlockPos((var28 << 4) + 8, var44, (var29 << 4) + 8));
                  if (var30 != null && var30.isBoundingBoxInFrustum((ICamera)var4, var5)) {
                     var30.setFrameIndex(var5);
                     RenderGlobal.ContainerLocalRenderInformation var31 = var30.getRenderInfo();
                     var31.initialize((EnumFacing)null, 0);
                     var40.add(var31);
                  }
               }
            }
         }

         this.mc.mcProfiler.startSection("iteration");
         boolean var46 = Config.isFogOn();

         while (!var40.isEmpty()) {
            RenderGlobal.ContainerLocalRenderInformation var49 = (RenderGlobal.ContainerLocalRenderInformation)var40.poll();
            RenderChunk var52 = var49.renderChunk;
            EnumFacing var55 = var49.facing;
            CompiledChunk var58 = var52.compiledChunk;
            if (!var58.isEmpty() || var52.isNeedsUpdate()) {
               this.renderInfos.add(var49);
            }

            if (ChunkUtils.hasEntities(var52.getChunk())) {
               this.renderInfosEntities.add(var49);
            }

            if (var58.getTileEntities().size() > 0) {
               this.renderInfosTileEntities.add(var49);
            }

            for (EnumFacing var35 : var42 ? ChunkVisibility.getFacingsNotOpposite(var49.setFacing) : EnumFacing.VALUES) {
               if (!var42 || var55 == null || var58.isVisible(var55.getOpposite(), var35)) {
                  RenderChunk var36 = this.getRenderChunkOffset(var39, var52, var35, var46, var23);
                  if (var36 != null && var36.setFrameIndex(var5) && var36.isBoundingBoxInFrustum((ICamera)var4, var5)) {
                     int var37 = var49.setFacing | 1 << var35.ordinal();
                     RenderGlobal.ContainerLocalRenderInformation var38 = var36.getRenderInfo();
                     var38.initialize(var35, var37);
                     var40.add(var38);
                  }
               }
            }
         }

         this.mc.mcProfiler.endSection();
      }

      this.mc.mcProfiler.endStartSection("captureFrustum");
      if (this.debugFixTerrainFrustum) {
         this.fixTerrainFrustum(var13, var15, var17);
         this.debugFixTerrainFrustum = false;
      }

      Lagometer.timerVisibility.end();
      if (Shaders.isShadowPass) {
         Shaders.mcProfilerEndSection();
      } else {
         this.mc.mcProfiler.endStartSection("rebuildNear");
         this.renderDispatcher.clearChunkUpdates();
         Set var41 = this.chunksToUpdate;
         this.chunksToUpdate = Sets.newLinkedHashSet();
         Lagometer.timerChunkUpdate.start();

         for (RenderGlobal.ContainerLocalRenderInformation var47 : this.renderInfos) {
            RenderChunk var50 = var47.renderChunk;
            if (var50.isNeedsUpdate() || var41.contains(var50)) {
               this.displayListEntitiesDirty = true;
               BlockPos var53 = var50.getPosition();
               boolean var56 = var39.distanceSq(var53.getX() + 8, var53.getY() + 8, var53.getZ() + 8) < 768.0;
               if (!var56) {
                  this.chunksToUpdate.add(var50);
               } else if (!var50.isPlayerUpdate()) {
                  this.chunksToUpdateForced.add(var50);
               } else {
                  this.mc.mcProfiler.startSection("build near");
                  this.renderDispatcher.updateChunkNow(var50);
                  var50.setNeedsUpdate(false);
                  this.mc.mcProfiler.endSection();
               }
            }
         }

         Lagometer.timerChunkUpdate.end();
         this.chunksToUpdate.addAll(var41);
         this.mc.mcProfiler.endSection();
      }
   }

   private boolean isPositionInRenderChunk(BlockPos var1, RenderChunk var2) {
      BlockPos var3 = var2.getPosition();
      return MathHelper.abs_int(var1.getX() - var3.getX()) > 16
         ? false
         : (MathHelper.abs_int(var1.getY() - var3.getY()) > 16 ? false : MathHelper.abs_int(var1.getZ() - var3.getZ()) <= 16);
   }

   private Set<EnumFacing> getVisibleFacings(BlockPos var1) {
      VisGraph var2 = new VisGraph();
      BlockPos var3 = new BlockPos(var1.getX() >> 4 << 4, var1.getY() >> 4 << 4, var1.getZ() >> 4 << 4);
      Chunk var4 = this.theWorld.getChunkFromBlockCoords(var3);

      for (MutableBlockPos var6 : BlockPos.getAllInBoxMutable(var3, var3.add(15, 15, 15))) {
         if (var4.getBlock(var6).isOpaqueCube()) {
            var2.func_178606_a(var6);
         }
      }

      return var2.func_178609_b(var1);
   }

   private RenderChunk getRenderChunkOffset(BlockPos var1, RenderChunk var2, EnumFacing var3, boolean var4, int var5) {
      RenderChunk var6 = var2.getRenderChunkNeighbour(var3);
      if (var6 == null) {
         return null;
      } else if (var6.getPosition().getY() > var5) {
         return null;
      } else {
         if (var4) {
            BlockPos var7 = var6.getPosition();
            int var8 = var1.getX() - var7.getX();
            int var9 = var1.getZ() - var7.getZ();
            int var10 = var8 * var8 + var9 * var9;
            if (var10 > this.renderDistanceSq) {
               return null;
            }
         }

         return var6;
      }
   }

   private void fixTerrainFrustum(double var1, double var3, double var5) {
      this.debugFixedClippingHelper = new ClippingHelperImpl();
      ((ClippingHelperImpl)this.debugFixedClippingHelper).init();
      Matrix4f var7 = new Matrix4f(this.debugFixedClippingHelper.modelviewMatrix);
      var7.transpose();
      Matrix4f var8 = new Matrix4f(this.debugFixedClippingHelper.projectionMatrix);
      var8.transpose();
      Matrix4f var9 = new Matrix4f();
      Matrix4f.mul(var8, var7, var9);
      var9.invert();
      this.debugTerrainFrustumPosition.x = var1;
      this.debugTerrainFrustumPosition.y = var3;
      this.debugTerrainFrustumPosition.z = var5;
      this.debugTerrainMatrix[0] = new Vector4f(-1.0F, -1.0F, -1.0F, 1.0F);
      this.debugTerrainMatrix[1] = new Vector4f(1.0F, -1.0F, -1.0F, 1.0F);
      this.debugTerrainMatrix[2] = new Vector4f(1.0F, 1.0F, -1.0F, 1.0F);
      this.debugTerrainMatrix[3] = new Vector4f(-1.0F, 1.0F, -1.0F, 1.0F);
      this.debugTerrainMatrix[4] = new Vector4f(-1.0F, -1.0F, 1.0F, 1.0F);
      this.debugTerrainMatrix[5] = new Vector4f(1.0F, -1.0F, 1.0F, 1.0F);
      this.debugTerrainMatrix[6] = new Vector4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.debugTerrainMatrix[7] = new Vector4f(-1.0F, 1.0F, 1.0F, 1.0F);

      for (int var10 = 0; var10 < 8; var10++) {
         Matrix4f.transform(var9, this.debugTerrainMatrix[var10], this.debugTerrainMatrix[var10]);
         this.debugTerrainMatrix[var10].x = this.debugTerrainMatrix[var10].x / this.debugTerrainMatrix[var10].w;
         this.debugTerrainMatrix[var10].y = this.debugTerrainMatrix[var10].y / this.debugTerrainMatrix[var10].w;
         this.debugTerrainMatrix[var10].z = this.debugTerrainMatrix[var10].z / this.debugTerrainMatrix[var10].w;
         this.debugTerrainMatrix[var10].w = 1.0F;
      }
   }

   protected Vector3f getViewVector(Entity var1, double var2) {
      float var4 = (float)(var1.prevRotationPitch + (var1.rotationPitch - var1.prevRotationPitch) * var2);
      float var5 = (float)(var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var2);
      if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) {
         var4 += 180.0F;
      }

      float var6 = MathHelper.cos(-var5 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var7 = MathHelper.sin(-var5 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var8 = -MathHelper.cos(-var4 * (float) (Math.PI / 180.0));
      float var9 = MathHelper.sin(-var4 * (float) (Math.PI / 180.0));
      return new Vector3f(var7 * var8, var9, var6 * var8);
   }

   public int renderBlockLayer(EnumWorldBlockLayer var1, double var2, int var4, Entity var5) {
      RenderHelper.disableStandardItemLighting();
      if (var1 == EnumWorldBlockLayer.TRANSLUCENT && !Shaders.isShadowPass) {
         this.mc.mcProfiler.startSection("translucent_sort");
         double var6 = var5.posX - this.prevRenderSortX;
         double var8 = var5.posY - this.prevRenderSortY;
         double var10 = var5.posZ - this.prevRenderSortZ;
         if (var6 * var6 + var8 * var8 + var10 * var10 > 1.0) {
            this.prevRenderSortX = var5.posX;
            this.prevRenderSortY = var5.posY;
            this.prevRenderSortZ = var5.posZ;
            int var12 = 0;
            this.chunksToResortTransparency.clear();

            for (RenderGlobal.ContainerLocalRenderInformation var14 : this.renderInfos) {
               if (var14.renderChunk.compiledChunk.isLayerStarted(var1) && var12++ < 15) {
                  this.chunksToResortTransparency.add(var14.renderChunk);
               }
            }
         }

         this.mc.mcProfiler.endSection();
      }

      this.mc.mcProfiler.startSection("filterempty");
      int var15 = 0;
      boolean var7 = var1 == EnumWorldBlockLayer.TRANSLUCENT;
      int var16 = var7 ? this.renderInfos.size() - 1 : 0;
      int var9 = var7 ? -1 : this.renderInfos.size();
      int var17 = var7 ? -1 : 1;

      for (int var11 = var16; var11 != var9; var11 += var17) {
         RenderChunk var18 = this.renderInfos.get(var11).renderChunk;
         if (!var18.getCompiledChunk().isLayerEmpty(var1)) {
            var15++;
            this.renderContainer.addRenderChunk(var18, var1);
         }
      }

      if (var15 == 0) {
         this.mc.mcProfiler.endSection();
         return var15;
      } else {
         if (Config.isFogOff() && this.mc.entityRenderer.fogStandard) {
            GlStateManager.disableFog();
         }

         this.mc.mcProfiler.endStartSection("render_" + var1);
         this.renderBlockLayer(var1);
         this.mc.mcProfiler.endSection();
         return var15;
      }
   }

   private void renderBlockLayer(EnumWorldBlockLayer var1) {
      this.mc.entityRenderer.enableLightmap();
      if (OpenGlHelper.useVbo()) {
         GL11.glEnableClientState(32884);
         OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
         GL11.glEnableClientState(32888);
         OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
         GL11.glEnableClientState(32888);
         OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
         GL11.glEnableClientState(32886);
      }

      if (Config.isShaders()) {
         ShadersRender.preRenderChunkLayer(var1);
      }

      this.renderContainer.renderChunkLayer(var1);
      if (Config.isShaders()) {
         ShadersRender.postRenderChunkLayer(var1);
      }

      if (OpenGlHelper.useVbo()) {
         for (VertexFormatElement var3 : DefaultVertexFormats.BLOCK.getElements()) {
            EnumUsage var4 = var3.getUsage();
            int var5 = var3.getIndex();
            switch (var4) {
               case POSITION:
                  GL11.glDisableClientState(32884);
                  break;
               case UV:
                  OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + var5);
                  GL11.glDisableClientState(32888);
                  OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                  break;
               case COLOR:
                  GL11.glDisableClientState(32886);
                  GlStateManager.resetColor();
            }
         }
      }

      this.mc.entityRenderer.disableLightmap();
   }

   private void cleanupDamagedBlocks(Iterator<DestroyBlockProgress> var1) {
      while (var1.hasNext()) {
         DestroyBlockProgress var2 = (DestroyBlockProgress)var1.next();
         int var3 = var2.getCreationCloudUpdateTick();
         if (this.cloudTickCounter - var3 > 400) {
            var1.remove();
         }
      }
   }

   public void updateClouds() {
      if (Config.isShaders()) {
         if (Keyboard.isKeyDown(61) && Keyboard.isKeyDown(24)) {
            GuiShaderOptions var1 = new GuiShaderOptions((GuiScreen)null, Config.getGameSettings());
            Config.getMinecraft().displayGuiScreen(var1);
         }

         if (Keyboard.isKeyDown(61) && Keyboard.isKeyDown(19)) {
            Shaders.uninit();
            Shaders.loadShaderPack();
         }
      }

      this.cloudTickCounter++;
      if (this.cloudTickCounter % 20 == 0) {
         this.cleanupDamagedBlocks(this.damagedBlocks.values().iterator());
      }
   }

   private void renderSkyEnd() {
      if (Config.isSkyEnabled()) {
         GlStateManager.disableFog();
         GlStateManager.disableAlpha();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         RenderHelper.disableStandardItemLighting();
         GlStateManager.depthMask(false);
         this.renderEngine.bindTexture(locationEndSkyPng);
         Tessellator var1 = Tessellator.getInstance();
         WorldRenderer var2 = var1.getWorldRenderer();

         for (int var3 = 0; var3 < 6; var3++) {
            GlStateManager.pushMatrix();
            if (var3 == 1) {
               GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (var3 == 2) {
               GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (var3 == 3) {
               GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
            }

            if (var3 == 4) {
               GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
            }

            if (var3 == 5) {
               GlStateManager.rotate(-90.0F, 0.0F, 0.0F, 1.0F);
            }

            var2.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            int var4 = 40;
            int var5 = 40;
            int var6 = 40;
            if (Config.isCustomColors()) {
               Vec3 var7 = new Vec3(var4 / 255.0, var5 / 255.0, var6 / 255.0);
               var7 = CustomColors.getWorldSkyColor(var7, this.theWorld, this.mc.getRenderViewEntity(), 0.0F);
               var4 = (int)(var7.xCoord * 255.0);
               var5 = (int)(var7.yCoord * 255.0);
               var6 = (int)(var7.zCoord * 255.0);
            }

            var2.pos(-100.0, -100.0, -100.0).tex(0.0, 0.0).color(var4, var5, var6, 255).endVertex();
            var2.pos(-100.0, -100.0, 100.0).tex(0.0, 16.0).color(var4, var5, var6, 255).endVertex();
            var2.pos(100.0, -100.0, 100.0).tex(16.0, 16.0).color(var4, var5, var6, 255).endVertex();
            var2.pos(100.0, -100.0, -100.0).tex(16.0, 0.0).color(var4, var5, var6, 255).endVertex();
            var1.draw();
            GlStateManager.popMatrix();
         }

         GlStateManager.depthMask(true);
         GlStateManager.enableTexture2D();
         GlStateManager.enableAlpha();
         GlStateManager.disableBlend();
      }
   }

   public void renderSky(float var1, int var2) {
      if (Reflector.CompatWorldProvider_getSkyRenderer.exists()) {
         WorldProvider var3 = this.mc.theWorld.provider;
         Object var4 = Reflector.call(var3, Reflector.CompatWorldProvider_getSkyRenderer, new Object[0]);
         if (var4 != null) {
            Reflector.callVoid(var4, Reflector.IRenderHandler_render, new Object[]{var1, this.theWorld, this.mc});
            return;
         }
      }

      if (this.mc.theWorld.provider.getDimensionId() == 1) {
         this.renderSkyEnd();
      } else if (this.mc.theWorld.provider.isSurfaceWorld()) {
         GlStateManager.disableTexture2D();
         boolean var20 = Config.isShaders();
         if (var20) {
            Shaders.disableTexture2D();
         }

         Vec3 var21 = this.theWorld.getSkyColor(this.mc.getRenderViewEntity(), var1);
         var21 = CustomColors.getSkyColor(
            var21, this.mc.theWorld, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ
         );
         if (var20) {
            Shaders.setSkyColor(var21);
         }

         float var5 = (float)var21.xCoord;
         float var6 = (float)var21.yCoord;
         float var7 = (float)var21.zCoord;
         if (var2 != 2) {
            float var8 = (var5 * 30.0F + var6 * 59.0F + var7 * 11.0F) / 100.0F;
            float var9 = (var5 * 30.0F + var6 * 70.0F) / 100.0F;
            float var10 = (var5 * 30.0F + var7 * 70.0F) / 100.0F;
            var5 = var8;
            var6 = var9;
            var7 = var10;
         }

         GlStateManager.color(var5, var6, var7);
         Tessellator var23 = Tessellator.getInstance();
         WorldRenderer var24 = var23.getWorldRenderer();
         GlStateManager.depthMask(false);
         GlStateManager.enableFog();
         if (var20) {
            Shaders.enableFog();
         }

         GlStateManager.color(var5, var6, var7);
         if (var20) {
            Shaders.preSkyList();
         }

         if (Config.isSkyEnabled()) {
            if (this.vboEnabled) {
               this.skyVBO.bindBuffer();
               GL11.glEnableClientState(32884);
               GL11.glVertexPointer(3, 5126, 12, 0L);
               this.skyVBO.drawArrays(7);
               this.skyVBO.unbindBuffer();
               GL11.glDisableClientState(32884);
            } else {
               GlStateManager.callList(this.glSkyList);
            }
         }

         GlStateManager.disableFog();
         if (var20) {
            Shaders.disableFog();
         }

         GlStateManager.disableAlpha();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         RenderHelper.disableStandardItemLighting();
         float[] var25 = this.theWorld.provider.calcSunriseSunsetColors(this.theWorld.getCelestialAngle(var1), var1);
         if (var25 != null && Config.isSunMoonEnabled()) {
            GlStateManager.disableTexture2D();
            if (var20) {
               Shaders.disableTexture2D();
            }

            GlStateManager.shadeModel(7425);
            GlStateManager.pushMatrix();
            GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(MathHelper.sin(this.theWorld.getCelestialAngleRadians(var1)) < 0.0F ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
            float var11 = var25[0];
            float var12 = var25[1];
            float var13 = var25[2];
            if (var2 != 2) {
               float var14 = (var11 * 30.0F + var12 * 59.0F + var13 * 11.0F) / 100.0F;
               float var15 = (var11 * 30.0F + var12 * 70.0F) / 100.0F;
               float var16 = (var11 * 30.0F + var13 * 70.0F) / 100.0F;
               var11 = var14;
               var12 = var15;
               var13 = var16;
            }

            var24.begin(6, DefaultVertexFormats.POSITION_COLOR);
            var24.pos(0.0, 100.0, 0.0).color(var11, var12, var13, var25[3]).endVertex();
            byte var31 = 16;

            for (int var34 = 0; var34 <= 16; var34++) {
               float var36 = var34 * (float) Math.PI * 2.0F / 16.0F;
               float var17 = MathHelper.sin(var36);
               float var18 = MathHelper.cos(var36);
               var24.pos(var17 * 120.0F, var18 * 120.0F, -var18 * 40.0F * var25[3]).color(var25[0], var25[1], var25[2], 0.0F).endVertex();
            }

            var23.draw();
            GlStateManager.popMatrix();
            GlStateManager.shadeModel(7424);
         }

         GlStateManager.enableTexture2D();
         if (var20) {
            Shaders.enableTexture2D();
         }

         GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
         GlStateManager.pushMatrix();
         float var26 = 1.0F - this.theWorld.getRainStrength(var1);
         GlStateManager.color(1.0F, 1.0F, 1.0F, var26);
         GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
         CustomSky.renderSky(this.theWorld, this.renderEngine, var1);
         if (var20) {
            Shaders.preCelestialRotate();
         }

         GlStateManager.rotate(this.theWorld.getCelestialAngle(var1) * 360.0F, 1.0F, 0.0F, 0.0F);
         if (var20) {
            Shaders.postCelestialRotate();
         }

         float var27 = 30.0F;
         if (Config.isSunTexture()) {
            this.renderEngine.bindTexture(locationSunPng);
            var24.begin(7, DefaultVertexFormats.POSITION_TEX);
            var24.pos(-var27, 100.0, -var27).tex(0.0, 0.0).endVertex();
            var24.pos(var27, 100.0, -var27).tex(1.0, 0.0).endVertex();
            var24.pos(var27, 100.0, var27).tex(1.0, 1.0).endVertex();
            var24.pos(-var27, 100.0, var27).tex(0.0, 1.0).endVertex();
            var23.draw();
         }

         var27 = 20.0F;
         if (Config.isMoonTexture()) {
            this.renderEngine.bindTexture(locationMoonPhasesPng);
            int var29 = this.theWorld.getMoonPhase();
            int var32 = var29 % 4;
            int var35 = var29 / 4 % 2;
            float var37 = (var32 + 0) / 4.0F;
            float var39 = (var35 + 0) / 2.0F;
            float var41 = (var32 + 1) / 4.0F;
            float var19 = (var35 + 1) / 2.0F;
            var24.begin(7, DefaultVertexFormats.POSITION_TEX);
            var24.pos(-var27, -100.0, var27).tex(var41, var19).endVertex();
            var24.pos(var27, -100.0, var27).tex(var37, var19).endVertex();
            var24.pos(var27, -100.0, -var27).tex(var37, var39).endVertex();
            var24.pos(-var27, -100.0, -var27).tex(var41, var39).endVertex();
            var23.draw();
         }

         GlStateManager.disableTexture2D();
         if (var20) {
            Shaders.disableTexture2D();
         }

         float var30 = this.theWorld.getStarBrightness(var1) * var26;
         if (var30 > 0.0F && Config.isStarsEnabled() && !CustomSky.hasSkyLayers(this.theWorld)) {
            GlStateManager.color(var30, var30, var30, var30);
            if (this.vboEnabled) {
               this.starVBO.bindBuffer();
               GL11.glEnableClientState(32884);
               GL11.glVertexPointer(3, 5126, 12, 0L);
               this.starVBO.drawArrays(7);
               this.starVBO.unbindBuffer();
               GL11.glDisableClientState(32884);
            } else {
               GlStateManager.callList(this.starGLCallList);
            }
         }

         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.disableBlend();
         GlStateManager.enableAlpha();
         GlStateManager.enableFog();
         if (var20) {
            Shaders.enableFog();
         }

         GlStateManager.popMatrix();
         GlStateManager.disableTexture2D();
         if (var20) {
            Shaders.disableTexture2D();
         }

         GlStateManager.color(0.0F, 0.0F, 0.0F);
         double var33 = this.mc.thePlayer.getPositionEyes(var1).yCoord - this.theWorld.getHorizon();
         if (var33 < 0.0 && !oc4e1b577a95.Ȩ()) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 12.0F, 0.0F);
            if (this.vboEnabled) {
               this.sky2VBO.bindBuffer();
               GL11.glEnableClientState(32884);
               GL11.glVertexPointer(3, 5126, 12, 0L);
               this.sky2VBO.drawArrays(7);
               this.sky2VBO.unbindBuffer();
               GL11.glDisableClientState(32884);
            } else {
               GlStateManager.callList(this.glSkyList2);
            }

            GlStateManager.popMatrix();
            float var38 = 1.0F;
            float var40 = -((float)(var33 + 65.0));
            float var42 = -1.0F;
            var24.begin(7, DefaultVertexFormats.POSITION_COLOR);
            var24.pos(-1.0, var40, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, var40, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, var40, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, var40, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, var40, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, var40, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, var40, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, var40, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
            var24.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
            var23.draw();
         }

         if (this.theWorld.provider.isSkyColored()) {
            GlStateManager.color(var5 * 0.2F + 0.04F, var6 * 0.2F + 0.04F, var7 * 0.6F + 0.1F);
         } else {
            GlStateManager.color(var5, var6, var7);
         }

         if (this.mc.gameSettings.renderDistanceChunks <= 4) {
            GlStateManager.color(this.mc.entityRenderer.fogColorRed, this.mc.entityRenderer.fogColorGreen, this.mc.entityRenderer.fogColorBlue);
         }

         GlStateManager.pushMatrix();
         GlStateManager.translate(0.0F, -((float)(var33 - 16.0)), 0.0F);
         if (Config.isSkyEnabled()) {
            if (this.vboEnabled) {
               this.sky2VBO.bindBuffer();
               GlStateManager.glEnableClientState(32884);
               GlStateManager.glVertexPointer(3, 5126, 12, 0);
               this.sky2VBO.drawArrays(7);
               this.sky2VBO.unbindBuffer();
               GlStateManager.glDisableClientState(32884);
            } else {
               GlStateManager.callList(this.glSkyList2);
            }
         }

         GlStateManager.popMatrix();
         GlStateManager.enableTexture2D();
         if (var20) {
            Shaders.enableTexture2D();
         }

         GlStateManager.depthMask(true);
      }
   }

   public void renderClouds(float var1, int var2) {
      if (!Config.isCloudsOff()) {
         if (Reflector.CompatWorldProvider_getCloudRenderer.exists()) {
            WorldProvider var3 = this.mc.theWorld.provider;
            Object var4 = Reflector.call(var3, Reflector.CompatWorldProvider_getCloudRenderer, new Object[0]);
            if (var4 != null) {
               Reflector.callVoid(var4, Reflector.IRenderHandler_render, new Object[]{var1, this.theWorld, this.mc});
               return;
            }
         }

         if (this.mc.theWorld.provider.isSurfaceWorld()) {
            if (Config.isShaders()) {
               Shaders.beginClouds();
            }

            if (Config.isCloudsFancy()) {
               this.renderCloudsFancy(var1, var2);
            } else {
               float var27 = 0.0F;
               GlStateManager.disableCull();
               float var29 = (float)(
                  this.mc.getRenderViewEntity().lastTickPosY + (this.mc.getRenderViewEntity().posY - this.mc.getRenderViewEntity().lastTickPosY) * var27
               );
               byte var5 = 32;
               byte var6 = 8;
               Tessellator var7 = Tessellator.getInstance();
               WorldRenderer var8 = var7.getWorldRenderer();
               this.renderEngine.bindTexture(locationCloudsPng);
               GlStateManager.enableBlend();
               GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
               Vec3 var9 = this.theWorld.getCloudColour(var27);
               float var10 = (float)var9.xCoord;
               float var11 = (float)var9.yCoord;
               float var12 = (float)var9.zCoord;
               this.cloudRenderer.prepareToRender(false, this.cloudTickCounter, var1, var9);
               if (this.cloudRenderer.shouldUpdateGlList()) {
                  this.cloudRenderer.startUpdateGlList();
                  if (var2 != 2) {
                     float var13 = (var10 * 30.0F + var11 * 59.0F + var12 * 11.0F) / 100.0F;
                     float var14 = (var10 * 30.0F + var11 * 70.0F) / 100.0F;
                     float var15 = (var10 * 30.0F + var12 * 70.0F) / 100.0F;
                     var10 = var13;
                     var11 = var14;
                     var12 = var15;
                  }

                  float var30 = 4.8828125E-4F;
                  double var31 = this.cloudTickCounter + var27;
                  double var16 = this.mc.getRenderViewEntity().prevPosX
                     + (this.mc.getRenderViewEntity().posX - this.mc.getRenderViewEntity().prevPosX) * var27
                     + var31 * 0.03F;
                  double var18 = this.mc.getRenderViewEntity().prevPosZ + (this.mc.getRenderViewEntity().posZ - this.mc.getRenderViewEntity().prevPosZ) * var27;
                  int var20 = MathHelper.floor_double(var16 / 2048.0);
                  int var21 = MathHelper.floor_double(var18 / 2048.0);
                  var16 -= var20 * 2048;
                  var18 -= var21 * 2048;
                  float var22 = this.theWorld.provider.getCloudHeight() - var29 + 0.33F;
                  var22 += this.mc.gameSettings.ofCloudsHeight * 128.0F;
                  float var23 = (float)(var16 * 4.8828125E-4);
                  float var24 = (float)(var18 * 4.8828125E-4);
                  var8.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);

                  for (short var25 = -256; var25 < 256; var25 += 32) {
                     for (short var26 = -256; var26 < 256; var26 += 32) {
                        var8.pos(var25 + 0, var22, var26 + 32)
                           .tex((var25 + 0) * 4.8828125E-4F + var23, (var26 + 32) * 4.8828125E-4F + var24)
                           .color(var10, var11, var12, 0.8F)
                           .endVertex();
                        var8.pos(var25 + 32, var22, var26 + 32)
                           .tex((var25 + 32) * 4.8828125E-4F + var23, (var26 + 32) * 4.8828125E-4F + var24)
                           .color(var10, var11, var12, 0.8F)
                           .endVertex();
                        var8.pos(var25 + 32, var22, var26 + 0)
                           .tex((var25 + 32) * 4.8828125E-4F + var23, (var26 + 0) * 4.8828125E-4F + var24)
                           .color(var10, var11, var12, 0.8F)
                           .endVertex();
                        var8.pos(var25 + 0, var22, var26 + 0)
                           .tex((var25 + 0) * 4.8828125E-4F + var23, (var26 + 0) * 4.8828125E-4F + var24)
                           .color(var10, var11, var12, 0.8F)
                           .endVertex();
                     }
                  }

                  var7.draw();
                  this.cloudRenderer.endUpdateGlList();
               }

               this.cloudRenderer.renderGlList();
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               GlStateManager.disableBlend();
               GlStateManager.enableCull();
            }

            if (Config.isShaders()) {
               Shaders.endClouds();
            }
         }
      }
   }

   public boolean hasCloudFog(double var1, double var3, double var5, float var7) {
      return false;
   }

   private void renderCloudsFancy(float var1, int var2) {
      var1 = 0.0F;
      GlStateManager.disableCull();
      float var3 = (float)(
         this.mc.getRenderViewEntity().lastTickPosY + (this.mc.getRenderViewEntity().posY - this.mc.getRenderViewEntity().lastTickPosY) * var1
      );
      Tessellator var4 = Tessellator.getInstance();
      WorldRenderer var5 = var4.getWorldRenderer();
      float var6 = 12.0F;
      float var7 = 4.0F;
      double var8 = this.cloudTickCounter + var1;
      double var10 = (
            this.mc.getRenderViewEntity().prevPosX + (this.mc.getRenderViewEntity().posX - this.mc.getRenderViewEntity().prevPosX) * var1 + var8 * 0.03F
         )
         / 12.0;
      double var12 = (this.mc.getRenderViewEntity().prevPosZ + (this.mc.getRenderViewEntity().posZ - this.mc.getRenderViewEntity().prevPosZ) * var1) / 12.0
         + 0.33F;
      float var14 = this.theWorld.provider.getCloudHeight() - var3 + 0.33F;
      var14 += this.mc.gameSettings.ofCloudsHeight * 128.0F;
      int var15 = MathHelper.floor_double(var10 / 2048.0);
      int var16 = MathHelper.floor_double(var12 / 2048.0);
      var10 -= var15 * 2048;
      var12 -= var16 * 2048;
      this.renderEngine.bindTexture(locationCloudsPng);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      Vec3 var17 = this.theWorld.getCloudColour(var1);
      float var18 = (float)var17.xCoord;
      float var19 = (float)var17.yCoord;
      float var20 = (float)var17.zCoord;
      this.cloudRenderer.prepareToRender(true, this.cloudTickCounter, var1, var17);
      if (var2 != 2) {
         float var21 = (var18 * 30.0F + var19 * 59.0F + var20 * 11.0F) / 100.0F;
         float var22 = (var18 * 30.0F + var19 * 70.0F) / 100.0F;
         float var23 = (var18 * 30.0F + var20 * 70.0F) / 100.0F;
         var18 = var21;
         var19 = var22;
         var20 = var23;
      }

      float var49 = var18 * 0.9F;
      float var50 = var19 * 0.9F;
      float var51 = var20 * 0.9F;
      float var24 = var18 * 0.7F;
      float var25 = var19 * 0.7F;
      float var26 = var20 * 0.7F;
      float var27 = var18 * 0.8F;
      float var28 = var19 * 0.8F;
      float var29 = var20 * 0.8F;
      float var30 = 0.00390625F;
      float var31 = MathHelper.floor_double(var10) * 0.00390625F;
      float var32 = MathHelper.floor_double(var12) * 0.00390625F;
      float var33 = (float)(var10 - MathHelper.floor_double(var10));
      float var34 = (float)(var12 - MathHelper.floor_double(var12));
      byte var35 = 8;
      byte var36 = 4;
      float var37 = 9.765625E-4F;
      GlStateManager.scale(12.0F, 1.0F, 12.0F);

      for (int var38 = 0; var38 < 2; var38++) {
         if (var38 == 0) {
            GlStateManager.colorMask(false, false, false, false);
         } else {
            switch (var2) {
               case 0:
                  GlStateManager.colorMask(false, true, true, true);
                  break;
               case 1:
                  GlStateManager.colorMask(true, false, false, true);
                  break;
               case 2:
                  GlStateManager.colorMask(true, true, true, true);
            }
         }

         this.cloudRenderer.renderGlList();
      }

      if (this.cloudRenderer.shouldUpdateGlList()) {
         this.cloudRenderer.startUpdateGlList();

         for (int var52 = -3; var52 <= 4; var52++) {
            for (int var39 = -3; var39 <= 4; var39++) {
               var5.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
               float var40 = var52 * 8;
               float var41 = var39 * 8;
               float var42 = var40 - var33;
               float var43 = var41 - var34;
               if (var14 > -5.0F) {
                  var5.pos(var42 + 0.0F, var14 + 0.0F, var43 + 8.0F)
                     .tex((var40 + 0.0F) * 0.00390625F + var31, (var41 + 8.0F) * 0.00390625F + var32)
                     .color(var24, var25, var26, 0.8F)
                     .normal(0.0F, -1.0F, 0.0F)
                     .endVertex();
                  var5.pos(var42 + 8.0F, var14 + 0.0F, var43 + 8.0F)
                     .tex((var40 + 8.0F) * 0.00390625F + var31, (var41 + 8.0F) * 0.00390625F + var32)
                     .color(var24, var25, var26, 0.8F)
                     .normal(0.0F, -1.0F, 0.0F)
                     .endVertex();
                  var5.pos(var42 + 8.0F, var14 + 0.0F, var43 + 0.0F)
                     .tex((var40 + 8.0F) * 0.00390625F + var31, (var41 + 0.0F) * 0.00390625F + var32)
                     .color(var24, var25, var26, 0.8F)
                     .normal(0.0F, -1.0F, 0.0F)
                     .endVertex();
                  var5.pos(var42 + 0.0F, var14 + 0.0F, var43 + 0.0F)
                     .tex((var40 + 0.0F) * 0.00390625F + var31, (var41 + 0.0F) * 0.00390625F + var32)
                     .color(var24, var25, var26, 0.8F)
                     .normal(0.0F, -1.0F, 0.0F)
                     .endVertex();
               }

               if (var14 <= 5.0F) {
                  var5.pos(var42 + 0.0F, var14 + 4.0F - 9.765625E-4F, var43 + 8.0F)
                     .tex((var40 + 0.0F) * 0.00390625F + var31, (var41 + 8.0F) * 0.00390625F + var32)
                     .color(var18, var19, var20, 0.8F)
                     .normal(0.0F, 1.0F, 0.0F)
                     .endVertex();
                  var5.pos(var42 + 8.0F, var14 + 4.0F - 9.765625E-4F, var43 + 8.0F)
                     .tex((var40 + 8.0F) * 0.00390625F + var31, (var41 + 8.0F) * 0.00390625F + var32)
                     .color(var18, var19, var20, 0.8F)
                     .normal(0.0F, 1.0F, 0.0F)
                     .endVertex();
                  var5.pos(var42 + 8.0F, var14 + 4.0F - 9.765625E-4F, var43 + 0.0F)
                     .tex((var40 + 8.0F) * 0.00390625F + var31, (var41 + 0.0F) * 0.00390625F + var32)
                     .color(var18, var19, var20, 0.8F)
                     .normal(0.0F, 1.0F, 0.0F)
                     .endVertex();
                  var5.pos(var42 + 0.0F, var14 + 4.0F - 9.765625E-4F, var43 + 0.0F)
                     .tex((var40 + 0.0F) * 0.00390625F + var31, (var41 + 0.0F) * 0.00390625F + var32)
                     .color(var18, var19, var20, 0.8F)
                     .normal(0.0F, 1.0F, 0.0F)
                     .endVertex();
               }

               if (var52 > -1) {
                  for (int var44 = 0; var44 < 8; var44++) {
                     var5.pos(var42 + var44 + 0.0F, var14 + 0.0F, var43 + 8.0F)
                        .tex((var40 + var44 + 0.5F) * 0.00390625F + var31, (var41 + 8.0F) * 0.00390625F + var32)
                        .color(var49, var50, var51, 0.8F)
                        .normal(-1.0F, 0.0F, 0.0F)
                        .endVertex();
                     var5.pos(var42 + var44 + 0.0F, var14 + 4.0F, var43 + 8.0F)
                        .tex((var40 + var44 + 0.5F) * 0.00390625F + var31, (var41 + 8.0F) * 0.00390625F + var32)
                        .color(var49, var50, var51, 0.8F)
                        .normal(-1.0F, 0.0F, 0.0F)
                        .endVertex();
                     var5.pos(var42 + var44 + 0.0F, var14 + 4.0F, var43 + 0.0F)
                        .tex((var40 + var44 + 0.5F) * 0.00390625F + var31, (var41 + 0.0F) * 0.00390625F + var32)
                        .color(var49, var50, var51, 0.8F)
                        .normal(-1.0F, 0.0F, 0.0F)
                        .endVertex();
                     var5.pos(var42 + var44 + 0.0F, var14 + 0.0F, var43 + 0.0F)
                        .tex((var40 + var44 + 0.5F) * 0.00390625F + var31, (var41 + 0.0F) * 0.00390625F + var32)
                        .color(var49, var50, var51, 0.8F)
                        .normal(-1.0F, 0.0F, 0.0F)
                        .endVertex();
                  }
               }

               if (var52 <= 1) {
                  for (int var53 = 0; var53 < 8; var53++) {
                     var5.pos(var42 + var53 + 1.0F - 9.765625E-4F, var14 + 0.0F, var43 + 8.0F)
                        .tex((var40 + var53 + 0.5F) * 0.00390625F + var31, (var41 + 8.0F) * 0.00390625F + var32)
                        .color(var49, var50, var51, 0.8F)
                        .normal(1.0F, 0.0F, 0.0F)
                        .endVertex();
                     var5.pos(var42 + var53 + 1.0F - 9.765625E-4F, var14 + 4.0F, var43 + 8.0F)
                        .tex((var40 + var53 + 0.5F) * 0.00390625F + var31, (var41 + 8.0F) * 0.00390625F + var32)
                        .color(var49, var50, var51, 0.8F)
                        .normal(1.0F, 0.0F, 0.0F)
                        .endVertex();
                     var5.pos(var42 + var53 + 1.0F - 9.765625E-4F, var14 + 4.0F, var43 + 0.0F)
                        .tex((var40 + var53 + 0.5F) * 0.00390625F + var31, (var41 + 0.0F) * 0.00390625F + var32)
                        .color(var49, var50, var51, 0.8F)
                        .normal(1.0F, 0.0F, 0.0F)
                        .endVertex();
                     var5.pos(var42 + var53 + 1.0F - 9.765625E-4F, var14 + 0.0F, var43 + 0.0F)
                        .tex((var40 + var53 + 0.5F) * 0.00390625F + var31, (var41 + 0.0F) * 0.00390625F + var32)
                        .color(var49, var50, var51, 0.8F)
                        .normal(1.0F, 0.0F, 0.0F)
                        .endVertex();
                  }
               }

               if (var39 > -1) {
                  for (int var54 = 0; var54 < 8; var54++) {
                     var5.pos(var42 + 0.0F, var14 + 4.0F, var43 + var54 + 0.0F)
                        .tex((var40 + 0.0F) * 0.00390625F + var31, (var41 + var54 + 0.5F) * 0.00390625F + var32)
                        .color(var27, var28, var29, 0.8F)
                        .normal(0.0F, 0.0F, -1.0F)
                        .endVertex();
                     var5.pos(var42 + 8.0F, var14 + 4.0F, var43 + var54 + 0.0F)
                        .tex((var40 + 8.0F) * 0.00390625F + var31, (var41 + var54 + 0.5F) * 0.00390625F + var32)
                        .color(var27, var28, var29, 0.8F)
                        .normal(0.0F, 0.0F, -1.0F)
                        .endVertex();
                     var5.pos(var42 + 8.0F, var14 + 0.0F, var43 + var54 + 0.0F)
                        .tex((var40 + 8.0F) * 0.00390625F + var31, (var41 + var54 + 0.5F) * 0.00390625F + var32)
                        .color(var27, var28, var29, 0.8F)
                        .normal(0.0F, 0.0F, -1.0F)
                        .endVertex();
                     var5.pos(var42 + 0.0F, var14 + 0.0F, var43 + var54 + 0.0F)
                        .tex((var40 + 0.0F) * 0.00390625F + var31, (var41 + var54 + 0.5F) * 0.00390625F + var32)
                        .color(var27, var28, var29, 0.8F)
                        .normal(0.0F, 0.0F, -1.0F)
                        .endVertex();
                  }
               }

               if (var39 <= 1) {
                  for (int var55 = 0; var55 < 8; var55++) {
                     var5.pos(var42 + 0.0F, var14 + 4.0F, var43 + var55 + 1.0F - 9.765625E-4F)
                        .tex((var40 + 0.0F) * 0.00390625F + var31, (var41 + var55 + 0.5F) * 0.00390625F + var32)
                        .color(var27, var28, var29, 0.8F)
                        .normal(0.0F, 0.0F, 1.0F)
                        .endVertex();
                     var5.pos(var42 + 8.0F, var14 + 4.0F, var43 + var55 + 1.0F - 9.765625E-4F)
                        .tex((var40 + 8.0F) * 0.00390625F + var31, (var41 + var55 + 0.5F) * 0.00390625F + var32)
                        .color(var27, var28, var29, 0.8F)
                        .normal(0.0F, 0.0F, 1.0F)
                        .endVertex();
                     var5.pos(var42 + 8.0F, var14 + 0.0F, var43 + var55 + 1.0F - 9.765625E-4F)
                        .tex((var40 + 8.0F) * 0.00390625F + var31, (var41 + var55 + 0.5F) * 0.00390625F + var32)
                        .color(var27, var28, var29, 0.8F)
                        .normal(0.0F, 0.0F, 1.0F)
                        .endVertex();
                     var5.pos(var42 + 0.0F, var14 + 0.0F, var43 + var55 + 1.0F - 9.765625E-4F)
                        .tex((var40 + 0.0F) * 0.00390625F + var31, (var41 + var55 + 0.5F) * 0.00390625F + var32)
                        .color(var27, var28, var29, 0.8F)
                        .normal(0.0F, 0.0F, 1.0F)
                        .endVertex();
                  }
               }

               var4.draw();
            }
         }

         this.cloudRenderer.endUpdateGlList();
      }

      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.disableBlend();
      GlStateManager.enableCull();
   }

   public void updateChunks(long var1) {
      var1 = (long)(var1 + 1.0E8);
      this.displayListEntitiesDirty = this.displayListEntitiesDirty | this.renderDispatcher.runChunkUploads(var1);
      if (this.chunksToUpdateForced.size() > 0) {
         Iterator var3 = this.chunksToUpdateForced.iterator();

         while (var3.hasNext()) {
            RenderChunk var4 = (RenderChunk)var3.next();
            if (!this.renderDispatcher.updateChunkLater(var4)) {
               break;
            }

            var4.setNeedsUpdate(false);
            var3.remove();
            this.chunksToUpdate.remove(var4);
            this.chunksToResortTransparency.remove(var4);
         }
      }

      if (this.chunksToResortTransparency.size() > 0) {
         Iterator var13 = this.chunksToResortTransparency.iterator();
         if (var13.hasNext()) {
            RenderChunk var15 = (RenderChunk)var13.next();
            if (this.renderDispatcher.updateTransparencyLater(var15)) {
               var13.remove();
            }
         }
      }

      double var14 = 0.0;
      int var5 = Config.getUpdatesPerFrame();
      if (!this.chunksToUpdate.isEmpty()) {
         Iterator var6 = this.chunksToUpdate.iterator();

         while (var6.hasNext()) {
            RenderChunk var7 = (RenderChunk)var6.next();
            boolean var8 = var7.isChunkRegionEmpty();
            boolean var9;
            if (var8) {
               var9 = this.renderDispatcher.updateChunkNow(var7);
            } else {
               var9 = this.renderDispatcher.updateChunkLater(var7);
            }

            if (!var9) {
               break;
            }

            var7.setNeedsUpdate(false);
            var6.remove();
            if (!var8) {
               double var10 = 2.0 * RenderChunkUtils.getRelativeBufferSize(var7);
               var14 += var10;
               if (var14 > var5) {
                  break;
               }
            }
         }
      }
   }

   public void renderWorldBorder(Entity var1, float var2) {
      Tessellator var3 = Tessellator.getInstance();
      WorldRenderer var4 = var3.getWorldRenderer();
      WorldBorder var5 = this.theWorld.getWorldBorder();
      double var6 = getWorldBorderVisibilityDistance(this.mc.gameSettings.renderDistanceChunks);
      double var8 = getWorldBorderGeometryRadius(this.mc.gameSettings.renderDistanceChunks);
      if (var1.posX >= var5.maxX() - var6 || var1.posX <= var5.minX() + var6 || var1.posZ >= var5.maxZ() - var6 || var1.posZ <= var5.minZ() + var6) {
         if (Config.isShaders()) {
            Shaders.pushProgram();
            Shaders.useProgram(Shaders.ProgramTexturedLit);
         }

         double var10 = 1.0 - var5.getClosestDistance(var1) / var6;
         var10 = Math.pow(var10, 4.0);
         double var12 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * var2;
         double var14 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * var2;
         double var16 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * var2;
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
         this.renderEngine.bindTexture(locationForcefieldPng);
         GlStateManager.depthMask(false);
         GlStateManager.pushMatrix();
         int var18 = var5.getStatus().getID();
         float var19 = (var18 >> 16 & 0xFF) / 255.0F;
         float var20 = (var18 >> 8 & 0xFF) / 255.0F;
         float var21 = (var18 & 0xFF) / 255.0F;
         GlStateManager.color(var19, var20, var21, (float)var10);
         GlStateManager.doPolygonOffset(-3.0F, -3.0F);
         GlStateManager.enablePolygonOffset();
         GlStateManager.alphaFunc(516, 0.1F);
         GlStateManager.enableAlpha();
         GlStateManager.disableCull();
         float var22 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F;
         float var23 = 0.0F;
         float var24 = 0.0F;
         float var25 = 128.0F;
         var4.begin(7, DefaultVertexFormats.POSITION_TEX);
         var4.setTranslation(-var12, -var14, -var16);
         int var26 = 0;
         double var27 = Math.max((double)MathHelper.floor_double(var16 - var8), var5.minZ());
         double var29 = Math.min((double)MathHelper.ceiling_double_int(var16 + var8), var5.maxZ());
         if (var12 > var5.maxX() - var6) {
            float var31 = 0.0F;

            for (double var32 = var27; var32 < var29; var31 += 0.5F) {
               double var34 = Math.min(1.0, var29 - var32);
               float var36 = (float)var34 * 0.5F;
               var4.pos(var5.maxX(), 256.0, var32).tex(var22 + var31, var22 + 0.0F).endVertex();
               var4.pos(var5.maxX(), 256.0, var32 + var34).tex(var22 + var36 + var31, var22 + 0.0F).endVertex();
               var4.pos(var5.maxX(), 0.0, var32 + var34).tex(var22 + var36 + var31, var22 + 128.0F).endVertex();
               var4.pos(var5.maxX(), 0.0, var32).tex(var22 + var31, var22 + 128.0F).endVertex();
               if (++var26 >= 512) {
                  flushWorldBorderBatch(var3, var4, var12, var14, var16);
                  var26 = 0;
               }

               var32++;
            }
         }

         if (var12 < var5.minX() + var6) {
            float var40 = 0.0F;

            for (double var43 = var27; var43 < var29; var40 += 0.5F) {
               double var46 = Math.min(1.0, var29 - var43);
               float var49 = (float)var46 * 0.5F;
               var4.pos(var5.minX(), 256.0, var43).tex(var22 + var40, var22 + 0.0F).endVertex();
               var4.pos(var5.minX(), 256.0, var43 + var46).tex(var22 + var49 + var40, var22 + 0.0F).endVertex();
               var4.pos(var5.minX(), 0.0, var43 + var46).tex(var22 + var49 + var40, var22 + 128.0F).endVertex();
               var4.pos(var5.minX(), 0.0, var43).tex(var22 + var40, var22 + 128.0F).endVertex();
               if (++var26 >= 512) {
                  flushWorldBorderBatch(var3, var4, var12, var14, var16);
                  var26 = 0;
               }

               var43++;
            }
         }

         var27 = Math.max((double)MathHelper.floor_double(var12 - var8), var5.minX());
         var29 = Math.min((double)MathHelper.ceiling_double_int(var12 + var8), var5.maxX());
         if (var16 > var5.maxZ() - var6) {
            float var41 = 0.0F;

            for (double var44 = var27; var44 < var29; var41 += 0.5F) {
               double var47 = Math.min(1.0, var29 - var44);
               float var50 = (float)var47 * 0.5F;
               var4.pos(var44, 256.0, var5.maxZ()).tex(var22 + var41, var22 + 0.0F).endVertex();
               var4.pos(var44 + var47, 256.0, var5.maxZ()).tex(var22 + var50 + var41, var22 + 0.0F).endVertex();
               var4.pos(var44 + var47, 0.0, var5.maxZ()).tex(var22 + var50 + var41, var22 + 128.0F).endVertex();
               var4.pos(var44, 0.0, var5.maxZ()).tex(var22 + var41, var22 + 128.0F).endVertex();
               if (++var26 >= 512) {
                  flushWorldBorderBatch(var3, var4, var12, var14, var16);
                  var26 = 0;
               }

               var44++;
            }
         }

         if (var16 < var5.minZ() + var6) {
            float var42 = 0.0F;

            for (double var45 = var27; var45 < var29; var42 += 0.5F) {
               double var48 = Math.min(1.0, var29 - var45);
               float var51 = (float)var48 * 0.5F;
               var4.pos(var45, 256.0, var5.minZ()).tex(var22 + var42, var22 + 0.0F).endVertex();
               var4.pos(var45 + var48, 256.0, var5.minZ()).tex(var22 + var51 + var42, var22 + 0.0F).endVertex();
               var4.pos(var45 + var48, 0.0, var5.minZ()).tex(var22 + var51 + var42, var22 + 128.0F).endVertex();
               var4.pos(var45, 0.0, var5.minZ()).tex(var22 + var42, var22 + 128.0F).endVertex();
               if (++var26 >= 512) {
                  flushWorldBorderBatch(var3, var4, var12, var14, var16);
                  var26 = 0;
               }

               var45++;
            }
         }

         var3.draw();
         var4.setTranslation(0.0, 0.0, 0.0);
         GlStateManager.enableCull();
         GlStateManager.disableAlpha();
         GlStateManager.doPolygonOffset(0.0F, 0.0F);
         GlStateManager.disablePolygonOffset();
         GlStateManager.enableAlpha();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.disableBlend();
         GlStateManager.popMatrix();
         GlStateManager.depthMask(true);
         if (Config.isShaders()) {
            Shaders.popProgram();
         }
      }
   }

   static double getWorldBorderVisibilityDistance(int var0) {
      return Math.max(2.0, (double)var0) * 16.0;
   }

   static double getWorldBorderGeometryRadius(int var0) {
      return Math.min(getWorldBorderVisibilityDistance(var0), 512.0);
   }

   static int getWorldBorderBatchVertexLimit() {
      return 2048;
   }

   private static void flushWorldBorderBatch(Tessellator var0, WorldRenderer var1, double var2, double var4, double var6) {
      var0.draw();
      var1.begin(7, DefaultVertexFormats.POSITION_TEX);
      var1.setTranslation(-var2, -var4, -var6);
   }

   private void preRenderDamagedBlocks() {
      GlStateManager.tryBlendFuncSeparate(774, 768, 1, 0);
      GlStateManager.enableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
      GlStateManager.doPolygonOffset(-1.0F, -10.0F);
      GlStateManager.enablePolygonOffset();
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.enableAlpha();
      GlStateManager.pushMatrix();
      if (Config.isShaders()) {
         ShadersRender.beginBlockDamage();
      }
   }

   private void postRenderDamagedBlocks() {
      GlStateManager.disableAlpha();
      GlStateManager.doPolygonOffset(0.0F, 0.0F);
      GlStateManager.disablePolygonOffset();
      GlStateManager.enableAlpha();
      GlStateManager.depthMask(true);
      GlStateManager.popMatrix();
      if (Config.isShaders()) {
         ShadersRender.endBlockDamage();
      }
   }

   public void drawBlockDamageTexture(Tessellator var1, WorldRenderer var2, Entity var3, float var4) {
      double var5 = var3.lastTickPosX + (var3.posX - var3.lastTickPosX) * var4;
      double var7 = var3.lastTickPosY + (var3.posY - var3.lastTickPosY) * var4;
      double var9 = var3.lastTickPosZ + (var3.posZ - var3.lastTickPosZ) * var4;
      if (!this.damagedBlocks.isEmpty()) {
         this.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
         this.preRenderDamagedBlocks();
         var2.begin(7, DefaultVertexFormats.BLOCK);
         var2.setTranslation(-var5, -var7, -var9);
         var2.noColor();
         Iterator var11 = this.damagedBlocks.values().iterator();

         while (var11.hasNext()) {
            DestroyBlockProgress var12 = (DestroyBlockProgress)var11.next();
            BlockPos var13 = var12.getPosition();
            double var14 = var13.getX() - var5;
            double var16 = var13.getY() - var7;
            double var18 = var13.getZ() - var9;
            Block var20 = this.theWorld.getBlockState(var13).getBlock();
            boolean var21;
            if (Reflector.CompatTileEntity_canRenderBreaking.exists()) {
               boolean var22 = var20 instanceof BlockChest || var20 instanceof BlockEnderChest || var20 instanceof BlockSign || var20 instanceof BlockSkull;
               if (!var22) {
                  TileEntity var23 = this.theWorld.getTileEntity(var13);
                  if (var23 != null) {
                     var22 = Reflector.callBoolean(var23, Reflector.CompatTileEntity_canRenderBreaking, new Object[0]);
                  }
               }

               var21 = !var22;
            } else {
               var21 = !(var20 instanceof BlockChest) && !(var20 instanceof BlockEnderChest) && !(var20 instanceof BlockSign) && !(var20 instanceof BlockSkull);
            }

            if (var21) {
               if (var14 * var14 + var16 * var16 + var18 * var18 > 1024.0) {
                  var11.remove();
               } else {
                  IBlockState var26 = this.theWorld.getBlockState(var13);
                  if (var26.getBlock().getMaterial() != Material.air) {
                     int var27 = var12.getPartialBlockDamage();
                     TextureAtlasSprite var24 = this.destroyBlockIcons[var27];
                     BlockRendererDispatcher var25 = this.mc.getBlockRendererDispatcher();
                     var25.renderBlockDamage(var26, var13, var24, this.theWorld);
                  }
               }
            }
         }

         var1.draw();
         var2.setTranslation(0.0, 0.0, 0.0);
         this.postRenderDamagedBlocks();
      }
   }

   public void drawSelectionBox(EntityPlayer var1, MovingObjectPosition var2, int var3, float var4) {
      ocee33618a8d var5 = new ocee33618a8d("drawSelectionBox", true);
      this.mimeow$drawBlockHighlight(var1, var2, var3, var4, var5);
      if (!var5.z$24lpjeeur71n9()) {
         if (var3 == 0 && var2.typeOfHit == MovingObjectType.BLOCK) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.color(0.0F, 0.0F, 0.0F, 0.4F);
            GL11.glLineWidth(2.0F);
            GlStateManager.disableTexture2D();
            if (Config.isShaders()) {
               Shaders.disableTexture2D();
            }

            GlStateManager.depthMask(false);
            float var6 = 0.002F;
            BlockPos var7 = var2.getBlockPos();
            Block var8 = this.theWorld.getBlockState(var7).getBlock();
            if (var8.getMaterial() != Material.air && this.theWorld.getWorldBorder().contains(var7)) {
               var8.setBlockBoundsBasedOnState(this.theWorld, var7);
               double var9 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * var4;
               double var11 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * var4;
               double var13 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * var4;
               AxisAlignedBB var15 = var8.getSelectedBoundingBox(this.theWorld, var7);
               EnumOffsetType var16 = var8.getOffsetType();
               if (var16 != EnumOffsetType.NONE) {
                  var15 = BlockModelUtils.getOffsetBoundingBox(var15, var16, var7);
               }

               drawSelectionBoundingBox(var15.expand(0.002F, 0.002F, 0.002F).offset(-var9, -var11, -var13));
            }

            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            if (Config.isShaders()) {
               Shaders.enableTexture2D();
            }

            GlStateManager.disableBlend();
         }
      }
   }

   public static void drawSelectionBoundingBox(AxisAlignedBB var0) {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(1, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var1.draw();
   }

   public static void drawOutlinedBoundingBox(AxisAlignedBB var0, int var1, int var2, int var3, int var4) {
      Tessellator var5 = Tessellator.getInstance();
      WorldRenderer var6 = var5.getWorldRenderer();
      var6.begin(3, DefaultVertexFormats.POSITION_COLOR);
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(3, DefaultVertexFormats.POSITION_COLOR);
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(1, DefaultVertexFormats.POSITION_COLOR);
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
   }

   private void markBlocksForUpdate(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.viewFrustum.markBlocksForUpdate(var1, var2, var3, var4, var5, var6);
   }

   public void markBlockForUpdate(BlockPos var1) {
      int var2 = var1.getX();
      int var3 = var1.getY();
      int var4 = var1.getZ();
      this.markBlocksForUpdate(var2 - 1, var3 - 1, var4 - 1, var2 + 1, var3 + 1, var4 + 1);
   }

   public void notifyLightSet(BlockPos var1) {
      int var2 = var1.getX();
      int var3 = var1.getY();
      int var4 = var1.getZ();
      this.markBlocksForUpdate(var2 - 1, var3 - 1, var4 - 1, var2 + 1, var3 + 1, var4 + 1);
   }

   public void markBlockRangeForRenderUpdate(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.markBlocksForUpdate(var1 - 1, var2 - 1, var3 - 1, var4 + 1, var5 + 1, var6 + 1);
   }

   public void playRecord(String var1, BlockPos var2) {
      ISound var3 = this.mapSoundPositions.get(var2);
      if (var3 != null) {
         this.mc.getSoundHandler().stopSound(var3);
         this.mapSoundPositions.remove(var2);
      }

      if (var1 != null) {
         ItemRecord var4 = ItemRecord.getRecord(var1);
         if (var4 != null) {
            this.mc.ingameGUI.setRecordPlayingMessage(var4.getRecordNameLocal());
         }

         PositionedSoundRecord var5 = PositionedSoundRecord.create(new ResourceLocation(var1), var2.getX(), var2.getY(), var2.getZ());
         this.mapSoundPositions.put(var2, var5);
         this.mc.getSoundHandler().playSound(var5);
      }
   }

   public void playSound(String var1, double var2, double var4, double var6, float var8, float var9) {
   }

   public void playSoundToNearExcept(EntityPlayer var1, String var2, double var3, double var5, double var7, float var9, float var10) {
   }

   public void spawnParticle(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
      try {
         this.spawnEntityFX(var1, var2, var3, var5, var7, var9, var11, var13, var15);
      } catch (Throwable var19) {
         CrashReport var17 = CrashReport.makeCrashReport(var19, "Exception while adding particle");
         CrashReportCategory var18 = var17.makeCategory("Particle being added");
         var18.addCrashSection("ID", var1);
         if (var15 != null) {
            var18.addCrashSection("Parameters", var15);
         }

         var18.addCrashSectionCallable("Position", () -> CrashReportCategory.getCoordinateInfo(var3, var5, var7));
         throw new ReportedException(var17);
      }
   }

   private void spawnParticle(EnumParticleTypes var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
      this.spawnParticle(var1.getParticleID(), var1.getShouldIgnoreRange(), var2, var4, var6, var8, var10, var12, var14);
   }

   private EntityFX spawnEntityFX(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
      if (this.mc != null && this.mc.getRenderViewEntity() != null && this.mc.effectRenderer != null) {
         int var16 = this.mc.gameSettings.particleSetting;
         if (var16 == 1 && this.theWorld.rand.nextInt(3) == 0) {
            var16 = 2;
         }

         double var17 = this.mc.getRenderViewEntity().posX - var3;
         double var19 = this.mc.getRenderViewEntity().posY - var5;
         double var21 = this.mc.getRenderViewEntity().posZ - var7;
         if (var1 == EnumParticleTypes.EXPLOSION_HUGE.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
         } else if (var1 == EnumParticleTypes.EXPLOSION_LARGE.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
         } else if (var1 == EnumParticleTypes.EXPLOSION_NORMAL.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
         } else if (var1 == EnumParticleTypes.SUSPENDED.getParticleID() && !Config.isWaterParticles()) {
            return null;
         } else if (var1 == EnumParticleTypes.SUSPENDED_DEPTH.getParticleID() && !Config.isVoidParticles()) {
            return null;
         } else if (var1 == EnumParticleTypes.SMOKE_NORMAL.getParticleID() && !Config.isAnimatedSmoke()) {
            return null;
         } else if (var1 == EnumParticleTypes.SMOKE_LARGE.getParticleID() && !Config.isAnimatedSmoke()) {
            return null;
         } else if (var1 == EnumParticleTypes.SPELL_MOB.getParticleID() && !Config.isPotionParticles()) {
            return null;
         } else if (var1 == EnumParticleTypes.SPELL_MOB_AMBIENT.getParticleID() && !Config.isPotionParticles()) {
            return null;
         } else if (var1 == EnumParticleTypes.SPELL.getParticleID() && !Config.isPotionParticles()) {
            return null;
         } else if (var1 == EnumParticleTypes.SPELL_INSTANT.getParticleID() && !Config.isPotionParticles()) {
            return null;
         } else if (var1 == EnumParticleTypes.SPELL_WITCH.getParticleID() && !Config.isPotionParticles()) {
            return null;
         } else if (var1 == EnumParticleTypes.PORTAL.getParticleID() && !Config.isPortalParticles()) {
            return null;
         } else if (var1 == EnumParticleTypes.FLAME.getParticleID() && !Config.isAnimatedFlame()) {
            return null;
         } else if (var1 == EnumParticleTypes.REDSTONE.getParticleID() && !Config.isAnimatedRedstone()) {
            return null;
         } else if (var1 == EnumParticleTypes.DRIP_WATER.getParticleID() && !Config.isDrippingWaterLava()) {
            return null;
         } else if (var1 == EnumParticleTypes.DRIP_LAVA.getParticleID() && !Config.isDrippingWaterLava()) {
            return null;
         } else if (var1 == EnumParticleTypes.FIREWORKS_SPARK.getParticleID() && !Config.isFireworkParticles()) {
            return null;
         } else {
            if (!var2) {
               double var23 = 256.0;
               if (var1 == EnumParticleTypes.CRIT.getParticleID()) {
                  var23 = 38416.0;
               }

               if (var17 * var17 + var19 * var19 + var21 * var21 > var23) {
                  return null;
               }

               if (var16 > 1) {
                  return null;
               }
            }

            EntityFX var25 = this.mc.effectRenderer.spawnEffectParticle(var1, var3, var5, var7, var9, var11, var13, var15);
            if (var1 == EnumParticleTypes.WATER_BUBBLE.getParticleID()) {
               CustomColors.updateWaterFX(var25, this.theWorld, var3, var5, var7, this.renderEnv);
            }

            if (var1 == EnumParticleTypes.WATER_SPLASH.getParticleID()) {
               CustomColors.updateWaterFX(var25, this.theWorld, var3, var5, var7, this.renderEnv);
            }

            if (var1 == EnumParticleTypes.WATER_DROP.getParticleID()) {
               CustomColors.updateWaterFX(var25, this.theWorld, var3, var5, var7, this.renderEnv);
            }

            if (var1 == EnumParticleTypes.TOWN_AURA.getParticleID()) {
               CustomColors.updateMyceliumFX(var25);
            }

            if (var1 == EnumParticleTypes.PORTAL.getParticleID()) {
               CustomColors.updatePortalFX(var25);
            }

            if (var1 == EnumParticleTypes.REDSTONE.getParticleID()) {
               CustomColors.updateReddustFX(var25, this.theWorld, var3, var5, var7);
            }

            return var25;
         }
      } else {
         return null;
      }
   }

   public void onEntityAdded(Entity var1) {
      RandomEntities.entityLoaded(var1, this.theWorld);
      if (Config.isDynamicLights()) {
         DynamicLights.entityAdded(var1, this);
      }
   }

   public void onEntityRemoved(Entity var1) {
      RandomEntities.entityUnloaded(var1, this.theWorld);
      if (Config.isDynamicLights()) {
         DynamicLights.entityRemoved(var1, this);
      }
   }

   public void deleteAllDisplayLists() {
   }

   public void broadcastSound(int var1, BlockPos var2, int var3) {
      switch (var1) {
         case 1013:
         case 1018:
            if (this.mc.getRenderViewEntity() != null) {
               double var4 = var2.getX() - this.mc.getRenderViewEntity().posX;
               double var6 = var2.getY() - this.mc.getRenderViewEntity().posY;
               double var8 = var2.getZ() - this.mc.getRenderViewEntity().posZ;
               double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
               double var12 = this.mc.getRenderViewEntity().posX;
               double var14 = this.mc.getRenderViewEntity().posY;
               double var16 = this.mc.getRenderViewEntity().posZ;
               if (var10 > 0.0) {
                  var12 += var4 / var10 * 2.0;
                  var14 += var6 / var10 * 2.0;
                  var16 += var8 / var10 * 2.0;
               }

               if (var1 == 1013) {
                  this.theWorld.playSound(var12, var14, var16, "mob.wither.spawn", 1.0F, 1.0F, false);
               } else {
                  this.theWorld.playSound(var12, var14, var16, "mob.enderdragon.end", 5.0F, 1.0F, false);
               }
            }
      }
   }

   public void playAuxSFX(EntityPlayer var1, int var2, BlockPos var3, int var4) {
      Random var5 = this.theWorld.rand;
      switch (var2) {
         case 1000:
            this.theWorld.playSoundAtPos(var3, "random.click", 1.0F, 1.0F, false);
            break;
         case 1001:
            this.theWorld.playSoundAtPos(var3, "random.click", 1.0F, 1.2F, false);
            break;
         case 1002:
            this.theWorld.playSoundAtPos(var3, "random.bow", 1.0F, 1.2F, false);
            break;
         case 1003:
            this.theWorld.playSoundAtPos(var3, "random.door_open", 1.0F, this.theWorld.rand.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1004:
            this.theWorld.playSoundAtPos(var3, "random.fizz", 0.5F, 2.6F + (var5.nextFloat() - var5.nextFloat()) * 0.8F, false);
            break;
         case 1005:
            if (Item.getItemById(var4) instanceof ItemRecord) {
               this.theWorld.playRecord(var3, "records." + ((ItemRecord)Item.getItemById(var4)).recordName);
            } else {
               this.theWorld.playRecord(var3, (String)null);
            }
            break;
         case 1006:
            this.theWorld.playSoundAtPos(var3, "random.door_close", 1.0F, this.theWorld.rand.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1007:
            this.theWorld.playSoundAtPos(var3, "mob.ghast.charge", 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1008:
            this.theWorld.playSoundAtPos(var3, "mob.ghast.fireball", 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1009:
            this.theWorld.playSoundAtPos(var3, "mob.ghast.fireball", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1010:
            this.theWorld.playSoundAtPos(var3, "mob.zombie.wood", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1011:
            this.theWorld.playSoundAtPos(var3, "mob.zombie.metal", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1012:
            this.theWorld.playSoundAtPos(var3, "mob.zombie.woodbreak", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1014:
            this.theWorld.playSoundAtPos(var3, "mob.wither.shoot", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1015:
            this.theWorld.playSoundAtPos(var3, "mob.bat.takeoff", 0.05F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1016:
            this.theWorld.playSoundAtPos(var3, "mob.zombie.infect", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1017:
            this.theWorld.playSoundAtPos(var3, "mob.zombie.unfect", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1020:
            this.theWorld.playSoundAtPos(var3, "random.anvil_break", 1.0F, this.theWorld.rand.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1021:
            this.theWorld.playSoundAtPos(var3, "random.anvil_use", 1.0F, this.theWorld.rand.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1022:
            this.theWorld.playSoundAtPos(var3, "random.anvil_land", 0.3F, this.theWorld.rand.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 2000:
            int var6 = var4 % 3 - 1;
            int var7 = var4 / 3 % 3 - 1;
            double var8 = var3.getX() + var6 * 0.6 + 0.5;
            double var10 = var3.getY() + 0.5;
            double var12 = var3.getZ() + var7 * 0.6 + 0.5;

            for (int var39 = 0; var39 < 10; var39++) {
               double var40 = var5.nextDouble() * 0.2 + 0.01;
               double var41 = var8 + var6 * 0.01 + (var5.nextDouble() - 0.5) * var7 * 0.5;
               double var42 = var10 + (var5.nextDouble() - 0.5) * 0.5;
               double var44 = var12 + var7 * 0.01 + (var5.nextDouble() - 0.5) * var6 * 0.5;
               double var45 = var6 * var40 + var5.nextGaussian() * 0.01;
               double var46 = -0.03 + var5.nextGaussian() * 0.01;
               double var48 = var7 * var40 + var5.nextGaussian() * 0.01;
               this.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var41, var42, var44, var45, var46, var48);
            }

            return;
         case 2001:
            Block var14 = Block.getBlockById(var4 & 4095);
            if (var14.getMaterial() != Material.air) {
               this.mc
                  .getSoundHandler()
                  .playSound(
                     new PositionedSoundRecord(
                        new ResourceLocation(var14.stepSound.getBreakSound()),
                        (var14.stepSound.getVolume() + 1.0F) / 2.0F,
                        var14.stepSound.getFrequency() * 0.8F,
                        var3.getX() + 0.5F,
                        var3.getY() + 0.5F,
                        var3.getZ() + 0.5F
                     )
                  );
            }

            this.mc.effectRenderer.addBlockDestroyEffects(var3, var14.getStateFromMeta(var4 >> 12 & 0xFF));
            break;
         case 2002:
            double var15 = var3.getX();
            double var17 = var3.getY();
            double var19 = var3.getZ();

            for (int var21 = 0; var21 < 8; var21++) {
               this.spawnParticle(
                  EnumParticleTypes.ITEM_CRACK,
                  var15,
                  var17,
                  var19,
                  var5.nextGaussian() * 0.15,
                  var5.nextDouble() * 0.2,
                  var5.nextGaussian() * 0.15,
                  Item.getIdFromItem(Items.potionitem),
                  var4
               );
            }

            int var43 = Items.potionitem.getColorFromDamage(var4);
            float var22 = (var43 >> 16 & 0xFF) / 255.0F;
            float var23 = (var43 >> 8 & 0xFF) / 255.0F;
            float var24 = (var43 >> 0 & 0xFF) / 255.0F;
            EnumParticleTypes var25 = EnumParticleTypes.SPELL;
            if (Items.potionitem.isEffectInstant(var4)) {
               var25 = EnumParticleTypes.SPELL_INSTANT;
            }

            for (int var47 = 0; var47 < 100; var47++) {
               double var27 = var5.nextDouble() * 4.0;
               double var29 = var5.nextDouble() * Math.PI * 2.0;
               double var31 = Math.cos(var29) * var27;
               double var51 = 0.01 + var5.nextDouble() * 0.5;
               double var52 = Math.sin(var29) * var27;
               EntityFX var53 = this.spawnEntityFX(
                  var25.getParticleID(), var25.getShouldIgnoreRange(), var15 + var31 * 0.1, var17 + 0.3, var19 + var52 * 0.1, var31, var51, var52
               );
               if (var53 != null) {
                  float var38 = 0.75F + var5.nextFloat() * 0.25F;
                  var53.setRBGColorF(var22 * var38, var23 * var38, var24 * var38);
                  var53.multiplyVelocity((float)var27);
               }
            }

            this.theWorld.playSoundAtPos(var3, "game.potion.smash", 1.0F, this.theWorld.rand.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 2003:
            double var26 = var3.getX() + 0.5;
            double var28 = var3.getY();
            double var30 = var3.getZ() + 0.5;

            for (int var49 = 0; var49 < 8; var49++) {
               this.spawnParticle(
                  EnumParticleTypes.ITEM_CRACK,
                  var26,
                  var28,
                  var30,
                  var5.nextGaussian() * 0.15,
                  var5.nextDouble() * 0.2,
                  var5.nextGaussian() * 0.15,
                  Item.getIdFromItem(Items.ender_eye)
               );
            }

            for (double var50 = 0.0; var50 < Math.PI * 2; var50 += Math.PI / 20) {
               this.spawnParticle(
                  EnumParticleTypes.PORTAL,
                  var26 + Math.cos(var50) * 5.0,
                  var28 - 0.4,
                  var30 + Math.sin(var50) * 5.0,
                  Math.cos(var50) * -5.0,
                  0.0,
                  Math.sin(var50) * -5.0
               );
               this.spawnParticle(
                  EnumParticleTypes.PORTAL,
                  var26 + Math.cos(var50) * 5.0,
                  var28 - 0.4,
                  var30 + Math.sin(var50) * 5.0,
                  Math.cos(var50) * -7.0,
                  0.0,
                  Math.sin(var50) * -7.0
               );
            }

            return;
         case 2004:
            for (int var32 = 0; var32 < 20; var32++) {
               double var33 = var3.getX() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
               double var35 = var3.getY() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
               double var37 = var3.getZ() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
               this.theWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var33, var35, var37, 0.0, 0.0, 0.0, new int[0]);
               this.theWorld.spawnParticle(EnumParticleTypes.FLAME, var33, var35, var37, 0.0, 0.0, 0.0, new int[0]);
            }

            return;
         case 2005:
            ItemDye.spawnBonemealParticles(this.theWorld, var3, var4);
      }
   }

   public void sendBlockBreakProgress(int var1, BlockPos var2, int var3) {
      if (var3 >= 0 && var3 < 10) {
         DestroyBlockProgress var4 = this.damagedBlocks.get(var1);
         if (var4 == null || var4.getPosition().getX() != var2.getX() || var4.getPosition().getY() != var2.getY() || var4.getPosition().getZ() != var2.getZ()) {
            var4 = new DestroyBlockProgress(var1, var2);
            this.damagedBlocks.put(var1, var4);
         }

         var4.setPartialBlockDamage(var3);
         var4.setCloudUpdateTick(this.cloudTickCounter);
      } else {
         this.damagedBlocks.remove(var1);
      }
   }

   public void setDisplayListEntitiesDirty() {
      this.displayListEntitiesDirty = true;
   }

   public boolean hasNoChunkUpdates() {
      return this.chunksToUpdate.isEmpty() && this.renderDispatcher.hasChunkUpdates();
   }

   public void resetClouds() {
      this.cloudRenderer.reset();
   }

   public int getCountRenderers() {
      return this.viewFrustum.renderChunks.length;
   }

   public int getCountActiveRenderers() {
      return this.renderInfos.size();
   }

   public int getCountEntitiesRendered() {
      return this.countEntitiesRendered;
   }

   public int getCountTileEntitiesRendered() {
      return this.countTileEntitiesRendered;
   }

   public int getCountLoadedChunks() {
      if (this.theWorld == null) {
         return 0;
      } else {
         IChunkProvider var1 = this.theWorld.getChunkProvider();
         if (var1 == null) {
            return 0;
         } else {
            if (var1 != this.worldChunkProvider) {
               this.worldChunkProvider = var1;
               this.worldChunkProviderMap = (LongHashMap)Reflector.getFieldValue(var1, Reflector.ChunkProviderClient_chunkMapping);
            }

            return this.worldChunkProviderMap == null ? 0 : this.worldChunkProviderMap.getNumHashElements();
         }
      }
   }

   public int getCountChunksToUpdate() {
      return this.chunksToUpdate.size();
   }

   public RenderChunk getRenderChunk(BlockPos var1) {
      return this.viewFrustum.getRenderChunk(var1);
   }

   public WorldClient getWorld() {
      return this.theWorld;
   }

   private void clearRenderInfos() {
      if (renderEntitiesCounter > 0) {
         this.renderInfos = new ArrayList<>(this.renderInfos.size() + 16);
         this.renderInfosEntities = new ArrayList<>(this.renderInfosEntities.size() + 16);
         this.renderInfosTileEntities = new ArrayList(this.renderInfosTileEntities.size() + 16);
      } else {
         this.renderInfos.clear();
         this.renderInfosEntities.clear();
         this.renderInfosTileEntities.clear();
      }
   }

   public void onPlayerPositionSet() {
      if (this.firstWorldLoad) {
         this.loadRenderers();
         this.firstWorldLoad = false;
      }
   }

   public void pauseChunkUpdates() {
      if (this.renderDispatcher != null) {
         this.renderDispatcher.pauseChunkUpdates();
      }
   }

   public void resumeChunkUpdates() {
      if (this.renderDispatcher != null) {
         this.renderDispatcher.resumeChunkUpdates();
      }
   }

   public void updateTileEntities(Collection<TileEntity> var1, Collection<TileEntity> var2) {
      synchronized (this.setTileEntities) {
         this.setTileEntities.removeAll(var1);
         this.setTileEntities.addAll(var2);
      }
   }

   private float mimeow$redirect$setupTerrainRotationPitch(Entity var1) {
      return var1 == this.mc.thePlayer && var1 == this.mc.getRenderViewEntity() && this.isFreelookActive() ? oc9755810e45.Б.η() : var1.rotationPitch;
   }

   private float mimeow$redirect$setupTerrainRotationYaw(Entity var1) {
      return var1 == this.mc.thePlayer && var1 == this.mc.getRenderViewEntity() && this.isFreelookActive() ? oc9755810e45.Б.ș() : var1.rotationYaw;
   }

   private boolean mimeow$redirect$interpolateBacktrackPosition(RenderManager var1, Entity var2, ICamera var3, double var4, double var6, double var8) {
      if (oc2cf3d80e17.Ŗ != null) {
         oc2cf3d80e17.Ŗ.ɖ(var2);
      }

      return var1.shouldRender(var2, var3, var4, var6, var8);
   }

   private Vector3f mimeow$redirect$setupTerrainViewVector(RenderGlobal var1, Entity var2, double var3) {
      boolean var5 = var2 == this.mc.thePlayer && var2 == this.mc.getRenderViewEntity() && this.isFreelookActive();
      float var6 = var5 ? oc9755810e45.Б.η() : (float)(var2.prevRotationPitch + (var2.rotationPitch - var2.prevRotationPitch) * var3);
      float var7 = var5 ? oc9755810e45.Б.ș() : (float)(var2.prevRotationYaw + (var2.rotationYaw - var2.prevRotationYaw) * var3);
      if (this.mc.gameSettings.thirdPersonView == 2) {
         var6 += 180.0F;
      }

      float var8 = MathHelper.cos(-var7 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var9 = MathHelper.sin(-var7 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var10 = -MathHelper.cos(-var6 * (float) (Math.PI / 180.0));
      float var11 = MathHelper.sin(-var6 * (float) (Math.PI / 180.0));
      return new Vector3f(var9 * var10, var11, var8 * var10);
   }

   private boolean isFreelookActive() {
      return oc9755810e45.Б != null && oc9755810e45.Б.Ö();
   }

   private void mimeow$drawBlockHighlight(EntityPlayer var1, MovingObjectPosition var2, int var3, float var4, ocee33618a8d var5) {
      if (ocea775c9d5c.ų.post(new oce4b2178c11(this, var1, var2, var3, var4))) {
         var5.z$2vp8d6bhwkrey();
      }
   }

   public static class ContainerLocalRenderInformation {
      final RenderChunk renderChunk;
      EnumFacing facing;
      int setFacing;

      public ContainerLocalRenderInformation(RenderChunk var1, EnumFacing var2, int var3) {
         this.renderChunk = var1;
         this.facing = var2;
         this.setFacing = var3;
      }

      public void setFacingBit(byte var1, EnumFacing var2) {
         this.setFacing = this.setFacing | var1 | 1 << var2.ordinal();
      }

      public boolean isFacingBit(EnumFacing var1) {
         return (this.setFacing & 1 << var1.ordinal()) > 0;
      }

      private void initialize(EnumFacing var1, int var2) {
         this.facing = var1;
         this.setFacing = var2;
      }
   }
}
