/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.LinkedHashMap;
import java.util.Map;
import x.oc51f4f13c5a;
import x.oc6bed6d7740;

public class oc173ab988a9 {
    private final String \u0538;
    private final String \u03d1;
    private String \u013f = "";
    private final Map<String, String> \u0514 = new LinkedHashMap<String, String>();
    private int \u00fd = 0x4FC29AA9 ^ 0x4FC28921;
    private int \u02ae = 0x4FC29AA9 ^ 0x4FC28921;
    public static boolean \u042c;

    private oc173ab988a9(String string, String string2) {
        this.\u0538 = string;
        this.\u03d1 = string2;
    }

    public oc173ab988a9 \u01ce(String string, String string2) {
        this.\u0514.put(string, string2);
        return this;
    }

    public oc173ab988a9 \u024f(String string) {
        String string2;
        block2: {
            block3: {
                int n = oc51f4f13c5a.\u0405;
                oc173ab988a9 oc173ab988a92 = this;
                string2 = string;
                if (n != 0) break block2;
                if (string2 != null) break block3;
                string2 = "";
                break block2;
            }
            string2 = string;
        }
        oc173ab988a92.\u013f = string2;
        return this;
    }

    public oc173ab988a9 \u019a(int n, int n2) {
        this.\u00fd = n;
        this.\u02ae = n2;
        return this;
    }

    public oc6bed6d7740 \u0290() {
        return new oc6bed6d7740(this);
    }
}

