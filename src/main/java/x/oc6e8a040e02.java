/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.ocd1cb14b5c3;

public class oc6e8a040e02 {
    public final boolean \u02e0;
    public boolean \u020e;
    public float \u0373;
    public float \u016e;
    public float \u0543;
    public float \u00e8;
    public int \u0533;
    public int \u01ce;
    public int k;
    public int \u0389;
    public int \u010f;
    public final List<ocd1cb14b5c3> \u027c = new ArrayList<ocd1cb14b5c3>();

    public oc6e8a040e02(boolean bl) {
        this.\u02e0 = bl;
    }

    private void \u037b(int n, int n2) {
        if (n > this.\u01ce || !this.\u020e) {
            this.\u01ce = n;
        }
        if (n2 > this.\u0389 || !this.\u020e) {
            this.\u0389 = n2;
        }
        if (n < this.\u0533 || !this.\u020e) {
            this.\u0533 = n;
        }
        if (n2 < this.k || !this.\u020e) {
            this.k = n2;
        }
        this.\u020e = true;
    }

    private void \u0220(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.\u02e0) {
            this.\u037b(n2, n3);
            if (n == (0x124DE02E ^ 0x124DE02A)) {
                this.\u037b(n4, n5);
                this.\u037b(n6, n7);
            }
        } else {
            this.\u027c.add(new ocd1cb14b5c3(n, n2, n3, n4, n5, n6, n7));
        }
        ++this.\u010f;
    }
}

