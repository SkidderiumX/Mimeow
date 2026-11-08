/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Comparator;
import x.oc6d9efd226f;

public class ocace50a692b
implements Comparator<oc6d9efd226f> {
    ocace50a692b() {
    }

    public int \u0207(oc6d9efd226f oc6d9efd226f2, oc6d9efd226f oc6d9efd226f3) {
        int n;
        block2: {
            block3: {
                int n2 = Long.compare(oc6d9efd226f3.j(), oc6d9efd226f2.j());
                int n3 = oc6d9efd226f.\u03a5;
                n = n2;
                if (n3 != 0) break block2;
                if (n == 0) break block3;
                n = n2;
                break block2;
            }
            n = oc6d9efd226f3.\u03b1().compareTo(oc6d9efd226f2.\u03b1());
        }
        return n;
    }
}

