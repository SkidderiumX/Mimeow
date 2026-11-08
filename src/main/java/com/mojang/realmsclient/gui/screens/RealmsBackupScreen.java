/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.Backup;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.WorldDownload;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.exception.RetryCallException;
import com.mojang.realmsclient.gui.LongRunningTask;
import com.mojang.realmsclient.gui.screens.RealmsBackupInfoScreen;
import com.mojang.realmsclient.gui.screens.RealmsConfigureWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsDownloadLatestWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsGenericErrorScreen;
import com.mojang.realmsclient.gui.screens.RealmsLongConfirmationScreen;
import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;
import com.mojang.realmsclient.util.RealmsUtil;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsClickableScrolledSelectionList;
import net.minecraft.realms.RealmsScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class RealmsBackupScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PLUS_ICON_LOCATION = "realms:textures/gui/realms/plus_icon.png";
    private static final String RESTORE_ICON_LOCATION = "realms:textures/gui/realms/restore_icon.png";
    private static int lastScrollPosition = -1;
    private final RealmsConfigureWorldScreen lastScreen;
    private List<Backup> backups = Collections.emptyList();
    private String toolTip = null;
    private BackupSelectionList backupSelectionList;
    private int selectedBackup = -1;
    private static final int BACK_BUTTON_ID = 0;
    private static final int RESTORE_BUTTON_ID = 1;
    private static final int DOWNLOAD_BUTTON_ID = 2;
    private RealmsButton downloadButton;
    private Boolean noBackups = false;
    private RealmsServer serverData;
    private static final String UPLOADED_KEY = "Uploaded";

    public RealmsBackupScreen(RealmsConfigureWorldScreen realmsConfigureWorldScreen, RealmsServer realmsServer) {
        this.lastScreen = realmsConfigureWorldScreen;
        this.serverData = realmsServer;
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
        this.backupSelectionList.mouseEvent();
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        this.backupSelectionList = new BackupSelectionList();
        if (lastScrollPosition != -1) {
            this.backupSelectionList.scroll(lastScrollPosition);
        }
        new Thread("Realms-fetch-backups"){

            @Override
            public void run() {
                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                try {
                    RealmsBackupScreen.this.backups = realmsClient.backupsFor((long)((RealmsBackupScreen)RealmsBackupScreen.this).serverData.id).backups;
                    RealmsBackupScreen.this.noBackups = RealmsBackupScreen.this.backups.size() == 0;
                    RealmsBackupScreen.this.generateChangeList();
                }
                catch (RealmsServiceException realmsServiceException) {
                    LOGGER.error("Couldn't request backups", (Throwable)realmsServiceException);
                }
            }
        }.start();
        this.postInit();
    }

    private void generateChangeList() {
        if (this.backups.size() <= 1) {
            return;
        }
        for (int i = 0; i < this.backups.size() - 1; ++i) {
            Backup backup = this.backups.get(i);
            Backup backup2 = this.backups.get(i + 1);
            if (backup.metadata.isEmpty() || backup2.metadata.isEmpty()) continue;
            for (String string : backup.metadata.keySet()) {
                if (!string.contains(UPLOADED_KEY) && backup2.metadata.containsKey(string)) {
                    if (backup.metadata.get(string).equals(backup2.metadata.get(string))) continue;
                    this.addToChangeList(backup, string);
                    continue;
                }
                this.addToChangeList(backup, string);
            }
        }
    }

    private void addToChangeList(Backup backup, String string) {
        if (string.contains(UPLOADED_KEY)) {
            String string2 = DateFormat.getDateTimeInstance(3, 3).format(backup.lastModifiedDate);
            backup.changeList.put(string, string2);
            backup.setUploadedVersion(true);
        } else {
            backup.changeList.put(string, backup.metadata.get(string));
        }
    }

    private void postInit() {
        this.downloadButton = RealmsBackupScreen.newButton(2, this.width() - 125, 32, 100, 20, RealmsBackupScreen.getLocalizedString("mco.backup.button.download"));
        this.buttonsAdd(this.downloadButton);
        this.buttonsAdd(RealmsBackupScreen.newButton(0, this.width() - 125, this.height() - 35, 85, 20, RealmsBackupScreen.getLocalizedString("gui.back")));
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
        if (realmsButton.id() == 0) {
            Realms.setScreen(this.lastScreen);
        } else if (realmsButton.id() == 2) {
            this.downloadClicked();
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            Realms.setScreen(this.lastScreen);
        }
    }

    private void restoreClicked(int n) {
        if (n >= 0 && n < this.backups.size() && !this.serverData.expired) {
            this.selectedBackup = n;
            Date date = this.backups.get((int)n).lastModifiedDate;
            String string = DateFormat.getDateTimeInstance(3, 3).format(date);
            String string2 = RealmsUtil.convertToAgePresentation(System.currentTimeMillis() - date.getTime());
            String string3 = RealmsBackupScreen.getLocalizedString("mco.configure.world.restore.question.line1", string, string2);
            String string4 = RealmsBackupScreen.getLocalizedString("mco.configure.world.restore.question.line2");
            Realms.setScreen(new RealmsLongConfirmationScreen(this, RealmsLongConfirmationScreen.Type.Warning, string3, string4, true, 1));
        }
    }

    private void downloadClicked() {
        String string = RealmsBackupScreen.getLocalizedString("mco.configure.world.restore.download.question.line1");
        String string2 = RealmsBackupScreen.getLocalizedString("mco.configure.world.restore.download.question.line2");
        Realms.setScreen(new RealmsLongConfirmationScreen(this, RealmsLongConfirmationScreen.Type.Info, string, string2, true, 2));
    }

    private void downloadWorldData() {
        RealmsClient realmsClient = RealmsClient.createRealmsClient();
        try {
            WorldDownload worldDownload = realmsClient.download(this.serverData.id);
            Realms.setScreen(new RealmsDownloadLatestWorldScreen(this, worldDownload, this.serverData.name + " (" + this.serverData.slots.get(this.serverData.activeSlot).getSlotName(this.serverData.activeSlot) + ")"));
        }
        catch (RealmsServiceException realmsServiceException) {
            LOGGER.error("Couldn't download world data");
            Realms.setScreen(new RealmsGenericErrorScreen(realmsServiceException, (RealmsScreen)this));
        }
    }

    @Override
    public void confirmResult(boolean bl, int n) {
        if (bl && n == 1) {
            this.restore();
        } else if (bl && n == 2) {
            this.downloadWorldData();
        } else {
            Realms.setScreen(this);
        }
    }

    private void restore() {
        Backup backup = this.backups.get(this.selectedBackup);
        RestoreTask restoreTask = new RestoreTask(backup);
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(this.lastScreen.getNewScreen(), restoreTask);
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    @Override
    public void render(int n, int n2, float f) {
        this.toolTip = null;
        this.renderBackground();
        this.backupSelectionList.render(n, n2, f);
        this.drawCenteredString(RealmsBackupScreen.getLocalizedString("mco.configure.world.backup"), this.width() / 2, 12, 0xFFFFFF);
        this.drawString(RealmsBackupScreen.getLocalizedString("mco.configure.world.backup"), (this.width() - 150) / 2 - 90, 20, 0xA0A0A0);
        if (this.noBackups.booleanValue()) {
            this.drawString(RealmsBackupScreen.getLocalizedString("mco.backup.nobackups"), 20, this.height() / 2 - 10, 0xFFFFFF);
        }
        this.downloadButton.active(this.noBackups == false);
        super.render(n, n2, f);
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

    private class BackupSelectionList
    extends RealmsClickableScrolledSelectionList {
        public BackupSelectionList() {
            super(RealmsBackupScreen.this.width() - 150, RealmsBackupScreen.this.height(), 32, RealmsBackupScreen.this.height() - 15, 36);
        }

        @Override
        public int getItemCount() {
            return RealmsBackupScreen.this.backups.size() + 1;
        }

        @Override
        public int getMaxPosition() {
            return this.getItemCount() * 36;
        }

        @Override
        public void renderBackground() {
            RealmsBackupScreen.this.renderBackground();
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

        @Override
        public void renderItem(int n, int n2, int n3, int n4, int n5, int n6) {
            n2 += 16;
            if (n < RealmsBackupScreen.this.backups.size()) {
                this.renderBackupItem(n, n2, n3, n4, RealmsBackupScreen.this.width);
            }
        }

        @Override
        public int getScrollbarPosition() {
            return this.width() - 5;
        }

        @Override
        public void itemClicked(int n, int n2, int n3, int n4, int n5) {
            int n6 = this.width() - 40;
            int n7 = n + 30 - this.getScroll();
            int n8 = n6 + 10;
            int n9 = n7 - 3;
            if (n3 >= n6 && n3 <= n6 + 9 && n4 >= n7 && n4 <= n7 + 9) {
                if (!((Backup)((RealmsBackupScreen)RealmsBackupScreen.this).backups.get((int)n2)).changeList.isEmpty()) {
                    lastScrollPosition = this.getScroll();
                    Realms.setScreen(new RealmsBackupInfoScreen(RealmsBackupScreen.this, (Backup)RealmsBackupScreen.this.backups.get(n2)));
                }
            } else if (n3 >= n8 && n3 <= n8 + 9 && n4 >= n9 && n4 <= n9 + 9) {
                lastScrollPosition = this.getScroll();
                RealmsBackupScreen.this.restoreClicked(n2);
            }
        }

        private void renderBackupItem(int n, int n2, int n3, int n4, int n5) {
            Backup backup = (Backup)RealmsBackupScreen.this.backups.get(n);
            int n6 = backup.isUploadedVersion() ? -8388737 : 0xFFFFFF;
            RealmsBackupScreen.this.drawString("Backup (" + RealmsUtil.convertToAgePresentation(System.currentTimeMillis() - backup.lastModifiedDate.getTime()) + ")", n2 + 2, n3 + 1, n6);
            RealmsBackupScreen.this.drawString(this.getMediumDatePresentation(backup.lastModifiedDate), n2 + 2, n3 + 12, 0x4C4C4C);
            int n7 = this.width() - 30;
            int n8 = -3;
            int n9 = n7 - 10;
            int n10 = n8 + 3;
            if (!((RealmsBackupScreen)RealmsBackupScreen.this).serverData.expired) {
                this.drawRestore(n7, n3 + n8, this.xm(), this.ym());
            }
            if (!backup.changeList.isEmpty()) {
                this.drawInfo(n9, n3 + n10, this.xm(), this.ym());
            }
        }

        private String getMediumDatePresentation(Date date) {
            return DateFormat.getDateTimeInstance(3, 3).format(date);
        }

        private void drawRestore(int n, int n2, int n3, int n4) {
            boolean bl = n3 >= n && n3 <= n + 12 && n4 >= n2 && n4 <= n2 + 14 && n4 < RealmsBackupScreen.this.height() - 15 && n4 > 32;
            RealmsScreen.bind(RealmsBackupScreen.RESTORE_ICON_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            RealmsScreen.blit(n * 2, n2 * 2, 0.0f, bl ? 28.0f : 0.0f, 23, 28, 23.0f, 56.0f);
            GL11.glPopMatrix();
            if (bl) {
                RealmsBackupScreen.this.toolTip = RealmsScreen.getLocalizedString("mco.backup.button.restore");
            }
        }

        private void drawInfo(int n, int n2, int n3, int n4) {
            boolean bl = n3 >= n && n3 <= n + 8 && n4 >= n2 && n4 <= n2 + 8 && n4 < RealmsBackupScreen.this.height() - 15 && n4 > 32;
            RealmsScreen.bind(RealmsBackupScreen.PLUS_ICON_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            RealmsScreen.blit(n * 2, n2 * 2, 0.0f, bl ? 15.0f : 0.0f, 15, 15, 15.0f, 30.0f);
            GL11.glPopMatrix();
            if (bl) {
                RealmsBackupScreen.this.toolTip = RealmsScreen.getLocalizedString("mco.backup.changes.tooltip");
            }
        }
    }

    private class RestoreTask
    extends LongRunningTask {
        private final Backup backup;

        private RestoreTask(Backup backup) {
            this.backup = backup;
        }

        @Override
        public void run() {
            this.setTitle(RealmsScreen.getLocalizedString("mco.backup.restoring"));
            for (int i = 0; i < 6; ++i) {
                try {
                    if (this.aborted()) {
                        return;
                    }
                    RealmsClient realmsClient = RealmsClient.createRealmsClient();
                    realmsClient.restoreWorld(((RealmsBackupScreen)RealmsBackupScreen.this).serverData.id, this.backup.backupId);
                    this.pause(1);
                    if (this.aborted()) {
                        return;
                    }
                    Realms.setScreen(RealmsBackupScreen.this.lastScreen.getNewScreen());
                    return;
                }
                catch (RetryCallException retryCallException) {
                    if (this.aborted()) {
                        return;
                    }
                    this.pause(retryCallException.delaySeconds);
                    continue;
                }
                catch (RealmsServiceException realmsServiceException) {
                    if (this.aborted()) {
                        return;
                    }
                    LOGGER.error("Couldn't restore backup");
                    Realms.setScreen(new RealmsGenericErrorScreen(realmsServiceException, (RealmsScreen)RealmsBackupScreen.this.lastScreen));
                    return;
                }
                catch (Exception exception) {
                    if (this.aborted()) {
                        return;
                    }
                    LOGGER.error("Couldn't restore backup");
                    this.error(exception.getLocalizedMessage());
                    return;
                }
            }
        }

        private void pause(int n) {
            try {
                Thread.sleep(n * 1000);
            }
            catch (InterruptedException interruptedException) {
                LOGGER.error(interruptedException);
            }
        }
    }
}

