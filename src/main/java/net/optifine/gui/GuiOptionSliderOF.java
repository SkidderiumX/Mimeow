/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.gui;

import net.minecraft.client.gui.GuiOptionSlider;
import net.minecraft.client.settings.GameSettings;
import net.optifine.gui.IOptionControl;

public class GuiOptionSliderOF
extends GuiOptionSlider
implements IOptionControl {
    private GameSettings.Options option = null;

    public GuiOptionSliderOF(int n, int n2, int n3, GameSettings.Options options) {
        super(n, n2, n3, options);
        this.option = options;
    }

    @Override
    public GameSettings.Options getOption() {
        return this.option;
    }
}

