/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;
import x.oc75d51ec7eb;

public enum oc3d8ab304f7 {
    P;
    private static final oc3d8ab304f7[] $VALUES_REF;
    public static final /* enum */ oc3d8ab304f7 \u00ee = new oc3d8ab304f7(d -> d);
    public static final /* enum */ oc3d8ab304f7 \u0572 = new oc3d8ab304f7(d -> d * d);
    public static final /* enum */ oc3d8ab304f7 \u04d5 = new oc3d8ab304f7(d -> d * (2.0 - d));
    public static final /* enum */ oc3d8ab304f7 \u0466 = new oc3d8ab304f7(d -> {
        double d2;
        block6: {
            double d3;
            block4: {
                block5: {
                    int n = oc75d51ec7eb.\u03e9;
                    d3 = d;
                    if (n != 0) break block4;
                    if (!(d3 < 0.5)) break block5;
                    d2 = 2.0 * d * d;
                    break block6;
                }
                d3 = -1.0;
            }
            d2 = d3 + (4.0 - 2.0 * d) * d;
        }
        return d2;
    });
    public static final /* enum */ oc3d8ab304f7 \u04ce = new oc3d8ab304f7(d -> d * d * d);
    public static final /* enum */ oc3d8ab304f7 \u0436 = new oc3d8ab304f7(d -> {
        d = d - 1.0;
        return d * d * d + 1.0;
    });
    public static final /* enum */ oc3d8ab304f7 \u028e = new oc3d8ab304f7(d -> {
        double d2;
        block6: {
            double d3;
            block4: {
                block5: {
                    int n = oc75d51ec7eb.\u03e9;
                    d3 = d;
                    if (n != 0) break block4;
                    if (!(d3 < 0.5)) break block5;
                    d2 = 4.0 * d * d * d;
                    break block6;
                }
                d3 = (d - 1.0) * (2.0 * d - 2.0) * (2.0 * d - 2.0);
            }
            d2 = d3 + 1.0;
        }
        return d2;
    });
    public static final /* enum */ oc3d8ab304f7 \u0527 = new oc3d8ab304f7(d -> d * d * d * d);
    public static final /* enum */ oc3d8ab304f7 \u0510 = new oc3d8ab304f7(d -> {
        d = d - 1.0;
        return 1.0 - d * d * d * d;
    });
    public static final /* enum */ oc3d8ab304f7 \u0230 = new oc3d8ab304f7(d -> {
        double d2;
        block6: {
            double d3;
            block4: {
                block5: {
                    int n = oc75d51ec7eb.\u03e9;
                    d3 = d;
                    if (n != 0) break block4;
                    if (!(d3 < 0.5)) break block5;
                    d2 = 8.0 * d * d * d * d;
                    break block6;
                }
                d3 = 1.0;
            }
            d = d - 1.0;
            d2 = d3 - 8.0 * d * d * d * d;
        }
        return d2;
    });
    public static final /* enum */ oc3d8ab304f7 \u0246 = new oc3d8ab304f7(d -> d * d * d * d * d);
    public static final /* enum */ oc3d8ab304f7 \u041e = new oc3d8ab304f7(d -> {
        d = d - 1.0;
        return 1.0 + d * d * d * d * d;
    });
    public static final /* enum */ oc3d8ab304f7 \u04e8 = new oc3d8ab304f7(d -> {
        double d2;
        block6: {
            double d3;
            block4: {
                block5: {
                    int n = oc75d51ec7eb.\u03e9;
                    d3 = d;
                    if (n != 0) break block4;
                    if (!(d3 < 0.5)) break block5;
                    d2 = 16.0 * d * d * d * d * d;
                    break block6;
                }
                d3 = 1.0;
            }
            d = d - 1.0;
            d2 = d3 + 16.0 * d * d * d * d * d;
        }
        return d2;
    });
    public static final /* enum */ oc3d8ab304f7 \u0534 = new oc3d8ab304f7(d -> 1.0 - Math.cos(d * Math.PI / 2.0));
    public static final /* enum */ oc3d8ab304f7 \u0564 = new oc3d8ab304f7(d -> Math.sin(d * Math.PI / 2.0));
    public static final /* enum */ oc3d8ab304f7 \u04ab = new oc3d8ab304f7(d -> 1.0 - Math.cos(Math.PI * d / 2.0));
    public static final /* enum */ oc3d8ab304f7 \u03ca = new oc3d8ab304f7(d -> {
        double d2;
        block6: {
            double d3;
            block4: {
                block5: {
                    int n = oc75d51ec7eb.\u03e9;
                    d3 = d;
                    if (n != 0) break block4;
                    if (d3 != 0.0) break block5;
                    d2 = 0.0;
                    break block6;
                }
                d3 = 2.0;
            }
            d2 = Math.pow(d3, 10.0 * d - 10.0);
        }
        return d2;
    });
    public static final /* enum */ oc3d8ab304f7 \u0403 = new oc3d8ab304f7(d -> {
        double d2;
        block6: {
            double d3;
            block4: {
                block5: {
                    int n = oc75d51ec7eb.\u03e9;
                    d3 = d;
                    if (n != 0) break block4;
                    if (d3 != 1.0) break block5;
                    d2 = 1.0;
                    break block6;
                }
                d3 = 1.0;
            }
            d2 = d3 - Math.pow(2.0, -10.0 * d);
        }
        return d2;
    });
    public static final /* enum */ oc3d8ab304f7 \u0262 = new oc3d8ab304f7(d -> {
        double d2;
        block14: {
            double d3;
            block17: {
                block18: {
                    Double d4;
                    int n;
                    block15: {
                        block16: {
                            double d5;
                            block12: {
                                block13: {
                                    n = oc75d51ec7eb.\u03e9;
                                    d5 = d;
                                    if (n != 0) break block12;
                                    if (d5 != 0.0) break block13;
                                    d2 = 0.0;
                                    break block14;
                                }
                                d4 = d;
                                if (n != 0) break block15;
                                d5 = d4;
                            }
                            if (d5 != 1.0) break block16;
                            d2 = 1.0;
                            break block14;
                        }
                        d4 = d;
                    }
                    d3 = d4;
                    if (n != 0) break block17;
                    if (!(d3 < 0.5)) break block18;
                    d2 = Math.pow(2.0, 20.0 * d - 10.0) / 2.0;
                    break block14;
                }
                d3 = 2.0 - Math.pow(2.0, -20.0 * d + 10.0);
            }
            d2 = d3 / 2.0;
        }
        return d2;
    });

