/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.texture.TextureClock;
import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.src.Config;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.optifine.SmartAnimations;
import net.optifine.shaders.Shaders;
import net.optifine.util.CounterInt;
import net.optifine.util.TextureUtils;

public class TextureAtlasSprite {
    private final String iconName;
    protected List<int[][]> framesTextureData = Lists.newArrayList();
    protected int[][] interpolatedFrameData;
    private AnimationMetadataSection animationMetadata;
    protected boolean rotated;
    protected int originX;
    protected int originY;
    protected int width;
    protected int height;
    private float minU;
    private float maxU;
    private float minV;
    private float maxV;
    protected int frameCounter;
    protected int tickCounter;
    private static String locationNameClock = "builtin/clock";
    private static String locationNameCompass = "builtin/compass";
    private int indexInMap = -1;
    public float baseU;
    public float baseV;
    public int sheetWidth;
    public int sheetHeight;
    public int glSpriteTextureId = -1;
    public TextureAtlasSprite spriteSingle = null;
    public boolean isSpriteSingle = false;
    public int mipmapLevels = 0;
    public TextureAtlasSprite spriteNormal = null;
    public TextureAtlasSprite spriteSpecular = null;
    public boolean isShadersSprite = false;
    public boolean isEmissive = false;
    public TextureAtlasSprite spriteEmissive = null;
    private int animationIndex = -1;
    private boolean animationActive = false;

    private TextureAtlasSprite(String string, boolean bl) {
        this.iconName = string;
        this.isSpriteSingle = bl;
    }

    public TextureAtlasSprite(String string) {
        this.iconName = string;
        if (Config.isMultiTexture()) {
            this.spriteSingle = new TextureAtlasSprite(this.getIconName() + ".spriteSingle", true);
        }
    }

    protected static TextureAtlasSprite makeAtlasSprite(ResourceLocation resourceLocation) {
        String string = resourceLocation.toString();
        return locationNameClock.equals(string) ? new TextureClock(string) : (locationNameCompass.equals(string) ? new TextureCompass(string) : new TextureAtlasSprite(string));
    }

    public static void setLocationNameClock(String string) {
        locationNameClock = string;
    }

    public static void setLocationNameCompass(String string) {
        locationNameCompass = string;
    }

    public void initSprite(int n, int n2, int n3, int n4, boolean bl) {
        this.originX = n3;
        this.originY = n4;
        this.rotated = bl;
        float f = (float)((double)0.01f / (double)n);
        float f2 = (float)((double)0.01f / (double)n2);
        this.minU = (float)n3 / (float)((double)n) + f;
        this.maxU = (float)(n3 + this.width) / (float)((double)n) - f;
        this.minV = (float)n4 / (float)n2 + f2;
        this.maxV = (float)(n4 + this.height) / (float)n2 - f2;
        this.baseU = Math.min(this.minU, this.maxU);
        this.baseV = Math.min(this.minV, this.maxV);
        if (this.spriteSingle != null) {
            this.spriteSingle.initSprite(this.width, this.height, 0, 0, false);
        }
        if (this.spriteNormal != null) {
            this.spriteNormal.copyFrom(this);
        }
        if (this.spriteSpecular != null) {
            this.spriteSpecular.copyFrom(this);
        }
    }

    public void copyFrom(TextureAtlasSprite textureAtlasSprite) {
        this.originX = textureAtlasSprite.originX;
        this.originY = textureAtlasSprite.originY;
        this.width = textureAtlasSprite.width;
        this.height = textureAtlasSprite.height;
        this.rotated = textureAtlasSprite.rotated;
        this.minU = textureAtlasSprite.minU;
        this.maxU = textureAtlasSprite.maxU;
        this.minV = textureAtlasSprite.minV;
        this.maxV = textureAtlasSprite.maxV;
        if (textureAtlasSprite != Config.getTextureMap().getMissingSprite()) {
            this.indexInMap = textureAtlasSprite.indexInMap;
        }
        this.baseU = textureAtlasSprite.baseU;
        this.baseV = textureAtlasSprite.baseV;
        this.sheetWidth = textureAtlasSprite.sheetWidth;
        this.sheetHeight = textureAtlasSprite.sheetHeight;
        this.glSpriteTextureId = textureAtlasSprite.glSpriteTextureId;
        this.mipmapLevels = textureAtlasSprite.mipmapLevels;
        if (this.spriteSingle != null) {
            this.spriteSingle.initSprite(this.width, this.height, 0, 0, false);
        }
        this.animationIndex = textureAtlasSprite.animationIndex;
    }

