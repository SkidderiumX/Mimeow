/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFWDeallocateCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWDeallocateCallback
extends Callback
implements GLFWDeallocateCallbackI {
    public static GLFWDeallocateCallback create(long l) {
        GLFWDeallocateCallbackI gLFWDeallocateCallbackI = (GLFWDeallocateCallbackI)Callback.get(l);
        return gLFWDeallocateCallbackI instanceof GLFWDeallocateCallback ? (GLFWDeallocateCallback)gLFWDeallocateCallbackI : new Container(l, gLFWDeallocateCallbackI);
    }

    public static @Nullable GLFWDeallocateCallback createSafe(long l) {
        return l == 0L ? null : GLFWDeallocateCallback.create(l);
    }

    public static GLFWDeallocateCallback create(GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
        return gLFWDeallocateCallbackI instanceof GLFWDeallocateCallback ? (GLFWDeallocateCallback)gLFWDeallocateCallbackI : new Container(gLFWDeallocateCallbackI.address(), gLFWDeallocateCallbackI);
    }

    protected GLFWDeallocateCallback() {
        super(CIF);
    }

    GLFWDeallocateCallback(long l) {
        super(l);
    }

    private static final class Container
    extends GLFWDeallocateCallback {
        private final GLFWDeallocateCallbackI delegate;

        Container(long l, GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
            super(l);
            this.delegate = gLFWDeallocateCallbackI;
        }

        @Override
        public void invoke(long l, long l2) {
            this.delegate.invoke(l, l2);
        }
    }
}

