/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.google.common.collect.Lists;
import com.mojang.realmsclient.RealmsMainScreen;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.PendingInvite;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.util.RealmsUtil;
import java.util.List;
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

public class RealmsPendingInvitesScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int BUTTON_BACK_ID = 0;
    private static final String ACCEPT_ICON_LOCATION = "realms:textures/gui/realms/accept_icon.png";
    private static final String REJECT_ICON_LOCATION = "realms:textures/gui/realms/reject_icon.png";
    private final RealmsScreen lastScreen;
    private String toolTip = null;
    private boolean loaded = false;
    private PendingInvitationList pendingList;
    private List<PendingInvite> pendingInvites = Lists.newArrayList();

    public RealmsPendingInvitesScreen(RealmsScreen realmsScreen) {
        this.lastScreen = realmsScreen;
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
        this.pendingList.mouseEvent();
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        this.pendingList = new PendingInvitationList();
        new Thread("Realms-pending-invitations-fetcher"){

            @Override
            public void run() {
                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                try {
                    RealmsPendingInvitesScreen.this.pendingInvites = realmsClient.pendingInvites().pendingInvites;
                }
                catch (RealmsServiceException realmsServiceException) {
                    LOGGER.error("Couldn't list invites");
                }
                finally {
                    RealmsPendingInvitesScreen.this.loaded = true;
                }
            }
        }.start();
        this.buttonsAdd(RealmsPendingInvitesScreen.newButton(0, this.width() / 2 - 75, this.height() - 32, 153, 20, RealmsPendingInvitesScreen.getLocalizedString("gui.done")));
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (!realmsButton.active()) {
            return;
        }
        switch (realmsButton.id()) {
            case 0: {
                Realms.setScreen(new RealmsMainScreen(this.lastScreen));
            }
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            Realms.setScreen(new RealmsMainScreen(this.lastScreen));
        }
    }

    private void updateList(int n) {
        this.pendingInvites.remove(n);
    }

    private void reject(final int n) {
        if (n < this.pendingInvites.size()) {
            new Thread("Realms-reject-invitation"){

                @Override
                public void run() {
                    try {
                        RealmsClient realmsClient = RealmsClient.createRealmsClient();
                        realmsClient.rejectInvitation(((PendingInvite)((RealmsPendingInvitesScreen)RealmsPendingInvitesScreen.this).pendingInvites.get((int)n)).invitationId);
                        RealmsPendingInvitesScreen.this.updateList(n);
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        LOGGER.error("Couldn't reject invite");
                    }
                }
            }.start();
        }
    }

    private void accept(final int n) {
        if (n < this.pendingInvites.size()) {
            new Thread("Realms-accept-invitation"){

                @Override
                public void run() {
                    try {
                        RealmsClient realmsClient = RealmsClient.createRealmsClient();
                        realmsClient.acceptInvitation(((PendingInvite)((RealmsPendingInvitesScreen)RealmsPendingInvitesScreen.this).pendingInvites.get((int)n)).invitationId);
                        RealmsPendingInvitesScreen.this.updateList(n);
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        LOGGER.error("Couldn't accept invite");
                    }
                }
            }.start();
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.toolTip = null;
        this.renderBackground();
        this.pendingList.render(n, n2, f);
        this.drawCenteredString(RealmsPendingInvitesScreen.getLocalizedString("mco.invites.title"), this.width() / 2, 12, 0xFFFFFF);
        if (this.toolTip != null) {
            this.renderMousehoverTooltip(this.toolTip, n, n2);
        }
        if (this.pendingInvites.size() == 0 && this.loaded) {
            this.drawCenteredString(RealmsPendingInvitesScreen.getLocalizedString("mco.invites.nopending"), this.width() / 2, this.height() / 2 - 20, 0xFFFFFF);
        }
        super.render(n, n2, f);
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

    private class PendingInvitationList
    extends RealmsClickableScrolledSelectionList {
        public PendingInvitationList() {
            super(RealmsPendingInvitesScreen.this.width() + 50, RealmsPendingInvitesScreen.this.height(), 32, RealmsPendingInvitesScreen.this.height() - 40, 36);
        }

        @Override
        public int getItemCount() {
            return RealmsPendingInvitesScreen.this.pendingInvites.size();
        }

        @Override
        public int getMaxPosition() {
            return this.getItemCount() * 36;
        }

        @Override
        public void renderBackground() {
            RealmsPendingInvitesScreen.this.renderBackground();
        }

        @Override
        public void renderSelected(int n, int n2, int n3, Tezzelator tezzelator) {
            int n4 = this.getScrollbarPosition() - 290;
            int n5 = this.getScrollbarPosition() - 10;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3553);
            tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_TEX_COLOR);
            tezzelator.vertex(n4, n2 + n3 + 2, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n5, n2 + n3 + 2, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n5, n2 - 2, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n4, n2 - 2, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n4 + 1, n2 + n3 + 1, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n5 - 1, n2 + n3 + 1, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n5 - 1, n2 - 1, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n4 + 1, n2 - 1, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
            tezzelator.end();
            GL11.glEnable(3553);
        }

        @Override
        public void renderItem(int n, int n2, int n3, int n4, int n5, int n6) {
            if (n < RealmsPendingInvitesScreen.this.pendingInvites.size()) {
                this.renderPendingInvitationItem(n, n2, n3, n4);
            }
        }

        private void renderPendingInvitationItem(int n, int n2, int n3, int n4) {
            PendingInvite pendingInvite = (PendingInvite)RealmsPendingInvitesScreen.this.pendingInvites.get(n);
            RealmsPendingInvitesScreen.this.drawString(pendingInvite.worldName, n2 + 2, n3 + 1, 0xFFFFFF);
            RealmsPendingInvitesScreen.this.drawString(pendingInvite.worldOwnerName, n2 + 2, n3 + 12, 0x6C6C6C);
            RealmsPendingInvitesScreen.this.drawString(RealmsUtil.convertToAgePresentation(System.currentTimeMillis() - pendingInvite.date.getTime()), n2 + 2, n3 + 24, 0x6C6C6C);
            int n5 = this.getScrollbarPosition() - 50;
            this.drawAccept(n5, n3, this.xm(), this.ym());
            this.drawReject(n5 + 20, n3, this.xm(), this.ym());
            RealmsScreen.bindFace(pendingInvite.worldOwnerUuid, pendingInvite.worldOwnerName);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            RealmsScreen.blit(n2 - 36, n3, 8.0f, 8.0f, 8, 8, 32, 32, 64.0f, 64.0f);
            RealmsScreen.blit(n2 - 36, n3, 40.0f, 8.0f, 8, 8, 32, 32, 64.0f, 64.0f);
        }

        private void drawAccept(int n, int n2, int n3, int n4) {
            boolean bl = false;
            if (n3 >= n && n3 <= n + 15 && n4 >= n2 && n4 <= n2 + 15 && n4 < RealmsPendingInvitesScreen.this.height() - 40 && n4 > 32) {
                bl = true;
            }
            RealmsScreen.bind(RealmsPendingInvitesScreen.ACCEPT_ICON_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            RealmsScreen.blit(n, n2, bl ? 19.0f : 0.0f, 0.0f, 18, 18, 37.0f, 18.0f);
            GL11.glPopMatrix();
            if (bl) {
                RealmsPendingInvitesScreen.this.toolTip = RealmsScreen.getLocalizedString("mco.invites.button.accept");
            }
        }

        private void drawReject(int n, int n2, int n3, int n4) {
            boolean bl = false;
            if (n3 >= n && n3 <= n + 15 && n4 >= n2 && n4 <= n2 + 15 && n4 < RealmsPendingInvitesScreen.this.height() - 40 && n4 > 32) {
                bl = true;
            }
            RealmsScreen.bind(RealmsPendingInvitesScreen.REJECT_ICON_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            RealmsScreen.blit(n, n2, bl ? 19.0f : 0.0f, 0.0f, 18, 18, 37.0f, 18.0f);
            GL11.glPopMatrix();
            if (bl) {
                RealmsPendingInvitesScreen.this.toolTip = RealmsScreen.getLocalizedString("mco.invites.button.reject");
            }
        }

        @Override
        public void itemClicked(int n, int n2, int n3, int n4, int n5) {
            int n6 = this.getScrollbarPosition() - 50;
            int n7 = n + 30 - this.getScroll();
            if (n3 >= n6 && n3 <= n6 + 15 && n4 >= n7 && n4 <= n7 + 15) {
                RealmsPendingInvitesScreen.this.accept(n2);
            } else if (n3 >= n6 + 20 && n3 <= n6 + 20 + 15 && n4 >= n7 && n4 <= n7 + 15) {
                RealmsPendingInvitesScreen.this.reject(n2);
            }
        }

        @Override
        public void customMouseEvent(int n, int n2, int n3, float f, int n4) {
            if (Mouse.isButtonDown(0) && this.ym() >= n && this.ym() <= n2) {
                int n5 = this.width() / 2 - 92;
                int n6 = this.width();
                int n7 = this.ym() - n - n3 + (int)f - 4;
                int n8 = n7 / n4;
                if (this.xm() >= n5 && this.xm() <= n6 && n8 >= 0 && n7 >= 0 && n8 < this.getItemCount()) {
                    this.itemClicked(n7, n8, this.xm(), this.ym(), this.width());
                }
            }
        }
    }
}

