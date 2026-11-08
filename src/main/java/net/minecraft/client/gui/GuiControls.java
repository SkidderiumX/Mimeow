/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiKeyBindingList;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiOptionSlider;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public class GuiControls
extends GuiScreen {
    private static final GameSettings.Options[] optionsArr = new GameSettings.Options[]{GameSettings.Options.INVERT_MOUSE, GameSettings.Options.SENSITIVITY, GameSettings.Options.TOUCHSCREEN};
    private GuiScreen parentScreen;
    protected String screenTitle = "Controls";
    private GameSettings options;
    public KeyBinding buttonId = null;
    public long time;
    private GuiKeyBindingList keyBindingList;
    private GuiButton buttonReset;

    public GuiControls(GuiScreen guiScreen, GameSettings gameSettings) {
        this.parentScreen = guiScreen;
        this.options = gameSettings;
    }

    @Override
    public void initGui() {
        this.keyBindingList = new GuiKeyBindingList(this, this.mc);
        this.buttonList.add(new GuiButton(200, this.width / 2 - 155, this.height - 29, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonReset = new GuiButton(201, this.width / 2 - 155 + 160, this.height - 29, 150, 20, I18n.format("controls.resetAll", new Object[0]));
        this.buttonList.add(this.buttonReset);
        this.screenTitle = I18n.format("controls.title", new Object[0]);
        int n = 0;
        for (GameSettings.Options options : optionsArr) {
            if (options.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(options.returnEnumOrdinal(), this.width / 2 - 155 + n % 2 * 160, 18 + 24 * (n >> 1), options));
            } else {
                this.buttonList.add(new GuiOptionButton(options.returnEnumOrdinal(), this.width / 2 - 155 + n % 2 * 160, 18 + 24 * (n >> 1), options, this.options.getKeyBinding(options)));
            }
            ++n;
        }
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.keyBindingList.handleMouseInput();
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.id == 200) {
            this.mc.displayGuiScreen(this.parentScreen);
        } else if (guiButton.id == 201) {
            for (KeyBinding keyBinding : this.mc.gameSettings.keyBindings) {
                keyBinding.setKeyCode(keyBinding.getKeyCodeDefault());
            }
            KeyBinding.resetKeyBindingArrayAndHash();
        } else if (guiButton.id < 100 && guiButton instanceof GuiOptionButton) {
            this.options.setOptionValue(((GuiOptionButton)guiButton).returnEnumOptions(), 1);
            guiButton.displayString = this.options.getKeyBinding(GameSettings.Options.getEnumOptions(guiButton.id));
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        if (this.buttonId != null) {
            this.options.setOptionKeyBinding(this.buttonId, -100 + n3);
            this.buttonId = null;
            KeyBinding.resetKeyBindingArrayAndHash();
        } else if (n3 != 0 || !this.keyBindingList.mouseClicked(n, n2, n3)) {
            super.mouseClicked(n, n2, n3);
        }
    }

    @Override
    protected void mouseReleased(int n, int n2, int n3) {
        if (n3 != 0 || !this.keyBindingList.mouseReleased(n, n2, n3)) {
            super.mouseReleased(n, n2, n3);
        }
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (this.buttonId != null) {
            if (n == 1) {
                this.options.setOptionKeyBinding(this.buttonId, 0);
            } else if (n != 0) {
                this.options.setOptionKeyBinding(this.buttonId, n);
            } else if (c > '\u0000') {
                this.options.setOptionKeyBinding(this.buttonId, c + 256);
            }
            this.buttonId = null;
            this.time = Minecraft.getSystemTime();
            KeyBinding.resetKeyBindingArrayAndHash();
        } else {
            super.keyTyped(c, n);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.keyBindingList.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 8, 0xFFFFFF);
        boolean bl = true;
        for (KeyBinding keyBinding : this.options.keyBindings) {
            if (keyBinding.getKeyCode() == keyBinding.getKeyCodeDefault()) continue;
            bl = false;
            break;
        }
        this.buttonReset.enabled = !bl;
        super.drawScreen(n, n2, f);
    }
}

