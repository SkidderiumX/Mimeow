/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import x.O;
import x.oc2cf3d80e17;
import x.oc6af36febc3;
import x.oc6dfc3938c0;

public class oca481da7ec8
implements O {
    final oc6af36febc3 val$list;
    final oc6dfc3938c0 this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oca481da7ec8(oc6dfc3938c0 oc6dfc3938c02, oc6af36febc3 oc6af36febc32) {
        this.this$0 = oc6dfc3938c02;
        this.val$list = oc6af36febc32;
    }

    @Override
    public long z$2x3ntqt526oi6() {
        return this.val$list.\u010e().size();
    }

    @Override
    public String z$35m04xqyo0snr(long l) {
        return this.val$list.\u010e().get((int)l);
    }

    @Override
    public float[] z$1vqgh10n4y8c4(long l) {
        float[] fArray = new float[0x85081C9F ^ 0x85081C9C];
        fArray[0] = 1.0f;
        fArray[1] = 1.0f;
        fArray[0x85081C9E ^ 0x85081C9C] = 1.0f;
        return fArray;
    }

    @Override
    public void z$3khx2gyg54sew(long l, float[] fArray) {
    }

    @Override
    public void z$3d5hxar1iu0yg(String string, float[] fArray) {
        this.val$list.\u0536(string);
        oc2cf3d80e17.\u04eb();
    }

    @Override
    public void z$2pwvkhw6ga4vj(long l) {
        List<String> list = this.val$list.\u010e();
        if (l >= 0L && l < (long)list.size()) {
            this.val$list.\u012d(list.get((int)l));
            oc2cf3d80e17.\u04eb();
        }
    }
}

