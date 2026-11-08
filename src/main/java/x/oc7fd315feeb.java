/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.W;
import x.oc1378bc114d;
import x.oc255ab955c3;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.oca9cc61aada;
import x.ocada7dda290;

public class oc7fd315feeb
extends oc5e2e2031b5 {
    private final oca9cc61aada \u03e2;
    private final ocada7dda290 \u0209;
    private boolean \u056b;

    oc7fd315feeb(oca9cc61aada oca9cc61aada2, oc69da1aa7f5 oc69da1aa7f52) {
        super(oca9cc61aada2, oc69da1aa7f52);
        this.\u03e2 = oca9cc61aada2;
        this.\u0209 = null;
    }

    oc7fd315feeb(ocada7dda290 ocada7dda2902, oc69da1aa7f5 oc69da1aa7f52) {
        super(ocada7dda2902, oc69da1aa7f52);
        this.\u03e2 = null;
        this.\u0209 = ocada7dda2902;
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u0117();
        int n3 = oc255ab955c3.\u01ea((double)this.\u0152 + (double)this.\u016d * 0.5, (double)this.\u0417 + 7.5);
        if (oc255ab955c3.\u050e(this.\u0152 - 3.0f, this.\u0417, this.\u016d, 15.0f, n, n2)) {
            W.\u02e0(this.\u0152 - 3.0f, this.\u0417, this.\u016d, 15.0f, 2.0f, 0xC16608F3 ^ 0x577F11EA);
        }
        String string = this.\u047b.z$18nrktuqeiysv();
        String string2 = this.P();
        int n4 = oc1378bc114d2.z$toz8pt08w0nc(string2);
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(string, oc1378bc114d2, (int)this.\u016d - n4 - (0x577F11F8 ^ 0x577F11EA)), this.\u0152 + 2.0f, oc255ab955c3.\u0544((int)this.\u0417, 0x577F11E5 ^ 0x577F11EA, oc1378bc114d2), -1, false);
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(string2, oc1378bc114d2, Math.max(0x577F11FE ^ 0x577F11EA, (int)this.\u016d / (0x577F11E8 ^ 0x577F11EA))), this.\u0152 + this.\u016d - 16.0f - (float)n4, oc255ab955c3.\u0544((int)this.\u0417, 0x577F11E5 ^ 0x577F11EA, oc1378bc114d2), n3, false);
        oc1378bc114d2.z$ao2ykh4tuw6w(this.\u056b ? "v" : ">", this.\u0152 + this.\u016d - 10.0f, this.\u0417 + 3.0f, 0xA8E18F74 ^ 0x577F11EA, false);
        if (!this.\u056b) {
            return;
        }
        String[] stringArray = this.\u04b2();
        W.\u02e0(this.\u0152 - 3.0f, this.\u0417 + 15.0f, this.\u016d, (0x577F11E5 ^ 0x577F11EA) * stringArray.length, 3.0f, oc255ab955c3.\u0515(0xA86608F3 ^ 0x577F11EA, 0x577F1110 ^ 0x577F11EA));
        for (int i = 0; i < stringArray.length; ++i) {
            float f = this.\u0417 + (float)((0x577F11E5 ^ 0x577F11EA) * (i + 1));
            boolean bl = this.\u040c(i, stringArray[i]);
            boolean bl2 = oc255ab955c3.\u050e(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, n, n2);
            if (bl2) {
                W.\u02e0(this.\u0152 - 2.0f, f + 1.0f, this.\u016d - 2.0f, 13.0f, 2.0f, 0xC16608F3 ^ 0x577F11EA);
            }
            String string3 = oc255ab955c3.\u0516(stringArray[i].replace((char)(0x577F11B5 ^ 0x577F11EA), (char)(0x577F11CA ^ 0x577F11EA)), oc1378bc114d2, (int)this.\u016d - (0x577F11F0 ^ 0x577F11EA));
            oc1378bc114d2.z$ao2ykh4tuw6w(string3, this.\u0152 + 6.0f, oc255ab955c3.\u0544((int)f, 0x577F11E5 ^ 0x577F11EA, oc1378bc114d2), bl ? n3 : (bl2 ? -1 : 0xA8E18F74 ^ 0x577F11EA), false);
            if (!bl) continue;
            W.\u02e0(this.\u0152 + this.\u016d - 13.0f, f + 4.5f, 6.0f, 6.0f, 3.0f, n3);
        }
    }

    @Override
    int z$ag4eb8ubl7je() {
        return (0x85B6250A ^ 0x85B62505) * (this.\u056b ? this.\u04b2().length + 1 : 1);
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (n3 != 0) {
            return false;
        }
        if (oc255ab955c3.\u050e(this.\u0152 - 3.0f, this.\u0417, this.\u016d, 15.0f, n, n2)) {
            this.\u056b = !this.\u056b;
            return true;
        }
        if (!this.\u056b) {
            return false;
        }
        String[] stringArray = this.\u04b2();
        for (int i = 0; i < stringArray.length; ++i) {
            float f = this.\u0417 + (float)((0x810143EE ^ 0x810143E1) * (i + 1));
            if (!oc255ab955c3.\u050e(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, n, n2)) continue;
            if (this.\u03e2 != null) {
                this.\u03e2.\u02ab(i);
                this.\u0273.z$1sehylui0i4ix(this.\u03e2);
                this.\u056b = false;
            } else {
                this.\u0209.\u0465(stringArray[i]);
                this.\u0273.z$3tl278wzjcayb(this.\u0209);
                this.\u0273.z$2u87utkr1isxg();
            }
            this.\u0416();
            return true;
        }
        return false;
    }

    @Override
    void z$3hwl7t34zws09() {
        this.\u056b = false;
    }

    private String[] \u04b2() {
        return this.\u03e2 == null ? this.\u0209.\u01e5() : this.\u03e2.\u04be();
    }

    private boolean \u040c(int n, String string) {
        return this.\u03e2 == null ? this.\u0209.\u01e9(string) : (int)this.\u03e2.\u04c1() == n;
    }

    private String P() {
        if (this.\u03e2 != null) {
            String[] stringArray = this.\u03e2.\u04be();
            if (stringArray.length == 0) {
                return "None";
            }
            int n = Math.max(0, Math.min(stringArray.length - 1, (int)this.\u03e2.\u04c1()));
            return stringArray[n].replace((char)(0xA1DE49B3 ^ 0xA1DE49EC), (char)(0xA1DE49CC ^ 0xA1DE49EC));
        }
        int n = this.\u0209.\u0507().size();
        if (n == 0) {
            return "None";
        }
        if (n == 1) {
            return this.\u0209.\u0507().get(0).replace((char)(0xA1DE49B3 ^ 0xA1DE49EC), (char)(0xA1DE49CC ^ 0xA1DE49EC));
        }
        return n + " selected";
    }
}

