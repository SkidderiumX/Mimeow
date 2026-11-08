/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.gui.RealmsConstants;
import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;
import com.mojang.realmsclient.util.RealmsTasks;
import com.mojang.realmsclient.util.RealmsUtil;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class RealmsTermsScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int BUTTON_AGREE_ID = 1;
    private static final int BUTTON_DISAGREE_ID = 2;
    private final RealmsScreen lastScreen;
    private final RealmsServer realmsServer;
    private RealmsButton agreeButton;
    private boolean onLink = false;
    private String realmsToSUrl = "https://minecraft.net/realms/terms";

    public RealmsTermsScreen(RealmsScreen realmsScreen, RealmsServer realmsServer) {
        this.lastScreen = realmsScreen;
        this.realmsServer = realmsServer;
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        int n = this.width() / 4;
        int n2 = this.width() / 4 - 2;
        int n3 = this.width() / 2 + 4;
        this.agreeButton = RealmsTermsScreen.newButton(1, n, RealmsConstants.row(12), n2, 20, RealmsTermsScreen.getLocalizedString("mco.terms.buttons.agree"));
        this.buttonsAdd(this.agreeButton);
        this.buttonsAdd(RealmsTermsScreen.newButton(2, n3, RealmsConstants.row(12), n2, 20, RealmsTermsScreen.getLocalizedString("mco.terms.buttons.disagree")));
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
            case 2: {
                Realms.setScreen(this.lastScreen);
                break;
            }
            case 1: {
                this.agreedToTos();
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
            Realms.setScreen(this.lastScreen);
        }
    }

    private void agreedToTos() {
        RealmsClient realmsClient = RealmsClient.createRealmsClient();
        try {
            realmsClient.agreeToTos();
            RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(this.lastScreen, new RealmsTasks.RealmsConnectTask(this.lastScreen, this.realmsServer));
            realmsLongRunningMcoTaskScreen.start();
            Realms.setScreen(realmsLongRunningMcoTaskScreen);
        }
        catch (RealmsServiceException realmsServiceException) {
            LOGGER.error("Couldn't agree to TOS");
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (this.onLink) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(this.realmsToSUrl), null);
            RealmsUtil.browseTo(this.realmsToSUrl);
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        this.drawCenteredString(RealmsTermsScreen.getLocalizedString("mco.terms.title"), this.width() / 2, 17, 0xFFFFFF);
        this.drawString(RealmsTermsScreen.getLocalizedString("mco.terms.sentence.1"), this.width() / 2 - 120, RealmsConstants.row(5), 0xFFFFFF);
        int n3 = this.fontWidth(RealmsTermsScreen.getLocalizedString("mco.terms.sentence.1"));
        int n4 = this.width() / 2 - 121 + n3;
        int n5 = RealmsConstants.row(5);
        int n6 = n4 + this.fontWidth("mco.terms.sentence.2") + 1;
        int n7 = n5 + 1 + this.fontLineHeight();
        if (n4 <= n && n <= n6 && n5 <= n2 && n2 <= n7) {
            this.onLink = true;
            this.drawString(" " + RealmsTermsScreen.getLocalizedString("mco.terms.sentence.2"), this.width() / 2 - 120 + n3, RealmsConstants.row(5), 7107012);
        } else {
            this.onLink = false;
            this.drawString(" " + RealmsTermsScreen.getLocalizedString("mco.terms.sentence.2"), this.width() / 2 - 120 + n3, RealmsConstants.row(5), 0x3366BB);
        }
        super.render(n, n2, f);
    }
}

