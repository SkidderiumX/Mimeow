/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.Mipmaps;
import net.optifine.reflect.Reflector;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import x.oc131b84b22f;

public class TextureUtil {
    private static final Logger logger = LogManager.getLogger();
    private static final int MAX_UPLOAD_PIXELS = 0x400000;
    private static IntBuffer dataBuffer = GLAllocation.createDirectIntBuffer(65536);
    public static final DynamicTexture missingTexture = new DynamicTexture(16, 16);
    public static final int[] missingTextureData = missingTexture.getTextureData();
    private static final int[] mipmapBuffer;
    private static int[] dataArray;

    public static int glGenTextures() {
        return GlStateManager.generateTexture();
    }

    public static void deleteTexture(int n) {
        GlStateManager.deleteTexture(n);
    }

    public static int uploadTextureImage(int n, BufferedImage bufferedImage) {
        return TextureUtil.uploadTextureImageAllocate(n, bufferedImage, false, false);
    }

    public static void uploadTexture(int n, int[] nArray, int n2, int n3) {
        TextureUtil.bindTexture(n);
        TextureUtil.uploadTextureSub(0, nArray, n2, n3, 0, 0, false, false, false);
    }

    public static int[][] generateMipmapData(int n, int n2, int[][] nArray) {
        int[][] nArrayArray = new int[n + 1][];
        nArrayArray[0] = nArray[0];
        if (n > 0) {
            int n3;
            boolean bl = false;
            for (n3 = 0; n3 < nArray[0].length; ++n3) {
                if (nArray[0][n3] >> 24 != 0) continue;
                bl = true;
                break;
            }
            for (n3 = 1; n3 <= n; ++n3) {
                if (nArray[n3] != null) {
                    nArrayArray[n3] = nArray[n3];
                    continue;
                }
                int[] nArray2 = nArrayArray[n3 - 1];
                int[] nArray3 = new int[nArray2.length >> 2];
                int n4 = n2 >> n3;
                int n5 = nArray3.length / n4;
                int n6 = n4 << 1;
                for (int i = 0; i < n4; ++i) {
                    for (int j = 0; j < n5; ++j) {
                        int n7 = 2 * (i + j * n6);
                        nArray3[i + j * n4] = TextureUtil.blendColors(nArray2[n7 + 0], nArray2[n7 + 1], nArray2[n7 + 0 + n6], nArray2[n7 + 1 + n6], bl);
                    }
                }
                nArrayArray[n3] = nArray3;
            }
        }
        return nArrayArray;
    }

    private static int blendColors(int n, int n2, int n3, int n4, boolean bl) {
        return Mipmaps.alphaBlend(n, n2, n3, n4);
    }

    private static int blendColorComponent(int n, int n2, int n3, int n4, int n5) {
        float f = (float)Math.pow((float)(n >> n5 & 0xFF) / 255.0f, 2.2);
        float f2 = (float)Math.pow((float)(n2 >> n5 & 0xFF) / 255.0f, 2.2);
        float f3 = (float)Math.pow((float)(n3 >> n5 & 0xFF) / 255.0f, 2.2);
        float f4 = (float)Math.pow((float)(n4 >> n5 & 0xFF) / 255.0f, 2.2);
        float f5 = (float)Math.pow((double)(f + f2 + f3 + f4) * 0.25, 0.45454545454545453);
        return (int)((double)f5 * 255.0);
    }

    public static void uploadTextureMipmap(int[][] nArray, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        for (int i = 0; i < nArray.length; ++i) {
            int[] nArray2 = nArray[i];
            TextureUtil.uploadTextureSub(i, nArray2, n >> i, n2 >> i, n3 >> i, n4 >> i, bl, bl2, nArray.length > 1);
        }
    }

    private static void uploadTextureSub(int n, int[] nArray, int n2, int n3, int n4, int n5, boolean bl, boolean bl2, boolean bl3) {
        int n6;
        TextureUtil.ensureUploadCapacity((long)n2 * (long)n3);
        int n7 = dataBuffer.capacity() / n2;
        TextureUtil.setTextureBlurMipmap(bl, bl3);
        TextureUtil.setTextureClamped(bl2);
        for (int i = 0; i < n2 * n3; i += n2 * n6) {
            int n8 = i / n2;
            n6 = Math.min(n7, n3 - n8);
            int n9 = n2 * n6;
            TextureUtil.copyToBufferPos(nArray, i, n9);
            if (oc131b84b22f.\u03c1(3553, n, n4, n5 + n8, n2, n6, 32993, 33639, dataBuffer)) continue;
            GL11.glTexSubImage2D(3553, n, n4, n5 + n8, n2, n6, 32993, 33639, dataBuffer);
        }
    }

    public static int uploadTextureImageAllocate(int n, BufferedImage bufferedImage, boolean bl, boolean bl2) {
        TextureUtil.allocateTexture(n, bufferedImage.getWidth(), bufferedImage.getHeight());
        return TextureUtil.uploadTextureImageSub(n, bufferedImage, 0, 0, bl, bl2);
    }

