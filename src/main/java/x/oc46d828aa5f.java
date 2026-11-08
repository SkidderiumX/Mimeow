/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;
import x.oc02a3730b27;
import x.oc69da1aa7f5;
import x.oc75d51ec7eb;
import x.oc86de9e2892;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.ocf1568fef75;

public class oc46d828aa5f {
    private static final String[] \u018a;
    private static final String[] \u04a1;
    private final Minecraft \u00e8 = Minecraft.getMinecraft();
    private final oc69da1aa7f5 \u04e3;
    private final occ2f8dff8d8 \u01aa;
    private final oca9cc61aada \u053e;
    private final oca9cc61aada \u00c4;
    private final oca9cc61aada \u042e;
    private final oca9cc61aada \u0219;
    private final oca9cc61aada L;
    private final oca9cc61aada \u03bd;
    private final ocf1568fef75 \u0540;
    private final Deque<Float> \u02ac = new ArrayDeque<Float>();
    private float \u0493;
    private float \u0292;
    private double \u0532;
    private double \u0286;
    private boolean \u03e3;
    public static boolean \u013e;

    public oc46d828aa5f(oc69da1aa7f5 oc69da1aa7f52) {
        this.\u04e3 = oc69da1aa7f52;
        this.\u01aa = new occ2f8dff8d8("Silent", true);
        oc69da1aa7f52.\u028c(this.\u01aa);
        this.\u053e = new oca9cc61aada("Angle limiter", 0, \u018a);
        oc69da1aa7f52.\u028c(this.\u053e);
        this.\u00c4 = new oca9cc61aada("Yaw speed", 180.0, 1.0, 180.0, 1.0);
        oc69da1aa7f52.\u028c(this.\u00c4);
        this.\u042e = new oca9cc61aada("Pitch speed", 180.0, 1.0, 180.0, 1.0);
        oc69da1aa7f52.\u028c(this.\u042e);
        this.\u0219 = new oca9cc61aada("Max delta history size", 20.0, 0.0, 20.0, 1.0);
        oc69da1aa7f52.\u028c(this.\u0219);
        this.L = new oca9cc61aada("Average yaw limiter mode", 0xAFC2E723 ^ 0xAFC2E721, \u04a1);
        oc69da1aa7f52.\u028c(this.L);
        this.\u03bd = new oca9cc61aada("Max average yaw delta", 90.0, 1.0, 180.0, 1.0);
        oc69da1aa7f52.\u028c(this.\u03bd);
        this.\u0540 = new ocf1568fef75("Yaw multiplier on limit", 0.0, 1.0, 0.1, 1.0, 0.01);
        oc69da1aa7f52.\u028c(this.\u0540);
        this.\u057c();
    }

    public void \u057c() {
        int n;
        double d;
        boolean bl;
        block20: {
            block19: {
                int n2;
                block18: {
                    double d2;
                    block16: {
                        block17: {
                            int n3;
                            block14: {
                                block15: {
                                    n2 = oc02a3730b27.\u0166;
                                    n3 = (int)this.\u053e.\u04c1();
                                    if (n2 != 0) break block14;
                                    if (n3 == (0xF41A3706 ^ 0xF41A3705)) break block15;
                                    n3 = 1;
                                    break block14;
                                }
                                n3 = 0;
                            }
                            bl = n3;
                            double d3 = this.\u0219.\u04c1() - 0.0;
                            d2 = d3 == 0.0 ? 0 : (d3 > 0.0 ? 1 : -1);
                            if (n2 != 0) break block16;
                            if (d2 <= 0) break block17;
                            d2 = 1.0;
                            break block16;
                        }
                        d2 = 0.0;
                    }
                    d = d2;
                    n = d;
                    if (n2 != 0) break block18;
                    if (n == false) break block19;
                    n = (int)this.L.\u04c1();
                }
                if (n2 != 0) break block20;
                if (n != 1) break block19;
                n = 1;
                break block20;
            }
            n = 0;
        }
        double d4 = n;
        this.\u00c4.\u0209(bl, this.\u04e3);
        this.\u042e.\u0209(bl, this.\u04e3);
        this.L.\u0209((boolean)d, this.\u04e3);
        this.\u03bd.\u0209((boolean)d4, this.\u04e3);
        this.\u0540.\u0209((boolean)d4, this.\u04e3);
    }

