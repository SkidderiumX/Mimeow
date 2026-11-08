/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.ocdd0f49ff2f;

public class oc151419fdfe {
    private final ocdd0f49ff2f \u0284;
    private final int \u01a0;
    private String \u0113;
    public static boolean v;

    public oc151419fdfe(String string, int n) {
        this.\u0113 = string;
        this.\u01a0 = n;
        this.\u0284 = new ocdd0f49ff2f(this, string, n);
        this.\u0284.\u04fa = true;
    }

    public ocdd0f49ff2f \u01da() {
        return this.\u0284;
    }

    public int \u0256() {
        return this.\u01a0;
    }

    public String \u0120() {
        return this.\u0113;
    }

    public void \u015d(String string) {
        this.\u0113 = string;
        this.\u0284.\u0122(string);
    }
}

