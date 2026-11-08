/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.src;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import net.minecraft.client.LoadingScreenRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.optifine.DynamicLights;
import net.optifine.GlErrors;
import net.optifine.VersionCheckThread;
import net.optifine.config.GlVersion;
import net.optifine.gui.GuiMessage;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorCompat;
import net.optifine.shaders.Shaders;
import net.optifine.util.DisplayModeComparator;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.TextureUtils;
import net.optifine.util.TimedEvent;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;

public class Config {
    public static final String OF_NAME = "OptiFine";
    public static final String MC_VERSION = "1.8.9";
    public static final String OF_EDITION = "HD_U";
    public static final String OF_RELEASE = "M6_pre2";
    public static final String VERSION = "OptiFine_1.8.9_HD_U_M6_pre2";
    private static String build = null;
    private static String newRelease = null;
    private static boolean notify64BitJava = false;
    public static String openGlVersion = null;
    public static String openGlRenderer = null;
    public static String openGlVendor = null;
    public static String[] openGlExtensions = null;
    public static GlVersion glVersion = null;
    public static GlVersion glslVersion = null;
    public static int minecraftVersionInt = -1;
    public static boolean fancyFogAvailable = false;
    public static boolean occlusionAvailable = false;
    private static GameSettings gameSettings = null;
    private static Minecraft minecraft = Minecraft.getMinecraft();
    private static boolean initialized = false;
    private static Thread minecraftThread = null;
    private static DisplayMode desktopDisplayMode = null;
    private static DisplayMode[] displayModes = null;
    private static int antialiasingLevel = 0;
    private static int availableProcessors = 0;
    public static boolean zoomMode = false;
    public static boolean zoomSmoothCamera = false;
    private static int texturePackClouds = 0;
    public static boolean waterOpacityChanged = false;
    private static boolean fullscreenModeChecked = false;
    private static boolean desktopModeChecked = false;
    private static DefaultResourcePack defaultResourcePackLazy = null;
    public static final Float DEF_ALPHA_FUNC_LEVEL = Float.valueOf(0.1f);
    private static final Logger LOGGER = LogManager.getLogger();
    public static final boolean logDetail = System.getProperty("log.detail", "false").equals("true");
    private static String mcDebugLast = null;
    private static int fpsMinLast = 0;
    public static float renderPartialTicks;

    public static String getVersion() {
        return VERSION;
    }

