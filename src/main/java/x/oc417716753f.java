/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import x.oc040dee6e11;
import x.oc293826be15;
import x.oc4b4b5da6c6;
import x.oc56e3ec4ee3;
import x.oc5f397ea265;
import x.oc9bcf1497a7;

public class oc417716753f
implements oc4b4b5da6c6 {
    private float[] \u0148;
    final oc56e3ec4ee3 val$iterator;
    final List val$batches;
    final oc293826be15 this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc417716753f(oc293826be15 oc293826be152, oc56e3ec4ee3 oc56e3ec4ee32, List list) {
        this.this$0 = oc293826be152;
        this.val$iterator = oc56e3ec4ee32;
        this.val$batches = list;
    }

    @Override
    public boolean z$1hzotucotrctd(int n) {
        this.\u0148 = new float[n * (0x5420DE02 ^ 0x5420DE06)];
        return this.\u0148.length >= n * (0x5420DE02 ^ 0x5420DE06);
    }

    @Override
    public boolean z$2m538xvys2mci() {
        boolean bl = oc040dee6e11.\u01e1(this.this$0.\u015f);
        if (bl) {
            this.val$iterator.\u023d = this.this$0.\u015f.\u0151.v;
            this.val$iterator.\u0279 = this.this$0.\u015f.\u0151.\u0525;
        }
        return bl;
    }

    @Override
    public void z$2yoi8bjxqdeix(List<float[]> list) {
        if (!list.isEmpty()) {
            this.z$281dh0fsip3jd();
            int n = 0;
            for (float[] fArray : list) {
                for (float f : fArray) {
                    this.\u0148[n++] = f;
                }
            }
            int n2 = this.this$0.\u015f.\u029b[this.this$0.\u015f.\u0495];
            this.val$batches.add(new oc9bcf1497a7(n2, this.this$0.\u015f.\u0151.\u0272, this.this$0.\u015f.\u0151.\u00cf, this.this$0.\u03f0.get(n2), this.this$0.\u0435.get(n2), list));
        }
    }

    @Override
    public void z$281dh0fsip3jd() {
        oc5f397ea265 oc5f397ea2652 = this.this$0.\u015f.\u0151.\u0137;
        if (this.this$0.\u015f.\u0151.\u04dc()) {
            this.this$0.\u015f.\u0490.z$20w06ler7vqca(this.this$0.\u015f.\u029b[this.this$0.\u015f.\u0495], oc5f397ea2652.\u0431, oc5f397ea2652.\u021f, oc5f397ea2652.\u0552 - oc5f397ea2652.\u0431, oc5f397ea2652.\u017c - oc5f397ea2652.\u021f, oc5f397ea2652.\u0289);
        }
        this.this$0.\u015f.\u0151.k();
    }
}

