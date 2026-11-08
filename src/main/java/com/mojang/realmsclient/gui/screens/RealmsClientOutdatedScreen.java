/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.gui.RealmsConstants;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;

public class RealmsClientOutdatedScreen
extends RealmsScreen {
    private static final int BUTTON_BACK_ID = 0;
    private final RealmsScreen lastScreen;
    private final boolean outdated;

    public RealmsClientOutdatedScreen(RealmsScreen realmsScreen, boolean bl) {
        this.lastScreen = realmsScreen;
        this.outdated = bl;
    }

    @Override
    public void init() {
        this.buttonsClear();
        this.buttonsAdd(RealmsClientOutdatedScreen.newButton(0, this.width() / 2 - 100, RealmsConstants.row(12), "Back"));
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        String string = this.outdated ? RealmsClientOutdatedScreen.getLocalizedString("mco.client.outdated.title") : RealmsClientOutdatedScreen.getLocalizedString("mco.client.incompatible.title");
        String string2 = this.outdated ? RealmsClientOutdatedScreen.getLocalizedString("mco.client.outdated.msg") : RealmsClientOutdatedScreen.getLocalizedString("mco.client.incompatible.msg");
        this.drawCenteredString(string, this.width() / 2, RealmsConstants.row(3), 0xFF0000);
        String[] stringArray = string2.split("\\\\n");
        int n3 = 0;
        for (String string3 : stringArray) {
            this.drawCenteredString(string3, this.width() / 2, RealmsConstants.row(5) + n3 * 12, 0xFFFFFF);
            ++n3;
        }
        super.render(n, n2, f);
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (realmsButton.id() == 0) {
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 28 || n == 156 || n == 1) {
            Realms.setScreen(this.lastScreen);
        }
    }
}

