/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.gui.RealmsConstants;
import com.mojang.realmsclient.gui.screens.RealmsConfigureWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsPlayerScreen;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsEditBox;
import net.minecraft.realms.RealmsScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class RealmsInviteScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private RealmsEditBox profileName;
    private RealmsServer serverData;
    private final RealmsConfigureWorldScreen configureScreen;
    private final RealmsScreen lastScreen;
    private final int BUTTON_INVITE_ID = 0;
    private final int BUTTON_CANCEL_ID = 1;
    private RealmsButton inviteButton;
    private final int PROFILENAME_EDIT_BOX = 2;
    private String errorMsg;
    private boolean showError;

    public RealmsInviteScreen(RealmsConfigureWorldScreen realmsConfigureWorldScreen, RealmsScreen realmsScreen, RealmsServer realmsServer) {
        this.configureScreen = realmsConfigureWorldScreen;
        this.lastScreen = realmsScreen;
        this.serverData = realmsServer;
    }

    @Override
    public void tick() {
        this.profileName.tick();
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        this.inviteButton = RealmsInviteScreen.newButton(0, this.width() / 2 - 100, RealmsConstants.row(10), RealmsInviteScreen.getLocalizedString("mco.configure.world.buttons.invite"));
        this.buttonsAdd(this.inviteButton);
        this.buttonsAdd(RealmsInviteScreen.newButton(1, this.width() / 2 - 100, RealmsConstants.row(12), RealmsInviteScreen.getLocalizedString("gui.cancel")));
        this.profileName = this.newEditBox(2, this.width() / 2 - 100, RealmsConstants.row(2), 200, 20);
        this.profileName.setFocus(true);
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
        switch (realmsButton.id()) {
            case 1: {
                Realms.setScreen(this.lastScreen);
                break;
            }
            case 0: {
                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                if (this.profileName.getValue() == null || this.profileName.getValue().isEmpty()) {
                    return;
                }
                try {
                    RealmsServer realmsServer = realmsClient.invite(this.serverData.id, this.profileName.getValue());
                    if (realmsServer != null) {
                        this.serverData.players = realmsServer.players;
                        Realms.setScreen(new RealmsPlayerScreen(this.configureScreen, this.serverData));
                        break;
                    }
                    this.showError(RealmsInviteScreen.getLocalizedString("mco.configure.world.players.error"));
                }
                catch (Exception exception) {
                    LOGGER.error("Couldn't invite user");
                    this.showError(RealmsInviteScreen.getLocalizedString("mco.configure.world.players.error"));
                }
                break;
            }
            default: {
                return;
            }
        }
    }

    private void showError(String string) {
        this.showError = true;
        this.errorMsg = string;
    }

    @Override
    public void keyPressed(char c, int n) {
        this.profileName.keyPressed(c, n);
        if (n == 15) {
            if (this.profileName.isFocused()) {
                this.profileName.setFocus(false);
            } else {
                this.profileName.setFocus(true);
            }
        }
        if (n == 28 || n == 156) {
            this.buttonClicked(this.inviteButton);
        }
        if (n == 1) {
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.profileName.mouseClicked(n, n2, n3);
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        this.drawString(RealmsInviteScreen.getLocalizedString("mco.configure.world.invite.profile.name"), this.width() / 2 - 100, RealmsConstants.row(1), 0xA0A0A0);
        if (this.showError) {
            this.drawCenteredString(this.errorMsg, this.width() / 2, RealmsConstants.row(5), 0xFF0000);
        }
        this.profileName.render();
        super.render(n, n2, f);
    }
}

