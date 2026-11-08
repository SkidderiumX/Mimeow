/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.nio.IntBuffer;
import net.minecraft.src.Config;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ARBDebugOutput;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.GLDebugMessageARBCallback;
import org.lwjgl.opengl.PixelFormat;

public class GlDebugHandler {
    private static GLDebugMessageARBCallback debugCallback;

    public static void createDisplayDebug() throws LWJGLException {
        boolean bl = GLContext.getCapabilities().GL_ARB_debug_output;
        ContextAttribs contextAttribs = new ContextAttribs().withDebug(true);
        Display.create(new PixelFormat().withDepthBits(24), contextAttribs);
        GlDebugHandler glDebugHandler = new GlDebugHandler();
        debugCallback = GLDebugMessageARBCallback.create((n, n2, n3, n4, n5, l, l2) -> glDebugHandler.handleMessage(n, n2, n3, n4, GLDebugMessageARBCallback.getMessage(n5, l)));
        ARBDebugOutput.glDebugMessageCallbackARB(debugCallback, 0L);
        ARBDebugOutput.glDebugMessageControlARB(4352, 4352, 4352, (IntBuffer)null, true);
        GL11.glEnable(33346);
    }

    public void handleMessage(int n, int n2, int n3, int n4, String string) {
        if (!(string.contains("glBindFramebuffer") || string.contains("Wide lines") || string.contains("shader recompiled"))) {
            Config.dbg("[LWJGL] source: " + this.getSource(n) + ", type: " + this.getType(n2) + ", id: " + n3 + ", severity: " + this.getSeverity(n4) + ", message: " + string);
            new Throwable("StackTrace").printStackTrace();
        }
    }

    public String getSource(int n) {
        switch (n) {
            case 33350: {
                return "API";
            }
            case 33351: {
                return "WIN";
            }
            case 33352: {
                return "SHADER";
            }
            case 33353: {
                return "EXT";
            }
            case 33354: {
                return "APP";
            }
            case 33355: {
                return "OTHER";
            }
        }
        return this.getUnknown(n);
    }

    public String getType(int n) {
        switch (n) {
            case 33356: {
                return "ERROR";
            }
            case 33357: {
                return "DEPRECATED";
            }
            case 33358: {
                return "UNDEFINED";
            }
            case 33359: {
                return "PORTABILITY";
            }
            case 33360: {
                return "PERFORMANCE";
            }
            case 33361: {
                return "OTHER";
            }
        }
        return this.getUnknown(n);
    }

    public String getSeverity(int n) {
        switch (n) {
            case 37190: {
                return "HIGH";
            }
            case 37191: {
                return "MEDIUM";
            }
            case 37192: {
                return "LOW";
            }
        }
        return this.getUnknown(n);
    }

    private String getUnknown(int n) {
        return "Unknown (0x" + Integer.toHexString(n).toUpperCase() + ")";
    }
}

