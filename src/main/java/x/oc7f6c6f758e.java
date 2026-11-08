/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import java.util.Objects;
import x.oc0bdff8f2e4;
import x.oc30dfe4c1c1;
import x.oc5f397ea265;
import x.oc6792429662;
import x.oc76a3ab00a6;
import x.ocae3bb6ecc0;

public class oc7f6c6f758e {
    public final oc5f397ea265 \u0137;
    public int \u0272;
    public int \u00cf;
    public int \u0110;
    public float v;
    public float \u0525;
    public float[] \u03ac;
    public float[] \u0481;
    public int[] \u0555;
    public final List<ocae3bb6ecc0> \u04d8;
    public oc0bdff8f2e4 \u0212;
    public oc76a3ab00a6 \u04a0;
    public oc6792429662 \u0151;
    public oc30dfe4c1c1 \u0469;

    public oc7f6c6f758e(oc5f397ea265 oc5f397ea2652, int n, int n2, List<ocae3bb6ecc0> list, oc30dfe4c1c1 oc30dfe4c1c12) {
        this.\u0137 = Objects.requireNonNull(oc5f397ea2652);
        this.\u0272 = n;
        this.\u00cf = n2;
        this.\u04d8 = Objects.requireNonNull(list);
        this.\u0469 = Objects.requireNonNull(oc30dfe4c1c12);
    }

    public boolean \u04dc() {
        return this.\u0137.\u0431 < this.\u0137.\u0552 && this.\u0137.\u021f < this.\u0137.\u017c;
    }

    public void k() {
        this.\u0137.\u0431 = this.\u0272;
        this.\u0137.\u021f = this.\u00cf;
        this.\u0137.\u017c = 0;
        this.\u0137.\u0552 = 0;
    }
}

