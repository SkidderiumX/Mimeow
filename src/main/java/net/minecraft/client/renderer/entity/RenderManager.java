/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRabbit;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.entity.RenderCaveSpider;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.client.renderer.entity.RenderEndermite;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.client.renderer.entity.RenderGuardian;
import net.minecraft.client.renderer.entity.RenderHorse;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderLeashKnot;
import net.minecraft.client.renderer.entity.RenderLightningBolt;
import net.minecraft.client.renderer.entity.RenderMagmaCube;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.client.renderer.entity.RenderMinecartMobSpawner;
import net.minecraft.client.renderer.entity.RenderMooshroom;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.client.renderer.entity.RenderPainting;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.entity.RenderPigZombie;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RenderPotion;
import net.minecraft.client.renderer.entity.RenderRabbit;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.RenderSilverfish;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.client.renderer.entity.RenderSquid;
import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.client.renderer.entity.RenderTntMinecart;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.client.renderer.entity.RenderWither;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.RenderXPOrb;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.RenderEnderCrystal;
import net.minecraft.client.renderer.tileentity.RenderItemFrame;
import net.minecraft.client.renderer.tileentity.RenderWitherSkull;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.optifine.entity.model.CustomEntityModels;
import net.optifine.player.PlayerItemsLayer;
import net.optifine.reflect.Reflector;
import net.optifine.shaders.Shaders;
import x.oc25aa89b91f;
import x.oc75d51ec7eb;
import x.oc9755810e45;
import x.ocb683e2d821;
import x.ocbc80def7d5;
import x.occ52191e479;

