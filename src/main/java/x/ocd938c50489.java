/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Comparator;
import x.oc6d9efd226f;

public class ocd938c50489
implements Comparator<oc6d9efd226f> {
    ocd938c50489() {
    }

    public int \u046c(oc6d9efd226f oc6d9efd226f2, oc6d9efd226f oc6d9efd226f3) {
        int n = Long.compare(oc6d9efd226f3.j(), oc6d9efd226f2.j());
        return n != 0 ? n : oc6d9efd226f3.\u03b1().compareTo(oc6d9efd226f2.\u03b1());
    }
}

