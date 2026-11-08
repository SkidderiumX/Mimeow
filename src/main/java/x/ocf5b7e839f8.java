/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc75d51ec7eb;

public class ocf5b7e839f8 {
    private static Object \u0196;
    public static boolean \u01da;

    private ocf5b7e839f8() {
    }

    public static synchronized boolean \u04e1(Object object) {
        Object object2;
        block10: {
            block11: {
                int n;
                block8: {
                    block9: {
                        n = oc75d51ec7eb.\u03e9;
                        object2 = \u0196;
                        if (n != 0) break block8;
                        if (object2 != object) break block9;
                        return true;
                    }
                    object2 = \u0196;
                }
                if (n != 0) break block10;
                if (object2 == null) break block11;
                return false;
            }
            object2 = object;
        }
        \u0196 = object2;
        return true;
    }

    public static synchronized void \u0130(Object object) {
        if (\u0196 == object) {
            \u0196 = null;
        }
    }

    public static synchronized Object \u0231() {
        return \u0196;
    }

    public static synchronized boolean \u0245() {
        boolean bl = \u0196 != null;
        return bl;
    }

    public static synchronized void \u0522() {
        \u0196 = null;
    }
}

