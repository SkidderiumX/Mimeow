/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui;

import net.minecraft.realms.RealmsButton;

public class RealmsHideableButton
extends RealmsButton {
    boolean visible = true;

    public RealmsHideableButton(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
    }

    @Override
    public void render(int n, int n2) {
        if (!this.visible) {
            return;
        }
        super.render(n, n2);
    }

    @Override
    public void clicked(int n, int n2) {
        if (!this.visible) {
            return;
        }
        super.clicked(n, n2);
    }

    @Override
    public void released(int n, int n2) {
        if (!this.visible) {
            return;
        }
        super.released(n, n2);
    }

    public void setVisible(boolean bl) {
        this.visible = bl;
    }

    public boolean getVisible() {
        return this.visible;
    }
}

