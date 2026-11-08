/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.settings;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.optifine.ClearWater;
import net.optifine.CustomColors;
import net.optifine.CustomGuis;
import net.optifine.CustomSky;
import net.optifine.DynamicLights;
import net.optifine.Lang;
import net.optifine.NaturalTextures;
import net.optifine.RandomEntities;
import net.optifine.reflect.Reflector;
import net.optifine.shaders.Shaders;
import net.optifine.util.KeyUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GameSettings {
    private static final Logger logger = LogManager.getLogger();
    private static final Gson gson = new Gson();
    private static final ParameterizedType typeListString = new ParameterizedType(){

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{String.class};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    };
    private static final String[] GUISCALES = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
    private static final String[] PARTICLES = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
    private static final String[] AMBIENT_OCCLUSIONS = new String[]{"options.ao.off", "options.ao.min", "options.ao.max"};
    private static final String[] CLOUDS_TYPES = new String[]{"options.off", "options.graphics.fast", "options.graphics.fancy"};
    public float mouseSensitivity = 0.5f;
    public boolean invertMouse;
    public int renderDistanceChunks = -1;
    public boolean viewBobbing = true;
    public boolean anaglyph;
    public boolean fboEnable = true;
    public int limitFramerate = 120;
    public int clouds = 2;
    public boolean fancyGraphics = true;
    public int ambientOcclusion = 2;
    public List<String> resourcePacks = Lists.newArrayList();
    public List<String> incompatibleResourcePacks = Lists.newArrayList();
    public EntityPlayer.EnumChatVisibility chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
    public boolean chatColours = true;
    public boolean chatLinks = true;
    public boolean chatLinksPrompt = true;
    public float chatOpacity = 1.0f;
    public boolean snooperEnabled = true;
    public boolean fullScreen;
    public boolean enableVsync = true;
    public boolean useVbo = false;
    public boolean allowBlockAlternatives = true;
    public boolean reducedDebugInfo = false;
    public boolean hideServerAddress;
    public boolean advancedItemTooltips;
    public boolean pauseOnLostFocus = true;
    private final Set<EnumPlayerModelParts> setModelParts = Sets.newHashSet(EnumPlayerModelParts.values());
    public boolean touchscreen;
    public int overrideWidth;
    public int overrideHeight;
    public boolean heldItemTooltips = true;
    public float chatScale = 1.0f;
    public float chatWidth = 1.0f;
    public float chatHeightUnfocused = 0.44366196f;
    public float chatHeightFocused = 1.0f;
    public boolean showInventoryAchievementHint = true;
    public int mipmapLevels = 4;
    private Map<SoundCategory, Float> mapSoundLevels = Maps.newEnumMap(SoundCategory.class);
    public boolean useNativeTransport = true;
    public boolean entityShadows = true;
    public boolean realmsNotifications = true;
    public KeyBinding keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
    public KeyBinding keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
    public KeyBinding keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
    public KeyBinding keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
    public KeyBinding keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
    public KeyBinding keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
    public KeyBinding keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.movement");
    public KeyBinding keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
    public KeyBinding keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
    public KeyBinding keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.gameplay");
    public KeyBinding keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
    public KeyBinding keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
    public KeyBinding keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
    public KeyBinding keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
    public KeyBinding keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
    public KeyBinding keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
    public KeyBinding keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
    public KeyBinding keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
    public KeyBinding keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
    public KeyBinding keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
    public KeyBinding[] keyBindsHotbar = new KeyBinding[]{new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory")};
    public KeyBinding[] keyBindings;
    protected Minecraft mc;
    private File optionsFile;
    public EnumDifficulty difficulty;
    public boolean hideGUI;
    public int thirdPersonView;
    public boolean showDebugInfo;
    public boolean showDebugProfilerChart;
    public boolean showLagometer;
    public String lastServer = "";
    public boolean smoothCamera;
    public boolean debugCamEnable;
    public float fovSetting = 70.0f;
    public float gammaSetting;
    public float saturation;
    public int guiScale;
    public int particleSetting;
    public String language = "en_US";
    public boolean forceUnicodeFont = false;
    public int ofFogType = 1;
    public float ofFogStart = 0.8f;
    public int ofMipmapType = 0;
    public boolean ofOcclusionFancy = false;
    public boolean ofSmoothFps = false;
    public boolean ofSmoothWorld = Config.isSingleProcessor();
    public boolean ofLazyChunkLoading = Config.isSingleProcessor();
    public boolean ofRenderRegions = false;
    public boolean ofSmartAnimations = false;
    public float ofAoLevel = 1.0f;
    public int ofAaLevel = 0;
    public int ofAfLevel = 1;
    public int ofClouds = 0;
    public float ofCloudsHeight = 0.0f;
    public int ofTrees = 0;
    public int ofRain = 0;
    public int ofDroppedItems = 0;
    public int ofBetterGrass = 3;
    public int ofAutoSaveTicks = 4000;
    public boolean ofLagometer = false;
    public boolean ofProfiler = false;
    public boolean ofShowFps = false;
    public boolean ofWeather = true;
    public boolean ofSky = true;
    public boolean ofStars = true;
    public boolean ofSunMoon = true;
    public int ofVignette = 0;
    public int ofChunkUpdates = 1;
    public boolean ofChunkUpdatesDynamic = false;
    public int ofTime = 0;
    public boolean ofClearWater = false;
    public boolean ofBetterSnow = false;
    public String ofFullscreenMode = "Default";
    public boolean ofSwampColors = true;
    public boolean ofRandomEntities = true;
    public boolean ofSmoothBiomes = true;
    public boolean ofCustomFonts = true;
    public boolean ofCustomColors = true;
    public boolean ofCustomSky = true;
    public boolean ofShowCapes = true;
    public int ofConnectedTextures = 2;
    public boolean ofCustomItems = true;
    public boolean ofNaturalTextures = false;
    public boolean ofEmissiveTextures = true;
    public boolean ofFastMath = false;
    public boolean ofFastRender = false;
    public int ofTranslucentBlocks = 0;
    public boolean ofDynamicFov = true;
    public boolean ofAlternateBlocks = true;
    public int ofDynamicLights = 3;
    public boolean ofCustomEntityModels = true;
    public boolean ofCustomGuis = true;
    public boolean ofShowGlErrors = true;
    public int ofScreenshotSize = 1;
    public int ofAnimatedWater = 0;
    public int ofAnimatedLava = 0;
    public boolean ofAnimatedFire = true;
    public boolean ofAnimatedPortal = true;
    public boolean ofAnimatedRedstone = true;
    public boolean ofAnimatedExplosion = true;
    public boolean ofAnimatedFlame = true;
    public boolean ofAnimatedSmoke = true;
    public boolean ofVoidParticles = true;
    public boolean ofWaterParticles = true;
    public boolean ofRainSplash = true;
    public boolean ofPortalParticles = true;
    public boolean ofPotionParticles = true;
    public boolean ofFireworkParticles = true;
    public boolean ofDrippingWaterLava = true;
    public boolean ofAnimatedTerrain = true;
    public boolean ofAnimatedTextures = true;
    public static final int DEFAULT = 0;
    public static final int FAST = 1;
    public static final int FANCY = 2;
    public static final int OFF = 3;
    public static final int SMART = 4;
    public static final int ANIM_ON = 0;
    public static final int ANIM_GENERATED = 1;
    public static final int ANIM_OFF = 2;
    public static final String DEFAULT_STR = "Default";
    private static final int[] OF_TREES_VALUES = new int[]{0, 1, 4, 2};
    private static final int[] OF_DYNAMIC_LIGHTS = new int[]{3, 1, 2};
    private static final String[] KEYS_DYNAMIC_LIGHTS = new String[]{"options.off", "options.graphics.fast", "options.graphics.fancy"};
    public KeyBinding ofKeyBindZoom;
    private File optionsFileOF;

    public GameSettings(Minecraft minecraft, File file) {
        this.keyBindings = ArrayUtils.addAll(new KeyBinding[]{this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindSprint, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindFullscreen, this.keyBindSpectatorOutlines}, this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.mc = minecraft;
        this.optionsFile = new File(file, "options.txt");
        if (minecraft.isJava64bit() && Runtime.getRuntime().maxMemory() >= 1000000000L) {
            Options.RENDER_DISTANCE.setValueMax(32.0f);
            long l = 1000000L;
            if (Runtime.getRuntime().maxMemory() >= 1500L * l) {
                Options.RENDER_DISTANCE.setValueMax(48.0f);
            }
            if (Runtime.getRuntime().maxMemory() >= 2500L * l) {
                Options.RENDER_DISTANCE.setValueMax(64.0f);
            }
        } else {
            Options.RENDER_DISTANCE.setValueMax(16.0f);
        }
        this.renderDistanceChunks = minecraft.isJava64bit() ? 12 : 8;
        this.optionsFileOF = new File(file, "optionsof.txt");
        this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
        this.ofKeyBindZoom = new KeyBinding("of.key.zoom", 46, "key.categories.misc");
        this.keyBindings = ArrayUtils.add(this.keyBindings, this.ofKeyBindZoom);
        KeyUtils.fixKeyConflicts(this.keyBindings, new KeyBinding[]{this.ofKeyBindZoom});
        this.renderDistanceChunks = 8;
        this.loadOptions();
        Config.initGameSettings(this);
    }

    public GameSettings() {
        this.keyBindings = ArrayUtils.addAll(new KeyBinding[]{this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindSprint, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindFullscreen, this.keyBindSpectatorOutlines}, this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
    }

    public static String getKeyDisplayString(int n) {
        return n < 0 ? I18n.format("key.mouseButton", n + 101) : (n < 256 ? Keyboard.getKeyName(n) : String.format("%c", Character.valueOf((char)(n - 256))).toUpperCase());
    }

    public static boolean isKeyDown(KeyBinding keyBinding) {
        return keyBinding.getKeyCode() == 0 ? false : (keyBinding.getKeyCode() < 0 ? Mouse.isButtonDown(keyBinding.getKeyCode() + 100) : Keyboard.isKeyDown(keyBinding.getKeyCode()));
    }

    public void setOptionKeyBinding(KeyBinding keyBinding, int n) {
        keyBinding.setKeyCode(n);
        this.saveOptions();
    }

    public void setOptionFloatValue(Options options, float f) {
        this.setOptionFloatValueOF(options, f);
        if (options == Options.SENSITIVITY) {
            this.mouseSensitivity = f;
        }
        if (options == Options.FOV) {
            this.fovSetting = f;
        }
        if (options == Options.GAMMA) {
            this.gammaSetting = f;
        }
        if (options == Options.FRAMERATE_LIMIT) {
            this.limitFramerate = (int)f;
            this.enableVsync = false;
            if (this.limitFramerate <= 0) {
                this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                this.enableVsync = true;
            }
            this.updateVSync();
        }
        if (options == Options.CHAT_OPACITY) {
            this.chatOpacity = f;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (options == Options.CHAT_HEIGHT_FOCUSED) {
            this.chatHeightFocused = f;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (options == Options.CHAT_HEIGHT_UNFOCUSED) {
            this.chatHeightUnfocused = f;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (options == Options.CHAT_WIDTH) {
            this.chatWidth = f;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (options == Options.CHAT_SCALE) {
            this.chatScale = f;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (options == Options.MIPMAP_LEVELS) {
            int n = this.mipmapLevels;
            this.mipmapLevels = (int)f;
            if ((float)n != f) {
                this.mc.getTextureMapBlocks().setMipmapLevels(this.mipmapLevels);
                this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                this.mc.getTextureMapBlocks().setBlurMipmapDirect(false, this.mipmapLevels > 0);
                this.mc.scheduleResourcesRefresh();
            }
        }
        if (options == Options.BLOCK_ALTERNATIVES) {
            this.allowBlockAlternatives = !this.allowBlockAlternatives;
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.RENDER_DISTANCE) {
            this.renderDistanceChunks = (int)f;
            this.mc.renderGlobal.setDisplayListEntitiesDirty();
        }
    }

    public void setOptionValue(Options options, int n) {
        this.setOptionValueOF(options, n);
        if (options == Options.INVERT_MOUSE) {
            boolean bl = this.invertMouse = !this.invertMouse;
        }
        if (options == Options.GUI_SCALE) {
            this.guiScale += n;
            if (GuiScreen.isShiftKeyDown()) {
                this.guiScale = 0;
            }
            DisplayMode displayMode = Config.getLargestDisplayMode();
            int n2 = displayMode.getWidth() / 320;
            int n3 = displayMode.getHeight() / 240;
            int n4 = Math.min(n2, n3);
            if (this.guiScale < 0) {
                this.guiScale = n4 - 1;
            }
            if (this.mc.isUnicode() && this.guiScale % 2 != 0) {
                this.guiScale += n;
            }
            if (this.guiScale < 0 || this.guiScale >= n4) {
                this.guiScale = 0;
            }
        }
        if (options == Options.PARTICLES) {
            this.particleSetting = (this.particleSetting + n) % 3;
        }
        if (options == Options.VIEW_BOBBING) {
            boolean bl = this.viewBobbing = !this.viewBobbing;
        }
        if (options == Options.RENDER_CLOUDS) {
            this.clouds = (this.clouds + n) % 3;
        }
        if (options == Options.FORCE_UNICODE_FONT) {
            this.forceUnicodeFont = !this.forceUnicodeFont;
            this.mc.fontRendererObj.setUnicodeFlag(this.mc.getLanguageManager().isCurrentLocaleUnicode() || this.forceUnicodeFont);
        }
        if (options == Options.FBO_ENABLE) {
            boolean bl = this.fboEnable = !this.fboEnable;
        }
        if (options == Options.ANAGLYPH) {
            if (!this.anaglyph && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.an.shaders1"), Lang.get("of.message.an.shaders2"));
                return;
            }
            this.anaglyph = !this.anaglyph;
            this.mc.refreshResources();
        }
        if (options == Options.GRAPHICS) {
            this.fancyGraphics = !this.fancyGraphics;
            this.updateRenderClouds();
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.AMBIENT_OCCLUSION) {
            this.ambientOcclusion = (this.ambientOcclusion + n) % 3;
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.CHAT_VISIBILITY) {
            this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility((this.chatVisibility.getChatVisibility() + n) % 3);
        }
        if (options == Options.CHAT_COLOR) {
            boolean bl = this.chatColours = !this.chatColours;
        }
        if (options == Options.CHAT_LINKS) {
            boolean bl = this.chatLinks = !this.chatLinks;
        }
        if (options == Options.CHAT_LINKS_PROMPT) {
            boolean bl = this.chatLinksPrompt = !this.chatLinksPrompt;
        }
        if (options == Options.SNOOPER_ENABLED) {
            boolean bl = this.snooperEnabled = !this.snooperEnabled;
        }
        if (options == Options.TOUCHSCREEN) {
            boolean bl = this.touchscreen = !this.touchscreen;
        }
        if (options == Options.USE_FULLSCREEN) {
            boolean bl = this.fullScreen = !this.fullScreen;
            if (this.mc.isFullScreen() != this.fullScreen) {
                this.mc.toggleFullscreen();
            }
        }
        if (options == Options.ENABLE_VSYNC) {
            this.enableVsync = !this.enableVsync;
            Display.setVSyncEnabled(this.enableVsync);
        }
        if (options == Options.USE_VBO) {
            this.useVbo = !this.useVbo;
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.BLOCK_ALTERNATIVES) {
            this.allowBlockAlternatives = !this.allowBlockAlternatives;
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.REDUCED_DEBUG_INFO) {
            boolean bl = this.reducedDebugInfo = !this.reducedDebugInfo;
        }
        if (options == Options.ENTITY_SHADOWS) {
            boolean bl = this.entityShadows = !this.entityShadows;
        }
        if (options == Options.REALMS_NOTIFICATIONS) {
            this.realmsNotifications = !this.realmsNotifications;
        }
        this.saveOptions();
    }

    public float getOptionFloatValue(Options options) {
        float f = this.getOptionFloatValueOF(options);
        if (f != Float.MAX_VALUE) {
            return f;
        }
        switch (options) {
            case FOV: {
                return this.fovSetting;
            }
            case GAMMA: {
                return this.gammaSetting;
            }
            case SATURATION: {
                return this.saturation;
            }
            case SENSITIVITY: {
                return this.mouseSensitivity;
            }
            case CHAT_OPACITY: {
                return this.chatOpacity;
            }
            case CHAT_HEIGHT_FOCUSED: {
                return this.chatHeightFocused;
            }
            case CHAT_HEIGHT_UNFOCUSED: {
                return this.chatHeightUnfocused;
            }
            case CHAT_SCALE: {
                return this.chatScale;
            }
            case CHAT_WIDTH: {
                return this.chatWidth;
            }
            case FRAMERATE_LIMIT: {
                return this.limitFramerate;
            }
            case MIPMAP_LEVELS: {
                return this.mipmapLevels;
            }
            case RENDER_DISTANCE: {
                return this.renderDistanceChunks;
            }
        }
        return 0.0f;
    }

    public boolean getOptionOrdinalValue(Options options) {
        switch (options) {
            case INVERT_MOUSE: {
                return this.invertMouse;
            }
            case VIEW_BOBBING: {
                return this.viewBobbing;
            }
            case ANAGLYPH: {
                return this.anaglyph;
            }
            case FBO_ENABLE: {
                return this.fboEnable;
            }
            case CHAT_COLOR: {
                return this.chatColours;
            }
            case CHAT_LINKS: {
                return this.chatLinks;
            }
            case CHAT_LINKS_PROMPT: {
                return this.chatLinksPrompt;
            }
            case SNOOPER_ENABLED: {
                return this.snooperEnabled;
            }
            case USE_FULLSCREEN: {
                return this.fullScreen;
            }
            case ENABLE_VSYNC: {
                return this.enableVsync;
            }
            case USE_VBO: {
                return this.useVbo;
            }
            case TOUCHSCREEN: {
                return this.touchscreen;
            }
            case FORCE_UNICODE_FONT: {
                return this.forceUnicodeFont;
            }
            case BLOCK_ALTERNATIVES: {
                return this.allowBlockAlternatives;
            }
            case REDUCED_DEBUG_INFO: {
                return this.reducedDebugInfo;
            }
            case ENTITY_SHADOWS: {
                return this.entityShadows;
            }
            case REALMS_NOTIFICATIONS: {
                return this.realmsNotifications;
            }
        }
        return false;
    }

    private static String getTranslation(String[] stringArray, int n) {
        if (n < 0 || n >= stringArray.length) {
            n = 0;
        }
        return I18n.format(stringArray[n], new Object[0]);
    }

    public String getKeyBinding(Options options) {
        String string = this.getKeyBindingOF(options);
        if (string != null) {
            return string;
        }
        String string2 = I18n.format(options.getEnumString(), new Object[0]) + ": ";
        if (options.getEnumFloat()) {
            float f = this.getOptionFloatValue(options);
            float f2 = options.normalizeValue(f);
            if (options == Options.MIPMAP_LEVELS && (double)f >= 4.0) {
                return string2 + Lang.get("of.general.max");
            }
            if (options == Options.SENSITIVITY) {
                return f2 == 0.0f ? string2 + I18n.format("options.sensitivity.min", new Object[0]) : (f2 == 1.0f ? string2 + I18n.format("options.sensitivity.max", new Object[0]) : string2 + (int)(f2 * 200.0f) + "%");
            }
            if (options == Options.FOV) {
                return f == 70.0f ? string2 + I18n.format("options.fov.min", new Object[0]) : (f == 110.0f ? string2 + I18n.format("options.fov.max", new Object[0]) : string2 + (int)f);
            }
            if (options == Options.FRAMERATE_LIMIT) {
                return f == options.valueMax ? string2 + I18n.format("options.framerateLimit.max", new Object[0]) : string2 + (int)f + " fps";
            }
            if (options == Options.RENDER_CLOUDS) {
                return f == options.valueMin ? string2 + I18n.format("options.cloudHeight.min", new Object[0]) : string2 + ((int)f + 128);
            }
            if (options == Options.GAMMA) {
                return f2 == 0.0f ? string2 + I18n.format("options.gamma.min", new Object[0]) : (f2 == 1.0f ? string2 + I18n.format("options.gamma.max", new Object[0]) : string2 + "+" + (int)(f2 * 100.0f) + "%");
            }
            if (options == Options.SATURATION) {
                return string2 + (int)(f2 * 400.0f) + "%";
            }
            if (options == Options.CHAT_OPACITY) {
                return string2 + (int)(f2 * 90.0f + 10.0f) + "%";
            }
            if (options == Options.CHAT_HEIGHT_UNFOCUSED || options == Options.CHAT_HEIGHT_FOCUSED) {
                return string2 + GuiNewChat.calculateChatboxHeight(f2) + "px";
            }
            if (options == Options.CHAT_WIDTH) {
                return string2 + GuiNewChat.calculateChatboxWidth(f2) + "px";
            }
            if (options == Options.RENDER_DISTANCE) {
                return string2 + (int)f + " chunks";
            }
            if (options == Options.MIPMAP_LEVELS) {
                return f == 0.0f ? string2 + I18n.format("options.off", new Object[0]) : string2 + (int)f;
            }
            return f2 == 0.0f ? string2 + I18n.format("options.off", new Object[0]) : string2 + (int)(f2 * 100.0f) + "%";
        }
        if (options.getEnumBoolean()) {
            boolean bl = this.getOptionOrdinalValue(options);
            return bl ? string2 + I18n.format("options.on", new Object[0]) : string2 + I18n.format("options.off", new Object[0]);
        }
        if (options == Options.GUI_SCALE) {
            return this.guiScale >= GUISCALES.length ? string2 + this.guiScale + "x" : string2 + GameSettings.getTranslation(GUISCALES, this.guiScale);
        }
        if (options == Options.CHAT_VISIBILITY) {
            return string2 + I18n.format(this.chatVisibility.getResourceKey(), new Object[0]);
        }
        if (options == Options.PARTICLES) {
            return string2 + GameSettings.getTranslation(PARTICLES, this.particleSetting);
        }
        if (options == Options.AMBIENT_OCCLUSION) {
            return string2 + GameSettings.getTranslation(AMBIENT_OCCLUSIONS, this.ambientOcclusion);
        }
        if (options == Options.RENDER_CLOUDS) {
            return string2 + GameSettings.getTranslation(CLOUDS_TYPES, this.clouds);
        }
        if (options == Options.GRAPHICS) {
            if (this.fancyGraphics) {
                return string2 + I18n.format("options.graphics.fancy", new Object[0]);
            }
            String string3 = "options.graphics.fast";
            return string2 + I18n.format("options.graphics.fast", new Object[0]);
        }
        return string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void loadOptions() {
        block70: {
            FileInputStream fileInputStream = null;
            try {
                if (this.optionsFile.exists()) {
                    fileInputStream = new FileInputStream(this.optionsFile);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    String string = "";
                    this.mapSoundLevels.clear();
                    while ((string = bufferedReader.readLine()) != null) {
                        try {
                            String[] stringArray = string.split(":");
                            if (stringArray[0].equals("mouseSensitivity")) {
                                this.mouseSensitivity = this.parseFloat(stringArray[1]);
                            }
                            if (stringArray[0].equals("fov")) {
                                this.fovSetting = this.parseFloat(stringArray[1]) * 40.0f + 70.0f;
                            }
                            if (stringArray[0].equals("gamma")) {
                                this.gammaSetting = this.parseFloat(stringArray[1]);
                            }
                            if (stringArray[0].equals("saturation")) {
                                this.saturation = this.parseFloat(stringArray[1]);
                            }
                            if (stringArray[0].equals("invertYMouse")) {
                                this.invertMouse = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("renderDistance")) {
                                this.renderDistanceChunks = Integer.parseInt(stringArray[1]);
                            }
                            if (stringArray[0].equals("guiScale")) {
                                this.guiScale = Integer.parseInt(stringArray[1]);
                            }
                            if (stringArray[0].equals("particles")) {
                                this.particleSetting = Integer.parseInt(stringArray[1]);
                            }
                            if (stringArray[0].equals("bobView")) {
                                this.viewBobbing = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("anaglyph3d")) {
                                this.anaglyph = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("maxFps")) {
                                this.limitFramerate = Integer.parseInt(stringArray[1]);
                                if (this.enableVsync) {
                                    this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                                }
                                if (this.limitFramerate <= 0) {
                                    this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                                }
                            }
                            if (stringArray[0].equals("fboEnable")) {
                                this.fboEnable = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("difficulty")) {
                                this.difficulty = EnumDifficulty.getDifficultyEnum(Integer.parseInt(stringArray[1]));
                            }
                            if (stringArray[0].equals("fancyGraphics")) {
                                this.fancyGraphics = stringArray[1].equals("true");
                                this.updateRenderClouds();
                            }
                            if (stringArray[0].equals("ao")) {
                                this.ambientOcclusion = stringArray[1].equals("true") ? 2 : (stringArray[1].equals("false") ? 0 : Integer.parseInt(stringArray[1]));
                            }
                            if (stringArray[0].equals("renderClouds")) {
                                if (stringArray[1].equals("true")) {
                                    this.clouds = 2;
                                } else if (stringArray[1].equals("false")) {
                                    this.clouds = 0;
                                } else if (stringArray[1].equals("fast")) {
                                    this.clouds = 1;
                                }
                            }
                            if (stringArray[0].equals("resourcePacks")) {
                                this.resourcePacks = (List)gson.fromJson(string.substring(string.indexOf(58) + 1), (Type)typeListString);
                                if (this.resourcePacks == null) {
                                    this.resourcePacks = Lists.newArrayList();
                                }
                            }
                            if (stringArray[0].equals("incompatibleResourcePacks")) {
                                this.incompatibleResourcePacks = (List)gson.fromJson(string.substring(string.indexOf(58) + 1), (Type)typeListString);
                                if (this.incompatibleResourcePacks == null) {
                                    this.incompatibleResourcePacks = Lists.newArrayList();
                                }
                            }
                            if (stringArray[0].equals("lastServer") && stringArray.length >= 2) {
                                this.lastServer = string.substring(string.indexOf(58) + 1);
                            }
                            if (stringArray[0].equals("lang") && stringArray.length >= 2) {
                                this.language = stringArray[1];
                            }
                            if (stringArray[0].equals("chatVisibility")) {
                                this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility(Integer.parseInt(stringArray[1]));
                            }
                            if (stringArray[0].equals("chatColors")) {
                                this.chatColours = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("chatLinks")) {
                                this.chatLinks = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("chatLinksPrompt")) {
                                this.chatLinksPrompt = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("chatOpacity")) {
                                this.chatOpacity = this.parseFloat(stringArray[1]);
                            }
                            if (stringArray[0].equals("snooperEnabled")) {
                                this.snooperEnabled = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("fullscreen")) {
                                this.fullScreen = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("enableVsync")) {
                                this.enableVsync = stringArray[1].equals("true");
                                if (this.enableVsync) {
                                    this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                                }
                                this.updateVSync();
                            }
                            if (stringArray[0].equals("useVbo")) {
                                this.useVbo = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("hideServerAddress")) {
                                this.hideServerAddress = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("advancedItemTooltips")) {
                                this.advancedItemTooltips = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("pauseOnLostFocus")) {
                                this.pauseOnLostFocus = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("touchscreen")) {
                                this.touchscreen = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("overrideHeight")) {
                                this.overrideHeight = Integer.parseInt(stringArray[1]);
                            }
                            if (stringArray[0].equals("overrideWidth")) {
                                this.overrideWidth = Integer.parseInt(stringArray[1]);
                            }
                            if (stringArray[0].equals("heldItemTooltips")) {
                                this.heldItemTooltips = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("chatHeightFocused")) {
                                this.chatHeightFocused = this.parseFloat(stringArray[1]);
                            }
                            if (stringArray[0].equals("chatHeightUnfocused")) {
                                this.chatHeightUnfocused = this.parseFloat(stringArray[1]);
                            }
                            if (stringArray[0].equals("chatScale")) {
                                this.chatScale = this.parseFloat(stringArray[1]);
                            }
                            if (stringArray[0].equals("chatWidth")) {
                                this.chatWidth = this.parseFloat(stringArray[1]);
                            }
                            if (stringArray[0].equals("showInventoryAchievementHint")) {
                                this.showInventoryAchievementHint = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("mipmapLevels")) {
                                this.mipmapLevels = Integer.parseInt(stringArray[1]);
                            }
                            if (stringArray[0].equals("forceUnicodeFont")) {
                                this.forceUnicodeFont = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("allowBlockAlternatives")) {
                                this.allowBlockAlternatives = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("reducedDebugInfo")) {
                                this.reducedDebugInfo = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("useNativeTransport")) {
                                this.useNativeTransport = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("entityShadows")) {
                                this.entityShadows = stringArray[1].equals("true");
                            }
                            if (stringArray[0].equals("realmsNotifications")) {
                                this.realmsNotifications = stringArray[1].equals("true");
                            }
                            for (KeyBinding keyBinding : this.keyBindings) {
                                if (!stringArray[0].equals("key_" + keyBinding.getKeyDescription())) continue;
                                keyBinding.setKeyCode(Integer.parseInt(stringArray[1]));
                            }
                            for (SoundCategory soundCategory : SoundCategory.values()) {
                                if (!stringArray[0].equals("soundCategory_" + soundCategory.getCategoryName())) continue;
                                this.mapSoundLevels.put(soundCategory, Float.valueOf(this.parseFloat(stringArray[1])));
                            }
                            for (EnumPlayerModelParts enumPlayerModelParts : EnumPlayerModelParts.values()) {
                                if (!stringArray[0].equals("modelPart_" + enumPlayerModelParts.getPartName())) continue;
                                this.setModelPartEnabled(enumPlayerModelParts, stringArray[1].equals("true"));
                            }
                        }
                        catch (Exception exception) {
                            logger.warn("Skipping bad option: " + string);
                            exception.printStackTrace();
                        }
                    }
                    KeyBinding.resetKeyBindingArrayAndHash();
                    bufferedReader.close();
                    IOUtils.closeQuietly(fileInputStream);
                    break block70;
                }
                IOUtils.closeQuietly(fileInputStream);
            }
            catch (Exception exception) {
                logger.error("Failed to load options", (Throwable)exception);
                break block70;
            }
            finally {
                IOUtils.closeQuietly(fileInputStream);
            }
            return;
        }
        this.loadOfOptions();
    }

    private float parseFloat(String string) {
        return string.equals("true") ? 1.0f : (string.equals("false") ? 0.0f : Float.parseFloat(string));
    }

    public void saveOptions() {
        Object object;
        if (Reflector.OptionalLoaderClientHandler.exists() && (object = Reflector.call(Reflector.OptionalLoaderClientHandler_instance, new Object[0])) != null && Reflector.callBoolean(object, Reflector.OptionalLoaderClientHandler_isLoading, new Object[0])) {
            return;
        }
        try {
            object = new PrintWriter(new FileWriter(this.optionsFile));
            ((PrintWriter)object).println("invertYMouse:" + this.invertMouse);
            ((PrintWriter)object).println("mouseSensitivity:" + this.mouseSensitivity);
            ((PrintWriter)object).println("fov:" + (this.fovSetting - 70.0f) / 40.0f);
            ((PrintWriter)object).println("gamma:" + this.gammaSetting);
            ((PrintWriter)object).println("saturation:" + this.saturation);
            ((PrintWriter)object).println("renderDistance:" + this.renderDistanceChunks);
            ((PrintWriter)object).println("guiScale:" + this.guiScale);
            ((PrintWriter)object).println("particles:" + this.particleSetting);
            ((PrintWriter)object).println("bobView:" + this.viewBobbing);
            ((PrintWriter)object).println("anaglyph3d:" + this.anaglyph);
            ((PrintWriter)object).println("maxFps:" + this.limitFramerate);
            ((PrintWriter)object).println("fboEnable:" + this.fboEnable);
            ((PrintWriter)object).println("difficulty:" + this.difficulty.getDifficultyId());
            ((PrintWriter)object).println("fancyGraphics:" + this.fancyGraphics);
            ((PrintWriter)object).println("ao:" + this.ambientOcclusion);
            switch (this.clouds) {
                case 0: {
                    ((PrintWriter)object).println("renderClouds:false");
                    break;
                }
                case 1: {
                    ((PrintWriter)object).println("renderClouds:fast");
                    break;
                }
                case 2: {
                    ((PrintWriter)object).println("renderClouds:true");
                }
            }
            ((PrintWriter)object).println("resourcePacks:" + gson.toJson(this.resourcePacks));
            ((PrintWriter)object).println("incompatibleResourcePacks:" + gson.toJson(this.incompatibleResourcePacks));
            ((PrintWriter)object).println("lastServer:" + this.lastServer);
            ((PrintWriter)object).println("lang:" + this.language);
            ((PrintWriter)object).println("chatVisibility:" + this.chatVisibility.getChatVisibility());
            ((PrintWriter)object).println("chatColors:" + this.chatColours);
            ((PrintWriter)object).println("chatLinks:" + this.chatLinks);
            ((PrintWriter)object).println("chatLinksPrompt:" + this.chatLinksPrompt);
            ((PrintWriter)object).println("chatOpacity:" + this.chatOpacity);
            ((PrintWriter)object).println("snooperEnabled:" + this.snooperEnabled);
            ((PrintWriter)object).println("fullscreen:" + this.fullScreen);
            ((PrintWriter)object).println("enableVsync:" + this.enableVsync);
            ((PrintWriter)object).println("useVbo:" + this.useVbo);
            ((PrintWriter)object).println("hideServerAddress:" + this.hideServerAddress);
            ((PrintWriter)object).println("advancedItemTooltips:" + this.advancedItemTooltips);
            ((PrintWriter)object).println("pauseOnLostFocus:" + this.pauseOnLostFocus);
            ((PrintWriter)object).println("touchscreen:" + this.touchscreen);
            ((PrintWriter)object).println("overrideWidth:" + this.overrideWidth);
            ((PrintWriter)object).println("overrideHeight:" + this.overrideHeight);
            ((PrintWriter)object).println("heldItemTooltips:" + this.heldItemTooltips);
            ((PrintWriter)object).println("chatHeightFocused:" + this.chatHeightFocused);
            ((PrintWriter)object).println("chatHeightUnfocused:" + this.chatHeightUnfocused);
            ((PrintWriter)object).println("chatScale:" + this.chatScale);
            ((PrintWriter)object).println("chatWidth:" + this.chatWidth);
            ((PrintWriter)object).println("showInventoryAchievementHint:" + this.showInventoryAchievementHint);
            ((PrintWriter)object).println("mipmapLevels:" + this.mipmapLevels);
            ((PrintWriter)object).println("forceUnicodeFont:" + this.forceUnicodeFont);
            ((PrintWriter)object).println("allowBlockAlternatives:" + this.allowBlockAlternatives);
            ((PrintWriter)object).println("reducedDebugInfo:" + this.reducedDebugInfo);
            ((PrintWriter)object).println("useNativeTransport:" + this.useNativeTransport);
            ((PrintWriter)object).println("entityShadows:" + this.entityShadows);
            ((PrintWriter)object).println("realmsNotifications:" + this.realmsNotifications);
            for (KeyBinding keyBinding : this.keyBindings) {
                ((PrintWriter)object).println("key_" + keyBinding.getKeyDescription() + ":" + keyBinding.getKeyCode());
            }
            for (SoundCategory soundCategory : SoundCategory.values()) {
                ((PrintWriter)object).println("soundCategory_" + soundCategory.getCategoryName() + ":" + this.getSoundLevel(soundCategory));
            }
            for (EnumPlayerModelParts enumPlayerModelParts : EnumPlayerModelParts.values()) {
                ((PrintWriter)object).println("modelPart_" + enumPlayerModelParts.getPartName() + ":" + this.setModelParts.contains((Object)enumPlayerModelParts));
            }
            ((PrintWriter)object).close();
        }
        catch (Exception exception) {
            logger.error("Failed to save options", (Throwable)exception);
        }
        this.saveOfOptions();
        this.sendSettingsToServer();
    }

    public float getSoundLevel(SoundCategory soundCategory) {
        return this.mapSoundLevels.containsKey((Object)soundCategory) ? this.mapSoundLevels.get((Object)soundCategory).floatValue() : 1.0f;
    }

    public void setSoundLevel(SoundCategory soundCategory, float f) {
        this.mc.getSoundHandler().setSoundLevel(soundCategory, f);
        this.mapSoundLevels.put(soundCategory, Float.valueOf(f));
    }

    public void sendSettingsToServer() {
        if (this.mc.thePlayer != null) {
            int n = 0;
            for (EnumPlayerModelParts enumPlayerModelParts : this.setModelParts) {
                n |= enumPlayerModelParts.getPartMask();
            }
            this.mc.thePlayer.sendQueue.addToSendQueue(new C15PacketClientSettings(this.language, this.renderDistanceChunks, this.chatVisibility, this.chatColours, n));
        }
    }

    public Set<EnumPlayerModelParts> getModelParts() {
        return ImmutableSet.copyOf(this.setModelParts);
    }

    public void setModelPartEnabled(EnumPlayerModelParts enumPlayerModelParts, boolean bl) {
        if (bl) {
            this.setModelParts.add(enumPlayerModelParts);
        } else {
            this.setModelParts.remove((Object)enumPlayerModelParts);
        }
        this.sendSettingsToServer();
    }

    public void switchModelPartEnabled(EnumPlayerModelParts enumPlayerModelParts) {
        if (!this.getModelParts().contains((Object)enumPlayerModelParts)) {
            this.setModelParts.add(enumPlayerModelParts);
        } else {
            this.setModelParts.remove((Object)enumPlayerModelParts);
        }
        this.sendSettingsToServer();
    }

    public int shouldRenderClouds() {
        return this.renderDistanceChunks >= 4 ? this.clouds : 0;
    }

    public boolean isUsingNativeTransport() {
        return this.useNativeTransport;
    }

    private void setOptionFloatValueOF(Options options, float f) {
        Object[] objectArray;
        int n;
        if (options == Options.CLOUD_HEIGHT) {
            this.ofCloudsHeight = f;
            this.mc.renderGlobal.resetClouds();
        }
        if (options == Options.AO_LEVEL) {
            this.ofAoLevel = f;
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.AA_LEVEL) {
            n = (int)f;
            if (n > 0 && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.aa.shaders1"), Lang.get("of.message.aa.shaders2"));
                return;
            }
            objectArray = new int[]{0, 2, 4, 6, 8, 12, 16};
            this.ofAaLevel = 0;
            for (int i = 0; i < objectArray.length; ++i) {
                if (n < objectArray[i]) continue;
                this.ofAaLevel = (int)objectArray[i];
            }
            this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
        }
        if (options == Options.AF_LEVEL) {
            n = (int)f;
            if (n > 1 && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.af.shaders1"), Lang.get("of.message.af.shaders2"));
                return;
            }
            this.ofAfLevel = 1;
            while (this.ofAfLevel * 2 <= n) {
                this.ofAfLevel *= 2;
            }
            this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
            this.mc.refreshResources();
        }
        if (options == Options.MIPMAP_TYPE) {
            n = (int)f;
            this.ofMipmapType = Config.limit(n, 0, 3);
            this.mc.refreshResources();
        }
        if (options == Options.FULLSCREEN_MODE) {
            n = (int)f - 1;
            objectArray = Config.getDisplayModeNames();
            if (n < 0 || n >= objectArray.length) {
                this.ofFullscreenMode = DEFAULT_STR;
                return;
            }
            this.ofFullscreenMode = objectArray[n];
        }
    }

    private float getOptionFloatValueOF(Options options) {
        if (options == Options.CLOUD_HEIGHT) {
            return this.ofCloudsHeight;
        }
        if (options == Options.AO_LEVEL) {
            return this.ofAoLevel;
        }
        if (options == Options.AA_LEVEL) {
            return this.ofAaLevel;
        }
        if (options == Options.AF_LEVEL) {
            return this.ofAfLevel;
        }
        if (options == Options.MIPMAP_TYPE) {
            return this.ofMipmapType;
        }
        if (options == Options.FRAMERATE_LIMIT) {
            return (float)this.limitFramerate == Options.FRAMERATE_LIMIT.getValueMax() && this.enableVsync ? 0.0f : (float)this.limitFramerate;
        }
        if (options == Options.FULLSCREEN_MODE) {
            if (this.ofFullscreenMode.equals(DEFAULT_STR)) {
                return 0.0f;
            }
            List<String> list = Arrays.asList(Config.getDisplayModeNames());
            int n = list.indexOf(this.ofFullscreenMode);
            return n < 0 ? 0.0f : (float)(n + 1);
        }
        return Float.MAX_VALUE;
    }

    private void setOptionValueOF(Options options, int n) {
        if (options == Options.FOG_FANCY) {
            switch (this.ofFogType) {
                case 1: {
                    this.ofFogType = 2;
                    if (Config.isFancyFogAvailable()) break;
                    this.ofFogType = 3;
                    break;
                }
                case 2: {
                    this.ofFogType = 3;
                    break;
                }
                case 3: {
                    this.ofFogType = 1;
                    break;
                }
                default: {
                    this.ofFogType = 1;
                }
            }
        }
        if (options == Options.FOG_START) {
            this.ofFogStart += 0.2f;
            if (this.ofFogStart > 0.81f) {
                this.ofFogStart = 0.2f;
            }
        }
        if (options == Options.SMOOTH_FPS) {
            boolean bl = this.ofSmoothFps = !this.ofSmoothFps;
        }
        if (options == Options.SMOOTH_WORLD) {
            this.ofSmoothWorld = !this.ofSmoothWorld;
            Config.updateThreadPriorities();
        }
        if (options == Options.CLOUDS) {
            ++this.ofClouds;
            if (this.ofClouds > 3) {
                this.ofClouds = 0;
            }
            this.updateRenderClouds();
            this.mc.renderGlobal.resetClouds();
        }
        if (options == Options.TREES) {
            this.ofTrees = GameSettings.nextValue(this.ofTrees, OF_TREES_VALUES);
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.DROPPED_ITEMS) {
            ++this.ofDroppedItems;
            if (this.ofDroppedItems > 2) {
                this.ofDroppedItems = 0;
            }
        }
        if (options == Options.RAIN) {
            ++this.ofRain;
            if (this.ofRain > 3) {
                this.ofRain = 0;
            }
        }
        if (options == Options.ANIMATED_WATER) {
            ++this.ofAnimatedWater;
            if (this.ofAnimatedWater == 1) {
                ++this.ofAnimatedWater;
            }
            if (this.ofAnimatedWater > 2) {
                this.ofAnimatedWater = 0;
            }
        }
        if (options == Options.ANIMATED_LAVA) {
            ++this.ofAnimatedLava;
            if (this.ofAnimatedLava == 1) {
                ++this.ofAnimatedLava;
            }
            if (this.ofAnimatedLava > 2) {
                this.ofAnimatedLava = 0;
            }
        }
        if (options == Options.ANIMATED_FIRE) {
            boolean bl = this.ofAnimatedFire = !this.ofAnimatedFire;
        }
        if (options == Options.ANIMATED_PORTAL) {
            boolean bl = this.ofAnimatedPortal = !this.ofAnimatedPortal;
        }
        if (options == Options.ANIMATED_REDSTONE) {
            boolean bl = this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
        }
        if (options == Options.ANIMATED_EXPLOSION) {
            boolean bl = this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
        }
        if (options == Options.ANIMATED_FLAME) {
            boolean bl = this.ofAnimatedFlame = !this.ofAnimatedFlame;
        }
        if (options == Options.ANIMATED_SMOKE) {
            boolean bl = this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
        }
        if (options == Options.VOID_PARTICLES) {
            boolean bl = this.ofVoidParticles = !this.ofVoidParticles;
        }
        if (options == Options.WATER_PARTICLES) {
            boolean bl = this.ofWaterParticles = !this.ofWaterParticles;
        }
        if (options == Options.PORTAL_PARTICLES) {
            boolean bl = this.ofPortalParticles = !this.ofPortalParticles;
        }
        if (options == Options.POTION_PARTICLES) {
            boolean bl = this.ofPotionParticles = !this.ofPotionParticles;
        }
        if (options == Options.FIREWORK_PARTICLES) {
            boolean bl = this.ofFireworkParticles = !this.ofFireworkParticles;
        }
        if (options == Options.DRIPPING_WATER_LAVA) {
            boolean bl = this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
        }
        if (options == Options.ANIMATED_TERRAIN) {
            boolean bl = this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
        }
        if (options == Options.ANIMATED_TEXTURES) {
            boolean bl = this.ofAnimatedTextures = !this.ofAnimatedTextures;
        }
        if (options == Options.RAIN_SPLASH) {
            boolean bl = this.ofRainSplash = !this.ofRainSplash;
        }
        if (options == Options.LAGOMETER) {
            boolean bl = this.ofLagometer = !this.ofLagometer;
        }
        if (options == Options.SHOW_FPS) {
            boolean bl = this.ofShowFps = !this.ofShowFps;
        }
        if (options == Options.AUTOSAVE_TICKS) {
            int n2 = 900;
            this.ofAutoSaveTicks = Math.max(this.ofAutoSaveTicks / n2 * n2, n2);
            this.ofAutoSaveTicks *= 2;
            if (this.ofAutoSaveTicks > 32 * n2) {
                this.ofAutoSaveTicks = n2;
            }
        }
        if (options == Options.BETTER_GRASS) {
            ++this.ofBetterGrass;
            if (this.ofBetterGrass > 3) {
                this.ofBetterGrass = 1;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.CONNECTED_TEXTURES) {
            ++this.ofConnectedTextures;
            if (this.ofConnectedTextures > 3) {
                this.ofConnectedTextures = 1;
            }
            if (this.ofConnectedTextures == 2) {
                this.mc.renderGlobal.loadRenderers();
            } else {
                this.mc.refreshResources();
            }
        }
        if (options == Options.WEATHER) {
            boolean bl = this.ofWeather = !this.ofWeather;
        }
        if (options == Options.SKY) {
            boolean bl = this.ofSky = !this.ofSky;
        }
        if (options == Options.STARS) {
            boolean bl = this.ofStars = !this.ofStars;
        }
        if (options == Options.SUN_MOON) {
            boolean bl = this.ofSunMoon = !this.ofSunMoon;
        }
        if (options == Options.VIGNETTE) {
            ++this.ofVignette;
            if (this.ofVignette > 2) {
                this.ofVignette = 0;
            }
        }
        if (options == Options.CHUNK_UPDATES) {
            ++this.ofChunkUpdates;
            if (this.ofChunkUpdates > 5) {
                this.ofChunkUpdates = 1;
            }
        }
        if (options == Options.CHUNK_UPDATES_DYNAMIC) {
            boolean bl = this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
        }
        if (options == Options.TIME) {
            ++this.ofTime;
            if (this.ofTime > 2) {
                this.ofTime = 0;
            }
        }
        if (options == Options.CLEAR_WATER) {
            this.ofClearWater = !this.ofClearWater;
            this.updateWaterOpacity();
        }
        if (options == Options.PROFILER) {
            boolean bl = this.ofProfiler = !this.ofProfiler;
        }
        if (options == Options.BETTER_SNOW) {
            this.ofBetterSnow = !this.ofBetterSnow;
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.SWAMP_COLORS) {
            this.ofSwampColors = !this.ofSwampColors;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.RANDOM_ENTITIES) {
            this.ofRandomEntities = !this.ofRandomEntities;
            RandomEntities.update();
        }
        if (options == Options.SMOOTH_BIOMES) {
            this.ofSmoothBiomes = !this.ofSmoothBiomes;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.CUSTOM_FONTS) {
            this.ofCustomFonts = !this.ofCustomFonts;
            this.mc.fontRendererObj.onResourceManagerReload(Config.getResourceManager());
            this.mc.standardGalacticFontRenderer.onResourceManagerReload(Config.getResourceManager());
        }
        if (options == Options.CUSTOM_COLORS) {
            this.ofCustomColors = !this.ofCustomColors;
            CustomColors.update();
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.CUSTOM_ITEMS) {
            this.ofCustomItems = !this.ofCustomItems;
            this.mc.refreshResources();
        }
        if (options == Options.CUSTOM_SKY) {
            this.ofCustomSky = !this.ofCustomSky;
            CustomSky.update();
        }
        if (options == Options.SHOW_CAPES) {
            boolean bl = this.ofShowCapes = !this.ofShowCapes;
        }
        if (options == Options.NATURAL_TEXTURES) {
            this.ofNaturalTextures = !this.ofNaturalTextures;
            NaturalTextures.update();
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.EMISSIVE_TEXTURES) {
            this.ofEmissiveTextures = !this.ofEmissiveTextures;
            this.mc.refreshResources();
        }
        if (options == Options.FAST_MATH) {
            MathHelper.fastMath = this.ofFastMath = !this.ofFastMath;
        }
        if (options == Options.FAST_RENDER) {
            if (!this.ofFastRender && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.fr.shaders1"), Lang.get("of.message.fr.shaders2"));
                return;
            }
            boolean bl = this.ofFastRender = !this.ofFastRender;
            if (this.ofFastRender) {
                this.mc.entityRenderer.stopUseShader();
            }
            Config.updateFramebufferSize();
        }
        if (options == Options.TRANSLUCENT_BLOCKS) {
            this.ofTranslucentBlocks = this.ofTranslucentBlocks == 0 ? 1 : (this.ofTranslucentBlocks == 1 ? 2 : (this.ofTranslucentBlocks == 2 ? 0 : 0));
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.LAZY_CHUNK_LOADING) {
            boolean bl = this.ofLazyChunkLoading = !this.ofLazyChunkLoading;
        }
        if (options == Options.RENDER_REGIONS) {
            this.ofRenderRegions = !this.ofRenderRegions;
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.SMART_ANIMATIONS) {
            this.ofSmartAnimations = !this.ofSmartAnimations;
            this.mc.renderGlobal.loadRenderers();
        }
        if (options == Options.DYNAMIC_FOV) {
            boolean bl = this.ofDynamicFov = !this.ofDynamicFov;
        }
        if (options == Options.ALTERNATE_BLOCKS) {
            this.ofAlternateBlocks = !this.ofAlternateBlocks;
            this.mc.refreshResources();
        }
        if (options == Options.DYNAMIC_LIGHTS) {
            this.ofDynamicLights = GameSettings.nextValue(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
            DynamicLights.removeLights(this.mc.renderGlobal);
        }
        if (options == Options.SCREENSHOT_SIZE) {
            ++this.ofScreenshotSize;
            if (this.ofScreenshotSize > 4) {
                this.ofScreenshotSize = 1;
            }
            if (!OpenGlHelper.isFramebufferEnabled()) {
                this.ofScreenshotSize = 1;
            }
        }
        if (options == Options.CUSTOM_ENTITY_MODELS) {
            this.ofCustomEntityModels = !this.ofCustomEntityModels;
            this.mc.refreshResources();
        }
        if (options == Options.CUSTOM_GUIS) {
            this.ofCustomGuis = !this.ofCustomGuis;
            CustomGuis.update();
        }
        if (options == Options.SHOW_GL_ERRORS) {
            boolean bl = this.ofShowGlErrors = !this.ofShowGlErrors;
        }
        if (options == Options.HELD_ITEM_TOOLTIPS) {
            boolean bl = this.heldItemTooltips = !this.heldItemTooltips;
        }
        if (options == Options.ADVANCED_TOOLTIPS) {
            this.advancedItemTooltips = !this.advancedItemTooltips;
        }
    }

    private String getKeyBindingOF(Options options) {
        Object object = I18n.format(options.getEnumString(), new Object[0]) + ": ";
        if (object == null) {
            object = options.getEnumString();
        }
        if (options == Options.RENDER_DISTANCE) {
            int n = (int)this.getOptionFloatValue(options);
            String string = I18n.format("options.renderDistance.tiny", new Object[0]);
            int n2 = 2;
            if (n >= 4) {
                string = I18n.format("options.renderDistance.short", new Object[0]);
                n2 = 4;
            }
            if (n >= 8) {
                string = I18n.format("options.renderDistance.normal", new Object[0]);
                n2 = 8;
            }
            if (n >= 16) {
                string = I18n.format("options.renderDistance.far", new Object[0]);
                n2 = 16;
            }
            if (n >= 32) {
                string = Lang.get("of.options.renderDistance.extreme");
                n2 = 32;
            }
            if (n >= 48) {
                string = Lang.get("of.options.renderDistance.insane");
                n2 = 48;
            }
            if (n >= 64) {
                string = Lang.get("of.options.renderDistance.ludicrous");
                n2 = 64;
            }
            int n3 = this.renderDistanceChunks - n2;
            Object object2 = string;
            if (n3 > 0) {
                object2 = string + "+";
            }
            return (String)object + n + " " + (String)object2;
        }
        if (options == Options.FOG_FANCY) {
            switch (this.ofFogType) {
                case 1: {
                    return (String)object + Lang.getFast();
                }
                case 2: {
                    return (String)object + Lang.getFancy();
                }
                case 3: {
                    return (String)object + Lang.getOff();
                }
            }
            return (String)object + Lang.getOff();
        }
        if (options == Options.FOG_START) {
            return (String)object + this.ofFogStart;
        }
        if (options == Options.MIPMAP_TYPE) {
            switch (this.ofMipmapType) {
                case 0: {
                    return (String)object + Lang.get("of.options.mipmap.nearest");
                }
                case 1: {
                    return (String)object + Lang.get("of.options.mipmap.linear");
                }
                case 2: {
                    return (String)object + Lang.get("of.options.mipmap.bilinear");
                }
                case 3: {
                    return (String)object + Lang.get("of.options.mipmap.trilinear");
                }
            }
            return (String)object + "of.options.mipmap.nearest";
        }
        if (options == Options.SMOOTH_FPS) {
            return this.ofSmoothFps ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SMOOTH_WORLD) {
            return this.ofSmoothWorld ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.CLOUDS) {
            switch (this.ofClouds) {
                case 1: {
                    return (String)object + Lang.getFast();
                }
                case 2: {
                    return (String)object + Lang.getFancy();
                }
                case 3: {
                    return (String)object + Lang.getOff();
                }
            }
            return (String)object + Lang.getDefault();
        }
        if (options == Options.TREES) {
            switch (this.ofTrees) {
                case 1: {
                    return (String)object + Lang.getFast();
                }
                case 2: {
                    return (String)object + Lang.getFancy();
                }
                default: {
                    return (String)object + Lang.getDefault();
                }
                case 4: 
            }
            return (String)object + Lang.get("of.general.smart");
        }
        if (options == Options.DROPPED_ITEMS) {
            switch (this.ofDroppedItems) {
                case 1: {
                    return (String)object + Lang.getFast();
                }
                case 2: {
                    return (String)object + Lang.getFancy();
                }
            }
            return (String)object + Lang.getDefault();
        }
        if (options == Options.RAIN) {
            switch (this.ofRain) {
                case 1: {
                    return (String)object + Lang.getFast();
                }
                case 2: {
                    return (String)object + Lang.getFancy();
                }
                case 3: {
                    return (String)object + Lang.getOff();
                }
            }
            return (String)object + Lang.getDefault();
        }
        if (options == Options.ANIMATED_WATER) {
            switch (this.ofAnimatedWater) {
                case 1: {
                    return (String)object + Lang.get("of.options.animation.dynamic");
                }
                case 2: {
                    return (String)object + Lang.getOff();
                }
            }
            return (String)object + Lang.getOn();
        }
        if (options == Options.ANIMATED_LAVA) {
            switch (this.ofAnimatedLava) {
                case 1: {
                    return (String)object + Lang.get("of.options.animation.dynamic");
                }
                case 2: {
                    return (String)object + Lang.getOff();
                }
            }
            return (String)object + Lang.getOn();
        }
        if (options == Options.ANIMATED_FIRE) {
            return this.ofAnimatedFire ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ANIMATED_PORTAL) {
            return this.ofAnimatedPortal ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ANIMATED_REDSTONE) {
            return this.ofAnimatedRedstone ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ANIMATED_EXPLOSION) {
            return this.ofAnimatedExplosion ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ANIMATED_FLAME) {
            return this.ofAnimatedFlame ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ANIMATED_SMOKE) {
            return this.ofAnimatedSmoke ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.VOID_PARTICLES) {
            return this.ofVoidParticles ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.WATER_PARTICLES) {
            return this.ofWaterParticles ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.PORTAL_PARTICLES) {
            return this.ofPortalParticles ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.POTION_PARTICLES) {
            return this.ofPotionParticles ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.FIREWORK_PARTICLES) {
            return this.ofFireworkParticles ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.DRIPPING_WATER_LAVA) {
            return this.ofDrippingWaterLava ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ANIMATED_TERRAIN) {
            return this.ofAnimatedTerrain ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ANIMATED_TEXTURES) {
            return this.ofAnimatedTextures ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.RAIN_SPLASH) {
            return this.ofRainSplash ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.LAGOMETER) {
            return this.ofLagometer ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SHOW_FPS) {
            return this.ofShowFps ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.AUTOSAVE_TICKS) {
            int n = 900;
            return this.ofAutoSaveTicks <= n ? (String)object + Lang.get("of.options.save.45s") : (this.ofAutoSaveTicks <= 2 * n ? (String)object + Lang.get("of.options.save.90s") : (this.ofAutoSaveTicks <= 4 * n ? (String)object + Lang.get("of.options.save.3min") : (this.ofAutoSaveTicks <= 8 * n ? (String)object + Lang.get("of.options.save.6min") : (this.ofAutoSaveTicks <= 16 * n ? (String)object + Lang.get("of.options.save.12min") : (String)object + Lang.get("of.options.save.24min")))));
        }
        if (options == Options.BETTER_GRASS) {
            switch (this.ofBetterGrass) {
                case 1: {
                    return (String)object + Lang.getFast();
                }
                case 2: {
                    return (String)object + Lang.getFancy();
                }
            }
            return (String)object + Lang.getOff();
        }
        if (options == Options.CONNECTED_TEXTURES) {
            switch (this.ofConnectedTextures) {
                case 1: {
                    return (String)object + Lang.getFast();
                }
                case 2: {
                    return (String)object + Lang.getFancy();
                }
            }
            return (String)object + Lang.getOff();
        }
        if (options == Options.WEATHER) {
            return this.ofWeather ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SKY) {
            return this.ofSky ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.STARS) {
            return this.ofStars ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SUN_MOON) {
            return this.ofSunMoon ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.VIGNETTE) {
            switch (this.ofVignette) {
                case 1: {
                    return (String)object + Lang.getFast();
                }
                case 2: {
                    return (String)object + Lang.getFancy();
                }
            }
            return (String)object + Lang.getDefault();
        }
        if (options == Options.CHUNK_UPDATES) {
            return (String)object + this.ofChunkUpdates;
        }
        if (options == Options.CHUNK_UPDATES_DYNAMIC) {
            return this.ofChunkUpdatesDynamic ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.TIME) {
            return this.ofTime == 1 ? (String)object + Lang.get("of.options.time.dayOnly") : (this.ofTime == 2 ? (String)object + Lang.get("of.options.time.nightOnly") : (String)object + Lang.getDefault());
        }
        if (options == Options.CLEAR_WATER) {
            return this.ofClearWater ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.AA_LEVEL) {
            Object object3 = "";
            if (this.ofAaLevel != Config.getAntialiasingLevel()) {
                object3 = " (" + Lang.get("of.general.restart") + ")";
            }
            return this.ofAaLevel == 0 ? (String)object + Lang.getOff() + (String)object3 : (String)object + this.ofAaLevel + (String)object3;
        }
        if (options == Options.AF_LEVEL) {
            return this.ofAfLevel == 1 ? (String)object + Lang.getOff() : (String)object + this.ofAfLevel;
        }
        if (options == Options.PROFILER) {
            return this.ofProfiler ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.BETTER_SNOW) {
            return this.ofBetterSnow ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SWAMP_COLORS) {
            return this.ofSwampColors ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.RANDOM_ENTITIES) {
            return this.ofRandomEntities ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SMOOTH_BIOMES) {
            return this.ofSmoothBiomes ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.CUSTOM_FONTS) {
            return this.ofCustomFonts ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.CUSTOM_COLORS) {
            return this.ofCustomColors ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.CUSTOM_SKY) {
            return this.ofCustomSky ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SHOW_CAPES) {
            return this.ofShowCapes ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.CUSTOM_ITEMS) {
            return this.ofCustomItems ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.NATURAL_TEXTURES) {
            return this.ofNaturalTextures ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.EMISSIVE_TEXTURES) {
            return this.ofEmissiveTextures ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.FAST_MATH) {
            return this.ofFastMath ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.FAST_RENDER) {
            return this.ofFastRender ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.TRANSLUCENT_BLOCKS) {
            return this.ofTranslucentBlocks == 1 ? (String)object + Lang.getFast() : (this.ofTranslucentBlocks == 2 ? (String)object + Lang.getFancy() : (String)object + Lang.getDefault());
        }
        if (options == Options.LAZY_CHUNK_LOADING) {
            return this.ofLazyChunkLoading ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.RENDER_REGIONS) {
            return this.ofRenderRegions ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SMART_ANIMATIONS) {
            return this.ofSmartAnimations ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.DYNAMIC_FOV) {
            return this.ofDynamicFov ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ALTERNATE_BLOCKS) {
            return this.ofAlternateBlocks ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.DYNAMIC_LIGHTS) {
            int n = GameSettings.indexOf(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
            return (String)object + GameSettings.getTranslation(KEYS_DYNAMIC_LIGHTS, n);
        }
        if (options == Options.SCREENSHOT_SIZE) {
            return this.ofScreenshotSize <= 1 ? (String)object + Lang.getDefault() : (String)object + this.ofScreenshotSize + "x";
        }
        if (options == Options.CUSTOM_ENTITY_MODELS) {
            return this.ofCustomEntityModels ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.CUSTOM_GUIS) {
            return this.ofCustomGuis ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.SHOW_GL_ERRORS) {
            return this.ofShowGlErrors ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.FULLSCREEN_MODE) {
            return this.ofFullscreenMode.equals(DEFAULT_STR) ? (String)object + Lang.getDefault() : (String)object + this.ofFullscreenMode;
        }
        if (options == Options.HELD_ITEM_TOOLTIPS) {
            return this.heldItemTooltips ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.ADVANCED_TOOLTIPS) {
            return this.advancedItemTooltips ? (String)object + Lang.getOn() : (String)object + Lang.getOff();
        }
        if (options == Options.FRAMERATE_LIMIT) {
            float f = this.getOptionFloatValue(options);
            return f == 0.0f ? (String)object + Lang.get("of.options.framerateLimit.vsync") : (f == options.valueMax ? (String)object + I18n.format("options.framerateLimit.max", new Object[0]) : (String)object + (int)f + " fps");
        }
        return null;
    }

    public void loadOfOptions() {
        try {
            File file = this.optionsFileOF;
            if (!file.exists()) {
                file = this.optionsFile;
            }
            if (!file.exists()) {
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(file), "UTF-8"));
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                try {
                    String[] stringArray = string.split(":");
                    if (stringArray[0].equals("ofRenderDistanceChunks") && stringArray.length >= 2) {
                        this.renderDistanceChunks = Integer.valueOf(stringArray[1]);
                        this.renderDistanceChunks = Config.limit(this.renderDistanceChunks, 2, 1024);
                    }
                    if (stringArray[0].equals("ofFogType") && stringArray.length >= 2) {
                        this.ofFogType = Integer.valueOf(stringArray[1]);
                        this.ofFogType = Config.limit(this.ofFogType, 1, 3);
                    }
                    if (stringArray[0].equals("ofFogStart") && stringArray.length >= 2) {
                        this.ofFogStart = Float.valueOf(stringArray[1]).floatValue();
                        if (this.ofFogStart < 0.2f) {
                            this.ofFogStart = 0.2f;
                        }
                        if (this.ofFogStart > 0.81f) {
                            this.ofFogStart = 0.8f;
                        }
                    }
                    if (stringArray[0].equals("ofMipmapType") && stringArray.length >= 2) {
                        this.ofMipmapType = Integer.valueOf(stringArray[1]);
                        this.ofMipmapType = Config.limit(this.ofMipmapType, 0, 3);
                    }
                    if (stringArray[0].equals("ofOcclusionFancy") && stringArray.length >= 2) {
                        this.ofOcclusionFancy = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSmoothFps") && stringArray.length >= 2) {
                        this.ofSmoothFps = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSmoothWorld") && stringArray.length >= 2) {
                        this.ofSmoothWorld = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAoLevel") && stringArray.length >= 2) {
                        this.ofAoLevel = Float.valueOf(stringArray[1]).floatValue();
                        this.ofAoLevel = Config.limit(this.ofAoLevel, 0.0f, 1.0f);
                    }
                    if (stringArray[0].equals("ofClouds") && stringArray.length >= 2) {
                        this.ofClouds = Integer.valueOf(stringArray[1]);
                        this.ofClouds = Config.limit(this.ofClouds, 0, 3);
                        this.updateRenderClouds();
                    }
                    if (stringArray[0].equals("ofCloudsHeight") && stringArray.length >= 2) {
                        this.ofCloudsHeight = Float.valueOf(stringArray[1]).floatValue();
                        this.ofCloudsHeight = Config.limit(this.ofCloudsHeight, 0.0f, 1.0f);
                    }
                    if (stringArray[0].equals("ofTrees") && stringArray.length >= 2) {
                        this.ofTrees = Integer.valueOf(stringArray[1]);
                        this.ofTrees = GameSettings.limit(this.ofTrees, OF_TREES_VALUES);
                    }
                    if (stringArray[0].equals("ofDroppedItems") && stringArray.length >= 2) {
                        this.ofDroppedItems = Integer.valueOf(stringArray[1]);
                        this.ofDroppedItems = Config.limit(this.ofDroppedItems, 0, 2);
                    }
                    if (stringArray[0].equals("ofRain") && stringArray.length >= 2) {
                        this.ofRain = Integer.valueOf(stringArray[1]);
                        this.ofRain = Config.limit(this.ofRain, 0, 3);
                    }
                    if (stringArray[0].equals("ofAnimatedWater") && stringArray.length >= 2) {
                        this.ofAnimatedWater = Integer.valueOf(stringArray[1]);
                        this.ofAnimatedWater = Config.limit(this.ofAnimatedWater, 0, 2);
                    }
                    if (stringArray[0].equals("ofAnimatedLava") && stringArray.length >= 2) {
                        this.ofAnimatedLava = Integer.valueOf(stringArray[1]);
                        this.ofAnimatedLava = Config.limit(this.ofAnimatedLava, 0, 2);
                    }
                    if (stringArray[0].equals("ofAnimatedFire") && stringArray.length >= 2) {
                        this.ofAnimatedFire = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedPortal") && stringArray.length >= 2) {
                        this.ofAnimatedPortal = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedRedstone") && stringArray.length >= 2) {
                        this.ofAnimatedRedstone = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedExplosion") && stringArray.length >= 2) {
                        this.ofAnimatedExplosion = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedFlame") && stringArray.length >= 2) {
                        this.ofAnimatedFlame = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedSmoke") && stringArray.length >= 2) {
                        this.ofAnimatedSmoke = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofVoidParticles") && stringArray.length >= 2) {
                        this.ofVoidParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofWaterParticles") && stringArray.length >= 2) {
                        this.ofWaterParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofPortalParticles") && stringArray.length >= 2) {
                        this.ofPortalParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofPotionParticles") && stringArray.length >= 2) {
                        this.ofPotionParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofFireworkParticles") && stringArray.length >= 2) {
                        this.ofFireworkParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofDrippingWaterLava") && stringArray.length >= 2) {
                        this.ofDrippingWaterLava = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedTerrain") && stringArray.length >= 2) {
                        this.ofAnimatedTerrain = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedTextures") && stringArray.length >= 2) {
                        this.ofAnimatedTextures = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofRainSplash") && stringArray.length >= 2) {
                        this.ofRainSplash = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofLagometer") && stringArray.length >= 2) {
                        this.ofLagometer = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofShowFps") && stringArray.length >= 2) {
                        this.ofShowFps = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAutoSaveTicks") && stringArray.length >= 2) {
                        this.ofAutoSaveTicks = Integer.valueOf(stringArray[1]);
                        this.ofAutoSaveTicks = Config.limit(this.ofAutoSaveTicks, 40, 40000);
                    }
                    if (stringArray[0].equals("ofBetterGrass") && stringArray.length >= 2) {
                        this.ofBetterGrass = Integer.valueOf(stringArray[1]);
                        this.ofBetterGrass = Config.limit(this.ofBetterGrass, 1, 3);
                    }
                    if (stringArray[0].equals("ofConnectedTextures") && stringArray.length >= 2) {
                        this.ofConnectedTextures = Integer.valueOf(stringArray[1]);
                        this.ofConnectedTextures = Config.limit(this.ofConnectedTextures, 1, 3);
                    }
                    if (stringArray[0].equals("ofWeather") && stringArray.length >= 2) {
                        this.ofWeather = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSky") && stringArray.length >= 2) {
                        this.ofSky = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofStars") && stringArray.length >= 2) {
                        this.ofStars = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSunMoon") && stringArray.length >= 2) {
                        this.ofSunMoon = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofVignette") && stringArray.length >= 2) {
                        this.ofVignette = Integer.valueOf(stringArray[1]);
                        this.ofVignette = Config.limit(this.ofVignette, 0, 2);
                    }
                    if (stringArray[0].equals("ofChunkUpdates") && stringArray.length >= 2) {
                        this.ofChunkUpdates = Integer.valueOf(stringArray[1]);
                        this.ofChunkUpdates = Config.limit(this.ofChunkUpdates, 1, 5);
                    }
                    if (stringArray[0].equals("ofChunkUpdatesDynamic") && stringArray.length >= 2) {
                        this.ofChunkUpdatesDynamic = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofTime") && stringArray.length >= 2) {
                        this.ofTime = Integer.valueOf(stringArray[1]);
                        this.ofTime = Config.limit(this.ofTime, 0, 2);
                    }
                    if (stringArray[0].equals("ofClearWater") && stringArray.length >= 2) {
                        this.ofClearWater = Boolean.valueOf(stringArray[1]);
                        this.updateWaterOpacity();
                    }
                    if (stringArray[0].equals("ofAaLevel") && stringArray.length >= 2) {
                        this.ofAaLevel = Integer.valueOf(stringArray[1]);
                        this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
                    }
                    if (stringArray[0].equals("ofAfLevel") && stringArray.length >= 2) {
                        this.ofAfLevel = Integer.valueOf(stringArray[1]);
                        this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
                    }
                    if (stringArray[0].equals("ofProfiler") && stringArray.length >= 2) {
                        this.ofProfiler = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofBetterSnow") && stringArray.length >= 2) {
                        this.ofBetterSnow = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSwampColors") && stringArray.length >= 2) {
                        this.ofSwampColors = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofRandomEntities") && stringArray.length >= 2) {
                        this.ofRandomEntities = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSmoothBiomes") && stringArray.length >= 2) {
                        this.ofSmoothBiomes = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofCustomFonts") && stringArray.length >= 2) {
                        this.ofCustomFonts = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofCustomColors") && stringArray.length >= 2) {
                        this.ofCustomColors = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofCustomItems") && stringArray.length >= 2) {
                        this.ofCustomItems = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofCustomSky") && stringArray.length >= 2) {
                        this.ofCustomSky = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofShowCapes") && stringArray.length >= 2) {
                        this.ofShowCapes = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofNaturalTextures") && stringArray.length >= 2) {
                        this.ofNaturalTextures = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofEmissiveTextures") && stringArray.length >= 2) {
                        this.ofEmissiveTextures = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofLazyChunkLoading") && stringArray.length >= 2) {
                        this.ofLazyChunkLoading = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofRenderRegions") && stringArray.length >= 2) {
                        this.ofRenderRegions = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSmartAnimations") && stringArray.length >= 2) {
                        this.ofSmartAnimations = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofDynamicFov") && stringArray.length >= 2) {
                        this.ofDynamicFov = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAlternateBlocks") && stringArray.length >= 2) {
                        this.ofAlternateBlocks = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofDynamicLights") && stringArray.length >= 2) {
                        this.ofDynamicLights = Integer.valueOf(stringArray[1]);
                        this.ofDynamicLights = GameSettings.limit(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
                    }
                    if (stringArray[0].equals("ofScreenshotSize") && stringArray.length >= 2) {
                        this.ofScreenshotSize = Integer.valueOf(stringArray[1]);
                        this.ofScreenshotSize = Config.limit(this.ofScreenshotSize, 1, 4);
                    }
                    if (stringArray[0].equals("ofCustomEntityModels") && stringArray.length >= 2) {
                        this.ofCustomEntityModels = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofCustomGuis") && stringArray.length >= 2) {
                        this.ofCustomGuis = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofShowGlErrors") && stringArray.length >= 2) {
                        this.ofShowGlErrors = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofFullscreenMode") && stringArray.length >= 2) {
                        this.ofFullscreenMode = stringArray[1];
                    }
                    if (stringArray[0].equals("ofFastMath") && stringArray.length >= 2) {
                        MathHelper.fastMath = this.ofFastMath = Boolean.valueOf(stringArray[1]).booleanValue();
                    }
                    if (stringArray[0].equals("ofFastRender") && stringArray.length >= 2) {
                        this.ofFastRender = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofTranslucentBlocks") && stringArray.length >= 2) {
                        this.ofTranslucentBlocks = Integer.valueOf(stringArray[1]);
                        this.ofTranslucentBlocks = Config.limit(this.ofTranslucentBlocks, 0, 2);
                    }
                    if (!stringArray[0].equals("key_" + this.ofKeyBindZoom.getKeyDescription())) continue;
                    this.ofKeyBindZoom.setKeyCode(Integer.parseInt(stringArray[1]));
                }
                catch (Exception exception) {
                    Config.dbg("Skipping bad option: " + string);
                    exception.printStackTrace();
                }
            }
            KeyUtils.fixKeyConflicts(this.keyBindings, new KeyBinding[]{this.ofKeyBindZoom});
            KeyBinding.resetKeyBindingArrayAndHash();
            bufferedReader.close();
        }
        catch (Exception exception) {
            Config.warn("Failed to load options");
            exception.printStackTrace();
        }
    }

    public void saveOfOptions() {
        try {
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter((OutputStream)new FileOutputStream(this.optionsFileOF), "UTF-8"));
            printWriter.println("ofFogType:" + this.ofFogType);
            printWriter.println("ofFogStart:" + this.ofFogStart);
            printWriter.println("ofMipmapType:" + this.ofMipmapType);
            printWriter.println("ofOcclusionFancy:" + this.ofOcclusionFancy);
            printWriter.println("ofSmoothFps:" + this.ofSmoothFps);
            printWriter.println("ofSmoothWorld:" + this.ofSmoothWorld);
            printWriter.println("ofAoLevel:" + this.ofAoLevel);
            printWriter.println("ofClouds:" + this.ofClouds);
            printWriter.println("ofCloudsHeight:" + this.ofCloudsHeight);
            printWriter.println("ofTrees:" + this.ofTrees);
            printWriter.println("ofDroppedItems:" + this.ofDroppedItems);
            printWriter.println("ofRain:" + this.ofRain);
            printWriter.println("ofAnimatedWater:" + this.ofAnimatedWater);
            printWriter.println("ofAnimatedLava:" + this.ofAnimatedLava);
            printWriter.println("ofAnimatedFire:" + this.ofAnimatedFire);
            printWriter.println("ofAnimatedPortal:" + this.ofAnimatedPortal);
            printWriter.println("ofAnimatedRedstone:" + this.ofAnimatedRedstone);
            printWriter.println("ofAnimatedExplosion:" + this.ofAnimatedExplosion);
            printWriter.println("ofAnimatedFlame:" + this.ofAnimatedFlame);
            printWriter.println("ofAnimatedSmoke:" + this.ofAnimatedSmoke);
            printWriter.println("ofVoidParticles:" + this.ofVoidParticles);
            printWriter.println("ofWaterParticles:" + this.ofWaterParticles);
            printWriter.println("ofPortalParticles:" + this.ofPortalParticles);
            printWriter.println("ofPotionParticles:" + this.ofPotionParticles);
            printWriter.println("ofFireworkParticles:" + this.ofFireworkParticles);
            printWriter.println("ofDrippingWaterLava:" + this.ofDrippingWaterLava);
            printWriter.println("ofAnimatedTerrain:" + this.ofAnimatedTerrain);
            printWriter.println("ofAnimatedTextures:" + this.ofAnimatedTextures);
            printWriter.println("ofRainSplash:" + this.ofRainSplash);
            printWriter.println("ofLagometer:" + this.ofLagometer);
            printWriter.println("ofShowFps:" + this.ofShowFps);
            printWriter.println("ofAutoSaveTicks:" + this.ofAutoSaveTicks);
            printWriter.println("ofBetterGrass:" + this.ofBetterGrass);
            printWriter.println("ofConnectedTextures:" + this.ofConnectedTextures);
            printWriter.println("ofWeather:" + this.ofWeather);
            printWriter.println("ofSky:" + this.ofSky);
            printWriter.println("ofStars:" + this.ofStars);
            printWriter.println("ofSunMoon:" + this.ofSunMoon);
            printWriter.println("ofVignette:" + this.ofVignette);
            printWriter.println("ofChunkUpdates:" + this.ofChunkUpdates);
            printWriter.println("ofChunkUpdatesDynamic:" + this.ofChunkUpdatesDynamic);
            printWriter.println("ofTime:" + this.ofTime);
            printWriter.println("ofClearWater:" + this.ofClearWater);
            printWriter.println("ofAaLevel:" + this.ofAaLevel);
            printWriter.println("ofAfLevel:" + this.ofAfLevel);
            printWriter.println("ofProfiler:" + this.ofProfiler);
            printWriter.println("ofBetterSnow:" + this.ofBetterSnow);
            printWriter.println("ofSwampColors:" + this.ofSwampColors);
            printWriter.println("ofRandomEntities:" + this.ofRandomEntities);
            printWriter.println("ofSmoothBiomes:" + this.ofSmoothBiomes);
            printWriter.println("ofCustomFonts:" + this.ofCustomFonts);
            printWriter.println("ofCustomColors:" + this.ofCustomColors);
            printWriter.println("ofCustomItems:" + this.ofCustomItems);
            printWriter.println("ofCustomSky:" + this.ofCustomSky);
            printWriter.println("ofShowCapes:" + this.ofShowCapes);
            printWriter.println("ofNaturalTextures:" + this.ofNaturalTextures);
            printWriter.println("ofEmissiveTextures:" + this.ofEmissiveTextures);
            printWriter.println("ofLazyChunkLoading:" + this.ofLazyChunkLoading);
            printWriter.println("ofRenderRegions:" + this.ofRenderRegions);
            printWriter.println("ofSmartAnimations:" + this.ofSmartAnimations);
            printWriter.println("ofDynamicFov:" + this.ofDynamicFov);
            printWriter.println("ofAlternateBlocks:" + this.ofAlternateBlocks);
            printWriter.println("ofDynamicLights:" + this.ofDynamicLights);
            printWriter.println("ofScreenshotSize:" + this.ofScreenshotSize);
            printWriter.println("ofCustomEntityModels:" + this.ofCustomEntityModels);
            printWriter.println("ofCustomGuis:" + this.ofCustomGuis);
            printWriter.println("ofShowGlErrors:" + this.ofShowGlErrors);
            printWriter.println("ofFullscreenMode:" + this.ofFullscreenMode);
            printWriter.println("ofFastMath:" + this.ofFastMath);
            printWriter.println("ofFastRender:" + this.ofFastRender);
            printWriter.println("ofTranslucentBlocks:" + this.ofTranslucentBlocks);
            printWriter.println("key_" + this.ofKeyBindZoom.getKeyDescription() + ":" + this.ofKeyBindZoom.getKeyCode());
            printWriter.close();
        }
        catch (Exception exception) {
            Config.warn("Failed to save options");
            exception.printStackTrace();
        }
    }

    private void updateRenderClouds() {
        switch (this.ofClouds) {
            case 1: {
                this.clouds = 1;
                break;
            }
            case 2: {
                this.clouds = 2;
                break;
            }
            case 3: {
                this.clouds = 0;
                break;
            }
            default: {
                this.clouds = this.fancyGraphics ? 2 : 1;
            }
        }
    }

    public void resetSettings() {
        this.renderDistanceChunks = 8;
        this.viewBobbing = true;
        this.anaglyph = false;
        this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
        this.enableVsync = false;
        this.updateVSync();
        this.mipmapLevels = 4;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.clouds = 2;
        this.fovSetting = 70.0f;
        this.gammaSetting = 0.0f;
        this.guiScale = 0;
        this.particleSetting = 0;
        this.heldItemTooltips = true;
        this.useVbo = false;
        this.forceUnicodeFont = false;
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmartAnimations = false;
        this.ofSmoothFps = false;
        Config.updateAvailableProcessors();
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = false;
        this.ofRenderRegions = false;
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofAlternateBlocks = true;
        this.ofDynamicLights = 3;
        this.ofScreenshotSize = 1;
        this.ofCustomEntityModels = true;
        this.ofCustomGuis = true;
        this.ofShowGlErrors = true;
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofShowFps = false;
        this.ofProfiler = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = DEFAULT_STR;
        this.ofSwampColors = true;
        this.ofRandomEntities = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomItems = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofNaturalTextures = false;
        this.ofEmissiveTextures = true;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        Shaders.setShaderPack("OFF");
        Shaders.configAntialiasingLevel = 0;
        Shaders.uninit();
        Shaders.storeConfig();
        this.updateWaterOpacity();
        this.mc.refreshResources();
        this.saveOptions();
    }

    public void updateVSync() {
        Display.setVSyncEnabled(this.enableVsync);
    }

    private void updateWaterOpacity() {
        if (Config.isIntegratedServerRunning()) {
            Config.waterOpacityChanged = true;
        }
        ClearWater.updateWaterOpacity(this, this.mc.theWorld);
    }

    public void setAllAnimations(boolean bl) {
        int n;
        this.ofAnimatedWater = n = bl ? 0 : 2;
        this.ofAnimatedLava = n;
        this.ofAnimatedFire = bl;
        this.ofAnimatedPortal = bl;
        this.ofAnimatedRedstone = bl;
        this.ofAnimatedExplosion = bl;
        this.ofAnimatedFlame = bl;
        this.ofAnimatedSmoke = bl;
        this.ofVoidParticles = bl;
        this.ofWaterParticles = bl;
        this.ofRainSplash = bl;
        this.ofPortalParticles = bl;
        this.ofPotionParticles = bl;
        this.ofFireworkParticles = bl;
        this.particleSetting = bl ? 0 : 2;
        this.ofDrippingWaterLava = bl;
        this.ofAnimatedTerrain = bl;
        this.ofAnimatedTextures = bl;
    }

    private static int nextValue(int n, int[] nArray) {
        int n2 = GameSettings.indexOf(n, nArray);
        if (n2 < 0) {
            return nArray[0];
        }
        if (++n2 >= nArray.length) {
            n2 = 0;
        }
        return nArray[n2];
    }

    private static int limit(int n, int[] nArray) {
        int n2 = GameSettings.indexOf(n, nArray);
        return n2 < 0 ? nArray[0] : n;
    }

    private static int indexOf(int n, int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != n) continue;
            return i;
        }
        return -1;
    }

    public static enum Options {
        INVERT_MOUSE("options.invertMouse", false, true),
        SENSITIVITY("options.sensitivity", true, false),
        FOV("options.fov", true, false, 30.0f, 110.0f, 1.0f),
        GAMMA("options.gamma", true, false),
        SATURATION("options.saturation", true, false),
        RENDER_DISTANCE("options.renderDistance", true, false, 2.0f, 16.0f, 1.0f),
        VIEW_BOBBING("options.viewBobbing", false, true),
        ANAGLYPH("options.anaglyph", false, true),
        FRAMERATE_LIMIT("options.framerateLimit", true, false, 0.0f, 260.0f, 5.0f),
        FBO_ENABLE("options.fboEnable", false, true),
        RENDER_CLOUDS("options.renderClouds", false, false),
        GRAPHICS("options.graphics", false, false),
        AMBIENT_OCCLUSION("options.ao", false, false),
        GUI_SCALE("options.guiScale", false, false),
        PARTICLES("options.particles", false, false),
        CHAT_VISIBILITY("options.chat.visibility", false, false),
        CHAT_COLOR("options.chat.color", false, true),
        CHAT_LINKS("options.chat.links", false, true),
        CHAT_OPACITY("options.chat.opacity", true, false),
        CHAT_LINKS_PROMPT("options.chat.links.prompt", false, true),
        SNOOPER_ENABLED("options.snooper", false, true),
        USE_FULLSCREEN("options.fullscreen", false, true),
        ENABLE_VSYNC("options.vsync", false, true),
        USE_VBO("options.vbo", false, true),
        TOUCHSCREEN("options.touchscreen", false, true),
        CHAT_SCALE("options.chat.scale", true, false),
        CHAT_WIDTH("options.chat.width", true, false),
        CHAT_HEIGHT_FOCUSED("options.chat.height.focused", true, false),
        CHAT_HEIGHT_UNFOCUSED("options.chat.height.unfocused", true, false),
        MIPMAP_LEVELS("options.mipmapLevels", true, false, 0.0f, 4.0f, 1.0f),
        FORCE_UNICODE_FONT("options.forceUnicodeFont", false, true),
        BLOCK_ALTERNATIVES("options.blockAlternatives", false, true),
        REDUCED_DEBUG_INFO("options.reducedDebugInfo", false, true),
        ENTITY_SHADOWS("options.entityShadows", false, true),
        REALMS_NOTIFICATIONS("options.realmsNotifications", false, true),
        FOG_FANCY("of.options.FOG_FANCY", false, false),
        FOG_START("of.options.FOG_START", false, false),
        MIPMAP_TYPE("of.options.MIPMAP_TYPE", true, false, 0.0f, 3.0f, 1.0f),
        SMOOTH_FPS("of.options.SMOOTH_FPS", false, false),
        CLOUDS("of.options.CLOUDS", false, false),
        CLOUD_HEIGHT("of.options.CLOUD_HEIGHT", true, false),
        TREES("of.options.TREES", false, false),
        RAIN("of.options.RAIN", false, false),
        ANIMATED_WATER("of.options.ANIMATED_WATER", false, false),
        ANIMATED_LAVA("of.options.ANIMATED_LAVA", false, false),
        ANIMATED_FIRE("of.options.ANIMATED_FIRE", false, false),
        ANIMATED_PORTAL("of.options.ANIMATED_PORTAL", false, false),
        AO_LEVEL("of.options.AO_LEVEL", true, false),
        LAGOMETER("of.options.LAGOMETER", false, false),
        SHOW_FPS("of.options.SHOW_FPS", false, false),
        AUTOSAVE_TICKS("of.options.AUTOSAVE_TICKS", false, false),
        BETTER_GRASS("of.options.BETTER_GRASS", false, false),
        ANIMATED_REDSTONE("of.options.ANIMATED_REDSTONE", false, false),
        ANIMATED_EXPLOSION("of.options.ANIMATED_EXPLOSION", false, false),
        ANIMATED_FLAME("of.options.ANIMATED_FLAME", false, false),
        ANIMATED_SMOKE("of.options.ANIMATED_SMOKE", false, false),
        WEATHER("of.options.WEATHER", false, false),
        SKY("of.options.SKY", false, false),
        STARS("of.options.STARS", false, false),
        SUN_MOON("of.options.SUN_MOON", false, false),
        VIGNETTE("of.options.VIGNETTE", false, false),
        CHUNK_UPDATES("of.options.CHUNK_UPDATES", false, false),
        CHUNK_UPDATES_DYNAMIC("of.options.CHUNK_UPDATES_DYNAMIC", false, false),
        TIME("of.options.TIME", false, false),
        CLEAR_WATER("of.options.CLEAR_WATER", false, false),
        SMOOTH_WORLD("of.options.SMOOTH_WORLD", false, false),
        VOID_PARTICLES("of.options.VOID_PARTICLES", false, false),
        WATER_PARTICLES("of.options.WATER_PARTICLES", false, false),
        RAIN_SPLASH("of.options.RAIN_SPLASH", false, false),
        PORTAL_PARTICLES("of.options.PORTAL_PARTICLES", false, false),
        POTION_PARTICLES("of.options.POTION_PARTICLES", false, false),
        FIREWORK_PARTICLES("of.options.FIREWORK_PARTICLES", false, false),
        PROFILER("of.options.PROFILER", false, false),
        DRIPPING_WATER_LAVA("of.options.DRIPPING_WATER_LAVA", false, false),
        BETTER_SNOW("of.options.BETTER_SNOW", false, false),
        FULLSCREEN_MODE("of.options.FULLSCREEN_MODE", true, false, 0.0f, Config.getDisplayModes().length, 1.0f),
        ANIMATED_TERRAIN("of.options.ANIMATED_TERRAIN", false, false),
        SWAMP_COLORS("of.options.SWAMP_COLORS", false, false),
        RANDOM_ENTITIES("of.options.RANDOM_ENTITIES", false, false),
        SMOOTH_BIOMES("of.options.SMOOTH_BIOMES", false, false),
        CUSTOM_FONTS("of.options.CUSTOM_FONTS", false, false),
        CUSTOM_COLORS("of.options.CUSTOM_COLORS", false, false),
        SHOW_CAPES("of.options.SHOW_CAPES", false, false),
        CONNECTED_TEXTURES("of.options.CONNECTED_TEXTURES", false, false),
        CUSTOM_ITEMS("of.options.CUSTOM_ITEMS", false, false),
        AA_LEVEL("of.options.AA_LEVEL", true, false, 0.0f, 16.0f, 1.0f),
        AF_LEVEL("of.options.AF_LEVEL", true, false, 1.0f, 16.0f, 1.0f),
        ANIMATED_TEXTURES("of.options.ANIMATED_TEXTURES", false, false),
        NATURAL_TEXTURES("of.options.NATURAL_TEXTURES", false, false),
        EMISSIVE_TEXTURES("of.options.EMISSIVE_TEXTURES", false, false),
        HELD_ITEM_TOOLTIPS("of.options.HELD_ITEM_TOOLTIPS", false, false),
        DROPPED_ITEMS("of.options.DROPPED_ITEMS", false, false),
        LAZY_CHUNK_LOADING("of.options.LAZY_CHUNK_LOADING", false, false),
        CUSTOM_SKY("of.options.CUSTOM_SKY", false, false),
        FAST_MATH("of.options.FAST_MATH", false, false),
        FAST_RENDER("of.options.FAST_RENDER", false, false),
        TRANSLUCENT_BLOCKS("of.options.TRANSLUCENT_BLOCKS", false, false),
        DYNAMIC_FOV("of.options.DYNAMIC_FOV", false, false),
        DYNAMIC_LIGHTS("of.options.DYNAMIC_LIGHTS", false, false),
        ALTERNATE_BLOCKS("of.options.ALTERNATE_BLOCKS", false, false),
        CUSTOM_ENTITY_MODELS("of.options.CUSTOM_ENTITY_MODELS", false, false),
        ADVANCED_TOOLTIPS("of.options.ADVANCED_TOOLTIPS", false, false),
        SCREENSHOT_SIZE("of.options.SCREENSHOT_SIZE", false, false),
        CUSTOM_GUIS("of.options.CUSTOM_GUIS", false, false),
        RENDER_REGIONS("of.options.RENDER_REGIONS", false, false),
        SHOW_GL_ERRORS("of.options.SHOW_GL_ERRORS", false, false),
        SMART_ANIMATIONS("of.options.SMART_ANIMATIONS", false, false);

        private final boolean enumFloat;
        private final boolean enumBoolean;
        private final String enumString;
        private final float valueStep;
        private float valueMin;
        private float valueMax;

        public static Options getEnumOptions(int n) {
            for (Options options : Options.values()) {
                if (options.returnEnumOrdinal() != n) continue;
                return options;
            }
            return null;
        }

        private Options(String string2, boolean bl, boolean bl2) {
            this(string2, bl, bl2, 0.0f, 1.0f, 0.0f);
        }

        private Options(String string2, boolean bl, boolean bl2, float f, float f2, float f3) {
            this.enumString = string2;
            this.enumFloat = bl;
            this.enumBoolean = bl2;
            this.valueMin = f;
            this.valueMax = f2;
            this.valueStep = f3;
        }

        public boolean getEnumFloat() {
            return this.enumFloat;
        }

        public boolean getEnumBoolean() {
            return this.enumBoolean;
        }

        public int returnEnumOrdinal() {
            return this.ordinal();
        }

        public String getEnumString() {
            return this.enumString;
        }

        public float getValueMax() {
            return this.valueMax;
        }

        public void setValueMax(float f) {
            this.valueMax = f;
        }

        public float normalizeValue(float f) {
            return MathHelper.clamp_float((this.snapToStepClamp(f) - this.valueMin) / (this.valueMax - this.valueMin), 0.0f, 1.0f);
        }

        public float denormalizeValue(float f) {
            return this.snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.clamp_float(f, 0.0f, 1.0f));
        }

        public float snapToStepClamp(float f) {
            f = this.snapToStep(f);
            return MathHelper.clamp_float(f, this.valueMin, this.valueMax);
        }

        protected float snapToStep(float f) {
            if (this.valueStep > 0.0f) {
                f = this.valueStep * (float)Math.round(f / this.valueStep);
            }
            return f;
        }
    }
}

