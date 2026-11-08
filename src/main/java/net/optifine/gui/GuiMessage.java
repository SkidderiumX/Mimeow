/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.gui;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.src.Config;

public class GuiMessage
extends GuiScreen {
    private GuiScreen parentScreen;
    private String messageLine1;
    private String messageLine2;
    private final List listLines2 = Lists.newArrayList();
    protected String confirmButtonText;
    private int ticksUntilEnable;

    public GuiMessage(GuiScreen guiScreen, String string, String string2) {
        this.parentScreen = guiScreen;
        this.messageLine1 = string;
        this.messageLine2 = string2;
        this.confirmButtonText = I18n.format("gui.done", new Object[0]);
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(0, this.width / 2 - 74, this.height / 6 + 96, this.confirmButtonText));
        this.listLines2.clear();
        this.listLines2.addAll(this.fontRendererObj.listFormattedStringToWidth(this.messageLine2, this.width - 50));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        Config.getMinecraft().displayGuiScreen(this.parentScreen);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.messageLine1, this.width / 2, 70, 0xFFFFFF);
        int n3 = 90;
        for (Object e : this.listLines2) {
            this.drawCenteredString(this.fontRendererObj, (String)e, this.width / 2, n3, 0xFFFFFF);
            n3 += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(n, n2, f);
    }

    public void setButtonDelay(int n) {
        this.ticksUntilEnable = n;
        for (GuiButton guiButton : this.buttonList) {
            guiButton.enabled = false;
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (--this.ticksUntilEnable == 0) {
            for (GuiButton guiButton : this.buttonList) {
                guiButton.enabled = true;
            }
        }
    }
}

