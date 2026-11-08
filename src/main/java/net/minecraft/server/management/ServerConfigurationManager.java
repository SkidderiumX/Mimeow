/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.network.play.server.S41PacketServerDifficulty;
import net.minecraft.network.play.server.S44PacketWorldBorder;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanList;
import net.minecraft.server.management.IPBanEntry;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.server.management.UserListBans;
import net.minecraft.server.management.UserListBansEntry;
import net.minecraft.server.management.UserListOps;
import net.minecraft.server.management.UserListOpsEntry;
import net.minecraft.server.management.UserListWhitelist;
import net.minecraft.server.management.UserListWhitelistEntry;
import net.minecraft.stats.StatList;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.border.IBorderListener;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.demo.DemoWorldManager;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ServerConfigurationManager {
    public static final File FILE_PLAYERBANS = new File("banned-players.json");
    public static final File FILE_IPBANS = new File("banned-ips.json");
    public static final File FILE_OPS = new File("ops.json");
    public static final File FILE_WHITELIST = new File("whitelist.json");
    private static final Logger logger = LogManager.getLogger();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    private final MinecraftServer mcServer;
    private final List<EntityPlayerMP> playerEntityList = Lists.newArrayList();
    private final Map<UUID, EntityPlayerMP> uuidToPlayerMap = Maps.newHashMap();
    private final UserListBans bannedPlayers = new UserListBans(FILE_PLAYERBANS);
    private final BanList bannedIPs = new BanList(FILE_IPBANS);
    private final UserListOps ops = new UserListOps(FILE_OPS);
    private final UserListWhitelist whiteListedPlayers = new UserListWhitelist(FILE_WHITELIST);
    private final Map<UUID, StatisticsFile> playerStatFiles = Maps.newHashMap();
    private IPlayerFileData playerNBTManagerObj;
    private boolean whiteListEnforced;
    protected int maxPlayers;
    private int viewDistance;
    private WorldSettings.GameType gameType;
    private boolean commandsAllowedForAll;
    private int playerPingIndex;

    public ServerConfigurationManager(MinecraftServer minecraftServer) {
        this.mcServer = minecraftServer;
        this.bannedPlayers.setLanServer(false);
        this.bannedIPs.setLanServer(false);
        this.maxPlayers = 8;
    }

    public void initializeConnectionToPlayer(NetworkManager networkManager, EntityPlayerMP entityPlayerMP) {
        GameProfile gameProfile = entityPlayerMP.getGameProfile();
        PlayerProfileCache playerProfileCache = this.mcServer.getPlayerProfileCache();
        GameProfile gameProfile2 = playerProfileCache.getProfileByUUID(gameProfile.getId());
        String string = gameProfile2 == null ? gameProfile.getName() : gameProfile2.getName();
        playerProfileCache.addEntry(gameProfile);
        NBTTagCompound nBTTagCompound = this.readPlayerDataFromFile(entityPlayerMP);
        entityPlayerMP.setWorld(this.mcServer.worldServerForDimension(entityPlayerMP.dimension));
        entityPlayerMP.theItemInWorldManager.setWorld((WorldServer)entityPlayerMP.worldObj);
        String string2 = "local";
        if (networkManager.getRemoteAddress() != null) {
            string2 = networkManager.getRemoteAddress().toString();
        }
        logger.info(entityPlayerMP.getName() + "[" + string2 + "] logged in with entity id " + entityPlayerMP.getEntityId() + " at (" + entityPlayerMP.posX + ", " + entityPlayerMP.posY + ", " + entityPlayerMP.posZ + ")");
        WorldServer worldServer = this.mcServer.worldServerForDimension(entityPlayerMP.dimension);
        WorldInfo worldInfo = worldServer.getWorldInfo();
        BlockPos blockPos = worldServer.getSpawnPoint();
        this.setPlayerGameTypeBasedOnOther(entityPlayerMP, null, worldServer);
        NetHandlerPlayServer netHandlerPlayServer = new NetHandlerPlayServer(this.mcServer, networkManager, entityPlayerMP);
        netHandlerPlayServer.sendPacket(new S01PacketJoinGame(entityPlayerMP.getEntityId(), entityPlayerMP.theItemInWorldManager.getGameType(), worldInfo.isHardcoreModeEnabled(), worldServer.provider.getDimensionId(), worldServer.getDifficulty(), this.getMaxPlayers(), worldInfo.getTerrainType(), worldServer.getGameRules().getBoolean("reducedDebugInfo")));
        netHandlerPlayServer.sendPacket(new S3FPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(this.getServerInstance().getServerModName())));
        netHandlerPlayServer.sendPacket(new S41PacketServerDifficulty(worldInfo.getDifficulty(), worldInfo.isDifficultyLocked()));
        netHandlerPlayServer.sendPacket(new S05PacketSpawnPosition(blockPos));
        netHandlerPlayServer.sendPacket(new S39PacketPlayerAbilities(entityPlayerMP.capabilities));
        netHandlerPlayServer.sendPacket(new S09PacketHeldItemChange(entityPlayerMP.inventory.currentItem));
        entityPlayerMP.getStatFile().func_150877_d();
        entityPlayerMP.getStatFile().sendAchievements(entityPlayerMP);
        this.sendScoreboard((ServerScoreboard)worldServer.getScoreboard(), entityPlayerMP);
        this.mcServer.refreshStatusNextTick();
        ChatComponentTranslation chatComponentTranslation = !entityPlayerMP.getName().equalsIgnoreCase(string) ? new ChatComponentTranslation("multiplayer.player.joined.renamed", entityPlayerMP.getDisplayName(), string) : new ChatComponentTranslation("multiplayer.player.joined", entityPlayerMP.getDisplayName());
        chatComponentTranslation.getChatStyle().setColor(EnumChatFormatting.YELLOW);
        this.sendChatMsg(chatComponentTranslation);
        this.playerLoggedIn(entityPlayerMP);
        netHandlerPlayServer.setPlayerLocation(entityPlayerMP.posX, entityPlayerMP.posY, entityPlayerMP.posZ, entityPlayerMP.rotationYaw, entityPlayerMP.rotationPitch);
        this.updateTimeAndWeatherForPlayer(entityPlayerMP, worldServer);
        if (this.mcServer.getResourcePackUrl().length() > 0) {
            entityPlayerMP.loadResourcePack(this.mcServer.getResourcePackUrl(), this.mcServer.getResourcePackHash());
        }
        Object object = entityPlayerMP.getActivePotionEffects().iterator();
        while (object.hasNext()) {
            PotionEffect potionEffect = object.next();
            netHandlerPlayServer.sendPacket(new S1DPacketEntityEffect(entityPlayerMP.getEntityId(), potionEffect));
        }
        entityPlayerMP.addSelfToInternalCraftingInventory();
        if (nBTTagCompound != null && nBTTagCompound.hasKey("Riding", 10) && (object = EntityList.createEntityFromNBT(nBTTagCompound.getCompoundTag("Riding"), worldServer)) != null) {
            ((Entity)object).forceSpawn = true;
            worldServer.spawnEntityInWorld((Entity)object);
            entityPlayerMP.mountEntity((Entity)object);
            ((Entity)object).forceSpawn = false;
        }
    }

    protected void sendScoreboard(ServerScoreboard serverScoreboard, EntityPlayerMP entityPlayerMP) {
        HashSet<ScoreObjective> hashSet = Sets.newHashSet();
        for (ScorePlayerTeam object : serverScoreboard.getTeams()) {
            entityPlayerMP.playerNetServerHandler.sendPacket(new S3EPacketTeams(object, 0));
        }
        for (int i = 0; i < 19; ++i) {
            ScoreObjective scoreObjective = serverScoreboard.getObjectiveInDisplaySlot(i);
            if (scoreObjective == null || hashSet.contains(scoreObjective)) continue;
            for (Packet packet : serverScoreboard.func_96550_d(scoreObjective)) {
                entityPlayerMP.playerNetServerHandler.sendPacket(packet);
            }
            hashSet.add(scoreObjective);
        }
    }

    public void setPlayerManager(WorldServer[] worldServerArray) {
        this.playerNBTManagerObj = worldServerArray[0].getSaveHandler().getPlayerNBTManager();
        worldServerArray[0].getWorldBorder().addListener(new IBorderListener(){

            @Override
            public void onSizeChanged(WorldBorder worldBorder, double d) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(worldBorder, S44PacketWorldBorder.Action.SET_SIZE));
            }

            @Override
            public void onTransitionStarted(WorldBorder worldBorder, double d, double d2, long l) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(worldBorder, S44PacketWorldBorder.Action.LERP_SIZE));
            }

            @Override
            public void onCenterChanged(WorldBorder worldBorder, double d, double d2) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(worldBorder, S44PacketWorldBorder.Action.SET_CENTER));
            }

            @Override
            public void onWarningTimeChanged(WorldBorder worldBorder, int n) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(worldBorder, S44PacketWorldBorder.Action.SET_WARNING_TIME));
            }

            @Override
            public void onWarningDistanceChanged(WorldBorder worldBorder, int n) {
                ServerConfigurationManager.this.sendPacketToAllPlayers(new S44PacketWorldBorder(worldBorder, S44PacketWorldBorder.Action.SET_WARNING_BLOCKS));
            }

            @Override
            public void onDamageAmountChanged(WorldBorder worldBorder, double d) {
            }

            @Override
            public void onDamageBufferChanged(WorldBorder worldBorder, double d) {
            }
        });
    }

    public void preparePlayer(EntityPlayerMP entityPlayerMP, WorldServer worldServer) {
        WorldServer worldServer2 = entityPlayerMP.getServerForPlayer();
        if (worldServer != null) {
            worldServer.getPlayerManager().removePlayer(entityPlayerMP);
        }
        worldServer2.getPlayerManager().addPlayer(entityPlayerMP);
        worldServer2.theChunkProviderServer.loadChunk((int)entityPlayerMP.posX >> 4, (int)entityPlayerMP.posZ >> 4);
    }

    public int getEntityViewDistance() {
        return PlayerManager.getFurthestViewableBlock(this.getViewDistance());
    }

    public NBTTagCompound readPlayerDataFromFile(EntityPlayerMP entityPlayerMP) {
        NBTTagCompound nBTTagCompound;
        NBTTagCompound nBTTagCompound2 = this.mcServer.worldServers[0].getWorldInfo().getPlayerNBTTagCompound();
        if (entityPlayerMP.getName().equals(this.mcServer.getServerOwner()) && nBTTagCompound2 != null) {
            entityPlayerMP.readFromNBT(nBTTagCompound2);
            nBTTagCompound = nBTTagCompound2;
            logger.debug("loading single player");
        } else {
            nBTTagCompound = this.playerNBTManagerObj.readPlayerData(entityPlayerMP);
        }
        return nBTTagCompound;
    }

    protected void writePlayerData(EntityPlayerMP entityPlayerMP) {
        this.playerNBTManagerObj.writePlayerData(entityPlayerMP);
        StatisticsFile statisticsFile = this.playerStatFiles.get(entityPlayerMP.getUniqueID());
        if (statisticsFile != null) {
            statisticsFile.saveStatFile();
        }
    }

    public void playerLoggedIn(EntityPlayerMP entityPlayerMP) {
        this.playerEntityList.add(entityPlayerMP);
        this.uuidToPlayerMap.put(entityPlayerMP.getUniqueID(), entityPlayerMP);
        this.sendPacketToAllPlayers(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.ADD_PLAYER, entityPlayerMP));
        WorldServer worldServer = this.mcServer.worldServerForDimension(entityPlayerMP.dimension);
        worldServer.spawnEntityInWorld(entityPlayerMP);
        this.preparePlayer(entityPlayerMP, null);
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            EntityPlayerMP entityPlayerMP2 = this.playerEntityList.get(i);
            entityPlayerMP.playerNetServerHandler.sendPacket(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.ADD_PLAYER, entityPlayerMP2));
        }
    }

    public void serverUpdateMountedMovingPlayer(EntityPlayerMP entityPlayerMP) {
        entityPlayerMP.getServerForPlayer().getPlayerManager().updateMountedMovingPlayer(entityPlayerMP);
    }

    public void playerLoggedOut(EntityPlayerMP entityPlayerMP) {
        entityPlayerMP.triggerAchievement(StatList.leaveGameStat);
        this.writePlayerData(entityPlayerMP);
        WorldServer worldServer = entityPlayerMP.getServerForPlayer();
        if (entityPlayerMP.ridingEntity != null) {
            worldServer.removePlayerEntityDangerously(entityPlayerMP.ridingEntity);
            logger.debug("removing player mount");
        }
        worldServer.removeEntity(entityPlayerMP);
        worldServer.getPlayerManager().removePlayer(entityPlayerMP);
        this.playerEntityList.remove(entityPlayerMP);
        UUID uUID = entityPlayerMP.getUniqueID();
        EntityPlayerMP entityPlayerMP2 = this.uuidToPlayerMap.get(uUID);
        if (entityPlayerMP2 == entityPlayerMP) {
            this.uuidToPlayerMap.remove(uUID);
            this.playerStatFiles.remove(uUID);
        }
        this.sendPacketToAllPlayers(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.REMOVE_PLAYER, entityPlayerMP));
    }

    public String allowUserToConnect(SocketAddress socketAddress, GameProfile gameProfile) {
        if (this.bannedPlayers.isBanned(gameProfile)) {
            UserListBansEntry userListBansEntry = (UserListBansEntry)this.bannedPlayers.getEntry(gameProfile);
            String string = "You are banned from this server!\nReason: " + userListBansEntry.getBanReason();
            if (userListBansEntry.getBanEndDate() != null) {
                string = string + "\nYour ban will be removed on " + dateFormat.format(userListBansEntry.getBanEndDate());
            }
            return string;
        }
        if (!this.canJoin(gameProfile)) {
            return "You are not white-listed on this server!";
        }
        if (this.bannedIPs.isBanned(socketAddress)) {
            IPBanEntry iPBanEntry = this.bannedIPs.getBanEntry(socketAddress);
            String string = "Your IP address is banned from this server!\nReason: " + iPBanEntry.getBanReason();
            if (iPBanEntry.getBanEndDate() != null) {
                string = string + "\nYour ban will be removed on " + dateFormat.format(iPBanEntry.getBanEndDate());
            }
            return string;
        }
        return this.playerEntityList.size() >= this.maxPlayers && !this.bypassesPlayerLimit(gameProfile) ? "The server is full!" : null;
    }

    public EntityPlayerMP createPlayerForUser(GameProfile gameProfile) {
        Object object;
        UUID uUID = EntityPlayer.getUUID(gameProfile);
        ArrayList<Object> arrayList = Lists.newArrayList();
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            object = this.playerEntityList.get(i);
            if (!((Entity)object).getUniqueID().equals(uUID)) continue;
            arrayList.add(object);
        }
        EntityPlayerMP entityPlayerMP = this.uuidToPlayerMap.get(gameProfile.getId());
        if (entityPlayerMP != null && !arrayList.contains(entityPlayerMP)) {
            arrayList.add(entityPlayerMP);
        }
        for (EntityPlayerMP entityPlayerMP2 : arrayList) {
            entityPlayerMP2.playerNetServerHandler.kickPlayerFromServer("You logged in from another location");
        }
        object = this.mcServer.isDemo() ? new DemoWorldManager(this.mcServer.worldServerForDimension(0)) : new ItemInWorldManager(this.mcServer.worldServerForDimension(0));
        return new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(0), gameProfile, (ItemInWorldManager)object);
    }

    public EntityPlayerMP recreatePlayerEntity(EntityPlayerMP entityPlayerMP, int n, boolean bl) {
        BlockPos blockPos;
        entityPlayerMP.getServerForPlayer().getEntityTracker().removePlayerFromTrackers(entityPlayerMP);
        entityPlayerMP.getServerForPlayer().getEntityTracker().untrackEntity(entityPlayerMP);
        entityPlayerMP.getServerForPlayer().getPlayerManager().removePlayer(entityPlayerMP);
        this.playerEntityList.remove(entityPlayerMP);
        this.mcServer.worldServerForDimension(entityPlayerMP.dimension).removePlayerEntityDangerously(entityPlayerMP);
        BlockPos blockPos2 = entityPlayerMP.getBedLocation();
        boolean bl2 = entityPlayerMP.isSpawnForced();
        entityPlayerMP.dimension = n;
        ItemInWorldManager itemInWorldManager = this.mcServer.isDemo() ? new DemoWorldManager(this.mcServer.worldServerForDimension(entityPlayerMP.dimension)) : new ItemInWorldManager(this.mcServer.worldServerForDimension(entityPlayerMP.dimension));
        EntityPlayerMP entityPlayerMP2 = new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(entityPlayerMP.dimension), entityPlayerMP.getGameProfile(), itemInWorldManager);
        entityPlayerMP2.playerNetServerHandler = entityPlayerMP.playerNetServerHandler;
        entityPlayerMP2.clonePlayer(entityPlayerMP, bl);
        entityPlayerMP2.setEntityId(entityPlayerMP.getEntityId());
        entityPlayerMP2.setCommandStats(entityPlayerMP);
        WorldServer worldServer = this.mcServer.worldServerForDimension(entityPlayerMP.dimension);
        this.setPlayerGameTypeBasedOnOther(entityPlayerMP2, entityPlayerMP, worldServer);
        if (blockPos2 != null) {
            blockPos = EntityPlayer.getBedSpawnLocation(this.mcServer.worldServerForDimension(entityPlayerMP.dimension), blockPos2, bl2);
            if (blockPos != null) {
                entityPlayerMP2.setLocationAndAngles((float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 0.1f, (float)blockPos.getZ() + 0.5f, 0.0f, 0.0f);
                entityPlayerMP2.setSpawnPoint(blockPos2, bl2);
            } else {
                entityPlayerMP2.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(0, 0.0f));
            }
        }
        worldServer.theChunkProviderServer.loadChunk((int)entityPlayerMP2.posX >> 4, (int)entityPlayerMP2.posZ >> 4);
        while (!worldServer.getCollidingBoundingBoxes(entityPlayerMP2, entityPlayerMP2.getEntityBoundingBox()).isEmpty() && entityPlayerMP2.posY < 256.0) {
            entityPlayerMP2.setPosition(entityPlayerMP2.posX, entityPlayerMP2.posY + 1.0, entityPlayerMP2.posZ);
        }
        entityPlayerMP2.playerNetServerHandler.sendPacket(new S07PacketRespawn(entityPlayerMP2.dimension, entityPlayerMP2.worldObj.getDifficulty(), entityPlayerMP2.worldObj.getWorldInfo().getTerrainType(), entityPlayerMP2.theItemInWorldManager.getGameType()));
        blockPos = worldServer.getSpawnPoint();
        entityPlayerMP2.playerNetServerHandler.setPlayerLocation(entityPlayerMP2.posX, entityPlayerMP2.posY, entityPlayerMP2.posZ, entityPlayerMP2.rotationYaw, entityPlayerMP2.rotationPitch);
        entityPlayerMP2.playerNetServerHandler.sendPacket(new S05PacketSpawnPosition(blockPos));
        entityPlayerMP2.playerNetServerHandler.sendPacket(new S1FPacketSetExperience(entityPlayerMP2.experience, entityPlayerMP2.experienceTotal, entityPlayerMP2.experienceLevel));
        this.updateTimeAndWeatherForPlayer(entityPlayerMP2, worldServer);
        worldServer.getPlayerManager().addPlayer(entityPlayerMP2);
        worldServer.spawnEntityInWorld(entityPlayerMP2);
        this.playerEntityList.add(entityPlayerMP2);
        this.uuidToPlayerMap.put(entityPlayerMP2.getUniqueID(), entityPlayerMP2);
        entityPlayerMP2.addSelfToInternalCraftingInventory();
        entityPlayerMP2.setHealth(entityPlayerMP2.getHealth());
        return entityPlayerMP2;
    }

    public void transferPlayerToDimension(EntityPlayerMP entityPlayerMP, int n) {
        int n2 = entityPlayerMP.dimension;
        WorldServer worldServer = this.mcServer.worldServerForDimension(entityPlayerMP.dimension);
        entityPlayerMP.dimension = n;
        WorldServer worldServer2 = this.mcServer.worldServerForDimension(entityPlayerMP.dimension);
        entityPlayerMP.playerNetServerHandler.sendPacket(new S07PacketRespawn(entityPlayerMP.dimension, entityPlayerMP.worldObj.getDifficulty(), entityPlayerMP.worldObj.getWorldInfo().getTerrainType(), entityPlayerMP.theItemInWorldManager.getGameType()));
        worldServer.removePlayerEntityDangerously(entityPlayerMP);
        entityPlayerMP.isDead = false;
        this.transferEntityToWorld(entityPlayerMP, n2, worldServer, worldServer2);
        this.preparePlayer(entityPlayerMP, worldServer);
        entityPlayerMP.playerNetServerHandler.setPlayerLocation(entityPlayerMP.posX, entityPlayerMP.posY, entityPlayerMP.posZ, entityPlayerMP.rotationYaw, entityPlayerMP.rotationPitch);
        entityPlayerMP.theItemInWorldManager.setWorld(worldServer2);
        this.updateTimeAndWeatherForPlayer(entityPlayerMP, worldServer2);
        this.syncPlayerInventory(entityPlayerMP);
        for (PotionEffect potionEffect : entityPlayerMP.getActivePotionEffects()) {
            entityPlayerMP.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(entityPlayerMP.getEntityId(), potionEffect));
        }
    }

    public void transferEntityToWorld(Entity entity, int n, WorldServer worldServer, WorldServer worldServer2) {
        double d = entity.posX;
        double d2 = entity.posZ;
        double d3 = 8.0;
        float f = entity.rotationYaw;
        worldServer.theProfiler.startSection("moving");
        if (entity.dimension == -1) {
            d = MathHelper.clamp_double(d / d3, worldServer2.getWorldBorder().minX() + 16.0, worldServer2.getWorldBorder().maxX() - 16.0);
            d2 = MathHelper.clamp_double(d2 / d3, worldServer2.getWorldBorder().minZ() + 16.0, worldServer2.getWorldBorder().maxZ() - 16.0);
            entity.setLocationAndAngles(d, entity.posY, d2, entity.rotationYaw, entity.rotationPitch);
            if (entity.isEntityAlive()) {
                worldServer.updateEntityWithOptionalForce(entity, false);
            }
        } else if (entity.dimension == 0) {
            d = MathHelper.clamp_double(d * d3, worldServer2.getWorldBorder().minX() + 16.0, worldServer2.getWorldBorder().maxX() - 16.0);
            d2 = MathHelper.clamp_double(d2 * d3, worldServer2.getWorldBorder().minZ() + 16.0, worldServer2.getWorldBorder().maxZ() - 16.0);
            entity.setLocationAndAngles(d, entity.posY, d2, entity.rotationYaw, entity.rotationPitch);
            if (entity.isEntityAlive()) {
                worldServer.updateEntityWithOptionalForce(entity, false);
            }
        } else {
            BlockPos blockPos = n == 1 ? worldServer2.getSpawnPoint() : worldServer2.getSpawnCoordinate();
            d = blockPos.getX();
            entity.posY = blockPos.getY();
            d2 = blockPos.getZ();
            entity.setLocationAndAngles(d, entity.posY, d2, 90.0f, 0.0f);
            if (entity.isEntityAlive()) {
                worldServer.updateEntityWithOptionalForce(entity, false);
            }
        }
        worldServer.theProfiler.endSection();
        if (n != 1) {
            worldServer.theProfiler.startSection("placing");
            d = MathHelper.clamp_int((int)d, -29999872, 29999872);
            d2 = MathHelper.clamp_int((int)d2, -29999872, 29999872);
            if (entity.isEntityAlive()) {
                entity.setLocationAndAngles(d, entity.posY, d2, entity.rotationYaw, entity.rotationPitch);
                worldServer2.getDefaultTeleporter().placeInPortal(entity, f);
                worldServer2.spawnEntityInWorld(entity);
                worldServer2.updateEntityWithOptionalForce(entity, false);
            }
            worldServer.theProfiler.endSection();
        }
        entity.setWorld(worldServer2);
    }

    public void onTick() {
        if (++this.playerPingIndex > 600) {
            this.sendPacketToAllPlayers(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.UPDATE_LATENCY, this.playerEntityList));
            this.playerPingIndex = 0;
        }
    }

    public void sendPacketToAllPlayers(Packet packet) {
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            this.playerEntityList.get((int)i).playerNetServerHandler.sendPacket(packet);
        }
    }

    public void sendPacketToAllPlayersInDimension(Packet packet, int n) {
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            EntityPlayerMP entityPlayerMP = this.playerEntityList.get(i);
            if (entityPlayerMP.dimension != n) continue;
            entityPlayerMP.playerNetServerHandler.sendPacket(packet);
        }
    }

    public void sendMessageToAllTeamMembers(EntityPlayer entityPlayer, IChatComponent iChatComponent) {
        Team team = entityPlayer.getTeam();
        if (team != null) {
            for (String string : team.getMembershipCollection()) {
                EntityPlayerMP entityPlayerMP = this.getPlayerByUsername(string);
                if (entityPlayerMP == null || entityPlayerMP == entityPlayer) continue;
                entityPlayerMP.addChatMessage(iChatComponent);
            }
        }
    }

    public void sendMessageToTeamOrEvryPlayer(EntityPlayer entityPlayer, IChatComponent iChatComponent) {
        Team team = entityPlayer.getTeam();
        if (team == null) {
            this.sendChatMsg(iChatComponent);
        } else {
            for (int i = 0; i < this.playerEntityList.size(); ++i) {
                EntityPlayerMP entityPlayerMP = this.playerEntityList.get(i);
                if (entityPlayerMP.getTeam() == team) continue;
                entityPlayerMP.addChatMessage(iChatComponent);
            }
        }
    }

    public String func_181058_b(boolean bl) {
        Object object = "";
        ArrayList<EntityPlayerMP> arrayList = Lists.newArrayList(this.playerEntityList);
        for (int i = 0; i < arrayList.size(); ++i) {
            if (i > 0) {
                object = (String)object + ", ";
            }
            object = (String)object + ((EntityPlayerMP)arrayList.get(i)).getName();
            if (!bl) continue;
            object = (String)object + " (" + ((EntityPlayerMP)arrayList.get(i)).getUniqueID().toString() + ")";
        }
        return object;
    }

    public String[] getAllUsernames() {
        String[] stringArray = new String[this.playerEntityList.size()];
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            stringArray[i] = this.playerEntityList.get(i).getName();
        }
        return stringArray;
    }

    public GameProfile[] getAllProfiles() {
        GameProfile[] gameProfileArray = new GameProfile[this.playerEntityList.size()];
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            gameProfileArray[i] = this.playerEntityList.get(i).getGameProfile();
        }
        return gameProfileArray;
    }

    public UserListBans getBannedPlayers() {
        return this.bannedPlayers;
    }

    public BanList getBannedIPs() {
        return this.bannedIPs;
    }

    public void addOp(GameProfile gameProfile) {
        this.ops.addEntry(new UserListOpsEntry(gameProfile, this.mcServer.getOpPermissionLevel(), this.ops.bypassesPlayerLimit(gameProfile)));
    }

    public void removeOp(GameProfile gameProfile) {
        this.ops.removeEntry(gameProfile);
    }

    public boolean canJoin(GameProfile gameProfile) {
        return !this.whiteListEnforced || this.ops.hasEntry(gameProfile) || this.whiteListedPlayers.hasEntry(gameProfile);
    }

    public boolean canSendCommands(GameProfile gameProfile) {
        return this.ops.hasEntry(gameProfile) || this.mcServer.isSinglePlayer() && this.mcServer.worldServers[0].getWorldInfo().areCommandsAllowed() && this.mcServer.getServerOwner().equalsIgnoreCase(gameProfile.getName()) || this.commandsAllowedForAll;
    }

    public EntityPlayerMP getPlayerByUsername(String string) {
        for (EntityPlayerMP entityPlayerMP : this.playerEntityList) {
            if (!entityPlayerMP.getName().equalsIgnoreCase(string)) continue;
            return entityPlayerMP;
        }
        return null;
    }

    public void sendToAllNear(double d, double d2, double d3, double d4, int n, Packet packet) {
        this.sendToAllNearExcept(null, d, d2, d3, d4, n, packet);
    }

    public void sendToAllNearExcept(EntityPlayer entityPlayer, double d, double d2, double d3, double d4, int n, Packet packet) {
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            double d5;
            double d6;
            double d7;
            EntityPlayerMP entityPlayerMP = this.playerEntityList.get(i);
            if (entityPlayerMP == entityPlayer || entityPlayerMP.dimension != n || !((d7 = d - entityPlayerMP.posX) * d7 + (d6 = d2 - entityPlayerMP.posY) * d6 + (d5 = d3 - entityPlayerMP.posZ) * d5 < d4 * d4)) continue;
            entityPlayerMP.playerNetServerHandler.sendPacket(packet);
        }
    }

    public void saveAllPlayerData() {
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            this.writePlayerData(this.playerEntityList.get(i));
        }
    }

    public void addWhitelistedPlayer(GameProfile gameProfile) {
        this.whiteListedPlayers.addEntry(new UserListWhitelistEntry(gameProfile));
    }

    public void removePlayerFromWhitelist(GameProfile gameProfile) {
        this.whiteListedPlayers.removeEntry(gameProfile);
    }

    public UserListWhitelist getWhitelistedPlayers() {
        return this.whiteListedPlayers;
    }

    public String[] getWhitelistedPlayerNames() {
        return this.whiteListedPlayers.getKeys();
    }

    public UserListOps getOppedPlayers() {
        return this.ops;
    }

    public String[] getOppedPlayerNames() {
        return this.ops.getKeys();
    }

    public void loadWhiteList() {
    }

    public void updateTimeAndWeatherForPlayer(EntityPlayerMP entityPlayerMP, WorldServer worldServer) {
        WorldBorder worldBorder = this.mcServer.worldServers[0].getWorldBorder();
        entityPlayerMP.playerNetServerHandler.sendPacket(new S44PacketWorldBorder(worldBorder, S44PacketWorldBorder.Action.INITIALIZE));
        entityPlayerMP.playerNetServerHandler.sendPacket(new S03PacketTimeUpdate(worldServer.getTotalWorldTime(), worldServer.getWorldTime(), worldServer.getGameRules().getBoolean("doDaylightCycle")));
        if (worldServer.isRaining()) {
            entityPlayerMP.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(1, 0.0f));
            entityPlayerMP.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(7, worldServer.getRainStrength(1.0f)));
            entityPlayerMP.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(8, worldServer.getThunderStrength(1.0f)));
        }
    }

    public void syncPlayerInventory(EntityPlayerMP entityPlayerMP) {
        entityPlayerMP.sendContainerToPlayer(entityPlayerMP.inventoryContainer);
        entityPlayerMP.setPlayerHealthUpdated();
        entityPlayerMP.playerNetServerHandler.sendPacket(new S09PacketHeldItemChange(entityPlayerMP.inventory.currentItem));
    }

    public int getCurrentPlayerCount() {
        return this.playerEntityList.size();
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public String[] getAvailablePlayerDat() {
        return this.mcServer.worldServers[0].getSaveHandler().getPlayerNBTManager().getAvailablePlayerDat();
    }

    public void setWhiteListEnabled(boolean bl) {
        this.whiteListEnforced = bl;
    }

    public List<EntityPlayerMP> getPlayersMatchingAddress(String string) {
        ArrayList<EntityPlayerMP> arrayList = Lists.newArrayList();
        for (EntityPlayerMP entityPlayerMP : this.playerEntityList) {
            if (!entityPlayerMP.getPlayerIP().equals(string)) continue;
            arrayList.add(entityPlayerMP);
        }
        return arrayList;
    }

    public int getViewDistance() {
        return this.viewDistance;
    }

    public MinecraftServer getServerInstance() {
        return this.mcServer;
    }

    public NBTTagCompound getHostPlayerData() {
        return null;
    }

    public void setGameType(WorldSettings.GameType gameType) {
        this.gameType = gameType;
    }

    private void setPlayerGameTypeBasedOnOther(EntityPlayerMP entityPlayerMP, EntityPlayerMP entityPlayerMP2, World world2) {
        if (entityPlayerMP2 != null) {
            entityPlayerMP.theItemInWorldManager.setGameType(entityPlayerMP2.theItemInWorldManager.getGameType());
        } else if (this.gameType != null) {
            entityPlayerMP.theItemInWorldManager.setGameType(this.gameType);
        }
        entityPlayerMP.theItemInWorldManager.initializeGameType(world2.getWorldInfo().getGameType());
    }

    public void setCommandsAllowedForAll(boolean bl) {
        this.commandsAllowedForAll = bl;
    }

    public void removeAllPlayers() {
        for (int i = 0; i < this.playerEntityList.size(); ++i) {
            this.playerEntityList.get((int)i).playerNetServerHandler.kickPlayerFromServer("Server closed");
        }
    }

    public void sendChatMsgImpl(IChatComponent iChatComponent, boolean bl) {
        this.mcServer.addChatMessage(iChatComponent);
        byte by = (byte)(bl ? 1 : 0);
        this.sendPacketToAllPlayers(new S02PacketChat(iChatComponent, by));
    }

    public void sendChatMsg(IChatComponent iChatComponent) {
        this.sendChatMsgImpl(iChatComponent, true);
    }

    public StatisticsFile getPlayerStatsFile(EntityPlayer entityPlayer) {
        StatisticsFile statisticsFile;
        UUID uUID = entityPlayer.getUniqueID();
        StatisticsFile statisticsFile2 = statisticsFile = uUID == null ? null : this.playerStatFiles.get(uUID);
        if (statisticsFile == null) {
            File file;
            File file2 = new File(this.mcServer.worldServerForDimension(0).getSaveHandler().getWorldDirectory(), "stats");
            File file3 = new File(file2, uUID.toString() + ".json");
            if (!file3.exists() && (file = new File(file2, entityPlayer.getName() + ".json")).exists() && file.isFile()) {
                file.renameTo(file3);
            }
            statisticsFile = new StatisticsFile(this.mcServer, file3);
            statisticsFile.readStatFile();
            this.playerStatFiles.put(uUID, statisticsFile);
        }
        return statisticsFile;
    }

    public void setViewDistance(int n) {
        this.viewDistance = n;
        if (this.mcServer.worldServers != null) {
            for (WorldServer worldServer : this.mcServer.worldServers) {
                if (worldServer == null) continue;
                worldServer.getPlayerManager().setPlayerViewRadius(n);
            }
        }
    }

    public List<EntityPlayerMP> getPlayerList() {
        return this.playerEntityList;
    }

    public EntityPlayerMP getPlayerByUUID(UUID uUID) {
        return this.uuidToPlayerMap.get(uUID);
    }

    public boolean bypassesPlayerLimit(GameProfile gameProfile) {
        return false;
    }
}

