/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Comparator;
import java.util.Map;
import x.oc89eb238246;

public class oc48bae949ec
implements Comparator<Map.Entry<String, String>> {
    oc48bae949ec() {
    }

    public int \u00fe(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
        int n;
        block2: {
            block3: {
                int n2 = Integer.compare(entry2.getKey().length(), entry.getKey().length());
                int n3 = oc89eb238246.\u0127;
                n = n2;
                if (n3 != 0) break block2;
                if (n == 0) break block3;
                n = n2;
                break block2;
            }
            n = entry.getKey().compareToIgnoreCase(entry2.getKey());
        }
        return n;
    }
}

