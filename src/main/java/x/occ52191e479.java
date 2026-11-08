/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.ocbde1165e4e;
import x.ocee33618a8d;

public class occ52191e479<R>
extends ocee33618a8d {
    private R \u0216;
    public static boolean \u0289;

    public occ52191e479(String string, boolean bl) {
        super(string, bl);
    }

    public occ52191e479(String string, boolean bl, R r) {
        super(string, bl);
        this.\u0216 = r;
    }

    public occ52191e479(String string, boolean bl, byte by) {
        this(string, bl, Byte.valueOf(by));
    }

    public occ52191e479(String string, boolean bl, char c) {
        this(string, bl, Character.valueOf(c));
    }

    public occ52191e479(String string, boolean bl, double d) {
        this(string, bl, Double.valueOf(d));
    }

    public occ52191e479(String string, boolean bl, float f) {
        this(string, bl, Float.valueOf(f));
    }

    public occ52191e479(String string, boolean bl, int n) {
        this(string, bl, Integer.valueOf(n));
    }

    public occ52191e479(String string, boolean bl, long l) {
        this(string, bl, Long.valueOf(l));
    }

    public occ52191e479(String string, boolean bl, short s) {
        this(string, bl, Short.valueOf(s));
    }

    public occ52191e479(String string, boolean bl, boolean bl2) {
        this(string, bl, Boolean.valueOf(bl2));
    }

    public void \u04ea(R r) throws ocbde1165e4e {
        this.z$2vp8d6bhwkrey();
        int n = ocee33618a8d.\u0278;
        this.\u0216 = r;
        if (false) {
            ocee33618a8d.\u0278 = ++n;
        }
    }

    public R \u040d() {
        return this.\u0216;
    }

    public byte \u037b() {
        byte by;
        block6: {
            occ52191e479<R> occ52191e4792;
            block4: {
                block5: {
                    int n = ocee33618a8d.\u0278;
                    occ52191e4792 = this;
                    if (n != 0) break block4;
                    if (occ52191e4792.\u0216 != null) break block5;
                    by = 0;
                    break block6;
                }
                occ52191e4792 = this.\u0216;
            }
            by = (Byte)((Object)occ52191e4792);
        }
        return by;
    }

    public char \u054f() {
        char c;
        block6: {
            occ52191e479<R> occ52191e4792;
            block4: {
                block5: {
                    int n = ocee33618a8d.\u0278;
                    occ52191e4792 = this;
                    if (n != 0) break block4;
                    if (occ52191e4792.\u0216 != null) break block5;
                    c = '\u0000';
                    break block6;
                }
                occ52191e4792 = this.\u0216;
            }
            c = ((Character)((Object)occ52191e4792)).charValue();
        }
        return c;
    }

    public double \u03a5() {
        double d;
        block6: {
            occ52191e479<R> occ52191e4792;
            block4: {
                block5: {
                    int n = ocee33618a8d.\u0278;
                    occ52191e4792 = this;
                    if (n != 0) break block4;
                    if (occ52191e4792.\u0216 != null) break block5;
                    d = 0.0;
                    break block6;
                }
                occ52191e4792 = this.\u0216;
            }
            d = (Double)((Object)occ52191e4792);
        }
        return d;
    }

    public float \u0439() {
        float f;
        block6: {
            occ52191e479<R> occ52191e4792;
            block4: {
                block5: {
                    int n = ocee33618a8d.\u0278;
                    occ52191e4792 = this;
                    if (n != 0) break block4;
                    if (occ52191e4792.\u0216 != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                occ52191e4792 = this.\u0216;
            }
            f = ((Float)((Object)occ52191e4792)).floatValue();
        }
        return f;
    }

    public int \u0102() {
        int n;
        block6: {
            occ52191e479<R> occ52191e4792;
            block4: {
                block5: {
                    int n2 = ocee33618a8d.\u0278;
                    occ52191e4792 = this;
                    if (n2 != 0) break block4;
                    if (occ52191e4792.\u0216 != null) break block5;
                    n = 0;
                    break block6;
                }
                occ52191e4792 = this.\u0216;
            }
            n = (Integer)((Object)occ52191e4792);
        }
        return n;
    }

    public long \u0154() {
        long l;
        block6: {
            occ52191e479<R> occ52191e4792;
            block4: {
                block5: {
                    int n = ocee33618a8d.\u0278;
                    occ52191e4792 = this;
                    if (n != 0) break block4;
                    if (occ52191e4792.\u0216 != null) break block5;
                    l = 0L;
                    break block6;
                }
                occ52191e4792 = this.\u0216;
            }
            l = (Long)((Object)occ52191e4792);
        }
        return l;
    }

    public short \u0201() {
        short s;
        block6: {
            occ52191e479<R> occ52191e4792;
            block4: {
                block5: {
                    int n = ocee33618a8d.\u0278;
                    occ52191e4792 = this;
                    if (n != 0) break block4;
                    if (occ52191e4792.\u0216 != null) break block5;
                    s = 0;
                    break block6;
                }
                occ52191e4792 = this.\u0216;
            }
            s = (Short)((Object)occ52191e4792);
        }
        return s;
    }

    public boolean \u016f() {
        boolean bl;
        block8: {
            block7: {
                occ52191e479<R> occ52191e4792;
                int n;
                block6: {
                    n = ocee33618a8d.\u0278;
                    occ52191e4792 = this;
                    if (n != 0) break block6;
                    if (occ52191e4792.\u0216 == null) break block7;
                    occ52191e4792 = this.\u0216;
                }
                bl = (Boolean)((Object)occ52191e4792);
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }
}

