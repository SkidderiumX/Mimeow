/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.Session;
import x.oc804fdd8d75;

public class oc6bcef73ceb {
    private final Session \u01ee;
    private final String \u04b2;
    private final String \u03ec;
    private final String \u0232;
    public static boolean \u027e;

    private oc6bcef73ceb(Session session, String string, String string2, String string3) {
        this.\u01ee = session;
        this.\u04b2 = string;
        this.\u03ec = string2;
        this.\u0232 = string3;
    }

    public Session \u045a() {
        return this.\u01ee;
    }

    public oc804fdd8d75 \u00fb() {
        return new oc804fdd8d75("", this.\u01ee.getToken(), this.\u01ee.getUsername(), 0L, this.\u03ec, this.\u0232, "premium", this.\u01ee.getPlayerID(), System.currentTimeMillis(), 0L, this.\u04b2);
    }

    public void \u042b(oc804fdd8d75 oc804fdd8d752) {
        oc804fdd8d752.\u04d0("");
        oc804fdd8d752.\u04cc(this.\u01ee.getToken());
        oc804fdd8d752.\u024a(this.\u01ee.getUsername());
        oc804fdd8d752.\u0531(this.\u03ec);
        int n = oc804fdd8d75.\u0186;
        oc804fdd8d752.\u0274(this.\u0232);
        oc804fdd8d752.\u0200("premium");
        oc804fdd8d752.\u0473(this.\u01ee.getPlayerID());
        oc804fdd8d752.\u0226(System.currentTimeMillis());
        oc804fdd8d752.\u01e7(this.\u04b2);
        if (false) {
            oc804fdd8d75.\u0186 = ++n;
        }
    }
}

