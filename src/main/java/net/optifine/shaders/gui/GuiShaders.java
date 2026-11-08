/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.gui;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.src.Config;
import net.optifine.Lang;
import net.optifine.gui.GuiScreenOF;
import net.optifine.gui.TooltipManager;
import net.optifine.gui.TooltipProviderEnumShaderOptions;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.ShadersTex;
import net.optifine.shaders.config.EnumShaderOption;
import net.optifine.shaders.gui.GuiButtonDownloadShaders;
import net.optifine.shaders.gui.GuiButtonEnumShaderOption;
import net.optifine.shaders.gui.GuiShaderOptions;
import net.optifine.shaders.gui.GuiSlotShaders;
import org.lwjgl.Sys;

public class GuiShaders
extends GuiScreenOF {
    protected GuiScreen parentGui;
    protected String screenTitle = "Shaders";
    private TooltipManager tooltipManager = new TooltipManager(this, new TooltipProviderEnumShaderOptions());
    private int updateTimer = -1;
    private GuiSlotShaders shaderList;
    private boolean saved = false;
    private static float[] QUALITY_MULTIPLIERS = new float[]{0.5f, 0.6f, 0.6666667f, 0.75f, 0.8333333f, 0.9f, 1.0f, 1.1666666f, 1.3333334f, 1.5f, 1.6666666f, 1.8f, 2.0f};
    private static String[] QUALITY_MULTIPLIER_NAMES = new String[]{"0.5x", "0.6x", "0.66x", "0.75x", "0.83x", "0.9x", "1x", "1.16x", "1.33x", "1.5x", "1.66x", "1.8x", "2x"};
    private static float QUALITY_MULTIPLIER_DEFAULT = 1.0f;
    private static float[] HAND_DEPTH_VALUES = new float[]{0.0625f, 0.125f, 0.25f};
    private static String[] HAND_DEPTH_NAMES = new String[]{"0.5x", "1x", "2x"};
    private static float HAND_DEPTH_DEFAULT = 0.125f;
    public static final int EnumOS_UNKNOWN = 0;
    public static final int EnumOS_WINDOWS = 1;
    public static final int EnumOS_OSX = 2;
    public static final int EnumOS_SOLARIS = 3;
    public static final int EnumOS_LINUX = 4;

    public GuiShaders(GuiScreen guiScreen, GameSettings gameSettings) {
        this.parentGui = guiScreen;
    }

    @Override
    public void initGui() {
        this.screenTitle = I18n.format("of.options.shadersTitle", new Object[0]);
        if (Shaders.shadersConfig == null) {
            Shaders.loadConfig();
        }
        int n = 120;
        int n2 = 20;
        int n3 = this.width - n - 10;
        int n4 = 30;
        int n5 = 20;
        int n6 = this.width - n - 20;
        this.shaderList = new GuiSlotShaders(this, n6, this.height, n4, this.height - 50, 16);
        this.shaderList.registerScrollButtons(7, 8);
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.ANTIALIASING, n3, 0 * n5 + n4, n, n2));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.NORMAL_MAP, n3, 1 * n5 + n4, n, n2));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.SPECULAR_MAP, n3, 2 * n5 + n4, n, n2));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.RENDER_RES_MUL, n3, 3 * n5 + n4, n, n2));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.SHADOW_RES_MUL, n3, 4 * n5 + n4, n, n2));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.HAND_DEPTH_MUL, n3, 5 * n5 + n4, n, n2));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.OLD_HAND_LIGHT, n3, 6 * n5 + n4, n, n2));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.OLD_LIGHTING, n3, 7 * n5 + n4, n, n2));
        int n7 = Math.min(150, n6 / 2 - 10);
        int n8 = n6 / 4 - n7 / 2;
        int n9 = this.height - 25;
        this.buttonList.add(new GuiButton(201, n8, n9, n7 - 22 + 1, n2, Lang.get("of.options.shaders.shadersFolder")));
        this.buttonList.add(new GuiButtonDownloadShaders(210, n8 + n7 - 22 - 1, n9));
        this.buttonList.add(new GuiButton(202, n6 / 4 * 3 - n7 / 2, this.height - 25, n7, n2, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(203, n3, this.height - 25, n, n2, Lang.get("of.options.shaders.shaderOptions")));
        this.updateButtons();
    }

    public void updateButtons() {
        boolean bl = Config.isShaders();
        for (GuiButton guiButton : this.buttonList) {
            if (guiButton.id == 201 || guiButton.id == 202 || guiButton.id == 210 || guiButton.id == EnumShaderOption.ANTIALIASING.ordinal()) continue;
            guiButton.enabled = bl;
        }
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.shaderList.handleMouseInput();
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        this.actionPerformed(guiButton, false);
    }

    @Override
    protected void actionPerformedRightClick(GuiButton guiButton) {
        this.actionPerformed(guiButton, true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void actionPerformed(GuiButton guiButton, boolean bl) {
        if (!guiButton.enabled) return;
        if (!(guiButton instanceof GuiButtonEnumShaderOption)) {
            if (bl) return;
            switch (guiButton.id) {
                case 201: {
                    switch (GuiShaders.getOSType()) {
                        case 1: {
                            String string = String.format("cmd.exe /C start \"Open file\" \"%s\"", Shaders.shaderPacksDir.getAbsolutePath());
                            try {
                                Runtime.getRuntime().exec(string);
                                return;
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                                break;
                            }
                        }
                        case 2: {
                            try {
                                Runtime.getRuntime().exec(new String[]{"/usr/bin/open", Shaders.shaderPacksDir.getAbsolutePath()});
                                return;
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                        }
                    }
                    boolean bl2 = false;
                    try {
                        Class<?> clazz = Class.forName("java.awt.Desktop");
                        Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                        clazz.getMethod("browse", URI.class).invoke(object, new File(this.mc.mcDataDir, "shaderpacks").toURI());
                    }
                    catch (Throwable throwable) {
                        throwable.printStackTrace();
                        bl2 = true;
                    }
                    if (!bl2) return;
                    Config.dbg("Opening via system class!");
                    Sys.openURL("file://" + Shaders.shaderPacksDir.getAbsolutePath());
                    return;
                }
                case 202: {
                    Shaders.storeConfig();
                    this.saved = true;
                    this.mc.displayGuiScreen(this.parentGui);
                    return;
                }
                case 203: {
                    GuiShaderOptions guiShaderOptions = new GuiShaderOptions(this, Config.getGameSettings());
                    Config.getMinecraft().displayGuiScreen(guiShaderOptions);
                    return;
                }
                case 210: {
                    try {
                        Class<?> clazz = Class.forName("java.awt.Desktop");
                        Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                        clazz.getMethod("browse", URI.class).invoke(object, new URI("http://optifine.net/shaderPacks"));
                    }
                    catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
                default: {
                    this.shaderList.actionPerformed(guiButton);
                    return;
                }
            }
        }
        GuiButtonEnumShaderOption guiButtonEnumShaderOption = (GuiButtonEnumShaderOption)guiButton;
        switch (guiButtonEnumShaderOption.getEnumShaderOption()) {
            case ANTIALIASING: {
                Shaders.nextAntialiasingLevel(!bl);
                if (this.hasShiftDown()) {
                    Shaders.configAntialiasingLevel = 0;
                }
                Shaders.uninit();
                break;
            }
            case NORMAL_MAP: {
                boolean bl3 = Shaders.configNormalMap = !Shaders.configNormalMap;
                if (this.hasShiftDown()) {
                    Shaders.configNormalMap = true;
                }
                Shaders.uninit();
                this.mc.scheduleResourcesRefresh();
                break;
            }
            case SPECULAR_MAP: {
                boolean bl4 = Shaders.configSpecularMap = !Shaders.configSpecularMap;
                if (this.hasShiftDown()) {
                    Shaders.configSpecularMap = true;
                }
                Shaders.uninit();
                this.mc.scheduleResourcesRefresh();
                break;
            }
            case RENDER_RES_MUL: {
                Shaders.configRenderResMul = this.getNextValue(Shaders.configRenderResMul, QUALITY_MULTIPLIERS, QUALITY_MULTIPLIER_DEFAULT, !bl, this.hasShiftDown());
                Shaders.uninit();
                Shaders.scheduleResize();
                break;
            }
            case SHADOW_RES_MUL: {
                Shaders.configShadowResMul = this.getNextValue(Shaders.configShadowResMul, QUALITY_MULTIPLIERS, QUALITY_MULTIPLIER_DEFAULT, !bl, this.hasShiftDown());
                Shaders.uninit();
                Shaders.scheduleResizeShadow();
                break;
            }
            case HAND_DEPTH_MUL: {
                Shaders.configHandDepthMul = this.getNextValue(Shaders.configHandDepthMul, HAND_DEPTH_VALUES, HAND_DEPTH_DEFAULT, !bl, this.hasShiftDown());
                Shaders.uninit();
                break;
            }
            case OLD_HAND_LIGHT: {
                Shaders.configOldHandLight.nextValue(!bl);
                if (this.hasShiftDown()) {
                    Shaders.configOldHandLight.resetValue();
                }
                Shaders.uninit();
                break;
            }
            case OLD_LIGHTING: {
                Shaders.configOldLighting.nextValue(!bl);
                if (this.hasShiftDown()) {
                    Shaders.configOldLighting.resetValue();
                }
                Shaders.updateBlockLightLevel();
                Shaders.uninit();
                this.mc.scheduleResourcesRefresh();
                break;
            }
            case TWEAK_BLOCK_DAMAGE: {
                Shaders.configTweakBlockDamage = !Shaders.configTweakBlockDamage;
                break;
            }
            case CLOUD_SHADOW: {
                Shaders.configCloudShadow = !Shaders.configCloudShadow;
                break;
            }
            case TEX_MIN_FIL_B: {
                Shaders.configTexMinFilN = Shaders.configTexMinFilS = (Shaders.configTexMinFilB = (Shaders.configTexMinFilB + 1) % 3);
                guiButton.displayString = "Tex Min: " + Shaders.texMinFilDesc[Shaders.configTexMinFilB];
                ShadersTex.updateTextureMinMagFilter();
                break;
            }
            case TEX_MAG_FIL_N: {
                Shaders.configTexMagFilN = (Shaders.configTexMagFilN + 1) % 2;
                guiButton.displayString = "Tex_n Mag: " + Shaders.texMagFilDesc[Shaders.configTexMagFilN];
                ShadersTex.updateTextureMinMagFilter();
                break;
            }
            case TEX_MAG_FIL_S: {
                Shaders.configTexMagFilS = (Shaders.configTexMagFilS + 1) % 2;
                guiButton.displayString = "Tex_s Mag: " + Shaders.texMagFilDesc[Shaders.configTexMagFilS];
                ShadersTex.updateTextureMinMagFilter();
                break;
            }
            case SHADOW_CLIP_FRUSTRUM: {
                Shaders.configShadowClipFrustrum = !Shaders.configShadowClipFrustrum;
                guiButton.displayString = "ShadowClipFrustrum: " + GuiShaders.toStringOnOff(Shaders.configShadowClipFrustrum);
                ShadersTex.updateTextureMinMagFilter();
            }
        }
        guiButtonEnumShaderOption.updateButtonText();
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (!this.saved) {
            Shaders.storeConfig();
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.shaderList.drawScreen(n, n2, f);
        if (this.updateTimer <= 0) {
            this.shaderList.updateList();
            this.updateTimer += 20;
        }
        this.drawCenteredString(this.fontRendererObj, this.screenTitle + " ", this.width / 2, 15, 0xFFFFFF);
        String string = "OpenGL: " + Shaders.glVersionString + ", " + Shaders.glVendorString + ", " + Shaders.glRendererString;
        int n3 = this.fontRendererObj.getStringWidth(string);
        if (n3 < this.width - 5) {
            this.drawCenteredString(this.fontRendererObj, string, this.width / 2, this.height - 40, 0x808080);
        } else {
            this.drawString(this.fontRendererObj, string, 5, this.height - 40, 0x808080);
        }
        super.drawScreen(n, n2, f);
        this.tooltipManager.drawTooltips(n, n2, this.buttonList);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        --this.updateTimer;
    }

    public Minecraft getMc() {
        return this.mc;
    }

    public void drawCenteredString(String string, int n, int n2, int n3) {
        this.drawCenteredString(this.fontRendererObj, string, n, n2, n3);
    }

    public static String toStringOnOff(boolean bl) {
        String string = Lang.getOn();
        String string2 = Lang.getOff();
        return bl ? string : string2;
    }

    public static String toStringAa(int n) {
        return n == 2 ? "FXAA 2x" : (n == 4 ? "FXAA 4x" : Lang.getOff());
    }

    public static String toStringValue(float f, float[] fArray, String[] stringArray) {
        int n = GuiShaders.getValueIndex(f, fArray);
        return stringArray[n];
    }

    private float getNextValue(float f, float[] fArray, float f2, boolean bl, boolean bl2) {
        if (bl2) {
            return f2;
        }
        int n = GuiShaders.getValueIndex(f, fArray);
        if (bl) {
            if (++n >= fArray.length) {
                n = 0;
            }
        } else if (--n < 0) {
            n = fArray.length - 1;
        }
        return fArray[n];
    }

    public static int getValueIndex(float f, float[] fArray) {
        for (int i = 0; i < fArray.length; ++i) {
            float f2 = fArray[i];
            if (!(f2 >= f)) continue;
            return i;
        }
        return fArray.length - 1;
    }

    public static String toStringQuality(float f) {
        return GuiShaders.toStringValue(f, QUALITY_MULTIPLIERS, QUALITY_MULTIPLIER_NAMES);
    }

    public static String toStringHandDepth(float f) {
        return GuiShaders.toStringValue(f, HAND_DEPTH_VALUES, HAND_DEPTH_NAMES);
    }

    public static int getOSType() {
        String string = System.getProperty("os.name").toLowerCase();
        return string.contains("win") ? 1 : (string.contains("mac") ? 2 : (string.contains("solaris") ? 3 : (string.contains("sunos") ? 3 : (string.contains("linux") ? 4 : (string.contains("unix") ? 4 : 0)))));
    }

    public boolean hasShiftDown() {
        return GuiShaders.isShiftKeyDown();
    }
}

