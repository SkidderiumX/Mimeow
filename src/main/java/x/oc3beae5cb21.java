/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x.oc0af730cc9f;
import x.oc1e2c36223e;
import x.oc81019d75fb;
import x.oc9be9d1e2c8;
import x.occ36fe312d9;
import x.ocebe35f25d6;

public class oc3beae5cb21
extends oc81019d75fb {
    private final oc0af730cc9f t;
    private List<occ36fe312d9> o = Collections.emptyList();

    public oc3beae5cb21(oc0af730cc9f oc0af730cc9f2, ocebe35f25d6 ocebe35f25d62, float f) {
        super(ocebe35f25d62, f, "Search potion effects...");
        this.t = oc0af730cc9f2;
    }

    @Override
    protected String z$37vljf1p4xmma() {
        int n = this.t.\u0271().size();
        return this.t.z$18nrktuqeiysv() + (String)(n > 0 ? " (" + n + ")" : "");
    }

    @Override
    protected int z$1sz52c3oju7wv() {
        return this.t.\u0271().size();
    }

    @Override
    protected int z$3e4g54z35cw92() {
        return this.o.size();
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.t.\u04c0;
    }

    @Override
    public String z$181tlwmlg110c() {
        return this.t.\u0150 != null ? this.t.\u0150.z$18nrktuqeiysv() : "";
    }

    @Override
    protected void z$2ys9gltfj0lh(oc1e2c36223e oc1e2c36223e2, float f, int n, int n2, int n3) {
        for (int i = n; i < n2; ++i) {
            occ36fe312d9 occ36fe312d92 = this.o.get(i);
            float f2 = oc1e2c36223e2.N - f + (float)i * 12.0f;
            int n4 = i == n3 ? 0xD8BD7912 ^ 0x2797532E : (i % (0x2797532C ^ 0x2797532E) == 0 ? 0xD88D4904 ^ 0x2797532E : 0xD8894D00 ^ 0x2797532E);
            this.\u03e4(occ36fe312d92.\u01b6, oc9be9d1e2c8.\u03ce(occ36fe312d92.\u03e2), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n4, false);
        }
    }

    @Override
    protected void z$14avr6kdt7khn(oc1e2c36223e oc1e2c36223e2, float f, int n, int n2) {
        List<String> list = this.t.\u0271();
        for (int i = n; i < n2; ++i) {
            String string = list.get(i);
            float f2 = this.\u0432(oc1e2c36223e2) - f + (float)i * 12.0f;
            int n3 = i % (0x99BB09C ^ 0x99BB09E) == 0 ? 0xF681AAB4 ^ 0x99BB09E : 0xF685AEB0 ^ 0x99BB09E;
            this.\u03e4(oc9be9d1e2c8.\u047f(string), oc9be9d1e2c8.\u03ce(string), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n3, true);
        }
    }

    @Override
    protected boolean z$1ypnztpggng98(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        if (!this.\u045e()) {
            return false;
        }
        int n3 = this.z$3e4g54z35cw92();
        if (n3 == 0) {
            return false;
        }
        float f = this.\u04c8.\u021b();
        int n4 = (int)(((float)n2 - oc1e2c36223e2.N + f) / 12.0f);
        if (n4 < 0 || n4 >= n3 || (float)n <= oc1e2c36223e2.\u043a || (float)n >= oc1e2c36223e2.\u0146) {
            return false;
        }
        float f2 = oc1e2c36223e2.N - f + (float)n4 * 12.0f;
        if ((float)n2 < f2 || (float)n2 >= f2 + 12.0f) {
            return false;
        }
        this.t.x(this.o.get((int)n4).\u03e2);
        this.\u0185();
        return true;
    }

    @Override
    protected boolean z$2ry952kdqqsva(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        float f = this.\u017c.\u021b();
        ArrayList<String> arrayList = new ArrayList<String>(this.t.\u0271());
        for (int i = 0; i < arrayList.size(); ++i) {
            float f2 = this.\u0432(oc1e2c36223e2) - f + (float)i * 12.0f;
            if (!this.\u0227(n, n2, f2, oc1e2c36223e2.\u0146)) continue;
            this.t.\u0116((String)arrayList.get(i));
            this.\u0278();
            return true;
        }
        return false;
    }

    @Override
    protected void z$6z92wsjyn19b(String string) {
        this.o = oc9be9d1e2c8.\u01d2(string, this.t);
    }

    @Override
    protected boolean z$2tyl9wl3yz5qt() {
        return false;
    }

    @Override
    protected void z$vrc7cco7wwqp() {
        this.o = oc9be9d1e2c8.\u01d2(this.\u0426().Q(), this.t);
    }

    @Override
    protected void z$3jmhyccrxm495() {
        this.o = Collections.emptyList();
    }

    private void \u0185() {
        this.\u0426().\u03f1("");
        this.\u039a(false);
        this.o = Collections.emptyList();
        this.\u04c8.\u0234(0.0f);
        this.\u0278();
    }
}

