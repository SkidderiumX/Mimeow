/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowIconifyCallback
extends Callback
implements GLFWWindowIconifyCallbackI {
    public static GLFWWindowIconifyCallback create(long l) {
        GLFWWindowIconifyCallbackI gLFWWindowIconifyCallbackI = (GLFWWindowIconifyCallbackI)Callback.get(l);
        return gLFWWindowIconifyCallbackI instanceof GLFWWindowIconifyCallback ? (GLFWWindowIconifyCallback)gLFWWindowIconifyCallbackI : new Container(l, gLFWWindowIconifyCallbackI);
    }

    public static @Nullable GLFWWindowIconifyCallback createSafe(long l) {
        return l == 0L ? null : GLFWWindowIconifyCallback.create(l);
    }

    public static GLFWWindowIconifyCallback create(GLFWWindowIconifyCallbackI gLFWWindowIconifyCallbackI) {
        return gLFWWindowIconifyCallbackI instanceof GLFWWindowIconifyCallback ? (GLFWWindowIconifyCallback)gLFWWindowIconifyCallbackI : new Container(gLFWWindowIconifyCallbackI.address(), gLFWWindowIconifyCallbackI);
    }

    protected GLFWWindowIconifyCallback() {
        super(CIF);
    }

    GLFWWindowIconifyCallback(long l) {
        super(l);
    }

    public GLFWWindowIconifyCallback set(long l) {
        GLFW.glfwSetWindowIconifyCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowIconifyCallback {
        private final GLFWWindowIconifyCallbackI delegate;

        Container(long l, GLFWWindowIconifyCallbackI gLFWWindowIconifyCallbackI) {
            super(l);
            this.delegate = gLFWWindowIconifyCallbackI;
        }

        @Override
        public void invoke(long l, boolean bl) {
            this.delegate.invoke(l, bl);
        }
    }
}

