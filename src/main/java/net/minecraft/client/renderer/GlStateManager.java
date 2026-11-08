/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.src.Config;
import net.optifine.SmartAnimations;
import net.optifine.render.GlAlphaState;
import net.optifine.render.GlBlendState;
import net.optifine.shaders.Shaders;
import net.optifine.util.LockCounter;
import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;
import x.oc30aea91d28;

public class GlStateManager {
    private static AlphaState alphaState;
    private static BooleanState lightingState;
    private static BooleanState[] lightState;
    private static ColorMaterialState colorMaterialState;
    private static BlendState blendState;
    private static DepthState depthState;
    private static FogState fogState;
    private static CullState cullState;
    private static PolygonOffsetState polygonOffsetState;
    private static ColorLogicState colorLogicState;
    private static TexGenState texGenState;
    private static ClearState clearState;
    private static StencilState stencilState;
    private static BooleanState normalizeState;
    private static int activeTextureUnit;
    private static TextureState[] textureState;
    private static int activeShadeModel;
    private static BooleanState rescaleNormalState;
    private static ColorMask colorMaskState;
    private static Color colorState;
    public static boolean clearEnabled;
    private static LockCounter alphaLock;
    private static GlAlphaState alphaLockState;
    private static LockCounter blendLock;
    private static GlBlendState blendLockState;
    private static boolean creatingDisplayList;

    public static void pushAttrib() {
        GL11.glPushAttrib(8256);
    }

    public static void popAttrib() {
        GL11.glPopAttrib();
    }

    public static void disableAlpha() {
        if (alphaLock.isLocked()) {
            alphaLockState.setDisabled();
        } else {
            GlStateManager.alphaState.alphaTest.setDisabled();
        }
    }

    public static void enableAlpha() {
        if (alphaLock.isLocked()) {
            alphaLockState.setEnabled();
        } else {
            GlStateManager.alphaState.alphaTest.setEnabled();
        }
    }

    public static void alphaFunc(int n, float f) {
        if (alphaLock.isLocked()) {
            alphaLockState.setFuncRef(n, f);
        } else if (n != GlStateManager.alphaState.func || f != GlStateManager.alphaState.ref) {
            GlStateManager.alphaState.func = n;
            GlStateManager.alphaState.ref = f;
            GL11.glAlphaFunc(n, f);
        }
    }

    public static void enableLighting() {
        lightingState.setEnabled();
    }

    public static void disableLighting() {
        lightingState.setDisabled();
    }

    public static void enableLight(int n) {
        lightState[n].setEnabled();
    }

    public static void disableLight(int n) {
        lightState[n].setDisabled();
    }

    public static void enableColorMaterial() {
        GlStateManager.colorMaterialState.colorMaterial.setEnabled();
    }

    public static void disableColorMaterial() {
        GlStateManager.colorMaterialState.colorMaterial.setDisabled();
    }

    public static void colorMaterial(int n, int n2) {
        if (n != GlStateManager.colorMaterialState.face || n2 != GlStateManager.colorMaterialState.mode) {
            GlStateManager.colorMaterialState.face = n;
            GlStateManager.colorMaterialState.mode = n2;
            GL11.glColorMaterial(n, n2);
        }
    }

    public static void disableDepth() {
        GlStateManager.depthState.depthTest.setDisabled();
    }

    public static void enableDepth() {
        GlStateManager.depthState.depthTest.setEnabled();
    }

    public static void depthFunc(int n) {
        if (n != GlStateManager.depthState.depthFunc) {
            GlStateManager.depthState.depthFunc = n;
            GL11.glDepthFunc(n);
        }
    }

    public static void depthMask(boolean bl) {
        if (bl != GlStateManager.depthState.maskEnabled) {
            GlStateManager.depthState.maskEnabled = bl;
            GL11.glDepthMask(bl);
        }
    }

    public static void disableBlend() {
        if (blendLock.isLocked()) {
            blendLockState.setDisabled();
        } else {
            GlStateManager.blendState.blend.setDisabled();
        }
    }

    public static void enableBlend() {
        if (blendLock.isLocked()) {
            blendLockState.setEnabled();
        } else {
            GlStateManager.blendState.blend.setEnabled();
        }
    }

