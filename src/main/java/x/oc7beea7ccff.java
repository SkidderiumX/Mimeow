/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;
import x.oc02a3730b27;
import x.oc1c4f5dd176;
import x.oc29fb8ce47a;
import x.oc3de8a289c5;
import x.oc4c5a4d3446;
import x.oc55585a6f85;
import x.oc69da1aa7f5;
import x.oc75d51ec7eb;
import x.oc7ebeda7e63;
import x.ocf242f30eaa;

public class oc7beea7ccff {
    private static final oc7beea7ccff \u04dc = new oc7beea7ccff();
    private final Minecraft \u03e1 = Minecraft.getMinecraft();
    private float \u02af;
    private float \u03be;
    private float \u0126;
    private float \u02a6;
    private boolean \u01ca;
    private boolean \u0279;
    private float \u0428 = -1.0f;
    private float \u0416;
    private float \u056f;
    public static int \u03ec;

    private oc7beea7ccff() {
    }

    public static oc7beea7ccff \u056f() {
        return \u04dc;
    }

    public void \u03a8() {
        block4: {
            oc7beea7ccff oc7beea7ccff2;
            block5: {
                int n = oc02a3730b27.\u0166;
                oc7beea7ccff2 = this;
                if (n != 0) break block4;
                if (oc7beea7ccff2.\u03e1.thePlayer != null) break block5;
                this.\u03ce();
                return;
            }
            this.\u03be = this.\u02af = this.\u03e1.thePlayer.rotationYaw;
            this.\u02a6 = this.\u0126 = this.\u03e1.thePlayer.rotationPitch;
            this.\u01ca = false;
            this.\u0279 = false;
            this.\u0428 = -1.0f;
            this.\u0416 = 0.0f;
            oc7beea7ccff2 = this;
        }
        oc7beea7ccff2.\u056f = 0.0f;
    }

    public void \u03ce() {
        this.\u02af = 0.0f;
        this.\u03be = 0.0f;
        this.\u0126 = 0.0f;
        this.\u02a6 = 0.0f;
        this.\u01ca = false;
        this.\u0279 = false;
        this.\u0428 = -1.0f;
        this.\u0416 = 0.0f;
        this.\u056f = 0.0f;
    }

