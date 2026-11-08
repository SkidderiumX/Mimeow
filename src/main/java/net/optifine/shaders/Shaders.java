/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import com.google.common.base.Charsets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.invoke.CallSite;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.optifine.CustomBlockLayers;
import net.optifine.CustomColors;
import net.optifine.GlErrors;
import net.optifine.Lang;
import net.optifine.config.ConnectedParser;
import net.optifine.expr.IExpressionBool;
import net.optifine.reflect.Reflector;
import net.optifine.render.GlAlphaState;
import net.optifine.render.GlBlendState;
import net.optifine.shaders.BlockAliases;
import net.optifine.shaders.CustomTexture;
import net.optifine.shaders.CustomTextureLocation;
import net.optifine.shaders.CustomTextureRaw;
import net.optifine.shaders.EntityAliases;
import net.optifine.shaders.FlipTextures;
import net.optifine.shaders.HFNoiseTexture;
import net.optifine.shaders.ICustomTexture;
import net.optifine.shaders.IShaderPack;
import net.optifine.shaders.ItemAliases;
import net.optifine.shaders.Program;
import net.optifine.shaders.ProgramStack;
import net.optifine.shaders.ProgramStage;
import net.optifine.shaders.Programs;
import net.optifine.shaders.SMCLog;
import net.optifine.shaders.SMath;
import net.optifine.shaders.ShaderPackDefault;
import net.optifine.shaders.ShaderPackFolder;
import net.optifine.shaders.ShaderPackNone;
import net.optifine.shaders.ShaderPackZip;
import net.optifine.shaders.ShaderUtils;
import net.optifine.shaders.ShadersRender;
import net.optifine.shaders.ShadersTex;
import net.optifine.shaders.SimpleShaderTexture;
import net.optifine.shaders.config.EnumShaderOption;
import net.optifine.shaders.config.MacroProcessor;
import net.optifine.shaders.config.MacroState;
import net.optifine.shaders.config.PropertyDefaultFastFancyOff;
import net.optifine.shaders.config.PropertyDefaultTrueFalse;
import net.optifine.shaders.config.RenderScale;
import net.optifine.shaders.config.ScreenShaderOptions;
import net.optifine.shaders.config.ShaderLine;
import net.optifine.shaders.config.ShaderOption;
import net.optifine.shaders.config.ShaderOptionProfile;
import net.optifine.shaders.config.ShaderOptionRest;
import net.optifine.shaders.config.ShaderPackParser;
import net.optifine.shaders.config.ShaderParser;
import net.optifine.shaders.config.ShaderProfile;
import net.optifine.shaders.uniform.CustomUniforms;
import net.optifine.shaders.uniform.ShaderUniform1f;
import net.optifine.shaders.uniform.ShaderUniform1i;
import net.optifine.shaders.uniform.ShaderUniform2i;
import net.optifine.shaders.uniform.ShaderUniform3f;
import net.optifine.shaders.uniform.ShaderUniform4f;
import net.optifine.shaders.uniform.ShaderUniform4i;
import net.optifine.shaders.uniform.ShaderUniformM4;
import net.optifine.shaders.uniform.ShaderUniforms;
import net.optifine.shaders.uniform.Smoother;
import net.optifine.texture.InternalFormat;
import net.optifine.texture.PixelFormat;
import net.optifine.texture.PixelType;
import net.optifine.texture.TextureType;
import net.optifine.util.EntityUtils;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.StrUtils;
import net.optifine.util.TimedEvent;
import org.apache.commons.io.IOUtils;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBGeometryShader4;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector4f;
import x.oc170ea29aae;
import x.oc30aea91d28;

public class Shaders {
    static Minecraft mc = Minecraft.getMinecraft();
    static EntityRenderer entityRenderer;
    public static boolean isInitializedOnce;
    public static boolean isShaderPackInitialized;
    public static ContextCapabilities capabilities;
    public static String glVersionString;
    public static String glVendorString;
    public static String glRendererString;
    public static boolean hasGlGenMipmap;
    public static int countResetDisplayLists;
    private static int renderDisplayWidth;
    private static int renderDisplayHeight;
    public static int renderWidth;
    public static int renderHeight;
    public static boolean isRenderingWorld;
    public static boolean isRenderingSky;
    public static boolean isCompositeRendered;
    public static boolean isRenderingDfb;
    public static boolean isShadowPass;
    public static boolean isEntitiesGlowing;
    public static boolean isSleeping;
    private static boolean isRenderingFirstPersonHand;
    private static boolean isHandRenderedMain;
    private static boolean isHandRenderedOff;
    private static boolean skipRenderHandMain;
    private static boolean skipRenderHandOff;
    public static boolean renderItemKeepDepthMask;
    public static boolean itemToRenderMainTranslucent;
    public static boolean itemToRenderOffTranslucent;
    static float[] sunPosition;
    static float[] moonPosition;
    static float[] shadowLightPosition;
    static float[] upPosition;
    static float[] shadowLightPositionVector;
    static float[] upPosModelView;
    static float[] sunPosModelView;
    static float[] moonPosModelView;
    private static float[] tempMat;
    static float clearColorR;
    static float clearColorG;
    static float clearColorB;
    static float skyColorR;
    static float skyColorG;
    static float skyColorB;
    static long worldTime;
    static long lastWorldTime;
    static long diffWorldTime;
    static float celestialAngle;
    static float sunAngle;
    static float shadowAngle;
    static int moonPhase;
    static long systemTime;
    static long lastSystemTime;
    static long diffSystemTime;
    static int frameCounter;
    static float frameTime;
    static float frameTimeCounter;
    static int systemTimeInt32;
    static float rainStrength;
    static float wetness;
    public static float wetnessHalfLife;
    public static float drynessHalfLife;
    public static float eyeBrightnessHalflife;
    static boolean usewetness;
    static int isEyeInWater;
    static int eyeBrightness;
    static float eyeBrightnessFadeX;
    static float eyeBrightnessFadeY;
    static float eyePosY;
    static float centerDepth;
    static float centerDepthSmooth;
    static float centerDepthSmoothHalflife;
    static boolean centerDepthSmoothEnabled;
    static int superSamplingLevel;
    static float nightVision;
    static float blindness;
    static boolean lightmapEnabled;
    static boolean fogEnabled;
    public static int entityAttrib;
    public static int midTexCoordAttrib;
    public static int tangentAttrib;
    public static boolean useEntityAttrib;
    public static boolean useMidTexCoordAttrib;
    public static boolean useTangentAttrib;
    public static boolean progUseEntityAttrib;
    public static boolean progUseMidTexCoordAttrib;
    public static boolean progUseTangentAttrib;
    private static boolean progArbGeometryShader4;
    private static int progMaxVerticesOut;
    private static boolean hasGeometryShaders;
    public static int atlasSizeX;
    public static int atlasSizeY;
    private static ShaderUniforms shaderUniforms;
    public static ShaderUniform4f uniform_entityColor;
    public static ShaderUniform1i uniform_entityId;
    public static ShaderUniform1i uniform_blockEntityId;
    public static ShaderUniform1i uniform_texture;
    public static ShaderUniform1i uniform_lightmap;
    public static ShaderUniform1i uniform_normals;
    public static ShaderUniform1i uniform_specular;
    public static ShaderUniform1i uniform_shadow;
    public static ShaderUniform1i uniform_watershadow;
    public static ShaderUniform1i uniform_shadowtex0;
    public static ShaderUniform1i uniform_shadowtex1;
    public static ShaderUniform1i uniform_depthtex0;
    public static ShaderUniform1i uniform_depthtex1;
    public static ShaderUniform1i uniform_shadowcolor;
    public static ShaderUniform1i uniform_shadowcolor0;
    public static ShaderUniform1i uniform_shadowcolor1;
    public static ShaderUniform1i uniform_noisetex;
    public static ShaderUniform1i uniform_gcolor;
    public static ShaderUniform1i uniform_gdepth;
    public static ShaderUniform1i uniform_gnormal;
    public static ShaderUniform1i uniform_composite;
    public static ShaderUniform1i uniform_gaux1;
    public static ShaderUniform1i uniform_gaux2;
    public static ShaderUniform1i uniform_gaux3;
    public static ShaderUniform1i uniform_gaux4;
    public static ShaderUniform1i uniform_colortex0;
    public static ShaderUniform1i uniform_colortex1;
    public static ShaderUniform1i uniform_colortex2;
    public static ShaderUniform1i uniform_colortex3;
    public static ShaderUniform1i uniform_colortex4;
    public static ShaderUniform1i uniform_colortex5;
    public static ShaderUniform1i uniform_colortex6;
    public static ShaderUniform1i uniform_colortex7;
    public static ShaderUniform1i uniform_gdepthtex;
    public static ShaderUniform1i uniform_depthtex2;
    public static ShaderUniform1i uniform_tex;
    public static ShaderUniform1i uniform_heldItemId;
    public static ShaderUniform1i uniform_heldBlockLightValue;
    public static ShaderUniform1i uniform_heldItemId2;
    public static ShaderUniform1i uniform_heldBlockLightValue2;
    public static ShaderUniform1i uniform_fogMode;
    public static ShaderUniform1f uniform_fogDensity;
    public static ShaderUniform3f uniform_fogColor;
    public static ShaderUniform3f uniform_skyColor;
    public static ShaderUniform1i uniform_worldTime;
    public static ShaderUniform1i uniform_worldDay;
    public static ShaderUniform1i uniform_moonPhase;
    public static ShaderUniform1i uniform_frameCounter;
    public static ShaderUniform1f uniform_frameTime;
    public static ShaderUniform1f uniform_frameTimeCounter;
    public static ShaderUniform1f uniform_sunAngle;
    public static ShaderUniform1f uniform_shadowAngle;
    public static ShaderUniform1f uniform_rainStrength;
    public static ShaderUniform1f uniform_aspectRatio;
    public static ShaderUniform1f uniform_viewWidth;
    public static ShaderUniform1f uniform_viewHeight;
    public static ShaderUniform1f uniform_near;
    public static ShaderUniform1f uniform_far;
    public static ShaderUniform3f uniform_sunPosition;
    public static ShaderUniform3f uniform_moonPosition;
    public static ShaderUniform3f uniform_shadowLightPosition;
    public static ShaderUniform3f uniform_upPosition;
    public static ShaderUniform3f uniform_previousCameraPosition;
    public static ShaderUniform3f uniform_cameraPosition;
    public static ShaderUniformM4 uniform_gbufferModelView;
    public static ShaderUniformM4 uniform_gbufferModelViewInverse;
    public static ShaderUniformM4 uniform_gbufferPreviousProjection;
    public static ShaderUniformM4 uniform_gbufferProjection;
    public static ShaderUniformM4 uniform_gbufferProjectionInverse;
    public static ShaderUniformM4 uniform_gbufferPreviousModelView;
    public static ShaderUniformM4 uniform_shadowProjection;
    public static ShaderUniformM4 uniform_shadowProjectionInverse;
    public static ShaderUniformM4 uniform_shadowModelView;
    public static ShaderUniformM4 uniform_shadowModelViewInverse;
    public static ShaderUniform1f uniform_wetness;
    public static ShaderUniform1f uniform_eyeAltitude;
    public static ShaderUniform2i uniform_eyeBrightness;
    public static ShaderUniform2i uniform_eyeBrightnessSmooth;
    public static ShaderUniform2i uniform_terrainTextureSize;
    public static ShaderUniform1i uniform_terrainIconSize;
    public static ShaderUniform1i uniform_isEyeInWater;
    public static ShaderUniform1f uniform_nightVision;
    public static ShaderUniform1f uniform_blindness;
    public static ShaderUniform1f uniform_screenBrightness;
    public static ShaderUniform1i uniform_hideGUI;
    public static ShaderUniform1f uniform_centerDepthSmooth;
    public static ShaderUniform2i uniform_atlasSize;
    public static ShaderUniform4i uniform_blendFunc;
    public static ShaderUniform1i uniform_instanceId;
    static double previousCameraPositionX;
    static double previousCameraPositionY;
    static double previousCameraPositionZ;
    static double cameraPositionX;
    static double cameraPositionY;
    static double cameraPositionZ;
    static int cameraOffsetX;
    static int cameraOffsetZ;
    static int shadowPassInterval;
    public static boolean needResizeShadow;
    static int shadowMapWidth;
    static int shadowMapHeight;
    static int spShadowMapWidth;
    static int spShadowMapHeight;
    static float shadowMapFOV;
    static float shadowMapHalfPlane;
    static boolean shadowMapIsOrtho;
    static float shadowDistanceRenderMul;
    static int shadowPassCounter;
    static int preShadowPassThirdPersonView;
    public static boolean shouldSkipDefaultShadow;
    static boolean waterShadowEnabled;
    static final int MaxDrawBuffers = 8;
    static final int MaxColorBuffers = 8;
    static final int MaxDepthBuffers = 3;
    static final int MaxShadowColorBuffers = 8;
    static final int MaxShadowDepthBuffers = 2;
    static int usedColorBuffers;
    static int usedDepthBuffers;
    static int usedShadowColorBuffers;
    static int usedShadowDepthBuffers;
    static int usedColorAttachs;
    static int usedDrawBuffers;
    static int dfb;
    static int sfb;
    private static int[] gbuffersFormat;
    public static boolean[] gbuffersClear;
    public static Vector4f[] gbuffersClearColor;
    private static Programs programs;
    public static final Program ProgramNone;
    public static final Program ProgramShadow;
    public static final Program ProgramShadowSolid;
    public static final Program ProgramShadowCutout;
    public static final Program ProgramBasic;
    public static final Program ProgramTextured;
    public static final Program ProgramTexturedLit;
    public static final Program ProgramSkyBasic;
    public static final Program ProgramSkyTextured;
    public static final Program ProgramClouds;
    public static final Program ProgramTerrain;
    public static final Program ProgramTerrainSolid;
    public static final Program ProgramTerrainCutoutMip;
    public static final Program ProgramTerrainCutout;
    public static final Program ProgramDamagedBlock;
    public static final Program ProgramBlock;
    public static final Program ProgramBeaconBeam;
    public static final Program ProgramItem;
    public static final Program ProgramEntities;
    public static final Program ProgramEntitiesGlowing;
    public static final Program ProgramArmorGlint;
    public static final Program ProgramSpiderEyes;
    public static final Program ProgramHand;
    public static final Program ProgramWeather;
    public static final Program ProgramDeferredPre;
    public static final Program[] ProgramsDeferred;
    public static final Program ProgramDeferred;
    public static final Program ProgramWater;
    public static final Program ProgramHandWater;
    public static final Program ProgramCompositePre;
    public static final Program[] ProgramsComposite;
    public static final Program ProgramComposite;
    public static final Program ProgramFinal;
    public static final int ProgramCount;
    public static final Program[] ProgramsAll;
    public static Program activeProgram;
    public static int activeProgramID;
    private static ProgramStack programStack;
    private static boolean hasDeferredPrograms;
    static IntBuffer activeDrawBuffers;
    private static int activeCompositeMipmapSetting;
    public static Properties loadedShaders;
    public static Properties shadersConfig;
    public static ITextureObject defaultTexture;
    public static boolean[] shadowHardwareFilteringEnabled;
    public static boolean[] shadowMipmapEnabled;
    public static boolean[] shadowFilterNearest;
    public static boolean[] shadowColorMipmapEnabled;
    public static boolean[] shadowColorFilterNearest;
    public static boolean configTweakBlockDamage;
    public static boolean configCloudShadow;
    public static float configHandDepthMul;
    public static float configRenderResMul;
    public static float configShadowResMul;
    public static int configTexMinFilB;
    public static int configTexMinFilN;
    public static int configTexMinFilS;
    public static int configTexMagFilB;
    public static int configTexMagFilN;
    public static int configTexMagFilS;
    public static boolean configShadowClipFrustrum;
    public static boolean configNormalMap;
    public static boolean configSpecularMap;
    public static PropertyDefaultTrueFalse configOldLighting;
    public static PropertyDefaultTrueFalse configOldHandLight;
    public static int configAntialiasingLevel;
    public static final int texMinFilRange = 3;
    public static final int texMagFilRange = 2;
    public static final String[] texMinFilDesc;
    public static final String[] texMagFilDesc;
    public static final int[] texMinFilValue;
    public static final int[] texMagFilValue;
    private static IShaderPack shaderPack;
    public static boolean shaderPackLoaded;
    public static String currentShaderName;
    public static final String SHADER_PACK_NAME_NONE = "OFF";
    public static final String SHADER_PACK_NAME_DEFAULT = "(internal)";
    public static final String SHADER_PACKS_DIR_NAME = "shaderpacks";
    public static final String OPTIONS_FILE_NAME = "optionsshaders.txt";
    public static final File shaderPacksDir;
    static File configFile;
    private static ShaderOption[] shaderPackOptions;
    private static Set<String> shaderPackOptionSliders;
    static ShaderProfile[] shaderPackProfiles;
    static Map<String, ScreenShaderOptions> shaderPackGuiScreens;
    static Map<String, IExpressionBool> shaderPackProgramConditions;
    public static final String PATH_SHADERS_PROPERTIES = "/shaders/shaders.properties";
    public static PropertyDefaultFastFancyOff shaderPackClouds;
    public static PropertyDefaultTrueFalse shaderPackOldLighting;
    public static PropertyDefaultTrueFalse shaderPackOldHandLight;
    public static PropertyDefaultTrueFalse shaderPackDynamicHandLight;
    public static PropertyDefaultTrueFalse shaderPackShadowTranslucent;
    public static PropertyDefaultTrueFalse shaderPackUnderwaterOverlay;
    public static PropertyDefaultTrueFalse shaderPackSun;
    public static PropertyDefaultTrueFalse shaderPackMoon;
    public static PropertyDefaultTrueFalse shaderPackVignette;
    public static PropertyDefaultTrueFalse shaderPackBackFaceSolid;
    public static PropertyDefaultTrueFalse shaderPackBackFaceCutout;
    public static PropertyDefaultTrueFalse shaderPackBackFaceCutoutMipped;
    public static PropertyDefaultTrueFalse shaderPackBackFaceTranslucent;
    public static PropertyDefaultTrueFalse shaderPackRainDepth;
    public static PropertyDefaultTrueFalse shaderPackBeaconBeamDepth;
    public static PropertyDefaultTrueFalse shaderPackSeparateAo;
    public static PropertyDefaultTrueFalse shaderPackFrustumCulling;
    private static Map<String, String> shaderPackResources;
    private static World currentWorld;
    private static List<Integer> shaderPackDimensions;
    private static ICustomTexture[] customTexturesGbuffers;
    private static ICustomTexture[] customTexturesComposite;
    private static ICustomTexture[] customTexturesDeferred;
    private static String noiseTexturePath;
    private static CustomUniforms customUniforms;
    private static final int STAGE_GBUFFERS = 0;
    private static final int STAGE_COMPOSITE = 1;
    private static final int STAGE_DEFERRED = 2;
    private static final String[] STAGE_NAMES;
    public static final boolean enableShadersOption = true;
    private static final boolean enableShadersDebug = true;
    public static final boolean saveFinalShaders;
    public static float blockLightLevel05;
    public static float blockLightLevel06;
    public static float blockLightLevel08;
    public static float aoLevel;
    public static float sunPathRotation;
    public static float shadowAngleInterval;
    public static int fogMode;
    public static float fogDensity;
    public static float fogColorR;
    public static float fogColorG;
    public static float fogColorB;
    public static float shadowIntervalSize;
    public static int terrainIconSize;
    public static int[] terrainTextureSize;
    private static ICustomTexture noiseTexture;
    private static boolean noiseTextureEnabled;
    private static int noiseTextureResolution;
    static final int[] colorTextureImageUnit;
    private static final int bigBufferSize;
    private static final ByteBuffer bigBuffer;
    static final float[] faProjection;
    static final float[] faProjectionInverse;
    static final float[] faModelView;
    static final float[] faModelViewInverse;
    static final float[] faShadowProjection;
    static final float[] faShadowProjectionInverse;
    static final float[] faShadowModelView;
    static final float[] faShadowModelViewInverse;
    static final FloatBuffer projection;
    static final FloatBuffer projectionInverse;
    static final FloatBuffer modelView;
    static final FloatBuffer modelViewInverse;
    static final FloatBuffer shadowProjection;
    static final FloatBuffer shadowProjectionInverse;
    static final FloatBuffer shadowModelView;
    static final FloatBuffer shadowModelViewInverse;
    static final FloatBuffer previousProjection;
    static final FloatBuffer previousModelView;
    static final FloatBuffer tempMatrixDirectBuffer;
    static final FloatBuffer tempDirectFloatBuffer;
    static final IntBuffer dfbColorTextures;
    static final IntBuffer dfbDepthTextures;
    static final IntBuffer sfbColorTextures;
    static final IntBuffer sfbDepthTextures;
    static final IntBuffer dfbDrawBuffers;
    static final IntBuffer sfbDrawBuffers;
    static final IntBuffer drawBuffersNone;
    static final IntBuffer drawBuffersColorAtt0;
    static final FlipTextures dfbColorTexturesFlip;
    static Map<Block, Integer> mapBlockToEntityData;
    private static final String[] formatNames;
    private static final int[] formatIds;
    private static final Pattern patternLoadEntityDataMap;
    public static int[] entityData;
    public static int entityDataIndex;

    private static ByteBuffer nextByteBuffer(int n) {
        ByteBuffer byteBuffer = bigBuffer;
        int n2 = byteBuffer.limit();
        byteBuffer.position(n2).limit(n2 + n);
        return byteBuffer.slice();
    }

    public static IntBuffer nextIntBuffer(int n) {
        ByteBuffer byteBuffer = bigBuffer;
        int n2 = byteBuffer.limit();
        byteBuffer.position(n2).limit(n2 + n * 4);
        return byteBuffer.asIntBuffer();
    }

    private static FloatBuffer nextFloatBuffer(int n) {
        ByteBuffer byteBuffer = bigBuffer;
        int n2 = byteBuffer.limit();
        byteBuffer.position(n2).limit(n2 + n * 4);
        return byteBuffer.asFloatBuffer();
    }

    private static IntBuffer[] nextIntBufferArray(int n, int n2) {
        IntBuffer[] intBufferArray = new IntBuffer[n];
        for (int i = 0; i < n; ++i) {
            intBufferArray[i] = Shaders.nextIntBuffer(n2);
        }
        return intBufferArray;
    }