    public static void blendFunc(int n, int n2) {
        if (blendLock.isLocked()) {
            blendLockState.setFactors(n, n2);
        } else if (n != GlStateManager.blendState.srcFactor || n2 != GlStateManager.blendState.dstFactor || n != GlStateManager.blendState.srcFactorAlpha || n2 != GlStateManager.blendState.dstFactorAlpha) {
            GlStateManager.blendState.srcFactor = n;
            GlStateManager.blendState.dstFactor = n2;
            GlStateManager.blendState.srcFactorAlpha = n;
            GlStateManager.blendState.dstFactorAlpha = n2;
            if (Config.isShaders()) {
                Shaders.uniform_blendFunc.setValue(n, n2, n, n2);
            }
            GL11.glBlendFunc(n, n2);
        }
    }

    public static void tryBlendFuncSeparate(int n, int n2, int n3, int n4) {
        if (blendLock.isLocked()) {
            blendLockState.setFactors(n, n2, n3, n4);
        } else if (n != GlStateManager.blendState.srcFactor || n2 != GlStateManager.blendState.dstFactor || n3 != GlStateManager.blendState.srcFactorAlpha || n4 != GlStateManager.blendState.dstFactorAlpha) {
            GlStateManager.blendState.srcFactor = n;
            GlStateManager.blendState.dstFactor = n2;
            GlStateManager.blendState.srcFactorAlpha = n3;
            GlStateManager.blendState.dstFactorAlpha = n4;
            if (Config.isShaders()) {
                Shaders.uniform_blendFunc.setValue(n, n2, n3, n4);
            }
            OpenGlHelper.glBlendFunc(n, n2, n3, n4);
        }
    }

    public static void enableFog() {
        GlStateManager.fogState.fog.setEnabled();
    }

    public static void disableFog() {
        GlStateManager.fogState.fog.setDisabled();
    }

    public static void setFog(int n) {
        if (n != GlStateManager.fogState.mode) {
            GlStateManager.fogState.mode = n;
            GL11.glFogi(2917, n);
            if (Config.isShaders()) {
                Shaders.setFogMode(n);
            }
        }
    }

