/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.world.WorldType;
import net.minecraft.world.storage.WorldInfo;

public class WorldSettings {
    private final long seed;
    private final GameType theGameType;
    private final boolean mapFeaturesEnabled;
    private final boolean hardcoreEnabled;
    private final WorldType terrainType;
    private boolean commandsAllowed;
    private boolean bonusChestEnabled;
    private String worldName = "";

    public WorldSettings(long l, GameType gameType, boolean bl, boolean bl2, WorldType worldType) {
        this.seed = l;
        this.theGameType = gameType;
        this.mapFeaturesEnabled = bl;
        this.hardcoreEnabled = bl2;
        this.terrainType = worldType;
    }

    public WorldSettings(WorldInfo worldInfo) {
        this(worldInfo.getSeed(), worldInfo.getGameType(), worldInfo.isMapFeaturesEnabled(), worldInfo.isHardcoreModeEnabled(), worldInfo.getTerrainType());
    }

    public WorldSettings enableBonusChest() {
        this.bonusChestEnabled = true;
        return this;
    }

    public WorldSettings enableCommands() {
        this.commandsAllowed = true;
        return this;
    }

    public WorldSettings setWorldName(String string) {
        this.worldName = string;
        return this;
    }

    public boolean isBonusChestEnabled() {
        return this.bonusChestEnabled;
    }

    public long getSeed() {
        return this.seed;
    }

    public GameType getGameType() {
        return this.theGameType;
    }

    public boolean getHardcoreEnabled() {
        return this.hardcoreEnabled;
    }

    public boolean isMapFeaturesEnabled() {
        return this.mapFeaturesEnabled;
    }

    public WorldType getTerrainType() {
        return this.terrainType;
    }

    public boolean areCommandsAllowed() {
        return this.commandsAllowed;
    }

    public static GameType getGameTypeById(int n) {
        return GameType.getByID(n);
    }

    public String getWorldName() {
        return this.worldName;
    }

    public static enum GameType {
        NOT_SET(-1, ""),
        SURVIVAL(0, "survival"),
        CREATIVE(1, "creative"),
        ADVENTURE(2, "adventure"),
        SPECTATOR(3, "spectator");

        int id;
        String name;

        private GameType(int n2, String string2) {
            this.id = n2;
            this.name = string2;
        }

        public int getID() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void configurePlayerCapabilities(PlayerCapabilities playerCapabilities) {
            if (this == CREATIVE) {
                playerCapabilities.allowFlying = true;
                playerCapabilities.isCreativeMode = true;
                playerCapabilities.disableDamage = true;
            } else if (this == SPECTATOR) {
                playerCapabilities.allowFlying = true;
                playerCapabilities.isCreativeMode = false;
                playerCapabilities.disableDamage = true;
                playerCapabilities.isFlying = true;
            } else {
                playerCapabilities.allowFlying = false;
                playerCapabilities.isCreativeMode = false;
                playerCapabilities.disableDamage = false;
                playerCapabilities.isFlying = false;
            }
            playerCapabilities.allowEdit = !this.isAdventure();
        }

        public boolean isAdventure() {
            return this == ADVENTURE || this == SPECTATOR;
        }

        public boolean isCreative() {
            return this == CREATIVE;
        }

        public boolean isSurvivalOrAdventure() {
            return this == SURVIVAL || this == ADVENTURE;
        }

        public static GameType getByID(int n) {
            for (GameType gameType : GameType.values()) {
                if (gameType.id != n) continue;
                return gameType;
            }
            return SURVIVAL;
        }

        public static GameType getByName(String string) {
            for (GameType gameType : GameType.values()) {
                if (!gameType.name.equals(string)) continue;
                return gameType;
            }
            return SURVIVAL;
        }
    }
}