    public oc29fb8ce47a \u00d8(Consumer<oc7ebeda7e63> consumer) {
        oc29fb8ce47a oc29fb8ce47a2;
        block66: {
            boolean bl;
            block68: {
                block67: {
                    oc7beea7ccff oc7beea7ccff2;
                    int n;
                    block64: {
                        block65: {
                            int n2;
                            oc7ebeda7e63 oc7ebeda7e632;
                            block61: {
                                block63: {
                                    block62: {
                                        float f;
                                        float f2;
                                        float f3;
                                        block60: {
                                            block59: {
                                                int n3;
                                                block58: {
                                                    block56: {
                                                        block57: {
                                                            float f4;
                                                            block53: {
                                                                float f5;
                                                                block55: {
                                                                    block54: {
                                                                        oc7ebeda7e63 oc7ebeda7e633;
                                                                        block50: {
                                                                            block51: {
                                                                                oc7beea7ccff oc7beea7ccff3;
                                                                                block52: {
                                                                                    oc7ebeda7e632 = new oc7ebeda7e63(this.\u03e1.thePlayer.rotationYaw, this.\u03e1.thePlayer.rotationPitch, this.\u0416, this.\u056f);
                                                                                    n = oc02a3730b27.\u0166;
                                                                                    consumer.accept(oc7ebeda7e632);
                                                                                    this.\u03be = this.\u02af;
                                                                                    this.\u02a6 = this.\u0126;
                                                                                    this.\u0416 = oc7ebeda7e632.\u01e3();
                                                                                    this.\u056f = oc7ebeda7e632.\u0172();
                                                                                    this.\u0279 = oc7ebeda7e632.\u0524();
                                                                                    oc7ebeda7e633 = oc7ebeda7e632;
                                                                                    if (n != 0) break block50;
                                                                                    if (oc7ebeda7e633.\u018c()) break block51;
                                                                                    oc7beea7ccff3 = this;
                                                                                    if (n != 0) break block52;
                                                                                    if (oc7beea7ccff3.\u01ca) break block51;
                                                                                    this.\u03e1.thePlayer.rotationYaw = this.\u02af = this.\u0394(this.\u02af, this.\u03e1.thePlayer.rotationYaw);
                                                                                    this.\u0126 = this.\u03e1.thePlayer.rotationPitch;
                                                                                    this.\u01ca = false;
                                                                                    oc7beea7ccff3 = this;
                                                                                }
                                                                                return oc7beea7ccff3.\u01e2();
                                                                            }
                                                                            oc7ebeda7e633 = oc7ebeda7e632;
                                                                        }
                                                                        float f6 = oc7ebeda7e633.\u0511();
                                                                        float f7 = Math.abs(oc75d51ec7eb.\u04cb());
                                                                        f4 = oc7beea7ccff.\u0166(f6, f7);
                                                                        float f8 = oc7beea7ccff.\u0142(this.\u00cf(oc7ebeda7e632.\u050b()), f4);
                                                                        float f9 = this.\u029a(oc7ebeda7e632.\u0266());
                                                                        this.\u02af = this.\u03be + f8;
                                                                        this.\u0126 = this.\u02a6 + f9;
                                                                        float[] fArray = new float[0xC6DFC311 ^ 0xC6DFC313];
                                                                        fArray[0] = this.\u03be;
                                                                        fArray[1] = this.\u02a6;
                                                                        float[] fArray2 = new float[0xC6DFC311 ^ 0xC6DFC313];
                                                                        fArray2[0] = this.\u02af;
                                                                        fArray2[1] = this.\u0126;
                                                                        float[] fArray3 = oc75d51ec7eb.\u0154(fArray, fArray2);
                                                                        this.\u02af = fArray3[0];
                                                                        this.\u0126 = Math.min(90.0f, fArray3[1]);
                                                                        n3 = oc7ebeda7e632.\u02a7();
                                                                        if (n != 0) break block53;
                                                                        if (n3 == 0) break block54;
                                                                        f5 = Math.abs(this.\u02af - this.\u03be);
                                                                        if (n != 0) break block55;
                                                                        f3 = f5;
                                                                        if (!(f3 >= 2.0f)) break block54;
                                                                        f5 = f3;
                                                                        if (n != 0) break block55;
                                                                        f2 = Math.abs(f5 - this.\u0428);
                                                                        if (f2 < 0.002f) {
                                                                            this.\u02af += oc75d51ec7eb.\u04cb();
                                                                        }
                                                                    }
                                                                    f5 = f4;
                                                                }
                                                                n3 = Float.isInfinite(f5);
                                                            }
                                                            if (n != 0) break block56;
                                                            if (n3 != 0) break block57;
                                                            this.\u02af = this.\u03be + oc7beea7ccff.\u0142(this.\u02af - this.\u03be, f4);
                                                        }
                                                        n3 = oc7ebeda7e632.\u02a7();
                                                    }
                                                    if (n != 0) break block58;
                                                    if (n3 == 0) break block59;
                                                    f = Math.abs(this.\u02af - this.\u03be);
                                                    if (n != 0) break block60;
                                                    float f6 = f - 2.0f;
                                                    n3 = f6 == 0.0f ? 0 : (f6 > 0.0f ? 1 : -1);
                                                }
                                                if (n3 >= 0) {
                                                    this.\u0428 = Math.abs(this.\u02af - this.\u03be);
                                                }
                                            }
                                            f = Math.abs(oc75d51ec7eb.\u0255(this.\u03e1.thePlayer.rotationYaw, this.\u02af));
                                        }
                                        f3 = f;
                                        f2 = Math.abs(this.\u03e1.thePlayer.rotationPitch - this.\u0126);
                                        float f11 = Math.max(1.0E-4f, oc75d51ec7eb.\u04cb() * 0.5f);
                                        oc7beea7ccff oc7beea7ccff4 = this;
                                        n2 = oc7ebeda7e632.\u018c();
                                        if (n != 0) break block61;
                                        if (n2 != 0) break block62;
                                        n2 = f3 == f11 ? 0 : (f3 > f11 ? 1 : -1);
                                        if (n != 0) break block61;
                                        if (n2 > 0) break block62;
                                        n2 = f2 == f11 ? 0 : (f2 > f11 ? 1 : -1);
                                        if (n != 0) break block61;
                                        if (n2 <= 0) break block63;
                                    }
                                    n2 = 1;
                                    break block61;
                                }
                                n2 = 0;
                            }
                            oc7beea7ccff4.\u01ca = n2;
                            oc7beea7ccff2 = this;
                            if (n != 0) break block64;
                            if (oc7beea7ccff2.\u01ca) break block65;
                            if (oc7ebeda7e632.\u018c()) break block65;
                            this.\u03e1.thePlayer.rotationYaw = this.\u02af = this.\u0394(this.\u02af, this.\u03e1.thePlayer.rotationYaw);
                            this.\u0126 = this.\u03e1.thePlayer.rotationPitch;
                        }
                        oc7beea7ccff2 = this;
                    }
                    oc29fb8ce47a2 = oc7beea7ccff2.\u01e2();
                    if (n == 0) break block66;
                    if (!false) break block67;
                    bl = false;
                    break block68;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return oc29fb8ce47a2;
    }

    public void \u0281(ocf242f30eaa ocf242f30eaa2) {
        this.\u04be(ocf242f30eaa2, this.\u02af);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void \u04be(ocf242f30eaa ocf242f30eaa2, float f) {
        float f2;
        block18: {
            block19: {
                boolean bl;
                int n;
                block17: {
                    block16: {
                        n = oc02a3730b27.\u0166;
                        bl = oc3de8a289c5.\u04d4();
                        if (n != 0) break block16;
                        if (!bl) return;
                        bl = this.\u01ca;
                    }
                    if (n != 0) break block17;
                    if (!bl) return;
                    f2 = ocf242f30eaa2.\u0391();
                    if (n != 0) break block18;
                    float f3 = f2 - 0.0f;
                    bl = f3 == 0.0f ? 0 : (f3 > 0.0f ? 1 : -1);
                }
                if (bl) break block19;
                f2 = ocf242f30eaa2.\u03a5();
                if (n != 0) break block18;
                if (f2 != 0.0f) break block19;
                return;
            }
            f2 = this.\u03e1.thePlayer.rotationYaw;
        }
        oc1c4f5dd176 oc1c4f5dd1762 = oc7beea7ccff.p(f2, f, ocf242f30eaa2.\u0391(), ocf242f30eaa2.\u03a5(), this.\u03e1.thePlayer.isSneaking());
        ocf242f30eaa2.\u045e(oc1c4f5dd1762.\u02e0);
        ocf242f30eaa2.I(oc1c4f5dd1762.\u00f4);
    }

    public static oc1c4f5dd176 p(float f, float f2, float f3, float f4, boolean bl) {
        float f5;
        float f6;
        block56: {
            block55: {
                float f7;
                int n;
                block52: {
                    block54: {
                        double d;
                        block53: {
                            float f8;
                            float f9;
                            block50: {
                                block51: {
                                    float f10;
                                    block47: {
                                        block49: {
                                            block48: {
                                                double d2;
                                                double d3;
                                                block44: {
                                                    block46: {
                                                        block45: {
                                                            float f11;
                                                            block42: {
                                                                block43: {
                                                                    n = oc02a3730b27.\u0166;
                                                                    f11 = f3;
                                                                    if (n != 0) break block42;
                                                                    if (f11 != 0.0f) break block43;
                                                                    f11 = f4;
                                                                    if (n != 0) break block42;
                                                                    if (f11 != 0.0f) break block43;
                                                                    return new oc1c4f5dd176(0.0f, 0.0f);
                                                                }
                                                                f11 = oc7beea7ccff.\u00b5((float)Math.toRadians(MathHelper.wrapAngleTo180_float(f)) + (float)Math.atan2(-f4, f3));
                                                            }
                                                            float f12 = f11;
                                                            f9 = oc7beea7ccff.\u00b5(f12 - (float)Math.toRadians(f2));
                                                            d3 = f9;
                                                            d2 = -1.1780972450961724;
                                                            if (n != 0) break block44;
                                                            if (!(d3 >= d2)) break block45;
                                                            d3 = f9;
                                                            if (n != 0) break block46;
                                                            if (!(d3 <= 1.1780972450961724)) break block45;
                                                            f10 = 1.0f;
                                                            break block47;
                                                        }
                                                        f10 = f9;
                                                        if (n != 0) break block47;
                                                        d3 = f10;
                                                    }
                                                    d2 = -1.9634954084936207;
                                                }
                                                if (d3 <= d2) break block48;
                                                f10 = f9;
                                                if (n != 0) break block47;
                                                if (!((double)f10 >= 1.9634954084936207)) break block49;
                                            }
                                            f10 = -1.0f;
                                            break block47;
                                        }
                                        f10 = 0.0f;
                                    }
                                    f6 = f10;
                                    f8 = f9;
                                    if (n != 0) break block50;
                                    if (!((double)f8 >= 0.39269908169872414)) break block51;
                                    f8 = f9;
                                    if (n != 0) break block50;
                                    if (!((double)f8 <= 2.748893571891069)) break block51;
                                    f7 = -1.0f;
                                    break block52;
                                }
                                f8 = f9;
                            }
                            d = f8;
                            if (n != 0) break block53;
                            if (!(d <= -0.39269908169872414)) break block54;
                            f7 = f9;
                            if (n != 0) break block52;
                            d = f7;
                        }
                        if (!(d >= -2.748893571891069)) break block54;
                        f7 = 1.0f;
                        break block52;
                    }
                    f7 = 0.0f;
                }
                f5 = f7;
                if (n != 0) break block55;
                if (!bl) break block56;
                f6 *= 0.3f;
            }
            f5 *= 0.3f;
        }
        return new oc1c4f5dd176(f6, f5);
    }

    public void \u0523(oc55585a6f85 oc55585a6f852) {
        this.\u0243(oc55585a6f852, this.\u02af);
    }

    public void \u0243(oc55585a6f85 oc55585a6f852, float f) {
        block8: {
            boolean bl;
            block7: {
                int n = oc02a3730b27.\u0166;
                bl = oc3de8a289c5.\u04d4();
                if (n != 0) break block7;
                if (!bl) break block8;
                bl = this.\u01ca;
            }
            if (bl) {
                oc55585a6f852.\u011a(f);
            }
        }
    }

    public void \u0543(oc4c5a4d3446 oc4c5a4d34462) {
        this.\u0244(oc4c5a4d34462, this.\u02af);
    }

    public void \u0244(oc4c5a4d3446 oc4c5a4d34462, float f) {
        block8: {
            boolean bl;
            block7: {
                int n = oc02a3730b27.\u0166;
                bl = oc3de8a289c5.\u04d4();
                if (n != 0) break block7;
                if (!bl) break block8;
                bl = this.\u01ca;
            }
            if (bl) {
                oc4c5a4d34462.\u0156(f);
            }
        }
    }

    public boolean \u03b0() {
        boolean bl;
        block8: {
            block7: {
                oc7beea7ccff oc7beea7ccff2;
                block6: {
                    int n = oc02a3730b27.\u0166;
                    oc7beea7ccff2 = this;
                    if (n != 0) break block6;
                    if (!oc7beea7ccff2.\u0279) break block7;
                    oc7beea7ccff2 = this;
                }
                if (oc7beea7ccff2.\u03e1.thePlayer == null) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u0131() {
        return this.\u01ca;
    }

    public float \u0265() {
        return this.\u02af;
    }

    public float \u050f() {
        return this.\u03be;
    }

    public float k() {
        return this.\u0126;
    }

    public float U() {
        return this.\u02a6;
    }

    public void \u0442(float f, float f2) {
        block18: {
            float f3;
            block17: {
                int n;
                block15: {
                    block16: {
                        n = oc02a3730b27.\u0166;
                        f3 = f;
                        if (n != 0) break block15;
                        if (Float.isNaN(f3)) break block16;
                        f3 = f;
                        if (n != 0) break block15;
                        if (Float.isInfinite(f3)) break block16;
                        this.\u02af = f;
                    }
                    f3 = f2;
                }
                if (n != 0) break block17;
                if (Float.isNaN(f3)) break block18;
                f3 = f2;
            }
            if (!Float.isInfinite(f3)) {
                this.\u0126 = f2;
            }
        }
    }

    public float \u03f7() {
        return Math.max(this.\u0416, this.\u056f);
    }

    public float \u02b1() {
        return this.\u0416;
    }

    public float \u049a() {
        return this.\u056f;
    }

    private oc29fb8ce47a \u01e2() {
        return new oc29fb8ce47a(this.\u02af, this.\u0126, this.\u03be, this.\u02a6, this.\u01ca, this.\u0416, this.\u056f);
    }

    public static float \u00b5(float f) {
        float f2;
        block2: {
            block3: {
                float f3 = (float)Math.PI * 2;
                f = (f + (float)Math.PI) % f3;
                int n = oc02a3730b27.\u0166;
                f2 = f;
                if (n != 0) break block2;
                if (!(f2 < 0.0f)) break block3;
                f += f3;
            }
            f2 = f - (float)Math.PI;
        }
        return f2;
    }

    private float \u00cf(float f) {
        float f2 = MathHelper.wrapAngleTo180_float(MathHelper.wrapAngleTo180_float(f) - MathHelper.wrapAngleTo180_float(this.\u03be));
        float f3 = (float)((double)this.\u0416 * (Math.sin(Math.toRadians(Math.abs(f2))) / 2.0 + 0.5));
        return Math.min(f3, Math.abs(f2)) * Math.signum(f2);
    }

    private float \u029a(float f) {
        float f2 = f - this.\u02a6;
        float f3 = (float)((double)this.\u056f * (Math.sin(Math.toRadians(Math.abs(f2))) / 2.0 + 0.5));
        return Math.min(f3, Math.abs(f2)) * Math.signum(f2);
    }

    public static float \u0142(float f, float f2) {
        float f3;
        block10: {
            block11: {
                float f4;
                block8: {
                    block9: {
                        int n = oc02a3730b27.\u0166;
                        f4 = f2;
                        if (n != 0) break block8;
                        if (Float.isNaN(f4)) break block9;
                        f3 = f2;
                        if (n != 0) break block10;
                        if (!Float.isInfinite(f3)) break block11;
                    }
                    f4 = f;
                }
                return f4;
            }
            f3 = Math.max(0.0f, f2);
        }
        float f5 = f3;
        return Math.max(-f5, Math.min(f5, f));
    }

    public static float \u0166(float f, float f2) {
        float f3;
        block26: {
            float f4;
            float f5;
            block27: {
                float f6;
                block24: {
                    block25: {
                        float f7;
                        int n;
                        block22: {
                            block23: {
                                float f8;
                                block20: {
                                    block21: {
                                        n = oc02a3730b27.\u0166;
                                        f8 = f;
                                        if (n != 0) break block20;
                                        if (Float.isNaN(f8)) break block21;
                                        f7 = f;
                                        if (n != 0) break block22;
                                        if (!Float.isInfinite(f7)) break block23;
                                    }
                                    f8 = Float.POSITIVE_INFINITY;
                                }
                                return f8;
                            }
                            f7 = Math.max(0.0f, f);
                        }
                        f5 = f7;
                        f4 = Math.abs(f2);
                        f6 = f4;
                        if (n != 0) break block24;
                        if (Float.isNaN(f6)) break block25;
                        f6 = f4;
                        if (n != 0) break block24;
                        if (Float.isInfinite(f6)) break block25;
                        f3 = f4;
                        if (n != 0) break block26;
                        if (!(f3 <= 0.0f)) break block27;
                    }
                    f6 = f5;
                }
                return f6;
            }
            f3 = (float)Math.floor((double)f5 / (double)f4) * f4;
        }
        return f3;
    }

    private float \u0394(float f, float f2) {
        float f3 = f - f2;
        float f4 = Math.round(f3 / 360.0f);
        return f2 + f4 * 360.0f;
    }
}

