/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.nio.FloatBuffer;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.src.Config;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.optifine.EmissiveTextures;
import net.optifine.entity.model.CustomEntityModels;
import net.optifine.reflect.Reflector;
import net.optifine.shaders.Shaders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import x.oc45aa3f2e74;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.oc9ca1ce49ff;
import x.oc9e2e8d26de;
import x.oca305a6dc47;
import x.oca4f99d2d44;
import x.occ52191e479;
import x.occc57954425;
import x.ocd1b2d918dd;
import x.ocd4576614ae;
import x.ocea775c9d5c;
import x.oced29a282d7;
import x.ocee33618a8d;
import x.ocf2fc2a5453;

public abstract class RendererLivingEntity<T extends EntityLivingBase>
extends Render<T> {
    private static final Logger logger = LogManager.getLogger();
    private static final DynamicTexture textureBrightness = new DynamicTexture(16, 16);
    public ModelBase mainModel;
    protected FloatBuffer brightnessBuffer = GLAllocation.createDirectFloatBuffer(4);
    protected List<LayerRenderer<T>> layerRenderers = Lists.newArrayList();
    protected boolean renderOutlines = false;
    public static float NAME_TAG_RANGE = 64.0f;
    public static float NAME_TAG_RANGE_SNEAK = 32.0f;
    public EntityLivingBase renderEntity;
    public float renderLimbSwing;
    public float renderLimbSwingAmount;
    public float renderAgeInTicks;
    public float renderHeadYaw;
    public float renderHeadPitch;
    public float renderScaleFactor;
    public float renderPartialTicks;
    private boolean renderModelPushMatrix;
    private boolean renderLayersPushMatrix;
    public static final boolean animateModelLiving = Boolean.getBoolean("animate.model.living");
    private EntityLivingBase nameHider$renderNameEntity;

    public RendererLivingEntity(RenderManager renderManager, ModelBase modelBase, float f) {
        super(renderManager);
        this.mainModel = modelBase;
        this.shadowSize = f;
        this.renderModelPushMatrix = this.mainModel instanceof ModelSpider;
    }

    public <V extends EntityLivingBase, U extends LayerRenderer<V>> boolean addLayer(U u) {
        return this.layerRenderers.add(u);
    }

    protected <V extends EntityLivingBase, U extends LayerRenderer<V>> boolean removeLayer(U u) {
        return this.layerRenderers.remove(u);
    }

    public ModelBase getMainModel() {
        return this.mainModel;
    }

    protected float interpolateRotation(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    public void transformHeldFull3DItemLayer() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void doRender(T t, double d, double d2, double d3, float f, float f2) {
        if (occc57954425.\u0205(t)) {
            if (this.canRenderName(t)) {
                this.renderName(t, d, d2, d3);
            }
            return;
        }
        this.mimeow$mobEsp$chamsPre((EntityLivingBase)t, d, d2, d3, f, f2, new ocee33618a8d("doRender", false));
        boolean bl = false;
        try {
            ocee33618a8d ocee33618a8d2 = new ocee33618a8d("doRender", true);
            this.mimeow$renderPre((EntityLivingBase)t, d, d2, d3, f, f2, ocee33618a8d2);
            if (ocee33618a8d2.z$24lpjeeur71n9()) {
                return;
            }
            if (!Reflector.RenderLivingEvent_Pre_Constructor.exists() || !Reflector.postCompatBusEvent(Reflector.RenderLivingEvent_Pre_Constructor, t, this, d, d2, d3)) {
                if (animateModelLiving) {
                    ((EntityLivingBase)t).limbSwingAmount = 1.0f;
                }
                GlStateManager.pushMatrix();
                GlStateManager.disableCull();
                this.mainModel.swingProgress = this.getSwingProgress(t, f2);
                this.mainModel.isRiding = ((Entity)t).isRiding();
                if (Reflector.CompatEntity_shouldRiderSit.exists()) {
                    this.mainModel.isRiding = ((Entity)t).isRiding() && ((EntityLivingBase)t).ridingEntity != null && Reflector.callBoolean(((EntityLivingBase)t).ridingEntity, Reflector.CompatEntity_shouldRiderSit, new Object[0]);
                }
                this.mainModel.isChild = ((EntityLivingBase)t).isChild();
                try {
                    float f3;
                    float f4 = this.interpolateRotation(((EntityLivingBase)t).prevRenderYawOffset, ((EntityLivingBase)t).renderYawOffset, f2);
                    float f5 = this.interpolateRotation(((EntityLivingBase)t).prevRotationYawHead, ((EntityLivingBase)t).rotationYawHead, f2);
                    float f6 = f5 - f4;
                    if (this.mainModel.isRiding && ((EntityLivingBase)t).ridingEntity instanceof EntityLivingBase) {
                        EntityLivingBase entityLivingBase = (EntityLivingBase)((EntityLivingBase)t).ridingEntity;
                        f4 = this.interpolateRotation(entityLivingBase.prevRenderYawOffset, entityLivingBase.renderYawOffset, f2);
                        f6 = f5 - f4;
                        f3 = MathHelper.wrapAngleTo180_float(f6);
                        if (f3 < -85.0f) {
                            f3 = -85.0f;
                        }
                        if (f3 >= 85.0f) {
                            f3 = 85.0f;
                        }
                        f4 = f5 - f3;
                        if (f3 * f3 > 2500.0f) {
                            f4 += f3 * 0.2f;
                        }
                        f6 = f5 - f4;
                    }
                    float f7 = ((EntityLivingBase)t).prevRotationPitch + (((EntityLivingBase)t).rotationPitch - ((EntityLivingBase)t).prevRotationPitch) * f2;
                    this.renderLivingAt(t, d, d2, d3);
                    f3 = this.handleRotationFloat(t, f2);
                    this.rotateCorpse(t, f3, f4, f2);
                    GlStateManager.enableRescaleNormal();
                    GlStateManager.scale(-1.0f, -1.0f, 1.0f);
                    this.preRenderCallback(t, f2);
                    float f8 = 0.0625f;
                    GlStateManager.translate(0.0f, -1.5078125f, 0.0f);
                    float f9 = ((EntityLivingBase)t).prevLimbSwingAmount + (((EntityLivingBase)t).limbSwingAmount - ((EntityLivingBase)t).prevLimbSwingAmount) * f2;
                    float f10 = ((EntityLivingBase)t).limbSwing - ((EntityLivingBase)t).limbSwingAmount * (1.0f - f2);
                    if (((EntityLivingBase)t).isChild()) {
                        f10 *= 3.0f;
                    }
                    if (f9 > 1.0f) {
                        f9 = 1.0f;
                    }
                    GlStateManager.enableAlpha();
                    this.mainModel.setLivingAnimations((EntityLivingBase)t, f10, f9, f2);
                    this.mainModel.setRotationAngles(f10, f9, f3, f6, f7, 0.0625f, (Entity)t);
                    if (CustomEntityModels.isActive()) {
                        this.renderEntity = t;
                        this.renderLimbSwing = f10;
                        this.renderLimbSwingAmount = f9;
                        this.renderAgeInTicks = f3;
                        this.renderHeadYaw = f6;
                        this.renderHeadPitch = f7;
                        this.renderScaleFactor = f8;
                        this.renderPartialTicks = f2;
                    }
                    if (this.renderOutlines) {
                        boolean bl2 = this.mimeow$redirect$setOutlineColor(this, (EntityLivingBase)t);
                        this.renderModel(t, f10, f9, f3, f6, f7, 0.0625f);
                        if (bl2) {
                            this.unsetScoreTeamColor();
                        }
                    } else {
                        boolean bl3 = this.setDoRenderBrightness(t, f2);
                        if (EmissiveTextures.isActive()) {
                            EmissiveTextures.beginRender();
                        }
                        if (this.renderModelPushMatrix) {
                            GlStateManager.pushMatrix();
                        }
                        this.renderModel(t, f10, f9, f3, f6, f7, 0.0625f);
                        if (this.renderModelPushMatrix) {
                            GlStateManager.popMatrix();
                        }
                        if (EmissiveTextures.isActive()) {
                            if (EmissiveTextures.hasEmissive()) {
                                this.renderModelPushMatrix = true;
                                EmissiveTextures.beginRenderEmissive();
                                GlStateManager.pushMatrix();
                                this.renderModel(t, f10, f9, f3, f6, f7, f8);
                                GlStateManager.popMatrix();
                                EmissiveTextures.endRenderEmissive();
                            }
                            EmissiveTextures.endRender();
                        }
                        if (bl3) {
                            this.unsetBrightness();
                        }
                        GlStateManager.depthMask(true);
                        if (!(t instanceof EntityPlayer) || !((EntityPlayer)t).isSpectator()) {
                            this.renderLayers(t, f10, f9, f2, f3, f6, f7, 0.0625f);
                        }
                    }
                    if (CustomEntityModels.isActive()) {
                        this.renderEntity = null;
                    }
                    GlStateManager.disableRescaleNormal();
                }
                catch (Exception exception) {
                    logger.error("Couldn't render entity", (Throwable)exception);
                }
                GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
                GlStateManager.enableTexture2D();
                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
                GlStateManager.enableCull();
                GlStateManager.popMatrix();
                if (!this.renderOutlines) {
                    super.doRender(t, d, d2, d3, f, f2);
                }
                if (Reflector.RenderLivingEvent_Post_Constructor.exists()) {
                    Reflector.postCompatBusEvent(Reflector.RenderLivingEvent_Post_Constructor, t, this, d, d2, d3);
                }
            }
            bl = true;
        }
        finally {
            this.mimeow$mobEsp$chamsPost((EntityLivingBase)t, d, d2, d3, f, f2, new ocee33618a8d("doRender", false));
        }
        if (bl) {
            this.mimeow$renderPost((EntityLivingBase)t, d, d2, d3, f, f2, new ocee33618a8d("doRender", false));
        }
    }

    protected boolean setScoreTeamColor(T t) {
        String string;
        ScorePlayerTeam scorePlayerTeam;
        int n = 0xFFFFFF;
        if (t instanceof EntityPlayer && (scorePlayerTeam = (ScorePlayerTeam)((EntityLivingBase)t).getTeam()) != null && (string = FontRenderer.getFormatFromString(scorePlayerTeam.getColorPrefix())).length() >= 2) {
            n = this.getFontRendererFromRenderManager().getColorCode(string.charAt(1));
        }
        float f = (float)(n >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n & 0xFF) / 255.0f;
        GlStateManager.disableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.color(f, f2, f3, 1.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }

    protected void unsetScoreTeamColor() {
        GlStateManager.enableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    protected void renderModel(T t, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl;
        boolean bl2 = this.mimeow$modify$modifyInvisibleFlag(!((Entity)t).isInvisible());
        boolean bl3 = bl = !bl2 && !((Entity)t).isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer);
        if (bl2 || bl) {
            if (!this.bindEntityTexture(t)) {
                return;
            }
            if (bl) {
                GlStateManager.pushMatrix();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 0.15f);
                GlStateManager.depthMask(false);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);
                GlStateManager.alphaFunc(516, 0.003921569f);
            }
            this.mainModel.render((Entity)t, f, f2, f3, f4, f5, f6);
            if (bl) {
                GlStateManager.disableBlend();
                GlStateManager.alphaFunc(516, 0.1f);
                GlStateManager.popMatrix();
                GlStateManager.depthMask(true);
            }
        }
    }

    protected boolean setDoRenderBrightness(T t, float f) {
        return this.setBrightness(t, f, true);
    }

    protected boolean setBrightness(T t, float f, boolean bl) {
        boolean bl2;
        float f2 = ((Entity)t).getBrightness(f);
        int n = this.getColorMultiplier(t, f2, f);
        boolean bl3 = (n >> 24 & 0xFF) > 0;
        boolean bl4 = bl2 = ((EntityLivingBase)t).hurtTime > 0 || ((EntityLivingBase)t).deathTime > 0;
        if (!bl3 && !bl2) {
            return false;
        }
        if (!bl3 && !bl) {
            return false;
        }
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, OpenGlHelper.GL_INTERPOLATE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_CONSTANT);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE2_RGB, OpenGlHelper.GL_CONSTANT);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND2_RGB, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        this.brightnessBuffer.position(0);
        if (bl2) {
            this.brightnessBuffer.put(1.0f);
            this.brightnessBuffer.put(0.0f);
            this.brightnessBuffer.put(0.0f);
            this.brightnessBuffer.put(0.3f);
            if (Config.isShaders()) {
                Shaders.setEntityColor(1.0f, 0.0f, 0.0f, 0.3f);
            }
        } else {
            float f3 = (float)(n >> 24 & 0xFF) / 255.0f;
            float f4 = (float)(n >> 16 & 0xFF) / 255.0f;
            float f5 = (float)(n >> 8 & 0xFF) / 255.0f;
            float f6 = (float)(n & 0xFF) / 255.0f;
            this.brightnessBuffer.put(f4);
            this.brightnessBuffer.put(f5);
            this.brightnessBuffer.put(f6);
            this.brightnessBuffer.put(1.0f - f3);
            if (Config.isShaders()) {
                Shaders.setEntityColor(f4, f5, f6, 1.0f - f3);
            }
        }
        this.brightnessBuffer.flip();
        GL11.glTexEnvfv(8960, 8705, this.brightnessBuffer);
        GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(textureBrightness.getGlTextureId());
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.lightmapTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }

    protected void unsetBrightness() {
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_ALPHA, OpenGlHelper.GL_PRIMARY_COLOR);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, 5890);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, 5890);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
        GlStateManager.disableTexture2D();
        GlStateManager.bindTexture(0);
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, 5890);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, 5890);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.setEntityColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    protected void renderLivingAt(T t, double d, double d2, double d3) {
        GlStateManager.translate((float)d, (float)d2, (float)d3);
    }

    protected void rotateCorpse(T t, float f, float f2, float f3) {
        GlStateManager.rotate(180.0f - f2, 0.0f, 1.0f, 0.0f);
        if (((EntityLivingBase)t).deathTime > 0) {
            float f4 = ((float)((EntityLivingBase)t).deathTime + f3 - 1.0f) / 20.0f * 1.6f;
            if ((f4 = MathHelper.sqrt_float(f4)) > 1.0f) {
                f4 = 1.0f;
            }
            GlStateManager.rotate(f4 * this.getDeathMaxRotation(t), 0.0f, 0.0f, 1.0f);
        } else {
            String string = EnumChatFormatting.getTextWithoutFormattingCodes(((Entity)t).getName());
            if (string != null && (string.equals("Dinnerbone") || string.equals("Grumm")) && (!(t instanceof EntityPlayer) || ((EntityPlayer)t).isWearing(EnumPlayerModelParts.CAPE))) {
                GlStateManager.translate(0.0f, ((EntityLivingBase)t).height + 0.1f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
            }
        }
    }

    protected float getSwingProgress(T t, float f) {
        return ((EntityLivingBase)t).getSwingProgress(f);
    }

    protected float handleRotationFloat(T t, float f) {
        return (float)((EntityLivingBase)t).ticksExisted + f;
    }

    protected void renderLayers(T t, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        for (LayerRenderer<T> layerRenderer : this.layerRenderers) {
            boolean bl = this.setBrightness(t, f3, layerRenderer.shouldCombineTextures());
            if (EmissiveTextures.isActive()) {
                EmissiveTextures.beginRender();
            }
            if (this.renderLayersPushMatrix) {
                GlStateManager.pushMatrix();
            }
            layerRenderer.doRenderLayer(t, f, f2, f3, f4, f5, f6, f7);
            if (this.renderLayersPushMatrix) {
                GlStateManager.popMatrix();
            }
            if (EmissiveTextures.isActive()) {
                if (EmissiveTextures.hasEmissive()) {
                    this.renderLayersPushMatrix = true;
                    EmissiveTextures.beginRenderEmissive();
                    GlStateManager.pushMatrix();
                    layerRenderer.doRenderLayer(t, f, f2, f3, f4, f5, f6, f7);
                    GlStateManager.popMatrix();
                    EmissiveTextures.endRenderEmissive();
                }
                EmissiveTextures.endRender();
            }
            if (!bl) continue;
            this.unsetBrightness();
        }
    }

    protected float getDeathMaxRotation(T t) {
        return 90.0f;
    }

    protected int getColorMultiplier(T t, float f, float f2) {
        return 0;
    }

    protected void preRenderCallback(T t, float f) {
    }

    @Override
    public void renderName(T t, double d, double d2, double d3) {
        this.mimeow$nameHider$captureRenderEntity((EntityLivingBase)t, d, d2, d3, new ocee33618a8d("renderName", false));
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("renderName", true);
        this.mimeow$specialsPre((EntityLivingBase)t, d, d2, d3, ocee33618a8d2);
        if (ocee33618a8d2.z$24lpjeeur71n9()) {
            this.mimeow$nameHider$clearRenderEntity((EntityLivingBase)t, d, d2, d3, new ocee33618a8d("renderName", false));
            return;
        }
        if (!Reflector.RenderLivingEvent_Specials_Pre_Constructor.exists() || !Reflector.postCompatBusEvent(Reflector.RenderLivingEvent_Specials_Pre_Constructor, t, this, d, d2, d3)) {
            if (this.canRenderName(t)) {
                float f;
                double d4 = ((Entity)t).getDistanceSqToEntity(this.renderManager.livingPlayer);
                float f2 = f = ((Entity)t).isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
                if (d4 < (double)(f * f)) {
                    String string = this.mimeow$modify$nameHider$hideRenderedName(((Entity)t).getDisplayName().getFormattedText());
                    float f3 = 0.02666667f;
                    GlStateManager.alphaFunc(516, 0.1f);
                    if (((Entity)t).isSneaking()) {
                        FontRenderer fontRenderer = this.getFontRendererFromRenderManager();
                        boolean bl = t instanceof EntityPlayer && oc9e2e8d26de.\u04b0(((Entity)t).getUniqueID(), ((Entity)t).getName());
                        GlStateManager.pushMatrix();
                        GlStateManager.translate((float)d, (float)d2 + ((EntityLivingBase)t).height + 0.5f - (((EntityLivingBase)t).isChild() ? ((EntityLivingBase)t).height / 2.0f : 0.0f), (float)d3);
                        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
                        GlStateManager.rotate(this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
                        GlStateManager.scale(-0.02666667f, -0.02666667f, 0.02666667f);
                        GlStateManager.translate(0.0f, 9.374999f, 0.0f);
                        GlStateManager.disableLighting();
                        GlStateManager.depthMask(false);
                        GlStateManager.enableBlend();
                        GlStateManager.disableTexture2D();
                        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                        int n = bl ? oc45aa3f2e74.\u041e(8) : 0;
                        int n2 = fontRenderer.getStringWidth(string) + n;
                        int n3 = n2 / 2;
                        int n4 = -n3 + n;
                        Tessellator tessellator = Tessellator.getInstance();
                        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
                        worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
                        worldRenderer.pos(-n3 - 1, -1.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
                        worldRenderer.pos(-n3 - 1, 8.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
                        worldRenderer.pos(n3 + 1, 8.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
                        worldRenderer.pos(n3 + 1, -1.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
                        tessellator.draw();
                        GlStateManager.enableTexture2D();
                        GlStateManager.depthMask(true);
                        if (bl) {
                            oc45aa3f2e74.\u03f8(-n3, 0.0f, 8, 0x20FFFFFF);
                        }
                        fontRenderer.drawString(string, n4, 0, 0x20FFFFFF);
                        GlStateManager.enableLighting();
                        GlStateManager.disableBlend();
                        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                        GlStateManager.popMatrix();
                    } else {
                        this.renderOffsetLivingLabel(t, d, d2 - (((EntityLivingBase)t).isChild() ? (double)(((EntityLivingBase)t).height / 2.0f) : 0.0), d3, string, 0.02666667f, d4);
                    }
                }
            }
            if (Reflector.RenderLivingEvent_Specials_Post_Constructor.exists()) {
                Reflector.postCompatBusEvent(Reflector.RenderLivingEvent_Specials_Post_Constructor, t, this, d, d2, d3);
            }
        }
        this.mimeow$nameHider$clearRenderEntity((EntityLivingBase)t, d, d2, d3, new ocee33618a8d("renderName", false));
    }

    @Override
    protected boolean canRenderName(T t) {
        occ52191e479 occ52191e4792 = new occ52191e479("canRenderName", true);
        this.mimeow$suppressNameDuringOutlinePass((EntityLivingBase)t, occ52191e4792);
        if (occ52191e4792.z$24lpjeeur71n9()) {
            return occ52191e4792.\u016f();
        }
        EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().thePlayer;
        if (t instanceof EntityPlayer && t != entityPlayerSP) {
            Team team = ((EntityLivingBase)t).getTeam();
            Team team2 = entityPlayerSP.getTeam();
            if (team != null) {
                Team.EnumVisible enumVisible = team.getNameTagVisibility();
                switch (enumVisible) {
                    case ALWAYS: {
                        return true;
                    }
                    case NEVER: {
                        return false;
                    }
                    case HIDE_FOR_OTHER_TEAMS: {
                        return team2 == null || team.isSameTeam(team2);
                    }
                    case HIDE_FOR_OWN_TEAM: {
                        return team2 == null || !team.isSameTeam(team2);
                    }
                }
                return true;
            }
        }
        return Minecraft.isGuiEnabled() && t != this.renderManager.livingPlayer && !((Entity)t).isInvisibleToPlayer(entityPlayerSP) && ((EntityLivingBase)t).riddenByEntity == null;
    }

    @Override
    protected void renderOffsetLivingLabel(T t, double d, double d2, double d3, String string, float f, double d4) {
        boolean bl = t instanceof EntityPlayer && oc9e2e8d26de.\u04b0(((Entity)t).getUniqueID(), ((Entity)t).getName());
        this.renderLivingLabel(t, string, d, d2, d3, 64, bl);
    }

    public void setRenderOutlines(boolean bl) {
        this.renderOutlines = bl;
    }

    public List<LayerRenderer<T>> getLayerRenderers() {
        return this.layerRenderers;
    }

    private boolean shouldRender() {
        return oc9755810e45.\u04c4 != null && oc9755810e45.\u04c4.z$3rzb3dil7uydr() && oc9755810e45.\u04c4.\u03f1() && oc9755810e45.\u04c4.\u040c.\u01ed();
    }

    private boolean mimeow$redirect$setOutlineColor(RendererLivingEntity rendererLivingEntity, EntityLivingBase entityLivingBase) {
        String string;
        ScorePlayerTeam scorePlayerTeam;
        boolean bl;
        int n = 0xFFFFFF;
        boolean bl2 = bl = this.shouldRender() && (entityLivingBase != Minecraft.getMinecraft().thePlayer && !oca4f99d2d44.\u039b(entityLivingBase) || entityLivingBase == Minecraft.getMinecraft().thePlayer && oc9755810e45.\u04c4.\u04ae.\u01ed());
        if (bl && !oc9755810e45.\u04c4.\u04ef.\u01ed()) {
            n = oc9755810e45.\u04c4.\u0419.\u01ed() ? oc7ab2161b9f.\u01be(2L, 0L) : oc9755810e45.\u04c4.\u0265.\u0373();
        } else if (entityLivingBase instanceof EntityPlayer && (scorePlayerTeam = (ScorePlayerTeam)entityLivingBase.getTeam()) != null && (string = FontRenderer.getFormatFromString(scorePlayerTeam.getColorPrefix())).length() >= 2) {
            n = this.getFontRendererFromRenderManager().getColorCode(string.charAt(1));
        }
        if (bl && oc9755810e45.\u04c4.\u01d6.\u01ed() && entityLivingBase.hurtTime != 0) {
            n = Color.RED.getRGB();
        }
        if (bl) {
            return false;
        }
        float f = (float)(n >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n & 0xFF) / 255.0f;
        GlStateManager.disableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.color(f, f2, f3, 1.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }

    private boolean mimeow$modify$modifyInvisibleFlag(boolean bl) {
        return bl || this.renderOutlines && this.shouldRender() && oc9755810e45.\u04c4.\u04f1.\u01ed();
    }

    private void mimeow$suppressNameDuringOutlinePass(EntityLivingBase entityLivingBase, occ52191e479 occ52191e4792) {
        if (ocd1b2d918dd.F || ocf2fc2a5453.\u0198) {
            occ52191e4792.\u04ea(Boolean.FALSE);
        }
    }

    private void mimeow$mobEsp$chamsPre(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        if (!(entityLivingBase instanceof EntityPlayer)) {
            ocf2fc2a5453.\u03cf(entityLivingBase);
        }
    }

    private void mimeow$mobEsp$chamsPost(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        if (!(entityLivingBase instanceof EntityPlayer)) {
            ocf2fc2a5453.\u023b();
        }
    }

    private void mimeow$nameHider$captureRenderEntity(EntityLivingBase entityLivingBase, double d, double d2, double d3, ocee33618a8d ocee33618a8d2) {
        this.nameHider$renderNameEntity = entityLivingBase;
    }

    private String mimeow$modify$nameHider$hideRenderedName(String string) {
        if (string == null || oc9755810e45.\u03c8 == null || !oc9755810e45.\u03c8.z$3rzb3dil7uydr()) {
            return string;
        }
        if (this.nameHider$renderNameEntity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)this.nameHider$renderNameEntity;
            return oced29a282d7.\u04a4(entityPlayer, entityPlayer.getDisplayName()).getFormattedText();
        }
        return oced29a282d7.\u0377(string);
    }

    private void mimeow$nameHider$clearRenderEntity(EntityLivingBase entityLivingBase, double d, double d2, double d3, ocee33618a8d ocee33618a8d2) {
        this.nameHider$renderNameEntity = null;
    }

    private void mimeow$renderPre(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        if (ocea775c9d5c.\u0173.post(new oc9ca1ce49ff<EntityLivingBase>(entityLivingBase, this, d, d2, d3))) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    private void mimeow$renderPost(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new ocd4576614ae<EntityLivingBase>(entityLivingBase, this, d, d2, d3));
    }

    private void mimeow$specialsPre(EntityLivingBase entityLivingBase, double d, double d2, double d3, ocee33618a8d ocee33618a8d2) {
        if (ocea775c9d5c.\u0173.post(new oca305a6dc47<EntityLivingBase>(entityLivingBase, this, d, d2, d3))) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    static {
        int[] nArray = textureBrightness.getTextureData();
        for (int i = 0; i < 256; ++i) {
            nArray[i] = -1;
        }
        textureBrightness.updateDynamicTexture();
    }
}

