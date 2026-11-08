/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.IReloadableResourceManager;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import x.oc03814b0e1a;
import x.oc293826be15;
import x.oc6b92d7f083;
import x.oc9bcf1497a7;
import x.oca952cab2bf;
import x.ocad69c23202;
import x.ocae3bb6ecc0;
import x.occ22af137a2;

public class oc1e7298eef6 {
    private static final float[] \u0272;
    private static oc293826be15 \u019a;
    private static oc293826be15 \u037c;
    private static boolean \u0389;
    private static final Map<Integer, Integer> \u010a;
    private static boolean \u015a;
    private static oc293826be15 \u0206;
    private static oc293826be15 \u02a6;
    private static final Map<Integer, Integer> \u01e7;

    static int \u011f() {
        return oc293826be15.\u0398++;
    }

    private static oc293826be15 w() {
        return oc1e7298eef6.\u0552(0);
    }

    public static oc6b92d7f083 \u04a9() {
        return new oc6b92d7f083();
    }

    private static oc293826be15 \u0552(int n) {
        oc293826be15 oc293826be152;
        if (\u015a) {
            oc293826be15 oc293826be153;
            oc293826be15 oc293826be154 = oc293826be153 = n == 1 ? \u02a6 : \u0206;
            if (oc293826be153 == null) {
                oc293826be153 = oca952cab2bf.\u028c(n);
                if (n == 1) {
                    \u02a6 = oc293826be153;
                } else {
                    \u0206 = oc293826be153;
                }
            }
            return oc293826be153;
        }
        oc293826be15 oc293826be155 = oc293826be152 = n == 1 ? \u037c : \u019a;
        if (oc293826be152 != null && oc293826be152.\u011b != null && !oc293826be152.\u011b.\u01c7()) {
            oc1e7298eef6.\u0133();
            oc293826be152 = null;
        }
        if (oc293826be152 == null) {
            Minecraft minecraft = Minecraft.getMinecraft();
            if (!\u0389 && minecraft.getResourceManager() instanceof IReloadableResourceManager) {
                \u0389 = true;
                ((IReloadableResourceManager)minecraft.getResourceManager()).registerReloadListener(iResourceManager -> oc1e7298eef6.\u0133());
            }
            try {
                oc03814b0e1a oc03814b0e1a2 = new oc03814b0e1a(minecraft, n == 1);
                int[] nArray = new int[0xB3A53B4 ^ 0xB3A52B4];
                Arrays.fill(nArray, -1);
                ocae3bb6ecc0 ocae3bb6ecc02 = new ocae3bb6ecc0(null, nArray, 0.8888889f, -0.11111111f, 1.0f);
                oc293826be152 = new oc293826be15(ocae3bb6ecc02, oc03814b0e1a2, 0xB3A50B4 ^ 0xB3A52B4, 0xB3A53B4 ^ 0xB3A52B4);
                if (n == 1) {
                    \u037c = oc293826be152;
                } else {
                    \u019a = oc293826be152;
                }
            }
            catch (IOException iOException) {
                throw new IllegalStateException("Cannot load game font resources", iOException);
            }
        }
        return oc293826be152;
    }

    public static oc293826be15 \u0493(oc293826be15 oc293826be152) {
        oc293826be15 oc293826be153 = \u019a;
        \u019a = Objects.requireNonNull(oc293826be152);
        \u037c = oc293826be152;
        return oc293826be153;
    }

    public static void \u0389(oc293826be15 oc293826be152) {
        \u019a = oc293826be152;
        \u037c = null;
    }

    public static void \u054a(oc293826be15 oc293826be152) {
        \u02a6 = oc293826be152;
        \u0206 = oc293826be152;
    }

    public static float \u0569(String string, float f, float f2, float f3, int n, float[] fArray) {
        return oc1e7298eef6.w().\u02e3(string, f, f2, f3, n, fArray);
    }

    public static ocad69c23202 \u01a3(String string, float f, float f2, float f3, int n, float[] fArray) {
        return oc1e7298eef6.w().\u00ba(string, f, f2, f3, n, fArray);
    }

    public static ocad69c23202 \u0532(String string, float f, float f2, float f3, int n, float[] fArray, int n2) {
        return oc1e7298eef6.\u0552(n2).\u00ba(string, f, f2, f3, n, fArray);
    }

    public static float \u0240(String string, int n, float f) {
        return oc1e7298eef6.\u0552(n).\u02e3(string, 0.0f, 0.0f, f, 0x3B326051 ^ 0x3B326058, null);
    }

