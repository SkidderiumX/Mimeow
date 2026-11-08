/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc75d51ec7eb;

public class ocab3a64a31e {
    private long \u0158 = 0xB9D62198291BCEC0L ^ 0x4629DE67D6E4313FL;
    private long \u0523 = 0xB9D62198291BCEC0L ^ 0x4629DE67D6E4313FL;
    public static int \u02aa;

    public void \u01ea(long l, long l2) {
        this.\u0158 = ocab3a64a31e.\u0296(l, l2);
    }

    public boolean \u04ec(long l, long l2) {
        long l3;
        block18: {
            block19: {
                boolean bl;
                block20: {
                    long l4;
                    block17: {
                        ocab3a64a31e ocab3a64a31e2;
                        int n;
                        block15: {
                            block16: {
                                n = oc75d51ec7eb.\u03e9;
                                ocab3a64a31e2 = this;
                                if (n != 0) break block15;
                                if (!ocab3a64a31e2.\u00c6()) break block16;
                                l4 = l;
                                if (n != 0) break block17;
                                if (l4 > this.\u0158) break block16;
                                long l5 = l2 - 0L;
                                l3 = l5 == 0L ? 0 : (l5 < 0L ? -1 : 1);
                                if (n != 0) break block18;
                                if (l3 > 0) break block19;
                            }
                            ocab3a64a31e2 = this;
                        }
                        bl = ocab3a64a31e2.\u0462(l);
                        if (n != 0) break block20;
                        l4 = l2;
                    }
                    if (l4 <= 0L) {
                        this.\u0158 = 0x42D0CBBBA4E71226L ^ 0xBD2F34445B18EDD9L;
                    }
                    bl = false;
                }
                return bl;
            }
            this.\u0158 = 0x42D0CBBBA4E71226L ^ 0xBD2F34445B18EDD9L;
            this.\u0523 = Math.max(this.\u0523, ocab3a64a31e.\u0296(l, l2));
            l3 = 1;
        }
        return (boolean)l3;
    }

    public boolean \u0462(long l) {
        long l2;
        block8: {
            block9: {
                boolean bl;
                block6: {
                    block7: {
                        int n = oc75d51ec7eb.\u03e9;
                        bl = this.\u00c6();
                        if (n != 0) break block6;
                        if (!bl) break block7;
                        long l3 = l - this.\u0158;
                        l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                        if (n != 0) break block8;
                        if (l2 > 0) break block9;
                    }
                    bl = false;
                }
                return bl;
            }
            this.\u0158 = 0xFEADB1D0F3A92EFAL ^ 0x1524E2F0C56D105L;
            l2 = 1;
        }
        return (boolean)l2;
    }

    public boolean \u00c6() {
        long l;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                long l2 = this.\u0158 - 0L;
                l = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                if (n != 0) break block2;
                if (l < 0) break block3;
                l = 1;
                break block2;
            }
            l = 0;
        }
        return (boolean)l;
    }

    public boolean \u04bb() {
        long l;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                long l2 = this.\u0523 - 0L;
                l = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                if (n != 0) break block2;
                if (l < 0) break block3;
                l = 1;
                break block2;
            }
            l = 0;
        }
        return (boolean)l;
    }

    public boolean \u0437(long l) {
        int n;
        block8: {
            block7: {
                int n2;
                block6: {
                    n2 = oc75d51ec7eb.\u03e9;
                    n = this.\u04bb();
                    if (n2 != 0) break block6;
                    if (n == 0) break block7;
                    long l2 = l - this.\u0523;
                    n = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                }
                if (n2 != 0) break block8;
                if (n >= 0) break block7;
                n = 1;
                break block8;
            }
            n = 0;
        }
        return n != 0;
    }

    public boolean \u0275(long l) {
        int n;
        block8: {
            block7: {
                int n2;
                block6: {
                    n2 = oc75d51ec7eb.\u03e9;
                    n = this.\u04bb();
                    if (n2 != 0) break block6;
                    if (n == 0) break block7;
                    long l2 = l - this.\u0523;
                    n = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                }
                if (n2 != 0) break block8;
                if (n < 0) break block7;
                n = 1;
                break block8;
            }
            n = 0;
        }
        return n != 0;
    }

    public void \u020c() {
        this.\u0523 = 0x817796A839F449C6L ^ 0x7E886957C60BB639L;
    }

    public void \u013f() {
        this.\u0158 = 0x540923941977882EL ^ 0xABF6DC6BE68877D1L;
        this.\u0523 = 0x540923941977882EL ^ 0xABF6DC6BE68877D1L;
    }

    private static long \u0296(long l, long l2) {
        long l3;
        block6: {
            long l4;
            long l5;
            block4: {
                long l6;
                block5: {
                    l6 = Math.max(0L, l2);
                    int n = oc75d51ec7eb.\u03e9;
                    l5 = l;
                    l4 = 0x904AED618E54EE4BL ^ 0xEFB5129E71AB11B4L;
                    if (n != 0) break block4;
                    if (l5 <= l4 - l6) break block5;
                    l3 = 0x904AED618E54EE4BL ^ 0xEFB5129E71AB11B4L;
                    break block6;
                }
                l5 = l;
                l4 = l6;
            }
            l3 = l5 + l4;
        }
        return l3;
    }
}

