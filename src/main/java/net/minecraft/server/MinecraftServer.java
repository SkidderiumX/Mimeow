/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.imageio.ImageIO;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetworkSystem;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Util;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldServerMulti;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MinecraftServer
implements Runnable,
ICommandSender,
IThreadListener,
IPlayerUsage {
    private static final Logger logger = LogManager.getLogger();
    public static final File USER_CACHE_FILE = new File("usercache.json");
    private static MinecraftServer mcServer;
    private final ISaveFormat anvilConverterForAnvilFile;
    private final PlayerUsageSnooper usageSnooper = new PlayerUsageSnooper("server", this, MinecraftServer.getCurrentTimeMillis());
    private final File anvilFile;
    private final List<ITickable> playersOnline = Lists.newArrayList();
    protected final ICommandManager commandManager;
    public final Profiler theProfiler = new Profiler();
    private final NetworkSystem networkSystem;
    private final ServerStatusResponse statusResponse = new ServerStatusResponse();
    private final Random random = new Random();
    private int serverPort = -1;
    public WorldServer[] worldServers;
    private ServerConfigurationManager serverConfigManager;
    private boolean serverRunning = true;
    private boolean serverStopped;
    private int tickCounter;
    protected final Proxy serverProxy;
    public String currentTask;
    public int percentDone;
    private boolean onlineMode;
    private boolean canSpawnAnimals;
    private boolean canSpawnNPCs;
    private boolean pvpEnabled;
    private boolean allowFlight;
    private String motd;
    private int buildLimit;
    private int maxPlayerIdleMinutes = 0;
    public final long[] tickTimeArray = new long[100];
    public long[][] timeOfLastDimensionTick;
    private KeyPair serverKeyPair;
    private String serverOwner;
    private String folderName;
    private String worldName;
    private boolean isDemo;
    private boolean enableBonusChest;
    private boolean worldIsBeingDeleted;
    private String resourcePackUrl = "";
    private String resourcePackHash = "";
    private boolean serverIsRunning;
    private long timeOfLastWarning;
    private String userMessage;
    private boolean startProfiling;
    private boolean isGamemodeForced;
    private final YggdrasilAuthenticationService authService;
    private final MinecraftSessionService sessionService;
    private long nanoTimeSinceStatusRefresh = 0L;
    private final GameProfileRepository profileRepo;
    private final PlayerProfileCache profileCache;
    protected final Queue<FutureTask<?>> futureTaskQueue = Queues.newArrayDeque();
    private Thread serverThread;
    private long currentTime = MinecraftServer.getCurrentTimeMillis();

    public MinecraftServer(Proxy proxy, File file) {
        this.serverProxy = proxy;
        mcServer = this;
        this.anvilFile = null;
        this.networkSystem = null;
        this.profileCache = new PlayerProfileCache(this, file);
        this.commandManager = null;
        this.anvilConverterForAnvilFile = null;
        this.authService = new YggdrasilAuthenticationService(proxy, UUID.randomUUID().toString());
        this.sessionService = this.authService.createMinecraftSessionService();
        this.profileRepo = this.authService.createProfileRepository();
    }

    public MinecraftServer(File file, Proxy proxy, File file2) {
        this.serverProxy = proxy;
        mcServer = this;
        this.anvilFile = file;
        this.networkSystem = new NetworkSystem(this);
        this.profileCache = new PlayerProfileCache(this, file2);
        this.commandManager = this.createNewCommandManager();
        this.anvilConverterForAnvilFile = new AnvilSaveConverter(file);
        this.authService = new YggdrasilAuthenticationService(proxy, UUID.randomUUID().toString());
        this.sessionService = this.authService.createMinecraftSessionService();
        this.profileRepo = this.authService.createProfileRepository();
    }

    protected ServerCommandManager createNewCommandManager() {
        return new ServerCommandManager();
    }

    protected abstract boolean startServer() throws IOException;

    protected void convertMapIfNeeded(String string) {
        if (this.getActiveAnvilConverter().isOldMapFormat(string)) {
            logger.info("Converting map!");
            this.setUserMessage("menu.convertingLevel");
            this.getActiveAnvilConverter().convertMapFormat(string, new IProgressUpdate(){
                private long startTime = System.currentTimeMillis();

                @Override
                public void displaySavingString(String string) {
                }

                @Override
                public void resetProgressAndMessage(String string) {
                }

                @Override
                public void setLoadingProgress(int n) {
                    if (System.currentTimeMillis() - this.startTime >= 1000L) {
                        this.startTime = System.currentTimeMillis();
                        logger.info("Converting... " + n + "%");
                    }
                }

                @Override
                public void setDoneWorking() {
                }

                @Override
                public void displayLoadingString(String string) {
                }
            });
        }
    }

    protected synchronized void setUserMessage(String string) {
        this.userMessage = string;
    }

    public synchronized String getUserMessage() {
        return this.userMessage;
    }

    protected void loadAllWorlds(String string, String string2, long l, WorldType worldType, String string3) {
        WorldSettings worldSettings;
        this.convertMapIfNeeded(string);
        this.setUserMessage("menu.loadingLevel");
        this.worldServers = new WorldServer[3];
        this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
        ISaveHandler iSaveHandler = this.anvilConverterForAnvilFile.getSaveLoader(string, true);
        this.setResourcePackFromWorld(this.getFolderName(), iSaveHandler);
        WorldInfo worldInfo = iSaveHandler.loadWorldInfo();
        if (worldInfo == null) {
            if (this.isDemo()) {
                worldSettings = DemoWorldServer.demoWorldSettings;
            } else {
                worldSettings = new WorldSettings(l, this.getGameType(), this.canStructuresSpawn(), this.isHardcore(), worldType);
                worldSettings.setWorldName(string3);
                if (this.enableBonusChest) {
                    worldSettings.enableBonusChest();
                }
            }
            worldInfo = new WorldInfo(worldSettings, string2);
        } else {
            worldInfo.setWorldName(string2);
            worldSettings = new WorldSettings(worldInfo);
        }
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
                this.worldServers[i].initialize(worldSettings);
            } else {
                this.worldServers[i] = (WorldServer)new WorldServerMulti(this, iSaveHandler, n, this.worldServers[0], this.theProfiler).init();
            }
            this.worldServers[i].addWorldAccess(new WorldManager(this, this.worldServers[i]));
            if (this.isSinglePlayer()) continue;
            this.worldServers[i].getWorldInfo().setGameType(this.getGameType());
        }
        this.serverConfigManager.setPlayerManager(this.worldServers);
        this.setDifficultyForAllWorlds(this.getDifficulty());
        this.initialWorldChunkLoad();
    }

    protected void initialWorldChunkLoad() {
        int n = 16;
        int n2 = 4;
        int n3 = 192;
        int n4 = 625;
        int n5 = 0;
        this.setUserMessage("menu.generatingTerrain");
        int n6 = 0;
        logger.info("Preparing start region for level " + n6);
        WorldServer worldServer = this.worldServers[n6];
        BlockPos blockPos = worldServer.getSpawnPoint();
        long l = MinecraftServer.getCurrentTimeMillis();
        for (int i = -192; i <= 192 && this.isServerRunning(); i += 16) {
            for (int j = -192; j <= 192 && this.isServerRunning(); j += 16) {
                long l2 = MinecraftServer.getCurrentTimeMillis();
                if (l2 - l > 1000L) {
                    this.outputPercentRemaining("Preparing spawn area", n5 * 100 / 625);
                    l = l2;
                }
                ++n5;
                worldServer.theChunkProviderServer.loadChunk(blockPos.getX() + i >> 4, blockPos.getZ() + j >> 4);
            }
        }
        this.clearCurrentTask();
    }

    protected void setResourcePackFromWorld(String string, ISaveHandler iSaveHandler) {
        File file = new File(iSaveHandler.getWorldDirectory(), "resources.zip");
        if (file.isFile()) {
            this.setResourcePack("level://" + string + "/" + file.getName(), "");
        }
    }

    public abstract boolean canStructuresSpawn();

    public abstract WorldSettings.GameType getGameType();

    public abstract EnumDifficulty getDifficulty();

    public abstract boolean isHardcore();

    public abstract int getOpPermissionLevel();

    public abstract boolean shouldBroadcastRconToOps();

    public abstract boolean shouldBroadcastConsoleToOps();

    protected void outputPercentRemaining(String string, int n) {
        this.currentTask = string;
        this.percentDone = n;
        logger.info(string + ": " + n + "%");
    }

    protected void clearCurrentTask() {
        this.currentTask = null;
        this.percentDone = 0;
    }

    protected void saveAllWorlds(boolean bl) {
        if (!this.worldIsBeingDeleted) {
            for (WorldServer worldServer : this.worldServers) {
                if (worldServer == null) continue;
                if (!bl) {
                    logger.info("Saving chunks for level '" + worldServer.getWorldInfo().getWorldName() + "'/" + worldServer.provider.getDimensionName());
                }
                try {
                    worldServer.saveAllChunks(true, null);
                }
                catch (MinecraftException minecraftException) {
                    logger.warn(minecraftException.getMessage());
                }
            }
        }
    }

    public void stopServer() {
        if (!this.worldIsBeingDeleted) {
            logger.info("Stopping server");
            if (this.getNetworkSystem() != null) {
                this.getNetworkSystem().terminateEndpoints();
            }
            if (this.serverConfigManager != null) {
                logger.info("Saving players");
                this.serverConfigManager.saveAllPlayerData();
                this.serverConfigManager.removeAllPlayers();
            }
            if (this.worldServers != null) {
                logger.info("Saving worlds");
                this.saveAllWorlds(false);
                for (int i = 0; i < this.worldServers.length; ++i) {
                    WorldServer worldServer = this.worldServers[i];
                    worldServer.flush();
                }
            }
            if (this.usageSnooper.isSnooperRunning()) {
                this.usageSnooper.stopSnooper();
            }
        }
    }

    public boolean isServerRunning() {
        return this.serverRunning;
    }

    public void initiateShutdown() {
        this.serverRunning = false;
    }

    protected void setInstance() {
        mcServer = this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            if (this.startServer()) {
                this.currentTime = MinecraftServer.getCurrentTimeMillis();
                long l = 0L;
                this.statusResponse.setServerDescription(new ChatComponentText(this.motd));
                this.statusResponse.setProtocolVersionInfo(new ServerStatusResponse.MinecraftProtocolVersionIdentifier("1.8.9", 47));
                this.addFaviconToStatusResponse(this.statusResponse);
                while (this.serverRunning) {
                    long l2 = MinecraftServer.getCurrentTimeMillis();
                    long l3 = l2 - this.currentTime;
                    if (l3 > 2000L && this.currentTime - this.timeOfLastWarning >= 15000L) {
                        logger.warn("Can't keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", l3, l3 / 50L);
                        l3 = 2000L;
                        this.timeOfLastWarning = this.currentTime;
                    }
                    if (l3 < 0L) {
                        logger.warn("Time ran backwards! Did the system time change?");
                        l3 = 0L;
                    }
                    l += l3;
                    this.currentTime = l2;
                    if (this.worldServers[0].areAllPlayersAsleep()) {
                        this.tick();
                        l = 0L;
                    } else {
                        while (l > 50L) {
                            l -= 50L;
                            this.tick();
                        }
                    }
                    Thread.sleep(Math.max(1L, 50L - l));
                    this.serverIsRunning = true;
                }
            } else {
                this.finalTick(null);
            }
        }
        catch (Throwable throwable) {
            logger.error("Encountered an unexpected exception", throwable);
            CrashReport crashReport = null;
            crashReport = throwable instanceof ReportedException ? this.addServerInfoToCrashReport(((ReportedException)throwable).getCrashReport()) : this.addServerInfoToCrashReport(new CrashReport("Exception in server tick loop", throwable));
            File file = new File(new File(this.getDataDirectory(), "crash-reports"), "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-server.txt");
            if (crashReport.saveToFile(file)) {
                logger.error("This crash report has been saved to: " + file.getAbsolutePath());
            } else {
                logger.error("We were unable to save this crash report to disk.");
            }
            this.finalTick(crashReport);
        }
        finally {
            try {
                this.serverStopped = true;
                this.stopServer();
            }
            catch (Throwable throwable) {
                logger.error("Exception stopping the server", throwable);
            }
            finally {
                this.systemExitNow();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addFaviconToStatusResponse(ServerStatusResponse serverStatusResponse) {
        File file = this.getFile("server-icon.png");
        if (file.isFile()) {
            ByteBuf byteBuf = Unpooled.buffer();
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Validate.validState(bufferedImage.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
                Validate.validState(bufferedImage.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
                ImageIO.write((RenderedImage)bufferedImage, "PNG", new ByteBufOutputStream(byteBuf));
                ByteBuf byteBuf2 = Base64.encode(byteBuf);
                serverStatusResponse.setFavicon("data:image/png;base64," + byteBuf2.toString(Charsets.UTF_8));
            }
            catch (Exception exception) {
                logger.error("Couldn't load server icon", (Throwable)exception);
            }
            finally {
                byteBuf.release();
            }
        }
    }

    public File getDataDirectory() {
        return new File(".");
    }

    protected void finalTick(CrashReport crashReport) {
    }

    protected void systemExitNow() {
    }

    public void tick() {
        long l = System.nanoTime();
        ++this.tickCounter;
        if (this.startProfiling) {
            this.startProfiling = false;
            this.theProfiler.profilingEnabled = true;
            this.theProfiler.clearProfiling();
        }
        this.theProfiler.startSection("root");
        this.updateTimeLightAndEntities();
        if (l - this.nanoTimeSinceStatusRefresh >= 5000000000L) {
            this.nanoTimeSinceStatusRefresh = l;
            this.statusResponse.setPlayerCountData(new ServerStatusResponse.PlayerCountData(this.getMaxPlayers(), this.getCurrentPlayerCount()));
            GameProfile[] gameProfileArray = new GameProfile[Math.min(this.getCurrentPlayerCount(), 12)];
            int n = MathHelper.getRandomIntegerInRange(this.random, 0, this.getCurrentPlayerCount() - gameProfileArray.length);
            for (int i = 0; i < gameProfileArray.length; ++i) {
                gameProfileArray[i] = this.serverConfigManager.getPlayerList().get(n + i).getGameProfile();
            }
            Collections.shuffle(Arrays.asList(gameProfileArray));
            this.statusResponse.getPlayerCountData().setPlayers(gameProfileArray);
        }
        if (this.tickCounter % 900 == 0) {
            this.theProfiler.startSection("save");
            this.serverConfigManager.saveAllPlayerData();
            this.saveAllWorlds(true);
            this.theProfiler.endSection();
        }
        this.theProfiler.startSection("tallying");
        this.tickTimeArray[this.tickCounter % 100] = System.nanoTime() - l;
        this.theProfiler.endSection();
        this.theProfiler.startSection("snooper");
        if (!this.usageSnooper.isSnooperRunning() && this.tickCounter > 100) {
            this.usageSnooper.startSnooper();
        }
        if (this.tickCounter % 6000 == 0) {
            this.usageSnooper.addMemoryStatsToSnooper();
        }
        this.theProfiler.endSection();
        this.theProfiler.endSection();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateTimeLightAndEntities() {
        int n;
        this.theProfiler.startSection("jobs");
        Queue<FutureTask<?>> queue = this.futureTaskQueue;
        synchronized (queue) {
            while (!this.futureTaskQueue.isEmpty()) {
                Util.runTask(this.futureTaskQueue.poll(), logger);
            }
        }
        this.theProfiler.endStartSection("levels");
        for (n = 0; n < this.worldServers.length; ++n) {
            long l = System.nanoTime();
            if (n == 0 || this.getAllowNether()) {
                WorldServer worldServer = this.worldServers[n];
                this.theProfiler.startSection(worldServer.getWorldInfo().getWorldName());
                if (this.tickCounter % 20 == 0) {
                    this.theProfiler.startSection("timeSync");
                    this.serverConfigManager.sendPacketToAllPlayersInDimension(new S03PacketTimeUpdate(worldServer.getTotalWorldTime(), worldServer.getWorldTime(), worldServer.getGameRules().getBoolean("doDaylightCycle")), worldServer.provider.getDimensionId());
                    this.theProfiler.endSection();
                }
                this.theProfiler.startSection("tick");
                try {
                    worldServer.tick();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception ticking world");
                    worldServer.addWorldInfoToCrashReport(crashReport);
                    throw new ReportedException(crashReport);
                }
                try {
                    worldServer.updateEntities();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception ticking world entities");
                    worldServer.addWorldInfoToCrashReport(crashReport);
                    throw new ReportedException(crashReport);
                }
                this.theProfiler.endSection();
                this.theProfiler.startSection("tracker");
                worldServer.getEntityTracker().updateTrackedEntities();
                this.theProfiler.endSection();
                this.theProfiler.endSection();
            }
            this.timeOfLastDimensionTick[n][this.tickCounter % 100] = System.nanoTime() - l;
        }
        this.theProfiler.endStartSection("connection");
        this.getNetworkSystem().networkTick();
        this.theProfiler.endStartSection("players");
        this.serverConfigManager.onTick();
        this.theProfiler.endStartSection("tickables");
        for (n = 0; n < this.playersOnline.size(); ++n) {
            this.playersOnline.get(n).update();
        }
        this.theProfiler.endSection();
    }

    public boolean getAllowNether() {
        return true;
    }

    public void startServerThread() {
        this.serverThread = new Thread((Runnable)this, "Server thread");
        this.serverThread.start();
    }

    public File getFile(String string) {
        return new File(this.getDataDirectory(), string);
    }

    public void logWarning(String string) {
        logger.warn(string);
    }

    public WorldServer worldServerForDimension(int n) {
        return n == -1 ? this.worldServers[1] : (n == 1 ? this.worldServers[2] : this.worldServers[0]);
    }

    public String getMinecraftVersion() {
        return "1.8.9";
    }

    public int getCurrentPlayerCount() {
        return this.serverConfigManager.getCurrentPlayerCount();
    }

    public int getMaxPlayers() {
        return this.serverConfigManager.getMaxPlayers();
    }

    public String[] getAllUsernames() {
        return this.serverConfigManager.getAllUsernames();
    }

    public GameProfile[] getGameProfiles() {
        return this.serverConfigManager.getAllProfiles();
    }

    public String getServerModName() {
        return "vanilla";
    }

    public CrashReport addServerInfoToCrashReport(CrashReport crashReport) {
        crashReport.getCategory().addCrashSectionCallable("Profiler Position", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return MinecraftServer.this.theProfiler.profilingEnabled ? MinecraftServer.this.theProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
        });
        if (this.serverConfigManager != null) {
            crashReport.getCategory().addCrashSectionCallable("Player Count", new Callable<String>(){

                @Override
                public String call() {
                    return MinecraftServer.this.serverConfigManager.getCurrentPlayerCount() + " / " + MinecraftServer.this.serverConfigManager.getMaxPlayers() + "; " + String.valueOf(MinecraftServer.this.serverConfigManager.getPlayerList());
                }
            });
        }
        return crashReport;
    }

    public List<String> getTabCompletions(ICommandSender iCommandSender, String string, BlockPos blockPos) {
        ArrayList<String> arrayList = Lists.newArrayList();
        if (string.startsWith("/")) {
            boolean bl = !(string = string.substring(1)).contains(" ");
            List<String> list = this.commandManager.getTabCompletionOptions(iCommandSender, string, blockPos);
            if (list != null) {
                for (String string2 : list) {
                    if (bl) {
                        arrayList.add("/" + string2);
                        continue;
                    }
                    arrayList.add(string2);
                }
            }
            return arrayList;
        }
        String[] stringArray = string.split(" ", -1);
        String string3 = stringArray[stringArray.length - 1];
        for (String string4 : this.serverConfigManager.getAllUsernames()) {
            if (!CommandBase.doesStringStartWith(string3, string4)) continue;
            arrayList.add(string4);
        }
        return arrayList;
    }

    public static MinecraftServer getServer() {
        return mcServer;
    }

    public boolean isAnvilFileSet() {
        return this.anvilFile != null;
    }

    @Override
    public String getName() {
        return "Server";
    }

    @Override
    public void addChatMessage(IChatComponent iChatComponent) {
        logger.info(iChatComponent.getUnformattedText());
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return true;
    }

    public ICommandManager getCommandManager() {
        return this.commandManager;
    }

    public KeyPair getKeyPair() {
        return this.serverKeyPair;
    }

    public String getServerOwner() {
        return this.serverOwner;
    }

    public void setServerOwner(String string) {
        this.serverOwner = string;
    }

    public boolean isSinglePlayer() {
        return this.serverOwner != null;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public void setFolderName(String string) {
        this.folderName = string;
    }

    public void setWorldName(String string) {
        this.worldName = string;
    }

    public String getWorldName() {
        return this.worldName;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.serverKeyPair = keyPair;
    }

    public void setDifficultyForAllWorlds(EnumDifficulty enumDifficulty) {
        for (int i = 0; i < this.worldServers.length; ++i) {
            WorldServer worldServer = this.worldServers[i];
            if (worldServer == null) continue;
            if (worldServer.getWorldInfo().isHardcoreModeEnabled()) {
                worldServer.getWorldInfo().setDifficulty(EnumDifficulty.HARD);
                worldServer.setAllowedSpawnTypes(true, true);
                continue;
            }
            if (this.isSinglePlayer()) {
                worldServer.getWorldInfo().setDifficulty(enumDifficulty);
                worldServer.setAllowedSpawnTypes(worldServer.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                continue;
            }
            worldServer.getWorldInfo().setDifficulty(enumDifficulty);
            worldServer.setAllowedSpawnTypes(this.allowSpawnMonsters(), this.canSpawnAnimals);
        }
    }

    protected boolean allowSpawnMonsters() {
        return true;
    }

    public boolean isDemo() {
        return this.isDemo;
    }

    public void setDemo(boolean bl) {
        this.isDemo = bl;
    }

    public void canCreateBonusChest(boolean bl) {
        this.enableBonusChest = bl;
    }

    public ISaveFormat getActiveAnvilConverter() {
        return this.anvilConverterForAnvilFile;
    }

    public void deleteWorldAndStopServer() {
        this.worldIsBeingDeleted = true;
        this.getActiveAnvilConverter().flushCache();
        for (int i = 0; i < this.worldServers.length; ++i) {
            WorldServer worldServer = this.worldServers[i];
            if (worldServer == null) continue;
            worldServer.flush();
        }
        this.getActiveAnvilConverter().deleteWorldDirectory(this.worldServers[0].getSaveHandler().getWorldDirectoryName());
        this.initiateShutdown();
    }

    public String getResourcePackUrl() {
        return this.resourcePackUrl;
    }

    public String getResourcePackHash() {
        return this.resourcePackHash;
    }

    public void setResourcePack(String string, String string2) {
        this.resourcePackUrl = string;
        this.resourcePackHash = string2;
    }

    @Override
    public void addServerStatsToSnooper(PlayerUsageSnooper playerUsageSnooper) {
        playerUsageSnooper.addClientStat("whitelist_enabled", false);
        playerUsageSnooper.addClientStat("whitelist_count", 0);
        if (this.serverConfigManager != null) {
            playerUsageSnooper.addClientStat("players_current", this.getCurrentPlayerCount());
            playerUsageSnooper.addClientStat("players_max", this.getMaxPlayers());
            playerUsageSnooper.addClientStat("players_seen", this.serverConfigManager.getAvailablePlayerDat().length);
        }
        playerUsageSnooper.addClientStat("uses_auth", this.onlineMode);
        playerUsageSnooper.addClientStat("gui_state", this.getGuiEnabled() ? "enabled" : "disabled");
        playerUsageSnooper.addClientStat("run_time", (MinecraftServer.getCurrentTimeMillis() - playerUsageSnooper.getMinecraftStartTimeMillis()) / 60L * 1000L);
        playerUsageSnooper.addClientStat("avg_tick_ms", (int)(MathHelper.average(this.tickTimeArray) * 1.0E-6));
        int n = 0;
        if (this.worldServers != null) {
            for (int i = 0; i < this.worldServers.length; ++i) {
                if (this.worldServers[i] == null) continue;
                WorldServer worldServer = this.worldServers[i];
                WorldInfo worldInfo = worldServer.getWorldInfo();
                playerUsageSnooper.addClientStat("world[" + n + "][dimension]", worldServer.provider.getDimensionId());
                playerUsageSnooper.addClientStat("world[" + n + "][mode]", (Object)worldInfo.getGameType());
                playerUsageSnooper.addClientStat("world[" + n + "][difficulty]", (Object)worldServer.getDifficulty());
                playerUsageSnooper.addClientStat("world[" + n + "][hardcore]", worldInfo.isHardcoreModeEnabled());
                playerUsageSnooper.addClientStat("world[" + n + "][generator_name]", worldInfo.getTerrainType().getWorldTypeName());
                playerUsageSnooper.addClientStat("world[" + n + "][generator_version]", worldInfo.getTerrainType().getGeneratorVersion());
                playerUsageSnooper.addClientStat("world[" + n + "][height]", this.buildLimit);
                playerUsageSnooper.addClientStat("world[" + n + "][chunks_loaded]", worldServer.getChunkProvider().getLoadedChunkCount());
                ++n;
            }
        }
        playerUsageSnooper.addClientStat("worlds", n);
    }

    @Override
    public void addServerTypeToSnooper(PlayerUsageSnooper playerUsageSnooper) {
        playerUsageSnooper.addStatToSnooper("singleplayer", this.isSinglePlayer());
        playerUsageSnooper.addStatToSnooper("server_brand", this.getServerModName());
        playerUsageSnooper.addStatToSnooper("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        playerUsageSnooper.addStatToSnooper("dedicated", this.isDedicatedServer());
    }

    @Override
    public boolean isSnooperEnabled() {
        return true;
    }

    public abstract boolean isDedicatedServer();

    public boolean isServerInOnlineMode() {
        return this.onlineMode;
    }

    public void setOnlineMode(boolean bl) {
        this.onlineMode = bl;
    }

    public boolean getCanSpawnAnimals() {
        return this.canSpawnAnimals;
    }

    public void setCanSpawnAnimals(boolean bl) {
        this.canSpawnAnimals = bl;
    }

    public boolean getCanSpawnNPCs() {
        return this.canSpawnNPCs;
    }

    public abstract boolean shouldUseNativeTransport();

    public void setCanSpawnNPCs(boolean bl) {
        this.canSpawnNPCs = bl;
    }

    public boolean isPVPEnabled() {
        return this.pvpEnabled;
    }

    public void setAllowPvp(boolean bl) {
        this.pvpEnabled = bl;
    }

    public boolean isFlightAllowed() {
        return this.allowFlight;
    }

    public void setAllowFlight(boolean bl) {
        this.allowFlight = bl;
    }

    public abstract boolean isCommandBlockEnabled();

    public String getMOTD() {
        return this.motd;
    }

    public void setMOTD(String string) {
        this.motd = string;
    }

    public int getBuildLimit() {
        return this.buildLimit;
    }

    public void setBuildLimit(int n) {
        this.buildLimit = n;
    }

    public boolean isServerStopped() {
        return this.serverStopped;
    }

    public ServerConfigurationManager getConfigurationManager() {
        return this.serverConfigManager;
    }

    public void setConfigManager(ServerConfigurationManager serverConfigurationManager) {
        this.serverConfigManager = serverConfigurationManager;
    }

    public void setGameType(WorldSettings.GameType gameType) {
        for (int i = 0; i < this.worldServers.length; ++i) {
            MinecraftServer.getServer().worldServers[i].getWorldInfo().setGameType(gameType);
        }
    }

    public NetworkSystem getNetworkSystem() {
        return this.networkSystem;
    }

    public boolean serverIsInRunLoop() {
        return this.serverIsRunning;
    }

    public boolean getGuiEnabled() {
        return false;
    }

    public abstract String shareToLAN(WorldSettings.GameType var1, boolean var2);

    public int getTickCounter() {
        return this.tickCounter;
    }

    public void enableProfiling() {
        this.startProfiling = true;
    }

    public PlayerUsageSnooper getPlayerUsageSnooper() {
        return this.usageSnooper;
    }

    @Override
    public BlockPos getPosition() {
        return BlockPos.ORIGIN;
    }

    @Override
    public Vec3 getPositionVector() {
        return new Vec3(0.0, 0.0, 0.0);
    }

    @Override
    public World getEntityWorld() {
        return this.worldServers[0];
    }

    @Override
    public Entity getCommandSenderEntity() {
        return null;
    }

    public int getSpawnProtectionSize() {
        return 16;
    }

    public boolean isBlockProtected(World world2, BlockPos blockPos, EntityPlayer entityPlayer) {
        return false;
    }

    public boolean getForceGamemode() {
        return this.isGamemodeForced;
    }

    public Proxy getServerProxy() {
        return this.serverProxy;
    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public int getMaxPlayerIdleMinutes() {
        return this.maxPlayerIdleMinutes;
    }

    public void setPlayerIdleTimeout(int n) {
        this.maxPlayerIdleMinutes = n;
    }

    @Override
    public IChatComponent getDisplayName() {
        return new ChatComponentText(this.getName());
    }

    public boolean isAnnouncingPlayerAchievements() {
        return true;
    }

    public MinecraftSessionService getMinecraftSessionService() {
        return this.sessionService;
    }

    public GameProfileRepository getGameProfileRepository() {
        return this.profileRepo;
    }

    public PlayerProfileCache getPlayerProfileCache() {
        return this.profileCache;
    }

    public ServerStatusResponse getServerStatusResponse() {
        return this.statusResponse;
    }

    public void refreshStatusNextTick() {
        this.nanoTimeSinceStatusRefresh = 0L;
    }

    public Entity getEntityFromUuid(UUID uUID) {
        for (WorldServer worldServer : this.worldServers) {
            Entity entity;
            if (worldServer == null || (entity = worldServer.getEntityFromUuid(uUID)) == null) continue;
            return entity;
        }
        return null;
    }

    @Override
    public boolean sendCommandFeedback() {
        return MinecraftServer.getServer().worldServers[0].getGameRules().getBoolean("sendCommandFeedback");
    }

    @Override
    public void setCommandStat(CommandResultStats.Type type, int n) {
    }

    public int getMaxWorldSize() {
        return 29999984;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <V> ListenableFuture<V> callFromMainThread(Callable<V> callable) {
        Validate.notNull(callable);
        if (!this.isCallingFromMinecraftThread() && !this.isServerStopped()) {
            ListenableFutureTask<V> listenableFutureTask = ListenableFutureTask.create(callable);
            Queue<FutureTask<?>> queue = this.futureTaskQueue;
            synchronized (queue) {
                this.futureTaskQueue.add(listenableFutureTask);
                return listenableFutureTask;
            }
        }
        try {
            return Futures.immediateFuture(callable.call());
        }
        catch (Exception exception) {
            return Futures.immediateFailedCheckedFuture(exception);
        }
    }

    @Override
    public ListenableFuture<Object> addScheduledTask(Runnable runnable2) {
        Validate.notNull(runnable2);
        return this.callFromMainThread(Executors.callable(runnable2));
    }

    @Override
    public boolean isCallingFromMinecraftThread() {
        return Thread.currentThread() == this.serverThread;
    }

    public int getNetworkCompressionTreshold() {
        return 256;
    }
}

