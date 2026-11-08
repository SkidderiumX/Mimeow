/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.gui.Gui;
import x.W;
import x.oc08592ac73b;
import x.oc1378bc114d;
import x.oc151419fdfe;
import x.oc213c6745ad;
import x.oc255ab955c3;
import x.oc2cf3d80e17;
import x.oc67f8865952;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.ocbd4917c4b1;
import x.ocd935250e5d;
import x.oce4cea752dd;

public class oc670dbafdea {
    private static final int \u040a = 19;
    private static final float \u03b6 = 4.0f;
    private static final int \u04c5 = 3;
    private static final long \u01f8 = 220L;
    private static long \u0493;
    private final oce4cea752dd \u0284;
    private final int \u040c;
    private final List<oc67f8865952> \u03ab = new ArrayList<oc67f8865952>();
    private final ocd935250e5d \u03a0 = new ocd935250e5d(0.0f);
    private int \u0121;
    private int \u0159;
    private int \u0229;
    private int \u0391;
    private int \u02a8;
    private int \u024c;
    private int \u0532;
    private float b;
    private float \u02a7;
    private boolean \u04ce;
    private boolean \u015f;
    private long \u04b5;

    oc670dbafdea(oce4cea752dd oce4cea752dd2, int n) {
        this.\u0284 = oce4cea752dd2;
        this.\u040c = n;
        this.\u0404();
    }

    void \u02aa(int n, int n2, float f) {
        this.\u0229 = Math.round(((float)this.\u0159 + this.\u02a7) * f);
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u024c();
        String string = oc255ab955c3.\u026f(this.\u0284.name());
        int n3 = oc255ab955c3.\u0544(this.\u0229, 0xEDAFBF5F ^ 0xEDAFBF4C, oc1378bc114d2);
        if (this.\u024c <= 0) {
            W.\u02e0(this.\u0121, this.\u0229, this.\u040c, 19.0f, 4.0f, 0x12B6A655 ^ 0xEDAFBF4C);
            oc1378bc114d2.z$ao2ykh4tuw6w(string, this.\u0121 + (0xEDAFBF4A ^ 0xEDAFBF4C), n3, -1, true);
            this.\u057f();
            return;
        }
        W.\u02e0(this.\u0121, this.\u0229, this.\u040c, (0xEDAFBF5F ^ 0xEDAFBF4C) + this.\u024c + (0xEDAFBF4F ^ 0xEDAFBF4C), 4.0f, 0x12869665 ^ 0xEDAFBF4C);
        W.b(this.\u0121, this.\u0229, this.\u040c, 19.0f, 4.0f, 0x12B6A655 ^ 0xEDAFBF4C, true, true, false, false);
        Gui.drawRect(this.\u0121, this.\u0229 + (0xEDAFBF5F ^ 0xEDAFBF4C) - 1, this.\u0121 + this.\u040c, this.\u0229 + (0xEDAFBF5F ^ 0xEDAFBF4C), 0x12BFAF5C ^ 0xEDAFBF4C);
        oc1378bc114d2.z$ao2ykh4tuw6w(string, this.\u0121 + (0xEDAFBF4A ^ 0xEDAFBF4C), n3, -1, true);
        this.\u057f();
        ocbd4917c4b1.\u010e(this.\u0121, this.\u0229 + (0xEDAFBF5F ^ 0xEDAFBF4C), this.\u040c, this.\u024c);
        int n4 = this.\u0229 + (0xEDAFBF5F ^ 0xEDAFBF4C) - Math.round(this.b);
        for (int i = 0; i < this.\u03ab.size(); ++i) {
            oc67f8865952 oc67f88659522 = this.\u03ab.get(i);
            oc67f88659522.\u0476(i);
            oc67f88659522.\u0214(this.\u0121, n4, this.\u040c);
            oc67f88659522.\u0376(n, n2);
            n4 += oc67f88659522.\u04b8();
        }
        ocbd4917c4b1.\u01df();
    }