    public static String getVersionDebug() {
        StringBuffer stringBuffer = new StringBuffer(32);
        if (Config.isDynamicLights()) {
            stringBuffer.append("DL: ");
            stringBuffer.append(String.valueOf(DynamicLights.getCount()));
            stringBuffer.append(", ");
        }
        stringBuffer.append(VERSION);
        String string = Shaders.getShaderPackName();
        if (string != null) {
            stringBuffer.append(", ");
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }

    public static void initGameSettings(GameSettings gameSettings) {
        if (Config.gameSettings == null) {
            Config.gameSettings = gameSettings;
            desktopDisplayMode = Display.getDesktopDisplayMode();
            Config.updateAvailableProcessors();
            ReflectorCompat.putLaunchBlackboard("optifine.CompatSplashCompatible", Boolean.TRUE);
        }
    }

    public static void initDisplay() {
        Config.checkInitialized();
        antialiasingLevel = Config.gameSettings.ofAaLevel;
        Config.checkDisplaySettings();
        Config.checkDisplayMode();
        minecraftThread = Thread.currentThread();
        Config.updateThreadPriorities();
        Shaders.startup(Minecraft.getMinecraft());
    }

    public static void checkInitialized() {
        if (!initialized && Display.isCreated()) {
            initialized = true;
            Config.checkOpenGlCaps();
            Config.startVersionCheckThread();
        }
    }

    private static void checkOpenGlCaps() {
        Config.log("");
        Config.log(Config.getVersion());
        Config.log("Build: " + Config.getBuild());
        Config.log("OS: " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version"));
        Config.log("Java: " + System.getProperty("java.version") + ", " + System.getProperty("java.vendor"));
        Config.log("VM: " + System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor"));
        Config.log("LWJGL: " + Sys.getVersion());
        openGlVersion = GL11.glGetString(7938);
        openGlRenderer = GL11.glGetString(7937);
        openGlVendor = GL11.glGetString(7936);
        Config.log("OpenGL: " + openGlRenderer + ", version " + openGlVersion + ", " + openGlVendor);
        Config.log("OpenGL Version: " + Config.getOpenGlVersionString());
        if (!GLContext.getCapabilities().OpenGL12) {
            Config.log("OpenGL Mipmap levels: Not available (GL12.GL_TEXTURE_MAX_LEVEL)");
        }
        if (!(fancyFogAvailable = GLContext.getCapabilities().GL_NV_fog_distance)) {
            Config.log("OpenGL Fancy fog: Not available (GL_NV_fog_distance)");
        }
        if (!(occlusionAvailable = GLContext.getCapabilities().GL_ARB_occlusion_query)) {
            Config.log("OpenGL Occlussion culling: Not available (GL_ARB_occlusion_query)");
        }
        int n = TextureUtils.getGLMaximumTextureSize();
        Config.dbg("Maximum texture size: " + n + "x" + n);
    }

    public static String getBuild() {
        if (build == null) {
            try {
                InputStream inputStream2 = Config.class.getResourceAsStream("/buildof.txt");
                if (inputStream2 == null) {
                    return null;
                }
                build = Config.readLines(inputStream2)[0];
            }
            catch (Exception exception) {
                Config.warn(exception.getClass().getName() + ": " + exception.getMessage());
                build = "";
            }
        }
        return build;
    }

    public static boolean isFancyFogAvailable() {
        return fancyFogAvailable;
    }

    public static boolean isOcclusionAvailable() {
        return occlusionAvailable;
    }

    public static int getMinecraftVersionInt() {
        if (minecraftVersionInt < 0) {
            String[] stringArray = Config.tokenize(MC_VERSION, ".");
            int n = 0;
            if (stringArray.length > 0) {
                n += 10000 * Config.parseInt(stringArray[0], 0);
            }
            if (stringArray.length > 1) {
                n += 100 * Config.parseInt(stringArray[1], 0);
            }
            if (stringArray.length > 2) {
                n += 1 * Config.parseInt(stringArray[2], 0);
            }
            minecraftVersionInt = n;
        }
        return minecraftVersionInt;
    }

    public static String getOpenGlVersionString() {
        GlVersion glVersion = Config.getGlVersion();
        String string = glVersion.getMajor() + "." + glVersion.getMinor() + "." + glVersion.getRelease();
        return string;
    }

    private static GlVersion getGlVersionLwjgl() {
        return GLContext.getCapabilities().OpenGL44 ? new GlVersion(4, 4) : (GLContext.getCapabilities().OpenGL43 ? new GlVersion(4, 3) : (GLContext.getCapabilities().OpenGL42 ? new GlVersion(4, 2) : (GLContext.getCapabilities().OpenGL41 ? new GlVersion(4, 1) : (GLContext.getCapabilities().OpenGL40 ? new GlVersion(4, 0) : (GLContext.getCapabilities().OpenGL33 ? new GlVersion(3, 3) : (GLContext.getCapabilities().OpenGL32 ? new GlVersion(3, 2) : (GLContext.getCapabilities().OpenGL31 ? new GlVersion(3, 1) : (GLContext.getCapabilities().OpenGL30 ? new GlVersion(3, 0) : (GLContext.getCapabilities().OpenGL21 ? new GlVersion(2, 1) : (GLContext.getCapabilities().OpenGL20 ? new GlVersion(2, 0) : (GLContext.getCapabilities().OpenGL15 ? new GlVersion(1, 5) : (GLContext.getCapabilities().OpenGL14 ? new GlVersion(1, 4) : (GLContext.getCapabilities().OpenGL13 ? new GlVersion(1, 3) : (GLContext.getCapabilities().OpenGL12 ? new GlVersion(1, 2) : (GLContext.getCapabilities().OpenGL11 ? new GlVersion(1, 1) : new GlVersion(1, 0))))))))))))))));
    }

    public static GlVersion getGlVersion() {
        if (glVersion == null) {
            String string = GL11.glGetString(7938);
            glVersion = Config.parseGlVersion(string, null);
            if (glVersion == null) {
                glVersion = Config.getGlVersionLwjgl();
            }
            if (glVersion == null) {
                glVersion = new GlVersion(1, 0);
            }
        }
        return glVersion;
    }

    public static GlVersion getGlslVersion() {
        String string;
        if (glslVersion == null && (glslVersion = Config.parseGlVersion(string = GL11.glGetString(35724), null)) == null) {
            glslVersion = new GlVersion(1, 10);
        }
        return glslVersion;
    }

    public static GlVersion parseGlVersion(String string, GlVersion glVersion) {
        try {
            if (string == null) {
                return glVersion;
            }
            Pattern pattern = Pattern.compile("([0-9]+)\\.([0-9]+)(\\.([0-9]+))?(.+)?");
            Matcher matcher = pattern.matcher(string);
            if (!matcher.matches()) {
                return glVersion;
            }
            int n = Integer.parseInt(matcher.group(1));
            int n2 = Integer.parseInt(matcher.group(2));
            int n3 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4)) : 0;
            String string2 = matcher.group(5);
            return new GlVersion(n, n2, n3, string2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return glVersion;
        }
    }

    public static String[] getOpenGlExtensions() {
        if (openGlExtensions == null) {
            openGlExtensions = Config.detectOpenGlExtensions();
        }
        return openGlExtensions;
    }

    private static String[] detectOpenGlExtensions() {
        Object object;
        try {
            int n;
            object = Config.getGlVersion();
            if (((GlVersion)object).getMajor() >= 3 && (n = GL11.glGetInteger(33309)) > 0) {
                String[] stringArray = new String[n];
                for (int i = 0; i < n; ++i) {
                    stringArray[i] = GL30.glGetStringi(7939, i);
                }
                return stringArray;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            object = GL11.glGetString(7939);
            String[] stringArray = ((String)object).split(" ");
            return stringArray;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new String[0];
        }
    }

    public static void updateThreadPriorities() {
        Config.updateAvailableProcessors();
        int n = 8;
        if (Config.isSingleProcessor()) {
            if (Config.isSmoothWorld()) {
                minecraftThread.setPriority(10);
                Config.setThreadPriority("Server thread", 1);
            } else {
                minecraftThread.setPriority(5);
                Config.setThreadPriority("Server thread", 5);
            }
        } else {
            minecraftThread.setPriority(10);
            Config.setThreadPriority("Server thread", 5);
        }
    }

    private static void setThreadPriority(String string, int n) {
        try {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            if (threadGroup == null) {
                return;
            }
            int n2 = (threadGroup.activeCount() + 10) * 2;
            Thread[] threadArray = new Thread[n2];
            threadGroup.enumerate(threadArray, false);
            for (int i = 0; i < threadArray.length; ++i) {
                Thread thread2 = threadArray[i];
                if (thread2 == null || !thread2.getName().startsWith(string)) continue;
                thread2.setPriority(n);
            }
        }
        catch (Throwable throwable) {
            Config.warn(throwable.getClass().getName() + ": " + throwable.getMessage());
        }
    }

    public static boolean isMinecraftThread() {
        return Thread.currentThread() == minecraftThread;
    }

    private static void startVersionCheckThread() {
        VersionCheckThread versionCheckThread = new VersionCheckThread();
        versionCheckThread.start();
    }

    public static boolean isMipmaps() {
        return Config.gameSettings.mipmapLevels > 0;
    }

    public static int getMipmapLevels() {
        return Config.gameSettings.mipmapLevels;
    }

    public static int getMipmapType() {
        switch (Config.gameSettings.ofMipmapType) {
            case 0: {
                return 9986;
            }
            case 1: {
                return 9986;
            }
            case 2: {
                if (Config.isMultiTexture()) {
                    return 9985;
                }
                return 9986;
            }
            case 3: {
                if (Config.isMultiTexture()) {
                    return 9987;
                }
                return 9986;
            }
        }
        return 9986;
    }

    public static boolean isUseAlphaFunc() {
        float f = Config.getAlphaFuncLevel();
        return f > DEF_ALPHA_FUNC_LEVEL.floatValue() + 1.0E-5f;
    }

    public static float getAlphaFuncLevel() {
        return DEF_ALPHA_FUNC_LEVEL.floatValue();
    }

    public static boolean isFogFancy() {
        return !Config.isFancyFogAvailable() ? false : Config.gameSettings.ofFogType == 2;
    }

    public static boolean isFogFast() {
        return Config.gameSettings.ofFogType == 1;
    }

    public static boolean isFogOff() {
        return Config.gameSettings.ofFogType == 3;
    }

    public static boolean isFogOn() {
        return Config.gameSettings.ofFogType != 3;
    }

    public static float getFogStart() {
        return Config.gameSettings.ofFogStart;
    }

    public static void detail(String string) {
        if (logDetail) {
            LOGGER.info("[OptiFine] " + string);
        }
    }

    public static void dbg(String string) {
        LOGGER.info("[OptiFine] " + string);
    }

    public static void warn(String string) {
        LOGGER.warn("[OptiFine] " + string);
    }

    public static void error(String string) {
        LOGGER.error("[OptiFine] " + string);
    }

    public static void log(String string) {
        Config.dbg(string);
    }

    public static int getUpdatesPerFrame() {
        return Config.gameSettings.ofChunkUpdates;
    }

    public static boolean isDynamicUpdates() {
        return Config.gameSettings.ofChunkUpdatesDynamic;
    }

    public static boolean isRainFancy() {
        return Config.gameSettings.ofRain == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofRain == 2;
    }

    public static boolean isRainOff() {
        return Config.gameSettings.ofRain == 3;
    }

    public static boolean isCloudsFancy() {
        return Config.gameSettings.ofClouds != 0 ? Config.gameSettings.ofClouds == 2 : (Config.isShaders() && !Shaders.shaderPackClouds.isDefault() ? Shaders.shaderPackClouds.isFancy() : (texturePackClouds != 0 ? texturePackClouds == 2 : Config.gameSettings.fancyGraphics));
    }

    public static boolean isCloudsOff() {
        return Config.gameSettings.ofClouds != 0 ? Config.gameSettings.ofClouds == 3 : (Config.isShaders() && !Shaders.shaderPackClouds.isDefault() ? Shaders.shaderPackClouds.isOff() : (texturePackClouds != 0 ? texturePackClouds == 3 : false));
    }

    public static void updateTexturePackClouds() {
        texturePackClouds = 0;
        IResourceManager iResourceManager = Config.getResourceManager();
        if (iResourceManager != null) {
            try {
                InputStream inputStream2 = iResourceManager.getResource(new ResourceLocation("mcpatcher/color.properties")).getInputStream();
                if (inputStream2 == null) {
                    return;
                }
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load(inputStream2);
                inputStream2.close();
                String string = propertiesOrdered.getProperty("clouds");
                if (string == null) {
                    return;
                }
                Config.dbg("Texture pack clouds: " + string);
                string = string.toLowerCase();
                if (string.equals("fast")) {
                    texturePackClouds = 1;
                }
                if (string.equals("fancy")) {
                    texturePackClouds = 2;
                }
                if (string.equals("off")) {
                    texturePackClouds = 3;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static ModelManager getModelManager() {
        return Config.minecraft.getRenderItem().modelManager;
    }

    public static boolean isTreesFancy() {
        return Config.gameSettings.ofTrees == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofTrees != 1;
    }

    public static boolean isTreesSmart() {
        return Config.gameSettings.ofTrees == 4;
    }

    public static boolean isCullFacesLeaves() {
        return Config.gameSettings.ofTrees == 0 ? !Config.gameSettings.fancyGraphics : Config.gameSettings.ofTrees == 4;
    }

    public static boolean isDroppedItemsFancy() {
        return Config.gameSettings.ofDroppedItems == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofDroppedItems == 2;
    }

    public static int limit(int n, int n2, int n3) {
        return n < n2 ? n2 : (n > n3 ? n3 : n);
    }

    public static float limit(float f, float f2, float f3) {
        return f < f2 ? f2 : (f > f3 ? f3 : f);
    }

    public static double limit(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    public static float limitTo1(float f) {
        return f < 0.0f ? 0.0f : (f > 1.0f ? 1.0f : f);
    }

    public static boolean isAnimatedWater() {
        return Config.gameSettings.ofAnimatedWater != 2;
    }

    public static boolean isGeneratedWater() {
        return Config.gameSettings.ofAnimatedWater == 1;
    }

    public static boolean isAnimatedPortal() {
        return Config.gameSettings.ofAnimatedPortal;
    }

    public static boolean isAnimatedLava() {
        return Config.gameSettings.ofAnimatedLava != 2;
    }

    public static boolean isGeneratedLava() {
        return Config.gameSettings.ofAnimatedLava == 1;
    }

    public static boolean isAnimatedFire() {
        return Config.gameSettings.ofAnimatedFire;
    }

    public static boolean isAnimatedRedstone() {
        return Config.gameSettings.ofAnimatedRedstone;
    }

    public static boolean isAnimatedExplosion() {
        return Config.gameSettings.ofAnimatedExplosion;
    }

    public static boolean isAnimatedFlame() {
        return Config.gameSettings.ofAnimatedFlame;
    }

    public static boolean isAnimatedSmoke() {
        return Config.gameSettings.ofAnimatedSmoke;
    }

    public static boolean isVoidParticles() {
        return Config.gameSettings.ofVoidParticles;
    }

    public static boolean isWaterParticles() {
        return Config.gameSettings.ofWaterParticles;
    }

    public static boolean isRainSplash() {
        return Config.gameSettings.ofRainSplash;
    }

    public static boolean isPortalParticles() {
        return Config.gameSettings.ofPortalParticles;
    }

    public static boolean isPotionParticles() {
        return Config.gameSettings.ofPotionParticles;
    }

    public static boolean isFireworkParticles() {
        return Config.gameSettings.ofFireworkParticles;
    }

    public static float getAmbientOcclusionLevel() {
        return Config.isShaders() && Shaders.aoLevel >= 0.0f ? Shaders.aoLevel : Config.gameSettings.ofAoLevel;
    }

    public static String listToString(List list) {
        return Config.listToString(list, ", ");
    }

    public static String listToString(List list, String string) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(list.size() * 5);
        for (int i = 0; i < list.size(); ++i) {
            Object e = list.get(i);
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(e));
        }
        return stringBuffer.toString();
    }

    public static String arrayToString(Object[] objectArray) {
        return Config.arrayToString(objectArray, ", ");
    }

    public static String arrayToString(Object[] objectArray, String string) {
        if (objectArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(objectArray.length * 5);
        for (int i = 0; i < objectArray.length; ++i) {
            Object object = objectArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(object));
        }
        return stringBuffer.toString();
    }

    public static String arrayToString(int[] nArray) {
        return Config.arrayToString(nArray, ", ");
    }

    public static String arrayToString(int[] nArray, String string) {
        if (nArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(nArray.length * 5);
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(n));
        }
        return stringBuffer.toString();
    }

    public static String arrayToString(float[] fArray) {
        return Config.arrayToString(fArray, ", ");
    }

    public static String arrayToString(float[] fArray, String string) {
        if (fArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(fArray.length * 5);
        for (int i = 0; i < fArray.length; ++i) {
            float f = fArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(f));
        }
        return stringBuffer.toString();
    }

    public static Minecraft getMinecraft() {
        return minecraft;
    }

    public static TextureManager getTextureManager() {
        return minecraft.getTextureManager();
    }

    public static IResourceManager getResourceManager() {
        return minecraft.getResourceManager();
    }

    public static InputStream getResourceStream(ResourceLocation resourceLocation) throws IOException {
        return Config.getResourceStream(minecraft.getResourceManager(), resourceLocation);
    }

    public static InputStream getResourceStream(IResourceManager iResourceManager, ResourceLocation resourceLocation) throws IOException {
        IResource iResource = iResourceManager.getResource(resourceLocation);
        return iResource == null ? null : iResource.getInputStream();
    }

    public static IResource getResource(ResourceLocation resourceLocation) throws IOException {
        return minecraft.getResourceManager().getResource(resourceLocation);
    }

    public static boolean hasResource(ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            return false;
        }
        IResourcePack iResourcePack = Config.getDefiningResourcePack(resourceLocation);
        return iResourcePack != null;
    }

    public static boolean hasResource(IResourceManager iResourceManager, ResourceLocation resourceLocation) {
        try {
            IResource iResource = iResourceManager.getResource(resourceLocation);
            return iResource != null;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static IResourcePack[] getResourcePacks() {
        ResourcePackRepository resourcePackRepository = minecraft.getResourcePackRepository();
        List<ResourcePackRepository.Entry> list = resourcePackRepository.getRepositoryEntries();
        ArrayList<IResourcePack> arrayList = new ArrayList<IResourcePack>();
        IResourcePack[] iResourcePackArray = list.iterator();
        while (iResourcePackArray.hasNext()) {
            ResourcePackRepository.Entry entry;
            ResourcePackRepository.Entry entry2 = entry = iResourcePackArray.next();
            arrayList.add(entry2.getResourcePack());
        }
        if (resourcePackRepository.getResourcePackInstance() != null) {
            arrayList.add(resourcePackRepository.getResourcePackInstance());
        }
        iResourcePackArray = arrayList.toArray(new IResourcePack[arrayList.size()]);
        return iResourcePackArray;
    }

    public static String getResourcePackNames() {
        if (minecraft.getResourcePackRepository() == null) {
            return "";
        }
        IResourcePack[] iResourcePackArray = Config.getResourcePacks();
        if (iResourcePackArray.length <= 0) {
            return Config.getDefaultResourcePack().getPackName();
        }
        String[] stringArray = new String[iResourcePackArray.length];
        for (int i = 0; i < iResourcePackArray.length; ++i) {
            stringArray[i] = iResourcePackArray[i].getPackName();
        }
        String string = Config.arrayToString(stringArray);
        return string;
    }

    public static DefaultResourcePack getDefaultResourcePack() {
        ResourcePackRepository resourcePackRepository;
        Minecraft minecraft;
        if (defaultResourcePackLazy == null && (defaultResourcePackLazy = (DefaultResourcePack)Reflector.getFieldValue(minecraft = Minecraft.getMinecraft(), Reflector.Minecraft_defaultResourcePack)) == null && (resourcePackRepository = minecraft.getResourcePackRepository()) != null) {
            defaultResourcePackLazy = (DefaultResourcePack)resourcePackRepository.rprDefaultResourcePack;
        }
        return defaultResourcePackLazy;
    }

    public static boolean isFromDefaultResourcePack(ResourceLocation resourceLocation) {
        IResourcePack iResourcePack = Config.getDefiningResourcePack(resourceLocation);
        return iResourcePack == Config.getDefaultResourcePack();
    }

    public static IResourcePack getDefiningResourcePack(ResourceLocation resourceLocation) {
        ResourcePackRepository resourcePackRepository = minecraft.getResourcePackRepository();
        IResourcePack iResourcePack = resourcePackRepository.getResourcePackInstance();
        if (iResourcePack != null && iResourcePack.resourceExists(resourceLocation)) {
            return iResourcePack;
        }
        List<ResourcePackRepository.Entry> list = resourcePackRepository.repositoryEntries;
        for (int i = list.size() - 1; i >= 0; --i) {
            ResourcePackRepository.Entry entry = list.get(i);
            IResourcePack iResourcePack2 = entry.getResourcePack();
            if (!iResourcePack2.resourceExists(resourceLocation)) continue;
            return iResourcePack2;
        }
        if (Config.getDefaultResourcePack().resourceExists(resourceLocation)) {
            return Config.getDefaultResourcePack();
        }
        return null;
    }

    public static RenderGlobal getRenderGlobal() {
        return Config.minecraft.renderGlobal;
    }

    public static boolean isBetterGrass() {
        return Config.gameSettings.ofBetterGrass != 3;
    }

    public static boolean isBetterGrassFancy() {
        return Config.gameSettings.ofBetterGrass == 2;
    }

    public static boolean isWeatherEnabled() {
        return Config.gameSettings.ofWeather;
    }

    public static boolean isSkyEnabled() {
        return Config.gameSettings.ofSky;
    }

    public static boolean isSunMoonEnabled() {
        return Config.gameSettings.ofSunMoon;
    }

    public static boolean isSunTexture() {
        return !Config.isSunMoonEnabled() ? false : !Config.isShaders() || Shaders.isSun();
    }

    public static boolean isMoonTexture() {
        return !Config.isSunMoonEnabled() ? false : !Config.isShaders() || Shaders.isMoon();
    }

    public static boolean isVignetteEnabled() {
        return Config.isShaders() && !Shaders.isVignette() ? false : (Config.gameSettings.ofVignette == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofVignette == 2);
    }

    public static boolean isStarsEnabled() {
        return Config.gameSettings.ofStars;
    }

    public static void sleep(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static boolean isTimeDayOnly() {
        return Config.gameSettings.ofTime == 1;
    }

    public static boolean isTimeDefault() {
        return Config.gameSettings.ofTime == 0;
    }

    public static boolean isTimeNightOnly() {
        return Config.gameSettings.ofTime == 2;
    }

    public static boolean isClearWater() {
        return Config.gameSettings.ofClearWater;
    }

    public static int getAnisotropicFilterLevel() {
        return Config.gameSettings.ofAfLevel;
    }

    public static boolean isAnisotropicFiltering() {
        return Config.getAnisotropicFilterLevel() > 1;
    }

    public static int getAntialiasingLevel() {
        return antialiasingLevel;
    }

    public static boolean isAntialiasing() {
        return Config.getAntialiasingLevel() > 0;
    }

    public static boolean isAntialiasingConfigured() {
        return Config.getGameSettings().ofAaLevel > 0;
    }

    public static boolean isMultiTexture() {
        return Config.getAnisotropicFilterLevel() > 1 ? true : Config.getAntialiasingLevel() > 0;
    }

    public static boolean between(int n, int n2, int n3) {
        return n >= n2 && n <= n3;
    }

    public static boolean between(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static boolean isDrippingWaterLava() {
        return Config.gameSettings.ofDrippingWaterLava;
    }

    public static boolean isBetterSnow() {
        return Config.gameSettings.ofBetterSnow;
    }

    public static Dimension getFullscreenDimension() {
        if (desktopDisplayMode == null) {
            return null;
        }
        if (gameSettings == null) {
            return new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight());
        }
        String string = Config.gameSettings.ofFullscreenMode;
        if (string.equals("Default")) {
            return new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight());
        }
        String[] stringArray = Config.tokenize(string, " x");
        return stringArray.length < 2 ? new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight()) : new Dimension(Config.parseInt(stringArray[0], -1), Config.parseInt(stringArray[1], -1));
    }

    public static int parseInt(String string, int n) {
        try {
            if (string == null) {
                return n;
            }
            string = string.trim();
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public static float parseFloat(String string, float f) {
        try {
            if (string == null) {
                return f;
            }
            string = string.trim();
            return Float.parseFloat(string);
        }
        catch (NumberFormatException numberFormatException) {
            return f;
        }
    }

    public static boolean parseBoolean(String string, boolean bl) {
        try {
            if (string == null) {
                return bl;
            }
            string = string.trim();
            return Boolean.parseBoolean(string);
        }
        catch (NumberFormatException numberFormatException) {
            return bl;
        }
    }

    public static Boolean parseBoolean(String string, Boolean bl) {
        try {
            if (string == null) {
                return bl;
            }
            return (string = string.trim().toLowerCase()).equals("true") ? Boolean.TRUE : (string.equals("false") ? Boolean.FALSE : bl);
        }
        catch (NumberFormatException numberFormatException) {
            return bl;
        }
    }

    public static String[] tokenize(String string, String string2) {
        String[] stringArray;
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        while (stringTokenizer.hasMoreTokens()) {
            stringArray = stringTokenizer.nextToken();
            arrayList.add(stringArray);
        }
        stringArray = arrayList.toArray(new String[arrayList.size()]);
        return stringArray;
    }

    public static DisplayMode getDesktopDisplayMode() {
        return desktopDisplayMode;
    }

    public static DisplayMode[] getDisplayModes() {
        if (displayModes == null) {
            try {
                DisplayMode[] displayModeArray = Display.getAvailableDisplayModes();
                Set<Dimension> set = Config.getDisplayModeDimensions(displayModeArray);
                ArrayList<DisplayMode> arrayList = new ArrayList<DisplayMode>();
                for (Dimension dimension : set) {
                    DisplayMode[] displayModeArray2 = Config.getDisplayModes(displayModeArray, dimension);
                    DisplayMode displayMode = Config.getDisplayMode(displayModeArray2, desktopDisplayMode);
                    if (displayMode == null) continue;
                    arrayList.add(displayMode);
                }
                DisplayMode[] displayModeArray3 = arrayList.toArray(new DisplayMode[arrayList.size()]);
                Arrays.sort(displayModeArray3, new DisplayModeComparator());
                return displayModeArray3;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                displayModes = new DisplayMode[]{desktopDisplayMode};
            }
        }
        return displayModes;
    }

    public static DisplayMode getLargestDisplayMode() {
        DisplayMode[] displayModeArray = Config.getDisplayModes();
        if (displayModeArray != null && displayModeArray.length >= 1) {
            DisplayMode displayMode = displayModeArray[displayModeArray.length - 1];
            return desktopDisplayMode.getWidth() > displayMode.getWidth() ? desktopDisplayMode : (desktopDisplayMode.getWidth() == displayMode.getWidth() && desktopDisplayMode.getHeight() > displayMode.getHeight() ? desktopDisplayMode : displayMode);
        }
        return desktopDisplayMode;
    }

    private static Set<Dimension> getDisplayModeDimensions(DisplayMode[] displayModeArray) {
        HashSet<Dimension> hashSet = new HashSet<Dimension>();
        for (int i = 0; i < displayModeArray.length; ++i) {
            DisplayMode displayMode = displayModeArray[i];
            Dimension dimension = new Dimension(displayMode.getWidth(), displayMode.getHeight());
            hashSet.add(dimension);
        }
        return hashSet;
    }

    private static DisplayMode[] getDisplayModes(DisplayMode[] displayModeArray, Dimension dimension) {
        ArrayList<DisplayMode> arrayList = new ArrayList<DisplayMode>();
        for (int i = 0; i < displayModeArray.length; ++i) {
            DisplayMode displayMode = displayModeArray[i];
            if ((double)displayMode.getWidth() != dimension.getWidth() || (double)displayMode.getHeight() != dimension.getHeight()) continue;
            arrayList.add(displayMode);
        }
        DisplayMode[] displayModeArray2 = arrayList.toArray(new DisplayMode[arrayList.size()]);
        return displayModeArray2;
    }

    private static DisplayMode getDisplayMode(DisplayMode[] displayModeArray, DisplayMode displayMode) {
        if (displayMode != null) {
            for (int i = 0; i < displayModeArray.length; ++i) {
                DisplayMode displayMode2 = displayModeArray[i];
                if (displayMode2.getBitsPerPixel() != displayMode.getBitsPerPixel() || displayMode2.getFrequency() != displayMode.getFrequency()) continue;
                return displayMode2;
            }
        }
        if (displayModeArray.length <= 0) {
            return null;
        }
        Arrays.sort(displayModeArray, new DisplayModeComparator());
        return displayModeArray[displayModeArray.length - 1];
    }

    public static String[] getDisplayModeNames() {
        DisplayMode[] displayModeArray = Config.getDisplayModes();
        String[] stringArray = new String[displayModeArray.length];
        for (int i = 0; i < displayModeArray.length; ++i) {
            DisplayMode displayMode = displayModeArray[i];
            String string = displayMode.getWidth() + "x" + displayMode.getHeight();
            stringArray[i] = string;
        }
        return stringArray;
    }

    public static DisplayMode getDisplayMode(Dimension dimension) throws LWJGLException {
        DisplayMode[] displayModeArray = Config.getDisplayModes();
        for (int i = 0; i < displayModeArray.length; ++i) {
            DisplayMode displayMode = displayModeArray[i];
            if (displayMode.getWidth() != dimension.width || displayMode.getHeight() != dimension.height) continue;
            return displayMode;
        }
        return desktopDisplayMode;
    }

    public static boolean isAnimatedTerrain() {
        return Config.gameSettings.ofAnimatedTerrain;
    }

    public static boolean isAnimatedTextures() {
        return Config.gameSettings.ofAnimatedTextures;
    }

    public static boolean isSwampColors() {
        return Config.gameSettings.ofSwampColors;
    }

    public static boolean isRandomEntities() {
        return Config.gameSettings.ofRandomEntities;
    }

    public static void checkGlError(String string) {
        int n = GlStateManager.glGetError();
        if (n != 0 && GlErrors.isEnabled(n)) {
            String string2 = Config.getGlErrorString(n);
            String string3 = String.format("OpenGL error: %s (%s), at: %s", n, string2, string);
            Config.error(string3);
            if (Config.isShowGlErrors() && TimedEvent.isActive("ShowGlError", 10000L)) {
                String string4 = I18n.format("of.message.openglError", n, string2);
                Config.minecraft.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(string4));
            }
        }
    }

    public static boolean isSmoothBiomes() {
        return Config.gameSettings.ofSmoothBiomes;
    }

    public static boolean isCustomColors() {
        return Config.gameSettings.ofCustomColors;
    }

    public static boolean isCustomSky() {
        return Config.gameSettings.ofCustomSky;
    }

    public static boolean isCustomFonts() {
        return Config.gameSettings.ofCustomFonts;
    }

    public static boolean isShowCapes() {
        return Config.gameSettings.ofShowCapes;
    }

    public static boolean isConnectedTextures() {
        return Config.gameSettings.ofConnectedTextures != 3;
    }

    public static boolean isNaturalTextures() {
        return Config.gameSettings.ofNaturalTextures;
    }

    public static boolean isEmissiveTextures() {
        return Config.gameSettings.ofEmissiveTextures;
    }

    public static boolean isConnectedTexturesFancy() {
        return Config.gameSettings.ofConnectedTextures == 2;
    }

    public static boolean isFastRender() {
        return Config.gameSettings.ofFastRender;
    }

    public static boolean isTranslucentBlocksFancy() {
        return Config.gameSettings.ofTranslucentBlocks == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofTranslucentBlocks == 2;
    }

    public static boolean isShaders() {
        return Shaders.shaderPackLoaded;
    }

    public static String[] readLines(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        return Config.readLines(fileInputStream);
    }

    public static String[] readLines(InputStream inputStream2) throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, "ASCII");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String string;
            if ((string = bufferedReader.readLine()) == null) {
                String[] stringArray = arrayList.toArray(new String[arrayList.size()]);
                return stringArray;
            }
            arrayList.add(string);
        }
    }

    public static String readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        return Config.readInputStream(fileInputStream, "ASCII");
    }

    public static String readInputStream(InputStream inputStream2) throws IOException {
        return Config.readInputStream(inputStream2, "ASCII");
    }

    public static String readInputStream(InputStream inputStream2, String string) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, string);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        String string2;
        while ((string2 = bufferedReader.readLine()) != null) {
            stringBuffer.append(string2);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static byte[] readAll(InputStream inputStream2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = new byte[1024];
        while (true) {
            int n;
            if ((n = inputStream2.read(byArray)) < 0) {
                inputStream2.close();
                byte[] byArray2 = byteArrayOutputStream.toByteArray();
                return byArray2;
            }
            byteArrayOutputStream.write(byArray, 0, n);
        }
    }

    public static GameSettings getGameSettings() {
        return gameSettings;
    }

    public static String getNewRelease() {
        return newRelease;
    }

    public static void setNewRelease(String string) {
        newRelease = string;
    }

    public static int compareRelease(String string, String string2) {
        int n;
        String[] stringArray;
        String string3;
        String[] stringArray2 = Config.splitRelease(string);
        String string4 = stringArray2[0];
        if (!string4.equals(string3 = (stringArray = Config.splitRelease(string2))[0])) {
            return string4.compareTo(string3);
        }
        int n2 = Config.parseInt(stringArray2[1], -1);
        if (n2 != (n = Config.parseInt(stringArray[1], -1))) {
            return n2 - n;
        }
        String string5 = stringArray2[2];
        String string6 = stringArray[2];
        if (!string5.equals(string6)) {
            if (string5.isEmpty()) {
                return 1;
            }
            if (string6.isEmpty()) {
                return -1;
            }
        }
        return string5.compareTo(string6);
    }

    private static String[] splitRelease(String string) {
        if (string != null && string.length() > 0) {
            Pattern pattern = Pattern.compile("([A-Z])([0-9]+)(.*)");
            Matcher matcher = pattern.matcher(string);
            if (!matcher.matches()) {
                return new String[]{"", "", ""};
            }
            String string2 = Config.normalize(matcher.group(1));
            String string3 = Config.normalize(matcher.group(2));
            String string4 = Config.normalize(matcher.group(3));
            return new String[]{string2, string3, string4};
        }
        return new String[]{"", "", ""};
    }

    public static int intHash(int n) {
        n = n ^ 0x3D ^ n >> 16;
        n += n << 3;
        n ^= n >> 4;
        n *= 668265261;
        n ^= n >> 15;
        return n;
    }

    public static int getRandom(BlockPos blockPos, int n) {
        int n2 = Config.intHash(n + 37);
        n2 = Config.intHash(n2 + blockPos.getX());
        n2 = Config.intHash(n2 + blockPos.getZ());
        n2 = Config.intHash(n2 + blockPos.getY());
        return n2;
    }

    public static int getAvailableProcessors() {
        return availableProcessors;
    }

    public static void updateAvailableProcessors() {
        availableProcessors = Runtime.getRuntime().availableProcessors();
    }

    public static boolean isSingleProcessor() {
        return Config.getAvailableProcessors() <= 1;
    }

    public static boolean isSmoothWorld() {
        return Config.gameSettings.ofSmoothWorld;
    }

    public static boolean isLazyChunkLoading() {
        return Config.gameSettings.ofLazyChunkLoading;
    }

    public static boolean isDynamicFov() {
        return Config.gameSettings.ofDynamicFov;
    }

    public static boolean isAlternateBlocks() {
        return Config.gameSettings.ofAlternateBlocks;
    }

    public static int getChunkViewDistance() {
        if (gameSettings == null) {
            return 10;
        }
        int n = Config.gameSettings.renderDistanceChunks;
        return n;
    }

    public static boolean equals(Object object, Object object2) {
        return object == object2 ? true : (object == null ? false : object.equals(object2));
    }

    public static boolean equalsOne(Object object, Object[] objectArray) {
        if (objectArray == null) {
            return false;
        }
        for (int i = 0; i < objectArray.length; ++i) {
            Object object2 = objectArray[i];
            if (!Config.equals(object, object2)) continue;
            return true;
        }
        return false;
    }

    public static boolean equalsOne(int n, int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != n) continue;
            return true;
        }
        return false;
    }

