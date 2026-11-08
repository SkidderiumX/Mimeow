/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.WorldTemplate;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.gui.RealmsConstants;
import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;
import com.mojang.realmsclient.gui.screens.RealmsResetNormalWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsScreenWithCallback;
import com.mojang.realmsclient.gui.screens.RealmsSelectFileToUploadScreen;
import com.mojang.realmsclient.gui.screens.RealmsSelectWorldTemplateScreen;
import com.mojang.realmsclient.util.RealmsTasks;
import com.mojang.realmsclient.util.RealmsTextureManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsSharedConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class RealmsResetWorldScreen
extends RealmsScreenWithCallback<WorldTemplate> {
    private static final Logger LOGGER = LogManager.getLogger();
    private RealmsScreen lastScreen;
    private RealmsServer serverData;
    private RealmsScreen returnScreen;
    private String title = RealmsResetWorldScreen.getLocalizedString("mco.reset.world.title");
    private String subtitle = RealmsResetWorldScreen.getLocalizedString("mco.reset.world.warning");
    private String buttonTitle = RealmsResetWorldScreen.getLocalizedString("gui.cancel");
    private int subtitleColor = 0xFF0000;
    private static final String SLOT_FRAME_LOCATION = "realms:textures/gui/realms/slot_frame.png";
    private static final String UPLOAD_LOCATION = "realms:textures/gui/realms/upload.png";
    private final int BUTTON_CANCEL_ID = 0;
    private boolean loaded = false;
    private List<WorldTemplate> templates = new ArrayList<WorldTemplate>();
    private List<WorldTemplate> adventuremaps = new ArrayList<WorldTemplate>();
    private final Random random = new Random();
    private ResetType selectedType = ResetType.NONE;
    private int templateId;
    private int adventureMapId;
    public int slot = -1;
    private ResetType typeToReset = ResetType.NONE;
    private ResetWorldInfo worldInfoToReset = null;
    private WorldTemplate worldTemplateToReset = null;
    private String resetTitle = null;

    public RealmsResetWorldScreen(RealmsScreen realmsScreen, RealmsServer realmsServer, RealmsScreen realmsScreen2) {
        this.lastScreen = realmsScreen;
        this.serverData = realmsServer;
        this.returnScreen = realmsScreen2;
    }

    public RealmsResetWorldScreen(RealmsScreen realmsScreen, RealmsServer realmsServer, RealmsScreen realmsScreen2, String string, String string2, int n, String string3) {
        this(realmsScreen, realmsServer, realmsScreen2);
        this.title = string;
        this.subtitle = string2;
        this.subtitleColor = n;
        this.buttonTitle = string3;
    }

    public void setSlot(int n) {
        this.slot = n;
    }

    public void setResetTitle(String string) {
        this.resetTitle = string;
    }

    @Override
    public void init() {
        this.buttonsClear();
        this.buttonsAdd(RealmsResetWorldScreen.newButton(0, this.width() / 2 - 40, RealmsConstants.row(14) - 10, 80, 20, this.buttonTitle));
        if (!this.loaded) {
            new Thread("Realms-reset-world-fetcher"){

                @Override
                public void run() {
                    RealmsClient realmsClient = RealmsClient.createRealmsClient();
                    try {
                        for (WorldTemplate worldTemplate : realmsClient.fetchWorldTemplates().templates) {
                            if (!worldTemplate.recommendedPlayers.equals("")) {
                                RealmsResetWorldScreen.this.adventuremaps.add(worldTemplate);
                                continue;
                            }
                            RealmsResetWorldScreen.this.templates.add(worldTemplate);
                        }
                        RealmsResetWorldScreen.this.templateId = RealmsResetWorldScreen.this.random.nextInt(RealmsResetWorldScreen.this.templates.size());
                        RealmsResetWorldScreen.this.adventureMapId = RealmsResetWorldScreen.this.random.nextInt(RealmsResetWorldScreen.this.adventuremaps.size());
                        RealmsResetWorldScreen.this.loaded = true;
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        LOGGER.error("Couldn't fetch templates in reset world");
                    }
                }
            }.start();
        }
    }

    @Override
    public void removed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            Realms.setScreen(this.lastScreen);
        }
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
    public void mouseClicked(int n, int n2, int n3) {
        switch (this.selectedType) {
            case NONE: {
                break;
            }
            case GENERATE: {
                Realms.setScreen(new RealmsResetNormalWorldScreen(this, this.title));
                break;
            }
            case UPLOAD: {
                Realms.setScreen(new RealmsSelectFileToUploadScreen(this.serverData.id, this.slot != -1 ? this.slot : this.serverData.activeSlot, this));
                break;
            }
            case ADVENTURE: {
                RealmsSelectWorldTemplateScreen realmsSelectWorldTemplateScreen = new RealmsSelectWorldTemplateScreen(this, null, false, this.adventuremaps);
                realmsSelectWorldTemplateScreen.setTitle(RealmsResetWorldScreen.getLocalizedString("mco.reset.world.adventure"));
                if (RealmsSharedConstants.VERSION_STRING.equals("1.8.9")) {
                    realmsSelectWorldTemplateScreen.setWarning(RealmsResetWorldScreen.getLocalizedString("mco.reset.world.updateBreaksAdventure"));
                    realmsSelectWorldTemplateScreen.setWarningURL("https://beta.minecraft.net/realms/adventure-maps-in-1-9");
                }
                Realms.setScreen(realmsSelectWorldTemplateScreen);
                break;
            }
            case SURVIVAL_SPAWN: {
                RealmsSelectWorldTemplateScreen realmsSelectWorldTemplateScreen = new RealmsSelectWorldTemplateScreen(this, null, false, this.templates);
                realmsSelectWorldTemplateScreen.setTitle(RealmsResetWorldScreen.getLocalizedString("mco.reset.world.template"));
                Realms.setScreen(realmsSelectWorldTemplateScreen);
                break;
            }
            default: {
                return;
            }
        }
    }

    private int frame(int n) {
        return this.width() / 2 - 80 + (n - 1) * 100;
    }

    @Override
    public void render(int n, int n2, float f) {
        this.selectedType = ResetType.NONE;
        this.renderBackground();
        this.drawCenteredString(this.title, this.width() / 2, 7, 0xFFFFFF);
        this.drawCenteredString(this.subtitle, this.width() / 2, 22, this.subtitleColor);
        if (this.loaded) {
            this.drawFrame(this.frame(1), RealmsConstants.row(0) + 10, n, n2, RealmsResetWorldScreen.getLocalizedString("mco.reset.world.generate"), -1L, "textures/gui/title/background/panorama_3.png", ResetType.GENERATE);
            this.drawFrame(this.frame(2), RealmsConstants.row(0) + 10, n, n2, RealmsResetWorldScreen.getLocalizedString("mco.reset.world.upload"), -1L, UPLOAD_LOCATION, ResetType.UPLOAD);
            this.drawFrame(this.frame(1), RealmsConstants.row(6) + 20, n, n2, RealmsResetWorldScreen.getLocalizedString("mco.reset.world.adventure"), Long.valueOf(this.adventuremaps.get((int)this.adventureMapId).id), this.adventuremaps.get((int)this.adventureMapId).image, ResetType.ADVENTURE);
            this.drawFrame(this.frame(2), RealmsConstants.row(6) + 20, n, n2, RealmsResetWorldScreen.getLocalizedString("mco.reset.world.template"), Long.valueOf(this.templates.get((int)this.templateId).id), this.templates.get((int)this.templateId).image, ResetType.SURVIVAL_SPAWN);
        }
        super.render(n, n2, f);
    }

    private void drawFrame(int n, int n2, int n3, int n4, String string, long l, String string2, ResetType resetType) {
        boolean bl = false;
        if (n3 >= n && n3 <= n + 60 && n4 >= n2 - 12 && n4 <= n2 + 60) {
            bl = true;
            this.selectedType = resetType;
        }
        if (l != -1L) {
            RealmsTextureManager.bindWorldTemplate(String.valueOf(l), string2);
        } else {
            RealmsResetWorldScreen.bind(string2);
        }
        if (bl) {
            GL11.glColor4f(0.56f, 0.56f, 0.56f, 1.0f);
        } else {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        RealmsScreen.blit(n + 2, n2 + 2, 0.0f, 0.0f, 56, 56, 56.0f, 56.0f);
        RealmsResetWorldScreen.bind(SLOT_FRAME_LOCATION);
        if (bl) {
            GL11.glColor4f(0.56f, 0.56f, 0.56f, 1.0f);
        } else {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        RealmsScreen.blit(n, n2, 0.0f, 0.0f, 60, 60, 60.0f, 60.0f);
        this.drawCenteredString(string, n + 30, n2 - 12, bl ? 0xA0A0A0 : 0xFFFFFF);
    }

    @Override
    void callback(WorldTemplate worldTemplate) {
        if (worldTemplate != null) {
            if (this.slot != -1) {
                this.typeToReset = worldTemplate.recommendedPlayers.equals("") ? ResetType.SURVIVAL_SPAWN : ResetType.ADVENTURE;
                this.worldTemplateToReset = worldTemplate;
                this.switchSlot();
            } else {
                this.resetWorldWithTemplate(worldTemplate);
            }
        }
    }

    private void switchSlot() {
        this.switchSlot(this);
    }

    public void switchSlot(RealmsScreen realmsScreen) {
        RealmsTasks.SwitchSlotTask switchSlotTask = new RealmsTasks.SwitchSlotTask(this.serverData.id, this.slot, realmsScreen, 100);
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(this.lastScreen, switchSlotTask);
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    @Override
    public void confirmResult(boolean bl, int n) {
        if (n == 100 && bl) {
            switch (this.typeToReset) {
                case ADVENTURE: 
                case SURVIVAL_SPAWN: {
                    if (this.worldTemplateToReset == null) break;
                    this.resetWorldWithTemplate(this.worldTemplateToReset);
                    break;
                }
                case GENERATE: {
                    if (this.worldInfoToReset == null) break;
                    this.triggerResetWorld(this.worldInfoToReset);
                    break;
                }
                default: {
                    return;
                }
            }
            return;
        }
        if (bl) {
            Realms.setScreen(this.returnScreen);
        }
    }

    public void resetWorldWithTemplate(WorldTemplate worldTemplate) {
        RealmsTasks.ResettingWorldTask resettingWorldTask = new RealmsTasks.ResettingWorldTask(this.serverData.id, this.returnScreen, worldTemplate);
        if (this.resetTitle != null) {
            resettingWorldTask.setResetTitle(this.resetTitle);
        }
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(this.lastScreen, resettingWorldTask);
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    public void resetWorld(ResetWorldInfo resetWorldInfo) {
        if (this.slot != -1) {
            this.typeToReset = ResetType.GENERATE;
            this.worldInfoToReset = resetWorldInfo;
            this.switchSlot();
        } else {
            this.triggerResetWorld(resetWorldInfo);
        }
    }

    private void triggerResetWorld(ResetWorldInfo resetWorldInfo) {
        RealmsTasks.ResettingWorldTask resettingWorldTask = new RealmsTasks.ResettingWorldTask(this.serverData.id, this.returnScreen, resetWorldInfo.seed, resetWorldInfo.levelType, resetWorldInfo.generateStructures);
        if (this.resetTitle != null) {
            resettingWorldTask.setResetTitle(this.resetTitle);
        }
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(this.lastScreen, resettingWorldTask);
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    public static class ResetWorldInfo {
        String seed;
        int levelType;
        boolean generateStructures;

        public ResetWorldInfo(String string, int n, boolean bl) {
            this.seed = string;
            this.levelType = n;
            this.generateStructures = bl;
        }
    }

    public static enum ResetType {
        NONE,
        GENERATE,
        UPLOAD,
        ADVENTURE,
        SURVIVAL_SPAWN;

    }
}

