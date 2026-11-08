/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.gui;

import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiVideoSettings;

public class GuiScreenOF
extends GuiScreen {
    protected void actionPerformedRightClick(GuiButton guiButton) throws IOException {
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        GuiButton guiButton;
        super.mouseClicked(n, n2, n3);
        if (n3 == 1 && (guiButton = GuiScreenOF.getSelectedButton(n, n2, this.buttonList)) != null && guiButton.enabled) {
            guiButton.playPressSound(this.mc.getSoundHandler());
            this.actionPerformedRightClick(guiButton);
        }
    }

    public static GuiButton getSelectedButton(int n, int n2, List<GuiButton> list) {
        for (int i = 0; i < list.size(); ++i) {
            GuiButton guiButton = list.get(i);
            if (!guiButton.visible) continue;
            int n3 = GuiVideoSettings.getButtonWidth(guiButton);
            int n4 = GuiVideoSettings.getButtonHeight(guiButton);
            if (n < guiButton.xPosition || n2 < guiButton.yPosition || n >= guiButton.xPosition + n3 || n2 >= guiButton.yPosition + n4) continue;
            return guiButton;
        }
        return null;
    }
}

