/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

public class DisplayMode {
    private int width;
    private int height;
    private int bpp;
    private int freq;
    private final boolean fullscreen;

    public DisplayMode(int n, int n2) {
        this(n, n2, 0, 0, false);
    }

    DisplayMode(int n, int n2, int n3, int n4) {
        this(n, n2, n3, n4, true);
    }

    private DisplayMode(int n, int n2, int n3, int n4, boolean bl) {
        this.width = n;
        this.height = n2;
        this.bpp = n3;
        this.freq = n4;
        this.fullscreen = bl;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getBitsPerPixel() {
        return this.bpp;
    }

    public int getFrequency() {
        return this.freq;
    }
}

