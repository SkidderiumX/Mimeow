/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import x.occ2b330902d;

public class oc613fa20ccd {
    private final Packet<?> \u00e2;
    private final occ2b330902d \u0495;
    private final long \u010b;
    public static int \u0564;

    public oc613fa20ccd(Packet<?> packet) {
        this.\u00e2 = packet;
        this.\u0495 = new occ2b330902d();
        this.\u010b = System.currentTimeMillis();
    }

    public oc613fa20ccd(Packet<?> packet, long l) {
        this.\u00e2 = packet;
        this.\u010b = l;
        this.\u0495 = new occ2b330902d();
    }

    public Packet<?> \u053b() {
        return this.\u00e2;
    }

    public occ2b330902d \u050e() {
        return this.\u0202();
    }

    public occ2b330902d \u0202() {
        return this.\u0495;
    }

    public long \u00e0() {
        return this.\u010b;
    }

    public long \u0440() {
        return this.\u010b;
    }
}

