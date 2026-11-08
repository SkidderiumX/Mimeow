/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import x.oc4e1b577a95;

public class GuiInventory
extends InventoryEffectRenderer {
    private static boolean renderingEntityPreview;
    private float oldMouseX;
    private float oldMouseY;

    public GuiInventory(EntityPlayer entityPlayer) {
        super(entityPlayer.inventoryContainer);
        this.allowUserInput = true;
    }

    @Override
    public void updateScreen() {
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
        }
        this.updateActivePotionEffects();
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
        } else {
            super.initGui();
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 86, 16, 0x404040);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this.oldMouseX = n;
        this.oldMouseY = n2;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        float f2 = oc4e1b577a95.\u0281();
        if (f2 < 1.0f) {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.color(1.0f, 1.0f, 1.0f, f2);
        } else {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        }
        this.mc.getTextureManager().bindTexture(inventoryBackground);
        int n3 = this.guiLeft;
        int n4 = this.guiTop;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        if (f2 < 1.0f) {
            GlStateManager.disableBlend();
            GlStateManager.disableAlpha();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        }
        GuiInventory.drawEntityOnScreen(n3 + 51, n4 + 75, 30, (float)(n3 + 51) - this.oldMouseX, (float)(n4 + 75 - 50) - this.oldMouseY, this.mc.thePlayer);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void drawEntityOnScreen(int n, int n2, int n3, float f, float f2, EntityLivingBase entityLivingBase) {
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.enableRescaleNormal();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(n, n2, 50.0f);
        GlStateManager.scale(-n3, n3, n3);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        float f3 = entityLivingBase.prevRenderYawOffset;
        float f4 = entityLivingBase.renderYawOffset;
        float f5 = entityLivingBase.rotationYaw;
        float f6 = entityLivingBase.prevRotationPitch;
        float f7 = entityLivingBase.rotationPitch;
        float f8 = entityLivingBase.prevRotationYawHead;
        float f9 = entityLivingBase.rotationYawHead;
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-((float)Math.atan(f2 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        entityLivingBase.prevRenderYawOffset = (float)Math.atan(f / 40.0f) * 20.0f;
        entityLivingBase.renderYawOffset = (float)Math.atan(f / 40.0f) * 20.0f;
        entityLivingBase.rotationYaw = (float)Math.atan(f / 40.0f) * 40.0f;
        entityLivingBase.rotationPitch = -((float)Math.atan(f2 / 40.0f)) * 20.0f;
        entityLivingBase.rotationYawHead = entityLivingBase.rotationYaw;
        entityLivingBase.prevRotationYawHead = entityLivingBase.rotationYaw;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        float f10 = renderManager.playerViewY;
        boolean bl = renderManager.isRenderShadow();
        renderingEntityPreview = true;
        try {
            renderManager.setPlayerViewY(180.0f);
            renderManager.setRenderShadow(false);
            renderManager.renderEntityWithPosYaw(entityLivingBase, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        }
        finally {
            renderingEntityPreview = false;
            renderManager.setPlayerViewY(f10);
            renderManager.setRenderShadow(bl);
            entityLivingBase.prevRenderYawOffset = f3;
            entityLivingBase.renderYawOffset = f4;
            entityLivingBase.rotationYaw = f5;
            entityLivingBase.prevRotationPitch = f6;
            entityLivingBase.rotationPitch = f7;
            entityLivingBase.prevRotationYawHead = f8;
            entityLivingBase.rotationYawHead = f9;
            GlStateManager.popMatrix();
        }
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.id == 0) {
            this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
        }
        if (guiButton.id == 1) {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
        }
    }

    public static boolean isRenderingEntityPreview() {
        return renderingEntityPreview;
    }
}

