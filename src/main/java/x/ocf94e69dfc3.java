/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemStack;
import x.oc117ab26e54;
import x.oc1e2c36223e;
import x.oc2ec6a95e5c;
import x.oc2ef79a3df1;
import x.oc920065c394;
import x.ocdd11f3c425;
import x.ocebe35f25d6;

public class ocf94e69dfc3
extends oc117ab26e54<oc2ec6a95e5c> {
    private List<ocdd11f3c425> \u03c2;

    public ocf94e69dfc3(oc2ec6a95e5c oc2ec6a95e5c2, ocebe35f25d6 ocebe35f25d62, float f) {
        super(oc2ec6a95e5c2, ocebe35f25d62, f);
    }

    @Override
    protected int z$1sz52c3oju7wv() {
        return ((oc2ec6a95e5c)this.\u00b5).\u01df().size();
    }

    @Override
    protected void z$14avr6kdt7khn(oc1e2c36223e oc1e2c36223e2, float f, int n, int n2) {
        List<String> list = ((oc2ec6a95e5c)this.\u00b5).\u01df();
        if (this.\u03c2 == null || this.\u03c2.size() != list.size()) {
            this.\u03c2 = new ArrayList<ocdd11f3c425>();
            for (String object : list) {
                List<oc2ef79a3df1> list2 = oc920065c394.\u04f6(object) ? oc920065c394.\u046b(object) : null;
                ArrayList<ItemStack> n3 = null;
                if (list2 != null && !list2.isEmpty()) {
                    n3 = new ArrayList<ItemStack>();
                    for (oc2ef79a3df1 oc2ef79a3df12 : list2) {
                        n3.add(oc2ef79a3df12.\u020b());
                    }
                }
                this.\u03c2.add(new ocdd11f3c425(object, oc920065c394.\u049f(object), oc920065c394.t(object), n3));
            }
        }
        for (int i = n; i < n2; ++i) {
            ocdd11f3c425 ocdd11f3c4252 = this.\u03c2.get(i);
            float f2 = this.\u0432(oc1e2c36223e2) - f + (float)i * 12.0f;
            int n3 = i % (0x692D1A51 ^ 0x692D1A53) == 0 ? 0x96370079 ^ 0x692D1A53 : 0x9633047D ^ 0x692D1A53;
            this.\u03e4(ocdd11f3c4252.\u057c, this.\u01d8(ocdd11f3c4252), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n3, true);
        }
    }

    @Override
    protected boolean z$2ry952kdqqsva(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        float f = this.\u017c.\u021b();
        ArrayList<String> arrayList = new ArrayList<String>(((oc2ec6a95e5c)this.\u00b5).\u01df());
        for (int i = 0; i < arrayList.size(); ++i) {
            float f2 = this.\u0432(oc1e2c36223e2) - f + (float)i * 12.0f;
            if (!this.\u0227(n, n2, f2, oc1e2c36223e2.\u0146)) continue;
            this.\u0438((String)arrayList.get(i));
            return true;
        }
        return false;
    }

    @Override
    protected void z$1zejnqfgzojx7() {
        this.\u03c2 = null;
    }
}

