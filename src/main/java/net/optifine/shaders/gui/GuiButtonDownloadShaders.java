/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonDownloadShaders
extends GuiButton {
    public GuiButtonDownloadShaders(int n, int n2, int n3) {
        super(n, n2, n3, 22, 20, "");
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.visible) {
            super.drawButton(minecraft, n, n2);
            ResourceLocation resourceLocation = new ResourceLocation("optifine/textures/icons.png");
            minecraft.getTextureManager().bindTexture(resourceLocation);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + 3, this.yPosition + 2, 0, 0, 16, 16);
        }
    }
}

