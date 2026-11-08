/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.N;
import x.oc1378bc114d;
import x.oc255ab955c3;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.occc831eff22;

public class ocd808b71f1d
extends oc5e2e2031b5 {
    private final occc831eff22 \u01b8;
    private final List<oc5e2e2031b5> \u021c = new ArrayList<oc5e2e2031b5>();

    ocd808b71f1d(occc831eff22 occc831eff222, oc69da1aa7f5 oc69da1aa7f52, List<N> list) {
        super(occc831eff222, oc69da1aa7f52);
        this.\u01b8 = occc831eff222;
        for (N n : list) {
            if (oc5e2e2031b5.\u0194(n) != this.\u01b8) continue;
            this.\u021c.add(oc5e2e2031b5.\u0208(n, oc69da1aa7f52, list));
        }
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        oc255ab955c3.\u04df(this.\u0152 - 3.0f, this.\u0417, this.\u016d, n, n2);
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u0117();
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(this.\u01b8.z$18nrktuqeiysv(), oc1378bc114d2, (int)this.\u016d - (0x1FECE8FD ^ 0x1FECE8EF)), this.\u0152 + 2.0f, oc255ab955c3.\u0544((int)this.\u0417, 0x1FECE8E0 ^ 0x1FECE8EF, oc1378bc114d2), -1, false);
        int n3 = oc255ab955c3.\u01ea((double)this.\u0152 + (double)this.\u016d * 0.5, (double)this.\u0417 + 7.5);
        if (!oc255ab955c3.\u01ca(this.\u01b8.\u01ab() ? "expand" : "collapse", this.\u0152 + this.\u016d - 12.0f, this.\u0417 + 5.0f, 0x1FECE8E7 ^ 0x1FECE8EF, 0x1FECE8EA ^ 0x1FECE8EF, n3)) {
            oc1378bc114d2.z$ao2ykh4tuw6w(this.\u01b8.\u01ab() ? "-" : "+", this.\u0152 + this.\u016d - 10.0f, this.\u0417 + 3.0f, n3, false);
        }
        if (!this.\u01b8.\u01ab()) {
            return;
        }
        int n4 = (int)this.\u0417 + (0x1FECE8E0 ^ 0x1FECE8EF);
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u021c) {
            if (!oc5e2e2031b52.\u00ce()) continue;
            oc5e2e2031b52.\u02b8(this.\u0152 + 3.0f, n4, this.\u016d - 3.0f);
            oc5e2e2031b52.z$1v7hdj78iia5d(n, n2);
            n4 += oc5e2e2031b52.z$ag4eb8ubl7je();
        }
    }

    @Override
    int z$ag4eb8ubl7je() {
        int n = 0xF838CE0E ^ 0xF838CE01;
        if (this.\u01b8.\u01ab()) {
            for (oc5e2e2031b5 oc5e2e2031b52 : this.\u021c) {
                if (!oc5e2e2031b52.\u00ce()) continue;
                n += oc5e2e2031b52.z$ag4eb8ubl7je();
            }
        }
        return n;
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (oc255ab955c3.\u050e(this.\u0152 - 3.0f, this.\u0417, this.\u016d, 15.0f, n, n2) && (n3 == 0 || n3 == 1)) {
            this.\u01b8.\u04f6(!this.\u01b8.\u01ab());
            return true;
        }
        if (!this.\u01b8.\u01ab()) {
            return false;
        }
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u021c) {
            if (!oc5e2e2031b52.\u00ce() || !oc5e2e2031b52.z$1u23iokff6gve(n, n2, n3)) continue;
            for (oc5e2e2031b5 oc5e2e2031b53 : this.\u021c) {
                if (oc5e2e2031b53 == oc5e2e2031b52) continue;
                oc5e2e2031b53.z$1l3ht5d17kefg();
            }
            return true;
        }
        return false;
    }

    @Override
    void z$rq44izq02hqg(int n, int n2, int n3) {
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u021c) {
            oc5e2e2031b52.z$rq44izq02hqg(n, n2, n3);
        }
    }

    @Override
    boolean z$3twgyf5k61sst(char c, int n) {
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u021c) {
            if (!oc5e2e2031b52.z$3twgyf5k61sst(c, n)) continue;
            return true;
        }
        return false;
    }

    @Override
    boolean z$3kj7psbv4c9hb(int n, int n2, int n3) {
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u021c) {
            if (!oc5e2e2031b52.\u00ce() || !oc5e2e2031b52.z$3kj7psbv4c9hb(n, n2, n3)) continue;
            return true;
        }
        return false;
    }

    @Override
    void z$1l3ht5d17kefg() {
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u021c) {
            oc5e2e2031b52.z$1l3ht5d17kefg();
        }
    }

    @Override
    void z$3hwl7t34zws09() {
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u021c) {
            oc5e2e2031b52.z$3hwl7t34zws09();
        }
    }
}

