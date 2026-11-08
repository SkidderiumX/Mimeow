/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
import x.oc053077e19a;
import x.oc19a24d59db;
import x.ocbf5a535fb8;

public class ocfaf379fc4a
extends oc053077e19a {
    public int \u0518;
    public oc19a24d59db \u0406;
    public int \u019c;
    public static boolean \u054e;

    public ocfaf379fc4a(S25PacketBlockBreakAnim s25PacketBlockBreakAnim) {
        super(s25PacketBlockBreakAnim);
    }

    public ocfaf379fc4a(int n, oc19a24d59db oc19a24d59db2, int n2) {
        super(null);
        this.\u0518 = n;
        this.\u0406 = oc19a24d59db2;
        this.\u019c = n2;
    }

    public ocfaf379fc4a(int n, ocbf5a535fb8 ocbf5a535fb82, int n2) {
        this(n, ocbf5a535fb82 == null ? null : new oc19a24d59db(ocbf5a535fb82), n2);
    }
}