    public static void setFogDensity(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f != GlStateManager.fogState.density) {
            GlStateManager.fogState.density = f;
            GL11.glFogf(2914, f);
            if (Config.isShaders()) {
                Shaders.setFogDensity(f);
            }
        }
    }

    public static void setFogStart(float f) {
        if (f != GlStateManager.fogState.start) {
            GlStateManager.fogState.start = f;
            GL11.glFogf(2915, f);
        }
    }

    public static void setFogEnd(float f) {
        if (f != GlStateManager.fogState.end) {
            GlStateManager.fogState.end = f;
            GL11.glFogf(2916, f);
        }
    }

    public static void glFog(int n, FloatBuffer floatBuffer) {
        GL11.glFogfv(n, floatBuffer);
    }

    public static void glFogi(int n, int n2) {
        GL11.glFogi(n, n2);
    }

    public static void enableCull() {
        GlStateManager.cullState.cullFace.setEnabled();
    }

    public static void disableCull() {
        GlStateManager.cullState.cullFace.setDisabled();
    }

    public static void cullFace(int n) {
        if (n != GlStateManager.cullState.mode) {
            GlStateManager.cullState.mode = n;
            GL11.glCullFace(n);
        }
    }

    public static void enablePolygonOffset() {
        GlStateManager.polygonOffsetState.polygonOffsetFill.setEnabled();
    }

    public static void disablePolygonOffset() {
        GlStateManager.polygonOffsetState.polygonOffsetFill.setDisabled();
    }

    public static void doPolygonOffset(float f, float f2) {
        if (f != GlStateManager.polygonOffsetState.factor || f2 != GlStateManager.polygonOffsetState.units) {
            GlStateManager.polygonOffsetState.factor = f;
            GlStateManager.polygonOffsetState.units = f2;
            GL11.glPolygonOffset(f, f2);
        }
    }

    public static void enableColorLogic() {
        GlStateManager.colorLogicState.colorLogicOp.setEnabled();
    }

    public static void disableColorLogic() {
        GlStateManager.colorLogicState.colorLogicOp.setDisabled();
    }

    public static void colorLogicOp(int n) {
        if (n != GlStateManager.colorLogicState.opcode) {
            GlStateManager.colorLogicState.opcode = n;
            GL11.glLogicOp(n);
        }
    }

    public static void enableTexGenCoord(TexGen texGen) {
        GlStateManager.texGenCoord((TexGen)texGen).textureGen.setEnabled();
    }

    public static void disableTexGenCoord(TexGen texGen) {
        GlStateManager.texGenCoord((TexGen)texGen).textureGen.setDisabled();
    }

    public static void texGen(TexGen texGen, int n) {
        TexGenCoord texGenCoord = GlStateManager.texGenCoord(texGen);
        if (n != texGenCoord.param) {
            texGenCoord.param = n;
            GL11.glTexGeni(texGenCoord.coord, 9472, n);
        }
    }

    public static void texGen(TexGen texGen, int n, FloatBuffer floatBuffer) {
        GL11.glTexGenfv(GlStateManager.texGenCoord((TexGen)texGen).coord, n, floatBuffer);
    }

    private static TexGenCoord texGenCoord(TexGen texGen) {
        switch (texGen) {
            case S: {
                return GlStateManager.texGenState.s;
            }
            case T: {
                return GlStateManager.texGenState.t;
            }
            case R: {
                return GlStateManager.texGenState.r;
            }
            case Q: {
                return GlStateManager.texGenState.q;
            }
        }
        return GlStateManager.texGenState.s;
    }

    public static void setActiveTexture(int n) {
        if (activeTextureUnit != n - OpenGlHelper.defaultTexUnit) {
            activeTextureUnit = n - OpenGlHelper.defaultTexUnit;
            OpenGlHelper.setActiveTexture(n);
        }
    }

    public static void enableTexture2D() {
        GlStateManager.textureState[GlStateManager.activeTextureUnit].texture2DState.setEnabled();
    }

    public static void disableTexture2D() {
        GlStateManager.textureState[GlStateManager.activeTextureUnit].texture2DState.setDisabled();
    }

    public static int generateTexture() {
        return GL11.glGenTextures();
    }

    public static void deleteTexture(int n) {
        if (n != 0) {
            GL11.glDeleteTextures(n);
            for (TextureState textureState : GlStateManager.textureState) {
                if (textureState.textureName != n) continue;
                textureState.textureName = 0;
            }
        }
    }

    public static void bindTexture(int n) {
        if (n != GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName) {
            GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName = n;
            GL11.glBindTexture(3553, n);
            if (SmartAnimations.isActive()) {
                SmartAnimations.textureRendered(n);
            }
        }
    }

    public static void enableNormalize() {
        normalizeState.setEnabled();
    }

    public static void disableNormalize() {
        normalizeState.setDisabled();
    }

    public static void shadeModel(int n) {
        if (n != activeShadeModel) {
            activeShadeModel = n;
            GL11.glShadeModel(n);
        }
    }

    public static void enableRescaleNormal() {
        rescaleNormalState.setEnabled();
    }

    public static void disableRescaleNormal() {
        rescaleNormalState.setDisabled();
    }

    public static void viewport(int n, int n2, int n3, int n4) {
        GL11.glViewport(n, n2, n3, n4);
    }

    public static void colorMask(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl != GlStateManager.colorMaskState.red || bl2 != GlStateManager.colorMaskState.green || bl3 != GlStateManager.colorMaskState.blue || bl4 != GlStateManager.colorMaskState.alpha) {
            GlStateManager.colorMaskState.red = bl;
            GlStateManager.colorMaskState.green = bl2;
            GlStateManager.colorMaskState.blue = bl3;
            GlStateManager.colorMaskState.alpha = bl4;
            GL11.glColorMask(bl, bl2, bl3, bl4);
        }
    }

    public static void clearDepth(double d) {
        if (d != GlStateManager.clearState.depth) {
            GlStateManager.clearState.depth = d;
            GL11.glClearDepth(d);
        }
    }

    public static void clearColor(float f, float f2, float f3, float f4) {
        if (f != GlStateManager.clearState.color.red || f2 != GlStateManager.clearState.color.green || f3 != GlStateManager.clearState.color.blue || f4 != GlStateManager.clearState.color.alpha) {
            GlStateManager.clearState.color.red = f;
            GlStateManager.clearState.color.green = f2;
            GlStateManager.clearState.color.blue = f3;
            GlStateManager.clearState.color.alpha = f4;
            GL11.glClearColor(f, f2, f3, f4);
        }
    }

    public static void clear(int n) {
        if (clearEnabled) {
            GL11.glClear(n);
        }
    }

    public static void matrixMode(int n) {
        GL11.glMatrixMode(n);
    }

    public static void loadIdentity() {
        GL11.glLoadIdentity();
    }

    public static void pushMatrix() {
        GL11.glPushMatrix();
    }

    public static void popMatrix() {
        GL11.glPopMatrix();
    }

    public static void getFloat(int n, FloatBuffer floatBuffer) {
        oc30aea91d28.\u0132(n, floatBuffer);
    }

    public static void ortho(double d, double d2, double d3, double d4, double d5, double d6) {
        GL11.glOrtho(d, d2, d3, d4, d5, d6);
    }

    public static void rotate(float f, float f2, float f3, float f4) {
        GL11.glRotatef(f, f2, f3, f4);
    }

    public static void scale(float f, float f2, float f3) {
        GL11.glScalef(f, f2, f3);
    }

    public static void scale(double d, double d2, double d3) {
        GL11.glScaled(d, d2, d3);
    }

    public static void translate(float f, float f2, float f3) {
        GL11.glTranslatef(f, f2, f3);
    }

    public static void translate(double d, double d2, double d3) {
        GL11.glTranslated(d, d2, d3);
    }

    public static void multMatrix(FloatBuffer floatBuffer) {
        GL11.glMultMatrixf(floatBuffer);
    }

    public static void color(float f, float f2, float f3, float f4) {
        if (f != GlStateManager.colorState.red || f2 != GlStateManager.colorState.green || f3 != GlStateManager.colorState.blue || f4 != GlStateManager.colorState.alpha) {
            GlStateManager.colorState.red = f;
            GlStateManager.colorState.green = f2;
            GlStateManager.colorState.blue = f3;
            GlStateManager.colorState.alpha = f4;
            GL11.glColor4f(f, f2, f3, f4);
        }
    }

    public static void color(float f, float f2, float f3) {
        GlStateManager.color(f, f2, f3, 1.0f);
    }

    public static void resetColor() {
        GlStateManager.colorState.alpha = -1.0f;
        GlStateManager.colorState.blue = -1.0f;
        GlStateManager.colorState.green = -1.0f;
        GlStateManager.colorState.red = -1.0f;
    }

    public static void glNormalPointer(int n, int n2, ByteBuffer byteBuffer) {
        GL11.glNormalPointer(n, n2, byteBuffer);
    }

    public static void glTexCoordPointer(int n, int n2, int n3, int n4) {
        GL11.glTexCoordPointer(n, n2, n3, n4);
    }

    public static void glTexCoordPointer(int n, int n2, int n3, ByteBuffer byteBuffer) {
        GL11.glTexCoordPointer(n, n2, n3, byteBuffer);
    }

    public static void glVertexPointer(int n, int n2, int n3, int n4) {
        GL11.glVertexPointer(n, n2, n3, n4);
    }

    public static void glVertexPointer(int n, int n2, int n3, ByteBuffer byteBuffer) {
        GL11.glVertexPointer(n, n2, n3, byteBuffer);
    }

    public static void glColorPointer(int n, int n2, int n3, int n4) {
        GL11.glColorPointer(n, n2, n3, n4);
    }

    public static void glColorPointer(int n, int n2, int n3, ByteBuffer byteBuffer) {
        GL11.glColorPointer(n, n2, n3, byteBuffer);
    }

    public static void glDisableClientState(int n) {
        GL11.glDisableClientState(n);
    }

    public static void glEnableClientState(int n) {
        GL11.glEnableClientState(n);
    }

    public static void glBegin(int n) {
        GL11.glBegin(n);
    }

    public static void glEnd() {
        oc170ea29aae.\u0177();
    }

    public static void glDrawArrays(int n, int n2, int n3) {
        int n4;
        oc170ea29aae.\u03ad(n, n2, n3);
        if (Config.isShaders() && !creatingDisplayList && (n4 = Shaders.activeProgram.getCountInstances()) > 1) {
            for (int i = 1; i < n4; ++i) {
                Shaders.uniform_instanceId.setValue(i);
                oc170ea29aae.\u03ad(n, n2, n3);
            }
            Shaders.uniform_instanceId.setValue(0);
        }
    }

    public static void callList(int n) {
        int n2;
        oc170ea29aae.\u0146(n);
        if (Config.isShaders() && !creatingDisplayList && (n2 = Shaders.activeProgram.getCountInstances()) > 1) {
            for (int i = 1; i < n2; ++i) {
                Shaders.uniform_instanceId.setValue(i);
                oc170ea29aae.\u0146(n);
            }
            Shaders.uniform_instanceId.setValue(0);
        }
    }

    public static void callLists(IntBuffer intBuffer) {
        int n;
        oc170ea29aae.\u01b8(intBuffer);
        if (Config.isShaders() && !creatingDisplayList && (n = Shaders.activeProgram.getCountInstances()) > 1) {
            for (int i = 1; i < n; ++i) {
                Shaders.uniform_instanceId.setValue(i);
                oc170ea29aae.\u01b8(intBuffer);
            }
            Shaders.uniform_instanceId.setValue(0);
        }
    }

    public static void glDeleteLists(int n, int n2) {
        GL11.glDeleteLists(n, n2);
    }

    public static void glNewList(int n, int n2) {
        GL11.glNewList(n, n2);
        creatingDisplayList = true;
    }

    public static void glEndList() {
        GL11.glEndList();
        creatingDisplayList = false;
    }

    public static int glGetError() {
        return GL11.glGetError();
    }

    public static void glTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, IntBuffer intBuffer) {
        GL11.glTexImage2D(n, n2, n3, n4, n5, n6, n7, n8, intBuffer);
    }

    public static void glTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, IntBuffer intBuffer) {
        GL11.glTexSubImage2D(n, n2, n3, n4, n5, n6, n7, n8, intBuffer);
    }

    public static void glCopyTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        GL11.glCopyTexSubImage2D(n, n2, n3, n4, n5, n6, n7, n8);
    }

    public static void glGetTexImage(int n, int n2, int n3, int n4, IntBuffer intBuffer) {
        GL11.glGetTexImage(n, n2, n3, n4, intBuffer);
    }

    public static void glTexParameterf(int n, int n2, float f) {
        GL11.glTexParameterf(n, n2, f);
    }

    public static void glTexParameteri(int n, int n2, int n3) {
        GL11.glTexParameteri(n, n2, n3);
    }

    public static int glGetTexLevelParameteri(int n, int n2, int n3) {
        return GL11.glGetTexLevelParameteri(n, n2, n3);
    }

    public static int getActiveTextureUnit() {
        return OpenGlHelper.defaultTexUnit + activeTextureUnit;
    }

    public static void bindCurrentTexture() {
        GL11.glBindTexture(3553, GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName);
    }

    public static int getBoundTexture() {
        return GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName;
    }

    public static void checkBoundTexture() {
        if (Config.isMinecraftThread()) {
            int n = GL11.glGetInteger(34016);
            int n2 = GL11.glGetInteger(32873);
            int n3 = GlStateManager.getActiveTextureUnit();
            int n4 = GlStateManager.getBoundTexture();
            if (n4 > 0 && (n != n3 || n2 != n4)) {
                Config.dbg("checkTexture: act: " + n3 + ", glAct: " + n + ", tex: " + n4 + ", glTex: " + n2);
            }
        }
    }

    public static void deleteTextures(IntBuffer intBuffer) {
        intBuffer.rewind();
        while (intBuffer.position() < intBuffer.limit()) {
            int n = intBuffer.get();
            GlStateManager.deleteTexture(n);
        }
        intBuffer.rewind();
    }

    public static boolean isFogEnabled() {
        return GlStateManager.fogState.fog.currentState;
    }

    public static void setFogEnabled(boolean bl) {
        GlStateManager.fogState.fog.setState(bl);
    }

    public static void lockAlpha(GlAlphaState glAlphaState) {
        if (!alphaLock.isLocked()) {
            GlStateManager.getAlphaState(alphaLockState);
            GlStateManager.setAlphaState(glAlphaState);
            alphaLock.lock();
        }
    }

    public static void unlockAlpha() {
        if (alphaLock.unlock()) {
            GlStateManager.setAlphaState(alphaLockState);
        }
    }

    public static void getAlphaState(GlAlphaState glAlphaState) {
        if (alphaLock.isLocked()) {
            glAlphaState.setState(alphaLockState);
        } else {
            glAlphaState.setState(GlStateManager.alphaState.alphaTest.currentState, GlStateManager.alphaState.func, GlStateManager.alphaState.ref);
        }
    }

    public static void setAlphaState(GlAlphaState glAlphaState) {
        if (alphaLock.isLocked()) {
            alphaLockState.setState(glAlphaState);
        } else {
            GlStateManager.alphaState.alphaTest.setState(glAlphaState.isEnabled());
            GlStateManager.alphaFunc(glAlphaState.getFunc(), glAlphaState.getRef());
        }
    }

    public static void lockBlend(GlBlendState glBlendState) {
        if (!blendLock.isLocked()) {
            GlStateManager.getBlendState(blendLockState);
            GlStateManager.setBlendState(glBlendState);
            blendLock.lock();
        }
    }

    public static void unlockBlend() {
        if (blendLock.unlock()) {
            GlStateManager.setBlendState(blendLockState);
        }
    }

    public static void getBlendState(GlBlendState glBlendState) {
        if (blendLock.isLocked()) {
            glBlendState.setState(blendLockState);
        } else {
            glBlendState.setState(GlStateManager.blendState.blend.currentState, GlStateManager.blendState.srcFactor, GlStateManager.blendState.dstFactor, GlStateManager.blendState.srcFactorAlpha, GlStateManager.blendState.dstFactorAlpha);
        }
    }

    public static void setBlendState(GlBlendState glBlendState) {
        if (blendLock.isLocked()) {
            blendLockState.setState(glBlendState);
        } else {
            GlStateManager.blendState.blend.setState(glBlendState.isEnabled());
            if (!glBlendState.isSeparate()) {
                GlStateManager.blendFunc(glBlendState.getSrcFactor(), glBlendState.getDstFactor());
            } else {
                GlStateManager.tryBlendFuncSeparate(glBlendState.getSrcFactor(), glBlendState.getDstFactor(), glBlendState.getSrcFactorAlpha(), glBlendState.getDstFactorAlpha());
            }
        }
    }

    public static void glMultiDrawArrays(int n, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int n2;
        oc170ea29aae.\u0446(n, intBuffer, intBuffer2);
        if (Config.isShaders() && !creatingDisplayList && (n2 = Shaders.activeProgram.getCountInstances()) > 1) {
            for (int i = 1; i < n2; ++i) {
                Shaders.uniform_instanceId.setValue(i);
                oc170ea29aae.\u0446(n, intBuffer, intBuffer2);
            }
            Shaders.uniform_instanceId.setValue(0);
        }
    }

    static {
        int n;
        alphaState = new AlphaState();
        lightingState = new BooleanState(2896);
        lightState = new BooleanState[8];
        colorMaterialState = new ColorMaterialState();
        blendState = new BlendState();
        depthState = new DepthState();
        fogState = new FogState();
        cullState = new CullState();
        polygonOffsetState = new PolygonOffsetState();
        colorLogicState = new ColorLogicState();
        texGenState = new TexGenState();
        clearState = new ClearState();
        stencilState = new StencilState();
        normalizeState = new BooleanState(2977);
        activeTextureUnit = 0;
        textureState = new TextureState[32];
        activeShadeModel = 7425;
        rescaleNormalState = new BooleanState(32826);
        colorMaskState = new ColorMask();
        colorState = new Color();
        clearEnabled = true;
        alphaLock = new LockCounter();
        alphaLockState = new GlAlphaState();
        blendLock = new LockCounter();
        blendLockState = new GlBlendState();
        creatingDisplayList = false;
        for (n = 0; n < 8; ++n) {
            GlStateManager.lightState[n] = new BooleanState(16384 + n);
        }
        for (n = 0; n < textureState.length; ++n) {
            GlStateManager.textureState[n] = new TextureState();
        }
    }

    public static class AlphaState {
        public BooleanState alphaTest = new BooleanState(3008);
        public int func = 519;
        public float ref = -1.0f;

        private AlphaState() {
        }
    }

    public static class BooleanState {
        private final int capability;
        private boolean currentState = false;

        public BooleanState(int n) {
            this.capability = n;
        }

        public void setDisabled() {
            this.setState(false);
        }

        public void setEnabled() {
            this.setState(true);
        }

        public void setState(boolean bl) {
            if (bl != this.currentState) {
                this.currentState = bl;
                if (bl) {
                    GL11.glEnable(this.capability);
                } else {
                    GL11.glDisable(this.capability);
                }
            }
        }
    }

    public static class ColorMaterialState {
        public BooleanState colorMaterial = new BooleanState(2903);
        public int face = 1032;
        public int mode = 5634;

        private ColorMaterialState() {
        }
    }

    public static class DepthState {
        public BooleanState depthTest = new BooleanState(2929);
        public boolean maskEnabled = true;
        public int depthFunc = 513;

        private DepthState() {
        }
    }

    public static class BlendState {
        public BooleanState blend = new BooleanState(3042);
        public int srcFactor = 1;
        public int dstFactor = 0;
        public int srcFactorAlpha = 1;
        public int dstFactorAlpha = 0;

        private BlendState() {
        }
    }

    public static class FogState {
        public BooleanState fog = new BooleanState(2912);
        public int mode = 2048;
        public float density = 1.0f;
        public float start = 0.0f;
        public float end = 1.0f;

        private FogState() {
        }
    }

    public static class CullState {
        public BooleanState cullFace = new BooleanState(2884);
        public int mode = 1029;

        private CullState() {
        }
    }

    public static class PolygonOffsetState {
        public BooleanState polygonOffsetFill = new BooleanState(32823);
        public BooleanState polygonOffsetLine = new BooleanState(10754);
        public float factor = 0.0f;
        public float units = 0.0f;

        private PolygonOffsetState() {
        }
    }

    public static class ColorLogicState {
        public BooleanState colorLogicOp = new BooleanState(3058);
        public int opcode = 5379;

        private ColorLogicState() {
        }
    }

    public static enum TexGen {
        S,
        T,
        R,
        Q;

    }

    public static class TexGenCoord {
        public BooleanState textureGen;
        public int coord;
        public int param = -1;

        public TexGenCoord(int n, int n2) {
            this.coord = n;
            this.textureGen = new BooleanState(n2);
        }
    }

    public static class TexGenState {
        public TexGenCoord s = new TexGenCoord(8192, 3168);
        public TexGenCoord t = new TexGenCoord(8193, 3169);
        public TexGenCoord r = new TexGenCoord(8194, 3170);
        public TexGenCoord q = new TexGenCoord(8195, 3171);

        private TexGenState() {
        }
    }

    public static class TextureState {
        public BooleanState texture2DState = new BooleanState(3553);
        public int textureName = 0;

        private TextureState() {
        }
    }

    public static class ColorMask {
        public boolean red = true;
        public boolean green = true;
        public boolean blue = true;
        public boolean alpha = true;

        private ColorMask() {
        }
    }

    public static class ClearState {
        public double depth = 1.0;
        public Color color = new Color(0.0f, 0.0f, 0.0f, 0.0f);
        public int field_179204_c = 0;

        private ClearState() {
        }
    }

    public static class Color {
        public float red = 1.0f;
        public float green = 1.0f;
        public float blue = 1.0f;
        public float alpha = 1.0f;

        public Color() {
        }

        public Color(float f, float f2, float f3, float f4) {
            this.red = f;
            this.green = f2;
            this.blue = f3;
            this.alpha = f4;
        }
    }

    public static class StencilState {
        public StencilFunc field_179078_a = new StencilFunc();
        public int field_179076_b = -1;
        public int field_179077_c = 7680;
        public int field_179074_d = 7680;
        public int field_179075_e = 7680;

        private StencilState() {
        }
    }

    public static class StencilFunc {
        public int field_179081_a = 519;
        public int field_179079_b = 0;
        public int field_179080_c = -1;

        private StencilFunc() {
        }
    }
}

