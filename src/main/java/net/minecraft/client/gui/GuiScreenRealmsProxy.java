/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonRealmsProxy;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;

public class GuiScreenRealmsProxy
extends GuiScreen {
    private RealmsScreen field_154330_a;

    public GuiScreenRealmsProxy(RealmsScreen realmsScreen) {
        this.field_154330_a = realmsScreen;
        this.buttonList = Collections.synchronizedList(Lists.newArrayList());
    }

    public RealmsScreen func_154321_a() {
        return this.field_154330_a;
    }

    @Override
    public void initGui() {
        this.field_154330_a.init();
        super.initGui();
    }

    public void func_154325_a(String string, int n, int n2, int n3) {
        super.drawCenteredString(this.fontRendererObj, string, n, n2, n3);
    }

    public void func_154322_b(String string, int n, int n2, int n3, boolean bl) {
        if (bl) {
            super.drawString(this.fontRendererObj, string, n, n2, n3);
        } else {
            this.fontRendererObj.drawString(string, n, n2, n3);
        }
    }

    @Override
    public void drawTexturedModalRect(int n, int n2, int n3, int n4, int n5, int n6) {
        this.field_154330_a.blit(n, n2, n3, n4, n5, n6);
        super.drawTexturedModalRect(n, n2, n3, n4, n5, n6);
    }

    @Override
    public void drawGradientRect(int n, int n2, int n3, int n4, int n5, int n6) {
        super.drawGradientRect(n, n2, n3, n4, n5, n6);
    }

    @Override
    public void drawDefaultBackground() {
        super.drawDefaultBackground();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return super.doesGuiPauseGame();
    }

    @Override
    public void drawWorldBackground(int n) {
        super.drawWorldBackground(n);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.field_154330_a.render(n, n2, f);
    }

    @Override
    public void renderToolTip(ItemStack itemStack, int n, int n2) {
        super.renderToolTip(itemStack, n, n2);
    }

    @Override
    public void drawCreativeTabHoveringText(String string, int n, int n2) {
        super.drawCreativeTabHoveringText(string, n, n2);
    }

    @Override
    public void drawHoveringText(List<String> list, int n, int n2) {
        super.drawHoveringText(list, n, n2);
    }

    @Override
    public void updateScreen() {
        this.field_154330_a.tick();
        super.updateScreen();
    }

    public int func_154329_h() {
        return this.fontRendererObj.FONT_HEIGHT;
    }

    public int func_154326_c(String string) {
        return this.fontRendererObj.getStringWidth(string);
    }

    public void func_154319_c(String string, int n, int n2, int n3) {
        this.fontRendererObj.drawStringWithShadow(string, n, n2, n3);
    }

    public List<String> func_154323_a(String string, int n) {
        return this.fontRendererObj.listFormattedStringToWidth(string, n);
    }

    @Override
    public final void actionPerformed(GuiButton guiButton) throws IOException {
        this.field_154330_a.buttonClicked(((GuiButtonRealmsProxy)guiButton).getRealmsButton());
    }

    public void func_154324_i() {
        this.buttonList.clear();
    }

    public void func_154327_a(RealmsButton realmsButton) {
        this.buttonList.add(realmsButton.getProxy());
    }

    public List<RealmsButton> func_154320_j() {
        ArrayList<RealmsButton> arrayList = Lists.newArrayListWithExpectedSize(this.buttonList.size());
        for (GuiButton guiButton : this.buttonList) {
            arrayList.add(((GuiButtonRealmsProxy)guiButton).getRealmsButton());
        }
        return arrayList;
    }

    public void func_154328_b(RealmsButton realmsButton) {
        this.buttonList.remove(realmsButton.getProxy());
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) throws IOException {
        this.field_154330_a.mouseClicked(n, n2, n3);
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void handleMouseInput() throws IOException {
        this.field_154330_a.mouseEvent();
        super.handleMouseInput();
    }

    @Override
    public void handleKeyboardInput() throws IOException {
        this.field_154330_a.keyboardEvent();
        super.handleKeyboardInput();
    }

    @Override
    public void mouseReleased(int n, int n2, int n3) {
        this.field_154330_a.mouseReleased(n, n2, n3);
    }

    @Override
    public void mouseClickMove(int n, int n2, int n3, long l) {
        this.field_154330_a.mouseDragged(n, n2, n3, l);
    }

    @Override
    public void keyTyped(char c, int n) throws IOException {
        this.field_154330_a.keyPressed(c, n);
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        this.field_154330_a.confirmResult(bl, n);
    }

    @Override
    public void onGuiClosed() {
        this.field_154330_a.removed();
        super.onGuiClosed();
    }
}

