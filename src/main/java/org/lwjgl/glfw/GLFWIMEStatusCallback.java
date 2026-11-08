/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWIMEStatusCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWIMEStatusCallback
extends Callback
implements GLFWIMEStatusCallbackI {
    public static GLFWIMEStatusCallback create(long l) {
        GLFWIMEStatusCallbackI gLFWIMEStatusCallbackI = (GLFWIMEStatusCallbackI)Callback.get(l);
        return gLFWIMEStatusCallbackI instanceof GLFWIMEStatusCallback ? (GLFWIMEStatusCallback)gLFWIMEStatusCallbackI : new Container(l, gLFWIMEStatusCallbackI);
    }

    public static @Nullable GLFWIMEStatusCallback createSafe(long l) {
        return l == 0L ? null : GLFWIMEStatusCallback.create(l);
    }

    public static GLFWIMEStatusCallback create(GLFWIMEStatusCallbackI gLFWIMEStatusCallbackI) {
        return gLFWIMEStatusCallbackI instanceof GLFWIMEStatusCallback ? (GLFWIMEStatusCallback)gLFWIMEStatusCallbackI : new Container(gLFWIMEStatusCallbackI.address(), gLFWIMEStatusCallbackI);
    }

    protected GLFWIMEStatusCallback() {
        super(CIF);
    }

    GLFWIMEStatusCallback(long l) {
        super(l);
    }

    public GLFWIMEStatusCallback set(long l) {
        GLFW.glfwSetIMEStatusCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWIMEStatusCallback {
        private final GLFWIMEStatusCallbackI delegate;

        Container(long l, GLFWIMEStatusCallbackI gLFWIMEStatusCallbackI) {
            super(l);
            this.delegate = gLFWIMEStatusCallbackI;
        }

        @Override
        public void invoke(long l) {
            this.delegate.invoke(l);
        }
    }
}

