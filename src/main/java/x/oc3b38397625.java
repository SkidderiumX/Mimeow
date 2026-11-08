/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.N;
import x.oc24a0a5bddf;
import x.oc2cf3d80e17;
import x.oc46245c2b20;
import x.oc69da1aa7f5;
import x.oc74760d9133;
import x.oc9755810e45;
import x.oca9cc61aada;
import x.ocada7dda290;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.oce4cea752dd;

public class oc3b38397625
extends oc69da1aa7f5 {
    private static final String \u051c = "Chat";
    private static final String \u026d = "Slinky";
    private static final String[] \u04ce;
    private static final String[] \u056b;
    private static final float[] \u0427;
    public static occ2f8dff8d8 \u051f;
    public static occ2f8dff8d8 \u0191;
    public static occ2f8dff8d8 \u01d1;
    public static occ2f8dff8d8 \u0520;
    public static occ2f8dff8d8 \u043b;
    public static oc24a0a5bddf \u0461;
    public static oca9cc61aada \u03b3;
    public static oca9cc61aada \u04e3;
    private final ocada7dda290 \u0403;
    private final occc831eff22 \u03f5;
    private final occc831eff22 \u0136;
    public static int \u00e9;

    public oc3b38397625() {
        super("Notifications", oce4cea752dd.\u014e, 0);
        this.\u0105("Shows alerts when modules change state.");
        String[] stringArray = new String[0x30995605 ^ 0x30995607];
        stringArray[0] = "Chat";
        stringArray[1] = "Slinky";
        String[] stringArray2 = new String[0x30995605 ^ 0x30995607];
        stringArray2[0] = "Chat";
        stringArray2[1] = "Slinky";
        this.\u0403 = new ocada7dda290("Mode", stringArray, stringArray2);
        this.\u028c(this.\u0403);
        this.\u03f5 = new occc831eff22("Hide if");
        this.\u028c(this.\u03f5);
        \u051f = new occ2f8dff8d8(this.\u03f5, "In-game", false);
        this.\u028c(\u051f);
        \u0191 = new occ2f8dff8d8(this.\u03f5, "Hold bind is used", true);
        this.\u028c(\u0191);
        this.\u0136 = new occc831eff22("Visible mod categories");
        this.\u028c(this.\u0136);
        \u01d1 = new occ2f8dff8d8(this.\u0136, "Combat", true);
        this.\u028c(\u01d1);
        \u0520 = new occ2f8dff8d8(this.\u0136, "Visual", true);
        this.\u028c(\u0520);
        \u043b = new occ2f8dff8d8(this.\u0136, "Utility", true);
        this.\u028c(\u043b);
        \u0461 = new oc24a0a5bddf("Accent", 0x309956BD ^ 0x30995607, 0x30995688 ^ 0x30995607, 0x3099567E ^ 0x30995607);
        this.\u028c(\u0461);
        \u03b3 = new oca9cc61aada("Scale", 1, \u056b);
        this.\u028c(\u03b3);
        \u04e3 = new oca9cc61aada("Animation", 0x30995605 ^ 0x30995607, \u04ce);
        this.\u028c(\u04e3);
        this.\u01e4(true);
        this.z$2u87utkr1isxg();
    }

    @Override
    public void onEnable() {
        block3: {
            oc46245c2b20 oc46245c2b202;
            block2: {
                int n = oc74760d9133.\u019e;
                oc46245c2b202 = oc2cf3d80e17.\u02e1;
                if (n != 0) break block2;
                if (oc46245c2b202 == null) break block3;
                oc46245c2b202 = oc2cf3d80e17.\u02e1;
            }
            oc46245c2b202.\u03a7();
        }
    }

    @Override
    public void onDisable() {
        block3: {
            oc46245c2b20 oc46245c2b202;
            block2: {
                int n = oc74760d9133.\u019e;
                oc46245c2b202 = oc2cf3d80e17.\u02e1;
                if (n != 0) break block2;
                if (oc46245c2b202 == null) break block3;
                oc46245c2b202 = oc2cf3d80e17.\u02e1;
            }
            oc46245c2b202.\u0458();
        }
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        block10: {
            block9: {
                int n2;
                block8: {
                    n2 = oc74760d9133.\u019e;
                    if (n == this.\u0403 && oc2cf3d80e17.\u02e1 != null) break block8;
                    return;
                }
                if (!oc3b38397625.\u04c8()) break block9;
                oc2cf3d80e17.\u02e1.\u03a7();
                if (n2 == 0) break block10;
            }
            oc2cf3d80e17.\u02e1.\u0458();
        }
    }

    @Override
    public void z$2u87utkr1isxg() {
        boolean bl = this.\u0403.\u01e9("Slinky");
        this.\u03f5.\u0209(bl, this);
        this.\u0136.\u0209(bl, this);
        int n = oc74760d9133.\u019e;
        \u0461.\u0209(bl, this);
        \u03b3.\u0209(bl, this);
        \u04e3.\u0209(bl, this);
        if (false) {
            oc74760d9133.\u019e = ++n;
        }
    }

    public static boolean \u037b() {
        return oc3b38397625.\u0501("Chat");
    }

    public static boolean \u04c8() {
        return oc3b38397625.\u0501("Slinky");
    }

    private static boolean \u0501(String string) {
        boolean bl;
        block11: {
            block9: {
                oc3b38397625 oc3b383976252;
                int n;
                block10: {
                    oc3b38397625 oc3b383976253;
                    block8: {
                        oc3b383976253 = oc9755810e45.\u04db;
                        n = oc74760d9133.\u019e;
                        oc3b383976252 = oc3b383976253;
                        if (n != 0) break block8;
                        if (oc3b383976252 == null) break block9;
                        oc3b383976252 = oc3b383976253;
                    }
                    if (n != 0) break block10;
                    if (!oc3b383976252.z$3rzb3dil7uydr()) break block9;
                    oc3b383976252 = oc3b383976253;
                }
                bl = oc3b383976252.\u0403.\u01e9(string);
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static float \u02a8() {
        int n;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                block5: {
                    int n2 = oc74760d9133.\u019e;
                    oca9cc61aada2 = \u03b3;
                    if (n2 != 0) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    n = 1;
                    break block6;
                }
                oca9cc61aada2 = \u03b3;
            }
            n = (int)oca9cc61aada2.\u04c1();
        }
        int n3 = n;
        n3 = Math.max(0, Math.min(\u0427.length - 1, n3));
        return \u0427[n3];
    }

    public static int \u02b0() {
        int n;
        block6: {
            oc24a0a5bddf oc24a0a5bddf2;
            block4: {
                block5: {
                    int n2 = oc74760d9133.\u019e;
                    oc24a0a5bddf2 = \u0461;
                    if (n2 != 0) break block4;
                    if (oc24a0a5bddf2 != null) break block5;
                    n = 0x507F0F91 ^ 0x50C580E8;
                    break block6;
                }
                oc24a0a5bddf2 = \u0461;
            }
            n = oc24a0a5bddf2.\u01d0();
        }
        return n;
    }

    public static int \u00f4() {
        int n;
        block6: {
            oca9cc61aada oca9cc61aada2;
            block4: {
                block5: {
                    int n2 = oc74760d9133.\u019e;
                    oca9cc61aada2 = \u04e3;
                    if (n2 != 0) break block4;
                    if (oca9cc61aada2 != null) break block5;
                    n = 0x528E5D18 ^ 0x528E5D1A;
                    break block6;
                }
                oca9cc61aada2 = \u04e3;
            }
            n = (int)oca9cc61aada2.\u04c1();
        }
        int n3 = n;
        return Math.max(0, Math.min(\u04ce.length - 1, n3));
    }

    static {
        String[] stringArray = new String[0x5980B374 ^ 0x5980B377];
        stringArray[0] = "None";
        stringArray[1] = "Move in";
        stringArray[0x5980B375 ^ 0x5980B377] = "Scale in";
        \u04ce = stringArray;
        String[] stringArray2 = new String[0x5980B373 ^ 0x5980B377];
        stringArray2[0] = "75%";
        stringArray2[1] = "100%";
        stringArray2[0x5980B375 ^ 0x5980B377] = "150%";
        stringArray2[0x5980B374 ^ 0x5980B377] = "200%";
        \u056b = stringArray2;
        float[] fArray = new float[0x5980B373 ^ 0x5980B377];
        fArray[0] = 0.75f;
        fArray[1] = 1.0f;
        fArray[0x5980B375 ^ 0x5980B377] = 1.5f;
        fArray[0x5980B374 ^ 0x5980B377] = 2.0f;
        \u0427 = fArray;
    }
}

