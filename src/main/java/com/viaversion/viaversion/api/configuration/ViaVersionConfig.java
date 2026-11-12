/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.configuration;

import com.viaversion.viaversion.api.configuration.Config;
import com.viaversion.viaversion.api.configuration.RateLimitConfig;
import com.viaversion.viaversion.api.minecraft.WorldIdentifiers;
import com.viaversion.viaversion.api.protocol.version.BlockedProtocolVersions;
import com.viaversion.viaversion.libs.gson.JsonElement;
import java.util.concurrent.TimeUnit;

public interface ViaVersionConfig
extends Config {
    public boolean isCheckForUpdates();

    public void setCheckForUpdates(boolean var1);

    public boolean isPreventCollision();

    public boolean isNewEffectIndicator();

    public boolean isShowNewDeathMessages();

    public boolean logEntityDataErrors();

    @java.lang.Deprecated(forRemoval=true)
    default public boolean isSuppressMetadataErrors() {
        return !this.logEntityDataErrors();
    }

    public boolean isShieldBlocking();

    public boolean isNoDelayShieldBlocking();

    public boolean isShowShieldWhenSwordInHand();

    public boolean isHologramPatch();

    public boolean isPistonAnimationPatch();

    public boolean isBossbarPatch();

    public boolean isBossbarAntiflicker();

    public double getHologramYOffset();

    public boolean isAutoTeam();

    @java.lang.Deprecated(forRemoval=true)
    default public int getMaxPPS() {
        return this.getPacketTrackerConfig().maxRate();
    }

    @java.lang.Deprecated(forRemoval=true)
    default public String getMaxPPSKickMessage() {
        return this.getPacketTrackerConfig().maxRateKickMessage();
    }

    @java.lang.Deprecated(forRemoval=true)
    default public int getTrackingPeriod() {
        return (int)TimeUnit.NANOSECONDS.toSeconds(this.getPacketTrackerConfig().trackingPeriodNanos());
    }

    @java.lang.Deprecated(forRemoval=true)
    default public int getWarningPPS() {
        return this.getPacketTrackerConfig().warningRate();
    }

    @java.lang.Deprecated(forRemoval=true)
    default public int getMaxWarnings() {
        return this.getPacketTrackerConfig().maxWarnings();
    }

    @java.lang.Deprecated(forRemoval=true)
    default public String getMaxWarningsKickMessage() {
        return this.getPacketTrackerConfig().warningKickMessage();
    }

    public RateLimitConfig getPacketTrackerConfig();

    public RateLimitConfig getPacketSizeTrackerConfig();

    public boolean isSendSupportedVersions();

    public boolean isSimulatePlayerTick();

    public boolean isItemCache();

    public boolean isNMSPlayerTicking();

    public boolean isReplacePistons();

    public int getPistonReplacementId();

    public boolean isChunkBorderFix();

    public boolean isMultiReddustColorFix();

    public boolean is1_13TeamColourFix();

    public boolean shouldRegisterUserConnectionOnJoin();

    public boolean is1_12QuickMoveActionFix();

    public BlockedProtocolVersions blockedProtocolVersions();

    public String getBlockedDisconnectMsg();

    public boolean logBlockedJoins();

    public String getReloadDisconnectMsg();

    public boolean logOtherConversionWarnings();

    public boolean logTextComponentConversionErrors();

    @java.lang.Deprecated(forRemoval=true)
    default public boolean isSuppressConversionWarnings() {
        return !this.logOtherConversionWarnings();
    }

    @java.lang.Deprecated(forRemoval=true)
    default public boolean isSuppressTextComponentConversionWarnings() {
        return !this.logTextComponentConversionErrors();
    }

    public boolean isDisable1_13AutoComplete();

    public boolean isServersideBlockConnections();

    public String getBlockConnectionMethod();

    public boolean isReduceBlockStorageMemory();

    public boolean isStemWhenBlockAbove();

    public boolean isVineClimbFix();

    public boolean isSnowCollisionFix();

    public boolean isInfestedBlocksFix();

    public int get1_13TabCompleteDelay();

    public boolean isTruncate1_14Books();

    public boolean isLeftHandedHandling();

    public boolean is1_9HitboxFix();

    public boolean is1_14HitboxFix();

    public boolean isNonFullBlockLightFix();

    public boolean is1_14HealthNaNFix();

    public boolean is1_15InstantRespawn();

    public boolean isIgnoreLong1_16ChannelNames();

    public boolean isForcedUse1_17ResourcePack();

    public JsonElement get1_17ResourcePackPrompt();

    public WorldIdentifiers get1_16WorldNamesMap();

    public boolean cache1_17Light();

    public boolean isArmorToggleFix();

    public boolean translateOcelotToCat();

    public boolean enforceSecureChat();

    public boolean handleInvalidItemCount();

    public boolean cancelBlockSounds();

    public boolean hideScoreboardNumbers();

    public boolean fix1_21PlacementRotation();

    public boolean cancelSwingInInventory();

    public int maxErrorLength();

    public boolean use1_8HitboxMargin();

    public boolean sendPlayerDetails();

    public boolean sendServerDetails();
}