    public float[] D(oc86de9e2892 oc86de9e28922) {
        float f;
        float f2;
        block25: {
            oc46d828aa5f oc46d828aa5f2;
            block23: {
                block24: {
                    int n;
                    block22: {
                        oc86de9e2892 oc86de9e28923;
                        block21: {
                            float f3;
                            block20: {
                                oc46d828aa5f oc46d828aa5f3;
                                block18: {
                                    block19: {
                                        block17: {
                                            oc86de9e2892 oc86de9e28924;
                                            block16: {
                                                n = oc02a3730b27.\u0166;
                                                oc86de9e28924 = oc86de9e28922;
                                                if (n != 0) break block16;
                                                if (oc86de9e28924.\u04dc == null) break block17;
                                                oc86de9e28924 = oc86de9e28922;
                                            }
                                            f3 = oc86de9e28924.\u04dc.floatValue();
                                            break block20;
                                        }
                                        oc46d828aa5f3 = this;
                                        if (n != 0) break block18;
                                        if (!oc46d828aa5f3.\u03e3) break block19;
                                        f3 = this.\u0493;
                                        break block20;
                                    }
                                    oc46d828aa5f3 = this;
                                }
                                f3 = oc46d828aa5f3.\u00e8.thePlayer.rotationYaw;
                            }
                            f2 = f3;
                            oc86de9e28923 = oc86de9e28922;
                            if (n != 0) break block21;
                            if (oc86de9e28923.\u0177 == null) break block22;
                            oc86de9e28923 = oc86de9e28922;
                        }
                        f = oc86de9e28923.\u0177.floatValue();
                        break block25;
                    }
                    oc46d828aa5f2 = this;
                    if (n != 0) break block23;
                    if (!oc46d828aa5f2.\u03e3) break block24;
                    f = this.\u0292;
                    break block25;
                }
                oc46d828aa5f2 = this;
            }
            f = oc46d828aa5f2.\u00e8.thePlayer.rotationPitch;
        }
        float f4 = f;
        float[] fArray = new float[0x14409F80 ^ 0x14409F82];
        fArray[0] = f2;
        fArray[1] = f4;
        return fArray;
    }

    public float[] \u049e(oc86de9e2892 oc86de9e28922, float[] fArray) {
        float[] fArray2 = this.D(oc86de9e28922);
        float[] fArray3 = this.\u04be(fArray2, fArray);
        fArray3 = oc75d51ec7eb.\u0154(fArray2, fArray3);
        fArray3[1] = MathHelper.clamp_float(fArray3[1], -90.0f, 90.0f);
        this.n(fArray2, fArray3);
        oc86de9e28922.\u0567(Float.valueOf(fArray3[0]), Float.valueOf(fArray3[1]));
        return fArray3;
    }

