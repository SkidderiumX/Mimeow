/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.nanovg.NVGPaint;
import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.nanovg.NanoVGGL2;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import x.oc595c51c58f;
import x.oc6a43806f12;
import x.occ22af137a2;
import x.ocd2958dac48;

public class oc8aaacef5d6 {
    static final String \u04f3 = "productsans-medium";
    static final String \u0426 = "productsans-bold";
    static final String \u0187 = "materialicons-regular";
    static final String \u01a3 = "materialicons-outlined";
    private final Minecraft \u0242 = Minecraft.getMinecraft();
    private final List<ByteBuffer> \u00f2 = new ArrayList<ByteBuffer>();
    private final NVGColor \u0480 = NVGColor.create();
    private final NVGColor \u01b4 = NVGColor.create();
    private final NVGPaint \u04ca = NVGPaint.create();
    private final NVGPaint r = NVGPaint.create();
    private long \u0118;
    private Framebuffer \u0117;
    private Framebuffer \u021e;
    private oc595c51c58f \u0288;
    private int \u0576;
    private int \u04a2 = -1;
    private int \u0490;
    private int \u047c;
    private occ22af137a2 \u0108;
    private int \u0423;
    private int \u0112;
    private int \u050b;
    private int \u0376;
    private int \u02a0;
    private int \u0205;
    private boolean \u04a5;
    private float \u023e = 1.0f;
    private float \u011e;
    private float \u03c4;
    private float \u0395;
    private float \u03a3;

    oc8aaacef5d6() {
    }

    void \u0508(float f, float f2) {
        this.\u0108 = occ22af137a2.\u0158();
        this.\u0423 = GL11.glGetInteger(0xB502E63C ^ 0xB5026DB1);
        this.\u0112 = GL11.glGetInteger(0xB502E525 ^ 0xB5026DB1);
        this.\u050b = GL11.glGetInteger(0xB502E524 ^ 0xB5026DB1);
        this.\u0376 = GL11.glGetInteger(0xB502E117 ^ 0xB5026DB1);
        this.\u02a0 = GL11.glGetInteger(0xB502E116 ^ 0xB5026DB1);
        this.\u0205 = GL11.glGetInteger(0xB502E804 ^ 0xB5026DB1);
        try {
            this.\u0138();
            this.\u0279(f, f2);
            this.\u0242.getFramebuffer().bindFramebuffer(true);
            this.\u03ea();
            GL11.glStencilMask(0xB5026D4E ^ 0xB5026DB1);
            GL11.glClearStencil(0);
            GL11.glClear(0xB50269B1 ^ 0xB5026DB1);
            GL20.glUseProgram(0);
            GL13.glActiveTexture(0xB502E971 ^ 0xB5026DB1);
            NanoVG.nvgBeginFrame(this.\u0118, f, f2, (float)this.\u0242.displayWidth / f);
            this.\u04a5 = true;
            this.\u023e = 1.0f;
            this.\u03c4 = 0.0f;
            this.\u011e = 0.0f;
            this.\u0395 = f;
            this.\u03a3 = f2;
        }
        catch (Error | RuntimeException throwable) {
            this.\u0509();
            throw throwable;
        }
    }

    void \u0509() {
        try {
            if (this.\u04a5) {
                NanoVG.nvgEndFrame(this.\u0118);
            }
        }
        finally {
            this.\u04a5 = false;
            if (this.\u0108 != null) {
                GL20.glUseProgram(this.\u0423);
                GL30.glBindVertexArray(this.\u0205);
                GL15.glBindBuffer(0xF25BE5D8 ^ 0xF25B6D4A, this.\u0112);
                GL15.glBindBuffer(0xF25BE5D9 ^ 0xF25B6D4A, this.\u050b);
                GL30.glBindFramebuffer(0xF25BE00A ^ 0xF25B6D4A, this.\u0376);
                GL30.glBindRenderbuffer(0xF25BE00B ^ 0xF25B6D4A, this.\u02a0);
                this.\u0108.close();
                this.\u0108 = null;
            }
        }
    }

