/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.item.ItemStack;
import x.N;
import x.oc019314a9ca;
import x.oc10354c7bb8;
import x.oc1e2c36223e;
import x.oc2ec6a95e5c;
import x.oc2ef79a3df1;
import x.oc81019d75fb;
import x.oc920065c394;
import x.ocebe35f25d6;

public abstract class oc117ab26e54<T extends oc2ec6a95e5c>
extends oc81019d75fb {
    protected final T \u00b5;
    private List<oc019314a9ca> \u01d1 = Collections.emptyList();
    private String \u0245;
    private String \u0451;
    private String \u0241;
    private List<oc2ef79a3df1> \u0535 = Collections.emptyList();

    protected oc117ab26e54(T t, ocebe35f25d6 ocebe35f25d62, float f) {
        super(ocebe35f25d62, f, "Search items...");
        this.\u00b5 = t;
    }

    @Override
    protected String z$37vljf1p4xmma() {
        int n = ((oc2ec6a95e5c)this.\u00b5).\u01df().size();
        return ((N)this.\u00b5).z$18nrktuqeiysv() + (String)(n > 0 ? " (" + n + ")" : "");
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return ((N)this.\u00b5).\u04c0;
    }

    @Override
    public String z$181tlwmlg110c() {
        return ((oc10354c7bb8)this.\u00b5).\u0150 != null ? ((oc10354c7bb8)this.\u00b5).\u0150.z$18nrktuqeiysv() : "";
    }

    @Override
    protected int z$3e4g54z35cw92() {
        return this.\u0245 != null ? (0x2DABF47F ^ 0x2DABF47D) + this.\u0535.size() : this.\u01d1.size();
    }

    @Override
    protected void z$2ys9gltfj0lh(oc1e2c36223e oc1e2c36223e2, float f, int n, int n2, int n3) {
        if (this.\u0245 != null) {
            String string = this.\u0451 != null ? this.\u0451 : this.\u0245;
            for (int i = n; i < n2; ++i) {
                int n4;
                float f2 = oc1e2c36223e2.N - f + (float)i * 12.0f;
                int n5 = i == n3 ? 0xBE3E57B3 ^ 0x41147D8F : (n4 = i % (0x41147D8D ^ 0x41147D8F) == 0 ? 0xBE0E67A5 ^ 0x41147D8F : 0xBE0A63A1 ^ 0x41147D8F);
                if (i == 0) {
                    this.\u0437(oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n4, string);
                    continue;
                }
                if (i == 1) {
                    this.\u03e4(string + " (All)", this.\u00ef(), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n4, false);
                    continue;
                }
                oc2ef79a3df1 oc2ef79a3df12 = this.\u0535.get(i - (0x41147D8D ^ 0x41147D8F));
                this.\u03e4(oc2ef79a3df12.\u0466, oc2ef79a3df12.\u020b(), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n4, false);
            }
            return;
        }
        for (int i = n; i < n2; ++i) {
            int n6;
            oc019314a9ca oc019314a9ca2 = this.\u01d1.get(i);
            float f3 = oc1e2c36223e2.N - f + (float)i * 12.0f;
            int n7 = i == n3 ? 0xBE3E57B3 ^ 0x41147D8F : (n6 = i % (0x41147D8D ^ 0x41147D8F) == 0 ? 0xBE0E67A5 ^ 0x41147D8F : 0xBE0A63A1 ^ 0x41147D8F);
            if (oc019314a9ca2.\u04cf()) {
                oc2ef79a3df1 oc2ef79a3df13 = oc019314a9ca2.\u0465.get(0);
                this.\u03e4(oc2ef79a3df13.\u0466, oc2ef79a3df13.\u020b(), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f3, n6, false);
                continue;
            }
            this.\u03e4(oc019314a9ca2.\u0493(), oc019314a9ca2.\u0189(), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f3, n6, false);
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
        float f = (float)n2 - oc1e2c36223e2.N;
        float f2 = this.\u04c8.\u021b();
        int n4 = (int)((f + f2) / 12.0f);
        if (n4 < 0 || n4 >= n3 || (float)n <= oc1e2c36223e2.\u043a || (float)n >= oc1e2c36223e2.\u0146) {
            return false;
        }
        float f3 = oc1e2c36223e2.N - f2 + (float)n4 * 12.0f;
        if ((float)n2 < f3 || (float)n2 >= f3 + 12.0f) {
            return false;
        }
        if (this.\u0245 != null) {
            if (n4 == 0) {
                this.\u0404();
                return true;
            }
            if (n4 == 1) {
                ((oc2ec6a95e5c)this.\u00b5).z$1nw3rcgnkegzj((String)(this.\u0241 != null ? this.\u0241 : this.\u0245 + ":*"));
                this.\u04da();
                return true;
            }
            int n5 = n4 - (0xBA5BF027 ^ 0xBA5BF025);
            if (n5 >= 0 && n5 < this.\u0535.size()) {
                ((oc2ec6a95e5c)this.\u00b5).z$1nw3rcgnkegzj(this.\u0535.get((int)n5).\u0468);
                this.\u04da();
                return true;
            }
            return true;
        }
        oc019314a9ca oc019314a9ca2 = this.\u01d1.get(n4);
        if (oc019314a9ca2.\u04cf()) {
            ((oc2ec6a95e5c)this.\u00b5).z$1nw3rcgnkegzj(oc019314a9ca2.\u0465.get((int)0).\u0468);
            this.\u04da();
            return true;
        }
        this.\u0245 = oc019314a9ca2.\u04e0;
        this.\u0451 = oc019314a9ca2.\u014b();
        this.\u0241 = oc019314a9ca2.\u0417();
        this.\u0535 = new ArrayList<oc2ef79a3df1>();
        for (oc2ef79a3df1 oc2ef79a3df12 : oc019314a9ca2.\u0465) {
            if (((oc2ec6a95e5c)this.\u00b5).\u00ef(oc2ef79a3df12.\u0468)) continue;
            this.\u0535.add(oc2ef79a3df12);
        }
        this.\u04c8.\u0234(0.0f);
        this.\u00ca();
        this.\u0172.\u01e3();
        return true;
    }

    @Override
    protected void z$6z92wsjyn19b(String string) {
        this.\u00ba();
        this.\u01d1 = oc920065c394.\u022e(string, this.\u00b5);
    }

    @Override
    protected boolean z$2tyl9wl3yz5qt() {
        if (this.\u0245 != null) {
            this.\u0404();
            return true;
        }
        return false;
    }

    @Override
    protected void z$vrc7cco7wwqp() {
        if (!this.\u0426().Q().isEmpty() && this.\u01d1.isEmpty()) {
            this.\u01d1 = oc920065c394.\u022e(this.\u0426().Q(), this.\u00b5);
        }
    }

    @Override
    protected void z$3jmhyccrxm495() {
        this.\u01d1 = Collections.emptyList();
        this.\u00ba();
        this.z$24873xrdw6tbn();
    }

    protected final void \u0438(String string) {
        ((oc2ec6a95e5c)this.\u00b5).z$2pk8fzn7jisvx(string);
        this.z$1zejnqfgzojx7();
        this.\u0278();
    }

    protected final void \u0285() {
        this.z$1zejnqfgzojx7();
    }

    protected final T \u00f4() {
        return this.\u00b5;
    }

    protected final oc019314a9ca \u018e(int n) {
        return this.\u01d1.get(n);
    }

    protected final List<oc2ef79a3df1> \u021a() {
        return this.\u0535;
    }

    private void \u0404() {
        this.\u00ba();
        this.\u04c8.\u0234(0.0f);
        this.\u00ca();
        this.\u0172.\u01e3();
    }

    private void \u00ba() {
        this.\u0245 = null;
        this.\u0451 = null;
        this.\u0241 = null;
        this.\u0535 = Collections.emptyList();
    }

    private void \u04da() {
        this.\u0426().\u03f1("");
        this.\u039a(false);
        this.\u01d1 = Collections.emptyList();
        this.\u00ba();
        this.\u04c8.\u0234(0.0f);
        this.z$1zejnqfgzojx7();
        this.\u0278();
    }

    private ItemStack \u00ef() {
        if (this.\u0535.isEmpty()) {
            return null;
        }
        int n = (int)(System.currentTimeMillis() / (0x854D1AA987C6560L ^ 0x854D1AA987C6688L) % (long)this.\u0535.size());
        return this.\u0535.get(n).\u020b();
    }

    protected void z$24873xrdw6tbn() {
    }

    protected abstract void z$1zejnqfgzojx7();
}

