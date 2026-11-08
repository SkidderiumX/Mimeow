/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;

public class GLContext {
    private static final ThreadLocal<ContextCapabilities> capabilities = new ThreadLocal();

    public static ContextCapabilities getCapabilities() {
        GLCapabilities gLCapabilities = GL.getCapabilities();
        ContextCapabilities contextCapabilities = capabilities.get();
        if (contextCapabilities == null || contextCapabilities.cap != gLCapabilities) {
            contextCapabilities = new ContextCapabilities(gLCapabilities);
            capabilities.set(contextCapabilities);
        }
        return contextCapabilities;
    }
}

