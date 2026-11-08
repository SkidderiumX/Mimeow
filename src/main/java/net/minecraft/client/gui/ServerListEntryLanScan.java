/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.resources.I18n;

public class ServerListEntryLanScan
implements GuiListExtended.IGuiListEntry {
    private final Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void drawEntry(int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
        int n8 = n3 + n5 / 2 - this.mc.fontRendererObj.FONT_HEIGHT / 2;
        this.mc.fontRendererObj.drawString(I18n.format("lanServer.scanning", new Object[0]), this.mc.currentScreen.width / 2 - this.mc.fontRendererObj.getStringWidth(I18n.format("lanServer.scanning", new Object[0])) / 2, n8, 0xFFFFFF);
        String string = switch ((int)(Minecraft.getSystemTime() / 300L % 4L)) {
            default -> "O o o";
            case 1, 3 -> "o O o";
            case 2 -> "o o O";
        };
        this.mc.fontRendererObj.drawString(string, this.mc.currentScreen.width / 2 - this.mc.fontRendererObj.getStringWidth(string) / 2, n8 + this.mc.fontRendererObj.FONT_HEIGHT, 0x808080);
    }

    @Override
    public void setSelected(int n, int n2, int n3) {
    }

    @Override
    public boolean mousePressed(int n, int n2, int n3, int n4, int n5, int n6) {
        return false;
    }

    @Override
    public void mouseReleased(int n, int n2, int n3, int n4, int n5, int n6) {
    }
}

