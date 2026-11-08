/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0CPacketInput;
import x.oc75d51ec7eb;

public class oc63e3533dee {
    private static final int k = 2048;
    private final Deque<Packet<?>> \u04c9 = new ArrayDeque();
    private final Consumer<Packet<?>> \u023a;
    public static int \u04c8;

    public oc63e3533dee(Consumer<Packet<?>> consumer) {
        this.\u023a = consumer;
    }

    public void \u01ec(Packet<?> packet) {
        this.\u04c9.addLast(packet);
    }

    public boolean \u0544() {
        int n;
        block4: {
            block5: {
                int n2 = oc75d51ec7eb.\u03e9;
                n = this.\u04c9.size();
                if (n2 != 0) break block4;
                if (n < (0xA547390A ^ 0xA547310A)) break block5;
                n = 1;
                break block4;
            }
            n = 0;
        }
        return n != 0;
    }

    public void \u01f8() {
        int n = oc75d51ec7eb.\u03e9;
        while (!this.\u04c9.isEmpty()) {
            this.\u023a.accept(this.\u04c9.removeFirst());
            if (n == 0) continue;
        }
    }

    public void \u00db() {
        this.\u04c9.removeIf(packet -> {
            Packet packet2;
            int n;
            int n2;
            block19: {
                block20: {
                    n2 = oc75d51ec7eb.\u03e9;
                    n = packet instanceof C03PacketPlayer;
                    if (n2 != 0) return n != 0;
                    if (n != 0) return 1 != 0;
                    n = packet instanceof C02PacketUseEntity;
                    if (n2 != 0) return n != 0;
                    if (n != 0) return 1 != 0;
                    n = packet instanceof C0APacketAnimation;
                    if (n2 != 0) return n != 0;
                    if (n != 0) return 1 != 0;
                    n = packet instanceof C0CPacketInput;
                    if (n2 != 0) return n != 0;
                    if (n != 0) return 1 != 0;
                    packet2 = packet;
                    if (n2 != 0) break block19;
                    if (!(packet2 instanceof C07PacketPlayerDigging)) break block20;
                    packet2 = (C07PacketPlayerDigging)packet;
                    if (n2 != 0) break block19;
                    Packet packet3 = packet2;
                    if (((C07PacketPlayerDigging)packet3).getStatus() != C07PacketPlayerDigging.Action.RELEASE_USE_ITEM) return 1 != 0;
                }
                packet2 = packet;
            }
            if (n2 == 0) {
                if (!(packet2 instanceof C08PacketPlayerBlockPlacement)) return 0 != 0;
                packet2 = packet;
            }
            C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement = (C08PacketPlayerBlockPlacement)packet2;
            n = c08PacketPlayerBlockPlacement.getPlacedBlockDirection();
            if (n2 != 0) return n != 0;
            if (n == (0xD9E8A80A ^ 0xD9E8A8F5)) return 0 != 0;
            return 1 != 0;
        });
    }

    public void \u01ee() {
        this.\u04c9.clear();
    }
}

