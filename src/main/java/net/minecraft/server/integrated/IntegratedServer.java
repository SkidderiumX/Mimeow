/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.integrated;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ThreadLanServerPing;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedPlayerList;
import net.minecraft.server.integrated.IntegratedServerCommandManager;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.CryptManager;
import net.minecraft.util.HttpUtil;
import net.minecraft.util.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldServerMulti;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import net.optifine.ClearWater;
import net.optifine.reflect.Reflector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntegratedServer
extends MinecraftServer {
    private static final Logger logger = LogManager.getLogger();
    private final Minecraft mc;
    private final WorldSettings theWorldSettings;
    private boolean isGamePaused;
    private boolean isPublic;
    private ThreadLanServerPing lanServerPing;
    private long ticksSaveLast = 0L;
    public World difficultyUpdateWorld = null;
    public BlockPos difficultyUpdatePos = null;
    public DifficultyInstance difficultyLast = null;

    public IntegratedServer(Minecraft minecraft) {
        super(minecraft.getProxy(), new File(minecraft.mcDataDir, USER_CACHE_FILE.getName()));
        this.mc = minecraft;
        this.theWorldSettings = null;
    }

    public IntegratedServer(Minecraft minecraft, String string, String string2, WorldSettings worldSettings) {
        super(new File(minecraft.mcDataDir, "saves"), minecraft.getProxy(), new File(minecraft.mcDataDir, USER_CACHE_FILE.getName()));
        NBTTagCompound nBTTagCompound;
        this.setServerOwner(minecraft.getSession().getUsername());
        this.setFolderName(string);
        this.setWorldName(string2);
        this.setDemo(minecraft.isDemo());
        this.canCreateBonusChest(worldSettings.isBonusChestEnabled());
        this.setBuildLimit(256);
        this.setConfigManager(new IntegratedPlayerList(this));
        this.mc = minecraft;
        this.theWorldSettings = this.isDemo() ? DemoWorldServer.demoWorldSettings : worldSettings;
        ISaveHandler iSaveHandler = this.getActiveAnvilConverter().getSaveLoader(string, false);
        WorldInfo worldInfo = iSaveHandler.loadWorldInfo();
        if (worldInfo != null && (nBTTagCompound = worldInfo.getPlayerNBTTagCompound()) != null && nBTTagCompound.hasKey("Dimension")) {
            int n;
            PacketThreadUtil.lastDimensionId = n = nBTTagCompound.getInteger("Dimension");
            this.mc.loadingScreen.setLoadingProgress(-1);
        }
    }

    @Override
    protected ServerCommandManager createNewCommandManager() {
        return new IntegratedServerCommandManager();
    }

    @Override
    protected void loadAllWorlds(String string, String string2, long l, WorldType worldType, String string3) {
        this.convertMapIfNeeded(string);
        boolean bl = Reflector.DimensionManager.exists();
        if (!bl) {
            this.worldServers = new WorldServer[3];
            this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
        }
        ISaveHandler iSaveHandler = this.getActiveAnvilConverter().getSaveLoader(string, true);
        this.setResourcePackFromWorld(this.getFolderName(), iSaveHandler);
        WorldInfo worldInfo = iSaveHandler.loadWorldInfo();
        if (worldInfo == null) {
            worldInfo = new WorldInfo(this.theWorldSettings, string2);
        } else {
            worldInfo.setWorldName(string2);
        }
        if (bl) {
            Integer[] integerArray;
            WorldServer worldServer = this.isDemo() ? (WorldServer)new DemoWorldServer(this, iSaveHandler, worldInfo, 0, this.theProfiler).init() : (WorldServer)new WorldServer(this, iSaveHandler, worldInfo, 0, this.theProfiler).init();
            worldServer.initialize(this.theWorldSettings);
            Integer[] integerArray2 = integerArray = (Integer[])Reflector.call(Reflector.DimensionManager_getStaticDimensionIDs, new Object[0]);
            int n = integerArray.length;
            for (int i = 0; i < n; ++i) {
                int n2 = integerArray2[i];
                WorldServer worldServer2 = n2 == 0 ? worldServer : (WorldServer)new WorldServerMulti((MinecraftServer)this, iSaveHandler, n2, worldServer, this.theProfiler).init();
                worldServer2.addWorldAccess(new WorldManager(this, worldServer2));
                if (!this.isSinglePlayer()) {
                    worldServer2.getWorldInfo().setGameType(this.getGameType());
                }
                if (!Reflector.EventBus.exists()) continue;
                Reflector.postCompatBusEvent(Reflector.WorldEvent_Load_Constructor, worldServer2);
            }
            this.getConfigurationManager().setPlayerManager(new WorldServer[]{worldServer});
            if (worldServer.getWorldInfo().getDifficulty() == null) {
                this.setDifficultyForAllWorlds(this.mc.gameSettings.difficulty);
            }
        } else {
            for (int i = 0; i < this.worldServers.length; ++i) {
                int n = 0;
                if (i == 1) {
                    n = -1;
                }
                if (i == 2) {
                    n = 1;
                }
                if (i == 0) {
                    this.worldServers[i] = this.isDemo() ? (WorldServer)new DemoWorldServer(this, iSaveHandler, worldInfo, n, this.theProfiler).init() : (WorldServer)new WorldServer(this, iSaveHandler, worldInfo, n, this.theProfiler).init();
                    this.worldServers[i].initialize(this.theWorldSettings);
                } else {
                    this.worldServers[i] = (WorldServer)new WorldServerMulti((MinecraftServer)this, iSaveHandler, n, this.worldServers[0], this.theProfiler).init();
                }
                this.worldServers[i].addWorldAccess(new WorldManager(this, this.worldServers[i]));
            }
            this.getConfigurationManager().setPlayerManager(this.worldServers);
            if (this.worldServers[0].getWorldInfo().getDifficulty() == null) {
                this.setDifficultyForAllWorlds(this.mc.gameSettings.difficulty);
            }
        }
        this.initialWorldChunkLoad();
    }

    @Override
    protected boolean startServer() throws IOException {
        Object object;
        logger.info("Starting integrated minecraft server version 1.9");
        this.setOnlineMode(true);
        this.setCanSpawnAnimals(true);
        this.setCanSpawnNPCs(true);
        this.setAllowPvp(true);
        this.setAllowFlight(true);
        logger.info("Generating keypair");
        this.setKeyPair(CryptManager.generateKeyPair());
        if (Reflector.OptionalLoaderCommonHandler_handleServerAboutToStart.exists()) {
            object = Reflector.call(Reflector.OptionalLoaderCommonHandler_instance, new Object[0]);
            if (!Reflector.callBoolean(object, Reflector.OptionalLoaderCommonHandler_handleServerAboutToStart, this)) {
                return false;
            }
        }
        this.loadAllWorlds(this.getFolderName(), this.getWorldName(), this.theWorldSettings.getSeed(), this.theWorldSettings.getTerrainType(), this.theWorldSettings.getWorldName());
        this.setMOTD(this.getServerOwner() + " - " + this.worldServers[0].getWorldInfo().getWorldName());
        if (Reflector.OptionalLoaderCommonHandler_handleServerStarting.exists()) {
            object = Reflector.call(Reflector.OptionalLoaderCommonHandler_instance, new Object[0]);
            if (Reflector.OptionalLoaderCommonHandler_handleServerStarting.getReturnType() == Boolean.TYPE) {
                return Reflector.callBoolean(object, Reflector.OptionalLoaderCommonHandler_handleServerStarting, this);
            }
            Reflector.callVoid(object, Reflector.OptionalLoaderCommonHandler_handleServerStarting, this);
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void tick() {
        this.onTick();
        boolean bl = this.isGamePaused;
        boolean bl2 = this.isGamePaused = Minecraft.getMinecraft().getNetHandler() != null && Minecraft.getMinecraft().isGamePaused();
        if (!bl && this.isGamePaused) {
            logger.info("Saving and pausing game...");
            this.getConfigurationManager().saveAllPlayerData();
            this.saveAllWorlds(false);
        }
        if (this.isGamePaused) {
            Queue queue = this.futureTaskQueue;
            synchronized (queue) {
                while (!this.futureTaskQueue.isEmpty()) {
                    Util.runTask((FutureTask)this.futureTaskQueue.poll(), logger);
                }
            }
        } else {
            super.tick();
            if (this.mc.gameSettings.renderDistanceChunks != this.getConfigurationManager().getViewDistance()) {
                logger.info("Changing view distance to {}, from {}", this.mc.gameSettings.renderDistanceChunks, this.getConfigurationManager().getViewDistance());
                this.getConfigurationManager().setViewDistance(this.mc.gameSettings.renderDistanceChunks);
            }
            if (this.mc.theWorld != null) {
                WorldInfo worldInfo = this.worldServers[0].getWorldInfo();
                WorldInfo worldInfo2 = this.mc.theWorld.getWorldInfo();
                if (!worldInfo.isDifficultyLocked() && worldInfo2.getDifficulty() != worldInfo.getDifficulty()) {
                    logger.info("Changing difficulty to {}, from {}", new Object[]{worldInfo2.getDifficulty(), worldInfo.getDifficulty()});
                    this.setDifficultyForAllWorlds(worldInfo2.getDifficulty());
                } else if (worldInfo2.isDifficultyLocked() && !worldInfo.isDifficultyLocked()) {
                    logger.info("Locking difficulty to {}", new Object[]{worldInfo2.getDifficulty()});
                    for (WorldServer worldServer : this.worldServers) {
                        if (worldServer == null) continue;
                        worldServer.getWorldInfo().setDifficultyLocked(true);
                    }
                }
            }
        }
    }

    @Override
    public boolean canStructuresSpawn() {
        return false;
    }

    @Override
    public WorldSettings.GameType getGameType() {
        return this.theWorldSettings.getGameType();
    }

    @Override
    public EnumDifficulty getDifficulty() {
        return this.mc.theWorld == null ? this.mc.gameSettings.difficulty : this.mc.theWorld.getWorldInfo().getDifficulty();
    }

    @Override
    public boolean isHardcore() {
        return this.theWorldSettings.getHardcoreEnabled();
    }

    @Override
    public boolean shouldBroadcastRconToOps() {
        return true;
    }

    @Override
    public boolean shouldBroadcastConsoleToOps() {
        return true;
    }

    @Override
    public void saveAllWorlds(boolean bl) {
        if (bl) {
            int n;
            int n2 = this.getTickCounter();
            if ((long)n2 < this.ticksSaveLast + (long)(n = this.mc.gameSettings.ofAutoSaveTicks)) {
                return;
            }
            this.ticksSaveLast = n2;
        }
        super.saveAllWorlds(bl);
    }

    @Override
    public File getDataDirectory() {
        return this.mc.mcDataDir;
    }

    @Override
    public boolean isDedicatedServer() {
        return false;
    }

    @Override
    public boolean shouldUseNativeTransport() {
        return false;
    }

    @Override
    protected void finalTick(CrashReport crashReport) {
        this.mc.crashed(crashReport);
    }

    @Override
    public CrashReport addServerInfoToCrashReport(CrashReport crashReport) {
        crashReport = super.addServerInfoToCrashReport(crashReport);
        crashReport.getCategory().addCrashSectionCallable("Type", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return "Integrated Server (map_client.txt)";
            }
        });
        crashReport.getCategory().addCrashSectionCallable("Is Modded", new Callable<String>(){

            @Override
            public String call() throws Exception {
                String string = ClientBrandRetriever.getClientModName();
                if (!string.equals("vanilla")) {
                    return "Definitely; Client brand changed to '" + string + "'";
                }
                string = IntegratedServer.this.getServerModName();
                return !string.equals("vanilla") ? "Definitely; Server brand changed to '" + string + "'" : (Minecraft.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and both client + server brands are untouched.");
            }
        });
        return crashReport;
    }

    @Override
    public void setDifficultyForAllWorlds(EnumDifficulty enumDifficulty) {
        super.setDifficultyForAllWorlds(enumDifficulty);
        if (this.mc.theWorld != null) {
            this.mc.theWorld.getWorldInfo().setDifficulty(enumDifficulty);
        }
    }

    @Override
    public void addServerStatsToSnooper(PlayerUsageSnooper playerUsageSnooper) {
        super.addServerStatsToSnooper(playerUsageSnooper);
        playerUsageSnooper.addClientStat("snooper_partner", this.mc.getPlayerUsageSnooper().getUniqueID());
    }

    @Override
    public boolean isSnooperEnabled() {
        return Minecraft.getMinecraft().isSnooperEnabled();
    }

    @Override
    public String shareToLAN(WorldSettings.GameType gameType, boolean bl) {
        try {
            int n = -1;
            try {
                n = HttpUtil.getSuitableLanPort();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            if (n <= 0) {
                n = 25564;
            }
            this.getNetworkSystem().addLanEndpoint(null, n);
            logger.info("Started on " + n);
            this.isPublic = true;
            this.lanServerPing = new ThreadLanServerPing(this.getMOTD(), "" + n);
            this.lanServerPing.start();
            this.getConfigurationManager().setGameType(gameType);
            this.getConfigurationManager().setCommandsAllowedForAll(bl);
            return "" + n;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    @Override
    public void stopServer() {
        super.stopServer();
        if (this.lanServerPing != null) {
            this.lanServerPing.interrupt();
            this.lanServerPing = null;
        }
    }

    @Override
    public void initiateShutdown() {
        if (!Reflector.MinecraftCompat.exists() || this.isServerRunning()) {
            Futures.getUnchecked(this.addScheduledTask(new Runnable(){

                @Override
                public void run() {
                    for (EntityPlayerMP entityPlayerMP : Lists.newArrayList(IntegratedServer.this.getConfigurationManager().getPlayerList())) {
                        IntegratedServer.this.getConfigurationManager().playerLoggedOut(entityPlayerMP);
                    }
                }
            }));
        }
        super.initiateShutdown();
        if (this.lanServerPing != null) {
            this.lanServerPing.interrupt();
            this.lanServerPing = null;
        }
    }

    public void setStaticInstance() {
        this.setInstance();
    }

    public boolean getPublic() {
        return this.isPublic;
    }

    @Override
    public void setGameType(WorldSettings.GameType gameType) {
        this.getConfigurationManager().setGameType(gameType);
    }

    @Override
    public boolean isCommandBlockEnabled() {
        return true;
    }

    @Override
    public int getOpPermissionLevel() {
        return 4;
    }

    private void onTick() {
        for (WorldServer worldServer : Arrays.asList(this.worldServers)) {
            this.onTick(worldServer);
        }
    }

    public DifficultyInstance getDifficultyAsync(World world2, BlockPos blockPos) {
        this.difficultyUpdateWorld = world2;
        this.difficultyUpdatePos = blockPos;
        return this.difficultyLast;
    }

    private void onTick(WorldServer worldServer) {
        if (!Config.isTimeDefault()) {
            this.fixWorldTime(worldServer);
        }
        if (!Config.isWeatherEnabled()) {
            this.fixWorldWeather(worldServer);
        }
        if (Config.waterOpacityChanged) {
            Config.waterOpacityChanged = false;
            ClearWater.updateWaterOpacity(Config.getGameSettings(), worldServer);
        }
        if (this.difficultyUpdateWorld == worldServer && this.difficultyUpdatePos != null) {
            this.difficultyLast = worldServer.getDifficultyForLocation(this.difficultyUpdatePos);
            this.difficultyUpdateWorld = null;
            this.difficultyUpdatePos = null;
        }
    }

    private void fixWorldWeather(WorldServer worldServer) {
        WorldInfo worldInfo = worldServer.getWorldInfo();
        if (worldInfo.isRaining() || worldInfo.isThundering()) {
            worldInfo.setRainTime(0);
            worldInfo.setRaining(false);
            worldServer.setRainStrength(0.0f);
            worldInfo.setThunderTime(0);
            worldInfo.setThundering(false);
            worldServer.setThunderStrength(0.0f);
            this.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(2, 0.0f));
            this.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(7, 0.0f));
            this.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(8, 0.0f));
        }
    }

    private void fixWorldTime(WorldServer worldServer) {
        WorldInfo worldInfo = worldServer.getWorldInfo();
        if (worldInfo.getGameType().getID() == 1) {
            long l = worldServer.getWorldTime();
            long l2 = l % 24000L;
            if (Config.isTimeDayOnly()) {
                if (l2 <= 1000L) {
                    worldServer.setWorldTime(l - l2 + 1001L);
                }
                if (l2 >= 11000L) {
                    worldServer.setWorldTime(l - l2 + 24001L);
                }
            }
            if (Config.isTimeNightOnly()) {
                if (l2 <= 14000L) {
                    worldServer.setWorldTime(l - l2 + 14001L);
                }
                if (l2 >= 22000L) {
                    worldServer.setWorldTime(l - l2 + 24000L + 14001L);
                }
            }
        }
    }
}