    public static final /* enum */ oc3d8ab304f7 \u03cc = new oc3d8ab304f7(d -> {
        d = d - 1.0;
        return Math.sqrt(1.0 - d * d);
    });
    public static final /* enum */ oc3d8ab304f7 \u0265 = new oc3d8ab304f7(d -> {
        double d2;
        block6: {
            double d3;
            block4: {
                block5: {
                    int n = oc75d51ec7eb.\u03e9;
                    d3 = d;
                    if (n != 0) break block4;
                    if (!(d3 < 0.5)) break block5;
                    d2 = (1.0 - Math.sqrt(1.0 - 4.0 * d * d)) / 2.0;
                    break block6;
                }
                d3 = Math.sqrt(1.0 - 4.0 * (d - 1.0) * d) + 1.0;
            }
            d2 = d3 / 2.0;
        }
        return d2;
    });
    public static final /* enum */ oc3d8ab304f7 \u0113 = new oc3d8ab304f7(d -> 1.0 / (1.0 + Math.exp(-d.doubleValue())));
    public static final /* enum */ oc3d8ab304f7 \u039d = new oc3d8ab304f7(d -> {
        double d2;
        block10: {
            double d3;
            block11: {
                block12: {
                    int n;
                    block8: {
                        block9: {
                            n = oc75d51ec7eb.\u03e9;
                            d3 = d;
                            if (n != 0) break block8;
                            if (d3 != 0.0) break block9;
                            d2 = 0.0;
                            break block10;
                        }
                        d3 = d;
                    }
                    if (n != 0) break block11;
                    if (d3 != 1.0) break block12;
                    d2 = 1.0;
                    break block10;
                }
                d3 = Math.pow(2.0, -10.0 * d) * Math.sin((d * 10.0 - 0.75) * 2.0943951023931953) * 0.5;
            }
            d2 = d3 + 1.0;
        }
        return d2;
    });
    public static final /* enum */ oc3d8ab304f7 \u04c5 = new oc3d8ab304f7(d -> 2.70158 * d * d * d - 1.70158 * d * d);
    public static final /* enum */ oc3d8ab304f7 \u03a7 = new oc3d8ab304f7(d -> 1.0 - (d - 1.0) * (d - 1.0));
    private final Function<Double, Double> \u03ef;
    private static final /* synthetic */ oc3d8ab304f7[] \u020e;
    public static boolean \u01ac;



