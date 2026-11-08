/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Comparator;
import x.oc04596227b7;
import x.oc68d6b191af;
import x.oc6e7b992074;

public class ocae0001283f
implements Comparator<oc6e7b992074> {
    final oc04596227b7 this$0;

    ocae0001283f(oc04596227b7 oc04596227b72) {
        this.this$0 = oc04596227b72;
    }

    public int \u0164(oc6e7b992074 oc6e7b9920742, oc6e7b992074 oc6e7b9920743) {
        int n;
        block8: {
            boolean bl;
            block10: {
                block9: {
                    boolean bl2;
                    block6: {
                        block7: {
                            int n2 = Integer.compare(oc6e7b9920742.\u00f6.ordinal(), oc6e7b9920743.\u00f6.ordinal());
                            bl2 = oc68d6b191af.\u0215;
                            n = n2;
                            if (bl2) break block6;
                            if (n == 0) break block7;
                            n = n2;
                            break block6;
                        }
                        n = Long.compare(oc6e7b9920742.\u04e4, oc6e7b9920743.\u04e4);
                    }
                    if (!false) break block8;
                    if (!bl2) break block9;
                    bl = false;
                    break block10;
                }
                bl = true;
            }
            oc68d6b191af.\u0215 = bl;
        }
        return n;
    }
}

