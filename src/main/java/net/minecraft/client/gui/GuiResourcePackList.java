/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.ResourcePackListEntry;
import net.minecraft.util.EnumChatFormatting;

public abstract class GuiResourcePackList
extends GuiListExtended {
    protected final Minecraft mc;
    protected final List<ResourcePackListEntry> field_148204_l;

    public GuiResourcePackList(Minecraft minecraft, int n, int n2, List<ResourcePackListEntry> list) {
        super(minecraft, n, n2, 32, n2 - 55 + 4, 36);
        this.mc = minecraft;
        this.field_148204_l = list;
        this.field_148163_i = false;
        this.setHasListHeader(true, (int)((float)minecraft.fontRendererObj.FONT_HEIGHT * 1.5f));
    }

    @Override
    protected void drawListHeader(int n, int n2, Tessellator tessellator) {
        String string = String.valueOf((Object)EnumChatFormatting.UNDERLINE) + String.valueOf((Object)EnumChatFormatting.BOLD) + this.getListHeader();
        this.mc.fontRendererObj.drawString(string, n + this.width / 2 - this.mc.fontRendererObj.getStringWidth(string) / 2, Math.min(this.top + 3, n2), 0xFFFFFF);
    }

    protected abstract String getListHeader();

    public List<ResourcePackListEntry> getList() {
        return this.field_148204_l;
    }

    @Override
    protected int getSize() {
        return this.getList().size();
    }

    @Override
    public ResourcePackListEntry getListEntry(int n) {
        return this.getList().get(n);
    }

    @Override
    public int getListWidth() {
        return this.width;
    }

    @Override
    protected int getScrollBarX() {
        return this.right - 6;
    }
}