    public static void allocateTexture(int n, int n2, int n3) {
        TextureUtil.allocateTextureImpl(n, 0, n2, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void allocateTextureImpl(int n, int n2, int n3, int n4) {
        Class clazz = TextureUtil.class;
        if (Reflector.SplashScreen.exists()) {
            clazz = Reflector.SplashScreen.getTargetClass();
        }
        Class clazz2 = clazz;
        synchronized (clazz2) {
            TextureUtil.deleteTexture(n);
            TextureUtil.bindTexture(n);
        }
        if (n2 >= 0) {
            GL11.glTexParameteri(3553, 33085, n2);
            GL11.glTexParameterf(3553, 33082, 0.0f);
            GL11.glTexParameterf(3553, 33083, n2);
            GL11.glTexParameterf(3553, 34049, 0.0f);
        }
        for (int i = 0; i <= n2; ++i) {
            GL11.glTexImage2D(3553, i, 6408, n3 >> i, n4 >> i, 0, 32993, 33639, (IntBuffer)null);
        }
    }

    public static int uploadTextureImageSub(int n, BufferedImage bufferedImage, int n2, int n3, boolean bl, boolean bl2) {
        TextureUtil.bindTexture(n);
        TextureUtil.uploadTextureImageSubImpl(bufferedImage, n2, n3, bl, bl2);
        return n;
    }

    private static void uploadTextureImageSubImpl(BufferedImage bufferedImage, int n, int n2, boolean bl, boolean bl2) {
        int n3 = bufferedImage.getWidth();
        int n4 = bufferedImage.getHeight();
        TextureUtil.ensureUploadCapacity((long)n3 * (long)n4);
        int n5 = dataBuffer.capacity() / n3;
        if (dataArray.length < dataBuffer.capacity()) {
            dataArray = new int[dataBuffer.capacity()];
        }
        int[] nArray = dataArray;
        TextureUtil.setTextureBlurred(bl);
        TextureUtil.setTextureClamped(bl2);
        for (int i = 0; i < n3 * n4; i += n3 * n5) {
            int n6 = i / n3;
            int n7 = Math.min(n5, n4 - n6);
            int n8 = n3 * n7;
            bufferedImage.getRGB(0, n6, n3, n7, nArray, 0, n3);
            TextureUtil.copyToBuffer(nArray, n8);
            GL11.glTexSubImage2D(3553, 0, n, n2 + n6, n3, n7, 32993, 33639, dataBuffer);
        }
    }

    private static void ensureUploadCapacity(long l) {
        int n = (int)Math.min(0x400000L, l);
        if (n > dataBuffer.capacity()) {
            dataBuffer = GLAllocation.createDirectIntBuffer(n);
        }
    }

    public static void setTextureClamped(boolean bl) {
        if (bl) {
            GL11.glTexParameteri(3553, 10242, 33071);
            GL11.glTexParameteri(3553, 10243, 33071);
        } else {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
    }

    private static void setTextureBlurred(boolean bl) {
        TextureUtil.setTextureBlurMipmap(bl, false);
    }

    public static void setTextureBlurMipmap(boolean bl, boolean bl2) {
        if (bl) {
            GL11.glTexParameteri(3553, 10241, bl2 ? 9987 : 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        } else {
            int n = Config.getMipmapType();
            GL11.glTexParameteri(3553, 10241, bl2 ? n : 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
    }

    private static void copyToBuffer(int[] nArray, int n) {
        TextureUtil.copyToBufferPos(nArray, 0, n);
    }

    private static void copyToBufferPos(int[] nArray, int n, int n2) {
        int[] nArray2 = nArray;
        if (Minecraft.getMinecraft().gameSettings.anaglyph) {
            nArray2 = TextureUtil.updateAnaglyph(nArray);
        }
        dataBuffer.clear();
        dataBuffer.put(nArray2, n, n2);
        dataBuffer.position(0).limit(n2);
    }

    static void bindTexture(int n) {
        GlStateManager.bindTexture(n);
    }

    public static int[] readImageData(IResourceManager iResourceManager, ResourceLocation resourceLocation) throws IOException {
        BufferedImage bufferedImage = TextureUtil.readBufferedImage(iResourceManager.getResource(resourceLocation).getInputStream());
        if (bufferedImage == null) {
            return null;
        }
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = new int[n * n2];
        bufferedImage.getRGB(0, 0, n, n2, nArray, 0, n);
        return nArray;
    }

    public static BufferedImage readBufferedImage(InputStream inputStream2) throws IOException {
        BufferedImage bufferedImage;
        if (inputStream2 == null) {
            return null;
        }
        try {
            bufferedImage = ImageIO.read(inputStream2);
        }
        finally {
            IOUtils.closeQuietly(inputStream2);
        }
        return bufferedImage;
    }

    public static int[] updateAnaglyph(int[] nArray) {
        int[] nArray2 = new int[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            nArray2[i] = TextureUtil.anaglyphColor(nArray[i]);
        }
        return nArray2;
    }

    public static int anaglyphColor(int n) {
        int n2 = n >> 24 & 0xFF;
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        int n6 = (n3 * 30 + n4 * 59 + n5 * 11) / 100;
        int n7 = (n3 * 30 + n4 * 70) / 100;
        int n8 = (n3 * 30 + n5 * 70) / 100;
        return n2 << 24 | n6 << 16 | n7 << 8 | n8;
    }

    public static void processPixelValues(int[] nArray, int n, int n2) {
        int[] nArray2 = new int[n];
        int n3 = n2 / 2;
        for (int i = 0; i < n3; ++i) {
            System.arraycopy(nArray, i * n, nArray2, 0, n);
            System.arraycopy(nArray, (n2 - 1 - i) * n, nArray, i * n, n);
            System.arraycopy(nArray2, 0, nArray, (n2 - 1 - i) * n, n);
        }
    }

    static {
        dataArray = new int[0];
        int n = -16777216;
        int n2 = -524040;
        int[] nArray = new int[]{-524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040};
        int[] nArray2 = new int[]{-16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216};
        int n3 = nArray.length;
        for (int i = 0; i < 16; ++i) {
            System.arraycopy(i < n3 ? nArray : nArray2, 0, missingTextureData, 16 * i, n3);
            System.arraycopy(i < n3 ? nArray2 : nArray, 0, missingTextureData, 16 * i + n3, n3);
        }
        missingTexture.updateDynamicTexture();
        mipmapBuffer = new int[4];
    }
}

