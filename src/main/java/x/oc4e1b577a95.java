/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc110d7f376c;
import x.oc4d46a99983;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc89eb238246;
import x.oc9755810e45;
import x.oc9adb807c19;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.occc57954425;
import x.oce4cea752dd;
import x.ocf923d5a814;

public class oc4e1b577a95
extends oc69da1aa7f5 {
    public static occ2f8dff8d8 \u0141;
    public static oca9cc61aada \u042a;
    public static occ2f8dff8d8 \u017c;
    public static occ2f8dff8d8 \u012f;
    public static occ2f8dff8d8 \u04a5;
    public static occ2f8dff8d8 \u0104;
    public static occ2f8dff8d8 \u04f8;
    public static occ2f8dff8d8 \u01ae;
    public static occ2f8dff8d8 \u04a0;
    public static occ2f8dff8d8 \u041d;
    public static occ2f8dff8d8 \u0419;
    public static occ2f8dff8d8 \u024e;
    public static oca9cc61aada \u0549;
    public static oca9cc61aada \u057c;
    public static int \u0415;

    public oc4e1b577a95() {
        super("Patcher", oce4cea752dd.\u04a6);
        this.\u0105("Adds rendering optimizations and quality-of-life fixes.");
        this.\u028c(new oc4d46a99983("PolyPatcher optimizations & QoL"));
        this.\u028c(new oc4d46a99983("Performance"));
        \u0141 = new occ2f8dff8d8("Entity Culling", true);
        this.\u028c(\u0141);
        \u042a = new oca9cc61aada("Cull Interval", "ms", 10.0, 5.0, 100.0, 5.0);
        this.\u028c(\u042a);
        \u017c = new occ2f8dff8d8("Particle Culling", true);
        this.\u028c(\u017c);
        \u01ae = new occ2f8dff8d8("Static Items", false);
        this.\u028c(\u01ae);
        \u04a0 = new occ2f8dff8d8("Unstacked Items", false);
        this.\u028c(\u04a0);
        this.\u028c(new oc4d46a99983("QoL & Visuals"));
        \u012f = new occ2f8dff8d8("Compact Chat", true);
        this.\u028c(\u012f);
        \u04a5 = new occ2f8dff8d8("Extended Chat (256)", true);
        this.\u028c(\u04a5);
        \u0104 = new occ2f8dff8d8("No Close My Chat", true);
        this.\u028c(\u0104);
        \u04f8 = new occ2f8dff8d8("Clean Projectiles", true);
        this.\u028c(\u04f8);
        \u041d = new occ2f8dff8d8("1.12 Crop Hitbox", true);
        this.\u028c(\u041d);
        \u0419 = new occ2f8dff8d8("Void Skybox Fix", true);
        this.\u028c(\u0419);
        \u024e = new occ2f8dff8d8("Smooth Scrolling", true);
        this.\u028c(\u024e);
        this.\u028c(new oc4d46a99983("GUI Opacity"));
        \u0549 = new oca9cc61aada("Container Opacity", 1.0, 0.0, 1.0, 0.05);
        this.\u028c(\u0549);
        \u057c = new oca9cc61aada("Container BG Opacity", 0.65, 0.0, 1.0, 0.05);
        this.\u028c(\u057c);
    }

    @oc66fa4f2195
    public void \u0292(oc9adb807c19 oc9adb807c192) {
        if (oc9adb807c192.\u04b0 == oc110d7f376c.END) {
            occc57954425.\u0137();
        }
    }

    @oc66fa4f2195
    public void \u00ff(ocf923d5a814 ocf923d5a8142) {
        if (ocf923d5a8142.\u04b0 == oc110d7f376c.START) {
            occc57954425.\u0458();
        }
    }

    public static boolean \u0544() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u0141;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u0141;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static long \u024e() {
        long l;
        block4: {
            block3: {
                oca9cc61aada oca9cc61aada2;
                block2: {
                    int n = oc89eb238246.\u0127;
                    oca9cc61aada2 = \u042a;
                    if (n != 0) break block2;
                    if (oca9cc61aada2 == null) break block3;
                    oca9cc61aada2 = \u042a;
                }
                l = (long)oca9cc61aada2.\u04c1();
                break block4;
            }
            l = 0xC7AB838966B1CF12L ^ 0xC7AB838966B1CF18L;
        }
        return l;
    }

    public static boolean \u03a4() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u017c;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u017c;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u03b4() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u012f;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u012f;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u041a() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u04a5;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u04a5;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean f() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u0104;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u0104;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u040d() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u04f8;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u04f8;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u0514() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u01ae;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u01ae;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u00f2() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u04a0;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u04a0;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u021c() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u041d;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u041d;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u0228() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u0419;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u0419;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u0210() {
        boolean bl;
        block11: {
            block9: {
                occ2f8dff8d8 occ2f8dff8d82;
                int n;
                block10: {
                    oc4e1b577a95 oc4e1b577a952;
                    block8: {
                        n = oc89eb238246.\u0127;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                        if (n != 0) break block8;
                        if (oc4e1b577a952 == null) break block9;
                        oc4e1b577a952 = oc9755810e45.\u0376;
                    }
                    if (!oc4e1b577a952.z$3rzb3dil7uydr()) break block9;
                    occ2f8dff8d82 = \u024e;
                    if (n != 0) break block10;
                    if (occ2f8dff8d82 == null) break block9;
                    occ2f8dff8d82 = \u024e;
                }
                bl = occ2f8dff8d82.\u01ed();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static float \u0281() {
        float f;
        block4: {
            block3: {
                oca9cc61aada oca9cc61aada2;
                block2: {
                    int n = oc89eb238246.\u0127;
                    oca9cc61aada2 = \u0549;
                    if (n != 0) break block2;
                    if (oca9cc61aada2 == null) break block3;
                    oca9cc61aada2 = \u0549;
                }
                f = (float)oca9cc61aada2.\u04c1();
                break block4;
            }
            f = 1.0f;
        }
        return f;
    }

    public static float H() {
        float f;
        block4: {
            block3: {
                oca9cc61aada oca9cc61aada2;
                block2: {
                    int n = oc89eb238246.\u0127;
                    oca9cc61aada2 = \u057c;
                    if (n != 0) break block2;
                    if (oca9cc61aada2 == null) break block3;
                    oca9cc61aada2 = \u057c;
                }
                f = (float)oca9cc61aada2.\u04c1();
                break block4;
            }
            f = 0.65f;
        }
        return f;
    }
}

