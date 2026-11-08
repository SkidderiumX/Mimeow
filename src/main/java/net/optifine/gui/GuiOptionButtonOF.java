/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.gui;

import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.settings.GameSettings;
import net.optifine.gui.IOptionControl;

public class GuiOptionButtonOF
extends GuiOptionButton
implements IOptionControl {
    private GameSettings.Options option = null;

    public GuiOptionButtonOF(int n, int n2, int n3, GameSettings.Options options, String string) {
        super(n, n2, n3, options, string);
        this.option = options;
    }

    @Override
    public GameSettings.Options getOption() {
        return this.option;
    }
}

