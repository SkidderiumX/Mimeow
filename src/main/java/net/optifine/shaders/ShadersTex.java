/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.shaders.MultiTexID;
import net.optifine.shaders.SMCLog;
import net.optifine.shaders.Shaders;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ShadersTex {
    public static final int initialBufferSize = 0x100000;
    public static ByteBuffer byteBuffer = BufferUtils.createByteBuffer(0x400000);
    public static IntBuffer intBuffer = byteBuffer.asIntBuffer();
    public static int[] intArray = new int[0x100000];
    public static final int defBaseTexColor = 0;
    public static final int defNormTexColor = -8421377;
    public static final int defSpecTexColor = 0;
    public static Map<Integer, MultiTexID> multiTexMap = new HashMap<Integer, MultiTexID>();

    public static IntBuffer getIntBuffer(int n) {
        if (intBuffer.capacity() < n) {
            int n2 = ShadersTex.roundUpPOT(n);
            byteBuffer = BufferUtils.createByteBuffer(n2 * 4);
            intBuffer = byteBuffer.asIntBuffer();
        }
        return intBuffer;
    }

    public static int[] getIntArray(int n) {
        if (intArray == null) {
            intArray = new int[0x100000];
        }
        if (intArray.length < n) {
            intArray = new int[ShadersTex.roundUpPOT(n)];
        }
        return intArray;
    }

    public static int roundUpPOT(int n) {
        int n2 = n - 1;
        n2 |= n2 >> 1;
        n2 |= n2 >> 2;
        n2 |= n2 >> 4;
        n2 |= n2 >> 8;
        n2 |= n2 >> 16;
        return n2 + 1;
    }

    public static int log2(int n) {
        int n2 = 0;
        if ((n & 0xFFFF0000) != 0) {
            n2 += 16;
            n >>= 16;
        }
        if ((n & 0xFF00) != 0) {
            n2 += 8;
            n >>= 8;
        }
        if ((n & 0xF0) != 0) {
            n2 += 4;
            n >>= 4;
        }
        if ((n & 6) != 0) {
            n2 += 2;
            n >>= 2;
        }
        if ((n & 2) != 0) {
            ++n2;
        }
        return n2;
    }

    public static IntBuffer fillIntBuffer(int n, int n2) {
        int[] nArray = ShadersTex.getIntArray(n);
        IntBuffer intBuffer = ShadersTex.getIntBuffer(n);
        Arrays.fill(intArray, 0, n, n2);
        ShadersTex.intBuffer.put(intArray, 0, n);
        return ShadersTex.intBuffer;
    }

    public static int[] createAIntImage(int n) {
        int[] nArray = new int[n * 3];
        Arrays.fill(nArray, 0, n, 0);
        Arrays.fill(nArray, n, n * 2, -8421377);
        Arrays.fill(nArray, n * 2, n * 3, 0);
        return nArray;
    }

    public static int[] createAIntImage(int n, int n2) {
        int[] nArray = new int[n * 3];
        Arrays.fill(nArray, 0, n, n2);
        Arrays.fill(nArray, n, n * 2, -8421377);
        Arrays.fill(nArray, n * 2, n * 3, 0);
        return nArray;
    }

    public static MultiTexID getMultiTexID(AbstractTexture abstractTexture) {
        MultiTexID multiTexID = abstractTexture.multiTex;
        if (multiTexID == null) {
            int n = abstractTexture.getGlTextureId();
            multiTexID = multiTexMap.get(n);
            if (multiTexID == null) {
                multiTexID = new MultiTexID(n, GL11.glGenTextures(), GL11.glGenTextures());
                multiTexMap.put(n, multiTexID);
            }
            abstractTexture.multiTex = multiTexID;
        }
        return multiTexID;
    }

    public static void deleteTextures(AbstractTexture abstractTexture, int n) {
        MultiTexID multiTexID = abstractTexture.multiTex;
        if (multiTexID != null) {
            abstractTexture.multiTex = null;
            multiTexMap.remove(multiTexID.base);
            GlStateManager.deleteTexture(multiTexID.norm);
            GlStateManager.deleteTexture(multiTexID.spec);
            if (multiTexID.base != n) {
                SMCLog.warning("Error : MultiTexID.base mismatch: " + multiTexID.base + ", texid: " + n);
                GlStateManager.deleteTexture(multiTexID.base);
            }
        }
    }

    public static void bindNSTextures(int n, int n2) {
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            GlStateManager.setActiveTexture(33986);
            GlStateManager.bindTexture(n);
            GlStateManager.setActiveTexture(33987);
            GlStateManager.bindTexture(n2);
            GlStateManager.setActiveTexture(33984);
        }
    }

    public static void bindNSTextures(MultiTexID multiTexID) {
        ShadersTex.bindNSTextures(multiTexID.norm, multiTexID.spec);
    }

    public static void bindTextures(int n, int n2, int n3) {
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            GlStateManager.setActiveTexture(33986);
            GlStateManager.bindTexture(n2);
            GlStateManager.setActiveTexture(33987);
            GlStateManager.bindTexture(n3);
            GlStateManager.setActiveTexture(33984);
        }
        GlStateManager.bindTexture(n);
    }

    public static void bindTextures(MultiTexID multiTexID) {
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            if (Shaders.configNormalMap) {
                GlStateManager.setActiveTexture(33986);
                GlStateManager.bindTexture(multiTexID.norm);
            }
            if (Shaders.configSpecularMap) {
                GlStateManager.setActiveTexture(33987);
                GlStateManager.bindTexture(multiTexID.spec);
            }
            GlStateManager.setActiveTexture(33984);
        }
        GlStateManager.bindTexture(multiTexID.base);
    }

    public static void bindTexture(ITextureObject iTextureObject) {
        int n = iTextureObject.getGlTextureId();
        ShadersTex.bindTextures(iTextureObject.getMultiTexID());
        if (GlStateManager.getActiveTextureUnit() == 33984) {
            int n2 = Shaders.atlasSizeX;
            int n3 = Shaders.atlasSizeY;
            if (iTextureObject instanceof TextureMap) {
                Shaders.atlasSizeX = ((TextureMap)iTextureObject).atlasWidth;
                Shaders.atlasSizeY = ((TextureMap)iTextureObject).atlasHeight;
            } else {
                Shaders.atlasSizeX = 0;
                Shaders.atlasSizeY = 0;
            }
            if (Shaders.atlasSizeX != n2 || Shaders.atlasSizeY != n3) {
                Shaders.uniform_atlasSize.setValue(Shaders.atlasSizeX, Shaders.atlasSizeY);
            }
        }
    }

    public static void bindTextures(int n) {
        MultiTexID multiTexID = multiTexMap.get(n);
        ShadersTex.bindTextures(multiTexID);
    }

    public static void initDynamicTexture(int n, int n2, int n3, DynamicTexture dynamicTexture) {
        MultiTexID multiTexID = dynamicTexture.getMultiTexID();
        int[] nArray = dynamicTexture.getTextureData();
        int n4 = n2 * n3;
        Arrays.fill(nArray, n4, n4 * 2, -8421377);
        Arrays.fill(nArray, n4 * 2, n4 * 3, 0);
        TextureUtil.allocateTexture(multiTexID.base, n2, n3);
        TextureUtil.setTextureBlurMipmap(false, false);
        TextureUtil.setTextureClamped(false);
        TextureUtil.allocateTexture(multiTexID.norm, n2, n3);
        TextureUtil.setTextureBlurMipmap(false, false);
        TextureUtil.setTextureClamped(false);
        TextureUtil.allocateTexture(multiTexID.spec, n2, n3);
        TextureUtil.setTextureBlurMipmap(false, false);
        TextureUtil.setTextureClamped(false);
        GlStateManager.bindTexture(multiTexID.base);
    }

    public static void updateDynamicTexture(int n, int[] nArray, int n2, int n3, DynamicTexture dynamicTexture) {
        MultiTexID multiTexID = dynamicTexture.getMultiTexID();
        GlStateManager.bindTexture(multiTexID.base);
        ShadersTex.updateDynTexSubImage1(nArray, n2, n3, 0, 0, 0);
        GlStateManager.bindTexture(multiTexID.norm);
        ShadersTex.updateDynTexSubImage1(nArray, n2, n3, 0, 0, 1);
        GlStateManager.bindTexture(multiTexID.spec);
        ShadersTex.updateDynTexSubImage1(nArray, n2, n3, 0, 0, 2);
        GlStateManager.bindTexture(multiTexID.base);
    }

    public static void updateDynTexSubImage1(int[] nArray, int n, int n2, int n3, int n4, int n5) {
        int n6 = n * n2;
        IntBuffer intBuffer = ShadersTex.getIntBuffer(n6);
        intBuffer.clear();
        int n7 = n5 * n6;
        if (nArray.length >= n7 + n6) {
            intBuffer.put(nArray, n7, n6).position(0).limit(n6);
            GL11.glTexSubImage2D(3553, 0, n3, n4, n, n2, 32993, 33639, intBuffer);
            intBuffer.clear();
        }
    }

    public static ITextureObject createDefaultTexture() {
        DynamicTexture dynamicTexture = new DynamicTexture(1, 1);
        dynamicTexture.getTextureData()[0] = -1;
        dynamicTexture.updateDynamicTexture();
        return dynamicTexture;
    }

    public static void allocateTextureMap(int n, int n2, int n3, int n4, Stitcher stitcher, TextureMap textureMap) {
        SMCLog.info("allocateTextureMap " + n2 + " " + n3 + " " + n4 + " ");
        textureMap.atlasWidth = n3;
        textureMap.atlasHeight = n4;
        MultiTexID multiTexID = ShadersTex.getMultiTexID(textureMap);
        TextureUtil.allocateTextureImpl(multiTexID.base, n2, n3, n4);
        if (Shaders.configNormalMap) {
            TextureUtil.allocateTextureImpl(multiTexID.norm, n2, n3, n4);
        }
        if (Shaders.configSpecularMap) {
            TextureUtil.allocateTextureImpl(multiTexID.spec, n2, n3, n4);
        }
        GlStateManager.bindTexture(n);
    }

    public static void uploadTexSubForLoadAtlas(TextureMap textureMap, String string, int[][] nArray, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int[][] nArray2;
        MultiTexID multiTexID = textureMap.multiTex;
        TextureUtil.uploadTextureMipmap(nArray, n, n2, n3, n4, bl, bl2);
        boolean bl3 = false;
        if (Shaders.configNormalMap) {
            nArray2 = ShadersTex.readImageAndMipmaps(textureMap, string + "_n", n, n2, nArray.length, bl3, -8421377);
            GlStateManager.bindTexture(multiTexID.norm);
            TextureUtil.uploadTextureMipmap(nArray2, n, n2, n3, n4, bl, bl2);
        }
        if (Shaders.configSpecularMap) {
            nArray2 = ShadersTex.readImageAndMipmaps(textureMap, string + "_s", n, n2, nArray.length, bl3, 0);
            GlStateManager.bindTexture(multiTexID.spec);
            TextureUtil.uploadTextureMipmap(nArray2, n, n2, n3, n4, bl, bl2);
        }
        GlStateManager.bindTexture(multiTexID.base);
    }

    public static int[][] readImageAndMipmaps(TextureMap textureMap, String string, int n, int n2, int n3, boolean bl, int n4) {
        MultiTexID multiTexID = textureMap.multiTex;
        Object object = new int[n3][];
        int[] nArray = new int[n * n2];
        object[0] = nArray;
        boolean bl2 = false;
        BufferedImage bufferedImage = ShadersTex.readImage(textureMap.completeResourceLocation(new ResourceLocation(string)));
        if (bufferedImage != null) {
            int n5 = bufferedImage.getWidth();
            int n6 = bufferedImage.getHeight();
            if (n5 + (bl ? 16 : 0) == n) {
                bl2 = true;
                bufferedImage.getRGB(0, 0, n5, n5, nArray, 0, n5);
            }
        }
        if (!bl2) {
            Arrays.fill(nArray, n4);
        }
        GlStateManager.bindTexture(multiTexID.spec);
        object = ShadersTex.genMipmapsSimple(((int[][])object).length - 1, n, object);
        return object;
    }

    public static BufferedImage readImage(ResourceLocation resourceLocation) {
        try {
            if (!Config.hasResource(resourceLocation)) {
                return null;
            }
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                return null;
            }
            BufferedImage bufferedImage = ImageIO.read(inputStream2);
            inputStream2.close();
            return bufferedImage;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static int[][] genMipmapsSimple(int n, int n2, int[][] nArray) {
        for (int i = 1; i <= n; ++i) {
            if (nArray[i] != null) continue;
            int n3 = n2 >> i;
            int n4 = n3 * 2;
            int[] nArray2 = nArray[i - 1];
            nArray[i] = new int[n3 * n3];
            int[] nArray3 = nArray[i];
            for (int j = 0; j < n3; ++j) {
                for (int k = 0; k < n3; ++k) {
                    int n5 = j * 2 * n4 + k * 2;
                    nArray3[j * n3 + k] = ShadersTex.blend4Simple(nArray2[n5], nArray2[n5 + 1], nArray2[n5 + n4], nArray2[n5 + n4 + 1]);
                }
            }
        }
        return nArray;
    }

    public static void uploadTexSub1(int[][] nArray, int n, int n2, int n3, int n4, int n5) {
        int n6 = n * n2;
        IntBuffer intBuffer = ShadersTex.getIntBuffer(n6);
        int n7 = nArray.length;
        int n8 = 0;
        int n9 = n;
        int n10 = n2;
        int n11 = n3;
        int n12 = n4;
        while (n9 > 0 && n10 > 0 && n8 < n7) {
            int n13 = n9 * n10;
            int[] nArray2 = nArray[n8];
            intBuffer.clear();
            if (nArray2.length >= n13 * (n5 + 1)) {
                intBuffer.put(nArray2, n13 * n5, n13).position(0).limit(n13);
                GL11.glTexSubImage2D(3553, n8, n11, n12, n9, n10, 32993, 33639, intBuffer);
            }
            n9 >>= 1;
            n10 >>= 1;
            n11 >>= 1;
            n12 >>= 1;
            ++n8;
        }
        intBuffer.clear();
    }

    public static int blend4Alpha(int n, int n2, int n3, int n4) {
        int n5;
        int n6 = n >>> 24 & 0xFF;
        int n7 = n2 >>> 24 & 0xFF;
        int n8 = n3 >>> 24 & 0xFF;
        int n9 = n4 >>> 24 & 0xFF;
        int n10 = n6 + n7 + n8 + n9;
        int n11 = (n10 + 2) / 4;
        if (n10 != 0) {
            n5 = n10;
        } else {
            n5 = 4;
            n6 = 1;
            n7 = 1;
            n8 = 1;
            n9 = 1;
        }
        int n12 = (n5 + 1) / 2;
        int n13 = n11 << 24 | ((n >>> 16 & 0xFF) * n6 + (n2 >>> 16 & 0xFF) * n7 + (n3 >>> 16 & 0xFF) * n8 + (n4 >>> 16 & 0xFF) * n9 + n12) / n5 << 16 | ((n >>> 8 & 0xFF) * n6 + (n2 >>> 8 & 0xFF) * n7 + (n3 >>> 8 & 0xFF) * n8 + (n4 >>> 8 & 0xFF) * n9 + n12) / n5 << 8 | ((n >>> 0 & 0xFF) * n6 + (n2 >>> 0 & 0xFF) * n7 + (n3 >>> 0 & 0xFF) * n8 + (n4 >>> 0 & 0xFF) * n9 + n12) / n5 << 0;
        return n13;
    }

    public static int blend4Simple(int n, int n2, int n3, int n4) {
        int n5 = ((n >>> 24 & 0xFF) + (n2 >>> 24 & 0xFF) + (n3 >>> 24 & 0xFF) + (n4 >>> 24 & 0xFF) + 2) / 4 << 24 | ((n >>> 16 & 0xFF) + (n2 >>> 16 & 0xFF) + (n3 >>> 16 & 0xFF) + (n4 >>> 16 & 0xFF) + 2) / 4 << 16 | ((n >>> 8 & 0xFF) + (n2 >>> 8 & 0xFF) + (n3 >>> 8 & 0xFF) + (n4 >>> 8 & 0xFF) + 2) / 4 << 8 | ((n >>> 0 & 0xFF) + (n2 >>> 0 & 0xFF) + (n3 >>> 0 & 0xFF) + (n4 >>> 0 & 0xFF) + 2) / 4 << 0;
        return n5;
    }

    public static void genMipmapAlpha(int[] nArray, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        Math.min(n2, n3);
        int n7 = n;
        int n8 = n2;
        int n9 = n3;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        while (n8 > 1 && n9 > 1) {
            n10 = n7 + n8 * n9;
            n11 = n8 / 2;
            n12 = n9 / 2;
            for (n6 = 0; n6 < n12; ++n6) {
                n5 = n10 + n6 * n11;
                n4 = n7 + n6 * 2 * n8;
                for (int i = 0; i < n11; ++i) {
                    nArray[n5 + i] = ShadersTex.blend4Alpha(nArray[n4 + i * 2], nArray[n4 + i * 2 + 1], nArray[n4 + n8 + i * 2], nArray[n4 + n8 + i * 2 + 1]);
                }
            }
            ++n13;
            n8 = n11;
            n9 = n12;
            n7 = n10;
        }
        while (n13 > 0) {
            n8 = n2 >> --n13;
            n9 = n3 >> n13;
            n6 = n7 = n10 - n8 * n9;
            for (n5 = 0; n5 < n9; ++n5) {
                for (n4 = 0; n4 < n8; ++n4) {
                    if (nArray[n6] == 0) {
                        nArray[n6] = nArray[n10 + n5 / 2 * n11 + n4 / 2] & 0xFFFFFF;
                    }
                    ++n6;
                }
            }
            n10 = n7;
            n11 = n8;
        }
    }

    public static void genMipmapSimple(int[] nArray, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        Math.min(n2, n3);
        int n7 = n;
        int n8 = n2;
        int n9 = n3;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        while (n8 > 1 && n9 > 1) {
            n10 = n7 + n8 * n9;
            n11 = n8 / 2;
            n12 = n9 / 2;
            for (n6 = 0; n6 < n12; ++n6) {
                n5 = n10 + n6 * n11;
                n4 = n7 + n6 * 2 * n8;
                for (int i = 0; i < n11; ++i) {
                    nArray[n5 + i] = ShadersTex.blend4Simple(nArray[n4 + i * 2], nArray[n4 + i * 2 + 1], nArray[n4 + n8 + i * 2], nArray[n4 + n8 + i * 2 + 1]);
                }
            }
            ++n13;
            n8 = n11;
            n9 = n12;
            n7 = n10;
        }
        while (n13 > 0) {
            n8 = n2 >> --n13;
            n9 = n3 >> n13;
            n6 = n7 = n10 - n8 * n9;
            for (n5 = 0; n5 < n9; ++n5) {
                for (n4 = 0; n4 < n8; ++n4) {
                    if (nArray[n6] == 0) {
                        nArray[n6] = nArray[n10 + n5 / 2 * n11 + n4 / 2] & 0xFFFFFF;
                    }
                    ++n6;
                }
            }
            n10 = n7;
            n11 = n8;
        }
    }

    public static boolean isSemiTransparent(int[] nArray, int n, int n2) {
        int n3 = n * n2;
        if (nArray[0] >>> 24 == 255 && nArray[n3 - 1] == 0) {
            return true;
        }
        for (int i = 0; i < n3; ++i) {
            int n4 = nArray[i] >>> 24;
            if (n4 == 0 || n4 == 255) continue;
            return true;
        }
        return false;
    }

    public static void updateSubTex1(int[] nArray, int n, int n2, int n3, int n4) {
        int n5 = 0;
        int n6 = n;
        int n7 = n2;
        int n8 = n3;
        int n9 = n4;
        while (n6 > 0 && n7 > 0) {
            GL11.glCopyTexSubImage2D(3553, n5, n8, n9, 0, 0, n6, n7);
            ++n5;
            n6 /= 2;
            n7 /= 2;
            n8 /= 2;
            n9 /= 2;
        }
    }

    public static void setupTexture(MultiTexID multiTexID, int[] nArray, int n, int n2, boolean bl, boolean bl2) {
        int n3 = bl ? 9729 : 9728;
        int n4 = bl2 ? 33071 : 10497;
        int n5 = n * n2;
        IntBuffer intBuffer = ShadersTex.getIntBuffer(n5);
        intBuffer.clear();
        intBuffer.put(nArray, 0, n5).position(0).limit(n5);
        GlStateManager.bindTexture(multiTexID.base);
        GL11.glTexImage2D(3553, 0, 6408, n, n2, 0, 32993, 33639, intBuffer);
        GL11.glTexParameteri(3553, 10241, n3);
        GL11.glTexParameteri(3553, 10240, n3);
        GL11.glTexParameteri(3553, 10242, n4);
        GL11.glTexParameteri(3553, 10243, n4);
        intBuffer.put(nArray, n5, n5).position(0).limit(n5);
        GlStateManager.bindTexture(multiTexID.norm);
        GL11.glTexImage2D(3553, 0, 6408, n, n2, 0, 32993, 33639, intBuffer);
        GL11.glTexParameteri(3553, 10241, n3);
        GL11.glTexParameteri(3553, 10240, n3);
        GL11.glTexParameteri(3553, 10242, n4);
        GL11.glTexParameteri(3553, 10243, n4);
        intBuffer.put(nArray, n5 * 2, n5).position(0).limit(n5);
        GlStateManager.bindTexture(multiTexID.spec);
        GL11.glTexImage2D(3553, 0, 6408, n, n2, 0, 32993, 33639, intBuffer);
        GL11.glTexParameteri(3553, 10241, n3);
        GL11.glTexParameteri(3553, 10240, n3);
        GL11.glTexParameteri(3553, 10242, n4);
        GL11.glTexParameteri(3553, 10243, n4);
        GlStateManager.bindTexture(multiTexID.base);
    }

    public static void updateSubImage(MultiTexID multiTexID, int[] nArray, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5 = n * n2;
        IntBuffer intBuffer = ShadersTex.getIntBuffer(n5);
        intBuffer.clear();
        intBuffer.put(nArray, 0, n5);
        intBuffer.position(0).limit(n5);
        GlStateManager.bindTexture(multiTexID.base);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, n3, n4, n, n2, 32993, 33639, intBuffer);
        if (nArray.length == n5 * 3) {
            intBuffer.clear();
            intBuffer.put(nArray, n5, n5).position(0);
            intBuffer.position(0).limit(n5);
        }
        GlStateManager.bindTexture(multiTexID.norm);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, n3, n4, n, n2, 32993, 33639, intBuffer);
        if (nArray.length == n5 * 3) {
            intBuffer.clear();
            intBuffer.put(nArray, n5 * 2, n5);
            intBuffer.position(0).limit(n5);
        }
        GlStateManager.bindTexture(multiTexID.spec);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, n3, n4, n, n2, 32993, 33639, intBuffer);
        GlStateManager.setActiveTexture(33984);
    }

    public static ResourceLocation getNSMapLocation(ResourceLocation resourceLocation, String string) {
        if (resourceLocation == null) {
            return null;
        }
        String string2 = resourceLocation.getResourcePath();
        String[] stringArray = string2.split(".png");
        String string3 = stringArray[0];
        return new ResourceLocation(resourceLocation.getResourceDomain(), string3 + "_" + string + ".png");
    }

    public static void loadNSMap(IResourceManager iResourceManager, ResourceLocation resourceLocation, int n, int n2, int[] nArray) {
        if (Shaders.configNormalMap) {
            ShadersTex.loadNSMap1(iResourceManager, ShadersTex.getNSMapLocation(resourceLocation, "n"), n, n2, nArray, n * n2, -8421377);
        }
        if (Shaders.configSpecularMap) {
            ShadersTex.loadNSMap1(iResourceManager, ShadersTex.getNSMapLocation(resourceLocation, "s"), n, n2, nArray, n * n2 * 2, 0);
        }
    }

    private static void loadNSMap1(IResourceManager iResourceManager, ResourceLocation resourceLocation, int n, int n2, int[] nArray, int n3, int n4) {
        if (!ShadersTex.loadNSMapFile(iResourceManager, resourceLocation, n, n2, nArray, n3)) {
            Arrays.fill(nArray, n3, n3 + n * n2, n4);
        }
    }

    private static boolean loadNSMapFile(IResourceManager iResourceManager, ResourceLocation resourceLocation, int n, int n2, int[] nArray, int n3) {
        if (resourceLocation == null) {
            return false;
        }
        try {
            IResource iResource = iResourceManager.getResource(resourceLocation);
            BufferedImage bufferedImage = ImageIO.read(iResource.getInputStream());
            if (bufferedImage == null) {
                return false;
            }
            if (bufferedImage.getWidth() == n && bufferedImage.getHeight() == n2) {
                bufferedImage.getRGB(0, 0, n, n2, nArray, n3, n);
                return true;
            }
            return false;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static int loadSimpleTexture(int n, BufferedImage bufferedImage, boolean bl, boolean bl2, IResourceManager iResourceManager, ResourceLocation resourceLocation, MultiTexID multiTexID) {
        int n2 = bufferedImage.getWidth();
        int n3 = bufferedImage.getHeight();
        int n4 = n2 * n3;
        int[] nArray = ShadersTex.getIntArray(n4 * 3);
        bufferedImage.getRGB(0, 0, n2, n3, nArray, 0, n2);
        ShadersTex.loadNSMap(iResourceManager, resourceLocation, n2, n3, nArray);
        ShadersTex.setupTexture(multiTexID, nArray, n2, n3, bl, bl2);
        return n;
    }

    public static void mergeImage(int[] nArray, int n, int n2, int n3) {
    }

    public static int blendColor(int n, int n2, int n3) {
        int n4 = 255 - n3;
        return ((n >>> 24 & 0xFF) * n3 + (n2 >>> 24 & 0xFF) * n4) / 255 << 24 | ((n >>> 16 & 0xFF) * n3 + (n2 >>> 16 & 0xFF) * n4) / 255 << 16 | ((n >>> 8 & 0xFF) * n3 + (n2 >>> 8 & 0xFF) * n4) / 255 << 8 | ((n >>> 0 & 0xFF) * n3 + (n2 >>> 0 & 0xFF) * n4) / 255 << 0;
    }

    public static void loadLayeredTexture(LayeredTexture layeredTexture, IResourceManager iResourceManager, List list) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int[] nArray = null;
        for (Object e : list) {
            String string = (String)e;
            if (string == null) continue;
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string);
                InputStream inputStream2 = iResourceManager.getResource(resourceLocation).getInputStream();
                BufferedImage bufferedImage = ImageIO.read(inputStream2);
                if (n3 == 0) {
                    n = bufferedImage.getWidth();
                    n2 = bufferedImage.getHeight();
                    n3 = n * n2;
                    nArray = ShadersTex.createAIntImage(n3, 0);
                }
                int[] nArray2 = ShadersTex.getIntArray(n3 * 3);
                bufferedImage.getRGB(0, 0, n, n2, nArray2, 0, n);
                ShadersTex.loadNSMap(iResourceManager, resourceLocation, n, n2, nArray2);
                for (int i = 0; i < n3; ++i) {
                    int n4 = nArray2[i] >>> 24 & 0xFF;
                    nArray[n3 * 0 + i] = ShadersTex.blendColor(nArray2[n3 * 0 + i], nArray[n3 * 0 + i], n4);
                    nArray[n3 * 1 + i] = ShadersTex.blendColor(nArray2[n3 * 1 + i], nArray[n3 * 1 + i], n4);
                    nArray[n3 * 2 + i] = ShadersTex.blendColor(nArray2[n3 * 2 + i], nArray[n3 * 2 + i], n4);
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        ShadersTex.setupTexture(layeredTexture.getMultiTexID(), nArray, n, n2, false, false);
    }

    public static void updateTextureMinMagFilter() {
        TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        ITextureObject iTextureObject = textureManager.getTexture(TextureMap.locationBlocksTexture);
        if (iTextureObject != null) {
            MultiTexID multiTexID = iTextureObject.getMultiTexID();
            GlStateManager.bindTexture(multiTexID.base);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilB]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilB]);
            GlStateManager.bindTexture(multiTexID.norm);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilN]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilN]);
            GlStateManager.bindTexture(multiTexID.spec);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilS]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilS]);
            GlStateManager.bindTexture(0);
        }
    }

    public static int[][] getFrameTexData(int[][] nArray, int n, int n2, int n3) {
        int n4 = nArray.length;
        int[][] nArrayArray = new int[n4][];
        for (int i = 0; i < n4; ++i) {
            int[] nArray2 = nArray[i];
            if (nArray2 == null) continue;
            int n5 = (n >> i) * (n2 >> i);
            int[] nArray3 = new int[n5 * 3];
            nArrayArray[i] = nArray3;
            int n6 = nArray2.length / 3;
            int n7 = n5 * n3;
            int n8 = 0;
            System.arraycopy(nArray2, n7, nArray3, n8, n5);
            System.arraycopy(nArray2, n7 += n6, nArray3, n8 += n5, n5);
            System.arraycopy(nArray2, n7 += n6, nArray3, n8 += n5, n5);
        }
        return nArrayArray;
    }

    public static int[][] prepareAF(TextureAtlasSprite textureAtlasSprite, int[][] nArray, int n, int n2) {
        boolean bl = true;
        return nArray;
    }

    public static void fixTransparentColor(TextureAtlasSprite textureAtlasSprite, int[] nArray) {
    }
}