    public int getOriginX() {
        return this.originX;
    }

    public int getOriginY() {
        return this.originY;
    }

    public int getIconWidth() {
        return this.width;
    }

    public int getIconHeight() {
        return this.height;
    }

    public float getMinU() {
        return this.minU;
    }

    public float getMaxU() {
        return this.maxU;
    }

    public float getInterpolatedU(double d) {
        float f = this.maxU - this.minU;
        return this.minU + f * (float)d / 16.0f;
    }

    public float getMinV() {
        return this.minV;
    }

    public float getMaxV() {
        return this.maxV;
    }

    public float getInterpolatedV(double d) {
        float f = this.maxV - this.minV;
        return this.minV + f * ((float)d / 16.0f);
    }

    public String getIconName() {
        return this.iconName;
    }

    public void updateAnimation() {
        if (this.animationMetadata != null) {
            this.animationActive = SmartAnimations.isActive() ? SmartAnimations.isSpriteRendered(this.animationIndex) : true;
            ++this.tickCounter;
            if (this.tickCounter >= this.animationMetadata.getFrameTimeSingle(this.frameCounter)) {
                int n = this.animationMetadata.getFrameIndex(this.frameCounter);
                int n2 = this.animationMetadata.getFrameCount() == 0 ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
                this.frameCounter = (this.frameCounter + 1) % n2;
                this.tickCounter = 0;
                int n3 = this.animationMetadata.getFrameIndex(this.frameCounter);
                boolean bl = false;
                boolean bl2 = this.isSpriteSingle;
                if (!this.animationActive) {
                    return;
                }
                if (n != n3 && n3 >= 0 && n3 < this.framesTextureData.size()) {
                    TextureUtil.uploadTextureMipmap(this.framesTextureData.get(n3), this.width, this.height, this.originX, this.originY, bl, bl2);
                }
            } else if (this.animationMetadata.isInterpolate()) {
                if (!this.animationActive) {
                    return;
                }
                this.updateAnimationInterpolated();
            }
        }
    }

    private void updateAnimationInterpolated() {
        int n;
        int n2;
        double d = 1.0 - (double)this.tickCounter / (double)this.animationMetadata.getFrameTimeSingle(this.frameCounter);
        int n3 = this.animationMetadata.getFrameIndex(this.frameCounter);
        if (n3 != (n2 = this.animationMetadata.getFrameIndex((this.frameCounter + 1) % (n = this.animationMetadata.getFrameCount() == 0 ? this.framesTextureData.size() : this.animationMetadata.getFrameCount()))) && n2 >= 0 && n2 < this.framesTextureData.size()) {
            int[][] nArray = this.framesTextureData.get(n3);
            int[][] nArray2 = this.framesTextureData.get(n2);
            if (this.interpolatedFrameData == null || this.interpolatedFrameData.length != nArray.length) {
                this.interpolatedFrameData = new int[nArray.length][];
            }
            for (int i = 0; i < nArray.length; ++i) {
                if (this.interpolatedFrameData[i] == null) {
                    this.interpolatedFrameData[i] = new int[nArray[i].length];
                }
                if (i >= nArray2.length || nArray2[i].length != nArray[i].length) continue;
                for (int j = 0; j < nArray[i].length; ++j) {
                    int n4 = nArray[i][j];
                    int n5 = nArray2[i][j];
                    int n6 = (int)((double)((n4 & 0xFF0000) >> 16) * d + (double)((n5 & 0xFF0000) >> 16) * (1.0 - d));
                    int n7 = (int)((double)((n4 & 0xFF00) >> 8) * d + (double)((n5 & 0xFF00) >> 8) * (1.0 - d));
                    int n8 = (int)((double)(n4 & 0xFF) * d + (double)(n5 & 0xFF) * (1.0 - d));
                    this.interpolatedFrameData[i][j] = n4 & 0xFF000000 | n6 << 16 | n7 << 8 | n8;
                }
            }
            TextureUtil.uploadTextureMipmap(this.interpolatedFrameData, this.width, this.height, this.originX, this.originY, false, false);
        }
    }

