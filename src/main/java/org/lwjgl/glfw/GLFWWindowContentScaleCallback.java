/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowContentScaleCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowContentScaleCallback
extends Callback
implements GLFWWindowContentScaleCallbackI {
    public static GLFWWindowContentScaleCallback create(long l) {
        GLFWWindowContentScaleCallbackI gLFWWindowContentScaleCallbackI = (GLFWWindowContentScaleCallbackI)Callback.get(l);
        return gLFWWindowContentScaleCallbackI instanceof GLFWWindowContentScaleCallback ? (GLFWWindowContentScaleCallback)gLFWWindowContentScaleCallbackI : new Container(l, gLFWWindowContentScaleCallbackI);
    }

    public static @Nullable GLFWWindowContentScaleCallback createSafe(long l) {
        return l == 0L ? null : GLFWWindowContentScaleCallback.create(l);
    }

    public static GLFWWindowContentScaleCallback create(GLFWWindowContentScaleCallbackI gLFWWindowContentScaleCallbackI) {
        return gLFWWindowContentScaleCallbackI instanceof GLFWWindowContentScaleCallback ? (GLFWWindowContentScaleCallback)gLFWWindowContentScaleCallbackI : new Container(gLFWWindowContentScaleCallbackI.address(), gLFWWindowContentScaleCallbackI);
    }

    protected GLFWWindowContentScaleCallback() {
        super(CIF);
    }

    GLFWWindowContentScaleCallback(long l) {
        super(l);
    }

    public GLFWWindowContentScaleCallback set(long l) {
        GLFW.glfwSetWindowContentScaleCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowContentScaleCallback {
        private final GLFWWindowContentScaleCallbackI delegate;

        Container(long l, GLFWWindowContentScaleCallbackI gLFWWindowContentScaleCallbackI) {
            super(l);
            this.delegate = gLFWWindowContentScaleCallbackI;
        }

        @Override
        public void invoke(long l, float f, float f2) {
            this.delegate.invoke(l, f, f2);
        }
    }
}