public class RenderManager
implements ocbc80def7d5 {
    private Map<Class, Render> entityRenderMap = Maps.newHashMap();
    private Map<String, RenderPlayer> skinMap = Maps.newHashMap();
    private RenderPlayer playerRenderer;
    private FontRenderer textRenderer;
    private double renderPosX;
    private double renderPosY;
    private double renderPosZ;
    public TextureManager renderEngine;
    public World worldObj;
    public Entity livingPlayer;
    public Entity pointedEntity;
    public float playerViewY;
    public float playerViewX;
    public GameSettings options;
    public double viewerPosX;
    public double viewerPosY;
    public double viewerPosZ;
    private boolean renderOutlines = false;
    private boolean renderShadow = true;
    private boolean debugBoundingBox = false;
    private float cachedPrevRotationPitch;
    private float cachedRotationPitch;
    public Render renderRender = null;

    public RenderManager(TextureManager textureManager, RenderItem renderItem) {
        this.renderEngine = textureManager;
        this.entityRenderMap.put(EntityCaveSpider.class, new RenderCaveSpider(this));
        this.entityRenderMap.put(EntitySpider.class, new RenderSpider(this));
        this.entityRenderMap.put(EntityPig.class, new RenderPig(this, new ModelPig(), 0.7f));
        this.entityRenderMap.put(EntitySheep.class, new RenderSheep(this, new ModelSheep2(), 0.7f));
        this.entityRenderMap.put(EntityCow.class, new RenderCow(this, new ModelCow(), 0.7f));
        this.entityRenderMap.put(EntityMooshroom.class, new RenderMooshroom(this, new ModelCow(), 0.7f));
        this.entityRenderMap.put(EntityWolf.class, new RenderWolf(this, new ModelWolf(), 0.5f));
        this.entityRenderMap.put(EntityChicken.class, new RenderChicken(this, new ModelChicken(), 0.3f));
        this.entityRenderMap.put(EntityOcelot.class, new RenderOcelot(this, new ModelOcelot(), 0.4f));
        this.entityRenderMap.put(EntityRabbit.class, new RenderRabbit(this, new ModelRabbit(), 0.3f));
        this.entityRenderMap.put(EntitySilverfish.class, new RenderSilverfish(this));
        this.entityRenderMap.put(EntityEndermite.class, new RenderEndermite(this));
        this.entityRenderMap.put(EntityCreeper.class, new RenderCreeper(this));
        this.entityRenderMap.put(EntityEnderman.class, new RenderEnderman(this));
        this.entityRenderMap.put(EntitySnowman.class, new RenderSnowMan(this));
        this.entityRenderMap.put(EntitySkeleton.class, new RenderSkeleton(this));
        this.entityRenderMap.put(EntityWitch.class, new RenderWitch(this));
        this.entityRenderMap.put(EntityBlaze.class, new RenderBlaze(this));
        this.entityRenderMap.put(EntityPigZombie.class, new RenderPigZombie(this));
        this.entityRenderMap.put(EntityZombie.class, new RenderZombie(this));
        this.entityRenderMap.put(EntitySlime.class, new RenderSlime(this, new ModelSlime(16), 0.25f));
        this.entityRenderMap.put(EntityMagmaCube.class, new RenderMagmaCube(this));
        this.entityRenderMap.put(EntityGiantZombie.class, new RenderGiantZombie(this, new ModelZombie(), 0.5f, 6.0f));
        this.entityRenderMap.put(EntityGhast.class, new RenderGhast(this));
        this.entityRenderMap.put(EntitySquid.class, new RenderSquid(this, new ModelSquid(), 0.7f));
        this.entityRenderMap.put(EntityVillager.class, new RenderVillager(this));
        this.entityRenderMap.put(EntityIronGolem.class, new RenderIronGolem(this));
        this.entityRenderMap.put(EntityBat.class, new RenderBat(this));
        this.entityRenderMap.put(EntityGuardian.class, new RenderGuardian(this));
        this.entityRenderMap.put(EntityDragon.class, new RenderDragon(this));
        this.entityRenderMap.put(EntityEnderCrystal.class, new RenderEnderCrystal(this));
        this.entityRenderMap.put(EntityWither.class, new RenderWither(this));
        this.entityRenderMap.put(Entity.class, new RenderEntity(this));
        this.entityRenderMap.put(EntityPainting.class, new RenderPainting(this));
        this.entityRenderMap.put(EntityItemFrame.class, new RenderItemFrame(this, renderItem));
        this.entityRenderMap.put(EntityLeashKnot.class, new RenderLeashKnot(this));
        this.entityRenderMap.put(EntityArrow.class, new RenderArrow(this));
        this.entityRenderMap.put(EntitySnowball.class, new RenderSnowball(this, Items.snowball, renderItem));
        this.entityRenderMap.put(EntityEnderPearl.class, new RenderSnowball(this, Items.ender_pearl, renderItem));
        this.entityRenderMap.put(EntityEnderEye.class, new RenderSnowball(this, Items.ender_eye, renderItem));
        this.entityRenderMap.put(EntityEgg.class, new RenderSnowball(this, Items.egg, renderItem));
        this.entityRenderMap.put(EntityPotion.class, new RenderPotion(this, renderItem));
        this.entityRenderMap.put(EntityExpBottle.class, new RenderSnowball(this, Items.experience_bottle, renderItem));
        this.entityRenderMap.put(EntityFireworkRocket.class, new RenderSnowball(this, Items.fireworks, renderItem));
        this.entityRenderMap.put(EntityLargeFireball.class, new RenderFireball(this, 2.0f));
        this.entityRenderMap.put(EntitySmallFireball.class, new RenderFireball(this, 0.5f));
        this.entityRenderMap.put(EntityWitherSkull.class, new RenderWitherSkull(this));
        this.entityRenderMap.put(EntityItem.class, new RenderEntityItem(this, renderItem));
        this.entityRenderMap.put(EntityXPOrb.class, new RenderXPOrb(this));
        this.entityRenderMap.put(EntityTNTPrimed.class, new RenderTNTPrimed(this));
        this.entityRenderMap.put(EntityFallingBlock.class, new RenderFallingBlock(this));
        this.entityRenderMap.put(EntityArmorStand.class, new ArmorStandRenderer(this));
        this.entityRenderMap.put(EntityMinecartTNT.class, new RenderTntMinecart(this));
        this.entityRenderMap.put(EntityMinecartMobSpawner.class, new RenderMinecartMobSpawner(this));
        this.entityRenderMap.put(EntityMinecart.class, new RenderMinecart(this));
        this.entityRenderMap.put(EntityBoat.class, new RenderBoat(this));
        this.entityRenderMap.put(EntityFishHook.class, new RenderFish(this));
        this.entityRenderMap.put(EntityHorse.class, new RenderHorse(this, new ModelHorse(), 0.75f));
        this.entityRenderMap.put(EntityLightningBolt.class, new RenderLightningBolt(this));
        this.playerRenderer = new RenderPlayer(this);
        this.skinMap.put("default", this.playerRenderer);
        this.skinMap.put("slim", new RenderPlayer(this, true));
        PlayerItemsLayer.register(this.skinMap);
        if (Reflector.RenderingRegistry_loadEntityRenderers.exists()) {
            Reflector.call(Reflector.RenderingRegistry_loadEntityRenderers, this, this.entityRenderMap);
        }
    }

    public void setRenderPosition(double d, double d2, double d3) {
        this.renderPosX = d;
        this.renderPosY = d2;
        this.renderPosZ = d3;
    }

    public <T extends Entity> Render<T> getEntityClassRenderObject(Class<? extends Entity> clazz) {
        Render<T> render2 = this.entityRenderMap.get(clazz);
        if (render2 == null && clazz != Entity.class) {
            render2 = this.getEntityClassRenderObject(clazz.getSuperclass());
            this.entityRenderMap.put(clazz, render2);
        }
        return render2;
    }

    public <T extends Entity> Render<T> getEntityRenderObject(Entity entity) {
        if (entity instanceof AbstractClientPlayer) {
            String string = ((AbstractClientPlayer)entity).getSkinType();
            RenderPlayer renderPlayer = this.skinMap.get(string);
            return renderPlayer != null ? renderPlayer : this.playerRenderer;
        }
        return this.getEntityClassRenderObject(entity.getClass());
    }

    public void cacheActiveRenderInfo(World world2, FontRenderer fontRenderer, Entity entity, Entity entity2, GameSettings gameSettings, float f) {
        this.worldObj = world2;
        this.options = gameSettings;
        this.livingPlayer = entity;
        this.pointedEntity = entity2;
        this.textRenderer = fontRenderer;
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPlayerSleeping()) {
            IBlockState iBlockState = world2.getBlockState(new BlockPos(entity));
            Block block = iBlockState.getBlock();
            if (Reflector.callBoolean(block, Reflector.CompatBlock_isBed, iBlockState, world2, new BlockPos(entity), (EntityLivingBase)entity)) {
                EnumFacing enumFacing = (EnumFacing)Reflector.call(block, Reflector.CompatBlock_getBedDirection, iBlockState, world2, new BlockPos(entity));
                int n = enumFacing.getHorizontalIndex();
                this.mimeow$redirect$freelookRedirectPlayerViewY(this, n * 90 + 180);
                this.mimeow$redirect$freelookRedirectPlayerViewX(this, 0.0f);
            } else if (block == Blocks.bed) {
                int n = iBlockState.getValue(BlockBed.FACING).getHorizontalIndex();
                this.mimeow$redirect$freelookRedirectPlayerViewY(this, n * 90 + 180);
                this.mimeow$redirect$freelookRedirectPlayerViewX(this, 0.0f);
            }
        } else {
            this.mimeow$redirect$freelookRedirectPlayerViewY(this, entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f);
            this.mimeow$redirect$freelookRedirectPlayerViewX(this, entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f);
        }
        if (gameSettings.thirdPersonView == 2) {
            this.mimeow$redirect$freelookRedirectPlayerViewY(this, this.playerViewY + 180.0f);
        }
        this.viewerPosX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        this.viewerPosY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        this.viewerPosZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
    }

    public void setPlayerViewY(float f) {
        this.playerViewY = f;
    }

    public boolean isRenderShadow() {
        return this.renderShadow;
    }

    public void setRenderShadow(boolean bl) {
        this.renderShadow = bl;
    }

    public void setDebugBoundingBox(boolean bl) {
        this.debugBoundingBox = bl;
    }

    public boolean isDebugBoundingBox() {
        return this.debugBoundingBox;
    }

    public boolean renderEntitySimple(Entity entity, float f) {
        return this.renderEntityStatic(entity, f, false);
    }

    public boolean shouldRender(Entity entity, ICamera iCamera, double d, double d2, double d3) {
        Render<Entity> render2 = this.getEntityRenderObject(entity);
        return render2 != null && render2.shouldRender(entity, iCamera, d, d2, d3);
    }

    public boolean renderEntityStatic(Entity entity, float f, boolean bl) {
        this.mimeow$renderEntityStaticPre(entity, f, bl, new occ52191e479("renderEntityStatic", false));
        if (entity.ticksExisted == 0) {
            entity.lastTickPosX = entity.posX;
            entity.lastTickPosY = entity.posY;
            entity.lastTickPosZ = entity.posZ;
        }
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        float f2 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f;
        int n = entity.getBrightnessForRender(f);
        if (entity.isBurning()) {
            n = 0xF000F0;
        }
        int n2 = n % 65536;
        int n3 = n / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)n2 / 1.0f, (float)n3 / 1.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl2 = this.doRenderEntity(entity, d - this.renderPosX, d2 - this.renderPosY, d3 - this.renderPosZ, f2, f, bl);
        this.mimeow$renderEntityStaticPost(entity, f, bl, new occ52191e479("renderEntityStatic", false, bl2));
        return bl2;
    }

    public void renderWitherSkull(Entity entity, float f) {
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        Render<Entity> render2 = this.getEntityRenderObject(entity);
        if (render2 != null && this.renderEngine != null) {
            int n = entity.getBrightnessForRender(f);
            int n2 = n % 65536;
            int n3 = n / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)n2 / 1.0f, (float)n3 / 1.0f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            render2.renderName(entity, d - this.renderPosX, d2 - this.renderPosY, d3 - this.renderPosZ);
        }
    }

    public boolean renderEntityWithPosYaw(Entity entity, double d, double d2, double d3, float f, float f2) {
        return this.doRenderEntity(entity, d, d2, d3, f, f2, false);
    }

    public boolean doRenderEntity(Entity entity, double d, double d2, double d3, float f, float f2, boolean bl) {
        Render<Entity> render2 = null;
        try {
            render2 = this.getEntityRenderObject(entity);
            if (render2 != null && this.renderEngine != null) {
                try {
                    if (render2 instanceof RendererLivingEntity) {
                        ((RendererLivingEntity)render2).setRenderOutlines(this.renderOutlines);
                    }
                    if (CustomEntityModels.isActive()) {
                        this.renderRender = render2;
                    }
                    render2.doRender(entity, d, d2, d3, f, f2);
                }
                catch (Throwable throwable) {
                    throw new ReportedException(CrashReport.makeCrashReport(throwable, "Rendering entity in world"));
                }
                try {
                    if (!this.renderOutlines) {
                        render2.doRenderShadowAndFire(entity, d, d2, d3, f, f2);
                    }
                }
                catch (Throwable throwable) {
                    throw new ReportedException(CrashReport.makeCrashReport(throwable, "Post-rendering entity in world"));
                }
                if (this.debugBoundingBox && !entity.isInvisible() && !bl) {
                    try {
                        this.renderDebugBoundingBox(entity, d, d2, d3, f, f2);
                    }
                    catch (Throwable throwable) {
                        throw new ReportedException(CrashReport.makeCrashReport(throwable, "Rendering entity hitbox in world"));
                    }
                }
            } else if (this.renderEngine != null) {
                return false;
            }
            return true;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Rendering entity in world");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being rendered");
            entity.addEntityCrashInfo(crashReportCategory);
            CrashReportCategory crashReportCategory2 = crashReport.makeCategory("Renderer details");
            crashReportCategory2.addCrashSection("Assigned renderer", render2);
            crashReportCategory2.addCrashSection("Location", CrashReportCategory.getCoordinateInfo(d, d2, d3));
            crashReportCategory2.addCrashSection("Rotation", Float.valueOf(f));
            crashReportCategory2.addCrashSection("Delta", Float.valueOf(f2));
            throw new ReportedException(crashReport);
        }
    }

    private void renderDebugBoundingBox(Entity entity, double d, double d2, double d3, float f, float f2) {
        if (!Shaders.isShadowPass) {
            GlStateManager.depthMask(false);
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            float f3 = entity.width / 2.0f;
            AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
            AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - entity.posX + d, axisAlignedBB.minY - entity.posY + d2, axisAlignedBB.minZ - entity.posZ + d3, axisAlignedBB.maxX - entity.posX + d, axisAlignedBB.maxY - entity.posY + d2, axisAlignedBB.maxZ - entity.posZ + d3);
            RenderGlobal.drawOutlinedBoundingBox(axisAlignedBB2, 255, 255, 255, 255);
            if (entity instanceof EntityLivingBase) {
                float f4 = 0.01f;
                RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(d - (double)f3, d2 + (double)entity.getEyeHeight() - (double)0.01f, d3 - (double)f3, d + (double)f3, d2 + (double)entity.getEyeHeight() + (double)0.01f, d3 + (double)f3), 255, 0, 0, 255);
            }
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            Vec3 vec3 = entity.getLook(f2);
            worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);
            worldRenderer.pos(d, d2 + (double)entity.getEyeHeight(), d3).color(0, 0, 255, 255).endVertex();
            worldRenderer.pos(d + vec3.xCoord * 2.0, d2 + (double)entity.getEyeHeight() + vec3.yCoord * 2.0, d3 + vec3.zCoord * 2.0).color(0, 0, 255, 255).endVertex();
            tessellator.draw();
            GlStateManager.enableTexture2D();
            GlStateManager.enableLighting();
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
        }
    }

    public void set(World world2) {
        this.worldObj = world2;
    }

    public double getDistanceToCamera(double d, double d2, double d3) {
        double d4 = d - this.viewerPosX;
        double d5 = d2 - this.viewerPosY;
        double d6 = d3 - this.viewerPosZ;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public FontRenderer getFontRenderer() {
        return this.textRenderer;
    }

    public void setRenderOutlines(boolean bl) {
        this.renderOutlines = bl;
    }

    public Map<Class, Render> getEntityRenderMap() {
        return this.entityRenderMap;
    }

    public void setEntityRenderMap(Map map) {
        this.entityRenderMap = map;
    }

    public Map<String, RenderPlayer> getSkinMap() {
        return Collections.unmodifiableMap(this.skinMap);
    }

    public void mimeow$renderEntityStaticPre(Entity entity, float f, boolean bl, occ52191e479 occ52191e4792) {
        if (entity instanceof EntityPlayerSP && oc25aa89b91f.\u0171()) {
            EntityPlayerSP entityPlayerSP = (EntityPlayerSP)entity;
            this.cachedRotationPitch = entityPlayerSP.rotationPitch;
            this.cachedPrevRotationPitch = entityPlayerSP.prevRotationPitch;
            entityPlayerSP.prevRotationPitch = oc75d51ec7eb.\u0173;
            entityPlayerSP.rotationPitch = oc75d51ec7eb.\u021b;
        }
    }

    public void mimeow$renderEntityStaticPost(Entity entity, float f, boolean bl, occ52191e479 occ52191e4792) {
        if (entity instanceof EntityPlayerSP && oc25aa89b91f.\u0171()) {
            EntityPlayerSP entityPlayerSP = (EntityPlayerSP)entity;
            entityPlayerSP.prevRotationPitch = this.cachedPrevRotationPitch;
            entityPlayerSP.rotationPitch = this.cachedRotationPitch;
        }
    }

    private void mimeow$redirect$freelookRedirectPlayerViewX(RenderManager renderManager, float f) {
        this.playerViewX = this.isFreelookActive() ? oc9755810e45.\u0411.\u03b7() : ocb683e2d821.\u0100(f);
    }

    private void mimeow$redirect$freelookRedirectPlayerViewY(RenderManager renderManager, float f) {
        this.playerViewY = this.isFreelookActive() ? oc9755810e45.\u0411.\u0219() : ocb683e2d821.\u020d(f);
    }

    private boolean isFreelookActive() {
        return this.livingPlayer == Minecraft.getMinecraft().thePlayer && oc9755810e45.\u0411 != null && oc9755810e45.\u0411.\u00d6();
    }

    @Override
    public double getRenderPosX() {
        return this.renderPosX;
    }

    @Override
    public double getRenderPosY() {
        return this.renderPosY;
    }

    @Override
    public double getRenderPosZ() {
        return this.renderPosZ;
    }
}

