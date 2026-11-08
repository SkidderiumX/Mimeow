/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

public class ContextAttribs {
    private int version_major;
    private int version_minor;
    private boolean profileCore;
    private boolean debug;

    public ContextAttribs(int n, int n2) {
        this.version_major = n;
        this.version_minor = n2;
    }

    public ContextAttribs() {
        this.version_major = 0;
        this.version_minor = 0;
    }

    public ContextAttribs withProfileCore(boolean bl) {
        this.profileCore = bl;
        return this;
    }

    public int getVersion_major() {
        return this.version_major;
    }

    public int getVersion_minor() {
        return this.version_minor;
    }

    public boolean isProfileCore() {
        return this.profileCore;
    }

    public ContextAttribs withDebug(boolean bl) {
        this.debug = this.debug;
        return this;
    }
}

