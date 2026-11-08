/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc1378bc114d;
import x.oc7ab2161b9f;
import x.oc93499ec6de;
import x.ocd2958dac48;
import x.ocd9533bdf8b;
import x.oce6044968f8;

public class oce9c793ea6c
implements oc1378bc114d {
    private final oc1378bc114d \u0399;
    private final boolean \u0223;

    private oce9c793ea6c(oc1378bc114d oc1378bc114d2) {
        this(oc1378bc114d2, false);
    }

    private oce9c793ea6c(oc1378bc114d oc1378bc114d2, boolean bl) {
        this.\u0399 = oc1378bc114d2;
        this.\u0223 = bl;
    }

    @Override
    public int z$ao2ykh4tuw6w(String string, float f, float f2, int n, boolean bl) {
        int n2;
        block2: {
            int n3;
            block3: {
                n3 = n >>> (0x9591CE4F ^ 0x9591CE57);
                boolean bl2 = oce6044968f8.\u0452;
                n2 = n3;
                if (bl2) break block2;
                if (n2 != 0) break block3;
                n3 = 0x9591CEA8 ^ 0x9591CE57;
            }
            n2 = n3;
        }
        int n4 = n2;
        return this.z$22eyp2803ejhs(string, f, f2, (arg_0, arg_1, arg_2, arg_3) -> oce9c793ea6c.q101jweq7e9hnj(n, n4, arg_0, arg_1, arg_2, arg_3), bl);
    }

    @Override
    public int z$22eyp2803ejhs(String string, float f, float f2, ocd9533bdf8b ocd9533bdf8b2, boolean bl) {
        boolean bl2;
        ocd9533bdf8b ocd9533bdf8b3;
        float f3;
        float f4;
        String string2;
        oc1378bc114d oc1378bc114d2;
        block16: {
            block15: {
                boolean bl3;
                block14: {
                    float f5;
                    oc93499ec6de oc93499ec6de2;
                    block13: {
                        int n;
                        float f6;
                        block11: {
                            block12: {
                                oc93499ec6de2 = oce6044968f8.\u015c();
                                f6 = (float)oc93499ec6de2.\u025f.\u04c1() / 255.0f * oce6044968f8.\u04da;
                                bl3 = oce6044968f8.\u0452;
                                n = oce6044968f8.\u013a;
                                if (bl3) break block11;
                                if (n == 0) break block12;
                                f6 *= (float)oc93499ec6de2.\u0405.\u04c1() / 255.0f;
                            }
                            f5 = f6;
                            if (bl3) break block13;
                            float f7 = f5 - 0.0f;
                            n = f7 == 0.0f ? 0 : (f7 < 0.0f ? -1 : 1);
                        }
                        if (n <= 0) {
                            return Math.round(f) + this.z$toz8pt08w0nc(string);
                        }
                        f5 = f6;
                    }
                    float f8 = f5;
                    float f9 = f + oce6044968f8.\u045c();
                    float f10 = f2 + oce6044968f8.\u0479();
                    oc1378bc114d2 = this.\u0399;
                    string2 = string;
                    f4 = f9;
                    f3 = f10;
                    ocd9533bdf8b3 = (arg_0, arg_1, arg_2, arg_3) -> this.q2tv9lib44i621(ocd9533bdf8b2, oc93499ec6de2, f9, f10, f8, arg_0, arg_1, arg_2, arg_3);
                    bl2 = oce6044968f8.\u013a;
                    if (bl3) break block14;
                    if (bl2) break block15;
                    bl2 = ocd2958dac48.\u0443();
                }
                if (bl3) break block16;
                if (!bl2) break block15;
                bl2 = true;
                break block16;
            }
            bl2 = false;
        }
        return oc1378bc114d2.z$22eyp2803ejhs(string2, f4, f3, ocd9533bdf8b3, bl2);
    }

    @Override
    public int z$toz8pt08w0nc(String string) {
        return this.\u0399.z$toz8pt08w0nc(string);
    }

    @Override
    public int z$1tqmx4tpnr6lq() {
        return this.\u0399.z$1tqmx4tpnr6lq();
    }

    @Override
    public int z$3hte9fh87zo6x() {
        return this.\u0399.z$3hte9fh87zo6x();
    }

    @Override
    public float z$3l314uvjy8lta() {
        return this.\u0399.z$3l314uvjy8lta();
    }

    @Override
    public int z$g5bxucc1j700() {
        return this.\u0399.z$g5bxucc1j700();
    }

    @Override
    public int z$w1h9nvoglpkn() {
        return this.\u0399.z$w1h9nvoglpkn();
    }

    private int q2tv9lib44i621(ocd9533bdf8b ocd9533bdf8b2, oc93499ec6de oc93499ec6de2, float f, float f2, float f3, char c, float f4, float f5, Integer n) {
        int n2;
        int n3;
        block40: {
            int n4;
            block41: {
                int n5;
                int n6;
                boolean bl;
                int n7;
                block35: {
                    oc93499ec6de oc93499ec6de3;
                    block38: {
                        block39: {
                            double d;
                            block36: {
                                block37: {
                                    boolean bl2;
                                    block33: {
                                        block34: {
                                            block32: {
                                                Integer n8;
                                                block31: {
                                                    int n9;
                                                    block42: {
                                                        block30: {
                                                            boolean bl3;
                                                            block28: {
                                                                block29: {
                                                                    n7 = ocd9533bdf8b2.z$151wba1mm8frh(c, f4, f5, n);
                                                                    bl = oce6044968f8.\u0452;
                                                                    bl3 = this.\u0223;
                                                                    if (bl) break block28;
                                                                    if (bl3) break block29;
                                                                    bl3 = oce6044968f8.\u013a;
                                                                    if (bl) break block28;
                                                                    if (!bl3) break block30;
                                                                }
                                                                bl3 = oc93499ec6de2.\u03e7.\u01ed();
                                                            }
                                                            float f6 = bl3 ? f + f4 : f;
                                                            n9 = oce6044968f8.\u022d(f6, f2);
                                                            break block42;
                                                        }
                                                        n9 = n7;
                                                    }
                                                    n6 = n9;
                                                    n8 = n;
                                                    if (bl) break block31;
                                                    if (n8 == null) break block32;
                                                    n8 = n;
                                                }
                                                n5 = n8;
                                                break block35;
                                            }
                                            bl2 = this.\u0223;
                                            if (bl) break block33;
                                            if (bl2) break block34;
                                            n5 = n7;
                                            break block35;
                                        }
                                        d = oc93499ec6de2.\u00e3.\u04c1();
                                        if (bl) break block36;
                                        double d2 = d - 0.0;
                                        bl2 = d2 == 0.0 ? 0 : (d2 > 0.0 ? 1 : -1);
                                    }
                                    if (bl2) break block37;
                                    n5 = n6;
                                    break block35;
                                }
                                oc93499ec6de3 = oc93499ec6de2;
                                if (bl) break block38;
                                d = oc93499ec6de3.\u00e3.\u04c1();
                            }
                            if (d != 1.0) break block39;
                            n5 = -1;
                            break block35;
                        }
                        oc93499ec6de3 = oc93499ec6de2;
                    }
                    n5 = oc93499ec6de3.\u00e4.\u0373();
                }
                n4 = n5;
                n3 = Math.round((float)(n7 >>> (0xDEF57D2C ^ 0xDEF57D34)) * f3);
                n2 = oce6044968f8.\u013a;
                if (bl) break block40;
                if (n2 == 0) break block41;
                n2 = oce6044968f8.\u03ae(n4, n6);
                break block40;
            }
            n2 = n4;
        }
        return oc7ab2161b9f.\u04ac(n2, n3);
    }

    private static int q101jweq7e9hnj(int n, int n2, char c, float f, float f2, Integer n3) {
        int n4;
        block4: {
            block3: {
                Integer n5;
                block2: {
                    boolean bl = oce6044968f8.\u0452;
                    n5 = n3;
                    if (bl) break block2;
                    if (n5 == null) break block3;
                    n5 = n3;
                }
                n4 = n5;
                break block4;
            }
            n4 = n;
        }
        return oc7ab2161b9f.\u04ac(n4, n2);
    }
}

