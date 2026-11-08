/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.gui.RealmsDataFetcher;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsScreen;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class RealmsNotificationsScreen
extends RealmsScreen {
    private static final String INVITE_ICON_LOCATION = "realms:textures/gui/realms/invite_icon.png";
    private static final String TRIAL_ICON_LOCATION = "realms:textures/gui/realms/trial_icon.png";
    private static RealmsDataFetcher realmsDataFetcher = new RealmsDataFetcher();
    private volatile int numberOfPendingInvites = 0;
    private static boolean checkedMcoAvailability;
    private static boolean trialAvailable;
    private static boolean validClient;
    private static final List<RealmsDataFetcher.Task> tasks;

    public RealmsNotificationsScreen(RealmsScreen realmsScreen) {
        this.checkIfMcoEnabled();
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        if (validClient && Realms.getRealmsNotificationsEnabled()) {
            realmsDataFetcher.initWithSpecificTaskList(tasks);
        }
    }

    @Override
    public void tick() {
        if (!(Realms.getRealmsNotificationsEnabled() && Realms.inTitleScreen() || realmsDataFetcher.isStopped())) {
            realmsDataFetcher.stop();
            return;
        }
        if (!validClient || !Realms.getRealmsNotificationsEnabled()) {
            return;
        }
        realmsDataFetcher.initWithSpecificTaskList(tasks);
        if (realmsDataFetcher.isFetchedSinceLastTry(RealmsDataFetcher.Task.PENDING_INVITE)) {
            this.numberOfPendingInvites = realmsDataFetcher.getPendingInvitesCount();
        }
        if (realmsDataFetcher.isFetchedSinceLastTry(RealmsDataFetcher.Task.TRIAL_AVAILABLE)) {
            trialAvailable = realmsDataFetcher.isTrialAvailable();
        }
        realmsDataFetcher.markClean();
    }

    private void checkIfMcoEnabled() {
        if (!checkedMcoAvailability) {
            checkedMcoAvailability = true;
            new Thread("Realms Notification Availability checker #1"){

                @Override
                public void run() {
                    RealmsClient realmsClient = RealmsClient.createRealmsClient();
                    try {
                        RealmsClient.CompatibleVersionResponse compatibleVersionResponse = realmsClient.clientCompatible();
                        if (!compatibleVersionResponse.equals((Object)RealmsClient.CompatibleVersionResponse.COMPATIBLE)) {
                            return;
                        }
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        checkedMcoAvailability = false;
                        return;
                    }
                    catch (IOException iOException) {
                        checkedMcoAvailability = false;
                        return;
                    }
                    validClient = true;
                }
            }.start();
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        if (validClient) {
            this.drawIcons(n, n2);
        }
        super.render(n, n2, f);
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
    }

    private void drawIcons(int n, int n2) {
        int n3 = this.numberOfPendingInvites;
        int n4 = 24;
        int n5 = this.height() / 4 + 48;
        int n6 = this.width() / 2 + 80;
        int n7 = n5 + 48 + 2;
        if (n3 != 0) {
            RealmsScreen.bind(INVITE_ICON_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            RealmsScreen.blit(n6, n7 - 6, 0.0f, 0.0f, 15, 25, 31.0f, 25.0f);
            GL11.glPopMatrix();
        }
        if (trialAvailable) {
            RealmsScreen.bind(TRIAL_ICON_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            int n8 = 0;
            if ((System.currentTimeMillis() / 800L & 1L) == 1L) {
                n8 = 8;
            }
            RealmsScreen.blit(n6 + 4 - (n3 != 0 ? 16 : 0), n7 + 4, 0.0f, n8, 8, 8, 8.0f, 16.0f);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void removed() {
        realmsDataFetcher.stop();
    }

    static {
        trialAvailable = false;
        validClient = false;
        tasks = Arrays.asList(RealmsDataFetcher.Task.PENDING_INVITE, RealmsDataFetcher.Task.TRIAL_AVAILABLE);
    }
}

