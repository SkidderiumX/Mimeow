/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.tileentity;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityBannerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityBeaconRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnchantmentTableRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEndPortalRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnderChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityMobSpawnerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityPistonRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ReportedException;
import net.minecraft.world.World;
import net.optifine.EmissiveTextures;
import net.optifine.reflect.Reflector;

public class TileEntityRendererDispatcher {
    public Map<Class, TileEntitySpecialRenderer> mapSpecialRenderers = Maps.newHashMap();
    public static TileEntityRendererDispatcher instance = new TileEntityRendererDispatcher();
    public FontRenderer fontRenderer;
    public static double staticPlayerX;
    public static double staticPlayerY;
    public static double staticPlayerZ;
    public TextureManager renderEngine;
    public World worldObj;
    public Entity entity;
    public float entityYaw;
    public float entityPitch;
    public double entityX;
    public double entityY;
    public double entityZ;
    public TileEntity tileEntityRendered;
    private Tessellator batchBuffer = new Tessellator(0x200000);
    private boolean drawingBatch = false;

    private TileEntityRendererDispatcher() {
        this.mapSpecialRenderers.put(TileEntitySign.class, new TileEntitySignRenderer());
        this.mapSpecialRenderers.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        this.mapSpecialRenderers.put(TileEntityPiston.class, new TileEntityPistonRenderer());
        this.mapSpecialRenderers.put(TileEntityChest.class, new TileEntityChestRenderer());
        this.mapSpecialRenderers.put(TileEntityEnderChest.class, new TileEntityEnderChestRenderer());
        this.mapSpecialRenderers.put(TileEntityEnchantmentTable.class, new TileEntityEnchantmentTableRenderer());
        this.mapSpecialRenderers.put(TileEntityEndPortal.class, new TileEntityEndPortalRenderer());
        this.mapSpecialRenderers.put(TileEntityBeacon.class, new TileEntityBeaconRenderer());
        this.mapSpecialRenderers.put(TileEntitySkull.class, new TileEntitySkullRenderer());
        this.mapSpecialRenderers.put(TileEntityBanner.class, new TileEntityBannerRenderer());
        for (TileEntitySpecialRenderer tileEntitySpecialRenderer : this.mapSpecialRenderers.values()) {
            tileEntitySpecialRenderer.setRendererDispatcher(this);
        }
    }

    public <T extends TileEntity> TileEntitySpecialRenderer<T> getSpecialRendererByClass(Class<? extends TileEntity> clazz) {
        TileEntitySpecialRenderer<T> tileEntitySpecialRenderer = this.mapSpecialRenderers.get(clazz);
        if (tileEntitySpecialRenderer == null && clazz != TileEntity.class) {
            tileEntitySpecialRenderer = this.getSpecialRendererByClass(clazz.getSuperclass());
            this.mapSpecialRenderers.put(clazz, tileEntitySpecialRenderer);
        }
        return tileEntitySpecialRenderer;
    }

    public <T extends TileEntity> TileEntitySpecialRenderer<T> getSpecialRenderer(TileEntity tileEntity) {
        return tileEntity != null && !tileEntity.isInvalid() ? this.getSpecialRendererByClass(tileEntity.getClass()) : null;
    }

    public void cacheActiveRenderInfo(World world2, TextureManager textureManager, FontRenderer fontRenderer, Entity entity, float f) {
        if (this.worldObj != world2) {
            this.setWorld(world2);
        }
        this.renderEngine = textureManager;
        this.entity = entity;
        this.fontRenderer = fontRenderer;
        this.entityYaw = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f;
        this.entityPitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f;
        this.entityX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        this.entityY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        this.entityZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
    }

    public void renderTileEntity(TileEntity tileEntity, float f, int n) {
        if (tileEntity.getDistanceSq(this.entityX, this.entityY, this.entityZ) < tileEntity.getMaxRenderDistanceSquared()) {
            BlockPos blockPos;
            boolean bl = true;
            if (Reflector.CompatTileEntity_hasFastRenderer.exists()) {
                boolean bl2 = bl = !this.drawingBatch || !Reflector.callBoolean(tileEntity, Reflector.CompatTileEntity_hasFastRenderer, new Object[0]);
            }
            if (bl) {
                RenderHelper.enableStandardItemLighting();
                int n2 = this.worldObj.getCombinedLight(tileEntity.getPos(), 0);
                int n3 = n2 % 65536;
                int n4 = n2 / 65536;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)n3 / 1.0f, (float)n4 / 1.0f);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            }
            if (!this.worldObj.isBlockLoaded(blockPos = tileEntity.getPos(), false)) {
                return;
            }
            if (EmissiveTextures.isActive()) {
                EmissiveTextures.beginRender();
            }
            this.renderTileEntityAt(tileEntity, (double)blockPos.getX() - staticPlayerX, (double)blockPos.getY() - staticPlayerY, (double)blockPos.getZ() - staticPlayerZ, f, n);
            if (EmissiveTextures.isActive()) {
                if (EmissiveTextures.hasEmissive()) {
                    EmissiveTextures.beginRenderEmissive();
                    this.renderTileEntityAt(tileEntity, (double)blockPos.getX() - staticPlayerX, (double)blockPos.getY() - staticPlayerY, (double)blockPos.getZ() - staticPlayerZ, f, n);
                    EmissiveTextures.endRenderEmissive();
                }
                EmissiveTextures.endRender();
            }
        }
    }

    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this.renderTileEntityAt(tileEntity, d, d2, d3, f, -1);
    }

    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f, int n) {
        TileEntitySpecialRenderer<TileEntity> tileEntitySpecialRenderer = this.getSpecialRenderer(tileEntity);
        if (tileEntitySpecialRenderer != null) {
            try {
                this.tileEntityRendered = tileEntity;
                if (this.drawingBatch && Reflector.callBoolean(tileEntity, Reflector.CompatTileEntity_hasFastRenderer, new Object[0])) {
                    tileEntitySpecialRenderer.renderTileEntityFast(tileEntity, d, d2, d3, f, n, this.batchBuffer.getWorldRenderer());
                } else {
                    tileEntitySpecialRenderer.renderTileEntityAt(tileEntity, d, d2, d3, f, n);
                }
                this.tileEntityRendered = null;
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Rendering Block Entity");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Block Entity Details");
                tileEntity.addInfoToCrashReport(crashReportCategory);
                throw new ReportedException(crashReport);
            }
        }
    }

    public void setWorld(World world2) {
        this.worldObj = world2;
    }

    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }

    public void preDrawBatch() {
        this.batchBuffer.getWorldRenderer().begin(7, DefaultVertexFormats.BLOCK);
        this.drawingBatch = true;
    }

    public void drawBatch(int n) {
        this.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.enableBlend();
        GlStateManager.disableCull();
        if (Minecraft.isAmbientOcclusionEnabled()) {
            GlStateManager.shadeModel(7425);
        } else {
            GlStateManager.shadeModel(7424);
        }
        if (n > 0) {
            this.batchBuffer.getWorldRenderer().sortVertexData((float)staticPlayerX, (float)staticPlayerY, (float)staticPlayerZ);
        }
        this.batchBuffer.draw();
        RenderHelper.enableStandardItemLighting();
        this.drawingBatch = false;
    }
}

