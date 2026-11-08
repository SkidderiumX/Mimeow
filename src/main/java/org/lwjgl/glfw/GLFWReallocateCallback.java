/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFWReallocateCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWReallocateCallback
extends Callback
implements GLFWReallocateCallbackI {
    public static GLFWReallocateCallback create(long l) {
        GLFWReallocateCallbackI gLFWReallocateCallbackI = (GLFWReallocateCallbackI)Callback.get(l);
        return gLFWReallocateCallbackI instanceof GLFWReallocateCallback ? (GLFWReallocateCallback)gLFWReallocateCallbackI : new Container(l, gLFWReallocateCallbackI);
    }

    public static @Nullable GLFWReallocateCallback createSafe(long l) {
        return l == 0L ? null : GLFWReallocateCallback.create(l);
    }

    public static GLFWReallocateCallback create(GLFWReallocateCallbackI gLFWReallocateCallbackI) {
        return gLFWReallocateCallbackI instanceof GLFWReallocateCallback ? (GLFWReallocateCallback)gLFWReallocateCallbackI : new Container(gLFWReallocateCallbackI.address(), gLFWReallocateCallbackI);
    }

    protected GLFWReallocateCallback() {
        super(CIF);
    }

    GLFWReallocateCallback(long l) {
        super(l);
    }

    private static final class Container
    extends GLFWReallocateCallback {
        private final GLFWReallocateCallbackI delegate;

        Container(long l, GLFWReallocateCallbackI gLFWReallocateCallbackI) {
            super(l);
            this.delegate = gLFWReallocateCallbackI;
        }

        @Override
        public long invoke(long l, long l2, long l3) {
            return this.delegate.invoke(l, l2, l3);
        }
    }
}

