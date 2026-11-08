/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.optifine.gui.GuiButtonOF;
import net.optifine.gui.GuiScreenCapeOF;

public class GuiCustomizeSkin
extends GuiScreen {
    private final GuiScreen parentScreen;
    private String title;

    public GuiCustomizeSkin(GuiScreen guiScreen) {
        this.parentScreen = guiScreen;
    }

    @Override
    public void initGui() {
        int n = 0;
        this.title = I18n.format("options.skinCustomisation.title", new Object[0]);
        for (EnumPlayerModelParts enumPlayerModelParts : EnumPlayerModelParts.values()) {
            this.buttonList.add(new ButtonPart(enumPlayerModelParts.getPartId(), this.width / 2 - 155 + n % 2 * 160, this.height / 6 + 24 * (n >> 1), 150, 20, enumPlayerModelParts));
            ++n;
        }
        if (n % 2 == 1) {
            ++n;
        }
        this.buttonList.add(new GuiButtonOF(210, this.width / 2 - 100, this.height / 6 + 24 * (n >> 1), I18n.format("of.options.skinCustomisation.ofCape", new Object[0])));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 24 * ((n += 2) >> 1), I18n.format("gui.done", new Object[0])));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.enabled) {
            if (guiButton.id == 210) {
                this.mc.displayGuiScreen(new GuiScreenCapeOF(this));
            }
            if (guiButton.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            } else if (guiButton instanceof ButtonPart) {
                EnumPlayerModelParts enumPlayerModelParts = ((ButtonPart)guiButton).playerModelParts;
                this.mc.gameSettings.switchModelPartEnabled(enumPlayerModelParts);
                guiButton.displayString = this.func_175358_a(enumPlayerModelParts);
            }
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    private String func_175358_a(EnumPlayerModelParts enumPlayerModelParts) {
        String string = this.mc.gameSettings.getModelParts().contains((Object)enumPlayerModelParts) ? I18n.format("options.on", new Object[0]) : I18n.format("options.off", new Object[0]);
        return enumPlayerModelParts.func_179326_d().getFormattedText() + ": " + string;
    }

    public class ButtonPart
    extends GuiButton {
        private final EnumPlayerModelParts playerModelParts;

        private ButtonPart(int n, int n2, int n3, int n4, int n5, EnumPlayerModelParts enumPlayerModelParts) {
            super(n, n2, n3, n4, n5, GuiCustomizeSkin.this.func_175358_a(enumPlayerModelParts));
            this.playerModelParts = enumPlayerModelParts;
        }
    }
}

