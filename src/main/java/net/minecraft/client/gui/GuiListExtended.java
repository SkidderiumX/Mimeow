/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;

public abstract class GuiListExtended
extends GuiSlot {
    public GuiListExtended(Minecraft minecraft, int n, int n2, int n3, int n4, int n5) {
        super(minecraft, n, n2, n3, n4, n5);
    }

    @Override
    protected void elementClicked(int n, boolean bl, int n2, int n3) {
    }

    @Override
    protected boolean isSelected(int n) {
        return false;
    }

    @Override
    protected void drawBackground() {
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
        this.getListEntry(n).drawEntry(n, n2, n3, this.getListWidth(), n4, n5, n6, this.getSlotIndexFromScreenCoords(n5, n6) == n);
    }

    @Override
    protected void func_178040_a(int n, int n2, int n3) {
        this.getListEntry(n).setSelected(n, n2, n3);
    }

    public boolean mouseClicked(int n, int n2, int n3) {
        int n4;
        if (this.isMouseYWithinSlotBounds(n2) && (n4 = this.getSlotIndexFromScreenCoords(n, n2)) >= 0) {
            int n5 = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            int n6 = this.top + 4 - this.getAmountScrolled() + n4 * this.slotHeight + this.headerPadding;
            int n7 = n - n5;
            int n8 = n2 - n6;
            if (this.getListEntry(n4).mousePressed(n4, n, n2, n3, n7, n8)) {
                this.setEnabled(false);
                return true;
            }
        }
        return false;
    }

    public boolean mouseReleased(int n, int n2, int n3) {
        for (int i = 0; i < this.getSize(); ++i) {
            int n4 = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            int n5 = this.top + 4 - this.getAmountScrolled() + i * this.slotHeight + this.headerPadding;
            int n6 = n - n4;
            int n7 = n2 - n5;
            this.getListEntry(i).mouseReleased(i, n, n2, n3, n6, n7);
        }
        this.setEnabled(true);
        return false;
    }

    public abstract IGuiListEntry getListEntry(int var1);

    public static interface IGuiListEntry {
        public void setSelected(int var1, int var2, int var3);

        public void drawEntry(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8);

        public boolean mousePressed(int var1, int var2, int var3, int var4, int var5, int var6);

        public void mouseReleased(int var1, int var2, int var3, int var4, int var5, int var6);
    }
}

