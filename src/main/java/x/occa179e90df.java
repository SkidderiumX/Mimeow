/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;
import x.oc93821aed5f;

public class occa179e90df
extends oc93821aed5f {
    private final long \u011e;
    public static int \u041d;

    public occa179e90df(long l) {
        long l2 = Math.max(0L, l);
        this.\u011e = System.nanoTime() + l2 * (0x23399109CFC9F24DL ^ 0x23399109CFC6B00DL);
    }

    @Override
    protected boolean z$3j6encvc02s81() {
        long l;
        block8: {
            boolean bl;
            block10: {
                block9: {
                    int n;
                    block6: {
                        block7: {
                            n = oc93821aed5f.\u053f;
                            long l2 = System.nanoTime() - this.\u011e - 0L;
                            l = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                            if (n != 0) break block6;
                            if (l < 0) break block7;
                            l = 1;
                            break block6;
                        }
                        l = 0;
                    }
                    if (n == 0) break block8;
                    if (!false) break block9;
                    bl = false;
                    break block10;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return (boolean)l;
    }
}

