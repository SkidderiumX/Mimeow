/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.opengl.GL11;
import x.oc0723d1b697;
import x.oc1378bc114d;
import x.oc170ea29aae;
import x.oc19a6b77031;
import x.oc3090a939b0;
import x.oc373d6c4e35;
import x.oc3ebac73392;
import x.oc6d9efd226f;
import x.oc9755810e45;
import x.ocb61fbe5199;
import x.ocb704df8382;
import x.ocb7e057f84c;
import x.occ995d8031c;
import x.ocd2958dac48;
import x.ocfc2b827e17;

public class GuiMainMenu
extends GuiScreen
implements GuiYesNoCallback {
    private static final String TITLE_TEXT = "miau";
    private static final ResourceLocation TITLE_LOGO = new ResourceLocation("miau/images/title_cat.png");
    private static final ResourceLocation[] FRIENDLY_CAT_SOUNDS = new ResourceLocation[]{new ResourceLocation("mob.cat.meow"), new ResourceLocation("mob.cat.purreow")};
    private static final int TITLE_LOGO_TEXTURE_WIDTH = 128;
    private static final int TITLE_LOGO_TEXTURE_HEIGHT = 114;
    private static final int TITLE_HIT_PADDING = 2;
    private static final long TITLE_TOGGLE_ANIMATION_DURATION_NANOS = 260000000L;
    private static final float TITLE_TOGGLE_START_SCALE = 0.35f;
    private static final int ACTION_HEIGHT = 14;
    private static final int CONTENT_MARGIN_MIN = 8;
    private static final int CONTENT_MARGIN_MAX = 48;
    private static final float CONTENT_MARGIN_RATIO = 0.022f;
    private static final int CONTENT_COLUMN_GAP = 12;
    private static final int ACCOUNT_MANAGER_BUTTON = 77701;
    private static final int DEFAULT_SHADER_PRIMARY = -12533761;
    private static final int DEFAULT_SHADER_SECONDARY = -32615;
    private static final long BOOT_TRANSITION_DURATION_NANOS = 550000000L;
    private static final float BOOT_TRANSITION_START_SCALE = 0.84f;
    private static final float BOOT_TRANSITION_EXPO_EXPONENT = 10.0f;
    private GuiButton buttonResetDemo;
    private long openedAt;
    private boolean bootTransitionPending;
    private long bootTransitionStartedAt = -1L;
    private int contentMargin;
    private int actionWidth;
    private int changelogWidth;
    private int changelogTop;
    private int changelogHeight;
    private int changelogAnimationOrder;
    private oc1378bc114d titleFont;
    private oc1378bc114d smallFont;
    private oc1378bc114d buttonFont;
    private ocb704df8382 preferences;
    private boolean titleLogoVisible;
    private long titleToggleAnimationStartedAt = -1L;
    private int nextCatSoundIndex;
    private ISound activeCatSound;

    public GuiMainMenu() {
        this(false);
    }

    public GuiMainMenu(boolean bl) {
        this.bootTransitionPending = bl;
    }

    @Override
    public void initGui() {
        int n;
        this.buttonList.clear();
        this.contentMargin = GuiMainMenu.calculateContentMargin(this.width, this.height);
        this.actionWidth = Math.max(112, Math.round((float)this.width * 0.18f));
        this.initializeFonts();
        this.initializePreferences();
        ocb61fbe5199.\u0476();
        this.openedAt = System.nanoTime();
        int n2 = this.width - this.contentMargin - this.actionWidth;
        int n3 = this.contentMargin;
        int n4 = 0;
        if (this.mc.isDemo()) {
            this.buttonList.add(this.createActionButton(11, n2, n3, I18n.format("menu.playdemo", new Object[0]), n4++));
            this.buttonResetDemo = this.createActionButton(12, n2, n3 += 14, I18n.format("menu.resetdemo", new Object[0]), n4++);
            this.buttonList.add(this.buttonResetDemo);
            WorldInfo worldInfo = this.mc.getSaveLoader().getWorldInfo("Demo_World");
            this.buttonResetDemo.enabled = worldInfo != null;
        } else {
            this.buttonList.add(this.createActionButton(1, n2, n3, I18n.format("menu.singleplayer", new Object[0]), n4++));
            this.buttonList.add(this.createActionButton(2, n2, n3 += 14, I18n.format("menu.multiplayer", new Object[0]), n4++));
            this.buttonList.add(this.createActionButton(77701, n2, n3 += 14, "Account Manager", n4++));
        }
        this.buttonList.add(this.createActionButton(0, n2, n3 += 14, "Settings", n4++));
        this.changelogTop = n = this.contentMargin + this.titleFont.z$1tqmx4tpnr6lq() + 8;
        this.changelogHeight = 0;
        this.changelogWidth = Math.min(320, Math.max(80, n2 - this.contentMargin - 12));
        this.changelogAnimationOrder = n4;
    }

    private void initializeFonts() {
        this.titleFont = oc3ebac73392.\u0122(21.0f);
        this.smallFont = oc3ebac73392.\u0122(8.0f);
        this.buttonFont = oc3ebac73392.\u0122(11.0f);
    }

    private void initializePreferences() {
        if (this.preferences != null) {
            return;
        }
        this.preferences = ocb704df8382.\u01b3(this.mc.mcDataDir);
        this.titleLogoVisible = this.preferences.\u01c6() == oc373d6c4e35.\u0425;
    }

    private oc3090a939b0 createActionButton(int n, int n2, int n3, String string, int n4) {
        return new oc3090a939b0(n, n2, n3, this.actionWidth, 14, string, n4, this.buttonFont, true);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        switch (guiButton.id) {
            case 0: {
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            }
            case 1: {
                this.mc.displayGuiScreen(new GuiSelectWorld(this));
                break;
            }
            case 2: {
                this.mc.displayGuiScreen(new GuiMultiplayer(this));
                break;
            }
            case 4: {
                this.mc.shutdown();
                break;
            }
            case 5: {
                this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
                break;
            }
            case 11: {
                this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
                break;
            }
            case 12: {
                this.confirmDemoReset();
                break;
            }
            case 77701: {
                this.mc.displayGuiScreen(new ocfc2b827e17(this));
                break;
            }
        }
    }

    private void confirmDemoReset() {
        ISaveFormat iSaveFormat = this.mc.getSaveLoader();
        WorldInfo worldInfo = iSaveFormat.getWorldInfo("Demo_World");
        if (worldInfo != null) {
            this.mc.displayGuiScreen(GuiSelectWorld.makeDeleteWorldYesNo(this, worldInfo.getWorldName(), 12));
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (bl && n == 12) {
            ISaveFormat iSaveFormat = this.mc.getSaveLoader();
            iSaveFormat.flushCache();
            iSaveFormat.deleteWorldDirectory("Demo_World");
        }
        this.mc.displayGuiScreen(this);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3;
        float f2;
        long l = System.nanoTime();
        if (this.bootTransitionPending && this.bootTransitionStartedAt < 0L) {
            this.bootTransitionStartedAt = l;
        }
        boolean bl = (f2 = this.getBootTransitionProgress(l)) < 1.0f;
        int n4 = bl ? Integer.MIN_VALUE : n;
        int n5 = n3 = bl ? Integer.MIN_VALUE : n2;
        if (bl) {
            Gui.drawRect(0, 0, this.width, this.height, -16777216);
            float f3 = GuiMainMenu.calculateBootScale(f2);
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)this.width / 2.0f, (float)this.height / 2.0f, 0.0f);
            GlStateManager.scale(f3, f3, 1.0f);
            GlStateManager.translate((float)(-this.width) / 2.0f, (float)(-this.height) / 2.0f, 0.0f);
        }
        this.drawBackground(l);
        this.drawInformation(l);
        super.drawScreen(n4, n3, f);
        this.drawFooter();
        if (bl) {
            GlStateManager.popMatrix();
        }
        if (this.bootTransitionPending && f2 >= 1.0f) {
            this.bootTransitionPending = false;
            this.bootTransitionStartedAt = -1L;
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private float getBootTransitionProgress(long l) {
        if (!this.bootTransitionPending) {
            return 1.0f;
        }
        if (this.bootTransitionStartedAt < 0L) {
            return 0.0f;
        }
        return GuiMainMenu.clamp((float)(l - this.bootTransitionStartedAt) / 5.5E8f);
    }

    static float calculateBootScale(float f) {
        float f2 = GuiMainMenu.easeOutExpo(f);
        return 0.84f + 0.16000003f * f2;
    }

    static float easeOutExpo(float f) {
        float f2 = GuiMainMenu.clamp(f);
        if (f2 <= 0.0f || f2 >= 1.0f) {
            return f2;
        }
        float f3 = 1.0f - (float)Math.pow(2.0, -10.0);
        return (1.0f - (float)Math.pow(2.0, -10.0f * f2)) / f3;
    }

    private void drawBackground(long l) {
        int n;
        int n2;
        float f = (float)Math.max(0L, l - this.openedAt) / 1.0E9f;
        if (ocb7e057f84c.\u0146(f, n2 = GuiMainMenu.getConfiguredHudColor(0.0, -12533761), n = GuiMainMenu.getConfiguredHudColor(48.0, -32615))) {
            return;
        }
        this.drawFallbackBackground(l);
    }

    private static int getConfiguredHudColor(double d, int n) {
        if (oc9755810e45.\u029c == null) {
            return n;
        }
        try {
            return ocd2958dac48.\u016f(d);
        }
        catch (LinkageError | RuntimeException throwable) {
            return n;
        }
    }

    private void drawFallbackBackground(long l) {
        this.drawGradientRect(0, 0, this.width, this.height, -15457478, -16249059);
        double d = (double)l / 1.0E9;
        float f = (float)Math.max(this.width, this.height) * 0.42f;
        this.drawSoftGlow((float)this.width * 0.16f + (float)Math.sin(d * 0.17) * (float)this.width * 0.04f, (float)this.height * 0.2f + (float)Math.cos(d * 0.13) * (float)this.height * 0.04f, f, 79, 183, 224, 9);
        this.drawSoftGlow((float)this.width * 0.84f + (float)Math.cos(d * 0.15) * (float)this.width * 0.04f, (float)this.height * 0.78f + (float)Math.sin(d * 0.11) * (float)this.height * 0.04f, f, 137, 102, 220, 8);
    }

    private void drawSoftGlow(float f, float f2, float f3, int n, int n2, int n3, int n4) {
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        GL11.glBegin(6);
        GL11.glColor4f((float)n / 255.0f, (float)n2 / 255.0f, (float)n3 / 255.0f, (float)n4 / 255.0f);
        GL11.glVertex2f(f, f2);
        GL11.glColor4f((float)n / 255.0f, (float)n2 / 255.0f, (float)n3 / 255.0f, 0.0f);
        for (int i = 0; i <= 64; ++i) {
            double d = (double)i * Math.PI * 2.0 / 64.0;
            GL11.glVertex2f(f + (float)Math.cos(d) * f3, f2 + (float)Math.sin(d) * f3);
        }
        oc170ea29aae.\u0177();
        GlStateManager.shadeModel(7424);
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void drawInformation(long l) {
        float f;
        float f2;
        float f3 = this.getEntranceProgress();
        if (f3 <= 0.01f) {
            return;
        }
        float f4 = 1.0f - (float)Math.pow(1.0f - f3, 3.0);
        int n = Math.max(4, Math.round(255.0f * f4));
        int n2 = Math.max(4, Math.round(205.0f * f4));
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.contentMargin, this.contentMargin, 0.0f);
        float f5 = GuiMainMenu.calculateTitleScale(f3);
        GlStateManager.scale(f5, f5, 1.0f);
        float f6 = this.getTitleToggleScale(l);
        if (f6 < 1.0f) {
            f2 = (float)this.getTitleWidth() / 2.0f;
            f = (float)this.titleFont.z$1tqmx4tpnr6lq() / 2.0f;
            GlStateManager.translate(f2, f, 0.0f);
            GlStateManager.scale(f6, f6, 1.0f);
            GlStateManager.translate(-f2, -f, 0.0f);
        }
        this.drawTitle(n);
        GlStateManager.popMatrix();
        f2 = (float)Math.max(0L, l - this.openedAt) / 1.0E9f;
        f = oc3090a939b0.\u0257(f2, this.changelogAnimationOrder);
        this.drawChangelogPreview(n2, f);
    }

    private void drawTitle(int n) {
        if (!this.titleLogoVisible) {
            this.titleFont.z$rqv994f7nhin(TITLE_TEXT, 0.0f, 0.0f, n << 24 | 0xFFFFFF);
            return;
        }
        int n2 = this.titleFont.z$1tqmx4tpnr6lq();
        int n3 = GuiMainMenu.calculateTitleLogoWidth(n2);
        this.mc.getTextureManager().bindTexture(TITLE_LOGO);
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(1.0f, 1.0f, 1.0f, (float)n / 255.0f);
        Gui.drawScaledCustomSizeModalRect(0, 0, 0.0f, 0.0f, 128, 114, n3, n2, 128.0f, 114.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void drawChangelogPreview(int n, float f) {
        oc0723d1b697 oc0723d1b6972 = ocb61fbe5199.\u01f5();
        int n2 = this.smallFont.z$3hte9fh87zo6x() + 1;
        oc6d9efd226f oc6d9efd226f2 = oc0723d1b6972.\u023a();
        int n3 = oc6d9efd226f2 == null ? 1 : 1 + oc0723d1b6972.\u0118().size();
        this.changelogHeight = n2 * n3;
        if (f <= 0.0f) {
            return;
        }
        float f2 = (float)this.contentMargin + (float)this.changelogWidth / 2.0f;
        float f3 = (float)this.changelogTop + (float)this.changelogHeight / 2.0f;
        float f4 = 0.97f + f * 0.03f;
        GlStateManager.pushMatrix();
        GlStateManager.translate(f2, f3 + (1.0f - f) * 4.0f, 0.0f);
        GlStateManager.scale(f4, f4, 1.0f);
        GlStateManager.translate(-f2, -f3, 0.0f);
        float f5 = this.changelogTop;
        if (oc6d9efd226f2 == null) {
            String string = oc0723d1b6972.\u03fa() ? "Fetching changelogs..." : (oc0723d1b6972.\u0287() ? "Unable to load changelogs." : "No changelogs are available yet.");
            this.drawPreviewLine(string, f5, n << 24 | 0xFFFFFF);
            GlStateManager.popMatrix();
            return;
        }
        this.drawPreviewLine(GuiMainMenu.formatReleaseName(oc6d9efd226f2.\u0154()), f5, n << 24 | 0xFFFFFF);
        f5 += (float)n2;
        for (occ995d8031c occ995d8031c2 : oc0723d1b6972.\u0118()) {
            int n4 = n << 24 | occ995d8031c2.\u021b().\u0510() & 0xFFFFFF;
            this.drawPreviewLine("- " + occ995d8031c2.\u0181(), f5, n4);
            f5 += (float)n2;
        }
        GlStateManager.popMatrix();
    }

    private void drawPreviewLine(String string, float f, int n) {
        this.smallFont.z$ao2ykh4tuw6w(GuiMainMenu.ellipsize(string, this.smallFont, this.changelogWidth), this.contentMargin, f, n, false);
    }

    private void drawFooter() {
        int n = this.height - this.contentMargin - this.smallFont.z$1tqmx4tpnr6lq();
        String string = ocb61fbe5199.\u01f5().\u0254();
        String string2 = "Credits: Myau client, vnhao294, khoanguyen67, aftercares, vector3030";
        if (this.smallFont.z$toz8pt08w0nc(string) + this.smallFont.z$toz8pt08w0nc(string2) + this.contentMargin * 2 + 12 > this.width) {
            string2 = "Credits: Myau Client";
        }
        int n2 = this.width - this.contentMargin * 2 - this.smallFont.z$toz8pt08w0nc(string2) - 12;
        string = GuiMainMenu.ellipsize(string, this.smallFont, Math.max(1, n2));
        this.smallFont.z$ao2ykh4tuw6w(string, this.contentMargin, n, -788529153, false);
        this.smallFont.z$ao2ykh4tuw6w(string2, this.width - this.contentMargin - this.smallFont.z$toz8pt08w0nc(string2), n, -788529153, false);
    }

    private float getEntranceProgress() {
        return GuiMainMenu.clamp((float)(System.nanoTime() - this.openedAt) / 4.5E8f);
    }

    private static float clamp(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    static int calculateContentMargin(int n, int n2) {
        int n3 = Math.max(1, n);
        int n4 = Math.max(1, n2);
        int n5 = Math.min(n3, Math.round((float)n4 * 1.7777778f));
        return Math.max(8, Math.min(48, Math.round((float)n5 * 0.022f)));
    }

    static int calculateTitleLogoWidth(int n) {
        return Math.max(1, Math.round((float)Math.max(1, n) * 1.122807f));
    }

    static float calculateTitleScale(float f) {
        float f2 = GuiMainMenu.clamp(f);
        float f3 = 1.0f - (float)Math.pow(1.0f - f2, 3.0);
        return 1.0f + (1.0f - f3) * 0.12f;
    }

    static float calculateTitleToggleScale(float f) {
        float f2 = GuiMainMenu.clamp(f);
        float f3 = 1.0f - (float)Math.pow(1.0f - f2, 3.0);
        return 0.35f + 0.65f * f3;
    }

    private float getTitleToggleScale(long l) {
        if (this.titleToggleAnimationStartedAt < 0L) {
            return 1.0f;
        }
        float f = GuiMainMenu.clamp((float)(l - this.titleToggleAnimationStartedAt) / 2.6E8f);
        if (f >= 1.0f) {
            this.titleToggleAnimationStartedAt = -1L;
            return 1.0f;
        }
        return GuiMainMenu.calculateTitleToggleScale(f);
    }

    static boolean isPointInsideTitle(int n, int n2, int n3, int n4, int n5, int n6, float f, int n7) {
        int n8 = Math.max(0, n7);
        float f2 = Math.max(0.0f, f);
        return n >= n3 - n8 && (float)n < (float)n3 + (float)Math.max(1, n5) * f2 + (float)n8 && n2 >= n4 - n8 && (float)n2 < (float)n4 + (float)Math.max(1, n6) * f2 + (float)n8;
    }

    private boolean isTitleClicked(int n, int n2) {
        float f = this.getEntranceProgress();
        if (f <= 0.01f) {
            return false;
        }
        int n3 = this.getTitleWidth();
        return GuiMainMenu.isPointInsideTitle(n, n2, this.contentMargin, this.contentMargin, n3, this.titleFont.z$1tqmx4tpnr6lq(), GuiMainMenu.calculateTitleScale(f), 2);
    }

    private int getTitleWidth() {
        return this.titleLogoVisible ? GuiMainMenu.calculateTitleLogoWidth(this.titleFont.z$1tqmx4tpnr6lq()) : this.titleFont.z$toz8pt08w0nc(TITLE_TEXT);
    }

    private void toggleTitle() {
        this.titleLogoVisible = !this.titleLogoVisible;
        this.titleToggleAnimationStartedAt = System.nanoTime();
        if (this.preferences != null) {
            this.preferences.\u038a(this.titleLogoVisible ? oc373d6c4e35.\u0425 : oc373d6c4e35.\u03cd);
        }
        this.playNextFriendlyCatSound();
    }

    private void playNextFriendlyCatSound() {
        if (this.activeCatSound != null) {
            this.mc.getSoundHandler().stopSound(this.activeCatSound);
        }
        ResourceLocation resourceLocation = FRIENDLY_CAT_SOUNDS[this.nextCatSoundIndex];
        this.nextCatSoundIndex = (this.nextCatSoundIndex + 1) % FRIENDLY_CAT_SOUNDS.length;
        this.activeCatSound = PositionedSoundRecord.create(resourceLocation);
        this.mc.getSoundHandler().playSound(this.activeCatSound);
    }

    static String ellipsize(String string, oc1378bc114d oc1378bc114d2, int n) {
        if (string == null || oc1378bc114d2 == null || n <= 0) {
            return "";
        }
        if (oc1378bc114d2.z$toz8pt08w0nc(string) <= n) {
            return string;
        }
        String string2 = "...";
        int n2 = n - oc1378bc114d2.z$toz8pt08w0nc(string2);
        if (n2 <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            stringBuilder.append(string.charAt(i));
            if (oc1378bc114d2.z$toz8pt08w0nc(stringBuilder.toString()) <= n2) continue;
            stringBuilder.setLength(stringBuilder.length() - 1);
            break;
        }
        return stringBuilder.append(string2).toString();
    }

    private static String formatReleaseName(String string) {
        String string2;
        String string3 = string2 = string == null ? "" : string.trim();
        if (string2.isEmpty()) {
            return "Latest release";
        }
        return string2.charAt(0) == 'v' || string2.charAt(0) == 'V' ? string2 : "v" + string2;
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        if (this.getBootTransitionProgress(System.nanoTime()) >= 1.0f) {
            if (n3 == 0 && this.isTitleClicked(n, n2)) {
                this.toggleTitle();
                return;
            }
            if (n3 == 0 && n >= this.contentMargin && n < this.contentMargin + this.changelogWidth && n2 >= this.changelogTop && n2 < this.changelogTop + this.changelogHeight) {
                this.mc.displayGuiScreen(new oc19a6b77031(this));
                return;
            }
            super.mouseClicked(n, n2, n3);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}

