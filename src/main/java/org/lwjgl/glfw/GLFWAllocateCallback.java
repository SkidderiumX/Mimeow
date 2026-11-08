/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFWAllocateCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWAllocateCallback
extends Callback
implements GLFWAllocateCallbackI {
    public static GLFWAllocateCallback create(long l) {
        GLFWAllocateCallbackI gLFWAllocateCallbackI = (GLFWAllocateCallbackI)Callback.get(l);
        return gLFWAllocateCallbackI instanceof GLFWAllocateCallback ? (GLFWAllocateCallback)gLFWAllocateCallbackI : new Container(l, gLFWAllocateCallbackI);
    }

    public static @Nullable GLFWAllocateCallback createSafe(long l) {
        return l == 0L ? null : GLFWAllocateCallback.create(l);
    }

    public static GLFWAllocateCallback create(GLFWAllocateCallbackI gLFWAllocateCallbackI) {
        return gLFWAllocateCallbackI instanceof GLFWAllocateCallback ? (GLFWAllocateCallback)gLFWAllocateCallbackI : new Container(gLFWAllocateCallbackI.address(), gLFWAllocateCallbackI);
    }

    protected GLFWAllocateCallback() {
        super(CIF);
    }

    GLFWAllocateCallback(long l) {
        super(l);
    }

    private static final class Container
    extends GLFWAllocateCallback {
        private final GLFWAllocateCallbackI delegate;

        Container(long l, GLFWAllocateCallbackI gLFWAllocateCallbackI) {
            super(l);
            this.delegate = gLFWAllocateCallbackI;
        }

        @Override
        public long invoke(long l, long l2) {
            return this.delegate.invoke(l, l2);
        }
    }
}

