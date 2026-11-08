/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Comparator;
import x.oc89eb238246;

public class oc36e8d7342a
implements Comparator<String> {
    oc36e8d7342a() {
    }

    public int \u0524(String string, String string2) {
        int n;
        block2: {
            block3: {
                int n2 = Integer.compare(string2.length(), string.length());
                int n3 = oc89eb238246.\u0127;
                n = n2;
                if (n3 != 0) break block2;
                if (n == 0) break block3;
                n = n2;
                break block2;
            }
            n = string.compareToIgnoreCase(string2);
        }
        return n;
    }
}

