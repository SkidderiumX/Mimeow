/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWScrollCallback
extends Callback
implements GLFWScrollCallbackI {
    public static GLFWScrollCallback create(long l) {
        GLFWScrollCallbackI gLFWScrollCallbackI = (GLFWScrollCallbackI)Callback.get(l);
        return gLFWScrollCallbackI instanceof GLFWScrollCallback ? (GLFWScrollCallback)gLFWScrollCallbackI : new Container(l, gLFWScrollCallbackI);
    }

    public static @Nullable GLFWScrollCallback createSafe(long l) {
        return l == 0L ? null : GLFWScrollCallback.create(l);
    }

    public static GLFWScrollCallback create(GLFWScrollCallbackI gLFWScrollCallbackI) {
        return gLFWScrollCallbackI instanceof GLFWScrollCallback ? (GLFWScrollCallback)gLFWScrollCallbackI : new Container(gLFWScrollCallbackI.address(), gLFWScrollCallbackI);
    }

    protected GLFWScrollCallback() {
        super(CIF);
    }

    GLFWScrollCallback(long l) {
        super(l);
    }

    public GLFWScrollCallback set(long l) {
        GLFW.glfwSetScrollCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWScrollCallback {
        private final GLFWScrollCallbackI delegate;

        Container(long l, GLFWScrollCallbackI gLFWScrollCallbackI) {
            super(l);
            this.delegate = gLFWScrollCallbackI;
        }

        @Override
        public void invoke(long l, double d, double d2) {
            this.delegate.invoke(l, d, d2);
        }
    }
}