    private void \u0138() {
        if (this.\u0118 != 0L) {
            return;
        }
        this.\u0118 = NanoVGGL2.nvgCreate(0xE6F64646 ^ 0xE6F64645);
        if (this.\u0118 == 0L) {
            throw new IllegalStateException("Cannot initialize Miau renderer");
        }
        String[] stringArray = new String[0xE6F64641 ^ 0xE6F64645];
        stringArray[0] = "productsans-medium";
        stringArray[1] = "productsans-bold";
        stringArray[0xE6F64647 ^ 0xE6F64645] = "materialicons-regular";
        stringArray[0xE6F64646 ^ 0xE6F64645] = "materialicons-outlined";
        for (String string : stringArray) {
            try (InputStream inputStream2 = oc8aaacef5d6.class.getResourceAsStream("/assets/miau/fonts/clickgui/" + string + ".ttf");){
                if (inputStream2 == null) {
                    throw new IOException("Missing font " + string);
                }
                byte[] byArray = inputStream2.readAllBytes();
                ByteBuffer byteBuffer = BufferUtils.createByteBuffer(byArray.length);
                byteBuffer.put(byArray).flip();
                this.\u00f2.add(byteBuffer);
                if (NanoVG.nvgCreateFontMem(this.\u0118, string, byteBuffer, false) >= 0) continue;
                throw new IOException("Cannot load font " + string);
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }
        this.\u0288 = new oc595c51c58f("miau:shaders/clickgui/blur.frag", "miau:shaders/clickgui/blur.vert");
    }

    private void \u03ea() {
        Framebuffer framebuffer = this.\u0242.getFramebuffer();
        if (!OpenGlHelper.isFramebufferEnabled() || framebuffer.depthBuffer < 0) {
            return;
        }
        if (framebuffer.depthBuffer == this.\u04a2 && framebuffer.framebufferWidth == this.\u0490 && framebuffer.framebufferHeight == this.\u047c) {
            return;
        }
        GL30.glBindRenderbuffer(0x347B1397 ^ 0x347B9ED6, framebuffer.depthBuffer);
        GL30.glRenderbufferStorage(0x347B1397 ^ 0x347B9ED6, 0x347B1626 ^ 0x347B9ED6, framebuffer.framebufferWidth, framebuffer.framebufferHeight);
        GL30.glFramebufferRenderbuffer(0x347B1396 ^ 0x347B9ED6, 0x347B13D6 ^ 0x347B9ED6, 0x347B1397 ^ 0x347B9ED6, framebuffer.depthBuffer);
        GL30.glFramebufferRenderbuffer(0x347B1396 ^ 0x347B9ED6, 0x347B13F6 ^ 0x347B9ED6, 0x347B1397 ^ 0x347B9ED6, framebuffer.depthBuffer);
        if (GL30.glCheckFramebufferStatus(0x347B1396 ^ 0x347B9ED6) != (0x347B1203 ^ 0x347B9ED6)) {
            throw new IllegalStateException("Incomplete Miau framebuffer");
        }
        this.\u04a2 = framebuffer.depthBuffer;
        this.\u0490 = framebuffer.framebufferWidth;
        this.\u047c = framebuffer.framebufferHeight;
    }

    private void \u0279(float f, float f2) {
        float f3;
        if (!OpenGlHelper.isFramebufferEnabled()) {
            this.A();
            return;
        }
        if (this.\u0117 == null || this.\u0117.framebufferWidth != this.\u0242.displayWidth || this.\u0117.framebufferHeight != this.\u0242.displayHeight) {
            this.A();
            this.\u0117 = new Framebuffer(this.\u0242.displayWidth, this.\u0242.displayHeight, false);
            this.\u021e = new Framebuffer(this.\u0242.displayWidth, this.\u0242.displayHeight, false);
            this.\u0117.setFramebufferFilter(0x648B7D7 ^ 0x64891D6);
            this.\u021e.setFramebufferFilter(0x648B7D7 ^ 0x64891D6);
            this.\u0576 = NanoVGGL2.nvglCreateImageFromHandle(this.\u0118, this.\u021e.framebufferTexture, this.\u0242.displayWidth, this.\u0242.displayHeight, 0x64991DE ^ 0x64891D6);
        }
        int n = this.\u0242.getFramebuffer().framebufferTexture;
        float f4 = f3 = oc6a43806f12.\u04db == null ? 7.0f : (float)oc6a43806f12.\u04db.\u04c1();
        if (oc6a43806f12.\u040c != null && !oc6a43806f12.\u040c.\u01ed()) {
            f3 = 0.0f;
        }
        GL13.glActiveTexture(0x6481516 ^ 0x64891D6);
        GL11.glDisable(0x6489DC7 ^ 0x64891D6);
        GL11.glDisable(0x6489AA7 ^ 0x64891D6);
        GL11.glDisable(0x6489A16 ^ 0x64891D6);
        GL11.glDisable(0x6489A34 ^ 0x64891D6);
        GL11.glDepthMask(false);
        for (int i = 0; i < (0x64891D0 ^ 0x64891D6); ++i) {
            Framebuffer framebuffer = i % (0x64891D4 ^ 0x64891D6) == 0 ? this.\u0117 : this.\u021e;
            framebuffer.bindFramebuffer(true);
            this.\u0288.\u01f5();
            this.\u0288.\u048f("image", 0);
            float[] fArray = new float[0x64891D4 ^ 0x64891D6];
            fArray[0] = i % (0x64891D4 ^ 0x64891D6) == 0 ? 1.0f / (float)this.\u0242.displayWidth : 0.0f;
            fArray[1] = i % (0x64891D4 ^ 0x64891D6) == 0 ? 0.0f : 1.0f / (float)this.\u0242.displayHeight;
            this.\u0288.\u03c8("stepSize", fArray);
            this.\u0288.\u03c8("radius", f3 / (float)(1 << i / (0x64891D4 ^ 0x64891D6)));
            GL11.glBindTexture(0x6489C37 ^ 0x64891D6, n);
            GL11.glBegin(0x64891D1 ^ 0x64891D6);
            GL11.glTexCoord2f(0.0f, 0.0f);
            GL11.glVertex2f(-1.0f, -1.0f);
            GL11.glTexCoord2f(1.0f, 0.0f);
            GL11.glVertex2f(1.0f, -1.0f);
            GL11.glTexCoord2f(1.0f, 1.0f);
            GL11.glVertex2f(1.0f, 1.0f);
            GL11.glTexCoord2f(0.0f, 1.0f);
            GL11.glVertex2f(-1.0f, 1.0f);
            GL11.glEnd();
            n = framebuffer.framebufferTexture;
        }
        this.\u0288.\u0287();
    }

    void A() {
        if (this.\u0576 != 0) {
            NanoVG.nvgDeleteImage(this.\u0118, this.\u0576);
            this.\u0576 = 0;
        }
        if (this.\u0117 != null) {
            this.\u0117.deleteFramebuffer();
            this.\u021e.deleteFramebuffer();
            this.\u021e = null;
            this.\u0117 = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void \u023a(float f, float f2, float f3, float f4, Runnable runnable2) {
        NanoVG.nvgSave(this.\u0118);
        NanoVG.nvgIntersectScissor(this.\u0118, f, f2, Math.max(0.0f, f3), Math.max(0.0f, f4));
        try {
            runnable2.run();
        }
        finally {
            NanoVG.nvgRestore(this.\u0118);
        }
    }

    void \u0459(float f) {
        NanoVG.nvgGlobalAlpha(this.\u0118, this.\u023e * f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void \u04f1(float f, float f2, float f3, Runnable runnable2) {
        float f4 = this.\u023e;
        float f5 = this.\u011e;
        float f6 = this.\u03c4;
        NanoVG.nvgSave(this.\u0118);
        NanoVG.nvgTranslate(this.\u0118, f, f2);
        this.\u023e *= f3;
        this.\u011e += f;
        this.\u03c4 += f2;
        this.\u0459(1.0f);
        try {
            runnable2.run();
        }
        finally {
            this.\u023e = f4;
            this.\u011e = f5;
            this.\u03c4 = f6;
            NanoVG.nvgRestore(this.\u0118);
        }
    }

    void \u027e(float f, float f2, float f3, float f4, float f5, int n) {
        this.\u0145(f, f2, f3, f4, f5, f5, n);
    }

    void \u0145(float f, float f2, float f3, float f4, float f5, float f6, int n) {
        this.\u0172(f, f2, f3, f4, f5, f6);
        NanoVG.nvgFillColor(this.\u0118, oc8aaacef5d6.\u0510(this.\u0480, n));
        NanoVG.nvgFill(this.\u0118);
    }

    void \u0454(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.\u0576 == 0) {
            return;
        }
        this.\u0172(f, f2, f3, f4, f5, f6);
        NanoVG.nvgImagePattern(this.\u0118, -this.\u011e, -this.\u03c4, this.\u0395, this.\u03a3, 0.0f, this.\u0576, 1.0f, this.r);
        NanoVG.nvgFillPaint(this.\u0118, this.r);
        NanoVG.nvgFill(this.\u0118);
    }

    void \u0419(float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, boolean bl) {
        this.\u0172(f, f2, f3, f4, f5, f6);
        NanoVG.nvgLinearGradient(this.\u0118, f, f2, bl ? f : f + f3, bl ? f2 + f4 : f2, oc8aaacef5d6.\u0510(this.\u0480, n), oc8aaacef5d6.\u0510(this.\u01b4, n2), this.\u04ca);
        NanoVG.nvgFillPaint(this.\u0118, this.\u04ca);
        NanoVG.nvgFill(this.\u0118);
    }

    void \u04ce(float f, float f2, float f3, float f4, float f5, float f6, int n) {
        this.\u0172(f, f2, f3, f4, f5, f5);
        NanoVG.nvgStrokeColor(this.\u0118, oc8aaacef5d6.\u0510(this.\u0480, n));
        NanoVG.nvgStrokeWidth(this.\u0118, f6);
        NanoVG.nvgStroke(this.\u0118);
    }

    void \u0456(String string, String string2, float f, float f2, float f3, int n) {
        NanoVG.nvgFontFace(this.\u0118, string);
        NanoVG.nvgFontSize(this.\u0118, f3);
        NanoVG.nvgTextAlign(this.\u0118, 0xADE41BD2 ^ 0xADE41B93);
        NanoVG.nvgFillColor(this.\u0118, oc8aaacef5d6.\u0510(this.\u0480, n));
        NanoVG.nvgText(this.\u0118, f, f2, string2);
    }

    float \u01f1(String string, String string2, float f) {
        NanoVG.nvgFontFace(this.\u0118, string);
        NanoVG.nvgFontSize(this.\u0118, f);
        return NanoVG.nvgTextBounds(this.\u0118, 0.0f, 0.0f, (CharSequence)string2, (float[])null);
    }

    String \u0398(String string, String string2, float f, float f2) {
        int n;
        if (this.\u01f1(string, string2, f) <= f2) {
            return string2;
        }
        for (n = string2.length(); n > 0 && this.\u01f1(string, string2.substring(0, n) + "\u2026", f) > f2; --n) {
        }
        return string2.substring(0, n) + "\u2026";
    }

    void \u025e(float f, float f2, float f3, float f4, int n) {
        NanoVG.nvgSave(this.\u0118);
        NanoVG.nvgTranslate(this.\u0118, f, f2);
        NanoVG.nvgRotate(this.\u0118, f4 * (float)Math.PI);
        NanoVG.nvgFontFace(this.\u0118, "materialicons-regular");
        NanoVG.nvgFontSize(this.\u0118, f3);
        NanoVG.nvgTextAlign(this.\u0118, 0x848292E4 ^ 0x848292F6);
        NanoVG.nvgFillColor(this.\u0118, oc8aaacef5d6.\u0510(this.\u0480, n));
        NanoVG.nvgText(this.\u0118, 0.0f, 0.0f, "\ue5cf");
        NanoVG.nvgRestore(this.\u0118);
    }

    private void \u0172(float f, float f2, float f3, float f4, float f5, float f6) {
        NanoVG.nvgBeginPath(this.\u0118);
        NanoVG.nvgRoundedRectVarying(this.\u0118, f, f2, Math.max(0.0f, f3), Math.max(0.0f, f4), f5, f5, f6, f6);
    }

    private static NVGColor \u0510(NVGColor nVGColor, int n) {
        return nVGColor.r((float)(n >> (0x3882F1ED ^ 0x3882F1FD) & (0x3882F102 ^ 0x3882F1FD)) / 255.0f).g((float)(n >> (0x3882F1F5 ^ 0x3882F1FD) & (0x3882F102 ^ 0x3882F1FD)) / 255.0f).b((float)(n & (0x3882F102 ^ 0x3882F1FD)) / 255.0f).a((float)(n >>> (0x3882F1E5 ^ 0x3882F1FD)) / 255.0f);
    }

    static int \u0161(int n, float f) {
        return n & (0x7BDA80A3 ^ 0x7B257F5C) | Math.round(Math.max(0.0f, Math.min(1.0f, f)) * (float)(n >>> (0x7B257F44 ^ 0x7B257F5C))) << (0x7B257F44 ^ 0x7B257F5C);
    }

    static int z(int n, float f) {
        float f2 = 1.0f - f;
        return n & (0x4AA409D5 ^ 0xB5A409D5) | (int)((float)(n >> (0xB5A409C5 ^ 0xB5A409D5) & (0xB5A4092A ^ 0xB5A409D5)) * f2) << (0xB5A409C5 ^ 0xB5A409D5) | (int)((float)(n >> (0xB5A409DD ^ 0xB5A409D5) & (0xB5A4092A ^ 0xB5A409D5)) * f2) << (0xB5A409DD ^ 0xB5A409D5) | (int)((float)(n & (0xB5A4092A ^ 0xB5A409D5)) * f2);
    }

    static int \u012d() {
        return ocd2958dac48.\u0581(0.0);
    }

    static int \u0173() {
        return ocd2958dac48.\u018e(0.0);
    }
}

