/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.item.ItemStack;
import x.F;
import x.oc10354c7bb8;
import x.oc1e2c36223e;
import x.oc3af4427d65;
import x.oc43fdb4c5d3;
import x.oc81019d75fb;
import x.ocdd11f3c425;
import x.ocebe35f25d6;

public class J
extends oc81019d75fb {
    public final oc10354c7bb8 \u046c;
    private List<oc3af4427d65> \u04ca = Collections.emptyList();
    private String \u040d;
    private List<oc43fdb4c5d3> \u00c8 = Collections.emptyList();
    private List<ocdd11f3c425> \u03c2;

    public J(oc10354c7bb8 oc10354c7bb82, ocebe35f25d6 ocebe35f25d62, float f) {
        super(ocebe35f25d62, f, "Search blocks...");
        this.\u046c = oc10354c7bb82;
    }

    @Override
    protected String z$37vljf1p4xmma() {
        int n = this.\u046c.\u0478().size();
        return this.\u046c.z$18nrktuqeiysv() + (String)(n > 0 ? " (" + n + ")" : "");
    }

    @Override
    protected int z$1sz52c3oju7wv() {
        return this.\u046c.\u0478().size();
    }

    @Override
    protected int z$3e4g54z35cw92() {
        return this.\u040d != null ? (0x19D25A77 ^ 0x19D25A75) + this.\u00c8.size() : this.\u04ca.size();
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u046c.\u04c0;
    }

    @Override
    public String z$181tlwmlg110c() {
        return this.\u046c.\u0150 != null ? this.\u046c.\u0150.z$18nrktuqeiysv() : "";
    }

    @Override
    protected void z$2ys9gltfj0lh(oc1e2c36223e oc1e2c36223e2, float f, int n, int n2, int n3) {
        if (this.\u040d != null) {
            String string = !this.\u00c8.isEmpty() ? this.\u00c8.get((int)0).\u00ed : this.\u040d;
            for (int i = n; i < n2; ++i) {
                int n4;
                float f2 = oc1e2c36223e2.N - f + (float)i * 12.0f;
                int n5 = i == n3 ? 0x9E3D3733 ^ 0x61171D0F : (n4 = i % (0x61171D0D ^ 0x61171D0F) == 0 ? 0x9E0D0725 ^ 0x61171D0F : 0x9E090321 ^ 0x61171D0F);
                if (i == 0) {
                    this.\u0437(oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n4, string);
                    continue;
                }
                if (i == 1) {
                    this.\u03e4(string + " (All)", this.\u0576(), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n4, false);
                    continue;
                }
                oc43fdb4c5d3 oc43fdb4c5d32 = this.\u00c8.get(i - (0x61171D0D ^ 0x61171D0F));
                this.\u03e4(oc43fdb4c5d32.\u00ed, oc43fdb4c5d32.\u04c2(), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n4, false);
            }
            return;
        }
        for (int i = n; i < n2; ++i) {
            int n6;
            oc3af4427d65 oc3af4427d652 = this.\u04ca.get(i);
            float f3 = oc1e2c36223e2.N - f + (float)i * 12.0f;
            int n7 = i == n3 ? 0x9E3D3733 ^ 0x61171D0F : (n6 = i % (0x61171D0D ^ 0x61171D0F) == 0 ? 0x9E0D0725 ^ 0x61171D0F : 0x9E090321 ^ 0x61171D0F);
            if (oc3af4427d652.\u04ae()) {
                oc43fdb4c5d3 oc43fdb4c5d33 = oc3af4427d652.\u049e.get(0);
                this.\u03e4(oc43fdb4c5d33.\u00ed, oc43fdb4c5d33.\u04c2(), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f3, n6, false);
                continue;
            }
            this.\u03e4(oc3af4427d652.\u0520(), oc3af4427d652.\u0478(), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f3, n6, false);
        }
    }

    @Override
    protected void z$14avr6kdt7khn(oc1e2c36223e oc1e2c36223e2, float f, int n, int n2) {
        List<String> list = this.\u046c.\u0478();
        if (this.\u03c2 == null || this.\u03c2.size() != list.size()) {
            this.\u03c2 = new ArrayList<ocdd11f3c425>();
            for (String object : list) {
                List<oc43fdb4c5d3> f2 = null;
                if (F.\u01e6(object)) {
                    f2 = F.\u038e(F.\u0519(object));
                }
                ArrayList<ItemStack> n3 = null;
                if (f2 != null && !f2.isEmpty()) {
                    n3 = new ArrayList<ItemStack>();
                    for (oc43fdb4c5d3 oc43fdb4c5d32 : f2) {
                        n3.add(oc43fdb4c5d32.\u04c2());
                    }
                }
                this.\u03c2.add(new ocdd11f3c425(object, F.\u0370(object), F.\u022f(object), n3));
            }
        }
        for (int i = n; i < n2; ++i) {
            ocdd11f3c425 ocdd11f3c4252 = this.\u03c2.get(i);
            float f2 = this.\u0432(oc1e2c36223e2) - f + (float)i * 12.0f;
            int n3 = i % (0xB2AAEE56 ^ 0xB2AAEE54) == 0 ? 0x4DB0F47E ^ 0xB2AAEE54 : 0x4DB4F07A ^ 0xB2AAEE54;
            this.\u03e4(ocdd11f3c4252.\u057c, this.\u01d8(ocdd11f3c4252), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n3, true);
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
        if (this.\u040d != null) {
            if (n4 == 0) {
                this.\u03b0();
                return true;
            }
            if (n4 == 1) {
                this.\u046c.\u051f(this.\u040d + ":*");
                this.\u0522();
                return true;
            }
            int n5 = n4 - (0xF6628BB8 ^ 0xF6628BBA);
            if (n5 >= 0 && n5 < this.\u00c8.size()) {
                this.\u046c.\u051f(this.\u00c8.get((int)n5).\u020e);
                this.\u0522();
                return true;
            }
            return true;
        }
        oc3af4427d65 oc3af4427d652 = this.\u04ca.get(n4);
        if (oc3af4427d652.\u04ae()) {
            this.\u046c.\u051f(oc3af4427d652.\u049e.get((int)0).\u020e);
            this.\u0522();
            return true;
        }
        this.\u040d = oc3af4427d652.\u01a7;
        this.\u00c8 = new ArrayList<oc43fdb4c5d3>();
        for (oc43fdb4c5d3 oc43fdb4c5d32 : oc3af4427d652.\u049e) {
            if (this.\u046c.\u0462(oc43fdb4c5d32.\u020e)) continue;
            this.\u00c8.add(oc43fdb4c5d32);
        }
        this.\u04c8.\u0234(0.0f);
        this.\u00ca();
        this.\u0172.\u01e3();
        return true;
    }

    @Override
    protected boolean z$2ry952kdqqsva(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        float f = this.\u017c.\u021b();
        ArrayList<String> arrayList = new ArrayList<String>(this.\u046c.\u0478());
        for (int i = 0; i < arrayList.size(); ++i) {
            float f2 = this.\u0432(oc1e2c36223e2) - f + (float)i * 12.0f;
            if (!this.\u0227(n, n2, f2, oc1e2c36223e2.\u0146)) continue;
            this.\u046c.\u0535((String)arrayList.get(i));
            this.\u03c2 = null;
            this.\u0278();
            return true;
        }
        return false;
    }

    @Override
    protected void z$6z92wsjyn19b(String string) {
        this.\u040d = null;
        this.\u00c8 = Collections.emptyList();
        this.\u04ca = F.\u04af(string, this.\u046c);
    }

    @Override
    protected boolean z$2tyl9wl3yz5qt() {
        if (this.\u040d != null) {
            this.\u03b0();
            return true;
        }
        return false;
    }

    @Override
    protected void z$vrc7cco7wwqp() {
        if (!this.\u0426().Q().isEmpty() && this.\u04ca.isEmpty()) {
            this.\u04ca = F.\u04af(this.\u0426().Q(), this.\u046c);
        }
    }

    @Override
    protected void z$3jmhyccrxm495() {
        this.\u04ca = Collections.emptyList();
        this.\u040d = null;
        this.\u00c8 = Collections.emptyList();
        this.\u03c2 = null;
    }

    private void \u0522() {
        this.\u0426().\u03f1("");
        this.\u039a(false);
        this.\u04ca = Collections.emptyList();
        this.\u040d = null;
        this.\u00c8 = Collections.emptyList();
        this.\u04c8.\u0234(0.0f);
        this.\u03c2 = null;
        this.\u0278();
    }

    private void \u03b0() {
        this.\u040d = null;
        this.\u00c8 = Collections.emptyList();
        this.\u04c8.\u0234(0.0f);
        this.\u00ca();
        this.\u0172.\u01e3();
    }

    private ItemStack \u0576() {
        if (this.\u00c8.isEmpty()) {
            return null;
        }
        int n = (int)(System.currentTimeMillis() / (0x526C457FE0B29423L ^ 0x526C457FE0B297CBL) % (long)this.\u00c8.size());
        return this.\u00c8.get(n).\u04c2();
    }
}