    public static void \u03d5(ocad69c23202 ocad69c232022, int n, float f) {
        if (occ22af137a2.\u03bb()) {
            oc1e7298eef6.\u016f(ocad69c232022, n, f);
        } else {
            try (occ22af137a2 occ22af137a22 = occ22af137a2.\u0158();){
                oc1e7298eef6.\u016f(ocad69c232022, n, f);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void \u016f(ocad69c23202 ocad69c232022, int n, float f) {
        GlStateManager.enableTexture2D();
        GlStateManager.disableAlpha();
        GL11.glShadeModel(0x2832659 ^ 0x2833B58);
        GL11.glTexEnvi(0x2831858 ^ 0x2833B58, 0x2831958 ^ 0x2833B58, 0x2831A58 ^ 0x2833B58);
        GlStateManager.color((float)(n >>> (0x2833B48 ^ 0x2833B58) & (0x2833BA7 ^ 0x2833B58)) / 255.0f, (float)(n >>> (0x2833B50 ^ 0x2833B58) & (0x2833BA7 ^ 0x2833B58)) / 255.0f, (float)(n & (0x2833BA7 ^ 0x2833B58)) / 255.0f, (float)(n >>> (0x2833B40 ^ 0x2833B58)) / 255.0f * f);
        for (oc9bcf1497a7 oc9bcf1497a72 : ocad69c232022.\u0439) {
            Integer n2 = \u010a.get(oc9bcf1497a72.\u03e9);
            if (n2 == null) {
                n2 = GL11.glGenTextures();
                \u010a.put(oc9bcf1497a72.\u03e9, n2);
            }
            GlStateManager.bindTexture(n2);
            Integer n3 = \u01e7.get(oc9bcf1497a72.\u03e9);
            if (n3 == null || n3 != oc9bcf1497a72.\u00f9[0]) {
                GL11.glTexParameteri(0x28336B9 ^ 0x2833B58, 0x2831359 ^ 0x2833B58, 0x2831D59 ^ 0x2833B58);
                GL11.glTexParameteri(0x28336B9 ^ 0x2833B58, 0x2831358 ^ 0x2833B58, 0x2831D59 ^ 0x2833B58);
                GL11.glTexParameteri(0x28336B9 ^ 0x2833B58, 0x283135A ^ 0x2833B58, 0x2831258 ^ 0x2833B58);
                GL11.glTexParameteri(0x28336B9 ^ 0x2833B58, 0x283135B ^ 0x2833B58, 0x2831258 ^ 0x2833B58);
                ByteBuffer byteBuffer = BufferUtils.createByteBuffer(oc9bcf1497a72.\u03ee.length);
                ((Buffer)byteBuffer.put(oc9bcf1497a72.\u03ee)).flip();
                GL11.glPixelStorei(0x28337AD ^ 0x2833B58, 1);
                GL11.glTexImage2D(0x28336B9 ^ 0x2833B58, 0, 0x283225E ^ 0x2833B58, oc9bcf1497a72.\u0424, oc9bcf1497a72.\u0133, 0, 0x283225E ^ 0x2833B58, 0x2832F59 ^ 0x2833B58, byteBuffer);
                \u01e7.put(oc9bcf1497a72.\u03e9, oc9bcf1497a72.\u00f9[0]);
            }
            GL11.glBegin(0x2833B5C ^ 0x2833B58);
            try {
                for (float[] fArray : oc9bcf1497a72.\u0129) {
                    GL11.glTexCoord2f(fArray[0x2833B5A ^ 0x2833B58], fArray[0x2833B5B ^ 0x2833B58]);
                    GL11.glVertex2f(fArray[0], fArray[1]);
                }
            }
            finally {
                GL11.glEnd();
            }
        }
        GlStateManager.disableTexture2D();
    }

    public static void \u0133() {
        if (!\u010a.isEmpty() && Display.isCreated()) {
            try {
                for (int n : \u010a.values()) {
                    GlStateManager.deleteTexture(n);
                }
            }
            catch (Exception exception) {
                throw new IllegalStateException("Cannot release font textures", exception);
            }
            finally {
                \u010a.clear();
                \u01e7.clear();
                \u02a6 = null;
                \u0206 = null;
                \u037c = null;
                \u019a = null;
            }
        } else {
            \u010a.clear();
            \u01e7.clear();
            \u02a6 = null;
            \u0206 = null;
            \u037c = null;
            \u019a = null;
        }
    }

    private oc1e7298eef6() {
    }

    static {
        float[] fArray = new float[0x17A91D51 ^ 0x17A91D57];
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[0x17A91D55 ^ 0x17A91D57] = 0.0f;
        fArray[0x17A91D54 ^ 0x17A91D57] = 1.0f;
        fArray[0x17A91D53 ^ 0x17A91D57] = 0.0f;
        fArray[0x17A91D52 ^ 0x17A91D57] = 0.0f;
        \u0272 = fArray;
        \u010a = new HashMap<Integer, Integer>();
        \u01e7 = new HashMap<Integer, Integer>();
    }
}

