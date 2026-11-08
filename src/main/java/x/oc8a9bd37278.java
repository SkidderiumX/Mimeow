/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc9e5a7eeec6;

public class oc8a9bd37278<T> {
    final T \u0231;
    final long \u02e1;

    oc8a9bd37278(T t, long l) {
        this.\u0231 = t;
        this.\u02e1 = l;
    }

    boolean \u00c1() {
        long l;
        block2: {
            block3: {
                boolean bl = oc9e5a7eeec6.\u039d;
                long l2 = System.currentTimeMillis() - this.\u02e1;
                l = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                if (bl) break block2;
                if (l >= 0) break block3;
                l = 1;
                break block2;
            }
            l = 0;
        }
        return (boolean)l;
    }
}

