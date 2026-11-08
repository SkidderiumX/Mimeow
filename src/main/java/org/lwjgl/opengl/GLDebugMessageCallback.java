/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.jspecify.annotations.Nullable;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLDebugMessageCallback
extends Callback
implements GLDebugMessageCallbackI {
    public static GLDebugMessageCallback create(long l) {
        GLDebugMessageCallbackI gLDebugMessageCallbackI = (GLDebugMessageCallbackI)Callback.get(l);
        return gLDebugMessageCallbackI instanceof GLDebugMessageCallback ? (GLDebugMessageCallback)gLDebugMessageCallbackI : new Container(l, gLDebugMessageCallbackI);
    }

    public static @Nullable GLDebugMessageCallback createSafe(long l) {
        return l == 0L ? null : GLDebugMessageCallback.create(l);
    }

    public static GLDebugMessageCallback create(GLDebugMessageCallbackI gLDebugMessageCallbackI) {
        return gLDebugMessageCallbackI instanceof GLDebugMessageCallback ? (GLDebugMessageCallback)gLDebugMessageCallbackI : new Container(gLDebugMessageCallbackI.address(), gLDebugMessageCallbackI);
    }

    protected GLDebugMessageCallback() {
        super(CIF);
    }

    GLDebugMessageCallback(long l) {
        super(l);
    }

    public static String getMessage(int n, long l) {
        return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(l, n));
    }

    private static final class Container
    extends GLDebugMessageCallback {
        private final GLDebugMessageCallbackI delegate;

        Container(long l, GLDebugMessageCallbackI gLDebugMessageCallbackI) {
            super(l);
            this.delegate = gLDebugMessageCallbackI;
        }

        @Override
        public void invoke(int n, int n2, int n3, int n4, int n5, long l, long l2) {
            this.delegate.invoke(n, n2, n3, n4, n5, l, l2);
        }
    }
}

