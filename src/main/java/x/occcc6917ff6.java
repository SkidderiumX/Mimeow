/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oce6044968f8;

public class occcc6917ff6 {
    private static final float \u02e2 = 1.0E-4f;
    private final long \u04db;
    private final long f;
    private boolean \u0196;
    private float \u0258;
    private float \u0193;
    private float \u0166;
    private float \u0372;
    private long \u0523;

    occcc6917ff6() {
        this(0x3852DAAA892264B2L ^ 0x3852DAAA892264D6L, 0x3852DAAA892266F0L ^ 0x3852DAAA892264D6L);
    }

    occcc6917ff6(long l, long l2) {
        this.\u04db = Math.max(0L, l);
        this.f = Math.max(1L, l2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void \u0180(float f, long l) {
        float f2;
        block17: {
            float f3;
            block19: {
                boolean bl;
                block20: {
                    float f4;
                    float f5;
                    block18: {
                        float f6;
                        block15: {
                            block16: {
                                f2 = occcc6917ff6.\u022f(f);
                                bl = oce6044968f8.\u0452;
                                occcc6917ff6 occcc6917ff62 = this;
                                if (!bl) {
                                    if (!occcc6917ff62.\u0196) {
                                        this.\u0196 = true;
                                        this.\u0258 = f2;
                                        this.\u0193 = f2;
                                        this.\u0166 = f2;
                                        this.\u0372 = f2;
                                        this.\u0523 = l;
                                        return;
                                    }
                                    occcc6917ff62 = this;
                                }
                                f3 = occcc6917ff62.\u04d8(l);
                                f5 = f2;
                                f6 = this.\u0258;
                                if (bl) break block15;
                                if (!(f5 < f6 - 1.0E-4f)) break block16;
                                this.\u0193 = Math.max(f3, this.\u0258);
                                this.\u03fb(this.\u0193, f2, l);
                                if (!bl) break block17;
                            }
                            f5 = f2;
                            f4 = this.\u0258;
                            if (bl) break block18;
                            f6 = f4 + 1.0E-4f;
                        }
                        if (!(f5 > f6)) break block19;
                        f5 = f2;
                        f4 = f3;
                    }
                    if (!(f5 >= f4)) break block20;
                    this.\u0193 = f2;
                    this.\u03fb(f2, f2, l);
                    if (!bl) break block17;
                }
                this.\u0193 = f3;
                this.\u03fb(f3, f2, l - this.\u04db);
                if (!bl) break block17;
            }
            this.\u0193 = f3;
        }
        this.\u0258 = f2;
        this.\u0193 = Math.max(this.\u0258, this.\u0193);
    }

    float \u0251() {
        return this.\u0258;
    }

    float y() {
        return this.\u0193;
    }

    void \u03f5(float f) {
        float f2 = occcc6917ff6.\u022f(f);
        this.\u0196 = true;
        this.\u0258 = f2;
        this.\u0193 = f2;
        this.\u0166 = f2;
        this.\u0372 = f2;
        this.\u0523 = 0L;
    }

    private void \u03fb(float f, float f2, long l) {
        this.\u0166 = f;
        this.\u0372 = f2;
        this.\u0523 = l;
    }

    private float \u04d8(long l) {
        long l2 = l - this.\u0523 - this.\u04db;
        if (l2 <= 0L) {
            return this.\u0166;
        }
        float f = Math.min(1.0f, (float)l2 / (float)this.f);
        float f2 = f * f * (3.0f - 2.0f * f);
        return this.\u0166 + (this.\u0372 - this.\u0166) * f2;
    }

    private static float \u022f(float f) {
        float f2;
        block10: {
            block11: {
                float f3;
                block8: {
                    block9: {
                        boolean bl = oce6044968f8.\u0452;
                        f3 = f;
                        if (bl) break block8;
                        if (Float.isNaN(f3)) break block9;
                        f2 = f;
                        if (bl) break block10;
                        if (!Float.isInfinite(f2)) break block11;
                    }
                    f3 = 0.0f;
                }
                return f3;
            }
            f2 = Math.max(0.0f, Math.min(1.0f, f));
        }
        return f2;
    }
}

