/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import x.oc847503a8ab;

public class oc981d71de6a {
    final oc847503a8ab \u00ee;
    final long \u056d;
    final C08PacketPlayerBlockPlacement \u0242;

    private oc981d71de6a(oc847503a8ab oc847503a8ab2, long l, C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement) {
        this.\u00ee = oc847503a8ab2;
        this.\u056d = l;
        this.\u0242 = c08PacketPlayerBlockPlacement;
    }

    static oc981d71de6a k(oc847503a8ab oc847503a8ab2, long l) {
        return new oc981d71de6a(oc847503a8ab2, l, null);
    }

    oc981d71de6a \u012f(C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement) {
        return new oc981d71de6a(this.\u00ee, this.\u056d, c08PacketPlayerBlockPlacement);
    }
}

