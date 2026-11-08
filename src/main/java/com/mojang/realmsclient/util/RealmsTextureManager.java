/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.realms.RealmsScreen;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.ARBMultitexture;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GLContext;

public class RealmsTextureManager {
    private static Map<String, RealmsTexture> textures = new HashMap<String, RealmsTexture>();
    private static Boolean useMultitextureArb;
    public static int GL_TEXTURE0;

    public static void bindWorldTemplate(String string, String string2) {
        if (string2 == null) {
            RealmsScreen.bind("textures/gui/presets/isles.png");
            return;
        }
        int n = RealmsTextureManager.getTextureId(string, string2);
        GL11.glBindTexture(3553, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int getTextureId(String string, String string2) {
        int n;
        Object object;
        if (textures.containsKey(string)) {
            object = textures.get(string);
            if (((RealmsTexture)object).image.equals(string2)) {
                return ((RealmsTexture)object).textureId;
            }
            GL11.glDeleteTextures(((RealmsTexture)object).textureId);
            n = ((RealmsTexture)object).textureId;
        } else {
            n = GL11.glGenTextures();
        }
        object = null;
        int n2 = 0;
        int n3 = 0;
        try {
            BufferedImage bufferedImage;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new Base64().decode(string2));
            try {
                bufferedImage = ImageIO.read(byteArrayInputStream);
            }
            finally {
                IOUtils.closeQuietly(byteArrayInputStream);
            }
            n2 = bufferedImage.getWidth();
            n3 = bufferedImage.getHeight();
            int[] nArray = new int[n2 * n3];
            bufferedImage.getRGB(0, 0, n2, n3, nArray, 0, n2);
            object = ByteBuffer.allocateDirect(4 * n2 * n3).order(ByteOrder.nativeOrder()).asIntBuffer();
            ((IntBuffer)object).put(nArray);
            ((IntBuffer)object).flip();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (GL_TEXTURE0 == -1) {
            GL_TEXTURE0 = RealmsTextureManager.getUseMultiTextureArb() ? 33984 : 33984;
        }
        RealmsTextureManager.glActiveTexture(GL_TEXTURE0);
        GL11.glBindTexture(3553, n);
        GL11.glTexImage2D(3553, 0, 6408, n2, n3, 0, 32993, 33639, (IntBuffer)object);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10241, 9729);
        textures.put(string, new RealmsTexture(string2, n));
        return n;
    }

    public static void glActiveTexture(int n) {
        if (RealmsTextureManager.getUseMultiTextureArb()) {
            ARBMultitexture.glActiveTextureARB(n);
        } else {
            GL13.glActiveTexture(n);
        }
    }

    public static boolean getUseMultiTextureArb() {
        if (useMultitextureArb == null) {
            ContextCapabilities contextCapabilities = GLContext.getCapabilities();
            useMultitextureArb = contextCapabilities.GL_ARB_multitexture && !contextCapabilities.OpenGL13;
        }
        return useMultitextureArb;
    }

    static {
        GL_TEXTURE0 = -1;
    }

    public static class RealmsTexture {
        String image;
        int textureId;

        public RealmsTexture(String string, int n) {
            this.image = string;
            this.textureId = n;
        }
    }
}

