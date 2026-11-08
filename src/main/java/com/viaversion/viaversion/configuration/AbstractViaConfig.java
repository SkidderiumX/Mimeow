/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.configuration;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.configuration.RateLimitConfig;
import com.viaversion.viaversion.api.configuration.ViaVersionConfig;
import com.viaversion.viaversion.api.minecraft.WorldIdentifiers;
import com.viaversion.viaversion.api.protocol.version.BlockedProtocolVersions;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSet;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocol.BlockedProtocolVersionsImpl;
import com.viaversion.viaversion.util.Config;
import com.viaversion.viaversion.util.ConfigSection;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

public class AbstractViaConfig
extends Config
implements ViaVersionConfig {
    public static final List<String> BUKKIT_ONLY_OPTIONS = Arrays.asList("register-userconnections-on-join", "quick-move-action-fix", "change-1_9-hitbox", "change-1_14-hitbox", "blockconnection-method", "armor-toggle-fix", "use-new-deathmessages", "item-cache", "nms-player-ticking");
    public static final List<String> VELOCITY_ONLY_OPTIONS = Arrays.asList("velocity-ping-interval", "velocity-ping-save", "velocity-servers");
    private boolean checkForUpdates;
    private boolean preventCollision;
    private boolean useNewEffectIndicator;
    private boolean logEntityDataErrors;
    private boolean shieldBlocking;
    private boolean noDelayShieldBlocking;
    private boolean showShieldWhenSwordInHand;
    private boolean hologramPatch;
    private boolean pistonAnimationPatch;
    private boolean bossbarPatch;
    private boolean bossbarAntiFlicker;
    private double hologramOffset;
    private RateLimitConfig packetTrackerConfig;
    private RateLimitConfig packetSizeTrackerConfig;
    private boolean sendSupportedVersions;
    private boolean simulatePlayerTick;
    private boolean replacePistons;
    private int pistonReplacementId;
    private boolean chunkBorderFix;
    private boolean autoTeam;
    private BlockedProtocolVersions blockedProtocolVersions;
    private String blockedDisconnectMessage;
    private boolean logBlockedJoins;
    private String reloadDisconnectMessage;
    private boolean logOtherConversionErrors;
    private boolean logTextComponentConversionErrors;
    private boolean multiReddustColorFix;
    private boolean disable1_13TabComplete;
    private boolean teamColourFix;
    private boolean serversideBlockConnections;
    private boolean reduceBlockStorageMemory;
    private boolean flowerStemWhenBlockAbove;
    private boolean vineClimbFix;
    private boolean snowCollisionFix;
    private boolean infestedBlocksFix;
    private int tabCompleteDelay;
    private boolean truncate1_14Books;
    private boolean leftHandedHandling;
    private boolean fullBlockLightFix;
    private boolean healthNaNFix;
    private boolean instantRespawn;
    private boolean ignoreLongChannelNames;
    private boolean forcedUse1_17ResourcePack;
    private JsonElement resourcePack1_17PromptMessage;
    private WorldIdentifiers map1_16WorldNames;
    private boolean cache1_17Light;
    private boolean translateOcelotToCat;
    private boolean enforceSecureChat;
    private boolean handleInvalidItemCount;
    private boolean cancelBlockSounds;
    private boolean hideScoreboardNumbers;
    private boolean fix1_21PlacementRotation;
    private boolean cancelSwingInInventory;
    private int maxErrorLength;
    private boolean use1_8HitboxMargin;
    private boolean sendPlayerDetails;
    private boolean sendServerDetails;

    public AbstractViaConfig(File file, Logger logger) {
        super(file, logger);
    }

    @Override
    public void reload() {
        super.reload();
        if (this.updateConfig()) {
            this.save();
        }
        this.loadFields();
    }

    @Override
    public List<String> getUnsupportedOptions() {
        ArrayList<String> arrayList = new ArrayList<String>(BUKKIT_ONLY_OPTIONS);
        arrayList.addAll(VELOCITY_ONLY_OPTIONS);
        arrayList.add("check-for-updates");
        return arrayList;
    }

    protected void loadFields() {
        this.checkForUpdates = this.getBoolean("check-for-updates", true);
        this.preventCollision = this.getBoolean("prevent-collision", true);
        this.useNewEffectIndicator = this.getBoolean("use-new-effect-indicator", true);
        this.shieldBlocking = this.getBoolean("shield-blocking", true);
        this.noDelayShieldBlocking = this.getBoolean("no-delay-shield-blocking", false);
        this.showShieldWhenSwordInHand = this.getBoolean("show-shield-when-sword-in-hand", false);
        this.hologramPatch = this.getBoolean("hologram-patch", false);
        this.pistonAnimationPatch = this.getBoolean("piston-animation-patch", false);
        this.bossbarPatch = this.getBoolean("bossbar-patch", true);
        this.bossbarAntiFlicker = this.getBoolean("bossbar-anti-flicker", false);
        this.hologramOffset = this.getDouble("hologram-y", -0.96);
        this.sendSupportedVersions = this.getBoolean("send-supported-versions", false);
        this.simulatePlayerTick = this.getBoolean("simulate-pt", true);
        this.replacePistons = this.getBoolean("replace-pistons", false);
        this.pistonReplacementId = this.getInt("replacement-piston-id", 0);
        this.chunkBorderFix = this.getBoolean("chunk-border-fix", false);
        this.autoTeam = this.getBoolean("auto-team", true);
        this.blockedProtocolVersions = this.loadBlockedProtocolVersions();
        this.blockedDisconnectMessage = this.getString("block-disconnect-msg", "You are using an unsupported Minecraft version!");
        this.reloadDisconnectMessage = this.getString("reload-disconnect-msg", "Server reload, please rejoin!");
        this.teamColourFix = this.getBoolean("team-colour-fix", true);
        this.multiReddustColorFix = this.getBoolean("multi-reddust-color-fix", false);
        this.disable1_13TabComplete = this.getBoolean("disable-1_13-auto-complete", false);
        this.serversideBlockConnections = this.getBoolean("serverside-blockconnections", true);
        this.reduceBlockStorageMemory = this.getBoolean("reduce-blockstorage-memory", false);
        this.flowerStemWhenBlockAbove = this.getBoolean("flowerstem-when-block-above", false);
        this.vineClimbFix = this.getBoolean("vine-climb-fix", false);
        this.snowCollisionFix = this.getBoolean("fix-low-snow-collision", false);
        this.infestedBlocksFix = this.getBoolean("fix-infested-block-breaking", true);
        this.tabCompleteDelay = this.getInt("1_13-tab-complete-delay", 0);
        this.truncate1_14Books = this.getBoolean("truncate-1_14-books", false);
        this.leftHandedHandling = this.getBoolean("left-handed-handling", true);
        this.fullBlockLightFix = this.getBoolean("fix-non-full-blocklight", false);
        this.healthNaNFix = this.getBoolean("fix-1_14-health-nan", true);
        this.instantRespawn = this.getBoolean("use-1_15-instant-respawn", false);
        this.ignoreLongChannelNames = this.getBoolean("ignore-long-1_16-channel-names", true);
        this.forcedUse1_17ResourcePack = this.getBoolean("forced-use-1_17-resource-pack", false);
        this.resourcePack1_17PromptMessage = this.getSerializedComponent("resource-pack-1_17-prompt");
        Map map = this.get("map-1_16-world-names", new HashMap());
        this.map1_16WorldNames = new WorldIdentifiers(map.getOrDefault("overworld", "minecraft:overworld"), map.getOrDefault("nether", "minecraft:the_nether"), map.getOrDefault("end", "minecraft:the_end"));
        this.cache1_17Light = this.getBoolean("cache-1_17-light", true);
        this.translateOcelotToCat = this.getBoolean("translate-ocelot-to-cat", true);
        this.enforceSecureChat = this.getBoolean("enforce-secure-chat", false);
        this.handleInvalidItemCount = this.getBoolean("handle-invalid-item-count", false);
        this.cancelBlockSounds = this.getBoolean("cancel-block-sounds", true);
        this.hideScoreboardNumbers = this.getBoolean("hide-scoreboard-numbers", false);
        this.fix1_21PlacementRotation = this.getBoolean("fix-1_21-placement-rotation", true);
        this.cancelSwingInInventory = this.getBoolean("cancel-swing-in-inventory", true);
        this.use1_8HitboxMargin = this.getBoolean("use-1_8-hitbox-margin", true);
        this.sendPlayerDetails = this.getBoolean("send-player-details", true);
        this.sendServerDetails = this.getBoolean("send-server-details", true);
        this.packetTrackerConfig = this.loadRateLimitConfig(this.getSection("packet-limiter"), "%pps", 1);
        this.packetSizeTrackerConfig = this.loadRateLimitConfig(this.getSection("packet-size-limiter"), "%bps", 1024);
        ConfigSection configSection = this.getSection("logging");
        this.logBlockedJoins = configSection.getBoolean("log-blocked-joins", false);
        this.logEntityDataErrors = configSection.getBoolean("log-entity-data-errors", true);
        this.logTextComponentConversionErrors = configSection.getBoolean("log-text-component-conversion-errors", false);
        this.logOtherConversionErrors = configSection.getBoolean("log-other-conversion-warnings", false);
        this.maxErrorLength = configSection.getInt("max-error-length", 1500);
    }

    protected boolean updateConfig() {
        ConfigSection configSection = this.originalRootSection();
        if (configSection == null) {
            return false;
        }
        boolean bl = false;
        if (configSection.contains("max-pps")) {
            ConfigSection configSection2 = this.getSection("packet-limiter");
            configSection2.set("max-per-second", configSection.getInt("max-pps", -1));
            configSection2.set("max-per-second-kick-message", configSection.getString("max-pps-kick-msg", "You are sending too many packets!"));
            configSection2.set("sustained-max-per-second", configSection.getInt("tracking-warning-pps", -1));
            configSection2.set("sustained-threshold", configSection.getInt("tracking-max-warnings", 3));
            configSection2.set("sustained-period-seconds", configSection.getInt("tracking-period", 7));
            configSection2.set("sustained-kick-message", configSection.getString("tracking-max-kick-msg", "You are sending too many packets, :("));
            bl = true;
        }
        int n = configSection.getInt("init-config-version", 0);
        int n2 = configSection.getInt("config-version", 0);
        boolean bl2 = configSection.getBoolean("migrate-default-config-changes", true);
        if (n2 < 1 && bl2) {
            ConfigSection configSection3 = this.getSection("packet-limiter");
            int n3 = configSection3.getInt("sustained-max-per-second", 0);
            if (n3 == 120 || n3 == 150) {
                configSection3.set("sustained-max-per-second", 200);
                bl = true;
            }
            if (configSection3.getInt("sustained-period-seconds", 0) == 6) {
                configSection3.set("sustained-period-seconds", 7);
                bl = true;
            }
            ConfigSection configSection4 = this.getSection("logging");
            configSection4.set("log-blocked-joins", configSection.getBoolean("log-blocked-joins", false));
            configSection4.set("log-entity-data-errors", !configSection.getBoolean("suppress-metadata-errors", false));
            configSection4.set("max-error-length", configSection.getInt("max-error-length", 1500));
        }
        return bl;
    }

    private BlockedProtocolVersions loadBlockedProtocolVersions() {
        List<Integer> list = this.getListSafe("block-protocols", Integer.class, "Invalid blocked version protocol found in config: '%s'");
        List<String> list2 = this.getListSafe("block-versions", String.class, "Invalid blocked version found in config: '%s'");
        ObjectSet objectSet = list.stream().map(ProtocolVersion::getProtocol).collect(ObjectOpenHashSet::of, Set::add, Set::addAll);
        ProtocolVersion protocolVersion = ProtocolVersion.unknown;
        ProtocolVersion protocolVersion2 = ProtocolVersion.unknown;
        for (String object : list2) {
            ProtocolVersion protocolVersion4;
            if (object.isEmpty()) continue;
            char c = object.charAt(0);
            if (c == '<' || c == '>') {
                protocolVersion4 = this.protocolVersion(object.substring(1));
                if (protocolVersion4 == null) continue;
                if (c == '<') {
                    if (protocolVersion.isKnown()) {
                        this.logger.warning("Already set lower bound " + String.valueOf(protocolVersion) + " overridden by " + protocolVersion4.getName());
                    }
                    protocolVersion = protocolVersion4;
                    continue;
                }
                if (protocolVersion2.isKnown()) {
                    this.logger.warning("Already set upper bound " + String.valueOf(protocolVersion2) + " overridden by " + protocolVersion4.getName());
                }
                protocolVersion2 = protocolVersion4;
                continue;
            }
            protocolVersion4 = this.protocolVersion(object);
            if (protocolVersion4 == null || objectSet.add(protocolVersion4)) continue;
            this.logger.warning("Duplicated blocked protocol version " + String.valueOf(protocolVersion4));
        }
        if (protocolVersion.isKnown() || protocolVersion2.isKnown()) {
            ProtocolVersion protocolVersion4 = protocolVersion;
            ProtocolVersion protocolVersion5 = protocolVersion2;
            objectSet.removeIf(protocolVersion3 -> {
                if (protocolVersion4.isKnown() && protocolVersion3.olderThan(protocolVersion4) || protocolVersion5.isKnown() && protocolVersion3.newerThan(protocolVersion5)) {
                    this.logger.warning("Blocked protocol version " + String.valueOf(protocolVersion3) + " already covered by upper or lower bound");
                    return true;
                }
                return false;
            });
        }
        return new BlockedProtocolVersionsImpl(objectSet, protocolVersion, protocolVersion2);
    }

    private RateLimitConfig loadRateLimitConfig(ConfigSection configSection, String string, int n) {
        int n2 = configSection.getInt("max-per-second", -1);
        int n3 = configSection.getInt("sustained-max-per-second", -1);
        return new RateLimitConfig(configSection.getBoolean("enabled", true), n2 != -1 ? n2 * n : -1, configSection.getString("max-per-second-kick-message", "You are sending too many packets!"), n3 != -1 ? n3 * n : -1, configSection.getInt("sustained-threshold", 3), TimeUnit.SECONDS.toNanos(configSection.getInt("sustained-period-seconds", 6)), configSection.getString("sustained-kick-message", "You are sending too many packets, :("), string);
    }

    private @Nullable ProtocolVersion protocolVersion(String string) {
        ProtocolVersion protocolVersion = ProtocolVersion.getClosest(string);
        if (protocolVersion == null) {
            this.logger.warning("Unknown protocol version in block-versions: " + string);
            return null;
        }
        return protocolVersion;
    }

    @Override
    public boolean isCheckForUpdates() {
        return this.checkForUpdates;
    }

    @Override
    public void setCheckForUpdates(boolean bl) {
        this.checkForUpdates = bl;
        this.set("checkforupdates", bl);
    }

    @Override
    public boolean isPreventCollision() {
        return this.preventCollision;
    }

    @Override
    public boolean isNewEffectIndicator() {
        return this.useNewEffectIndicator;
    }

    @Override
    public boolean isShowNewDeathMessages() {
        return false;
    }

    @Override
    public boolean logEntityDataErrors() {
        return this.logEntityDataErrors || Via.getManager().isDebug();
    }

    @Override
    public boolean isShieldBlocking() {
        return this.shieldBlocking;
    }

    @Override
    public boolean isNoDelayShieldBlocking() {
        return this.noDelayShieldBlocking;
    }

    @Override
    public boolean isShowShieldWhenSwordInHand() {
        return this.showShieldWhenSwordInHand;
    }

    @Override
    public boolean isHologramPatch() {
        return this.hologramPatch;
    }

    @Override
    public boolean isPistonAnimationPatch() {
        return this.pistonAnimationPatch;
    }

    @Override
    public boolean isBossbarPatch() {
        return this.bossbarPatch;
    }

    @Override
    public boolean isBossbarAntiflicker() {
        return this.bossbarAntiFlicker;
    }

    @Override
    public double getHologramYOffset() {
        return this.hologramOffset;
    }

    @Override
    public RateLimitConfig getPacketTrackerConfig() {
        return this.packetTrackerConfig;
    }

    @Override
    public RateLimitConfig getPacketSizeTrackerConfig() {
        return this.packetSizeTrackerConfig;
    }

    @Override
    public boolean isSendSupportedVersions() {
        return this.sendSupportedVersions;
    }

    @Override
    public boolean isSimulatePlayerTick() {
        return this.simulatePlayerTick;
    }

    @Override
    public boolean isItemCache() {
        return false;
    }

    @Override
    public boolean isNMSPlayerTicking() {
        return false;
    }

    @Override
    public boolean isReplacePistons() {
        return this.replacePistons;
    }

    @Override
    public int getPistonReplacementId() {
        return this.pistonReplacementId;
    }

    @Override
    public boolean isChunkBorderFix() {
        return this.chunkBorderFix;
    }

    @Override
    public boolean isAutoTeam() {
        return this.preventCollision && this.autoTeam;
    }

    @Override
    public boolean shouldRegisterUserConnectionOnJoin() {
        return false;
    }

    @Override
    public boolean is1_12QuickMoveActionFix() {
        return false;
    }

    @Override
    public BlockedProtocolVersions blockedProtocolVersions() {
        return this.blockedProtocolVersions;
    }

    @Override
    public String getBlockedDisconnectMsg() {
        return this.blockedDisconnectMessage;
    }

    @Override
    public boolean logBlockedJoins() {
        return this.logBlockedJoins;
    }

    @Override
    public String getReloadDisconnectMsg() {
        return this.reloadDisconnectMessage;
    }

    @Override
    public boolean isMultiReddustColorFix() {
        return this.multiReddustColorFix;
    }

    @Override
    public boolean is1_13TeamColourFix() {
        return this.teamColourFix;
    }

    @Override
    public boolean logOtherConversionWarnings() {
        return this.logOtherConversionErrors || Via.getManager().isDebug();
    }

    @Override
    public boolean logTextComponentConversionErrors() {
        return this.logTextComponentConversionErrors || Via.getManager().isDebug();
    }

    @Override
    public boolean isDisable1_13AutoComplete() {
        return this.disable1_13TabComplete;
    }

    @Override
    public boolean isServersideBlockConnections() {
        return this.serversideBlockConnections;
    }

    @Override
    public String getBlockConnectionMethod() {
        return "packet";
    }

    @Override
    public boolean isReduceBlockStorageMemory() {
        return this.reduceBlockStorageMemory;
    }

    @Override
    public boolean isStemWhenBlockAbove() {
        return this.flowerStemWhenBlockAbove;
    }

    @Override
    public boolean isVineClimbFix() {
        return this.vineClimbFix;
    }

    @Override
    public boolean isSnowCollisionFix() {
        return this.snowCollisionFix;
    }

    @Override
    public boolean isInfestedBlocksFix() {
        return this.infestedBlocksFix;
    }

    @Override
    public int get1_13TabCompleteDelay() {
        return this.tabCompleteDelay;
    }

    @Override
    public boolean isTruncate1_14Books() {
        return this.truncate1_14Books;
    }

    @Override
    public boolean isLeftHandedHandling() {
        return this.leftHandedHandling;
    }

    @Override
    public boolean is1_9HitboxFix() {
        return false;
    }

    @Override
    public boolean is1_14HitboxFix() {
        return false;
    }

    @Override
    public boolean isNonFullBlockLightFix() {
        return this.fullBlockLightFix;
    }

    @Override
    public boolean is1_14HealthNaNFix() {
        return this.healthNaNFix;
    }

    @Override
    public boolean is1_15InstantRespawn() {
        return this.instantRespawn;
    }

    @Override
    public boolean isIgnoreLong1_16ChannelNames() {
        return this.ignoreLongChannelNames;
    }

    @Override
    public boolean isForcedUse1_17ResourcePack() {
        return this.forcedUse1_17ResourcePack;
    }

    @Override
    public JsonElement get1_17ResourcePackPrompt() {
        return this.resourcePack1_17PromptMessage;
    }

    @Override
    public WorldIdentifiers get1_16WorldNamesMap() {
        return this.map1_16WorldNames;
    }

    @Override
    public boolean cache1_17Light() {
        return this.cache1_17Light;
    }

    @Override
    public boolean isArmorToggleFix() {
        return false;
    }

    @Override
    public boolean translateOcelotToCat() {
        return this.translateOcelotToCat;
    }

    @Override
    public boolean enforceSecureChat() {
        return this.enforceSecureChat;
    }

    @Override
    public boolean handleInvalidItemCount() {
        return this.handleInvalidItemCount;
    }

    @Override
    public boolean cancelBlockSounds() {
        return this.cancelBlockSounds;
    }

    @Override
    public boolean hideScoreboardNumbers() {
        return this.hideScoreboardNumbers;
    }

    @Override
    public boolean fix1_21PlacementRotation() {
        return this.fix1_21PlacementRotation;
    }

    @Override
    public boolean cancelSwingInInventory() {
        return this.cancelSwingInInventory;
    }

    @Override
    public int maxErrorLength() {
        return this.maxErrorLength;
    }

    @Override
    public boolean use1_8HitboxMargin() {
        return this.use1_8HitboxMargin;
    }

    @Override
    public boolean sendPlayerDetails() {
        return this.sendPlayerDetails;
    }

    @Override
    public boolean sendServerDetails() {
        return this.sendServerDetails;
    }
}

