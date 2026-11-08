/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import x.F;
import x.O;
import x.oc0af730cc9f;
import x.oc10354c7bb8;
import x.oc2cf3d80e17;
import x.oc2ec6a95e5c;
import x.oc63848f8f74;
import x.oc6dfc3938c0;
import x.oc920065c394;
import x.oc9be9d1e2c8;

public class oc5ef5aeeaf9
implements O {
    final oc10354c7bb8 val$list;
    final List val$catalog;
    final oc6dfc3938c0 this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc5ef5aeeaf9(oc6dfc3938c0 oc6dfc3938c02, oc10354c7bb8 oc10354c7bb82, List list) {
        this.this$0 = oc6dfc3938c02;
        this.val$list = oc10354c7bb82;
        this.val$catalog = list;
    }

    @Override
    public long z$2x3ntqt526oi6() {
        return this.val$list.\u0478().size();
    }

    @Override
    public String z$35m04xqyo0snr(long l) {
        String string = this.val$list.\u0478().get((int)l);
        return this.val$list instanceof oc0af730cc9f ? oc9be9d1e2c8.\u047f(string) : (this.val$list instanceof oc2ec6a95e5c ? oc920065c394.\u049f(string) : F.\u0370(string));
    }

    @Override
    public float[] z$1vqgh10n4y8c4(long l) {
        float[] fArray = new float[0x4AF5D873 ^ 0x4AF5D870];
        fArray[0] = 1.0f;
        fArray[1] = 1.0f;
        fArray[0x4AF5D872 ^ 0x4AF5D870] = 1.0f;
        return fArray;
    }

    @Override
    public void z$3khx2gyg54sew(long l, float[] fArray) {
    }

    @Override
    public void z$3d5hxar1iu0yg(String string, float[] fArray) {
        if (this.val$list instanceof oc2ec6a95e5c) {
            oc2ec6a95e5c oc2ec6a95e5c2 = (oc2ec6a95e5c)this.val$list;
            oc2ec6a95e5c2.z$1nw3rcgnkegzj(string);
        } else {
            this.val$list.\u051f(string);
        }
        oc2cf3d80e17.\u04eb();
    }

    @Override
    public void z$2k037up90b496(int n, String string, float[] fArray) {
        this.z$3d5hxar1iu0yg(((oc63848f8f74)this.val$catalog.get(n)).\u03d9(), fArray);
    }

    @Override
    public void z$2pwvkhw6ga4vj(long l) {
        List<String> list = this.val$list.\u0478();
        if (l >= 0L && l < (long)list.size()) {
            if (this.val$list instanceof oc2ec6a95e5c) {
                oc2ec6a95e5c oc2ec6a95e5c2 = (oc2ec6a95e5c)this.val$list;
                oc2ec6a95e5c2.z$2pk8fzn7jisvx(list.get((int)l));
            } else {
                this.val$list.\u0535(list.get((int)l));
            }
            oc2cf3d80e17.\u04eb();
        }
    }
}

