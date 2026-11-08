/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import x.oc4e1b577a95;

public class GuiChest
extends GuiContainer {
    private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
    private IInventory upperChestInventory;
    private IInventory lowerChestInventory;
    private int inventoryRows;

    public GuiChest(IInventory iInventory, IInventory iInventory2) {
        super(new ContainerChest(iInventory, iInventory2, Minecraft.getMinecraft().thePlayer));
        this.upperChestInventory = iInventory;
        this.lowerChestInventory = iInventory2;
        this.allowUserInput = false;
        int n = 222;
        int n2 = n - 108;
        this.inventoryRows = iInventory2.getSizeInventory() / 9;
        this.ySize = n2 + this.inventoryRows * 18;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRendererObj.drawString(this.lowerChestInventory.getDisplayName().getUnformattedText(), 8, 6, 0x404040);
        this.fontRendererObj.drawString(this.upperChestInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 0x404040);
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
        this.mc.getTextureManager().bindTexture(CHEST_GUI_TEXTURE);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(n3, n4 + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
        if (f2 < 1.0f) {
            GlStateManager.disableBlend();
            GlStateManager.disableAlpha();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
}