    public static void loadConfig() {
        Object object;
        SMCLog.info("Load shaders configuration.");
        try {
            if (!shaderPacksDir.exists()) {
                shaderPacksDir.mkdir();
            }
        }
        catch (Exception exception) {
            SMCLog.severe("Failed to open the shaderpacks directory: " + String.valueOf(shaderPacksDir));
        }
        shadersConfig = new PropertiesOrdered();
        shadersConfig.setProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), "");
        if (configFile.exists()) {
            try {
                object = new FileReader(configFile);
                shadersConfig.load((Reader)object);
                ((InputStreamReader)object).close();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (!configFile.exists()) {
            try {
                Shaders.storeConfig();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        object = EnumShaderOption.values();
        for (int i = 0; i < ((EnumShaderOption[])object).length; ++i) {
            Object object2 = object[i];
            String string = ((EnumShaderOption)((Object)object2)).getPropertyKey();
            String string2 = ((EnumShaderOption)((Object)object2)).getValueDefault();
            String string3 = shadersConfig.getProperty(string, string2);
            Shaders.setEnumShaderOption((EnumShaderOption)((Object)object2), string3);
        }
        Shaders.loadShaderPack();
    }

    private static void setEnumShaderOption(EnumShaderOption enumShaderOption, String string) {
        if (string == null) {
            string = enumShaderOption.getValueDefault();
        }
        switch (enumShaderOption) {
            case ANTIALIASING: {
                configAntialiasingLevel = Config.parseInt(string, 0);
                break;
            }
            case NORMAL_MAP: {
                configNormalMap = Config.parseBoolean(string, true);
                break;
            }
            case SPECULAR_MAP: {
                configSpecularMap = Config.parseBoolean(string, true);
                break;
            }
            case RENDER_RES_MUL: {
                configRenderResMul = Config.parseFloat(string, 1.0f);
                break;
            }
            case SHADOW_RES_MUL: {
                configShadowResMul = Config.parseFloat(string, 1.0f);
                break;
            }
            case HAND_DEPTH_MUL: {
                configHandDepthMul = Config.parseFloat(string, 0.125f);
                break;
            }
            case CLOUD_SHADOW: {
                configCloudShadow = Config.parseBoolean(string, true);
                break;
            }
            case OLD_HAND_LIGHT: {
                configOldHandLight.setPropertyValue(string);
                break;
            }
            case OLD_LIGHTING: {
                configOldLighting.setPropertyValue(string);
                break;
            }
            case SHADER_PACK: {
                currentShaderName = string;
                break;
            }
            case TWEAK_BLOCK_DAMAGE: {
                configTweakBlockDamage = Config.parseBoolean(string, true);
                break;
            }
            case SHADOW_CLIP_FRUSTRUM: {
                configShadowClipFrustrum = Config.parseBoolean(string, true);
                break;
            }
            case TEX_MIN_FIL_B: {
                configTexMinFilB = Config.parseInt(string, 0);
                break;
            }
            case TEX_MIN_FIL_N: {
                configTexMinFilN = Config.parseInt(string, 0);
                break;
            }
            case TEX_MIN_FIL_S: {
                configTexMinFilS = Config.parseInt(string, 0);
                break;
            }
            case TEX_MAG_FIL_B: {
                configTexMagFilB = Config.parseInt(string, 0);
                break;
            }
            case TEX_MAG_FIL_N: {
                configTexMagFilB = Config.parseInt(string, 0);
                break;
            }
            case TEX_MAG_FIL_S: {
                configTexMagFilB = Config.parseInt(string, 0);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown option: " + String.valueOf((Object)enumShaderOption));
            }
        }
    }

    public static void storeConfig() {
        SMCLog.info("Save shaders configuration.");
        if (shadersConfig == null) {
            shadersConfig = new PropertiesOrdered();
        }
        EnumShaderOption[] enumShaderOptionArray = EnumShaderOption.values();
        for (int i = 0; i < enumShaderOptionArray.length; ++i) {
            EnumShaderOption enumShaderOption = enumShaderOptionArray[i];
            String string = enumShaderOption.getPropertyKey();
            String string2 = Shaders.getEnumShaderOption(enumShaderOption);
            shadersConfig.setProperty(string, string2);
        }
        try {
            FileWriter fileWriter = new FileWriter(configFile);
            shadersConfig.store(fileWriter, (String)null);
            fileWriter.close();
        }
        catch (Exception exception) {
            SMCLog.severe("Error saving configuration: " + exception.getClass().getName() + ": " + exception.getMessage());
        }
    }

    public static String getEnumShaderOption(EnumShaderOption enumShaderOption) {
        switch (enumShaderOption) {
            case ANTIALIASING: {
                return Integer.toString(configAntialiasingLevel);
            }
            case NORMAL_MAP: {
                return Boolean.toString(configNormalMap);
            }
            case SPECULAR_MAP: {
                return Boolean.toString(configSpecularMap);
            }
            case RENDER_RES_MUL: {
                return Float.toString(configRenderResMul);
            }
            case SHADOW_RES_MUL: {
                return Float.toString(configShadowResMul);
            }
            case HAND_DEPTH_MUL: {
                return Float.toString(configHandDepthMul);
            }
            case CLOUD_SHADOW: {
                return Boolean.toString(configCloudShadow);
            }
            case OLD_HAND_LIGHT: {
                return configOldHandLight.getPropertyValue();
            }
            case OLD_LIGHTING: {
                return configOldLighting.getPropertyValue();
            }
            case SHADER_PACK: {
                return currentShaderName;
            }
            case TWEAK_BLOCK_DAMAGE: {
                return Boolean.toString(configTweakBlockDamage);
            }
            case SHADOW_CLIP_FRUSTRUM: {
                return Boolean.toString(configShadowClipFrustrum);
            }
            case TEX_MIN_FIL_B: {
                return Integer.toString(configTexMinFilB);
            }
            case TEX_MIN_FIL_N: {
                return Integer.toString(configTexMinFilN);
            }
            case TEX_MIN_FIL_S: {
                return Integer.toString(configTexMinFilS);
            }
            case TEX_MAG_FIL_B: {
                return Integer.toString(configTexMagFilB);
            }
            case TEX_MAG_FIL_N: {
                return Integer.toString(configTexMagFilB);
            }
            case TEX_MAG_FIL_S: {
                return Integer.toString(configTexMagFilB);
            }
        }
        throw new IllegalArgumentException("Unknown option: " + String.valueOf((Object)enumShaderOption));
    }

    public static void setShaderPack(String string) {
        currentShaderName = string;
        shadersConfig.setProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), string);
        Shaders.loadShaderPack();
    }

    public static void loadShaderPack() {
        boolean bl;
        boolean bl2 = shaderPackLoaded;
        boolean bl3 = Shaders.isOldLighting();
        if (Shaders.mc.renderGlobal != null) {
            Shaders.mc.renderGlobal.pauseChunkUpdates();
        }
        shaderPackLoaded = false;
        if (shaderPack != null) {
            shaderPack.close();
            shaderPack = null;
            shaderPackResources.clear();
            shaderPackDimensions.clear();
            shaderPackOptions = null;
            shaderPackOptionSliders = null;
            shaderPackProfiles = null;
            shaderPackGuiScreens = null;
            shaderPackProgramConditions.clear();
            shaderPackClouds.resetValue();
            shaderPackOldHandLight.resetValue();
            shaderPackDynamicHandLight.resetValue();
            shaderPackOldLighting.resetValue();
            Shaders.resetCustomTextures();
            noiseTexturePath = null;
        }
        boolean bl4 = false;
        if (Config.isAntialiasing()) {
            SMCLog.info("Shaders can not be loaded, Antialiasing is enabled: " + Config.getAntialiasingLevel() + "x");
            bl4 = true;
        }
        if (Config.isAnisotropicFiltering()) {
            SMCLog.info("Shaders can not be loaded, Anisotropic Filtering is enabled: " + Config.getAnisotropicFilterLevel() + "x");
            bl4 = true;
        }
        if (Config.isFastRender()) {
            SMCLog.info("Shaders can not be loaded, Fast Render is enabled.");
            bl4 = true;
        }
        String string = shadersConfig.getProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), SHADER_PACK_NAME_DEFAULT);
        if (!bl4) {
            shaderPack = Shaders.getShaderPack(string);
            boolean bl5 = shaderPackLoaded = shaderPack != null;
        }
        if (shaderPackLoaded) {
            SMCLog.info("Loaded shaderpack: " + Shaders.getShaderPackName());
        } else {
            SMCLog.info("No shaderpack loaded.");
            shaderPack = new ShaderPackNone();
        }
        if (saveFinalShaders) {
            Shaders.clearDirectory(new File(shaderPacksDir, "debug"));
        }
        Shaders.loadShaderPackResources();
        Shaders.loadShaderPackDimensions();
        shaderPackOptions = Shaders.loadShaderPackOptions();
        Shaders.loadShaderPackProperties();
        boolean bl6 = shaderPackLoaded != bl2;
        boolean bl7 = bl = Shaders.isOldLighting() != bl3;
        if (bl6 || bl) {
            DefaultVertexFormats.updateVertexFormats();
            if (Reflector.LightUtil.exists()) {
                Reflector.LightUtil_itemConsumer.setValue(null);
                Reflector.LightUtil_tessellator.setValue(null);
            }
            Shaders.updateBlockLightLevel();
        }
        if (mc.getResourcePackRepository() != null) {
            CustomBlockLayers.update();
        }
        if (Shaders.mc.renderGlobal != null) {
            Shaders.mc.renderGlobal.resumeChunkUpdates();
        }
        if ((bl6 || bl) && mc.getResourceManager() != null) {
            mc.scheduleResourcesRefresh();
        }
    }

    public static IShaderPack getShaderPack(String string) {
        if (string == null) {
            return null;
        }
        if (!(string = string.trim()).isEmpty() && !string.equals(SHADER_PACK_NAME_NONE)) {
            if (string.equals(SHADER_PACK_NAME_DEFAULT)) {
                return new ShaderPackDefault();
            }
            try {
                File file = new File(shaderPacksDir, string);
                return file.isDirectory() ? new ShaderPackFolder(string, file) : (file.isFile() && string.toLowerCase().endsWith(".zip") ? new ShaderPackZip(string, file) : null);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static IShaderPack getShaderPack() {
        return shaderPack;
    }

    private static void loadShaderPackDimensions() {
        shaderPackDimensions.clear();
        for (int i = -128; i <= 128; ++i) {
            String string = "/shaders/world" + i;
            if (!shaderPack.hasDirectory(string)) continue;
            shaderPackDimensions.add(i);
        }
        if (shaderPackDimensions.size() > 0) {
            Integer[] integerArray = shaderPackDimensions.toArray(new Integer[shaderPackDimensions.size()]);
            Config.dbg("[Shaders] Worlds: " + Config.arrayToString((Object[])integerArray));
        }
    }

    private static void loadShaderPackProperties() {
        Object object;
        shaderPackClouds.resetValue();
        shaderPackOldHandLight.resetValue();
        shaderPackDynamicHandLight.resetValue();
        shaderPackOldLighting.resetValue();
        shaderPackShadowTranslucent.resetValue();
        shaderPackUnderwaterOverlay.resetValue();
        shaderPackSun.resetValue();
        shaderPackMoon.resetValue();
        shaderPackVignette.resetValue();
        shaderPackBackFaceSolid.resetValue();
        shaderPackBackFaceCutout.resetValue();
        shaderPackBackFaceCutoutMipped.resetValue();
        shaderPackBackFaceTranslucent.resetValue();
        shaderPackRainDepth.resetValue();
        shaderPackBeaconBeamDepth.resetValue();
        shaderPackSeparateAo.resetValue();
        shaderPackFrustumCulling.resetValue();
        BlockAliases.reset();
        ItemAliases.reset();
        EntityAliases.reset();
        customUniforms = null;
        for (int i = 0; i < ProgramsAll.length; ++i) {
            object = ProgramsAll[i];
            ((Program)object).resetProperties();
        }
        if (shaderPack != null) {
            BlockAliases.update(shaderPack);
            ItemAliases.update(shaderPack);
            EntityAliases.update(shaderPack);
            String string = PATH_SHADERS_PROPERTIES;
            try {
                object = shaderPack.getResourceAsStream(string);
                if (object == null) {
                    return;
                }
                object = MacroProcessor.process((InputStream)object, string);
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load((InputStream)object);
                ((InputStream)object).close();
                shaderPackClouds.loadFrom(propertiesOrdered);
                shaderPackOldHandLight.loadFrom(propertiesOrdered);
                shaderPackDynamicHandLight.loadFrom(propertiesOrdered);
                shaderPackOldLighting.loadFrom(propertiesOrdered);
                shaderPackShadowTranslucent.loadFrom(propertiesOrdered);
                shaderPackUnderwaterOverlay.loadFrom(propertiesOrdered);
                shaderPackSun.loadFrom(propertiesOrdered);
                shaderPackVignette.loadFrom(propertiesOrdered);
                shaderPackMoon.loadFrom(propertiesOrdered);
                shaderPackBackFaceSolid.loadFrom(propertiesOrdered);
                shaderPackBackFaceCutout.loadFrom(propertiesOrdered);
                shaderPackBackFaceCutoutMipped.loadFrom(propertiesOrdered);
                shaderPackBackFaceTranslucent.loadFrom(propertiesOrdered);
                shaderPackRainDepth.loadFrom(propertiesOrdered);
                shaderPackBeaconBeamDepth.loadFrom(propertiesOrdered);
                shaderPackSeparateAo.loadFrom(propertiesOrdered);
                shaderPackFrustumCulling.loadFrom(propertiesOrdered);
                shaderPackOptionSliders = ShaderPackParser.parseOptionSliders(propertiesOrdered, shaderPackOptions);
                shaderPackProfiles = ShaderPackParser.parseProfiles(propertiesOrdered, shaderPackOptions);
                shaderPackGuiScreens = ShaderPackParser.parseGuiScreens(propertiesOrdered, shaderPackProfiles, shaderPackOptions);
                shaderPackProgramConditions = ShaderPackParser.parseProgramConditions(propertiesOrdered, shaderPackOptions);
                customTexturesGbuffers = Shaders.loadCustomTextures(propertiesOrdered, 0);
                customTexturesComposite = Shaders.loadCustomTextures(propertiesOrdered, 1);
                customTexturesDeferred = Shaders.loadCustomTextures(propertiesOrdered, 2);
                noiseTexturePath = propertiesOrdered.getProperty("texture.noise");
                if (noiseTexturePath != null) {
                    noiseTextureEnabled = true;
                }
                customUniforms = ShaderPackParser.parseCustomUniforms(propertiesOrdered);
                ShaderPackParser.parseAlphaStates(propertiesOrdered);
                ShaderPackParser.parseBlendStates(propertiesOrdered);
                ShaderPackParser.parseRenderScales(propertiesOrdered);
                ShaderPackParser.parseBuffersFlip(propertiesOrdered);
            }
            catch (IOException iOException) {
                Config.warn("[Shaders] Error reading: " + string);
            }
        }
    }

    private static ICustomTexture[] loadCustomTextures(Properties properties, int n) {
        String string = "texture." + STAGE_NAMES[n] + ".";
        Set<Object> set = properties.keySet();
        ArrayList<ICustomTexture> arrayList = new ArrayList<ICustomTexture>();
        for (Object object : set) {
            String string2 = (String)object;
            if (!string2.startsWith(string)) continue;
            String string3 = StrUtils.removePrefix(string2, string);
            string3 = StrUtils.removeSuffix(string3, new String[]{".0", ".1", ".2", ".3", ".4", ".5", ".6", ".7", ".8", ".9"});
            String string4 = properties.getProperty(string2).trim();
            int n2 = Shaders.getTextureIndex(n, string3);
            if (n2 < 0) {
                SMCLog.warning("Invalid texture name: " + string2);
                continue;
            }
            ICustomTexture iCustomTexture = Shaders.loadCustomTexture(n2, string4);
            if (iCustomTexture == null) continue;
            SMCLog.info("Custom texture: " + string2 + " = " + string4);
            arrayList.add(iCustomTexture);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        ICustomTexture[] iCustomTextureArray = arrayList.toArray(new ICustomTexture[arrayList.size()]);
        return iCustomTextureArray;
    }

    private static ICustomTexture loadCustomTexture(int n, String string) {
        if (string == null) {
            return null;
        }
        return (string = string.trim()).indexOf(58) >= 0 ? Shaders.loadCustomTextureLocation(n, string) : (string.indexOf(32) >= 0 ? Shaders.loadCustomTextureRaw(n, string) : Shaders.loadCustomTextureShaders(n, string));
    }

    private static ICustomTexture loadCustomTextureLocation(int n, String string) {
        String string2 = string.trim();
        int n2 = 0;
        if (string2.startsWith("minecraft:textures/")) {
            if ((string2 = StrUtils.addSuffixCheck(string2, ".png")).endsWith("_n.png")) {
                string2 = StrUtils.replaceSuffix(string2, "_n.png", ".png");
                n2 = 1;
            } else if (string2.endsWith("_s.png")) {
                string2 = StrUtils.replaceSuffix(string2, "_s.png", ".png");
                n2 = 2;
            }
        }
        ResourceLocation resourceLocation = new ResourceLocation(string2);
        CustomTextureLocation customTextureLocation = new CustomTextureLocation(n, resourceLocation, n2);
        return customTextureLocation;
    }

    private static ICustomTexture loadCustomTextureRaw(int n, String string) {
        ConnectedParser connectedParser = new ConnectedParser("Shaders");
        String[] stringArray = Config.tokenize(string, " ");
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>(Arrays.asList(stringArray));
        String string2 = (String)arrayDeque.poll();
        TextureType textureType = (TextureType)connectedParser.parseEnum((String)arrayDeque.poll(), TextureType.values(), "texture type");
        if (textureType == null) {
            SMCLog.warning("Invalid raw texture type: " + string);
            return null;
        }
        InternalFormat internalFormat = (InternalFormat)connectedParser.parseEnum((String)arrayDeque.poll(), InternalFormat.values(), "internal format");
        if (internalFormat == null) {
            SMCLog.warning("Invalid raw texture internal format: " + string);
            return null;
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        switch (textureType) {
            case TEXTURE_1D: {
                n2 = connectedParser.parseInt((String)arrayDeque.poll(), -1);
                break;
            }
            case TEXTURE_2D: {
                n2 = connectedParser.parseInt((String)arrayDeque.poll(), -1);
                n3 = connectedParser.parseInt((String)arrayDeque.poll(), -1);
                break;
            }
            case TEXTURE_3D: {
                n2 = connectedParser.parseInt((String)arrayDeque.poll(), -1);
                n3 = connectedParser.parseInt((String)arrayDeque.poll(), -1);
                n4 = connectedParser.parseInt((String)arrayDeque.poll(), -1);
                break;
            }
            case TEXTURE_RECTANGLE: {
                n2 = connectedParser.parseInt((String)arrayDeque.poll(), -1);
                n3 = connectedParser.parseInt((String)arrayDeque.poll(), -1);
                break;
            }
            default: {
                SMCLog.warning("Invalid raw texture type: " + String.valueOf((Object)textureType));
                return null;
            }
        }
        if (n2 >= 0 && n3 >= 0 && n4 >= 0) {
            PixelFormat pixelFormat = (PixelFormat)connectedParser.parseEnum((String)arrayDeque.poll(), PixelFormat.values(), "pixel format");
            if (pixelFormat == null) {
                SMCLog.warning("Invalid raw texture pixel format: " + string);
                return null;
            }
            PixelType pixelType = (PixelType)connectedParser.parseEnum((String)arrayDeque.poll(), PixelType.values(), "pixel type");
            if (pixelType == null) {
                SMCLog.warning("Invalid raw texture pixel type: " + string);
                return null;
            }
            if (!arrayDeque.isEmpty()) {
                SMCLog.warning("Invalid raw texture, too many parameters: " + string);
                return null;
            }
            return Shaders.loadCustomTextureRaw(n, string, string2, textureType, internalFormat, n2, n3, n4, pixelFormat, pixelType);
        }
        SMCLog.warning("Invalid raw texture size: " + string);
        return null;
    }

    private static ICustomTexture loadCustomTextureRaw(int n, String string, String string2, TextureType textureType, InternalFormat internalFormat, int n2, int n3, int n4, PixelFormat pixelFormat, PixelType pixelType) {
        try {
            String string3 = "shaders/" + StrUtils.removePrefix(string2, "/");
            InputStream inputStream2 = shaderPack.getResourceAsStream(string3);
            if (inputStream2 == null) {
                SMCLog.warning("Raw texture not found: " + string2);
                return null;
            }
            byte[] byArray = Config.readAll(inputStream2);
            IOUtils.closeQuietly(inputStream2);
            ByteBuffer byteBuffer = GLAllocation.createDirectByteBuffer(byArray.length);
            byteBuffer.put(byArray);
            byteBuffer.flip();
            TextureMetadataSection textureMetadataSection = SimpleShaderTexture.loadTextureMetadataSection(string3, new TextureMetadataSection(true, true, new ArrayList<Integer>()));
            CustomTextureRaw customTextureRaw = new CustomTextureRaw(textureType, internalFormat, n2, n3, n4, pixelFormat, pixelType, byteBuffer, n, textureMetadataSection.getTextureBlur(), textureMetadataSection.getTextureClamp());
            return customTextureRaw;
        }
        catch (IOException iOException) {
            SMCLog.warning("Error loading raw texture: " + string2);
            SMCLog.warning(iOException.getClass().getName() + ": " + iOException.getMessage());
            return null;
        }
    }

    private static ICustomTexture loadCustomTextureShaders(int n, String object) {
        if (((String)(object = ((String)object).trim())).indexOf(46) < 0) {
            object = (String)object + ".png";
        }
        try {
            String string = "shaders/" + StrUtils.removePrefix((String)object, "/");
            InputStream inputStream2 = shaderPack.getResourceAsStream(string);
            if (inputStream2 == null) {
                SMCLog.warning("Texture not found: " + (String)object);
                return null;
            }
            IOUtils.closeQuietly(inputStream2);
            SimpleShaderTexture simpleShaderTexture = new SimpleShaderTexture(string);
            simpleShaderTexture.loadTexture(mc.getResourceManager());
            CustomTexture customTexture = new CustomTexture(n, string, simpleShaderTexture);
            return customTexture;
        }
        catch (IOException iOException) {
            SMCLog.warning("Error loading texture: " + (String)object);
            SMCLog.warning(iOException.getClass().getName() + ": " + iOException.getMessage());
            return null;
        }
    }

    private static int getTextureIndex(int n, String string) {
        if (n == 0) {
            if (string.equals("texture")) {
                return 0;
            }
            if (string.equals("lightmap")) {
                return 1;
            }
            if (string.equals("normals")) {
                return 2;
            }
            if (string.equals("specular")) {
                return 3;
            }
            if (string.equals("shadowtex0") || string.equals("watershadow")) {
                return 4;
            }
            if (string.equals("shadow")) {
                return waterShadowEnabled ? 5 : 4;
            }
            if (string.equals("shadowtex1")) {
                return 5;
            }
            if (string.equals("depthtex0")) {
                return 6;
            }
            if (string.equals("gaux1")) {
                return 7;
            }
            if (string.equals("gaux2")) {
                return 8;
            }
            if (string.equals("gaux3")) {
                return 9;
            }
            if (string.equals("gaux4")) {
                return 10;
            }
            if (string.equals("depthtex1")) {
                return 12;
            }
            if (string.equals("shadowcolor0") || string.equals("shadowcolor")) {
                return 13;
            }
            if (string.equals("shadowcolor1")) {
                return 14;
            }
            if (string.equals("noisetex")) {
                return 15;
            }
        }
        if (n == 1 || n == 2) {
            if (string.equals("colortex0") || string.equals("colortex0")) {
                return 0;
            }
            if (string.equals("colortex1") || string.equals("gdepth")) {
                return 1;
            }
            if (string.equals("colortex2") || string.equals("gnormal")) {
                return 2;
            }
            if (string.equals("colortex3") || string.equals("composite")) {
                return 3;
            }
            if (string.equals("shadowtex0") || string.equals("watershadow")) {
                return 4;
            }
            if (string.equals("shadow")) {
                return waterShadowEnabled ? 5 : 4;
            }
            if (string.equals("shadowtex1")) {
                return 5;
            }
            if (string.equals("depthtex0") || string.equals("gdepthtex")) {
                return 6;
            }
            if (string.equals("colortex4") || string.equals("gaux1")) {
                return 7;
            }
            if (string.equals("colortex5") || string.equals("gaux2")) {
                return 8;
            }
            if (string.equals("colortex6") || string.equals("gaux3")) {
                return 9;
            }
            if (string.equals("colortex7") || string.equals("gaux4")) {
                return 10;
            }
            if (string.equals("depthtex1")) {
                return 11;
            }
            if (string.equals("depthtex2")) {
                return 12;
            }
            if (string.equals("shadowcolor0") || string.equals("shadowcolor")) {
                return 13;
            }
            if (string.equals("shadowcolor1")) {
                return 14;
            }
            if (string.equals("noisetex")) {
                return 15;
            }
        }
        return -1;
    }

    private static void bindCustomTextures(ICustomTexture[] iCustomTextureArray) {
        if (iCustomTextureArray != null) {
            for (int i = 0; i < iCustomTextureArray.length; ++i) {
                ICustomTexture iCustomTexture = iCustomTextureArray[i];
                GlStateManager.setActiveTexture(33984 + iCustomTexture.getTextureUnit());
                int n = iCustomTexture.getTextureId();
                int n2 = iCustomTexture.getTarget();
                if (n2 == 3553) {
                    GlStateManager.bindTexture(n);
                    continue;
                }
                GL11.glBindTexture(n2, n);
            }
        }
    }

    private static void resetCustomTextures() {
        Shaders.deleteCustomTextures(customTexturesGbuffers);
        Shaders.deleteCustomTextures(customTexturesComposite);
        Shaders.deleteCustomTextures(customTexturesDeferred);
        customTexturesGbuffers = null;
        customTexturesComposite = null;
        customTexturesDeferred = null;
    }

    private static void deleteCustomTextures(ICustomTexture[] iCustomTextureArray) {
        if (iCustomTextureArray != null) {
            for (int i = 0; i < iCustomTextureArray.length; ++i) {
                ICustomTexture iCustomTexture = iCustomTextureArray[i];
                iCustomTexture.deleteTexture();
            }
        }
    }

    public static ShaderOption[] getShaderPackOptions(String string) {
        Object[] objectArray = (ShaderOption[])shaderPackOptions.clone();
        if (shaderPackGuiScreens == null) {
            if (shaderPackProfiles != null) {
                ShaderOptionProfile shaderOptionProfile = new ShaderOptionProfile(shaderPackProfiles, (ShaderOption[])objectArray);
                objectArray = (ShaderOption[])Config.addObjectToArray(objectArray, shaderOptionProfile, 0);
            }
            objectArray = Shaders.getVisibleOptions((ShaderOption[])objectArray);
            return objectArray;
        }
        Object object = string != null ? "screen." + string : "screen";
        ScreenShaderOptions screenShaderOptions = shaderPackGuiScreens.get(object);
        if (screenShaderOptions == null) {
            return new ShaderOption[0];
        }
        ShaderOption[] shaderOptionArray = screenShaderOptions.getShaderOptions();
        ArrayList<ShaderOption> arrayList = new ArrayList<ShaderOption>();
        for (int i = 0; i < shaderOptionArray.length; ++i) {
            ShaderOption shaderOption = shaderOptionArray[i];
            if (shaderOption == null) {
                arrayList.add(null);
                continue;
            }
            if (shaderOption instanceof ShaderOptionRest) {
                ShaderOption[] shaderOptionArray2 = Shaders.getShaderOptionsRest(shaderPackGuiScreens, (ShaderOption[])objectArray);
                arrayList.addAll(Arrays.asList(shaderOptionArray2));
                continue;
            }
            arrayList.add(shaderOption);
        }
        ShaderOption[] shaderOptionArray3 = arrayList.toArray(new ShaderOption[arrayList.size()]);
        return shaderOptionArray3;
    }

    public static int getShaderPackColumns(String string, int n) {
        Object object;
        Object object2 = object = string != null ? "screen." + string : "screen";
        if (shaderPackGuiScreens == null) {
            return n;
        }
        ScreenShaderOptions screenShaderOptions = shaderPackGuiScreens.get(object);
        return screenShaderOptions == null ? n : screenShaderOptions.getColumns();
    }

    private static ShaderOption[] getShaderOptionsRest(Map<String, ScreenShaderOptions> map, ShaderOption[] shaderOptionArray) {
        Object object;
        Object object2;
        HashSet<String> hashSet = new HashSet<String>();
        for (String string : map.keySet()) {
            object2 = map.get(string);
            object = ((ScreenShaderOptions)object2).getShaderOptions();
            for (int i = 0; i < ((ShaderOption[])object).length; ++i) {
                ShaderOption shaderOption = object[i];
                if (shaderOption == null) continue;
                hashSet.add(shaderOption.getName());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < shaderOptionArray.length; ++i) {
            object2 = shaderOptionArray[i];
            if (!((ShaderOption)object2).isVisible() || hashSet.contains(object = ((ShaderOption)object2).getName())) continue;
            arrayList.add(object2);
        }
        ShaderOption[] shaderOptionArray2 = arrayList.toArray(new ShaderOption[arrayList.size()]);
        return shaderOptionArray2;
    }

    public static ShaderOption getShaderOption(String string) {
        return ShaderUtils.getShaderOption(string, shaderPackOptions);
    }

    public static ShaderOption[] getShaderPackOptions() {
        return shaderPackOptions;
    }

    public static boolean isShaderPackOptionSlider(String string) {
        return shaderPackOptionSliders == null ? false : shaderPackOptionSliders.contains(string);
    }

    private static ShaderOption[] getVisibleOptions(ShaderOption[] shaderOptionArray) {
        ArrayList<ShaderOption> arrayList = new ArrayList<ShaderOption>();
        for (int i = 0; i < shaderOptionArray.length; ++i) {
            ShaderOption shaderOption = shaderOptionArray[i];
            if (!shaderOption.isVisible()) continue;
            arrayList.add(shaderOption);
        }
        ShaderOption[] shaderOptionArray2 = arrayList.toArray(new ShaderOption[arrayList.size()]);
        return shaderOptionArray2;
    }

    public static void saveShaderPackOptions() {
        Shaders.saveShaderPackOptions(shaderPackOptions, shaderPack);
    }

    private static void saveShaderPackOptions(ShaderOption[] shaderOptionArray, IShaderPack iShaderPack) {
        PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
        if (shaderPackOptions != null) {
            for (int i = 0; i < shaderOptionArray.length; ++i) {
                ShaderOption shaderOption = shaderOptionArray[i];
                if (!shaderOption.isChanged() || !shaderOption.isEnabled()) continue;
                propertiesOrdered.setProperty(shaderOption.getName(), shaderOption.getValue());
            }
        }
        try {
            Shaders.saveOptionProperties(iShaderPack, propertiesOrdered);
        }
        catch (IOException iOException) {
            Config.warn("[Shaders] Error saving configuration for " + shaderPack.getName());
            iOException.printStackTrace();
        }
    }

    private static void saveOptionProperties(IShaderPack iShaderPack, Properties properties) throws IOException {
        String string = "shaderpacks/" + iShaderPack.getName() + ".txt";
        File file = new File(Minecraft.getMinecraft().mcDataDir, string);
        if (properties.isEmpty()) {
            file.delete();
        } else {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream, (String)null);
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }

    private static ShaderOption[] loadShaderPackOptions() {
        try {
            String[] stringArray = programs.getProgramNames();
            ShaderOption[] shaderOptionArray = ShaderPackParser.parseShaderPackOptions(shaderPack, stringArray, shaderPackDimensions);
            Properties properties = Shaders.loadOptionProperties(shaderPack);
            for (int i = 0; i < shaderOptionArray.length; ++i) {
                ShaderOption shaderOption = shaderOptionArray[i];
                String string = properties.getProperty(shaderOption.getName());
                if (string == null) continue;
                shaderOption.resetValue();
                if (shaderOption.setValue(string)) continue;
                Config.warn("[Shaders] Invalid value, option: " + shaderOption.getName() + ", value: " + string);
            }
            return shaderOptionArray;
        }
        catch (IOException iOException) {
            Config.warn("[Shaders] Error reading configuration for " + shaderPack.getName());
            iOException.printStackTrace();
            return null;
        }
    }

    private static Properties loadOptionProperties(IShaderPack iShaderPack) throws IOException {
        PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
        String string = "shaderpacks/" + iShaderPack.getName() + ".txt";
        File file = new File(Minecraft.getMinecraft().mcDataDir, string);
        if (file.exists() && file.isFile() && file.canRead()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            propertiesOrdered.load(fileInputStream);
            fileInputStream.close();
            return propertiesOrdered;
        }
        return propertiesOrdered;
    }

    public static ShaderOption[] getChangedOptions(ShaderOption[] shaderOptionArray) {
        ArrayList<ShaderOption> arrayList = new ArrayList<ShaderOption>();
        for (int i = 0; i < shaderOptionArray.length; ++i) {
            ShaderOption shaderOption = shaderOptionArray[i];
            if (!shaderOption.isEnabled() || !shaderOption.isChanged()) continue;
            arrayList.add(shaderOption);
        }
        ShaderOption[] shaderOptionArray2 = arrayList.toArray(new ShaderOption[arrayList.size()]);
        return shaderOptionArray2;
    }

    private static String applyOptions(String string, ShaderOption[] shaderOptionArray) {
        if (shaderOptionArray != null && shaderOptionArray.length > 0) {
            for (int i = 0; i < shaderOptionArray.length; ++i) {
                ShaderOption shaderOption = shaderOptionArray[i];
                if (!shaderOption.matchesLine(string)) continue;
                string = shaderOption.getSourceLine();
                break;
            }
            return string;
        }
        return string;
    }

    public static ArrayList listOfShaders() {
        Object object;
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(SHADER_PACK_NAME_NONE);
        arrayList.add(SHADER_PACK_NAME_DEFAULT);
        int n = arrayList.size();
        try {
            if (!shaderPacksDir.exists()) {
                shaderPacksDir.mkdir();
            }
            object = shaderPacksDir.listFiles();
            for (int i = 0; i < ((File[])object).length; ++i) {
                File file = object[i];
                String string = file.getName();
                if (file.isDirectory()) {
                    File file2;
                    if (string.equals("debug") || !(file2 = new File(file, "shaders")).exists() || !file2.isDirectory()) continue;
                    arrayList.add(string);
                    continue;
                }
                if (!file.isFile() || !string.toLowerCase().endsWith(".zip")) continue;
                arrayList.add(string);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        object = arrayList.subList(n, arrayList.size());
        Collections.sort(object, String.CASE_INSENSITIVE_ORDER);
        return arrayList;
    }

    public static int checkFramebufferStatus(String string) {
        int n = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
        if (n != 36053) {
            System.err.format("FramebufferStatus 0x%04X at %s\n", n, string);
        }
        return n;
    }

    public static int checkGLError(String string) {
        int n = GlStateManager.glGetError();
        if (n != 0 && GlErrors.isEnabled(n)) {
            String string2 = Config.getGlErrorString(n);
            String string3 = Shaders.getErrorInfo(n, string);
            String string4 = String.format("OpenGL error: %s (%s)%s, at: %s", n, string2, string3, string);
            SMCLog.severe(string4);
            if (Config.isShowGlErrors() && TimedEvent.isActive("ShowGlErrorShaders", 10000L)) {
                String string5 = I18n.format("of.message.openglError", n, string2);
                Shaders.printChat(string5);
            }
        }
        return n;
    }

    private static String getErrorInfo(int n, String string) {
        String string2;
        Object object;
        Object object2;
        StringBuilder stringBuilder = new StringBuilder();
        if (n == 1286) {
            int n2 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
            object2 = Shaders.getFramebufferStatusText(n2);
            object = ", fbStatus: " + n2 + " (" + (String)object2 + ")";
            stringBuilder.append((String)object);
        }
        if ((string2 = activeProgram.getName()).isEmpty()) {
            string2 = "none";
        }
        stringBuilder.append(", program: " + string2);
        object2 = Shaders.getProgramById(activeProgramID);
        if (object2 != activeProgram) {
            object = ((Program)object2).getName();
            if (((String)object).isEmpty()) {
                object = "none";
            }
            stringBuilder.append(" (" + (String)object + ")");
        }
        if (string.equals("setDrawBuffers")) {
            stringBuilder.append(", drawBuffers: " + activeProgram.getDrawBufSettings());
        }
        return stringBuilder.toString();
    }

    private static Program getProgramById(int n) {
        for (int i = 0; i < ProgramsAll.length; ++i) {
            Program program = ProgramsAll[i];
            if (program.getId() != n) continue;
            return program;
        }
        return ProgramNone;
    }

    private static String getFramebufferStatusText(int n) {
        switch (n) {
            case 33305: {
                return "Undefined";
            }
            case 36053: {
                return "Complete";
            }
            case 36054: {
                return "Incomplete attachment";
            }
            case 36055: {
                return "Incomplete missing attachment";
            }
            case 36059: {
                return "Incomplete draw buffer";
            }
            case 36060: {
                return "Incomplete read buffer";
            }
            case 36061: {
                return "Unsupported";
            }
            case 36182: {
                return "Incomplete multisample";
            }
            case 36264: {
                return "Incomplete layer targets";
            }
        }
        return "Unknown";
    }

    private static void printChat(String string) {
        Shaders.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(string));
    }

    private static void printChatAndLogError(String string) {
        SMCLog.severe(string);
        Shaders.mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(string));
    }

    public static void printIntBuffer(String string, IntBuffer intBuffer) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(string).append(" [pos ").append(intBuffer.position()).append(" lim ").append(intBuffer.limit()).append(" cap ").append(intBuffer.capacity()).append(" :");
        int n = intBuffer.limit();
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(" ").append(intBuffer.get(i));
        }
        stringBuilder.append("]");
        SMCLog.info(stringBuilder.toString());
    }

    public static void startup(Minecraft minecraft) {
        Shaders.checkShadersModInstalled();
        minecraft = Minecraft.getMinecraft();
        capabilities = GLContext.getCapabilities();
        glVersionString = GL11.glGetString(7938);
        glVendorString = GL11.glGetString(7936);
        glRendererString = GL11.glGetString(7937);
        SMCLog.info("OpenGL Version: " + glVersionString);
        SMCLog.info("Vendor:  " + glVendorString);
        SMCLog.info("Renderer: " + glRendererString);
        SMCLog.info("Capabilities: " + (Shaders.capabilities.OpenGL20 ? " 2.0 " : " - ") + (Shaders.capabilities.OpenGL21 ? " 2.1 " : " - ") + (Shaders.capabilities.OpenGL30 ? " 3.0 " : " - ") + (Shaders.capabilities.OpenGL32 ? " 3.2 " : " - ") + (Shaders.capabilities.OpenGL40 ? " 4.0 " : " - "));
        SMCLog.info("GL_MAX_DRAW_BUFFERS: " + GL11.glGetInteger(34852));
        SMCLog.info("GL_MAX_COLOR_ATTACHMENTS_EXT: " + GL11.glGetInteger(36063));
        SMCLog.info("GL_MAX_TEXTURE_IMAGE_UNITS: " + GL11.glGetInteger(34930));
        hasGlGenMipmap = Shaders.capabilities.OpenGL30;
        Shaders.loadConfig();
    }

    public static void updateBlockLightLevel() {
        if (Shaders.isOldLighting()) {
            blockLightLevel05 = 0.5f;
            blockLightLevel06 = 0.6f;
            blockLightLevel08 = 0.8f;
        } else {
            blockLightLevel05 = 1.0f;
            blockLightLevel06 = 1.0f;
            blockLightLevel08 = 1.0f;
        }
    }

    public static boolean isOldHandLight() {
        return !configOldHandLight.isDefault() ? configOldHandLight.isTrue() : (!shaderPackOldHandLight.isDefault() ? shaderPackOldHandLight.isTrue() : true);
    }

    public static boolean isDynamicHandLight() {
        return !shaderPackDynamicHandLight.isDefault() ? shaderPackDynamicHandLight.isTrue() : true;
    }

    public static boolean isOldLighting() {
        return !configOldLighting.isDefault() ? configOldLighting.isTrue() : (!shaderPackOldLighting.isDefault() ? shaderPackOldLighting.isTrue() : true);
    }

    public static boolean isRenderShadowTranslucent() {
        return !shaderPackShadowTranslucent.isFalse();
    }

    public static boolean isUnderwaterOverlay() {
        return !shaderPackUnderwaterOverlay.isFalse();
    }

    public static boolean isSun() {
        return !shaderPackSun.isFalse();
    }

    public static boolean isMoon() {
        return !shaderPackMoon.isFalse();
    }

    public static boolean isVignette() {
        return !shaderPackVignette.isFalse();
    }

    public static boolean isRenderBackFace(EnumWorldBlockLayer enumWorldBlockLayer) {
        switch (enumWorldBlockLayer) {
            case SOLID: {
                return shaderPackBackFaceSolid.isTrue();
            }
            case CUTOUT: {
                return shaderPackBackFaceCutout.isTrue();
            }
            case CUTOUT_MIPPED: {
                return shaderPackBackFaceCutoutMipped.isTrue();
            }
            case TRANSLUCENT: {
                return shaderPackBackFaceTranslucent.isTrue();
            }
        }
        return false;
    }

    public static boolean isRainDepth() {
        return shaderPackRainDepth.isTrue();
    }

    public static boolean isBeaconBeamDepth() {
        return shaderPackBeaconBeamDepth.isTrue();
    }

    public static boolean isSeparateAo() {
        return shaderPackSeparateAo.isTrue();
    }

    public static boolean isFrustumCulling() {
        return !shaderPackFrustumCulling.isFalse();
    }

    public static void init() {
        boolean bl;
        if (!isInitializedOnce) {
            isInitializedOnce = true;
            bl = true;
        } else {
            bl = false;
        }
        if (!isShaderPackInitialized) {
            int n;
            Object object;
            Object object2;
            int n2;
            Shaders.checkGLError("Shaders.init pre");
            if (Shaders.getShaderPackName() != null) {
                // empty if block
            }
            if (!Shaders.capabilities.OpenGL20) {
                Shaders.printChatAndLogError("No OpenGL 2.0");
            }
            if (!Shaders.capabilities.GL_EXT_framebuffer_object) {
                Shaders.printChatAndLogError("No EXT_framebuffer_object");
            }
            dfbDrawBuffers.position(0).limit(8);
            dfbColorTextures.position(0).limit(16);
            dfbDepthTextures.position(0).limit(3);
            sfbDrawBuffers.position(0).limit(8);
            sfbDepthTextures.position(0).limit(2);
            sfbColorTextures.position(0).limit(8);
            usedColorBuffers = 4;
            usedDepthBuffers = 1;
            usedShadowColorBuffers = 0;
            usedShadowDepthBuffers = 0;
            usedColorAttachs = 1;
            usedDrawBuffers = 1;
            Arrays.fill(gbuffersFormat, 6408);
            Arrays.fill(gbuffersClear, true);
            Arrays.fill(gbuffersClearColor, null);
            Arrays.fill(shadowHardwareFilteringEnabled, false);
            Arrays.fill(shadowMipmapEnabled, false);
            Arrays.fill(shadowFilterNearest, false);
            Arrays.fill(shadowColorMipmapEnabled, false);
            Arrays.fill(shadowColorFilterNearest, false);
            centerDepthSmoothEnabled = false;
            noiseTextureEnabled = false;
            sunPathRotation = 0.0f;
            shadowIntervalSize = 2.0f;
            shadowMapWidth = 1024;
            shadowMapHeight = 1024;
            spShadowMapWidth = 1024;
            spShadowMapHeight = 1024;
            shadowMapFOV = 90.0f;
            shadowMapHalfPlane = 160.0f;
            shadowMapIsOrtho = true;
            shadowDistanceRenderMul = -1.0f;
            aoLevel = -1.0f;
            useEntityAttrib = false;
            useMidTexCoordAttrib = false;
            useTangentAttrib = false;
            waterShadowEnabled = false;
            hasGeometryShaders = false;
            Shaders.updateBlockLightLevel();
            Smoother.resetValues();
            shaderUniforms.reset();
            if (customUniforms != null) {
                customUniforms.reset();
            }
            ShaderProfile shaderProfile = ShaderUtils.detectProfile(shaderPackProfiles, shaderPackOptions, false);
            Object object3 = "";
            if (currentWorld != null && shaderPackDimensions.contains(n2 = Shaders.currentWorld.provider.getDimensionId())) {
                object3 = "world" + n2 + "/";
            }
            for (n2 = 0; n2 < ProgramsAll.length; ++n2) {
                Program program = ProgramsAll[n2];
                program.resetId();
                program.resetConfiguration();
                if (program.getProgramStage() == ProgramStage.NONE) continue;
                object2 = program.getName();
                object = (String)object3 + (String)object2;
                boolean bl2 = true;
                if (shaderPackProgramConditions.containsKey(object)) {
                    boolean bl3 = bl2 = bl2 && shaderPackProgramConditions.get(object).eval();
                }
                if (shaderProfile != null) {
                    boolean bl4 = bl2 = bl2 && !shaderProfile.isProgramDisabled((String)object);
                }
                if (!bl2) {
                    SMCLog.info("Program disabled: " + (String)object);
                    object2 = "<disabled>";
                    object = (String)object3 + (String)object2;
                }
                String string = "/shaders/" + (String)object;
                String string2 = string + ".vsh";
                String string3 = string + ".gsh";
                String string4 = string + ".fsh";
                Shaders.setupProgram(program, string2, string3, string4);
                int n3 = program.getId();
                if (n3 > 0) {
                    SMCLog.info("Program loaded: " + (String)object);
                }
                Shaders.initDrawBuffers(program);
                Shaders.updateToggleBuffers(program);
            }
            hasDeferredPrograms = false;
            for (n2 = 0; n2 < ProgramsDeferred.length; ++n2) {
                if (ProgramsDeferred[n2].getId() == 0) continue;
                hasDeferredPrograms = true;
                break;
            }
            usedColorAttachs = usedColorBuffers;
            shadowPassInterval = usedShadowDepthBuffers > 0 ? 1 : 0;
            shouldSkipDefaultShadow = usedShadowDepthBuffers > 0;
            SMCLog.info("usedColorBuffers: " + usedColorBuffers);
            SMCLog.info("usedDepthBuffers: " + usedDepthBuffers);
            SMCLog.info("usedShadowColorBuffers: " + usedShadowColorBuffers);
            SMCLog.info("usedShadowDepthBuffers: " + usedShadowDepthBuffers);
            SMCLog.info("usedColorAttachs: " + usedColorAttachs);
            SMCLog.info("usedDrawBuffers: " + usedDrawBuffers);
            dfbDrawBuffers.position(0).limit(usedDrawBuffers);
            dfbColorTextures.position(0).limit(usedColorBuffers * 2);
            dfbColorTexturesFlip.reset();
            for (n2 = 0; n2 < usedDrawBuffers; ++n2) {
                dfbDrawBuffers.put(n2, 36064 + n2);
            }
            n2 = GL11.glGetInteger(34852);
            if (usedDrawBuffers > n2) {
                Shaders.printChatAndLogError("[Shaders] Error: Not enough draw buffers, needed: " + usedDrawBuffers + ", available: " + n2);
            }
            sfbDrawBuffers.position(0).limit(usedShadowColorBuffers);
            for (n = 0; n < usedShadowColorBuffers; ++n) {
                sfbDrawBuffers.put(n, 36064 + n);
            }
            for (n = 0; n < ProgramsAll.length; ++n) {
                for (object = object2 = ProgramsAll[n]; ((Program)object).getId() == 0 && ((Program)object).getProgramBackup() != object; object = ((Program)object).getProgramBackup()) {
                }
                if (object == object2 || object2 == ProgramShadow) continue;
                ((Program)object2).copyFrom((Program)object);
            }
            Shaders.resize();
            Shaders.resizeShadow();
            if (noiseTextureEnabled) {
                Shaders.setupNoiseTexture();
            }
            if (defaultTexture == null) {
                defaultTexture = ShadersTex.createDefaultTexture();
            }
            GlStateManager.pushMatrix();
            GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
            Shaders.preCelestialRotate();
            Shaders.postCelestialRotate();
            GlStateManager.popMatrix();
            isShaderPackInitialized = true;
            Shaders.loadEntityDataMap();
            Shaders.resetDisplayLists();
            if (!bl) {
                // empty if block
            }
            Shaders.checkGLError("Shaders.init");
        }
    }

    private static void initDrawBuffers(Program program) {
        int n = GL11.glGetInteger(34852);
        Arrays.fill(program.getToggleColorTextures(), false);
        if (program == ProgramFinal) {
            program.setDrawBuffers(null);
        } else if (program.getId() == 0) {
            if (program == ProgramShadow) {
                program.setDrawBuffers(drawBuffersNone);
            } else {
                program.setDrawBuffers(drawBuffersColorAtt0);
            }
        } else {
            String string = program.getDrawBufSettings();
            if (string == null) {
                if (program != ProgramShadow && program != ProgramShadowSolid && program != ProgramShadowCutout) {
                    program.setDrawBuffers(dfbDrawBuffers);
                    usedDrawBuffers = usedColorBuffers;
                    Arrays.fill(program.getToggleColorTextures(), 0, usedColorBuffers, true);
                } else {
                    program.setDrawBuffers(sfbDrawBuffers);
                }
            } else {
                IntBuffer intBuffer = program.getDrawBuffersBuffer();
                int n2 = string.length();
                usedDrawBuffers = Math.max(usedDrawBuffers, n2);
                n2 = Math.min(n2, n);
                program.setDrawBuffers(intBuffer);
                intBuffer.limit(n2);
                for (int i = 0; i < n2; ++i) {
                    int n3 = Shaders.getDrawBuffer(program, string, i);
                    intBuffer.put(i, n3);
                }
            }
        }
    }

    private static int getDrawBuffer(Program program, String string, int n) {
        int n2 = 0;
        if (n >= string.length()) {
            return n2;
        }
        int n3 = string.charAt(n) - 48;
        if (program == ProgramShadow) {
            if (n3 >= 0 && n3 <= 1) {
                n2 = n3 + 36064;
                usedShadowColorBuffers = Math.max(usedShadowColorBuffers, n3);
            }
            return n2;
        }
        if (n3 >= 0 && n3 <= 7) {
            program.getToggleColorTextures()[n3] = true;
            n2 = n3 + 36064;
            usedColorAttachs = Math.max(usedColorAttachs, n3);
            usedColorBuffers = Math.max(usedColorBuffers, n3);
        }
        return n2;
    }

    private static void updateToggleBuffers(Program program) {
        boolean[] blArray = program.getToggleColorTextures();
        Boolean[] booleanArray = program.getBuffersFlip();
        for (int i = 0; i < booleanArray.length; ++i) {
            Boolean bl = booleanArray[i];
            if (bl == null) continue;
            blArray[i] = bl;
        }
    }

    public static void resetDisplayLists() {
        SMCLog.info("Reset model renderers");
        ++countResetDisplayLists;
        SMCLog.info("Reset world renderers");
        Shaders.mc.renderGlobal.loadRenderers();
    }

    private static void setupProgram(Program program, String string, String string2, String string3) {
        Shaders.checkGLError("pre setupProgram");
        int n = ARBShaderObjects.glCreateProgramObjectARB();
        Shaders.checkGLError("create");
        if (n != 0) {
            progUseEntityAttrib = false;
            progUseMidTexCoordAttrib = false;
            progUseTangentAttrib = false;
            int n2 = Shaders.createVertShader(program, string);
            int n3 = Shaders.createGeomShader(program, string2);
            int n4 = Shaders.createFragShader(program, string3);
            Shaders.checkGLError("create");
            if (n2 == 0 && n3 == 0 && n4 == 0) {
                ARBShaderObjects.glDeleteObjectARB(n);
                n = 0;
                program.resetId();
            } else {
                if (n2 != 0) {
                    ARBShaderObjects.glAttachObjectARB(n, n2);
                    Shaders.checkGLError("attach");
                }
                if (n3 != 0) {
                    ARBShaderObjects.glAttachObjectARB(n, n3);
                    Shaders.checkGLError("attach");
                    if (progArbGeometryShader4) {
                        ARBGeometryShader4.glProgramParameteriARB(n, 36315, 4);
                        ARBGeometryShader4.glProgramParameteriARB(n, 36316, 5);
                        ARBGeometryShader4.glProgramParameteriARB(n, 36314, progMaxVerticesOut);
                        Shaders.checkGLError("arbGeometryShader4");
                    }
                    hasGeometryShaders = true;
                }
                if (n4 != 0) {
                    ARBShaderObjects.glAttachObjectARB(n, n4);
                    Shaders.checkGLError("attach");
                }
                if (progUseEntityAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(n, entityAttrib, "mc_Entity");
                    Shaders.checkGLError("mc_Entity");
                }
                if (progUseMidTexCoordAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(n, midTexCoordAttrib, "mc_midTexCoord");
                    Shaders.checkGLError("mc_midTexCoord");
                }
                if (progUseTangentAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(n, tangentAttrib, "at_tangent");
                    Shaders.checkGLError("at_tangent");
                }
                ARBShaderObjects.glLinkProgramARB(n);
                if (GL20.glGetProgrami(n, 35714) != 1) {
                    SMCLog.severe("Error linking program: " + n + " (" + program.getName() + ")");
                }
                Shaders.printLogInfo(n, program.getName());
                if (n2 != 0) {
                    ARBShaderObjects.glDetachObjectARB(n, n2);
                    ARBShaderObjects.glDeleteObjectARB(n2);
                }
                if (n3 != 0) {
                    ARBShaderObjects.glDetachObjectARB(n, n3);
                    ARBShaderObjects.glDeleteObjectARB(n3);
                }
                if (n4 != 0) {
                    ARBShaderObjects.glDetachObjectARB(n, n4);
                    ARBShaderObjects.glDeleteObjectARB(n4);
                }
                program.setId(n);
                program.setRef(n);
                Shaders.useProgram(program);
                ARBShaderObjects.glValidateProgramARB(n);
                Shaders.useProgram(ProgramNone);
                Shaders.printLogInfo(n, program.getName());
                int n5 = GL20.glGetProgrami(n, 35715);
                if (n5 != 1) {
                    String string4 = "\"";
                    Shaders.printChatAndLogError("[Shaders] Error: Invalid program " + string4 + program.getName() + string4);
                    ARBShaderObjects.glDeleteObjectARB(n);
                    n = 0;
                    program.resetId();
                }
            }
        }
    }

    private static int createVertShader(Program program, String string) {
        int n = ARBShaderObjects.glCreateShaderObjectARB(35633);
        if (n == 0) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder(131072);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(Shaders.getShaderReader(string));
        }
        catch (Exception exception) {
            ARBShaderObjects.glDeleteObjectARB(n);
            return 0;
        }
        ShaderOption[] shaderOptionArray = Shaders.getChangedOptions(shaderPackOptions);
        ArrayList<String> arrayList = new ArrayList<String>();
        if (bufferedReader != null) {
            try {
                bufferedReader = ShaderPackParser.resolveIncludes(bufferedReader, string, shaderPack, 0, arrayList, 0);
                MacroState macroState = new MacroState();
                while (true) {
                    ShaderLine shaderLine;
                    String string2;
                    if ((string2 = bufferedReader.readLine()) == null) {
                        bufferedReader.close();
                        break;
                    }
                    string2 = Shaders.applyOptions(string2, shaderOptionArray);
                    stringBuilder.append(string2).append('\n');
                    if (!macroState.processLine(string2) || (shaderLine = ShaderParser.parseLine(string2)) == null) continue;
                    if (shaderLine.isAttribute("mc_Entity")) {
                        useEntityAttrib = true;
                        progUseEntityAttrib = true;
                    } else if (shaderLine.isAttribute("mc_midTexCoord")) {
                        useMidTexCoordAttrib = true;
                        progUseMidTexCoordAttrib = true;
                    } else if (shaderLine.isAttribute("at_tangent")) {
                        useTangentAttrib = true;
                        progUseTangentAttrib = true;
                    }
                    if (!shaderLine.isConstInt("countInstances")) continue;
                    program.setCountInstances(shaderLine.getValueInt());
                    SMCLog.info("countInstances: " + program.getCountInstances());
                }
            }
            catch (Exception exception) {
                SMCLog.severe("Couldn't read " + string + "!");
                exception.printStackTrace();
                ARBShaderObjects.glDeleteObjectARB(n);
                return 0;
            }
        }
        if (saveFinalShaders) {
            Shaders.saveShader(string, stringBuilder.toString());
        }
        ARBShaderObjects.glShaderSourceARB(n, (CharSequence)stringBuilder);
        ARBShaderObjects.glCompileShaderARB(n);
        if (GL20.glGetShaderi(n, 35713) != 1) {
            SMCLog.severe("Error compiling vertex shader: " + string);
        }
        Shaders.printShaderLogInfo(n, string, arrayList);
        return n;
    }

    private static int createGeomShader(Program program, String string) {
        int n = ARBShaderObjects.glCreateShaderObjectARB(36313);
        if (n == 0) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder(131072);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(Shaders.getShaderReader(string));
        }
        catch (Exception exception) {
            ARBShaderObjects.glDeleteObjectARB(n);
            return 0;
        }
        ShaderOption[] shaderOptionArray = Shaders.getChangedOptions(shaderPackOptions);
        ArrayList<String> arrayList = new ArrayList<String>();
        progArbGeometryShader4 = false;
        progMaxVerticesOut = 3;
        if (bufferedReader != null) {
            try {
                bufferedReader = ShaderPackParser.resolveIncludes(bufferedReader, string, shaderPack, 0, arrayList, 0);
                MacroState macroState = new MacroState();
                while (true) {
                    String string2;
                    ShaderLine shaderLine;
                    String string3;
                    if ((string3 = bufferedReader.readLine()) == null) {
                        bufferedReader.close();
                        break;
                    }
                    string3 = Shaders.applyOptions(string3, shaderOptionArray);
                    stringBuilder.append(string3).append('\n');
                    if (!macroState.processLine(string3) || (shaderLine = ShaderParser.parseLine(string3)) == null) continue;
                    if (shaderLine.isExtension("GL_ARB_geometry_shader4") && ((string2 = Config.normalize(shaderLine.getValue())).equals("enable") || string2.equals("require") || string2.equals("warn"))) {
                        progArbGeometryShader4 = true;
                    }
                    if (!shaderLine.isConstInt("maxVerticesOut")) continue;
                    progMaxVerticesOut = shaderLine.getValueInt();
                }
            }
            catch (Exception exception) {
                SMCLog.severe("Couldn't read " + string + "!");
                exception.printStackTrace();
                ARBShaderObjects.glDeleteObjectARB(n);
                return 0;
            }
        }
        if (saveFinalShaders) {
            Shaders.saveShader(string, stringBuilder.toString());
        }
        ARBShaderObjects.glShaderSourceARB(n, (CharSequence)stringBuilder);
        ARBShaderObjects.glCompileShaderARB(n);
        if (GL20.glGetShaderi(n, 35713) != 1) {
            SMCLog.severe("Error compiling geometry shader: " + string);
        }
        Shaders.printShaderLogInfo(n, string, arrayList);
        return n;
    }

    private static int createFragShader(Program program, String string) {
        int n = ARBShaderObjects.glCreateShaderObjectARB(35632);
        if (n == 0) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder(131072);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(Shaders.getShaderReader(string));
        }
        catch (Exception exception) {
            ARBShaderObjects.glDeleteObjectARB(n);
            return 0;
        }
        ShaderOption[] shaderOptionArray = Shaders.getChangedOptions(shaderPackOptions);
        ArrayList<String> arrayList = new ArrayList<String>();
        if (bufferedReader != null) {
            try {
                bufferedReader = ShaderPackParser.resolveIncludes(bufferedReader, string, shaderPack, 0, arrayList, 0);
                MacroState macroState = new MacroState();
                while (true) {
                    String string2;
                    ShaderLine shaderLine;
                    String string3;
                    if ((string3 = bufferedReader.readLine()) == null) {
                        bufferedReader.close();
                        break;
                    }
                    string3 = Shaders.applyOptions(string3, shaderOptionArray);
                    stringBuilder.append(string3).append('\n');
                    if (!macroState.processLine(string3) || (shaderLine = ShaderParser.parseLine(string3)) == null) continue;
                    if (shaderLine.isUniform()) {
                        string2 = shaderLine.getName();
                        int n2 = ShaderParser.getShadowDepthIndex(string2);
                        if (n2 >= 0) {
                            usedShadowDepthBuffers = Math.max(usedShadowDepthBuffers, n2 + 1);
                            continue;
                        }
                        n2 = ShaderParser.getShadowColorIndex(string2);
                        if (n2 >= 0) {
                            usedShadowColorBuffers = Math.max(usedShadowColorBuffers, n2 + 1);
                            continue;
                        }
                        n2 = ShaderParser.getDepthIndex(string2);
                        if (n2 >= 0) {
                            usedDepthBuffers = Math.max(usedDepthBuffers, n2 + 1);
                            continue;
                        }
                        if (string2.equals("gdepth") && gbuffersFormat[1] == 6408) {
                            Shaders.gbuffersFormat[1] = 34836;
                            continue;
                        }
                        n2 = ShaderParser.getColorIndex(string2);
                        if (n2 >= 0) {
                            usedColorBuffers = Math.max(usedColorBuffers, n2 + 1);
                            continue;
                        }
                        if (!string2.equals("centerDepthSmooth")) continue;
                        centerDepthSmoothEnabled = true;
                        continue;
                    }
                    if (!shaderLine.isConstInt("shadowMapResolution") && !shaderLine.isProperty("SHADOWRES")) {
                        if (!shaderLine.isConstFloat("shadowMapFov") && !shaderLine.isProperty("SHADOWFOV")) {
                            if (!shaderLine.isConstFloat("shadowDistance") && !shaderLine.isProperty("SHADOWHPL")) {
                                if (shaderLine.isConstFloat("shadowDistanceRenderMul")) {
                                    shadowDistanceRenderMul = shaderLine.getValueFloat();
                                    SMCLog.info("Shadow distance render mul: " + shadowDistanceRenderMul);
                                    continue;
                                }
                                if (shaderLine.isConstFloat("shadowIntervalSize")) {
                                    shadowIntervalSize = shaderLine.getValueFloat();
                                    SMCLog.info("Shadow map interval size: " + shadowIntervalSize);
                                    continue;
                                }
                                if (shaderLine.isConstBool("generateShadowMipmap", true)) {
                                    Arrays.fill(shadowMipmapEnabled, true);
                                    SMCLog.info("Generate shadow mipmap");
                                    continue;
                                }
                                if (shaderLine.isConstBool("generateShadowColorMipmap", true)) {
                                    Arrays.fill(shadowColorMipmapEnabled, true);
                                    SMCLog.info("Generate shadow color mipmap");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowHardwareFiltering", true)) {
                                    Arrays.fill(shadowHardwareFilteringEnabled, true);
                                    SMCLog.info("Hardware shadow filtering enabled.");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowHardwareFiltering0", true)) {
                                    Shaders.shadowHardwareFilteringEnabled[0] = true;
                                    SMCLog.info("shadowHardwareFiltering0");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowHardwareFiltering1", true)) {
                                    Shaders.shadowHardwareFilteringEnabled[1] = true;
                                    SMCLog.info("shadowHardwareFiltering1");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowtex0Mipmap", "shadowtexMipmap", true)) {
                                    Shaders.shadowMipmapEnabled[0] = true;
                                    SMCLog.info("shadowtex0Mipmap");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowtex1Mipmap", true)) {
                                    Shaders.shadowMipmapEnabled[1] = true;
                                    SMCLog.info("shadowtex1Mipmap");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowcolor0Mipmap", "shadowColor0Mipmap", true)) {
                                    Shaders.shadowColorMipmapEnabled[0] = true;
                                    SMCLog.info("shadowcolor0Mipmap");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowcolor1Mipmap", "shadowColor1Mipmap", true)) {
                                    Shaders.shadowColorMipmapEnabled[1] = true;
                                    SMCLog.info("shadowcolor1Mipmap");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowtex0Nearest", "shadowtexNearest", "shadow0MinMagNearest", true)) {
                                    Shaders.shadowFilterNearest[0] = true;
                                    SMCLog.info("shadowtex0Nearest");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowtex1Nearest", "shadow1MinMagNearest", true)) {
                                    Shaders.shadowFilterNearest[1] = true;
                                    SMCLog.info("shadowtex1Nearest");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowcolor0Nearest", "shadowColor0Nearest", "shadowColor0MinMagNearest", true)) {
                                    Shaders.shadowColorFilterNearest[0] = true;
                                    SMCLog.info("shadowcolor0Nearest");
                                    continue;
                                }
                                if (shaderLine.isConstBool("shadowcolor1Nearest", "shadowColor1Nearest", "shadowColor1MinMagNearest", true)) {
                                    Shaders.shadowColorFilterNearest[1] = true;
                                    SMCLog.info("shadowcolor1Nearest");
                                    continue;
                                }
                                if (!shaderLine.isConstFloat("wetnessHalflife") && !shaderLine.isProperty("WETNESSHL")) {
                                    if (!shaderLine.isConstFloat("drynessHalflife") && !shaderLine.isProperty("DRYNESSHL")) {
                                        int n3;
                                        if (shaderLine.isConstFloat("eyeBrightnessHalflife")) {
                                            eyeBrightnessHalflife = shaderLine.getValueFloat();
                                            SMCLog.info("Eye brightness halflife: " + eyeBrightnessHalflife);
                                            continue;
                                        }
                                        if (shaderLine.isConstFloat("centerDepthHalflife")) {
                                            centerDepthSmoothHalflife = shaderLine.getValueFloat();
                                            SMCLog.info("Center depth halflife: " + centerDepthSmoothHalflife);
                                            continue;
                                        }
                                        if (shaderLine.isConstFloat("sunPathRotation")) {
                                            sunPathRotation = shaderLine.getValueFloat();
                                            SMCLog.info("Sun path rotation: " + sunPathRotation);
                                            continue;
                                        }
                                        if (shaderLine.isConstFloat("ambientOcclusionLevel")) {
                                            aoLevel = Config.limit(shaderLine.getValueFloat(), 0.0f, 1.0f);
                                            SMCLog.info("AO Level: " + aoLevel);
                                            continue;
                                        }
                                        if (shaderLine.isConstInt("superSamplingLevel")) {
                                            int n4 = shaderLine.getValueInt();
                                            if (n4 > 1) {
                                                SMCLog.info("Super sampling level: " + n4 + "x");
                                                superSamplingLevel = n4;
                                                continue;
                                            }
                                            superSamplingLevel = 1;
                                            continue;
                                        }
                                        if (shaderLine.isConstInt("noiseTextureResolution")) {
                                            noiseTextureResolution = shaderLine.getValueInt();
                                            noiseTextureEnabled = true;
                                            SMCLog.info("Noise texture enabled");
                                            SMCLog.info("Noise texture resolution: " + noiseTextureResolution);
                                            continue;
                                        }
                                        if (shaderLine.isConstIntSuffix("Format")) {
                                            string2 = StrUtils.removeSuffix(shaderLine.getName(), "Format");
                                            String string4 = shaderLine.getValue();
                                            n3 = Shaders.getBufferIndexFromString(string2);
                                            int n5 = Shaders.getTextureFormatFromString(string4);
                                            if (n3 < 0 || n5 == 0) continue;
                                            Shaders.gbuffersFormat[n3] = n5;
                                            SMCLog.info("%s format: %s", string2, string4);
                                            continue;
                                        }
                                        if (shaderLine.isConstBoolSuffix("Clear", false)) {
                                            int n6;
                                            if (!ShaderParser.isComposite(string) && !ShaderParser.isDeferred(string) || (n6 = Shaders.getBufferIndexFromString(string2 = StrUtils.removeSuffix(shaderLine.getName(), "Clear"))) < 0) continue;
                                            Shaders.gbuffersClear[n6] = false;
                                            SMCLog.info("%s clear disabled", string2);
                                            continue;
                                        }
                                        if (shaderLine.isConstVec4Suffix("ClearColor")) {
                                            int n7;
                                            if (!ShaderParser.isComposite(string) && !ShaderParser.isDeferred(string) || (n7 = Shaders.getBufferIndexFromString(string2 = StrUtils.removeSuffix(shaderLine.getName(), "ClearColor"))) < 0) continue;
                                            Vector4f vector4f = shaderLine.getValueVec4();
                                            if (vector4f != null) {
                                                Shaders.gbuffersClearColor[n7] = vector4f;
                                                SMCLog.info("%s clear color: %s %s %s %s", string2, Float.valueOf(vector4f.getX()), Float.valueOf(vector4f.getY()), Float.valueOf(vector4f.getZ()), Float.valueOf(vector4f.getW()));
                                                continue;
                                            }
                                            SMCLog.warning("Invalid color value: " + shaderLine.getValue());
                                            continue;
                                        }
                                        if (shaderLine.isProperty("GAUX4FORMAT", "RGBA32F")) {
                                            Shaders.gbuffersFormat[7] = 34836;
                                            SMCLog.info("gaux4 format : RGB32AF");
                                            continue;
                                        }
                                        if (shaderLine.isProperty("GAUX4FORMAT", "RGB32F")) {
                                            Shaders.gbuffersFormat[7] = 34837;
                                            SMCLog.info("gaux4 format : RGB32F");
                                            continue;
                                        }
                                        if (shaderLine.isProperty("GAUX4FORMAT", "RGB16")) {
                                            Shaders.gbuffersFormat[7] = 32852;
                                            SMCLog.info("gaux4 format : RGB16");
                                            continue;
                                        }
                                        if (shaderLine.isConstBoolSuffix("MipmapEnabled", true)) {
                                            int n8;
                                            if (!ShaderParser.isComposite(string) && !ShaderParser.isDeferred(string) && !ShaderParser.isFinal(string) || (n8 = Shaders.getBufferIndexFromString(string2 = StrUtils.removeSuffix(shaderLine.getName(), "MipmapEnabled"))) < 0) continue;
                                            n3 = program.getCompositeMipmapSetting();
                                            program.setCompositeMipmapSetting(n3 |= 1 << n8);
                                            SMCLog.info("%s mipmap enabled", string2);
                                            continue;
                                        }
                                        if (!shaderLine.isProperty("DRAWBUFFERS")) continue;
                                        string2 = shaderLine.getValue();
                                        if (ShaderParser.isValidDrawBuffers(string2)) {
                                            program.setDrawBufSettings(string2);
                                            continue;
                                        }
                                        SMCLog.warning("Invalid draw buffers: " + string2);
                                        continue;
                                    }
                                    drynessHalfLife = shaderLine.getValueFloat();
                                    SMCLog.info("Dryness halflife: " + drynessHalfLife);
                                    continue;
                                }
                                wetnessHalfLife = shaderLine.getValueFloat();
                                SMCLog.info("Wetness halflife: " + wetnessHalfLife);
                                continue;
                            }
                            shadowMapHalfPlane = shaderLine.getValueFloat();
                            shadowMapIsOrtho = true;
                            SMCLog.info("Shadow map distance: " + shadowMapHalfPlane);
                            continue;
                        }
                        shadowMapFOV = shaderLine.getValueFloat();
                        shadowMapIsOrtho = false;
                        SMCLog.info("Shadow map field of view: " + shadowMapFOV);
                        continue;
                    }
                    spShadowMapWidth = spShadowMapHeight = shaderLine.getValueInt();
                    shadowMapWidth = shadowMapHeight = Math.round((float)spShadowMapWidth * configShadowResMul);
                    SMCLog.info("Shadow map resolution: " + spShadowMapWidth);
                }
            }
            catch (Exception exception) {
                SMCLog.severe("Couldn't read " + string + "!");
                exception.printStackTrace();
                ARBShaderObjects.glDeleteObjectARB(n);
                return 0;
            }
        }
        if (saveFinalShaders) {
            Shaders.saveShader(string, stringBuilder.toString());
        }
        ARBShaderObjects.glShaderSourceARB(n, (CharSequence)stringBuilder);
        ARBShaderObjects.glCompileShaderARB(n);
        if (GL20.glGetShaderi(n, 35713) != 1) {
            SMCLog.severe("Error compiling fragment shader: " + string);
        }
        Shaders.printShaderLogInfo(n, string, arrayList);
        return n;
    }

    private static Reader getShaderReader(String string) {
        return new InputStreamReader(shaderPack.getResourceAsStream(string));
    }

    public static void saveShader(String string, String string2) {
        try {
            File file = new File(shaderPacksDir, "debug/" + string);
            file.getParentFile().mkdirs();
            Config.writeFile(file, string2);
        }
        catch (IOException iOException) {
            Config.warn("Error saving: " + string);
            iOException.printStackTrace();
        }
    }

    private static void clearDirectory(File file) {
        File[] fileArray;
        if (file.exists() && file.isDirectory() && (fileArray = file.listFiles()) != null) {
            for (int i = 0; i < fileArray.length; ++i) {
                File file2 = fileArray[i];
                if (file2.isDirectory()) {
                    Shaders.clearDirectory(file2);
                }
                file2.delete();
            }
        }
    }

    private static boolean printLogInfo(int n, String string) {
        IntBuffer intBuffer = BufferUtils.createIntBuffer(1);
        ARBShaderObjects.glGetObjectParameterivARB(n, 35716, intBuffer);
        int n2 = intBuffer.get();
        if (n2 > 1) {
            ByteBuffer byteBuffer = BufferUtils.createByteBuffer(n2);
            intBuffer.flip();
            ARBShaderObjects.glGetInfoLogARB(n, intBuffer, byteBuffer);
            byte[] byArray = new byte[n2];
            byteBuffer.get(byArray);
            if (byArray[n2 - 1] == 0) {
                byArray[n2 - 1] = 10;
            }
            String string2 = new String(byArray, Charsets.US_ASCII);
            string2 = StrUtils.trim(string2, " \n\r\t");
            SMCLog.info("Info log: " + string + "\n" + string2);
            return false;
        }
        return true;
    }

    private static boolean printShaderLogInfo(int n, String string, List<String> list) {
        IntBuffer intBuffer = BufferUtils.createIntBuffer(1);
        int n2 = GL20.glGetShaderi(n, 35716);
        if (n2 <= 1) {
            return true;
        }
        for (int i = 0; i < list.size(); ++i) {
            String string2 = list.get(i);
            SMCLog.info("File: " + (i + 1) + " = " + string2);
        }
        String string3 = GL20.glGetShaderInfoLog(n, n2);
        string3 = StrUtils.trim(string3, " \n\r\t");
        SMCLog.info("Shader info log: " + string + "\n" + string3);
        return false;
    }

    public static void setDrawBuffers(IntBuffer intBuffer) {
        if (intBuffer == null) {
            intBuffer = drawBuffersNone;
        }
        if (activeDrawBuffers != intBuffer) {
            activeDrawBuffers = intBuffer;
            GL20.glDrawBuffers(intBuffer);
            Shaders.checkGLError("setDrawBuffers");
        }
    }

    public static void useProgram(Program program) {
        Shaders.checkGLError("pre-useProgram");
        if (isShadowPass) {
            program = ProgramShadow;
        } else if (isEntitiesGlowing) {
            program = ProgramEntitiesGlowing;
        }
        if (activeProgram != program) {
            int n;
            Shaders.updateAlphaBlend(activeProgram, program);
            activeProgram = program;
            activeProgramID = n = program.getId();
            ARBShaderObjects.glUseProgramObjectARB(n);
            if (Shaders.checkGLError("useProgram") != 0) {
                program.setId(0);
                activeProgramID = n = program.getId();
                ARBShaderObjects.glUseProgramObjectARB(n);
            }
            shaderUniforms.setProgram(n);
            if (customUniforms != null) {
                customUniforms.setProgram(n);
            }
            if (n != 0) {
                IntBuffer intBuffer = program.getDrawBuffers();
                if (isRenderingDfb) {
                    Shaders.setDrawBuffers(intBuffer);
                }
                activeCompositeMipmapSetting = program.getCompositeMipmapSetting();
                switch (program.getProgramStage()) {
                    case GBUFFERS: {
                        Shaders.setProgramUniform1i(uniform_texture, 0);
                        Shaders.setProgramUniform1i(uniform_lightmap, 1);
                        Shaders.setProgramUniform1i(uniform_normals, 2);
                        Shaders.setProgramUniform1i(uniform_specular, 3);
                        Shaders.setProgramUniform1i(uniform_shadow, waterShadowEnabled ? 5 : 4);
                        Shaders.setProgramUniform1i(uniform_watershadow, 4);
                        Shaders.setProgramUniform1i(uniform_shadowtex0, 4);
                        Shaders.setProgramUniform1i(uniform_shadowtex1, 5);
                        Shaders.setProgramUniform1i(uniform_depthtex0, 6);
                        if (customTexturesGbuffers != null || hasDeferredPrograms) {
                            Shaders.setProgramUniform1i(uniform_gaux1, 7);
                            Shaders.setProgramUniform1i(uniform_gaux2, 8);
                            Shaders.setProgramUniform1i(uniform_gaux3, 9);
                            Shaders.setProgramUniform1i(uniform_gaux4, 10);
                        }
                        Shaders.setProgramUniform1i(uniform_depthtex1, 11);
                        Shaders.setProgramUniform1i(uniform_shadowcolor, 13);
                        Shaders.setProgramUniform1i(uniform_shadowcolor0, 13);
                        Shaders.setProgramUniform1i(uniform_shadowcolor1, 14);
                        Shaders.setProgramUniform1i(uniform_noisetex, 15);
                        break;
                    }
                    case DEFERRED: 
                    case COMPOSITE: {
                        Shaders.setProgramUniform1i(uniform_gcolor, 0);
                        Shaders.setProgramUniform1i(uniform_gdepth, 1);
                        Shaders.setProgramUniform1i(uniform_gnormal, 2);
                        Shaders.setProgramUniform1i(uniform_composite, 3);
                        Shaders.setProgramUniform1i(uniform_gaux1, 7);
                        Shaders.setProgramUniform1i(uniform_gaux2, 8);
                        Shaders.setProgramUniform1i(uniform_gaux3, 9);
                        Shaders.setProgramUniform1i(uniform_gaux4, 10);
                        Shaders.setProgramUniform1i(uniform_colortex0, 0);
                        Shaders.setProgramUniform1i(uniform_colortex1, 1);
                        Shaders.setProgramUniform1i(uniform_colortex2, 2);
                        Shaders.setProgramUniform1i(uniform_colortex3, 3);
                        Shaders.setProgramUniform1i(uniform_colortex4, 7);
                        Shaders.setProgramUniform1i(uniform_colortex5, 8);
                        Shaders.setProgramUniform1i(uniform_colortex6, 9);
                        Shaders.setProgramUniform1i(uniform_colortex7, 10);
                        Shaders.setProgramUniform1i(uniform_shadow, waterShadowEnabled ? 5 : 4);
                        Shaders.setProgramUniform1i(uniform_watershadow, 4);
                        Shaders.setProgramUniform1i(uniform_shadowtex0, 4);
                        Shaders.setProgramUniform1i(uniform_shadowtex1, 5);
                        Shaders.setProgramUniform1i(uniform_gdepthtex, 6);
                        Shaders.setProgramUniform1i(uniform_depthtex0, 6);
                        Shaders.setProgramUniform1i(uniform_depthtex1, 11);
                        Shaders.setProgramUniform1i(uniform_depthtex2, 12);
                        Shaders.setProgramUniform1i(uniform_shadowcolor, 13);
                        Shaders.setProgramUniform1i(uniform_shadowcolor0, 13);
                        Shaders.setProgramUniform1i(uniform_shadowcolor1, 14);
                        Shaders.setProgramUniform1i(uniform_noisetex, 15);
                        break;
                    }
                    case SHADOW: {
                        Shaders.setProgramUniform1i(uniform_tex, 0);
                        Shaders.setProgramUniform1i(uniform_texture, 0);
                        Shaders.setProgramUniform1i(uniform_lightmap, 1);
                        Shaders.setProgramUniform1i(uniform_normals, 2);
                        Shaders.setProgramUniform1i(uniform_specular, 3);
                        Shaders.setProgramUniform1i(uniform_shadow, waterShadowEnabled ? 5 : 4);
                        Shaders.setProgramUniform1i(uniform_watershadow, 4);
                        Shaders.setProgramUniform1i(uniform_shadowtex0, 4);
                        Shaders.setProgramUniform1i(uniform_shadowtex1, 5);
                        if (customTexturesGbuffers != null) {
                            Shaders.setProgramUniform1i(uniform_gaux1, 7);
                            Shaders.setProgramUniform1i(uniform_gaux2, 8);
                            Shaders.setProgramUniform1i(uniform_gaux3, 9);
                            Shaders.setProgramUniform1i(uniform_gaux4, 10);
                        }
                        Shaders.setProgramUniform1i(uniform_shadowcolor, 13);
                        Shaders.setProgramUniform1i(uniform_shadowcolor0, 13);
                        Shaders.setProgramUniform1i(uniform_shadowcolor1, 14);
                        Shaders.setProgramUniform1i(uniform_noisetex, 15);
                    }
                }
                ItemStack itemStack = Shaders.mc.thePlayer != null ? Shaders.mc.thePlayer.getHeldItem() : null;
                Item item = itemStack != null ? itemStack.getItem() : null;
                int n2 = -1;
                Block block = null;
                if (item != null) {
                    n2 = Item.itemRegistry.getIDForObject(item);
                    block = Block.blockRegistry.getObjectById(n2);
                    n2 = ItemAliases.getItemAliasId(n2);
                }
                int n3 = block != null ? block.getLightValue() : 0;
                Shaders.setProgramUniform1i(uniform_heldItemId, n2);
                Shaders.setProgramUniform1i(uniform_heldBlockLightValue, n3);
                Shaders.setProgramUniform1i(uniform_fogMode, fogEnabled ? fogMode : 0);
                Shaders.setProgramUniform1f(uniform_fogDensity, fogEnabled ? fogDensity : 0.0f);
                Shaders.setProgramUniform3f(uniform_fogColor, fogColorR, fogColorG, fogColorB);
                Shaders.setProgramUniform3f(uniform_skyColor, skyColorR, skyColorG, skyColorB);
                Shaders.setProgramUniform1i(uniform_worldTime, (int)(worldTime % 24000L));
                Shaders.setProgramUniform1i(uniform_worldDay, (int)(worldTime / 24000L));
                Shaders.setProgramUniform1i(uniform_moonPhase, moonPhase);
                Shaders.setProgramUniform1i(uniform_frameCounter, frameCounter);
                Shaders.setProgramUniform1f(uniform_frameTime, frameTime);
                Shaders.setProgramUniform1f(uniform_frameTimeCounter, frameTimeCounter);
                Shaders.setProgramUniform1f(uniform_sunAngle, sunAngle);
                Shaders.setProgramUniform1f(uniform_shadowAngle, shadowAngle);
                Shaders.setProgramUniform1f(uniform_rainStrength, rainStrength);
                Shaders.setProgramUniform1f(uniform_aspectRatio, (float)renderWidth / (float)renderHeight);
                Shaders.setProgramUniform1f(uniform_viewWidth, renderWidth);
                Shaders.setProgramUniform1f(uniform_viewHeight, renderHeight);
                Shaders.setProgramUniform1f(uniform_near, 0.05f);
                Shaders.setProgramUniform1f(uniform_far, Shaders.mc.gameSettings.renderDistanceChunks * 16);
                Shaders.setProgramUniform3f(uniform_sunPosition, sunPosition[0], sunPosition[1], sunPosition[2]);
                Shaders.setProgramUniform3f(uniform_moonPosition, moonPosition[0], moonPosition[1], moonPosition[2]);
                Shaders.setProgramUniform3f(uniform_shadowLightPosition, shadowLightPosition[0], shadowLightPosition[1], shadowLightPosition[2]);
                Shaders.setProgramUniform3f(uniform_upPosition, upPosition[0], upPosition[1], upPosition[2]);
                Shaders.setProgramUniform3f(uniform_previousCameraPosition, (float)previousCameraPositionX, (float)previousCameraPositionY, (float)previousCameraPositionZ);
                Shaders.setProgramUniform3f(uniform_cameraPosition, (float)cameraPositionX, (float)cameraPositionY, (float)cameraPositionZ);
                Shaders.setProgramUniformMatrix4ARB(uniform_gbufferModelView, false, modelView);
                Shaders.setProgramUniformMatrix4ARB(uniform_gbufferModelViewInverse, false, modelViewInverse);
                Shaders.setProgramUniformMatrix4ARB(uniform_gbufferPreviousProjection, false, previousProjection);
                Shaders.setProgramUniformMatrix4ARB(uniform_gbufferProjection, false, projection);
                Shaders.setProgramUniformMatrix4ARB(uniform_gbufferProjectionInverse, false, projectionInverse);
                Shaders.setProgramUniformMatrix4ARB(uniform_gbufferPreviousModelView, false, previousModelView);
                if (usedShadowDepthBuffers > 0) {
                    Shaders.setProgramUniformMatrix4ARB(uniform_shadowProjection, false, shadowProjection);
                    Shaders.setProgramUniformMatrix4ARB(uniform_shadowProjectionInverse, false, shadowProjectionInverse);
                    Shaders.setProgramUniformMatrix4ARB(uniform_shadowModelView, false, shadowModelView);
                    Shaders.setProgramUniformMatrix4ARB(uniform_shadowModelViewInverse, false, shadowModelViewInverse);
                }
                Shaders.setProgramUniform1f(uniform_wetness, wetness);
                Shaders.setProgramUniform1f(uniform_eyeAltitude, eyePosY);
                Shaders.setProgramUniform2i(uniform_eyeBrightness, eyeBrightness & 0xFFFF, eyeBrightness >> 16);
                Shaders.setProgramUniform2i(uniform_eyeBrightnessSmooth, Math.round(eyeBrightnessFadeX), Math.round(eyeBrightnessFadeY));
                Shaders.setProgramUniform2i(uniform_terrainTextureSize, terrainTextureSize[0], terrainTextureSize[1]);
                Shaders.setProgramUniform1i(uniform_terrainIconSize, terrainIconSize);
                Shaders.setProgramUniform1i(uniform_isEyeInWater, isEyeInWater);
                Shaders.setProgramUniform1f(uniform_nightVision, nightVision);
                Shaders.setProgramUniform1f(uniform_blindness, blindness);
                Shaders.setProgramUniform1f(uniform_screenBrightness, Shaders.mc.gameSettings.gammaSetting);
                Shaders.setProgramUniform1i(uniform_hideGUI, Shaders.mc.gameSettings.hideGUI ? 1 : 0);
                Shaders.setProgramUniform1f(uniform_centerDepthSmooth, centerDepthSmooth);
                Shaders.setProgramUniform2i(uniform_atlasSize, atlasSizeX, atlasSizeY);
                if (customUniforms != null) {
                    customUniforms.update();
                }
                Shaders.checkGLError("end useProgram");
            }
        }
    }

    private static void updateAlphaBlend(Program program, Program program2) {
        GlBlendState glBlendState;
        GlAlphaState glAlphaState;
        if (program.getAlphaState() != null) {
            GlStateManager.unlockAlpha();
        }
        if (program.getBlendState() != null) {
            GlStateManager.unlockBlend();
        }
        if ((glAlphaState = program2.getAlphaState()) != null) {
            GlStateManager.lockAlpha(glAlphaState);
        }
        if ((glBlendState = program2.getBlendState()) != null) {
            GlStateManager.lockBlend(glBlendState);
        }
    }

    private static void setProgramUniform1i(ShaderUniform1i shaderUniform1i, int n) {
        shaderUniform1i.setValue(n);
    }

    private static void setProgramUniform2i(ShaderUniform2i shaderUniform2i, int n, int n2) {
        shaderUniform2i.setValue(n, n2);
    }

    private static void setProgramUniform1f(ShaderUniform1f shaderUniform1f, float f) {
        shaderUniform1f.setValue(f);
    }

    private static void setProgramUniform3f(ShaderUniform3f shaderUniform3f, float f, float f2, float f3) {
        shaderUniform3f.setValue(f, f2, f3);
    }

    private static void setProgramUniformMatrix4ARB(ShaderUniformM4 shaderUniformM4, boolean bl, FloatBuffer floatBuffer) {
        shaderUniformM4.setValue(bl, floatBuffer);
    }

    public static int getBufferIndexFromString(String string) {
        return !string.equals("colortex0") && !string.equals("gcolor") ? (!string.equals("colortex1") && !string.equals("gdepth") ? (!string.equals("colortex2") && !string.equals("gnormal") ? (!string.equals("colortex3") && !string.equals("composite") ? (!string.equals("colortex4") && !string.equals("gaux1") ? (!string.equals("colortex5") && !string.equals("gaux2") ? (!string.equals("colortex6") && !string.equals("gaux3") ? (!string.equals("colortex7") && !string.equals("gaux4") ? -1 : 7) : 6) : 5) : 4) : 3) : 2) : 1) : 0;
    }

    private static int getTextureFormatFromString(String string) {
        string = string.trim();
        for (int i = 0; i < formatNames.length; ++i) {
            String string2 = formatNames[i];
            if (!string.equals(string2)) continue;
            return formatIds[i];
        }
        return 0;
    }

    private static void setupNoiseTexture() {
        if (noiseTexture == null && noiseTexturePath != null) {
            noiseTexture = Shaders.loadCustomTexture(15, noiseTexturePath);
        }
        if (noiseTexture == null) {
            noiseTexture = new HFNoiseTexture(noiseTextureResolution, noiseTextureResolution);
        }
    }

    private static void loadEntityDataMap() {
        Object object;
        mapBlockToEntityData = new IdentityHashMap<Block, Integer>(300);
        if (mapBlockToEntityData.isEmpty()) {
            for (Object object2 : Block.blockRegistry.getKeys()) {
                object = Block.blockRegistry.getObject((ResourceLocation)object2);
                int n = Block.blockRegistry.getIDForObject((Block)object);
                mapBlockToEntityData.put((Block)object, n);
            }
        }
        Object object3 = null;
        try {
            object3 = new BufferedReader(new InputStreamReader(shaderPack.getResourceAsStream("/mc_Entity_x.txt")));
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (object3 != null) {
            try {
                Object object2;
                while ((object2 = ((BufferedReader)object3).readLine()) != null) {
                    object = patternLoadEntityDataMap.matcher((CharSequence)object2);
                    if (((Matcher)object).matches()) {
                        String string = ((Matcher)object).group(1);
                        String string2 = ((Matcher)object).group(2);
                        int n = Integer.parseInt(string2);
                        Block block = Block.getBlockFromName(string);
                        if (block != null) {
                            mapBlockToEntityData.put(block, n);
                            continue;
                        }
                        SMCLog.warning("Unknown block name %s", string);
                        continue;
                    }
                    SMCLog.warning("unmatched %s\n", object2);
                }
            }
            catch (Exception exception) {
                SMCLog.warning("Error parsing mc_Entity_x.txt");
            }
        }
        if (object3 != null) {
            try {
                ((BufferedReader)object3).close();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private static IntBuffer fillIntBufferZero(IntBuffer intBuffer) {
        int n = intBuffer.limit();
        for (int i = intBuffer.position(); i < n; ++i) {
            intBuffer.put(i, 0);
        }
        return intBuffer;
    }

    public static void uninit() {
        if (isShaderPackInitialized) {
            Shaders.checkGLError("Shaders.uninit pre");
            for (int i = 0; i < ProgramsAll.length; ++i) {
                Program program = ProgramsAll[i];
                if (program.getRef() != 0) {
                    ARBShaderObjects.glDeleteObjectARB(program.getRef());
                    Shaders.checkGLError("del programRef");
                }
                program.setRef(0);
                program.setId(0);
                program.setDrawBufSettings(null);
                program.setDrawBuffers(null);
                program.setCompositeMipmapSetting(0);
            }
            hasDeferredPrograms = false;
            if (dfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(dfb);
                dfb = 0;
                Shaders.checkGLError("del dfb");
            }
            if (sfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(sfb);
                sfb = 0;
                Shaders.checkGLError("del sfb");
            }
            if (dfbDepthTextures != null) {
                GlStateManager.deleteTextures(dfbDepthTextures);
                Shaders.fillIntBufferZero(dfbDepthTextures);
                Shaders.checkGLError("del dfbDepthTextures");
            }
            if (dfbColorTextures != null) {
                GlStateManager.deleteTextures(dfbColorTextures);
                Shaders.fillIntBufferZero(dfbColorTextures);
                Shaders.checkGLError("del dfbTextures");
            }
            if (sfbDepthTextures != null) {
                GlStateManager.deleteTextures(sfbDepthTextures);
                Shaders.fillIntBufferZero(sfbDepthTextures);
                Shaders.checkGLError("del shadow depth");
            }
            if (sfbColorTextures != null) {
                GlStateManager.deleteTextures(sfbColorTextures);
                Shaders.fillIntBufferZero(sfbColorTextures);
                Shaders.checkGLError("del shadow color");
            }
            if (dfbDrawBuffers != null) {
                Shaders.fillIntBufferZero(dfbDrawBuffers);
            }
            if (noiseTexture != null) {
                noiseTexture.deleteTexture();
                noiseTexture = null;
            }
            SMCLog.info("Uninit");
            shadowPassInterval = 0;
            shouldSkipDefaultShadow = false;
            isShaderPackInitialized = false;
            Shaders.checkGLError("Shaders.uninit");
        }
    }

    public static void scheduleResize() {
        renderDisplayHeight = 0;
    }

    public static void scheduleResizeShadow() {
        needResizeShadow = true;
    }

    private static void resize() {
        renderDisplayWidth = Shaders.mc.displayWidth;
        renderDisplayHeight = Shaders.mc.displayHeight;
        renderWidth = Math.round((float)renderDisplayWidth * configRenderResMul);
        renderHeight = Math.round((float)renderDisplayHeight * configRenderResMul);
        Shaders.setupFrameBuffer();
    }

    private static void resizeShadow() {
        needResizeShadow = false;
        shadowMapWidth = Math.round((float)spShadowMapWidth * configShadowResMul);
        shadowMapHeight = Math.round((float)spShadowMapHeight * configShadowResMul);
        Shaders.setupShadowFrameBuffer();
    }

    private static void setupFrameBuffer() {
        int n;
        if (dfb != 0) {
            EXTFramebufferObject.glDeleteFramebuffersEXT(dfb);
            GlStateManager.deleteTextures(dfbDepthTextures);
            GlStateManager.deleteTextures(dfbColorTextures);
        }
        dfb = EXTFramebufferObject.glGenFramebuffersEXT();
        GL11.glGenTextures(dfbDepthTextures.clear().limit(usedDepthBuffers));
        GL11.glGenTextures(dfbColorTextures.clear().limit(16));
        dfbDepthTextures.position(0);
        dfbColorTextures.position(0);
        EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
        GL20.glDrawBuffers(0);
        GL11.glReadBuffer(0);
        for (n = 0; n < usedDepthBuffers; ++n) {
            GlStateManager.bindTexture(dfbDepthTextures.get(n));
            GL11.glTexParameteri(3553, 10242, 33071);
            GL11.glTexParameteri(3553, 10243, 33071);
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
            GL11.glTexParameteri(3553, 34891, 6409);
            GL11.glTexImage2D(3553, 0, 6402, renderWidth, renderHeight, 0, 6402, 5126, (FloatBuffer)null);
        }
        EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, dfbDepthTextures.get(0), 0);
        GL20.glDrawBuffers(dfbDrawBuffers);
        GL11.glReadBuffer(0);
        Shaders.checkGLError("FT d");
        for (n = 0; n < usedColorBuffers; ++n) {
            GlStateManager.bindTexture(dfbColorTexturesFlip.getA(n));
            GL11.glTexParameteri(3553, 10242, 33071);
            GL11.glTexParameteri(3553, 10243, 33071);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexImage2D(3553, 0, gbuffersFormat[n], renderWidth, renderHeight, 0, Shaders.getPixelFormat(gbuffersFormat[n]), 33639, (ByteBuffer)null);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + n, 3553, dfbColorTexturesFlip.getA(n), 0);
            Shaders.checkGLError("FT c");
        }
        for (n = 0; n < usedColorBuffers; ++n) {
            GlStateManager.bindTexture(dfbColorTexturesFlip.getB(n));
            GL11.glTexParameteri(3553, 10242, 33071);
            GL11.glTexParameteri(3553, 10243, 33071);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexImage2D(3553, 0, gbuffersFormat[n], renderWidth, renderHeight, 0, Shaders.getPixelFormat(gbuffersFormat[n]), 33639, (ByteBuffer)null);
            Shaders.checkGLError("FT ca");
        }
        n = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
        if (n == 36058) {
            Shaders.printChatAndLogError("[Shaders] Error: Failed framebuffer incomplete formats");
            for (int i = 0; i < usedColorBuffers; ++i) {
                GlStateManager.bindTexture(dfbColorTexturesFlip.getA(i));
                GL11.glTexImage2D(3553, 0, 6408, renderWidth, renderHeight, 0, 32993, 33639, (ByteBuffer)null);
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + i, 3553, dfbColorTexturesFlip.getA(i), 0);
                Shaders.checkGLError("FT c");
            }
            n = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
            if (n == 36053) {
                SMCLog.info("complete");
            }
        }
        GlStateManager.bindTexture(0);
        if (n != 36053) {
            Shaders.printChatAndLogError("[Shaders] Error: Failed creating framebuffer! (Status " + n + ")");
        } else {
            SMCLog.info("Framebuffer created.");
        }
    }

    private static int getPixelFormat(int n) {
        switch (n) {
            case 33333: 
            case 33334: 
            case 33339: 
            case 33340: 
            case 36208: 
            case 36209: 
            case 36226: 
            case 36227: {
                return 36251;
            }
        }
        return 32993;
    }

    private static void setupShadowFrameBuffer() {
        if (usedShadowDepthBuffers != 0) {
            int n;
            int n2;
            if (sfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(sfb);
                GlStateManager.deleteTextures(sfbDepthTextures);
                GlStateManager.deleteTextures(sfbColorTextures);
            }
            sfb = EXTFramebufferObject.glGenFramebuffersEXT();
            EXTFramebufferObject.glBindFramebufferEXT(36160, sfb);
            GL11.glDrawBuffer(0);
            GL11.glReadBuffer(0);
            GL11.glGenTextures(sfbDepthTextures.clear().limit(usedShadowDepthBuffers));
            GL11.glGenTextures(sfbColorTextures.clear().limit(usedShadowColorBuffers));
            sfbDepthTextures.position(0);
            sfbColorTextures.position(0);
            for (n2 = 0; n2 < usedShadowDepthBuffers; ++n2) {
                GlStateManager.bindTexture(sfbDepthTextures.get(n2));
                GL11.glTexParameterf(3553, 10242, 33071.0f);
                GL11.glTexParameterf(3553, 10243, 33071.0f);
                n = shadowFilterNearest[n2] ? 9728 : 9729;
                GL11.glTexParameteri(3553, 10241, n);
                GL11.glTexParameteri(3553, 10240, n);
                if (shadowHardwareFilteringEnabled[n2]) {
                    GL11.glTexParameteri(3553, 34892, 34894);
                }
                GL11.glTexImage2D(3553, 0, 6402, shadowMapWidth, shadowMapHeight, 0, 6402, 5126, (FloatBuffer)null);
            }
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbDepthTextures.get(0), 0);
            Shaders.checkGLError("FT sd");
            for (n2 = 0; n2 < usedShadowColorBuffers; ++n2) {
                GlStateManager.bindTexture(sfbColorTextures.get(n2));
                GL11.glTexParameterf(3553, 10242, 33071.0f);
                GL11.glTexParameterf(3553, 10243, 33071.0f);
                n = shadowColorFilterNearest[n2] ? 9728 : 9729;
                GL11.glTexParameteri(3553, 10241, n);
                GL11.glTexParameteri(3553, 10240, n);
                GL11.glTexImage2D(3553, 0, 6408, shadowMapWidth, shadowMapHeight, 0, 32993, 33639, (ByteBuffer)null);
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + n2, 3553, sfbColorTextures.get(n2), 0);
                Shaders.checkGLError("FT sc");
            }
            GlStateManager.bindTexture(0);
            if (usedShadowColorBuffers > 0) {
                GL20.glDrawBuffers(sfbDrawBuffers);
            }
            if ((n2 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160)) != 36053) {
                Shaders.printChatAndLogError("[Shaders] Error: Failed creating shadow framebuffer! (Status " + n2 + ")");
            } else {
                SMCLog.info("Shadow framebuffer created.");
            }
        }
    }

    public static void beginRender(Minecraft minecraft, float f, long l) {
        block13: {
            Shaders.checkGLError("pre beginRender");
            Shaders.checkWorldChanged(Shaders.mc.theWorld);
            mc = minecraft;
            Shaders.mc.mcProfiler.startSection("init");
            entityRenderer = Shaders.mc.entityRenderer;
            if (!isShaderPackInitialized) {
                try {
                    Shaders.init();
                }
                catch (IllegalStateException illegalStateException) {
                    if (!Config.normalize(illegalStateException.getMessage()).equals("Function is not supported")) break block13;
                    Shaders.printChatAndLogError("[Shaders] Error: " + illegalStateException.getMessage());
                    illegalStateException.printStackTrace();
                    Shaders.setShaderPack(SHADER_PACK_NAME_NONE);
                    return;
                }
            }
        }
        if (Shaders.mc.displayWidth != renderDisplayWidth || Shaders.mc.displayHeight != renderDisplayHeight) {
            Shaders.resize();
        }
        if (needResizeShadow) {
            Shaders.resizeShadow();
        }
        if ((diffWorldTime = ((worldTime = Shaders.mc.theWorld.getWorldTime()) - lastWorldTime) % 24000L) < 0L) {
            diffWorldTime += 24000L;
        }
        lastWorldTime = worldTime;
        moonPhase = Shaders.mc.theWorld.getMoonPhase();
        if (++frameCounter >= 720720) {
            frameCounter = 0;
        }
        systemTime = System.currentTimeMillis();
        if (lastSystemTime == 0L) {
            lastSystemTime = systemTime;
        }
        diffSystemTime = systemTime - lastSystemTime;
        lastSystemTime = systemTime;
        frameTime = (float)diffSystemTime / 1000.0f;
        frameTimeCounter += frameTime;
        frameTimeCounter %= 3600.0f;
        rainStrength = minecraft.theWorld.getRainStrength(f);
        float f2 = (float)diffSystemTime * 0.01f;
        float f3 = (float)Math.exp(Math.log(0.5) * (double)f2 / (double)(wetness < rainStrength ? drynessHalfLife : wetnessHalfLife));
        wetness = wetness * f3 + rainStrength * (1.0f - f3);
        Entity entity = mc.getRenderViewEntity();
        if (entity != null) {
            isSleeping = entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPlayerSleeping();
            eyePosY = (float)entity.posY * f + (float)entity.lastTickPosY * (1.0f - f);
            eyeBrightness = entity.getBrightnessForRender(f);
            f3 = (float)diffSystemTime * 0.01f;
            float f4 = (float)Math.exp(Math.log(0.5) * (double)f3 / (double)eyeBrightnessHalflife);
            eyeBrightnessFadeX = eyeBrightnessFadeX * f4 + (float)(eyeBrightness & 0xFFFF) * (1.0f - f4);
            eyeBrightnessFadeY = eyeBrightnessFadeY * f4 + (float)(eyeBrightness >> 16) * (1.0f - f4);
            Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(Shaders.mc.theWorld, entity, f);
            Material material = block.getMaterial();
            isEyeInWater = material == Material.water ? 1 : (material == Material.lava ? 2 : 0);
            if (Shaders.mc.thePlayer != null) {
                nightVision = 0.0f;
                if (Shaders.mc.thePlayer.isPotionActive(Potion.nightVision)) {
                    nightVision = Config.getMinecraft().entityRenderer.getNightVisionBrightness(Shaders.mc.thePlayer, f);
                }
                blindness = 0.0f;
                if (Shaders.mc.thePlayer.isPotionActive(Potion.blindness)) {
                    int n = Shaders.mc.thePlayer.getActivePotionEffect(Potion.blindness).getDuration();
                    blindness = Config.limit((float)n / 20.0f, 0.0f, 1.0f);
                }
            }
            Vec3 vec3 = Shaders.mc.theWorld.getSkyColor(entity, f);
            vec3 = CustomColors.getWorldSkyColor(vec3, currentWorld, entity, f);
            skyColorR = (float)vec3.xCoord;
            skyColorG = (float)vec3.yCoord;
            skyColorB = (float)vec3.zCoord;
        }
        isRenderingWorld = true;
        isCompositeRendered = false;
        isShadowPass = false;
        isHandRenderedMain = false;
        isHandRenderedOff = false;
        skipRenderHandMain = false;
        skipRenderHandOff = false;
        Shaders.bindGbuffersTextures();
        previousCameraPositionX = cameraPositionX;
        previousCameraPositionY = cameraPositionY;
        previousCameraPositionZ = cameraPositionZ;
        previousProjection.position(0);
        projection.position(0);
        previousProjection.put(projection);
        previousProjection.position(0);
        projection.position(0);
        previousModelView.position(0);
        modelView.position(0);
        previousModelView.put(modelView);
        previousModelView.position(0);
        modelView.position(0);
        Shaders.checkGLError("beginRender");
        ShadersRender.renderShadowMap(entityRenderer, 0, f, l);
        Shaders.mc.mcProfiler.endSection();
        EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
        for (int i = 0; i < usedColorBuffers; ++i) {
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + i, 3553, dfbColorTexturesFlip.getA(i), 0);
        }
        Shaders.checkGLError("end beginRender");
    }

    private static void bindGbuffersTextures() {
        int n;
        if (usedShadowDepthBuffers >= 1) {
            GlStateManager.setActiveTexture(33988);
            GlStateManager.bindTexture(sfbDepthTextures.get(0));
            if (usedShadowDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33989);
                GlStateManager.bindTexture(sfbDepthTextures.get(1));
            }
        }
        GlStateManager.setActiveTexture(33984);
        for (n = 0; n < usedColorBuffers; ++n) {
            GlStateManager.bindTexture(dfbColorTexturesFlip.getA(n));
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
            GlStateManager.bindTexture(dfbColorTexturesFlip.getB(n));
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
        }
        GlStateManager.bindTexture(0);
        for (n = 0; n < 4 && 4 + n < usedColorBuffers; ++n) {
            GlStateManager.setActiveTexture(33991 + n);
            GlStateManager.bindTexture(dfbColorTexturesFlip.getA(4 + n));
        }
        GlStateManager.setActiveTexture(33990);
        GlStateManager.bindTexture(dfbDepthTextures.get(0));
        if (usedDepthBuffers >= 2) {
            GlStateManager.setActiveTexture(33995);
            GlStateManager.bindTexture(dfbDepthTextures.get(1));
            if (usedDepthBuffers >= 3) {
                GlStateManager.setActiveTexture(33996);
                GlStateManager.bindTexture(dfbDepthTextures.get(2));
            }
        }
        for (n = 0; n < usedShadowColorBuffers; ++n) {
            GlStateManager.setActiveTexture(33997 + n);
            GlStateManager.bindTexture(sfbColorTextures.get(n));
        }
        if (noiseTextureEnabled) {
            GlStateManager.setActiveTexture(33984 + noiseTexture.getTextureUnit());
            GlStateManager.bindTexture(noiseTexture.getTextureId());
        }
        Shaders.bindCustomTextures(customTexturesGbuffers);
        GlStateManager.setActiveTexture(33984);
    }

    public static void checkWorldChanged(World world2) {
        if (currentWorld != world2) {
            World world3 = currentWorld;
            currentWorld = world2;
            Shaders.setCameraOffset(mc.getRenderViewEntity());
            int n = Shaders.getDimensionId(world3);
            int n2 = Shaders.getDimensionId(world2);
            if (n2 != n) {
                boolean bl = shaderPackDimensions.contains(n);
                boolean bl2 = shaderPackDimensions.contains(n2);
                if (bl || bl2) {
                    Shaders.uninit();
                }
            }
            Smoother.resetValues();
        }
    }

    private static int getDimensionId(World world2) {
        return world2 == null ? Integer.MIN_VALUE : world2.provider.getDimensionId();
    }

    public static void beginRenderPass(int n, float f, long l) {
        if (!isShadowPass) {
            EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
            GL11.glViewport(0, 0, renderWidth, renderHeight);
            activeDrawBuffers = null;
            ShadersTex.bindNSTextures(defaultTexture.getMultiTexID());
            Shaders.useProgram(ProgramTextured);
            Shaders.checkGLError("end beginRenderPass");
        }
    }

    public static void setViewport(int n, int n2, int n3, int n4) {
        GlStateManager.colorMask(true, true, true, true);
        if (isShadowPass) {
            GL11.glViewport(0, 0, shadowMapWidth, shadowMapHeight);
        } else {
            GL11.glViewport(0, 0, renderWidth, renderHeight);
            EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
            isRenderingDfb = true;
            GlStateManager.enableCull();
            GlStateManager.enableDepth();
            Shaders.setDrawBuffers(drawBuffersNone);
            Shaders.useProgram(ProgramTextured);
            Shaders.checkGLError("beginRenderPass");
        }
    }

    public static void setFogMode(int n) {
        fogMode = n;
        if (fogEnabled) {
            Shaders.setProgramUniform1i(uniform_fogMode, n);
        }
    }

    public static void setFogColor(float f, float f2, float f3) {
        fogColorR = f;
        fogColorG = f2;
        fogColorB = f3;
        Shaders.setProgramUniform3f(uniform_fogColor, fogColorR, fogColorG, fogColorB);
    }

    public static void setClearColor(float f, float f2, float f3, float f4) {
        GlStateManager.clearColor(f, f2, f3, f4);
        clearColorR = f;
        clearColorG = f2;
        clearColorB = f3;
    }

    public static void clearRenderBuffer() {
        if (isShadowPass) {
            Shaders.checkGLError("shadow clear pre");
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbDepthTextures.get(0), 0);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL20.glDrawBuffers(ProgramShadow.getDrawBuffers());
            Shaders.checkFramebufferStatus("shadow clear");
            GL11.glClear(16640);
            Shaders.checkGLError("shadow clear");
        } else {
            Vector4f vector4f;
            Shaders.checkGLError("clear pre");
            if (gbuffersClear[0]) {
                vector4f = gbuffersClearColor[0];
                if (vector4f != null) {
                    GL11.glClearColor(vector4f.getX(), vector4f.getY(), vector4f.getZ(), vector4f.getW());
                }
                if (dfbColorTexturesFlip.isChanged(0)) {
                    EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064, 3553, dfbColorTexturesFlip.getB(0), 0);
                    GL20.glDrawBuffers(36064);
                    GL11.glClear(16384);
                    EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064, 3553, dfbColorTexturesFlip.getA(0), 0);
                }
                GL20.glDrawBuffers(36064);
                GL11.glClear(16384);
            }
            if (gbuffersClear[1]) {
                GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                vector4f = gbuffersClearColor[1];
                if (vector4f != null) {
                    GL11.glClearColor(vector4f.getX(), vector4f.getY(), vector4f.getZ(), vector4f.getW());
                }
                if (dfbColorTexturesFlip.isChanged(1)) {
                    EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36065, 3553, dfbColorTexturesFlip.getB(1), 0);
                    GL20.glDrawBuffers(36065);
                    GL11.glClear(16384);
                    EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36065, 3553, dfbColorTexturesFlip.getA(1), 0);
                }
                GL20.glDrawBuffers(36065);
                GL11.glClear(16384);
            }
            for (int i = 2; i < usedColorBuffers; ++i) {
                if (!gbuffersClear[i]) continue;
                GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                Vector4f vector4f2 = gbuffersClearColor[i];
                if (vector4f2 != null) {
                    GL11.glClearColor(vector4f2.getX(), vector4f2.getY(), vector4f2.getZ(), vector4f2.getW());
                }
                if (dfbColorTexturesFlip.isChanged(i)) {
                    EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + i, 3553, dfbColorTexturesFlip.getB(i), 0);
                    GL20.glDrawBuffers(36064 + i);
                    GL11.glClear(16384);
                    EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + i, 3553, dfbColorTexturesFlip.getA(i), 0);
                }
                GL20.glDrawBuffers(36064 + i);
                GL11.glClear(16384);
            }
            Shaders.setDrawBuffers(dfbDrawBuffers);
            Shaders.checkFramebufferStatus("clear");
            Shaders.checkGLError("clear");
        }
    }

    public static void setCamera(float f) {
        Entity entity = mc.getRenderViewEntity();
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        Shaders.updateCameraOffset(entity);
        cameraPositionX = d - (double)cameraOffsetX;
        cameraPositionY = d2;
        cameraPositionZ = d3 - (double)cameraOffsetZ;
        oc30aea91d28.\u0132(2983, projection.position(0));
        SMath.invertMat4FBFA(projectionInverse.position(0), projection.position(0), faProjectionInverse, faProjection);
        projection.position(0);
        projectionInverse.position(0);
        oc30aea91d28.\u0132(2982, modelView.position(0));
        SMath.invertMat4FBFA(modelViewInverse.position(0), modelView.position(0), faModelViewInverse, faModelView);
        modelView.position(0);
        modelViewInverse.position(0);
        Shaders.checkGLError("setCamera");
    }

    private static void updateCameraOffset(Entity entity) {
        double d = Math.abs(cameraPositionX - previousCameraPositionX);
        double d2 = Math.abs(cameraPositionZ - previousCameraPositionZ);
        double d3 = Math.abs(cameraPositionX);
        double d4 = Math.abs(cameraPositionZ);
        if (d > 1000.0 || d2 > 1000.0 || d3 > 1000000.0 || d4 > 1000000.0) {
            Shaders.setCameraOffset(entity);
        }
    }

    private static void setCameraOffset(Entity entity) {
        if (entity == null) {
            cameraOffsetX = 0;
            cameraOffsetZ = 0;
        } else {
            cameraOffsetX = (int)entity.posX / 1000 * 1000;
            cameraOffsetZ = (int)entity.posZ / 1000 * 1000;
        }
    }

    public static void setCameraShadow(float f) {
        float f2;
        float f3;
        float f4;
        Entity entity = mc.getRenderViewEntity();
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        Shaders.updateCameraOffset(entity);
        cameraPositionX = d - (double)cameraOffsetX;
        cameraPositionY = d2;
        cameraPositionZ = d3 - (double)cameraOffsetZ;
        oc30aea91d28.\u0132(2983, projection.position(0));
        SMath.invertMat4FBFA(projectionInverse.position(0), projection.position(0), faProjectionInverse, faProjection);
        projection.position(0);
        projectionInverse.position(0);
        oc30aea91d28.\u0132(2982, modelView.position(0));
        SMath.invertMat4FBFA(modelViewInverse.position(0), modelView.position(0), faModelViewInverse, faModelView);
        modelView.position(0);
        modelViewInverse.position(0);
        GL11.glViewport(0, 0, shadowMapWidth, shadowMapHeight);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        if (shadowMapIsOrtho) {
            GL11.glOrtho(-shadowMapHalfPlane, shadowMapHalfPlane, -shadowMapHalfPlane, shadowMapHalfPlane, 0.05f, 256.0);
        } else {
            GLU.gluPerspective(shadowMapFOV, (float)shadowMapWidth / (float)shadowMapHeight, 0.05f, 256.0f);
        }
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -100.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        celestialAngle = Shaders.mc.theWorld.getCelestialAngle(f);
        sunAngle = celestialAngle < 0.75f ? celestialAngle + 0.25f : celestialAngle - 0.75f;
        float f5 = celestialAngle * -360.0f;
        float f6 = f4 = shadowAngleInterval > 0.0f ? f5 % shadowAngleInterval - shadowAngleInterval * 0.5f : 0.0f;
        if ((double)sunAngle <= 0.5) {
            GL11.glRotatef(f5 - f4, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(sunPathRotation, 1.0f, 0.0f, 0.0f);
            shadowAngle = sunAngle;
        } else {
            GL11.glRotatef(f5 + 180.0f - f4, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(sunPathRotation, 1.0f, 0.0f, 0.0f);
            shadowAngle = sunAngle - 0.5f;
        }
        if (shadowMapIsOrtho) {
            f3 = shadowIntervalSize;
            f2 = f3 / 2.0f;
            GL11.glTranslatef((float)d % f3 - f2, (float)d2 % f3 - f2, (float)d3 % f3 - f2);
        }
        f3 = sunAngle * ((float)Math.PI * 2);
        f2 = (float)Math.cos(f3);
        float f7 = (float)Math.sin(f3);
        float f8 = sunPathRotation * ((float)Math.PI * 2);
        float f9 = f2;
        float f10 = f7 * (float)Math.cos(f8);
        float f11 = f7 * (float)Math.sin(f8);
        if ((double)sunAngle > 0.5) {
            f9 = -f2;
            f10 = -f10;
            f11 = -f11;
        }
        Shaders.shadowLightPositionVector[0] = f9;
        Shaders.shadowLightPositionVector[1] = f10;
        Shaders.shadowLightPositionVector[2] = f11;
        Shaders.shadowLightPositionVector[3] = 0.0f;
        oc30aea91d28.\u0132(2983, shadowProjection.position(0));
        SMath.invertMat4FBFA(shadowProjectionInverse.position(0), shadowProjection.position(0), faShadowProjectionInverse, faShadowProjection);
        shadowProjection.position(0);
        shadowProjectionInverse.position(0);
        oc30aea91d28.\u0132(2982, shadowModelView.position(0));
        SMath.invertMat4FBFA(shadowModelViewInverse.position(0), shadowModelView.position(0), faShadowModelViewInverse, faShadowModelView);
        shadowModelView.position(0);
        shadowModelViewInverse.position(0);
        Shaders.setProgramUniformMatrix4ARB(uniform_gbufferProjection, false, projection);
        Shaders.setProgramUniformMatrix4ARB(uniform_gbufferProjectionInverse, false, projectionInverse);
        Shaders.setProgramUniformMatrix4ARB(uniform_gbufferPreviousProjection, false, previousProjection);
        Shaders.setProgramUniformMatrix4ARB(uniform_gbufferModelView, false, modelView);
        Shaders.setProgramUniformMatrix4ARB(uniform_gbufferModelViewInverse, false, modelViewInverse);
        Shaders.setProgramUniformMatrix4ARB(uniform_gbufferPreviousModelView, false, previousModelView);
        Shaders.setProgramUniformMatrix4ARB(uniform_shadowProjection, false, shadowProjection);
        Shaders.setProgramUniformMatrix4ARB(uniform_shadowProjectionInverse, false, shadowProjectionInverse);
        Shaders.setProgramUniformMatrix4ARB(uniform_shadowModelView, false, shadowModelView);
        Shaders.setProgramUniformMatrix4ARB(uniform_shadowModelViewInverse, false, shadowModelViewInverse);
        Shaders.mc.gameSettings.thirdPersonView = 1;
        Shaders.checkGLError("setCamera");
    }

    public static void preCelestialRotate() {
        GL11.glRotatef(sunPathRotation * 1.0f, 0.0f, 0.0f, 1.0f);
        Shaders.checkGLError("preCelestialRotate");
    }

    public static void postCelestialRotate() {
        FloatBuffer floatBuffer = tempMatrixDirectBuffer;
        floatBuffer.clear();
        oc30aea91d28.\u0132(2982, floatBuffer);
        floatBuffer.get(tempMat, 0, 16);
        SMath.multiplyMat4xVec4(sunPosition, tempMat, sunPosModelView);
        SMath.multiplyMat4xVec4(moonPosition, tempMat, moonPosModelView);
        System.arraycopy(shadowAngle == sunAngle ? sunPosition : moonPosition, 0, shadowLightPosition, 0, 3);
        Shaders.setProgramUniform3f(uniform_sunPosition, sunPosition[0], sunPosition[1], sunPosition[2]);
        Shaders.setProgramUniform3f(uniform_moonPosition, moonPosition[0], moonPosition[1], moonPosition[2]);
        Shaders.setProgramUniform3f(uniform_shadowLightPosition, shadowLightPosition[0], shadowLightPosition[1], shadowLightPosition[2]);
        if (customUniforms != null) {
            customUniforms.update();
        }
        Shaders.checkGLError("postCelestialRotate");
    }

    public static void setUpPosition() {
        FloatBuffer floatBuffer = tempMatrixDirectBuffer;
        floatBuffer.clear();
        oc30aea91d28.\u0132(2982, floatBuffer);
        floatBuffer.get(tempMat, 0, 16);
        SMath.multiplyMat4xVec4(upPosition, tempMat, upPosModelView);
        Shaders.setProgramUniform3f(uniform_upPosition, upPosition[0], upPosition[1], upPosition[2]);
        if (customUniforms != null) {
            customUniforms.update();
        }
    }

    public static void genCompositeMipmap() {
        if (hasGlGenMipmap) {
            for (int i = 0; i < usedColorBuffers; ++i) {
                if ((activeCompositeMipmapSetting & 1 << i) == 0) continue;
                GlStateManager.setActiveTexture(33984 + colorTextureImageUnit[i]);
                GL11.glTexParameteri(3553, 10241, 9987);
                GL30.glGenerateMipmap(3553);
            }
            GlStateManager.setActiveTexture(33984);
        }
    }

    public static void drawComposite() {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Shaders.drawCompositeQuad();
        int n = activeProgram.getCountInstances();
        if (n > 1) {
            for (int i = 1; i < n; ++i) {
                uniform_instanceId.setValue(i);
                Shaders.drawCompositeQuad();
            }
            uniform_instanceId.setValue(0);
        }
    }

    private static void drawCompositeQuad() {
        if (!Shaders.canRenderQuads()) {
            GL11.glBegin(5);
            GL11.glTexCoord2f(0.0f, 0.0f);
            GL11.glVertex3f(0.0f, 0.0f, 0.0f);
            GL11.glTexCoord2f(1.0f, 0.0f);
            GL11.glVertex3f(1.0f, 0.0f, 0.0f);
            GL11.glTexCoord2f(0.0f, 1.0f);
            GL11.glVertex3f(0.0f, 1.0f, 0.0f);
            GL11.glTexCoord2f(1.0f, 1.0f);
            GL11.glVertex3f(1.0f, 1.0f, 0.0f);
            oc170ea29aae.\u0177();
        } else {
            GL11.glBegin(7);
            GL11.glTexCoord2f(0.0f, 0.0f);
            GL11.glVertex3f(0.0f, 0.0f, 0.0f);
            GL11.glTexCoord2f(1.0f, 0.0f);
            GL11.glVertex3f(1.0f, 0.0f, 0.0f);
            GL11.glTexCoord2f(1.0f, 1.0f);
            GL11.glVertex3f(1.0f, 1.0f, 0.0f);
            GL11.glTexCoord2f(0.0f, 1.0f);
            GL11.glVertex3f(0.0f, 1.0f, 0.0f);
            oc170ea29aae.\u0177();
        }
    }

    public static void renderDeferred() {
        if (!isShadowPass) {
            boolean bl = Shaders.checkBufferFlip(ProgramDeferredPre);
            if (hasDeferredPrograms) {
                Shaders.checkGLError("pre-render Deferred");
                Shaders.renderComposites(ProgramsDeferred, false);
                bl = true;
            }
            if (bl) {
                Shaders.bindGbuffersTextures();
                for (int i = 0; i < usedColorBuffers; ++i) {
                    EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + i, 3553, dfbColorTexturesFlip.getA(i), 0);
                }
                if (ProgramWater.getDrawBuffers() != null) {
                    Shaders.setDrawBuffers(ProgramWater.getDrawBuffers());
                } else {
                    Shaders.setDrawBuffers(dfbDrawBuffers);
                }
                GlStateManager.setActiveTexture(33984);
                mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            }
        }
    }

    public static void renderCompositeFinal() {
        if (!isShadowPass) {
            Shaders.checkBufferFlip(ProgramCompositePre);
            Shaders.checkGLError("pre-render CompositeFinal");
            Shaders.renderComposites(ProgramsComposite, true);
        }
    }

    private static boolean checkBufferFlip(Program program) {
        boolean bl = false;
        Boolean[] booleanArray = program.getBuffersFlip();
        for (int i = 0; i < usedColorBuffers; ++i) {
            if (!Config.isTrue(booleanArray[i])) continue;
            dfbColorTexturesFlip.flip(i);
            bl = true;
        }
        return bl;
    }

    private static void renderComposites(Program[] programArray, boolean bl) {
        if (!isShadowPass) {
            int n;
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5889);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, 1.0, 0.0, 1.0, 0.0, 1.0);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableTexture2D();
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.enableDepth();
            GlStateManager.depthFunc(519);
            GlStateManager.depthMask(false);
            GlStateManager.disableLighting();
            if (usedShadowDepthBuffers >= 1) {
                GlStateManager.setActiveTexture(33988);
                GlStateManager.bindTexture(sfbDepthTextures.get(0));
                if (usedShadowDepthBuffers >= 2) {
                    GlStateManager.setActiveTexture(33989);
                    GlStateManager.bindTexture(sfbDepthTextures.get(1));
                }
            }
            for (n = 0; n < usedColorBuffers; ++n) {
                GlStateManager.setActiveTexture(33984 + colorTextureImageUnit[n]);
                GlStateManager.bindTexture(dfbColorTexturesFlip.getA(n));
            }
            GlStateManager.setActiveTexture(33990);
            GlStateManager.bindTexture(dfbDepthTextures.get(0));
            if (usedDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33995);
                GlStateManager.bindTexture(dfbDepthTextures.get(1));
                if (usedDepthBuffers >= 3) {
                    GlStateManager.setActiveTexture(33996);
                    GlStateManager.bindTexture(dfbDepthTextures.get(2));
                }
            }
            for (n = 0; n < usedShadowColorBuffers; ++n) {
                GlStateManager.setActiveTexture(33997 + n);
                GlStateManager.bindTexture(sfbColorTextures.get(n));
            }
            if (noiseTextureEnabled) {
                GlStateManager.setActiveTexture(33984 + noiseTexture.getTextureUnit());
                GlStateManager.bindTexture(noiseTexture.getTextureId());
            }
            if (bl) {
                Shaders.bindCustomTextures(customTexturesComposite);
            } else {
                Shaders.bindCustomTextures(customTexturesDeferred);
            }
            GlStateManager.setActiveTexture(33984);
            for (n = 0; n < usedColorBuffers; ++n) {
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + n, 3553, dfbColorTexturesFlip.getB(n), 0);
            }
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, dfbDepthTextures.get(0), 0);
            GL20.glDrawBuffers(dfbDrawBuffers);
            Shaders.checkGLError("pre-composite");
            for (n = 0; n < programArray.length; ++n) {
                Program program = programArray[n];
                if (program.getId() == 0) continue;
                Shaders.useProgram(program);
                Shaders.checkGLError(program.getName());
                if (activeCompositeMipmapSetting != 0) {
                    Shaders.genCompositeMipmap();
                }
                Shaders.preDrawComposite();
                Shaders.drawComposite();
                Shaders.postDrawComposite();
                for (int i = 0; i < usedColorBuffers; ++i) {
                    if (!program.getToggleColorTextures()[i]) continue;
                    dfbColorTexturesFlip.flip(i);
                    GlStateManager.setActiveTexture(33984 + colorTextureImageUnit[i]);
                    GlStateManager.bindTexture(dfbColorTexturesFlip.getA(i));
                    EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + i, 3553, dfbColorTexturesFlip.getB(i), 0);
                }
                GlStateManager.setActiveTexture(33984);
            }
            Shaders.checkGLError("composite");
            if (bl) {
                Shaders.renderFinal();
                isCompositeRendered = true;
            }
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glPopMatrix();
            Shaders.useProgram(ProgramNone);
        }
    }

    private static void preDrawComposite() {
        RenderScale renderScale = activeProgram.getRenderScale();
        if (renderScale != null) {
            int n = (int)((float)renderWidth * renderScale.getOffsetX());
            int n2 = (int)((float)renderHeight * renderScale.getOffsetY());
            int n3 = (int)((float)renderWidth * renderScale.getScale());
            int n4 = (int)((float)renderHeight * renderScale.getScale());
            GL11.glViewport(n, n2, n3, n4);
        }
    }

    private static void postDrawComposite() {
        RenderScale renderScale = activeProgram.getRenderScale();
        if (renderScale != null) {
            GL11.glViewport(0, 0, renderWidth, renderHeight);
        }
    }

    private static void renderFinal() {
        isRenderingDfb = false;
        mc.getFramebuffer().bindFramebuffer(true);
        OpenGlHelper.glFramebufferTexture2D(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_COLOR_ATTACHMENT0, 3553, Shaders.mc.getFramebuffer().framebufferTexture, 0);
        GL11.glViewport(0, 0, Shaders.mc.displayWidth, Shaders.mc.displayHeight);
        if (EntityRenderer.anaglyphEnable) {
            boolean bl = EntityRenderer.anaglyphField != 0;
            GlStateManager.colorMask(bl, !bl, !bl, true);
        }
        GlStateManager.depthMask(true);
        GL11.glClearColor(clearColorR, clearColorG, clearColorB, 1.0f);
        GL11.glClear(16640);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(519);
        GlStateManager.depthMask(false);
        Shaders.checkGLError("pre-final");
        Shaders.useProgram(ProgramFinal);
        Shaders.checkGLError("final");
        if (activeCompositeMipmapSetting != 0) {
            Shaders.genCompositeMipmap();
        }
        Shaders.drawComposite();
        Shaders.checkGLError("renderCompositeFinal");
    }

    public static void endRender() {
        if (isShadowPass) {
            Shaders.checkGLError("shadow endRender");
        } else {
            if (!isCompositeRendered) {
                Shaders.renderCompositeFinal();
            }
            isRenderingWorld = false;
            GlStateManager.colorMask(true, true, true, true);
            Shaders.useProgram(ProgramNone);
            RenderHelper.disableStandardItemLighting();
            Shaders.checkGLError("endRender end");
        }
    }

    public static void beginSky() {
        isRenderingSky = true;
        fogEnabled = true;
        Shaders.setDrawBuffers(dfbDrawBuffers);
        Shaders.useProgram(ProgramSkyTextured);
        Shaders.pushEntity(-2, 0);
    }

    public static void setSkyColor(Vec3 vec3) {
        skyColorR = (float)vec3.xCoord;
        skyColorG = (float)vec3.yCoord;
        skyColorB = (float)vec3.zCoord;
        Shaders.setProgramUniform3f(uniform_skyColor, skyColorR, skyColorG, skyColorB);
    }

    public static void drawHorizon() {
        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        float f = Shaders.mc.gameSettings.renderDistanceChunks * 16;
        double d = (double)f * 0.9238;
        double d2 = (double)f * 0.3826;
        double d3 = -d2;
        double d4 = -d;
        double d5 = 16.0;
        double d6 = -cameraPositionY;
        worldRenderer.begin(7, DefaultVertexFormats.POSITION);
        worldRenderer.pos(d3, d6, d4).endVertex();
        worldRenderer.pos(d3, d5, d4).endVertex();
        worldRenderer.pos(d4, d5, d3).endVertex();
        worldRenderer.pos(d4, d6, d3).endVertex();
        worldRenderer.pos(d4, d6, d3).endVertex();
        worldRenderer.pos(d4, d5, d3).endVertex();
        worldRenderer.pos(d4, d5, d2).endVertex();
        worldRenderer.pos(d4, d6, d2).endVertex();
        worldRenderer.pos(d4, d6, d2).endVertex();
        worldRenderer.pos(d4, d5, d2).endVertex();
        worldRenderer.pos(d3, d5, d).endVertex();
        worldRenderer.pos(d3, d6, d).endVertex();
        worldRenderer.pos(d3, d6, d).endVertex();
        worldRenderer.pos(d3, d5, d).endVertex();
        worldRenderer.pos(d2, d5, d).endVertex();
        worldRenderer.pos(d2, d6, d).endVertex();
        worldRenderer.pos(d2, d6, d).endVertex();
        worldRenderer.pos(d2, d5, d).endVertex();
        worldRenderer.pos(d, d5, d2).endVertex();
        worldRenderer.pos(d, d6, d2).endVertex();
        worldRenderer.pos(d, d6, d2).endVertex();
        worldRenderer.pos(d, d5, d2).endVertex();
        worldRenderer.pos(d, d5, d3).endVertex();
        worldRenderer.pos(d, d6, d3).endVertex();
        worldRenderer.pos(d, d6, d3).endVertex();
        worldRenderer.pos(d, d5, d3).endVertex();
        worldRenderer.pos(d2, d5, d4).endVertex();
        worldRenderer.pos(d2, d6, d4).endVertex();
        worldRenderer.pos(d2, d6, d4).endVertex();
        worldRenderer.pos(d2, d5, d4).endVertex();
        worldRenderer.pos(d3, d5, d4).endVertex();
        worldRenderer.pos(d3, d6, d4).endVertex();
        worldRenderer.pos(d4, d6, d4).endVertex();
        worldRenderer.pos(d4, d6, d).endVertex();
        worldRenderer.pos(d, d6, d).endVertex();
        worldRenderer.pos(d, d6, d4).endVertex();
        Tessellator.getInstance().draw();
    }

    public static void preSkyList() {
        Shaders.setUpPosition();
        GL11.glColor3f(fogColorR, fogColorG, fogColorB);
        Shaders.drawHorizon();
        GL11.glColor3f(skyColorR, skyColorG, skyColorB);
    }

    public static void endSky() {
        isRenderingSky = false;
        Shaders.setDrawBuffers(dfbDrawBuffers);
        Shaders.useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
        Shaders.popEntity();
    }

    public static void beginUpdateChunks() {
        Shaders.checkGLError("beginUpdateChunks1");
        Shaders.checkFramebufferStatus("beginUpdateChunks1");
        if (!isShadowPass) {
            Shaders.useProgram(ProgramTerrain);
        }
        Shaders.checkGLError("beginUpdateChunks2");
        Shaders.checkFramebufferStatus("beginUpdateChunks2");
    }

    public static void endUpdateChunks() {
        Shaders.checkGLError("endUpdateChunks1");
        Shaders.checkFramebufferStatus("endUpdateChunks1");
        if (!isShadowPass) {
            Shaders.useProgram(ProgramTerrain);
        }
        Shaders.checkGLError("endUpdateChunks2");
        Shaders.checkFramebufferStatus("endUpdateChunks2");
    }

    public static boolean shouldRenderClouds(GameSettings gameSettings) {
        if (!shaderPackLoaded) {
            return true;
        }
        Shaders.checkGLError("shouldRenderClouds");
        return isShadowPass ? configCloudShadow : gameSettings.clouds > 0;
    }

    public static void beginClouds() {
        fogEnabled = true;
        Shaders.pushEntity(-3, 0);
        Shaders.useProgram(ProgramClouds);
    }

    public static void endClouds() {
        Shaders.disableFog();
        Shaders.popEntity();
        Shaders.useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
    }

    public static void beginEntities() {
        if (isRenderingWorld) {
            Shaders.useProgram(ProgramEntities);
        }
    }

    public static void nextEntity(Entity entity) {
        if (isRenderingWorld) {
            Shaders.useProgram(ProgramEntities);
            Shaders.setEntityId(entity);
        }
    }

    public static void setEntityId(Entity entity) {
        if (uniform_entityId.isDefined()) {
            int n = EntityUtils.getEntityIdByClass(entity);
            int n2 = EntityAliases.getEntityAliasId(n);
            if (n2 >= 0) {
                n = n2;
            }
            uniform_entityId.setValue(n);
        }
    }

    public static void beginSpiderEyes() {
        if (isRenderingWorld && ProgramSpiderEyes.getId() != ProgramNone.getId()) {
            Shaders.useProgram(ProgramSpiderEyes);
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, 0.0f);
            GlStateManager.blendFunc(770, 771);
        }
    }

    public static void endSpiderEyes() {
        if (isRenderingWorld && ProgramSpiderEyes.getId() != ProgramNone.getId()) {
            Shaders.useProgram(ProgramEntities);
            GlStateManager.disableAlpha();
        }
    }

    public static void endEntities() {
        if (isRenderingWorld) {
            Shaders.setEntityId(null);
            Shaders.useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
        }
    }

    public static void beginEntitiesGlowing() {
        if (isRenderingWorld) {
            isEntitiesGlowing = true;
        }
    }

    public static void endEntitiesGlowing() {
        if (isRenderingWorld) {
            isEntitiesGlowing = false;
        }
    }

    public static void setEntityColor(float f, float f2, float f3, float f4) {
        if (isRenderingWorld && !isShadowPass) {
            uniform_entityColor.setValue(f, f2, f3, f4);
        }
    }

    public static void beginLivingDamage() {
        if (isRenderingWorld) {
            ShadersTex.bindTexture(defaultTexture);
            if (!isShadowPass) {
                Shaders.setDrawBuffers(drawBuffersColorAtt0);
            }
        }
    }

    public static void endLivingDamage() {
        if (isRenderingWorld && !isShadowPass) {
            Shaders.setDrawBuffers(ProgramEntities.getDrawBuffers());
        }
    }

    public static void beginBlockEntities() {
        if (isRenderingWorld) {
            Shaders.checkGLError("beginBlockEntities");
            Shaders.useProgram(ProgramBlock);
        }
    }

    public static void nextBlockEntity(TileEntity tileEntity) {
        if (isRenderingWorld) {
            Shaders.checkGLError("nextBlockEntity");
            Shaders.useProgram(ProgramBlock);
            Shaders.setBlockEntityId(tileEntity);
        }
    }

    public static void setBlockEntityId(TileEntity tileEntity) {
        if (uniform_blockEntityId.isDefined()) {
            int n = Shaders.getBlockEntityId(tileEntity);
            uniform_blockEntityId.setValue(n);
        }
    }

    private static int getBlockEntityId(TileEntity tileEntity) {
        int n;
        if (tileEntity == null) {
            return -1;
        }
        Block block = tileEntity.getBlockType();
        if (block == null) {
            return 0;
        }
        int n2 = Block.getIdFromBlock(block);
        int n3 = BlockAliases.getBlockAliasId(n2, n = tileEntity.getBlockMetadata());
        if (n3 >= 0) {
            n2 = n3;
        }
        return n2;
    }

    public static void endBlockEntities() {
        if (isRenderingWorld) {
            Shaders.checkGLError("endBlockEntities");
            Shaders.setBlockEntityId(null);
            Shaders.useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
            ShadersTex.bindNSTextures(defaultTexture.getMultiTexID());
        }
    }

    public static void beginLitParticles() {
        Shaders.useProgram(ProgramTexturedLit);
    }

    public static void beginParticles() {
        Shaders.useProgram(ProgramTextured);
    }

    public static void endParticles() {
        Shaders.useProgram(ProgramTexturedLit);
    }

    public static void readCenterDepth() {
        if (!isShadowPass && centerDepthSmoothEnabled) {
            tempDirectFloatBuffer.clear();
            GL11.glReadPixels(renderWidth / 2, renderHeight / 2, 1, 1, 6402, 5126, tempDirectFloatBuffer);
            centerDepth = tempDirectFloatBuffer.get(0);
            float f = (float)diffSystemTime * 0.01f;
            float f2 = (float)Math.exp(Math.log(0.5) * (double)f / (double)centerDepthSmoothHalflife);
            centerDepthSmooth = centerDepthSmooth * f2 + centerDepth * (1.0f - f2);
        }
    }

    public static void beginWeather() {
        if (!isShadowPass) {
            if (usedDepthBuffers >= 3) {
                GlStateManager.setActiveTexture(33996);
                GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, renderWidth, renderHeight);
                GlStateManager.setActiveTexture(33984);
            }
            GlStateManager.enableDepth();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.enableAlpha();
            Shaders.useProgram(ProgramWeather);
        }
    }

    public static void endWeather() {
        GlStateManager.disableBlend();
        Shaders.useProgram(ProgramTexturedLit);
    }

    public static void preWater() {
        if (usedDepthBuffers >= 2) {
            GlStateManager.setActiveTexture(33995);
            Shaders.checkGLError("pre copy depth");
            GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, renderWidth, renderHeight);
            Shaders.checkGLError("copy depth");
            GlStateManager.setActiveTexture(33984);
        }
        ShadersTex.bindNSTextures(defaultTexture.getMultiTexID());
    }

    public static void beginWater() {
        if (isRenderingWorld) {
            if (!isShadowPass) {
                Shaders.renderDeferred();
                Shaders.useProgram(ProgramWater);
                GlStateManager.enableBlend();
                GlStateManager.depthMask(true);
            } else {
                GlStateManager.depthMask(true);
            }
        }
    }

    public static void endWater() {
        if (isRenderingWorld) {
            if (isShadowPass) {
                // empty if block
            }
            Shaders.useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
        }
    }

    public static void applyHandDepth() {
        if ((double)configHandDepthMul != 1.0) {
            GL11.glScaled(1.0, 1.0, configHandDepthMul);
        }
    }

    public static void beginHand(boolean bl) {
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5888);
        if (bl) {
            Shaders.useProgram(ProgramHandWater);
        } else {
            Shaders.useProgram(ProgramHand);
        }
        Shaders.checkGLError("beginHand");
        Shaders.checkFramebufferStatus("beginHand");
    }

    public static void endHand() {
        Shaders.checkGLError("pre endHand");
        Shaders.checkFramebufferStatus("pre endHand");
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        GlStateManager.blendFunc(770, 771);
        Shaders.checkGLError("endHand");
    }

    public static void beginFPOverlay() {
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
    }

    public static void endFPOverlay() {
    }

    public static void glEnableWrapper(int n) {
        GL11.glEnable(n);
        if (n == 3553) {
            Shaders.enableTexture2D();
        } else if (n == 2912) {
            Shaders.enableFog();
        }
    }

    public static void glDisableWrapper(int n) {
        GL11.glDisable(n);
        if (n == 3553) {
            Shaders.disableTexture2D();
        } else if (n == 2912) {
            Shaders.disableFog();
        }
    }

    public static void sglEnableT2D(int n) {
        GL11.glEnable(n);
        Shaders.enableTexture2D();
    }

    public static void sglDisableT2D(int n) {
        GL11.glDisable(n);
        Shaders.disableTexture2D();
    }

    public static void sglEnableFog(int n) {
        GL11.glEnable(n);
        Shaders.enableFog();
    }

    public static void sglDisableFog(int n) {
        GL11.glDisable(n);
        Shaders.disableFog();
    }

    public static void enableTexture2D() {
        if (isRenderingSky) {
            Shaders.useProgram(ProgramSkyTextured);
        } else if (activeProgram == ProgramBasic) {
            Shaders.useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
        }
    }

    public static void disableTexture2D() {
        if (isRenderingSky) {
            Shaders.useProgram(ProgramSkyBasic);
        } else if (activeProgram == ProgramTextured || activeProgram == ProgramTexturedLit) {
            Shaders.useProgram(ProgramBasic);
        }
    }

    public static void pushProgram() {
        programStack.push(activeProgram);
    }

    public static void popProgram() {
        Program program = programStack.pop();
        Shaders.useProgram(program);
    }

    public static void beginLeash() {
        Shaders.pushProgram();
        Shaders.useProgram(ProgramBasic);
    }

    public static void endLeash() {
        Shaders.popProgram();
    }

    public static void enableFog() {
        fogEnabled = true;
        Shaders.setProgramUniform1i(uniform_fogMode, fogMode);
        Shaders.setProgramUniform1f(uniform_fogDensity, fogDensity);
    }

    public static void disableFog() {
        fogEnabled = false;
        Shaders.setProgramUniform1i(uniform_fogMode, 0);
    }

    public static void setFogDensity(float f) {
        fogDensity = f;
        if (fogEnabled) {
            Shaders.setProgramUniform1f(uniform_fogDensity, f);
        }
    }

    public static void sglFogi(int n, int n2) {
        GL11.glFogi(n, n2);
        if (n == 2917) {
            fogMode = n2;
            if (fogEnabled) {
                Shaders.setProgramUniform1i(uniform_fogMode, fogMode);
            }
        }
    }

    public static void enableLightmap() {
        lightmapEnabled = true;
        if (activeProgram == ProgramTextured) {
            Shaders.useProgram(ProgramTexturedLit);
        }
    }

    public static void disableLightmap() {
        lightmapEnabled = false;
        if (activeProgram == ProgramTexturedLit) {
            Shaders.useProgram(ProgramTextured);
        }
    }

    public static int getEntityData() {
        return entityData[entityDataIndex * 2];
    }

    public static int getEntityData2() {
        return entityData[entityDataIndex * 2 + 1];
    }

    public static int setEntityData1(int n) {
        Shaders.entityData[Shaders.entityDataIndex * 2] = entityData[entityDataIndex * 2] & 0xFFFF | n << 16;
        return n;
    }

    public static int setEntityData2(int n) {
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = entityData[entityDataIndex * 2 + 1] & 0xFFFF0000 | n & 0xFFFF;
        return n;
    }

    public static void pushEntity(int n, int n2) {
        Shaders.entityData[++Shaders.entityDataIndex * 2] = n & 0xFFFF | n2 << 16;
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }

    public static void pushEntity(int n) {
        Shaders.entityData[++Shaders.entityDataIndex * 2] = n & 0xFFFF;
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }

    public static void pushEntity(Block block) {
        int n = block.getRenderType();
        Shaders.entityData[++Shaders.entityDataIndex * 2] = Block.blockRegistry.getIDForObject(block) & 0xFFFF | n << 16;
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }

    public static void popEntity() {
        Shaders.entityData[Shaders.entityDataIndex * 2] = 0;
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
        --entityDataIndex;
    }

    public static void mcProfilerEndSection() {
        Shaders.mc.mcProfiler.endSection();
    }

    public static String getShaderPackName() {
        return shaderPack == null ? null : (shaderPack instanceof ShaderPackNone ? null : shaderPack.getName());
    }

    public static InputStream getShaderPackResourceStream(String string) {
        return shaderPack == null ? null : shaderPack.getResourceAsStream(string);
    }

    public static void nextAntialiasingLevel(boolean bl) {
        if (bl) {
            if ((configAntialiasingLevel += 2) > 4) {
                configAntialiasingLevel = 0;
            }
        } else if ((configAntialiasingLevel -= 2) < 0) {
            configAntialiasingLevel = 4;
        }
        configAntialiasingLevel = configAntialiasingLevel / 2 * 2;
        configAntialiasingLevel = Config.limit(configAntialiasingLevel, 0, 4);
    }

    public static void checkShadersModInstalled() {
        try {
            Class<?> clazz = Class.forName("shadersmod.transform.SMCClassTransformer");
        }
        catch (Throwable throwable) {
            return;
        }
        throw new RuntimeException("Shaders Mod detected. Please remove it, OptiFine has built-in support for shaders.");
    }

    public static void resourcesReloaded() {
        Shaders.loadShaderPackResources();
        if (shaderPackLoaded) {
            BlockAliases.resourcesReloaded();
            ItemAliases.resourcesReloaded();
            EntityAliases.resourcesReloaded();
        }
    }

    private static void loadShaderPackResources() {
        shaderPackResources = new HashMap<String, String>();
        if (shaderPackLoaded) {
            ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
            String string = "/shaders/lang/";
            String string2 = "en_US";
            String string3 = ".lang";
            arrayList.add((CallSite)((Object)(string + string2 + string3)));
            if (!Config.getGameSettings().language.equals(string2)) {
                arrayList.add((CallSite)((Object)(string + Config.getGameSettings().language + string3)));
            }
            try {
                for (String string4 : arrayList) {
                    InputStream inputStream2 = shaderPack.getResourceAsStream(string4);
                    if (inputStream2 == null) continue;
                    PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                    Lang.loadLocaleData(inputStream2, propertiesOrdered);
                    inputStream2.close();
                    for (Object object : ((Properties)propertiesOrdered).keySet()) {
                        String string5 = (String)object;
                        String string6 = propertiesOrdered.getProperty(string5);
                        shaderPackResources.put(string5, string6);
                    }
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static String translate(String string, String string2) {
        String string3 = shaderPackResources.get(string);
        return string3 == null ? string2 : string3;
    }

    public static boolean isProgramPath(String string) {
        Program program;
        if (string == null) {
            return false;
        }
        if (string.length() <= 0) {
            return false;
        }
        int n = string.lastIndexOf("/");
        if (n >= 0) {
            string = string.substring(n + 1);
        }
        return (program = Shaders.getProgram(string)) != null;
    }

    public static Program getProgram(String string) {
        return programs.getProgram(string);
    }

    public static void setItemToRenderMain(ItemStack itemStack) {
        itemToRenderMainTranslucent = Shaders.isTranslucentBlock(itemStack);
    }

    public static void setItemToRenderOff(ItemStack itemStack) {
        itemToRenderOffTranslucent = Shaders.isTranslucentBlock(itemStack);
    }

    public static boolean isItemToRenderMainTranslucent() {
        return itemToRenderMainTranslucent;
    }

    public static boolean isItemToRenderOffTranslucent() {
        return itemToRenderOffTranslucent;
    }

    public static boolean isBothHandsRendered() {
        return isHandRenderedMain && isHandRenderedOff;
    }

    private static boolean isTranslucentBlock(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        Item item = itemStack.getItem();
        if (item == null) {
            return false;
        }
        if (!(item instanceof ItemBlock)) {
            return false;
        }
        ItemBlock itemBlock = (ItemBlock)item;
        Block block = itemBlock.getBlock();
        if (block == null) {
            return false;
        }
        EnumWorldBlockLayer enumWorldBlockLayer = block.getBlockLayer();
        return enumWorldBlockLayer == EnumWorldBlockLayer.TRANSLUCENT;
    }

    public static boolean isSkipRenderHand() {
        return skipRenderHandMain;
    }

    public static boolean isRenderBothHands() {
        return !skipRenderHandMain && !skipRenderHandOff;
    }

    public static void setSkipRenderHands(boolean bl, boolean bl2) {
        skipRenderHandMain = bl;
        skipRenderHandOff = bl2;
    }

    public static void setHandsRendered(boolean bl, boolean bl2) {
        isHandRenderedMain = bl;
        isHandRenderedOff = bl2;
    }

    public static boolean isHandRenderedMain() {
        return isHandRenderedMain;
    }

    public static boolean isHandRenderedOff() {
        return isHandRenderedOff;
    }

    public static float getShadowRenderDistance() {
        return shadowDistanceRenderMul < 0.0f ? -1.0f : shadowMapHalfPlane * shadowDistanceRenderMul;
    }

    public static void setRenderingFirstPersonHand(boolean bl) {
        isRenderingFirstPersonHand = bl;
    }

    public static boolean isRenderingFirstPersonHand() {
        return isRenderingFirstPersonHand;
    }

    public static void beginBeacon() {
        if (isRenderingWorld) {
            Shaders.useProgram(ProgramBeaconBeam);
        }
    }

    public static void endBeacon() {
        if (isRenderingWorld) {
            Shaders.useProgram(ProgramBlock);
        }
    }

    public static World getCurrentWorld() {
        return currentWorld;
    }

    public static BlockPos getCameraPosition() {
        return new BlockPos(cameraPositionX, cameraPositionY, cameraPositionZ);
    }

    public static boolean isCustomUniforms() {
        return customUniforms != null;
    }

    public static boolean canRenderQuads() {
        return hasGeometryShaders ? Shaders.capabilities.GL_NV_geometry_shader4 : true;
    }

    static {
        isInitializedOnce = false;
        isShaderPackInitialized = false;
        hasGlGenMipmap = false;
        countResetDisplayLists = 0;
        renderDisplayWidth = 0;
        renderDisplayHeight = 0;
        renderWidth = 0;
        renderHeight = 0;
        isRenderingWorld = false;
        isRenderingSky = false;
        isCompositeRendered = false;
        isRenderingDfb = false;
        isShadowPass = false;
        isEntitiesGlowing = false;
        renderItemKeepDepthMask = false;
        itemToRenderMainTranslucent = false;
        itemToRenderOffTranslucent = false;
        sunPosition = new float[4];
        moonPosition = new float[4];
        shadowLightPosition = new float[4];
        upPosition = new float[4];
        shadowLightPositionVector = new float[4];
        upPosModelView = new float[]{0.0f, 100.0f, 0.0f, 0.0f};
        sunPosModelView = new float[]{0.0f, 100.0f, 0.0f, 0.0f};
        moonPosModelView = new float[]{0.0f, -100.0f, 0.0f, 0.0f};
        tempMat = new float[16];
        worldTime = 0L;
        lastWorldTime = 0L;
        diffWorldTime = 0L;
        celestialAngle = 0.0f;
        sunAngle = 0.0f;
        shadowAngle = 0.0f;
        moonPhase = 0;
        systemTime = 0L;
        lastSystemTime = 0L;
        diffSystemTime = 0L;
        frameCounter = 0;
        frameTime = 0.0f;
        frameTimeCounter = 0.0f;
        systemTimeInt32 = 0;
        rainStrength = 0.0f;
        wetness = 0.0f;
        wetnessHalfLife = 600.0f;
        drynessHalfLife = 200.0f;
        eyeBrightnessHalflife = 10.0f;
        usewetness = false;
        isEyeInWater = 0;
        eyeBrightness = 0;
        eyeBrightnessFadeX = 0.0f;
        eyeBrightnessFadeY = 0.0f;
        eyePosY = 0.0f;
        centerDepth = 0.0f;
        centerDepthSmooth = 0.0f;
        centerDepthSmoothHalflife = 1.0f;
        centerDepthSmoothEnabled = false;
        superSamplingLevel = 1;
        nightVision = 0.0f;
        blindness = 0.0f;
        lightmapEnabled = false;
        fogEnabled = true;
        entityAttrib = 10;
        midTexCoordAttrib = 11;
        tangentAttrib = 12;
        useEntityAttrib = false;
        useMidTexCoordAttrib = false;
        useTangentAttrib = false;
        progUseEntityAttrib = false;
        progUseMidTexCoordAttrib = false;
        progUseTangentAttrib = false;
        progArbGeometryShader4 = false;
        progMaxVerticesOut = 3;
        hasGeometryShaders = false;
        atlasSizeX = 0;
        atlasSizeY = 0;
        shaderUniforms = new ShaderUniforms();
        uniform_entityColor = shaderUniforms.make4f("entityColor");
        uniform_entityId = shaderUniforms.make1i("entityId");
        uniform_blockEntityId = shaderUniforms.make1i("blockEntityId");
        uniform_texture = shaderUniforms.make1i("texture");
        uniform_lightmap = shaderUniforms.make1i("lightmap");
        uniform_normals = shaderUniforms.make1i("normals");
        uniform_specular = shaderUniforms.make1i("specular");
        uniform_shadow = shaderUniforms.make1i("shadow");
        uniform_watershadow = shaderUniforms.make1i("watershadow");
        uniform_shadowtex0 = shaderUniforms.make1i("shadowtex0");
        uniform_shadowtex1 = shaderUniforms.make1i("shadowtex1");
        uniform_depthtex0 = shaderUniforms.make1i("depthtex0");
        uniform_depthtex1 = shaderUniforms.make1i("depthtex1");
        uniform_shadowcolor = shaderUniforms.make1i("shadowcolor");
        uniform_shadowcolor0 = shaderUniforms.make1i("shadowcolor0");
        uniform_shadowcolor1 = shaderUniforms.make1i("shadowcolor1");
        uniform_noisetex = shaderUniforms.make1i("noisetex");
        uniform_gcolor = shaderUniforms.make1i("gcolor");
        uniform_gdepth = shaderUniforms.make1i("gdepth");
        uniform_gnormal = shaderUniforms.make1i("gnormal");
        uniform_composite = shaderUniforms.make1i("composite");
        uniform_gaux1 = shaderUniforms.make1i("gaux1");
        uniform_gaux2 = shaderUniforms.make1i("gaux2");
        uniform_gaux3 = shaderUniforms.make1i("gaux3");
        uniform_gaux4 = shaderUniforms.make1i("gaux4");
        uniform_colortex0 = shaderUniforms.make1i("colortex0");
        uniform_colortex1 = shaderUniforms.make1i("colortex1");
        uniform_colortex2 = shaderUniforms.make1i("colortex2");
        uniform_colortex3 = shaderUniforms.make1i("colortex3");
        uniform_colortex4 = shaderUniforms.make1i("colortex4");
        uniform_colortex5 = shaderUniforms.make1i("colortex5");
        uniform_colortex6 = shaderUniforms.make1i("colortex6");
        uniform_colortex7 = shaderUniforms.make1i("colortex7");
        uniform_gdepthtex = shaderUniforms.make1i("gdepthtex");
        uniform_depthtex2 = shaderUniforms.make1i("depthtex2");
        uniform_tex = shaderUniforms.make1i("tex");
        uniform_heldItemId = shaderUniforms.make1i("heldItemId");
        uniform_heldBlockLightValue = shaderUniforms.make1i("heldBlockLightValue");
        uniform_heldItemId2 = shaderUniforms.make1i("heldItemId2");
        uniform_heldBlockLightValue2 = shaderUniforms.make1i("heldBlockLightValue2");
        uniform_fogMode = shaderUniforms.make1i("fogMode");
        uniform_fogDensity = shaderUniforms.make1f("fogDensity");
        uniform_fogColor = shaderUniforms.make3f("fogColor");
        uniform_skyColor = shaderUniforms.make3f("skyColor");
        uniform_worldTime = shaderUniforms.make1i("worldTime");
        uniform_worldDay = shaderUniforms.make1i("worldDay");
        uniform_moonPhase = shaderUniforms.make1i("moonPhase");
        uniform_frameCounter = shaderUniforms.make1i("frameCounter");
        uniform_frameTime = shaderUniforms.make1f("frameTime");
        uniform_frameTimeCounter = shaderUniforms.make1f("frameTimeCounter");
        uniform_sunAngle = shaderUniforms.make1f("sunAngle");
        uniform_shadowAngle = shaderUniforms.make1f("shadowAngle");
        uniform_rainStrength = shaderUniforms.make1f("rainStrength");
        uniform_aspectRatio = shaderUniforms.make1f("aspectRatio");
        uniform_viewWidth = shaderUniforms.make1f("viewWidth");
        uniform_viewHeight = shaderUniforms.make1f("viewHeight");
        uniform_near = shaderUniforms.make1f("near");
        uniform_far = shaderUniforms.make1f("far");
        uniform_sunPosition = shaderUniforms.make3f("sunPosition");
        uniform_moonPosition = shaderUniforms.make3f("moonPosition");
        uniform_shadowLightPosition = shaderUniforms.make3f("shadowLightPosition");
        uniform_upPosition = shaderUniforms.make3f("upPosition");
        uniform_previousCameraPosition = shaderUniforms.make3f("previousCameraPosition");
        uniform_cameraPosition = shaderUniforms.make3f("cameraPosition");
        uniform_gbufferModelView = shaderUniforms.makeM4("gbufferModelView");
        uniform_gbufferModelViewInverse = shaderUniforms.makeM4("gbufferModelViewInverse");
        uniform_gbufferPreviousProjection = shaderUniforms.makeM4("gbufferPreviousProjection");
        uniform_gbufferProjection = shaderUniforms.makeM4("gbufferProjection");
        uniform_gbufferProjectionInverse = shaderUniforms.makeM4("gbufferProjectionInverse");
        uniform_gbufferPreviousModelView = shaderUniforms.makeM4("gbufferPreviousModelView");
        uniform_shadowProjection = shaderUniforms.makeM4("shadowProjection");
        uniform_shadowProjectionInverse = shaderUniforms.makeM4("shadowProjectionInverse");
        uniform_shadowModelView = shaderUniforms.makeM4("shadowModelView");
        uniform_shadowModelViewInverse = shaderUniforms.makeM4("shadowModelViewInverse");
        uniform_wetness = shaderUniforms.make1f("wetness");
        uniform_eyeAltitude = shaderUniforms.make1f("eyeAltitude");
        uniform_eyeBrightness = shaderUniforms.make2i("eyeBrightness");
        uniform_eyeBrightnessSmooth = shaderUniforms.make2i("eyeBrightnessSmooth");
        uniform_terrainTextureSize = shaderUniforms.make2i("terrainTextureSize");
        uniform_terrainIconSize = shaderUniforms.make1i("terrainIconSize");
        uniform_isEyeInWater = shaderUniforms.make1i("isEyeInWater");
        uniform_nightVision = shaderUniforms.make1f("nightVision");
        uniform_blindness = shaderUniforms.make1f("blindness");
        uniform_screenBrightness = shaderUniforms.make1f("screenBrightness");
        uniform_hideGUI = shaderUniforms.make1i("hideGUI");
        uniform_centerDepthSmooth = shaderUniforms.make1f("centerDepthSmooth");
        uniform_atlasSize = shaderUniforms.make2i("atlasSize");
        uniform_blendFunc = shaderUniforms.make4i("blendFunc");
        uniform_instanceId = shaderUniforms.make1i("instanceId");
        shadowPassInterval = 0;
        needResizeShadow = false;
        shadowMapWidth = 1024;
        shadowMapHeight = 1024;
        spShadowMapWidth = 1024;
        spShadowMapHeight = 1024;
        shadowMapFOV = 90.0f;
        shadowMapHalfPlane = 160.0f;
        shadowMapIsOrtho = true;
        shadowDistanceRenderMul = -1.0f;
        shadowPassCounter = 0;
        shouldSkipDefaultShadow = false;
        waterShadowEnabled = false;
        usedColorBuffers = 0;
        usedDepthBuffers = 0;
        usedShadowColorBuffers = 0;
        usedShadowDepthBuffers = 0;
        usedColorAttachs = 0;
        usedDrawBuffers = 0;
        dfb = 0;
        sfb = 0;
        gbuffersFormat = new int[8];
        gbuffersClear = new boolean[8];
        gbuffersClearColor = new Vector4f[8];
        programs = new Programs();
        ProgramNone = programs.getProgramNone();
        ProgramShadow = programs.makeShadow("shadow", ProgramNone);
        ProgramShadowSolid = programs.makeShadow("shadow_solid", ProgramShadow);
        ProgramShadowCutout = programs.makeShadow("shadow_cutout", ProgramShadow);
        ProgramBasic = programs.makeGbuffers("gbuffers_basic", ProgramNone);
        ProgramTextured = programs.makeGbuffers("gbuffers_textured", ProgramBasic);
        ProgramTexturedLit = programs.makeGbuffers("gbuffers_textured_lit", ProgramTextured);
        ProgramSkyBasic = programs.makeGbuffers("gbuffers_skybasic", ProgramBasic);
        ProgramSkyTextured = programs.makeGbuffers("gbuffers_skytextured", ProgramTextured);
        ProgramClouds = programs.makeGbuffers("gbuffers_clouds", ProgramTextured);
        ProgramTerrain = programs.makeGbuffers("gbuffers_terrain", ProgramTexturedLit);
        ProgramTerrainSolid = programs.makeGbuffers("gbuffers_terrain_solid", ProgramTerrain);
        ProgramTerrainCutoutMip = programs.makeGbuffers("gbuffers_terrain_cutout_mip", ProgramTerrain);
        ProgramTerrainCutout = programs.makeGbuffers("gbuffers_terrain_cutout", ProgramTerrain);
        ProgramDamagedBlock = programs.makeGbuffers("gbuffers_damagedblock", ProgramTerrain);
        ProgramBlock = programs.makeGbuffers("gbuffers_block", ProgramTerrain);
        ProgramBeaconBeam = programs.makeGbuffers("gbuffers_beaconbeam", ProgramTextured);
        ProgramItem = programs.makeGbuffers("gbuffers_item", ProgramTexturedLit);
        ProgramEntities = programs.makeGbuffers("gbuffers_entities", ProgramTexturedLit);
        ProgramEntitiesGlowing = programs.makeGbuffers("gbuffers_entities_glowing", ProgramEntities);
        ProgramArmorGlint = programs.makeGbuffers("gbuffers_armor_glint", ProgramTextured);
        ProgramSpiderEyes = programs.makeGbuffers("gbuffers_spidereyes", ProgramTextured);
        ProgramHand = programs.makeGbuffers("gbuffers_hand", ProgramTexturedLit);
        ProgramWeather = programs.makeGbuffers("gbuffers_weather", ProgramTexturedLit);
        ProgramDeferredPre = programs.makeVirtual("deferred_pre");
        ProgramsDeferred = programs.makeDeferreds("deferred", 16);
        ProgramDeferred = ProgramsDeferred[0];
        ProgramWater = programs.makeGbuffers("gbuffers_water", ProgramTerrain);
        ProgramHandWater = programs.makeGbuffers("gbuffers_hand_water", ProgramHand);
        ProgramCompositePre = programs.makeVirtual("composite_pre");
        ProgramsComposite = programs.makeComposites("composite", 16);
        ProgramComposite = ProgramsComposite[0];
        ProgramFinal = programs.makeComposite("final");
        ProgramCount = programs.getCount();
        ProgramsAll = programs.getPrograms();
        activeProgram = ProgramNone;
        activeProgramID = 0;
        programStack = new ProgramStack();
        hasDeferredPrograms = false;
        activeDrawBuffers = null;
        activeCompositeMipmapSetting = 0;
        loadedShaders = null;
        shadersConfig = null;
        defaultTexture = null;
        shadowHardwareFilteringEnabled = new boolean[2];
        shadowMipmapEnabled = new boolean[2];
        shadowFilterNearest = new boolean[2];
        shadowColorMipmapEnabled = new boolean[8];
        shadowColorFilterNearest = new boolean[8];
        configTweakBlockDamage = false;
        configCloudShadow = false;
        configHandDepthMul = 0.125f;
        configRenderResMul = 1.0f;
        configShadowResMul = 1.0f;
        configTexMinFilB = 0;
        configTexMinFilN = 0;
        configTexMinFilS = 0;
        configTexMagFilB = 0;
        configTexMagFilN = 0;
        configTexMagFilS = 0;
        configShadowClipFrustrum = true;
        configNormalMap = true;
        configSpecularMap = true;
        configOldLighting = new PropertyDefaultTrueFalse("oldLighting", "Classic Lighting", 0);
        configOldHandLight = new PropertyDefaultTrueFalse("oldHandLight", "Old Hand Light", 0);
        configAntialiasingLevel = 0;
        texMinFilDesc = new String[]{"Nearest", "Nearest-Nearest", "Nearest-Linear"};
        texMagFilDesc = new String[]{"Nearest", "Linear"};
        texMinFilValue = new int[]{9728, 9984, 9986};
        texMagFilValue = new int[]{9728, 9729};
        shaderPack = null;
        shaderPackLoaded = false;
        shaderPackOptions = null;
        shaderPackOptionSliders = null;
        shaderPackProfiles = null;
        shaderPackGuiScreens = null;
        shaderPackProgramConditions = new HashMap<String, IExpressionBool>();
        shaderPackClouds = new PropertyDefaultFastFancyOff("clouds", "Clouds", 0);
        shaderPackOldLighting = new PropertyDefaultTrueFalse("oldLighting", "Classic Lighting", 0);
        shaderPackOldHandLight = new PropertyDefaultTrueFalse("oldHandLight", "Old Hand Light", 0);
        shaderPackDynamicHandLight = new PropertyDefaultTrueFalse("dynamicHandLight", "Dynamic Hand Light", 0);
        shaderPackShadowTranslucent = new PropertyDefaultTrueFalse("shadowTranslucent", "Shadow Translucent", 0);
        shaderPackUnderwaterOverlay = new PropertyDefaultTrueFalse("underwaterOverlay", "Underwater Overlay", 0);
        shaderPackSun = new PropertyDefaultTrueFalse("sun", "Sun", 0);
        shaderPackMoon = new PropertyDefaultTrueFalse("moon", "Moon", 0);
        shaderPackVignette = new PropertyDefaultTrueFalse("vignette", "Vignette", 0);
        shaderPackBackFaceSolid = new PropertyDefaultTrueFalse("backFace.solid", "Back-face Solid", 0);
        shaderPackBackFaceCutout = new PropertyDefaultTrueFalse("backFace.cutout", "Back-face Cutout", 0);
        shaderPackBackFaceCutoutMipped = new PropertyDefaultTrueFalse("backFace.cutoutMipped", "Back-face Cutout Mipped", 0);
        shaderPackBackFaceTranslucent = new PropertyDefaultTrueFalse("backFace.translucent", "Back-face Translucent", 0);
        shaderPackRainDepth = new PropertyDefaultTrueFalse("rain.depth", "Rain Depth", 0);
        shaderPackBeaconBeamDepth = new PropertyDefaultTrueFalse("beacon.beam.depth", "Rain Depth", 0);
        shaderPackSeparateAo = new PropertyDefaultTrueFalse("separateAo", "Separate AO", 0);
        shaderPackFrustumCulling = new PropertyDefaultTrueFalse("frustum.culling", "Frustum Culling", 0);
        shaderPackResources = new HashMap<String, String>();
        currentWorld = null;
        shaderPackDimensions = new ArrayList<Integer>();
        customTexturesGbuffers = null;
        customTexturesComposite = null;
        customTexturesDeferred = null;
        noiseTexturePath = null;
        customUniforms = null;
        STAGE_NAMES = new String[]{"gbuffers", "composite", "deferred"};
        saveFinalShaders = System.getProperty("shaders.debug.save", "false").equals("true");
        blockLightLevel05 = 0.5f;
        blockLightLevel06 = 0.6f;
        blockLightLevel08 = 0.8f;
        aoLevel = -1.0f;
        sunPathRotation = 0.0f;
        shadowAngleInterval = 0.0f;
        fogMode = 0;
        fogDensity = 0.0f;
        shadowIntervalSize = 2.0f;
        terrainIconSize = 16;
        terrainTextureSize = new int[2];
        noiseTextureEnabled = false;
        noiseTextureResolution = 256;
        colorTextureImageUnit = new int[]{0, 1, 2, 3, 7, 8, 9, 10};
        bigBufferSize = (285 + 8 * ProgramCount) * 4;
        bigBuffer = BufferUtils.createByteBuffer(bigBufferSize).limit(0);
        faProjection = new float[16];
        faProjectionInverse = new float[16];
        faModelView = new float[16];
        faModelViewInverse = new float[16];
        faShadowProjection = new float[16];
        faShadowProjectionInverse = new float[16];
        faShadowModelView = new float[16];
        faShadowModelViewInverse = new float[16];
        projection = Shaders.nextFloatBuffer(16);
        projectionInverse = Shaders.nextFloatBuffer(16);
        modelView = Shaders.nextFloatBuffer(16);
        modelViewInverse = Shaders.nextFloatBuffer(16);
        shadowProjection = Shaders.nextFloatBuffer(16);
        shadowProjectionInverse = Shaders.nextFloatBuffer(16);
        shadowModelView = Shaders.nextFloatBuffer(16);
        shadowModelViewInverse = Shaders.nextFloatBuffer(16);
        previousProjection = Shaders.nextFloatBuffer(16);
        previousModelView = Shaders.nextFloatBuffer(16);
        tempMatrixDirectBuffer = Shaders.nextFloatBuffer(16);
        tempDirectFloatBuffer = Shaders.nextFloatBuffer(16);
        dfbColorTextures = Shaders.nextIntBuffer(16);
        dfbDepthTextures = Shaders.nextIntBuffer(3);
        sfbColorTextures = Shaders.nextIntBuffer(8);
        sfbDepthTextures = Shaders.nextIntBuffer(2);
        dfbDrawBuffers = Shaders.nextIntBuffer(8);
        sfbDrawBuffers = Shaders.nextIntBuffer(8);
        drawBuffersNone = Shaders.nextIntBuffer(8).limit(0);
        drawBuffersColorAtt0 = Shaders.nextIntBuffer(8).put(36064).position(0).limit(1);
        dfbColorTexturesFlip = new FlipTextures(dfbColorTextures, 8);
        formatNames = new String[]{"R8", "RG8", "RGB8", "RGBA8", "R8_SNORM", "RG8_SNORM", "RGB8_SNORM", "RGBA8_SNORM", "R16", "RG16", "RGB16", "RGBA16", "R16_SNORM", "RG16_SNORM", "RGB16_SNORM", "RGBA16_SNORM", "R16F", "RG16F", "RGB16F", "RGBA16F", "R32F", "RG32F", "RGB32F", "RGBA32F", "R32I", "RG32I", "RGB32I", "RGBA32I", "R32UI", "RG32UI", "RGB32UI", "RGBA32UI", "R3_G3_B2", "RGB5_A1", "RGB10_A2", "R11F_G11F_B10F", "RGB9_E5"};
        formatIds = new int[]{33321, 33323, 32849, 32856, 36756, 36757, 36758, 36759, 33322, 33324, 32852, 32859, 36760, 36761, 36762, 36763, 33325, 33327, 34843, 34842, 33326, 33328, 34837, 34836, 33333, 33339, 36227, 36226, 33334, 33340, 36209, 36208, 10768, 32855, 32857, 35898, 35901};
        patternLoadEntityDataMap = Pattern.compile("\\s*([\\w:]+)\\s*=\\s*([-]?\\d+)\\s*");
        entityData = new int[32];
        entityDataIndex = 0;
        shaderPacksDir = new File(Minecraft.getMinecraft().mcDataDir, SHADER_PACKS_DIR_NAME);
        configFile = new File(Minecraft.getMinecraft().mcDataDir, OPTIONS_FILE_NAME);
    }
}