    boolean \u0297(int n, int n2, int n3) {
        if (oc255ab955c3.\u050e(this.\u0121, this.\u0229, this.\u040c, 19.0f, n, n2)) {
            this.\u03ab();
            if (n3 == 1) {
                this.\u04ce = !this.\u04ce;
                this.t();
                oc2cf3d80e17.\u04eb();
            } else if (n3 == 0) {
                this.\u0159 = Math.round((float)this.\u0159 + this.\u02a7);
                this.\u02a7 = 0.0f;
                this.\u0229 = this.\u0159;
                this.\u015f = true;
                this.\u0391 = this.\u0121 - n;
                this.\u02a8 = this.\u0159 - n2;
            }
            return n3 == 0 || n3 == 1;
        }
        if (!this.\u04ce || !this.\u00c7(n, n2)) {
            return false;
        }
        for (oc67f8865952 oc67f88659522 : this.\u03ab) {
            if (!oc67f88659522.\u0290(n, n2, n3)) continue;
            return true;
        }
        this.\u03ab();
        return true;
    }

    boolean \u0186(int n, int n2, int n3) {
        boolean bl = this.\u015f;
        this.\u015f = false;
        for (oc67f8865952 oc67f88659522 : this.\u03ab) {
            oc67f88659522.c(n, n2, n3);
        }
        return bl;
    }

    boolean \u0435(char c, int n) {
        if (!this.\u04ce) {
            return false;
        }
        for (oc67f8865952 oc67f88659522 : this.\u03ab) {
            if (!oc67f88659522.\u0586(c, n)) continue;
            return true;
        }
        return false;
    }

    boolean \u01a6(int n, int n2, int n3) {
        if (!this.\u04ce || !this.\u00c7(n, n2)) {
            return false;
        }
        for (oc67f8865952 oc67f88659522 : this.\u03ab) {
            if (!oc67f88659522.\u04df(n, n2, n3)) continue;
            return true;
        }
        this.b -= oc08592ac73b.\u02b5(n3, oc6a43806f12.\u04f9.\u04c1());
        this.t();
        return true;
    }

    void \u0282() {
        List<oc69da1aa7f5> list = this.\u050e();
        list.sort(Comparator.comparing(oc69da1aa7f5::z$3i8m9vxwuvqj0, String.CASE_INSENSITIVE_ORDER));
        HashMap<Object, oc67f8865952> hashMap = new HashMap<Object, oc67f8865952>();
        for (oc67f8865952 object : this.\u03ab) {
            hashMap.put(object.\u040d().\u0452() + "\u0000" + object.\u040d().z$3i8m9vxwuvqj0(), object);
            hashMap.put(object.\u040d().z$3i8m9vxwuvqj0(), object);
        }
        this.\u03ab.clear();
        for (oc69da1aa7f5 oc69da1aa7f52 : list) {
            oc67f8865952 oc67f88659522 = (oc67f8865952)hashMap.get(oc69da1aa7f52.\u0452() + "\u0000" + oc69da1aa7f52.z$3i8m9vxwuvqj0());
            if (oc67f88659522 == null) {
                oc67f88659522 = (oc67f8865952)hashMap.get(oc69da1aa7f52.z$3i8m9vxwuvqj0());
            }
            oc67f8865952 oc67f88659523 = new oc67f8865952(oc69da1aa7f52);
            if (oc67f88659522 != null) {
                oc67f88659523.\u0405(oc67f88659522);
            }
            this.\u03ab.add(oc67f88659523);
        }
        this.t();
    }

    void \u03ab() {
        for (oc67f8865952 oc67f88659522 : this.\u03ab) {
            oc67f88659522.\u04df();
        }
    }

    void \u0109() {
        this.\u015f = false;
        for (oc67f8865952 oc67f88659522 : this.\u03ab) {
            oc67f88659522.\u0564();
        }
        this.\u03a0.\u04ca(this.\u04ce ? 1.0f : 0.0f);
    }

    void \u01ce() {
        this.\u015f = false;
    }

    void \u02a7(int n, int n2, int n3) {
        if (this.\u015f) {
            this.\u0121 = n + this.\u0391;
            this.\u0159 = n2 + this.\u02a8;
        }
        this.\u0532 = this.\u02c1();
        this.\u03a0.\u0392(this.\u04ce ? 1.0f : 0.0f, 0x10CC013B2A4970FAL ^ 0x10CC013B2A497026L);
        float f = this.\u03a0.\u02b1();
        int n4 = Math.round((float)this.\u0159 + this.\u02a7);
        int n5 = Math.max(0, n3 - n4 - (0x3D51437A ^ 0x3D514370) - (0x3D514363 ^ 0x3D514370));
        this.\u024c = Math.min(Math.round((float)this.\u0532 * f), n5);
        this.t();
    }

    void \u0177(float f) {
        this.\u02a7 = Math.max(0.0f, f);
    }

