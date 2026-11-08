/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;

public class oc053077e19a {
    final Packet<?> \u046d;
    public Packet<?> \u04e7;
    public final String \u01ce;
    public static int \u0144;

    public oc053077e19a(Packet<?> packet) {
        this.\u046d = packet;
        this.\u04e7 = packet;
        this.\u01ce = packet == null ? "" : packet.getClass().getSimpleName();
    }

    public String \u0470() {
        return this.\u01ce;
    }

    public Packet<?> \u0446() {
        return this.\u046d;
    }

    public Packet<?> z$1m95n1m9pvxum() {
        return this.\u046d;
    }
}