    public float[] \u01db(oc86de9e2892 oc86de9e28922, float[] fArray, int n) {
        float[] fArray2 = this.D(oc86de9e28922);
        int n2 = oc02a3730b27.\u0166;
        float[] fArray3 = this.\u04be(fArray2, fArray);
        if (n2 == 0) {
            fArray3 = oc75d51ec7eb.\u0154(fArray2, fArray3);
            fArray3[1] = MathHelper.clamp_float(fArray3[1], -90.0f, 90.0f);
            if (!oc86de9e28922.\u043b(this.\u04e3, n, Float.valueOf(fArray3[0]), Float.valueOf(fArray3[1]))) {
                return null;
            }
            this.n(fArray2, fArray3);
        }
        return fArray3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void n(float[] fArray, float[] fArray2) {
        block6: {
            int n;
            block5: {
                n = oc02a3730b27.\u0166;
                oc46d828aa5f oc46d828aa5f2 = this;
                if (n != 0) break block5;
                oc46d828aa5f2.\u0143(fArray[0], fArray2[0]);
                this.\u0493 = fArray2[0];
                this.\u0292 = fArray2[1];
                this.\u03e3 = true;
                if (this.\u01aa.\u01ed()) break block6;
                this.\u00e8.thePlayer.rotationYaw = fArray2[0];
                oc46d828aa5f2 = this;
            }
            oc46d828aa5f2.\u00e8.thePlayer.rotationPitch = fArray2[1];
            if (n == 0) return;
        }
        oc75d51ec7eb.\u010d(fArray2[0], fArray2[1]);
    }

    public void \u024c() {
        this.\u02ac.clear();
        this.\u0532 = 0.0;
        this.\u0286 = 0.0;
        this.\u03e3 = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private float[] \u04be(float[] fArray, float[] fArray2) {
        double d;
        double d2;
        block17: {
            block15: {
                block16: {
                    float f;
                    float f2;
                    double d3;
                    int n;
                    int n2;
                    float f3;
                    float f4;
                    block14: {
                        block13: {
                            block12: {
                                int n3;
                                block11: {
                                    f4 = MathHelper.wrapAngleTo180_float(fArray2[0] - fArray[0]);
                                    f3 = MathHelper.wrapAngleTo180_float(fArray2[1] - fArray[1]);
                                    f4 = this.\u00dc(f4);
                                    n2 = oc02a3730b27.\u0166;
                                    n3 = n = (int)this.\u053e.\u04c1();
                                    if (n2 != 0) break block11;
                                    if (n3 != (0x8FFC3779 ^ 0x8FFC377A)) break block12;
                                    n3 = 0x8FFC3778 ^ 0x8FFC377A;
                                }
                                float[] fArray3 = new float[n3];
                                fArray3[0] = fArray[0] + f4;
                                fArray3[1] = fArray[1] + f3;
                                return fArray3;
                            }
                            d3 = Math.max(1.0E-6, Math.hypot(Math.abs(f4), Math.abs(f3)));
                            f2 = Math.min((float)this.\u00c4.\u04c1() / 3.0f, 180.0f);
                            f = Math.min((float)this.\u042e.\u04c1() / 3.0f, 180.0f);
                            if (n2 != 0) break block13;
                            if (n != (0x8FFC3778 ^ 0x8FFC377A)) break block14;
                            f2 = MathHelper.clamp_float(Math.abs(f4) / 180.0f * f2, oc46d828aa5f.\u03b3(4.0f, 6.0f), 180.0f);
                        }
                        f = MathHelper.clamp_float(Math.abs(f3) / 180.0f * f, oc46d828aa5f.\u03b3(4.0f, 6.0f), 180.0f);
                    }
                    double d4 = Math.abs((double)f4 / d3) * (double)f2;
                    double d5 = Math.abs((double)f3 / d3) * (double)f;
                    d2 = MathHelper.clamp_double(f4, -d4, d4);
                    d = MathHelper.clamp_double(f3, -d5, d5);
                    if (n2 != 0) break block15;
                    if (n != 1) break block16;
                    this.\u0532 += (d2 - this.\u0532) * 0.25;
                    this.\u0286 += (d - this.\u0286) * 0.25;
                    d2 = this.\u0532;
                    d = this.\u0286;
                    if (n2 == 0) break block17;
                }
                this.\u0532 = d2;
            }
            this.\u0286 = d;
        }
        float[] fArray4 = new float[0x8FFC3778 ^ 0x8FFC377A];
        fArray4[0] = fArray[0] + (float)d2;
        fArray4[1] = fArray[1] + (float)d;
        return fArray4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private float \u00dc(float f) {
        float f2;
        float f32;
        block27: {
            double d;
            float f4;
            block24: {
                int n;
                block25: {
                    float f5;
                    block26: {
                        float f6;
                        block23: {
                            oc46d828aa5f oc46d828aa5f2;
                            block22: {
                                n = oc02a3730b27.\u0166;
                                oc46d828aa5f2 = this;
                                if (n != 0) break block22;
                                if (oc46d828aa5f2.\u02ac.isEmpty()) return f;
                                oc46d828aa5f2 = this;
                            }
                            if ((int)oc46d828aa5f2.L.\u04c1() == (0xFABC6E17 ^ 0xFABC6E15)) {
                                return f;
                            }
                            float f7 = 0.0f;
                            for (float f32 : this.\u02ac) {
                                f6 = f7;
                                if (n == 0) {
                                    f7 = f6 + f32;
                                    if (n == 0) continue;
                                }
                                break block23;
                            }
                            f6 = Math.abs(f7 / (float)this.\u02ac.size());
                        }
                        f4 = f6;
                        d = this.L.\u04c1();
                        if (n != 0) break block24;
                        if ((int)d != 0) break block25;
                        f5 = f4;
                        if (n != 0) return f5;
                        if (!(f5 > 50.0f)) break block26;
                        return 0.0f;
                    }
                    f5 = f;
                    return f5;
                }
                f2 = f4;
                if (n != 0) break block27;
                d = f2;
            }
            if (d <= this.\u03bd.\u04c1()) {
                return f;
            }
            f2 = 1.0f - MathHelper.clamp_float((f4 - (float)this.\u03bd.\u04c1()) / (float)this.\u03bd.\u04c1(), 0.0f, 1.0f);
        }
        f32 = f2;
        double d = this.\u0540.\u00f6() + (this.\u0540.\u0456() - this.\u0540.\u00f6()) * (double)f32;
        return (float)((double)f * d);
    }

    private void \u0143(float f, float f2) {
        int n;
        int n2;
        block6: {
            block5: {
                n2 = oc02a3730b27.\u0166;
                n = (int)this.\u0219.\u04c1();
                if (n2 != 0) break block5;
                if (n > 0) break block6;
                this.\u02ac.clear();
            }
            return;
        }
        this.\u02ac.addLast(Float.valueOf(MathHelper.wrapAngleTo180_float(f - f2)));
        while (this.\u02ac.size() > n) {
            this.\u02ac.removeFirst();
            if (n2 == 0) continue;
        }
    }

    private static float \u03b3(float f, float f2) {
        return f + ThreadLocalRandom.current().nextFloat() * (f2 - f);
    }

    static {
        String[] stringArray = new String[0x1E95A286 ^ 0x1E95A282];
        stringArray[0] = "Linear";
        stringArray[1] = "Accelerated";
        stringArray[0x1E95A280 ^ 0x1E95A282] = "Interpolated";
        stringArray[0x1E95A281 ^ 0x1E95A282] = "None";
        \u018a = stringArray;
        String[] stringArray2 = new String[0x1E95A281 ^ 0x1E95A282];
        stringArray2[0] = "NCP";
        stringArray2[1] = "Custom";
        stringArray2[0x1E95A280 ^ 0x1E95A282] = "None";
        \u04a1 = stringArray2;
    }
}

