/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import x.A;
import x.oc06b9308b3c;
import x.oc1aae86a55a;
import x.oc1dbdddc1e9;
import x.oc1e7298eef6;
import x.oc50c8413885;
import x.oc6928adbdaa;
import x.oc840d7c857b;
import x.ocac488f5520;
import x.ocad69c23202;
import x.ocbc6f0988cd;
import x.occ22af137a2;

public class ocd94f97a9f3 {
    private static Consumer<ocac488f5520> \u047d = ocd94f97a9f3::\u03cb;
    private static DoubleSupplier \u0174 = () -> (double)System.nanoTime() * 1.0E-9;

    private ocd94f97a9f3() {
    }

    public static double \u0128() {
        return \u0174.getAsDouble();
    }

    public static DoubleSupplier \u04e2(DoubleSupplier doubleSupplier) {
        DoubleSupplier doubleSupplier2 = \u0174;
        \u0174 = Objects.requireNonNull(doubleSupplier);
        return doubleSupplier2;
    }

    public static Consumer<ocac488f5520> \u02a3(Consumer<ocac488f5520> consumer) {
        Consumer<ocac488f5520> consumer2 = \u047d;
        \u047d = Objects.requireNonNull(consumer);
        return consumer2;
    }

    public static void \u01e3() {
        oc1e7298eef6.\u0133();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void \u03cb(ocac488f5520 ocac488f55202) {
        try (occ22af137a2 occ22af137a22 = occ22af137a2.\u0158();){
            GL11.glPushMatrix();
            oc50c8413885 oc50c84138852 = ocd94f97a9f3.\u0568();
            A a = new A();
            oc1aae86a55a oc1aae86a55a2 = new oc1aae86a55a();
            int n = 0;
            float f = 1.0f;
            float f2 = Minecraft.getMinecraft().getRenderItem().zLevel;
            ArrayDeque<Float> arrayDeque = new ArrayDeque<Float>();
            try {
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(0x4630B6B9 ^ 0x4630B5BB, 0x4630B6B8 ^ 0x4630B5BB, 1, 0x4630B6B8 ^ 0x4630B5BB);
                GlStateManager.disableTexture2D();
                for (oc6928adbdaa oc6928adbdaa2 : ocac488f55202.t()) {
                    int n2;
                    float[] fArray = oc6928adbdaa2.\u0459;
                    if (oc6928adbdaa2.\u03a0.equals("push")) {
                        GL11.glPushMatrix();
                        oc50c84138852.\u015b();
                        ++n;
                        arrayDeque.push(Float.valueOf(f));
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("pop")) {
                        if (n <= 0) {
                            throw new IllegalStateException("Unbalanced drawing matrix");
                        }
                        GL11.glPopMatrix();
                        oc50c84138852.popMark();
                        --n;
                        f = ((Float)arrayDeque.pop()).floatValue();
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("translate")) {
                        GL11.glTranslatef(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB]);
                        oc50c84138852.\u0108(fArray[0], fArray[1]);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("scale")) {
                        GL11.glScalef(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB]);
                        oc50c84138852.\u04f2(fArray[0], fArray[1]);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("rotate")) {
                        GL11.glRotatef(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB], fArray[0x4630B5B8 ^ 0x4630B5BB]);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("color")) {
                        GlStateManager.color(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB], fArray[0x4630B5B8 ^ 0x4630B5BB] * f);
                        oc50c84138852.\u0556(fArray);
                        oc50c84138852.\u02b7(fArray);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("opacity")) {
                        oc50c84138852.\u048c().X = f = fArray[0];
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("screenClip")) {
                        GL11.glEnable(0x4630B9AA ^ 0x4630B5BB);
                        GL11.glScissor((int)fArray[0], Minecraft.getMinecraft().displayHeight - (int)(fArray[1] + fArray[0x4630B5B8 ^ 0x4630B5BB]), Math.max(0, (int)fArray[0x4630B5B9 ^ 0x4630B5BB]), Math.max(0, (int)fArray[0x4630B5B8 ^ 0x4630B5BB]));
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("unclip")) {
                        GL11.glDisable(0x4630B9AA ^ 0x4630B5BB);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("gradient")) {
                        float[] fArray2 = new float[0x4630B5BF ^ 0x4630B5BB];
                        fArray2[0] = fArray[0x4630B5BF ^ 0x4630B5BB];
                        fArray2[1] = fArray[0x4630B5BE ^ 0x4630B5BB];
                        fArray2[0x4630B5B9 ^ 0x4630B5BB] = fArray[0x4630B5BD ^ 0x4630B5BB];
                        fArray2[0x4630B5B8 ^ 0x4630B5BB] = fArray[0x4630B5BC ^ 0x4630B5BB];
                        float[] fArray3 = new float[0x4630B5BF ^ 0x4630B5BB];
                        fArray3[0] = fArray[0x4630B5B3 ^ 0x4630B5BB];
                        fArray3[1] = fArray[0x4630B5B2 ^ 0x4630B5BB];
                        fArray3[0x4630B5B9 ^ 0x4630B5BB] = fArray[0x4630B5B1 ^ 0x4630B5BB];
                        fArray3[0x4630B5B8 ^ 0x4630B5BB] = fArray[0x4630B5B0 ^ 0x4630B5BB];
                        oc06b9308b3c oc06b9308b3c2 = oc50c8413885.\u02a6(fArray[0], fArray[1], fArray[0] + fArray[0x4630B5B9 ^ 0x4630B5BB], fArray[1], fArray2, fArray3);
                        oc50c84138852.\u01fb(oc06b9308b3c2);
                        ocd94f97a9f3.\u00e6(oc50c84138852, new ocbc6f0988cd(0.25f, 0.01f, 1.0f).\u0224(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB], fArray[0x4630B5B8 ^ 0x4630B5BB]), false, oc1aae86a55a2, a);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("lineWidth")) {
                        GL11.glLineWidth(fArray[0]);
                        oc50c84138852.\u048c().\u0229 = fArray[0];
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("enable")) {
                        ocd94f97a9f3.i((int)fArray[0], true);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("disable")) {
                        ocd94f97a9f3.i((int)fArray[0], false);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("vertices2") && oc6928adbdaa2.\u04f8 == Boolean.TRUE) {
                        float[] fArray4 = new float[0x4630B5BD ^ 0x4630B5BB];
                        fArray4[0] = 0.0f;
                        fArray4[1] = fArray[1];
                        fArray4[0x4630B5B9 ^ 0x4630B5BB] = fArray[0x4630B5B9 ^ 0x4630B5BB];
                        fArray4[0x4630B5B8 ^ 0x4630B5BB] = 1.0f;
                        fArray4[0x4630B5BF ^ 0x4630B5BB] = fArray[0x4630B5B8 ^ 0x4630B5BB];
                        fArray4[0x4630B5BE ^ 0x4630B5BB] = fArray[0x4630B5BF ^ 0x4630B5BB];
                        ocd94f97a9f3.\u00e6(oc50c84138852, new ocbc6f0988cd(0.25f, 0.01f, 1.0f).\u048e(fArray4), true, oc1aae86a55a2, a);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.startsWith("vertices")) {
                        int n3 = oc6928adbdaa2.\u03a0.equals("vertices2") ? 0x4630B5B9 ^ 0x4630B5BB : 0x4630B5B8 ^ 0x4630B5BB;
                        GL11.glBegin((int)fArray[0]);
                        try {
                            for (n2 = 1; n2 < fArray.length; n2 += n3) {
                                GL11.glVertex3f(fArray[n2], fArray[n2 + 1], n3 == (0x4630B5B8 ^ 0x4630B5BB) ? fArray[n2 + (0x4630B5B9 ^ 0x4630B5BB)] : 0.0f);
                            }
                            continue;
                        }
                        finally {
                            GL11.glEnd();
                            continue;
                        }
                    }
                    if (oc6928adbdaa2.\u03a0.equals("roundedRect") || oc6928adbdaa2.\u03a0.equals("roundedStroke")) {
                        ocd94f97a9f3.\u00e6(oc50c84138852, new ocbc6f0988cd(0.25f, 0.01f, 1.0f).\u0225(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB], fArray[0x4630B5B8 ^ 0x4630B5BB], fArray[0x4630B5BF ^ 0x4630B5BB], fArray[0x4630B5BF ^ 0x4630B5BB], fArray[0x4630B5BF ^ 0x4630B5BB], fArray[0x4630B5BF ^ 0x4630B5BB]), oc6928adbdaa2.\u03a0.equals("roundedStroke"), oc1aae86a55a2, a);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("roundedRectVarying")) {
                        ocd94f97a9f3.\u00e6(oc50c84138852, new ocbc6f0988cd(0.25f, 0.01f, 1.0f).\u0225(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB], fArray[0x4630B5B8 ^ 0x4630B5BB], fArray[0x4630B5BF ^ 0x4630B5BB], fArray[0x4630B5BE ^ 0x4630B5BB], fArray[0x4630B5BD ^ 0x4630B5BB], fArray[0x4630B5BC ^ 0x4630B5BB]), false, oc1aae86a55a2, a);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("circle")) {
                        ocd94f97a9f3.\u00e6(oc50c84138852, new ocbc6f0988cd(0.25f, 0.01f, 1.0f).\u022b(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB], fArray[0x4630B5B9 ^ 0x4630B5BB]), false, oc1aae86a55a2, a);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("circleStroke")) {
                        ocd94f97a9f3.\u00e6(oc50c84138852, new ocbc6f0988cd(0.25f, 0.01f, 1.0f).\u022b(fArray[0], fArray[1], fArray[0x4630B5B9 ^ 0x4630B5BB], fArray[0x4630B5B9 ^ 0x4630B5BB]), true, oc1aae86a55a2, a);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("pillGradient")) {
                        ocd94f97a9f3.\u0154(oc50c84138852.\u048c().\u01f9, fArray, f);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("itemDepth")) {
                        Minecraft.getMinecraft().getRenderItem().zLevel = fArray[0];
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("text") && oc6928adbdaa2.\u04f8 instanceof ocad69c23202) {
                        oc1e7298eef6.\u03d5((ocad69c23202)oc6928adbdaa2.\u04f8, Float.floatToRawIntBits(fArray[0x4630B5B9 ^ 0x4630B5BB]), f);
                        continue;
                    }
                    if (oc6928adbdaa2.\u03a0.equals("text")) {
                        GlStateManager.enableTexture2D();
                        GL11.glPushMatrix();
                        try {
                            float f3 = fArray[0x4630B5BF ^ 0x4630B5BB] / (float)Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT;
                            GL11.glTranslatef(fArray[0], fArray[1], 0.0f);
                            GL11.glScalef(f3, f3, 1.0f);
                            n2 = Float.floatToRawIntBits(fArray[0x4630B5B9 ^ 0x4630B5BB]);
                            int n4 = (int)((float)(n2 >>> (0x4630B5A3 ^ 0x4630B5BB)) * f);
                            Minecraft.getMinecraft().fontRendererObj.drawString((String)oc6928adbdaa2.\u04f8, 0.0f, 0.0f, n4 << (0x4630B5A3 ^ 0x4630B5BB) | n2 & (0x46CF4A44 ^ 0x4630B5BB), fArray[0x4630B5B8 ^ 0x4630B5BB] != 0.0f);
                            continue;
                        }
                        finally {
                            GL11.glPopMatrix();
                            GlStateManager.disableTexture2D();
                            continue;
                        }
                    }
                    if (!oc6928adbdaa2.\u03a0.equals("item")) continue;
                    GlStateManager.enableTexture2D();
                    RenderHelper.enableGUIStandardItemLighting();
                    try {
                        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI((ItemStack)oc6928adbdaa2.\u04f8, (int)fArray[0], (int)fArray[1]);
                        Minecraft.getMinecraft().getRenderItem().renderItemOverlays(Minecraft.getMinecraft().fontRendererObj, (ItemStack)oc6928adbdaa2.\u04f8, (int)fArray[0], (int)fArray[1]);
                    }
                    finally {
                        RenderHelper.disableStandardItemLighting();
                        GlStateManager.disableTexture2D();
                    }
                }
            }
            finally {
                Minecraft.getMinecraft().getRenderItem().zLevel = f2;
                while (n-- > 0) {
                    GL11.glPopMatrix();
                }
                GL11.glPopMatrix();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void \u0154(float[] fArray, float[] fArray2, float f) {
        float f2 = fArray2[0];
        float f3 = fArray2[1];
        float f4 = fArray2[0x990EB1ED ^ 0x990EB1EF];
        float f5 = fArray2[0x990EB1EC ^ 0x990EB1EF];
        float f6 = Math.max(0.0f, Math.min(fArray2[0x990EB1EB ^ 0x990EB1EF], Math.min(f5, f4) * 0.5f));
        int n = (fArray2.length - (0x990EB1EA ^ 0x990EB1EF)) / (0x990EB1EB ^ 0x990EB1EF);
        if (n >= 1 && !(f4 <= 0.0f) && !(f5 <= 0.0f)) {
            float f7;
            int n2;
            TreeSet<Float> treeSet = new TreeSet<Float>();
            int n3 = Math.max(0x990EB1EB ^ 0x990EB1EF, (int)Math.ceil(f6 * 2.0f));
            for (n2 = 0; n2 <= n3; ++n2) {
                f7 = f6 - f6 * (float)Math.cos(1.5707963267948966 * (double)n2 / (double)n3);
                treeSet.add(Float.valueOf(f2 + f7));
                treeSet.add(Float.valueOf(f2 + f4 - f7));
            }
            for (n2 = 0; n2 < n; ++n2) {
                treeSet.add(Float.valueOf(f2 + (n == 1 ? 0.0f : f4 * (float)n2 / (float)(n - 1))));
            }
            float f8 = f3 + f5 * 0.5f;
            f7 = f5 * 0.5f - f6;
            float[] fArray3 = new float[0x990EB1EB ^ 0x990EB1EF];
            GL11.glShadeModel(0x990EACEE ^ 0x990EB1EF);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glBegin(0x990EB1EA ^ 0x990EB1EF);
            try {
                Iterator iterator2 = treeSet.iterator();
                while (iterator2.hasNext()) {
                    float f9 = ((Float)iterator2.next()).floatValue();
                    float f10 = f9 < f2 + f6 ? f2 + f6 - f9 : (f9 > f2 + f4 - f6 ? f9 - (f2 + f4 - f6) : 0.0f);
                    float f11 = f7 + (float)Math.sqrt(Math.max(0.0f, f6 * f6 - f10 * f10));
                    if (n == 1) {
                        System.arraycopy(fArray2, 0x990EB1EA ^ 0x990EB1EF, fArray3, 0, 0x990EB1EB ^ 0x990EB1EF);
                    } else {
                        float f12 = Math.max(0.0f, Math.min(1.0f, (f9 - f2) / f4)) * (float)(n - 1);
                        int n4 = Math.min(n - (0x990EB1ED ^ 0x990EB1EF), (int)f12);
                        float f13 = f12 - (float)n4;
                        for (int i = 0; i < (0x990EB1EB ^ 0x990EB1EF); ++i) {
                            fArray3[i] = fArray2[(0x990EB1EA ^ 0x990EB1EF) + n4 * (0x990EB1EB ^ 0x990EB1EF) + i] + (fArray2[(0x990EB1EA ^ 0x990EB1EF) + (n4 + 1) * (0x990EB1EB ^ 0x990EB1EF) + i] - fArray2[(0x990EB1EA ^ 0x990EB1EF) + n4 * (0x990EB1EB ^ 0x990EB1EF) + i]) * f13;
                        }
                    }
                    GL11.glColor4f(fArray3[0], fArray3[1], fArray3[0x990EB1ED ^ 0x990EB1EF], fArray3[0x990EB1EC ^ 0x990EB1EF] * f);
                    ocd94f97a9f3.\u01eb(fArray, f9, f8 - f11);
                    ocd94f97a9f3.\u01eb(fArray, f9, f8 + f11);
                }
            }
            finally {
                GL11.glEnd();
                GL11.glPopMatrix();
            }
        }
    }

    private static void \u01eb(float[] fArray, float f, float f2) {
        GL11.glVertex2f(fArray[0] * f + fArray[0xD2F8FAD1 ^ 0xD2F8FAD3] * f2 + fArray[0xD2F8FAD7 ^ 0xD2F8FAD3], fArray[1] * f + fArray[0xD2F8FAD0 ^ 0xD2F8FAD3] * f2 + fArray[0xD2F8FAD6 ^ 0xD2F8FAD3]);
    }

    private static void i(int n, boolean bl) {
        switch (n) {
            case 2884: {
                if (bl) {
                    GlStateManager.enableCull();
                    break;
                }
                GlStateManager.disableCull();
                break;
            }
            case 2896: {
                if (bl) {
                    GlStateManager.enableLighting();
                    break;
                }
                GlStateManager.disableLighting();
                break;
            }
            case 2929: {
                if (bl) {
                    GlStateManager.enableDepth();
                    break;
                }
                GlStateManager.disableDepth();
                break;
            }
            case 3008: {
                if (bl) {
                    GlStateManager.enableAlpha();
                    break;
                }
                GlStateManager.disableAlpha();
                break;
            }
            case 3042: {
                if (bl) {
                    GlStateManager.enableBlend();
                    break;
                }
                GlStateManager.disableBlend();
                break;
            }
            case 3553: {
                if (bl) {
                    GlStateManager.enableTexture2D();
                    break;
                }
                GlStateManager.disableTexture2D();
                break;
            }
            default: {
                if (bl) {
                    GL11.glEnable(n);
                    break;
                }
                GL11.glDisable(n);
            }
        }
    }

    public static oc50c8413885 \u0568() {
        oc840d7c857b oc840d7c857b2 = new oc840d7c857b();
        oc840d7c857b2.\u01f9[0x3C4BA785 ^ 0x3C4BA786] = 1.0f;
        oc840d7c857b2.\u01f9[0] = 1.0f;
        oc840d7c857b2.X = 1.0f;
        oc840d7c857b2.\u0229 = 1.0f;
        oc840d7c857b2.\u010c = 10.0f;
        oc840d7c857b2.\u0403 = 0;
        oc840d7c857b2.\u04e1 = 1;
        oc840d7c857b2.\u0256 = 1;
        oc840d7c857b2.\u029a[1] = -1.0f;
        oc840d7c857b2.\u029a[0] = -1.0f;
        oc840d7c857b2.\u03f2[0] = 0x3C4BA484 ^ 0x3C4BA786;
        oc840d7c857b2.\u03f2[0x3C4BA784 ^ 0x3C4BA786] = 1;
        int n = 0x3C4BA485 ^ 0x3C4BA786;
        oc840d7c857b2.\u03f2[0x3C4BA785 ^ 0x3C4BA786] = n;
        oc840d7c857b2.\u03f2[1] = n;
        return new oc50c8413885(oc840d7c857b2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void \u00e6(oc50c8413885 oc50c84138852, ocbc6f0988cd ocbc6f0988cd2, boolean bl, oc1dbdddc1e9 oc1dbdddc1e92, A a) {
        ocbc6f0988cd2.\u04ab(oc50c84138852.\u048c().\u01f9);
        GL11.glPushMatrix();
        try {
            GL11.glLoadIdentity();
            if (bl) {
                oc50c84138852.\u0235(ocbc6f0988cd2, oc1dbdddc1e92, a, true);
            } else {
                oc50c84138852.\u0196(ocbc6f0988cd2, oc1dbdddc1e92, a, true);
            }
        }
        finally {
            GL11.glPopMatrix();
        }
    }
}

