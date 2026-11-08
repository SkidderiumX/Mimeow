/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.RealmsMainScreen;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.RealmsWorldOptions;
import com.mojang.realmsclient.dto.WorldTemplate;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.gui.RealmsConstants;
import com.mojang.realmsclient.gui.RealmsHideableButton;
import com.mojang.realmsclient.gui.screens.RealmsBackupScreen;
import com.mojang.realmsclient.gui.screens.RealmsGenericErrorScreen;
import com.mojang.realmsclient.gui.screens.RealmsLongConfirmationScreen;
import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;
import com.mojang.realmsclient.gui.screens.RealmsPlayerScreen;
import com.mojang.realmsclient.gui.screens.RealmsResetWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsScreenWithCallback;
import com.mojang.realmsclient.gui.screens.RealmsSelectWorldTemplateScreen;
import com.mojang.realmsclient.gui.screens.RealmsSettingsScreen;
import com.mojang.realmsclient.gui.screens.RealmsSlotOptionsScreen;
import com.mojang.realmsclient.gui.screens.RealmsSubscriptionInfoScreen;
import com.mojang.realmsclient.util.RealmsTasks;
import com.mojang.realmsclient.util.RealmsTextureManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsMth;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsSharedConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class RealmsConfigureWorldScreen
extends RealmsScreenWithCallback<WorldTemplate> {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ON_ICON_LOCATION = "realms:textures/gui/realms/on_icon.png";
    private static final String OFF_ICON_LOCATION = "realms:textures/gui/realms/off_icon.png";
    private static final String EXPIRED_ICON_LOCATION = "realms:textures/gui/realms/expired_icon.png";
    private static final String EXPIRES_SOON_ICON_LOCATION = "realms:textures/gui/realms/expires_soon_icon.png";
    private static final String SLOT_FRAME_LOCATION = "realms:textures/gui/realms/slot_frame.png";
    private static final String EMPTY_FRAME_LOCATION = "realms:textures/gui/realms/empty_frame.png";
    private String toolTip;
    private final RealmsScreen lastScreen;
    private RealmsServer serverData;
    private volatile long serverId;
    private int left_x;
    private int right_x;
    private int default_button_width = 80;
    private int default_button_offset = 5;
    private static final int BUTTON_BACK_ID = 0;
    private static final int BUTTON_PLAYERS_ID = 2;
    private static final int BUTTON_SETTINGS_ID = 3;
    private static final int BUTTON_SUBSCRIPTION_ID = 4;
    private static final int BUTTON_OPTIONS_ID = 5;
    private static final int BUTTON_BACKUP_ID = 6;
    private static final int BUTTON_RESET_WORLD_ID = 7;
    private static final int BUTTON_SWITCH_MINIGAME_ID = 8;
    private static final int SWITCH_SLOT_ID = 9;
    private static final int SWITCH_SLOT_ID_EMPTY = 10;
    private static final int SWITCH_SLOT_ID_RESULT = 11;
    private RealmsButton playersButton;
    private RealmsButton settingsButton;
    private RealmsButton subscriptionButton;
    private RealmsHideableButton optionsButton;
    private RealmsHideableButton backupButton;
    private RealmsHideableButton resetWorldButton;
    private RealmsHideableButton switchMinigameButton;
    private boolean stateChanged;
    private int hoveredSlot = -1;
    private int animTick;
    private int clicks = 0;
    private boolean hoveredActiveSlot = false;

    public RealmsConfigureWorldScreen(RealmsScreen realmsScreen, long l) {
        this.lastScreen = realmsScreen;
        this.serverId = l;
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
    }

    @Override
    public void init() {
        if (this.serverData == null) {
            this.fetchServerData(this.serverId);
        }
        this.left_x = this.width() / 2 - 187;
        this.right_x = this.width() / 2 + 190;
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        this.playersButton = RealmsConfigureWorldScreen.newButton(2, this.centerButton(0, 3), RealmsConstants.row(0), this.default_button_width, 20, RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.buttons.players"));
        this.buttonsAdd(this.playersButton);
        this.settingsButton = RealmsConfigureWorldScreen.newButton(3, this.centerButton(1, 3), RealmsConstants.row(0), this.default_button_width, 20, RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.buttons.settings"));
        this.buttonsAdd(this.settingsButton);
        this.subscriptionButton = RealmsConfigureWorldScreen.newButton(4, this.centerButton(2, 3), RealmsConstants.row(0), this.default_button_width, 20, RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.buttons.subscription"));
        this.buttonsAdd(this.subscriptionButton);
        this.optionsButton = new RealmsHideableButton(5, this.leftButton(0), RealmsConstants.row(13) - 5, this.default_button_width + 10, 20, RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.buttons.options"));
        this.buttonsAdd(this.optionsButton);
        this.backupButton = new RealmsHideableButton(6, this.leftButton(1), RealmsConstants.row(13) - 5, this.default_button_width + 10, 20, RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.backup"));
        this.buttonsAdd(this.backupButton);
        this.resetWorldButton = new RealmsHideableButton(7, this.leftButton(2), RealmsConstants.row(13) - 5, this.default_button_width + 10, 20, RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.buttons.resetworld"));
        this.buttonsAdd(this.resetWorldButton);
        this.switchMinigameButton = new RealmsHideableButton(8, this.leftButton(0), RealmsConstants.row(13) - 5, this.default_button_width + 20, 20, RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.buttons.switchminigame"));
        this.buttonsAdd(this.switchMinigameButton);
        this.buttonsAdd(RealmsConfigureWorldScreen.newButton(0, this.right_x - this.default_button_width + 8, RealmsConstants.row(13) - 5, this.default_button_width - 10, 20, RealmsConfigureWorldScreen.getLocalizedString("gui.back")));
        this.backupButton.active(true);
        if (this.serverData == null) {
            this.hideMinigameButtons();
            this.hideRegularButtons();
            this.playersButton.active(false);
            this.settingsButton.active(false);
            this.subscriptionButton.active(false);
        } else {
            this.disableButtons();
            if (this.isMinigame()) {
                this.hideRegularButtons();
            } else {
                this.hideMinigameButtons();
            }
        }
    }

    private int leftButton(int n) {
        return this.left_x + n * (this.default_button_width + 10 + this.default_button_offset);
    }

    private int centerButton(int n, int n2) {
        return this.width() / 2 - (n2 * (this.default_button_width + this.default_button_offset) - this.default_button_offset) / 2 + n * (this.default_button_width + this.default_button_offset);
    }

    @Override
    public void tick() {
        ++this.animTick;
        --this.clicks;
        if (this.clicks < 0) {
            this.clicks = 0;
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.toolTip = null;
        this.hoveredActiveSlot = false;
        this.hoveredSlot = -1;
        this.renderBackground();
        this.drawCenteredString(RealmsConfigureWorldScreen.getLocalizedString("mco.configure.worlds.title"), this.width() / 2, RealmsConstants.row(4), 0xFFFFFF);
        super.render(n, n2, f);
        if (this.serverData == null) {
            this.drawCenteredString(RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.title"), this.width() / 2, 17, 0xFFFFFF);
            return;
        }
        String string = this.serverData.getName();
        int n3 = this.fontWidth(string);
        int n4 = this.serverData.state == RealmsServer.State.CLOSED ? 0xA0A0A0 : 0x7FFF7F;
        int n5 = this.fontWidth(RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.title"));
        this.drawCenteredString(RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.title"), this.width() / 2, 12, 0xFFFFFF);
        this.drawCenteredString(string, this.width() / 2, 24, n4);
        int n6 = Math.min(this.centerButton(2, 3) + this.default_button_width - 11, this.width() / 2 + n3 / 2 + n5 / 2 + 10);
        this.drawServerStatus(n6, 7, n, n2);
        for (Map.Entry<Integer, RealmsWorldOptions> entry : this.serverData.slots.entrySet()) {
            if (entry.getValue().templateImage != null && entry.getValue().templateId != -1L) {
                this.drawSlotFrame(this.frame(entry.getKey()), RealmsConstants.row(5) + 5, n, n2, this.serverData.activeSlot == entry.getKey() && !this.isMinigame(), entry.getValue().getSlotName(entry.getKey()), entry.getKey(), entry.getValue().templateId, entry.getValue().templateImage, entry.getValue().empty);
                continue;
            }
            this.drawSlotFrame(this.frame(entry.getKey()), RealmsConstants.row(5) + 5, n, n2, this.serverData.activeSlot == entry.getKey() && !this.isMinigame(), entry.getValue().getSlotName(entry.getKey()), entry.getKey(), -1L, null, entry.getValue().empty);
        }
        this.drawSlotFrame(this.frame(4), RealmsConstants.row(5) + 5, n, n2, this.isMinigame(), "Minigame", 4, -1L, null, false);
        if (this.isMinigame()) {
            this.drawString(RealmsConfigureWorldScreen.getLocalizedString("mco.configure.current.minigame") + ": " + this.serverData.getMinigameName(), this.left_x + this.default_button_width + 20 + this.default_button_offset * 2, RealmsConstants.row(13), 0xFFFFFF);
        }
        if (this.toolTip != null) {
            this.renderMousehoverTooltip(this.toolTip, n, n2);
        }
    }

    private int frame(int n) {
        return this.left_x + (n - 1) * 98;
    }

    @Override
    public void removed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (!realmsButton.active()) {
            return;
        }
        if (realmsButton instanceof RealmsHideableButton && !((RealmsHideableButton)realmsButton).getVisible()) {
            return;
        }
        switch (realmsButton.id()) {
            case 2: {
                Realms.setScreen(new RealmsPlayerScreen(this, this.serverData));
                break;
            }
            case 3: {
                Realms.setScreen(new RealmsSettingsScreen(this, this.serverData.clone()));
                break;
            }
            case 4: {
                Realms.setScreen(new RealmsSubscriptionInfoScreen(this, this.serverData.clone(), this.lastScreen));
                break;
            }
            case 0: {
                this.backButtonClicked();
                break;
            }
            case 8: {
                Realms.setScreen(new RealmsSelectWorldTemplateScreen(this, null, true));
                break;
            }
            case 6: {
                Realms.setScreen(new RealmsBackupScreen(this, this.serverData.clone()));
                break;
            }
            case 5: {
                Realms.setScreen(new RealmsSlotOptionsScreen(this, this.serverData.slots.get(this.serverData.activeSlot).clone(), this.serverData.worldType, this.serverData.activeSlot));
                break;
            }
            case 7: {
                Realms.setScreen(new RealmsResetWorldScreen(this, this.serverData.clone(), this.getNewScreen()));
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            this.backButtonClicked();
        }
    }

    private void backButtonClicked() {
        if (this.stateChanged) {
            ((RealmsMainScreen)this.lastScreen).removeSelection();
        }
        Realms.setScreen(this.lastScreen);
    }

    private void fetchServerData(final long l) {
        new Thread(){

            @Override
            public void run() {
                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                try {
                    RealmsConfigureWorldScreen.this.serverData = realmsClient.getOwnWorld(l);
                    RealmsConfigureWorldScreen.this.disableButtons();
                    if (RealmsConfigureWorldScreen.this.isMinigame()) {
                        RealmsConfigureWorldScreen.this.showMinigameButtons();
                    } else {
                        RealmsConfigureWorldScreen.this.showRegularButtons();
                    }
                }
                catch (RealmsServiceException realmsServiceException) {
                    LOGGER.error("Couldn't get own world");
                    Realms.setScreen(new RealmsGenericErrorScreen(realmsServiceException.getMessage(), RealmsConfigureWorldScreen.this.lastScreen));
                }
                catch (IOException iOException) {
                    LOGGER.error("Couldn't parse response getting own world");
                }
            }
        }.start();
    }

    private void disableButtons() {
        this.playersButton.active(!this.serverData.expired);
        this.settingsButton.active(!this.serverData.expired);
        this.subscriptionButton.active(true);
        this.switchMinigameButton.active(!this.serverData.expired);
        this.optionsButton.active(!this.serverData.expired);
        this.resetWorldButton.active(!this.serverData.expired);
    }

    @Override
    public void confirmResult(boolean bl, int n) {
        switch (n) {
            case 9: {
                if (bl) {
                    this.switchSlot();
                    break;
                }
                Realms.setScreen(this);
                break;
            }
            case 10: {
                if (bl) {
                    RealmsResetWorldScreen realmsResetWorldScreen = new RealmsResetWorldScreen(this, this.serverData, this.getNewScreen(), RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.switch.slot"), RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.switch.slot.subtitle"), 0xA0A0A0, RealmsConfigureWorldScreen.getLocalizedString("gui.cancel"));
                    realmsResetWorldScreen.setSlot(this.hoveredSlot);
                    realmsResetWorldScreen.setResetTitle(RealmsConfigureWorldScreen.getLocalizedString("mco.create.world.reset.title"));
                    Realms.setScreen(realmsResetWorldScreen);
                    break;
                }
                Realms.setScreen(this);
                break;
            }
            case 11: {
                Realms.setScreen(this);
            }
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (n3 == 0) {
            this.clicks += RealmsSharedConstants.TICKS_PER_SECOND / 3 + 1;
        } else {
            return;
        }
        if (this.hoveredSlot != -1) {
            if (this.hoveredSlot < 4) {
                String string = RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.slot.switch.question.line1");
                String string2 = RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.slot.switch.question.line2");
                if (this.serverData.slots.get((Object)Integer.valueOf((int)this.hoveredSlot)).empty) {
                    Realms.setScreen(new RealmsLongConfirmationScreen(this, RealmsLongConfirmationScreen.Type.Info, string, string2, true, 10));
                } else {
                    Realms.setScreen(new RealmsLongConfirmationScreen(this, RealmsLongConfirmationScreen.Type.Info, string, string2, true, 9));
                }
            } else if (!this.isMinigame() && !this.serverData.expired) {
                RealmsSelectWorldTemplateScreen realmsSelectWorldTemplateScreen = new RealmsSelectWorldTemplateScreen(this, null, true);
                realmsSelectWorldTemplateScreen.setWarning(RealmsConfigureWorldScreen.getLocalizedString("mco.minigame.world.info"));
                Realms.setScreen(realmsSelectWorldTemplateScreen);
            }
        } else if (this.clicks >= RealmsSharedConstants.TICKS_PER_SECOND / 2 && this.hoveredActiveSlot && (this.serverData.state == RealmsServer.State.OPEN || this.serverData.state == RealmsServer.State.CLOSED)) {
            if (this.serverData.state == RealmsServer.State.OPEN) {
                ((RealmsMainScreen)this.lastScreen).play(this.serverData);
            } else {
                this.openTheWorld(true, this);
            }
        }
        super.mouseClicked(n, n2, n3);
    }

    protected void renderMousehoverTooltip(String string, int n, int n2) {
        if (string == null) {
            return;
        }
        int n3 = n + 12;
        int n4 = n2 - 12;
        int n5 = this.fontWidth(string);
        if (n3 + n5 + 3 > this.right_x) {
            n3 = n3 - n5 - 20;
        }
        this.fillGradient(n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 8 + 3, -1073741824, -1073741824);
        this.fontDrawShadow(string, n3, n4, 0xFFFFFF);
    }

    private void drawServerStatus(int n, int n2, int n3, int n4) {
        if (this.serverData.expired) {
            this.drawExpired(n, n2, n3, n4);
        } else if (this.serverData.state == RealmsServer.State.CLOSED) {
            this.drawClose(n, n2, n3, n4);
        } else if (this.serverData.state == RealmsServer.State.OPEN) {
            if (this.serverData.daysLeft < 7) {
                this.drawExpiring(n, n2, n3, n4, this.serverData.daysLeft);
            } else {
                this.drawOpen(n, n2, n3, n4);
            }
        }
    }

    private void drawExpired(int n, int n2, int n3, int n4) {
        RealmsScreen.bind(EXPIRED_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, 0.0f, 10, 28, 10.0f, 28.0f);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 27) {
            this.toolTip = RealmsConfigureWorldScreen.getLocalizedString("mco.selectServer.expired");
        }
    }

    private void drawExpiring(int n, int n2, int n3, int n4, int n5) {
        RealmsScreen.bind(EXPIRES_SOON_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        if (this.animTick % 20 < 10) {
            RealmsScreen.blit(n, n2, 0.0f, 0.0f, 10, 28, 20.0f, 28.0f);
        } else {
            RealmsScreen.blit(n, n2, 10.0f, 0.0f, 10, 28, 20.0f, 28.0f);
        }
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 27) {
            this.toolTip = n5 <= 0 ? RealmsConfigureWorldScreen.getLocalizedString("mco.selectServer.expires.soon") : (n5 == 1 ? RealmsConfigureWorldScreen.getLocalizedString("mco.selectServer.expires.day") : RealmsConfigureWorldScreen.getLocalizedString("mco.selectServer.expires.days", n5));
        }
    }

    private void drawOpen(int n, int n2, int n3, int n4) {
        RealmsScreen.bind(ON_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, 0.0f, 10, 28, 10.0f, 28.0f);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 27) {
            this.toolTip = RealmsConfigureWorldScreen.getLocalizedString("mco.selectServer.open");
        }
    }

    private void drawClose(int n, int n2, int n3, int n4) {
        RealmsScreen.bind(OFF_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, 0.0f, 10, 28, 10.0f, 28.0f);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 27) {
            this.toolTip = RealmsConfigureWorldScreen.getLocalizedString("mco.selectServer.closed");
        }
    }

    private boolean isMinigame() {
        return this.serverData != null && this.serverData.worldType.equals((Object)RealmsServer.WorldType.MINIGAME);
    }

    private void drawSlotFrame(int n, int n2, int n3, int n4, boolean bl, String string, int n5, long l, String string2, boolean bl2) {
        if (n3 >= n && n3 <= n + 80 && n4 >= n2 && n4 <= n2 + 80 && (!this.isMinigame() && this.serverData.activeSlot != n5 || this.isMinigame() && n5 != 4) && (n5 != 4 || !this.serverData.expired)) {
            this.hoveredSlot = n5;
            String string3 = this.toolTip = n5 == 4 ? RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.slot.tooltip.minigame") : RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.slot.tooltip");
        }
        if (n3 >= n && n3 <= n + 80 && n4 >= n2 && n4 <= n2 + 80 && (!this.isMinigame() && this.serverData.activeSlot == n5 || this.isMinigame() && n5 == 4) && !this.serverData.expired && (this.serverData.state == RealmsServer.State.OPEN || this.serverData.state == RealmsServer.State.CLOSED)) {
            this.hoveredActiveSlot = true;
            this.toolTip = RealmsConfigureWorldScreen.getLocalizedString("mco.configure.world.slot.tooltip.active");
        }
        if (bl2) {
            RealmsConfigureWorldScreen.bind(EMPTY_FRAME_LOCATION);
        } else if (string2 != null && l != -1L) {
            RealmsTextureManager.bindWorldTemplate(String.valueOf(l), string2);
        } else if (n5 == 1) {
            RealmsConfigureWorldScreen.bind("textures/gui/title/background/panorama_0.png");
        } else if (n5 == 2) {
            RealmsConfigureWorldScreen.bind("textures/gui/title/background/panorama_2.png");
        } else if (n5 == 3) {
            RealmsConfigureWorldScreen.bind("textures/gui/title/background/panorama_3.png");
        } else {
            RealmsTextureManager.bindWorldTemplate(String.valueOf(this.serverData.minigameId), this.serverData.minigameImage);
        }
        if (!bl) {
            GL11.glColor4f(0.56f, 0.56f, 0.56f, 1.0f);
        } else if (bl) {
            float f = 0.9f + 0.1f * RealmsMth.cos((float)this.animTick * 0.2f);
            GL11.glColor4f(f, f, f, 1.0f);
        }
        RealmsScreen.blit(n + 3, n2 + 3, 0.0f, 0.0f, 74, 74, 74.0f, 74.0f);
        RealmsConfigureWorldScreen.bind(SLOT_FRAME_LOCATION);
        if (this.hoveredSlot == n5) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        } else if (!bl) {
            GL11.glColor4f(0.56f, 0.56f, 0.56f, 1.0f);
        } else {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        RealmsScreen.blit(n, n2, 0.0f, 0.0f, 80, 80, 80.0f, 80.0f);
        this.drawCenteredString(string, n + 40, n2 + 66, 0xFFFFFF);
    }

    private void hideRegularButtons() {
        this.optionsButton.setVisible(false);
        this.backupButton.setVisible(false);
        this.resetWorldButton.setVisible(false);
    }

    private void hideMinigameButtons() {
        this.switchMinigameButton.setVisible(false);
    }

    private void showRegularButtons() {
        this.optionsButton.setVisible(true);
        this.backupButton.setVisible(true);
        this.resetWorldButton.setVisible(true);
    }

    private void showMinigameButtons() {
        this.switchMinigameButton.setVisible(true);
    }

    public void saveSlotSettings() {
        RealmsClient realmsClient = RealmsClient.createRealmsClient();
        try {
            realmsClient.updateSlot(this.serverData.id, this.serverData.activeSlot, this.serverData.slots.get(this.serverData.activeSlot));
        }
        catch (RealmsServiceException realmsServiceException) {
            LOGGER.error("Couldn't save slot settings");
            Realms.setScreen(new RealmsGenericErrorScreen(realmsServiceException, (RealmsScreen)this));
            return;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            LOGGER.error("Couldn't save slot settings");
        }
        Realms.setScreen(this);
    }

    public void saveSlotSettings(RealmsWorldOptions realmsWorldOptions) {
        RealmsWorldOptions realmsWorldOptions2 = this.serverData.slots.get(this.serverData.activeSlot);
        realmsWorldOptions.templateId = realmsWorldOptions2.templateId;
        realmsWorldOptions.templateImage = realmsWorldOptions2.templateImage;
        this.serverData.slots.put(this.serverData.activeSlot, realmsWorldOptions);
        this.saveSlotSettings();
    }

    public void saveServerData() {
        RealmsClient realmsClient = RealmsClient.createRealmsClient();
        try {
            realmsClient.update(this.serverData.id, this.serverData.getName(), this.serverData.getDescription());
        }
        catch (RealmsServiceException realmsServiceException) {
            LOGGER.error("Couldn't save settings");
            Realms.setScreen(new RealmsGenericErrorScreen(realmsServiceException, (RealmsScreen)this));
            return;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            LOGGER.error("Couldn't save settings");
        }
        Realms.setScreen(this);
    }

    public void saveSettings(String string, String string2) {
        String string3 = string2 == null || string2.trim().equals("") ? null : string2;
        this.serverData.setName(string);
        this.serverData.setDescription(string3);
        this.saveServerData();
    }

    public void openTheWorld(boolean bl, RealmsScreen realmsScreen) {
        RealmsTasks.OpenServerTask openServerTask = new RealmsTasks.OpenServerTask(this.serverData, this, this.lastScreen, bl);
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(realmsScreen, openServerTask);
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    public void closeTheWorld(RealmsScreen realmsScreen) {
        RealmsTasks.CloseServerTask closeServerTask = new RealmsTasks.CloseServerTask(this.serverData, this);
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(realmsScreen, closeServerTask);
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    public void stateChanged() {
        this.stateChanged = true;
    }

    @Override
    void callback(WorldTemplate worldTemplate) {
        if (worldTemplate == null) {
            return;
        }
        if (worldTemplate.minigame) {
            this.switchMinigame(worldTemplate);
        }
    }

    private void switchSlot() {
        RealmsTasks.SwitchSlotTask switchSlotTask = new RealmsTasks.SwitchSlotTask(this.serverData.id, this.hoveredSlot, this.getNewScreen(), 11);
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(this.lastScreen, switchSlotTask);
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    private void switchMinigame(WorldTemplate worldTemplate) {
        RealmsTasks.SwitchMinigameTask switchMinigameTask = new RealmsTasks.SwitchMinigameTask(this.serverData.id, worldTemplate, this.getNewScreen());
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(this.lastScreen, switchMinigameTask);
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    public RealmsConfigureWorldScreen getNewScreen() {
        return new RealmsConfigureWorldScreen(this.lastScreen, this.serverId);
    }
}

