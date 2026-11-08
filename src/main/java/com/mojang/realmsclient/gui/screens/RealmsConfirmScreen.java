/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.gui.RealmsConstants;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;

public class RealmsConfirmScreen
extends RealmsScreen {
    protected RealmsScreen parent;
    protected String title1;
    private String title2;
    protected String yesButton;
    protected String noButton;
    protected int id;
    private int delayTicker;

    public RealmsConfirmScreen(RealmsScreen realmsScreen, String string, String string2, int n) {
        this.parent = realmsScreen;
        this.title1 = string;
        this.title2 = string2;
        this.id = n;
        this.yesButton = RealmsConfirmScreen.getLocalizedString("gui.yes");
        this.noButton = RealmsConfirmScreen.getLocalizedString("gui.no");
    }

    public RealmsConfirmScreen(RealmsScreen realmsScreen, String string, String string2, String string3, String string4, int n) {
        this.parent = realmsScreen;
        this.title1 = string;
        this.title2 = string2;
        this.yesButton = string3;
        this.noButton = string4;
        this.id = n;
    }

    @Override
    public void init() {
        this.buttonsAdd(RealmsConfirmScreen.newButton(0, this.width() / 2 - 105, RealmsConstants.row(9), 100, 20, this.yesButton));
        this.buttonsAdd(RealmsConfirmScreen.newButton(1, this.width() / 2 + 5, RealmsConstants.row(9), 100, 20, this.noButton));
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        this.parent.confirmResult(realmsButton.id() == 0, this.id);
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        this.drawCenteredString(this.title1, this.width() / 2, RealmsConstants.row(3), 0xFFFFFF);
        this.drawCenteredString(this.title2, this.width() / 2, RealmsConstants.row(5), 0xFFFFFF);
        super.render(n, n2, f);
    }

    public void setDelay(int n) {
        this.delayTicker = n;
        for (RealmsButton realmsButton : this.buttons()) {
            realmsButton.active(false);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (--this.delayTicker == 0) {
            for (RealmsButton realmsButton : this.buttons()) {
                realmsButton.active(true);
            }
        }
    }
}

