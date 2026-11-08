/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;

public class oc1dc74d739e {
    private final Packet<?> \u00cb;
    private final NetHandlerPlayClient \u02a0;
    private final WorldClient \u04f6;

    private oc1dc74d739e(Packet<?> packet, NetHandlerPlayClient netHandlerPlayClient, WorldClient worldClient) {
        this.\u00cb = packet;
        this.\u02a0 = netHandlerPlayClient;
        this.\u04f6 = worldClient;
    }
}

