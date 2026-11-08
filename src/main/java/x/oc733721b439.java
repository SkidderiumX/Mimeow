/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc25aa89b91f;
import x.occ0b63c0426;

public class oc733721b439 {
    public double \u0255;
    public double \u0265;
    public double \u0220;
    public float \u0202;
    public float \u01bc;
    public boolean \u0281;
    public boolean \u04cf;
    public boolean \u0473;
    public static boolean \u0399;

    public oc733721b439() {
    }

    public oc733721b439(oc25aa89b91f oc25aa89b91f2, byte by) {
        if (oc25aa89b91f2 != null) {
            this.\u0255 = oc25aa89b91f2.\u010a();
            this.\u0265 = oc25aa89b91f2.\u01f8();
            this.\u0220 = oc25aa89b91f2.\u0465();
            this.\u0202 = oc25aa89b91f2.\u0541();
            this.\u01bc = oc25aa89b91f2.\u01bd();
            this.\u0281 = oc25aa89b91f2.z();
            this.\u04cf = oc25aa89b91f2.\u0531();
            this.\u0473 = oc25aa89b91f2.\u0274();
        }
    }

    public oc733721b439(Object[] objectArray) {
        if (objectArray == null) {
            return;
        }
        this.\u0255 = oc733721b439.\u00e8(objectArray, 0, 0.0);
        this.\u0265 = oc733721b439.\u00e8(objectArray, 1, 0.0);
        this.\u0220 = oc733721b439.\u00e8(objectArray, 0xC1FD729F ^ 0xC1FD729D, 0.0);
        this.\u0202 = (float)oc733721b439.\u00e8(objectArray, 0xC1FD729E ^ 0xC1FD729D, 0.0);
        this.\u01bc = (float)oc733721b439.\u00e8(objectArray, 0xC1FD7299 ^ 0xC1FD729D, 0.0);
        this.\u0281 = oc733721b439.\u01cf(objectArray, 0xC1FD7298 ^ 0xC1FD729D);
        this.\u04cf = oc733721b439.\u01cf(objectArray, 0xC1FD729B ^ 0xC1FD729D);
        this.\u0473 = oc733721b439.\u01cf(objectArray, 0xC1FD729A ^ 0xC1FD729D);
    }

    public Object[] \u051c() {
        Object[] objectArray = new Object[0xF36B1719 ^ 0xF36B1711];
        objectArray[0] = this.\u0255;
        objectArray[1] = this.\u0265;
        objectArray[0xF36B1713 ^ 0xF36B1711] = this.\u0220;
        objectArray[0xF36B1712 ^ 0xF36B1711] = Float.valueOf(this.\u0202);
        objectArray[0xF36B1715 ^ 0xF36B1711] = Float.valueOf(this.\u01bc);
        objectArray[0xF36B1714 ^ 0xF36B1711] = this.\u0281;
        objectArray[0xF36B1717 ^ 0xF36B1711] = this.\u04cf;
        objectArray[0xF36B1716 ^ 0xF36B1711] = this.\u0473;
        return objectArray;
    }

    public boolean \u04dd(oc733721b439 oc733721b4392) {
        boolean bl;
        block43: {
            block35: {
                int n;
                block42: {
                    oc733721b439 oc733721b4393;
                    block41: {
                        block40: {
                            block39: {
                                block38: {
                                    double d;
                                    block37: {
                                        oc733721b439 oc733721b4394;
                                        block36: {
                                            block34: {
                                                n = occ0b63c0426.\u039f;
                                                oc733721b4394 = oc733721b4392;
                                                if (n != 0) break block34;
                                                if (oc733721b4394 == null) break block35;
                                                oc733721b4394 = this;
                                            }
                                            if (n != 0) break block36;
                                            if (oc733721b4394.\u0255 != oc733721b4392.\u0255) break block35;
                                            oc733721b4394 = this;
                                        }
                                        d = oc733721b4394.\u0265;
                                        if (n != 0) break block37;
                                        if (d != oc733721b4392.\u0265) break block35;
                                        oc733721b4393 = this;
                                        if (n != 0) break block38;
                                        d = oc733721b4393.\u0220;
                                    }
                                    if (d != oc733721b4392.\u0220) break block35;
                                    oc733721b4393 = this;
                                }
                                if (n != 0) break block39;
                                if (oc733721b4393.\u0202 != oc733721b4392.\u0202) break block35;
                                oc733721b4393 = this;
                            }
                            if (n != 0) break block40;
                            if (oc733721b4393.\u01bc != oc733721b4392.\u01bc) break block35;
                            oc733721b4393 = this;
                        }
                        if (n != 0) break block41;
                        if (oc733721b4393.\u0281 != oc733721b4392.\u0281) break block35;
                        oc733721b4393 = this;
                    }
                    bl = oc733721b4393.\u04cf;
                    if (n != 0) break block42;
                    if (bl != oc733721b4392.\u04cf) break block35;
                    bl = this.\u0473;
                }
                if (n != 0) break block43;
                if (bl != oc733721b4392.\u0473) break block35;
                bl = true;
                break block43;
            }
            bl = false;
        }
        return bl;
    }

    private static double \u00e8(Object[] objectArray, int n, double d) {
        double d2;
        block11: {
            block9: {
                int n2;
                Object[] objectArray2;
                block10: {
                    int n3;
                    block8: {
                        int n4 = occ0b63c0426.\u039f;
                        n3 = n;
                        if (n4 != 0) break block8;
                        if (n3 >= objectArray.length) break block9;
                        objectArray2 = objectArray;
                        n2 = n;
                        if (n4 != 0) break block10;
                        n3 = objectArray2[n2] instanceof Number;
                    }
                    if (n3 == 0) break block9;
                    objectArray2 = objectArray;
                    n2 = n;
                }
                d2 = ((Number)objectArray2[n2]).doubleValue();
                break block11;
            }
            d2 = d;
        }
        return d2;
    }

    private static boolean \u01cf(Object[] objectArray, int n) {
        boolean bl;
        block13: {
            block11: {
                Object object;
                int n2;
                block12: {
                    int n3;
                    block10: {
                        n2 = occ0b63c0426.\u039f;
                        n3 = n;
                        if (n2 != 0) break block10;
                        if (n3 >= objectArray.length) break block11;
                        object = objectArray;
                        if (n2 != 0) break block12;
                        n3 = object[n] instanceof Boolean;
                    }
                    if (n3 == 0) break block11;
                    object = objectArray[n];
                }
                bl = (Boolean)object;
                if (n2 != 0) break block13;
                if (!bl) break block11;
                bl = true;
                break block13;
            }
            bl = false;
        }
        return bl;
    }
}

