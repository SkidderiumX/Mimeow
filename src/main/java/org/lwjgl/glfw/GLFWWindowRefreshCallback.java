/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowRefreshCallback
extends Callback
implements GLFWWindowRefreshCallbackI {
    public static GLFWWindowRefreshCallback create(long l) {
        GLFWWindowRefreshCallbackI gLFWWindowRefreshCallbackI = (GLFWWindowRefreshCallbackI)Callback.get(l);
        return gLFWWindowRefreshCallbackI instanceof GLFWWindowRefreshCallback ? (GLFWWindowRefreshCallback)gLFWWindowRefreshCallbackI : new Container(l, gLFWWindowRefreshCallbackI);
    }

    public static @Nullable GLFWWindowRefreshCallback createSafe(long l) {
        return l == 0L ? null : GLFWWindowRefreshCallback.create(l);
    }

    public static GLFWWindowRefreshCallback create(GLFWWindowRefreshCallbackI gLFWWindowRefreshCallbackI) {
        return gLFWWindowRefreshCallbackI instanceof GLFWWindowRefreshCallback ? (GLFWWindowRefreshCallback)gLFWWindowRefreshCallbackI : new Container(gLFWWindowRefreshCallbackI.address(), gLFWWindowRefreshCallbackI);
    }

    protected GLFWWindowRefreshCallback() {
        super(CIF);
    }

    GLFWWindowRefreshCallback(long l) {
        super(l);
    }

    public GLFWWindowRefreshCallback set(long l) {
        GLFW.glfwSetWindowRefreshCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowRefreshCallback {
        private final GLFWWindowRefreshCallbackI delegate;

        Container(long l, GLFWWindowRefreshCallbackI gLFWWindowRefreshCallbackI) {
            super(l);
            this.delegate = gLFWWindowRefreshCallbackI;
        }

        @Override
        public void invoke(long l) {
            this.delegate.invoke(l);
        }
    }
}

