/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oce6044968f8;

public class ocd941e94801 {
    private static final long \u0217 = 150L;
    private static final float \u04e4 = 1.0E-4f;
    private boolean \u03d7;
    private boolean f;
    private float \u043e;
    private float \u040a;
    private float \u0191 = 1.0f;
    private long \u0581;

    ocd941e94801() {
    }

    float \u056d(float f, float f2, boolean bl, long l) {
        long l2;
        block30: {
            ocd941e94801 ocd941e948012;
            block34: {
                block31: {
                    float f3;
                    boolean bl2;
                    block32: {
                        block33: {
                            block28: {
                                ocd941e94801 ocd941e948013;
                                float f4;
                                float f5;
                                block29: {
                                    boolean bl3;
                                    block26: {
                                        block27: {
                                            block24: {
                                                block25: {
                                                    f5 = Math.max(0.0f, f);
                                                    bl2 = oce6044968f8.\u0452;
                                                    f4 = Math.max(0.5f, f2);
                                                    if (bl2) break block24;
                                                    if (!this.\u03d7) break block25;
                                                    bl3 = bl;
                                                    if (bl2) break block26;
                                                    if (bl3) break block27;
                                                }
                                                this.\u03d7 = true;
                                                this.f = false;
                                                this.\u043e = f5;
                                                this.\u040a = f5;
                                                this.\u0191 = f4;
                                                this.\u0581 = l;
                                            }
                                            return ocd941e94801.\u0421(f5, f4);
                                        }
                                        ocd941e948013 = this;
                                        if (bl2) break block28;
                                        bl3 = ocd941e948013.f;
                                    }
                                    if (!bl3) break block29;
                                    long l3 = l - this.\u0581 - (0x2947D3D173C64F50L ^ 0x2947D3D173C64FC6L);
                                    l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                                    if (bl2) break block30;
                                    if (l2 < 0) break block31;
                                }
                                this.\u043e = this.\u040a;
                                this.\u040a = f5;
                                this.\u0191 = f4;
                                ocd941e948013 = this;
                            }
                            float f6 = Math.abs(this.\u043e - this.\u040a) - 1.0E-4f;
                            f3 = f6 == 0.0f ? 0 : (f6 > 0.0f ? 1 : -1);
                            if (bl2) break block32;
                            if (f3 <= 0) break block33;
                            f3 = 1.0f;
                            break block32;
                        }
                        f3 = 0.0f;
                    }
                    ocd941e948013.f = f3;
                    ocd941e948012 = this;
                    if (bl2) break block34;
                    if (!ocd941e948012.f) break block31;
                    this.\u0581 = l;
                }
                ocd941e948012 = this;
            }
            l2 = (long)ocd941e948012.f;
        }
        float f7 = l2 != false ? Math.max(0.0f, Math.min(1.0f, (float)(l - this.\u0581) / 150.0f)) : 1.0f;
        float f8 = f7;
        float f9 = this.\u043e + (this.\u040a - this.\u043e) * f8;
        return ocd941e94801.\u0421(f9, this.\u0191);
    }

    private static float \u0421(float f, float f2) {
        return Math.max(0.0f, Math.min(1.0f, f / f2));
    }
}

