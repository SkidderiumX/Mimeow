/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import x.N;
import x.oc0b01802c56;
import x.oc0dddd2db0b;
import x.oc10354c7bb8;
import x.oc1cb76bf763;
import x.oc24a0a5bddf;
import x.oc28d879035d;
import x.oc321b4679dd;
import x.oc4d46a99983;
import x.oc4f21845252;
import x.oc559475c182;
import x.oc69da1aa7f5;
import x.oc6af36febc3;
import x.oc8aaacef5d6;
import x.oca9cc61aada;
import x.ocada7dda290;
import x.ocb072b0dd6a;
import x.ocb23d192a35;
import x.ocb24b6f6ca5;
import x.ocb29e26d1a9;
import x.occ242fb507a;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.ocd22c3031a1;
import x.ocda2d7d3e89;
import x.oce1bd2fa256;
import x.oce2d5c38593;
import x.ocf1568fef75;

public class oc1079614cc6 {
    private final List<oc4f21845252> \u029a = new ArrayList<oc4f21845252>();

    oc1079614cc6(oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        this(oc69da1aa7f52, oc1cb76bf7632, oc69da1aa7f52.\u0260(), null, Collections.newSetFromMap(new IdentityHashMap()));
    }

    private oc1079614cc6(oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632, List<N> list, occc831eff22 occc831eff222, Set<N> set) {
        for (N n : list) {
            if (n instanceof oc4d46a99983 || set.contains(n) || oc0dddd2db0b.\u04f4(n, list) != occc831eff222) continue;
            set.add(n);
            if (n instanceof occc831eff22) {
                occc831eff22 occc831eff223 = (occc831eff22)n;
                this.\u029a.add(new ocb24b6f6ca5(occc831eff223, oc69da1aa7f52, oc1cb76bf7632, new oc1079614cc6(oc69da1aa7f52, oc1cb76bf7632, list, occc831eff223, set)));
                continue;
            }
            this.\u029a.add(oc1079614cc6.\u0217(n, oc69da1aa7f52, oc1cb76bf7632));
        }
    }

    private static oc4f21845252 \u0217(N n, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        if (n instanceof occ2f8dff8d8) {
            occ2f8dff8d8 occ2f8dff8d82 = (occ2f8dff8d8)n;
            return new occ242fb507a(occ2f8dff8d82, oc69da1aa7f52, oc1cb76bf7632);
        }
        if (n instanceof oca9cc61aada) {
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)n;
            return oca9cc61aada2.\u00c6 ? new ocda2d7d3e89(oca9cc61aada2, oc69da1aa7f52, oc1cb76bf7632) : new ocb29e26d1a9(oca9cc61aada2, oc69da1aa7f52, oc1cb76bf7632);
        }
        if (n instanceof ocf1568fef75) {
            ocf1568fef75 ocf1568fef752 = (ocf1568fef75)n;
            return new oce2d5c38593(ocf1568fef752, oc69da1aa7f52, oc1cb76bf7632);
        }
        if (n instanceof oc24a0a5bddf) {
            oc24a0a5bddf oc24a0a5bddf2 = (oc24a0a5bddf)n;
            return new oc0b01802c56(oc24a0a5bddf2, oc69da1aa7f52, oc1cb76bf7632);
        }
        if (n instanceof ocada7dda290) {
            ocada7dda290 ocada7dda2902 = (ocada7dda290)n;
            return new oc559475c182(ocada7dda2902, oc69da1aa7f52, oc1cb76bf7632);
        }
        if (n instanceof oc321b4679dd) {
            oc321b4679dd oc321b4679dd2 = (oc321b4679dd)n;
            return new ocb072b0dd6a(oc321b4679dd2, oc69da1aa7f52, oc1cb76bf7632);
        }
        if (n instanceof ocb23d192a35) {
            ocb23d192a35 ocb23d192a352 = (ocb23d192a35)n;
            return new ocd22c3031a1(ocb23d192a352, oc69da1aa7f52, oc1cb76bf7632);
        }
        if (n instanceof oc10354c7bb8 || n instanceof oc6af36febc3 || n instanceof oce1bd2fa256) {
            return new oc28d879035d(n, oc69da1aa7f52, oc1cb76bf7632);
        }
        return new oc4f21845252(n, oc69da1aa7f52, oc1cb76bf7632);
    }

    float \u0116(oc8aaacef5d6 oc8aaacef5d62, float f) {
        float f2 = 0.0f;
        for (oc4f21845252 oc4f218452522 : this.\u029a) {
            if (oc4f218452522.\u04b3.\u04c0) {
                oc4f218452522.\u03c8 = f;
                f2 += oc4f218452522.z$3i1zpd5rao25t(oc8aaacef5d62);
                continue;
            }
            oc4f218452522.z$21n2hyuutt37u();
        }
        return f2;
    }

    void \u011d(oc8aaacef5d6 oc8aaacef5d62, float f, float f2, float f3, float f4, float f5, boolean bl) {
        List<oc4f21845252> list = this.\u029a.stream().filter(oc4f218452522 -> oc4f218452522.\u04b3.\u04c0).toList();
        float f6 = f2;
        for (int i = 0; i < list.size(); ++i) {
            oc4f21845252 oc4f218452523 = list.get(i);
            oc4f218452523.\u01e7 = f;
            oc4f218452523.\u0575 = f6;
            oc4f218452523.\u03c8 = f3;
            oc4f218452523.\u039b = bl && i == list.size() - 1;
            oc4f218452523.\u041a = oc4f218452523.z$3i1zpd5rao25t(oc8aaacef5d62);
            oc4f218452523.z$28tc36an9xevp(oc8aaacef5d62, f4, f5);
            f6 += oc4f218452523.\u041a;
        }
    }

    boolean \u0446(float f, float f2, int n) {
        for (oc4f21845252 oc4f218452522 : this.\u029a) {
            if (!oc4f218452522.\u04b3.\u04c0 || !oc4f218452522.\u00c0(f, f2) || !oc4f218452522.z$3iwy342velf2h(f, f2, n)) continue;
            return true;
        }
        return false;
    }

    void s() {
        this.\u029a.forEach(oc4f21845252::z$jjpp51h3b2lm);
    }

    void \u02a2() {
        this.\u029a.forEach(oc4f21845252::z$21n2hyuutt37u);
    }

    boolean \u0169() {
        return this.\u029a.isEmpty();
    }
}

