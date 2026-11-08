/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import io.netty.buffer.Unpooled;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiBeacon
extends GuiContainer {
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation beaconGuiTextures = new ResourceLocation("textures/gui/container/beacon.png");
    private IInventory tileBeacon;
    private ConfirmButton beaconConfirmButton;
    private boolean buttonsNotDrawn;

    public GuiBeacon(InventoryPlayer inventoryPlayer, IInventory iInventory) {
        super(new ContainerBeacon(inventoryPlayer, iInventory));
        this.tileBeacon = iInventory;
        this.xSize = 230;
        this.ySize = 219;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.beaconConfirmButton = new ConfirmButton(-1, this.guiLeft + 164, this.guiTop + 107);
        this.buttonList.add(this.beaconConfirmButton);
        this.buttonList.add(new CancelButton(-2, this.guiLeft + 190, this.guiTop + 107));
        this.buttonsNotDrawn = true;
        this.beaconConfirmButton.enabled = false;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        int n = this.tileBeacon.getField(0);
        int n2 = this.tileBeacon.getField(1);
        int n3 = this.tileBeacon.getField(2);
        if (this.buttonsNotDrawn && n >= 0) {
            PowerButton powerButton;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            this.buttonsNotDrawn = false;
            for (n8 = 0; n8 <= 2; ++n8) {
                n7 = TileEntityBeacon.effectsList[n8].length;
                n6 = n7 * 22 + (n7 - 1) * 2;
                for (n5 = 0; n5 < n7; ++n5) {
                    n4 = TileEntityBeacon.effectsList[n8][n5].id;
                    powerButton = new PowerButton(n8 << 8 | n4, this.guiLeft + 76 + n5 * 24 - n6 / 2, this.guiTop + 22 + n8 * 25, n4, n8);
                    this.buttonList.add(powerButton);
                    if (n8 >= n) {
                        powerButton.enabled = false;
                        continue;
                    }
                    if (n4 != n2) continue;
                    powerButton.func_146140_b(true);
                }
            }
            n8 = 3;
            n7 = TileEntityBeacon.effectsList[n8].length + 1;
            n6 = n7 * 22 + (n7 - 1) * 2;
            for (n5 = 0; n5 < n7 - 1; ++n5) {
                n4 = TileEntityBeacon.effectsList[n8][n5].id;
                powerButton = new PowerButton(n8 << 8 | n4, this.guiLeft + 167 + n5 * 24 - n6 / 2, this.guiTop + 47, n4, n8);
                this.buttonList.add(powerButton);
                if (n8 >= n) {
                    powerButton.enabled = false;
                    continue;
                }
                if (n4 != n3) continue;
                powerButton.func_146140_b(true);
            }
            if (n2 > 0) {
                PowerButton powerButton2 = new PowerButton(n8 << 8 | n2, this.guiLeft + 167 + (n7 - 1) * 24 - n6 / 2, this.guiTop + 47, n2, n8);
                this.buttonList.add(powerButton2);
                if (n8 >= n) {
                    powerButton2.enabled = false;
                } else if (n2 == n3) {
                    powerButton2.func_146140_b(true);
                }
            }
        }
        this.beaconConfirmButton.enabled = this.tileBeacon.getStackInSlot(0) != null && n2 > 0;
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.id == -2) {
            this.mc.displayGuiScreen(null);
        } else if (guiButton.id == -1) {
            String string = "MC|Beacon";
            PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
            packetBuffer.writeInt(this.tileBeacon.getField(1));
            packetBuffer.writeInt(this.tileBeacon.getField(2));
            this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload(string, packetBuffer));
            this.mc.displayGuiScreen(null);
        } else if (guiButton instanceof PowerButton) {
            if (((PowerButton)guiButton).func_146141_c()) {
                return;
            }
            int n = guiButton.id;
            int n2 = n & 0xFF;
            int n3 = n >> 8;
            if (n3 < 3) {
                this.tileBeacon.setField(1, n2);
            } else {
                this.tileBeacon.setField(2, n2);
            }
            this.buttonList.clear();
            this.initGui();
            this.updateScreen();
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        RenderHelper.disableStandardItemLighting();
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.primary", new Object[0]), 62, 10, 0xE0E0E0);
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.secondary", new Object[0]), 169, 10, 0xE0E0E0);
        for (GuiButton guiButton : this.buttonList) {
            if (!guiButton.isMouseOver()) continue;
            guiButton.drawButtonForegroundLayer(n - this.guiLeft, n2 - this.guiTop);
            break;
        }
        RenderHelper.enableGUIStandardItemLighting();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(beaconGuiTextures);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        this.itemRender.zLevel = 100.0f;
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.emerald), n3 + 42, n4 + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.diamond), n3 + 42 + 22, n4 + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.gold_ingot), n3 + 42 + 44, n4 + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.iron_ingot), n3 + 42 + 66, n4 + 109);
        this.itemRender.zLevel = 0.0f;
    }

    public class ConfirmButton
    extends Button {
        public ConfirmButton(int n, int n2, int n3) {
            super(n, n2, n3, beaconGuiTextures, 90, 220);
        }

        @Override
        public void drawButtonForegroundLayer(int n, int n2) {
            GuiBeacon.this.drawCreativeTabHoveringText(I18n.format("gui.done", new Object[0]), n, n2);
        }
    }

    public class CancelButton
    extends Button {
        public CancelButton(int n, int n2, int n3) {
            super(n, n2, n3, beaconGuiTextures, 112, 220);
        }

        @Override
        public void drawButtonForegroundLayer(int n, int n2) {
            GuiBeacon.this.drawCreativeTabHoveringText(I18n.format("gui.cancel", new Object[0]), n, n2);
        }
    }

    public class PowerButton
    extends Button {
        private final int field_146149_p;
        private final int field_146148_q;

        public PowerButton(int n, int n2, int n3, int n4, int n5) {
            super(n, n2, n3, GuiContainer.inventoryBackground, 0 + Potion.potionTypes[n4].getStatusIconIndex() % 8 * 18, 198 + Potion.potionTypes[n4].getStatusIconIndex() / 8 * 18);
            this.field_146149_p = n4;
            this.field_146148_q = n5;
        }

        @Override
        public void drawButtonForegroundLayer(int n, int n2) {
            Object object = I18n.format(Potion.potionTypes[this.field_146149_p].getName(), new Object[0]);
            if (this.field_146148_q >= 3 && this.field_146149_p != Potion.regeneration.id) {
                object = (String)object + " II";
            }
            GuiBeacon.this.drawCreativeTabHoveringText((String)object, n, n2);
        }
    }

    public static class Button
    extends GuiButton {
        private final ResourceLocation field_146145_o;
        private final int field_146144_p;
        private final int field_146143_q;
        private boolean field_146142_r;

        protected Button(int n, int n2, int n3, ResourceLocation resourceLocation, int n4, int n5) {
            super(n, n2, n3, 22, 22, "");
            this.field_146145_o = resourceLocation;
            this.field_146144_p = n4;
            this.field_146143_q = n5;
        }

        @Override
        public void drawButton(Minecraft minecraft, int n, int n2) {
            if (this.visible) {
                minecraft.getTextureManager().bindTexture(beaconGuiTextures);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.hovered = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
                int n3 = 219;
                int n4 = 0;
                if (!this.enabled) {
                    n4 += this.width * 2;
                } else if (this.field_146142_r) {
                    n4 += this.width * 1;
                } else if (this.hovered) {
                    n4 += this.width * 3;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, n4, n3, this.width, this.height);
                if (!beaconGuiTextures.equals(this.field_146145_o)) {
                    minecraft.getTextureManager().bindTexture(this.field_146145_o);
                }
                this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, this.field_146144_p, this.field_146143_q, 18, 18);
            }
        }

        public boolean func_146141_c() {
            return this.field_146142_r;
        }

        public void func_146140_b(boolean bl) {
            this.field_146142_r = bl;
        }
    }
}

