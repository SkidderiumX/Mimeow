/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import de.florianmichael.viamcp.ViaMCP;
import de.florianmichael.viamcp.fixes.AttackOrder;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.imageio.ImageIO;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.LoadingScreenRenderer;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMemoryErrorScreen;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSleepMP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.achievement.GuiAchievement;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.FoliageColorReloadListener;
import net.minecraft.client.resources.GrassColorReloadListener;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.resources.ResourceIndex;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.AnimationMetadataSectionSerializer;
import net.minecraft.client.resources.data.FontMetadataSection;
import net.minecraft.client.resources.data.FontMetadataSectionSerializer;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.client.resources.data.LanguageMetadataSectionSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.client.resources.data.PackMetadataSectionSerializer;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSectionSerializer;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Bootstrap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.IStatStringFormat;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MinecraftError;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import net.minecraft.util.Util;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;
import x.MouseEvent;
import x.oc02a3730b27;
import x.oc099368a591;
import x.oc110d7f376c;
import x.oc142aa368f4;
import x.oc170ea29aae;
import x.oc24ebc274b7;
import x.oc2bbaa492fe;
import x.oc2cf3d80e17;
import x.oc2f2e7502e9;
import x.oc38a48edfca;
import x.oc479681b341;
import x.oc507025139f;
import x.oc51fb428ba0;
import x.oc68db11bd12;
import x.oc718fd4d503;
import x.oc8ecfa69e1b;
import x.oc8edd24b1ed;
import x.oc9374123646;
import x.oc9755810e45;
import x.oc9adb807c19;
import x.oca27090789a;
import x.ocac48057a4f;
import x.ocb3fa5b0d15;
import x.ocb754f4cbfb;
import x.ocbab3c9954b;
import x.ocbb165642ef;
import x.ocbe9732642b;
import x.occ0c83447ab;
import x.occ9a2be31f2;
import x.occb187f10ff;
import x.occb36f998dc;
import x.ocded28ccee0;
import x.ocdf771dc334;
import x.oce040b2baf2;
import x.oce38b1b133f;
import x.oce4fccf5a38;
import x.ocea775c9d5c;
import x.ocee33618a8d;
import x.ocf6b0e5bf86;
import x.ocf923d5a814;
import x.ocfce21f66a2;

