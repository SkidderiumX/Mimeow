/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.realms;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonRealmsProxy;
import net.minecraft.util.ResourceLocation;

public class RealmsButton {
    protected static final ResourceLocation WIDGETS_LOCATION = new ResourceLocation("textures/gui/widgets.png");
    private GuiButtonRealmsProxy proxy;

    public RealmsButton(int n, int n2, int n3, String string) {
        this.proxy = new GuiButtonRealmsProxy(this, n, n2, n3, string);
    }

    public RealmsButton(int n, int n2, int n3, int n4, int n5, String string) {
        this.proxy = new GuiButtonRealmsProxy(this, n, n2, n3, string, n4, n5);
    }

    public GuiButton getProxy() {
        return this.proxy;
    }

    public int id() {
        return this.proxy.getId();
    }

    public boolean active() {
        return this.proxy.getEnabled();
    }

    public void active(boolean bl) {
        this.proxy.setEnabled(bl);
    }

    public void msg(String string) {
        this.proxy.setText(string);
    }

    public int getWidth() {
        return this.proxy.getButtonWidth();
    }

    public int getHeight() {
        return this.proxy.getHeight();
    }

    public int y() {
        return this.proxy.getPositionY();
    }

    public void render(int n, int n2) {
        this.proxy.drawButton(Minecraft.getMinecraft(), n, n2);
    }

    public void clicked(int n, int n2) {
    }

    public void released(int n, int n2) {
    }

    public void blit(int n, int n2, int n3, int n4, int n5, int n6) {
        this.proxy.drawTexturedModalRect(n, n2, n3, n4, n5, n6);
    }

    public void renderBg(int n, int n2) {
    }

    public int getYImage(boolean bl) {
        return this.proxy.func_154312_c(bl);
    }
}

