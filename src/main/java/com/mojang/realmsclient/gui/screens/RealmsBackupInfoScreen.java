/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.dto.Backup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsSimpleScrolledSelectionList;
import net.minecraft.realms.Tezzelator;
import org.lwjgl.input.Keyboard;

public class RealmsBackupInfoScreen
extends RealmsScreen {
    private final RealmsScreen lastScreen;
    private final int BUTTON_BACK_ID = 0;
    private final Backup backup;
    private List<String> keys = new ArrayList<String>();
    private BackupInfoList backupInfoList;
    String[] difficulties = new String[]{RealmsBackupInfoScreen.getLocalizedString("options.difficulty.peaceful"), RealmsBackupInfoScreen.getLocalizedString("options.difficulty.easy"), RealmsBackupInfoScreen.getLocalizedString("options.difficulty.normal"), RealmsBackupInfoScreen.getLocalizedString("options.difficulty.hard")};
    String[] gameModes = new String[]{RealmsBackupInfoScreen.getLocalizedString("selectWorld.gameMode.survival"), RealmsBackupInfoScreen.getLocalizedString("selectWorld.gameMode.creative"), RealmsBackupInfoScreen.getLocalizedString("selectWorld.gameMode.adventure")};

    public RealmsBackupInfoScreen(RealmsScreen realmsScreen, Backup backup) {
        this.lastScreen = realmsScreen;
        this.backup = backup;
        if (backup.changeList != null) {
            for (Map.Entry<String, String> entry : backup.changeList.entrySet()) {
                this.keys.add(entry.getKey());
            }
        }
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
        this.backupInfoList.mouseEvent();
    }

    @Override
    public void tick() {
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsAdd(RealmsBackupInfoScreen.newButton(0, this.width() / 2 - 100, this.height() / 4 + 120 + 24, RealmsBackupInfoScreen.getLocalizedString("gui.back")));
        this.backupInfoList = new BackupInfoList();
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
        if (realmsButton.id() == 0) {
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        this.drawCenteredString("Changes from last backup", this.width() / 2, 10, 0xFFFFFF);
        this.backupInfoList.render(n, n2, f);
        super.render(n, n2, f);
    }

    private String checkForSpecificMetadata(String string, String string2) {
        String string3 = string.toLowerCase();
        if (string3.contains("game") && string3.contains("mode")) {
            return this.gameModeMetadata(string2);
        }
        if (string3.contains("game") && string3.contains("difficulty")) {
            return this.gameDifficultyMetadata(string2);
        }
        return string2;
    }

    private String gameDifficultyMetadata(String string) {
        try {
            return this.difficulties[Integer.parseInt(string)];
        }
        catch (Exception exception) {
            return "UNKNOWN";
        }
    }

    private String gameModeMetadata(String string) {
        try {
            return this.gameModes[Integer.parseInt(string)];
        }
        catch (Exception exception) {
            return "UNKNOWN";
        }
    }

    private class BackupInfoList
    extends RealmsSimpleScrolledSelectionList {
        public BackupInfoList() {
            super(RealmsBackupInfoScreen.this.width(), RealmsBackupInfoScreen.this.height(), 32, RealmsBackupInfoScreen.this.height() - 64, 36);
        }

        @Override
        public int getItemCount() {
            return ((RealmsBackupInfoScreen)RealmsBackupInfoScreen.this).backup.changeList.size();
        }

        @Override
        public void selectItem(int n, boolean bl, int n2, int n3) {
        }

        @Override
        public boolean isSelectedItem(int n) {
            return false;
        }

        @Override
        public int getMaxPosition() {
            return this.getItemCount() * 36;
        }

        @Override
        public void renderBackground() {
        }

        @Override
        protected void renderItem(int n, int n2, int n3, int n4, Tezzelator tezzelator, int n5, int n6) {
            String string = (String)RealmsBackupInfoScreen.this.keys.get(n);
            RealmsBackupInfoScreen.this.drawString(string, this.width() / 2 - 40, n3, 0xA0A0A0);
            String string2 = ((RealmsBackupInfoScreen)RealmsBackupInfoScreen.this).backup.changeList.get(string);
            RealmsBackupInfoScreen.this.drawString(RealmsBackupInfoScreen.this.checkForSpecificMetadata(string, string2), this.width() / 2 - 40, n3 + 12, 0xFFFFFF);
        }
    }
}

