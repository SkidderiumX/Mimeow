/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import com.google.common.base.Predicates;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.src.Config;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.CustomColors;
import net.optifine.GlErrors;
import net.optifine.Lagometer;
import net.optifine.RandomEntities;
import net.optifine.gui.GuiChatOF;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorCompat;
import net.optifine.reflect.ReflectorResolver;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.ShadersRender;
import net.optifine.util.MemoryMonitor;
import net.optifine.util.TextureUtils;
import net.optifine.util.TimedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;
import x.oc02a3730b27;
import x.oc2cf3d80e17;
import x.oc36adbc80c5;
import x.oc4a43182f3e;
import x.oc65f19d876a;
import x.oc746a23b244;
import x.oc9755810e45;
import x.oc9ee35e7bd8;
import x.ocb683e2d821;
import x.ocbb165642ef;
import x.occ52191e479;
import x.ocdaa622d41d;
import x.ocea775c9d5c;
import x.ocee33618a8d;
import x.ocfce21f66a2;

public class EntityRenderer
implements IResourceManagerReloadListener,
ocdaa622d41d,
oc65f19d876a {
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation locationRainPng = new ResourceLocation("textures/environment/rain.png");
    private static final ResourceLocation locationSnowPng = new ResourceLocation("textures/environment/snow.png");
    public static boolean anaglyphEnable;
    public static int anaglyphField;
    private final Minecraft mc;
    private final IResourceManager resourceManager;
    private final Random random = new Random();
    private float farPlaneDistance;
    public ItemRenderer itemRenderer;
    private final MapItemRenderer theMapItemRenderer;
    private int rendererUpdateCount;
    private Entity pointedEntity;
    private MouseFilter mouseFilterXAxis = new MouseFilter();
    private MouseFilter mouseFilterYAxis = new MouseFilter();
    private float thirdPersonDistance = 4.0f;
    float zoomAmount = 5.0f;
    private float previousFOV;
    private boolean previousSmoothCamera;
    private float thirdPersonDistanceTemp = 4.0f;
    private float smoothCamYaw;
    private float smoothCamPitch;
    private float smoothCamFilterX;
    private float smoothCamFilterY;
    private float smoothCamPartialTicks;
    private float fovModifierHand;
    private float fovModifierHandPrev;
    private float bossColorModifier;
    private float bossColorModifierPrev;
    private boolean cloudFog;
    private final boolean renderHand = true;
    private final boolean drawBlockOutline = true;
    private long prevFrameTime = Minecraft.getSystemTime();
    private long renderEndNanoTime;
    private final DynamicTexture lightmapTexture;
    private final int[] lightmapColors;
    private final ResourceLocation locationLightMap;
    private boolean lightmapUpdateNeeded;
    private float torchFlickerX;
    private float torchFlickerDX;
    private int rainSoundCounter;
    private final float[] rainXCoords = new float[1024];
    private final float[] rainYCoords = new float[1024];
    private final FloatBuffer fogColorBuffer = GLAllocation.createDirectFloatBuffer(16);
    public float fogColorRed;
    public float fogColorGreen;
    public float fogColorBlue;
    private float fogColor2;
    private float fogColor1;
    private final int debugViewDirection = 0;
    private final boolean debugView = false;
    private final double cameraZoom = 1.0;
    private double cameraYaw;
    private double cameraPitch;
    private ShaderGroup theShaderGroup;
    private static final ResourceLocation[] shaderResourceLocations;
    public static final int shaderCount;
    private int shaderIndex;
    private boolean useShader = false;
    public int frameCount = 0;
    private ShaderGroup Roven$saturationShader;
    private boolean initialized = false;
    private World updatedWorld = null;
    private final boolean showDebugInfo = false;
    public boolean fogStandard = false;
    private float clipDistance = 128.0f;
    private long lastServerTime = 0L;
    private int lastServerTicks = 0;
    private int serverWaitTime = 0;
    private int serverWaitTimeCurrent = 0;
    private float avgServerTimeDiff = 0.0f;
    private float avgServerTickDiff = 0.0f;
    private final ShaderGroup[] fxaaShaders = new ShaderGroup[10];
    private boolean loadVisibleChunks = false;
    private float mimeow$freeLookYaw;
    private float mimeow$freeLookPitch;
    private float mimeow$freeLookPreviousYaw;
    private float mimeow$freeLookPreviousPitch;
    private boolean mimeow$restoreFreeLookRotation;

    public EntityRenderer(Minecraft minecraft, IResourceManager iResourceManager) {
        this.shaderIndex = shaderCount;
        this.mc = minecraft;
        this.resourceManager = iResourceManager;
        this.itemRenderer = minecraft.getItemRenderer();
        this.theMapItemRenderer = new MapItemRenderer(minecraft.getTextureManager());
        this.lightmapTexture = new DynamicTexture(16, 16);
        this.locationLightMap = minecraft.getTextureManager().getDynamicTextureLocation("lightMap", this.lightmapTexture);
        this.lightmapColors = this.lightmapTexture.getTextureData();
        this.theShaderGroup = null;
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32; ++j) {
                float f = j - 16;
                float f2 = i - 16;
                float f3 = MathHelper.sqrt_float(f * f + f2 * f2);
                this.rainXCoords[i << 5 | j] = -f2 / f3;
                this.rainYCoords[i << 5 | j] = f / f3;
            }
        }
    }

    public boolean isShaderActive() {
        occ52191e479 occ52191e4792 = new occ52191e479("isShaderActive", true);
        this.mimeow$onIsShaderActive(occ52191e4792);
        return occ52191e4792.z$24lpjeeur71n9() ? occ52191e4792.\u016f() : OpenGlHelper.shadersSupported && this.theShaderGroup != null;
    }

    public void stopUseShader() {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        this.shaderIndex = shaderCount;
    }

    public void switchUseShader() {
        this.useShader = !this.useShader;
    }

    public void loadEntityShader(Entity entity) {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.deleteShaderGroup();
            }
            this.theShaderGroup = null;
            if (entity instanceof EntityCreeper) {
                this.loadShader(new ResourceLocation("shaders/post/creeper.json"));
            } else if (entity instanceof EntitySpider) {
                this.loadShader(new ResourceLocation("shaders/post/spider.json"));
            } else if (entity instanceof EntityEnderman) {
                this.loadShader(new ResourceLocation("shaders/post/invert.json"));
            } else if (Reflector.CompatHooksClient_loadEntityShader.exists()) {
                Reflector.call(Reflector.CompatHooksClient_loadEntityShader, entity, this);
            }
        }
    }

    public void activateNextShader() {
        if (OpenGlHelper.shadersSupported && this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.deleteShaderGroup();
            }
            this.shaderIndex = (this.shaderIndex + 1) % (shaderResourceLocations.length + 1);
            if (this.shaderIndex != shaderCount) {
                this.loadShader(shaderResourceLocations[this.shaderIndex]);
            } else {
                this.theShaderGroup = null;
            }
        }
    }

    private void loadShader(ResourceLocation resourceLocation) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            try {
                this.theShaderGroup = new ShaderGroup(this.mc.getTextureManager(), this.resourceManager, this.mc.getFramebuffer(), resourceLocation);
                this.theShaderGroup.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.useShader = true;
            }
            catch (IOException iOException) {
                logger.warn("Failed to load shader: " + String.valueOf(resourceLocation), (Throwable)iOException);
                this.shaderIndex = shaderCount;
                this.useShader = false;
            }
            catch (JsonSyntaxException jsonSyntaxException) {
                logger.warn("Failed to load shader: " + String.valueOf(resourceLocation), (Throwable)jsonSyntaxException);
                this.shaderIndex = shaderCount;
                this.useShader = false;
            }
        }
    }

    @Override
    public void onResourceManagerReload(IResourceManager iResourceManager) {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        if (this.shaderIndex != shaderCount) {
            this.loadShader(shaderResourceLocations[this.shaderIndex]);
        } else {
            this.loadEntityShader(this.mc.getRenderViewEntity());
        }
    }

    public void updateRenderer() {
        if (OpenGlHelper.shadersSupported && ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
        }
        this.updateFovModifierHand();
        this.updateTorchFlicker();
        this.fogColor2 = this.fogColor1;
        this.thirdPersonDistanceTemp = this.thirdPersonDistance;
        if (this.mc.gameSettings.smoothCamera) {
            float f = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            float f2 = f * f * f * 8.0f;
            this.smoothCamFilterX = this.mouseFilterXAxis.smooth(this.smoothCamYaw, Config.zoomMode ? 0.55f / this.zoomAmount * f2 : 0.05f * f2);
            this.smoothCamFilterY = this.mouseFilterYAxis.smooth(this.smoothCamPitch, Config.zoomMode ? 0.55f / this.zoomAmount * f2 : 0.05f * f2);
            this.smoothCamPartialTicks = 0.0f;
            this.smoothCamYaw = 0.0f;
            this.smoothCamPitch = 0.0f;
        } else {
            this.smoothCamFilterX = 0.0f;
            this.smoothCamFilterY = 0.0f;
            this.mouseFilterXAxis.reset();
            this.mouseFilterYAxis.reset();
        }
        if (this.mc.getRenderViewEntity() == null) {
            this.mc.setRenderViewEntity(this.mc.thePlayer);
        }
        Entity entity = this.mc.getRenderViewEntity();
        double d = entity.posX;
        double d2 = entity.posY + (double)entity.getEyeHeight();
        double d3 = entity.posZ;
        float f = this.mc.theWorld.getLightBrightness(new BlockPos(d, d2, d3));
        float f3 = (float)this.mc.gameSettings.renderDistanceChunks / 16.0f;
        f3 = MathHelper.clamp_float(f3, 0.0f, 1.0f);
        float f4 = f * (1.0f - f3) + f3;
        this.fogColor1 += (f4 - this.fogColor1) * 0.1f;
        ++this.rendererUpdateCount;
        this.itemRenderer.updateEquippedItem();
        this.addRainParticles();
        this.bossColorModifierPrev = this.bossColorModifier;
        if (BossStatus.hasColorModifier) {
            this.bossColorModifier += 0.05f;
            if (this.bossColorModifier > 1.0f) {
                this.bossColorModifier = 1.0f;
            }
            BossStatus.hasColorModifier = false;
        } else if (this.bossColorModifier > 0.0f) {
            this.bossColorModifier -= 0.0125f;
        }
    }

    public ShaderGroup getShaderGroup() {
        occ52191e479 occ52191e4792 = new occ52191e479("getShaderGroup", true);
        this.mimeow$onGetShaderGroup(occ52191e4792);
        return occ52191e4792.z$24lpjeeur71n9() ? (ShaderGroup)occ52191e4792.\u040d() : this.theShaderGroup;
    }

    public void updateShaderGroupSize(int n, int n2) {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.createBindFramebuffers(n, n2);
            }
            this.mimeow$onUpdateShaderGroupSize(n, n2, new ocee33618a8d("updateShaderGroupSize", false));
            this.mc.renderGlobal.createBindEntityOutlineFbs(n, n2);
        }
    }

    public void getMouseOver(float f) {
        this.mimeow$onGetMouseOverHead(f, new ocee33618a8d("getMouseOver", false));
        Entity entity = this.mc.getRenderViewEntity();
        if (entity != null && this.mc.theWorld != null) {
            this.mc.mcProfiler.startSection("pick");
            this.mc.pointedEntity = null;
            double d = this.mc.playerController.getBlockReachDistance();
            this.mc.objectMouseOver = entity.rayTrace(d, f);
            double d2 = d;
            Vec3 vec3 = entity.getPositionEyes(f);
            boolean bl = false;
            int n = 3;
            if (this.mc.playerController.extendedReach()) {
                d = 6.0;
                d2 = 6.0;
            } else if (d > 3.0) {
                bl = true;
            }
            if (this.mc.objectMouseOver != null) {
                d2 = this.mc.objectMouseOver.hitVec.distanceTo(vec3);
            }
            Vec3 vec32 = entity.getLook(f);
            Vec3 vec33 = vec3.addVector(vec32.xCoord * d, vec32.yCoord * d, vec32.zCoord * d);
            this.pointedEntity = null;
            Vec3 vec34 = null;
            float f2 = 1.0f;
            List<Entity> list = this.mc.theWorld.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().addCoord(vec32.xCoord * d, vec32.yCoord * d, vec32.zCoord * d).expand(1.0, 1.0, 1.0), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
            double d3 = d2;
            Iterator<Entity> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                double d4;
                Entity entity2;
                Entity entity3 = entity2 = iterator2.next();
                float f3 = entity3.getCollisionBorderSize();
                AxisAlignedBB axisAlignedBB = entity3.getEntityBoundingBox().expand(f3, f3, f3);
                MovingObjectPosition movingObjectPosition = axisAlignedBB.calculateIntercept(vec3, vec33);
                if (axisAlignedBB.isVecInside(vec3)) {
                    if (!(d3 >= 0.0)) continue;
                    this.pointedEntity = entity3;
                    vec34 = movingObjectPosition == null ? vec3 : movingObjectPosition.hitVec;
                    d3 = 0.0;
                    continue;
                }
                if (movingObjectPosition == null || !((d4 = vec3.distanceTo(movingObjectPosition.hitVec)) < d3) && d3 != 0.0) continue;
                boolean bl2 = false;
                if (Reflector.CompatEntity_canRiderInteract.exists()) {
                    bl2 = Reflector.callBoolean(entity3, Reflector.CompatEntity_canRiderInteract, new Object[0]);
                }
                if (!bl2 && entity3 == entity.ridingEntity) {
                    if (d3 != 0.0) continue;
                    this.pointedEntity = entity3;
                    vec34 = movingObjectPosition.hitVec;
                    continue;
                }
                this.pointedEntity = entity3;
                vec34 = movingObjectPosition.hitVec;
                d3 = d4;
            }
            if (this.pointedEntity != null && bl && vec3.distanceTo(vec34) > 3.0) {
                this.pointedEntity = null;
                this.mc.objectMouseOver = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, vec34, null, new BlockPos(vec34));
            }
            if (this.pointedEntity != null && (d3 < d2 || this.mc.objectMouseOver == null)) {
                this.mc.objectMouseOver = new MovingObjectPosition(this.pointedEntity, vec34);
                if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame) {
                    this.mc.pointedEntity = this.pointedEntity;
                }
            }
            this.mimeow$onGetMouseOverBeforeEndSection(f, new ocee33618a8d("getMouseOver", false));
            this.mc.mcProfiler.endSection();
        }
        this.mimeow$onGetMouseOverReturn(f, new ocee33618a8d("getMouseOver", false));
    }

    private void updateFovModifierHand() {
        float f = 1.0f;
        if (this.mc.getRenderViewEntity() instanceof AbstractClientPlayer) {
            AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer)this.mc.getRenderViewEntity();
            f = abstractClientPlayer.getFovModifier();
        }
        this.fovModifierHandPrev = this.fovModifierHand;
        this.fovModifierHand += (f - this.fovModifierHand) * 0.5f;
        if (this.fovModifierHand > 1.5f) {
            this.fovModifierHand = 1.5f;
        }
        if (this.fovModifierHand < 0.1f) {
            this.fovModifierHand = 0.1f;
        }
    }

    private void setFOV(float f) {
        this.mc.gameSettings.fovSetting = f;
    }

    private void setSmoothCamera(boolean bl) {
        this.mc.gameSettings.smoothCamera = bl;
    }

    private boolean isSmooth() {
        return this.mc.gameSettings.smoothCamera;
    }

    private float getFOV() {
        return this.mc.gameSettings.fovSetting;
    }

    private float getFOVModifier(float f, boolean bl) {
        Object object;
        Objects.requireNonNull(this);
        Entity entity = this.mc.getRenderViewEntity();
        float f2 = 70.0f;
        if (bl) {
            f2 = this.mc.gameSettings.fovSetting;
            if (Config.isDynamicFov()) {
                f2 *= this.fovModifierHandPrev + (this.fovModifierHand - this.fovModifierHandPrev) * f;
            }
        }
        boolean bl2 = false;
        int n = Mouse.getDWheel();
        if (n > 0) {
            this.zoomAmount += 0.15f * this.zoomAmount;
        } else if (n < 0) {
            this.zoomAmount -= 0.15f * this.zoomAmount;
        }
        if (this.zoomAmount < 0.75f) {
            this.zoomAmount = 0.75f;
        }
        if (this.zoomAmount > 20.0f) {
            this.zoomAmount = 20.0f;
        }
        if (this.mc.currentScreen == null) {
            GameSettings gameSettings = this.mc.gameSettings;
            bl2 = GameSettings.isKeyDown(this.mc.gameSettings.ofKeyBindZoom);
        }
        boolean bl3 = false;
        if (this.mc.currentScreen == null) {
            object = this.mc.gameSettings;
            bl3 = GameSettings.isKeyDown(this.mc.gameSettings.ofKeyBindZoom);
        }
        if (bl3) {
            if (!Config.zoomMode) {
                this.previousFOV = this.getFOV();
                Config.zoomMode = true;
                this.mc.gameSettings.smoothCamera = true;
                this.zoomAmount = 2.0f;
            }
            if (Config.zoomMode) {
                this.setFOV(this.previousFOV / this.zoomAmount);
            }
        } else if (Config.zoomMode) {
            Config.zoomMode = false;
            this.mc.gameSettings.smoothCamera = Config.zoomSmoothCamera;
            this.mouseFilterXAxis = new MouseFilter();
            this.mouseFilterYAxis = new MouseFilter();
            this.mc.renderGlobal.displayListEntitiesDirty = true;
            this.setFOV(this.previousFOV);
        }
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getHealth() <= 0.0f) {
            float f3 = (float)((EntityLivingBase)entity).deathTime + f;
            f2 /= (1.0f - 500.0f / (f3 + 500.0f)) * 2.0f + 1.0f;
        }
        if (((Block)(object = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, f))).getMaterial() == Material.water) {
            f2 = f2 * 60.0f / 70.0f;
        }
        return Reflector.CompatHooksClient_getFOVModifier.exists() ? Reflector.callFloat(Reflector.CompatHooksClient_getFOVModifier, this, entity, object, Float.valueOf(f), Float.valueOf(f2)) : f2;
    }

    private void hurtCameraEffect(float f) {
        if (this.mc.getRenderViewEntity() instanceof EntityLivingBase) {
            float f2;
            EntityLivingBase entityLivingBase = (EntityLivingBase)this.mc.getRenderViewEntity();
            float f3 = (float)entityLivingBase.hurtTime - f;
            if (entityLivingBase.getHealth() <= 0.0f) {
                f2 = (float)entityLivingBase.deathTime + f;
                this.mimeow$redirect$injectNoHurtCam(40.0f - 8000.0f / (f2 + 200.0f), 0.0f, 0.0f, 1.0f);
            }
            if (f3 < 0.0f) {
                return;
            }
            f3 /= (float)entityLivingBase.maxHurtTime;
            f3 = MathHelper.sin(f3 * f3 * f3 * f3 * (float)Math.PI);
            f2 = entityLivingBase.attackedAtYaw;
            this.mimeow$redirect$injectNoHurtCam(-f2, 0.0f, 1.0f, 0.0f);
            this.mimeow$redirect$injectNoHurtCam(-f3 * 14.0f, 0.0f, 0.0f, 1.0f);
            this.mimeow$redirect$injectNoHurtCam(f2, 0.0f, 1.0f, 0.0f);
        }
    }

    private void setupViewBobbing(float f) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)this.mc.getRenderViewEntity();
            float f2 = entityPlayer.distanceWalkedModified - entityPlayer.prevDistanceWalkedModified;
            float f3 = -(entityPlayer.distanceWalkedModified + f2 * f);
            float f4 = entityPlayer.prevCameraYaw + (entityPlayer.cameraYaw - entityPlayer.prevCameraYaw) * f;
            float f5 = entityPlayer.prevCameraPitch + (entityPlayer.cameraPitch - entityPlayer.prevCameraPitch) * f;
            GlStateManager.translate(MathHelper.sin(f3 * (float)Math.PI) * f4 * 0.5f, -Math.abs(MathHelper.cos(f3 * (float)Math.PI) * f4), 0.0f);
            GlStateManager.rotate(MathHelper.sin(f3 * (float)Math.PI) * f4 * 3.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(Math.abs(MathHelper.cos(f3 * (float)Math.PI - 0.2f) * f4) * 5.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(f5, 1.0f, 0.0f, 0.0f);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void orientCamera(float f) {
        oc02a3730b27.\u024f();
        try {
            Object object;
            this.mimeow$beginFreeLook();
            Entity entity = this.mc.getRenderViewEntity();
            float f2 = entity.getEyeHeight();
            double d = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)f;
            double d2 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)f + (double)f2;
            double d3 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)f;
            if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPlayerSleeping()) {
                f2 = (float)((double)f2 + 1.0);
                GlStateManager.translate(0.0f, 0.3f, 0.0f);
                if (!this.mc.gameSettings.debugCamEnable) {
                    object = new BlockPos(entity);
                    IBlockState iBlockState = this.mc.theWorld.getBlockState((BlockPos)object);
                    Block block = iBlockState.getBlock();
                    if (Reflector.CompatHooksClient_orientBedCamera.exists()) {
                        Reflector.callVoid(Reflector.CompatHooksClient_orientBedCamera, this.mc.theWorld, object, iBlockState, entity);
                    } else if (block == Blocks.bed) {
                        int n = iBlockState.getValue(BlockBed.FACING).getHorizontalIndex();
                        GlStateManager.rotate(n * 90, 0.0f, 1.0f, 0.0f);
                    }
                    GlStateManager.rotate(this.mimeow$redirect$freelookPrevRotationYaw(entity) + (this.mimeow$redirect$freelookRotationYaw(entity) - this.mimeow$redirect$freelookPrevRotationYaw(entity)) * f + 180.0f, 0.0f, -1.0f, 0.0f);
                    GlStateManager.rotate(this.mimeow$redirect$freelookPrevRotationPitch(entity) + (this.mimeow$redirect$freelookRotationPitch(entity) - this.mimeow$redirect$freelookPrevRotationPitch(entity)) * f, -1.0f, 0.0f, 0.0f);
                }
            } else if (this.mc.gameSettings.thirdPersonView > 0) {
                double d4 = this.thirdPersonDistanceTemp + (this.thirdPersonDistance - this.thirdPersonDistanceTemp) * f;
                if (this.mc.gameSettings.debugCamEnable) {
                    GlStateManager.translate(0.0f, 0.0f, (float)(-d4));
                } else {
                    float f3 = this.mimeow$redirect$freelookRotationYaw(entity);
                    float f4 = this.mimeow$redirect$freelookRotationPitch(entity);
                    if (this.mc.gameSettings.thirdPersonView == 2) {
                        f4 += 180.0f;
                    }
                    double d5 = (double)(-MathHelper.sin(f3 / 180.0f * (float)Math.PI) * MathHelper.cos(f4 / 180.0f * (float)Math.PI)) * d4;
                    double d6 = (double)(MathHelper.cos(f3 / 180.0f * (float)Math.PI) * MathHelper.cos(f4 / 180.0f * (float)Math.PI)) * d4;
                    double d7 = (double)(-MathHelper.sin(f4 / 180.0f * (float)Math.PI)) * d4;
                    for (int i = 0; i < 8; ++i) {
                        double d8;
                        MovingObjectPosition movingObjectPosition;
                        float f5 = (i & 1) * 2 - 1;
                        float f6 = (i >> 1 & 1) * 2 - 1;
                        float f7 = (i >> 2 & 1) * 2 - 1;
                        if ((movingObjectPosition = this.mc.theWorld.rayTraceBlocks(new Vec3(d + (double)(f5 *= 0.1f), d2 + (double)(f6 *= 0.1f), d3 + (double)(f7 *= 0.1f)), new Vec3(d - d5 + (double)f5 + (double)f7, d2 - d7 + (double)f6, d3 - d6 + (double)f7), false, true, true)) == null || !((d8 = this.mimeow$redirect$injectNoCameraClip(movingObjectPosition.hitVec, new Vec3(d, d2, d3))) < d4)) continue;
                        d4 = d8;
                    }
                    if (this.mc.gameSettings.thirdPersonView == 2) {
                        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    }
                    GlStateManager.rotate(this.mimeow$redirect$freelookRotationPitch(entity) - f4, 1.0f, 0.0f, 0.0f);
                    GlStateManager.rotate(this.mimeow$redirect$freelookRotationYaw(entity) - f3, 0.0f, 1.0f, 0.0f);
                    GlStateManager.translate(0.0f, 0.0f, (float)(-d4));
                    GlStateManager.rotate(f3 - this.mimeow$redirect$freelookRotationYaw(entity), 0.0f, 1.0f, 0.0f);
                    GlStateManager.rotate(f4 - this.mimeow$redirect$freelookRotationPitch(entity), 1.0f, 0.0f, 0.0f);
                }
            } else {
                GlStateManager.translate(0.0f, 0.0f, -0.1f);
            }
            if (Reflector.EntityViewRenderEvent_CameraSetup_Constructor.exists()) {
                if (!this.mc.gameSettings.debugCamEnable) {
                    float f8 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f + 180.0f;
                    float f9 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f;
                    float f10 = 0.0f;
                    if (entity instanceof EntityAnimal) {
                        EntityAnimal entityAnimal = (EntityAnimal)entity;
                        f8 = entityAnimal.prevRotationYawHead + (entityAnimal.rotationYawHead - entityAnimal.prevRotationYawHead) * f + 180.0f;
                    }
                    Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, f);
                    Object object2 = Reflector.newInstance(Reflector.EntityViewRenderEvent_CameraSetup_Constructor, this, entity, block, Float.valueOf(f), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10));
                    Reflector.postCompatBusEvent(object2);
                    f10 = Reflector.getFieldValueFloat(object2, Reflector.EntityViewRenderEvent_CameraSetup_roll, f10);
                    f9 = Reflector.getFieldValueFloat(object2, Reflector.EntityViewRenderEvent_CameraSetup_pitch, f9);
                    f8 = Reflector.getFieldValueFloat(object2, Reflector.EntityViewRenderEvent_CameraSetup_yaw, f8);
                    GlStateManager.rotate(f10, 0.0f, 0.0f, 1.0f);
                    GlStateManager.rotate(f9, 1.0f, 0.0f, 0.0f);
                    GlStateManager.rotate(f8, 0.0f, 1.0f, 0.0f);
                }
            } else if (!this.mc.gameSettings.debugCamEnable) {
                GlStateManager.rotate(this.mimeow$redirect$freelookPrevRotationPitch(entity) + (this.mimeow$redirect$freelookRotationPitch(entity) - this.mimeow$redirect$freelookPrevRotationPitch(entity)) * f, 1.0f, 0.0f, 0.0f);
                if (entity instanceof EntityAnimal) {
                    object = (EntityAnimal)entity;
                    GlStateManager.rotate(((EntityAnimal)object).prevRotationYawHead + (((EntityAnimal)object).rotationYawHead - ((EntityAnimal)object).prevRotationYawHead) * f + 180.0f, 0.0f, 1.0f, 0.0f);
                } else {
                    GlStateManager.rotate(this.mimeow$redirect$freelookPrevRotationYaw(entity) + (this.mimeow$redirect$freelookRotationYaw(entity) - this.mimeow$redirect$freelookPrevRotationYaw(entity)) * f + 180.0f, 0.0f, 1.0f, 0.0f);
                }
            }
            GlStateManager.translate(0.0f, -f2, 0.0f);
            d = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)f;
            d2 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)f + (double)f2;
            d3 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)f;
            this.cloudFog = this.mc.renderGlobal.hasCloudFog(d, d2, d3, f);
            this.mimeow$restoreFreeLook();
        }
        finally {
            oc02a3730b27.\u051b();
        }
    }

    public void setupCameraTransform(float f, int n) {
        float f2;
        this.farPlaneDistance = this.mc.gameSettings.renderDistanceChunks * 16;
        if (Config.isFogFancy()) {
            this.farPlaneDistance *= 0.95f;
        }
        if (Config.isFogFast()) {
            this.farPlaneDistance *= 0.83f;
        }
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        float f3 = 0.07f;
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate((float)(-(n * 2 - 1)) * 0.07f, 0.0f, 0.0f);
        }
        this.clipDistance = this.farPlaneDistance * 2.0f;
        if (this.clipDistance < 173.0f) {
            this.clipDistance = 173.0f;
        }
        if (this.cameraZoom != 1.0) {
            GlStateManager.translate((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0f);
            GlStateManager.scale(this.cameraZoom, this.cameraZoom, 1.0);
        }
        Project.gluPerspective(this.getFOVModifier(f, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate((float)(n * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.hurtCameraEffect(f);
        if (this.mc.gameSettings.viewBobbing) {
            this.setupViewBobbing(f);
        }
        if ((f2 = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * f) > 0.0f) {
            int n2 = 20;
            if (this.mimeow$redirectSetupCameraTransform(this.mc.thePlayer, Potion.confusion)) {
                n2 = 7;
            }
            float f4 = 5.0f / (f2 * f2 + 5.0f) - f2 * 0.04f;
            f4 *= f4;
            GlStateManager.rotate(((float)this.rendererUpdateCount + f) * (float)n2, 0.0f, 1.0f, 1.0f);
            GlStateManager.scale(1.0f / f4, 1.0f, 1.0f);
            GlStateManager.rotate(-((float)this.rendererUpdateCount + f) * (float)n2, 0.0f, 1.0f, 1.0f);
        }
        this.orientCamera(f);
        Objects.requireNonNull(this);
    }

    private void renderHand(float f, int n) {
        this.renderHand(f, n, true, true, false);
    }

    public void renderHand(float f, int n, boolean bl, boolean bl2, boolean bl3) {
        Objects.requireNonNull(this);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        float f2 = 0.07f;
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate((float)(-(n * 2 - 1)) * 0.07f, 0.0f, 0.0f);
        }
        if (Config.isShaders()) {
            Shaders.applyHandDepth();
        }
        Project.gluPerspective(this.getFOVModifier(f, false), (float)this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.farPlaneDistance * 2.0f);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate((float)(n * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        boolean bl4 = false;
        if (bl) {
            boolean bl5;
            GlStateManager.pushMatrix();
            this.hurtCameraEffect(f);
            if (this.mc.gameSettings.viewBobbing) {
                this.setupViewBobbing(f);
            }
            bl4 = this.mc.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping();
            boolean bl6 = bl5 = !ReflectorCompat.renderFirstPersonHand(this.mc.renderGlobal, f, n);
            if (bl5 && this.mc.gameSettings.thirdPersonView == 0 && !bl4 && !this.mc.gameSettings.hideGUI && !this.mc.playerController.isSpectator()) {
                this.enableLightmap();
                if (Config.isShaders()) {
                    ShadersRender.renderItemFP(this.itemRenderer, f, bl3);
                } else {
                    this.itemRenderer.renderItemInFirstPerson(f);
                }
                this.disableLightmap();
            }
            GlStateManager.popMatrix();
        }
        if (!bl2) {
            return;
        }
        this.disableLightmap();
        if (this.mc.gameSettings.thirdPersonView == 0 && !bl4) {
            this.itemRenderer.renderOverlays(f);
            this.hurtCameraEffect(f);
        }
        if (this.mc.gameSettings.viewBobbing) {
            this.setupViewBobbing(f);
        }
    }

    public void disableLightmap() {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.disableLightmap();
        }
    }

    public void enableLightmap() {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.matrixMode(5890);
        GlStateManager.loadIdentity();
        float f = 0.00390625f;
        GlStateManager.scale(0.00390625f, 0.00390625f, 0.00390625f);
        GlStateManager.translate(8.0f, 8.0f, 8.0f);
        GlStateManager.matrixMode(5888);
        this.mc.getTextureManager().bindTexture(this.locationLightMap);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 33071);
        GL11.glTexParameteri(3553, 10243, 33071);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.enableLightmap();
        }
    }

    private void updateTorchFlicker() {
        this.torchFlickerDX = (float)((double)this.torchFlickerDX + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.torchFlickerDX = (float)((double)this.torchFlickerDX * 0.9);
        this.torchFlickerX += (this.torchFlickerDX - this.torchFlickerX) * 1.0f;
        this.lightmapUpdateNeeded = true;
    }

    private void updateLightmap(float f) {
        if (this.lightmapUpdateNeeded) {
            this.mc.mcProfiler.startSection("lightTex");
            WorldClient worldClient = this.mc.theWorld;
            if (worldClient != null) {
                if (Config.isCustomColors() && CustomColors.updateLightmap(worldClient, this.torchFlickerX, this.lightmapColors, this.mc.thePlayer.isPotionActive(Potion.nightVision), f)) {
                    this.lightmapTexture.updateDynamicTexture();
                    this.lightmapUpdateNeeded = false;
                    this.mc.mcProfiler.endSection();
                    return;
                }
                float f2 = worldClient.getSunBrightness(1.0f);
                float f3 = f2 * 0.95f + 0.05f;
                for (int i = 0; i < 256; ++i) {
                    float f4;
                    float f5;
                    float f6 = worldClient.provider.getLightBrightnessTable()[i / 16] * f3;
                    float f7 = worldClient.provider.getLightBrightnessTable()[i % 16] * (this.torchFlickerX * 0.1f + 1.5f);
                    if (worldClient.getLastLightningBolt() > 0) {
                        f6 = worldClient.provider.getLightBrightnessTable()[i / 16];
                    }
                    float f8 = f6 * (f2 * 0.65f + 0.35f);
                    float f9 = f6 * (f2 * 0.65f + 0.35f);
                    float f10 = f7 * ((f7 * 0.6f + 0.4f) * 0.6f + 0.4f);
                    float f11 = f7 * (f7 * f7 * 0.6f + 0.4f);
                    float f12 = f8 + f7;
                    float f13 = f9 + f10;
                    float f14 = f6 + f11;
                    f12 = f12 * 0.96f + 0.03f;
                    f13 = f13 * 0.96f + 0.03f;
                    f14 = f14 * 0.96f + 0.03f;
                    if (this.bossColorModifier > 0.0f) {
                        f5 = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * f;
                        f12 = f12 * (1.0f - f5) + f12 * 0.7f * f5;
                        f13 = f13 * (1.0f - f5) + f13 * 0.6f * f5;
                        f14 = f14 * (1.0f - f5) + f14 * 0.6f * f5;
                    }
                    if (worldClient.provider.getDimensionId() == 1) {
                        f12 = 0.22f + f7 * 0.75f;
                        f13 = 0.28f + f10 * 0.75f;
                        f14 = 0.25f + f11 * 0.75f;
                    }
                    if (this.mc.thePlayer.isPotionActive(Potion.nightVision)) {
                        f5 = this.getNightVisionBrightness(this.mc.thePlayer, f);
                        f4 = 1.0f / f12;
                        if (f4 > 1.0f / f13) {
                            f4 = 1.0f / f13;
                        }
                        if (f4 > 1.0f / f14) {
                            f4 = 1.0f / f14;
                        }
                        f12 = f12 * (1.0f - f5) + f12 * f4 * f5;
                        f13 = f13 * (1.0f - f5) + f13 * f4 * f5;
                        f14 = f14 * (1.0f - f5) + f14 * f4 * f5;
                    }
                    if (f12 > 1.0f) {
                        f12 = 1.0f;
                    }
                    if (f13 > 1.0f) {
                        f13 = 1.0f;
                    }
                    if (f14 > 1.0f) {
                        f14 = 1.0f;
                    }
                    f5 = this.mc.gameSettings.gammaSetting;
                    f4 = 1.0f - f12;
                    float f15 = 1.0f - f13;
                    float f16 = 1.0f - f14;
                    f4 = 1.0f - f4 * f4 * f4 * f4;
                    f15 = 1.0f - f15 * f15 * f15 * f15;
                    f16 = 1.0f - f16 * f16 * f16 * f16;
                    f12 = f12 * (1.0f - f5) + f4 * f5;
                    f13 = f13 * (1.0f - f5) + f15 * f5;
                    f14 = f14 * (1.0f - f5) + f16 * f5;
                    f12 = f12 * 0.96f + 0.03f;
                    f13 = f13 * 0.96f + 0.03f;
                    f14 = f14 * 0.96f + 0.03f;
                    if (f12 > 1.0f) {
                        f12 = 1.0f;
                    }
                    if (f13 > 1.0f) {
                        f13 = 1.0f;
                    }
                    if (f14 > 1.0f) {
                        f14 = 1.0f;
                    }
                    if (f12 < 0.0f) {
                        f12 = 0.0f;
                    }
                    if (f13 < 0.0f) {
                        f13 = 0.0f;
                    }
                    if (f14 < 0.0f) {
                        f14 = 0.0f;
                    }
                    int n = 255;
                    int n2 = (int)(f12 * 255.0f);
                    int n3 = (int)(f13 * 255.0f);
                    int n4 = (int)(f14 * 255.0f);
                    this.lightmapColors[i] = 0xFF000000 | n2 << 16 | n3 << 8 | n4;
                }
                this.lightmapTexture.updateDynamicTexture();
                this.lightmapUpdateNeeded = false;
                this.mc.mcProfiler.endSection();
            }
        }
    }

    public float getNightVisionBrightness(EntityLivingBase entityLivingBase, float f) {
        int n = entityLivingBase.getActivePotionEffect(Potion.nightVision).getDuration();
        return n > 200 ? 1.0f : 0.7f + MathHelper.sin(((float)n - f) * (float)Math.PI * 0.2f) * 0.3f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCameraAndRender(float f, long l) {
        oc02a3730b27.\u03bc();
        try {
            int n;
            Config.renderPartialTicks = f;
            this.frameInit();
            boolean bl = Display.isActive();
            if (!(bl || !this.mc.gameSettings.pauseOnLostFocus || this.mc.gameSettings.touchscreen && Mouse.isButtonDown(1))) {
                if (Minecraft.getSystemTime() - this.prevFrameTime > 500L) {
                    this.mc.displayInGameMenu();
                }
            } else {
                this.prevFrameTime = Minecraft.getSystemTime();
            }
            this.mc.mcProfiler.startSection("mouse");
            if (bl && Minecraft.isRunningOnMac && this.mimeow$redirect$freelookOverrideMouse(this.mc) && !Mouse.isInsideWindow()) {
                Mouse.setGrabbed(false);
                Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
                Mouse.setGrabbed(true);
            }
            if (this.mimeow$redirect$freelookOverrideMouse(this.mc) && bl) {
                this.mc.mouseHelper.mouseXYChange();
                float f2 = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
                float f3 = f2 * f2 * f2 * 8.0f;
                float f4 = (float)this.mc.mouseHelper.deltaX * f3;
                float f5 = (float)this.mc.mouseHelper.deltaY * f3;
                n = 1;
                if (this.mc.gameSettings.invertMouse) {
                    n = -1;
                }
                if (this.mc.gameSettings.smoothCamera) {
                    this.smoothCamYaw += f4;
                    this.smoothCamPitch += f5;
                    float f6 = f - this.smoothCamPartialTicks;
                    this.smoothCamPartialTicks = f;
                    f4 = this.smoothCamFilterX * f6;
                    f5 = this.smoothCamFilterY * f6;
                    this.mc.thePlayer.setAngles(f4, f5 * (float)n);
                } else {
                    this.smoothCamYaw = 0.0f;
                    this.smoothCamPitch = 0.0f;
                    this.mc.thePlayer.setAngles(f4, f5 * (float)n);
                }
            }
            this.mc.mcProfiler.endSection();
            if (!this.mc.skipRenderWorld) {
                anaglyphEnable = this.mc.gameSettings.anaglyph;
                ScaledResolution scaledResolution = new ScaledResolution(this.mc);
                int n2 = scaledResolution.getScaledWidth();
                int n3 = scaledResolution.getScaledHeight();
                int n4 = Mouse.getX() * n2 / this.mc.displayWidth;
                n = n3 - Mouse.getY() * n3 / this.mc.displayHeight - 1;
                int n5 = this.mc.gameSettings.limitFramerate;
                if (this.mc.theWorld != null) {
                    this.mc.mcProfiler.startSection("level");
                    int n6 = Math.min(Minecraft.getDebugFPS(), n5);
                    n6 = Math.max(n6, 60);
                    long l2 = System.nanoTime() - l;
                    long l3 = Math.max((long)(1000000000 / n6 / 4) - l2, 0L);
                    this.renderWorld(f, System.nanoTime() + l3);
                    if (OpenGlHelper.shadersSupported) {
                        this.mc.renderGlobal.renderEntityOutlineFramebuffer();
                        this.mimeow$onRenderSaturation(f, l, new ocee33618a8d("updateCameraAndRender", false));
                        if (this.theShaderGroup != null && this.useShader) {
                            GlStateManager.matrixMode(5890);
                            GlStateManager.pushMatrix();
                            GlStateManager.loadIdentity();
                            this.theShaderGroup.loadShaderGroup(f);
                            GlStateManager.popMatrix();
                        }
                        this.mc.getFramebuffer().bindFramebuffer(true);
                    }
                    this.renderEndNanoTime = System.nanoTime();
                    this.mc.mcProfiler.endStartSection("gui");
                    if (!this.mc.gameSettings.hideGUI || this.mc.currentScreen != null) {
                        GlStateManager.alphaFunc(516, 0.1f);
                        this.mc.ingameGUI.renderGameOverlay(f);
                        if (this.mc.gameSettings.ofShowFps && !this.mc.gameSettings.showDebugInfo) {
                            Config.drawFps();
                        }
                        if (this.mc.gameSettings.showDebugInfo) {
                            Lagometer.showLagometer(scaledResolution);
                        }
                    }
                    this.mc.mcProfiler.endSection();
                } else {
                    GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
                    GlStateManager.matrixMode(5889);
                    GlStateManager.loadIdentity();
                    GlStateManager.matrixMode(5888);
                    GlStateManager.loadIdentity();
                    this.setupOverlayRendering();
                    this.renderEndNanoTime = System.nanoTime();
                    TileEntityRendererDispatcher.instance.renderEngine = this.mc.getTextureManager();
                    TileEntityRendererDispatcher.instance.fontRenderer = this.mc.fontRendererObj;
                }
                if (this.mc.currentScreen != null) {
                    GuiScreen guiScreen = this.mc.currentScreen;
                    GlStateManager.clear(256);
                    try {
                        if (Reflector.CompatHooksClient_drawScreen.exists()) {
                            Reflector.callVoid(Reflector.CompatHooksClient_drawScreen, this.mc.currentScreen, n4, n, Float.valueOf(f));
                        } else {
                            this.mc.currentScreen.drawScreen(n4, n, f);
                        }
                        ocea775c9d5c.\u0173.post(new oc36adbc80c5(guiScreen, n4, n, f));
                    }
                    catch (Throwable throwable) {
                        CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Rendering screen");
                        CrashReportCategory crashReportCategory = crashReport.makeCategory("Screen render details");
                        crashReportCategory.addCrashSectionCallable("Screen name", () -> this.mc.currentScreen.getClass().getCanonicalName());
                        crashReportCategory.addCrashSectionCallable("Mouse location", () -> String.format("Scaled: (%d, %d). Absolute: (%d, %d)", n4, n, Mouse.getX(), Mouse.getY()));
                        crashReportCategory.addCrashSectionCallable("Screen size", () -> String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), this.mc.displayWidth, this.mc.displayHeight, scaledResolution.getScaleFactor()));
                        throw new ReportedException(crashReport);
                    }
                }
                if (oc2cf3d80e17.\u02e1 != null) {
                    oc2cf3d80e17.\u02e1.\u03e9(this.mc.displayWidth, this.mc.displayHeight);
                }
            }
            this.frameFinish();
            this.waitForServerThread();
            MemoryMonitor.update();
            Lagometer.updateLagometer();
            if (this.mc.gameSettings.ofProfiler) {
                this.mc.gameSettings.showDebugProfilerChart = true;
            }
        }
        finally {
            oc02a3730b27.\u0167();
        }
    }

    private boolean isDrawBlockOutline() {
        boolean bl;
        Objects.requireNonNull(this);
        Entity entity = this.mc.getRenderViewEntity();
        boolean bl2 = bl = entity instanceof EntityPlayer && !this.mc.gameSettings.hideGUI;
        if (bl && !((EntityPlayer)entity).capabilities.allowEdit) {
            ItemStack itemStack = ((EntityPlayer)entity).getCurrentEquippedItem();
            if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                BlockPos blockPos = this.mc.objectMouseOver.getBlockPos();
                IBlockState iBlockState = this.mc.theWorld.getBlockState(blockPos);
                Block block = iBlockState.getBlock();
                bl = this.mc.playerController.getCurrentGameType() == WorldSettings.GameType.SPECTATOR ? ReflectorCompat.blockHasTileEntity(iBlockState) && this.mc.theWorld.getTileEntity(blockPos) instanceof IInventory : itemStack != null && (itemStack.canDestroy(block) || itemStack.canPlaceOn(block));
            }
        }
        return bl;
    }

    private void renderWorldDirections(float f) {
        if (this.mc.gameSettings.showDebugInfo && !this.mc.gameSettings.hideGUI && !this.mc.thePlayer.hasReducedDebug() && !this.mc.gameSettings.reducedDebugInfo) {
            Entity entity = this.mc.getRenderViewEntity();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GL11.glLineWidth(1.0f);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            this.orientCamera(f);
            GlStateManager.translate(0.0f, entity.getEyeHeight(), 0.0f);
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(0.0, 0.0, 0.0, 0.005, 1.0E-4, 1.0E-4), 255, 0, 0, 255);
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0E-4, 1.0E-4, 0.005), 0, 0, 255, 255);
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0E-4, 0.0033, 1.0E-4), 0, 255, 0, 255);
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
        }
    }

    public void renderWorld(float f, long l) {
        this.updateLightmap(f);
        if (this.mc.getRenderViewEntity() == null) {
            this.mc.setRenderViewEntity(this.mc.thePlayer);
        }
        this.getMouseOver(f);
        this.mimeow$onRenderWorld(f, l, new ocee33618a8d("renderWorld", false));
        if (Config.isShaders()) {
            Shaders.beginRender(this.mc, f, l);
        }
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        this.mc.mcProfiler.startSection("center");
        if (this.mc.gameSettings.anaglyph) {
            anaglyphField = 0;
            GlStateManager.colorMask(false, true, true, false);
            this.renderWorldPass(0, f, l);
            anaglyphField = 1;
            GlStateManager.colorMask(true, false, false, false);
            this.renderWorldPass(1, f, l);
            GlStateManager.colorMask(true, true, true, false);
        } else {
            this.renderWorldPass(2, f, l);
        }
        this.mc.mcProfiler.endSection();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void renderWorldPass(int n, float f, long l) {
        EntityPlayer entityPlayer;
        boolean bl = Config.isShaders();
        if (bl) {
            Shaders.beginRenderPass(n, f, l);
        }
        RenderGlobal renderGlobal = this.mc.renderGlobal;
        EffectRenderer effectRenderer = this.mc.effectRenderer;
        boolean bl2 = this.isDrawBlockOutline();
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("clear");
        if (bl) {
            Shaders.setViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        } else {
            GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }
        this.updateFogColor(f);
        GlStateManager.clear(16640);
        if (bl) {
            Shaders.clearRenderBuffer();
        }
        this.mc.mcProfiler.endStartSection("camera");
        this.setupCameraTransform(f, n);
        if (bl) {
            Shaders.setCamera(f);
        }
        ActiveRenderInfo.updateRenderInfo(this.mc.thePlayer, this.mc.gameSettings.thirdPersonView == 2);
        this.mc.mcProfiler.endStartSection("frustum");
        ClippingHelper clippingHelper = ClippingHelperImpl.getInstance();
        this.mc.mcProfiler.endStartSection("culling");
        clippingHelper.disabled = Config.isShaders() && !Shaders.isFrustumCulling();
        Frustum frustum = new Frustum(clippingHelper);
        Entity entity = this.mc.getRenderViewEntity();
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        if (bl) {
            ShadersRender.setFrustrumPosition(frustum, d, d2, d3);
        } else {
            frustum.setPosition(d, d2, d3);
        }
        oc4a43182f3e.\u0272 = frustum;
        if ((Config.isSkyEnabled() || Config.isSunMoonEnabled() || Config.isStarsEnabled()) && !Shaders.isShadowPass) {
            this.setupFog(-1, f);
            this.mc.mcProfiler.endStartSection("sky");
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(f, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
            if (bl) {
                Shaders.beginSky();
            }
            renderGlobal.renderSky(f, n);
            if (bl) {
                Shaders.endSky();
            }
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(f, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
        } else {
            GlStateManager.disableBlend();
        }
        this.setupFog(0, f);
        GlStateManager.shadeModel(7425);
        if (entity.posY + (double)entity.getEyeHeight() < 128.0 + (double)(this.mc.gameSettings.ofCloudsHeight * 128.0f)) {
            this.renderCloudsCheck(renderGlobal, f, n);
        }
        this.mc.mcProfiler.endStartSection("prepareterrain");
        this.setupFog(0, f);
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        RenderHelper.disableStandardItemLighting();
        this.mc.mcProfiler.endStartSection("terrain_setup");
        this.checkLoadVisibleChunks(entity, f, frustum, this.mc.thePlayer.isSpectator());
        if (bl) {
            ShadersRender.setupTerrain(renderGlobal, entity, f, frustum, this.frameCount++, this.mc.thePlayer.isSpectator());
        } else {
            renderGlobal.setupTerrain(entity, f, frustum, this.frameCount++, this.mc.thePlayer.isSpectator());
        }
        if (n == 0 || n == 2) {
            this.mc.mcProfiler.endStartSection("updatechunks");
            Lagometer.timerChunkUpload.start();
            this.mc.renderGlobal.updateChunks(l);
            Lagometer.timerChunkUpload.end();
        }
        this.mc.mcProfiler.endStartSection("terrain");
        Lagometer.timerTerrain.start();
        if (this.mc.gameSettings.ofSmoothFps && n > 0) {
            this.mc.mcProfiler.endStartSection("finish");
            GL11.glFinish();
            this.mc.mcProfiler.endStartSection("terrain");
        }
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        if (bl) {
            ShadersRender.beginTerrainSolid();
        }
        renderGlobal.renderBlockLayer(EnumWorldBlockLayer.SOLID, f, n, entity);
        GlStateManager.enableAlpha();
        if (bl) {
            ShadersRender.beginTerrainCutoutMipped();
        }
        this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).setBlurMipmap(false, this.mc.gameSettings.mipmapLevels > 0);
        renderGlobal.renderBlockLayer(EnumWorldBlockLayer.CUTOUT_MIPPED, f, n, entity);
        this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).restoreLastBlurMipmap();
        this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).setBlurMipmap(false, false);
        if (bl) {
            ShadersRender.beginTerrainCutout();
        }
        renderGlobal.renderBlockLayer(EnumWorldBlockLayer.CUTOUT, f, n, entity);
        this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).restoreLastBlurMipmap();
        if (bl) {
            ShadersRender.endTerrain();
        }
        Lagometer.timerTerrain.end();
        GlStateManager.shadeModel(7424);
        GlStateManager.alphaFunc(516, 0.1f);
        Objects.requireNonNull(this);
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        RenderHelper.enableStandardItemLighting();
        this.mc.mcProfiler.endStartSection("entities");
        if (Reflector.CompatHooksClient_setRenderPass.exists()) {
            Reflector.callVoid(Reflector.CompatHooksClient_setRenderPass, 0);
        }
        renderGlobal.renderEntities(entity, frustum, f);
        if (Reflector.CompatHooksClient_setRenderPass.exists()) {
            Reflector.callVoid(Reflector.CompatHooksClient_setRenderPass, -1);
        }
        RenderHelper.disableStandardItemLighting();
        this.disableLightmap();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        if (this.mc.objectMouseOver != null && entity.isInsideOfMaterial(Material.water) && bl2) {
            entityPlayer = (EntityPlayer)entity;
            GlStateManager.disableAlpha();
            this.mc.mcProfiler.endStartSection("outline");
            renderGlobal.drawSelectionBox(entityPlayer, this.mc.objectMouseOver, 0, f);
            GlStateManager.enableAlpha();
        }
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        if (bl2 && this.mc.objectMouseOver != null && !entity.isInsideOfMaterial(Material.water)) {
            entityPlayer = (EntityPlayer)entity;
            GlStateManager.disableAlpha();
            this.mc.mcProfiler.endStartSection("outline");
            if (!(Reflector.CompatHooksClient_onDrawBlockHighlight.exists() && Reflector.callBoolean(Reflector.CompatHooksClient_onDrawBlockHighlight, renderGlobal, entityPlayer, this.mc.objectMouseOver, 0, entityPlayer.getHeldItem(), Float.valueOf(f)) || this.mc.gameSettings.hideGUI)) {
                renderGlobal.drawSelectionBox(entityPlayer, this.mc.objectMouseOver, 0, f);
            }
            GlStateManager.enableAlpha();
        }
        if (!renderGlobal.damagedBlocks.isEmpty()) {
            this.mc.mcProfiler.endStartSection("destroyProgress");
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
            this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).setBlurMipmap(false, false);
            renderGlobal.drawBlockDamageTexture(Tessellator.getInstance(), Tessellator.getInstance().getWorldRenderer(), entity, f);
            this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).restoreLastBlurMipmap();
            GlStateManager.disableBlend();
        }
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableBlend();
        Objects.requireNonNull(this);
        this.enableLightmap();
        this.mc.mcProfiler.endStartSection("litParticles");
        if (bl) {
            Shaders.beginLitParticles();
        }
        effectRenderer.renderLitParticles(entity, f);
        RenderHelper.disableStandardItemLighting();
        this.setupFog(0, f);
        this.mc.mcProfiler.endStartSection("particles");
        if (bl) {
            Shaders.beginParticles();
        }
        effectRenderer.renderParticles(entity, f);
        if (bl) {
            Shaders.endParticles();
        }
        this.disableLightmap();
        GlStateManager.depthMask(false);
        if (Config.isShaders()) {
            GlStateManager.depthMask(Shaders.isRainDepth());
        }
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("weather");
        if (bl) {
            Shaders.beginWeather();
        }
        this.renderRainSnow(f);
        if (bl) {
            Shaders.endWeather();
        }
        GlStateManager.depthMask(true);
        renderGlobal.renderWorldBorder(entity, f);
        if (bl) {
            ShadersRender.renderHand0(this, f, n);
            Shaders.preWater();
        }
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.alphaFunc(516, 0.1f);
        this.setupFog(0, f);
        GlStateManager.enableBlend();
        GlStateManager.depthMask(false);
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        GlStateManager.shadeModel(7425);
        this.mc.mcProfiler.endStartSection("translucent");
        if (bl) {
            Shaders.beginWater();
        }
        renderGlobal.renderBlockLayer(EnumWorldBlockLayer.TRANSLUCENT, f, n, entity);
        if (bl) {
            Shaders.endWater();
        }
        if (Reflector.CompatHooksClient_setRenderPass.exists()) {
            Objects.requireNonNull(this);
            RenderHelper.enableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("entities");
            Reflector.callVoid(Reflector.CompatHooksClient_setRenderPass, 1);
            this.mc.renderGlobal.renderEntities(entity, frustum, f);
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            Reflector.callVoid(Reflector.CompatHooksClient_setRenderPass, -1);
            RenderHelper.disableStandardItemLighting();
        }
        GlStateManager.shadeModel(7424);
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.disableFog();
        if (entity.posY + (double)entity.getEyeHeight() >= 128.0 + (double)(this.mc.gameSettings.ofCloudsHeight * 128.0f)) {
            this.mc.mcProfiler.endStartSection("aboveClouds");
            this.renderCloudsCheck(renderGlobal, f, n);
        }
        if (Reflector.CompatHooksClient_dispatchRenderLast.exists()) {
            this.mc.mcProfiler.endStartSection("compat_render_last");
            Reflector.callVoid(Reflector.CompatHooksClient_dispatchRenderLast, renderGlobal, Float.valueOf(f));
        }
        GL11.glPushAttrib(1048575);
        GlStateManager.pushMatrix();
        try {
            this.mimeow$renderWorldLast(f, l, new ocee33618a8d("renderWorld", false));
        }
        finally {
            GlStateManager.popMatrix();
            GL11.glPopAttrib();
        }
        this.mimeow$restoreFirstPersonRenderState();
        this.setupCameraTransform(f, n);
        this.mc.mcProfiler.endStartSection("hand");
        Objects.requireNonNull(this);
        if (!Shaders.isShadowPass) {
            if (bl) {
                ShadersRender.renderHand1(this, f, n);
                Shaders.renderCompositeFinal();
            }
            GlStateManager.clear(256);
            if (bl) {
                ShadersRender.renderFPOverlay(this, f, n);
            } else {
                this.renderHand(f, n);
            }
            this.renderWorldDirections(f);
        }
        if (bl) {
            Shaders.endRender();
        }
    }

    private void renderCloudsCheck(RenderGlobal renderGlobal, float f, int n) {
        if (this.mc.gameSettings.renderDistanceChunks >= 4 && !Config.isCloudsOff() && Shaders.shouldRenderClouds(this.mc.gameSettings)) {
            this.mc.mcProfiler.endStartSection("clouds");
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(f, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance * 4.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            this.setupFog(0, f);
            renderGlobal.renderClouds(f, n);
            GlStateManager.disableFog();
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(f, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
        }
    }

    private void addRainParticles() {
        float f = this.mc.theWorld.getRainStrength(1.0f);
        if (!Config.isRainFancy()) {
            f /= 2.0f;
        }
        if (f != 0.0f && Config.isRainSplash()) {
            this.random.setSeed((long)this.rendererUpdateCount * 312987231L);
            Entity entity = this.mc.getRenderViewEntity();
            WorldClient worldClient = this.mc.theWorld;
            BlockPos blockPos = new BlockPos(entity);
            int n = 10;
            double d = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            int n2 = 0;
            int n3 = (int)(100.0f * f * f);
            if (this.mc.gameSettings.particleSetting == 1) {
                n3 >>= 1;
            } else if (this.mc.gameSettings.particleSetting == 2) {
                n3 = 0;
            }
            for (int i = 0; i < n3; ++i) {
                BlockPos blockPos2 = worldClient.getPrecipitationHeight(blockPos.add(this.random.nextInt(10) - this.random.nextInt(10), 0, this.random.nextInt(10) - this.random.nextInt(10)));
                BiomeGenBase biomeGenBase = worldClient.getBiomeGenForCoords(blockPos2);
                BlockPos blockPos3 = blockPos2.down();
                Block block = worldClient.getBlockState(blockPos3).getBlock();
                if (blockPos2.getY() > blockPos.getY() + 10 || blockPos2.getY() < blockPos.getY() - 10 || !biomeGenBase.canRain() || !(biomeGenBase.getFloatTemperature(blockPos2) >= 0.15f)) continue;
                double d4 = this.random.nextDouble();
                double d5 = this.random.nextDouble();
                if (block.getMaterial() == Material.lava) {
                    this.mc.theWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double)blockPos2.getX() + d4, (double)((float)blockPos2.getY() + 0.1f) - block.getBlockBoundsMinY(), (double)blockPos2.getZ() + d5, 0.0, 0.0, 0.0, new int[0]);
                    continue;
                }
                if (block.getMaterial() == Material.air) continue;
                block.setBlockBoundsBasedOnState(worldClient, blockPos3);
                if (this.random.nextInt(++n2) == 0) {
                    d = (double)blockPos3.getX() + d4;
                    d2 = (double)((float)blockPos3.getY() + 0.1f) + block.getBlockBoundsMaxY() - 1.0;
                    d3 = (double)blockPos3.getZ() + d5;
                }
                this.mc.theWorld.spawnParticle(EnumParticleTypes.WATER_DROP, (double)blockPos3.getX() + d4, (double)((float)blockPos3.getY() + 0.1f) + block.getBlockBoundsMaxY(), (double)blockPos3.getZ() + d5, 0.0, 0.0, 0.0, new int[0]);
            }
            if (n2 > 0 && this.random.nextInt(3) < this.rainSoundCounter++) {
                this.rainSoundCounter = 0;
                if (d2 > (double)(blockPos.getY() + 1) && worldClient.getPrecipitationHeight(blockPos).getY() > MathHelper.floor_float(blockPos.getY())) {
                    this.mc.theWorld.playSound(d, d2, d3, "ambient.weather.rain", 0.1f, 0.5f, false);
                } else {
                    this.mc.theWorld.playSound(d, d2, d3, "ambient.weather.rain", 0.2f, 1.0f, false);
                }
            }
        }
    }

    protected void renderRainSnow(float f) {
        WorldProvider worldProvider;
        Object object;
        if (Reflector.CompatWorldProvider_getWeatherRenderer.exists() && (object = Reflector.call(worldProvider = this.mc.theWorld.provider, Reflector.CompatWorldProvider_getWeatherRenderer, new Object[0])) != null) {
            Reflector.callVoid(object, Reflector.IRenderHandler_render, Float.valueOf(f), this.mc.theWorld, this.mc);
            return;
        }
        float f2 = this.mc.theWorld.getRainStrength(f);
        if (f2 > 0.0f) {
            if (Config.isRainOff()) {
                return;
            }
            this.enableLightmap();
            object = this.mc.getRenderViewEntity();
            WorldClient worldClient = this.mc.theWorld;
            int n = MathHelper.floor_double(((Entity)object).posX);
            int n2 = MathHelper.floor_double(((Entity)object).posY);
            int n3 = MathHelper.floor_double(((Entity)object).posZ);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            GlStateManager.disableCull();
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.alphaFunc(516, 0.1f);
            double d = ((Entity)object).lastTickPosX + (((Entity)object).posX - ((Entity)object).lastTickPosX) * (double)f;
            double d2 = ((Entity)object).lastTickPosY + (((Entity)object).posY - ((Entity)object).lastTickPosY) * (double)f;
            double d3 = ((Entity)object).lastTickPosZ + (((Entity)object).posZ - ((Entity)object).lastTickPosZ) * (double)f;
            int n4 = MathHelper.floor_double(d2);
            int n5 = 5;
            if (Config.isRainFancy()) {
                n5 = 10;
            }
            int n6 = -1;
            float f3 = (float)this.rendererUpdateCount + f;
            worldRenderer.setTranslation(-d, -d2, -d3);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (int i = n3 - n5; i <= n3 + n5; ++i) {
                for (int j = n - n5; j <= n + n5; ++j) {
                    double d4;
                    double d5;
                    double d6;
                    int n7 = (i - n3 + 16) * 32 + j - n + 16;
                    double d7 = (double)this.rainXCoords[n7] * 0.5;
                    double d8 = (double)this.rainYCoords[n7] * 0.5;
                    mutableBlockPos.set(j, 0, i);
                    BiomeGenBase biomeGenBase = worldClient.getBiomeGenForCoords(mutableBlockPos);
                    if (!biomeGenBase.canRain() && !biomeGenBase.getEnableSnow()) continue;
                    int n8 = worldClient.getPrecipitationHeight(mutableBlockPos).getY();
                    int n9 = n2 - n5;
                    int n10 = n2 + n5;
                    if (n9 < n8) {
                        n9 = n8;
                    }
                    if (n10 < n8) {
                        n10 = n8;
                    }
                    int n11 = n8;
                    if (n8 < n4) {
                        n11 = n4;
                    }
                    if (n9 == n10) continue;
                    this.random.setSeed(j * j * 3121 + j * 45238971 ^ i * i * 418711 + i * 13761);
                    mutableBlockPos.set(j, n9, i);
                    float f4 = biomeGenBase.getFloatTemperature(mutableBlockPos);
                    if (worldClient.getWorldChunkManager().getTemperatureAtHeight(f4, n8) >= 0.15f) {
                        if (n6 != 0) {
                            if (n6 >= 0) {
                                tessellator.draw();
                            }
                            n6 = 0;
                            this.mc.getTextureManager().bindTexture(locationRainPng);
                            worldRenderer.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                        }
                        d6 = ((double)(this.rendererUpdateCount + j * j * 3121 + j * 45238971 + i * i * 418711 + i * 13761 & 0x1F) + (double)f) / 32.0 * (3.0 + this.random.nextDouble());
                        d5 = (double)((float)j + 0.5f) - ((Entity)object).posX;
                        d4 = (double)((float)i + 0.5f) - ((Entity)object).posZ;
                        float f5 = MathHelper.sqrt_double(d5 * d5 + d4 * d4) / (float)n5;
                        float f6 = ((1.0f - f5 * f5) * 0.5f + 0.5f) * f2;
                        mutableBlockPos.set(j, n11, i);
                        int n12 = ((World)worldClient).getCombinedLight(mutableBlockPos, 0);
                        int n13 = n12 >> 16 & 0xFFFF;
                        int n14 = n12 & 0xFFFF;
                        worldRenderer.pos((double)j - d7 + 0.5, n9, (double)i - d8 + 0.5).tex(0.0, (double)n9 * 0.25 + d6).color(1.0f, 1.0f, 1.0f, f6).lightmap(n13, n14).endVertex();
                        worldRenderer.pos((double)j + d7 + 0.5, n9, (double)i + d8 + 0.5).tex(1.0, (double)n9 * 0.25 + d6).color(1.0f, 1.0f, 1.0f, f6).lightmap(n13, n14).endVertex();
                        worldRenderer.pos((double)j + d7 + 0.5, n10, (double)i + d8 + 0.5).tex(1.0, (double)n10 * 0.25 + d6).color(1.0f, 1.0f, 1.0f, f6).lightmap(n13, n14).endVertex();
                        worldRenderer.pos((double)j - d7 + 0.5, n10, (double)i - d8 + 0.5).tex(0.0, (double)n10 * 0.25 + d6).color(1.0f, 1.0f, 1.0f, f6).lightmap(n13, n14).endVertex();
                        continue;
                    }
                    if (n6 != 1) {
                        if (n6 >= 0) {
                            tessellator.draw();
                        }
                        n6 = 1;
                        this.mc.getTextureManager().bindTexture(locationSnowPng);
                        worldRenderer.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                    }
                    d6 = ((float)(this.rendererUpdateCount & 0x1FF) + f) / 512.0f;
                    d5 = this.random.nextDouble() + (double)f3 * 0.01 * (double)((float)this.random.nextGaussian());
                    d4 = this.random.nextDouble() + (double)(f3 * (float)this.random.nextGaussian()) * 0.001;
                    double d9 = (double)((float)j + 0.5f) - ((Entity)object).posX;
                    double d10 = (double)((float)i + 0.5f) - ((Entity)object).posZ;
                    float f7 = MathHelper.sqrt_double(d9 * d9 + d10 * d10) / (float)n5;
                    float f8 = ((1.0f - f7 * f7) * 0.3f + 0.5f) * f2;
                    mutableBlockPos.set(j, n11, i);
                    int n15 = (((World)worldClient).getCombinedLight(mutableBlockPos, 0) * 3 + 0xF000F0) / 4;
                    int n16 = n15 >> 16 & 0xFFFF;
                    int n17 = n15 & 0xFFFF;
                    worldRenderer.pos((double)j - d7 + 0.5, n9, (double)i - d8 + 0.5).tex(0.0 + d5, (double)n9 * 0.25 + d6 + d4).color(1.0f, 1.0f, 1.0f, f8).lightmap(n16, n17).endVertex();
                    worldRenderer.pos((double)j + d7 + 0.5, n9, (double)i + d8 + 0.5).tex(1.0 + d5, (double)n9 * 0.25 + d6 + d4).color(1.0f, 1.0f, 1.0f, f8).lightmap(n16, n17).endVertex();
                    worldRenderer.pos((double)j + d7 + 0.5, n10, (double)i + d8 + 0.5).tex(1.0 + d5, (double)n10 * 0.25 + d6 + d4).color(1.0f, 1.0f, 1.0f, f8).lightmap(n16, n17).endVertex();
                    worldRenderer.pos((double)j - d7 + 0.5, n10, (double)i - d8 + 0.5).tex(0.0 + d5, (double)n10 * 0.25 + d6 + d4).color(1.0f, 1.0f, 1.0f, f8).lightmap(n16, n17).endVertex();
                }
            }
            if (n6 >= 0) {
                tessellator.draw();
            }
            worldRenderer.setTranslation(0.0, 0.0, 0.0);
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc(516, 0.1f);
            this.disableLightmap();
        }
    }

    public void setupOverlayRendering() {
        ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        GlStateManager.clear(256);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, scaledResolution.getScaledWidth_double(), scaledResolution.getScaledHeight_double(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
    }

    private void updateFogColor(float f) {
        float f2;
        float f3;
        Object object;
        float f4;
        Object object2;
        WorldClient worldClient = this.mc.theWorld;
        Entity entity = this.mc.getRenderViewEntity();
        float f5 = 0.25f + 0.75f * (float)this.mc.gameSettings.renderDistanceChunks / 32.0f;
        f5 = 1.0f - (float)Math.pow(f5, 0.25);
        Vec3 vec3 = worldClient.getSkyColor(this.mc.getRenderViewEntity(), f);
        vec3 = CustomColors.getWorldSkyColor(vec3, worldClient, this.mc.getRenderViewEntity(), f);
        float f6 = (float)vec3.xCoord;
        float f7 = (float)vec3.yCoord;
        float f8 = (float)vec3.zCoord;
        Vec3 vec32 = worldClient.getFogColor(f);
        vec32 = CustomColors.getWorldFogColor(vec32, worldClient, this.mc.getRenderViewEntity(), f);
        this.fogColorRed = (float)vec32.xCoord;
        this.fogColorGreen = (float)vec32.yCoord;
        this.fogColorBlue = (float)vec32.zCoord;
        if (this.mc.gameSettings.renderDistanceChunks >= 4) {
            double d = -1.0;
            object2 = MathHelper.sin(worldClient.getCelestialAngleRadians(f)) > 0.0f ? new Vec3(-1.0, 0.0, 0.0) : new Vec3(1.0, 0.0, 0.0);
            f4 = (float)entity.getLook(f).dotProduct((Vec3)object2);
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > 0.0f && (object = worldClient.provider.calcSunriseSunsetColors(worldClient.getCelestialAngle(f), f)) != null) {
                this.fogColorRed = this.fogColorRed * (1.0f - (f4 *= object[3])) + object[0] * f4;
                this.fogColorGreen = this.fogColorGreen * (1.0f - f4) + object[1] * f4;
                this.fogColorBlue = this.fogColorBlue * (1.0f - f4) + object[2] * f4;
            }
        }
        this.fogColorRed += (f6 - this.fogColorRed) * f5;
        this.fogColorGreen += (f7 - this.fogColorGreen) * f5;
        this.fogColorBlue += (f8 - this.fogColorBlue) * f5;
        float f9 = worldClient.getRainStrength(f);
        if (f9 > 0.0f) {
            f3 = 1.0f - f9 * 0.5f;
            float f10 = 1.0f - f9 * 0.4f;
            this.fogColorRed *= f3;
            this.fogColorGreen *= f3;
            this.fogColorBlue *= f10;
        }
        if ((f3 = worldClient.getThunderStrength(f)) > 0.0f) {
            float f11 = 1.0f - f3 * 0.5f;
            this.fogColorRed *= f11;
            this.fogColorGreen *= f11;
            this.fogColorBlue *= f11;
        }
        object2 = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, f);
        if (this.cloudFog) {
            Vec3 vec33 = worldClient.getCloudColour(f);
            this.fogColorRed = (float)vec33.xCoord;
            this.fogColorGreen = (float)vec33.yCoord;
            this.fogColorBlue = (float)vec33.zCoord;
        } else if (((Block)object2).getMaterial() == Material.water) {
            f4 = (float)EnchantmentHelper.getRespiration(entity) * 0.2f;
            f4 = Config.limit(f4, 0.0f, 0.6f);
            if (entity instanceof EntityLivingBase && this.mimeow$redirectFogColor((EntityLivingBase)entity, Potion.waterBreathing)) {
                f4 = f4 * 0.3f + 0.6f;
            }
            this.fogColorRed = 0.02f + f4;
            this.fogColorGreen = 0.02f + f4;
            this.fogColorBlue = 0.2f + f4;
            object = CustomColors.getUnderwaterColor(this.mc.theWorld, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ);
            if (object != null) {
                this.fogColorRed = (float)object.xCoord;
                this.fogColorGreen = (float)object.yCoord;
                this.fogColorBlue = (float)object.zCoord;
            }
        } else if (((Block)object2).getMaterial() == Material.lava) {
            this.fogColorRed = 0.6f;
            this.fogColorGreen = 0.1f;
            this.fogColorBlue = 0.0f;
            Vec3 vec34 = CustomColors.getUnderlavaColor(this.mc.theWorld, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ);
            if (vec34 != null) {
                this.fogColorRed = (float)vec34.xCoord;
                this.fogColorGreen = (float)vec34.yCoord;
                this.fogColorBlue = (float)vec34.zCoord;
            }
        }
        float f12 = this.fogColor2 + (this.fogColor1 - this.fogColor2) * f;
        this.fogColorRed *= f12;
        this.fogColorGreen *= f12;
        this.fogColorBlue *= f12;
        double d = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f) * worldClient.provider.getVoidFogYFactor();
        if (entity instanceof EntityLivingBase && this.mimeow$redirectFogColor((EntityLivingBase)entity, Potion.blindness)) {
            int n = ((EntityLivingBase)entity).getActivePotionEffect(Potion.blindness).getDuration();
            d = n < 20 ? (d *= (double)(1.0f - (float)n / 20.0f)) : 0.0;
        }
        if (d < 1.0) {
            if (d < 0.0) {
                d = 0.0;
            }
            d *= d;
            this.fogColorRed = (float)((double)this.fogColorRed * d);
            this.fogColorGreen = (float)((double)this.fogColorGreen * d);
            this.fogColorBlue = (float)((double)this.fogColorBlue * d);
        }
        if (this.bossColorModifier > 0.0f) {
            float f13 = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * f;
            this.fogColorRed = this.fogColorRed * (1.0f - f13) + this.fogColorRed * 0.7f * f13;
            this.fogColorGreen = this.fogColorGreen * (1.0f - f13) + this.fogColorGreen * 0.6f * f13;
            this.fogColorBlue = this.fogColorBlue * (1.0f - f13) + this.fogColorBlue * 0.6f * f13;
        }
        if (entity instanceof EntityLivingBase && this.mimeow$redirectFogColor((EntityLivingBase)entity, Potion.nightVision)) {
            float f14 = this.getNightVisionBrightness((EntityLivingBase)entity, f);
            f2 = 1.0f / this.fogColorRed;
            if (f2 > 1.0f / this.fogColorGreen) {
                f2 = 1.0f / this.fogColorGreen;
            }
            if (f2 > 1.0f / this.fogColorBlue) {
                f2 = 1.0f / this.fogColorBlue;
            }
            if (Float.isInfinite(f2)) {
                f2 = Math.nextAfter(f2, 0.0);
            }
            this.fogColorRed = this.fogColorRed * (1.0f - f14) + this.fogColorRed * f2 * f14;
            this.fogColorGreen = this.fogColorGreen * (1.0f - f14) + this.fogColorGreen * f2 * f14;
            this.fogColorBlue = this.fogColorBlue * (1.0f - f14) + this.fogColorBlue * f2 * f14;
        }
        if (this.mc.gameSettings.anaglyph) {
            float f15 = (this.fogColorRed * 30.0f + this.fogColorGreen * 59.0f + this.fogColorBlue * 11.0f) / 100.0f;
            f2 = (this.fogColorRed * 30.0f + this.fogColorGreen * 70.0f) / 100.0f;
            float f16 = (this.fogColorRed * 30.0f + this.fogColorBlue * 70.0f) / 100.0f;
            this.fogColorRed = f15;
            this.fogColorGreen = f2;
            this.fogColorBlue = f16;
        }
        if (Reflector.EntityViewRenderEvent_FogColors_Constructor.exists()) {
            Object object3 = Reflector.newInstance(Reflector.EntityViewRenderEvent_FogColors_Constructor, this, entity, object2, Float.valueOf(f), Float.valueOf(this.fogColorRed), Float.valueOf(this.fogColorGreen), Float.valueOf(this.fogColorBlue));
            Reflector.postCompatBusEvent(object3);
            this.fogColorRed = Reflector.getFieldValueFloat(object3, Reflector.EntityViewRenderEvent_FogColors_red, this.fogColorRed);
            this.fogColorGreen = Reflector.getFieldValueFloat(object3, Reflector.EntityViewRenderEvent_FogColors_green, this.fogColorGreen);
            this.fogColorBlue = Reflector.getFieldValueFloat(object3, Reflector.EntityViewRenderEvent_FogColors_blue, this.fogColorBlue);
        }
        Shaders.setClearColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 0.0f);
    }

    private void setupFog(int n, float f) {
        if (n != -1) {
            GlStateManager.disableFog();
            return;
        }
        this.fogStandard = false;
        Entity entity = this.mc.getRenderViewEntity();
        boolean bl = false;
        if (entity instanceof EntityPlayer) {
            bl = ((EntityPlayer)entity).capabilities.isCreativeMode;
        }
        GL11.glFogfv(2918, this.setFogColorBuffer(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 1.0f));
        GL11.glNormal3f(0.0f, -1.0f, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, f);
        float f2 = -1.0f;
        if (Reflector.CompatHooksClient_getFogDensity.exists()) {
            f2 = Reflector.callFloat(Reflector.CompatHooksClient_getFogDensity, this, entity, block, Float.valueOf(f), Float.valueOf(0.1f));
        }
        if (f2 >= 0.0f) {
            GlStateManager.setFogDensity(f2);
        } else if (entity instanceof EntityLivingBase && this.mimeow$redirectSetupFog((EntityLivingBase)entity, Potion.blindness)) {
            float f3 = 5.0f;
            int n2 = ((EntityLivingBase)entity).getActivePotionEffect(Potion.blindness).getDuration();
            if (n2 < 20) {
                f3 = 5.0f + (this.farPlaneDistance - 5.0f) * (1.0f - (float)n2 / 20.0f);
            }
            GlStateManager.setFog(9729);
            if (n == -1) {
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(f3 * 0.8f);
            } else {
                GlStateManager.setFogStart(f3 * 0.25f);
                GlStateManager.setFogEnd(f3);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance && Config.isFogFancy()) {
                GL11.glFogi(34138, 34139);
            }
        } else if (this.cloudFog) {
            GlStateManager.setFog(2048);
            GlStateManager.setFogDensity(0.1f);
        } else if (block.getMaterial() == Material.water) {
            float f4;
            GlStateManager.setFog(2048);
            float f5 = f4 = Config.isClearWater() ? 0.02f : 0.1f;
            if (entity instanceof EntityLivingBase && this.mimeow$redirectSetupFog((EntityLivingBase)entity, Potion.waterBreathing)) {
                GlStateManager.setFogDensity(0.01f);
            } else {
                float f6 = 0.1f - (float)EnchantmentHelper.getRespiration(entity) * 0.03f;
                GlStateManager.setFogDensity(Config.limit(f6, 0.0f, f4));
            }
        } else if (block.getMaterial() == Material.lava) {
            GlStateManager.setFog(2048);
            GlStateManager.setFogDensity(2.0f);
        } else {
            float f7 = this.farPlaneDistance;
            this.fogStandard = true;
            GlStateManager.setFog(9729);
            if (n == -1) {
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(f7);
            } else {
                GlStateManager.setFogStart(f7 * Config.getFogStart());
                GlStateManager.setFogEnd(f7);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                if (Config.isFogFancy()) {
                    GL11.glFogi(34138, 34139);
                }
                if (Config.isFogFast()) {
                    GL11.glFogi(34138, 34140);
                }
            }
            if (this.mc.theWorld.provider.doesXZShowFog((int)entity.posX, (int)entity.posZ)) {
                GlStateManager.setFogStart(f7 * 0.05f);
                GlStateManager.setFogEnd(f7);
            }
            if (Reflector.CompatHooksClient_onFogRender.exists()) {
                Reflector.callVoid(Reflector.CompatHooksClient_onFogRender, this, entity, block, Float.valueOf(f), n, Float.valueOf(f7));
            }
        }
        GlStateManager.enableColorMaterial();
        GlStateManager.enableFog();
        GlStateManager.colorMaterial(1028, 4608);
    }

    private FloatBuffer setFogColorBuffer(float f, float f2, float f3, float f4) {
        if (Config.isShaders()) {
            Shaders.setFogColor(f, f2, f3);
        }
        this.fogColorBuffer.clear();
        this.fogColorBuffer.put(f).put(f2).put(f3).put(f4);
        this.fogColorBuffer.flip();
        return this.fogColorBuffer;
    }

    public MapItemRenderer getMapItemRenderer() {
        return this.theMapItemRenderer;
    }

    private void waitForServerThread() {
        this.serverWaitTimeCurrent = 0;
        if (Config.isSmoothWorld() && Config.isSingleProcessor()) {
            IntegratedServer integratedServer;
            if (this.mc.isIntegratedServerRunning() && (integratedServer = this.mc.getIntegratedServer()) != null) {
                boolean bl = this.mc.isGamePaused();
                if (!bl && !(this.mc.currentScreen instanceof GuiDownloadTerrain)) {
                    if (this.serverWaitTime > 0) {
                        Lagometer.timerServer.start();
                        Config.sleep(this.serverWaitTime);
                        Lagometer.timerServer.end();
                        this.serverWaitTimeCurrent = this.serverWaitTime;
                    }
                    long l = System.nanoTime() / 1000000L;
                    if (this.lastServerTime != 0L && this.lastServerTicks != 0) {
                        long l2 = l - this.lastServerTime;
                        if (l2 < 0L) {
                            this.lastServerTime = l;
                            l2 = 0L;
                        }
                        if (l2 >= 50L) {
                            this.lastServerTime = l;
                            int n = integratedServer.getTickCounter();
                            int n2 = n - this.lastServerTicks;
                            if (n2 < 0) {
                                this.lastServerTicks = n;
                                n2 = 0;
                            }
                            if (n2 < 1 && this.serverWaitTime < 100) {
                                this.serverWaitTime += 2;
                            }
                            if (n2 > 1 && this.serverWaitTime > 0) {
                                --this.serverWaitTime;
                            }
                            this.lastServerTicks = n;
                        }
                    } else {
                        this.lastServerTime = l;
                        this.lastServerTicks = integratedServer.getTickCounter();
                        this.avgServerTickDiff = 1.0f;
                        this.avgServerTimeDiff = 50.0f;
                    }
                } else {
                    if (this.mc.currentScreen instanceof GuiDownloadTerrain) {
                        Config.sleep(20L);
                    }
                    this.lastServerTime = 0L;
                    this.lastServerTicks = 0;
                }
            }
        } else {
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
        }
    }

    private void frameInit() {
        GlErrors.frameStart();
        if (!this.initialized) {
            ReflectorResolver.resolve();
            TextureUtils.registerResourceListener();
            if (Config.getBitsOs() == 64 && Config.getBitsJre() == 32) {
                Config.setNotify64BitJava(true);
            }
            this.initialized = true;
        }
        Config.checkDisplayMode();
        WorldClient worldClient = this.mc.theWorld;
        if (worldClient != null) {
            Object object;
            if (Config.getNewRelease() != null) {
                object = "HD_U".replace("HD_U", "HD Ultra").replace("L", "Light");
                String string = (String)object + " " + Config.getNewRelease();
                ChatComponentText chatComponentText = new ChatComponentText(I18n.format("of.message.newVersion", "\u00a7n" + string + "\u00a7r"));
                chatComponentText.setChatStyle(new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://optifine.net/downloads")));
                this.mc.ingameGUI.getChatGUI().printChatMessage(chatComponentText);
                Config.setNewRelease(null);
            }
            if (Config.isNotify64BitJava()) {
                Config.setNotify64BitJava(false);
                object = new ChatComponentText(I18n.format("of.message.java64Bit", new Object[0]));
                this.mc.ingameGUI.getChatGUI().printChatMessage((IChatComponent)object);
            }
        }
        if (this.mc.currentScreen instanceof GuiMainMenu) {
            this.updateMainMenu((GuiMainMenu)this.mc.currentScreen);
        }
        if (this.updatedWorld != worldClient) {
            RandomEntities.worldChanged(this.updatedWorld, worldClient);
            Config.updateThreadPriorities();
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
            this.updatedWorld = worldClient;
        }
        if (!this.setFxaaShader(Shaders.configAntialiasingLevel)) {
            Shaders.configAntialiasingLevel = 0;
        }
        if (this.mc.currentScreen != null && this.mc.currentScreen.getClass() == GuiChat.class) {
            this.mc.displayGuiScreen(new GuiChatOF((GuiChat)this.mc.currentScreen));
        }
    }

    private void frameFinish() {
        int n;
        if (this.mc.theWorld != null && Config.isShowGlErrors() && TimedEvent.isActive("CheckGlErrorFrameFinish", 10000L) && (n = GlStateManager.glGetError()) != 0 && GlErrors.isEnabled(n)) {
            String string = Config.getGlErrorString(n);
            ChatComponentText chatComponentText = new ChatComponentText(I18n.format("of.message.openglError", n, string));
            this.mc.ingameGUI.getChatGUI().printChatMessage(chatComponentText);
        }
    }

    private void updateMainMenu(GuiMainMenu guiMainMenu) {
        try {
            String string = null;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int n = calendar.get(5);
            int n2 = calendar.get(2) + 1;
            if (n == 8 && n2 == 4) {
                string = "Happy birthday, OptiFine!";
            }
            if (n == 14 && n2 == 8) {
                string = "Happy birthday, sp614x!";
            }
            if (string == null) {
                return;
            }
            Reflector.setFieldValue(guiMainMenu, Reflector.GuiMainMenu_splashText, string);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public boolean setFxaaShader(int n) {
        if (!OpenGlHelper.isFramebufferEnabled()) {
            return false;
        }
        if (this.theShaderGroup != null && this.theShaderGroup != this.fxaaShaders[2] && this.theShaderGroup != this.fxaaShaders[4]) {
            return true;
        }
        if (n != 2 && n != 4) {
            if (this.theShaderGroup == null) {
                return true;
            }
            this.theShaderGroup.deleteShaderGroup();
            this.theShaderGroup = null;
            return true;
        }
        if (this.theShaderGroup != null && this.theShaderGroup == this.fxaaShaders[n]) {
            return true;
        }
        if (this.mc.theWorld == null) {
            return true;
        }
        this.loadShader(new ResourceLocation("shaders/post/fxaa_of_" + n + "x.json"));
        this.fxaaShaders[n] = this.theShaderGroup;
        return this.useShader;
    }

    private void checkLoadVisibleChunks(Entity entity, float f, ICamera iCamera, boolean bl) {
        int n = 201435902;
        if (this.loadVisibleChunks) {
            this.loadVisibleChunks = false;
            this.loadAllVisibleChunks(entity, f, iCamera, bl);
            this.mc.ingameGUI.getChatGUI().deleteChatLine(201435902);
        }
        if (Keyboard.isKeyDown(61) && Keyboard.isKeyDown(38)) {
            if (this.mc.currentScreen != null) {
                return;
            }
            this.loadVisibleChunks = true;
            ChatComponentText chatComponentText = new ChatComponentText(I18n.format("of.message.loadingVisibleChunks", new Object[0]));
            this.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(chatComponentText, 201435902);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void loadAllVisibleChunks(Entity entity, double d, ICamera iCamera, boolean bl) {
        int n = this.mc.gameSettings.ofChunkUpdates;
        boolean bl2 = this.mc.gameSettings.ofLazyChunkLoading;
        try {
            this.mc.gameSettings.ofChunkUpdates = 1000;
            this.mc.gameSettings.ofLazyChunkLoading = false;
            RenderGlobal renderGlobal = Config.getRenderGlobal();
            int n2 = renderGlobal.getCountLoadedChunks();
            long l = System.currentTimeMillis();
            Config.dbg("Loading visible chunks");
            long l2 = System.currentTimeMillis() + 5000L;
            int n3 = 0;
            boolean bl3 = false;
            do {
                bl3 = false;
                for (int i = 0; i < 100; ++i) {
                    renderGlobal.displayListEntitiesDirty = true;
                    renderGlobal.setupTerrain(entity, d, iCamera, this.frameCount++, bl);
                    if (!renderGlobal.hasNoChunkUpdates()) {
                        bl3 = true;
                    }
                    n3 += renderGlobal.getCountChunksToUpdate();
                    while (!renderGlobal.hasNoChunkUpdates()) {
                        renderGlobal.updateChunks(System.nanoTime() + 1000000000L);
                    }
                    n3 -= renderGlobal.getCountChunksToUpdate();
                    if (!bl3) break;
                }
                if (renderGlobal.getCountLoadedChunks() != n2) {
                    bl3 = true;
                    n2 = renderGlobal.getCountLoadedChunks();
                }
                if (System.currentTimeMillis() <= l2) continue;
                Config.log("Chunks loaded: " + n3);
                l2 = System.currentTimeMillis() + 5000L;
            } while (bl3);
            Config.log("Chunks loaded: " + n3);
            Config.log("Finished loading visible chunks");
            RenderChunk.renderChunksUpdated = 0;
        }
        finally {
            this.mc.gameSettings.ofChunkUpdates = n;
            this.mc.gameSettings.ofLazyChunkLoading = bl2;
        }
    }

    private void mimeow$onIsShaderActive(occ52191e479 occ52191e4792) {
        if (this.Roven$saturationShader != null && OpenGlHelper.shadersSupported) {
            occ52191e4792.\u04ea(Boolean.TRUE);
        }
    }

    private void mimeow$onGetShaderGroup(occ52191e479 occ52191e4792) {
        if (this.Roven$saturationShader != null && OpenGlHelper.shadersSupported && this.theShaderGroup == null) {
            occ52191e4792.\u04ea(this.Roven$saturationShader);
        }
    }

    private void mimeow$onUpdateShaderGroupSize(int n, int n2, ocee33618a8d ocee33618a8d2) {
        if (this.Roven$saturationShader != null) {
            this.Roven$saturationShader.createBindFramebuffers(n, n2);
        }
    }

    private void mimeow$onRenderSaturation(float f, long l, ocee33618a8d ocee33618a8d2) {
        if (this.Roven$saturationShader != null) {
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.loadIdentity();
            this.Roven$saturationShader.loadShaderGroup(f);
            GlStateManager.popMatrix();
        }
    }

    @Override
    public ShaderGroup Roven$getSaturationShader() {
        return this.Roven$saturationShader;
    }

    @Override
    public void Roven$setSaturationShader(ShaderGroup shaderGroup) {
        this.Roven$saturationShader = shaderGroup;
    }

    public void mimeow$redirect$injectNoHurtCam(float f, float f2, float f3, float f4) {
        if (oc9755810e45.\u054b != null && oc9755810e45.\u054b.z$3rzb3dil7uydr()) {
            f = (float)((double)(f / 14.0f) * oc9755810e45.\u054b.\u0136.\u04c1());
        }
        GlStateManager.rotate(f, f2, f3, f4);
    }

    public double mimeow$redirect$injectNoCameraClip(Vec3 vec3, Vec3 vec32) {
        return vec3.distanceTo(vec32);
    }

    private float mimeow$redirect$freelookRotationYaw(Entity entity) {
        return entity == this.mc.thePlayer && this.isFreelookActive() ? oc9755810e45.\u0411.\u0219() : entity.rotationYaw;
    }

    private float mimeow$redirect$freelookPrevRotationYaw(Entity entity) {
        return entity == this.mc.thePlayer && this.isFreelookActive() ? oc9755810e45.\u0411.\u0219() : entity.prevRotationYaw;
    }

    private float mimeow$redirect$freelookRotationPitch(Entity entity) {
        return entity == this.mc.thePlayer && this.isFreelookActive() ? oc9755810e45.\u0411.\u03b7() : entity.rotationPitch;
    }

    private float mimeow$redirect$freelookPrevRotationPitch(Entity entity) {
        return entity == this.mc.thePlayer && this.isFreelookActive() ? oc9755810e45.\u0411.\u03b7() : entity.prevRotationPitch;
    }

    private boolean mimeow$redirect$freelookOverrideMouse(Minecraft minecraft) {
        return minecraft.inGameHasFocus;
    }

    private boolean isFreelookActive() {
        return oc9755810e45.\u0411 != null && oc9755810e45.\u0411.\u00d6();
    }

    private void mimeow$beginFreeLook() {
        oc9ee35e7bd8 oc9ee35e7bd82 = oc9755810e45.\u0411;
        EntityPlayerSP entityPlayerSP = this.mc.thePlayer;
        if (oc9ee35e7bd82 == null || !oc9ee35e7bd82.\u00d6() || entityPlayerSP == null) {
            return;
        }
        this.mimeow$freeLookYaw = entityPlayerSP.rotationYaw;
        this.mimeow$freeLookPitch = entityPlayerSP.rotationPitch;
        this.mimeow$freeLookPreviousYaw = entityPlayerSP.prevRotationYaw;
        this.mimeow$freeLookPreviousPitch = entityPlayerSP.prevRotationPitch;
        this.mimeow$restoreFreeLookRotation = true;
        entityPlayerSP.prevRotationYaw = entityPlayerSP.rotationYaw = oc9ee35e7bd82.\u0219();
        entityPlayerSP.prevRotationPitch = entityPlayerSP.rotationPitch = MathHelper.clamp_float(oc9ee35e7bd82.\u03b7(), -90.0f, 90.0f);
        if (this.mc.gameSettings.thirdPersonView == 0) {
            this.mc.gameSettings.thirdPersonView = 1;
        }
        this.thirdPersonDistanceTemp = this.thirdPersonDistance;
    }

    private void mimeow$restoreFreeLook() {
        if (!this.mimeow$restoreFreeLookRotation || this.mc.thePlayer == null) {
            return;
        }
        EntityPlayerSP entityPlayerSP = this.mc.thePlayer;
        entityPlayerSP.rotationYaw = this.mimeow$freeLookYaw;
        entityPlayerSP.rotationPitch = this.mimeow$freeLookPitch;
        entityPlayerSP.prevRotationYaw = this.mimeow$freeLookPreviousYaw;
        entityPlayerSP.prevRotationPitch = this.mimeow$freeLookPreviousPitch;
        this.mimeow$restoreFreeLookRotation = false;
    }

    private boolean mimeow$redirectSetupFog(EntityLivingBase entityLivingBase, Potion potion) {
        return oc9755810e45.\u0205 == null || !oc9755810e45.\u0205.\u013c(potion) ? entityLivingBase.isPotionActive(potion) : false;
    }

    private boolean mimeow$redirectFogColor(EntityLivingBase entityLivingBase, Potion potion) {
        return oc9755810e45.\u0205 == null || !oc9755810e45.\u0205.\u013c(potion) ? entityLivingBase.isPotionActive(potion) : false;
    }

    private boolean mimeow$redirectSetupCameraTransform(EntityPlayerSP entityPlayerSP, Potion potion) {
        return oc9755810e45.\u0205 == null || !oc9755810e45.\u0205.\u03b4(potion) ? entityPlayerSP.isPotionActive(potion) : false;
    }

    private void mimeow$onRenderWorld(float f, long l, ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new ocfce21f66a2());
    }

    private void mimeow$onGetMouseOverHead(float f, ocee33618a8d ocee33618a8d2) {
        Entity entity;
        oc02a3730b27.\u04e6(f);
        ocbb165642ef ocbb165642ef2 = ocbb165642ef.\u02a8();
        if (!ocbb165642ef2.\u0498 && !ocb683e2d821.\u029d() && (entity = Minecraft.getMinecraft().getRenderViewEntity()) != null && ocbb165642ef2.\u0178()) {
            Float f2 = ocbb165642ef2.\u0266();
            Float f3 = ocbb165642ef2.\u022b();
            if (f2 != null && !f2.isNaN() && f3 != null && !f3.isNaN()) {
                ocbb165642ef2.\u0494(entity, f2.floatValue(), f3.floatValue(), true);
                ocbb165642ef2.\u0498 = true;
            }
        }
    }

    private void mimeow$onGetMouseOverBeforeEndSection(float f, ocee33618a8d ocee33618a8d2) {
        if (oc9755810e45.\u03d4 != null && oc9755810e45.\u03d4.\u03c6()) {
            oc9755810e45.\u03d4.\u00df(f);
        } else if (oc9755810e45.\u00ff != null && oc9755810e45.\u00ff.\u0110()) {
            oc9755810e45.\u00ff.\u04b4(f);
        } else if (oc9755810e45.\u0450 != null && oc9755810e45.\u0450.\u01ad()) {
            oc9755810e45.\u0450.D(f);
        } else if (oc9755810e45.\u0496 != null && oc9755810e45.\u0496.\u03e6()) {
            oc9755810e45.\u0496.\u014e(f);
        }
    }

    private void mimeow$onGetMouseOverReturn(float f, ocee33618a8d ocee33618a8d2) {
        oc02a3730b27.\u03f7();
        ocbb165642ef ocbb165642ef2 = ocbb165642ef.\u02a8();
        if (ocbb165642ef2.\u0498) {
            Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
            if (entity != null) {
                ocbb165642ef2.\u011b(entity);
            }
            ocbb165642ef2.\u0498 = false;
        }
    }

    private void mimeow$renderWorldLast(float f, long l, ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new oc746a23b244(this.mc.renderGlobal, f));
    }

    private void mimeow$restoreFirstPersonRenderState() {
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.bindCurrentTexture();
        GL11.glDisable(3553);
        GlStateManager.disableTexture2D();
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.bindCurrentTexture();
        GL11.glEnable(3553);
        GlStateManager.enableTexture2D();
        GL11.glEnable(3008);
        GlStateManager.enableAlpha();
        GL11.glAlphaFunc(516, 0.1f);
        GlStateManager.alphaFunc(516, 0.1f);
        GL11.glEnable(2929);
        GlStateManager.enableDepth();
        GL11.glDepthFunc(515);
        GlStateManager.depthFunc(515);
        GL11.glDepthMask(true);
        GlStateManager.depthMask(true);
        GL11.glEnable(2884);
        GlStateManager.enableCull();
        GL11.glDisable(3042);
        GlStateManager.disableBlend();
        GL11.glDisable(2896);
        GlStateManager.disableLighting();
        GL11.glDisable(2912);
        GlStateManager.disableFog();
        GL11.glDisable(32826);
        GlStateManager.disableRescaleNormal();
        GL11.glColorMask(true, true, true, true);
        GlStateManager.colorMask(true, true, true, true);
        GL11.glShadeModel(7424);
        GlStateManager.shadeModel(7424);
        GL11.glTexEnvi(8960, 8704, 8448);
        GlStateManager.resetColor();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void callSetupCameraTransform(float f, int n) {
        this.setupCameraTransform(f, n);
    }

    @Override
    public void callLoadShader(ResourceLocation resourceLocation) {
        this.loadShader(resourceLocation);
    }

    @Override
    public ResourceLocation[] getShaderResourceLocations() {
        return shaderResourceLocations;
    }

    @Override
    public boolean getUseShader() {
        return this.useShader;
    }

    @Override
    public void setUseShader(boolean bl) {
        this.useShader = bl;
    }

    @Override
    public int getShaderIndex() {
        return this.shaderIndex;
    }

    @Override
    public void setShaderIndex(int n) {
        this.shaderIndex = n;
    }

    @Override
    public void setThirdPersonDistance(float f) {
        this.thirdPersonDistance = f;
    }

    @Override
    public Entity getPointedEntity() {
        return this.pointedEntity;
    }

    @Override
    public void setPointedEntity(Entity entity) {
        this.pointedEntity = entity;
    }

    static {
        shaderResourceLocations = new ResourceLocation[]{new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json"), new ResourceLocation("shaders/post/creeper.json"), new ResourceLocation("shaders/post/spider.json")};
        shaderCount = shaderResourceLocations.length;
    }
}

