/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWPreeditCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWPreeditCallback
extends Callback
implements GLFWPreeditCallbackI {
    public static GLFWPreeditCallback create(long l) {
        GLFWPreeditCallbackI gLFWPreeditCallbackI = (GLFWPreeditCallbackI)Callback.get(l);
        return gLFWPreeditCallbackI instanceof GLFWPreeditCallback ? (GLFWPreeditCallback)gLFWPreeditCallbackI : new Container(l, gLFWPreeditCallbackI);
    }

    public static @Nullable GLFWPreeditCallback createSafe(long l) {
        return l == 0L ? null : GLFWPreeditCallback.create(l);
    }

    public static GLFWPreeditCallback create(GLFWPreeditCallbackI gLFWPreeditCallbackI) {
        return gLFWPreeditCallbackI instanceof GLFWPreeditCallback ? (GLFWPreeditCallback)gLFWPreeditCallbackI : new Container(gLFWPreeditCallbackI.address(), gLFWPreeditCallbackI);
    }

    protected GLFWPreeditCallback() {
        super(CIF);
    }

    GLFWPreeditCallback(long l) {
        super(l);
    }

    public GLFWPreeditCallback set(long l) {
        GLFW.glfwSetPreeditCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWPreeditCallback {
        private final GLFWPreeditCallbackI delegate;

        Container(long l, GLFWPreeditCallbackI gLFWPreeditCallbackI) {
            super(l);
            this.delegate = gLFWPreeditCallbackI;
        }

        @Override
        public void invoke(long l, int n, long l2, int n2, long l3, int n3, int n4) {
            this.delegate.invoke(l, n, l2, n2, l3, n3, n4);
        }
    }
}

