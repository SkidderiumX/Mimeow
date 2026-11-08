/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.IIconCreator;
import net.minecraft.client.renderer.texture.ITickableTextureObject;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.optifine.BetterGrass;
import net.optifine.ConnectedTextures;
import net.optifine.CustomItems;
import net.optifine.EmissiveTextures;
import net.optifine.SmartAnimations;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorCompat;
import net.optifine.shaders.ShadersTex;
import net.optifine.util.CounterInt;
import net.optifine.util.TextureUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL;
import x.oc131b84b22f;

public class TextureMap
extends AbstractTexture
implements ITickableTextureObject {
    private static final boolean ENABLE_SKIP = Boolean.parseBoolean(System.getProperty("optionalLoader.skipFirstTextureLoad", "true"));
    private static final Logger logger = LogManager.getLogger();
    public static final ResourceLocation LOCATION_MISSING_TEXTURE = new ResourceLocation("missingno");
    public static final ResourceLocation locationBlocksTexture = new ResourceLocation("textures/atlas/blocks.png");
    private final List<TextureAtlasSprite> listAnimatedSprites;
    private final Map<String, TextureAtlasSprite> mapRegisteredSprites;
    private final Map<String, TextureAtlasSprite> mapUploadedSprites;
    private final String basePath;
    private final IIconCreator iconCreator;
    private int mipmapLevels;
    private final TextureAtlasSprite missingImage;
    private boolean skipFirst = false;
    private TextureAtlasSprite[] iconGrid = null;
    private int iconGridSize = -1;
    private int iconGridCountX = -1;
    private int iconGridCountY = -1;
    private double iconGridSizeU = -1.0;
    private double iconGridSizeV = -1.0;
    private CounterInt counterIndexInMap = new CounterInt(0);
    public int atlasWidth = 0;
    public int atlasHeight = 0;
    private int countAnimationsActive;
    private int frameCountAnimations;

    public TextureMap(String string) {
        this(string, null);
    }

    public TextureMap(String string, boolean bl) {
        this(string, null, bl);
    }

    public TextureMap(String string, IIconCreator iIconCreator) {
        this(string, iIconCreator, false);
    }

    public TextureMap(String string, IIconCreator iIconCreator, boolean bl) {
        this.listAnimatedSprites = Lists.newArrayList();
        this.mapRegisteredSprites = Maps.newHashMap();
        this.mapUploadedSprites = Maps.newHashMap();
        this.missingImage = new TextureAtlasSprite("missingno");
        this.basePath = string;
        this.iconCreator = iIconCreator;
        this.skipFirst = bl && ENABLE_SKIP;
    }

    private void initMissingImage() {
        int n = this.getMinSpriteSize();
        int[] nArray = this.getMissingImageData(n);
        this.missingImage.setIconWidth(n);
        this.missingImage.setIconHeight(n);
        int[][] nArrayArray = new int[this.mipmapLevels + 1][];
        nArrayArray[0] = nArray;
        this.missingImage.setFramesTextureData(Lists.newArrayList(new int[][][]{nArrayArray}));
        this.missingImage.setIndexInMap(this.counterIndexInMap.nextValue());
    }

    @Override
    public void loadTexture(IResourceManager iResourceManager) throws IOException {
        if (this.iconCreator != null) {
            this.loadSprites(iResourceManager, this.iconCreator);
        }
    }

    public void loadSprites(IResourceManager iResourceManager, IIconCreator iIconCreator) {
        this.mapRegisteredSprites.clear();
        this.counterIndexInMap.reset();
        iIconCreator.registerSprites(this);
        if (this.mipmapLevels >= 4) {
            this.mipmapLevels = this.detectMaxMipmapLevel(this.mapRegisteredSprites, iResourceManager);
            Config.log("Mipmap levels: " + this.mipmapLevels);
        }
        this.initMissingImage();
        this.deleteGlTexture();
        this.loadTextureAtlas(iResourceManager);
    }

    public void loadTextureAtlas(IResourceManager iResourceManager) {
        int n;
        int n2;
        Object object;
        Object object2;
        HashMap<String, TextureAtlasSprite> hashMap;
        int n3;
        Config.dbg("Multitexture: " + Config.isMultiTexture());
        if (Config.isMultiTexture()) {
            for (TextureAtlasSprite object32 : this.mapUploadedSprites.values()) {
                object32.deleteSpriteTexture();
            }
        }
        ConnectedTextures.updateIcons(this);
        CustomItems.updateIcons(this);
        BetterGrass.updateIcons(this);
        int n4 = TextureUtils.getGLMaximumTextureSize();
        Stitcher stitcher = new Stitcher(n4, n4, true, 0, this.mipmapLevels);
        this.mapUploadedSprites.clear();
        this.listAnimatedSprites.clear();
        int n5 = Integer.MAX_VALUE;
        Reflector.callVoid(Reflector.CompatHooksClient_onTextureStitchedPre, this);
        this.iconGridSize = n3 = this.getMinSpriteSize();
        int n6 = 1 << this.mipmapLevels;
        int n7 = 0;
        int n8 = 0;
        for (Map.Entry<String, TextureAtlasSprite> n9 : this.mapRegisteredSprites.entrySet()) {
            if (this.skipFirst) break;
            TextureAtlasSprite n22 = n9.getValue();
            hashMap = new ResourceLocation(n22.getIconName());
            ResourceLocation n17 = this.completeResourceLocation((ResourceLocation)((Object)hashMap), 0);
            n22.updateIndexInMap(this.counterIndexInMap);
            if (n22.hasCustomLoader(iResourceManager, (ResourceLocation)((Object)hashMap))) {
                if (!n22.load(iResourceManager, (ResourceLocation)((Object)hashMap))) {
                    n5 = Math.min(n5, Math.min(n22.getIconWidth(), n22.getIconHeight()));
                    stitcher.addSprite(n22);
                    Config.detail("Custom loader (skipped): " + String.valueOf(n22));
                    ++n8;
                }
                Config.detail("Custom loader: " + String.valueOf(n22));
                ++n7;
                continue;
            }
            try {
                IResource textureAtlasSprite = iResourceManager.getResource(n17);
                object2 = new BufferedImage[1 + this.mipmapLevels];
                object2[0] = TextureUtil.readBufferedImage(textureAtlasSprite.getInputStream());
                int n10 = object2[0].getWidth();
                int n11 = object2[0].getHeight();
                if (n10 < 1 || n11 < 1) {
                    Config.warn("Invalid sprite size: " + String.valueOf(n22));
                    continue;
                }
                if (n10 < n3 || this.mipmapLevels > 0) {
                    int n12;
                    int n13 = n12 = this.mipmapLevels > 0 ? TextureUtils.scaleToGrid(n10, n3) : TextureUtils.scaleToMin(n10, n3);
                    if (n12 != n10) {
                        if (!TextureUtils.isPowerOfTwo(n10)) {
                            Config.log("Scaled non power of 2: " + n22.getIconName() + ", " + n10 + " -> " + n12);
                        } else {
                            Config.log("Scaled too small texture: " + n22.getIconName() + ", " + n10 + " -> " + n12);
                        }
                        int n14 = n11 * n12 / n10;
                        object2[0] = TextureUtils.scaleImage(object2[0], n12);
                    }
                }
                if ((object = (TextureMetadataSection)textureAtlasSprite.getMetadata("texture")) != null) {
                    List<Integer> list = ((TextureMetadataSection)object).getListMipmaps();
                    if (!list.isEmpty()) {
                        int n15 = object2[0].getWidth();
                        int n16 = object2[0].getHeight();
                        if (MathHelper.roundUpToPowerOfTwo(n15) != n15 || MathHelper.roundUpToPowerOfTwo(n16) != n16) {
                            throw new RuntimeException("Unable to load extra miplevels, source-texture is not power of two");
                        }
                    }
                    for (int n16 : list) {
                        if (n16 <= 0 || n16 >= ((BufferedImage[])object2).length - 1 || object2[n16] != null) continue;
                        ResourceLocation resourceLocation = this.completeResourceLocation((ResourceLocation)((Object)hashMap), n16);
                        try {
                            object2[n16] = TextureUtil.readBufferedImage(iResourceManager.getResource(resourceLocation).getInputStream());
                        }
                        catch (IOException iOException) {
                            logger.error("Unable to load miplevel {} from: {}", n16, resourceLocation, iOException);
                        }
                    }
                }
                AnimationMetadataSection animationMetadataSection = (AnimationMetadataSection)textureAtlasSprite.getMetadata("animation");
                n22.loadSprite((BufferedImage[])object2, animationMetadataSection);
            }
            catch (RuntimeException textureAtlasSprite) {
                logger.error("Unable to parse metadata from " + String.valueOf(n17), (Throwable)textureAtlasSprite);
                ReflectorCompat.OptionalLoaderClientHandler_trackBrokenTexture(n17, textureAtlasSprite.getMessage());
                continue;
            }
            catch (IOException n18) {
                logger.error("Using missing texture, unable to load " + String.valueOf(n17) + ", " + n18.getClass().getName());
                ReflectorCompat.OptionalLoaderClientHandler_trackMissingTexture(n17);
                continue;
            }
            n5 = Math.min(n5, Math.min(n22.getIconWidth(), n22.getIconHeight()));
            int n18 = Math.min(Integer.lowestOneBit(n22.getIconWidth()), Integer.lowestOneBit(n22.getIconHeight()));
            if (n18 < n6) {
                logger.warn("Texture {} with size {}x{} limits mip level from {} to {}", n17, n22.getIconWidth(), n22.getIconHeight(), MathHelper.calculateLogBaseTwo(n6), MathHelper.calculateLogBaseTwo(n18));
                n6 = n18;
            }
            stitcher.addSprite(n22);
        }
        if (n7 > 0) {
            Config.dbg("Custom loader sprites: " + n7);
        }
        if (n8 > 0) {
            Config.dbg("Custom loader sprites (skipped): " + n8);
        }
        if ((n2 = MathHelper.calculateLogBaseTwo(n = Math.min(n5, n6))) < 0) {
            n2 = 0;
        }
        if (n2 < this.mipmapLevels) {
            logger.warn("{}: dropping miplevel from {} to {}, because of minimum power of two: {}", this.basePath, this.mipmapLevels, n2, n);
            this.mipmapLevels = n2;
        }
        for (final TextureAtlasSprite textureAtlasSprite : this.mapRegisteredSprites.values()) {
            if (this.skipFirst) break;
            try {
                textureAtlasSprite.generateMipmaps(this.mipmapLevels);
            }
            catch (Throwable throwable) {
                object2 = CrashReport.makeCrashReport(throwable, "Applying mipmap");
                CrashReportCategory crashReportCategory = ((CrashReport)object2).makeCategory("Sprite being mipmapped");
                crashReportCategory.addCrashSectionCallable("Sprite name", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return textureAtlasSprite.getIconName();
                    }
                });
                crashReportCategory.addCrashSectionCallable("Sprite size", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return textureAtlasSprite.getIconWidth() + " x " + textureAtlasSprite.getIconHeight();
                    }
                });
                crashReportCategory.addCrashSectionCallable("Sprite frames", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return textureAtlasSprite.getFrameCount() + " frames";
                    }
                });
                crashReportCategory.addCrashSection("Mipmap levels", this.mipmapLevels);
                throw new ReportedException((CrashReport)object2);
            }
        }
        this.missingImage.generateMipmaps(this.mipmapLevels);
        stitcher.addSprite(this.missingImage);
        this.skipFirst = false;
        stitcher.doStitch();
        logger.info("Created: {}x{} {}-atlas", stitcher.getCurrentWidth(), stitcher.getCurrentHeight(), this.basePath);
        if (Config.isShaders()) {
            ShadersTex.allocateTextureMap(this.getGlTextureId(), this.mipmapLevels, stitcher.getCurrentWidth(), stitcher.getCurrentHeight(), stitcher, this);
        } else {
            TextureUtil.allocateTextureImpl(this.getGlTextureId(), this.mipmapLevels, stitcher.getCurrentWidth(), stitcher.getCurrentHeight());
        }
        hashMap = Maps.newHashMap(this.mapRegisteredSprites);
        for (TextureAtlasSprite textureAtlasSprite : stitcher.getStichSlots()) {
            object2 = textureAtlasSprite.getIconName();
            hashMap.remove(object2);
            this.mapUploadedSprites.put((String)object2, textureAtlasSprite);
            try {
                if (Config.isShaders()) {
                    ShadersTex.uploadTexSubForLoadAtlas(this, textureAtlasSprite.getIconName(), textureAtlasSprite.getFrameTextureData(0), textureAtlasSprite.getIconWidth(), textureAtlasSprite.getIconHeight(), textureAtlasSprite.getOriginX(), textureAtlasSprite.getOriginY(), false, false);
                } else {
                    TextureUtil.uploadTextureMipmap(textureAtlasSprite.getFrameTextureData(0), textureAtlasSprite.getIconWidth(), textureAtlasSprite.getIconHeight(), textureAtlasSprite.getOriginX(), textureAtlasSprite.getOriginY(), false, false);
                }
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Stitching texture atlas");
                object = crashReport.makeCategory("Texture being stitched together");
                ((CrashReportCategory)object).addCrashSection("Atlas path", this.basePath);
                ((CrashReportCategory)object).addCrashSection("Sprite", textureAtlasSprite);
                throw new ReportedException(crashReport);
            }
            if (!textureAtlasSprite.hasAnimationMetadata()) continue;
            textureAtlasSprite.setAnimationIndex(this.listAnimatedSprites.size());
            this.listAnimatedSprites.add(textureAtlasSprite);
        }
        for (TextureAtlasSprite textureAtlasSprite : hashMap.values()) {
            textureAtlasSprite.copyFrom(this.missingImage);
        }
        Config.log("Animated sprites: " + this.listAnimatedSprites.size());
        if (Config.isMultiTexture()) {
            int n19 = stitcher.getCurrentWidth();
            int n20 = stitcher.getCurrentHeight();
            for (TextureAtlasSprite textureAtlasSprite : stitcher.getStichSlots()) {
                textureAtlasSprite.sheetWidth = n19;
                textureAtlasSprite.sheetHeight = n20;
                textureAtlasSprite.mipmapLevels = this.mipmapLevels;
                TextureAtlasSprite textureAtlasSprite2 = textureAtlasSprite.spriteSingle;
                if (textureAtlasSprite2 == null) continue;
                if (textureAtlasSprite2.getIconWidth() <= 0) {
                    textureAtlasSprite2.setIconWidth(textureAtlasSprite.getIconWidth());
                    textureAtlasSprite2.setIconHeight(textureAtlasSprite.getIconHeight());
                    textureAtlasSprite2.initSprite(textureAtlasSprite.getIconWidth(), textureAtlasSprite.getIconHeight(), 0, 0, false);
                    textureAtlasSprite2.clearFramesTextureData();
                    List<int[][]> list = textureAtlasSprite.getFramesTextureData();
                    textureAtlasSprite2.setFramesTextureData(list);
                    textureAtlasSprite2.setAnimationMetadata(textureAtlasSprite.getAnimationMetadata());
                }
                textureAtlasSprite2.sheetWidth = n19;
                textureAtlasSprite2.sheetHeight = n20;
                textureAtlasSprite2.mipmapLevels = this.mipmapLevels;
                textureAtlasSprite2.setAnimationIndex(textureAtlasSprite.getAnimationIndex());
                textureAtlasSprite.bindSpriteTexture();
                boolean bl = false;
                boolean bl2 = true;
                try {
                    TextureUtil.uploadTextureMipmap(textureAtlasSprite2.getFrameTextureData(0), textureAtlasSprite2.getIconWidth(), textureAtlasSprite2.getIconHeight(), textureAtlasSprite2.getOriginX(), textureAtlasSprite2.getOriginY(), bl, bl2);
                }
                catch (Exception exception) {
                    Config.dbg("Error uploading sprite single: " + String.valueOf(textureAtlasSprite2) + ", parent: " + String.valueOf(textureAtlasSprite));
                    exception.printStackTrace();
                }
            }
            Config.getMinecraft().getTextureManager().bindTexture(locationBlocksTexture);
        }
        Reflector.callVoid(Reflector.CompatHooksClient_onTextureStitchedPost, this);
        this.updateIconGrid(stitcher.getCurrentWidth(), stitcher.getCurrentHeight());
        if (Config.equals(System.getProperty("saveTextureMap"), "true")) {
            Config.dbg("Exporting texture map: " + this.basePath);
            TextureUtils.saveGlTexture("debug/" + this.basePath.replaceAll("/", "_"), this.getGlTextureId(), this.mipmapLevels, stitcher.getCurrentWidth(), stitcher.getCurrentHeight());
        }
    }

    public ResourceLocation completeResourceLocation(ResourceLocation resourceLocation) {
        return this.completeResourceLocation(resourceLocation, 0);
    }

    public ResourceLocation completeResourceLocation(ResourceLocation resourceLocation, int n) {
        return this.isAbsoluteLocation(resourceLocation) ? new ResourceLocation(resourceLocation.getResourceDomain(), resourceLocation.getResourcePath() + ".png") : (n == 0 ? new ResourceLocation(resourceLocation.getResourceDomain(), String.format("%s/%s%s", this.basePath, resourceLocation.getResourcePath(), ".png")) : new ResourceLocation(resourceLocation.getResourceDomain(), String.format("%s/mipmaps/%s.%d%s", this.basePath, resourceLocation.getResourcePath(), n, ".png")));
    }

    public TextureAtlasSprite getAtlasSprite(String string) {
        TextureAtlasSprite textureAtlasSprite = this.mapUploadedSprites.get(string);
        if (textureAtlasSprite == null) {
            textureAtlasSprite = this.missingImage;
        }
        return textureAtlasSprite;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAnimations() {
        int n;
        boolean bl;
        boolean bl2 = false;
        boolean bl3 = false;
        TextureUtil.bindTexture(this.getGlTextureId());
        int n2 = 0;
        boolean bl4 = bl = !Config.isShaders() && !Config.isMultiTexture() && GL.getCapabilities().OpenGL21;
        if (bl) {
            oc131b84b22f.\u00c5();
        }
        try {
            for (TextureAtlasSprite textureAtlasSprite : this.listAnimatedSprites) {
                if (!this.isTerrainAnimationActive(textureAtlasSprite)) continue;
                textureAtlasSprite.updateAnimation();
                if (textureAtlasSprite.isAnimationActive()) {
                    ++n2;
                }
                if (textureAtlasSprite.spriteNormal != null) {
                    bl2 = true;
                }
                if (textureAtlasSprite.spriteSpecular == null) continue;
                bl3 = true;
            }
        }
        finally {
            if (bl) {
                oc131b84b22f.\u0140();
            }
        }
        if (Config.isMultiTexture()) {
            for (TextureAtlasSprite textureAtlasSprite : this.listAnimatedSprites) {
                TextureAtlasSprite textureAtlasSprite2;
                if (!this.isTerrainAnimationActive(textureAtlasSprite) || (textureAtlasSprite2 = textureAtlasSprite.spriteSingle) == null) continue;
                if (textureAtlasSprite == TextureUtils.iconClock || textureAtlasSprite == TextureUtils.iconCompass) {
                    textureAtlasSprite2.frameCounter = textureAtlasSprite.frameCounter;
                }
                textureAtlasSprite.bindSpriteTexture();
                textureAtlasSprite2.updateAnimation();
                if (!textureAtlasSprite2.isAnimationActive()) continue;
                ++n2;
            }
            TextureUtil.bindTexture(this.getGlTextureId());
        }
        if (Config.isShaders()) {
            if (bl2) {
                TextureUtil.bindTexture(this.getMultiTexID().norm);
                for (TextureAtlasSprite textureAtlasSprite : this.listAnimatedSprites) {
                    if (textureAtlasSprite.spriteNormal == null || !this.isTerrainAnimationActive(textureAtlasSprite)) continue;
                    if (textureAtlasSprite == TextureUtils.iconClock || textureAtlasSprite == TextureUtils.iconCompass) {
                        textureAtlasSprite.spriteNormal.frameCounter = textureAtlasSprite.frameCounter;
                    }
                    textureAtlasSprite.spriteNormal.updateAnimation();
                    if (!textureAtlasSprite.spriteNormal.isAnimationActive()) continue;
                    ++n2;
                }
            }
            if (bl3) {
                TextureUtil.bindTexture(this.getMultiTexID().spec);
                for (TextureAtlasSprite textureAtlasSprite : this.listAnimatedSprites) {
                    if (textureAtlasSprite.spriteSpecular == null || !this.isTerrainAnimationActive(textureAtlasSprite)) continue;
                    if (textureAtlasSprite == TextureUtils.iconClock || textureAtlasSprite == TextureUtils.iconCompass) {
                        textureAtlasSprite.spriteNormal.frameCounter = textureAtlasSprite.frameCounter;
                    }
                    textureAtlasSprite.spriteSpecular.updateAnimation();
                    if (!textureAtlasSprite.spriteSpecular.isAnimationActive()) continue;
                    ++n2;
                }
            }
            if (bl2 || bl3) {
                TextureUtil.bindTexture(this.getGlTextureId());
            }
        }
        if ((n = Config.getMinecraft().entityRenderer.frameCount) != this.frameCountAnimations) {
            this.countAnimationsActive = n2;
            this.frameCountAnimations = n;
        }
        if (SmartAnimations.isActive()) {
            SmartAnimations.resetSpritesRendered();
        }
    }

    public TextureAtlasSprite registerSprite(ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            throw new IllegalArgumentException("Location cannot be null!");
        }
        TextureAtlasSprite textureAtlasSprite = this.mapRegisteredSprites.get(resourceLocation.toString());
        if (textureAtlasSprite == null) {
            textureAtlasSprite = TextureAtlasSprite.makeAtlasSprite(resourceLocation);
            this.mapRegisteredSprites.put(resourceLocation.toString(), textureAtlasSprite);
            textureAtlasSprite.updateIndexInMap(this.counterIndexInMap);
            if (Config.isEmissiveTextures()) {
                this.checkEmissive(resourceLocation, textureAtlasSprite);
            }
        }
        return textureAtlasSprite;
    }

    @Override
    public void tick() {
        this.updateAnimations();
    }

    public void setMipmapLevels(int n) {
        this.mipmapLevels = n;
    }

    public TextureAtlasSprite getMissingSprite() {
        return this.missingImage;
    }

    public TextureAtlasSprite getTextureExtry(String string) {
        return this.mapRegisteredSprites.get(string);
    }

    public boolean setTextureEntry(String string, TextureAtlasSprite textureAtlasSprite) {
        if (!this.mapRegisteredSprites.containsKey(string)) {
            this.mapRegisteredSprites.put(string, textureAtlasSprite);
            textureAtlasSprite.updateIndexInMap(this.counterIndexInMap);
            return true;
        }
        return false;
    }

    public boolean setTextureEntry(TextureAtlasSprite textureAtlasSprite) {
        return this.setTextureEntry(textureAtlasSprite.getIconName(), textureAtlasSprite);
    }

    public String getBasePath() {
        return this.basePath;
    }

    public int getMipmapLevels() {
        return this.mipmapLevels;
    }

    private boolean isAbsoluteLocation(ResourceLocation resourceLocation) {
        String string = resourceLocation.getResourcePath();
        return this.isAbsoluteLocationPath(string);
    }

    private boolean isAbsoluteLocationPath(String string) {
        String string2 = string.toLowerCase();
        return string2.startsWith("mcpatcher/") || string2.startsWith("optifine/");
    }

    public TextureAtlasSprite getSpriteSafe(String string) {
        ResourceLocation resourceLocation = new ResourceLocation(string);
        return this.mapRegisteredSprites.get(resourceLocation.toString());
    }

    public TextureAtlasSprite getRegisteredSprite(ResourceLocation resourceLocation) {
        return this.mapRegisteredSprites.get(resourceLocation.toString());
    }

    private boolean isTerrainAnimationActive(TextureAtlasSprite textureAtlasSprite) {
        return textureAtlasSprite != TextureUtils.iconWaterStill && textureAtlasSprite != TextureUtils.iconWaterFlow ? (textureAtlasSprite != TextureUtils.iconLavaStill && textureAtlasSprite != TextureUtils.iconLavaFlow ? (textureAtlasSprite != TextureUtils.iconFireLayer0 && textureAtlasSprite != TextureUtils.iconFireLayer1 ? (textureAtlasSprite == TextureUtils.iconPortal ? Config.isAnimatedPortal() : (textureAtlasSprite != TextureUtils.iconClock && textureAtlasSprite != TextureUtils.iconCompass ? Config.isAnimatedTerrain() : true)) : Config.isAnimatedFire()) : Config.isAnimatedLava()) : Config.isAnimatedWater();
    }

    public int getCountRegisteredSprites() {
        return this.counterIndexInMap.getValue();
    }

    private int detectMaxMipmapLevel(Map map, IResourceManager iResourceManager) {
        int n;
        int n2 = this.detectMinimumSpriteSize(map, iResourceManager, 20);
        if (n2 < 16) {
            n2 = 16;
        }
        if ((n2 = MathHelper.roundUpToPowerOfTwo(n2)) > 16) {
            Config.log("Sprite size: " + n2);
        }
        if ((n = MathHelper.calculateLogBaseTwo(n2)) < 4) {
            n = 4;
        }
        return n;
    }

    private int detectMinimumSpriteSize(Map map, IResourceManager iResourceManager, int n) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Iterator iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            object3 = object4 = iterator2.next();
            TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite)object3.getValue();
            object2 = new ResourceLocation(textureAtlasSprite.getIconName());
            ResourceLocation resourceLocation = this.completeResourceLocation((ResourceLocation)object2);
            if (textureAtlasSprite.hasCustomLoader(iResourceManager, (ResourceLocation)object2)) continue;
            try {
                InputStream inputStream2;
                object = iResourceManager.getResource(resourceLocation);
                if (object == null || (inputStream2 = object.getInputStream()) == null) continue;
                Dimension dimension = TextureUtils.getImageSize(inputStream2, "png");
                inputStream2.close();
                if (dimension == null) continue;
                int n2 = dimension.width;
                int n3 = MathHelper.roundUpToPowerOfTwo(n2);
                if (!hashMap.containsKey(n3)) {
                    hashMap.put(n3, 1);
                    continue;
                }
                int n4 = (Integer)hashMap.get(n3);
                hashMap.put(n3, n4 + 1);
            }
            catch (Exception exception) {}
        }
        int n5 = 0;
        object4 = hashMap.keySet();
        object3 = new TreeSet(object4);
        object2 = object3.iterator();
        while (object2.hasNext()) {
            int n6 = (Integer)object2.next();
            int n7 = (Integer)hashMap.get(n6);
            n5 += n7;
        }
        int n8 = 16;
        int n9 = 0;
        int n10 = n5 * n / 100;
        object = object3.iterator();
        while (object.hasNext()) {
            int n11 = (Integer)object.next();
            int n12 = (Integer)hashMap.get(n11);
            n9 += n12;
            if (n11 > n8) {
                n8 = n11;
            }
            if (n9 <= n10) continue;
            return n8;
        }
        return n8;
    }

    private int getMinSpriteSize() {
        int n = 1 << this.mipmapLevels;
        if (n < 8) {
            n = 8;
        }
        return n;
    }

    private int[] getMissingImageData(int n) {
        BufferedImage bufferedImage = new BufferedImage(16, 16, 2);
        bufferedImage.setRGB(0, 0, 16, 16, TextureUtil.missingTextureData, 0, 16);
        BufferedImage bufferedImage2 = TextureUtils.scaleImage(bufferedImage, n);
        int[] nArray = new int[n * n];
        bufferedImage2.getRGB(0, 0, n, n, nArray, 0, n);
        return nArray;
    }

    public boolean isTextureBound() {
        int n;
        int n2 = GlStateManager.getBoundTexture();
        return n2 == (n = this.getGlTextureId());
    }

    private void updateIconGrid(int n, int n2) {
        this.iconGridCountX = -1;
        this.iconGridCountY = -1;
        this.iconGrid = null;
        if (this.iconGridSize > 0) {
            this.iconGridCountX = n / this.iconGridSize;
            this.iconGridCountY = n2 / this.iconGridSize;
            this.iconGrid = new TextureAtlasSprite[this.iconGridCountX * this.iconGridCountY];
            this.iconGridSizeU = 1.0 / (double)this.iconGridCountX;
            this.iconGridSizeV = 1.0 / (double)this.iconGridCountY;
            for (TextureAtlasSprite textureAtlasSprite : this.mapUploadedSprites.values()) {
                double d = 0.5 / (double)n;
                double d2 = 0.5 / (double)n2;
                double d3 = (double)Math.min(textureAtlasSprite.getMinU(), textureAtlasSprite.getMaxU()) + d;
                double d4 = (double)Math.min(textureAtlasSprite.getMinV(), textureAtlasSprite.getMaxV()) + d2;
                double d5 = (double)Math.max(textureAtlasSprite.getMinU(), textureAtlasSprite.getMaxU()) - d;
                double d6 = (double)Math.max(textureAtlasSprite.getMinV(), textureAtlasSprite.getMaxV()) - d2;
                int n3 = (int)(d3 / this.iconGridSizeU);
                int n4 = (int)(d4 / this.iconGridSizeV);
                int n5 = (int)(d5 / this.iconGridSizeU);
                int n6 = (int)(d6 / this.iconGridSizeV);
                for (int i = n3; i <= n5; ++i) {
                    if (i >= 0 && i < this.iconGridCountX) {
                        for (int j = n4; j <= n6; ++j) {
                            if (j >= 0 && j < this.iconGridCountX) {
                                int n7 = j * this.iconGridCountX + i;
                                this.iconGrid[n7] = textureAtlasSprite;
                                continue;
                            }
                            Config.warn("Invalid grid V: " + j + ", icon: " + textureAtlasSprite.getIconName());
                        }
                        continue;
                    }
                    Config.warn("Invalid grid U: " + i + ", icon: " + textureAtlasSprite.getIconName());
                }
            }
        }
    }

    public TextureAtlasSprite getIconByUV(double d, double d2) {
        if (this.iconGrid == null) {
            return null;
        }
        int n = (int)(d2 / this.iconGridSizeV);
        int n2 = (int)(d / this.iconGridSizeU);
        int n3 = n * this.iconGridCountX + n2;
        return n3 >= 0 && n3 <= this.iconGrid.length ? this.iconGrid[n3] : null;
    }

    private void checkEmissive(ResourceLocation resourceLocation, TextureAtlasSprite textureAtlasSprite) {
        ResourceLocation resourceLocation2;
        ResourceLocation resourceLocation3;
        String string = EmissiveTextures.getSuffixEmissive();
        if (string != null && !resourceLocation.getResourcePath().endsWith(string) && Config.hasResource(resourceLocation3 = this.completeResourceLocation(resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), resourceLocation.getResourcePath() + string)))) {
            TextureAtlasSprite textureAtlasSprite2 = this.registerSprite(resourceLocation2);
            textureAtlasSprite2.isEmissive = true;
            textureAtlasSprite.spriteEmissive = textureAtlasSprite2;
        }
    }

    public int getCountAnimations() {
        return this.listAnimatedSprites.size();
    }

    public int getCountAnimationsActive() {
        return this.countAnimationsActive;
    }
}

