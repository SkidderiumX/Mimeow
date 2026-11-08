/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.realms.RealmsClickableScrolledSelectionList;
import net.minecraft.realms.Tezzelator;
import org.lwjgl.input.Mouse;

public class GuiClickableScrolledSelectionListProxy
extends GuiSlot {
    private final RealmsClickableScrolledSelectionList field_178046_u;

    public GuiClickableScrolledSelectionListProxy(RealmsClickableScrolledSelectionList realmsClickableScrolledSelectionList, int n, int n2, int n3, int n4, int n5) {
        super(Minecraft.getMinecraft(), n, n2, n3, n4, n5);
        this.field_178046_u = realmsClickableScrolledSelectionList;
    }

    @Override
    protected int getSize() {
        return this.field_178046_u.getItemCount();
    }

    @Override
    protected void elementClicked(int n, boolean bl, int n2, int n3) {
        this.field_178046_u.selectItem(n, bl, n2, n3);
    }

    @Override
    protected boolean isSelected(int n) {
        return this.field_178046_u.isSelectedItem(n);
    }

    @Override
    protected void drawBackground() {
        this.field_178046_u.renderBackground();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
        this.field_178046_u.renderItem(n, n2, n3, n4, n5, n6);
    }

    public int func_178044_e() {
        return this.width;
    }

    public int func_178042_f() {
        return this.mouseY;
    }

    public int func_178045_g() {
        return this.mouseX;
    }

    @Override
    protected int getContentHeight() {
        return this.field_178046_u.getMaxPosition();
    }

    @Override
    protected int getScrollBarX() {
        return this.field_178046_u.getScrollbarPosition();
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        if (this.scrollMultiplier > 0.0f && Mouse.getEventButtonState()) {
            this.field_178046_u.customMouseEvent(this.top, this.bottom, this.headerPadding, this.amountScrolled, this.slotHeight);
        }
    }

    public void func_178043_a(int n, int n2, int n3, Tezzelator tezzelator) {
        this.field_178046_u.renderSelected(n, n2, n3, tezzelator);
    }

    @Override
    protected void drawSelectionBox(int n, int n2, int n3, int n4) {
        int n5 = this.getSize();
        for (int i = 0; i < n5; ++i) {
            int n6 = n2 + i * this.slotHeight + this.headerPadding;
            int n7 = this.slotHeight - 4;
            if (n6 > this.bottom || n6 + n7 < this.top) {
                this.func_178040_a(i, n, n6);
            }
            if (this.showSelectionBox && this.isSelected(i)) {
                this.func_178043_a(this.width, n6, n7, Tezzelator.instance);
            }
            this.drawSlot(i, n, n6, n7, n3, n4);
        }
    }
}

