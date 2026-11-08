/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.tileentity;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomColors;
import net.optifine.shaders.Shaders;
import org.lwjgl.opengl.GL11;

public class TileEntitySignRenderer
extends TileEntitySpecialRenderer<TileEntitySign> {
    private static final ResourceLocation SIGN_TEXTURE = new ResourceLocation("textures/entity/sign.png");
    private final ModelSign model = new ModelSign();
    private static double textRenderDistanceSq = 4096.0;

    @Override
    public void renderTileEntityAt(TileEntitySign tileEntitySign, double d, double d2, double d3, float f, int n) {
        float f2;
        Block block = tileEntitySign.getBlockType();
        GlStateManager.pushMatrix();
        float f3 = 0.6666667f;
        if (block == Blocks.standing_sign) {
            GlStateManager.translate((float)d + 0.5f, (float)d2 + 0.75f * f3, (float)d3 + 0.5f);
            float f4 = (float)(tileEntitySign.getBlockMetadata() * 360) / 16.0f;
            GlStateManager.rotate(-f4, 0.0f, 1.0f, 0.0f);
            this.model.signStick.showModel = true;
        } else {
            int n2 = tileEntitySign.getBlockMetadata();
            f2 = 0.0f;
            if (n2 == 2) {
                f2 = 180.0f;
            }
            if (n2 == 4) {
                f2 = 90.0f;
            }
            if (n2 == 5) {
                f2 = -90.0f;
            }
            GlStateManager.translate((float)d + 0.5f, (float)d2 + 0.75f * f3, (float)d3 + 0.5f);
            GlStateManager.rotate(-f2, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.3125f, -0.4375f);
            this.model.signStick.showModel = false;
        }
        if (n >= 0) {
            this.bindTexture(DESTROY_STAGES[n]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 2.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        } else {
            this.bindTexture(SIGN_TEXTURE);
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        GlStateManager.scale(f3, -f3, -f3);
        this.model.renderSign();
        GlStateManager.popMatrix();
        if (TileEntitySignRenderer.isRenderText(tileEntitySign)) {
            FontRenderer fontRenderer = this.getFontRenderer();
            f2 = 0.015625f * f3;
            GlStateManager.translate(0.0f, 0.5f * f3, 0.07f * f3);
            GlStateManager.scale(f2, -f2, f2);
            GL11.glNormal3f(0.0f, 0.0f, -1.0f * f2);
            GlStateManager.depthMask(false);
            int n3 = 0;
            if (Config.isCustomColors()) {
                n3 = CustomColors.getSignTextColor(n3);
            }
            if (n < 0) {
                for (int i = 0; i < tileEntitySign.signText.length; ++i) {
                    Object object;
                    if (tileEntitySign.signText[i] == null) continue;
                    IChatComponent iChatComponent = tileEntitySign.signText[i];
                    List<IChatComponent> list = GuiUtilRenderComponents.splitText(iChatComponent, 90, fontRenderer, false, true);
                    Object object2 = object = list != null && list.size() > 0 ? list.get(0).getFormattedText() : "";
                    if (i == tileEntitySign.lineBeingEdited) {
                        object = "> " + (String)object + " <";
                        fontRenderer.drawString((String)object, -fontRenderer.getStringWidth((String)object) / 2, i * 10 - tileEntitySign.signText.length * 5, n3);
                        continue;
                    }
                    fontRenderer.drawString((String)object, -fontRenderer.getStringWidth((String)object) / 2, i * 10 - tileEntitySign.signText.length * 5, n3);
                }
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
        if (n >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }

    private static boolean isRenderText(TileEntitySign tileEntitySign) {
        if (Shaders.isShadowPass) {
            return false;
        }
        if (Config.getMinecraft().currentScreen instanceof GuiEditSign) {
            return true;
        }
        if (!Config.zoomMode && tileEntitySign.lineBeingEdited < 0) {
            Entity entity = Config.getMinecraft().getRenderViewEntity();
            double d = tileEntitySign.getDistanceSq(entity.posX, entity.posY, entity.posZ);
            if (d > textRenderDistanceSq) {
                return false;
            }
        }
        return true;
    }

    public static void updateTextRenderDistance() {
        Minecraft minecraft = Config.getMinecraft();
        double d = Config.limit(minecraft.gameSettings.fovSetting, 1.0f, 120.0f);
        double d2 = Math.max(1.5 * (double)minecraft.displayHeight / d, 16.0);
        textRenderDistanceSq = d2 * d2;
    }
}

