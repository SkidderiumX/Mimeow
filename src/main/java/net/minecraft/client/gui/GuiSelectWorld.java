/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.client.gui.GuiRenameWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiSelectWorld
extends GuiScreen
implements GuiYesNoCallback {
    private static final Logger logger = LogManager.getLogger();
    private final DateFormat field_146633_h = new SimpleDateFormat();
    protected GuiScreen parentScreen;
    protected String screenTitle = "Select world";
    private boolean field_146634_i;
    private int selectedIndex;
    private java.util.List<SaveFormatComparator> field_146639_s;
    private List availableWorlds;
    private String field_146637_u;
    private String field_146636_v;
    private String[] field_146635_w = new String[4];
    private boolean confirmingDelete;
    private GuiButton deleteButton;
    private GuiButton selectButton;
    private GuiButton renameButton;
    private GuiButton recreateButton;

    public GuiSelectWorld(GuiScreen guiScreen) {
        this.parentScreen = guiScreen;
    }

    @Override
    public void initGui() {
        this.screenTitle = I18n.format("selectWorld.title", new Object[0]);
        try {
            this.loadLevelList();
        }
        catch (AnvilConverterException anvilConverterException) {
            logger.error("Couldn't load level list", (Throwable)anvilConverterException);
            this.mc.displayGuiScreen(new GuiErrorScreen("Unable to load worlds", anvilConverterException.getMessage()));
            return;
        }
        this.field_146637_u = I18n.format("selectWorld.world", new Object[0]);
        this.field_146636_v = I18n.format("selectWorld.conversion", new Object[0]);
        this.field_146635_w[WorldSettings.GameType.SURVIVAL.getID()] = I18n.format("gameMode.survival", new Object[0]);
        this.field_146635_w[WorldSettings.GameType.CREATIVE.getID()] = I18n.format("gameMode.creative", new Object[0]);
        this.field_146635_w[WorldSettings.GameType.ADVENTURE.getID()] = I18n.format("gameMode.adventure", new Object[0]);
        this.field_146635_w[WorldSettings.GameType.SPECTATOR.getID()] = I18n.format("gameMode.spectator", new Object[0]);
        this.availableWorlds = new List(this.mc);
        this.availableWorlds.registerScrollButtons(4, 5);
        this.addWorldSelectionButtons();
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.availableWorlds.handleMouseInput();
    }

    private void loadLevelList() throws AnvilConverterException {
        ISaveFormat iSaveFormat = this.mc.getSaveLoader();
        this.field_146639_s = iSaveFormat.getSaveList();
        Collections.sort(this.field_146639_s);
        this.selectedIndex = -1;
    }

    protected String func_146621_a(int n) {
        return this.field_146639_s.get(n).getFileName();
    }

    protected String func_146614_d(int n) {
        Object object = this.field_146639_s.get(n).getDisplayName();
        if (StringUtils.isEmpty((CharSequence)object)) {
            object = I18n.format("selectWorld.world", new Object[0]) + " " + (n + 1);
        }
        return object;
    }

    public void addWorldSelectionButtons() {
        this.selectButton = new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, I18n.format("selectWorld.select", new Object[0]));
        this.buttonList.add(this.selectButton);
        this.buttonList.add(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, I18n.format("selectWorld.create", new Object[0])));
        this.renameButton = new GuiButton(6, this.width / 2 - 154, this.height - 28, 72, 20, I18n.format("selectWorld.rename", new Object[0]));
        this.buttonList.add(this.renameButton);
        this.deleteButton = new GuiButton(2, this.width / 2 - 76, this.height - 28, 72, 20, I18n.format("selectWorld.delete", new Object[0]));
        this.buttonList.add(this.deleteButton);
        this.recreateButton = new GuiButton(7, this.width / 2 + 4, this.height - 28, 72, 20, I18n.format("selectWorld.recreate", new Object[0]));
        this.buttonList.add(this.recreateButton);
        this.buttonList.add(new GuiButton(0, this.width / 2 + 82, this.height - 28, 72, 20, I18n.format("gui.cancel", new Object[0])));
        this.selectButton.enabled = false;
        this.deleteButton.enabled = false;
        this.renameButton.enabled = false;
        this.recreateButton.enabled = false;
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.enabled) {
            if (guiButton.id == 2) {
                String string = this.func_146614_d(this.selectedIndex);
                if (string != null) {
                    this.confirmingDelete = true;
                    GuiYesNo guiYesNo = GuiSelectWorld.makeDeleteWorldYesNo(this, string, this.selectedIndex);
                    this.mc.displayGuiScreen(guiYesNo);
                }
            } else if (guiButton.id == 1) {
                this.func_146615_e(this.selectedIndex);
            } else if (guiButton.id == 3) {
                this.mc.displayGuiScreen(new GuiCreateWorld(this));
            } else if (guiButton.id == 6) {
                this.mc.displayGuiScreen(new GuiRenameWorld(this, this.func_146621_a(this.selectedIndex)));
            } else if (guiButton.id == 0) {
                this.mc.displayGuiScreen(this.parentScreen);
            } else if (guiButton.id == 7) {
                GuiCreateWorld guiCreateWorld = new GuiCreateWorld(this);
                ISaveHandler iSaveHandler = this.mc.getSaveLoader().getSaveLoader(this.func_146621_a(this.selectedIndex), false);
                WorldInfo worldInfo = iSaveHandler.loadWorldInfo();
                iSaveHandler.flush();
                guiCreateWorld.recreateFromExistingWorld(worldInfo);
                this.mc.displayGuiScreen(guiCreateWorld);
            } else {
                this.availableWorlds.actionPerformed(guiButton);
            }
        }
    }

    public void func_146615_e(int n) {
        this.mc.displayGuiScreen(null);
        if (!this.field_146634_i) {
            Object object;
            this.field_146634_i = true;
            Object object2 = this.func_146621_a(n);
            if (object2 == null) {
                object2 = "World" + n;
            }
            if ((object = this.func_146614_d(n)) == null) {
                object = "World" + n;
            }
            if (this.mc.getSaveLoader().canLoadWorld((String)object2)) {
                this.mc.launchIntegratedServer((String)object2, (String)object, null);
            }
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (this.confirmingDelete) {
            this.confirmingDelete = false;
            if (bl) {
                ISaveFormat iSaveFormat = this.mc.getSaveLoader();
                iSaveFormat.flushCache();
                iSaveFormat.deleteWorldDirectory(this.func_146621_a(n));
                try {
                    this.loadLevelList();
                }
                catch (AnvilConverterException anvilConverterException) {
                    logger.error("Couldn't load level list", (Throwable)anvilConverterException);
                }
            }
            this.mc.displayGuiScreen(this);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.availableWorlds.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    public static GuiYesNo makeDeleteWorldYesNo(GuiYesNoCallback guiYesNoCallback, String string, int n) {
        String string2 = I18n.format("selectWorld.deleteQuestion", new Object[0]);
        String string3 = "'" + string + "' " + I18n.format("selectWorld.deleteWarning", new Object[0]);
        String string4 = I18n.format("selectWorld.deleteButton", new Object[0]);
        String string5 = I18n.format("gui.cancel", new Object[0]);
        GuiYesNo guiYesNo = new GuiYesNo(guiYesNoCallback, string2, string3, string4, string5, n);
        return guiYesNo;
    }

    public class List
    extends GuiSlot {
        public List(Minecraft minecraft) {
            super(minecraft, GuiSelectWorld.this.width, GuiSelectWorld.this.height, 32, GuiSelectWorld.this.height - 64, 36);
        }

        @Override
        protected int getSize() {
            return GuiSelectWorld.this.field_146639_s.size();
        }

        @Override
        protected void elementClicked(int n, boolean bl, int n2, int n3) {
            boolean bl2;
            GuiSelectWorld.this.selectedIndex = n;
            GuiSelectWorld.this.selectButton.enabled = bl2 = GuiSelectWorld.this.selectedIndex >= 0 && GuiSelectWorld.this.selectedIndex < this.getSize();
            GuiSelectWorld.this.deleteButton.enabled = bl2;
            GuiSelectWorld.this.renameButton.enabled = bl2;
            GuiSelectWorld.this.recreateButton.enabled = bl2;
            if (bl && bl2) {
                GuiSelectWorld.this.func_146615_e(n);
            }
        }

        @Override
        protected boolean isSelected(int n) {
            return n == GuiSelectWorld.this.selectedIndex;
        }

        @Override
        protected int getContentHeight() {
            return GuiSelectWorld.this.field_146639_s.size() * 36;
        }

        @Override
        protected void drawBackground() {
            GuiSelectWorld.this.drawDefaultBackground();
        }

        @Override
        protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
            SaveFormatComparator saveFormatComparator = GuiSelectWorld.this.field_146639_s.get(n);
            Object object = saveFormatComparator.getDisplayName();
            if (StringUtils.isEmpty((CharSequence)object)) {
                object = GuiSelectWorld.this.field_146637_u + " " + (n + 1);
            }
            Object object2 = saveFormatComparator.getFileName();
            object2 = (String)object2 + " (" + GuiSelectWorld.this.field_146633_h.format(new Date(saveFormatComparator.getLastTimePlayed()));
            object2 = (String)object2 + ")";
            Object object3 = "";
            if (saveFormatComparator.requiresConversion()) {
                object3 = GuiSelectWorld.this.field_146636_v + " " + (String)object3;
            } else {
                object3 = GuiSelectWorld.this.field_146635_w[saveFormatComparator.getEnumGameType().getID()];
                if (saveFormatComparator.isHardcoreModeEnabled()) {
                    object3 = String.valueOf((Object)EnumChatFormatting.DARK_RED) + I18n.format("gameMode.hardcore", new Object[0]) + String.valueOf((Object)EnumChatFormatting.RESET);
                }
                if (saveFormatComparator.getCheatsEnabled()) {
                    object3 = (String)object3 + ", " + I18n.format("selectWorld.cheats", new Object[0]);
                }
            }
            GuiSelectWorld.this.drawString(GuiSelectWorld.this.fontRendererObj, (String)object, n2 + 2, n3 + 1, 0xFFFFFF);
            GuiSelectWorld.this.drawString(GuiSelectWorld.this.fontRendererObj, (String)object2, n2 + 2, n3 + 12, 0x808080);
            GuiSelectWorld.this.drawString(GuiSelectWorld.this.fontRendererObj, (String)object3, n2 + 2, n3 + 12 + 10, 0x808080);
        }
    }
}

