/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import x.N;
import x.oc0af730cc9f;
import x.oc10354c7bb8;
import x.oc24a0a5bddf;
import x.oc255ab955c3;
import x.oc25d9ae5593;
import x.oc2ada83901b;
import x.oc2cf3d80e17;
import x.oc2ec6a95e5c;
import x.oc300695e691;
import x.oc30c8fb3a16;
import x.oc321b4679dd;
import x.oc34e6c65587;
import x.oc4d46a99983;
import x.oc69da1aa7f5;
import x.oc6af36febc3;
import x.oc7fd315feeb;
import x.oc93f6136fee;
import x.oc9b1cbd3b8d;
import x.oca9cc61aada;
import x.ocada7dda290;
import x.ocb23d192a35;
import x.ocbc9c7a1e51;
import x.occ2f8dff8d8;
import x.occ876d93e01;
import x.occc831eff22;
import x.ocd808b71f1d;
import x.oce1bd2fa256;
import x.ocf1568fef75;

public abstract class oc5e2e2031b5 {
    final N \u047b;
    final oc69da1aa7f5 \u0273;
    float \u0152;
    float \u0417;
    float \u016d;

    oc5e2e2031b5(N n, oc69da1aa7f5 oc69da1aa7f52) {
        this.\u047b = n;
        this.\u0273 = oc69da1aa7f52;
    }

    static oc5e2e2031b5 \u0208(N n, oc69da1aa7f5 oc69da1aa7f52, List<N> list) {
        if (n instanceof occc831eff22) {
            return new ocd808b71f1d((occc831eff22)n, oc69da1aa7f52, list);
        }
        if (n instanceof occ2f8dff8d8) {
            return new oc30c8fb3a16((occ2f8dff8d8)n, oc69da1aa7f52);
        }
        if (n instanceof ocada7dda290) {
            return new oc7fd315feeb((ocada7dda290)n, oc69da1aa7f52);
        }
        if (n instanceof oca9cc61aada) {
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)n;
            return oca9cc61aada2.\u00c6 ? new oc7fd315feeb(oca9cc61aada2, oc69da1aa7f52) : new oc34e6c65587(oca9cc61aada2, oc69da1aa7f52);
        }
        if (n instanceof ocf1568fef75) {
            return new oc9b1cbd3b8d((ocf1568fef75)n, oc69da1aa7f52);
        }
        if (n instanceof oc24a0a5bddf) {
            return new occ876d93e01((oc24a0a5bddf)n, oc69da1aa7f52);
        }
        if (n instanceof oc321b4679dd) {
            return new oc300695e691((oc321b4679dd)n, oc69da1aa7f52);
        }
        if (n instanceof ocb23d192a35) {
            return new oc93f6136fee((ocb23d192a35)n, oc69da1aa7f52);
        }
        if (n instanceof oce1bd2fa256) {
            return new oc2ada83901b((oce1bd2fa256)n, oc69da1aa7f52);
        }
        if (n instanceof ocbc9c7a1e51) {
            return new oc2ada83901b((ocbc9c7a1e51)n, oc69da1aa7f52);
        }
        if (n instanceof oc0af730cc9f) {
            return new oc2ada83901b((oc0af730cc9f)n, oc69da1aa7f52);
        }
        if (n instanceof oc2ec6a95e5c) {
            return new oc2ada83901b((oc2ec6a95e5c)n, oc69da1aa7f52);
        }
        if (n instanceof oc10354c7bb8) {
            return new oc2ada83901b((oc10354c7bb8)n, oc69da1aa7f52);
        }
        if (n instanceof oc6af36febc3) {
            return new oc2ada83901b((oc6af36febc3)n, oc69da1aa7f52);
        }
        if (n instanceof oc4d46a99983) {
            return new oc25d9ae5593((oc4d46a99983)n, oc69da1aa7f52);
        }
        return new oc25d9ae5593(n, oc69da1aa7f52);
    }

    static occc831eff22 \u0194(N n) {
        if (n instanceof occ2f8dff8d8) {
            return ((occ2f8dff8d8)n).\u03e1;
        }
        if (n instanceof oca9cc61aada) {
            return ((oca9cc61aada)n).\u026c;
        }
        if (n instanceof ocf1568fef75) {
            return ((ocf1568fef75)n).\u0415;
        }
        if (n instanceof ocada7dda290) {
            return ((ocada7dda290)n).\u0467;
        }
        if (n instanceof oc24a0a5bddf) {
            return ((oc24a0a5bddf)n).a;
        }
        if (n instanceof ocb23d192a35) {
            return ((ocb23d192a35)n).\u044d;
        }
        if (n instanceof oc321b4679dd) {
            return ((oc321b4679dd)n).\u01e1;
        }
        if (n instanceof oc6af36febc3) {
            return ((oc6af36febc3)n).\u0377;
        }
        if (n instanceof oc10354c7bb8) {
            return ((oc10354c7bb8)n).\u0150;
        }
        if (n instanceof oce1bd2fa256) {
            return ((oce1bd2fa256)n).\u01f3;
        }
        return null;
    }

    void \u02b8(float f, float f2, float f3) {
        this.\u0152 = f;
        this.\u0417 = f2;
        this.\u016d = f3;
    }

    boolean \u00ce() {
        return this.\u047b.\u04c0;
    }

    int z$ag4eb8ubl7je() {
        return 0xF21DEA16 ^ 0xF21DEA19;
    }

    abstract void z$1v7hdj78iia5d(int var1, int var2);

    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        return false;
    }

    void z$rq44izq02hqg(int n, int n2, int n3) {
    }

    boolean z$3twgyf5k61sst(char c, int n) {
        return false;
    }

    boolean z$3kj7psbv4c9hb(int n, int n2, int n3) {
        return false;
    }

    void z$1l3ht5d17kefg() {
    }

    void z$3hwl7t34zws09() {
        this.z$1l3ht5d17kefg();
    }

    boolean \u01f7(int n, int n2) {
        return oc255ab955c3.\u050e(this.\u0152 - 3.0f, this.\u0417, this.\u016d, this.z$ag4eb8ubl7je(), n, n2);
    }

    void \u0416() {
        if (oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u0115.\u01da().\u018b = false;
        }
    }
}