    private oc3d8ab304f7(Function<Double, Double> function) {
        this.\u03ef = function;
    }

    public Function<Double, Double> \u0523() {
        return this.\u03ef;
    }

    public String toString() {
        return StringUtils.capitalize(super.toString().toLowerCase().replace("_", " "));
    }

    private static /* synthetic */ oc3d8ab304f7[] \u0579() {
        oc3d8ab304f7[] oc3d8ab304f7Array = new oc3d8ab304f7[0xD85884B4 ^ 0xD85884AE];
        oc3d8ab304f7Array[0] = \u00ee;
        oc3d8ab304f7Array[1] = \u0572;
        oc3d8ab304f7Array[0xD85884AC ^ 0xD85884AE] = \u04d5;
        oc3d8ab304f7Array[0xD85884AD ^ 0xD85884AE] = \u0466;
        oc3d8ab304f7Array[0xD85884AA ^ 0xD85884AE] = \u04ce;
        oc3d8ab304f7Array[0xD85884AB ^ 0xD85884AE] = \u0436;
        oc3d8ab304f7Array[0xD85884A8 ^ 0xD85884AE] = \u028e;
        oc3d8ab304f7Array[0xD85884A9 ^ 0xD85884AE] = \u0527;
        oc3d8ab304f7Array[0xD85884A6 ^ 0xD85884AE] = \u0510;
        oc3d8ab304f7Array[0xD85884A7 ^ 0xD85884AE] = \u0230;
        oc3d8ab304f7Array[0xD85884A4 ^ 0xD85884AE] = \u0246;
        oc3d8ab304f7Array[0xD85884A5 ^ 0xD85884AE] = \u041e;
        oc3d8ab304f7Array[0xD85884A2 ^ 0xD85884AE] = \u04e8;
        oc3d8ab304f7Array[0xD85884A3 ^ 0xD85884AE] = \u0534;
        oc3d8ab304f7Array[0xD85884A0 ^ 0xD85884AE] = \u0564;
        oc3d8ab304f7Array[0xD85884A1 ^ 0xD85884AE] = \u04ab;
        oc3d8ab304f7Array[0xD85884BE ^ 0xD85884AE] = \u03ca;
        oc3d8ab304f7Array[0xD85884BF ^ 0xD85884AE] = \u0403;
        oc3d8ab304f7Array[0xD85884BC ^ 0xD85884AE] = \u0262;
        oc3d8ab304f7Array[0xD85884BD ^ 0xD85884AE] = P;
        oc3d8ab304f7Array[0xD85884BA ^ 0xD85884AE] = \u03cc;
        oc3d8ab304f7Array[0xD85884BB ^ 0xD85884AE] = \u0265;
        oc3d8ab304f7Array[0xD85884B8 ^ 0xD85884AE] = \u0113;
        oc3d8ab304f7Array[0xD85884B9 ^ 0xD85884AE] = \u039d;
        oc3d8ab304f7Array[0xD85884B6 ^ 0xD85884AE] = \u04c5;
        oc3d8ab304f7Array[0xD85884B7 ^ 0xD85884AE] = \u03a7;
        return oc3d8ab304f7Array;
    }

    static {
        \u020e = oc3d8ab304f7.\u0579();
    }
}

