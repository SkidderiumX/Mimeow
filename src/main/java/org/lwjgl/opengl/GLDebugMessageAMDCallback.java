/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.jspecify.annotations.Nullable;
import org.lwjgl.opengl.GLDebugMessageAMDCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLDebugMessageAMDCallback
extends Callback
implements GLDebugMessageAMDCallbackI {
    public static GLDebugMessageAMDCallback create(long l) {
        GLDebugMessageAMDCallbackI gLDebugMessageAMDCallbackI = (GLDebugMessageAMDCallbackI)Callback.get(l);
        return gLDebugMessageAMDCallbackI instanceof GLDebugMessageAMDCallback ? (GLDebugMessageAMDCallback)gLDebugMessageAMDCallbackI : new Container(l, gLDebugMessageAMDCallbackI);
    }

    public static @Nullable GLDebugMessageAMDCallback createSafe(long l) {
        return l == 0L ? null : GLDebugMessageAMDCallback.create(l);
    }

    public static GLDebugMessageAMDCallback create(GLDebugMessageAMDCallbackI gLDebugMessageAMDCallbackI) {
        return gLDebugMessageAMDCallbackI instanceof GLDebugMessageAMDCallback ? (GLDebugMessageAMDCallback)gLDebugMessageAMDCallbackI : new Container(gLDebugMessageAMDCallbackI.address(), gLDebugMessageAMDCallbackI);
    }

    protected GLDebugMessageAMDCallback() {
        super(CIF);
    }

    GLDebugMessageAMDCallback(long l) {
        super(l);
    }

    public static String getMessage(int n, long l) {
        return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(l, n));
    }

    private static final class Container
    extends GLDebugMessageAMDCallback {
        private final GLDebugMessageAMDCallbackI delegate;

        Container(long l, GLDebugMessageAMDCallbackI gLDebugMessageAMDCallbackI) {
            super(l);
            this.delegate = gLDebugMessageAMDCallbackI;
        }

        @Override
        public void invoke(int n, int n2, int n3, int n4, long l, long l2) {
            this.delegate.invoke(n, n2, n3, n4, l, l2);
        }
    }
}

