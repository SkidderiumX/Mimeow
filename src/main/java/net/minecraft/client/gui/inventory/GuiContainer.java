/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import x.oc9755810e45;

public abstract class GuiContainer
extends GuiScreen {
    protected static final ResourceLocation inventoryBackground = new ResourceLocation("textures/gui/container/inventory.png");
    protected int xSize = 176;
    protected int ySize = 166;
    public Container inventorySlots;
    protected int guiLeft;
    protected int guiTop;
    private Slot theSlot;
    private Slot clickedSlot;
    private boolean isRightMouseClick;
    private ItemStack draggedStack;
    private int touchUpX;
    private int touchUpY;
    private Slot returningStackDestSlot;
    private long returningStackTime;
    private ItemStack returningStack;
    private Slot currentDragTargetSlot;
    private long dragItemDropDelay;
    protected final Set<Slot> dragSplittingSlots = Sets.newHashSet();
    protected boolean dragSplitting;
    private int dragSplittingLimit;
    private int dragSplittingButton;
    private boolean ignoreMouseUp;
    private int dragSplittingRemnant;
    private long lastClickTime;
    private Slot lastClickSlot;
    private int lastClickButton;
    private boolean doubleClick;
    private ItemStack shiftClickedSlot;

    public GuiContainer(Container container) {
        this.inventorySlots = container;
        this.ignoreMouseUp = true;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.mc.thePlayer.openContainer = this.inventorySlots;
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3;
        int n4;
        Object object;
        this.drawDefaultBackground();
        int n5 = this.guiLeft;
        int n6 = this.guiTop;
        this.drawGuiContainerBackgroundLayer(f, n, n2);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        super.drawScreen(n, n2, f);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.pushMatrix();
        GlStateManager.translate(n5, n6, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableRescaleNormal();
        this.theSlot = null;
        int n7 = 240;
        int n8 = 240;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)n7 / 1.0f, (float)n8 / 1.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i) {
            object = this.inventorySlots.inventorySlots.get(i);
            this.drawSlot((Slot)object);
            int n9 = n4 = this.isMouseOverSlot((Slot)object, n, n2) && ((Slot)object).canBeHovered() ? 1 : 0;
            if (n4 != 0) {
                this.theSlot = object;
            }
            if (n4 == 0 && !this.isAutomatedSlotHighlighted((Slot)object)) continue;
            this.drawSlotHighlight((Slot)object);
        }
        RenderHelper.disableStandardItemLighting();
        this.drawGuiContainerForegroundLayer(n, n2);
        RenderHelper.enableGUIStandardItemLighting();
        InventoryPlayer inventoryPlayer = this.mc.thePlayer.inventory;
        Object object2 = object = this.draggedStack == null ? inventoryPlayer.getItemStack() : this.draggedStack;
        if (object != null) {
            n4 = 8;
            n3 = this.draggedStack == null ? 8 : 16;
            String string = null;
            if (this.draggedStack != null && this.isRightMouseClick) {
                object = ((ItemStack)object).copy();
                ((ItemStack)object).stackSize = MathHelper.ceiling_float_int((float)((ItemStack)object).stackSize / 2.0f);
            } else if (this.dragSplitting && this.dragSplittingSlots.size() > 1) {
                object = ((ItemStack)object).copy();
                ((ItemStack)object).stackSize = this.dragSplittingRemnant;
                if (((ItemStack)object).stackSize == 0) {
                    string = String.valueOf((Object)EnumChatFormatting.YELLOW) + "0";
                }
            }
            this.drawItemStack((ItemStack)object, n - n5 - n4, n2 - n6 - n3, string);
        }
        if (this.returningStack != null) {
            float f2 = (float)(Minecraft.getSystemTime() - this.returningStackTime) / 100.0f;
            if (f2 >= 1.0f) {
                f2 = 1.0f;
                this.returningStack = null;
            }
            n3 = this.returningStackDestSlot.xDisplayPosition - this.touchUpX;
            int n10 = this.returningStackDestSlot.yDisplayPosition - this.touchUpY;
            int n11 = this.touchUpX + (int)((float)n3 * f2);
            int n12 = this.touchUpY + (int)((float)n10 * f2);
            this.drawItemStack(this.returningStack, n11, n12, null);
        }
        GlStateManager.popMatrix();
        if (inventoryPlayer.getItemStack() == null && this.theSlot != null && this.theSlot.getHasStack()) {
            ItemStack itemStack = this.theSlot.getStack();
            this.renderToolTip(itemStack, n, n2);
        }
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
    }

    private boolean isAutomatedSlotHighlighted(Slot slot) {
        if (!slot.canBeHovered()) {
            return false;
        }
        int n = this.inventorySlots.windowId;
        return oc9755810e45.\u04e5 != null && oc9755810e45.\u04e5.T(n, slot.slotNumber) || oc9755810e45.\u017c != null && oc9755810e45.\u017c.\u0568(n, slot.slotNumber);
    }

    private void drawSlotHighlight(Slot slot) {
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        int n = slot.xDisplayPosition;
        int n2 = slot.yDisplayPosition;
        GlStateManager.colorMask(true, true, true, false);
        this.drawGradientRect(n, n2, n + 16, n2 + 16, -2130706433, -2130706433);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
    }

    private void drawItemStack(ItemStack itemStack, int n, int n2, String string) {
        GlStateManager.translate(0.0f, 0.0f, 32.0f);
        this.zLevel = 200.0f;
        this.itemRender.zLevel = 200.0f;
        this.itemRender.renderItemAndEffectIntoGUI(itemStack, n, n2);
        this.itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, itemStack, n, n2 - (this.draggedStack == null ? 0 : 8), string);
        this.zLevel = 0.0f;
        this.itemRender.zLevel = 0.0f;
    }

    protected void drawGuiContainerForegroundLayer(int n, int n2) {
    }

    protected abstract void drawGuiContainerBackgroundLayer(float var1, int var2, int var3);

    private void drawSlot(Slot slot) {
        String string;
        int n = slot.xDisplayPosition;
        int n2 = slot.yDisplayPosition;
        ItemStack itemStack = slot.getStack();
        boolean bl = false;
        boolean bl2 = slot == this.clickedSlot && this.draggedStack != null && !this.isRightMouseClick;
        ItemStack itemStack2 = this.mc.thePlayer.inventory.getItemStack();
        String string2 = null;
        if (slot == this.clickedSlot && this.draggedStack != null && this.isRightMouseClick && itemStack != null) {
            itemStack = itemStack.copy();
            itemStack.stackSize /= 2;
        } else if (this.dragSplitting && this.dragSplittingSlots.contains(slot) && itemStack2 != null) {
            if (this.dragSplittingSlots.size() == 1) {
                return;
            }
            if (Container.canAddItemToSlot(slot, itemStack2, true) && this.inventorySlots.canDragIntoSlot(slot)) {
                itemStack = itemStack2.copy();
                bl = true;
                Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, itemStack, slot.getStack() == null ? 0 : slot.getStack().stackSize);
                if (itemStack.stackSize > itemStack.getMaxStackSize()) {
                    string2 = String.valueOf((Object)EnumChatFormatting.YELLOW) + itemStack.getMaxStackSize();
                    itemStack.stackSize = itemStack.getMaxStackSize();
                }
                if (itemStack.stackSize > slot.getItemStackLimit(itemStack)) {
                    string2 = String.valueOf((Object)EnumChatFormatting.YELLOW) + slot.getItemStackLimit(itemStack);
                    itemStack.stackSize = slot.getItemStackLimit(itemStack);
                }
            } else {
                this.dragSplittingSlots.remove(slot);
                this.updateDragSplitting();
            }
        }
        this.zLevel = 100.0f;
        this.itemRender.zLevel = 100.0f;
        if (itemStack == null && (string = slot.getSlotTexture()) != null) {
            TextureAtlasSprite textureAtlasSprite = this.mc.getTextureMapBlocks().getAtlasSprite(string);
            GlStateManager.disableLighting();
            this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            this.drawTexturedModalRect(n, n2, textureAtlasSprite, 16, 16);
            GlStateManager.enableLighting();
            bl2 = true;
        }
        if (!bl2) {
            if (bl) {
                GuiContainer.drawRect(n, n2, n + 16, n2 + 16, -2130706433);
            }
            GlStateManager.enableDepth();
            this.itemRender.renderItemAndEffectIntoGUI(itemStack, n, n2);
            this.itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, itemStack, n, n2, string2);
        }
        this.itemRender.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }

    private void updateDragSplitting() {
        ItemStack itemStack = this.mc.thePlayer.inventory.getItemStack();
        if (itemStack != null && this.dragSplitting) {
            this.dragSplittingRemnant = itemStack.stackSize;
            for (Slot slot : this.dragSplittingSlots) {
                ItemStack itemStack2 = itemStack.copy();
                int n = slot.getStack() == null ? 0 : slot.getStack().stackSize;
                Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, itemStack2, n);
                if (itemStack2.stackSize > itemStack2.getMaxStackSize()) {
                    itemStack2.stackSize = itemStack2.getMaxStackSize();
                }
                if (itemStack2.stackSize > slot.getItemStackLimit(itemStack2)) {
                    itemStack2.stackSize = slot.getItemStackLimit(itemStack2);
                }
                this.dragSplittingRemnant -= itemStack2.stackSize - n;
            }
        }
    }

    private Slot getSlotAtPosition(int n, int n2) {
        for (int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i) {
            Slot slot = this.inventorySlots.inventorySlots.get(i);
            if (!this.isMouseOverSlot(slot, n, n2)) continue;
            return slot;
        }
        return null;
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        super.mouseClicked(n, n2, n3);
        boolean bl = n3 == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100;
        Slot slot = this.getSlotAtPosition(n, n2);
        long l = Minecraft.getSystemTime();
        this.doubleClick = this.lastClickSlot == slot && l - this.lastClickTime < 250L && this.lastClickButton == n3;
        this.ignoreMouseUp = false;
        if (n3 == 0 || n3 == 1 || bl) {
            int n4 = this.guiLeft;
            int n5 = this.guiTop;
            boolean bl2 = n < n4 || n2 < n5 || n >= n4 + this.xSize || n2 >= n5 + this.ySize;
            int n6 = -1;
            if (slot != null) {
                n6 = slot.slotNumber;
            }
            if (bl2) {
                n6 = -999;
            }
            if (this.mc.gameSettings.touchscreen && bl2 && this.mc.thePlayer.inventory.getItemStack() == null) {
                this.mc.displayGuiScreen(null);
                return;
            }
            if (n6 != -1) {
                if (this.mc.gameSettings.touchscreen) {
                    if (slot != null && slot.getHasStack()) {
                        this.clickedSlot = slot;
                        this.draggedStack = null;
                        this.isRightMouseClick = n3 == 1;
                    } else {
                        this.clickedSlot = null;
                    }
                } else if (!this.dragSplitting) {
                    if (this.mc.thePlayer.inventory.getItemStack() == null) {
                        if (n3 == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                            this.handleMouseClick(slot, n6, n3, 3);
                        } else {
                            boolean bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            int n7 = 0;
                            if (bl3) {
                                this.shiftClickedSlot = slot != null && slot.getHasStack() ? slot.getStack() : null;
                                n7 = 1;
                            } else if (n6 == -999) {
                                n7 = 4;
                            }
                            this.handleMouseClick(slot, n6, n3, n7);
                        }
                        this.ignoreMouseUp = true;
                    } else {
                        this.dragSplitting = true;
                        this.dragSplittingButton = n3;
                        this.dragSplittingSlots.clear();
                        if (n3 == 0) {
                            this.dragSplittingLimit = 0;
                        } else if (n3 == 1) {
                            this.dragSplittingLimit = 1;
                        } else if (n3 == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                            this.dragSplittingLimit = 2;
                        }
                    }
                }
            }
        }
        this.lastClickSlot = slot;
        this.lastClickTime = l;
        this.lastClickButton = n3;
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        Slot slot = this.getSlotAtPosition(n, n2);
        ItemStack itemStack = this.mc.thePlayer.inventory.getItemStack();
        if (this.clickedSlot != null && this.mc.gameSettings.touchscreen) {
            if (n3 == 0 || n3 == 1) {
                if (this.draggedStack == null) {
                    if (slot != this.clickedSlot && this.clickedSlot.getStack() != null) {
                        this.draggedStack = this.clickedSlot.getStack().copy();
                    }
                } else if (this.draggedStack.stackSize > 1 && slot != null && Container.canAddItemToSlot(slot, this.draggedStack, false)) {
                    long l2 = Minecraft.getSystemTime();
                    if (this.currentDragTargetSlot == slot) {
                        if (l2 - this.dragItemDropDelay > 500L) {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, 0);
                            this.handleMouseClick(slot, slot.slotNumber, 1, 0);
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, 0);
                            this.dragItemDropDelay = l2 + 750L;
                            --this.draggedStack.stackSize;
                        }
                    } else {
                        this.currentDragTargetSlot = slot;
                        this.dragItemDropDelay = l2;
                    }
                }
            }
        } else if (this.dragSplitting && slot != null && itemStack != null && itemStack.stackSize > this.dragSplittingSlots.size() && Container.canAddItemToSlot(slot, itemStack, true) && slot.isItemValid(itemStack) && this.inventorySlots.canDragIntoSlot(slot)) {
            this.dragSplittingSlots.add(slot);
            this.updateDragSplitting();
        }
    }

    @Override
    protected void mouseReleased(int n, int n2, int n3) {
        Slot slot = this.getSlotAtPosition(n, n2);
        int n4 = this.guiLeft;
        int n5 = this.guiTop;
        boolean bl = n < n4 || n2 < n5 || n >= n4 + this.xSize || n2 >= n5 + this.ySize;
        int n6 = -1;
        if (slot != null) {
            n6 = slot.slotNumber;
        }
        if (bl) {
            n6 = -999;
        }
        if (this.doubleClick && slot != null && n3 == 0 && this.inventorySlots.canMergeSlot(null, slot)) {
            if (GuiContainer.isShiftKeyDown()) {
                if (slot != null && slot.inventory != null && this.shiftClickedSlot != null) {
                    for (Slot slot2 : this.inventorySlots.inventorySlots) {
                        if (slot2 == null || !slot2.canTakeStack(this.mc.thePlayer) || !slot2.getHasStack() || slot2.inventory != slot.inventory || !Container.canAddItemToSlot(slot2, this.shiftClickedSlot, true)) continue;
                        this.handleMouseClick(slot2, slot2.slotNumber, n3, 1);
                    }
                }
            } else {
                this.handleMouseClick(slot, n6, n3, 6);
            }
            this.doubleClick = false;
            this.lastClickTime = 0L;
        } else {
            if (this.dragSplitting && this.dragSplittingButton != n3) {
                this.dragSplitting = false;
                this.dragSplittingSlots.clear();
                this.ignoreMouseUp = true;
                return;
            }
            if (this.ignoreMouseUp) {
                this.ignoreMouseUp = false;
                return;
            }
            if (this.clickedSlot != null && this.mc.gameSettings.touchscreen) {
                if (n3 == 0 || n3 == 1) {
                    if (this.draggedStack == null && slot != this.clickedSlot) {
                        this.draggedStack = this.clickedSlot.getStack();
                    }
                    boolean bl2 = Container.canAddItemToSlot(slot, this.draggedStack, false);
                    if (n6 != -1 && this.draggedStack != null && bl2) {
                        this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, n3, 0);
                        this.handleMouseClick(slot, n6, 0, 0);
                        if (this.mc.thePlayer.inventory.getItemStack() != null) {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, n3, 0);
                            this.touchUpX = n - n4;
                            this.touchUpY = n2 - n5;
                            this.returningStackDestSlot = this.clickedSlot;
                            this.returningStack = this.draggedStack;
                            this.returningStackTime = Minecraft.getSystemTime();
                        } else {
                            this.returningStack = null;
                        }
                    } else if (this.draggedStack != null) {
                        this.touchUpX = n - n4;
                        this.touchUpY = n2 - n5;
                        this.returningStackDestSlot = this.clickedSlot;
                        this.returningStack = this.draggedStack;
                        this.returningStackTime = Minecraft.getSystemTime();
                    }
                    this.draggedStack = null;
                    this.clickedSlot = null;
                }
            } else if (this.dragSplitting && !this.dragSplittingSlots.isEmpty()) {
                this.handleMouseClick(null, -999, Container.func_94534_d(0, this.dragSplittingLimit), 5);
                for (Slot slot3 : this.dragSplittingSlots) {
                    this.handleMouseClick(slot3, slot3.slotNumber, Container.func_94534_d(1, this.dragSplittingLimit), 5);
                }
                this.handleMouseClick(null, -999, Container.func_94534_d(2, this.dragSplittingLimit), 5);
            } else if (this.mc.thePlayer.inventory.getItemStack() != null) {
                if (n3 == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                    this.handleMouseClick(slot, n6, n3, 3);
                } else {
                    boolean bl3;
                    boolean bl4 = bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                    if (bl3) {
                        this.shiftClickedSlot = slot != null && slot.getHasStack() ? slot.getStack() : null;
                    }
                    this.handleMouseClick(slot, n6, n3, bl3 ? 1 : 0);
                }
            }
        }
        if (this.mc.thePlayer.inventory.getItemStack() == null) {
            this.lastClickTime = 0L;
        }
        this.dragSplitting = false;
    }

    private boolean isMouseOverSlot(Slot slot, int n, int n2) {
        return this.isPointInRegion(slot.xDisplayPosition, slot.yDisplayPosition, 16, 16, n, n2);
    }

    protected boolean isPointInRegion(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.guiLeft;
        int n8 = this.guiTop;
        return (n5 -= n7) >= n - 1 && n5 < n + n3 + 1 && (n6 -= n8) >= n2 - 1 && n6 < n2 + n4 + 1;
    }

    public final void clickSlot(int n, int n2, int n3) {
        this.handleMouseClick(null, n, n2, n3);
    }

    protected void handleMouseClick(Slot slot, int n, int n2, int n3) {
        if (slot != null) {
            n = slot.slotNumber;
        }
        this.mc.playerController.windowClick(this.inventorySlots.windowId, n, n2, n3, this.mc.thePlayer);
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (n == 1 || n == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.thePlayer.closeScreen();
        }
        this.checkHotbarKeys(n);
        if (this.theSlot != null && this.theSlot.getHasStack()) {
            if (n == this.mc.gameSettings.keyBindPickBlock.getKeyCode()) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, 0, 3);
            } else if (n == this.mc.gameSettings.keyBindDrop.getKeyCode()) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, GuiContainer.isCtrlKeyDown() ? 1 : 0, 4);
            }
        }
    }

    protected boolean checkHotbarKeys(int n) {
        if (this.mc.thePlayer.inventory.getItemStack() == null && this.theSlot != null) {
            for (int i = 0; i < 9; ++i) {
                if (n != this.mc.gameSettings.keyBindsHotbar[i].getKeyCode()) continue;
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, i, 2);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onGuiClosed() {
        if (this.mc.thePlayer != null) {
            this.inventorySlots.onContainerClosed(this.mc.thePlayer);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead) {
            this.mc.thePlayer.closeScreen();
        }
    }
}

