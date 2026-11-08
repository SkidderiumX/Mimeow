/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

public class PixelFormat {
    private int bpp;
    private int alpha;
    private int depth;
    private int stencil;
    private int samples;
    private int colorSamples;
    private int num_aux_buffers;
    private int accum_bpp;
    private int accum_alpha;
    private boolean stereo;
    private boolean floating_point;
    private boolean floating_point_packed;
    private boolean sRGB;

    public PixelFormat() {
        this(0, 8, 0);
    }

    public PixelFormat(int n, int n2, int n3) {
        this(n, n2, n3, 0);
    }

    public PixelFormat(int n, int n2, int n3, int n4) {
        this(0, n, n2, n3, n4);
    }

    public PixelFormat(int n, int n2, int n3, int n4, int n5) {
        this(n, n2, n3, n4, n5, 0, 0, 0, false);
    }

    public PixelFormat(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        this(n, n2, n3, n4, n5, n6, n7, n8, bl, false);
    }

    public PixelFormat(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl, boolean bl2) {
        this.bpp = n;
        this.alpha = n2;
        this.depth = n3;
        this.stencil = n4;
        this.samples = n5;
        this.num_aux_buffers = n6;
        this.accum_bpp = n7;
        this.accum_alpha = n8;
        this.stereo = bl;
        this.floating_point = bl2;
        this.floating_point_packed = false;
        this.sRGB = false;
    }

    private PixelFormat(PixelFormat pixelFormat) {
        this.bpp = pixelFormat.bpp;
        this.alpha = pixelFormat.alpha;
        this.depth = pixelFormat.depth;
        this.stencil = pixelFormat.stencil;
        this.samples = pixelFormat.samples;
        this.colorSamples = pixelFormat.colorSamples;
        this.num_aux_buffers = pixelFormat.num_aux_buffers;
        this.accum_bpp = pixelFormat.accum_bpp;
        this.accum_alpha = pixelFormat.accum_alpha;
        this.stereo = pixelFormat.stereo;
        this.floating_point = pixelFormat.floating_point;
        this.floating_point_packed = pixelFormat.floating_point_packed;
        this.sRGB = pixelFormat.sRGB;
    }

    public int getBitsPerPixel() {
        return this.bpp;
    }

    public PixelFormat withBitsPerPixel(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of bits per pixel specified: " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.bpp = n;
        return pixelFormat;
    }

    public int getAlphaBits() {
        return this.alpha;
    }

    public PixelFormat withAlphaBits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of alpha bits specified: " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.alpha = n;
        return pixelFormat;
    }

    public int getDepthBits() {
        return this.depth;
    }

    public PixelFormat withDepthBits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of depth bits specified: " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.depth = n;
        return pixelFormat;
    }

    public int getStencilBits() {
        return this.stencil;
    }

    public PixelFormat withStencilBits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of stencil bits specified: " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.stencil = n;
        return pixelFormat;
    }

    public int getSamples() {
        return this.samples;
    }

    public PixelFormat withSamples(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of samples specified: " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.samples = n;
        return pixelFormat;
    }

    public PixelFormat withCoverageSamples(int n) {
        return this.withCoverageSamples(n, this.samples);
    }

    public PixelFormat withCoverageSamples(int n, int n2) {
        if (n2 < 0 || n < 0 || n2 == 0 && 0 < n || n2 < n) {
            throw new IllegalArgumentException("Invalid number of coverage samples specified: " + n2 + " - " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.samples = n2;
        pixelFormat.colorSamples = n;
        return pixelFormat;
    }

    public int getAuxBuffers() {
        return this.num_aux_buffers;
    }

    public PixelFormat withAuxBuffers(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of auxiliary buffers specified: " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.num_aux_buffers = n;
        return pixelFormat;
    }

    public int getAccumulationBitsPerPixel() {
        return this.accum_bpp;
    }

    public PixelFormat withAccumulationBitsPerPixel(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of bits per pixel in the accumulation buffer specified: " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.accum_bpp = n;
        return pixelFormat;
    }

    public int getAccumulationAlpha() {
        return this.accum_alpha;
    }

    public PixelFormat withAccumulationAlpha(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of alpha bits in the accumulation buffer specified: " + n);
        }
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.accum_alpha = n;
        return pixelFormat;
    }

    public boolean isStereo() {
        return this.stereo;
    }

    public PixelFormat withStereo(boolean bl) {
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.stereo = bl;
        return pixelFormat;
    }

    public boolean isFloatingPoint() {
        return this.floating_point;
    }

    public PixelFormat withFloatingPoint(boolean bl) {
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.floating_point = bl;
        if (bl) {
            pixelFormat.floating_point_packed = false;
        }
        return pixelFormat;
    }

    public PixelFormat withFloatingPointPacked(boolean bl) {
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.floating_point_packed = bl;
        if (bl) {
            pixelFormat.floating_point = false;
        }
        return pixelFormat;
    }

    public boolean isSRGB() {
        return this.sRGB;
    }

    public PixelFormat withSRGB(boolean bl) {
        PixelFormat pixelFormat = new PixelFormat(this);
        pixelFormat.sRGB = bl;
        return pixelFormat;
    }
}