    public static boolean isSameOne(Object object, Object[] objectArray) {
        if (objectArray == null) {
            return false;
        }
        for (int i = 0; i < objectArray.length; ++i) {
            Object object2 = objectArray[i];
            if (object != object2) continue;
            return true;
        }
        return false;
    }

    public static String normalize(String string) {
        return string == null ? "" : string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void checkDisplaySettings() {
        int n = Config.getAntialiasingLevel();
        if (n > 0) {
            DisplayMode displayMode = Display.getDisplayMode();
            Config.dbg("FSAA Samples: " + n);
            try {
                Display.destroy();
                Display.setDisplayMode(displayMode);
                Display.create(new PixelFormat().withDepthBits(24).withSamples(n));
                if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                    Display.setResizable(false);
                    Display.setResizable(true);
                }
            }
            catch (LWJGLException lWJGLException) {
                Config.warn("Error setting FSAA: " + n + "x");
                lWJGLException.printStackTrace();
                try {
                    Display.setDisplayMode(displayMode);
                    Display.create(new PixelFormat().withDepthBits(24));
                    if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                        Display.setResizable(false);
                        Display.setResizable(true);
                    }
                }
                catch (LWJGLException lWJGLException2) {
                    lWJGLException2.printStackTrace();
                    try {
                        Display.setDisplayMode(displayMode);
                        Display.create();
                        if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                            Display.setResizable(false);
                            Display.setResizable(true);
                        }
                    }
                    catch (LWJGLException lWJGLException3) {
                        lWJGLException3.printStackTrace();
                    }
                }
            }
            if (!Minecraft.isRunningOnMac && Config.getDefaultResourcePack() != null) {
                InputStream inputStream2;
                InputStream inputStream3;
                block15: {
                    inputStream3 = null;
                    inputStream2 = null;
                    try {
                        inputStream3 = Config.getDefaultResourcePack().getInputStreamAssets(new ResourceLocation("icons/icon_16x16.png"));
                        inputStream2 = Config.getDefaultResourcePack().getInputStreamAssets(new ResourceLocation("icons/icon_32x32.png"));
                        if (inputStream3 == null || inputStream2 == null) break block15;
                        Display.setIcon(new ByteBuffer[]{Config.readIconImage(inputStream3), Config.readIconImage(inputStream2)});
                    }
                    catch (IOException iOException) {
                        try {
                            Config.warn("Error setting window icon: " + iOException.getClass().getName() + ": " + iOException.getMessage());
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
    }

    private static ByteBuffer readIconImage(InputStream inputStream2) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream2);
        int[] nArray = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 * nArray.length);
        for (int n : nArray) {
            byteBuffer.putInt(n << 8 | n >> 24 & 0xFF);
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    public static void checkDisplayMode() {
        try {
            if (minecraft.isFullScreen()) {
                if (fullscreenModeChecked) {
                    return;
                }
                fullscreenModeChecked = true;
                desktopModeChecked = false;
                DisplayMode displayMode = Display.getDisplayMode();
                Dimension dimension = Config.getFullscreenDimension();
                if (dimension == null) {
                    return;
                }
                if (displayMode.getWidth() == dimension.width && displayMode.getHeight() == dimension.height) {
                    return;
                }
                DisplayMode displayMode2 = Config.getDisplayMode(dimension);
                if (displayMode2 == null) {
                    return;
                }
                Display.setDisplayMode(displayMode2);
                Config.minecraft.displayWidth = Display.getDisplayMode().getWidth();
                Config.minecraft.displayHeight = Display.getDisplayMode().getHeight();
                if (Config.minecraft.displayWidth <= 0) {
                    Config.minecraft.displayWidth = 1;
                }
                if (Config.minecraft.displayHeight <= 0) {
                    Config.minecraft.displayHeight = 1;
                }
                if (Config.minecraft.currentScreen != null) {
                    ScaledResolution scaledResolution = new ScaledResolution(minecraft);
                    int n = scaledResolution.getScaledWidth();
                    int n2 = scaledResolution.getScaledHeight();
                    Config.minecraft.currentScreen.setWorldAndResolution(minecraft, n, n2);
                }
                Config.updateFramebufferSize();
                Display.setFullscreen(true);
                Config.minecraft.gameSettings.updateVSync();
                GlStateManager.enableTexture2D();
            } else {
                if (desktopModeChecked) {
                    return;
                }
                desktopModeChecked = true;
                fullscreenModeChecked = false;
                Config.minecraft.gameSettings.updateVSync();
                Display.update();
                GlStateManager.enableTexture2D();
                if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                    Display.setResizable(false);
                    Display.setResizable(true);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            Config.gameSettings.ofFullscreenMode = "Default";
            gameSettings.saveOfOptions();
        }
    }

    public static void updateFramebufferSize() {
        minecraft.getFramebuffer().createBindFramebuffer(Config.minecraft.displayWidth, Config.minecraft.displayHeight);
        if (Config.minecraft.entityRenderer != null) {
            Config.minecraft.entityRenderer.updateShaderGroupSize(Config.minecraft.displayWidth, Config.minecraft.displayHeight);
        }
        Config.minecraft.loadingScreen = new LoadingScreenRenderer(minecraft);
    }

    public static Object[] addObjectToArray(Object[] objectArray, Object object) {
        if (objectArray == null) {
            throw new NullPointerException("The given array is NULL");
        }
        int n = objectArray.length;
        int n2 = n + 1;
        Object[] objectArray2 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
        System.arraycopy(objectArray, 0, objectArray2, 0, n);
        objectArray2[n] = object;
        return objectArray2;
    }

    public static Object[] addObjectToArray(Object[] objectArray, Object object, int n) {
        ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList(objectArray));
        arrayList.add(n, object);
        Object[] objectArray2 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), arrayList.size());
        return arrayList.toArray(objectArray2);
    }

