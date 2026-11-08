/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMonitorCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWMonitorCallback
extends Callback
implements GLFWMonitorCallbackI {
    public static GLFWMonitorCallback create(long l) {
        GLFWMonitorCallbackI gLFWMonitorCallbackI = (GLFWMonitorCallbackI)Callback.get(l);
        return gLFWMonitorCallbackI instanceof GLFWMonitorCallback ? (GLFWMonitorCallback)gLFWMonitorCallbackI : new Container(l, gLFWMonitorCallbackI);
    }

    public static @Nullable GLFWMonitorCallback createSafe(long l) {
        return l == 0L ? null : GLFWMonitorCallback.create(l);
    }

    public static GLFWMonitorCallback create(GLFWMonitorCallbackI gLFWMonitorCallbackI) {
        return gLFWMonitorCallbackI instanceof GLFWMonitorCallback ? (GLFWMonitorCallback)gLFWMonitorCallbackI : new Container(gLFWMonitorCallbackI.address(), gLFWMonitorCallbackI);
    }

    protected GLFWMonitorCallback() {
        super(CIF);
    }

    GLFWMonitorCallback(long l) {
        super(l);
    }

    public GLFWMonitorCallback set() {
        GLFW.glfwSetMonitorCallback(this);
        return this;
    }

    private static final class Container
    extends GLFWMonitorCallback {
        private final GLFWMonitorCallbackI delegate;

        Container(long l, GLFWMonitorCallbackI gLFWMonitorCallbackI) {
            super(l);
            this.delegate = gLFWMonitorCallbackI;
        }

        @Override
        public void invoke(long l, int n) {
            this.delegate.invoke(l, n);
        }
    }
}

