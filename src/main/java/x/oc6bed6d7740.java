/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import x.oc173ab988a9;

public class oc6bed6d7740 {
    private final String \u04dc;
    private final String \u0475;
    private final String \u0580;
    private final Map<String, String> \u03d7;
    private final int \u00fb;
    private final int \u00eb;
    public static int \u0501;

    private oc6bed6d7740(oc173ab988a9 oc173ab988a92) {
        this.\u04dc = oc173ab988a92.\u0538;
        this.\u0475 = oc173ab988a92.\u03d1;
        this.\u0580 = oc173ab988a92.\u013f;
        this.\u03d7 = Collections.unmodifiableMap(new LinkedHashMap<String, String>(oc173ab988a92.\u0514));
        this.\u00fb = oc173ab988a92.\u00fd;
        this.\u00eb = oc173ab988a92.\u02ae;
    }

    public String \u03c8() {
        return this.\u04dc;
    }

    public String \u04b6() {
        return this.\u0475;
    }

    public String \u018f() {
        return this.\u0580;
    }

    public Map<String, String> \u01ed() {
        return this.\u03d7;
    }

    public int \u0504() {
        return this.\u00fb;
    }

    public int \u0293() {
        return this.\u00eb;
    }

    public static oc173ab988a9 \u0289(String string, String string2) {
        return new oc173ab988a9(string, string2);
    }
}