    public int[][] getFrameTextureData(int n) {
        return this.framesTextureData.get(n);
    }

    public int getFrameCount() {
        return this.framesTextureData.size();
    }

    public void setIconWidth(int n) {
        this.width = n;
        if (this.spriteSingle != null) {
            this.spriteSingle.setIconWidth(this.width);
        }
    }

    public void setIconHeight(int n) {
        this.height = n;
        if (this.spriteSingle != null) {
            this.spriteSingle.setIconHeight(this.height);
        }
    }

    public void loadSprite(BufferedImage[] bufferedImageArray, AnimationMetadataSection animationMetadataSection) throws IOException {
        Object object;
        int n;
        int n2;
        this.resetSprite();
        int n3 = bufferedImageArray[0].getWidth();
        int n4 = bufferedImageArray[0].getHeight();
        this.width = n3;
        this.height = n4;
        if (this.spriteSingle != null) {
            this.spriteSingle.width = this.width;
            this.spriteSingle.height = this.height;
        }
        int[][] nArrayArray = new int[bufferedImageArray.length][];
        for (n2 = 0; n2 < bufferedImageArray.length; ++n2) {
            BufferedImage bufferedImage = bufferedImageArray[n2];
            if (bufferedImage == null) continue;
            if (this.width >> n2 != bufferedImage.getWidth()) {
                bufferedImage = TextureUtils.scaleImage(bufferedImage, this.width >> n2);
            }
            if (n2 > 0 && (bufferedImage.getWidth() != n3 >> n2 || bufferedImage.getHeight() != n4 >> n2)) {
                throw new RuntimeException(String.format("Unable to load miplevel: %d, image is size: %dx%d, expected %dx%d", n2, bufferedImage.getWidth(), bufferedImage.getHeight(), n3 >> n2, n4 >> n2));
            }
            nArrayArray[n2] = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
            bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), nArrayArray[n2], 0, bufferedImage.getWidth());
        }
        if (animationMetadataSection == null) {
            if (n4 != n3) {
                throw new RuntimeException("broken aspect ratio and not an animation");
            }
            this.framesTextureData.add(nArrayArray);
        } else {
            n2 = n4 / n3;
            int n5 = n3;
            n = n3;
            this.height = this.width;
            if (animationMetadataSection.getFrameCount() > 0) {
                object = animationMetadataSection.getFrameIndexSet().iterator();
                while (object.hasNext()) {
                    var10_13 = (Integer)object.next();
                    if (var10_13 >= n2) {
                        throw new RuntimeException("invalid frameindex " + var10_13);
                    }
                    this.allocateFrameTextureData(var10_13);
                    this.framesTextureData.set(var10_13, TextureAtlasSprite.getFrameTextureData(nArrayArray, n5, n, var10_13));
                }
                this.animationMetadata = animationMetadataSection;
            } else {
                object = Lists.newArrayList();
                for (var10_13 = 0; var10_13 < n2; ++var10_13) {
                    this.framesTextureData.add(TextureAtlasSprite.getFrameTextureData(nArrayArray, n5, n, var10_13));
                    object.add(new AnimationFrame(var10_13, -1));
                }
                this.animationMetadata = new AnimationMetadataSection((List<AnimationFrame>)object, this.width, this.height, animationMetadataSection.getFrameTime(), animationMetadataSection.isInterpolate());
            }
        }
        if (!this.isShadersSprite) {
            if (Config.isShaders()) {
                this.loadShadersSprites();
            }
            for (n2 = 0; n2 < this.framesTextureData.size(); ++n2) {
                int[][] nArray = this.framesTextureData.get(n2);
                if (nArray == null || this.iconName.startsWith("minecraft:blocks/leaves_")) continue;
                for (n = 0; n < nArray.length; ++n) {
                    object = nArray[n];
                    this.fixTransparentColor((int[])object);
                }
            }
            if (this.spriteSingle != null) {
                this.spriteSingle.loadSprite(bufferedImageArray, animationMetadataSection);
            }
        }
    }

    public void generateMipmaps(int n) {
        ArrayList<int[][]> arrayList = Lists.newArrayList();
        for (int i = 0; i < this.framesTextureData.size(); ++i) {
            final int[][] nArray = this.framesTextureData.get(i);
            if (nArray == null) continue;
            try {
                arrayList.add(TextureUtil.generateMipmapData(n, this.width, nArray));
                continue;
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Generating mipmaps for frame");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Frame being iterated");
                crashReportCategory.addCrashSection("Frame index", i);
                crashReportCategory.addCrashSectionCallable("Frame sizes", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int[] nArray2 : nArray) {
                            if (stringBuilder.length() > 0) {
                                stringBuilder.append(", ");
                            }
                            stringBuilder.append(nArray2 == null ? "null" : Integer.valueOf(nArray2.length));
                        }
                        return stringBuilder.toString();
                    }
                });
                throw new ReportedException(crashReport);
            }
        }
        this.setFramesTextureData(arrayList);
        if (this.spriteSingle != null) {
            this.spriteSingle.generateMipmaps(n);
        }
    }

    private void allocateFrameTextureData(int n) {
        if (this.framesTextureData.size() <= n) {
            for (int i = this.framesTextureData.size(); i <= n; ++i) {
                this.framesTextureData.add(null);
            }
        }
        if (this.spriteSingle != null) {
            this.spriteSingle.allocateFrameTextureData(n);
        }
    }

    private static int[][] getFrameTextureData(int[][] nArray, int n, int n2, int n3) {
        int[][] nArrayArray = new int[nArray.length][];
        for (int i = 0; i < nArray.length; ++i) {
            int[] nArray2 = nArray[i];
            if (nArray2 == null) continue;
            nArrayArray[i] = new int[(n >> i) * (n2 >> i)];
            System.arraycopy(nArray2, n3 * nArrayArray[i].length, nArrayArray[i], 0, nArrayArray[i].length);
        }
        return nArrayArray;
    }

    public void clearFramesTextureData() {
        this.framesTextureData.clear();
        if (this.spriteSingle != null) {
            this.spriteSingle.clearFramesTextureData();
        }
    }

    public boolean hasAnimationMetadata() {
        return this.animationMetadata != null;
    }

    public void setFramesTextureData(List<int[][]> list) {
        this.framesTextureData = list;
        if (this.spriteSingle != null) {
            this.spriteSingle.setFramesTextureData(list);
        }
    }

    private void resetSprite() {
        this.animationMetadata = null;
        this.setFramesTextureData(Lists.newArrayList());
        this.frameCounter = 0;
        this.tickCounter = 0;
        if (this.spriteSingle != null) {
            this.spriteSingle.resetSprite();
        }
    }

    public String toString() {
        return "TextureAtlasSprite{name='" + this.iconName + "', frameCount=" + this.framesTextureData.size() + ", rotated=" + this.rotated + ", x=" + this.originX + ", y=" + this.originY + ", height=" + this.height + ", width=" + this.width + ", u0=" + this.minU + ", u1=" + this.maxU + ", v0=" + this.minV + ", v1=" + this.maxV + "}";
    }

    public boolean hasCustomLoader(IResourceManager iResourceManager, ResourceLocation resourceLocation) {
        return false;
    }

    public boolean load(IResourceManager iResourceManager, ResourceLocation resourceLocation) {
        return true;
    }

    public int getIndexInMap() {
        return this.indexInMap;
    }

    public void setIndexInMap(int n) {
        this.indexInMap = n;
    }

    public void updateIndexInMap(CounterInt counterInt) {
        if (this.indexInMap < 0) {
            this.indexInMap = counterInt.nextValue();
        }
    }

    public int getAnimationIndex() {
        return this.animationIndex;
    }

    public void setAnimationIndex(int n) {
        this.animationIndex = n;
        if (this.spriteNormal != null) {
            this.spriteNormal.setAnimationIndex(n);
        }
        if (this.spriteSpecular != null) {
            this.spriteSpecular.setAnimationIndex(n);
        }
    }

    public boolean isAnimationActive() {
        return this.animationActive;
    }

    private void fixTransparentColor(int[] nArray) {
        if (nArray != null) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            long l = 0L;
            long l2 = 0L;
            long l3 = 0L;
            long l4 = 0L;
            for (n6 = 0; n6 < nArray.length; ++n6) {
                n5 = nArray[n6];
                n4 = n5 >> 24 & 0xFF;
                if (n4 < 16) continue;
                n3 = n5 >> 16 & 0xFF;
                n2 = n5 >> 8 & 0xFF;
                n = n5 & 0xFF;
                l += (long)n3;
                l2 += (long)n2;
                l3 += (long)n;
                ++l4;
            }
            if (l4 > 0L) {
                n6 = (int)(l / l4);
                n5 = (int)(l2 / l4);
                n4 = (int)(l3 / l4);
                n3 = n6 << 16 | n5 << 8 | n4;
                for (n2 = 0; n2 < nArray.length; ++n2) {
                    n = nArray[n2];
                    int n7 = n >> 24 & 0xFF;
                    if (n7 > 16) continue;
                    nArray[n2] = n3;
                }
            }
        }
    }

    public double getSpriteU16(float f) {
        float f2 = this.maxU - this.minU;
        return (f - this.minU) / f2 * 16.0f;
    }

    public double getSpriteV16(float f) {
        float f2 = this.maxV - this.minV;
        return (f - this.minV) / f2 * 16.0f;
    }

    public void bindSpriteTexture() {
        if (this.glSpriteTextureId < 0) {
            this.glSpriteTextureId = TextureUtil.glGenTextures();
            TextureUtil.allocateTextureImpl(this.glSpriteTextureId, this.mipmapLevels, this.width, this.height);
            TextureUtils.applyAnisotropicLevel();
        }
        TextureUtils.bindTexture(this.glSpriteTextureId);
    }

    public void deleteSpriteTexture() {
        if (this.glSpriteTextureId >= 0) {
            TextureUtil.deleteTexture(this.glSpriteTextureId);
            this.glSpriteTextureId = -1;
        }
    }

    public float toSingleU(float f) {
        f -= this.baseU;
        float f2 = (float)this.sheetWidth / (float)this.width;
        return f *= f2;
    }

    public float toSingleV(float f) {
        f -= this.baseV;
        float f2 = (float)this.sheetHeight / (float)this.height;
        return f *= f2;
    }

    public List<int[][]> getFramesTextureData() {
        ArrayList<int[][]> arrayList = new ArrayList<int[][]>();
        arrayList.addAll(this.framesTextureData);
        return arrayList;
    }

    public AnimationMetadataSection getAnimationMetadata() {
        return this.animationMetadata;
    }

    public void setAnimationMetadata(AnimationMetadataSection animationMetadataSection) {
        this.animationMetadata = animationMetadataSection;
    }

    private void loadShadersSprites() {
        ResourceLocation resourceLocation;
        String string;
        if (Shaders.configNormalMap) {
            string = this.iconName + "_n";
            resourceLocation = new ResourceLocation(string);
            resourceLocation = Config.getTextureMap().completeResourceLocation(resourceLocation);
            if (Config.hasResource(resourceLocation)) {
                this.spriteNormal = new TextureAtlasSprite(string);
                this.spriteNormal.isShadersSprite = true;
                this.spriteNormal.copyFrom(this);
                this.spriteNormal.generateMipmaps(this.mipmapLevels);
            }
        }
        if (Shaders.configSpecularMap) {
            string = this.iconName + "_s";
            resourceLocation = new ResourceLocation(string);
            resourceLocation = Config.getTextureMap().completeResourceLocation(resourceLocation);
            if (Config.hasResource(resourceLocation)) {
                this.spriteSpecular = new TextureAtlasSprite(string);
                this.spriteSpecular.isShadersSprite = true;
                this.spriteSpecular.copyFrom(this);
                this.spriteSpecular.generateMipmaps(this.mipmapLevels);
            }
        }
    }
}

