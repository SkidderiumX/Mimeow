/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.N;
import x.oc69da1aa7f5;
import x.oc93499ec6de;
import x.oc9755810e45;
import x.oc9cd81f0bf1;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.ocd2958dac48;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc42c8f83828
extends oc69da1aa7f5 {
    public static final String[] \u0182;
    public static final String[] \u046b;
    public static oca9cc61aada \u0498;
    public static oca9cc61aada \u0222;
    public static occ2f8dff8d8 \u04d5;
    public static occ2f8dff8d8 \u023d;
    public static oca9cc61aada \u00e7;
    public static oca9cc61aada \u0575;
    public static oca9cc61aada \u01df;
    public static occ2f8dff8d8 \u025c;
    public static oca9cc61aada \u02a8;
    public static occ2f8dff8d8 \u03ae;
    public static occ2f8dff8d8 \u01ac;
    public static occ2f8dff8d8 \u01d1;
    public static boolean \u02c1;

    public oc42c8f83828() {
        super("Chat", oce4cea752dd.\u014e);
        this.\u0105("Customizes chat rounding, animations and neutral shaders.");
        this.\u0430 = false;
        this.\u04c2(true);
        occc831eff22 occc831eff222 = new occc831eff22("Appearance");
        this.\u028c(occc831eff222);
        \u00e7 = new oca9cc61aada("Box Style", 0x52BC33DA ^ 0x52BC33D9, \u046b);
        this.\u0228(occc831eff222, \u00e7);
        \u0575 = new oca9cc61aada("Corner Radius", "px", 5.0, 1.0, 10.0, 0.5);
        this.\u0228(occc831eff222, \u0575);
        \u01df = new oca9cc61aada("BG Opacity", 0.5, 0.0, 1.0, 0.05);
        this.\u0228(occc831eff222, \u01df);
        \u025c = new occ2f8dff8d8("Rounded Input", false);
        this.\u0228(occc831eff222, \u025c);
        \u02a8 = new oca9cc61aada("Input Radius", "px", 4.0, 1.0, 8.0, 0.5);
        this.\u0228(occc831eff222, \u02a8);
        occc831eff22 occc831eff223 = new occc831eff22("Animations");
        this.\u028c(occc831eff223);
        \u0498 = new oca9cc61aada("Animation", 0, \u0182);
        this.\u0228(occc831eff223, \u0498);
        \u0222 = new oca9cc61aada("Animation speed", "ms", 250.0, 100.0, 600.0, 25.0, "Anim Speed");
        this.\u0228(occc831eff223, \u0222);
        \u04d5 = new occ2f8dff8d8("Open animation", false);
        this.\u0228(occc831eff223, \u04d5);
        \u023d = new occ2f8dff8d8("Smooth scroll", false);
        this.\u0228(occc831eff223, \u023d);
        occc831eff22 occc831eff224 = new occc831eff22("Shaders");
        this.\u028c(occc831eff224);
        \u03ae = new occ2f8dff8d8("Shader", false);
        this.\u0228(occc831eff224, \u03ae);
        \u01ac = new occ2f8dff8d8("Blur", true);
        this.\u0228(occc831eff224, \u01ac);
        \u01d1 = new occ2f8dff8d8("Bloom", false);
        this.\u0228(occc831eff224, \u01d1);
        this.z$2u87utkr1isxg();
    }

    private void \u0228(occc831eff22 occc831eff222, N n) {
        oc93499ec6de.\u04ac(n, occc831eff222);
        this.\u028c(n);
    }

    @Override
    public void z$2u87utkr1isxg() {
        boolean bl;
        oca9cc61aada oca9cc61aada2;
        block12: {
            block14: {
                block13: {
                    boolean bl2;
                    oca9cc61aada oca9cc61aada3;
                    boolean bl3;
                    block10: {
                        block11: {
                            bl3 = oce6044968f8.\u0452;
                            oca9cc61aada3 = \u0575;
                            bl2 = oc42c8f83828.\u048f();
                            if (bl3) break block10;
                            if (bl2 > true) break block11;
                            bl2 = true;
                            break block10;
                        }
                        bl2 = false;
                    }
                    oca9cc61aada3.\u0209(bl2, this);
                    oca9cc61aada2 = \u02a8;
                    bl = \u025c.\u01ed();
                    if (bl3) break block12;
                    oca9cc61aada2.\u0209(bl, this);
                    oca9cc61aada2 = \u0222;
                    if (\u0498.\u04c1() != 0.0) break block13;
                    bl = \u04d5.\u01ed();
                    if (bl3) break block12;
                    if (!bl) break block14;
                }
                bl = true;
                break block12;
            }
            bl = false;
        }
        oca9cc61aada2.\u0209(bl, this);
        \u01ac.\u0209(\u03ae.\u01ed(), this);
        \u01d1.\u0209(\u03ae.\u01ed(), this);
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        this.z$2u87utkr1isxg();
    }

    @Override
    public void guiButtonToggled(occ2f8dff8d8 occ2f8dff8d82) {
        super.guiButtonToggled(occ2f8dff8d82);
        this.z$2u87utkr1isxg();
    }

    public static boolean \u03a5() {
        boolean bl;
        block6: {
            block5: {
                oc42c8f83828 oc42c8f838282;
                boolean bl2;
                block4: {
                    bl2 = oce6044968f8.\u0452;
                    oc42c8f838282 = oc9755810e45.\u0256;
                    if (bl2) break block4;
                    if (oc42c8f838282 == null) break block5;
                    oc42c8f838282 = oc9755810e45.\u0256;
                }
                bl = oc42c8f838282.z$3rzb3dil7uydr();
                if (bl2) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public static int \u026d() {
        int n;
        block6: {
            block4: {
                oca9cc61aada oca9cc61aada2;
                block5: {
                    boolean bl = oce6044968f8.\u0452;
                    if (!oc42c8f83828.\u03a5()) break block4;
                    oca9cc61aada2 = \u0498;
                    if (bl) break block5;
                    if (oca9cc61aada2 == null) break block4;
                    oca9cc61aada2 = \u0498;
                }
                n = (int)oca9cc61aada2.\u04c1();
                break block6;
            }
            n = 0;
        }
        return n;
    }

    public static long \u03b3() {
        long l;
        block6: {
            block4: {
                oca9cc61aada oca9cc61aada2;
                block5: {
                    boolean bl = oce6044968f8.\u0452;
                    if (!oc42c8f83828.\u03a5()) break block4;
                    oca9cc61aada2 = \u0222;
                    if (bl) break block5;
                    if (oca9cc61aada2 == null) break block4;
                    oca9cc61aada2 = \u0222;
                }
                l = (long)oca9cc61aada2.\u04c1();
                break block6;
            }
            l = 0xC92015FEE41D33F4L ^ 0xC92015FEE41D330EL;
        }
        return l;
    }

    public static boolean \u01dc() {
        boolean bl;
        block8: {
            block6: {
                occ2f8dff8d8 occ2f8dff8d82;
                boolean bl2;
                block7: {
                    bl2 = oce6044968f8.\u0452;
                    if (!oc42c8f83828.\u03a5()) break block6;
                    occ2f8dff8d82 = \u04d5;
                    if (bl2) break block7;
                    if (occ2f8dff8d82 == null) break block6;
                    occ2f8dff8d82 = \u04d5;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (bl2) break block8;
                if (!bl) break block6;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u049c() {
        boolean bl;
        block8: {
            block6: {
                occ2f8dff8d8 occ2f8dff8d82;
                boolean bl2;
                block7: {
                    bl2 = oce6044968f8.\u0452;
                    if (!oc42c8f83828.\u03a5()) break block6;
                    occ2f8dff8d82 = \u023d;
                    if (bl2) break block7;
                    if (occ2f8dff8d82 == null) break block6;
                    occ2f8dff8d82 = \u023d;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (bl2) break block8;
                if (!bl) break block6;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u03ae() {
        return ocd2958dac48.\u0443();
    }

    public static boolean \u0517() {
        boolean bl;
        block8: {
            block6: {
                occ2f8dff8d8 occ2f8dff8d82;
                boolean bl2;
                block7: {
                    bl2 = oce6044968f8.\u0452;
                    if (!oc42c8f83828.\u01bd()) break block6;
                    occ2f8dff8d82 = \u01ac;
                    if (bl2) break block7;
                    if (occ2f8dff8d82 == null) break block6;
                    occ2f8dff8d82 = \u01ac;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (bl2) break block8;
                if (!bl) break block6;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static float \u024f() {
        return oce6044968f8.\u018a();
    }

    public static boolean N() {
        boolean bl;
        block8: {
            block6: {
                occ2f8dff8d8 occ2f8dff8d82;
                boolean bl2;
                block7: {
                    bl2 = oce6044968f8.\u0452;
                    if (!oc42c8f83828.\u01bd()) break block6;
                    occ2f8dff8d82 = \u01d1;
                    if (bl2) break block7;
                    if (occ2f8dff8d82 == null) break block6;
                    occ2f8dff8d82 = \u01d1;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (bl2) break block8;
                if (!bl) break block6;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u01bd() {
        boolean bl;
        block8: {
            block6: {
                occ2f8dff8d8 occ2f8dff8d82;
                boolean bl2;
                block7: {
                    bl2 = oce6044968f8.\u0452;
                    if (!oc42c8f83828.\u03a5()) break block6;
                    occ2f8dff8d82 = \u03ae;
                    if (bl2) break block7;
                    if (occ2f8dff8d82 == null) break block6;
                    occ2f8dff8d82 = \u03ae;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (bl2) break block8;
                if (!bl) break block6;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static float \u04ed() {
        return oce6044968f8.\u01f4();
    }

    public static int \u048f() {
        int n;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                block5: {
                    boolean bl = oce6044968f8.\u0452;
                    oca9cc61aada2 = \u00e7;
                    if (bl) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    n = 0x68DE3DE0 ^ 0x68DE3DE3;
                    break block6;
                }
                oca9cc61aada2 = \u00e7;
            }
            n = (int)oca9cc61aada2.\u04c1();
        }
        return n;
    }

    public static float \u0143() {
        float f;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                block5: {
                    boolean bl = oce6044968f8.\u0452;
                    oca9cc61aada2 = \u0575;
                    if (bl) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    f = 5.0f;
                    break block6;
                }
                oca9cc61aada2 = \u0575;
            }
            f = (float)oca9cc61aada2.\u04c1();
        }
        return f;
    }

    public static float \u0413() {
        float f;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                block5: {
                    boolean bl = oce6044968f8.\u0452;
                    oca9cc61aada2 = \u01df;
                    if (bl) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    f = 0.5f;
                    break block6;
                }
                oca9cc61aada2 = \u01df;
            }
            f = (float)oca9cc61aada2.\u04c1();
        }
        return f;
    }

    public static boolean \u00f5() {
        boolean bl;
        block8: {
            block6: {
                occ2f8dff8d8 occ2f8dff8d82;
                boolean bl2;
                block7: {
                    bl2 = oce6044968f8.\u0452;
                    if (!oc42c8f83828.\u03a5()) break block6;
                    occ2f8dff8d82 = \u025c;
                    if (bl2) break block7;
                    if (occ2f8dff8d82 == null) break block6;
                    occ2f8dff8d82 = \u025c;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (bl2) break block8;
                if (!bl) break block6;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static float \u03b8() {
        float f;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                block5: {
                    boolean bl = oce6044968f8.\u0452;
                    oca9cc61aada2 = \u02a8;
                    if (bl) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    f = 4.0f;
                    break block6;
                }
                oca9cc61aada2 = \u02a8;
            }
            f = (float)oca9cc61aada2.\u04c1();
        }
        return f;
    }

    public static oc9cd81f0bf1 \u0207() {
        int n;
        float f;
        block8: {
            int n2;
            block6: {
                block7: {
                    int n3 = oc42c8f83828.\u048f();
                    boolean bl = oce6044968f8.\u0452;
                    float f2 = n3 <= 1 ? oc42c8f83828.\u0143() * oce6044968f8.\u01bc() : 0.0f;
                    f = f2;
                    n2 = n3;
                    if (bl) break block6;
                    if (n2 != (0x657D13C7 ^ 0x657D13C5)) break block7;
                    n = 0;
                    break block8;
                }
                n2 = Math.round(oc42c8f83828.\u0413() * 255.0f);
            }
            n = n2 << (0x657D13DD ^ 0x657D13C5);
        }
        int n4 = n;
        return oc42c8f83828.\u02ae(f, n4);
    }

    public static oc9cd81f0bf1 G() {
        float f = oc42c8f83828.\u00f5() ? oc42c8f83828.\u03b8() * oce6044968f8.\u01bc() : 0.0f;
        float f2 = f;
        return oc42c8f83828.\u02ae(f2, Math.round(oc42c8f83828.\u0413() * 255.0f) << (0x41E99EA8 ^ 0x41E99EB0));
    }

    private static oc9cd81f0bf1 \u02ae(float f, int n) {
        return oc9cd81f0bf1.\u044b(f, n, oc42c8f83828.\u0517(), oc42c8f83828.N());
    }

    static {
        String[] stringArray = new String[0x2DF5F0C3 ^ 0x2DF5F0C0];
        stringArray[0] = "None";
        stringArray[1] = "Slide";
        stringArray[0x2DF5F0C2 ^ 0x2DF5F0C0] = "Fade";
        \u0182 = stringArray;
        String[] stringArray2 = new String[0x2DF5F0C4 ^ 0x2DF5F0C0];
        stringArray2[0] = "Rounded Box";
        stringArray2[1] = "Rounded Lines";
        stringArray2[0x2DF5F0C2 ^ 0x2DF5F0C0] = "Transparent";
        stringArray2[0x2DF5F0C3 ^ 0x2DF5F0C0] = "Vanilla";
        \u046b = stringArray2;
    }
}

