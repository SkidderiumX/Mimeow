/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWPreeditCandidateCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWPreeditCandidateCallback
extends Callback
implements GLFWPreeditCandidateCallbackI {
    public static GLFWPreeditCandidateCallback create(long l) {
        GLFWPreeditCandidateCallbackI gLFWPreeditCandidateCallbackI = (GLFWPreeditCandidateCallbackI)Callback.get(l);
        return gLFWPreeditCandidateCallbackI instanceof GLFWPreeditCandidateCallback ? (GLFWPreeditCandidateCallback)gLFWPreeditCandidateCallbackI : new Container(l, gLFWPreeditCandidateCallbackI);
    }

    public static @Nullable GLFWPreeditCandidateCallback createSafe(long l) {
        return l == 0L ? null : GLFWPreeditCandidateCallback.create(l);
    }

    public static GLFWPreeditCandidateCallback create(GLFWPreeditCandidateCallbackI gLFWPreeditCandidateCallbackI) {
        return gLFWPreeditCandidateCallbackI instanceof GLFWPreeditCandidateCallback ? (GLFWPreeditCandidateCallback)gLFWPreeditCandidateCallbackI : new Container(gLFWPreeditCandidateCallbackI.address(), gLFWPreeditCandidateCallbackI);
    }

    protected GLFWPreeditCandidateCallback() {
        super(CIF);
    }

    GLFWPreeditCandidateCallback(long l) {
        super(l);
    }

    public GLFWPreeditCandidateCallback set(long l) {
        GLFW.glfwSetPreeditCandidateCallback(l, this);
        return this;
    }

    private static final class Container
    extends GLFWPreeditCandidateCallback {
        private final GLFWPreeditCandidateCallbackI delegate;

        Container(long l, GLFWPreeditCandidateCallbackI gLFWPreeditCandidateCallbackI) {
            super(l);
            this.delegate = gLFWPreeditCandidateCallbackI;
        }

        @Override
        public void invoke(long l, int n, int n2, int n3, int n4) {
            this.delegate.invoke(l, n, n2, n3, n4);
        }
    }
}

