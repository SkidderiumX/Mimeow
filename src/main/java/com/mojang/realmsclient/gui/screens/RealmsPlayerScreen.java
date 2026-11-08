/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.Ops;
import com.mojang.realmsclient.dto.PlayerInfo;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.gui.RealmsConstants;
import com.mojang.realmsclient.gui.screens.RealmsActivityScreen;
import com.mojang.realmsclient.gui.screens.RealmsConfigureWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsConfirmScreen;
import com.mojang.realmsclient.gui.screens.RealmsInviteScreen;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsClickableScrolledSelectionList;
import net.minecraft.realms.RealmsDefaultVertexFormat;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.Tezzelator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class RealmsPlayerScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String OP_ICON_LOCATION = "realms:textures/gui/realms/op_icon.png";
    private static final String USER_ICON_LOCATION = "realms:textures/gui/realms/user_icon.png";
    private static final String CROSS_ICON_LOCATION = "realms:textures/gui/realms/cross_player_icon.png";
    private String toolTip;
    private final RealmsConfigureWorldScreen lastScreen;
    private RealmsServer serverData;
    private InvitedSelectionList invitedSelectionList;
    private int column1_x;
    private int column_width;
    private int column2_x;
    private static final int BUTTON_BACK_ID = 0;
    private static final int BUTTON_INVITE_ID = 1;
    private static final int BUTTON_UNINVITE_ID = 2;
    private static final int BUTTON_ACTIVITY_ID = 3;
    private RealmsButton inviteButton;
    private RealmsButton activityButton;
    private int selectedInvitedIndex = -1;
    private String selectedInvited;
    private boolean stateChanged;

    public RealmsPlayerScreen(RealmsConfigureWorldScreen realmsConfigureWorldScreen, RealmsServer realmsServer) {
        this.lastScreen = realmsConfigureWorldScreen;
        this.serverData = realmsServer;
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
        if (this.invitedSelectionList != null) {
            this.invitedSelectionList.mouseEvent();
        }
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void init() {
        this.column1_x = this.width() / 2 - 160;
        this.column_width = 150;
        this.column2_x = this.width() / 2 + 12;
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        this.inviteButton = RealmsPlayerScreen.newButton(1, this.column2_x, RealmsConstants.row(1), this.column_width + 10, 20, RealmsPlayerScreen.getLocalizedString("mco.configure.world.buttons.invite"));
        this.buttonsAdd(this.inviteButton);
        this.activityButton = RealmsPlayerScreen.newButton(3, this.column2_x, RealmsConstants.row(3), this.column_width + 10, 20, RealmsPlayerScreen.getLocalizedString("mco.configure.world.buttons.activity"));
        this.buttonsAdd(this.activityButton);
        this.buttonsAdd(RealmsPlayerScreen.newButton(0, this.column2_x + this.column_width / 2 + 2, RealmsConstants.row(12), this.column_width / 2 + 10 - 2, 20, RealmsPlayerScreen.getLocalizedString("gui.back")));
        this.invitedSelectionList = new InvitedSelectionList();
        this.invitedSelectionList.setLeftPos(this.column1_x);
        this.inviteButton.active(false);
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
            case 0: {
                this.backButtonClicked();
                break;
            }
            case 1: {
                Realms.setScreen(new RealmsInviteScreen(this.lastScreen, this, this.serverData));
                break;
            }
            case 3: {
                Realms.setScreen(new RealmsActivityScreen(this, this.serverData));
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
            Realms.setScreen(this.lastScreen.getNewScreen());
        } else {
            Realms.setScreen(this.lastScreen);
        }
    }

    private void op(int n) {
        RealmsClient realmsClient = RealmsClient.createRealmsClient();
        String string = this.serverData.players.get(n).getUuid();
        try {
            this.updateOps(realmsClient.op(this.serverData.id, string));
        }
        catch (RealmsServiceException realmsServiceException) {
            LOGGER.error("Couldn't op the user");
        }
    }

    private void deop(int n) {
        RealmsClient realmsClient = RealmsClient.createRealmsClient();
        String string = this.serverData.players.get(n).getUuid();
        try {
            this.updateOps(realmsClient.deop(this.serverData.id, string));
        }
        catch (RealmsServiceException realmsServiceException) {
            LOGGER.error("Couldn't deop the user");
        }
    }

    private void updateOps(Ops ops) {
        for (PlayerInfo playerInfo : this.serverData.players) {
            playerInfo.setOperator(ops.ops.contains(playerInfo.getName()));
        }
    }

    private void uninvite(int n) {
        if (n >= 0 && n < this.serverData.players.size()) {
            PlayerInfo playerInfo = this.serverData.players.get(n);
            this.selectedInvited = playerInfo.getUuid();
            this.selectedInvitedIndex = n;
            RealmsConfirmScreen realmsConfirmScreen = new RealmsConfirmScreen(this, "Question", RealmsPlayerScreen.getLocalizedString("mco.configure.world.uninvite.question") + " '" + playerInfo.getName() + "' ?", 2);
            Realms.setScreen(realmsConfirmScreen);
        }
    }

    @Override
    public void confirmResult(boolean bl, int n) {
        if (n == 2) {
            if (bl) {
                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                try {
                    realmsClient.uninvite(this.serverData.id, this.selectedInvited);
                }
                catch (RealmsServiceException realmsServiceException) {
                    LOGGER.error("Couldn't uninvite user");
                }
                this.deleteFromInvitedList(this.selectedInvitedIndex);
            }
            this.stateChanged = true;
            Realms.setScreen(this);
        }
    }

    private void deleteFromInvitedList(int n) {
        this.serverData.players.remove(n);
    }

    @Override
    public void render(int n, int n2, float f) {
        this.toolTip = null;
        this.renderBackground();
        if (this.invitedSelectionList != null) {
            this.invitedSelectionList.render(n, n2, f);
        }
        int n3 = RealmsConstants.row(12) + 20;
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tezzelator tezzelator = Tezzelator.instance;
        RealmsPlayerScreen.bind("textures/gui/options_background.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f2 = 32.0f;
        tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_TEX_COLOR);
        tezzelator.vertex(0.0, this.height(), 0.0).tex(0.0, (float)(this.height() - n3) / 32.0f + 0.0f).color(64, 64, 64, 255).endVertex();
        tezzelator.vertex(this.width(), this.height(), 0.0).tex((float)this.width() / 32.0f, (float)(this.height() - n3) / 32.0f + 0.0f).color(64, 64, 64, 255).endVertex();
        tezzelator.vertex(this.width(), n3, 0.0).tex((float)this.width() / 32.0f, 0.0).color(64, 64, 64, 255).endVertex();
        tezzelator.vertex(0.0, n3, 0.0).tex(0.0, 0.0).color(64, 64, 64, 255).endVertex();
        tezzelator.end();
        this.drawCenteredString(RealmsPlayerScreen.getLocalizedString("mco.configure.world.players.title"), this.width() / 2, 17, 0xFFFFFF);
        if (this.serverData != null && this.serverData.players != null) {
            this.drawString(RealmsPlayerScreen.getLocalizedString("mco.configure.world.invited") + " (" + this.serverData.players.size() + ")", this.column1_x, RealmsConstants.row(0), 0xA0A0A0);
            this.inviteButton.active(this.serverData.players.size() < 200);
        } else {
            this.drawString(RealmsPlayerScreen.getLocalizedString("mco.configure.world.invited"), this.column1_x, RealmsConstants.row(0), 0xA0A0A0);
            this.inviteButton.active(false);
        }
        super.render(n, n2, f);
        if (this.serverData == null) {
            return;
        }
        if (this.toolTip != null) {
            this.renderMousehoverTooltip(this.toolTip, n, n2);
        }
    }

    protected void renderMousehoverTooltip(String string, int n, int n2) {
        if (string == null) {
            return;
        }
        int n3 = n + 12;
        int n4 = n2 - 12;
        int n5 = this.fontWidth(string);
        this.fillGradient(n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 8 + 3, -1073741824, -1073741824);
        this.fontDrawShadow(string, n3, n4, 0xFFFFFF);
    }

    private void drawRemoveIcon(int n, int n2, int n3, int n4) {
        boolean bl = n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9 && n4 < RealmsConstants.row(12) + 20 && n4 > RealmsConstants.row(1);
        RealmsPlayerScreen.bind(CROSS_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, bl ? 7.0f : 0.0f, 8, 7, 8.0f, 14.0f);
        GL11.glPopMatrix();
        if (bl) {
            this.toolTip = RealmsPlayerScreen.getLocalizedString("mco.configure.world.invites.remove.tooltip");
        }
    }

    private void drawOpped(int n, int n2, int n3, int n4) {
        boolean bl = n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9 && n4 < RealmsConstants.row(12) + 20 && n4 > RealmsConstants.row(1);
        RealmsPlayerScreen.bind(OP_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, bl ? 8.0f : 0.0f, 8, 8, 8.0f, 16.0f);
        GL11.glPopMatrix();
        if (bl) {
            this.toolTip = RealmsPlayerScreen.getLocalizedString("mco.configure.world.invites.ops.tooltip");
        }
    }

    private void drawNormal(int n, int n2, int n3, int n4) {
        boolean bl = n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 9 && n4 < RealmsConstants.row(12) + 20 && n4 > RealmsConstants.row(1);
        RealmsPlayerScreen.bind(USER_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, bl ? 8.0f : 0.0f, 8, 8, 8.0f, 16.0f);
        GL11.glPopMatrix();
        if (bl) {
            this.toolTip = RealmsPlayerScreen.getLocalizedString("mco.configure.world.invites.normal.tooltip");
        }
    }

    private class InvitedSelectionList
    extends RealmsClickableScrolledSelectionList {
        public InvitedSelectionList() {
            super(RealmsPlayerScreen.this.column_width + 10, RealmsConstants.row(12) + 20, RealmsConstants.row(1), RealmsConstants.row(12) + 20, 13);
        }

        @Override
        public void customMouseEvent(int n, int n2, int n3, float f, int n4) {
            if (Mouse.isButtonDown(0) && this.ym() >= n && this.ym() <= n2) {
                int n5 = RealmsPlayerScreen.this.column1_x;
                int n6 = RealmsPlayerScreen.this.column1_x + RealmsPlayerScreen.this.column_width;
                int n7 = this.ym() - n - n3 + (int)f - 4;
                int n8 = n7 / n4;
                if (this.xm() >= n5 && this.xm() <= n6 && n8 >= 0 && n7 >= 0 && n8 < this.getItemCount()) {
                    this.itemClicked(n7, n8, this.xm(), this.ym(), this.width());
                }
            }
        }

        @Override
        public void itemClicked(int n, int n2, int n3, int n4, int n5) {
            if (n2 < 0 || n2 > ((RealmsPlayerScreen)RealmsPlayerScreen.this).serverData.players.size() || RealmsPlayerScreen.this.toolTip == null) {
                return;
            }
            if (RealmsPlayerScreen.this.toolTip.equals(RealmsScreen.getLocalizedString("mco.configure.world.invites.ops.tooltip")) || RealmsPlayerScreen.this.toolTip.equals(RealmsScreen.getLocalizedString("mco.configure.world.invites.normal.tooltip"))) {
                if (((RealmsPlayerScreen)RealmsPlayerScreen.this).serverData.players.get(n2).isOperator()) {
                    RealmsPlayerScreen.this.deop(n2);
                } else {
                    RealmsPlayerScreen.this.op(n2);
                }
            } else if (RealmsPlayerScreen.this.toolTip.equals(RealmsScreen.getLocalizedString("mco.configure.world.invites.remove.tooltip"))) {
                RealmsPlayerScreen.this.uninvite(n2);
            }
        }

        @Override
        public void renderBackground() {
            RealmsPlayerScreen.this.renderBackground();
        }

        @Override
        public int getScrollbarPosition() {
            return RealmsPlayerScreen.this.column1_x + this.width() - 5;
        }

        @Override
        public int getItemCount() {
            return RealmsPlayerScreen.this.serverData == null ? 1 : ((RealmsPlayerScreen)RealmsPlayerScreen.this).serverData.players.size();
        }

        @Override
        public int getMaxPosition() {
            return this.getItemCount() * 13;
        }

        @Override
        protected void renderItem(int n, int n2, int n3, int n4, Tezzelator tezzelator, int n5, int n6) {
            if (RealmsPlayerScreen.this.serverData == null) {
                return;
            }
            if (n < ((RealmsPlayerScreen)RealmsPlayerScreen.this).serverData.players.size()) {
                this.renderInvitedItem(n, n2, n3, n4);
            }
        }

        private void renderInvitedItem(int n, int n2, int n3, int n4) {
            PlayerInfo playerInfo = ((RealmsPlayerScreen)RealmsPlayerScreen.this).serverData.players.get(n);
            RealmsPlayerScreen.this.drawString(playerInfo.getName(), RealmsPlayerScreen.this.column1_x + 3 + 12, n3 + 1, playerInfo.getAccepted() ? 0xFFFFFF : 0xA0A0A0);
            if (playerInfo.isOperator()) {
                RealmsPlayerScreen.this.drawOpped(RealmsPlayerScreen.this.column1_x + RealmsPlayerScreen.this.column_width - 10, n3 + 1, this.xm(), this.ym());
            } else {
                RealmsPlayerScreen.this.drawNormal(RealmsPlayerScreen.this.column1_x + RealmsPlayerScreen.this.column_width - 10, n3 + 1, this.xm(), this.ym());
            }
            RealmsPlayerScreen.this.drawRemoveIcon(RealmsPlayerScreen.this.column1_x + RealmsPlayerScreen.this.column_width - 22, n3 + 2, this.xm(), this.ym());
            RealmsScreen.bindFace(playerInfo.getUuid(), playerInfo.getName());
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            RealmsScreen.blit(RealmsPlayerScreen.this.column1_x + 2 + 2, n3 + 1, 8.0f, 8.0f, 8, 8, 8, 8, 64.0f, 64.0f);
            RealmsScreen.blit(RealmsPlayerScreen.this.column1_x + 2 + 2, n3 + 1, 40.0f, 8.0f, 8, 8, 8, 8, 64.0f, 64.0f);
        }
    }
}

