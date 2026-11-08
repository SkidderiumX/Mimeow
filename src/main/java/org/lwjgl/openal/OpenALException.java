/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.openal.AL10;

public class OpenALException
extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public OpenALException() {
    }

    public OpenALException(int n) {
        super("OpenAL error: " + AL10.alGetString(n) + " (" + n + ")");
    }

    public OpenALException(String string) {
        super(string);
    }

    public OpenALException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public OpenALException(Throwable throwable) {
        super(throwable);
    }
}

