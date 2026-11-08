/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oce6044968f8;

public class occ4083141c7 {
    private static final float \u019b = 1.0E-4f;
    private boolean \u016b;
    private boolean B;
    private float \u051a;
    private float \u04c1;
    private float \u0377;
    private float \u025a;
    private long \u03ac;
    private long \u057f;

    occ4083141c7() {
    }

    void \u0248(float f, long l, long l2, boolean bl) {
        block16: {
            occ4083141c7 occ4083141c72;
            float f2;
            block17: {
                occ4083141c7 occ4083141c73;
                block14: {
                    occ4083141c7 occ4083141c74;
                    block15: {
                        boolean bl2;
                        block12: {
                            block13: {
                                bl2 = oce6044968f8.\u0452;
                                f2 = occ4083141c7.\u017d(f);
                                if (bl2) break block12;
                                if (this.\u016b) break block13;
                                this.\u016b = true;
                                this.B = bl;
                                this.\u051a = f2;
                                this.\u04c1 = f2;
                                this.\u0377 = f2;
                                this.\u025a = f2;
                                this.\u03ac = l;
                                this.\u057f = Math.max(1L, l2);
                                return;
                            }
                            occ4083141c74 = this;
                            occ4083141c73 = this;
                            if (bl2) break block14;
                            occ4083141c74.\u04c1 = occ4083141c73.\u0550(l);
                        }
                        if (Math.abs(f2 - this.\u051a) > 1.0E-4f) break block15;
                        occ4083141c72 = this;
                        if (bl2) break block16;
                        if (occ4083141c72.B == bl) break block17;
                    }
                    occ4083141c74 = this;
                    occ4083141c73 = this;
                }
                occ4083141c74.\u0377 = occ4083141c73.\u04c1;
                this.\u025a = f2;
                this.\u03ac = l;
                this.\u057f = Math.max(1L, l2);
                this.B = bl;
            }
            this.\u051a = f2;
            occ4083141c72 = this;
        }
        occ4083141c72.\u04c1 = this.\u0550(l);
    }

    float \u01a2() {
        return this.\u04c1;
    }

    private float \u0550(long l) {
        float f = Math.max(0.0f, Math.min(1.0f, (float)(l - this.\u03ac) / (float)this.\u057f));
        float f2 = this.B ? occ4083141c7.\u0445(f) : occ4083141c7.\u0178(f);
        float f3 = f2;
        return this.\u0377 + (this.\u025a - this.\u0377) * f3;
    }

    private static float \u0445(float f) {
        float f2;
        block6: {
            float f3;
            block4: {
                block5: {
                    boolean bl = oce6044968f8.\u0452;
                    f3 = f;
                    if (bl) break block4;
                    if (!(f3 < 0.5f)) break block5;
                    f2 = 2.0f * f * f;
                    break block6;
                }
                f3 = -1.0f;
            }
            f2 = f3 + (4.0f - 2.0f * f) * f;
        }
        return f2;
    }

    private static float \u0178(float f) {
        float f2;
        block6: {
            float f3;
            block4: {
                block5: {
                    boolean bl = oce6044968f8.\u0452;
                    f3 = f;
                    if (bl) break block4;
                    if (!(f3 < 0.5f)) break block5;
                    f2 = 4.0f * f * f * f;
                    break block6;
                }
                f3 = (f - 1.0f) * (2.0f * f - 2.0f) * (2.0f * f - 2.0f);
            }
            f2 = f3 + 1.0f;
        }
        return f2;
    }

    private static float \u017d(float f) {
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

