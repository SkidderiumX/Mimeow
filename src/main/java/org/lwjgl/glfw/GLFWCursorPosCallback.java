/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWCursorPosCallback
extends Callback
implements GLFWCursorPosCallbackI {
    public static GLFWCursorPosCallback create(long l) {
        GLFWCursorPosCallbackI gLFWCursorPosCallbackI = (GLFWCursorPosCallbackI)Callback.get(l);
        return gLFWCursorPosCallbackI instanceof GLFWCursorPosCallback ? (GLFWCursorPosCallback)gLFWCursorPosCallbackI : new Container(l, gLFWCursorPosCallbackI);
    }

    public static @Nullable GLFWCursorPosCallback createSafe(long l) {
        return l == 0L ? null : GLFWCursorPosCallback.create(l);
    }

    public static GLFWCursorPosCallback create(GLFWCursorPosCallbackI gLFWCursorPosCallbackI) {
        return gLFWCursorPosCallbackI instanceof GLFWCursorPosCallback ? (GLFWCursorPosCallback)gLFWCursorPosCallbackI : new Container(gLFWCursorPosCallbackI.address(), gLFWCursorPosCallbackI);
    }

    protected GLFWCursorPosCallback() {
        super(CIF);
    }

    GLFWCursorPosCallback(long l) {
        super(l);
    }

    public GLFWCursorPosCallback set(long l) {
        GLFW.glfwSetCursorPosCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWCursorPosCallback {
        private final GLFWCursorPosCallbackI delegate;

        Container(long l, GLFWCursorPosCallbackI gLFWCursorPosCallbackI) {
            super(l);
            this.delegate = gLFWCursorPosCallbackI;
        }

        @Override
        public void invoke(long l, double d, double d2) {
            this.delegate.invoke(l, d, d2);
        }
    }
}

