/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import x.oc75d51ec7eb;
import x.ocbd4917c4b1;
import x.ocd2958dac48;
import x.ocda171fe5d8;
import x.oce6044968f8;

public class oc2b4e974fd6 {
    static final float \u04a0 = 112.5f;
    static final float \u04e8 = 7.5f;
    static final float \u01b3 = 15.0f;
    static final long \u00f0 = 50L;
    static final long \u0552 = 900L;
    private float \u0377;
    private float \u03e5;
    private long \u0567;
    private boolean \u0200;
    private long \u0212;
    private long \u04bf = 0x266D3C0C6CB56B2BL ^ 0xD992C3F3934A94D4L;
    private float \u0577 = 1.0f;
    public static boolean \u0426;

    public void \u03ec(float f) {
        block16: {
            block17: {
                long l;
                int n;
                block15: {
                    block14: {
                        oc2b4e974fd6 oc2b4e974fd62;
                        block12: {
                            block13: {
                                n = oc75d51ec7eb.\u03e9;
                                l = System.currentTimeMillis();
                                if (n != 0) break block12;
                                if (!this.\u0200) break block13;
                                oc2b4e974fd62 = this;
                                if (n != 0) break block14;
                                if (oc2b4e974fd62.\u04bf < 0L) break block15;
                            }
                            this.\u0200 = true;
                            this.\u0212 = l;
                            this.\u0377 = 0.0f;
                            this.\u03e5 = 0.0f;
                        }
                        oc2b4e974fd62 = this;
                    }
                    oc2b4e974fd62.\u0567 = l;
                }
                float f2 = MathHelper.clamp_float(f, 0.0f, 1.0f);
                if (n != 0) break block16;
                if (Float.compare(this.\u03e5, f2) == 0) break block17;
                this.\u0377 = this.\u0123(l);
                this.\u03e5 = f2;
                this.\u0567 = l;
            }
            this.\u04bf = 0xC9421B65A7B9A9D4L ^ 0x36BDE49A5846562BL;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void \u03de() {
        long l;
        block9: {
            block10: {
                oc2b4e974fd6 oc2b4e974fd62;
                int n;
                block8: {
                    n = oc75d51ec7eb.\u03e9;
                    oc2b4e974fd62 = this;
                    if (n != 0) break block8;
                    if (!oc2b4e974fd62.\u0200) return;
                    oc2b4e974fd62 = this;
                }
                l = oc2b4e974fd62.\u04bf;
                if (n != 0) break block9;
                if (l < 0L) break block10;
                return;
            }
            l = System.currentTimeMillis();
        }
        long l2 = l;
        this.\u0577 = this.\u02b7(l2);
        this.\u04bf = l2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void \u00f4() {
        float f;
        float f2;
        long l;
        int n;
        block20: {
            oc2b4e974fd6 oc2b4e974fd62;
            block16: {
                block17: {
                    block19: {
                        block18: {
                            n = oc75d51ec7eb.\u03e9;
                            if (!this.\u0200) {
                                return;
                            }
                            l = System.currentTimeMillis();
                            oc2b4e974fd62 = this;
                            if (n != 0) break block16;
                            if (oc2b4e974fd62.\u04bf < 0L) break block17;
                            f2 = MathHelper.clamp_float((float)(l - this.\u04bf) / 900.0f, 0.0f, 1.0f);
                            f = this.\u0577 + (1.1f - this.\u0577) * oc2b4e974fd6.\u0234(f2);
                            if (n != 0) break block18;
                            if (!(f2 >= 1.0f)) break block19;
                            this.\u04d3();
                        }
                        return;
                    }
                    if (n == 0) break block20;
                }
                oc2b4e974fd62 = this;
            }
            f = oc2b4e974fd62.\u02b7(l);
        }
        f2 = MathHelper.clamp_float(1.0f - 10.0f * Math.abs(1.0f - f), 0.0f, 1.0f);
        ScaledResolution scaledResolution = new ScaledResolution(ocda171fe5d8.\u01d4);
        float f3 = (float)scaledResolution.getScaledWidth() * 0.5f - 56.25f;
        float f4 = (float)scaledResolution.getScaledHeight() * 0.5f + 15.0f;
        float f5 = f3 + 56.25f;
        float f6 = f4 + 3.75f;
        float f7 = 112.5f * this.\u0123(l);
        int n2 = oc2b4e974fd6.\u04af(ocd2958dac48.\u0581(f4), f2);
        int n3 = oc2b4e974fd6.\u04af(ocd2958dac48.\u018e(f4), f2);
        GlStateManager.pushMatrix();
        if (n == 0) {
            GlStateManager.translate(f5, f6, 0.0f);
            GlStateManager.scale(f, f, 1.0f);
            GlStateManager.translate(-f5, -f6, 0.0f);
            oce6044968f8.\u04d6(f3, f4, 112.5f, 7.5f, f2, null);
            if (f7 > 0.0f) {
                ocbd4917c4b1.\u04f6(f3, f4, f3 + f7, f4 + 7.5f, 4.0f, n2, n2, n3, n3);
            }
            GlStateManager.popMatrix();
        }
    }

    public void \u04d3() {
        this.\u0200 = false;
        this.\u0212 = 0L;
        this.\u04bf = 0x29791EE1952A242AL ^ 0xD686E11E6AD5DBD5L;
        this.\u0577 = 1.0f;
        this.\u0162();
    }

    public void \u0162() {
        this.\u0377 = 0.0f;
        this.\u03e5 = 0.0f;
        this.\u0567 = System.currentTimeMillis();
    }

    private float \u0123(long l) {
        float f = MathHelper.clamp_float((float)(l - this.\u0567) / 50.0f, 0.0f, 1.0f);
        return this.\u0377 + (this.\u03e5 - this.\u0377) * f;
    }

    private float \u02b7(long l) {
        float f = MathHelper.clamp_float((float)(l - this.\u0212) / 900.0f, 0.0f, 1.0f);
        return 0.95f + oc2b4e974fd6.\u0234(f) * 0.05f;
    }

    private static float \u0234(float f) {
        float f2;
        block6: {
            float f3;
            block4: {
                block5: {
                    int n = oc75d51ec7eb.\u03e9;
                    f3 = f;
                    if (n != 0) break block4;
                    if (!(f3 >= 1.0f)) break block5;
                    f2 = 1.0f;
                    break block6;
                }
                f3 = 1.0f;
            }
            f2 = f3 - (float)Math.pow(2.0, -10.0 * (double)f);
        }
        return f2;
    }

    private static int \u04af(int n, float f) {
        int n2 = Math.round((float)(n >>> (0x60AC3C8E ^ 0x60AC3C96)) * MathHelper.clamp_float(f, 0.0f, 1.0f));
        return n & (0x6053C369 ^ 0x60AC3C96) | n2 << (0x60AC3C8E ^ 0x60AC3C96);
    }
}

