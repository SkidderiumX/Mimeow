/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.mojang.realmsclient.gui.RealmsConstants;
import com.mojang.realmsclient.gui.screens.RealmsGenericErrorScreen;
import com.mojang.realmsclient.gui.screens.RealmsResetWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsUploadScreen;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsAnvilLevelStorageSource;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsLevelSummary;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsScrolledSelectionList;
import net.minecraft.realms.Tezzelator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class RealmsSelectFileToUploadScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int CANCEL_BUTTON = 1;
    private static final int UPLOAD_BUTTON = 2;
    private final RealmsResetWorldScreen lastScreen;
    private final long worldId;
    private int slotId;
    private RealmsButton uploadButton;
    private final DateFormat DATE_FORMAT = new SimpleDateFormat();
    private List<RealmsLevelSummary> levelList = new ArrayList<RealmsLevelSummary>();
    private int selectedWorld = -1;
    private WorldSelectionList worldSelectionList;
    private String worldLang;
    private String conversionLang;
    private String[] gameModesLang = new String[4];

    public RealmsSelectFileToUploadScreen(long l, int n, RealmsResetWorldScreen realmsResetWorldScreen) {
        this.lastScreen = realmsResetWorldScreen;
        this.worldId = l;
        this.slotId = n;
    }

    private void loadLevelList() throws Exception {
        RealmsAnvilLevelStorageSource realmsAnvilLevelStorageSource = this.getLevelStorageSource();
        this.levelList = realmsAnvilLevelStorageSource.getLevelList();
        Collections.sort(this.levelList);
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        try {
            this.loadLevelList();
        }
        catch (Exception exception) {
            LOGGER.error("Couldn't load level list", (Throwable)exception);
            Realms.setScreen(new RealmsGenericErrorScreen("Unable to load worlds", exception.getMessage(), this.lastScreen));
            return;
        }
        this.worldLang = RealmsSelectFileToUploadScreen.getLocalizedString("selectWorld.world");
        this.conversionLang = RealmsSelectFileToUploadScreen.getLocalizedString("selectWorld.conversion");
        this.gameModesLang[Realms.survivalId()] = RealmsSelectFileToUploadScreen.getLocalizedString("gameMode.survival");
        this.gameModesLang[Realms.creativeId()] = RealmsSelectFileToUploadScreen.getLocalizedString("gameMode.creative");
        this.gameModesLang[Realms.adventureId()] = RealmsSelectFileToUploadScreen.getLocalizedString("gameMode.adventure");
        this.gameModesLang[Realms.spectatorId()] = RealmsSelectFileToUploadScreen.getLocalizedString("gameMode.spectator");
        this.buttonsAdd(RealmsSelectFileToUploadScreen.newButton(1, this.width() / 2 + 6, this.height() - 32, 153, 20, RealmsSelectFileToUploadScreen.getLocalizedString("gui.back")));
        this.uploadButton = RealmsSelectFileToUploadScreen.newButton(2, this.width() / 2 - 154, this.height() - 32, 153, 20, RealmsSelectFileToUploadScreen.getLocalizedString("mco.upload.button.name"));
        this.buttonsAdd(this.uploadButton);
        this.uploadButton.active(this.selectedWorld >= 0 && this.selectedWorld < this.levelList.size());
        this.worldSelectionList = new WorldSelectionList();
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
        if (realmsButton.id() == 1) {
            Realms.setScreen(this.lastScreen);
        } else if (realmsButton.id() == 2) {
            this.upload();
        }
    }

    private void upload() {
        if (this.selectedWorld != -1 && !this.levelList.get(this.selectedWorld).isHardcore()) {
            RealmsLevelSummary realmsLevelSummary = this.levelList.get(this.selectedWorld);
            Realms.setScreen(new RealmsUploadScreen(this.worldId, this.slotId, this.lastScreen, realmsLevelSummary));
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        this.worldSelectionList.render(n, n2, f);
        this.drawCenteredString(RealmsSelectFileToUploadScreen.getLocalizedString("mco.upload.select.world.title"), this.width() / 2, 13, 0xFFFFFF);
        this.drawCenteredString(RealmsSelectFileToUploadScreen.getLocalizedString("mco.upload.select.world.subtitle"), this.width() / 2, RealmsConstants.row(-1), 0xA0A0A0);
        if (this.levelList.size() == 0) {
            this.drawCenteredString(RealmsSelectFileToUploadScreen.getLocalizedString("mco.upload.select.world.none"), this.width() / 2, this.height() / 2 - 20, 0xFFFFFF);
        }
        super.render(n, n2, f);
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
        this.worldSelectionList.mouseEvent();
    }

    @Override
    public void tick() {
        super.tick();
    }

    private class WorldSelectionList
    extends RealmsScrolledSelectionList {
        public WorldSelectionList() {
            super(RealmsSelectFileToUploadScreen.this.width(), RealmsSelectFileToUploadScreen.this.height(), RealmsConstants.row(0), RealmsSelectFileToUploadScreen.this.height() - 40, 36);
        }

        @Override
        public int getItemCount() {
            return RealmsSelectFileToUploadScreen.this.levelList.size();
        }

        @Override
        public void selectItem(int n, boolean bl, int n2, int n3) {
            RealmsSelectFileToUploadScreen.this.selectedWorld = n;
            RealmsSelectFileToUploadScreen.this.uploadButton.active(RealmsSelectFileToUploadScreen.this.selectedWorld >= 0 && RealmsSelectFileToUploadScreen.this.selectedWorld < this.getItemCount() && !((RealmsLevelSummary)RealmsSelectFileToUploadScreen.this.levelList.get(RealmsSelectFileToUploadScreen.this.selectedWorld)).isHardcore());
            if (bl) {
                RealmsSelectFileToUploadScreen.this.upload();
            }
        }

        @Override
        public boolean isSelectedItem(int n) {
            return n == RealmsSelectFileToUploadScreen.this.selectedWorld;
        }

        @Override
        public int getMaxPosition() {
            return RealmsSelectFileToUploadScreen.this.levelList.size() * 36;
        }

        @Override
        public void renderBackground() {
            RealmsSelectFileToUploadScreen.this.renderBackground();
        }

        @Override
        protected void renderItem(int n, int n2, int n3, int n4, Tezzelator tezzelator, int n5, int n6) {
            RealmsLevelSummary realmsLevelSummary = (RealmsLevelSummary)RealmsSelectFileToUploadScreen.this.levelList.get(n);
            String string = realmsLevelSummary.getLevelName();
            if (string == null || string.isEmpty()) {
                string = RealmsSelectFileToUploadScreen.this.worldLang + " " + (n + 1);
            }
            String string2 = realmsLevelSummary.getLevelId();
            string2 = string2 + " (" + RealmsSelectFileToUploadScreen.this.DATE_FORMAT.format(new Date(realmsLevelSummary.getLastPlayed()));
            string2 = string2 + ")";
            String string3 = "";
            if (realmsLevelSummary.isRequiresConversion()) {
                string3 = RealmsSelectFileToUploadScreen.this.conversionLang + " " + string3;
            } else {
                string3 = RealmsSelectFileToUploadScreen.this.gameModesLang[realmsLevelSummary.getGameMode()];
                if (realmsLevelSummary.isHardcore()) {
                    string3 = (Object)((Object)ChatFormatting.DARK_RED) + RealmsScreen.getLocalizedString("mco.upload.hardcore") + (Object)((Object)ChatFormatting.RESET);
                }
                if (realmsLevelSummary.hasCheats()) {
                    string3 = string3 + ", " + RealmsScreen.getLocalizedString("selectWorld.cheats");
                }
            }
            RealmsSelectFileToUploadScreen.this.drawString(string, n2 + 2, n3 + 1, 0xFFFFFF);
            RealmsSelectFileToUploadScreen.this.drawString(string2, n2 + 2, n3 + 12, 0x808080);
            RealmsSelectFileToUploadScreen.this.drawString(string3, n2 + 2, n3 + 12 + 10, 0x808080);
        }
    }
}

