/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards;

import com.viaversion.viabackwards.api.DialogStyleConfig;
import com.viaversion.viaversion.util.ChatColorUtil;
import com.viaversion.viaversion.util.Config;
import com.viaversion.viaversion.util.ConfigSection;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ViaBackwardsConfig
extends Config
implements com.viaversion.viabackwards.api.ViaBackwardsConfig {
    private boolean addCustomEnchantsToLore;
    private boolean addTeamColorToPrefix;
    private boolean fix1_13FacePlayer;
    private boolean alwaysShowOriginalMobName;
    private boolean fix1_13FormattedInventoryTitles;
    private boolean handlePingsAsInvAcknowledgements;
    private boolean bedrockAtY0;
    private boolean sculkShriekersToCryingObsidian;
    private boolean scaffoldingToWater;
    private boolean mapDarknessEffect;
    private boolean mapCustomModelData;
    private boolean mapDisplayEntities;
    private boolean suppressEmulationWarnings;
    private boolean dialogsViaChests;
    private DialogStyleConfig dialogStyleConfig;
    private boolean codeOfConductAsDialog;
    private boolean passOriginalItemNameToResourcePacks;

    public ViaBackwardsConfig(File file, Logger logger) {
        super(file, logger);
    }

    @Override
    public void reload() {
        super.reload();
        this.loadFields();
    }

    private void loadFields() {
        this.addCustomEnchantsToLore = this.getBoolean("add-custom-enchants-into-lore", true);
        this.addTeamColorToPrefix = this.getBoolean("add-teamcolor-to-prefix", true);
        this.fix1_13FacePlayer = this.getBoolean("fix-1_13-face-player", false);
        this.fix1_13FormattedInventoryTitles = this.getBoolean("fix-formatted-inventory-titles", true);
        this.alwaysShowOriginalMobName = this.getBoolean("always-show-original-mob-name", true);
        this.handlePingsAsInvAcknowledgements = this.getBoolean("handle-pings-as-inv-acknowledgements", false);
        this.bedrockAtY0 = this.getBoolean("bedrock-at-y-0", false);
        this.sculkShriekersToCryingObsidian = this.getBoolean("sculk-shriekers-to-crying-obsidian", false);
        this.scaffoldingToWater = this.getBoolean("scaffolding-to-water", false);
        this.mapDarknessEffect = this.getBoolean("map-darkness-effect", true);
        this.mapCustomModelData = this.getBoolean("map-custom-model-data", true);
        this.mapDisplayEntities = this.getBoolean("map-display-entities", true);
        this.suppressEmulationWarnings = this.getBoolean("suppress-emulation-warnings", false);
        this.dialogsViaChests = this.getBoolean("dialogs-via-chests", true);
        this.dialogStyleConfig = this.loadDialogStyleConfig(this.getSection("dialog-style"));
        this.codeOfConductAsDialog = this.getBoolean("code-of-conduct-as-dialog", true);
        this.passOriginalItemNameToResourcePacks = this.getBoolean("pass-original-item-name-to-resource-packs", true);
    }

    private DialogStyleConfig loadDialogStyleConfig(ConfigSection configSection) {
        return new DialogStyleConfig(this.getString(configSection, "page-navigation-title", "&9&lPage navigation"), this.getString(configSection, "page-navigation-next", "&9Left click: &6Go to next page"), this.getString(configSection, "page-navigation-previous", "&9Right click: &6Go to previous page"), this.getString(configSection, "increase-value", "&9Left click: &6Increase value by %s"), this.getString(configSection, "decrease-value", "&9Right click: &6Decrease value by %s"), this.getString(configSection, "value-range", "&7(Value between &a%s &7and &a%s&7)"), this.getString(configSection, "next-option", "&9Left click: &6Go to next option"), this.getString(configSection, "previous-option", "&9Right click: &6Go to previous option"), this.getString(configSection, "current-value", "&7Current value: &a%s"), this.getString(configSection, "edit-value", "&9Left click: &6Edit text"), this.getString(configSection, "set-text", "&9Left click/close: &6Set text"), this.getString(configSection, "close", "&9Left click: &6Close"), this.getString(configSection, "toggle-value", "&9Left click: &6Toggle value"));
    }

    protected String getString(ConfigSection configSection, String string, String string2) {
        return ChatColorUtil.translateAlternateColorCodes(configSection.getString(string, string2));
    }

    @Override
    public boolean addCustomEnchantsToLore() {
        return this.addCustomEnchantsToLore;
    }

    @Override
    public boolean addTeamColorTo1_13Prefix() {
        return this.addTeamColorToPrefix;
    }

    @Override
    public boolean isFix1_13FacePlayer() {
        return this.fix1_13FacePlayer;
    }

    @Override
    public boolean fix1_13FormattedInventoryTitle() {
        return this.fix1_13FormattedInventoryTitles;
    }

    @Override
    public boolean alwaysShowOriginalMobName() {
        return this.alwaysShowOriginalMobName;
    }

    @Override
    public boolean handlePingsAsInvAcknowledgements() {
        return this.handlePingsAsInvAcknowledgements || Boolean.getBoolean("com.viaversion.handlePingsAsInvAcknowledgements");
    }

    @Override
    public boolean bedrockAtY0() {
        return this.bedrockAtY0;
    }

    @Override
    public boolean sculkShriekerToCryingObsidian() {
        return this.sculkShriekersToCryingObsidian;
    }

    @Override
    public boolean scaffoldingToWater() {
        return this.scaffoldingToWater;
    }

    @Override
    public boolean mapDarknessEffect() {
        return this.mapDarknessEffect;
    }

    @Override
    public boolean mapCustomModelData() {
        return this.mapCustomModelData;
    }

    @Override
    public boolean mapDisplayEntities() {
        return this.mapDisplayEntities;
    }

    @Override
    public boolean suppressEmulationWarnings() {
        return this.suppressEmulationWarnings;
    }

    @Override
    public boolean dialogsViaChests() {
        return this.dialogsViaChests;
    }

    @Override
    public DialogStyleConfig dialogStyleConfig() {
        return this.dialogStyleConfig;
    }

    @Override
    public boolean codeOfConductAsDialog() {
        return this.codeOfConductAsDialog;
    }

    @Override
    public boolean passOriginalItemNameToResourcePacks() {
        return this.passOriginalItemNameToResourcePacks;
    }

    @Override
    public URL getDefaultConfigURL() {
        return this.getClass().getClassLoader().getResource("assets/viabackwards/config.yml");
    }

    @Override
    public InputStream getDefaultConfigInputStream() {
        return this.getClass().getClassLoader().getResourceAsStream("assets/viabackwards/config.yml");
    }

    @Override
    protected void handleConfig(Map<String, Object> map) {
    }

    @Override
    public List<String> getUnsupportedOptions() {
        return Collections.emptyList();
    }
}

