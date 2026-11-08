/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.gui;

import com.mojang.authlib.exceptions.InvalidCredentialsException;
import java.math.BigInteger;
import java.net.URI;
import java.util.Random;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.src.Config;
import net.optifine.Lang;
import net.optifine.gui.GuiButtonOF;
import net.optifine.gui.GuiScreenOF;

public class GuiScreenCapeOF
extends GuiScreenOF {
    private final GuiScreen parentScreen;
    private String title;
    private String message;
    private long messageHideTimeMs;
    private String linkUrl;
    private GuiButtonOF buttonCopyLink;
    private FontRenderer fontRenderer;

    public GuiScreenCapeOF(GuiScreen guiScreen) {
        this.fontRenderer = Config.getMinecraft().fontRendererObj;
        this.parentScreen = guiScreen;
    }

    @Override
    public void initGui() {
        int n = 0;
        this.title = I18n.format("of.options.capeOF.title", new Object[0]);
        this.buttonList.add(new GuiButtonOF(210, this.width / 2 - 155, this.height / 6 + 24 * ((n += 2) >> 1), 150, 20, I18n.format("of.options.capeOF.openEditor", new Object[0])));
        this.buttonList.add(new GuiButtonOF(220, this.width / 2 - 155 + 160, this.height / 6 + 24 * (n >> 1), 150, 20, I18n.format("of.options.capeOF.reloadCape", new Object[0])));
        this.buttonCopyLink = new GuiButtonOF(230, this.width / 2 - 100, this.height / 6 + 24 * ((n += 6) >> 1), 200, 20, I18n.format("of.options.capeOF.copyEditorLink", new Object[0]));
        this.buttonCopyLink.visible = this.linkUrl != null;
        this.buttonList.add(this.buttonCopyLink);
        this.buttonList.add(new GuiButtonOF(200, this.width / 2 - 100, this.height / 6 + 24 * ((n += 4) >> 1), I18n.format("gui.done", new Object[0])));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            if (guiButton.id == 200) {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            if (guiButton.id == 210) {
                try {
                    String string = this.mc.getSession().getProfile().getName();
                    String string2 = this.mc.getSession().getProfile().getId().toString().replace("-", "");
                    String string3 = this.mc.getSession().getToken();
                    Random random = new Random();
                    Random random2 = new Random(System.identityHashCode(new Object()));
                    BigInteger bigInteger = new BigInteger(128, random);
                    BigInteger bigInteger2 = new BigInteger(128, random2);
                    BigInteger bigInteger3 = bigInteger.xor(bigInteger2);
                    String string4 = bigInteger3.toString(16);
                    this.mc.getSessionService().joinServer(this.mc.getSession().getProfile(), string3, string4);
                    String string5 = "https://optifine.net/capeChange?u=" + string2 + "&n=" + string + "&s=" + string4;
                    boolean bl = Config.openWebLink(new URI(string5));
                    if (bl) {
                        this.showMessage(Lang.get("of.message.capeOF.openEditor"), 10000L);
                    } else {
                        this.showMessage(Lang.get("of.message.capeOF.openEditorError"), 10000L);
                        this.setLinkUrl(string5);
                    }
                }
                catch (InvalidCredentialsException invalidCredentialsException) {
                    Config.showGuiMessage(I18n.format("of.message.capeOF.error1", new Object[0]), I18n.format("of.message.capeOF.error2", invalidCredentialsException.getMessage()));
                    Config.warn("Mojang authentication failed");
                    Config.warn(invalidCredentialsException.getClass().getName() + ": " + invalidCredentialsException.getMessage());
                }
                catch (Exception exception) {
                    Config.warn("Error opening OptiFine cape link");
                    Config.warn(exception.getClass().getName() + ": " + exception.getMessage());
                }
            }
            if (guiButton.id == 220) {
                this.showMessage(Lang.get("of.message.capeOF.reloadCape"), 15000L);
                if (this.mc.thePlayer != null) {
                    long l = 15000L;
                    long l2 = System.currentTimeMillis() + l;
                    this.mc.thePlayer.setReloadCapeTimeMs(l2);
                }
            }
            if (guiButton.id == 230 && this.linkUrl != null) {
                GuiScreenCapeOF.setClipboardString(this.linkUrl);
            }
        }
    }

    private void showMessage(String string, long l) {
        this.message = string;
        this.messageHideTimeMs = System.currentTimeMillis() + l;
        this.setLinkUrl(null);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        if (this.message != null) {
            this.drawCenteredString(this.fontRenderer, this.message, this.width / 2, this.height / 6 + 60, 0xFFFFFF);
            if (System.currentTimeMillis() > this.messageHideTimeMs) {
                this.message = null;
                this.setLinkUrl(null);
            }
        }
        super.drawScreen(n, n2, f);
    }

    public void setLinkUrl(String string) {
        this.linkUrl = string;
        this.buttonCopyLink.visible = string != null;
    }
}

