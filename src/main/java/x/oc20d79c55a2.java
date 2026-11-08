/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc40c5bf6083;
import x.oc4cbf3a882f;
import x.oc54714bd439;

public class oc20d79c55a2 {
    private static final oc40c5bf6083 \u057f = new oc4cbf3a882f();
    public static int \u01cf;

    private oc20d79c55a2() {
    }

    public static void \u024a(Runnable runnable2) {
        oc20d79c55a2.\u0209(runnable2, \u057f);
    }

    static void \u0209(Runnable runnable2, oc40c5bf6083 oc40c5bf60832) {
        oc20d79c55a2.\u00d2(oc40c5bf60832);
        int n = oc54714bd439.\u0563;
        try {
            runnable2.run();
        }
        finally {
            oc20d79c55a2.\u00d2(oc40c5bf60832);
        }
        if (false) {
            oc54714bd439.\u0563 = ++n;
        }
    }

    private static void \u00d2(oc40c5bf6083 oc40c5bf60832) {
        oc40c5bf60832.z$qiq0lufagw0r();
        oc40c5bf60832.z$cux1eh0fxqj7();
    }
}

