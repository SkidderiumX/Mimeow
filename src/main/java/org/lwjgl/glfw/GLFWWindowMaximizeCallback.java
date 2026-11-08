/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowMaximizeCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowMaximizeCallback
extends Callback
implements GLFWWindowMaximizeCallbackI {
    public static GLFWWindowMaximizeCallback create(long l) {
        GLFWWindowMaximizeCallbackI gLFWWindowMaximizeCallbackI = (GLFWWindowMaximizeCallbackI)Callback.get(l);
        return gLFWWindowMaximizeCallbackI instanceof GLFWWindowMaximizeCallback ? (GLFWWindowMaximizeCallback)gLFWWindowMaximizeCallbackI : new Container(l, gLFWWindowMaximizeCallbackI);
    }

    public static @Nullable GLFWWindowMaximizeCallback createSafe(long l) {
        return l == 0L ? null : GLFWWindowMaximizeCallback.create(l);
    }

    public static GLFWWindowMaximizeCallback create(GLFWWindowMaximizeCallbackI gLFWWindowMaximizeCallbackI) {
        return gLFWWindowMaximizeCallbackI instanceof GLFWWindowMaximizeCallback ? (GLFWWindowMaximizeCallback)gLFWWindowMaximizeCallbackI : new Container(gLFWWindowMaximizeCallbackI.address(), gLFWWindowMaximizeCallbackI);
    }

    protected GLFWWindowMaximizeCallback() {
        super(CIF);
    }

    GLFWWindowMaximizeCallback(long l) {
        super(l);
    }

    public GLFWWindowMaximizeCallback set(long l) {
        GLFW.glfwSetWindowMaximizeCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowMaximizeCallback {
        private final GLFWWindowMaximizeCallbackI delegate;

        Container(long l, GLFWWindowMaximizeCallbackI gLFWWindowMaximizeCallbackI) {
            super(l);
            this.delegate = gLFWWindowMaximizeCallbackI;
        }

        @Override
        public void invoke(long l, boolean bl) {
            this.delegate.invoke(l, bl);
        }
    }
}

