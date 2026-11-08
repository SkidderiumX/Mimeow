/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

public class OpenGLException
extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public OpenGLException() {
    }

    public OpenGLException(String string) {
        super(string);
    }

    public OpenGLException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public OpenGLException(Throwable throwable) {
        super(throwable);
    }

    public OpenGLException(int n) {
        this("OpenGL error " + n);
    }
}

