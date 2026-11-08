/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerDeadmau5Head;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ResourceLocation;
import x.oc7ab2161b9f;
import x.ocb554f4d108;
import x.ocbc0df1f744;
import x.occ34ee36d65;
import x.ocd056cee4b3;
import x.ocea775c9d5c;
import x.ocee33618a8d;

public class RenderPlayer
extends RendererLivingEntity<AbstractClientPlayer> {
    private boolean smallArms;

    public RenderPlayer(RenderManager renderManager) {
        this(renderManager, false);
    }

    public RenderPlayer(RenderManager renderManager, boolean bl) {
        super(renderManager, new ModelPlayer(0.0f, bl), 0.5f);
        this.smallArms = bl;
        this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerArrow(this));
        this.addLayer(new LayerDeadmau5Head(this));
        this.addLayer(new LayerCape(this));
        this.addLayer(new LayerCustomHead(this.getMainModel().bipedHead));
    }

    @Override
    public ModelPlayer getMainModel() {
        return (ModelPlayer)super.getMainModel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void doRender(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        this.mimeow$onDoRenderHead(abstractClientPlayer, d, d2, d3, f, f2, new ocee33618a8d("doRender", false));
        boolean bl = false;
        try {
            ocee33618a8d ocee33618a8d2 = new ocee33618a8d("doRender", true);
            this.mimeow$renderPlayerPre(abstractClientPlayer, d, d2, d3, f, f2, ocee33618a8d2);
            if (!ocee33618a8d2.z$24lpjeeur71n9()) {
                if (!abstractClientPlayer.isUser() || this.renderManager.livingPlayer == abstractClientPlayer) {
                    double d4 = d2;
                    if (occ34ee36d65.\u042e(abstractClientPlayer) && !(abstractClientPlayer instanceof EntityPlayerSP)) {
                        d4 = d2 - 0.125;
                    }
                    this.setModelVisibilities(abstractClientPlayer);
                    super.doRender(abstractClientPlayer, d, d4, d3, f, f2);
                }
                bl = true;
            }
        }
        finally {
            this.mimeow$onDoRenderReturn(abstractClientPlayer, d, d2, d3, f, f2, new ocee33618a8d("doRender", false));
        }
        if (bl) {
            this.mimeow$renderPlayerPost(abstractClientPlayer, d, d2, d3, f, f2, new ocee33618a8d("doRender", false));
        }
    }

    private void setModelVisibilities(AbstractClientPlayer abstractClientPlayer) {
        ModelPlayer modelPlayer = this.getMainModel();
        if (abstractClientPlayer.isSpectator()) {
            modelPlayer.setInvisible(false);
            modelPlayer.bipedHead.showModel = true;
            modelPlayer.bipedHeadwear.showModel = true;
        } else {
            InventoryPlayer inventoryPlayer = abstractClientPlayer.inventory;
            ItemStack itemStack = this.mimeow$redirectGetCurrentItem(inventoryPlayer);
            modelPlayer.setInvisible(true);
            modelPlayer.bipedHeadwear.showModel = abstractClientPlayer.isWearing(EnumPlayerModelParts.HAT);
            modelPlayer.bipedBodyWear.showModel = abstractClientPlayer.isWearing(EnumPlayerModelParts.JACKET);
            modelPlayer.bipedLeftLegwear.showModel = abstractClientPlayer.isWearing(EnumPlayerModelParts.LEFT_PANTS_LEG);
            modelPlayer.bipedRightLegwear.showModel = abstractClientPlayer.isWearing(EnumPlayerModelParts.RIGHT_PANTS_LEG);
            modelPlayer.bipedLeftArmwear.showModel = abstractClientPlayer.isWearing(EnumPlayerModelParts.LEFT_SLEEVE);
            modelPlayer.bipedRightArmwear.showModel = abstractClientPlayer.isWearing(EnumPlayerModelParts.RIGHT_SLEEVE);
            modelPlayer.heldItemLeft = 0;
            modelPlayer.aimedBow = false;
            modelPlayer.isSneak = occ34ee36d65.\u042e(abstractClientPlayer);
            if (itemStack == null) {
                modelPlayer.heldItemRight = 0;
            } else {
                modelPlayer.heldItemRight = 1;
                if (this.mimeow$redirectGetItemInUseCount(abstractClientPlayer) > 0) {
                    EnumAction enumAction = itemStack.getItemUseAction();
                    if (enumAction == EnumAction.BLOCK) {
                        modelPlayer.heldItemRight = 3;
                    } else if (enumAction == EnumAction.BOW) {
                        modelPlayer.aimedBow = true;
                    }
                }
            }
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(AbstractClientPlayer abstractClientPlayer) {
        return abstractClientPlayer.getLocationSkin();
    }

    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }

    @Override
    protected void preRenderCallback(AbstractClientPlayer abstractClientPlayer, float f) {
        float f2 = 0.9375f;
        GlStateManager.scale(f2, f2, f2);
    }

    @Override
    protected void renderOffsetLivingLabel(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
        Scoreboard scoreboard;
        ScoreObjective scoreObjective;
        if (d4 < 100.0 && (scoreObjective = (scoreboard = abstractClientPlayer.getWorldScoreboard()).getObjectiveInDisplaySlot(2)) != null) {
            Score score = scoreboard.getValueFromObjective(abstractClientPlayer.getName(), scoreObjective);
            this.renderLivingLabel(abstractClientPlayer, score.getScorePoints() + " " + scoreObjective.getDisplayName(), d, d2, d3, 64);
            d2 += (double)((float)this.getFontRendererFromRenderManager().FONT_HEIGHT * 1.15f * f);
        }
        super.renderOffsetLivingLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
    }

    public void renderRightArm(AbstractClientPlayer abstractClientPlayer) {
        float f = 1.0f;
        GlStateManager.color(f, f, f);
        ModelPlayer modelPlayer = this.getMainModel();
        this.setModelVisibilities(abstractClientPlayer);
        modelPlayer.swingProgress = 0.0f;
        modelPlayer.isSneak = false;
        modelPlayer.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, abstractClientPlayer);
        modelPlayer.renderRightArm();
    }

    public void renderLeftArm(AbstractClientPlayer abstractClientPlayer) {
        float f = 1.0f;
        GlStateManager.color(f, f, f);
        ModelPlayer modelPlayer = this.getMainModel();
        this.setModelVisibilities(abstractClientPlayer);
        modelPlayer.isSneak = false;
        modelPlayer.swingProgress = 0.0f;
        modelPlayer.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, abstractClientPlayer);
        modelPlayer.renderLeftArm();
    }

    @Override
    protected void renderLivingAt(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        if (abstractClientPlayer.isEntityAlive() && abstractClientPlayer.isPlayerSleeping()) {
            super.renderLivingAt(abstractClientPlayer, d + (double)abstractClientPlayer.renderOffsetX, d2 + (double)abstractClientPlayer.renderOffsetY, d3 + (double)abstractClientPlayer.renderOffsetZ);
        } else {
            super.renderLivingAt(abstractClientPlayer, d, d2, d3);
        }
    }

    @Override
    protected void rotateCorpse(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        if (abstractClientPlayer.isEntityAlive() && abstractClientPlayer.isPlayerSleeping()) {
            GlStateManager.rotate(abstractClientPlayer.getBedOrientationInDegrees(), 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(this.getDeathMaxRotation(abstractClientPlayer), 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(270.0f, 0.0f, 1.0f, 0.0f);
        } else {
            super.rotateCorpse(abstractClientPlayer, f, f2, f3);
        }
    }

    private void mimeow$onDoRenderHead(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        ocb554f4d108.\u0525(abstractClientPlayer);
    }

    private void mimeow$onDoRenderReturn(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        ocb554f4d108.\u029b(abstractClientPlayer);
    }

    private ItemStack mimeow$redirectGetCurrentItem(InventoryPlayer inventoryPlayer) {
        return Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && inventoryPlayer.player == Minecraft.getMinecraft().thePlayer ? oc7ab2161b9f.\u03de(inventoryPlayer.getCurrentItem()) : inventoryPlayer.getCurrentItem();
    }

    private int mimeow$redirectGetItemInUseCount(AbstractClientPlayer abstractClientPlayer) {
        int n = abstractClientPlayer.getItemInUseCount();
        if (n > 0) {
            return n;
        }
        ItemStack itemStack = Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 ? oc7ab2161b9f.\u03de(abstractClientPlayer.inventory.getCurrentItem()) : abstractClientPlayer.inventory.getCurrentItem();
        return ocb554f4d108.\u01fe(abstractClientPlayer, itemStack) ? 1 : n;
    }

    private void mimeow$renderPlayerPre(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        if (ocea775c9d5c.\u0173.post(new ocbc0df1f744(abstractClientPlayer, this, f2, d, d2, d3))) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    private void mimeow$renderPlayerPost(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2, ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new ocd056cee4b3(abstractClientPlayer, this, f2, d, d2, d3));
    }
}

