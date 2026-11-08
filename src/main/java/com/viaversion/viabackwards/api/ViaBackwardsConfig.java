/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api;

import com.viaversion.viabackwards.api.DialogStyleConfig;
import com.viaversion.viaversion.api.configuration.Config;

public interface ViaBackwardsConfig
extends Config {
    public boolean addCustomEnchantsToLore();

    public boolean addTeamColorTo1_13Prefix();

    public boolean isFix1_13FacePlayer();

    public boolean fix1_13FormattedInventoryTitle();

    public boolean alwaysShowOriginalMobName();

    public boolean handlePingsAsInvAcknowledgements();

    public boolean bedrockAtY0();

    public boolean sculkShriekerToCryingObsidian();

    public boolean scaffoldingToWater();

    public boolean mapDarknessEffect();

    public boolean mapCustomModelData();

    public boolean mapDisplayEntities();

    public boolean suppressEmulationWarnings();

    public boolean dialogsViaChests();

    public DialogStyleConfig dialogStyleConfig();

    public boolean codeOfConductAsDialog();

    public boolean passOriginalItemNameToResourcePacks();
}

