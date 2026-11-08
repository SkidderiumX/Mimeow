/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collections;
import java.util.List;
import x.oc0ac184e19b;
import x.ocbb1bc27172;

public class oc142532d567 {
    public static final oc142532d567 a = new oc142532d567("", Collections.emptyList(), false, false);
    private final String \u017f;
    private final List<oc0ac184e19b> \u0223;
    private final boolean \u050c;
    private final boolean \u016c;
    public static int \u017b;

    oc142532d567(String string, List<oc0ac184e19b> list, boolean bl, boolean bl2) {
        this.\u017f = string;
        this.\u0223 = Collections.unmodifiableList(list);
        this.\u050c = bl;
        this.\u016c = bl2;
    }

    public String M() {
        return this.\u017f;
    }

    public List<oc0ac184e19b> \u00ce() {
        return this.\u0223;
    }

    public boolean \u0198() {
        return this.\u050c;
    }

    public boolean \u010f() {
        return this.\u016c;
    }

    public int \u01ff(long l) {
        int n;
        block6: {
            int n2 = -1;
            int n3 = ocbb1bc27172.\u050d;
            for (int i = 0; i < this.\u0223.size(); ++i) {
                int n4;
                block7: {
                    long l2 = this.\u0223.get((int)i).\u01fc - l;
                    n = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                    if (n3 != 0) break block6;
                    if (n3 != 0) break block7;
                    if (n > 0) {
                        break;
                    }
                    n4 = i;
                }
                n2 = n4;
                if (n3 == 0) continue;
            }
            n = n2;
        }
        return n;
    }
}