    float \u0262() {
        return (0xC2BD1F55 ^ 0xC2BD1F46) + this.\u024c + (0xC2BD1F45 ^ 0xC2BD1F46);
    }

    boolean \u0444() {
        return this.\u015f;
    }

    void \u0509(int n, int n2) {
        this.\u0121 = n;
        this.\u0159 = n2;
        this.\u02a7 = 0.0f;
    }

    void \u04a6(int n, int n2) {
        this.\u0121 = Math.max(0, Math.min(this.\u0121, Math.max(0, n - this.\u040c)));
        this.\u0159 = Math.max(0, Math.min(this.\u0159, Math.max(0, n2 - (0xAB2B0A08 ^ 0xAB2B0A1B))));
    }

    void \u0404() {
        this.\u04b5 = ++\u0493;
    }

    long \u03cb() {
        return this.\u04b5;
    }

    public oce4cea752dd \u0238() {
        return this.\u0284;
    }

    public int \u01e3() {
        return this.\u0121;
    }

    public int \u039e() {
        return this.\u0159;
    }

    public int \u01bf() {
        return this.\u040c;
    }

    public boolean \u047a() {
        return this.\u04ce;
    }

    public void \u0254(int n, int n2, boolean bl) {
        this.\u0121 = n;
        this.\u0159 = n2;
        this.\u04ce = bl;
        this.\u02a7 = 0.0f;
        this.\u0532 = this.\u02c1();
        this.\u03a0.\u04ca(bl ? 1.0f : 0.0f);
        this.\u024c = bl ? this.\u0532 : 0;
    }

    private int \u02c1() {
        int n = 0;
        for (oc67f8865952 oc67f88659522 : this.\u03ab) {
            n += oc67f88659522.\u04b8();
        }
        return n;
    }

    private void t() {
        this.b = Math.max(0.0f, Math.min(this.b, (float)Math.max(0, this.\u0532 - this.\u024c)));
    }

    private boolean \u00c7(int n, int n2) {
        return oc255ab955c3.\u050e(this.\u0121, this.\u0229 + (0x4A41015E ^ 0x4A41014D), this.\u040c, this.\u024c, n, n2);
    }

    private List<oc69da1aa7f5> \u050e() {
        if (oc2cf3d80e17.\u013c == null) {
            return Collections.emptyList();
        }
        if (this.\u0284 != oce4cea752dd.\u051d) {
            return new ArrayList<oc69da1aa7f5>(oc2cf3d80e17.\u013c.\u0249(this.\u0284));
        }
        ArrayList<oc69da1aa7f5> arrayList = new ArrayList<oc69da1aa7f5>();
        if (oc2cf3d80e17.\u00c1 != null) {
            for (oc151419fdfe oc151419fdfe2 : oc2cf3d80e17.\u00c1.\u01f9) {
                arrayList.add(oc151419fdfe2.\u01da());
            }
        }
        return arrayList;
    }

    private void \u057f() {
        String string = oc670dbafdea.\u0469(this.\u0284);
        int n = oc255ab955c3.\u01ea((double)this.\u0121 + (double)this.\u040c * 0.5, (double)this.\u0229 + 9.5);
        if (!oc255ab955c3.\u01ca(string, this.\u0121 + this.\u040c - (0x88A92415 ^ 0x88A9241A), oc255ab955c3.\u0544(this.\u0229, 0x88A92409 ^ 0x88A9241A, oc255ab955c3.\u024c()) - 1, 0x88A92413 ^ 0x88A9241A, 0x88A92413 ^ 0x88A9241A, n)) {
            Gui.drawRect(this.\u0121 + this.\u040c - (0x88A92414 ^ 0x88A9241A), this.\u0229 + (0x88A92413 ^ 0x88A9241A) - (0x88A9241E ^ 0x88A9241A), this.\u0121 + this.\u040c - (0x88A9241F ^ 0x88A9241A), this.\u0229 + (0x88A92413 ^ 0x88A9241A) + (0x88A9241E ^ 0x88A9241A), n);
        }
    }

    private static String \u0469(oce4cea752dd oce4cea752dd2) {
        switch (oc213c6745ad.\u037c[oce4cea752dd2.ordinal()]) {
            case 1: {
                return "move";
            }
            case 2: 
            case 3: {
                return "visuals";
            }
            case 4: 
            case 5: {
                return "script";
            }
            case 6: {
                return "combat";
            }
            case 7: {
                return "player";
            }
            case 8: 
            case 9: 
            case 10: {
                return "world";
            }
        }
        return "exploit";
    }
}