public class Minecraft
implements IThreadListener,
IPlayerUsage,
oc8ecfa69e1b {
    private static final Logger logger = LogManager.getLogger();
    public static final boolean isRunningOnMac = Util.getOSType() == Util.EnumOS.OSX;
    public static byte[] memoryReserve = new byte[0xA00000];
    private static final List<DisplayMode> macDisplayModes = Lists.newArrayList(new DisplayMode(2560, 1600), new DisplayMode(2880, 1800));
    private final File fileResourcepacks;
    private final PropertyMap profileProperties;
    private ServerData currentServerData;
    private TextureManager renderEngine;
    private static Minecraft theMinecraft;
    public PlayerControllerMP playerController;
    private boolean fullscreen;
    private boolean enableGLErrorChecking = false;
    private boolean hasCrashed;
    private CrashReport crashReporter;
    public int displayWidth;
    public int displayHeight;
    private boolean connectedToRealms = false;
    private Timer timer = new Timer(20.0f);
    private PlayerUsageSnooper usageSnooper = new PlayerUsageSnooper("client", this, MinecraftServer.getCurrentTimeMillis());
    public WorldClient theWorld;
    public RenderGlobal renderGlobal;
    private RenderManager renderManager;
    private RenderItem renderItem;
    private ItemRenderer itemRenderer;
    public EntityPlayerSP thePlayer;
    private Entity renderViewEntity;
    public Entity pointedEntity;
    public EffectRenderer effectRenderer;
    private Session session;
    private boolean isGamePaused;
    public FontRenderer fontRendererObj;
    public FontRenderer standardGalacticFontRenderer;
    public GuiScreen currentScreen;
    public LoadingScreenRenderer loadingScreen;
    public EntityRenderer entityRenderer;
    private int leftClickCounter;
    private int tempDisplayWidth;
    private int tempDisplayHeight;
    private IntegratedServer theIntegratedServer;
    public GuiAchievement guiAchievement;
    public GuiIngame ingameGUI;
    public boolean skipRenderWorld;
    public MovingObjectPosition objectMouseOver;
    public GameSettings gameSettings;
    public MouseHelper mouseHelper;
    public final File mcDataDir;
    private final File fileAssets;
    private final String launchedVersion;
    private final Proxy proxy;
    private ISaveFormat saveLoader;
    private static int debugFPS;
    private int rightClickDelayTimer;
    private String serverName;
    private int serverPort;
    public boolean inGameHasFocus;
    long systemTime = Minecraft.getSystemTime();
    private int joinPlayerCounter;
    public final FrameTimer frameTimer = new FrameTimer();
    long startNanoTime = System.nanoTime();
    private final boolean jvm64bit;
    private final boolean isDemo;
    private NetworkManager myNetworkManager;
    private boolean integratedServerIsRunning;
    public final Profiler mcProfiler = new Profiler();
    private long debugCrashKeyPressTime = -1L;
    private IReloadableResourceManager mcResourceManager;
    private final IMetadataSerializer metadataSerializer_ = new IMetadataSerializer();
    private final List<IResourcePack> defaultResourcePacks = Lists.newArrayList();
    private final DefaultResourcePack mcDefaultResourcePack;
    private ResourcePackRepository mcResourcePackRepository;
    private LanguageManager mcLanguageManager;
    private Framebuffer framebufferMc;
    private TextureMap textureMapBlocks;
    private SoundHandler mcSoundHandler;
    private MusicTicker mcMusicTicker;
    private final MinecraftSessionService sessionService;
    private SkinManager skinManager;
    private final Queue<FutureTask<?>> scheduledTasks = Queues.newArrayDeque();
    private long field_175615_aJ = 0L;
    private final Thread mcThread = Thread.currentThread();
    private ModelManager modelManager;
    private BlockRendererDispatcher blockRenderDispatcher;
    volatile boolean running = true;
    public String debug = "";
    public boolean field_175613_B = false;
    public boolean field_175614_C = false;
    public boolean field_175611_D = false;
    public boolean renderChunksMany = true;
    long debugUpdateTime = Minecraft.getSystemTime();
    int fpsCounter;
    long prevFrameTime = -1L;
    private String debugProfilerName = "root";
    private static boolean mimeow$initialized;

    public Minecraft(GameConfiguration gameConfiguration) {
        theMinecraft = this;
        this.mcDataDir = gameConfiguration.folderInfo.mcDataDir;
        this.fileAssets = gameConfiguration.folderInfo.assetsDir;
        this.fileResourcepacks = gameConfiguration.folderInfo.resourcePacksDir;
        this.launchedVersion = gameConfiguration.gameInfo.version;
        this.profileProperties = gameConfiguration.userInfo.profileProperties;
        this.mcDefaultResourcePack = new DefaultResourcePack(new ResourceIndex(gameConfiguration.folderInfo.assetsDir, gameConfiguration.folderInfo.assetIndex).getResourceMap());
        this.proxy = gameConfiguration.userInfo.proxy == null ? Proxy.NO_PROXY : gameConfiguration.userInfo.proxy;
        this.sessionService = new YggdrasilAuthenticationService(gameConfiguration.userInfo.proxy, UUID.randomUUID().toString()).createMinecraftSessionService();
        this.session = gameConfiguration.userInfo.session;
        logger.info("Setting user: " + this.session.getUsername());
        logger.info("(Session ID is " + this.session.getSessionID() + ")");
        this.isDemo = gameConfiguration.gameInfo.isDemo;
        this.displayWidth = gameConfiguration.displayInfo.width > 0 ? gameConfiguration.displayInfo.width : 1;
        this.displayHeight = gameConfiguration.displayInfo.height > 0 ? gameConfiguration.displayInfo.height : 1;
        this.tempDisplayWidth = gameConfiguration.displayInfo.width;
        this.tempDisplayHeight = gameConfiguration.displayInfo.height;
        this.fullscreen = gameConfiguration.displayInfo.fullscreen;
        this.jvm64bit = Minecraft.isJvm64bit();
        this.theIntegratedServer = new IntegratedServer(this);
        if (gameConfiguration.serverInfo.serverName != null) {
            this.serverName = gameConfiguration.serverInfo.serverName;
            this.serverPort = gameConfiguration.serverInfo.serverPort;
        }
        ImageIO.setUseCache(false);
        Bootstrap.register();
    }

    public void run() {
        this.running = true;
        try {
            this.startGame();
        }
        catch (Throwable throwable) {
            logger.fatal("Failed to start game!", throwable);
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Initializing game");
            crashReport.makeCategory("Initialization");
            this.displayCrashReport(this.addGraphicsAndWorldToCrashReport(crashReport));
            return;
        }
        try {
            while (this.running) {
                if (this.hasCrashed && this.crashReporter != null) {
                    this.displayCrashReport(this.crashReporter);
                    continue;
                }
                try {
                    this.runGameLoop();
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    this.freeMemory();
                    this.displayGuiScreen(new GuiMemoryErrorScreen());
                    System.gc();
                }
            }
            return;
        }
        catch (MinecraftError minecraftError) {
        }
        catch (ReportedException reportedException) {
            this.addGraphicsAndWorldToCrashReport(reportedException.getCrashReport());
            this.freeMemory();
            logger.fatal("Reported exception thrown!", (Throwable)reportedException);
            this.displayCrashReport(reportedException.getCrashReport());
        }
        catch (Throwable throwable) {
            CrashReport crashReport = this.addGraphicsAndWorldToCrashReport(new CrashReport("Unexpected error", throwable));
            this.freeMemory();
            logger.fatal("Unreported exception thrown!", throwable);
            this.displayCrashReport(crashReport);
        }
        finally {
            this.shutdownMinecraftApplet();
        }
    }

    private void startGame() throws LWJGLException, IOException {
        this.gameSettings = new GameSettings(this, this.mcDataDir);
        this.defaultResourcePacks.add(this.mcDefaultResourcePack);
        this.startTimerHackThread();
        if (this.gameSettings.overrideHeight > 0 && this.gameSettings.overrideWidth > 0) {
            this.displayWidth = this.gameSettings.overrideWidth;
            this.displayHeight = this.gameSettings.overrideHeight;
        }
        logger.info("LWJGL Version: " + Sys.getVersion());
        this.setWindowIcon();
        this.setInitialDisplayMode();
        this.createDisplay();
        this.displayWidth = Math.max(1, Display.getWidth());
        this.displayHeight = Math.max(1, Display.getHeight());
        OpenGlHelper.initializeTextures();
        this.framebufferMc = new Framebuffer(this.displayWidth, this.displayHeight, true);
        this.framebufferMc.setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.registerMetadataSerializers();
        this.mcResourcePackRepository = new ResourcePackRepository(this.fileResourcepacks, new File(this.mcDataDir, "server-resource-packs"), this.mcDefaultResourcePack, this.metadataSerializer_, this.gameSettings);
        this.mcResourceManager = new SimpleReloadableResourceManager(this.metadataSerializer_);
        this.mcLanguageManager = new LanguageManager(this.metadataSerializer_, this.gameSettings.language);
        this.mcResourceManager.registerReloadListener(this.mcLanguageManager);
        this.refreshResources();
        this.renderEngine = new TextureManager(this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.renderEngine);
        this.drawSplashScreen(this.renderEngine, 0.14f);
        this.skinManager = new SkinManager(this.renderEngine, new File(this.fileAssets, "skins"), this.sessionService);
        this.saveLoader = new AnvilSaveConverter(new File(this.mcDataDir, "saves"));
        this.mcSoundHandler = new SoundHandler(this.mcResourceManager, this.gameSettings);
        this.mcResourceManager.registerReloadListener(this.mcSoundHandler);
        this.mcMusicTicker = new MusicTicker(this);
        this.fontRendererObj = new FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii.png"), this.renderEngine, false);
        if (this.gameSettings.language != null) {
            this.fontRendererObj.setUnicodeFlag(this.isUnicode());
            this.fontRendererObj.setBidiFlag(this.mcLanguageManager.isCurrentLanguageBidirectional());
        }
        this.standardGalacticFontRenderer = new FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii_sga.png"), this.renderEngine, false);
        this.mcResourceManager.registerReloadListener(this.fontRendererObj);
        this.mcResourceManager.registerReloadListener(this.standardGalacticFontRenderer);
        this.mcResourceManager.registerReloadListener(new GrassColorReloadListener());
        this.mcResourceManager.registerReloadListener(new FoliageColorReloadListener());
        this.drawSplashScreen(this.renderEngine, 0.38f);
        AchievementList.openInventory.setStatStringFormatter(new IStatStringFormat(){

            @Override
            public String formatString(String string) {
                try {
                    return String.format(string, GameSettings.getKeyDisplayString(Minecraft.this.gameSettings.keyBindInventory.getKeyCode()));
                }
                catch (Exception exception) {
                    return "Error: " + exception.getLocalizedMessage();
                }
            }
        });
        this.mouseHelper = new MouseHelper();
        this.checkGLError("Pre startup");
        GlStateManager.enableTexture2D();
        GlStateManager.shadeModel(7425);
        GlStateManager.clearDepth(1.0);
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.cullFace(1029);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(5888);
        this.checkGLError("Startup");
        this.textureMapBlocks = new TextureMap("textures");
        this.textureMapBlocks.setMipmapLevels(this.gameSettings.mipmapLevels);
        this.renderEngine.loadTickableTexture(TextureMap.locationBlocksTexture, this.textureMapBlocks);
        this.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
        this.textureMapBlocks.setBlurMipmapDirect(false, this.gameSettings.mipmapLevels > 0);
        this.modelManager = new ModelManager(this.textureMapBlocks);
        this.mcResourceManager.registerReloadListener(this.modelManager);
        this.renderItem = new RenderItem(this.renderEngine, this.modelManager);
        this.renderManager = new RenderManager(this.renderEngine, this.renderItem);
        this.itemRenderer = new ItemRenderer(this);
        this.mcResourceManager.registerReloadListener(this.renderItem);
        this.entityRenderer = new EntityRenderer(this, this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.entityRenderer);
        this.blockRenderDispatcher = new BlockRendererDispatcher(this.modelManager.getBlockModelShapes(), this.gameSettings);
        this.mcResourceManager.registerReloadListener(this.blockRenderDispatcher);
        this.renderGlobal = new RenderGlobal(this);
        this.mcResourceManager.registerReloadListener(this.renderGlobal);
        this.guiAchievement = new GuiAchievement(this);
        this.drawSplashScreen(this.renderEngine, 0.72f);
        GlStateManager.viewport(0, 0, this.displayWidth, this.displayHeight);
        this.effectRenderer = new EffectRenderer(this.theWorld, this.renderEngine);
        this.checkGLError("Post startup");
        this.ingameGUI = new GuiIngame(this);
        this.drawSplashScreen(this.renderEngine, 0.88f);
        try {
            ViaMCP.create();
        }
        catch (Throwable throwable) {
            logger.error("Unable to initialize ViaMCP; falling back to native 1.8 networking", throwable);
        }
        this.drawSplashScreen(this.renderEngine, 1.0f);
        if (this.serverName != null) {
            this.displayGuiScreen(new GuiConnecting(new GuiMainMenu(), this, this.serverName, this.serverPort));
        } else {
            this.displayGuiScreen(new GuiMainMenu(true));
        }
        this.loadingScreen = new LoadingScreenRenderer(this);
        if (this.gameSettings.fullScreen && !this.fullscreen) {
            this.toggleFullscreen();
        }
        try {
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
        }
        catch (OpenGLException openGLException) {
            this.gameSettings.enableVsync = false;
            this.gameSettings.saveOptions();
        }
        this.renderGlobal.makeEntityOutlineShader();
        this.mimeow$initialize(new ocee33618a8d("startGame", false));
    }

    private void registerMetadataSerializers() {
        this.metadataSerializer_.registerMetadataSectionType(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new FontMetadataSectionSerializer(), FontMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new PackMetadataSectionSerializer(), PackMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
    }

    private void createDisplay() throws LWJGLException {
        Display.setResizable(true);
        Display.setTitle(ocbe9732642b.\u012f());
        try {
            Display.create(new PixelFormat().withDepthBits(24));
        }
        catch (LWJGLException lWJGLException) {
            logger.error("Couldn't set pixel format", (Throwable)lWJGLException);
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            if (this.fullscreen) {
                this.updateDisplayMode();
            }
            Display.create();
        }
    }

    private void setInitialDisplayMode() throws LWJGLException {
        if (this.fullscreen) {
            Display.setFullscreen(true);
            DisplayMode displayMode = Display.getDisplayMode();
            this.displayWidth = Math.max(1, displayMode.getWidth());
            this.displayHeight = Math.max(1, displayMode.getHeight());
        } else {
            Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
        }
        this.displayWidth = Math.max(1, Display.getWidth());
        this.displayHeight = Math.max(1, Display.getHeight());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setWindowIcon() {
        Util.EnumOS enumOS = Util.getOSType();
        if (enumOS != Util.EnumOS.OSX) {
            InputStream inputStream2;
            InputStream inputStream3;
            block5: {
                inputStream3 = null;
                inputStream2 = null;
                try {
                    inputStream3 = this.mcDefaultResourcePack.getInputStreamAssets(new ResourceLocation("icons/icon_16x16.png"));
                    inputStream2 = this.mcDefaultResourcePack.getInputStreamAssets(new ResourceLocation("icons/icon_32x32.png"));
                    if (inputStream3 == null || inputStream2 == null) break block5;
                    Display.setIcon(new ByteBuffer[]{this.readImageToBuffer(inputStream3), this.readImageToBuffer(inputStream2)});
                }
                catch (IOException iOException) {
                    try {
                        logger.error("Couldn't set icon", (Throwable)iOException);
                    }
                    catch (Throwable throwable) {
                        IOUtils.closeQuietly(inputStream3);
                        IOUtils.closeQuietly(inputStream2);
                        throw throwable;
                    }
                    IOUtils.closeQuietly(inputStream3);
                    IOUtils.closeQuietly(inputStream2);
                }
            }
            IOUtils.closeQuietly(inputStream3);
            IOUtils.closeQuietly(inputStream2);
        }
    }

    private static boolean isJvm64bit() {
        String[] stringArray;
        for (String string : stringArray = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"}) {
            String string2 = System.getProperty(string);
            if (string2 == null || !string2.contains("64")) continue;
            return true;
        }
        return false;
    }

    public Framebuffer getFramebuffer() {
        return this.framebufferMc;
    }

    public String getVersion() {
        return this.launchedVersion;
    }

    private void startTimerHackThread() {
        Thread thread2 = new Thread("Timer hack thread"){

            @Override
            public void run() {
                while (Minecraft.this.running) {
                    try {
                        Thread.sleep(Integer.MAX_VALUE);
                    }
                    catch (InterruptedException interruptedException) {}
                }
            }
        };
        thread2.setDaemon(true);
        thread2.start();
    }

    public void crashed(CrashReport crashReport) {
        this.hasCrashed = true;
        this.crashReporter = crashReport;
    }

    public void displayCrashReport(CrashReport crashReport) {
        File file = new File(Minecraft.getMinecraft().mcDataDir, "crash-reports");
        File file2 = new File(file, "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-client.txt");
        Bootstrap.printToSYSOUT(crashReport.getCompleteReport());
        if (crashReport.getFile() != null) {
            Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + String.valueOf(crashReport.getFile()));
            System.exit(-1);
        } else if (crashReport.saveToFile(file2)) {
            Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
            System.exit(-1);
        } else {
            Bootstrap.printToSYSOUT("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(-2);
        }
    }

    public boolean isUnicode() {
        return this.mcLanguageManager.isCurrentLocaleUnicode() || this.gameSettings.forceUnicodeFont;
    }

    public void refreshResources() {
        ArrayList<IResourcePack> arrayList = Lists.newArrayList(this.defaultResourcePacks);
        for (ResourcePackRepository.Entry entry : this.mcResourcePackRepository.getRepositoryEntries()) {
            arrayList.add(entry.getResourcePack());
        }
        if (this.mcResourcePackRepository.getResourcePackInstance() != null) {
            arrayList.add(this.mcResourcePackRepository.getResourcePackInstance());
        }
        try {
            this.mcResourceManager.reloadResources(arrayList);
        }
        catch (RuntimeException runtimeException) {
            logger.info("Caught error stitching, removing all assigned resourcepacks", (Throwable)runtimeException);
            arrayList.clear();
            arrayList.addAll(this.defaultResourcePacks);
            this.mcResourcePackRepository.setRepositories(Collections.emptyList());
            this.mcResourceManager.reloadResources(arrayList);
            this.gameSettings.resourcePacks.clear();
            this.gameSettings.incompatibleResourcePacks.clear();
            this.gameSettings.saveOptions();
        }
        this.mcLanguageManager.parseLanguageMetadata(arrayList);
        if (this.renderGlobal != null) {
            this.renderGlobal.loadRenderers();
        }
    }

    private ByteBuffer readImageToBuffer(InputStream inputStream2) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream2);
        int[] nArray = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 * nArray.length);
        for (int n : nArray) {
            byteBuffer.putInt(n << 8 | n >> 24 & 0xFF);
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    private void updateDisplayMode() throws LWJGLException {
        HashSet<DisplayMode> hashSet = Sets.newHashSet();
        Collections.addAll(hashSet, Display.getAvailableDisplayModes());
        DisplayMode displayMode = Display.getDesktopDisplayMode();
        if (!hashSet.contains(displayMode) && Util.getOSType() == Util.EnumOS.OSX) {
            block0: for (DisplayMode displayMode2 : macDisplayModes) {
                boolean bl = true;
                for (DisplayMode displayMode3 : hashSet) {
                    if (displayMode3.getBitsPerPixel() != 32 || displayMode3.getWidth() != displayMode2.getWidth() || displayMode3.getHeight() != displayMode2.getHeight()) continue;
                    bl = false;
                    break;
                }
                if (bl) continue;
                for (DisplayMode displayMode3 : hashSet) {
                    if (displayMode3.getBitsPerPixel() != 32 || displayMode3.getWidth() != displayMode2.getWidth() / 2 || displayMode3.getHeight() != displayMode2.getHeight() / 2) continue;
                    displayMode = displayMode3;
                    continue block0;
                }
            }
        }
        Display.setDisplayMode(displayMode);
        this.displayWidth = displayMode.getWidth();
        this.displayHeight = displayMode.getHeight();
    }

    private void drawSplashScreen(TextureManager textureManager, float f) throws LWJGLException {
        occ0c83447ab.\u04b7(this, textureManager, f);
    }

    public void draw(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        float f = 0.00390625f;
        float f2 = 0.00390625f;
        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldRenderer.pos(n, n2 + n6, 0.0).tex((float)n3 * f, (float)(n4 + n6) * f2).color(n7, n8, n9, n10).endVertex();
        worldRenderer.pos(n + n5, n2 + n6, 0.0).tex((float)(n3 + n5) * f, (float)(n4 + n6) * f2).color(n7, n8, n9, n10).endVertex();
        worldRenderer.pos(n + n5, n2, 0.0).tex((float)(n3 + n5) * f, (float)n4 * f2).color(n7, n8, n9, n10).endVertex();
        worldRenderer.pos(n, n2, 0.0).tex((float)n3 * f, (float)n4 * f2).color(n7, n8, n9, n10).endVertex();
        Tessellator.getInstance().draw();
    }

    public ISaveFormat getSaveLoader() {
        return this.saveLoader;
    }

    public void displayGuiScreen(GuiScreen guiScreen) {
        this.mimeow$onDisplayGuiScreen(guiScreen, new ocee33618a8d("displayGuiScreen", false));
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("displayGuiScreen", true);
        guiScreen = this.mimeow$guiOpen(guiScreen, ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            if (this.currentScreen != null) {
                this.currentScreen.onGuiClosed();
            }
            if (guiScreen == null && this.theWorld == null) {
                guiScreen = new GuiMainMenu();
            } else if (guiScreen == null && this.thePlayer.getHealth() <= 0.0f) {
                guiScreen = new GuiGameOver();
            }
            if (guiScreen instanceof GuiMainMenu) {
                this.gameSettings.showDebugInfo = false;
                this.ingameGUI.getChatGUI().clearChatMessages();
            }
            this.currentScreen = guiScreen;
            if (guiScreen != null) {
                this.setIngameNotInFocus();
                ScaledResolution scaledResolution = new ScaledResolution(this);
                int n = scaledResolution.getScaledWidth();
                int n2 = scaledResolution.getScaledHeight();
                guiScreen.setWorldAndResolution(this, n, n2);
                this.skipRenderWorld = false;
            } else {
                this.mcSoundHandler.resumeSounds();
                this.setIngameFocus();
            }
        }
    }

    private void checkGLError(String string) {
        int n;
        if (this.enableGLErrorChecking && (n = GL11.glGetError()) != 0) {
            String string2 = GLU.gluErrorString(n);
            logger.error("########## GL ERROR ##########");
            logger.error("@ " + string);
            logger.error(n + ": " + string2);
        }
    }

    public void shutdownMinecraftApplet() {
        try {
            logger.info("Stopping!");
            try {
                this.loadWorld(null);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this.mcSoundHandler.unloadSounds();
        }
        finally {
            Display.destroy();
            if (!this.hasCrashed) {
                oc099368a591.\u0216();
                System.exit(0);
            }
        }
        System.gc();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void runGameLoop() throws IOException {
        this.mimeow$onRunGameLoop(new ocee33618a8d("runGameLoop", false));
        ocb3fa5b0d15.\u025a(this.gameSettings.showDebugInfo);
        oc170ea29aae.\u03ec(this.gameSettings.showDebugInfo);
        long l = System.nanoTime();
        this.mcProfiler.startSection("root");
        if (Display.isCreated() && Display.isCloseRequested()) {
            this.shutdown();
        }
        oc51fb428ba0.\u043a(this.timer);
        oc51fb428ba0.\u023a(this.timer);
        if (this.isGamePaused && this.theWorld != null) {
            float f = this.timer.renderPartialTicks;
            this.timer.updateTimer();
            this.timer.renderPartialTicks = f;
        } else {
            this.timer.updateTimer();
        }
        oc51fb428ba0.\u04a7(this.timer);
        this.mcProfiler.startSection("scheduledExecutables");
        Queue<FutureTask<?>> queue = this.scheduledTasks;
        synchronized (queue) {
            while (!this.scheduledTasks.isEmpty()) {
                Util.runTask(this.scheduledTasks.poll(), logger);
            }
        }
        this.mcProfiler.endSection();
        long l2 = System.nanoTime();
        this.mcProfiler.startSection("tick");
        for (int i = 0; i < this.timer.elapsedTicks; ++i) {
            this.runTick();
        }
        oc51fb428ba0.\u0292();
        this.mcProfiler.endStartSection("preRenderErrors");
        long l3 = System.nanoTime() - l2;
        this.checkGLError("Pre render");
        this.mcProfiler.endStartSection("sound");
        this.mcSoundHandler.setListener(this.thePlayer, this.timer.renderPartialTicks);
        this.mcProfiler.endSection();
        this.mcProfiler.startSection("render");
        GlStateManager.pushMatrix();
        GlStateManager.clear(16640);
        this.framebufferMc.bindFramebuffer(true);
        this.mcProfiler.startSection("display");
        GlStateManager.enableTexture2D();
        if (this.thePlayer != null && this.thePlayer.isEntityInsideOpaqueBlock()) {
            this.gameSettings.thirdPersonView = 0;
        }
        this.mcProfiler.endSection();
        if (!this.skipRenderWorld) {
            this.mcProfiler.endStartSection("gameRenderer");
            EntityRenderer entityRenderer = this.entityRenderer;
            float f = this.timer.renderPartialTicks;
            this.mimeow$renderTickStart(new ocee33618a8d("runGameLoop", false));
            entityRenderer.updateCameraAndRender(f, l);
            this.mimeow$renderTickEnd(new ocee33618a8d("runGameLoop", false));
            this.mcProfiler.endSection();
        }
        this.mcProfiler.endSection();
        if (this.gameSettings.showDebugInfo && this.gameSettings.showDebugProfilerChart && !this.gameSettings.hideGUI) {
            if (!this.mcProfiler.profilingEnabled) {
                this.mcProfiler.clearProfiling();
            }
            this.mcProfiler.profilingEnabled = true;
            this.displayDebugInfo(l3);
        } else {
            this.mcProfiler.profilingEnabled = false;
            this.prevFrameTime = System.nanoTime();
        }
        this.guiAchievement.updateAchievementWindow();
        this.framebufferMc.unbindFramebuffer();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.framebufferMc.framebufferRender(this.displayWidth, this.displayHeight);
        GlStateManager.popMatrix();
        ocb3fa5b0d15.\u0538();
        this.mcProfiler.startSection("root");
        this.updateDisplay();
        Thread.yield();
        this.checkGLError("Post render");
        ++this.fpsCounter;
        this.isGamePaused = this.isSingleplayer() && this.currentScreen != null && this.currentScreen.doesGuiPauseGame() && !this.theIntegratedServer.getPublic();
        long l4 = System.nanoTime();
        this.frameTimer.addFrame(l4 - this.startNanoTime);
        this.startNanoTime = l4;
        while (Minecraft.getSystemTime() >= this.debugUpdateTime + 1000L) {
            debugFPS = this.fpsCounter;
            Object[] objectArray = new Object[8];
            objectArray[0] = debugFPS;
            objectArray[1] = RenderChunk.renderChunksUpdated;
            objectArray[2] = RenderChunk.renderChunksUpdated != 1 ? "s" : "";
            objectArray[3] = (float)this.gameSettings.limitFramerate == GameSettings.Options.FRAMERATE_LIMIT.getValueMax() ? "inf" : Integer.valueOf(this.gameSettings.limitFramerate);
            objectArray[4] = this.gameSettings.enableVsync ? " vsync" : "";
            Object object = objectArray[5] = this.gameSettings.fancyGraphics ? "" : " fast";
            objectArray[6] = this.gameSettings.clouds == 0 ? "" : (this.gameSettings.clouds == 1 ? " fast-clouds" : " fancy-clouds");
            objectArray[7] = OpenGlHelper.useVbo() ? " vbo" : "";
            this.debug = String.format("%d fps (%d chunk update%s) T: %s%s%s%s%s", objectArray);
            RenderChunk.renderChunksUpdated = 0;
            this.debugUpdateTime += 1000L;
            this.fpsCounter = 0;
            this.usageSnooper.addMemoryStatsToSnooper();
            if (this.usageSnooper.isSnooperRunning()) continue;
            this.usageSnooper.startSnooper();
        }
        if (this.isFramerateLimitBelowMax()) {
            this.mcProfiler.startSection("fpslimit_wait");
            Display.sync(this.getLimitFramerate());
            this.mcProfiler.endSection();
        }
        this.mcProfiler.endSection();
    }

    public void updateDisplay() {
        this.mcProfiler.startSection("display_update");
        oc02a3730b27.\u0269();
        Display.update();
        this.mcProfiler.endSection();
        this.checkWindowResize();
    }

    protected void checkWindowResize() {
        if (Display.wasResized()) {
            int n = this.displayWidth;
            int n2 = this.displayHeight;
            this.displayWidth = Display.getWidth();
            this.displayHeight = Display.getHeight();
            if (this.displayWidth != n || this.displayHeight != n2) {
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
                this.resize(this.displayWidth, this.displayHeight);
            }
        }
    }

    public int getLimitFramerate() {
        return this.theWorld == null && this.currentScreen != null && !(this.currentScreen instanceof GuiMainMenu) ? 30 : this.gameSettings.limitFramerate;
    }

    public boolean isFramerateLimitBelowMax() {
        return (float)this.getLimitFramerate() < GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
    }

    public void freeMemory() {
        try {
            memoryReserve = new byte[0];
            this.renderGlobal.deleteAllDisplayLists();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            System.gc();
            this.loadWorld(null);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        System.gc();
    }

    private void updateDebugProfilerName(int n) {
        List<Profiler.Result> list = this.mcProfiler.getProfilingData(this.debugProfilerName);
        if (list != null && !list.isEmpty()) {
            Profiler.Result result = list.remove(0);
            if (n == 0) {
                int n2;
                if (result.field_76331_c.length() > 0 && (n2 = this.debugProfilerName.lastIndexOf(".")) >= 0) {
                    this.debugProfilerName = this.debugProfilerName.substring(0, n2);
                }
            } else if (--n < list.size() && !list.get((int)n).field_76331_c.equals("unspecified")) {
                if (this.debugProfilerName.length() > 0) {
                    this.debugProfilerName = this.debugProfilerName + ".";
                }
                this.debugProfilerName = this.debugProfilerName + list.get((int)n).field_76331_c;
            }
        }
    }

    private void displayDebugInfo(long l) {
        if (this.mcProfiler.profilingEnabled) {
            int n;
            int n2;
            Object object;
            List<Profiler.Result> list = this.mcProfiler.getProfilingData(this.debugProfilerName);
            Profiler.Result result = list.remove(0);
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.enableColorMaterial();
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, this.displayWidth, this.displayHeight, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GL11.glLineWidth(1.0f);
            GlStateManager.disableTexture2D();
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            int n3 = 160;
            int n4 = this.displayWidth - n3 - 10;
            int n5 = this.displayHeight - n3 * 2;
            GlStateManager.enableBlend();
            worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
            worldRenderer.pos((float)n4 - (float)n3 * 1.1f, (float)n5 - (float)n3 * 0.6f - 16.0f, 0.0).color(200, 0, 0, 0).endVertex();
            worldRenderer.pos((float)n4 - (float)n3 * 1.1f, n5 + n3 * 2, 0.0).color(200, 0, 0, 0).endVertex();
            worldRenderer.pos((float)n4 + (float)n3 * 1.1f, n5 + n3 * 2, 0.0).color(200, 0, 0, 0).endVertex();
            worldRenderer.pos((float)n4 + (float)n3 * 1.1f, (float)n5 - (float)n3 * 0.6f - 16.0f, 0.0).color(200, 0, 0, 0).endVertex();
            tessellator.draw();
            GlStateManager.disableBlend();
            double d = 0.0;
            for (int i = 0; i < list.size(); ++i) {
                float f;
                float f2;
                float f3;
                int n6;
                object = list.get(i);
                n2 = MathHelper.floor_double(((Profiler.Result)object).field_76332_a / 4.0) + 1;
                worldRenderer.begin(6, DefaultVertexFormats.POSITION_COLOR);
                n = ((Profiler.Result)object).getColor();
                int n7 = n >> 16 & 0xFF;
                int n8 = n >> 8 & 0xFF;
                int n9 = n & 0xFF;
                worldRenderer.pos(n4, n5, 0.0).color(n7, n8, n9, 255).endVertex();
                for (n6 = n2; n6 >= 0; --n6) {
                    f3 = (float)((d + ((Profiler.Result)object).field_76332_a * (double)n6 / (double)n2) * Math.PI * 2.0 / 100.0);
                    f2 = MathHelper.sin(f3) * (float)n3;
                    f = MathHelper.cos(f3) * (float)n3 * 0.5f;
                    worldRenderer.pos((float)n4 + f2, (float)n5 - f, 0.0).color(n7, n8, n9, 255).endVertex();
                }
                tessellator.draw();
                worldRenderer.begin(5, DefaultVertexFormats.POSITION_COLOR);
                for (n6 = n2; n6 >= 0; --n6) {
                    f3 = (float)((d + ((Profiler.Result)object).field_76332_a * (double)n6 / (double)n2) * Math.PI * 2.0 / 100.0);
                    f2 = MathHelper.sin(f3) * (float)n3;
                    f = MathHelper.cos(f3) * (float)n3 * 0.5f;
                    worldRenderer.pos((float)n4 + f2, (float)n5 - f, 0.0).color(n7 >> 1, n8 >> 1, n9 >> 1, 255).endVertex();
                    worldRenderer.pos((float)n4 + f2, (float)n5 - f + 10.0f, 0.0).color(n7 >> 1, n8 >> 1, n9 >> 1, 255).endVertex();
                }
                tessellator.draw();
                d += ((Profiler.Result)object).field_76332_a;
            }
            DecimalFormat decimalFormat = new DecimalFormat("##0.00");
            GlStateManager.enableTexture2D();
            object = "";
            if (!result.field_76331_c.equals("unspecified")) {
                object = (String)object + "[0] ";
            }
            object = result.field_76331_c.length() == 0 ? (String)object + "ROOT " : (String)object + result.field_76331_c + " ";
            n2 = 0xFFFFFF;
            this.fontRendererObj.drawStringWithShadow((String)object, n4 - n3, n5 - n3 / 2 - 16, n2);
            object = decimalFormat.format(result.field_76330_b) + "%";
            this.fontRendererObj.drawStringWithShadow((String)object, n4 + n3 - this.fontRendererObj.getStringWidth((String)object), n5 - n3 / 2 - 16, n2);
            for (n = 0; n < list.size(); ++n) {
                Profiler.Result result2 = list.get(n);
                Object object2 = "";
                object2 = result2.field_76331_c.equals("unspecified") ? (String)object2 + "[?] " : (String)object2 + "[" + (n + 1) + "] ";
                object2 = (String)object2 + result2.field_76331_c;
                this.fontRendererObj.drawStringWithShadow((String)object2, n4 - n3, n5 + n3 / 2 + n * 8 + 20, result2.getColor());
                object2 = decimalFormat.format(result2.field_76332_a) + "%";
                this.fontRendererObj.drawStringWithShadow((String)object2, n4 + n3 - 50 - this.fontRendererObj.getStringWidth((String)object2), n5 + n3 / 2 + n * 8 + 20, result2.getColor());
                object2 = decimalFormat.format(result2.field_76330_b) + "%";
                this.fontRendererObj.drawStringWithShadow((String)object2, n4 + n3 - this.fontRendererObj.getStringWidth((String)object2), n5 + n3 / 2 + n * 8 + 20, result2.getColor());
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }

    public void setIngameFocus() {
        if (Display.isActive() && !this.inGameHasFocus) {
            this.inGameHasFocus = true;
            this.mouseHelper.grabMouseCursor();
            this.displayGuiScreen(null);
            this.leftClickCounter = 10000;
        }
    }

    public void setIngameNotInFocus() {
        if (this.inGameHasFocus) {
            KeyBinding.unPressAllKeys();
            this.inGameHasFocus = false;
            this.mouseHelper.ungrabMouseCursor();
        }
    }

    public void displayInGameMenu() {
        if (this.currentScreen == null) {
            this.displayGuiScreen(new GuiIngameMenu());
            if (this.isSingleplayer() && !this.theIntegratedServer.getPublic()) {
                this.mcSoundHandler.pauseSounds();
            }
        }
    }

    private void sendClickBlockToController(boolean bl) {
        if (oc51fb428ba0.\u0241()) {
            return;
        }
        if (!bl) {
            this.leftClickCounter = 0;
        }
        if (this.leftClickCounter <= 0 && !this.thePlayer.isUsingItem()) {
            if (bl && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                BlockPos blockPos = this.objectMouseOver.getBlockPos();
                if (this.theWorld.getBlockState(blockPos).getBlock().getMaterial() != Material.air) {
                    ocea775c9d5c.\u0173.post(new oc2bbaa492fe(blockPos, this.objectMouseOver.sideHit));
                    if (this.playerController.onPlayerDamageBlock(blockPos, this.objectMouseOver.sideHit)) {
                        this.effectRenderer.addBlockHitEffects(blockPos, this.objectMouseOver.sideHit);
                        this.thePlayer.swingItem();
                    }
                }
            } else {
                this.playerController.resetBlockRemoving();
            }
        }
    }

    private void clickMouse() {
        if (oc51fb428ba0.\u0241()) {
            return;
        }
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("clickMouse", true);
        this.mimeow$injectClickMouse(ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            if (this.leftClickCounter <= 0) {
                AttackOrder.sendConditionalSwing(this, this.objectMouseOver);
                if (this.objectMouseOver == null) {
                    logger.error("Null returned as 'hitResult', this shouldn't happen!");
                    if (this.playerController.isNotCreative()) {
                        this.leftClickCounter = 10;
                    }
                } else {
                    switch (this.objectMouseOver.typeOfHit) {
                        case ENTITY: {
                            AttackOrder.sendFixedAttack(this, this.thePlayer, this.objectMouseOver.entityHit);
                            break;
                        }
                        case BLOCK: {
                            BlockPos blockPos = this.objectMouseOver.getBlockPos();
                            if (this.theWorld.getBlockState(blockPos).getBlock().getMaterial() != Material.air) {
                                this.playerController.clickBlock(blockPos, this.objectMouseOver.sideHit);
                                break;
                            }
                        }
                        default: {
                            if (!this.playerController.isNotCreative()) break;
                            this.leftClickCounter = 10;
                        }
                    }
                }
            }
            ocea775c9d5c.\u0173.post(new oc68db11bd12());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void rightClickMouse() {
        oc02a3730b27.Y();
        try {
            ocee33618a8d ocee33618a8d2 = new ocee33618a8d("rightClickMouse", true);
            this.mimeow$injectRightClickMouse(ocee33618a8d2);
            if (!ocee33618a8d2.z$24lpjeeur71n9() && !this.playerController.getIsHittingBlock()) {
                Object object;
                this.rightClickDelayTimer = 4;
                boolean bl = true;
                ItemStack itemStack = this.thePlayer.inventory.getCurrentItem();
                if (this.objectMouseOver == null) {
                    logger.warn("Null returned as 'hitResult', this shouldn't happen!");
                } else {
                    switch (this.objectMouseOver.typeOfHit) {
                        case ENTITY: {
                            if (this.playerController.isPlayerRightClickingOnEntity(this.thePlayer, this.objectMouseOver.entityHit, this.objectMouseOver)) {
                                bl = false;
                                break;
                            }
                            if (!this.playerController.interactWithEntitySendPacket(this.thePlayer, this.objectMouseOver.entityHit)) break;
                            bl = false;
                            break;
                        }
                        case BLOCK: {
                            int n;
                            object = this.objectMouseOver.getBlockPos();
                            if (this.theWorld.getBlockState((BlockPos)object).getBlock().getMaterial() == Material.air) break;
                            int n2 = n = itemStack != null ? itemStack.stackSize : 0;
                            if (this.playerController.onPlayerRightClick(this.thePlayer, this.theWorld, itemStack, (BlockPos)object, this.objectMouseOver.sideHit, this.objectMouseOver.hitVec)) {
                                bl = false;
                                this.thePlayer.swingItem();
                            }
                            if (itemStack == null) {
                                return;
                            }
                            if (itemStack.stackSize == 0) {
                                this.thePlayer.inventory.mainInventory[oc718fd4d503.\u014c.\u0532()] = null;
                                break;
                            }
                            if (itemStack.stackSize == n && !this.playerController.isInCreativeMode()) break;
                            this.entityRenderer.itemRenderer.resetEquippedProgress();
                        }
                    }
                }
                if (bl && (object = this.thePlayer.inventory.getCurrentItem()) != null && this.playerController.sendUseItem(this.thePlayer, this.theWorld, (ItemStack)object)) {
                    this.entityRenderer.itemRenderer.resetEquippedProgress2();
                }
            }
        }
        finally {
            oc02a3730b27.\u00da();
        }
    }

    public void toggleFullscreen() {
        try {
            this.gameSettings.fullScreen = this.fullscreen = !this.fullscreen;
            Display.setFullscreen(this.fullscreen);
            this.displayWidth = Math.max(1, Display.getWidth());
            this.displayHeight = Math.max(1, Display.getHeight());
            if (this.currentScreen != null) {
                this.resize(this.displayWidth, this.displayHeight);
            } else {
                this.updateFramebufferSize();
            }
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
            this.updateDisplay();
        }
        catch (Exception exception) {
            logger.error("Couldn't toggle fullscreen", (Throwable)exception);
        }
    }

    private void resize(int n, int n2) {
        this.displayWidth = Math.max(1, n);
        this.displayHeight = Math.max(1, n2);
        if (this.currentScreen != null) {
            ScaledResolution scaledResolution = new ScaledResolution(this);
            this.currentScreen.onResize(this, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
        }
        this.loadingScreen = new LoadingScreenRenderer(this);
        this.updateFramebufferSize();
    }

    private void updateFramebufferSize() {
        this.framebufferMc.createBindFramebuffer(this.displayWidth, this.displayHeight);
        if (this.entityRenderer != null) {
            this.entityRenderer.updateShaderGroupSize(this.displayWidth, this.displayHeight);
        }
    }

    public MusicTicker getMusicTicker() {
        return this.mcMusicTicker;
    }

    public void runTick() throws IOException {
        Object object;
        Object object2;
        if (oc51fb428ba0.\u01fb()) {
            return;
        }
        this.mimeow$onRunTickStart(new ocee33618a8d("runTick", false));
        this.mimeow$clientTickStart(new ocee33618a8d("runTick", false));
        if (this.rightClickDelayTimer > 0) {
            --this.rightClickDelayTimer;
        }
        Profiler profiler = this.mcProfiler;
        this.mimeow$onRunTickAfterRightClickDelay(new ocee33618a8d("runTick", false));
        profiler.startSection("gui");
        if (!this.isGamePaused) {
            this.ingameGUI.updateTick();
        }
        this.mcProfiler.endSection();
        EntityRenderer entityRenderer = this.entityRenderer;
        this.mimeow$onBeforeGetMouseOver(new ocee33618a8d("runTick", false));
        entityRenderer.getMouseOver(1.0f);
        this.mimeow$onRunTickMouseOver(new ocee33618a8d("runTick", false));
        this.mcProfiler.startSection("gameMode");
        if (!this.isGamePaused && this.theWorld != null) {
            this.playerController.updateController();
        }
        this.mcProfiler.endStartSection("textures");
        if (!this.isGamePaused) {
            this.renderEngine.tick();
        }
        if (this.currentScreen == null && this.thePlayer != null) {
            if (this.thePlayer.getHealth() <= 0.0f) {
                this.displayGuiScreen(null);
            } else if (this.thePlayer.isPlayerSleeping() && this.theWorld != null) {
                this.displayGuiScreen(new GuiSleepMP());
            }
        } else if (this.currentScreen != null && this.currentScreen instanceof GuiSleepMP && !this.thePlayer.isPlayerSleeping()) {
            this.displayGuiScreen(null);
        }
        if (this.currentScreen != null) {
            this.leftClickCounter = 10000;
        }
        if (this.currentScreen != null) {
            try {
                this.currentScreen.handleInput();
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Updating screen events");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Affected screen");
                crashReportCategory.addCrashSectionCallable("Screen name", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return Minecraft.this.currentScreen.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(crashReport);
            }
            if (this.currentScreen != null) {
                try {
                    this.currentScreen.updateScreen();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Ticking screen");
                    CrashReportCategory crashReportCategory = crashReport.makeCategory("Affected screen");
                    crashReportCategory.addCrashSectionCallable("Screen name", new Callable<String>(){

                        @Override
                        public String call() throws Exception {
                            return Minecraft.this.currentScreen.getClass().getCanonicalName();
                        }
                    });
                    throw new ReportedException(crashReport);
                }
            }
        }
        if (this.currentScreen == null || this.currentScreen.allowUserInput) {
            int n;
            this.mcProfiler.endStartSection("mouse");
            while (this.mimeow$redirect$nextMouseEvent()) {
                long l;
                int n2 = Mouse.getEventButton();
                KeyBinding.setKeyBindState(n2 - 100, Mouse.getEventButtonState());
                if (Mouse.getEventButtonState()) {
                    if (this.thePlayer.isSpectator() && n2 == 2) {
                        this.ingameGUI.getSpectatorGui().func_175261_b();
                    } else {
                        KeyBinding.onTick(n2 - 100);
                    }
                }
                if ((l = Minecraft.getSystemTime() - this.systemTime) > 200L) continue;
                n = Mouse.getEventDWheel();
                if (n != 0) {
                    if (this.thePlayer.isSpectator()) {
                        int n3 = n = n < 0 ? -1 : 1;
                        if (this.ingameGUI.getSpectatorGui().func_175262_a()) {
                            this.ingameGUI.getSpectatorGui().func_175259_b(-n);
                        } else {
                            float f = MathHelper.clamp_float(this.thePlayer.capabilities.getFlySpeed() + (float)n * 0.005f, 0.0f, 0.2f);
                            this.thePlayer.capabilities.setFlySpeed(f);
                        }
                    } else {
                        InventoryPlayer inventoryPlayer = this.thePlayer.inventory;
                        this.mimeow$redirect$changeCurrentItem(inventoryPlayer, n);
                    }
                }
                if (this.currentScreen == null) {
                    if (this.inGameHasFocus || !Mouse.getEventButtonState()) continue;
                    this.setIngameFocus();
                    continue;
                }
                if (this.currentScreen == null) continue;
                this.currentScreen.handleMouseInput();
            }
            if (this.leftClickCounter > 0) {
                --this.leftClickCounter;
            }
            Profiler profiler2 = this.mcProfiler;
            this.mimeow$onRunTick(new ocee33618a8d("runTick", false));
            profiler2.endStartSection("keyboard");
            while (Keyboard.next()) {
                int n4;
                ocea775c9d5c.\u0173.post(new occb187f10ff(Keyboard.getKeyName(Keyboard.getEventKey()), Keyboard.getEventKey(), Keyboard.getEventKeyState(), this.currentScreen != null));
                int n5 = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
                KeyBinding.setKeyBindState(n5, Keyboard.getEventKeyState());
                if (Keyboard.getEventKeyState()) {
                    KeyBinding.onTick(n5);
                }
                if (this.debugCrashKeyPressTime > 0L) {
                    if (Minecraft.getSystemTime() - this.debugCrashKeyPressTime >= 6000L) {
                        throw new ReportedException(new CrashReport("Manually triggered debug crash", new Throwable()));
                    }
                    if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61)) {
                        this.debugCrashKeyPressTime = -1L;
                    }
                } else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61)) {
                    this.debugCrashKeyPressTime = Minecraft.getSystemTime();
                }
                ocea775c9d5c.\u0173.post(new occb187f10ff(Keyboard.getKeyName(Keyboard.getEventKey()), Keyboard.getEventKey(), Keyboard.getEventKeyState(), this.currentScreen != null));
                this.dispatchKeypresses();
                if (!Keyboard.getEventKeyState()) continue;
                if (n5 == 62 && this.entityRenderer != null) {
                    this.entityRenderer.switchUseShader();
                }
                if (this.currentScreen != null) {
                    this.currentScreen.handleKeyboardInput();
                } else {
                    if (n5 == 1) {
                        this.displayInGameMenu();
                    }
                    if (n5 == 32 && Keyboard.isKeyDown(61) && this.ingameGUI != null) {
                        this.ingameGUI.getChatGUI().clearChatMessages();
                    }
                    if (n5 == 31 && Keyboard.isKeyDown(61)) {
                        this.refreshResources();
                    }
                    if (n5 != 17 || Keyboard.isKeyDown(61)) {
                        // empty if block
                    }
                    if (n5 != 18 || Keyboard.isKeyDown(61)) {
                        // empty if block
                    }
                    if (n5 != 47 || Keyboard.isKeyDown(61)) {
                        // empty if block
                    }
                    if (n5 != 38 || Keyboard.isKeyDown(61)) {
                        // empty if block
                    }
                    if (n5 != 22 || Keyboard.isKeyDown(61)) {
                        // empty if block
                    }
                    if (n5 == 20 && Keyboard.isKeyDown(61)) {
                        this.refreshResources();
                    }
                    if (n5 == 33 && Keyboard.isKeyDown(61)) {
                        this.gameSettings.setOptionValue(GameSettings.Options.RENDER_DISTANCE, GuiScreen.isShiftKeyDown() ? -1 : 1);
                    }
                    if (n5 == 30 && Keyboard.isKeyDown(61)) {
                        this.renderGlobal.loadRenderers();
                    }
                    if (n5 == 35 && Keyboard.isKeyDown(61)) {
                        this.gameSettings.advancedItemTooltips = !this.gameSettings.advancedItemTooltips;
                        this.gameSettings.saveOptions();
                    }
                    if (n5 == 48 && Keyboard.isKeyDown(61)) {
                        this.renderManager.setDebugBoundingBox(!this.renderManager.isDebugBoundingBox());
                    }
                    if (n5 == 25 && Keyboard.isKeyDown(61)) {
                        this.gameSettings.pauseOnLostFocus = !this.gameSettings.pauseOnLostFocus;
                        this.gameSettings.saveOptions();
                    }
                    if (n5 == 59) {
                        boolean bl = this.gameSettings.hideGUI = !this.gameSettings.hideGUI;
                    }
                    if (n5 == 61) {
                        this.gameSettings.showDebugInfo = !this.gameSettings.showDebugInfo;
                        this.gameSettings.showDebugProfilerChart = GuiScreen.isShiftKeyDown();
                        this.gameSettings.showLagometer = GuiScreen.isAltKeyDown();
                    }
                    if (this.gameSettings.keyBindTogglePerspective.isPressed()) {
                        n4 = this.gameSettings.thirdPersonView + 1;
                        this.mimeow$redirect$onSetThirdPersonView(this.gameSettings, n4);
                        if (this.gameSettings.thirdPersonView > 2) {
                            n = 0;
                            this.mimeow$redirect$onSetThirdPersonView(this.gameSettings, n);
                        }
                        if (this.gameSettings.thirdPersonView == 0) {
                            this.entityRenderer.loadEntityShader(this.getRenderViewEntity());
                        } else if (this.gameSettings.thirdPersonView == 1) {
                            this.entityRenderer.loadEntityShader(null);
                        }
                        this.renderGlobal.setDisplayListEntitiesDirty();
                    }
                    if (this.gameSettings.keyBindSmoothCamera.isPressed()) {
                        boolean bl = this.gameSettings.smoothCamera = !this.gameSettings.smoothCamera;
                    }
                }
                if (!this.gameSettings.showDebugInfo || !this.gameSettings.showDebugProfilerChart) continue;
                if (n5 == 11) {
                    this.updateDebugProfilerName(0);
                }
                for (n4 = 0; n4 < 9; ++n4) {
                    if (n5 != 2 + n4) continue;
                    this.updateDebugProfilerName(n4 + 1);
                }
            }
            for (int i = 0; i < 9; ++i) {
                if (!this.gameSettings.keyBindsHotbar[i].isPressed()) continue;
                if (this.thePlayer.isSpectator()) {
                    this.ingameGUI.getSpectatorGui().func_175260_a(i);
                    continue;
                }
                this.mimeow$redirect$onSetCurrentItem(this.thePlayer.inventory, i);
            }
            object2 = this.gameSettings;
            object = this.mimeow$injectBeforeChatVisibility(new ocee33618a8d("runTick", false));
            int n6 = n = ((GameSettings)object2).chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN ? 1 : 0;
            while (this.gameSettings.keyBindInventory.isPressed()) {
                if (this.playerController.isRidingHorse()) {
                    this.thePlayer.sendHorseInventory();
                    continue;
                }
                this.getNetHandler().addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT));
                this.displayGuiScreen(new GuiInventory(this.thePlayer));
            }
            while (this.gameSettings.keyBindDrop.isPressed()) {
                if (this.thePlayer.isSpectator()) continue;
                this.thePlayer.dropOneItem(GuiScreen.isCtrlKeyDown());
            }
            while (this.gameSettings.keyBindChat.isPressed() && n != 0) {
                this.displayGuiScreen(new GuiChat());
            }
            if (this.currentScreen == null && this.gameSettings.keyBindCommand.isPressed() && n != 0) {
                this.displayGuiScreen(new GuiChat("/"));
            }
            if (this.thePlayer.isUsingItem()) {
                if (!((oca27090789a)object).\u0241() && !this.gameSettings.keyBindUseItem.isKeyDown()) {
                    this.playerController.onStoppedUsingItem(this.thePlayer);
                }
                while (this.gameSettings.keyBindAttack.isPressed()) {
                }
                while (this.gameSettings.keyBindUseItem.isPressed()) {
                }
                while (this.gameSettings.keyBindPickBlock.isPressed()) {
                }
            } else {
                while (this.gameSettings.keyBindAttack.isPressed()) {
                    if (((oca27090789a)object).\u0508()) continue;
                    this.clickMouse();
                }
                while (this.gameSettings.keyBindUseItem.isPressed()) {
                    if (((oca27090789a)object).\u00e8()) continue;
                    this.rightClickMouse();
                }
                while (this.gameSettings.keyBindPickBlock.isPressed()) {
                    this.middleClickMouse();
                }
            }
            if (!((oca27090789a)object).\u00e8() && this.gameSettings.keyBindUseItem.isKeyDown() && this.rightClickDelayTimer == 0 && !this.thePlayer.isUsingItem()) {
                this.rightClickMouse();
            }
            if (!((oca27090789a)object).\u040b()) {
                this.sendClickBlockToController(this.currentScreen == null && this.gameSettings.keyBindAttack.isKeyDown() && this.inGameHasFocus);
            }
            this.mimeow$fastMinePassiveBlockHitDelay(new ocee33618a8d("runTick", false));
        }
        if (this.theWorld != null) {
            if (this.thePlayer != null) {
                ++this.joinPlayerCounter;
                if (this.joinPlayerCounter == 30) {
                    this.joinPlayerCounter = 0;
                    this.theWorld.joinEntityInSurroundings(this.thePlayer);
                }
            }
            this.mcProfiler.endStartSection("gameRenderer");
            if (!this.isGamePaused) {
                this.entityRenderer.updateRenderer();
            }
            this.mcProfiler.endStartSection("levelRenderer");
            if (!this.isGamePaused) {
                this.renderGlobal.updateClouds();
            }
            this.mcProfiler.endStartSection("level");
            if (!this.isGamePaused) {
                if (this.theWorld.getLastLightningBolt() > 0) {
                    this.theWorld.setLastLightningBolt(this.theWorld.getLastLightningBolt() - 1);
                }
                oc02a3730b27.\u0418();
                try {
                    this.theWorld.updateEntities();
                    ocea775c9d5c.\u0173.post(new oce38b1b133f());
                }
                catch (Error | RuntimeException throwable) {
                    oc02a3730b27.\u0125();
                    throw throwable;
                }
                oc02a3730b27.\u0224();
                ocea775c9d5c.\u0173.post(new ocac48057a4f());
            }
        } else if (this.entityRenderer.isShaderActive()) {
            this.entityRenderer.stopUseShader();
        }
        if (!this.isGamePaused) {
            this.mcMusicTicker.update();
            this.mcSoundHandler.update();
        }
        if (this.theWorld != null) {
            if (!this.isGamePaused) {
                this.theWorld.setAllowedSpawnTypes(this.theWorld.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                try {
                    this.theWorld.tick();
                }
                catch (Throwable throwable) {
                    object2 = CrashReport.makeCrashReport(throwable, "Exception in world tick");
                    if (this.theWorld == null) {
                        object = ((CrashReport)object2).makeCategory("Affected level");
                        ((CrashReportCategory)object).addCrashSection("Problem", "Level is null!");
                    } else {
                        this.theWorld.addWorldInfoToCrashReport((CrashReport)object2);
                    }
                    throw new ReportedException((CrashReport)object2);
                }
            }
            this.mcProfiler.endStartSection("animateTick");
            if (!this.isGamePaused && this.theWorld != null) {
                this.theWorld.doVoidFogParticles(MathHelper.floor_double(this.thePlayer.posX), MathHelper.floor_double(this.thePlayer.posY), MathHelper.floor_double(this.thePlayer.posZ));
            }
            this.mcProfiler.endStartSection("particles");
            if (!this.isGamePaused) {
                this.effectRenderer.updateEffects();
            }
        } else if (this.myNetworkManager != null) {
            this.mcProfiler.endStartSection("pendingConnection");
            this.myNetworkManager.processReceivedPackets();
        }
        this.mcProfiler.endSection();
        this.systemTime = Minecraft.getSystemTime();
        this.mimeow$clientTickEnd(new ocee33618a8d("runTick", false));
        oc51fb428ba0.\u04b7();
    }

    public void launchIntegratedServer(String string, String string2, WorldSettings worldSettings) {
        Object object;
        this.loadWorld(null);
        System.gc();
        ISaveHandler iSaveHandler = this.saveLoader.getSaveLoader(string, false);
        WorldInfo worldInfo = iSaveHandler.loadWorldInfo();
        if (worldInfo == null && worldSettings != null) {
            worldInfo = new WorldInfo(worldSettings, string);
            iSaveHandler.saveWorldInfo(worldInfo);
        }
        if (worldSettings == null) {
            worldSettings = new WorldSettings(worldInfo);
        }
        try {
            this.theIntegratedServer = new IntegratedServer(this, string, string2, worldSettings);
            this.theIntegratedServer.startServerThread();
            this.integratedServerIsRunning = true;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Starting integrated server");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Starting integrated server");
            crashReportCategory.addCrashSection("Level ID", string);
            crashReportCategory.addCrashSection("Level Name", string2);
            throw new ReportedException(crashReport);
        }
        this.loadingScreen.displaySavingString(I18n.format("menu.loadingLevel", new Object[0]));
        while (!this.theIntegratedServer.serverIsInRunLoop()) {
            object = this.theIntegratedServer.getUserMessage();
            if (object != null) {
                this.loadingScreen.displayLoadingString(I18n.format((String)object, new Object[0]));
            } else {
                this.loadingScreen.displayLoadingString("");
            }
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedException) {}
        }
        this.displayGuiScreen(null);
        object = this.theIntegratedServer.getNetworkSystem().addLocalEndpoint();
        NetworkManager networkManager = NetworkManager.provideLocalClient((SocketAddress)object);
        networkManager.setNetHandler(new NetHandlerLoginClient(networkManager, this, null));
        networkManager.sendPacket(new C00Handshake(47, object.toString(), 0, EnumConnectionState.LOGIN));
        networkManager.sendPacket(new C00PacketLoginStart(this.getSession().getProfile()));
        this.myNetworkManager = networkManager;
    }

    public void loadWorld(WorldClient worldClient) {
        this.loadWorld(worldClient, "");
    }

    public void loadWorld(WorldClient worldClient, String string) {
        this.mimeow$worldUnload(worldClient, string, new ocee33618a8d("loadWorld", false));
        if (worldClient == null) {
            NetHandlerPlayClient netHandlerPlayClient = this.getNetHandler();
            if (netHandlerPlayClient != null) {
                netHandlerPlayClient.cleanup();
            }
            if (this.theIntegratedServer != null && this.theIntegratedServer.isAnvilFileSet()) {
                this.theIntegratedServer.initiateShutdown();
                this.theIntegratedServer.setStaticInstance();
            }
            this.theIntegratedServer = null;
            this.guiAchievement.clearAchievements();
            this.entityRenderer.getMapItemRenderer().clearLoadedMaps();
        }
        this.renderViewEntity = null;
        this.myNetworkManager = null;
        if (this.loadingScreen != null) {
            this.loadingScreen.resetProgressAndMessage(string);
            this.loadingScreen.displayLoadingString("");
        }
        if (worldClient == null && this.theWorld != null) {
            this.mcResourcePackRepository.clearResourcePack();
            this.ingameGUI.resetPlayersOverlayFooterHeader();
            this.setServerData(null);
            this.integratedServerIsRunning = false;
        }
        this.mcSoundHandler.stopSounds();
        this.theWorld = worldClient;
        if (worldClient != null) {
            if (this.renderGlobal != null) {
                this.renderGlobal.setWorldAndLoadRenderers(worldClient);
            }
            if (this.effectRenderer != null) {
                this.effectRenderer.clearEffects(worldClient);
            }
            if (this.thePlayer == null) {
                this.thePlayer = this.playerController.func_178892_a(worldClient, new StatFileWriter());
                this.playerController.flipPlayer(this.thePlayer);
            }
            this.thePlayer.preparePlayerToSpawn();
            worldClient.spawnEntityInWorld(this.thePlayer);
            this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
            this.playerController.setPlayerCapabilities(this.thePlayer);
            this.renderViewEntity = this.thePlayer;
        } else {
            this.saveLoader.flushCache();
            this.thePlayer = null;
        }
        this.systemTime = 0L;
        this.mimeow$worldLoad(worldClient, string, new ocee33618a8d("loadWorld", false));
    }

    public void setDimensionAndSpawnPlayer(int n) {
        this.theWorld.setInitialSpawnLocation();
        this.theWorld.removeAllEntities();
        int n2 = 0;
        String string = null;
        if (this.thePlayer != null) {
            n2 = this.thePlayer.getEntityId();
            this.theWorld.removeEntity(this.thePlayer);
            string = this.thePlayer.getClientBrand();
        }
        this.renderViewEntity = null;
        EntityPlayerSP entityPlayerSP = this.thePlayer;
        this.thePlayer = this.playerController.func_178892_a(this.theWorld, this.thePlayer == null ? new StatFileWriter() : this.thePlayer.getStatFileWriter());
        this.thePlayer.getDataWatcher().updateWatchedObjectsFromList(entityPlayerSP.getDataWatcher().getAllWatched());
        this.thePlayer.dimension = n;
        this.renderViewEntity = this.thePlayer;
        this.thePlayer.preparePlayerToSpawn();
        this.thePlayer.setClientBrand(string);
        this.theWorld.spawnEntityInWorld(this.thePlayer);
        this.playerController.flipPlayer(this.thePlayer);
        this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
        this.thePlayer.setEntityId(n2);
        this.playerController.setPlayerCapabilities(this.thePlayer);
        this.thePlayer.setReducedDebug(entityPlayerSP.hasReducedDebug());
        if (this.currentScreen instanceof GuiGameOver) {
            this.displayGuiScreen(null);
        }
    }

    public final boolean isDemo() {
        return this.isDemo;
    }

    public NetHandlerPlayClient getNetHandler() {
        return this.thePlayer != null ? this.thePlayer.sendQueue : null;
    }

    public static boolean isGuiEnabled() {
        return theMinecraft == null || !Minecraft.theMinecraft.gameSettings.hideGUI;
    }

    public static boolean isFancyGraphicsEnabled() {
        return theMinecraft != null && Minecraft.theMinecraft.gameSettings.fancyGraphics;
    }

    public static boolean isAmbientOcclusionEnabled() {
        return theMinecraft != null && Minecraft.theMinecraft.gameSettings.ambientOcclusion != 0;
    }

    private void middleClickMouse() {
        if (this.objectMouseOver != null) {
            Item item;
            Object object;
            Object object2;
            boolean bl = this.thePlayer.capabilities.isCreativeMode;
            int n = 0;
            boolean bl2 = false;
            TileEntity tileEntity = null;
            if (this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                object2 = this.objectMouseOver.getBlockPos();
                object = this.theWorld.getBlockState((BlockPos)object2).getBlock();
                if (((Block)object).getMaterial() == Material.air) {
                    return;
                }
                item = ((Block)object).getItem(this.theWorld, (BlockPos)object2);
                if (item == null) {
                    return;
                }
                if (bl && GuiScreen.isCtrlKeyDown()) {
                    tileEntity = this.theWorld.getTileEntity((BlockPos)object2);
                }
                Block block = item instanceof ItemBlock && !((Block)object).isFlowerPot() ? Block.getBlockFromItem(item) : object;
                n = block.getDamageValue(this.theWorld, (BlockPos)object2);
                bl2 = item.getHasSubtypes();
            } else {
                if (this.objectMouseOver.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY || this.objectMouseOver.entityHit == null || !bl) {
                    return;
                }
                if (this.objectMouseOver.entityHit instanceof EntityPainting) {
                    item = Items.painting;
                } else if (this.objectMouseOver.entityHit instanceof EntityLeashKnot) {
                    item = Items.lead;
                } else if (this.objectMouseOver.entityHit instanceof EntityItemFrame) {
                    object2 = (EntityItemFrame)this.objectMouseOver.entityHit;
                    object = ((EntityItemFrame)object2).getDisplayedItem();
                    if (object == null) {
                        item = Items.item_frame;
                    } else {
                        item = ((ItemStack)object).getItem();
                        n = ((ItemStack)object).getMetadata();
                        bl2 = true;
                    }
                } else if (this.objectMouseOver.entityHit instanceof EntityMinecart) {
                    object2 = (EntityMinecart)this.objectMouseOver.entityHit;
                    switch (((EntityMinecart)object2).getMinecartType()) {
                        case FURNACE: {
                            item = Items.furnace_minecart;
                            break;
                        }
                        case CHEST: {
                            item = Items.chest_minecart;
                            break;
                        }
                        case TNT: {
                            item = Items.tnt_minecart;
                            break;
                        }
                        case HOPPER: {
                            item = Items.hopper_minecart;
                            break;
                        }
                        case COMMAND_BLOCK: {
                            item = Items.command_block_minecart;
                            break;
                        }
                        default: {
                            item = Items.minecart;
                            break;
                        }
                    }
                } else if (this.objectMouseOver.entityHit instanceof EntityBoat) {
                    item = Items.boat;
                } else if (this.objectMouseOver.entityHit instanceof EntityArmorStand) {
                    item = Items.armor_stand;
                } else {
                    item = Items.spawn_egg;
                    n = EntityList.getEntityID(this.objectMouseOver.entityHit);
                    bl2 = true;
                    if (!EntityList.entityEggs.containsKey(n)) {
                        return;
                    }
                }
            }
            object2 = this.thePlayer.inventory;
            if (tileEntity == null) {
                ((InventoryPlayer)object2).setCurrentItem(item, n, bl2, bl);
            } else {
                object = this.pickBlockWithNBT(item, n, tileEntity);
                ((InventoryPlayer)object2).setInventorySlotContents(((InventoryPlayer)object2).currentItem, (ItemStack)object);
            }
            if (bl) {
                int n2 = this.thePlayer.inventoryContainer.inventorySlots.size() - 9 + ((InventoryPlayer)object2).currentItem;
                this.playerController.sendSlotPacket(((InventoryPlayer)object2).getStackInSlot(((InventoryPlayer)object2).currentItem), n2);
            }
        }
    }

    private ItemStack pickBlockWithNBT(Item item, int n, TileEntity tileEntity) {
        ItemStack itemStack = new ItemStack(item, 1, n);
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        tileEntity.writeToNBT(nBTTagCompound);
        if (item == Items.skull && nBTTagCompound.hasKey("Owner")) {
            NBTTagCompound nBTTagCompound2 = nBTTagCompound.getCompoundTag("Owner");
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            nBTTagCompound3.setTag("SkullOwner", nBTTagCompound2);
            itemStack.setTagCompound(nBTTagCompound3);
            return itemStack;
        }
        itemStack.setTagInfo("BlockEntityTag", nBTTagCompound);
        NBTTagCompound nBTTagCompound4 = new NBTTagCompound();
        NBTTagList nBTTagList = new NBTTagList();
        nBTTagList.appendTag(new NBTTagString("(+NBT)"));
        nBTTagCompound4.setTag("Lore", nBTTagList);
        itemStack.setTagInfo("display", nBTTagCompound4);
        return itemStack;
    }

    public CrashReport addGraphicsAndWorldToCrashReport(CrashReport crashReport) {
        crashReport.getCategory().addCrashSectionCallable("Launched Version", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return Minecraft.this.launchedVersion;
            }
        });
        crashReport.getCategory().addCrashSectionCallable("LWJGL", new Callable<String>(){

            @Override
            public String call() {
                return Sys.getVersion();
            }
        });
        crashReport.getCategory().addCrashSectionCallable("OpenGL", new Callable<String>(){

            @Override
            public String call() {
                return GL11.glGetString(7937) + " GL version " + GL11.glGetString(7938) + ", " + GL11.glGetString(7936);
            }
        });
        crashReport.getCategory().addCrashSectionCallable("GL Caps", new Callable<String>(){

            @Override
            public String call() {
                return OpenGlHelper.getLogText();
            }
        });
        crashReport.getCategory().addCrashSectionCallable("Using VBOs", new Callable<String>(){

            @Override
            public String call() {
                return Minecraft.this.gameSettings.useVbo ? "Yes" : "No";
            }
        });
        crashReport.getCategory().addCrashSectionCallable("Is Modded", new Callable<String>(){

            @Override
            public String call() throws Exception {
                String string = ClientBrandRetriever.getClientModName();
                return !string.equals("vanilla") ? "Definitely; Client brand changed to '" + string + "'" : (Minecraft.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and client brand is untouched.");
            }
        });
        crashReport.getCategory().addCrashSectionCallable("Type", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return "Client (map_client.txt)";
            }
        });
        crashReport.getCategory().addCrashSectionCallable("Resource Packs", new Callable<String>(){

            @Override
            public String call() throws Exception {
                StringBuilder stringBuilder = new StringBuilder();
                for (String string : Minecraft.this.gameSettings.resourcePacks) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(string);
                    if (!Minecraft.this.gameSettings.incompatibleResourcePacks.contains(string)) continue;
                    stringBuilder.append(" (incompatible)");
                }
                return stringBuilder.toString();
            }
        });
        crashReport.getCategory().addCrashSectionCallable("Current Language", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return Minecraft.this.mcLanguageManager.getCurrentLanguage().toString();
            }
        });
        crashReport.getCategory().addCrashSectionCallable("Profiler Position", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return Minecraft.this.mcProfiler.profilingEnabled ? Minecraft.this.mcProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
        });
        crashReport.getCategory().addCrashSectionCallable("CPU", new Callable<String>(){

            @Override
            public String call() {
                return OpenGlHelper.getCpu();
            }
        });
        if (this.theWorld != null) {
            this.theWorld.addWorldInfoToCrashReport(crashReport);
        }
        return crashReport;
    }

    public static Minecraft getMinecraft() {
        return theMinecraft;
    }

    public ListenableFuture<Object> scheduleResourcesRefresh() {
        return this.addScheduledTask(new Runnable(){

            @Override
            public void run() {
                Minecraft.this.refreshResources();
            }
        });
    }

    @Override
    public void addServerStatsToSnooper(PlayerUsageSnooper playerUsageSnooper) {
        playerUsageSnooper.addClientStat("fps", debugFPS);
        playerUsageSnooper.addClientStat("vsync_enabled", this.gameSettings.enableVsync);
        playerUsageSnooper.addClientStat("display_frequency", Display.getDisplayMode().getFrequency());
        playerUsageSnooper.addClientStat("display_type", this.fullscreen ? "fullscreen" : "windowed");
        playerUsageSnooper.addClientStat("run_time", (MinecraftServer.getCurrentTimeMillis() - playerUsageSnooper.getMinecraftStartTimeMillis()) / 60L * 1000L);
        playerUsageSnooper.addClientStat("current_action", this.getCurrentAction());
        String string = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? "little" : "big";
        playerUsageSnooper.addClientStat("endianness", string);
        playerUsageSnooper.addClientStat("resource_packs", this.mcResourcePackRepository.getRepositoryEntries().size());
        int n = 0;
        for (ResourcePackRepository.Entry entry : this.mcResourcePackRepository.getRepositoryEntries()) {
            playerUsageSnooper.addClientStat("resource_pack[" + n++ + "]", entry.getResourcePackName());
        }
        if (this.theIntegratedServer != null && this.theIntegratedServer.getPlayerUsageSnooper() != null) {
            playerUsageSnooper.addClientStat("snooper_partner", this.theIntegratedServer.getPlayerUsageSnooper().getUniqueID());
        }
    }

    private String getCurrentAction() {
        return this.theIntegratedServer != null ? (this.theIntegratedServer.getPublic() ? "hosting_lan" : "singleplayer") : (this.currentServerData != null ? (this.currentServerData.isOnLAN() ? "playing_lan" : "multiplayer") : "out_of_game");
    }

    @Override
    public void addServerTypeToSnooper(PlayerUsageSnooper playerUsageSnooper) {
        playerUsageSnooper.addStatToSnooper("opengl_version", GL11.glGetString(7938));
        playerUsageSnooper.addStatToSnooper("opengl_vendor", GL11.glGetString(7936));
        playerUsageSnooper.addStatToSnooper("client_brand", ClientBrandRetriever.getClientModName());
        playerUsageSnooper.addStatToSnooper("launched_version", this.launchedVersion);
        ContextCapabilities contextCapabilities = GLContext.getCapabilities();
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_arrays_of_arrays]", contextCapabilities.GL_ARB_arrays_of_arrays);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_base_instance]", contextCapabilities.GL_ARB_base_instance);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_blend_func_extended]", contextCapabilities.GL_ARB_blend_func_extended);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_clear_buffer_object]", contextCapabilities.GL_ARB_clear_buffer_object);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_color_buffer_float]", contextCapabilities.GL_ARB_color_buffer_float);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_compatibility]", contextCapabilities.GL_ARB_compatibility);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_compressed_texture_pixel_storage]", contextCapabilities.GL_ARB_compressed_texture_pixel_storage);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_compute_shader]", contextCapabilities.GL_ARB_compute_shader);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_copy_buffer]", contextCapabilities.GL_ARB_copy_buffer);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_copy_image]", contextCapabilities.GL_ARB_copy_image);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", contextCapabilities.GL_ARB_depth_buffer_float);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_compute_shader]", contextCapabilities.GL_ARB_compute_shader);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_copy_buffer]", contextCapabilities.GL_ARB_copy_buffer);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_copy_image]", contextCapabilities.GL_ARB_copy_image);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", contextCapabilities.GL_ARB_depth_buffer_float);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_depth_clamp]", contextCapabilities.GL_ARB_depth_clamp);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_depth_texture]", contextCapabilities.GL_ARB_depth_texture);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_draw_buffers]", contextCapabilities.GL_ARB_draw_buffers);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_draw_buffers_blend]", contextCapabilities.GL_ARB_draw_buffers_blend);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_draw_elements_base_vertex]", contextCapabilities.GL_ARB_draw_elements_base_vertex);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_draw_indirect]", contextCapabilities.GL_ARB_draw_indirect);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_draw_instanced]", contextCapabilities.GL_ARB_draw_instanced);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_explicit_attrib_location]", contextCapabilities.GL_ARB_explicit_attrib_location);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_explicit_uniform_location]", contextCapabilities.GL_ARB_explicit_uniform_location);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_fragment_layer_viewport]", contextCapabilities.GL_ARB_fragment_layer_viewport);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_fragment_program]", contextCapabilities.GL_ARB_fragment_program);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_fragment_shader]", contextCapabilities.GL_ARB_fragment_shader);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_fragment_program_shadow]", contextCapabilities.GL_ARB_fragment_program_shadow);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_framebuffer_object]", contextCapabilities.GL_ARB_framebuffer_object);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_framebuffer_sRGB]", contextCapabilities.GL_ARB_framebuffer_sRGB);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_geometry_shader4]", contextCapabilities.GL_ARB_geometry_shader4);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_gpu_shader5]", contextCapabilities.GL_ARB_gpu_shader5);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_half_float_pixel]", contextCapabilities.GL_ARB_half_float_pixel);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_half_float_vertex]", contextCapabilities.GL_ARB_half_float_vertex);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_instanced_arrays]", contextCapabilities.GL_ARB_instanced_arrays);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_map_buffer_alignment]", contextCapabilities.GL_ARB_map_buffer_alignment);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_map_buffer_range]", contextCapabilities.GL_ARB_map_buffer_range);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_multisample]", contextCapabilities.GL_ARB_multisample);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_multitexture]", contextCapabilities.GL_ARB_multitexture);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_occlusion_query2]", contextCapabilities.GL_ARB_occlusion_query2);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_pixel_buffer_object]", contextCapabilities.GL_ARB_pixel_buffer_object);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_seamless_cube_map]", contextCapabilities.GL_ARB_seamless_cube_map);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_shader_objects]", contextCapabilities.GL_ARB_shader_objects);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_shader_stencil_export]", contextCapabilities.GL_ARB_shader_stencil_export);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_shader_texture_lod]", contextCapabilities.GL_ARB_shader_texture_lod);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_shadow]", contextCapabilities.GL_ARB_shadow);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_shadow_ambient]", contextCapabilities.GL_ARB_shadow_ambient);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_stencil_texturing]", contextCapabilities.GL_ARB_stencil_texturing);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_sync]", contextCapabilities.GL_ARB_sync);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_tessellation_shader]", contextCapabilities.GL_ARB_tessellation_shader);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_texture_border_clamp]", contextCapabilities.GL_ARB_texture_border_clamp);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_texture_buffer_object]", contextCapabilities.GL_ARB_texture_buffer_object);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_texture_cube_map]", contextCapabilities.GL_ARB_texture_cube_map);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_texture_cube_map_array]", contextCapabilities.GL_ARB_texture_cube_map_array);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_texture_non_power_of_two]", contextCapabilities.GL_ARB_texture_non_power_of_two);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_uniform_buffer_object]", contextCapabilities.GL_ARB_uniform_buffer_object);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_vertex_blend]", contextCapabilities.GL_ARB_vertex_blend);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_vertex_buffer_object]", contextCapabilities.GL_ARB_vertex_buffer_object);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_vertex_program]", contextCapabilities.GL_ARB_vertex_program);
        playerUsageSnooper.addStatToSnooper("gl_caps[ARB_vertex_shader]", contextCapabilities.GL_ARB_vertex_shader);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_bindable_uniform]", contextCapabilities.GL_EXT_bindable_uniform);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_blend_equation_separate]", contextCapabilities.GL_EXT_blend_equation_separate);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_blend_func_separate]", contextCapabilities.GL_EXT_blend_func_separate);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_blend_minmax]", contextCapabilities.GL_EXT_blend_minmax);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_blend_subtract]", contextCapabilities.GL_EXT_blend_subtract);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_draw_instanced]", contextCapabilities.GL_EXT_draw_instanced);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_framebuffer_multisample]", contextCapabilities.GL_EXT_framebuffer_multisample);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_framebuffer_object]", contextCapabilities.GL_EXT_framebuffer_object);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_framebuffer_sRGB]", contextCapabilities.GL_EXT_framebuffer_sRGB);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_geometry_shader4]", contextCapabilities.GL_EXT_geometry_shader4);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_gpu_program_parameters]", contextCapabilities.GL_EXT_gpu_program_parameters);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_gpu_shader4]", contextCapabilities.GL_EXT_gpu_shader4);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_multi_draw_arrays]", contextCapabilities.GL_EXT_multi_draw_arrays);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_packed_depth_stencil]", contextCapabilities.GL_EXT_packed_depth_stencil);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_paletted_texture]", contextCapabilities.GL_EXT_paletted_texture);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_rescale_normal]", contextCapabilities.GL_EXT_rescale_normal);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_separate_shader_objects]", contextCapabilities.GL_EXT_separate_shader_objects);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_shader_image_load_store]", contextCapabilities.GL_EXT_shader_image_load_store);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_shadow_funcs]", contextCapabilities.GL_EXT_shadow_funcs);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_shared_texture_palette]", contextCapabilities.GL_EXT_shared_texture_palette);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_stencil_clear_tag]", contextCapabilities.GL_EXT_stencil_clear_tag);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_stencil_two_side]", contextCapabilities.GL_EXT_stencil_two_side);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_stencil_wrap]", contextCapabilities.GL_EXT_stencil_wrap);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_texture_3d]", contextCapabilities.GL_EXT_texture_3d);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_texture_array]", contextCapabilities.GL_EXT_texture_array);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_texture_buffer_object]", contextCapabilities.GL_EXT_texture_buffer_object);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_texture_integer]", contextCapabilities.GL_EXT_texture_integer);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_texture_lod_bias]", contextCapabilities.GL_EXT_texture_lod_bias);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_texture_sRGB]", contextCapabilities.GL_EXT_texture_sRGB);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_vertex_shader]", contextCapabilities.GL_EXT_vertex_shader);
        playerUsageSnooper.addStatToSnooper("gl_caps[EXT_vertex_weighting]", contextCapabilities.GL_EXT_vertex_weighting);
        playerUsageSnooper.addStatToSnooper("gl_caps[gl_max_vertex_uniforms]", GL11.glGetInteger(35658));
        GL11.glGetError();
        playerUsageSnooper.addStatToSnooper("gl_caps[gl_max_fragment_uniforms]", GL11.glGetInteger(35657));
        GL11.glGetError();
        playerUsageSnooper.addStatToSnooper("gl_caps[gl_max_vertex_attribs]", GL11.glGetInteger(34921));
        GL11.glGetError();
        playerUsageSnooper.addStatToSnooper("gl_caps[gl_max_vertex_texture_image_units]", GL11.glGetInteger(35660));
        GL11.glGetError();
        playerUsageSnooper.addStatToSnooper("gl_caps[gl_max_texture_image_units]", GL11.glGetInteger(34930));
        GL11.glGetError();
        playerUsageSnooper.addStatToSnooper("gl_caps[gl_max_texture_image_units]", GL11.glGetInteger(35071));
        GL11.glGetError();
        playerUsageSnooper.addStatToSnooper("gl_max_texture_size", Minecraft.getGLMaximumTextureSize());
    }

    public static int getGLMaximumTextureSize() {
        for (int i = 16384; i > 0; i >>= 1) {
            GL11.glTexImage2D(32868, 0, 6408, i, i, 0, 6408, 5121, (ByteBuffer)null);
            int n = GL11.glGetTexLevelParameteri(32868, 0, 4096);
            if (n == 0) continue;
            return i;
        }
        return -1;
    }

    @Override
    public boolean isSnooperEnabled() {
        return this.gameSettings.snooperEnabled;
    }

    public void setServerData(ServerData serverData) {
        this.currentServerData = serverData;
    }

    public ServerData getCurrentServerData() {
        return this.currentServerData;
    }

    public boolean isIntegratedServerRunning() {
        return this.integratedServerIsRunning;
    }

    public boolean isSingleplayer() {
        return this.integratedServerIsRunning && this.theIntegratedServer != null;
    }

    public IntegratedServer getIntegratedServer() {
        return this.theIntegratedServer;
    }

    public static void stopIntegratedServer() {
        IntegratedServer integratedServer;
        if (theMinecraft != null && (integratedServer = theMinecraft.getIntegratedServer()) != null) {
            integratedServer.stopServer();
        }
    }

    public PlayerUsageSnooper getPlayerUsageSnooper() {
        return this.usageSnooper;
    }

    public static long getSystemTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    public boolean isFullScreen() {
        return this.fullscreen;
    }

    public Session getSession() {
        return this.session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public PropertyMap getProfileProperties() {
        if (this.profileProperties.isEmpty()) {
            GameProfile gameProfile = this.getSessionService().fillProfileProperties(this.session.getProfile(), false);
            this.profileProperties.putAll(gameProfile.getProperties());
        }
        return this.profileProperties;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public TextureManager getTextureManager() {
        return this.renderEngine;
    }

    public IResourceManager getResourceManager() {
        return this.mcResourceManager;
    }

    public ResourcePackRepository getResourcePackRepository() {
        return this.mcResourcePackRepository;
    }

    public LanguageManager getLanguageManager() {
        return this.mcLanguageManager;
    }

    public TextureMap getTextureMapBlocks() {
        return this.textureMapBlocks;
    }

    public boolean isJava64bit() {
        return this.jvm64bit;
    }

    public boolean isGamePaused() {
        return this.isGamePaused;
    }

    public SoundHandler getSoundHandler() {
        return this.mcSoundHandler;
    }

    public IResourcePack getDefaultResourcePack() {
        return this.mcDefaultResourcePack;
    }

    public MusicTicker.MusicType getAmbientMusicType() {
        return this.thePlayer != null ? (this.thePlayer.worldObj.provider instanceof WorldProviderHell ? MusicTicker.MusicType.NETHER : (this.thePlayer.worldObj.provider instanceof WorldProviderEnd ? (BossStatus.bossName != null && BossStatus.statusBarTime > 0 ? MusicTicker.MusicType.END_BOSS : MusicTicker.MusicType.END) : (this.thePlayer.capabilities.isCreativeMode && this.thePlayer.capabilities.allowFlying ? MusicTicker.MusicType.CREATIVE : MusicTicker.MusicType.GAME))) : MusicTicker.MusicType.MENU;
    }

    public void dispatchKeypresses() {
        int n = Keyboard.getEventKey();
        if (!(n == 0 || Keyboard.isRepeatEvent() || this.currentScreen instanceof GuiControls && ((GuiControls)this.currentScreen).time > Minecraft.getSystemTime() - 20L || !Keyboard.getEventKeyState())) {
            if (n == this.gameSettings.keyBindFullscreen.getKeyCode() && n != 42 && n != 54 && !Keyboard.isKeyDown(42) && !Keyboard.isKeyDown(54)) {
                this.toggleFullscreen();
            } else if (n == this.gameSettings.keyBindScreenshot.getKeyCode()) {
                this.ingameGUI.getChatGUI().printChatMessage(ScreenShotHelper.saveScreenshot(this.mcDataDir, this.displayWidth, this.displayHeight, this.framebufferMc));
            }
        }
    }

    public MinecraftSessionService getSessionService() {
        return this.sessionService;
    }

    public SkinManager getSkinManager() {
        return this.skinManager;
    }

    public Entity getRenderViewEntity() {
        return this.renderViewEntity;
    }

    public void setRenderViewEntity(Entity entity) {
        this.renderViewEntity = entity;
        this.entityRenderer.loadEntityShader(entity);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <V> ListenableFuture<V> addScheduledTask(Callable<V> callable) {
        Validate.notNull(callable);
        if (!this.isCallingFromMinecraftThread()) {
            ListenableFutureTask<V> listenableFutureTask = ListenableFutureTask.create(callable);
            Queue<FutureTask<?>> queue = this.scheduledTasks;
            synchronized (queue) {
                this.scheduledTasks.add(listenableFutureTask);
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
        return this.addScheduledTask(Executors.callable(runnable2));
    }

    @Override
    public boolean isCallingFromMinecraftThread() {
        return Thread.currentThread() == this.mcThread;
    }

    public BlockRendererDispatcher getBlockRendererDispatcher() {
        return this.blockRenderDispatcher;
    }

    public RenderManager getRenderManager() {
        return this.renderManager;
    }

    public RenderItem getRenderItem() {
        return this.renderItem;
    }

    public ItemRenderer getItemRenderer() {
        return this.itemRenderer;
    }

    public static int getDebugFPS() {
        return debugFPS;
    }

    public FrameTimer getFrameTimer() {
        return this.frameTimer;
    }

    public static Map<String, String> getSessionInfo() {
        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put("X-Minecraft-Username", Minecraft.getMinecraft().getSession().getUsername());
        hashMap.put("X-Minecraft-UUID", Minecraft.getMinecraft().getSession().getPlayerID());
        hashMap.put("X-Minecraft-Version", "1.8.9");
        return hashMap;
    }

    public boolean isConnectedToRealms() {
        return this.connectedToRealms;
    }

    public void setConnectedToRealms(boolean bl) {
        this.connectedToRealms = bl;
    }

    public void mimeow$onBeforeGetMouseOver(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new occb36f998dc());
        ocbb165642ef.\u02a8().\u0155();
    }

    public void mimeow$onRunTickMouseOver(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new ocfce21f66a2());
    }

    private oca27090789a mimeow$injectBeforeChatVisibility(ocee33618a8d ocee33618a8d2) {
        oca27090789a oca27090789a2 = new oca27090789a();
        ocea775c9d5c.\u0173.post(oca27090789a2);
        return oca27090789a2;
    }

    private void mimeow$onRunTick(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new oc38a48edfca());
    }

    public void mimeow$onRunGameLoop(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new oc9374123646());
    }

    public void mimeow$injectClickMouse(ocee33618a8d ocee33618a8d2) {
        oc24ebc274b7 oc24ebc274b72 = new oc24ebc274b7(0);
        ocea775c9d5c.\u0173.post(oc24ebc274b72);
        if (oc24ebc274b72.isCanceled()) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
            return;
        }
        MovingObjectPosition movingObjectPosition = this.objectMouseOver;
        oc507025139f oc507025139f2 = new oc507025139f(movingObjectPosition);
        ocea775c9d5c.\u0173.post(oc507025139f2);
        if (oc507025139f2.isCanceled()) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        } else {
            ocea775c9d5c.\u0173.post(new oce040b2baf2());
        }
    }

    public void mimeow$injectRightClickMouse(ocee33618a8d ocee33618a8d2) {
        oc24ebc274b7 oc24ebc274b72 = new oc24ebc274b7(1);
        ocea775c9d5c.\u0173.post(oc24ebc274b72);
        if (oc24ebc274b72.isCanceled()) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
            return;
        }
        oc479681b341 oc479681b3412 = new oc479681b341();
        ocea775c9d5c.\u0173.post(oc479681b3412);
        if (oc479681b3412.isCanceled()) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    public void mimeow$onRunTickStart(ocee33618a8d ocee33618a8d2) {
        if (!oc51fb428ba0.\u01f3()) {
            ocea775c9d5c.\u0173.post(new ocf6b0e5bf86());
        }
    }

    public void mimeow$onRunTickAfterRightClickDelay(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new oc2f2e7502e9());
    }

    private void mimeow$fastMinePassiveBlockHitDelay(ocee33618a8d ocee33618a8d2) {
        ocb754f4cbfb ocb754f4cbfb2;
        oc8edd24b1ed oc8edd24b1ed2 = oc9755810e45.\u03d4;
        if (!(oc8edd24b1ed2 != null && oc8edd24b1ed2.\u0554() || (ocb754f4cbfb2 = oc9755810e45.\u015b) == null)) {
            ocb754f4cbfb2.\u0134(this);
        }
    }

    public void mimeow$onDisplayGuiScreen(GuiScreen guiScreen, ocee33618a8d ocee33618a8d2) {
        boolean bl;
        GuiScreen guiScreen2 = this.currentScreen;
        GuiScreen guiScreen3 = guiScreen;
        boolean bl2 = bl = guiScreen != null;
        if (!bl) {
            guiScreen3 = guiScreen2;
        }
        ocded28ccee0 ocded28ccee02 = new ocded28ccee0(guiScreen3, bl);
        ocea775c9d5c.\u0173.post(ocded28ccee02);
    }

    public void mimeow$redirect$changeCurrentItem(InventoryPlayer inventoryPlayer, int n) {
        occ9a2be31f2 occ9a2be31f22 = new occ9a2be31f2(n, inventoryPlayer.currentItem);
        ocea775c9d5c.\u0173.post(occ9a2be31f22);
        if (!occ9a2be31f22.isCanceled()) {
            inventoryPlayer.changeCurrentItem(n);
        }
    }

    private void mimeow$redirect$onSetThirdPersonView(GameSettings gameSettings, int n) {
        gameSettings.thirdPersonView = n;
    }

    private void mimeow$redirect$onSetCurrentItem(InventoryPlayer inventoryPlayer, int n) {
        oc142aa368f4 oc142aa368f42 = new oc142aa368f4(n);
        ocea775c9d5c.\u0173.post(oc142aa368f42);
        if (!oc142aa368f42.isCanceled()) {
            inventoryPlayer.currentItem = n;
        }
    }

    private void mimeow$initialize(ocee33618a8d ocee33618a8d2) {
        if (!mimeow$initialized) {
            mimeow$initialized = true;
            new oc2cf3d80e17().\u0535();
        }
    }

    private void mimeow$clientTickStart(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new oc9adb807c19(oc110d7f376c.START));
    }

    private void mimeow$clientTickEnd(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new oc9adb807c19(oc110d7f376c.END));
    }

    private void mimeow$renderTickStart(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new ocf923d5a814(oc110d7f376c.START, this.timer.renderPartialTicks));
    }

    private void mimeow$renderTickEnd(ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new ocf923d5a814(oc110d7f376c.END, this.timer.renderPartialTicks));
    }

    private GuiScreen mimeow$guiOpen(GuiScreen guiScreen, ocee33618a8d ocee33618a8d2) {
        ocdf771dc334 ocdf771dc3342 = new ocdf771dc334(guiScreen);
        if (ocea775c9d5c.\u0173.post(ocdf771dc3342)) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
        return ocdf771dc3342.\u0190;
    }

    private void mimeow$worldUnload(WorldClient worldClient, String string, ocee33618a8d ocee33618a8d2) {
        if (this.theWorld != null && this.theWorld != worldClient) {
            ocea775c9d5c.\u0173.post(new ocbab3c9954b(this.theWorld));
        }
    }

    private void mimeow$worldLoad(WorldClient worldClient, String string, ocee33618a8d ocee33618a8d2) {
        if (worldClient != null) {
            ocea775c9d5c.\u0173.post(new oce4fccf5a38(worldClient));
        }
    }

    private boolean mimeow$redirect$nextMouseEvent() {
        while (Mouse.next()) {
            MouseEvent mouseEvent = new MouseEvent();
            mouseEvent.button = Mouse.getEventButton();
            mouseEvent.buttonstate = Mouse.getEventButtonState();
            mouseEvent.dwheel = Mouse.getEventDWheel();
            mouseEvent.dx = Mouse.getEventDX();
            mouseEvent.dy = Mouse.getEventDY();
            mouseEvent.x = Mouse.getEventX();
            mouseEvent.y = Mouse.getEventY();
            mouseEvent.nanoseconds = Mouse.getEventNanoseconds();
            if (ocea775c9d5c.\u0173.post(mouseEvent)) continue;
            return true;
        }
        return false;
    }

    @Override
    public Timer getTimer() {
        return this.timer;
    }

    @Override
    public NetworkManager getMyNetworkManager() {
        return this.myNetworkManager;
    }

    @Override
    public int getRightClickDelayTimer() {
        return this.rightClickDelayTimer;
    }

    @Override
    public void setRightClickDelayTimer(int n) {
        this.rightClickDelayTimer = n;
    }

    @Override
    public void setLeftClickCounter(int n) {
        this.leftClickCounter = n;
    }

    @Override
    public void callRightClickMouse() {
        this.rightClickMouse();
    }

    @Override
    public void callClickMouse() {
        this.clickMouse();
    }

    @Override
    public void invokeDispatchKeypresses() {
        this.dispatchKeypresses();
    }
}

