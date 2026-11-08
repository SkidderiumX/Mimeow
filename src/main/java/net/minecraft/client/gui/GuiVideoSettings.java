/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.src.Config;
import net.optifine.Lang;
import net.optifine.gui.GuiAnimationSettingsOF;
import net.optifine.gui.GuiDetailSettingsOF;
import net.optifine.gui.GuiOptionButtonOF;
import net.optifine.gui.GuiOptionSliderOF;
import net.optifine.gui.GuiOtherSettingsOF;
import net.optifine.gui.GuiPerformanceSettingsOF;
import net.optifine.gui.GuiQualitySettingsOF;
import net.optifine.gui.GuiScreenOF;
import net.optifine.gui.TooltipManager;
import net.optifine.gui.TooltipProviderOptions;
import net.optifine.shaders.gui.GuiShaders;

public class GuiVideoSettings
extends GuiScreenOF {
    private GuiScreen parentGuiScreen;
    protected String screenTitle = "Video Settings";
    private GameSettings guiGameSettings;
    private static GameSettings.Options[] videoOptions = new GameSettings.Options[]{GameSettings.Options.GRAPHICS, GameSettings.Options.RENDER_DISTANCE, GameSettings.Options.AMBIENT_OCCLUSION, GameSettings.Options.FRAMERATE_LIMIT, GameSettings.Options.AO_LEVEL, GameSettings.Options.VIEW_BOBBING, GameSettings.Options.GUI_SCALE, GameSettings.Options.USE_VBO, GameSettings.Options.GAMMA, GameSettings.Options.BLOCK_ALTERNATIVES, GameSettings.Options.DYNAMIC_LIGHTS, GameSettings.Options.DYNAMIC_FOV};
    private TooltipManager tooltipManager = new TooltipManager(this, new TooltipProviderOptions());

    public GuiVideoSettings(GuiScreen guiScreen, GameSettings gameSettings) {
        this.parentGuiScreen = guiScreen;
        this.guiGameSettings = gameSettings;
    }

    @Override
    public void initGui() {
        int n;
        this.screenTitle = I18n.format("options.videoTitle", new Object[0]);
        this.buttonList.clear();
        for (n = 0; n < videoOptions.length; ++n) {
            GameSettings.Options options = videoOptions[n];
            if (options == null) continue;
            int n2 = this.width / 2 - 155 + n % 2 * 160;
            int n3 = this.height / 6 + 21 * (n / 2) - 12;
            if (options.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSliderOF(options.returnEnumOrdinal(), n2, n3, options));
                continue;
            }
            this.buttonList.add(new GuiOptionButtonOF(options.returnEnumOrdinal(), n2, n3, options, this.guiGameSettings.getKeyBinding(options)));
        }
        n = this.height / 6 + 21 * (videoOptions.length / 2) - 12;
        int n4 = 0;
        n4 = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(231, n4, n, Lang.get("of.options.shaders")));
        n4 = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(202, n4, n, Lang.get("of.options.quality")));
        n4 = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(201, n4, n += 21, Lang.get("of.options.details")));
        n4 = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(212, n4, n, Lang.get("of.options.performance")));
        n4 = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(211, n4, n += 21, Lang.get("of.options.animations")));
        n4 = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(222, n4, n, Lang.get("of.options.other")));
        n += 21;
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        this.actionPerformed(guiButton, 1);
    }

    @Override
    protected void actionPerformedRightClick(GuiButton guiButton) {
        if (guiButton.id == GameSettings.Options.GUI_SCALE.ordinal()) {
            this.actionPerformed(guiButton, -1);
        }
    }

    private void actionPerformed(GuiButton guiButton, int n) {
        if (guiButton.enabled) {
            Object object;
            int n2 = this.guiGameSettings.guiScale;
            if (guiButton.id < 200 && guiButton instanceof GuiOptionButton) {
                this.guiGameSettings.setOptionValue(((GuiOptionButton)guiButton).returnEnumOptions(), n);
                guiButton.displayString = this.guiGameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(guiButton.id));
            }
            if (guiButton.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGuiScreen);
            }
            if (this.guiGameSettings.guiScale != n2) {
                object = new ScaledResolution(this.mc);
                int n3 = ((ScaledResolution)object).getScaledWidth();
                int n4 = ((ScaledResolution)object).getScaledHeight();
                this.setWorldAndResolution(this.mc, n3, n4);
            }
            if (guiButton.id == 201) {
                this.mc.gameSettings.saveOptions();
                object = new GuiDetailSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)object);
            }
            if (guiButton.id == 202) {
                this.mc.gameSettings.saveOptions();
                object = new GuiQualitySettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)object);
            }
            if (guiButton.id == 211) {
                this.mc.gameSettings.saveOptions();
                object = new GuiAnimationSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)object);
            }
            if (guiButton.id == 212) {
                this.mc.gameSettings.saveOptions();
                object = new GuiPerformanceSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)object);
            }
            if (guiButton.id == 222) {
                this.mc.gameSettings.saveOptions();
                object = new GuiOtherSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)object);
            }
            if (guiButton.id == 231) {
                if (Config.isAntialiasing() || Config.isAntialiasingConfigured()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.aa1"), Lang.get("of.message.shaders.aa2"));
                    return;
                }
                if (Config.isAnisotropicFiltering()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.af1"), Lang.get("of.message.shaders.af2"));
                    return;
                }
                if (Config.isFastRender()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.fr1"), Lang.get("of.message.shaders.fr2"));
                    return;
                }
                if (Config.getGameSettings().anaglyph) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.an1"), Lang.get("of.message.shaders.an2"));
                    return;
                }
                this.mc.gameSettings.saveOptions();
                object = new GuiShaders(this, this.guiGameSettings);
                this.mc.displayGuiScreen((GuiScreen)object);
            }
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 15, 0xFFFFFF);
        String string = Config.getVersion();
        String string2 = "HD_U";
        if (string2.equals("HD")) {
            string = "OptiFine HD M6_pre2";
        }
        if (string2.equals("HD_U")) {
            string = "OptiFine HD M6_pre2 Ultra";
        }
        if (string2.equals("L")) {
            string = "OptiFine M6_pre2 Light";
        }
        this.drawString(this.fontRendererObj, string, 2, this.height - 10, 0x808080);
        String string3 = "Minecraft 1.8.9";
        int n3 = this.fontRendererObj.getStringWidth(string3);
        this.drawString(this.fontRendererObj, string3, this.width - n3 - 2, this.height - 10, 0x808080);
        super.drawScreen(n, n2, f);
        this.tooltipManager.drawTooltips(n, n2, this.buttonList);
    }

    public static int getButtonWidth(GuiButton guiButton) {
        return guiButton.width;
    }

    public static int getButtonHeight(GuiButton guiButton) {
        return guiButton.height;
    }

    public static void drawGradientRect(GuiScreen guiScreen, int n, int n2, int n3, int n4, int n5, int n6) {
        guiScreen.drawGradientRect(n, n2, n3, n4, n5, n6);
    }

    public static String getGuiChatText(GuiChat guiChat) {
        return guiChat.inputField.getText();
    }
}

