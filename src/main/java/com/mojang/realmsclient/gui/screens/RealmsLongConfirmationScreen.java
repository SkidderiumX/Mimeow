/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.gui.RealmsConstants;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;

public class RealmsLongConfirmationScreen
extends RealmsScreen {
    private final Type type;
    private final String line2;
    private final String line3;
    protected final RealmsScreen parent;
    protected final String yesButton;
    protected final String noButton;
    private final String okButton;
    protected final int id;
    private final boolean yesNoQuestion;

    public RealmsLongConfirmationScreen(RealmsScreen realmsScreen, Type type, String string, String string2, boolean bl, int n) {
        this.parent = realmsScreen;
        this.id = n;
        this.type = type;
        this.line2 = string;
        this.line3 = string2;
        this.yesNoQuestion = bl;
        this.yesButton = RealmsLongConfirmationScreen.getLocalizedString("gui.yes");
        this.noButton = RealmsLongConfirmationScreen.getLocalizedString("gui.no");
        this.okButton = RealmsLongConfirmationScreen.getLocalizedString("mco.gui.ok");
    }

    @Override
    public void init() {
        if (this.yesNoQuestion) {
            this.buttonsAdd(RealmsLongConfirmationScreen.newButton(0, this.width() / 2 - 105, RealmsConstants.row(8), 100, 20, this.yesButton));
            this.buttonsAdd(RealmsLongConfirmationScreen.newButton(1, this.width() / 2 + 5, RealmsConstants.row(8), 100, 20, this.noButton));
        } else {
            this.buttonsAdd(RealmsLongConfirmationScreen.newButton(0, this.width() / 2 - 50, RealmsConstants.row(8), 100, 20, this.okButton));
        }
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        this.parent.confirmResult(realmsButton.id() == 0, this.id);
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            this.parent.confirmResult(false, this.id);
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        this.drawCenteredString(this.type.text, this.width() / 2, RealmsConstants.row(2), this.type.colorCode);
        this.drawCenteredString(this.line2, this.width() / 2, RealmsConstants.row(4), 0xFFFFFF);
        this.drawCenteredString(this.line3, this.width() / 2, RealmsConstants.row(6), 0xFFFFFF);
        super.render(n, n2, f);
    }

    public static enum Type {
        Warning("Warning!", 0xFF0000),
        Info("Info!", 8226750);

        public final int colorCode;
        public final String text;

        private Type(String string2, int n2) {
            this.text = string2;
            this.colorCode = n2;
        }
    }
}

