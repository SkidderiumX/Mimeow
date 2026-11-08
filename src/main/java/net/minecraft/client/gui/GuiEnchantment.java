/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnchantmentNameParts;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import org.lwjgl.util.glu.Project;

public class GuiEnchantment
extends GuiContainer {
    private static final ResourceLocation ENCHANTMENT_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/enchanting_table.png");
    private static final ResourceLocation ENCHANTMENT_TABLE_BOOK_TEXTURE = new ResourceLocation("textures/entity/enchanting_table_book.png");
    private static final ModelBook MODEL_BOOK = new ModelBook();
    private final InventoryPlayer playerInventory;
    private Random random = new Random();
    private ContainerEnchantment container;
    public int field_147073_u;
    public float field_147071_v;
    public float field_147069_w;
    public float field_147082_x;
    public float field_147081_y;
    public float field_147080_z;
    public float field_147076_A;
    ItemStack field_147077_B;
    private final IWorldNameable field_175380_I;

    public GuiEnchantment(InventoryPlayer inventoryPlayer, World world2, IWorldNameable iWorldNameable) {
        super(new ContainerEnchantment(inventoryPlayer, world2));
        this.playerInventory = inventoryPlayer;
        this.container = (ContainerEnchantment)this.inventorySlots;
        this.field_175380_I = iWorldNameable;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRendererObj.drawString(this.field_175380_I.getDisplayName().getUnformattedText(), 12, 5, 0x404040);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.func_147068_g();
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        super.mouseClicked(n, n2, n3);
        int n4 = (this.width - this.xSize) / 2;
        int n5 = (this.height - this.ySize) / 2;
        for (int i = 0; i < 3; ++i) {
            int n6 = n - (n4 + 60);
            int n7 = n2 - (n5 + 14 + 19 * i);
            if (n6 < 0 || n7 < 0 || n6 >= 108 || n7 >= 19 || !this.container.enchantItem(this.mc.thePlayer, i)) continue;
            this.mc.playerController.sendEnchantPacket(this.container.windowId, i);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(ENCHANTMENT_TABLE_GUI_TEXTURE);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        GlStateManager.pushMatrix();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        GlStateManager.viewport((scaledResolution.getScaledWidth() - 320) / 2 * scaledResolution.getScaleFactor(), (scaledResolution.getScaledHeight() - 240) / 2 * scaledResolution.getScaleFactor(), 320 * scaledResolution.getScaleFactor(), 240 * scaledResolution.getScaleFactor());
        GlStateManager.translate(-0.34f, 0.23f, 0.0f);
        Project.gluPerspective(90.0f, 1.3333334f, 9.0f, 80.0f);
        float f2 = 1.0f;
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.translate(0.0f, 3.3f, -16.0f);
        GlStateManager.scale(f2, f2, f2);
        float f3 = 5.0f;
        GlStateManager.scale(f3, f3, f3);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(ENCHANTMENT_TABLE_BOOK_TEXTURE);
        GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
        float f4 = this.field_147076_A + (this.field_147080_z - this.field_147076_A) * f;
        GlStateManager.translate((1.0f - f4) * 0.2f, (1.0f - f4) * 0.1f, (1.0f - f4) * 0.25f);
        GlStateManager.rotate(-(1.0f - f4) * 90.0f - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        float f5 = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * f + 0.25f;
        float f6 = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * f + 0.75f;
        f5 = (f5 - (float)MathHelper.truncateDoubleToInt(f5)) * 1.6f - 0.3f;
        f6 = (f6 - (float)MathHelper.truncateDoubleToInt(f6)) * 1.6f - 0.3f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        GlStateManager.enableRescaleNormal();
        MODEL_BOOK.render(null, 0.0f, f5, f6, f4, 0.0f, 0.0625f);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.matrixMode(5889);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        EnchantmentNameParts.getInstance().reseedRandomGenerator(this.container.xpSeed);
        int n5 = this.container.getLapisAmount();
        for (int i = 0; i < 3; ++i) {
            int n6 = n3 + 60;
            int n7 = n6 + 20;
            int n8 = 86;
            String string = EnchantmentNameParts.getInstance().generateNewRandomName();
            this.zLevel = 0.0f;
            this.mc.getTextureManager().bindTexture(ENCHANTMENT_TABLE_GUI_TEXTURE);
            int n9 = this.container.enchantLevels[i];
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (n9 == 0) {
                this.drawTexturedModalRect(n6, n4 + 14 + 19 * i, 0, 185, 108, 19);
                continue;
            }
            String string2 = "" + n9;
            FontRenderer fontRenderer = this.mc.standardGalacticFontRenderer;
            int n10 = 6839882;
            if (!(n5 >= i + 1 && this.mc.thePlayer.experienceLevel >= n9 || this.mc.thePlayer.capabilities.isCreativeMode)) {
                this.drawTexturedModalRect(n6, n4 + 14 + 19 * i, 0, 185, 108, 19);
                this.drawTexturedModalRect(n6 + 1, n4 + 15 + 19 * i, 16 * i, 239, 16, 16);
                fontRenderer.drawSplitString(string, n7, n4 + 16 + 19 * i, n8, (n10 & 0xFEFEFE) >> 1);
                n10 = 4226832;
            } else {
                int n11 = n - (n3 + 60);
                int n12 = n2 - (n4 + 14 + 19 * i);
                if (n11 >= 0 && n12 >= 0 && n11 < 108 && n12 < 19) {
                    this.drawTexturedModalRect(n6, n4 + 14 + 19 * i, 0, 204, 108, 19);
                    n10 = 0xFFFF80;
                } else {
                    this.drawTexturedModalRect(n6, n4 + 14 + 19 * i, 0, 166, 108, 19);
                }
                this.drawTexturedModalRect(n6 + 1, n4 + 15 + 19 * i, 16 * i, 223, 16, 16);
                fontRenderer.drawSplitString(string, n7, n4 + 16 + 19 * i, n8, n10);
                n10 = 8453920;
            }
            fontRenderer = this.mc.fontRendererObj;
            fontRenderer.drawStringWithShadow(string2, n7 + 86 - fontRenderer.getStringWidth(string2), n4 + 16 + 19 * i + 7, n10);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        boolean bl = this.mc.thePlayer.capabilities.isCreativeMode;
        int n3 = this.container.getLapisAmount();
        for (int i = 0; i < 3; ++i) {
            String string;
            int n4 = this.container.enchantLevels[i];
            int n5 = this.container.enchantmentIds[i];
            int n6 = i + 1;
            if (!this.isPointInRegion(60, 14 + 19 * i, 108, 17, n, n2) || n4 <= 0 || n5 < 0) continue;
            ArrayList<String> arrayList = Lists.newArrayList();
            if (n5 >= 0 && Enchantment.getEnchantmentById(n5 & 0xFF) != null) {
                string = Enchantment.getEnchantmentById(n5 & 0xFF).getTranslatedName((n5 & 0xFF00) >> 8);
                arrayList.add(EnumChatFormatting.WHITE.toString() + EnumChatFormatting.ITALIC.toString() + I18n.format("container.enchant.clue", string));
            }
            if (!bl) {
                if (n5 >= 0) {
                    arrayList.add("");
                }
                if (this.mc.thePlayer.experienceLevel < n4) {
                    arrayList.add(EnumChatFormatting.RED.toString() + "Level Requirement: " + this.container.enchantLevels[i]);
                } else {
                    string = "";
                    string = n6 == 1 ? I18n.format("container.enchant.lapis.one", new Object[0]) : I18n.format("container.enchant.lapis.many", n6);
                    if (n3 >= n6) {
                        arrayList.add(EnumChatFormatting.GRAY.toString() + string);
                    } else {
                        arrayList.add(EnumChatFormatting.RED.toString() + string);
                    }
                    string = n6 == 1 ? I18n.format("container.enchant.level.one", new Object[0]) : I18n.format("container.enchant.level.many", n6);
                    arrayList.add(EnumChatFormatting.GRAY.toString() + string);
                }
            }
            this.drawHoveringText(arrayList, n, n2);
            break;
        }
    }

    public void func_147068_g() {
        ItemStack itemStack = this.inventorySlots.getSlot(0).getStack();
        if (!ItemStack.areItemStacksEqual(itemStack, this.field_147077_B)) {
            this.field_147077_B = itemStack;
            do {
                this.field_147082_x += (float)(this.random.nextInt(4) - this.random.nextInt(4));
            } while (!(this.field_147071_v > this.field_147082_x + 1.0f) && !(this.field_147071_v < this.field_147082_x - 1.0f));
        }
        ++this.field_147073_u;
        this.field_147069_w = this.field_147071_v;
        this.field_147076_A = this.field_147080_z;
        boolean bl = false;
        for (int i = 0; i < 3; ++i) {
            if (this.container.enchantLevels[i] == 0) continue;
            bl = true;
        }
        this.field_147080_z = bl ? (this.field_147080_z += 0.2f) : (this.field_147080_z -= 0.2f);
        this.field_147080_z = MathHelper.clamp_float(this.field_147080_z, 0.0f, 1.0f);
        float f = (this.field_147082_x - this.field_147071_v) * 0.4f;
        float f2 = 0.2f;
        f = MathHelper.clamp_float(f, -f2, f2);
        this.field_147081_y += (f - this.field_147081_y) * 0.9f;
        this.field_147071_v += this.field_147081_y;
    }
}