    public static Object[] addObjectsToArray(Object[] objectArray, Object[] objectArray2) {
        if (objectArray == null) {
            throw new NullPointerException("The given array is NULL");
        }
        if (objectArray2.length == 0) {
            return objectArray;
        }
        int n = objectArray.length;
        int n2 = n + objectArray2.length;
        Object[] objectArray3 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
        System.arraycopy(objectArray, 0, objectArray3, 0, n);
        System.arraycopy(objectArray2, 0, objectArray3, n, objectArray2.length);
        return objectArray3;
    }

    public static Object[] removeObjectFromArray(Object[] objectArray, Object object) {
        ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList(objectArray));
        arrayList.remove(object);
        Object[] objectArray2 = Config.collectionToArray(arrayList, objectArray.getClass().getComponentType());
        return objectArray2;
    }

    public static Object[] collectionToArray(Collection collection, Class clazz) {
        if (collection == null) {
            return null;
        }
        if (clazz == null) {
            return null;
        }
        if (clazz.isPrimitive()) {
            throw new IllegalArgumentException("Can not make arrays with primitive elements (int, double), element class: " + String.valueOf(clazz));
        }
        Object[] objectArray = (Object[])Array.newInstance(clazz, collection.size());
        return collection.toArray(objectArray);
    }

    public static boolean isCustomItems() {
        return Config.gameSettings.ofCustomItems;
    }

    public static void drawFps() {
        int n = Minecraft.getDebugFPS();
        String string = Config.getUpdates(Config.minecraft.debug);
        int n2 = Config.minecraft.renderGlobal.getCountActiveRenderers();
        int n3 = Config.minecraft.renderGlobal.getCountEntitiesRendered();
        int n4 = Config.minecraft.renderGlobal.getCountTileEntitiesRendered();
        String string2 = n + "/" + Config.getFpsMin() + " fps, C: " + n2 + ", E: " + n3 + "+" + n4 + ", U: " + string;
        Config.minecraft.fontRendererObj.drawString(string2, 2, 2, -2039584);
    }

    public static int getFpsMin() {
        long l;
        int n;
        if (Config.minecraft.debug == mcDebugLast) {
            return fpsMinLast;
        }
        mcDebugLast = Config.minecraft.debug;
        FrameTimer frameTimer = minecraft.getFrameTimer();
        long[] lArray = frameTimer.getFrames();
        int n2 = frameTimer.getIndex();
        if (n2 == (n = frameTimer.getLastIndex())) {
            return fpsMinLast;
        }
        int n3 = Minecraft.getDebugFPS();
        if (n3 <= 0) {
            n3 = 1;
        }
        long l2 = l = (long)(1.0 / (double)n3 * 1.0E9);
        long l3 = 0L;
        int n4 = MathHelper.normalizeAngle(n2 - 1, lArray.length);
        while (n4 != n && (double)l3 < 1.0E9) {
            long l4 = lArray[n4];
            if (l4 > l2) {
                l2 = l4;
            }
            l3 += l4;
            n4 = MathHelper.normalizeAngle(n4 - 1, lArray.length);
        }
        double d = (double)l2 / 1.0E9;
        fpsMinLast = (int)(1.0 / d);
        return fpsMinLast;
    }

    private static String getUpdates(String string) {
        int n = string.indexOf(40);
        if (n < 0) {
            return "";
        }
        int n2 = string.indexOf(32, n);
        return n2 < 0 ? "" : string.substring(n + 1, n2);
    }

    public static int getBitsOs() {
        String string = System.getenv("ProgramFiles(X86)");
        return string != null ? 64 : 32;
    }

    public static int getBitsJre() {
        String[] stringArray = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"};
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            String string2 = System.getProperty(string);
            if (string2 == null || !string2.contains("64")) continue;
            return 64;
        }
        return 32;
    }

    public static boolean isNotify64BitJava() {
        return notify64BitJava;
    }

    public static void setNotify64BitJava(boolean bl) {
        notify64BitJava = bl;
    }

    public static boolean isConnectedModels() {
        return false;
    }

    public static void showGuiMessage(String string, String string2) {
        GuiMessage guiMessage = new GuiMessage(Config.minecraft.currentScreen, string, string2);
        minecraft.displayGuiScreen(guiMessage);
    }

    public static int[] addIntToArray(int[] nArray, int n) {
        return Config.addIntsToArray(nArray, new int[]{n});
    }

    public static int[] addIntsToArray(int[] nArray, int[] nArray2) {
        if (nArray != null && nArray2 != null) {
            int n = nArray.length;
            int n2 = n + nArray2.length;
            int[] nArray3 = new int[n2];
            System.arraycopy(nArray, 0, nArray3, 0, n);
            for (int i = 0; i < nArray2.length; ++i) {
                nArray3[i + n] = nArray2[i];
            }
            return nArray3;
        }
        throw new NullPointerException("The given array is NULL");
    }

    public static DynamicTexture getMojangLogoTexture(DynamicTexture dynamicTexture) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation("textures/gui/title/mojang.png");
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                return dynamicTexture;
            }
            BufferedImage bufferedImage = ImageIO.read(inputStream2);
            if (bufferedImage == null) {
                return dynamicTexture;
            }
            DynamicTexture dynamicTexture2 = new DynamicTexture(bufferedImage);
            return dynamicTexture2;
        }
        catch (Exception exception) {
            Config.warn(exception.getClass().getName() + ": " + exception.getMessage());
            return dynamicTexture;
        }
    }

    public static void writeFile(File file, String string) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] byArray = string.getBytes("ASCII");
        fileOutputStream.write(byArray);
        fileOutputStream.close();
    }

    public static TextureMap getTextureMap() {
        return Config.getMinecraft().getTextureMapBlocks();
    }

    public static boolean isDynamicLights() {
        return Config.gameSettings.ofDynamicLights != 3;
    }

    public static boolean isDynamicLightsFast() {
        return Config.gameSettings.ofDynamicLights == 1;
    }

    public static boolean isDynamicHandLight() {
        return !Config.isDynamicLights() ? false : (Config.isShaders() ? Shaders.isDynamicHandLight() : true);
    }

    public static boolean isCustomEntityModels() {
        return Config.gameSettings.ofCustomEntityModels;
    }

    public static boolean isCustomGuis() {
        return Config.gameSettings.ofCustomGuis;
    }

    public static int getScreenshotSize() {
        return Config.gameSettings.ofScreenshotSize;
    }

    public static int[] toPrimitive(Integer[] integerArray) {
        if (integerArray == null) {
            return null;
        }
        if (integerArray.length == 0) {
            return new int[0];
        }
        int[] nArray = new int[integerArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = integerArray[i];
        }
        return nArray;
    }

    public static boolean isRenderRegions() {
        return Config.gameSettings.ofRenderRegions;
    }

    public static boolean isVbo() {
        return OpenGlHelper.useVbo();
    }

    public static boolean isSmoothFps() {
        return Config.gameSettings.ofSmoothFps;
    }

    public static boolean openWebLink(URI uRI) {
        try {
            Desktop.getDesktop().browse(uRI);
            return true;
        }
        catch (Exception exception) {
            Config.warn("Error opening link: " + String.valueOf(uRI));
            Config.warn(exception.getClass().getName() + ": " + exception.getMessage());
            return false;
        }
    }

    public static boolean isShowGlErrors() {
        return Config.gameSettings.ofShowGlErrors;
    }

    public static String arrayToString(boolean[] blArray, String string) {
        if (blArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(blArray.length * 5);
        for (int i = 0; i < blArray.length; ++i) {
            boolean bl = blArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(bl));
        }
        return stringBuffer.toString();
    }

    public static boolean isIntegratedServerRunning() {
        return minecraft.getIntegratedServer() == null ? false : minecraft.isIntegratedServerRunning();
    }

    public static IntBuffer createDirectIntBuffer(int n) {
        return GLAllocation.createDirectByteBuffer(n << 2).asIntBuffer();
    }

    public static String getGlErrorString(int n) {
        switch (n) {
            case 0: {
                return "No error";
            }
            case 1280: {
                return "Invalid enum";
            }
            case 1281: {
                return "Invalid value";
            }
            case 1282: {
                return "Invalid operation";
            }
            case 1283: {
                return "Stack overflow";
            }
            case 1284: {
                return "Stack underflow";
            }
            case 1285: {
                return "Out of memory";
            }
            case 1286: {
                return "Invalid framebuffer operation";
            }
        }
        return "Unknown";
    }

    public static boolean isTrue(Boolean bl) {
        return bl != null && bl != false;
    }

    public static boolean isQuadsToTriangles() {
        return !Config.isShaders() ? false : !Shaders.canRenderQuads();
    }

    public static void checkNull(Object object, String string) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException(string);
        }
    }
}

